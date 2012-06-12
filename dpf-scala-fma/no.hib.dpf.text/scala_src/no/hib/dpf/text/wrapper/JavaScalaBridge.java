package no.hib.dpf.text.wrapper;

import no.dpf.text.graph.parser.Parser;
import no.dpf.text.graph.GraphDpf$;

public class JavaScalaBridge {
	private final Parser parser = new Parser(GraphDpf$.MODULE$, "DPF");	

	public JavaScalaBridge(){
		System.out.println("Scala init.");
	}
	
	
}
