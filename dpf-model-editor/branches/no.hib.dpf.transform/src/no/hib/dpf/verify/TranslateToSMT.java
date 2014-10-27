package no.hib.dpf.verify;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.impl.PredicateImpl;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;

public class TranslateToSMT {

	/*
	 * Graph structure to alloy specification
	 */

	static public  final String LINE = System.lineSeparator();
	static public  final String NP = "N";
	static public  final String AP = "E";
	static public  final String DECLARE_FUN = "declare-fun ";
	static public  final String ASSERT = "assert ";
	private StringBuffer buffer = new StringBuffer();
	private DGraph dGraph = null;
	private List<Production> rules = null;
	private DSpecification dType = null;

	static private String COMEDGE = "(t.sm.es-t.des)";
	static private String COMNODE = "(t.sm.ns-t.dns)";
	static private String DELEDGE = "t.des";
	static private String DELNODE = "t.dns";
	static private String ADDEDGE = "t.aes";
	static private String ADDNODE = "t.ans";

	public  String nodeSig(Node node){ return NP + node.getName(); }
	public  String edgeSig(Arrow node){ return AP + node.getName(); }

	//signatures for nodes
	public  void nodeSigs(){
		List<Node> nodes = dGraph.getGraph().getNodes();
		buffer.append(";;functions for nodes" + LINE);		
		for(Node node : nodes)
			buffer.append("(" + DECLARE_FUN + nodeSig(node) + " (Int) Bool)" + LINE);
		buffer.append("(define-fun NODE ((x Int)) Bool (or");
		for(Node node : nodes)
			buffer.append(" ("  + nodeSig(node) + " x)");
		buffer.append("))" + LINE);
		buffer.append("(" + ASSERT + "(! (forall ((x Int)) (and " + LINE);
		for (int i = 0; i < nodes.size(); i++) {
			for (int j = i + 1; j < nodes.size(); j++) {
				Node first = nodes.get(i), second = nodes.get(j);
				buffer.append(" (not (and ");
				buffer.append(" ("  + nodeSig(first) + " x)");
				buffer.append(" ("  + nodeSig(second) + " x)");
				buffer.append("))" + LINE);
			}
		}
		buffer.append(")) :named node-types-disjoint))");
		buffer.append(LINE + LINE);
	}
	//signatures for edges
	public void edgeSigs(){
		EList<Arrow> edges = dGraph.getGraph().getArrows();
		buffer.append(";;functions for edges" + LINE);
		
		for(Arrow arrow : edges)
			buffer.append("(" + DECLARE_FUN + edgeSig(arrow) + " (Int) Bool)" + LINE);
		buffer.append("(define-fun EDGE ((x Int)) Bool (or");
		for(Arrow arrow : edges)
			buffer.append(" ("  + edgeSig(arrow) + " x)");
		buffer.append("))" + LINE);
		buffer.append("(assert (! (forall ((x Int)) (not (and (EDGE x) (NODE x)))) :named NOT-NODE-EDGE))" + LINE);
		buffer.append("(" + ASSERT + "(! (forall ((x Int)) (and " + LINE);
		for (int i = 0; i < edges.size(); i++) {
			for (int j = i + 1; j < edges.size(); j++) {
				Arrow first = edges.get(i), second = edges.get(j);
				buffer.append(" (not (and ");
				buffer.append(" ("  + edgeSig(first) + " x)");
				buffer.append(" ("  + edgeSig(second) + " x)");
				buffer.append("))" + LINE);
			}
		}
		buffer.append(")) :named edge-types-disjoint))" + LINE + LINE);
		
		buffer.append("(" + DECLARE_FUN + " SRC (Int) Int)" + LINE);
		buffer.append("(" + DECLARE_FUN + " TRG (Int) Int)" + LINE);
		buffer.append("(" + ASSERT + " (! (forall ((e Int) (n Int)) (=> (or (= (SRC e) n) (= (TRG e) n)) (ite (EDGE e) (NODE n) (= n NULL)))) :named src-and-trg-domain-node-value-edge))" + LINE);
		buffer.append("(" + ASSERT + " (! (forall ((e Int) (n Int)) (=> (= (SRC e) n) (and " + LINE);
		for(Arrow arrow : edges)
			buffer.append("(=> ("  + edgeSig(arrow) + " e) (" + nodeSig(arrow.getSource()) + " n))" + LINE);
		buffer.append("(=> (not (EDGE e)) (= n NULL))))) :named src-domain-value))" + LINE);
		buffer.append("(" + ASSERT + " (! (forall ((e Int) (n Int)) (=> (= (TRG e) n) (and " + LINE);
		for(Arrow arrow : edges)
			buffer.append("(=> ("  + edgeSig(arrow) + " e) (" + nodeSig(arrow.getTarget()) + " n))" + LINE);
		buffer.append("(=> (not (EDGE e)) (= n NULL))))) :named trg-domain-value))" + LINE + LINE);		
	}

	public void ruleSigs(){
		for(Production iter : rules){
			buffer.append("(declare-const rule-" + iter.getName() + " Int)" + LINE);
		}
		
		int index = 1;
		for(Production iter : rules){
			buffer.append("(assert (= rule-" + iter.getName() + " " + index++ + "))" + LINE);
		}
		index = 1;
		buffer.append("(define-fun RULE ((x Int)) Bool (or");
		for(Production iter : rules)
			buffer.append(" (= rule-" + iter.getName() + " x)");
		buffer.append("))" + LINE);
		buffer.append(LINE);
	}
	//The graph signature
	public  void graphSig(){
		buffer.append("(" + DECLARE_FUN + "GRAPH (Int) Bool)" + LINE);
		buffer.append("(assert (! (forall ((x Int)) (and (not (and (EDGE x) (GRAPH x))) (not (and (GRAPH x) (NODE x))))) :named NOT-GRAPH-NODE-EDGE))" + LINE + LINE);
		buffer.append("(" + DECLARE_FUN + "nodes (Int Int) Bool)" + LINE);
		buffer.append("(" + DECLARE_FUN + "edges (Int Int) Bool)" + LINE);
		buffer.append("(assert (! (forall ((g Int) (n Int)) (=> (nodes g n) (and (GRAPH g) (NODE n)))) :named nodes-domain-grpah-value-node))" + LINE);
		buffer.append("(assert (! (forall ((g Int) (e Int)) (=> (edges g e) (and (GRAPH g) (EDGE e)))) :named edges-domain-grpah-value-edge))" + LINE);
		buffer.append("(assert (! (forall ((g Int) (e Int)) (=> (edges g e) (and (nodes g (SRC e)) (nodes g (TRG e))))) :named to-be-graph))" + LINE + LINE);
		
	}
	//The transformation signature
	public  void tranSig(){
		buffer.append("(" + DECLARE_FUN + "TRANS (Int) Bool)" + LINE);
		buffer.append("(assert (! (forall ((x Int)) (and (not (and (TRANS x) (GRAPH x))) (not (and (EDGE x) (TRANS x))) (not (and (TRANS x) (NODE x))))) :named NOT-TRANS-GRAPH-NODE-EDGE))" + LINE + LINE);
		buffer.append("(assert (not (or (NODE NULL) (EDGE NULL) (GRAPH NULL) (TRANS NULL))))" + LINE + LINE);
		buffer.append("(" + DECLARE_FUN + "rule (Int) Int)" + LINE);
		buffer.append("(assert (! (forall ((t Int) (r Int)) (=> (= (rule t) r) (ite (TRANS t) (RULE r) (= r NULL)))) :named rule-domain-trans-value-graph))");
		buffer.append("(" + DECLARE_FUN + "sm (Int) Int)" + LINE);
		buffer.append("(" + DECLARE_FUN + "tm (Int) Int)" + LINE);
		buffer.append("(" + DECLARE_FUN + "dns (Int Int) Bool)" + LINE);
		buffer.append("(" + DECLARE_FUN + "ans (Int Int) Bool)" + LINE);
		buffer.append("(" + DECLARE_FUN + "des (Int Int) Bool)" + LINE);
		buffer.append("(" + DECLARE_FUN + "aes (Int Int) Bool)" + LINE);
		buffer.append("(assert (! (forall ((t Int) (g Int)) (=> (= (sm t) g) (ite (TRANS t) (GRAPH g) (= g NULL)))) :named sm-domain-trans-value-graph))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (g Int)) (=> (= (tm t) g) (ite (TRANS t) (GRAPH g) (= g NULL)))) :named tm-domain-trans-value-graph))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (n Int)) (=> (dns t n) (and (TRANS t) (NODE n)))) :named dns-domain-trans-value-node))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (n Int)) (=> (ans t n) (and (TRANS t) (NODE n)))) :named ans-domain-trans-value-node))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (e Int)) (=> (des t e) (and (TRANS t) (EDGE e)))) :named des-domain-trans-value-edge))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (e Int)) (=> (aes t e) (and (TRANS t) (EDGE e)))) :named aes-domain-trans-value-edge))" + LINE);
		buffer.append("(assert (! (forall ((t Int)) (=> (TRANS t) (exists ((x Int)) (or (dns t x) (ans t x) (des t x) (aes t x))))) :named something-changed))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (n Int)) (=> (dns t n) (nodes (sm t) n))) :named deleted-nodes-belong-source))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (n Int)) (=> (ans t n) (nodes (tm t) n))) :named added-nodes-belong-source))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (e Int)) (=> (des t e) (nodes (sm t) e))) :named deleted-edges-belong-target))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (e Int)) (=> (aes t e) (nodes (tm t) e))) :named added-edges-belong-target))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (n Int)) (not (and (dns t n) (ans t n)))) :named no-deleted-added-nodes))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (e Int)) (not (and (des t e) (aes t e)))) :named no-deleted-added-edges))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (n Int)) (= (and (not (dns t n)) (nodes (sm t) n)) (and (not (ans t n)) (nodes (tm t) n)))) :named not-changed-nodes-kept))" + LINE);
		buffer.append("(assert (! (forall ((t Int) (e Int)) (= (and (not (des t e)) (edges (sm t) e)) (and (not (aes t e)) (edges (tm t) e)))) :named not-changed-edges-kept))" + LINE);
	}

