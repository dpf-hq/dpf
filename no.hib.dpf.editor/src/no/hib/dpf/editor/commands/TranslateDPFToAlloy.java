package no.hib.dpf.editor.commands;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.ValidatorType;
import no.hib.dpf.core.impl.PredicateImpl;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;

public class TranslateDPFToAlloy {

	/*
	 * Graph structure to alloy specification
	 */

	static public  final String LINE = System.lineSeparator();
	static public  final String NP = "N";
	static public  final String AP = "E";
	static public  final String SIG = "sig ";

	private String nodes = null;
	private String arrows = null;
	private StringBuffer buffer = new StringBuffer();
	private DGraph dGraph = null;
	private DSpecification model = null;

	public  String nodeSig(Node node){ return NP + node.getName(); }
	public  String edgeSig(Arrow node){ return AP + node.getName(); }

	//signatures for nodes
	public  void nodeSigs(){
		buffer.append("//signatures for nodes" + LINE);
		for(Node node : dGraph.getGraph().getNodes()){
			Constraint cenum = null;
			for (Constraint iter : node.getConstraints()) 
				if(iter.getPredicate().getSymbol().equals("enum"))
					cenum = iter;
			if(cenum != null){
				String literals = cenum.getParameters();
				String LITERALS = "literal:{";
				buffer.append("abstract " + SIG + nodeSig(node) + "{}" + LINE);
				literals = literals.substring(literals.indexOf(LITERALS) + LITERALS.length(), literals.length() - 1);
				String[] liters = literals.split(",");
				buffer.append("lone " + SIG + "N" + liters[0]);
				for(int index = 1; index < liters.length; ++index)
					buffer.append(", N" + liters[index].trim());
				buffer.append(" extends " + nodeSig(node) + "{}" + LINE);
			}else
				buffer.append(SIG + nodeSig(node) + "{}" + LINE);	
		}
		buffer.append(LINE);
	}
	//signatures for edges
	public void edgeSigs(){
		buffer.append("//signatures for edges" + LINE);
		for(Arrow arrow : dGraph.getGraph().getArrows())
			buffer.append(SIG + edgeSig(arrow) + "{src:one " + nodeSig(arrow.getSource()) + ", trg:one " + nodeSig(arrow.getTarget()) + "}" + LINE);
		buffer.append(LINE);
	}

	//The universal node signatures
	protected  String nodeUniv(){
		if(nodes != null) return nodes;
		nodes = "";
		List<Node> ns = dGraph.getGraph().getNodes();
		if(ns.size() > 0) nodes += nodeSig(ns.get(0));
		for(int index = 1; index < ns.size(); ++index)
			nodes += "+" + nodeSig(ns.get(index));
		return nodes;
	}
	//The universal edge signatures
	protected  String edgeUniv(){
		if(arrows != null) return arrows;
		arrows = "";
		List<Arrow> edges = dGraph.getGraph().getArrows();
		if(edges.size() > 0) arrows += edgeSig(edges.get(0));
		for(int index = 1; index < edges.size(); ++index)
			arrows +=  "+" + edgeSig(edges.get(index));
		return arrows;
	}
	//The graph signature
	public  void graphSig(){
		buffer.append(SIG + "Graph{ns:set ");
		buffer.append(nodeUniv());
		buffer.append(", es:set ");
		buffer.append(edgeUniv());
		buffer.append("}" + LINE + LINE);
	}

	//In a graph, the source and target node of each contained edge should be also contained by the graph  
	public void isGraph(){
		buffer.append("//In a graph, the source and target node of each contained edge should be also contained by the graph" + LINE);
		buffer.append("pred isGraph[g:Graph]{" + LINE);
		for (Arrow arrow : dGraph.getGraph().getArrows())
			buffer.append("\tall e:" + edgeSig(arrow) + "&g.es|(e.src in g.ns and e.trg in g.ns)" + LINE);
		buffer.append("}" + LINE + LINE);
	}
	//The general constraints of a transformation
	private String GRAPH_NODES = "&g.ns", GRAPH_EDGES = "&g.es";

