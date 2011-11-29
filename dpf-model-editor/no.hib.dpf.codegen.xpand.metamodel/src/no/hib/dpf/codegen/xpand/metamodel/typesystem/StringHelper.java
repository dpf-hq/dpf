package no.hib.dpf.codegen.xpand.metamodel.typesystem;

public class StringHelper {
	public static String pluralize(String arg) {
		if(arg.endsWith("e") || arg.endsWith("a") || arg.endsWith("i") 
				|| arg.endsWith("o") || arg.endsWith("u") || arg.endsWith("y")) {
			return arg + "s";
		}
		return arg + "es";
	}
}
