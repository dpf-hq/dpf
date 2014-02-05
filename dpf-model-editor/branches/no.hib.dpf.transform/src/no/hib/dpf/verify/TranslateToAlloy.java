package no.hib.dpf.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;

public class TranslateToAlloy {

	/*
	 * Graph structure to alloy specification
	 */

	static public  final String LINE = System.lineSeparator();
	static public  final String NP = "N";
	static public  final String AP = "A";
	static public  final String SIG = "sig ";
	
	private String nodes = null;
	private String arrows = null;
	private StringBuffer buffer = new StringBuffer();
	private DGraph dGraph = null;
	private List<Production> rules = null;
	
	static private String COMMONARROW = "(trans.source.arrows-trans.darrows)";
	static private String COMMONNODE = "(trans.source.nodes-trans.dnodes)";
	static private String DELETEARROW = "trans.darrows";
	static private String DELETENODE = "trans.dnodes";
	static private String ADDARROW = "trans.aarrows";
	static private String ADDNODE = "trans.anodes";
	
	public  String nodeName(Node node){ return NP + node.getName(); }
	public  String arrowName(Arrow node){ return AP + node.getName(); }
	public  void nodeTypes(){
		for(Node node : dGraph.getGraph().getNodes())
			buffer.append(SIG + nodeName(node) + "{}" + LINE);
	}
	public void arrowTypes(){
		for(Arrow arrow : dGraph.getGraph().getArrows())
			buffer.append(SIG + arrowName(arrow) + "{src:one " + nodeName(arrow.getSource()) + ", trg:one " + nodeName(arrow.getTarget()) + "}" + LINE);
	}
	
