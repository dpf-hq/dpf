package no.hib.dpf.text.wrapper;

import java.util.ArrayList;
import java.util.List;
import no.hib.dpf.text.graph.*;

import no.hib.dpf.text.tdpf.Specification;

public class JavaScalaBridge {
	
	public JavaScalaBridge(){
		System.out.println("Scala init.");
	}
	
	public List<String> read(Specification s){
		return new Bridge(Dpf$.MODULE$, "DPF",s.getSequenceNumber()).read(s);
	}
	
}