	/**
	 * Each source model satisfies all the constraints on the metamodel. In this way, every source model is valid.<br>
	 * 1. Each arrow has a default constraint multi[0,1]. Translate the default constraint first.<br>
	 * 2. Then translate the other constraint associated with the metamodel.<br>
	 */
	public void pre_source_valid(){
		buffer.append("pred valid[g:Graph]{" + LINE);

		for(Arrow arrow : model.getSpecification().getGraph().getArrows()){
			boolean isMult = false;
			for(Constraint constraint : arrow.getConstraints()){
				if(constraint.getPredicate() == DPFConstants.ARROW_MULTI){
					isMult = true;
					break;
				}
			}
			if(!isMult)
				buffer.append(translateArrowMultiplicity(arrow, GRAPH_NODES, GRAPH_EDGES));
		}
		for(Constraint constraint : model.getSpecification().getConstraints()){
			Predicate predicate  = constraint.getPredicate();
			if(predicate.getSymbol().equals("enum"))
				continue;
			else if(predicate == DPFConstants.INJECTIVE)
				buffer.append(translateInjective(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.SURJECTIVE)
				buffer.append(translateSurjective(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.ARROW_MULTI)
				buffer.append(translateArrowMultiplicity(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.NODE_MULTI)
				buffer.append(translateNodeMultiplicity(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.XOR)
				buffer.append(translateXOR(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.XOR4)
				buffer.append(translateXOR4(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.MERGE_NAND)
				buffer.append(translateMergeNAND(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.SPLIT_NAND)
				buffer.append(translateSplitNAND(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.REFLEXIVE)
				buffer.append(translateReflexive(constraint, GRAPH_NODES, GRAPH_EDGES));
			else if(predicate == DPFConstants.IRREFLEXIVE)
				buffer.append(translateIrreflexive(constraint, GRAPH_NODES, GRAPH_EDGES));
			else 
				buffer.append(translateGeneral(constraint, GRAPH_NODES, GRAPH_EDGES));
		}
		buffer.append("}" + LINE);
	}
	private Object translateIrreflexive(Constraint constraint,
			String gRAPH_NODES2, String arrows) {
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "reflexive on " + arrow +  LINE;
		return result + "no e:(" + AP + arrow.getName() + arrows + ")| e.src = e.trg" + LINE; 
	}
	private String translateGeneral(Constraint constraint, String gRAPH_NODES2, String arrows2) {
		Predicate predicate = constraint.getPredicate();
		if(predicate.getValidator().getType() == ValidatorType.ALLOY)
		{
			GraphHomomorphism mapping = constraint.getMappings();
			Map<String,String> nodeHash = new HashMap<String,String>(), arrowHash = new HashMap<String,String>();
			for(Entry<Arrow, Arrow> entry : mapping.getArrowMapping().entrySet())
				arrowHash.put(entry.getKey().getName(), entry.getValue().getName());
			for(Entry<Node, Node> entry : mapping.getNodeMapping().entrySet())
				nodeHash.put(entry.getKey().getName(), entry.getValue().getName());
			String alloy = predicate.getValidator().getValidator();
			String real = "";
			int first = 0, second = 0;
			while(first < alloy.length()){
				first = alloy.indexOf("$", first);
				if(first == -1) {real += alloy.substring(second); break;}
				String add = alloy.substring(second, first);
				second = alloy.indexOf("$", first + 1);
				if(second == -1) return "";
				real += add;
				String variable = alloy.substring(first + 1, second);
				if(nodeHash.containsKey(variable)){
					real += NP + nodeHash.get(variable) + gRAPH_NODES2;
				}else if(arrowHash.containsKey(variable)){
					real += AP + arrowHash.get(variable) + arrows2;
				}else return "";
				first = second = second + 1;
			}
			return real + LINE;
		}
		return "";
	}
	private String translateReflexive(Constraint constraint, String nodes, String arrows) {
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "reflexive on " + arrow +  LINE;
		return result + "all e:(" + AP + arrow.getName() + arrows + ")| e.src = e.trg" + LINE; 
	}
	private String translateSplitNAND(Constraint constraint, String nodes, String arrows) {
		Node z = getNode(constraint, "Z");
		Arrow zx = getArrow(constraint, "ZX"), zy = getArrow(constraint, "ZY");
		String result = "//" + "NAND constraint between " + zx + " and " + zy + LINE;
		result += "all n:(" + NP + z.getName() + nodes + ") | let e1 = (some e : " + AP + zx.getName() + 
				arrows + " | e.src = n), e2=(some e : " + AP + zy.getName() + arrows + " | e.src = n)|not(e1 and e2)" + LINE;
		return result;
	}
	private String translateMergeNAND(Constraint constraint, String nodes, String arrows) {
		Node target = getNode(constraint, "Z");
		Arrow xz = getArrow(constraint, "XZ"), yz = getArrow(constraint, "YZ");
		String result = "//" + "NAND constraint between " + xz + " and " + yz + LINE;
		result += "all n:(" + NP + target.getName() + nodes + ") | let e1 = (some e : " + AP + xz.getName() + 
				arrows + " | e.trg = n), e2=(some e : " + AP + yz.getName() + arrows + " | e.trg = n)|not(e1 and e2)" + LINE;
		return result;
	}
	private String translateXOR4(Constraint constraint, String nodes, String arrows) {
		Node source = getNode(constraint, "X");
		Arrow xy1 = getArrow(constraint, "XY1"), xy2 = getArrow(constraint, "XY2"), xy3 = getArrow(constraint, "XY3"), xy4 = getArrow(constraint, "XY4");
		String result = "//" + "XOR constraint between " + xy1 + ","+ xy2 + ","+ xy3 + " and " + xy4 + LINE;
		result += "all n:(" + NP + source.getName() + nodes + ") | let e1=(some e : " + AP + xy1.getName() + 
				arrows + "|e.src = n), e2=(some e : " + AP + xy2.getName() + 
				arrows + "|e.src = n), e3=(some e : " + AP + xy3.getName() + 
				arrows + "|e.src = n), e4=(some e : " + AP + xy4.getName() + 
				arrows + "|e.src = n)|(e1 or e2 or e3 or e4) and not(((e1 and (e2 or e3 or e4)) or (e2 and (e1 or e3 or e4)) or (e3 and (e2 or e1 or e4)) or (e4 and (e2 or e3 or e1))))" + LINE;
		return result;
	}
	private String translateXOR(Constraint constraint, String nodes, String arrows) {
		Node source = getNode(constraint, "Z");
		Arrow zx = getArrow(constraint, "ZX"), zy = getArrow(constraint, "ZY");
		String result = "//" + "XOR constraint between " + zx + " and " + zy + LINE;
		result += "all n:(" + NP + source.getName() + nodes + ") | let e1 = (some e : " + AP + zx.getName() + 
				arrows + " | e.src = n), e2=(some e : " + AP + zy.getName() + arrows + " | e.src = n)|(e1 or e2) and not(e1 and e2)" + LINE;
		return result;
	}
	private String translateNodeMultiplicity(Constraint constraint, String nodes, String arrows) {
		Node source = getNode(constraint, "X");
		String result = "//" + "mulitplicity on " + source.getName() + " " + constraint.getParameters() + LINE;
		Map<String, String> parameters = PredicateImpl.getParameterMap(constraint.getParameters());
		if(parameters == null) return result;
		String min = parameters.get("min");
		String max = parameters.get("max");
		result += "let count = #" + NP + source.getName() + 
				nodes + " | count>=" + min;
		if(!(max.equals("*") || max.equals("-1")))
			result += " and count <=" + max;
		return result + LINE; 
	}
	private String translateArrowMultiplicity(Constraint constraint, String nodes, String arrows) {
		Node source = getNode(constraint, "X");
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "mulitplicity on " + arrow +  constraint.getParameters() +  LINE;
		Map<String, String> parameters = PredicateImpl.getParameterMap(constraint.getParameters());
		if(parameters == null) return result;
		String min = parameters.get("min");
		String max = parameters.get("max");
		result += "all n:(" + NP + source.getName() + nodes + ")| let count = #{e:(" + AP + arrow.getName() + 
				arrows + ")| e.src = n}| count>=" + min;
		if(!(max.equals("*") || max.equals("-1")))
			result += " and count <=" + max;
		return result + LINE; 
	}
	private String translateSurjective(Constraint constraint, String nodes, String arrows) {
		Node source = getNode(constraint, "Y");
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "surjective on " + arrow +  LINE;
		return result + "all n:(" + NP + source.getName() + nodes + ")| some e:(" + AP + arrow.getName() + 
				arrows + ")| e.trg = n" + LINE;
	}
	private String translateArrowMultiplicity(Arrow arrow, String nodes, String arrows) {
		String result = "//" + "mulitplicity on " + arrow +  "[0,1]" + LINE;
		return result + "all n:(" + NP + arrow.getSource().getName() + nodes + ")| lone e:(" + AP + arrow.getName()+ 
				arrows + ")|e.src=n" + LINE;
	}
	private Node getNode(Constraint constraint, String name){
		return constraint.getMappings().getNodeMapping().get(constraint.getPredicate().getShape().getNodeByName(name));
	}
	private Arrow getArrow(Constraint constraint, String name){
		return constraint.getMappings().getArrowMapping().get(constraint.getPredicate().getShape().getArrowByName(name));
	}
	private String translateInjective(Constraint constraint, String nodes, String arrows) {
		Node source = getNode(constraint, "X");
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "check injective on " + arrow+  LINE;
		return result + "all n:(" + NP + source.getName() + nodes + ")| no e1, e2:(" + AP + arrow.getName() + 
				arrows + ")| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)" + LINE; 
	}
	/*
	 * Get the connected subgraphs from a graph
	 */
	//	private void getConnectedSubgraphs(List<DNode> nodes, List<DArrow> arrows, List<Object> subgraphs){
	//		List<DNode> unvisited = new ArrayList<DNode>();
	//		List<DArrow> unvisitedEdge = new ArrayList<DArrow>();
	//		unvisited.addAll(nodes);
	//		unvisitedEdge.addAll(arrows);
	//		while(!unvisited.isEmpty()){
	//			DNode visit = unvisited.get(0);
	//			List<DNode> related = new ArrayList<DNode>();
	//			related.add(visit);
	//			unvisited.remove(visit);
	//			List<DNode> subn = new ArrayList<DNode>();
	//			List<DArrow> suba = new ArrayList<DArrow>();
	//			do{
	//				DNode cur = related.get(0);
	//				related.remove(cur);
	//				subn.add(cur);
	//				if(unvisited.contains(cur))
	//					unvisited.remove(cur);
	//				for(DArrow arrow : cur.getDIncomings()){
	//					if(!arrows.contains(arrow))
	//						continue;
	//					if(!suba.contains(arrow)){
	//						suba.add(arrow);
	//						unvisitedEdge.remove(arrow);
	//					}
	//					DNode source = arrow.getDSource();
	//					if(!related.contains(source) && !subn.contains(source) && nodes.contains(source))
	//						related.add(source);
	//				}
	//				for(DArrow arrow : cur.getDOutgoings()){
	//					if(!arrows.contains(arrow))
	//						continue;
	//					if(!suba.contains(arrow)){
	//						suba.add(arrow);
	//						unvisitedEdge.remove(arrow);
	//					}
	//					DNode target = arrow.getDTarget();
	//					if(!related.contains(target) && !subn.contains(target) && nodes.contains(target))
	//						related.add(target);
	//				}					
	//			}while(!related.isEmpty());
	//			subgraphs.add(subn);
	//			subgraphs.add(suba);
	//		}
	//		for(DArrow arrow : unvisitedEdge){
	//			List<DNode> subn = new ArrayList<DNode>();
	//			List<DArrow> suba = new ArrayList<DArrow>();
	//			suba.add(arrow);
	//			subgraphs.add(subn);
	//			subgraphs.add(suba);
	//		}
	//
	//	}

	/**
	 * General facts about the system<br>
	 * 1. All the graphs involving transformations equals to the Graph instances<br>
	 * 2. All the nodes and the edges contained by the graphs instances equal to the nodes and the edges instances<br>
	 * 3. All the transformation should satisfy the following constraints:<br>
	 *    a. no dangle arrows after the transformation<br>
	 *    b. general constraints about a transformation,  {@link #pre_trans_general()}<br>
	 *    c. the source model is valid<br>
	 *    d. the transformation applies one of the rules<br>
	 */
	public void fact(){
		buffer.append("//general constraints for transformations" + LINE);
		buffer.append("fact{" + LINE);
		buffer.append("\tall graph:Graph|isGraph[graph] and valid[graph]" + LINE);
		buffer.append("\tno disjoint g1, g2:Graph|g1.ns=g2.ns and g1.es=g2.es" + LINE);
		buffer.append("\tGraph.ns=" + nodeUniv() + LINE);
		buffer.append("\tGraph.es=" + edgeUniv() + LINE);
		buffer.append("}" + LINE + LINE);
	}

	/*
	 * the entrance method to encode a model transformation system
	 */
	public void translate(){
		nodeSigs();
		edgeSigs();
		graphSig();
		isGraph();
		pre_source_valid();
		fact();
		run_command();
		buffer.append("run {} for 5 but exactly 1 Graph");
	}
	private String targetNodes = "&t.tm.ns", targetArrows = "&t.tm.es";
	private void run_command() {
		for(Arrow arrow : model.getSpecification().getGraph().getArrows()){
			boolean isMult = false;
			for(Constraint constraint : arrow.getConstraints()){
				if(constraint.getPredicate() == DPFConstants.ARROW_MULTI){
					isMult = true;
					break;
				}
			}
			if(!isMult)
				commands.add(translateArrowMultiplicity(arrow, targetNodes, targetArrows));
		}
		for(Constraint constraint : model.getSpecification().getConstraints()){
			Predicate predicate  = constraint.getPredicate();
			if(predicate == DPFConstants.INJECTIVE)
				commands.add(translateInjective(constraint, targetNodes, targetArrows));
			else if(predicate == DPFConstants.SURJECTIVE)
				commands.add(translateSurjective(constraint, targetNodes, targetArrows));
			else if(predicate == DPFConstants.ARROW_MULTI)
				commands.add(translateArrowMultiplicity(constraint, targetNodes, targetArrows));
			else if(predicate == DPFConstants.NODE_MULTI)
				commands.add(translateNodeMultiplicity(constraint, targetNodes, targetArrows));
			else if(predicate == DPFConstants.XOR)
				commands.add(translateXOR(constraint, targetNodes, targetArrows));
			else if(predicate == DPFConstants.XOR4)
				commands.add(translateXOR4(constraint, targetNodes, targetArrows));
			else if(predicate == DPFConstants.MERGE_NAND)
				commands.add(translateMergeNAND(constraint, targetNodes, targetArrows));
			else if(predicate == DPFConstants.SPLIT_NAND)
				commands.add(translateSplitNAND(constraint, targetNodes, targetArrows));
			else if(predicate == DPFConstants.REFLEXIVE)
				commands.add(translateReflexive(constraint, targetNodes, targetArrows));
		}
	}

	/**
	 * translate Model to Alloy
	 */
	public TranslateDPFToAlloy(DSpecification model){
		this.model  = model;
		dGraph = model.getDGraph();
	}

	public List<String> commands = new ArrayList<String>();
	String current = null;

	public void writeToFile(File file) throws IOException{
		FileWriter writer = new FileWriter(file);
		writer.write(buffer.toString());
		writer.close();
	}
}