	public void ruleTypes(){
		buffer.append("one abstract " + SIG + "Rule{}" + LINE);
		buffer.append("lone " + SIG);
		for (Iterator<Production> iterator = rules.iterator(); iterator.hasNext();) {
			Production production = (Production) iterator.next();
			buffer.append(production.getName());
			if(iterator.hasNext())
				buffer.append(", ");
		}
		buffer.append(" extends Rule{}" + LINE);
	}
	protected  String nodesType(){
		if(nodes != null) return nodes;
		nodes = "";
		for (Iterator<Node> iterator = dGraph.getGraph().getNodes().iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			nodes += nodeName(node);;
			if(iterator.hasNext())
				nodes += "+";
		}
		return nodes;
	}
	protected  String arrowsType(){
		if(arrows != null) return arrows;
		arrows = "";
		for (Iterator<Arrow> iterator = dGraph.getGraph().getArrows().iterator(); iterator.hasNext();) {
			Arrow arrow = (Arrow) iterator.next();
			arrows += arrowName(arrow);;
			if(iterator.hasNext())
				arrows += "+";
		}
		return arrows;
	}
	public  void graphType(){
		buffer.append(SIG + "Graph{nodes:set ");
		buffer.append(nodesType());
		buffer.append(", arrows:set ");
		buffer.append(arrowsType());
		buffer.append("}" + LINE);
	}
	public  void transType(){
		buffer.append(SIG + "Trans{rule:one Rule, source:one Graph, target:one Graph, dnodes:set ");
		buffer.append(nodesType());
		buffer.append(", darrows:set ");
		buffer.append(arrowsType());
		buffer.append(", anodes:set ");
		buffer.append(nodesType());
		buffer.append(", aarrows:set ");
		buffer.append(arrowsType());
		buffer.append("}" + LINE);
	}
	public void pre_no_dangle_arrow(){
		buffer.append("pred no_dangle_arrow[trans:Trans]{" + LINE);
		for (Arrow arrow : dGraph.getGraph().getArrows()){
			buffer.append("all arrow : " + arrowName(arrow) + "|(arrow.src in trans.dnodes or arrow.trg in trans.dnodes) implies arrow in trans.darrows" + LINE);
			buffer.append("all arrow : " + arrowName(arrow) + "|(arrow.src in trans.anodes or arrow.trg in trans.anodes) implies arrow in trans.aarrows" + LINE);
		}
		buffer.append("}" + LINE);
	}
	public void pre_trans_general(){
		buffer.append("pred trans_general[trans:Trans]{" + LINE);
		buffer.append("some trans.dnodes or some trans.darrows or some trans.anodes or some trans.aarrows" + LINE);
		buffer.append("trans.dnodes in trans.source.nodes" + LINE);
		buffer.append("trans.darrows in trans.source.arrows" + LINE);
		buffer.append("trans.anodes in trans.target.nodes" + LINE);
		buffer.append("trans.aarrows in trans.target.arrows" + LINE);
		buffer.append("no (trans.dnodes & trans.anodes)" + LINE);
		buffer.append("no (trans.darrows & trans.aarrows)" + LINE);
		buffer.append("trans.source.nodes-trans.dnodes=trans.target.nodes-trans.anodes" + LINE);
		buffer.append("trans.source.arrows-trans.darrows=trans.target.arrows-trans.aarrows" + LINE);
		buffer.append("}" + LINE);
	}
	public void pre_source_valid(){
		buffer.append("pre source_valid[trans]{" + LINE);
		buffer.append("}" + LINE);
	}
	private void getRelated(List<DNode> nodes, List<Object> relatedSet, List<DArrow> arrows){
		List<DNode> unvisited = new ArrayList<DNode>();
		unvisited.addAll(nodes);
		while(!unvisited.isEmpty()){
			DNode visit = unvisited.get(0);
			List<DNode> related = new ArrayList<DNode>();
			related.add(visit);
			unvisited.remove(visit);
			List<DNode> subn = new ArrayList<DNode>();
			List<DArrow> suba = new ArrayList<DArrow>();
			do{
				DNode cur = related.get(0);
				related.remove(cur);
				subn.add(cur);
				if(unvisited.contains(cur))
					unvisited.remove(cur);
				for(DArrow arrow : cur.getDIncomings()){
					if(!arrows.contains(arrow))
						continue;
					if(!suba.contains(arrow))
						suba.add(arrow);
					DNode source = arrow.getDSource();
					if(!related.contains(source) && !subn.contains(source))
						related.add(source);
				}
				for(DArrow arrow : cur.getDOutgoings()){
					if(!arrows.contains(arrow))
						continue;
					if(!suba.contains(arrow))
						suba.add(arrow);
					DNode target = arrow.getDTarget();
					if(!related.contains(target) && !subn.contains(target))
						related.add(target);
				}					
			}while(!related.isEmpty());
			relatedSet.add(subn);
			relatedSet.add(suba);
		}
		
	}
	@SuppressWarnings("unchecked")
	public  void translateMatch(List<DNode> nodes, List<DArrow> arrows, List<DNode> commonNodes, List<DArrow> commonArrows,
			boolean delete){
		List<Object> relatedSet = new ArrayList<Object>();
		getRelated(nodes, relatedSet, arrows);
		for(int index = 0; index < relatedSet.size(); index += 2){
			List<DNode> subn = (List<DNode>) relatedSet.get(index);
			List<DArrow> suba = (List<DArrow>) relatedSet.get(index + 1);
			List<DNode>  subcn = new ArrayList<DNode>();
			List<DArrow>  subca = new ArrayList<DArrow>();
			for(DNode node : subn)
				if(commonNodes.contains(node))
					subcn.add(node);
			for(DArrow arrow : suba)
				if(commonArrows.contains(arrow))
					subca.add(arrow);
			translateRelatedMatch(suba, subn, subcn, subca, true);
		}
		
	}
	public void pre_rule(Production rule, DGraph dGraph){
		buffer.append("pred rule_" + rule.getName() + "[trans:Trans]{" + LINE);
		buffer.append("some trans.rule&" + rule.getName() + LINE);
		translateMatch(rule.getLeftNodes(), rule.getLeftArrows(), rule.getCommonNodes(), rule.getCommonArrows(), true);
		translateMatch(rule.getRightNodes(), rule.getRightArrows(), rule.getCommonNodes(), rule.getCommonArrows(), false);
		translateNodeMulti(rule.getLeftNodes(), rule.getCommonNodes(), DELETENODE);
		translateNodeMulti(rule.getRightNodes(), rule.getCommonNodes(), ADDNODE);
		translateArrowMulti(rule.getLeftArrows(), rule.getCommonArrows(), DELETEARROW);
		translateArrowMulti(rule.getRightArrows(), rule.getCommonArrows(), ADDARROW);
		translateNodeUnchanged(rule.getLeftNodes(), rule.getCommonNodes(), DELETENODE, dGraph.getDNodes());
		translateNodeUnchanged(rule.getRightNodes(), rule.getCommonNodes(), ADDNODE, dGraph.getDNodes());
		translateArrowUnchanged(rule.getLeftArrows(), rule.getCommonArrows(), DELETEARROW, dGraph.getDArrows());
		translateArrowUnchanged(rule.getRightArrows(), rule.getCommonArrows(), ADDARROW, dGraph.getDArrows());
		buffer.append("}" + LINE);
	}
	
