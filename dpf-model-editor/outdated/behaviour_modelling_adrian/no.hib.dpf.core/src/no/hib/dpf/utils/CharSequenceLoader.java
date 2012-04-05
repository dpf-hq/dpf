package no.hib.dpf.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaFileObject;

/**
 * A custom ClassLoader which maps class names to JavaFileObjectImpl instances.
 */
final class CharSequenceLoader extends ClassLoader {
   private final Map<String, JavaFileObject> classes = new HashMap<String, JavaFileObject>();

   CharSequenceLoader(final ClassLoader parentClassLoader) {
      super(parentClassLoader);
   }

   /**
    * @return An collection of JavaFileObject instances for the classes in the
    *         class loader.
    */
   Collection<JavaFileObject> files() {
      return Collections.unmodifiableCollection(classes.values());
   }

   @Override
   protected Class<?> findClass(final String qualifiedClassName)
         throws ClassNotFoundException {
      JavaFileObject file = classes.get(qualifiedClassName);
      if (file != null) {
         byte[] bytes = ((CharSequenceJavaFileObject) file).getByteCode();
         return defineClass(qualifiedClassName, bytes, 0, bytes.length);
      }
      // Workaround for "feature" in Java 6
      // see http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6434149
      try {
         Class<?> c = Class.forName(qualifiedClassName);
         return c;
      } catch (ClassNotFoundException nf) {
         // Ignore and fall through
      }
      return super.findClass(qualifiedClassName);
   }

   /**
    * Add a class name/JavaFileObject mapping
    * 
    * @param qualifiedClassName
    *           the name
    * @param javaFile
    *           the file associated with the name
    */
   void add(final String qualifiedClassName, final JavaFileObject javaFile) {
      classes.put(qualifiedClassName, javaFile);
   }

   @Override
   public InputStream getResourceAsStream(final String name) {
      if (name.endsWith(".class")) {
         String qualifiedClassName = name.substring(0,
               name.length() - ".class".length()).replace('/', '.');
         CharSequenceJavaFileObject file = (CharSequenceJavaFileObject) classes.get(qualifiedClassName);
         if (file != null) {
            return new ByteArrayInputStream(file.getByteCode());
         }
      }
      return super.getResourceAsStream(name);
   }
}