	/**
	 * Each source model satisfies all the constraints on the metamodel. In this way, every source model is valid.<br>
	 * 1. Each arrow has a default constraint multi[0,1]. Translate the default constraint first.<br>
	 * 2. Then translate the other constraint associated with the metamodel.<br>
	 */
	public void pre_source_valid(){
//		if(rules != null)
//			buffer.append("pred valid[g:Graph]{" + LINE);
//		else
//			buffer.append("fact graph_valid{" + LINE);

		for(Arrow arrow : dType.getSpecification().getGraph().getArrows()){
			boolean isMult = false;
			for(Constraint constraint : arrow.getConstraints()){
				if(constraint.getPredicate() == DPFConstants.ARROW_MULTI){
					isMult = true;
					break;
				}
			}
			if(!isMult)
				buffer.append(translateArrowMultiplicity(arrow));
		}
		for(Constraint constraint : dType.getSpecification().getConstraints()){
			Predicate predicate  = constraint.getPredicate();
			if(predicate == DPFConstants.INJECTIVE)
				buffer.append(translateInjective(constraint));
			else if(predicate == DPFConstants.SURJECTIVE)
				buffer.append(translateSurjective(constraint));
			else if(predicate == DPFConstants.ARROW_MULTI)
				buffer.append(translateArrowMultiplicity(constraint));
			else if(predicate == DPFConstants.NODE_MULTI)
				buffer.append(translateNodeMultiplicity(constraint));
			else if(predicate == DPFConstants.XOR)
				buffer.append(translateXOR(constraint));
			else if(predicate == DPFConstants.XOR4)
				buffer.append(translateXOR4(constraint));
			else if(predicate == DPFConstants.MERGE_NAND)
				buffer.append(translateMergeNAND(constraint));
			else if(predicate == DPFConstants.SPLIT_NAND)
				buffer.append(translateSplitNAND(constraint));
			else if(predicate == DPFConstants.REFLEXIVE)
				buffer.append(translateReflexive(constraint));
		}
		buffer.append(LINE);
	}
	private String translateReflexive(Constraint constraint) {
		Arrow arrow = getArrow(constraint, "XY");
		String result = ";;" + "reflexive on " + arrow +  LINE;
		String name = "REFLEX-" + arrow.getName(); 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((e Int)) (=> (and (edges g e) (" + edgeSig(arrow) + " e)) (= (SRC e) (TRG e)))))" + LINE; 
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private String translateSplitNAND(Constraint constraint) {
		Node z = getNode(constraint, "Z");
		Arrow zx = getArrow(constraint, "ZX"), zy = getArrow(constraint, "ZY");
		String result = ";;" + "NAND constraint between " + zx + " and " + zy + LINE;
		String name = "SPLIT-NAND-" + zx.getName() + "-" + zy.getName(); 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(z) + " n)) "
		+ "(not (exists ((e1 Int) (e2 Int)) (and (edges g e1) (edges g e2) (distinct e1 e2) (" + edgeSig(zx) + " e1) (" + edgeSig(zy) + " e2)"
		+ " (= (SRC e1) n) (= (SRC e1) n)))))))" +  LINE;
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private String translateMergeNAND(Constraint constraint) {
		Node target = getNode(constraint, "Z");
		Arrow xz = getArrow(constraint, "XZ"), yz = getArrow(constraint, "YZ");
		String result = ";;" + "NAND constraint between " + xz + " and " + yz + LINE;
		String name = "MERGE-NAND-" + xz.getName() + "-" + yz.getName(); 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(target) + " n)) "
		+ "(not (exists ((e1 Int) (e2 Int)) (and (edges g e1) (edges g e2) (distinct e1 e2) (" + edgeSig(xz) + " e1) (" + edgeSig(yz) + " e2)"
		+ " (= (TRG e1) n) (= (TRG e1) n)))))))" +  LINE;
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private String translateXOR4(Constraint constraint) {
		Node source = getNode(constraint, "X");
		Arrow xy1 = getArrow(constraint, "XY1"), xy2 = getArrow(constraint, "XY2"), xy3 = getArrow(constraint, "XY3"), xy4 = getArrow(constraint, "XY4");
		String result = ";;" + "XOR constraint between " + xy1 + ","+ xy2 + ","+ xy3 + " and " + xy4 + LINE;
		String name = "XOR4-" + xy1.getName() + "-" + xy2.getName() + "-" + xy3.getName() + "-" + xy4.getName(); 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(source) + " n)) (let ("
				+ LINE + "(e1 (exists ((e Int)) (and (edges g e) (" + edgeSig(xy1) + " e) (= (SRC e) n))))"  
				+ LINE + " (e2 (exists ((e Int)) (and (edges g e) (" + edgeSig(xy2) + " e) (= (SRC e) n))))"  
				+ LINE + " (e3 (exists ((e Int)) (and (edges g e) (" + edgeSig(xy3) + " e) (= (SRC e) n))))"  
				+ LINE + " (e4 (exists ((e Int)) (and (edges g e) (" + edgeSig(xy4) + " e) (= (SRC e) n))))" 
				+ ") (and (or e1 e2 e3 e4) (not (or (and e1 (or e2 e3 e4)) (and e2 (or e1 e3 e4)) "
				+ "(and e3 (or e2 e1 e4)) (and e4 (or e2 e3 e1)))))))))" + LINE;
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private String translateXOR(Constraint constraint) {
		Node source = getNode(constraint, "Z");
		Arrow zx = getArrow(constraint, "ZX"), zy = getArrow(constraint, "ZY");
		String result = ";;" + "XOR constraint between " + zx + " and " + zy + LINE;
		String name = "XOR-" + zx.getName() + "-" + zy.getName(); 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(source) + " n)) (let ("
				+ LINE + " (e1 (exists ((e Int)) (and (edges g e) (" + edgeSig(zx) + " e) (= (SRC e) n))))"  
				+ LINE + " (e2 (exists ((e Int)) (and (edges g e) (" + edgeSig(zy) + " e) (= (SRC e) n))))"  
				+ ") (and (or e1 e2) (not (and e1 e2)))))))" + LINE;
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private String translateNodeMultiplicity(Constraint constraint) {
		Node source = getNode(constraint, "X");
		String result = ";;" + "mulitplicity on " + source.getName() + " " + constraint.getParameters() + LINE;
		Map<String, String> parameters = PredicateImpl.getParameterMap(constraint.getParameters());
		if(parameters == null) return result;
		int min = Integer.valueOf(parameters.get("min"));
		String pmax = parameters.get("max");
		int max = 0;
		if(pmax.equals("*") || pmax.equals("-1")) max = -1;
		else max = Integer.valueOf(pmax) + 1;
		String name = "MULT-" + source.getName() + "-" + min + "-" + max; 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(source) + " n)) ";
		if(min > 0 && max > 0) result += " (and ";
		result += NodeMultiplicity(min, nodeSig(source));
		if(min > 0 && max > 0) result += " ";
		if(max > 0) result += " (not ";
		result += NodeMultiplicity(max, nodeSig(source));
		if(max > 0) result += ")";
		if(min > 0 && max > 0) result += ")";
		result += ")))" + LINE;
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private String translateArrowMultiplicity(Constraint constraint) {
		Node source = getNode(constraint, "X");
		Arrow arrow = getArrow(constraint, "XY");
		String result = ";;" + "mulitplicity on " + arrow +  constraint.getParameters() +  LINE;
		Map<String, String> parameters = PredicateImpl.getParameterMap(constraint.getParameters());
		if(parameters == null) return result;
		int min = Integer.valueOf(parameters.get("min"));
		String pmax = parameters.get("max");
		int max = 0;
		if(pmax.equals("*") || pmax.equals("-1")) max = -1;
		else max = Integer.valueOf(pmax) + 1;
		String name = "MULT-" + arrow.getName() + "-" + min + "-" + max; 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(source) + " n)) ";
		if(min > 0 && max > 0) result += " (and ";
		result += multiplicity(min, edgeSig(arrow));
		if(min > 0 && max > 0) result += " ";
		if(max > 0) result += " (not ";
		result += multiplicity(max, edgeSig(arrow));
		if(max > 0) result += ")";
		if(min > 0 && max > 0) result += ")";
		result += ")))" + LINE;
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private String multiplicity(int min, String arrow){
		String result = "";
		if(min > 0){
			result += "(exists ((e1 Int)";
			for(int index = 2; index <= min; index++)
				result += " (e" + index + " Int)";
			result += ") (and";
			for(int index = 1; index <= min; index++)
				result += " (edges g e" + index + ")  (" + arrow + " e" +  index + ")";
			if(min > 1){
				result += " (distinct";
				for(int index = 1; index <= min; index++)
					result += " e" +  index;
				result += ")";
			}
			for(int index = 1; index <= min; index++)
				result += " (= (SRC e" +  index + ") n)";
			result += "))";
		}
		return result;
	}
	private String NodeMultiplicity(int min, String node){
		String result = "";
		if(min > 0){
			result += "(exists ((n1 Int)";
			for(int index = 2; index <= min; index++)
				result += " (n" + index + " Int)";
			result += ") (and";
			for(int index = 1; index <= min; index++)
				result += " (nodes g n" + index + ") (" + node + " n" +  index + ")";
			if(min > 1){
				result += " (distinct";
				for(int index = 1; index <= min; index++)
					result += " n" +  index;
				result += ")";
			}
			result += "))";
		}
		return result;
	}
	private String translateSurjective(Constraint constraint) {
		Node target = getNode(constraint, "Y");
		Arrow arrow = getArrow(constraint, "XY");
		String result = ";;" + "surjective on " + arrow +  LINE;
		String name = "SUJ-" + arrow.getName(); 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(target) + " n)) "
				+ "(exists ((e Int)) (and (edges g e) (" + edgeSig(arrow) + " e) (= (TRG e) n))))))" + LINE; 
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private String translateArrowMultiplicity(Arrow arrow) {
		String result = ";;mulitplicity on " + arrow +  "[0,1]" + LINE;
		String name = "MUL-" + arrow.getName(); 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(arrow.getSource()) + " n)) "
				+ "(not (exists ((e1 Int) (e2 Int)) (and (edges g e1) (edges g e2) (" + edgeSig(arrow) + " e1) (= (SRC e1) n)"
				+ " (distinct e1 e2) (" + edgeSig(arrow) + " e2) (= (SRC e2) n)))))))" + LINE; 
		return result + "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	private Node getNode(Constraint constraint, String name){
		return constraint.getMappings().getNodeMapping().get(constraint.getPredicate().getShape().getNodeByName(name));
	}
	private Arrow getArrow(Constraint constraint, String name){
		return constraint.getMappings().getArrowMapping().get(constraint.getPredicate().getShape().getArrowByName(name));
	}
	private String translateInjective(Constraint constraint) {
		Node source = getNode(constraint, "X");
		Arrow arrow = getArrow(constraint, "XY");
		String result = ";;" + "check injective on " + arrow +  LINE;
		String name = "INJ-" + arrow.getName(); 
		result += "(define-fun " + name + " ((g Int)) Bool (forall ((n Int)) (=> (and (nodes g n) (" + nodeSig(source) + " n)) "
				+ "(not (exists ((e1 Int) (e2 Int)) (and (distinct e1 e2) (" + edgeSig(arrow) + " e1) (" + edgeSig(arrow) + " e2) (edges g e1) (edges g e2)"
				+ " (= (SRC e1) n) (= (SRC e1) n)))))))" +  LINE; 
		return result += "(assert (forall ((t Int)) (=> (TRANS t) (" + name + " (sm t)))))" +  LINE;
	}
	/*
	 * Get the connected subgraphs from a graph
	 */
	private void getConnectedSubgraphs(List<DNode> nodes, List<DArrow> arrows, List<Object> subgraphs){
		List<DNode> unvisited = new ArrayList<DNode>();
		List<DArrow> unvisitedEdge = new ArrayList<DArrow>();
		unvisited.addAll(nodes);
		unvisitedEdge.addAll(arrows);
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
					if(!suba.contains(arrow)){
						suba.add(arrow);
						unvisitedEdge.remove(arrow);
					}
					DNode source = arrow.getDSource();
					if(!related.contains(source) && !subn.contains(source) && nodes.contains(source))
						related.add(source);
				}
				for(DArrow arrow : cur.getDOutgoings()){
					if(!arrows.contains(arrow))
						continue;
					if(!suba.contains(arrow)){
						suba.add(arrow);
						unvisitedEdge.remove(arrow);
					}
					DNode target = arrow.getDTarget();
					if(!related.contains(target) && !subn.contains(target) && nodes.contains(target))
						related.add(target);
				}					
			}while(!related.isEmpty());
			subgraphs.add(subn);
			subgraphs.add(suba);
		}
		for(DArrow arrow : unvisitedEdge){
			List<DNode> subn = new ArrayList<DNode>();
			List<DArrow> suba = new ArrayList<DArrow>();
			suba.add(arrow);
			subgraphs.add(subn);
			subgraphs.add(suba);
		}

	}
	/*
	 * encoding the match of left or right side(indicated by delete) of a rule  
	 */
//	@SuppressWarnings("unchecked")
//	private  void hasOneMatch(List<DNode> nodes, List<DArrow> arrows, List<DNode> commonNodes, List<DArrow> commonArrows, boolean delete){
//		List<Object> relatedSet = new ArrayList<Object>();
//		getConnectedSubgraphs(nodes, arrows, relatedSet);
//		for(int index = 0; index < relatedSet.size(); index += 2){
//			List<DNode> subn = (List<DNode>) relatedSet.get(index);
//			List<DArrow> suba = (List<DArrow>) relatedSet.get(index + 1);
//			List<DNode>  subcn = new ArrayList<DNode>();
//			List<DArrow>  subca = new ArrayList<DArrow>();
//			for(DNode node : subn)
//				if(commonNodes.contains(node))
//					subcn.add(node);
//			for(DArrow arrow : suba)
//				if(commonArrows.contains(arrow))
//					subca.add(arrow);
//			translateRelatedMatch(suba, subn, subcn, subca, delete);
//		}
//		buffer.append(LINE);
//	}

//	private void matchDelAndAdd(List<DNode> leftnodes, List<DArrow> leftarrows, List<DNode> commonNodes, List<DArrow> commonArrows, List<DNode> rightnodes, List<DArrow> rightarrows){
//		for(DNode iter : commonNodes){
//			List<DArrow> left = new ArrayList<DArrow>(), right = new ArrayList<DArrow>();
//			for(DArrow arrow : iter.getDIncomings()){
//				if(leftarrows.contains(arrow) && !commonArrows.contains(arrow))
//					left.add(arrow);
//				else if(rightarrows.contains(arrow) && !commonArrows.contains(arrow))
//					right.add(arrow);
//			}
//			for(DArrow arrow : iter.getDOutgoings()){
//				if(!left.contains(arrow) && leftarrows.contains(arrow) && !commonArrows.contains(arrow))
//					left.add(arrow);
//				else if(!right.contains(arrow) && rightarrows.contains(arrow) && !commonArrows.contains(arrow))
//					right.add(arrow);
//			}
//			if(!left.isEmpty() && !right.isEmpty()){
//				String the = iter.getName();
//				buffer.append("\tsome " + the  + ":" + nodeSig(iter.getNode().getTypeNode()) + "&" + COMNODE + "|");
//				DArrow first = left.get(0);
//				buffer.append("(some " + first.getName()  + ":" + edgeSig(first.getArrow().getTypeArrow()) + "&" + DELEDGE + "|" + first.getName() + (first.getDSource() == iter ? ".src" : ".trg") + "=" + the + ")");
//				for (int i = 1; i < left.size(); i++) {
//					DArrow other = left.get(i);
//					buffer.append(" and (some " + other.getName()  + ":" + edgeSig(other.getArrow().getTypeArrow()) + "&" + DELEDGE + "|" + other.getName() + (other.getDSource() == iter ? ".src" : ".trg") + "=" + the + ")");
//				}
//				for (int i = 0; i < right.size(); i++) {
//					DArrow other = right.get(i);
//					buffer.append(" and (some " + other.getName()  + ":" + edgeSig(other.getArrow().getTypeArrow()) + "&" + ADDEDGE + "|" + other.getName() + (other.getDSource() == iter ? ".src" : ".trg") + "=" + the + ")");
//				}
//				buffer.append(LINE);
//			}
//		}
//	}
	/**
	 * encoding the match of left or right side(indicated by delete) of a rule <br>
	 * Different from the last method, this one is used in the condition that if an element is changed, it is matched by rule's left or right side
	 */
	@SuppressWarnings("unchecked")
	public  void hasOneMatch(List<DNode> nodes, List<DArrow> arrows, List<DNode> commonNodes, List<DArrow> commonArrows, Object replaced, boolean delete){
		List<Object> relatedSet = new ArrayList<Object>();
		getConnectedSubgraphs(nodes, arrows, relatedSet);
		buffer.append("(");
		for(int index = 0; index < relatedSet.size(); index += 2){
			if(index != 0)
				buffer.append(" and ");
			buffer.append("(");
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
			translateRelatedMatch(suba, subn, subcn, subca, delete, replaced);
			buffer.append(")");
		}
		buffer.append(")");
	}

	/**
	 * Encoding a predicate to see if a transformation is applying a rule
	 * @param rule : The rule
	 * @param dGraph : The metamodel
	 */
	@SuppressWarnings("unchecked")
	public void pre_rule(Production rule, DGraph dGraph){
		buffer.append(";;the predicate that the transformation is an application of the rule " + rule.getName() + LINE);
		buffer.append("(define-fun rule_" + rule.getName() + " ((t Int)) Bool (and " + LINE);
//		buffer.append("\tsome t.rule&" + rule.getName() + LINE + LINE);
		//Has one match of left(right) side of the rule
		List<Object> relatedSet = new ArrayList<Object>();
		getConnectedSubgraphs(rule.getSum().getDGraph().getDNodes(), rule.getSum().getDGraph().getDArrows(), relatedSet);
		for(int index = 0; index < relatedSet.size(); index += 2){
			List<DNode> subn = (List<DNode>) relatedSet.get(index);
			List<DArrow> suba = (List<DArrow>) relatedSet.get(index + 1);
			translateMatch(intersection(subn, rule.getLeftNodes()), intersection(suba, rule.getLeftArrows()),
					  intersection(subn, rule.getCommonNodes()), intersection(suba, rule.getCommonArrows()),
					  intersection(subn, rule.getRightNodes()), intersection(suba, rule.getRightArrows()));
		}
		nodesChanged(rule.getLeftNodes(), rule.getLeftArrows(), rule.getCommonNodes(), rule.getCommonArrows(), true);
		nodesChanged(rule.getRightNodes(), rule.getRightArrows(), rule.getCommonNodes(), rule.getCommonArrows(), false);
		edgesChanged(rule.getLeftNodes(), rule.getLeftArrows(), rule.getCommonNodes(), rule.getCommonArrows(), true);
		edgesChanged(rule.getRightNodes(), rule.getRightArrows(), rule.getCommonNodes(), rule.getCommonArrows(), false);
		noNodeChanged(rule.getLeftNodes(), rule.getCommonNodes(), dGraph.getDNodes(), true);
		noNodeChanged(rule.getRightNodes(), rule.getCommonNodes(), dGraph.getDNodes(), false);
		noEdgeChanged(rule.getLeftArrows(), rule.getCommonArrows(), dGraph.getDArrows(), true);
		noEdgeChanged(rule.getRightArrows(), rule.getCommonArrows(), dGraph.getDArrows(), false);
		buffer.append("))" + LINE);
	}

	private <T> List<T> complement(Collection<T> A, Collection<T> B){
		List<T> result = new ArrayList<T>();
		for(T iter : A){
			if(!B.contains(iter))
				result.add(iter);
		}
		return result;
	}
	private <T> List<T> intersection(List<T> A, List<T> B){
		List<T> result = new ArrayList<T>();
		for(T iter : A){
			if(B.contains(iter))
				result.add(iter);
		}
		return result;
	}
//	private Map<DNode, List<DNode>> getTypeNodeMap(List<DNode> lists){
//		Map<DNode, List<DNode>> map = new HashMap<DNode, List<DNode>>();
//		for(DNode node : lists){
//			DNode type = node.getDType();
//			List<DNode> list = map.get(type);
//			if(list == null){
//				list = new ArrayList<DNode>();
//				list.add(node);
//				map.put(node, list);
//			}else
//				list.add(node);
//		}
//		return map;
//	}
//	private Map<DArrow, List<DArrow>> getTypeArrowMap(List<DArrow> lists){
//		Map<DArrow, List<DArrow>> map = new HashMap<DArrow, List<DArrow>>();
//		for(DArrow arrow : lists){
//			DArrow type = arrow.getDType();
//			List<DArrow> list = map.get(type);
//			if(list == null){
//				list = new ArrayList<DArrow>();
//				list.add(arrow);
//				map.put(arrow, list);
//			}else
//				list.add(arrow);
//		}
//		return map;
//	}
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private void putMap(Map<DNode, List[]> maps, DNode element){
//		List[] graph = new List[2];
//		graph[0] = new ArrayList<DNode>();
//		graph[0].add(element);
//		maps.put(element, graph);
//	}
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	private void putMap(Map<DNode, List[]> maps, DNode node, DArrow element){
//		List[] graph = new List[2];
//		graph[0] = new ArrayList<DNode>();
//		graph[0].add(element.getDSource());
//		if(element.getDSource() != element.getDTarget())
//			graph[0].add(element.getDTarget());
//		graph[1] = new ArrayList<DArrow>();
//		graph[1].add(element);
//		maps.put(node, graph);
//	}
//	@SuppressWarnings("rawtypes")
//	private void findUnique(List<DNode> leftnodes, List<DArrow> leftarrows, List<DNode> commonNodes, List<DArrow> commonArrows, List<DNode> rightnodes, List<DArrow> rightarrows){
//		//		Map<DNode, List<?>[]> maps = new HashMap<DNode, List<?>[]>();
//		List<DNode> dNodes = complement(leftnodes, commonNodes), aNodes = complement(rightnodes, commonNodes);
//		List<DArrow> dEdges = complement(leftarrows, commonArrows), aEdges = complement(rightarrows, commonArrows);
//		List<DNode> glues = new ArrayList<DNode>();
//		List<List<DArrow>> deleted = new ArrayList<List<DArrow>>(), added = new ArrayList<List<DArrow>>();
//		for(DNode iter : commonNodes){
//			List<DArrow> related = new ArrayList<DArrow>();
//			for(DArrow left : dEdges)
//				if(left.getDSource() == iter || left.getDTarget() == iter)
//					related.add(left);
//			if(related.isEmpty()) continue;
//			List<DArrow> rightrelated = new ArrayList<DArrow>();
//			for(DArrow right : aEdges)
//				if(right.getDSource() == iter || right.getDTarget() == iter)
//					rightrelated.add(right);
//			if(rightrelated.isEmpty()) continue;
//			glues.add(iter);
//			deleted.add(related);
//			added.add(rightrelated);
//		}
//		if(glues.isEmpty()) return;
//		Map<DNode, List[]> decided = new HashMap<DNode, List[]>();
//		Map<DNode, List<DNode>> nodeMap = getTypeNodeMap(dNodes);
//		for(Entry<DNode, List<DNode>> entry : nodeMap.entrySet()){
//			if(entry.getValue().size() == 1 && decided.containsKey(entry.getValue().get(0))){
//				putMap(decided, entry.getValue().get(0));
//			}
//		}
//		Map<DArrow, List<DArrow>> arrowMaps = getTypeArrowMap(dEdges);
//		for(Entry<DArrow, List<DArrow>> entry : arrowMaps.entrySet()){
//			if(entry.getValue().size() == 1){
//				DArrow cur = entry.getValue().get(0);
//				if(cur.getDSource() == cur.getDTarget() && !decided.containsKey(cur.getDSource()))
//					putMap(decided, cur.getDSource(), cur);
//			}
//		}
//		for(Entry<DArrow, List<DArrow>> entry : arrowMaps.entrySet()){
//			if(entry.getValue().size() == 1){
//				DArrow cur = entry.getValue().get(0);
//				if(cur.getDSource() != cur.getDTarget()){
//					if(!decided.containsKey(cur.getDSource()))
//						putMap(decided, cur.getDSource(), cur);
//					if(!decided.containsKey(cur.getDTarget()))
//						putMap(decided, cur.getDTarget(), cur);
//				}
//			}
//		}
//		Map<DNode, List[]> decidedRight = new HashMap<DNode, List[]>();
//		Map<DNode, List<DNode>> nodeMapRight = getTypeNodeMap(aNodes);
//		for(Entry<DNode, List<DNode>> entry : nodeMapRight.entrySet()){
//			if(entry.getValue().size() == 1 && !decidedRight.containsKey(entry.getValue().get(0))){
//				putMap(decidedRight, entry.getValue().get(0));
//			}
//		}
//		Map<DArrow, List<DArrow>> arrowMapsRight = getTypeArrowMap(aEdges);
//		for(Entry<DArrow, List<DArrow>> entry : arrowMapsRight.entrySet()){
//			if(entry.getValue().size() == 1){
//				DArrow cur = entry.getValue().get(0);
//				if(cur.getDSource() == cur.getDTarget() && !decidedRight.containsKey(cur.getDSource()))
//					putMap(decidedRight, cur.getDSource(), cur);
//			}
//		}
//		for(Entry<DArrow, List<DArrow>> entry : arrowMapsRight.entrySet()){
//			if(entry.getValue().size() == 1){
//				DArrow cur = entry.getValue().get(0);
//				if(cur.getDSource() != cur.getDTarget()){
//					if(!decidedRight.containsKey(cur.getDSource()))
//						putMap(decidedRight, cur.getDSource(), cur);
//					if(!decidedRight.containsKey(cur.getDTarget()))
//						putMap(decidedRight, cur.getDTarget(), cur);
//				}
//			}
//		}
//		for (int i = 0; i < glues.size(); i++) {
//			DNode node = glues.get(i);
//			if(decided.containsKey(node) && decidedRight.containsKey(node)){
//				List[] leftGraph = decided.get(node);
//				List[] rightGraph = decidedRight.get(node);
//				DArrow left = (DArrow) leftGraph[1].get(0);
//				DArrow right = (DArrow) rightGraph[1].get(0);
//				buffer.append("some left:" + edgeSig(left.getArrow().getTypeArrow()) + "&" + DELETEARROW  + ",");
//				buffer.append("right:" + edgeSig(right.getArrow().getTypeArrow()) + "&" + ADDARROW  + "|left.");
//				buffer.append(left.getDSource() == node ? "src" : "trg");
//				buffer.append("=right.");
//				buffer.append((right.getDSource() == node ? "src" : "trg") + LINE);
//			}else{
//				buffer.append(";;need mauelly setting the glue nodes right now" + LINE);
//			}
//		}
//		buffer.append(LINE);
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
	public void fact(List<Production> rules){
		buffer.append("(assert (! (forall ((n Int)) (=> (NODE n) (exists ((g Int)) (and (GRAPH g) (nodes g n))))) :named every-node-in-graph))" + LINE);
		buffer.append("(assert (! (forall ((e Int)) (=> (EDGE e) (exists ((g Int)) (and (GRAPH g) (edges g e))))) :named every-edge-in-graph))" + LINE);
		buffer.append("(assert (! (forall ((g Int)) (=> (GRAPH g) (exists ((t Int)) (and (TRANS t) (or (= (sm t) g) (= (tm t) g)))))) :named every-graph-in-transformation))" + LINE);
		buffer.append("(assert (! (not (exists ((g1 Int) (g2 Int)) (and (GRAPH g1) (GRAPH g2) (distinct g1 g2) (forall ((x Int)) (and (=> (NODE x) (= (nodes g1 x) (nodes g2 x))) "
				+ "(=> (EDGE x) (= (edges g1 x) (edges g2 x)))))))) :named graphs-are-different))" + LINE);

//		buffer.append("\tall t:Trans | trans_general[t] and valid[t.sm] and (" + LINE + "\t");
//		for (Iterator<Production> iterator = rules.iterator(); iterator.hasNext();) {
//			Production rule = (Production) iterator.next();
//			buffer.append("rule_" + rule.getName() + "[t]");
//			if(iterator.hasNext())
//				buffer.append(" or ");
//		}
//		buffer.append(")" + LINE + "}" + LINE + LINE);
	}
	public  String translate(List<DArrow> arrows, List<DNode> nodes, List<DNode> commonNodes, List<DArrow> commonArrows,
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

	@SuppressWarnings("unchecked")
	private <T> Map<T, List<T>> getTypeHash(List<T> lists){
		Map<T, List<T>> map = new HashMap<T, List<T>>();
		for(T iter : lists){
			T type = iter instanceof DNode ? (T) ((DNode)iter).getDType() : (T) ((DArrow)iter).getDType(); 
			if(map.containsKey(type)){
				map.get(type).add(iter);
			}else{
				List<T> cur = new ArrayList<T>();
				cur.add(iter);
				map.put(type, cur);
			}
		}
		return map;
	}
//	private <T> List<List<T>> elementsOfSameType(List<T> lists){
//		List<List<T>> result = new ArrayList<List<T>>();
//		for(List<T> iter : getTypeHash(lists).values()){
//			if(iter.size() > 1)
//				result.add(iter);
//		}
//		return result;
//	}
//	private void changeNodesAreDifferent(List<DNode> list){
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = i + 1; j < list.size(); j++) {
//				buffer.append(" and " + list.get(i).getName() + "!=" + list.get(i).getName());
//			}
//		}
//	}
//	private void changeEdgesAreDifferent(List<DArrow> list){
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = i + 1; j < list.size(); j++) {
//				buffer.append(" and " + list.get(i).getName() + "!=" + list.get(i).getName());
//			}
//		}
//	}
	
	private void getUniqueElements(List<DNode> nodes, List<DArrow> edges, List<DNode> uns, List<DArrow> ues){
		Map<DNode, List<DNode>> nodeHash = getTypeHash(nodes);
		Map<DArrow, List<DArrow>> edgeHash = getTypeHash(edges);
		
		for(List<DNode> iter : nodeHash.values()){
			if(iter.size() == 1)
				uns.add(iter.get(0));
		}
		for(List<DArrow> iter : edgeHash.values()){
			if(iter.size() == 1)
				ues.add(iter.get(0));
		}
	}
//	private void translateSubMatch(List<DNode> leftNodes, List<DArrow> leftEdges, 
//			  List<DNode> commonNodes, List<DArrow> commonEdges, 
//			  List<DNode> rightNodes, List<DArrow> rightEdges){
//		Set<DNode> nodes = new HashSet<DNode>();
//		nodes.addAll(leftNodes);
//		nodes.addAll(rightNodes);
//		Set<DArrow> edges = new HashSet<DArrow>();
//		edges.addAll(leftEdges);
//		edges.addAll(rightEdges);
//		List<DArrow> edgeList = new ArrayList<>(edges);
//		Map<DNode, DArrow> hash = new HashMap<DNode, DArrow>();
//		DArrow cur = edgeList.get(0);
//		boolean ke = commonEdges.contains(cur), de = !ke & leftEdges.contains(cur);		
//		buffer.append("\tsome " + alloyTypedVariable(cur, hash) + "&" + (ke ? COMEDGE : (de ? DELEDGE : ADDEDGE)));
//		for (int i = 1; i < edgeList.size(); i++) {
//			cur = edgeList.get(i);
//			ke = commonEdges.contains(cur);
//			de = !ke & leftEdges.contains(cur);
//			buffer.append(", " + alloyTypedVariable(cur, hash) + "&" + (ke ? COMEDGE : (de ? DELEDGE : ADDEDGE)));
//		}
//		buffer.append("|" + LINE + "\tlet ");
//		List<String> strings = new ArrayList<String>();
//		for (Entry<DNode, DArrow> iter: hash.entrySet()) {
//			DNode n = iter.getKey();
//			DArrow a = iter.getValue();
//			strings.add(n.getName() + "=" + a.getName() + "." + (a.getDSource() == n ? "src" : "trg"));
//		}
//		if(!strings.isEmpty())
//		buffer.append(strings.get(0));
//		for (int i = 1; i < strings.size(); i++) {
//			buffer.append(", " + strings.get(i));
//		}
//		buffer.append("|" + LINE + "\t");
//		strings = new ArrayList<String>();
//		for(DArrow arrow : edges){
//			DNode source = arrow.getDSource();
//			DArrow ah = hash.get(source);
//			if(arrow != ah){
//				strings.add(source.getName() + "=" + arrow.getName() + ".src");
//			}
//			DNode target = arrow.getDTarget();
//			ah = hash.get(target);
//			if(source == target || arrow != ah){
//				strings.add(target.getName() + "=" + arrow.getName() + ".trg");
//			}
//		}
//		
//		for (DNode node : hash.keySet()) {
//			boolean kn = commonNodes.contains(node), dn = !kn & leftNodes.contains(node);
//			strings.add(node.getName() + " in " + nodeSig(node.getDType().getNode()) + "&" + (kn ? COMNODE : (dn ? DELNODE : ADDNODE)));
//		}
//		if(!strings.isEmpty())
//			buffer.append(strings.get(0));
//			for (int i = 1; i < strings.size(); i++) {
//				buffer.append(" and " + strings.get(i));
//			}
//		for(List<DNode> iter : elementsOfSameType(complement(leftNodes, commonNodes)))
//			changeNodesAreDifferent(iter);
//		for(List<DNode> iter : elementsOfSameType(complement(rightNodes, commonNodes)))
//			changeNodesAreDifferent(iter);
//		for(List<DArrow> iter : elementsOfSameType(complement(leftEdges, commonEdges)))
//			changeEdgesAreDifferent(iter);
//		for(List<DArrow> iter : elementsOfSameType(complement(rightEdges, commonEdges)))
//			changeEdgesAreDifferent(iter);
//		buffer.append(LINE + LINE);
//	}
	@SuppressWarnings("unchecked")
	public void translateMatch(List<DNode> leftNodes, List<DArrow> leftEdges, 
						  List<DNode> commonNodes, List<DArrow> commonEdges, 
						  List<DNode> rightNodes, List<DArrow> rightEdges){
		Set<DNode> nodes = new HashSet<DNode>();
		nodes.addAll(leftNodes);
		nodes.addAll(commonNodes);
		nodes.addAll(rightNodes);
		Set<DArrow> edges = new HashSet<DArrow>(); 
		edges.addAll(leftEdges);
		edges.addAll(commonEdges);
		edges.addAll(rightEdges);
		
		//Get the unique elements of the type which has only one instance deleted or added during the direct model transformation
		List<DNode> uniqueNodes = new ArrayList<DNode>();
		List<DArrow> uniqueEdges = new ArrayList<DArrow>();
		getUniqueElements(complement(leftNodes, commonNodes), complement(leftEdges, commonEdges), uniqueNodes, uniqueEdges);
		getUniqueElements(complement(rightNodes, commonNodes), complement(rightEdges, commonEdges), uniqueNodes, uniqueEdges);
		
		//Get the joint node which are shared by different unique subgraphs
		Map<DNode, List<Integer>> jointNodes = new HashMap<DNode, List<Integer>>();
		ArrayList<Object> uniqueSubgraphs = new ArrayList<Object>();
		getConnectedSubgraphs(uniqueNodes, uniqueEdges, uniqueSubgraphs);
		for(int index = 0; index < uniqueSubgraphs.size(); index += 2){
			List<DNode> subn = (List<DNode>) uniqueSubgraphs.get(index);
			List<DArrow> suba = (List<DArrow>) uniqueSubgraphs.get(index + 1);
			for(DArrow iter : suba){
				DNode cur = iter.getDSource();
				if(!subn.contains(cur)) {
//					subn.add(cur); 
					List<Integer> value = jointNodes.get(cur);
					if(value == null){
						value = new ArrayList<Integer>();
						jointNodes.put(cur, value);
					}
					value.add(index);
				}
				cur = iter.getDTarget();
				if(cur != iter.getDSource() && !subn.contains(cur)) {
//					subn.add(cur); 
					List<Integer> value = jointNodes.get(cur);
					if(value == null){
						value = new ArrayList<Integer>();
						jointNodes.put(cur, value);
					}
					value.add(index);
				}
			}
		}
		
		//Get the subgraphs after removing the unique elements
		List<DNode> nnodes = complement(nodes, uniqueNodes);
		List<DArrow> nedges = complement(edges, uniqueEdges);
		ArrayList<Object> subgraphs = new ArrayList<Object>();
		getConnectedSubgraphs(nnodes, nedges, subgraphs);
		//Get the subgraph which each joint node is contained
		Map<DNode, Integer> jointInSubgraph = new HashMap<DNode, Integer>();
		for(int index = 0; index < subgraphs.size(); index += 2){
			List<DNode> subn = (List<DNode>) subgraphs.get(index);
			for(DNode iter : subn)
				if(jointNodes.containsKey(iter))
					jointInSubgraph.put(iter, index);
		}
		//Get the subgraphs which joint subgraphs are connected with
		Map<Integer, List<Integer>> uniqueToSubGraphs = new HashMap<Integer, List<Integer>>();
		for(int index = 0; index < uniqueSubgraphs.size(); index += 2){
			List<Integer> value = new ArrayList<Integer>();
			List<DNode> subn = (List<DNode>) uniqueSubgraphs.get(index);
			List<DArrow> suba = (List<DArrow>) uniqueSubgraphs.get(index + 1);
			for(DArrow iter : suba){
				DNode cur = iter.getDSource();
				Integer subg = jointInSubgraph.get(cur);
				if(!subn.contains(cur) && !value.contains(subg)) 
					value.add(subg);
				cur = iter.getDTarget();
				subg = jointInSubgraph.get(cur);
				if(cur != iter.getDSource() && !subn.contains(cur) && !value.contains(subg)) 
					value.add(subg);
			}
			uniqueToSubGraphs.put(index, value);
		}
		//Choose the edge for each joint node
//		List<DArrow> chosens = new ArrayList<DArrow>();
		Map<DArrow, Integer> subgs = new HashMap<DArrow, Integer>();
		for(Entry<DNode, List<Integer>> iter : jointNodes.entrySet()){
			DNode joint = iter.getKey();
			int chosenIndex = 0, max = 0;
			for(Integer i : iter.getValue()) {
				int size = uniqueToSubGraphs.get(i).size();
				if(size > max){
					chosenIndex = i;
					max = size;
				}
			}
			List<DArrow> jsuba = (List<DArrow>) uniqueSubgraphs.get(chosenIndex + 1);
			DArrow chosen = null;
			for(DArrow edge : jsuba){
				if(edge.getDSource() == joint || edge.getDTarget() == joint){
					chosen = edge;
					break;
				}
			}
			
			//Add the joint node to the subgraph and other joint subgraphs
			int subIndex = jointInSubgraph.get(joint);
			List<DArrow> suba = (List<DArrow>) subgraphs.get(subIndex + 1);
			List<DNode> subn = (List<DNode>) subgraphs.get(subIndex);
			if(!suba.contains(chosen)){
				subgs.put(chosen, subIndex);
				suba.add(chosen);
				if(!subn.contains(chosen.getDSource())) subn.add(chosen.getDSource());
				if(!subn.contains(chosen.getDTarget())) subn.add(chosen.getDTarget());
			}
			for(Integer i : iter.getValue()){
				suba = (List<DArrow>) uniqueSubgraphs.get(i + 1);
				subn = (List<DNode>) uniqueSubgraphs.get(i);
				for(DArrow a : suba){
					if(!subn.contains(a.getDSource())) subn.add(a.getDSource());
					if(!subn.contains(a.getDTarget())) subn.add(a.getDTarget());
				}
				if(i == chosenIndex) continue;
				if(!suba.contains(chosen)){suba.add(chosen);
				if(!subn.contains(chosen.getDSource())) subn.add(chosen.getDSource());
				if(!subn.contains(chosen.getDTarget())) subn.add(chosen.getDTarget());}
			}			
		}
		
		List<Object> finalSubgraphs = new ArrayList<Object>();
		for(int index = 0; index < subgraphs.size(); index += 2){
			List<DNode> subn = (List<DNode>) subgraphs.get(index);
			List<DArrow> suba = (List<DArrow>) subgraphs.get(index + 1);
			if(suba.isEmpty()|| (suba.size() == 1 && subgs.containsKey(suba.get(0)))) continue;
			finalSubgraphs.add(subn);
			finalSubgraphs.add(suba);
		}
		for(int index = 0; index < uniqueSubgraphs.size(); index += 2){
			List<DNode> subn = (List<DNode>) uniqueSubgraphs.get(index);
			List<DArrow> suba = (List<DArrow>) uniqueSubgraphs.get(index + 1);
			if(suba.isEmpty() || (suba.size() == 1 && subgs.containsKey(suba.get(0)))) continue;
			Set<Integer> hash = new HashSet<Integer>();
			Iterator<DArrow> iterator = suba.iterator();
			for (; iterator.hasNext();) {
				DArrow a = (DArrow) iterator.next();
				if(!subgs.containsKey(a)) break;
				hash.add(subgs.get(a));
			}
			if(!iterator.hasNext() && hash.size() < 2) continue;
			finalSubgraphs.add(subn);
			finalSubgraphs.add(suba);
		}
		for(int index = 0; index < finalSubgraphs.size(); index += 2){
			List<DNode> subn = (List<DNode>) finalSubgraphs.get(index);
			List<DArrow> suba = (List<DArrow>) finalSubgraphs.get(index + 1);
//			translateSubMatch(intersection(subn, leftNodes), intersection(suba, leftEdges), 
			translateRelatedMatch(intersection(subn, leftNodes), intersection(suba, leftEdges), 
					intersection(subn, commonNodes), intersection(suba, commonEdges), 
					intersection(subn, rightNodes), intersection(suba, rightEdges));
		}	
	}
	
	
//	private String alloyTypedVariable(DArrow instance){
//		return instance.getArrow().getName() + ":" + edgeSig(instance.getArrow().getTypeArrow());
//	}
//	private String alloyTypedVariable(DArrow instance, Map<DNode, DArrow> hash) {
//		DNode source = instance.getDSource(), target = instance.getDTarget();
//		if(!hash.containsKey(source)) hash.put(source, instance);
//		if(!hash.containsKey(target)) hash.put(target, instance);
//		return alloyTypedVariable(instance);
//	}
	public  void translateRelatedMatch(DArrow cur, 
			List<DArrow> visited, List<DNode> visitedNode, 
			List<DNode> leftNodes, List<DArrow> leftEdges,  
			 List<DNode> commonNodes, List<DArrow> commonEdges, 
			 List<DNode> rightNodes, List<DArrow> rightEdges) {
		boolean kept = commonEdges.contains(cur), srcKept = commonNodes.contains(cur.getDSource()), trgKept = commonNodes.contains(cur.getDTarget());
		String the = cur.getArrow().getName(), source = cur.getArrow().getSource().getName(), target = cur.getArrow().getTarget().getName();
		buffer.append(LINE + "(exists ((");//kept ? "some " : "one ");
		buffer.append(the +" Int)) (and (");
		buffer.append(edgeSig(cur.getArrow().getTypeArrow()) + " " + the + ")");
		boolean delete = !kept & leftEdges.contains(cur);
		buffer.append(kept ? COMEDGE(the) : (delete ? DELEDGE(the) : ADDEDGE(the)));
//		buffer.append("|");
		boolean srcVisited = visitedNode.contains(cur.getDSource()), trgVisited =  visitedNode.contains(cur.getDTarget());
		visitedNode.add(cur.getDSource());
		visitedNode.add(cur.getDTarget());
		visited.add(cur);
		if(srcVisited && trgVisited){
			buffer.append(" (= (SRC " + the + ") " + source + ") (= (TRG " + the  + ") " + target + ")))");
			return;
		}
		buffer.append(" (let (");
		boolean ref = cur.getDSource() == cur.getDTarget();
		if(!srcVisited)
			buffer.append("(" + source + " (SRC " + the + "))");
		if(!srcVisited && !trgVisited && !ref)
			buffer.append(" ");
		if(!trgVisited && !ref)
			buffer.append("(" + target + " (TRG " + the + "))");
		buffer.append(")" + LINE + "\t (and ");
		if(srcVisited)
			buffer.append("(= (SRC " + the + ") " + source + ")");
		else{
			delete = leftNodes.contains(source);
			buffer.append(srcKept ? COMNODE(source) : (delete ? DELNODE(source) : ADDNODE(source)));
		}
		if(!ref){
			buffer.append(" ");
			if(trgVisited)
				buffer.append("(= (TRG " + the + ") " + target + ")");
			else{
				delete = leftNodes.contains(target);
				buffer.append(trgKept ? COMNODE(target) : (delete ? DELNODE(target) : ADDNODE(target)));
			}
		}else if(!trgVisited)
			buffer.append(" (" + target + " (TRG" + the + "))");

		if(!srcVisited){
			for(DArrow arrow : cur.getDSource().getDIncomings()){
				if((leftEdges.contains(arrow) || rightEdges.contains(arrow)) && !visited.contains(arrow)){
					buffer.append(" (");
					translateRelatedMatch(arrow, visited, visitedNode, leftNodes, leftEdges, commonNodes, commonEdges, rightNodes, rightEdges);
					buffer.append(")");
				}
			}
			for(DArrow arrow : cur.getDSource().getDOutgoings()){
				if((leftEdges.contains(arrow) || rightEdges.contains(arrow)) && !visited.contains(arrow)){
					buffer.append(" (");
					translateRelatedMatch(arrow, visited, visitedNode, leftNodes, leftEdges, commonNodes, commonEdges, rightNodes, rightEdges);
					buffer.append(")");
				}
			}
		}
		if(!trgVisited && !ref){
			for(DArrow arrow : cur.getDTarget().getDIncomings()){
				if((leftEdges.contains(arrow) || rightEdges.contains(arrow)) && !visited.contains(arrow)){
					buffer.append(" (");
					translateRelatedMatch(arrow, visited, visitedNode, leftNodes, leftEdges, commonNodes, commonEdges, rightNodes, rightEdges);
					buffer.append(")");
				}
			}
			for(DArrow arrow : cur.getDTarget().getDOutgoings()){
				if((leftEdges.contains(arrow) || rightEdges.contains(arrow)) && !visited.contains(arrow)){
					buffer.append(" (");
					translateRelatedMatch(arrow, visited, visitedNode, leftNodes, leftEdges, commonNodes, commonEdges, rightNodes, rightEdges);
					buffer.append(")");
				}
			}
		}
		buffer.append("))))");
	}
//	public  void translateRelatedMatch(DArrow cur, List<DArrow> visited, List<DNode> visitedNode, List<DArrow> arrows, List<DNode> nodes, List<DNode> commonNodes, List<DArrow> commonArrows, boolean delete) {
//		boolean kept = commonArrows.contains(cur), srcKept = commonNodes.contains(cur.getDSource()), trgKept = commonNodes.contains(cur.getDTarget());
//		String the = cur.getArrow().getName(), source = cur.getArrow().getSource().getName(), target = cur.getArrow().getTarget().getName();
//		buffer.append("some ");//kept ? "some " : "one ");
//		buffer.append(the +":");
//		buffer.append(edgeSig(cur.getArrow().getTypeArrow()) + "&");
//		buffer.append(kept ? COMEDGE : (delete ? DELEDGE : ADDEDGE));
//		buffer.append("|");
//		boolean srcVisited = visitedNode.contains(cur.getDSource()), trgVisited =  visitedNode.contains(cur.getDTarget());
//		visitedNode.add(cur.getDSource());
//		visitedNode.add(cur.getDTarget());
//		visited.add(cur);
//		if(srcVisited && trgVisited){
//			buffer.append(the + ".src=" + source + " and " + the  + ".trg =" + target);
//			return;
//		}
//
//		buffer.append("let ");
//		boolean ref = cur.getDSource() == cur.getDTarget();
//		if(!srcVisited)
//			buffer.append(source + "=" + the + ".src");
//		if(!srcVisited && !trgVisited && !ref)
//			buffer.append(",");
//		if(!trgVisited && !ref)
//			buffer.append(target + "=" + the + ".trg");
//		buffer.append("|" + LINE + "\t(");
//		if(srcVisited)
//			buffer.append(the + ".src=" + source);
//		else
//			buffer.append(source + " in " + (srcKept ? COMNODE : (delete ? DELNODE : ADDNODE)));
//		if(!ref){
//			buffer.append(" and ");
//			if(trgVisited)
//				buffer.append(the + ".trg=" + target);
//			else
//				buffer.append(target + " in " + (trgKept ? COMNODE : (delete ? DELNODE : ADDNODE)));
//		}else if(!trgVisited)
//			buffer.append(" and " + target + "=" + the + ".trg");
//
//		if(!srcVisited){
//			for(DArrow arrow : cur.getDSource().getDIncomings()){
//				if(arrows.contains(arrow) && !visited.contains(arrow)){
//					buffer.append(" and (");
//					translateRelatedMatch(arrow, visited, visitedNode, arrows, nodes, commonNodes, commonArrows, delete);
//					buffer.append(")");
//				}
//			}
//			for(DArrow arrow : cur.getDSource().getDOutgoings()){
//				if(arrows.contains(arrow) && !visited.contains(arrow)){
//					buffer.append(" and (");
//					translateRelatedMatch(arrow, visited, visitedNode, arrows, nodes, commonNodes, commonArrows, delete);
//					buffer.append(")");
//				}
//			}
//		}
//		if(!trgVisited && !ref){
//			for(DArrow arrow : cur.getDTarget().getDIncomings()){
//				if(arrows.contains(arrow) && !visited.contains(arrow)){
//					buffer.append(" and (");
//					translateRelatedMatch(arrow, visited, visitedNode, arrows, nodes, commonNodes, commonArrows, delete);
//					buffer.append(")");
//				}
//			}
//			for(DArrow arrow : cur.getDTarget().getDOutgoings()){
//				if(arrows.contains(arrow) && !visited.contains(arrow)){
//					buffer.append(" and (");
//					translateRelatedMatch(arrow, visited, visitedNode, arrows, nodes, commonNodes, commonArrows, delete);
//					buffer.append(")");
//				}
//			}
//		}
//		buffer.append(")");
//	}

	/*
	 * Check if an arrow in a graph is key point: removing the arrow, can split the graph into two unrelated subgraphs.
	 */
//	private boolean isKeyArrow(DArrow arrow, List<DArrow> arrows, List<DNode> nodes){
//		List<DNode> left = new ArrayList<DNode>();
//		left.addAll(nodes);
//		List<DArrow> leftArrows = new ArrayList<DArrow>();
//		leftArrows.addAll(arrows);
//		leftArrows.remove(arrow);
//		return !isRelated(leftArrows, left);
//	}
//	private boolean isRelated(List<DArrow> leftArrows, List<DNode> left) {
//		List<DNode> reached = new ArrayList<DNode>(), visited = new ArrayList<DNode>();
//		if(!left.isEmpty())
//			visited.add(left.get(0));
//		while(!visited.isEmpty()){
//			DNode cur = visited.get(0);
//			visited.remove(cur);
//			reached.add(cur);
//			for(DArrow iter : cur.getDOutgoings()){
//				DNode target = iter.getDTarget();
//				if(leftArrows.contains(iter) && !(visited.contains(target) ||reached.contains(target)))
//					visited.add(target);
//			}
//			for(DArrow iter : cur.getDIncomings()){
//				DNode source = iter.getDSource();
//				if(leftArrows.contains(iter) && !(visited.contains(source) ||reached.contains(source)))
//					visited.add(source);
//			}				
//		}
//		return reached.size() == left.size();
//	}
//	private int priority(DArrow arrow, List<DArrow> arrows, List<DNode> nodes){
//		if(arrow.getDSource() == arrow.getDTarget()) return 1;
//		if(isKeyArrow(arrow, arrows, nodes)) return 2;
//		else return 0;
//	}
//	private void getCommonSubgraph(List<DNode> subn, List<DArrow> suba, List<DNode> subcn, List<DArrow> subca, List<DNode> commonNodes, List<DArrow> commonArrows){
//		for(DNode node : subn)
//			if(commonNodes.contains(node) && !subcn.contains(node))
//				subcn.add(node);
//		for(DArrow arrow : suba)
//			if(commonArrows.contains(arrow) && !subca.contains(arrow))
//				subca.add(arrow);
//	}
	
	private String ADDNODE(String source) {
		return " (nodes (sm t) " + source + ") (ans t " + source + ")";
	}
	private String DELNODE(String source) {
		return " (nodes (sm t) " + source + ") (dns t " + source + ")";
	}
	private String COMNODE(String source) {
		return " (nodes (sm t) " + source + ") (not (dns t " + source + "))";
	}
	private String COMEDGE(String the) {
		return " (edges (sm t) " + the + ") (not (des t " + the + "))";
	}
	private String ADDEDGE(String the) {
		return " (edges (sm t) " + the + ") (aes t " + the + ")";
	}
	private String DELEDGE(String the) {
		return " (edges (sm t) " + the + ") (des t " + the + ")";
	}
	public  void translateRelatedMatch(List<DNode> leftNodes, List<DArrow> leftEdges,  
			 List<DNode> commonNodes, List<DArrow> commonEdges, 
			 List<DNode> rightNodes, List<DArrow> rightEdges) {
				
		Set<DArrow> edges = new HashSet<DArrow>();
		edges.addAll(leftEdges);
		edges.addAll(rightEdges);
		buffer.append("\t");
		translateRelatedMatch((DArrow)edges.iterator().next(), 
				new ArrayList<DArrow>(), new ArrayList<DNode>(), 
				leftNodes, leftEdges, 
				commonNodes, commonEdges, 
				rightNodes, rightEdges);
		buffer.append(LINE + LINE);
	}
	/**
	 * encoding a match from a connected graph to another graph
	 */
	/**
	 * @param arrows
	 * @param nodes
	 * @param commonNodes
	 * @param commonArrows
	 * @param delete
	 */
//	@SuppressWarnings("unchecked")
//	public  void translateRelatedMatch(List<DArrow> arrows, List<DNode> nodes, List<DNode> commonNodes, List<DArrow> commonArrows, boolean delete) {
//		Map<DArrow, List<DArrow>> typeHash = new HashMap<DArrow, List<DArrow>>();
//		for(DArrow iter : arrows){
//			if(commonArrows.contains(iter)) continue;
//			DArrow type = iter.getDType();
//			List<DArrow> sameType = typeHash.get(type);
//			if(sameType == null)
//				sameType = new ArrayList<DArrow>();
//			sameType.add(iter);
//			typeHash.put(type, sameType);			
//		}
//		Map<DArrow, List<DArrow>> hash = new HashMap<DArrow, List<DArrow>>();
//		for(DNode iter : commonNodes){
//			List<DArrow> reduct = new ArrayList<DArrow>();
//			for(DArrow arrow : iter.getDIncomings()){
//				List<DArrow> sameType = typeHash.get(arrow.getDType());
//				if(arrows.contains(arrow) && !commonArrows.contains(arrow) && sameType != null && sameType.size() == 1)
//					reduct.add(arrow);
//			}
//			for(DArrow arrow : iter.getDOutgoings()){
//				List<DArrow> sameType = typeHash.get(arrow.getDType());
//				if(arrows.contains(arrow) && !commonArrows.contains(arrow) && sameType != null && sameType.size() == 1 && !reduct.contains(arrow))
//					reduct.add(arrow);
//			}
//			if(reduct.size() < 2) continue;
//			if(reduct.size() == 2 && arrows.size() == 2) continue;
//			DArrow chosen = reduct.get(0);
//			int priority = priority(chosen, arrows, nodes);
//			for (int i = 1; i < reduct.size(); i++) {
//				DArrow next = reduct.get(i);
//				int p1 = priority(next, arrows, nodes);
//				if(p1>priority){
//					chosen = next;
//					priority = p1;
//				}
//			}
//			for (int i = 0; i < reduct.size(); i++) {
//				for (int j = i + 1; j < reduct.size(); j++) {
//					DArrow first = reduct.get(i), second = reduct.get(j);
//					if(first!= chosen && second != chosen) continue;
//					List<DArrow> suba = new ArrayList<DArrow>(), subca = new ArrayList<DArrow>();
//					suba.add(first);
//					suba.add(second);
//					List<DNode> subn = new ArrayList<DNode>(), subcn = new ArrayList<DNode>();
//					subn.add(first.getDSource());
//					if(!subn.contains(first.getDTarget()))
//						subn.add(first.getDTarget());
//					if(!subn.contains(second.getDSource()))
//						subn.add(second.getDSource());
//					if(!subn.contains(second.getDTarget()))
//						subn.add(second.getDTarget());
//					getCommonSubgraph(subn, suba, subcn, subca, commonNodes, commonArrows);
//					buffer.append("\t");
//					translateRelatedMatch(suba.get(0), new ArrayList<DArrow>(), new ArrayList<DNode>(), suba, subn, subcn, subca, delete);
//					//					buffer.append("some " + first.getName() + ":" + edgeSig(first.getArrow().getTypeArrow()) + "&" + (delete ? DELETEARROW : ADDARROW) + "|some "+ second.getName() + ":" + edgeSig(second.getArrow().getTypeArrow()) + "&" + (delete ? DELETEARROW : ADDARROW));
//					//					buffer.append("|" + first.getName() + (first.getDSource() == iter ? ".src" : ".trg"));
//					//					buffer.append("=" + second.getName() + (second.getDSource() == iter ? ".src" : ".trg"));
//					buffer.append(LINE);
//				}
//			}
//			//			reduct.remove(chosen);
//			hash.put(chosen, reduct);
//		}
//		List<DNode> newNodes = new ArrayList<DNode>(nodes);
//		List<DArrow> newArrows = new ArrayList<DArrow>(arrows);
//		for(List<DArrow> iter : hash.values())
//			newArrows.removeAll(iter);
//		List<Object> relatedSet = new ArrayList<Object>();
//		getConnectedSubgraphs(newNodes, newArrows, relatedSet);
//		for(int index = 0; index < relatedSet.size(); index += 2){
//			List<DNode> subn = (List<DNode>) relatedSet.get(index);
//			List<DArrow> suba = (List<DArrow>) relatedSet.get(index + 1);
//			List<DNode>  subcn = new ArrayList<DNode>();
//			List<DArrow>  subca = new ArrayList<DArrow>();
//			for(DArrow iter : hash.keySet()){
//				boolean source = subn.contains(iter.getDSource()) && commonNodes.contains(iter.getDSource()) && !suba.contains(iter);
//				boolean target = subn.contains(iter.getDTarget()) && commonNodes.contains(iter.getDTarget()) && !suba.contains(iter);
//				if(source){
//					suba.add(iter);
//					if(!subn.contains(iter.getDTarget())) subn.add(iter.getDTarget());
//				}
//				if(target){
//					suba.add(iter);
//					if(!subn.contains(iter.getDSource())) subn.add(iter.getDSource());
//				}
//			}
//			getCommonSubgraph(subn, suba, subcn, subca, commonNodes, commonArrows);
//			buffer.append("\t");
//			if(suba.size() > 0)
//				translateRelatedMatch(suba.get(0), new ArrayList<DArrow>(), new ArrayList<DNode>(), suba, subn, subcn, subca, delete);
//			else
//				buffer.append("some " + nodeSig(nodes.get(0).getNode().getTypeNode()) + "&" + 
//						(commonNodes.contains(nodes.get(0))? COMNODE : (delete ? DELNODE : ADDNODE)));
//			buffer.append(LINE);
//		}
//		return;
//	}
	//		if(arrows.size() > 0)
	//			translateRelatedMatch(arrows.get(0), new ArrayList<DArrow>(), new ArrayList<DNode>(), arrows, nodes, commonNodes, commonArrows, delete);
	//		else
	//			buffer.append("some " + nodeSig(nodes.get(0).getNode().getTypeNode()) + "&" + 
	//					(commonNodes.contains(nodes.get(0))? COMMONNODE : (delete ? DELETENODE : ADDNODE)));
	public  void translateRelatedMatchOld(List<DArrow> arrows, List<DNode> nodes, List<DNode> commonNodes, List<DArrow> commonArrows, boolean delete) {
		boolean nochange = nodes.size() == commonNodes.size() && arrows.size() == commonArrows.size();
		buffer.append(nochange ? "some " : "one ");
		Map<DNode, DArrow> derivedBySource = new HashMap<DNode, DArrow>(), derivedByTarget = new HashMap<DNode, DArrow>();
		for (Iterator<DArrow> iterator = arrows.iterator(); iterator.hasNext();) {
			DArrow dArrow = (DArrow) iterator.next();
			buffer.append("e_" + dArrow.getName() + ":" + edgeSig(dArrow.getArrow().getTypeArrow()) + "&");
			buffer.append(commonArrows.contains(dArrow) ? COMEDGE : (delete? DELEDGE : ADDEDGE));
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
			buffer.append(nodeSig(dNode.getNode().getTypeNode()) + "&");
			buffer.append((commonNodes.contains(dNode) ? COMNODE : (delete? DELNODE : ADDNODE)) + LINE);
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
		List<String> matches = new ArrayList<String>();
		String iter = "";
		for (Iterator<DArrow> iterator = arrows.iterator(); iterator.hasNext();) {
			DArrow arrow = (DArrow) iterator.next();
			DNode src = arrow.getDSource(); 
			boolean isSrcDerived = derivedBySource.get(src) == arrow;
			if(!isSrcDerived)
				iter += "n_" + src.getName() + " = e_" + arrow.getName() + ".src ";

			DNode trg = arrow.getDTarget();
			boolean isTrgDerived = derivedByTarget.get(trg) == arrow;
			if(!isTrgDerived){
				if(!isSrcDerived) 
					iter += "and ";
				iter += "n_" + trg.getName() + " = e_" + arrow.getName() + ".trg ";
			}
			if(iterator.hasNext() && (!isSrcDerived || !isTrgDerived))
				iter += "and ";
		}
		if(!iter.isEmpty()) matches.add(iter);
		iter = "";

		List<DNode> changedNodes = new ArrayList<DNode>();
		for(DNode node : nodes)
			if(!commonNodes.contains(node))
				changedNodes.add(node);
		for(int i = 0; i < changedNodes.size(); i++){
			DNode node = changedNodes.get(i);
			iter += "n_" + node.getName()  + " in " + nodeSig(node.getNode().getTypeNode()) + "&" +  (delete ? DELNODE : ADDNODE);
			if(i < changedNodes.size() - 1)
				iter += " and ";
		}

		if(!iter.isEmpty()) matches.add(iter);
		iter = "";
		for(int i = 0; i < commonNodes.size(); i++){
			DNode node = commonNodes.get(i);
			iter += "n_" + node.getName()  + " in " + nodeSig(node.getNode().getTypeNode()) + "&" +  COMNODE;
			if(i < commonNodes.size() - 1)
				iter += " and ";
		}
		if(!iter.isEmpty()) matches.add(iter);
		for (int i = 0; i < matches.size(); i++) {
			if(i != 0)
				buffer.append(" and" + LINE);
			buffer.append(matches.get(i));
		}
		buffer.append(")" + LINE);
	}
	
	public  void translateRelatedMatch(List<DArrow> arrows, List<DNode> nodes, List<DNode> commonNodes, List<DArrow> commonArrows, boolean delete, Object replaced) {
		boolean nochange = nodes.size() == commonNodes.size() && arrows.size() == commonArrows.size();
		buffer.append(nochange ? "some " : "one ");
		Map<DNode, DArrow> derivedBySource = new HashMap<DNode, DArrow>(), derivedByTarget = new HashMap<DNode, DArrow>();
		int size = arrows.size() - (arrows.contains(replaced) ? 1 : 0);
		int count = 0;
		for(int index = 0; index < arrows.size(); ++index){
			DArrow dArrow = arrows.get(index);
			if(dArrow != replaced){
				++count;
				buffer.append("e_" + dArrow.getName() + ":" + edgeSig(dArrow.getArrow().getTypeArrow()) + "&");
				buffer.append(commonArrows.contains(dArrow) ? COMEDGE : (delete? DELEDGE : ADDEDGE));
				if(count != size - 1)
					buffer.append(", ");
			}
			DNode src = dArrow.getDSource(), trg = dArrow.getDTarget();
			if(!derivedBySource.containsKey(src) && !derivedByTarget.containsKey(src))
				derivedBySource.put(src, dArrow);
			if(!derivedBySource.containsKey(trg) && !derivedByTarget.containsKey(trg))
				derivedByTarget.put(trg, dArrow);
		}
		if(arrows.size() == 0){
			DNode dNode = nodes.get(0);
			if(dNode != replaced){
				buffer.append(nodeSig(dNode.getNode().getTypeNode()) + "&");
				buffer.append((commonNodes.contains(dNode) ? COMNODE : (delete? DELNODE : ADDNODE)) + LINE);
			}
			return;
		}
		buffer.append(" |" + LINE + "let ");
		for (Iterator<Entry<DNode, DArrow>> iterator = derivedBySource.entrySet().iterator(); iterator.hasNext();) {
			Entry<DNode, DArrow> entry = (Entry<DNode, DArrow>) iterator.next();
			String key = entry.getKey() == replaced ? "_n" : entry.getKey().getName();
			String value = entry.getValue() == replaced? "_e" : entry.getValue().getName();
			buffer.append("n_" + key + " = e_" + value + ".src");
			if(iterator.hasNext()) 
				buffer.append(", ");
		}
		if(!derivedBySource.isEmpty() && !derivedByTarget.isEmpty())
			buffer.append(", ");
		for (Iterator<Entry<DNode, DArrow>> iterator = derivedByTarget.entrySet().iterator(); iterator.hasNext();) {
			Entry<DNode, DArrow> entry = (Entry<DNode, DArrow>) iterator.next();
			String key = entry.getKey() == replaced ? "_n" : entry.getKey().getName();
			String value = entry.getValue() == replaced? "_e" : entry.getValue().getName();
			buffer.append("n_" + key + " = e_" + value + ".trg");
			if(iterator.hasNext())
				buffer.append(", ");
		}
		buffer.append(" |" + LINE + "(");
		for (Iterator<DArrow> iterator = arrows.iterator(); iterator.hasNext();) {
			DArrow arrow = (DArrow) iterator.next();
			DNode src = arrow.getDSource(); 
			boolean isSrcDerived = derivedBySource.get(src) == arrow;
			if(!isSrcDerived){
				String key = src == replaced ? "_n" : src.getName();
				String value = arrow == replaced? "_e" : arrow.getName();
				buffer.append("n_" + key + " = e_" + value + ".src ");
			}

			DNode trg = arrow.getDTarget();
			boolean isTrgDerived = derivedByTarget.get(trg) == arrow;
			if(!isTrgDerived){
				if(!isSrcDerived) 
					buffer.append("and ");
				String key = trg == replaced ? "_n" : trg.getName();
				String value = arrow == replaced? "_e" : arrow.getName();
				buffer.append("n_" + key + " = e_" + value + ".trg ");
			}
			if(iterator.hasNext() && (!isSrcDerived || !isTrgDerived))
				buffer.append("and ");
		}

		List<DNode> changedNodes = new ArrayList<DNode>();
		for(DNode node : nodes)
			if(!commonNodes.contains(node) && node != replaced)
				changedNodes.add(node);
		if(changedNodes.size() > 0)
			buffer.append(LINE + "and ");
		for(int i = 0; i < changedNodes.size(); i++){
			DNode node = changedNodes.get(i);
			buffer.append("n_" + node.getName()  + " in " + nodeSig(node.getNode().getTypeNode()) + "&" +  (delete ? DELNODE : ADDNODE));
			if(i < changedNodes.size() - 1)
				buffer.append(" and ");
		}

		if(commonNodes.size()  > 0)
			buffer.append(LINE + "and ");
		for(int i = 0; i < commonNodes.size(); i++){
			DNode node = commonNodes.get(i);
			buffer.append("n_" + node.getName()  + " in " + nodeSig(node.getNode().getTypeNode()) + "&" +  COMNODE);
			if(i < commonNodes.size() - 1)
				buffer.append(" and ");
		}

		buffer.append(")" + LINE);
	}

	/**
	 * If no instance of a type is deleted(added).
	 */
	public  void noNodeChanged(List<DNode> nodes, List<DNode> commonNodes,  List<DNode> all, boolean delete){
		String tpre = delete ? "dns" : "ans";
		List<DNode> hide = new ArrayList<DNode>();
		hide.addAll(all);
		for(DNode node : nodes){
			if(!commonNodes.contains(node)){
				DNode type = node.getDType();
				if(hide.contains(type))
					hide.remove(type);
			}
		}
		if(all.size() == hide.size()){
			buffer.append("\t(not (exists ((n Int)) (and (NODE n) (" + tpre + " t e))))" + LINE);
			return;
		}
		for (int i = 0; i < hide.size(); i++) {
			DNode node = hide.get(i);
			if(node instanceof DConstraintNode) 
				continue;
			buffer.append("\t(not (exists ((n Int)) (and (" + nodeSig(node.getNode()) + " n) (" + tpre + " t n))))" + LINE);
		}
	}
	public  void noEdgeChanged(List<DArrow> arrows, List<DArrow> commonArrows,  List<DArrow> all, boolean delete){
		String tpre = delete ? "des" : "aes"; 
		List<DArrow> hide = new ArrayList<DArrow>();
		hide.addAll(all);
		for(DArrow arrow : arrows){
			if(!commonArrows.contains(arrow)){
				DArrow type = arrow.getDType();
				if(hide.contains(type))
					hide.remove(type);
			}
		}
		if(all.size() == hide.size()){
			buffer.append("\t(not (exists ((e Int)) (and (EDGE e) (" + tpre + " t e))))" + LINE);
			return;
		}
		for (int i = 0; i < hide.size(); i++) {
			buffer.append("\t(not (exists ((e Int)) (and (" + edgeSig(hide.get(i).getArrow()) + " e) (" + tpre + " t e))))" + LINE);
		}
//		buffer.append("\tno (" + temp + ")&" + tpre + LINE);
	}
	/*
	 * If more than one instance of a type is deleted(added), it must be matched by the left(right) part of the rule.
	 * If only one instance of a type is deleted(added), we use number restricted to encoding the constraint.
	 */
	public  void nodesChanged(List<DNode> nodes, List<DArrow> arrows, List<DNode> commonNodes, List<DArrow> commonArrows, boolean delete){
		String tpre = delete ? "dns" : "ans";
		Map<DNode, List<DNode>> counters = new HashMap<DNode, List<DNode>>();
		for(DNode node : nodes){
			if(!commonNodes.contains(node)){
				DNode type = node.getDType();
				List<DNode> nodesOfType = counters.get(type);
				if(nodesOfType == null){
					nodesOfType = new ArrayList<DNode>();
					nodesOfType.add(node);
					counters.put(type, nodesOfType);
				}
				else
					nodesOfType.add(node);
			}
		}
		for(Entry<DNode, List<DNode>> entry : counters.entrySet()){
			List<DNode> count = entry.getValue();
			buffer.append("\t(and ");
			buffer.append(NodeMultiplicity(count.size(), nodeSig(entry.getKey().getNode()), tpre));
			buffer.append(" (not ");
			buffer.append(NodeMultiplicity(count.size()+1, nodeSig(entry.getKey().getNode()), tpre));
			buffer.append("))" + LINE);
//			if(count.size() == 1)
//				buffer.append("\t#" + nodeSig(entry.getKey().getNode()) + "&" + tpre + " = " + count.size() + LINE);
//			else{
//				buffer.append("\tall n : (" + nodeSig(entry.getKey().getNode()) + "&" + tpre + ")|");
//				for(int index = 0; index < count.size(); ++index){
//					if(index != 0)
//						buffer.append(" or ");
//					hasOneMatch(nodes, arrows, commonNodes, commonArrows, count.get(index), delete);
//				}
//			}
		}
	}
	private String NodeMultiplicity(int min, String node, String del){
		String result = "";
		if(min > 0){
			result += "(exists ((n1 Int)";
			for(int index = 2; index <= min; index++)
				result += " (n" + index + " Int)";
			result += ") (and";
			for(int index = 1; index <= min; index++)
				result += " (" + del + " t n" + index + ") (" + node + " n" +  index + ")";
			if(min > 1){
				result += " (distinct";
				for(int index = 1; index <= min; index++)
					result += " n" +  index;
				result += ")";
			}
			result += "))";
		}
		return result;
	}
	private String multiplicity(int min, String arrow, String del){
		String result = "";
		if(min > 0){
			result += "(exists ((e1 Int)";
			for(int index = 2; index <= min; index++)
				result += " (e" + index + " Int)";
			result += ") (and";
			for(int index = 1; index <= min; index++)
				result += " (" + del + " t e" + index + ") (" + arrow + " e" +  index + ")";
			if(min > 1){
				result += " (distinct";
				for(int index = 1; index <= min; index++)
					result += " e" +  index;
				result += ")";
			}
			result += "))";
		}
		return result;
	}
	public  void edgesChanged(List<DNode> nodes, List<DArrow> arrows, List<DNode> commonNodes, List<DArrow> commonArrows, boolean delete){
		String tpre = delete ? "des" : "aes";
		Map<DArrow, List<DArrow>> counters = new HashMap<DArrow, List<DArrow>>();
		for(DArrow arrow : arrows){
			if(!commonArrows.contains(arrow)){
				DArrow type = arrow.getDType();
				List<DArrow> arrowsOfType = counters.get(type);
				if(arrowsOfType == null){
					arrowsOfType = new ArrayList<DArrow>();
					arrowsOfType.add(arrow);
					counters.put(type, arrowsOfType);
				}
				else
					arrowsOfType.add(arrow);
			}
		}
		for(Entry<DArrow, List<DArrow>> entry : counters.entrySet()){
			List<DArrow> count = entry.getValue();
			buffer.append("\t(and ");
			buffer.append(multiplicity(count.size(), edgeSig(entry.getKey().getArrow()), tpre));
			buffer.append(" (not ");
			buffer.append(multiplicity(count.size()+1, edgeSig(entry.getKey().getArrow()), tpre));
			buffer.append("))" + LINE);
//			if(count.size() == 1)
//				buffer.append("\t#" + edgeSig(entry.getKey().getArrow()) + "&" + tpre + " = " + count.size() + LINE);
//			else{
//				buffer.append("\tall n : (" + edgeSig(entry.getKey().getArrow()) + "&" + tpre + ")|");
//				for(int index = 0; index < count.size(); ++index){
//					if(index != 0)
//						buffer.append(" or ");
//					hasOneMatch(nodes, arrows, commonNodes, commonArrows, count.get(index), delete);
//				}
//			}
		}
	}

	/*
	 * the entrance method to encode a model transformation system
	 */
	public void translate(){
		buffer.append("(set-option :produce-models true)" + LINE);
		buffer.append("(set-option :model.compact true)" + LINE);		
		buffer.append("(set-option :smt.pull-nested-quantifiers true)" + LINE);
		buffer.append("(set-option :auto-config false)" + LINE);
		buffer.append("(set-option :smt.mbqi true)" + LINE);
		buffer.append("(set-option :produce-unsat-cores true)" + LINE + LINE);
		
		buffer.append("(declare-const NULL Int)" + LINE);
		buffer.append("(assert (= NULL 0))" + LINE + LINE);
		nodeSigs();
		edgeSigs();
		if(rules != null){
			graphSig();
			ruleSigs();
			tranSig();
			fact(rules);
			for(Production rule : rules)
				pre_rule(rule, dGraph);
		}
		pre_source_valid();
//		if(rules != null){
//			run_command();
//		}
		buffer.append("(check-sat)\n(get-unsat-core)");
	}
	private String targetNodes = "&t.tm.ns", targetArrows = "&t.tm.es";
	private void run_command() {
		for(Arrow arrow : dType.getSpecification().getGraph().getArrows()){
			boolean isMult = false;
			for(Constraint constraint : arrow.getConstraints()){
				if(constraint.getPredicate() == DPFConstants.ARROW_MULTI){
					isMult = true;
					break;
				}
			}
			if(!isMult)
				commands.add(translateArrowMultiplicity(arrow));
		}
		for(Constraint constraint : dType.getSpecification().getConstraints()){
			Predicate predicate  = constraint.getPredicate();
			if(predicate == DPFConstants.INJECTIVE)
				commands.add(translateInjective(constraint));
			else if(predicate == DPFConstants.SURJECTIVE)
				commands.add(translateSurjective(constraint));
			else if(predicate == DPFConstants.ARROW_MULTI)
				commands.add(translateArrowMultiplicity(constraint));
			else if(predicate == DPFConstants.NODE_MULTI)
				commands.add(translateNodeMultiplicity(constraint));
			else if(predicate == DPFConstants.XOR)
				commands.add(translateXOR(constraint));
			else if(predicate == DPFConstants.XOR4)
				commands.add(translateXOR4(constraint));
			else if(predicate == DPFConstants.MERGE_NAND)
				commands.add(translateMergeNAND(constraint));
			else if(predicate == DPFConstants.SPLIT_NAND)
				commands.add(translateSplitNAND(constraint));
			else if(predicate == DPFConstants.REFLEXIVE)
				commands.add(translateReflexive(constraint));
		}
	}

	/**
	 * translate Transformation to Alloy
	 */
	public TranslateToSMT(Transform transform){
		dType  = transform.getElementTypeGraph();
		dGraph = transform.getElementTypeGraph().getDGraph();
		rules = transform.getRules();
	}
	/**
	 * translate Diagram model to Alloy
	 */
	public TranslateToSMT(DSpecification diagramModel){
		dType  = diagramModel;
		dGraph = dType.getDGraph();
		rules = null;
		targetArrows = "";
		targetNodes = "";
	}
	public Object getBuffer() {
		return buffer;
	}
	public List<String> commands = new ArrayList<String>();
	String current = null;

	public void writeToFile(File file) throws IOException{
		FileWriter writer = new FileWriter(file);
		writer.write(buffer.toString());
		writer.close();
	}
}
