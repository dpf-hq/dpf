package no.hib.dpf.verify;

import java.util.ArrayList;
import java.util.HashMap;
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
	public static final String MORPH = "morphism_";
	public static final String SIG = "sig ";
	public static final String FACT = "fact ";
	public static final String LINE = System.lineSeparator();

	public static String translateNodeTypes(Graph graph, boolean src){
		StringBuffer buffer = new StringBuffer();
		for(Node node : graph.getNodes()){
			String name = node.getName();
			String source = (src ? SN : TN) + name;
			buffer.append(SIG  + source + "{to : lone " + (src ? TN : SN) + name + "}" + LINE);
		}
		buffer.append(LINE + FACT + MORPH + "nodes{" + LINE);
		for(Node node : graph.getNodes()){
			String name = node.getName();
			String source = (src ? SN : TN) + name;
			buffer.append("all n : " + source + " | some n.to iff n.to.to = n" + LINE);
		}
		buffer.append("}" + LINE);
		return buffer.toString();
	}

	public static String translateEdgeTypes(Graph graph, boolean src){
		StringBuffer buffer = new StringBuffer();
		for(Arrow arrow : graph.getArrows()){
			String name = arrow.getName();
			String source = (src ? SE : TE) + name;
			buffer.append(SIG  + source + "{src : one " + (src ? SN : TN) + arrow.getSource().getName() + ", trg: one " + (src ? SN : TN) + arrow.getTarget().getName() + ", to : lone " + (src ? TE : SE) + name + "}" + LINE);
		}
		buffer.append(LINE + FACT + MORPH + "edges{" + LINE);
		for(Arrow arrow : graph.getArrows()){
			String name = arrow.getName();
			String source = (src ? SE : TE) + name;
			buffer.append("all e : " + source + " | (some e.to iff e.to.to = e) and (some e.to implies (some e.src.to and some e.trg.to and e.src.to = e.to.src and e.trg.to = e.to.trg))" + LINE);
		}
		buffer.append("}" + LINE);
		return buffer.toString();
	}

	public static String translate(DArrow edge, String vpre, String tpre){
		return vpre + edge.getName() + ":" + tpre + edge.getTypeName();
	}
	public static String translate(DNode node, String vpre, String tpre){
		return vpre + node.getName() + ":" + tpre + node.getTypeName();
	}
	private static void printAList(StringBuffer buffer, List<String> strings, String between){
		for(int index = 0; index < strings.size(); index++){
			buffer.append(strings.get(index));
			if(index != strings.size() - 1)
				buffer.append(between);
		}
		strings.clear();
	}
	/*
	 * Giving that B is a subgraph of A, get the graph difference A-B. 
	 * 
	 */
	public static void graphDifference(List<DNode> ANodes, List<DArrow> AArrows, 
									   List<DNode> BNodes, List<DArrow> BArrows, 
									   List<DNode> CNodes, List<DArrow> CArrows){
		for (DNode dNode : ANodes) {
			if(!BNodes.contains(dNode) && !CNodes.contains(dNode))
				CNodes.add(dNode);
		}
		for (DArrow dArrow : AArrows) {
			if(!BArrows.contains(dArrow) && !CArrows.contains(dArrow)){
				CArrows.add(dArrow);
				if(!CNodes.contains(dArrow.getDSource()))
					CNodes.add(dArrow.getDSource());
				if(!CNodes.contains(dArrow.getDTarget()))
					CNodes.add(dArrow.getDTarget());
			}
		}
	}
	public static String translateMatchConnected(List<DArrow> arrows, List<DNode> nodes, 
			List<DNode> commonNodes, List<DArrow> commonArrows,
			String vvpre, String vtpre, String evpre, String etpre) {
		StringBuffer buffer = new StringBuffer();
		boolean noChange = nodes.size() - commonNodes.size() == 0 && arrows.size() - commonArrows.size() == 0;
		boolean isSingle = arrows.isEmpty();
		if(noChange || isSingle)
			buffer.append("some ");
		else buffer.append("one ");
		if(isSingle){
			DNode node = nodes.get(0);
			buffer.append(vvpre + node.getName() + " : " + vtpre + node.getTypeName() + " | " + (commonNodes.contains(node) ? "some " : "none ") + vvpre + node.getName() + ".to" + LINE + LINE);
			return buffer.toString();
		}
		List<String> strings = new ArrayList<String>();
		for (DArrow edge : arrows) 
			strings.add(evpre + edge.getName() + " : " + etpre + edge.getTypeName());
		printAList(buffer, strings, ", ");

		Map<DNode, DArrow> derivedBySource = new HashMap<DNode, DArrow>(), 
				derivedByTarget = new HashMap<DNode, DArrow>();
		for(int i = 0; i < arrows.size(); i++){
			DArrow edge = arrows.get(i);
			DNode src = edge.getDSource();
			DNode trg = edge.getDTarget();
			if(!derivedBySource.containsKey(src) && !derivedByTarget.containsKey(src))
				derivedBySource.put(src, edge);
			if(!derivedBySource.containsKey(trg) && !derivedByTarget.containsKey(trg))
				derivedByTarget.put(trg, edge);
		}
		
		for (Entry<DNode, DArrow> entry : derivedBySource.entrySet()) 
			strings.add(vvpre + entry.getKey().getName() + " = " + evpre + entry.getValue().getName() + ".src");
		for (Entry<DNode, DArrow> entry : derivedByTarget.entrySet()) 
			strings.add(vvpre + entry.getKey().getName() + " = " + evpre + entry.getValue().getName() + ".trg");
		if(!strings.isEmpty()){
			buffer.append(" |" + LINE + "let ");
			printAList(buffer, strings, ", ");
		}
		
		buffer.append(" |" + LINE + "(");
		for(DArrow edge : arrows){
			DNode src = edge.getDSource(); 
			DArrow theSrcEdge = derivedBySource.get(src);
			boolean isSrcDerived = theSrcEdge != null && theSrcEdge == edge;
			if(!isSrcDerived)
				strings.add(vvpre + src.getName() + " = " + evpre + edge.getName() + ".src ");

			DNode trg = edge.getDTarget();
			DArrow theTrgEdge = derivedByTarget.get(trg);
			boolean isTrgDerived = theTrgEdge != null && theTrgEdge == edge;
			if(!isTrgDerived){
				strings.add(vvpre + trg.getName() + " = " + evpre + edge.getName() + ".trg ");
			}
		}
		printAList(buffer, strings, "and ");
		buffer.append("and " + LINE);
		
		for(DNode node : nodes)
			if(!commonNodes.contains(node))
				strings.add("no " + vvpre + node.getName()  + ".to ");
		
		for(DArrow arrow : arrows)
			if(!commonArrows.contains(arrow))
				strings.add("no " + evpre + arrow.getName() + ".to ");
		
		for(DNode node : commonNodes)
			strings.add("some " + vvpre + node.getName()  + ".to ");
		
		for(DArrow arrow : commonArrows)
			strings.add("some " + evpre + arrow.getName() + ".to ");
		printAList(buffer, strings, "and ");
		
		buffer.append(")" + LINE + LINE);
		return buffer.toString();
	}
	public static String translateMatch(EList<DArrow> arrows, EList<DNode> nodes, EList<DNode> commonNodes, EList<DArrow> commonArrows,
			String vvpre, String vtpre, String evpre, String etpre) {
		
		StringBuffer buffer = new StringBuffer();
		List<DNode> visited = new ArrayList<DNode>();
		List<DArrow> unvisitedArrows = new ArrayList<DArrow>();
		unvisitedArrows.addAll(arrows);
		for (DNode dNode : nodes) {
			if(!visited.contains(dNode)){
				List<DArrow> carrows = new ArrayList<DArrow>();
				List<DNode> cnodes = new ArrayList<DNode>();
				List<DNode> untouched = new ArrayList<DNode>();
				untouched.add(dNode);
				while(!untouched.isEmpty()){
					DNode iter = untouched.get(0);
					untouched.remove(iter);
					cnodes.add(iter);
					visited.add(iter);
					for(DArrow arrow : unvisitedArrows){
						DNode source = arrow.getDSource(), target = arrow.getDTarget();
						if(source == iter || target == iter){
							if(!carrows.contains(arrow)){
								carrows.add(arrow);
								DNode other = source == iter ? target : source;
								if(!cnodes.contains(other) && !untouched.contains(other))
									untouched.add(other);
							}
						}
					}
					unvisitedArrows.removeAll(carrows);
				}
				List<DNode> ccommonNodes = new ArrayList<DNode>();
				List<DArrow> ccommonArrows = new ArrayList<DArrow>();
				for(DNode node : cnodes)
					if(commonNodes.contains(node))
						ccommonNodes.add(node);
				for (DArrow dArrow : carrows) 
					if(commonArrows.contains(dArrow))
						ccommonArrows.add(dArrow);
					
				buffer.append(translateMatchConnected(carrows, cnodes, ccommonNodes, ccommonArrows, vvpre, vtpre, evpre, etpre));
				}
			}
		return buffer.toString();
	}

	public static String translateRule(Production iter, DGraph dGraph) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(FACT + "{");
		buffer.append(translateMatch(iter.getLeftArrows(), iter.getLeftNodes(), iter.getCommonNodes(), iter.getCommonArrows(), 
				sn, SN, se, SE));
		buffer.append(translateMatch(iter.getRightArrows(), iter.getRightNodes(), iter.getCommonNodes(), iter.getCommonArrows(), 
				tn, TN, te, TE));
		buffer.append(translateNodeMulti(iter.getLeftNodes(), iter.getCommonNodes(), SN));
		buffer.append(translateNodeMulti(iter.getRightNodes(), iter.getCommonNodes(), TN));
		buffer.append(translateArrowMulti(iter.getLeftArrows(), iter.getCommonArrows(), SE));
		buffer.append(translateArrowMulti(iter.getRightArrows(), iter.getCommonArrows(), TE));
		buffer.append(translateNodeUnchanged(iter.getLeftNodes(), iter.getCommonNodes(), SN, dGraph.getDNodes()));
		buffer.append(translateNodeUnchanged(iter.getRightNodes(), iter.getCommonNodes(), TN, dGraph.getDNodes()));
		buffer.append(translateArrowUnchanged(iter.getLeftArrows(), iter.getCommonArrows(), SE, dGraph.getDArrows()));
		buffer.append(translateArrowUnchanged(iter.getRightArrows(), iter.getCommonArrows(), TE, dGraph.getDArrows()));
		buffer.append("}");
		return buffer.toString();
	}

	public static String translateNodeUnchanged(EList<DNode> nodes, EList<DNode> commonNodes, String tpre,  EList<DNode> all){
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
			buffer.append("all n : " + tpre + node.getName() + " | some n.to" + LINE);
		}
		return buffer.toString();
	}
	public static String translateArrowUnchanged(EList<DArrow> arrows, EList<DArrow> commonArrows, String tpre,  EList<DArrow> all){
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
		for(DArrow arrow : hide)
			buffer.append("all e : " + tpre + arrow.getName() + " | some e.to" + LINE);
		return buffer.toString();
	}
	public static String translateNodeMulti(EList<DNode> nodes, EList<DNode> commonNodes, String tpre){
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
			buffer.append("#{n : " + tpre + node.getName() + " | no n.to} = " + count + LINE);
		}
		return buffer.toString();
	}
	public static String translateArrowMulti(EList<DArrow> arrows, EList<DArrow> commonArrows, String tpre){
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
			buffer.append("#{e : " + tpre + arrow.getName() + " | no e.to} = " + count + LINE);
		}
		return buffer.toString();
	}

}
