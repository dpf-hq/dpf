package no.hib.dpf.jython;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.python.util.PythonInterpreter;

public class Runner {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		PythonInterpreter inter = new PythonInterpreter();
		
		String pythonFile = args[0];
		System.err.println("Python file: " + pythonFile);
		System.err.println(System.getenv());
		InputStream is = new FileInputStream(args[0]);
		inter.execfile(is);
		
	}

}