	public void fact(List<Production> rules){
		buffer.append("fact{" + LINE);
		buffer.append("(Trans.source+Trans.target)=Graph" + LINE);
		buffer.append("Rule=Trans.rule" + LINE);
		buffer.append("Graph.nodes=" + nodesType() + LINE);
		buffer.append("Graph.arrows=" + arrowsType() + LINE);
		buffer.append("all trans:Trans | no_dangle_arrow[trans] and trans_general[trans] and source_valid[trans] and (" + LINE);
		for (Iterator<Production> iterator = rules.iterator(); iterator.hasNext();) {
			Production rule = (Production) iterator.next();
			buffer.append("rule_" + rule.getName() + "[trans]");
			if(iterator.hasNext())
				buffer.append(" or ");
		}
		buffer.append(")" + LINE + "}");
	}
	public  String translate(EList<DArrow> arrows, EList<DNode> nodes, EList<DNode> commonNodes, EList<DArrow> commonArrows,
			String vvpre, String vtpre, String evpre, String etpre) {
		StringBuffer buffer = new StringBuffer();
		List<DNode> island = new ArrayList<DNode>(), someNodes = new ArrayList<DNode>();
		for(DNode node : nodes){
			boolean isSingled = true;
			for (DArrow dArrow : arrows) {
				if(dArrow.getDSource() == node || dArrow.getDTarget() == node){
					isSingled = false;
					break;
				}
			}
			if(isSingled){
				if(!commonNodes.contains(node)){
					if(!island.contains(node))
						island.add(node);
				}else if(!someNodes.contains(node))
					someNodes.add(node);
			}
		}
		for (int i = 0; i < someNodes.size(); i++) {
			DNode node = someNodes.get(0);
			buffer.append("(some " + vvpre + node.getName() + " : " + vtpre + node.getTypeName() + " | some " + vvpre + node.getName() + ".to)");
			if(i != someNodes.size() - 1)
				buffer.append(" and ");
		}
		if(arrows.isEmpty() && nodes.size() - someNodes.size() == 0){
			buffer.append(LINE);
			return buffer.toString();
		}
		
		if(!someNodes.isEmpty())
			buffer.append(" and ");
		buffer.append("one ");
		for(int i = 0; i < arrows.size(); i++){
			DArrow edge = arrows.get(i);
			buffer.append(evpre + edge.getName() + " : " + etpre + edge.getTypeName());
			if(i < arrows.size() - 1)
				buffer.append(", ");
		}

		Map<DNode, DArrow> derivedBySource = new HashMap<DNode, DArrow>(), derivedByTarget = new HashMap<DNode, DArrow>();
		for(int i = 0; i < arrows.size(); i++){
			DArrow edge = arrows.get(i);
			DNode src = edge.getDSource();
			DNode trg = edge.getDTarget();
			if(!derivedBySource.containsKey(src) && !derivedByTarget.containsKey(src))
				derivedBySource.put(src, edge);
			if(!derivedBySource.containsKey(trg) && !derivedByTarget.containsKey(trg))
				derivedByTarget.put(trg, edge);
		}
		if(arrows.size() > 0 && !island.isEmpty())
			buffer.append(", ");
		for (int i = 0; i < island.size(); i++) {
			DNode node = island.get(i);
			buffer.append(vvpre + node.getName() + " : " + vtpre + node.getTypeName());
			if(i != island.size() - 1)
				buffer.append(", ");
		}
		if(!derivedBySource.isEmpty() || !derivedByTarget.isEmpty())
			buffer.append(" |" + LINE + "let ");
		for (Iterator<Entry<DNode, DArrow>> iterator = derivedBySource.entrySet().iterator(); iterator.hasNext();) {
			Entry<DNode, DArrow> entry = (Entry<DNode, DArrow>) iterator.next();
			DNode node = entry.getKey();
			DArrow edge = entry.getValue();
			buffer.append(vvpre + node.getName() + " = " + evpre + edge.getName() + ".src");
			if(iterator.hasNext())
				buffer.append(", ");
		}
		if(!derivedBySource.isEmpty() && !derivedByTarget.isEmpty())
			buffer.append(", ");
		for (Iterator<Entry<DNode, DArrow>> iterator = derivedByTarget.entrySet().iterator(); iterator.hasNext();) {
			Entry<DNode, DArrow> entry = (Entry<DNode, DArrow>) iterator.next();
			DNode node = entry.getKey();
			DArrow edge = entry.getValue();
			buffer.append(vvpre + node.getName() + " = " + evpre + edge.getName() + ".trg");
			if(iterator.hasNext())
				buffer.append(", ");
		}
		buffer.append(" |" + LINE + "(");

		List<String> strings = new ArrayList<String>();
		for(int i = 0; i < arrows.size(); i++){
			String current = "";
			DArrow edge = arrows.get(i);
			DNode src = edge.getDSource(); 
			DArrow theSrcEdge = derivedBySource.get(src);
			boolean isSrcDerived = theSrcEdge != null && theSrcEdge == edge;
			if(!isSrcDerived)
				current += vvpre + src.getName() + " = " + evpre + edge.getName() + ".src ";

			DNode trg = edge.getDTarget();
			DArrow theTrgEdge = derivedByTarget.get(trg);
			boolean isTrgDerived = theTrgEdge != null && theTrgEdge == edge;
			if(!isTrgDerived){
				if(!isSrcDerived)
					current += "and ";
				current += vvpre + trg.getName() + " = " + evpre + edge.getName() + ".trg ";
			}
			if(!current.isEmpty())
				strings.add(current);
		}
		for(int i = 0; i < strings.size(); i++){
			buffer.append(strings.get(i));
			if(i != strings.size() - 1)
				buffer.append("and ");
		}
		List<DNode> changedNodes = new ArrayList<DNode>();
		for(DNode node : nodes)
			if(!commonNodes.contains(node))
				changedNodes.add(node);
		if(changedNodes.size() > 0)
			buffer.append(LINE + "and ");
		for(int i = 0; i < changedNodes.size(); i++){
			DNode node = changedNodes.get(i);
			buffer.append("no " + vvpre + node.getName()  + ".to ");
			if(i < changedNodes.size() - 1)
				buffer.append("and ");
		}
		
		List<DArrow> changedArrows = new ArrayList<DArrow>();
		for(DArrow arrow : arrows)
			if(!commonArrows.contains(arrow))
				changedArrows.add(arrow);
		if(!changedArrows.isEmpty())
			buffer.append(LINE + "and ");
		for(int i = 0; i < changedArrows.size(); i++){
			DArrow arrow = changedArrows.get(i);
			buffer.append("no " + evpre + arrow.getName() + ".to ");
			if(i < changedArrows.size() - 1)
				buffer.append("and ");
		}
		
		if(commonNodes.size() - someNodes.size() > 0)
			buffer.append(LINE + "and ");
		for(int i = 0; i < commonNodes.size(); i++){
			DNode node = commonNodes.get(i);
			buffer.append("some " + vvpre + node.getName()  + ".to ");
			if(i < commonNodes.size() - 1)
				buffer.append("and ");
		}
		
		if(!commonArrows.isEmpty())
			buffer.append(LINE + "and ");
		for(int i = 0; i < commonArrows.size(); i++){
			DArrow arrow = commonArrows.get(i);
			buffer.append("some " + evpre + arrow.getName() + ".to ");
			if(i < commonArrows.size() - 1)
				buffer.append("and ");
		}
		buffer.append(")" + LINE);
		return buffer.toString();
	}

