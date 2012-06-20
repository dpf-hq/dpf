package no.hib.dpf.text.wrapper;

import java.util.Stack;
import java.util.List;
import no.hib.dpf.text.graph.*;

import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.util.Tuple;

public class JavaScalaBridge {
	
	public JavaScalaBridge(){
		//System.out.println("Scala init.");
	}
	
	public List<String> read(Stack<Tuple<String,Specification>> s){
		return new Bridge(Dpf$.MODULE$,"DPF",s.get(0).y.getSequenceNumber()).read(s);
	}
	
	
}
