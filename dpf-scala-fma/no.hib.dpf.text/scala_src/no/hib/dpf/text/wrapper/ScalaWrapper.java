package no.hib.dpf.text.wrapper;

import no.dpf.text.graph.parser.Parser;
import no.dpf.text.graph.GraphDpf$;

public class ScalaWrapper {
	private final Parser parser = new Parser(GraphDpf$.MODULE$, "DPF");	

	public ScalaWrapper(){
		System.out.println("Scala init.");
	}
	
	
}
