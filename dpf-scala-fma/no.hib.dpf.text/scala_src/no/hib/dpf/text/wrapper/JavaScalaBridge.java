package no.hib.dpf.text.wrapper;

import java.util.ArrayList;
import java.util.List;
import no.hib.dpf.text.graph.*;

import no.hib.dpf.text.tdpf.Specification;

public class JavaScalaBridge {
	
	private final Bridge bridge = new Bridge(Dpf$.MODULE$, "DPF");	

	public JavaScalaBridge(){
		System.out.println("Scala init.");
	}
	
	public List<String> read(Specification s){
		return bridge.read(s);
	}
	
}
