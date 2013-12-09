package no.hib.dpf.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;

public class TranslateToAlloy {
	
	/*
	 * Graph structure to alloy specification
	 */
	
	public static final String SN = "SV_";
	public static final String sn = "sv_";
	public static final String TN = "TV_";
	public static final String tn = "tn_";
	public static final String SE = "SE_";
	public static final String se = "se_";
	public static final String te = "te_";
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
			buffer.append(FACT + MORPH + source + "{all n : " + source + " | n.to != none iff n.to.to = n}" + LINE);
		}
		return buffer.toString();
	}
	
	public static String translateEdges(Graph graph, boolean src){
		StringBuffer buffer = new StringBuffer();
		for(Arrow arrow : graph.getArrows()){
			String name = arrow.getName();
			String source = (src ? SE : TE) + name;
			buffer.append(SIG  + source + "{src : one " + (src ? SN : TN) + arrow.getSource().getName() + ", trg: one " + (src ? SN : TN) + arrow.getTarget().getName() + ", to : lone " + (src ? TE : SE) + name + "}" + LINE);
			buffer.append(FACT + MORPH + source + "{all e : " + source + " | (e.to != none iff e.to.to = e) and (e.to != none implies (e.src.to != none and e.trg.to != none and e.src.to = e.to.src and e.trg.to = e.to.trg))}" + LINE);
		}
		return buffer.toString();
	}

	public static String translate(DArrow edge, String vpre, String tpre){
		return vpre + edge.getName() + ":" + tpre + edge.getTypeName();
	}
	public static String translate(DNode node, String vpre, String tpre){
		return vpre + node.getName() + ":" + tpre + node.getTypeName();
	}
	public static String translate(EList<DArrow> arrows, EList<DNode> nodes, EList<DNode> commonNodes, EList<DArrow> commonArrows,
			String vvpre, String vtpre, String evpre, String etpre) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(FACT + "{one ");
		for(int i = 0; i < arrows.size(); i++){
			DArrow edge = arrows.get(i);
			buffer.append(evpre + edge.getName() + " : " + etpre + edge.getTypeName());
			if(i < arrows.size() - 1)
				buffer.append(", ");
		}
		
		Map<DNode, DArrow> derivedsrc = new HashMap<DNode, DArrow>(), derivedtrg = new HashMap<DNode, DArrow>();
		for(int i = 0; i < arrows.size(); i++){
			DArrow edge = arrows.get(i);
			DNode src = edge.getDSource();
			if(!derivedsrc.containsKey(src))
				derivedsrc.put(src, edge);
			else{
				DNode trg = edge.getDTarget();
				if(src != trg && !derivedtrg.containsKey(trg))
					derivedtrg.put(trg,edge);
			}
		}
		List<DNode> named = new ArrayList<DNode>();
		for (int i = 0; i < nodes.size(); i++) {
			DNode cur = nodes.get(i);
			if(!derivedsrc.containsKey(cur) && !named.contains(cur))
				named.add(cur);
		}
		if(!named.isEmpty())
			buffer.append(", ");
		for(DNode node : named)
			buffer.append(vvpre + node.getName() + " : " + vtpre + node.getTypeName());
		buffer.append(" |" + LINE + "let ");
		for (Iterator<Entry<DNode, DArrow>> iterator = derivedsrc.entrySet().iterator(); iterator.hasNext();) {
			Entry<DNode, DArrow> entry = (Entry<DNode, DArrow>) iterator.next();
			DNode node = entry.getKey();
			DArrow arrow = entry.getValue();
			buffer.append(vvpre + node.getName() + " = " + evpre + arrow.getName() + ".src");
			if(iterator.hasNext())
				buffer.append(", ");
		}
		if(!derivedtrg.isEmpty()){
			buffer.append(", ");
			for (Iterator<Entry<DNode, DArrow>> iterator = derivedtrg.entrySet().iterator(); iterator.hasNext();) {
				Entry<DNode, DArrow> entry = (Entry<DNode, DArrow>) iterator.next();
				DNode node = entry.getKey();
				DArrow arrow = entry.getValue();
				buffer.append(vvpre + node.getName() + " = " + evpre + arrow.getName() + ".trg");
				if(iterator.hasNext())
					buffer.append(", ");
			}
		}
		buffer.append(" |" + LINE + "(");
		
		for(int i = 0; i < arrows.size(); i++){
			DArrow edge = arrows.get(i);
			DNode src = edge.getDSource();
			boolean isSrc = !derivedsrc.containsKey(src) || derivedsrc.get(src) != edge;
			
			if(isSrc)
				buffer.append(vvpre + src.getName() + " = " + evpre + edge.getName() + ".src ");
			DNode trg = edge.getDTarget();
			boolean isTrg = !derivedtrg.containsKey(trg) || derivedtrg.get(trg) != edge;
			if(isSrc && isTrg)
				buffer.append("and ");
			if(isTrg)
				buffer.append(vvpre + trg.getName() + " = " + evpre + edge.getName() + ".trg ");
			if(i < arrows.size() - 1)
				buffer.append("and ");
		}
		buffer.append(LINE + "and ");
		for(int i = 0; i < nodes.size(); i++){
			DNode node = nodes.get(i);
			buffer.append(vvpre + node.getName() + ".to " + (commonNodes.contains(node) ? "!" : "") + "= none ");
			if(i < nodes.size() - 1)
				buffer.append("and ");
		}
		if(!arrows.isEmpty())
			buffer.append("and ");
		for(int i = 0; i < arrows.size(); i++){
			DArrow arrow = arrows.get(i);
			buffer.append(evpre + arrow.getName() + ".to " + (commonArrows.contains(arrow) ? "!" : "") + "= none ");
			if(i < arrows.size() - 1)
				buffer.append("and ");
		}
		buffer.append(LINE + ")" + "}");
		return buffer.toString();
	}

	public static String translate(Production iter, DGraph dGraph) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(translate(iter.getLeftArrows(), iter.getLeftNodes(), iter.getCommonNodes(), iter.getCommonArrows(), 
				sn, SN, se, SE));
		buffer.append(LINE);
		buffer.append(translate(iter.getRightArrows(), iter.getRightNodes(), iter.getCommonNodes(), iter.getCommonArrows(), 
				tn, TN, te, TE));
		buffer.append(LINE);
		buffer.append(translateNode(iter.getLeftNodes(), iter.getCommonNodes(), SN));
		buffer.append(LINE);
		buffer.append(translateNode(iter.getRightNodes(), iter.getCommonNodes(), TN));
		buffer.append(LINE);
		buffer.append(translateArrow(iter.getLeftArrows(), iter.getCommonArrows(), SE));
		buffer.append(LINE);
		buffer.append(translateArrow(iter.getRightArrows(), iter.getCommonArrows(), TE));
		buffer.append(LINE);
		buffer.append(translateNode(iter.getLeftNodes(), iter.getCommonNodes(), SN, dGraph.getDNodes()));
		buffer.append(LINE);
		buffer.append(translateNode(iter.getRightNodes(), iter.getCommonNodes(), TN, dGraph.getDNodes()));
		buffer.append(LINE);
		buffer.append(translateArrow(iter.getLeftArrows(), iter.getCommonArrows(), SE, dGraph.getDArrows()));
		buffer.append(LINE);
		buffer.append(translateArrow(iter.getRightArrows(), iter.getCommonArrows(), TE, dGraph.getDArrows()));
		return buffer.toString();
	}
	
	public static String translateNode(EList<DNode> nodes, EList<DNode> commonNodes, String tpre,  EList<DNode> all){
		StringBuffer buffer = new StringBuffer();
		List<DNode> hide = new ArrayList<DNode>();
		hide.addAll(all);
		for(DNode node : nodes){
			if(!commonNodes.contains(node)){
				DNode type = node.getDType();
				if(hide.contains(type))
					hide.remove(type);
			}
		}
		for(DNode node : hide){
			buffer.append(FACT + "{all n : " + tpre + node.getName() + " | n.to != none}" + LINE);
		}
		return buffer.toString();
	}
	public static String translateArrow(EList<DArrow> arrows, EList<DArrow> commonArrows, String tpre,  EList<DArrow> all){
		StringBuffer buffer = new StringBuffer();
		List<DArrow> hide = new ArrayList<DArrow>();
		hide.addAll(all);
		for(DArrow arrow : arrows){
			if(!commonArrows.contains(arrow)){
				DArrow type = arrow.getDType();
				if(hide.contains(type))
					hide.remove(type);
			}
		}
		for(DArrow arrow : hide){
			buffer.append(FACT + "{all e : " + tpre + arrow.getName() + " | e.to != none}" + LINE);
		}
		return buffer.toString();
	}
	public static String translateNode(EList<DNode> nodes, EList<DNode> commonNodes, String tpre){
		StringBuffer buffer = new StringBuffer();
		Map<DNode, Integer> counters = new HashMap<>();
		for(DNode node : nodes){
			if(!commonNodes.contains(node)){
				DNode type = node.getDType();
				Integer count = counters.get(type);
				if(count == null)
					counters.put(type, 1);
				else
					count = count + 1;
			}
		}
		for(Entry<DNode, Integer> entry : counters.entrySet()){
			DNode node = entry.getKey();
			int count = entry.getValue();
			buffer.append(FACT + "{#{n : " + tpre + node.getName() + " | n.to = none} = " + count + "}" + LINE);
		}
		return buffer.toString();
	}
	public static String translateArrow(EList<DArrow> arrows, EList<DArrow> commonArrows, String tpre){
		StringBuffer buffer = new StringBuffer();
		Map<DArrow, Integer> counters = new HashMap<>();
		for(DArrow arrow : arrows){
			if(!commonArrows.contains(arrow)){
				DArrow type = arrow.getDType();
				Integer count = counters.get(type);
				if(count == null)
					counters.put(type, 1);
				else
					count = count + 1;
			}
		}
		for(Entry<DArrow, Integer> entry : counters.entrySet()){
			DArrow arrow = entry.getKey();
			int count = entry.getValue();
			buffer.append(FACT + "{#{e : " + tpre + arrow.getName() + " | e.to = none} = " + count + "}" + LINE);
		}
		return buffer.toString();
	}

}