	public  void translateRelatedMatch(List<DArrow> arrows, List<DNode> nodes, List<DNode> commonNodes, List<DArrow> commonArrows, boolean delete) {
		boolean nochange = nodes.size() == commonNodes.size() && arrows.size() == commonArrows.size();
		buffer.append(nochange ? "some " : "one ");
		Map<DNode, DArrow> derivedBySource = new HashMap<DNode, DArrow>(), derivedByTarget = new HashMap<DNode, DArrow>();
		for (Iterator<DArrow> iterator = arrows.iterator(); iterator.hasNext();) {
			DArrow dArrow = (DArrow) iterator.next();
			buffer.append("e_" + dArrow.getName() + ":" + arrowName(dArrow.getArrow().getTypeArrow()) + "&");
			buffer.append(commonArrows.contains(dArrow) ? COMMONARROW : (delete? DELETEARROW : ADDARROW));
			if(iterator.hasNext())
				buffer.append(", ");
			DNode src = dArrow.getDSource(), trg = dArrow.getDTarget();
			if(!derivedBySource.containsKey(src) && !derivedByTarget.containsKey(src))
				derivedBySource.put(src, dArrow);
			if(!derivedBySource.containsKey(trg) && !derivedByTarget.containsKey(trg))
				derivedByTarget.put(trg, dArrow);
		}
		if(arrows.size() == 0){
			DNode dNode = nodes.get(0);
			buffer.append(nodeName(dNode.getNode().getTypeNode()) + "&");
			buffer.append((commonNodes.contains(dNode) ? COMMONNODE : (delete? DELETENODE : ADDNODE)) + LINE);
			return;
		}
		buffer.append(" |" + LINE + "let ");
		for (Iterator<Entry<DNode, DArrow>> iterator = derivedBySource.entrySet().iterator(); iterator.hasNext();) {
			Entry<DNode, DArrow> entry = (Entry<DNode, DArrow>) iterator.next();
			buffer.append("n_" + entry.getKey().getName() + " = e_" + entry.getValue().getName() + ".src");
			if(iterator.hasNext()) 
				buffer.append(", ");
		}
		if(!derivedBySource.isEmpty() && !derivedByTarget.isEmpty())
			buffer.append(", ");
		for (Iterator<Entry<DNode, DArrow>> iterator = derivedByTarget.entrySet().iterator(); iterator.hasNext();) {
			Entry<DNode, DArrow> entry = (Entry<DNode, DArrow>) iterator.next();
			buffer.append("n_" + entry.getKey().getName() + " = e_" + entry.getValue().getName() + ".trg");
			if(iterator.hasNext())
				buffer.append(", ");
		}
		buffer.append(" |" + LINE + "(");
		for (Iterator<DArrow> iterator = arrows.iterator(); iterator.hasNext();) {
			DArrow arrow = (DArrow) iterator.next();
			DNode src = arrow.getDSource(); 
			boolean isSrcDerived = derivedBySource.get(src) == arrow;
			if(!isSrcDerived)
				buffer.append("n_" + src.getName() + " = e_" + arrow.getName() + ".src ");

			DNode trg = arrow.getDTarget();
			boolean isTrgDerived = derivedByTarget.get(trg) == arrow;
			if(!isTrgDerived){
				if(!isSrcDerived) 
					buffer.append("and ");
				buffer.append("n_" + trg.getName() + " = e_" + arrow.getName() + ".trg ");
			}
			if(iterator.hasNext() && (!isSrcDerived || !isTrgDerived))
				buffer.append("and ");
		}
		
		List<DNode> changedNodes = new ArrayList<DNode>();
		for(DNode node : nodes)
			if(!commonNodes.contains(node))
				changedNodes.add(node);
		if(changedNodes.size() > 0)
			buffer.append(LINE + "and ");
		for(int i = 0; i < changedNodes.size(); i++){
			DNode node = changedNodes.get(i);
			buffer.append("n_" + node.getName()  + " in " + nodeName(node.getNode().getTypeNode()) + "&" +  (delete ? DELETENODE : ADDNODE));
			if(i < changedNodes.size() - 1)
				buffer.append(" and ");
		}
		
		if(commonNodes.size()  > 0)
			buffer.append(LINE + "and ");
		for(int i = 0; i < commonNodes.size(); i++){
			DNode node = commonNodes.get(i);
			buffer.append("n_" + node.getName()  + " in " + nodeName(node.getNode().getTypeNode()) + "&" +  COMMONNODE);
			if(i < commonNodes.size() - 1)
				buffer.append(" and ");
		}
		
		buffer.append(")" + LINE);
	}


