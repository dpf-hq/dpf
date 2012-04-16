package no.hib.dpf.utils;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

/**
 * Compile a String or other {@link CharSequence}, returning a Java
 * {@link Class} instance that may be instantiated. This class is a Facade
 * around {@link JavaCompiler} for a narrower use case, but a bit easier to use.
 * <p>
 * To compile a String containing source for a Java class which implements
 * MyInterface:
 * 
 * <pre>
 * ClassLoader classLoader = MyClass.class.getClassLoader(); // optional; null is also OK 
 * List&lt;Diagnostic&gt; diagnostics = new ArrayList&lt;Diagnostic&gt;(); // optional; null is also OK
 * JavaStringCompiler&lt;Object&gt; compiler = new JavaStringCompiler&lt;MyInterface&gt;(classLoader,
 *       null);
 * try {
 *    Class&lt;MyInterface&gt; newClass = compiler.compile(&quot;com.mypackage.NewClass&quot;,
 *          stringContaininSourceForNewClass, diagnostics, MyInterface);
 *    MyInterface instance = newClass.newInstance();
 *    instance.someOperation(someArgs);
 * } catch (JavaStringCompilerException e) {
 *    handle(e);
 * } catch (IllegalAccessException e) {
 *    handle(e);
 * }
 * </pre>
 * 
 * The source can be in a String, {@link StringBuffer}, or your own class which
 * implements {@link CharSequence}. If you implement your own, it must be
 * thread safe (preferably, immutable.)
 * 
 * @author <a href="mailto:David.Biesack@sas.com">David J. Biesack</a>
 */
public class CharSequenceCompiler<T> {
   // Compiler requires source files with a ".java" extension:
   static final String JAVA_EXTENSION = ".java";

   private final CharSequenceLoader classLoader;

   // The compiler instance that this facade uses.
   private final JavaCompiler compiler;

   // The compiler options (such as "-target" "1.5").
   private final List<String> options;

   // collect compiler diagnostics in this instance.
   private DiagnosticCollector<JavaFileObject> diagnostics;

   // The FileManager which will store source and class "files".
   private final CharSequenceFileManager javaFileManager;

   /**
    * Construct a new instance which delegates to the named class loader.
    * 
    * @param loader
    *           the application ClassLoader. The compiler will look through to
    *           this // class loader for dependent classes
    * @param options
    *           The compiler options (such as "-target" "1.5"). See the usage
    *           for javac
    * @throws IllegalStateException
    *            if the Java compiler cannot be loaded.
    */
   public CharSequenceCompiler(ClassLoader loader, Iterable<String> options) {
      compiler = ToolProvider.getSystemJavaCompiler();
      if (compiler == null) {
         throw new IllegalStateException("Cannot find the system Java compiler. "
               + "Check that your class path includes tools.jar");
      }
      classLoader = new CharSequenceLoader(loader);
      diagnostics = new DiagnosticCollector<JavaFileObject>();
      final JavaFileManager fileManager = compiler.getStandardFileManager(diagnostics,
            Locale.getDefault(), null);
      // create our FileManager which chains to the default file manager
      // and our ClassLoader
      javaFileManager = new CharSequenceFileManager(fileManager, classLoader);
      this.options = new ArrayList<String>();
      if (options != null) { // make a save copy of input options
         for (String option : options) {
            this.options.add(option);
         }
      }
   }

   /**
    * Compile Java source in <var>javaSource</name> and return the resulting
    * class.
    * <p>
    * Thread safety: this method is thread safe if the <var>javaSource</var>
    * and <var>diagnosticsList</var> are isolated to this thread.
    * 
    * @param qualifiedClassName
    *           The fully qualified class name.
    * @param javaSource
    *           Complete java source, including a package statement and a class,
    *           interface, or annotation declaration.
    * @param diagnosticsList
    *           Any diagnostics generated by compiling the source are added to
    *           this collector.
    * @param types
    *           zero or more Class objects representing classes or interfaces
    *           that the resulting class must be assignable (castable) to.
    * @return a Class which is generated by compiling the source
    * @throws CharSequenceCompilerException
    *            if the source cannot be compiled - for example, if it contains
    *            syntax or semantic errors or if dependent classes cannot be
    *            found.
    * @throws ClassCastException
    *            if the generated class is not assignable to all the optional
    *            <var>types</var>.
    */
   public synchronized Class<T> compile(final String qualifiedClassName,
         final CharSequence javaSource,
         final DiagnosticCollector<JavaFileObject> diagnosticsList,
         final Class<?>... types) throws CharSequenceCompilerException,
         ClassCastException {
      if (diagnosticsList != null)
         diagnostics = diagnosticsList;
      else
         diagnostics = new DiagnosticCollector<JavaFileObject>();
      Map<String, CharSequence> classes = new HashMap<String, CharSequence>(1);
      classes.put(qualifiedClassName, javaSource);
      Map<String, Class<T>> compiled = compile(classes, diagnosticsList);
      Class<T> newClass = compiled.get(qualifiedClassName);
      return castable(newClass, types);
   }

