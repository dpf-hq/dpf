package no.hib.dpf.text.wrapper;

import java.util.Map;
import java.util.List;
import java.util.Stack;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.Signature;
import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.util.Tuple;

public final class JavaScalaBridge {
	
	public static Tuple<List<String>,List<Tuple<?,String>>> read(Stack<Tuple<String,Specification>> s){
		return new Bridge(null,"",s.get(0).y.getSequenceNumber().getNextNumber()).read(s);
	}
	
	public static boolean isSpecificationInCache(String name){
		return no.hib.dpf.text.graph.parser.Parser$.MODULE$.specs().contains(name);
	}

	public static Tuple<Map<Long,String>,List<String>> checkConstraints(Specification s, Signature cs){
		return new Bridge(null,"",s.getSequenceNumber().getNextNumber()).checkConstraints(s,cs);
	}
	
	//Non-Static:
	private final Bridge bridge;
	
	public JavaScalaBridge(long seqNum, String mm){
		bridge = new Bridge(null,"",seqNum);
		bridge.createGraph(mm);
	}
	
	public Tuple<Node,String> addNode(Node n){
		return bridge.addJNode(n);
	}

	public Tuple<Arrow,String> addArrow(Arrow a){
		return bridge.addJArrow(a);
	}
	public Tuple<Tuple<Arrows,Arrows>,String> addArrows(Arrows a, Arrows next){
		return bridge.addJArrows(a,next);
	}
	
	
	public Tuple<Arrow,String> checkArrowForConstraint(Arrow a){
		return bridge.checkJArrowForConstraint(a);
	}
	
	public Tuple<Tuple<Arrows,Arrows>,String> checkArrowsForConstraint(Arrows a, Arrows next){
		return bridge.checkJArrowsForConstraint(a,next);
	}
	
}
