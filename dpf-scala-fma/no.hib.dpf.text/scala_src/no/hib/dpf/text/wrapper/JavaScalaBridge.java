package no.hib.dpf.text.wrapper;

import no.hib.dpf.text.graph.parser.Bridge;
import no.hib.dpf.text.graph.GraphDpf$;

public class JavaScalaBridge {
	private final Bridge parser = new Bridge(GraphDpf$.MODULE$, "DPF");	

	public JavaScalaBridge(){
		System.out.println("Scala init.");
	}
	
	
	
}
