package extensions;

import java.util.List;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;

public class TemplateHelper {
	public enum Mult {MANY_TO_ONE, ONE_TO_MANY, MANY_TO_MANY, ONE_TO_ONE};
	private static String MULT_CONSTRAINT = "[mult(m,n)]";
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
			m = Mult.ONE_TO_ONE;
		}
		return m;
	}
	public static String printArrayImport(Node n) {
		List<Arrow> la = n.getOutgoings();
		boolean ret = false;
		for(Arrow a : la) {
			ret = hasOneOrManyToOtherConstraint(a);
			if (ret) return "import java.util.ArrayList;"; 
		}
		return "";
	}
	public static String getAttr(Arrow a) {
		if(hasOneOrManyToOtherConstraint(a)) return "private ArrayList<" +
					a.getSource().getName() + "> " + a.getName() + ";";
		else return "public " + a.getTarget().getName() + " " + a.getName() + ";";
	}
	public static boolean hasOneOrManyToOtherConstraint(Arrow a) {
		for(Constraint c : a.getConstraints()) {
//			if(c.getPredicate().getSymbol().equals(MULT_CONSTRAINT)) {
				if(!parseConstraint(c.getParameters()).equals(Mult.MANY_TO_ONE))
					return true;
//			}
		}
		return false;
	}
	public static String getParamList(List<Arrow> aa, List<Arrow> aaa) {
		StringBuffer ret = new StringBuffer();
		ret.append(paramList(aa));
		if (aaa.size() != 0 && ret.length() != 0) 
			ret.append(", " + paramList(aaa));
		return ret.toString();
	}
	private static String paramList(List<Arrow> aa) {
		StringBuffer ret = new StringBuffer();
		for(int i = 0; i < aa.size(); ++i) {
			Arrow a = aa.get(i);
			if(hasOneOrManyToOtherConstraint(a)) ret.append("ArrayList<" +
					a.getSource().getName() + "> " + a.getName());
			else ret.append(a.getTarget().getName() + " " + a.getName());
			if(i < aa.size()-1) ret.append(", ");
		}
		return ret.toString();
	}
	public static String getConstructorInit(List<Arrow> aa, List<Arrow> aaa) {
		StringBuffer ret = new StringBuffer();
		for(int i = 0; i < aa.size(); ++i) {
			Arrow a = aa.get(i);
			ret.append("this." + a.getName() + " = " + a.getName() + ";"); 
		}
		return ret.toString();
	}
	
	public String printSymbols(Specification spec) {
		StringBuffer buf = new StringBuffer();
		for(Constraint c : spec.getConstraints()) {
//			try {
				buf.append("Symbol for " + c.getId() + ": " + c.getPredicate().getSymbol() + 
						" Parameters: " + c.getParameters() + "\n");
//			} catch(NullPointerException e) {
//				buf.append("Symbol for " + c.getId() + ": npe\n");
//			}
		}
		return buf.toString();
	}
}

