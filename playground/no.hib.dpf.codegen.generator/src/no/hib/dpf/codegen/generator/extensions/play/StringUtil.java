package no.hib.dpf.codegen.generator.extensions.play;
import org.eclipse.xtend.util.stdlib.GlobalVarExtensions;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class StringUtil {
	private static String ARROW_TYPE = "Type";
	private static String ARROW_REFERENCE = "Reference";
	private static String MULT_CONSTRAINT = "[mult(m,n)]";
	
	public enum Mult {MANY_TO_ONE, ONE_TO_MANY, MANY_TO_MANY, ONE_TO_ONE};
	public static Mult parseConstraint(String expr) {
		String f,l;
		Mult m;
		try {
			f = expr.substring(0, expr.indexOf(','));
			l = expr.substring(expr.indexOf(',') + 1, expr.length());
			
			if(Integer.parseInt(f) == 1 && Integer.parseInt(l) == -1) {
				m = Mult.ONE_TO_MANY;
			} else if(Integer.parseInt(f) == -1 && Integer.parseInt(l) == -1) {
				m = Mult.MANY_TO_MANY;
			} else if(Integer.parseInt(f) == -1 && Integer.parseInt(l) == 1) {
				m = Mult.MANY_TO_ONE;
			} else m = Mult.ONE_TO_ONE;
			
		} catch (StringIndexOutOfBoundsException e) {
			//TODO: Perhaps we need to get the parameters from constrained out/ingoing arrows
			m = Mult.ONE_TO_ONE;
		}
		
		return m;
	}

	/*public static String getAttributeList(List<Arrow> list) {
		StringBuffer buf = new StringBuffer();
		for(int i = 0; i < list.size(); ++i) {
			Node n = list.get(i).getTarget();
			if(!n.getTypeName().equals("Class")) {
				buf.append(toFirstUpper(n.getTypeName()) + " " + toFirstLower(n.getName()));
			} else {
				buf.append(toFirstUpper(n.getName()) + " " + toFirstLower(n.getName()));
			}
			if(i < list.size()-1) buf.append(", ");
		}
		return buf.toString();
	}*/
	
	private static List<Arrow> getTypeAndReferenceArrows(List<Arrow> la) {
		ArrayList<Arrow> a = new ArrayList<Arrow>();
		for(Arrow aa : la) {
			if(aa.getTypeName().equals(ARROW_TYPE) || aa.getTypeName().equals(ARROW_REFERENCE))
				a.add(aa);		
		}
		return a;
	}
	
	public static Boolean hasMultConstraint(Node n) {
		for(Constraint c : n.getGraph().getConstraints()) {
			if(c.getPredicate().getSymbol().equals(MULT_CONSTRAINT)) {
				for(Node tmp : c.getConstrainedNodes()) {
					if(tmp != null && n != null && tmp.getId() == n.getId()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean hasOneOrManyToOtherConstraint(Arrow a) {
		for(Constraint c : a.getGraph().getConstraints()) {
			if(c.getPredicate().getSymbol().equals(MULT_CONSTRAINT)) {
				for(Arrow tmp : c.getConstrainedArrows()) {
					if(tmp != null && a != null && tmp.getId() == a.getId()
							&& !parseConstraint(c.getParameters()).equals(Mult.MANY_TO_ONE)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//TODO: Refactor so we dont return ""
	public static String printArrayImport(List<Arrow> la) {
		boolean ret = false;
		for(Arrow a : la) {
			ret = hasOneOrManyToOtherConstraint(a);
			if (ret) return "import java.util.ArrayList;"; 
		}
		return "";
	}
	
	public static String getDomainClassAttributes(List<Arrow> la) {
		StringBuffer ret = new StringBuffer();
		List<Arrow> tmp = getTypeAndReferenceArrows(la);
		
		for(int i = 0; i < tmp.size(); ++i) {
			Arrow a = tmp.get(i);
			ret.append(getDomainClassAttributes(a));
			if(i < tmp.size() - 1) ret.append("\n");
		}
		return ret.toString();
	}
	
	private static String getDomainClassAttributes(Arrow a) {
		if(hasOneOrManyToOtherConstraint(a)) {
			if(a.getTypeName().equals(ARROW_TYPE)) {
				return "public " + "ArrayList<" + toFirstUpper(a.getName()) + "> " + toFirstLower(a.getTarget().getName()) + ";";
			} else if (a.getTypeName().equals(ARROW_REFERENCE)){
				return "public " + "ArrayList<" + toFirstUpper(a.getTarget().getName()) + "> " + toFirstLower(a.getName()) + ";";
			}
		} 
		
		if(a.getTypeName().equals(ARROW_TYPE)) {
				return "public " + toFirstUpper(a.getName()) + " " + toFirstLower(a.getTarget().getName() + ";");
		} else if (a.getTypeName().equals(ARROW_REFERENCE)){
				return "public " + toFirstUpper(a.getTarget().getName()) + " " + toFirstLower(a.getName() + ";");
		}
		return null;
	}
	
	
	public static void printConstraints(List<Constraint> co) {
		for(Constraint c : co) {
			for(Arrow a : c.getConstrainedArrows()) {
				if(a != null) {
					System.out.println("Constrained arrow " + a.getName() 
						+ " with constraint: " + c.getPredicate().getSymbol() + " " + c.getParameters());
					System.out.println("----> " + c.getId() + "  " + a.getId());
				}
			}
			for(Node n : c.getConstrainedNodes()) {
				if(n != null) {
					System.out.println("Constrained node " + n.getName() 
							+ " with constraint: " + c.getPredicate().getSymbol() + " " + c.getParameters());
					System.out.println("----> " + c.getId() + "  " + n.getId());
				}
			}
		}
	}
	
	private static String createSetterForConstructor(Arrow a) {
		if(a.getTypeName().equals(ARROW_TYPE)) {
			return "this." + toFirstLower(a.getTarget().getName()) + " = " + toFirstLower(a.getTarget().getName()) + ";";
		} else if(a.getTypeName().equals(ARROW_REFERENCE)){
			return "this." + toFirstLower(a.getName()) + " = " + toFirstLower(a.getName()) + ";";
		} else return null;
	}
	
	public static String getConstructorSetters(List<Arrow> list) {
		List<Arrow> ltmp = getTypeAndReferenceArrows(list);
		StringBuffer res = new StringBuffer();
		for(int i = 0; i < ltmp.size(); ++i) {
			Arrow a = ltmp.get(i);
			res.append(createSetterForConstructor(a));
			if(i < ltmp.size()-1) res.append("\n");
		}
		return res.toString();
	}
	
	private static String getAttributeForConstructor(Arrow a) {
		if(a.getTypeName().equals(ARROW_TYPE)) {
			if(hasOneOrManyToOtherConstraint(a)) 
				return toFirstUpper("ArrayList<" + a.getName()) + "> " + toFirstLower(a.getTarget().getName());
			else
				return toFirstUpper(a.getName()) + " " + toFirstLower(a.getTarget().getName());
		} else if (a.getTypeName().equals(ARROW_REFERENCE)){
			if(hasOneOrManyToOtherConstraint(a))
				return toFirstUpper("ArrayList<" + a.getTarget().getName()) + "> " + toFirstLower(a.getName());
			else
				return toFirstUpper(a.getTarget().getName()) + " " + toFirstLower(a.getName());
		}
		return null;
	}
	
	public static String getAttributeList(List<Arrow> list) {
		List<Arrow> ltmp = getTypeAndReferenceArrows(list);
		StringBuffer res = new StringBuffer();
		for(int i = 0; i < ltmp.size(); ++i) {
			Arrow a = ltmp.get(i);
			String tmp = getAttributeForConstructor(a);
			if(tmp != null) {
				res.append(tmp);
				if(i < ltmp.size()-1) res.append(", ");
			}
		}
		return res.toString();
	}
	
	private static String toFirstUpper(String s) {
		return Character.toUpperCase(s.charAt(0)) + s.substring(1);
	}
	
	private static String toFirstLower(String s) {
		return Character.toLowerCase(s.charAt(0)) + s.substring(1);
	}
}
