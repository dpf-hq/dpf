package no.hib.mums.shared;

import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;

public class ModelUtil {
	
	private Specification model;
	
	private Node tempNode = null;
	private Arrow tempArrow = null;
	
	public ModelUtil(Specification model) {
		this.model = model;
	}
	
	public ModelUtil is(Node n) {
		tempNode = n;
		return this;
	}
	
	public boolean typeOf(Arrow a) {
		boolean ret = false;
		if(tempArrow.getTypeArrow().equals(a)) {
			ret = true;
		}
		nul();
		return ret;
	}
	
	public boolean typeOf(String s) {
		boolean ret = false;
		if(tempNode != null) {
			if(tempNode.getTypeName().equals(s)) {
				ret = true;
			}
		} else {
			if(tempArrow.getTypeArrow().equals(s)) {
				ret = true;
			}
		}
		nul();
		return ret;
	}
	
	public boolean typeOf(Node n) {
		boolean ret = false;
		if(tempNode.getTypeNode().equals(n)) {
			ret = true;
		}
		nul();
		return ret;
	}
	
	public ModelUtil getArrows() {
		
		return this;
	}
	
	public <T> List<T> select() {
		return null;
		
	}
	
	public static void printSpecification(Specification s) {
		System.out.println("Specification " + s.toString());
		System.out.println("\tGraph " + s.getGraph().getName() + " " + s.getGraph().getId());
		System.out.println("\t\tNodes:");
		for(Node n : s.getGraph().getNodes()) {
			System.out.println("\t\t\t" + n.getName() + " " + n.getId() + " -> Typed by " + n.getTypeName());
		}
		System.out.println("\t\tArrows:");
		for(Arrow a : s.getGraph().getArrows()) {
			System.out.println("\t\t\t" + a.getName() + " " + a.getId() + " -> Typed by " + a.getTypeName());
			System.out.println("\t\t\t\tSource: " + a.getSource());
			System.out.println("\t\t\t\tTarget: " + a.getTarget());
		}
		if(s.getType() != null && s.getType().getGraph() != null) {
			printSpecification(s.getType());
		} else {
			//A proxy is an object that is defined in a Resource that has not been loaded. 
			//An object may be a proxy either because proxy resolution was disabled when 
			//the object was accessed (see eGet(EStructuralFeature,boolean)) or because proxy resolution failed.
			System.out.println("Specification.type is empty or proxy");
			//Proxyobjects might fail to load if a bundle cannot be resolved. The app trying to resolve it needs
			//to be OSGi
		}
	}
	
	private void nul() {
		tempNode = null;
		tempArrow = null;
	}
	
	private void nul(Object o) {
		o = null;
	}
}
