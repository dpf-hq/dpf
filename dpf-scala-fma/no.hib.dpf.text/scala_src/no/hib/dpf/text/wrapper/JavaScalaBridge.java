package no.hib.dpf.text.wrapper;

import no.hib.dpf.text.graph.*;
import no.hib.dpf.text.tdpf.TGraph;

public class JavaScalaBridge {
	
	private final Bridge bridge = new Bridge(GraphDpf$.MODULE$, "DPF");	

	public JavaScalaBridge(){
		System.out.println("Scala init.");
	}
	
	public void read(TGraph g){
		bridge.readTGraph(g, "Test");
	}
	
}
