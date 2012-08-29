package template;

import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Predicate;

public class StringUtil {
	private enum Constraints {		
		XOR_SPLIT("xor"),
		XOR_MERGE("xor'"),
		AND_SPLIT("and"),
		AND_MERGE("and'"),
		OR_SPLIT("or"),
		OR_MERGE("or'");
		
		private String symbol;
		
		private Constraints(String symbol) {
			this.symbol = symbol;
		}

		public String mergeStatement(List<Arrow> l) {
			if(l.size() == 2) {
				switch(this) {
					case XOR_MERGE:
						return xorMerge(l);
					case AND_MERGE:
						return andMerge(l);
					default:
						return "";
				}
			} else if (l.size() == 1 && this == XOR_SPLIT) {
				//Case where we need to handle the c and !c predicate on a single incoming arrow on a task node
				boolean c = false;
				
				for(Constraint cc : l.get(0).getConstraints()) {
					if(cc.getPredicate().getSymbol().equals("c")) {
						c = true;
					}
				}
				
				return  "disabled -> enabled { guard " + l.get(0).getName() + " > 0 && " + (c ? "c == 1" : "c == 0") + "; },\n";
			} else {
				return  "disabled -> enabled { guard " + l.get(0).getName() + " > 0; },\n";
			}
			
		}
		
		public String splitStatement(List<Arrow> l) {
			if(l.size() == 2) {
				switch(this) {
				case XOR_SPLIT:
					return xorSplit(l);
				case AND_SPLIT:
					return andSplit(l);
				default:
					return "";
				}
			} else {
				return "running -> finished { effect " + l.get(0).getName() + " = 1; };";
			}
		}
		
		public static Constraints getConstraint(String s) {
			for(Constraints c : Constraints.values()) {
				if(s.equals(c.symbol)) {
					return c;
				}
			}
			return null;
		}
		
	}
	
	public static String splitStatement(List<Arrow> l) {
		//All outgoing arrows should result in an effect statement
		try {
			Predicate p = l.get(0).getConstraints().get(0).getPredicate();
			Constraints c = Constraints.getConstraint(p.getSymbol());
			return c.splitStatement(l);
		} catch(IndexOutOfBoundsException e) {
			//Case where an arrow is not constrained. Should still result in a effect expression
			return "running -> finished { effect " + l.get(0).getName() + " = 1; };";
		}
	}
	
	public static String mergeStatement(List<Arrow> l) {
		//Assuming the incoming arrows are constrained by the same predicate
		try {
			Predicate p = l.get(0).getConstraints().get(0).getPredicate();
			Constraints c = Constraints.getConstraint(p.getSymbol());
			return c.mergeStatement(l);
		} catch(IndexOutOfBoundsException e) {
			//Case where an arrow is not constrained. Should still result in a guard expression
			return "disabled -> enabled { guard " + l.get(0).getName() + " > 0; },\n";
		}
	}
	
	private static String andSplit(List<Arrow> l) {
		//AND split predicates shape consists of two arrows 
		return "running -> finished { effect " + l.get(0).getName() + " = 1, " + l.get(1).getName() + " = 1; };";
	}
	
	private static String xorSplit(List<Arrow> l) {
		//XOR split predicates shape consists of two arrows 
		StringBuffer ret = new StringBuffer();
		ret.append("running -> finished { effect c = 1, " + l.get(0).getName() + " = 1, " + l.get(1).getName() + " = 0; },\n\t\t");
		ret.append("running -> finished { effect c = 0, " + l.get(1).getName() + " = 1, " + l.get(0).getName() + " = 0; };");
		return ret.toString();
	}
	
	private static String xorMerge(List<Arrow> l) {
		//XOR merge predicates shape consists of two arrows 
		StringBuffer ret = new StringBuffer();
		ret.append("disabled -> enabled { guard " + l.get(0).getName() + " > 0 && " + l.get(1).getName() + " == 0; },\n\t\t");
		ret.append("disabled -> enabled { guard " + l.get(1).getName() + " > 0 && " + l.get(0).getName() + " == 0; },\n");
		return ret.toString();
	}
	
	private static String andMerge(List<Arrow> l) {
		//AND merge predicates shape consists of two arrows 
		return "disabled -> enabled { guard " + l.get(0).getName() + " > 0 && " + l.get(1).getName() + " > 0; },\n";
	}
}