	public  void translateNodeUnchanged(EList<DNode> nodes, EList<DNode> commonNodes, String tpre,  EList<DNode> all){
		List<DNode> hide = new ArrayList<DNode>();
		hide.addAll(all);
		for(DNode node : nodes){
			if(!commonNodes.contains(node)){
				DNode type = node.getDType();
				if(hide.contains(type))
					hide.remove(type);
			}
		}
		for(DNode node : hide)
			buffer.append("no " + nodeName(node.getNode()) + "&" + tpre + LINE);
	}
	public  void translateArrowUnchanged(EList<DArrow> arrows, EList<DArrow> commonArrows, String tpre,  EList<DArrow> all){
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
			buffer.append("no " + arrowName(arrow.getArrow()) + "&" + tpre + LINE);
	}
	public  void translateNodeMulti(EList<DNode> nodes, EList<DNode> commonNodes, String tpre){
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
		for(Entry<DNode, Integer> entry : counters.entrySet())
			buffer.append("#" + nodeName(entry.getKey().getNode()) + "&" + tpre + " = " + entry.getValue() + LINE);
	}
	public  void translateArrowMulti(EList<DArrow> arrows, EList<DArrow> commonArrows, String tpre){
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
		for(Entry<DArrow, Integer> entry : counters.entrySet())
			buffer.append("#" + arrowName(entry.getKey().getArrow()) + "&" + tpre + " = " + entry.getValue() + LINE);
	}
	public void translate(){
		nodeTypes();
		arrowTypes();
		ruleTypes();
		graphType();
		transType();
		pre_no_dangle_arrow();
		for(Production rule : rules)
			pre_rule(rule, dGraph);
		pre_trans_general();
		pre_source_valid();
		fact(rules);
	}
	public TranslateToAlloy(Transform transform){
		dGraph = transform.getElementTypeGraph().getDGraph();
		rules = transform.getRules();
	}
	
	public Object getBuffer() {
		return buffer;
	}

}
