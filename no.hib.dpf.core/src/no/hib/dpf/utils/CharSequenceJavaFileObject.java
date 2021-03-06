package no.hib.dpf.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

/**
 * A JavaFileObject which contains either the source text or the compiler
 * generated class. This class is used in two cases.
 * <ol>
 * <li>This instance uses it to store the source which is passed to the
 * compiler. This uses the
 * {@link CharSequenceJavaFileObject#JavaFileObjectImpl(String, CharSequence)}
 * constructor.
 * <li>The Java compiler also creates instances (indirectly through the
 * FileManagerImplFileManager) when it wants to create a JavaFileObject for the
 * .class output. This uses the
 * {@link CharSequenceJavaFileObject#JavaFileObjectImpl(String, JavaFileObject.Kind)}
 * constructor.
 * </ol>
 * This class does not attempt to reuse instances (there does not seem to be a
 * need, as it would require adding a Map for the purpose, and this would also
 * prevent garbage collection of class byte code.)
 */
final class CharSequenceJavaFileObject extends SimpleJavaFileObject {
   // If kind == CLASS, this stores byte code from openOutputStream
   private ByteArrayOutputStream byteCode;

   // if kind == SOURCE, this contains the source text
   private final CharSequence source;

   /**
    * Construct a new instance which stores source
    * 
    * @param baseName
    *           the base name
    * @param source
    *           the source code
    */
   CharSequenceJavaFileObject(final String baseName, final CharSequence source) {
      super(CharSequenceCompiler.toURI(baseName + CharSequenceCompiler.JAVA_EXTENSION), Kind.SOURCE);
      this.source = source;
   }

   /**
    * Construct a new instance
    * 
    * @param name
    *           the file name
    * @param kind
    *           the kind of file
    */
   CharSequenceJavaFileObject(final String name, final Kind kind) {
      super(CharSequenceCompiler.toURI(name), kind);
      source = null;
   }

   /**
    * Return the source code content
    * 
    * @see javax.tools.SimpleJavaFileObject#getCharContent(boolean)
    */
   @Override
   public CharSequence getCharContent(final boolean ignoreEncodingErrors)
         throws UnsupportedOperationException {
      if (source == null)
         throw new UnsupportedOperationException("getCharContent()");
      return source;
   }

   /**
    * Return an input stream for reading the byte code
    * 
    * @see javax.tools.SimpleJavaFileObject#openInputStream()
    */
   @Override
   public InputStream openInputStream() {
      return new ByteArrayInputStream(getByteCode());
   }

   /**
    * Return an output stream for writing the bytecode
    * 
    * @see javax.tools.SimpleJavaFileObject#openOutputStream()
    */
   @Override
   public OutputStream openOutputStream() {
      byteCode = new ByteArrayOutputStream();
      return byteCode;
   }

   /**
    * @return the byte code generated by the compiler
    */
   byte[] getByteCode() {
      return byteCode.toByteArray();
   }
}