   /**
    * Compile multiple Java source strings and return a Map containing the
    * resulting classes.
    * <p>
    * Thread safety: this method is thread safe if the <var>classes</var> and
    * <var>diagnosticsList</var> are isolated to this thread.
    * 
    * @param classes
    *           A Map whose keys are qualified class names and whose values are
    *           the Java source strings containing the definition of the class.
    *           A map value may be null, indicating that compiled class is
    *           expected, although no source exists for it (it may be a
    *           non-public class contained in one of the other strings.)
    * @param diagnosticsList
    *           Any diagnostics generated by compiling the source are added to
    *           this list.
    * @return A mapping of qualified class names to their corresponding classes.
    *         The map has the same keys as the input <var>classes</var>; the
    *         values are the corresponding Class objects.
    * @throws CharSequenceCompilerException
    *            if the source cannot be compiled
    */
   public synchronized Map<String, Class<T>> compile(
         final Map<String, CharSequence> classes,
         final DiagnosticCollector<JavaFileObject> diagnosticsList)
         throws CharSequenceCompilerException {
      List<JavaFileObject> sources = new ArrayList<JavaFileObject>();
      for (Entry<String, CharSequence> entry : classes.entrySet()) {
         String qualifiedClassName = entry.getKey();
         CharSequence javaSource = entry.getValue();
         if (javaSource != null) {
            final int dotPos = qualifiedClassName.lastIndexOf('.');
            final String className = dotPos == -1 ? qualifiedClassName
                  : qualifiedClassName.substring(dotPos + 1);
            final String packageName = dotPos == -1 ? "" : qualifiedClassName
                  .substring(0, dotPos);
            final CharSequenceJavaFileObject source = new CharSequenceJavaFileObject(className,
                  javaSource);
            sources.add(source);
            // Store the source file in the FileManager via package/class
            // name.
            // For source files, we add a .java extension
            javaFileManager.putFileForInput(StandardLocation.SOURCE_PATH, packageName,
                  className + JAVA_EXTENSION, source);
         }
      }
      // Get a CompliationTask from the compiler and compile the sources
      final CompilationTask task = compiler.getTask(null, javaFileManager, diagnostics,
            options, null, sources);
      final Boolean result = task.call();
      if (!result || !result.booleanValue()){//If compilation error occurs
    	  	    /*Iterate through each compilation problem and print it*/
    	    for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()){
    	        System.out.format("Error on line %d in %s\n", diagnostic.getLineNumber(), diagnostic);
    	    }
    	    throw new CharSequenceCompilerException("Compilation failed.", classes
    	    		.keySet(), diagnostics);
    	}
      try {
         // For each class name in the inpput map, get its compiled
         // class and put it in the output map
         Map<String, Class<T>> compiled = new HashMap<String, Class<T>>();
         for (String qualifiedClassName : classes.keySet()) {
            final Class<T> newClass = loadClass(qualifiedClassName);
            compiled.put(qualifiedClassName, newClass);
         }
         return compiled;
      } catch (ClassNotFoundException e) {
         throw new CharSequenceCompilerException(classes.keySet(), e, diagnostics);
      } catch (IllegalArgumentException e) {
         throw new CharSequenceCompilerException(classes.keySet(), e, diagnostics);
      } catch (SecurityException e) {
         throw new CharSequenceCompilerException(classes.keySet(), e, diagnostics);
      }
   }

   /**
    * Load a class that was generated by this instance or accessible from its
    * parent class loader. Use this method if you need access to additional
    * classes compiled by
    * {@link #compile(String, CharSequence, DiagnosticCollector, Class...) compile()},
    * for example if the primary class contained nested classes or additional
    * non-public classes.
    * 
    * @param qualifiedClassName
    *           the name of the compiled class you wish to load
    * @return a Class instance named by <var>qualifiedClassName</var>
    * @throws ClassNotFoundException
    *            if no such class is found.
    */
   @SuppressWarnings("unchecked")
   public Class<T> loadClass(final String qualifiedClassName)
         throws ClassNotFoundException {
      return (Class<T>) classLoader.loadClass(qualifiedClassName);
   }

   /**
    * Check that the <var>newClass</var> is a subtype of all the type
    * parameters and throw a ClassCastException if not.
    * 
    * @param types
    *           zero of more classes or interfaces that the <var>newClass</var>
    *           must be castable to.
    * @return <var>newClass</var> if it is castable to all the types
    * @throws ClassCastException
    *            if <var>newClass</var> is not castable to all the types.
    */
   private Class<T> castable(Class<T> newClass, Class<?>... types)
         throws ClassCastException {
      for (Class<?> type : types)
         if (!type.isAssignableFrom(newClass)) {
            throw new ClassCastException(type.getName());
         }
      return newClass;
   }

   /**
    * COnverts a String to a URI.
    * 
    * @param name
    *           a file name
    * @return a URI
    */
   static URI toURI(String name) {
      try {
         return new URI(name);
      } catch (URISyntaxException e) {
         throw new RuntimeException(e);
      }
   }
}
