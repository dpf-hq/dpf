package no.hib.dpf.verify;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

public class TranslateToAlloy {
	
	/*
	 * Graph structure to alloy specification
	 */
	
	public static final String SN = "SV_";
	public static final String TN = "TV_";
	public static final String SE = "SE_";
	public static final String TE = "TE_";
	public static final String MORPH = "morph_";
	public static final String SIG = "sig ";
	public static final String FACT = "fact ";
	public static final String LINE = System.lineSeparator();
	
	public static String translateNodes(Graph graph, boolean src){
		StringBuffer buffer = new StringBuffer();
		for(Node node : graph.getNodes()){
			String name = node.getName();
			String source = (src ? SN : TN) + name;
			buffer.append(SIG  + source + "{to : lone " + (src ? TN : SN) + name + "}" + LINE);
			buffer.append(FACT + MORPH + source + "{all n:" + source + "|n.to != none iff n.to.to = n}" + LINE);
		}
		return buffer.toString();
	}
	
	public static String translateEdges(Graph graph, boolean src){
		StringBuffer buffer = new StringBuffer();
		for(Arrow arrow : graph.getArrows()){
			String name = arrow.getName();
			String source = (src ? SE : TE) + name;
			buffer.append(SIG  + source + "{src : one " + (src ? SN : TN) + arrow.getSource().getName() + ", trg: one " + (src ? SN : TN) + arrow.getTarget().getName() + ", to : lone " + (src ? TE : SE) + name + "}" + LINE);
			buffer.append(FACT + MORPH + source + "{all e:" + source + "|(e.to != none iff e.to.to = e) and (e.to != none implies (e.src.to != none and e.trg.to != none and e.src.to = e.to.src and e.trg.to = e.to.trg))}" + LINE);
		}
		return buffer.toString();
	}

}
