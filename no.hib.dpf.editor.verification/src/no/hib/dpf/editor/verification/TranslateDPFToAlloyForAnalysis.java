package no.hib.dpf.editor.verification;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.ValidatorType;
import no.hib.dpf.core.impl.PredicateImpl;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.uconstraint.Constraints;
import no.hib.dpf.uconstraint.UConstraint;

public class TranslateDPFToAlloyForAnalysis {

	/*
	 * Graph structure to alloy specification
	 */

	static public  final String LINE = System.lineSeparator();
	static public  final String NP = "N";
	static public  final String AP = "E";
	static public  final String SIG = "sig ";

	//	private String nodes = null;
	//	private String arrows = null;
	private StringBuffer buffer = new StringBuffer();
	private DGraph dGraph = null;
	private DSpecification model = null;

	private Map<IDObject, String> element2Name = new HashMap<IDObject, String>();
	private Map<String, IDObject> name2Element = new HashMap<String, IDObject>();
	private int index = 0;
	public  String nodeSig(Node node){ 
		String name = element2Name.get(node);
		if(name == null){
			name = NP + index ++;
			element2Name.put(node, name);
			name2Element.put(name, node);
		}
		return name;
	 }
	public  String edgeSig(Arrow edge){ 
		String name = element2Name.get(edge);
		if(name == null){
			name = AP + index ++;
			element2Name.put(edge, name);
			name2Element.put(name, edge);
		}
		return name;
	}
	public List<Node> enums = new ArrayList<Node>();

	public Map<String, List<String>> enumer = new HashMap<String, List<String>>();
	//signatures for nodes
	public  void nodeSigs(){
		buffer.append("//signatures for nodes" + LINE);
		for(Node node : dGraph.getGraph().getNodes()){
			Constraint cenum = null;
			for (Constraint iter : node.getConstraints()) 
				if(iter.getPredicate().getSymbol().equals("enum"))
					cenum = iter;
			if(cenum != null){
				enums.add(node);
				List<String> ins = new ArrayList<String>();
				String literals = cenum.getParameters();
				String LITERALS = "literal:{";
				buffer.append(SIG + nodeSig(node) + "{}" + LINE);
				literals = literals.substring(literals.indexOf(LITERALS) + LITERALS.length(), literals.length() - 1);
				String[] liters = literals.split(",");
				buffer.append("lone " + SIG + "N" + liters[0].trim());
				ins.add(liters[0].trim());
				for(int index = 1; index < liters.length; ++index){
					buffer.append(", N" + liters[index].trim());
					ins.add(liters[index].trim());
				}
				enumer.put(node.getName(), ins);
				buffer.append(" extends " + nodeSig(node) + "{}" + LINE);
			}else{
				buffer.append(SIG + nodeSig(node) + "{}" + LINE);
				buffer.append("fact{some "+ nodeSig(node) + "}" + LINE);
			}
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

	/**
	 * Each source model satisfies all the constraints on the metamodel. In this way, every source model is valid.<br>
	 * 1. Each arrow has a default constraint multi[0,1]. Translate the default constraint first.<br>
	 * 2. Then translate the other constraint associated with the metamodel.<br>
	 */
	public Map<Object, String> hash = new HashMap<Object, String>();
	private Object[] findOverlap(Object c1, Object c2){
		List<Node> n1 = null, n2 = null;
		List<Arrow> e1 = null, e2 = null;
		if(c1 instanceof Constraint){
			n1 = ((Constraint)c1).getNodes();
			e1 = ((Constraint)c1).getArrows();
		}else if (c1 instanceof Arrow){
			n1 = new ArrayList<Node>();
			n1.add(((Arrow)c1).getSource());
			n1.add(((Arrow)c1).getTarget());
			e1 = new ArrayList<Arrow>();
			e1.add((Arrow)c1);
		}else{
			UConstraint uc = (UConstraint) c1;
			Graph g = uc.getSum().getSpecification().getGraph();
			n1 = new ArrayList<Node>();
			for(Node iter : g.getNodes()){
				if(!n1.contains(iter.getTypeNode()))
					n1.add(iter.getTypeNode());
			}
			e1 = new ArrayList<Arrow>();
			for(Arrow iter : g.getArrows()){
				if(!e1.contains(iter.getTypeArrow()))
					e1.add(iter.getTypeArrow());
			}
		}
		if(c2 instanceof Constraint){
			n2 = ((Constraint)c2).getNodes();
			e2 = ((Constraint)c2).getArrows();
		}else if (c2 instanceof Arrow){
			n2 = new ArrayList<Node>();
			n2.add(((Arrow)c2).getSource());
			n2.add(((Arrow)c2).getTarget());
			e2 = new ArrayList<Arrow>();
			e2.add((Arrow)c2);
		}else{
			UConstraint uc = (UConstraint) c2;
			Graph g = uc.getSum().getSpecification().getGraph();
			n2 = new ArrayList<Node>();
			for(Node iter : g.getNodes()){
				if(!n2.contains(iter.getTypeNode()))
					n2.add(iter.getTypeNode());
			}
			e2 = new ArrayList<Arrow>();
			for(Arrow iter : g.getArrows()){
				if(!e2.contains(iter.getTypeArrow()))
					e2.add(iter.getTypeArrow());
			}
		}
		List<Node> nodes = intersection(n1, n2);
		List<Arrow> edges = intersection(e1, e2);
		if(nodes.isEmpty() && edges.isEmpty()) return null;
		return new Object[]{nodes, edges};
	}
	private void translate(Constraint constraint, String prefix){
		
		Predicate predicate  = constraint.getPredicate();
		String predName = getConstraintName(constraint);
		buffer.append(prefix + " " + predName + "[]{" + LINE);
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
		else if(predicate == DPFConstants.IRREFLEXIVE)
			buffer.append(translateIrreflexive(constraint));
		else if(predicate == DPFConstants.JOINT_SURJ)
			buffer.append(translateJointSurjective(constraint));
		else 
			buffer.append(translateGeneral(constraint));

		buffer.append("}" + LINE);
	}
	public void pre_source_valid(){
		for(Arrow arrow : model.getSpecification().getGraph().getArrows()){
			boolean isMult = false;
			for(Constraint constraint : arrow.getConstraints()){
				if(constraint.getPredicate() == DPFConstants.ARROW_MULTI){
					isMult = true;
					break;
				}
			}
			if(!isMult){
				hash.put(arrow, "mult1_" + arrow.getName());
				buffer.append("pred mult1_" + arrow.getName() + "[]{" + LINE);
				buffer.append(translateArrowMultiplicity(arrow));
				buffer.append("}" + LINE);
			}
		}
		for(Constraint constraint : model.getSpecification().getConstraints()){
			if(check != null && constraint == check) continue;;
			Predicate predicate  = constraint.getPredicate();
			if(predicate.getSymbol().equals("string")
					|| predicate.getSymbol().equals("int") 
					|| predicate.getSymbol().equals("bool"))
				continue;
			String predName = getConstraintName(constraint);
			hash.put(constraint, predName);
			translate(constraint, "pred");
		}
		if(uc != null){
			for(UConstraint iter : uc.getRules()){
				buffer.append("pred " + iter.getName() + "[]{" + LINE);
				pre_rule(iter, dGraph);
				hash.put(iter, iter.getName());
				buffer.append(LINE + "}" + LINE);
			}
		}
	}
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
	private <T> List<T> intersection(List<T> A, List<T> B){
		List<T> result = new ArrayList<T>();
		for(T iter : A){
			if(!result.contains(iter) && B.contains(iter))
				result.add(iter);
		}
		return result;
	}
	public  void translateRelatedMatch(List<DNode> leftNodes, List<DArrow> leftEdges,  
			List<DNode> commonNodes, List<DArrow> commonEdges, 
			List<DNode> rightNodes, List<DArrow> rightEdges) {
		List<DArrow> visited = new ArrayList<DArrow>();
		List<DNode> visitedNode= new ArrayList<DNode>();
		String name = null, type = null;
		boolean isLeftExist = true;
		if(!commonEdges.isEmpty()){
			translateRelatedMatch(commonEdges.get(0), "all ", visited, visitedNode, commonNodes, commonEdges);
		}else if(!commonNodes.isEmpty()){
			DNode node = commonNodes.get(0);
			visitedNode.add(node);
			name = node.getNode().getName();
			type = nodeSig(node.getNode().getTypeNode());
			buffer.append("all " + name + ":" + type + "|");
		}else{
			isLeftExist = false;
		}
		if(leftEdges.size() > commonEdges.size()){
			if(isLeftExist) buffer.append(" and");
			buffer.append(" not (");
			for(DArrow iter : leftEdges){
				if(!visited.contains(iter)){
					translateRelatedMatch(iter, "some ", visited, visitedNode, leftNodes, leftEdges);
				}
			}
			buffer.append(")");
			isLeftExist = true;
		}
		if(isLeftExist)
			buffer.append(" implies (");
		for(DArrow iter : rightEdges){
			if(!visited.contains(iter)){
				translateRelatedMatch(iter, "some ", visited, visitedNode,  rightNodes, rightEdges);
			}
		}
		if(isLeftExist)
			buffer.append(") ");
	}
	public  boolean translateRelatedMatch(DArrow cur, String prefix, 
			List<DArrow> visited, List<DNode> visitedNode, 
			List<DNode> leftNodes, List<DArrow> leftEdges) {
		String the = cur.getArrow().getName(), source = cur.getArrow().getSource().getName(), target = cur.getArrow().getTarget().getName();
		buffer.append(prefix);//kept ? "some " : "one ");
		buffer.append(the +":");
		buffer.append(edgeSig(cur.getArrow().getTypeArrow()));
		buffer.append("|");
		boolean srcVisited = visitedNode.contains(cur.getDSource()), trgVisited =  visitedNode.contains(cur.getDTarget());
		boolean srcIsEnum = IsEnum(cur.getArrow().getSource().getTypeNode().getName(), source), trgIsEnum = IsEnum(cur.getArrow().getTarget().getTypeNode().getName(), target);
		visitedNode.add(cur.getDSource());
		visitedNode.add(cur.getDTarget());
		visited.add(cur);
		if(srcVisited && trgVisited){
			if(srcIsEnum)
				buffer.append(source + " in N" + source);
			else
				buffer.append(the + ".src=" + source);
			buffer.append(" and ");
			if(trgIsEnum)
				buffer.append(target + " in N" + target);
			else
				buffer.append(the + ".trg=" + target);
			return true;
		}

		String let = "";
		buffer.append("let ");
		boolean ref = cur.getDSource() == cur.getDTarget();
		if(!srcVisited)
			let += (source + "=" + the + ".src");
		if(!srcVisited && !trgVisited && !ref)
			let += (",");
		if(!trgVisited && !ref)
			let += (target + "=" + the + ".trg");
		buffer.append(let);
		buffer.append("|" + LINE + "\t");
		StringBuffer buffer1 = new StringBuffer();
		if(srcIsEnum)
			buffer1.append(source + " in N" + source);
		else if(srcVisited)
			buffer1.append(the + ".src=" + source);
		if(!ref){
			if(trgIsEnum){
				if(buffer1.length() > 0)
					buffer1.append(" and ");
				buffer1.append(target + " in N" + target);
			}
			else if(trgVisited){
				if(buffer1.length() > 0)
					buffer1.append(" and ");
				buffer1.append(the + ".trg=" + target);
			}
		}

		if(!srcVisited){
			for(DArrow arrow : cur.getDSource().getDIncomings()){
				if(leftEdges.contains(arrow) && !visited.contains(arrow)){
					if(buffer1.length() > 0)
						buffer1.append(" and (");
					translateRelatedMatch(arrow, "some ", visited, visitedNode, leftNodes, leftEdges);
				}
			}
			for(DArrow arrow : cur.getDSource().getDOutgoings()){
				if(leftEdges.contains(arrow)  && !visited.contains(arrow)){
					if(buffer1.length() > 0)
						buffer1.append(" and (");
					translateRelatedMatch(arrow, "some ", visited, visitedNode, leftNodes, leftEdges);
					buffer1.append(")");
				}
			}
		}
		if(!trgVisited && !ref){
			for(DArrow arrow : cur.getDTarget().getDIncomings()){
				if(leftEdges.contains(arrow) && !visited.contains(arrow)){
					if(buffer1.length() > 0)
						buffer1.append(" and (");
					translateRelatedMatch(arrow, "some ", visited, visitedNode, leftNodes, leftEdges);
					buffer1.append(")");
				}
			}
			for(DArrow arrow : cur.getDTarget().getDOutgoings()){
				if(leftEdges.contains(arrow) && !visited.contains(arrow)){
					if(buffer1.length() > 0)
						buffer1.append(" and (");
					translateRelatedMatch(arrow, "some ", visited, visitedNode, leftNodes, leftEdges);
					buffer1.append(")");
				}
			}
		}
		if(buffer1.length() == 0) buffer1.append(let.replace(",", " and "));

		boolean containAnd = buffer1.length() > 0 && buffer1.indexOf(" and ") != -1;
		if(containAnd) buffer.append("(");
		buffer.append(buffer1);
		if(containAnd) buffer.append(")");
		return buffer1.length() > 0;
	}
	private boolean IsEnum(String name, String target) {
		return enumer.containsKey(name) && enumer.get(name).contains(target);
	}
	@SuppressWarnings("unchecked")
	public void pre_rule(UConstraint rule, DGraph dGraph){
		List<Object> relatedSet = new ArrayList<Object>();
		getConnectedSubgraphs(rule.getSum().getDGraph().getDNodes(), rule.getSum().getDGraph().getDArrows(), relatedSet);
		for(int index = 0; index < relatedSet.size(); index += 2){
			List<DNode> subn = (List<DNode>) relatedSet.get(index);
			List<DArrow> suba = (List<DArrow>) relatedSet.get(index + 1);
			translateRelatedMatch(intersection(subn, rule.getLeftNodes()), intersection(suba, rule.getLeftArrows()),
					intersection(subn, rule.getCommonNodes()), intersection(suba, rule.getCommonArrows()),
					intersection(subn, rule.getRightNodes()), intersection(suba, rule.getRightArrows()));
		}
	}
	private String translateJointSurjective(Constraint constraint) {
		Node target = getNode(constraint, "Z");
		Arrow xz = getArrow(constraint, "XZ"), yz = getArrow(constraint, "YZ");
		String result = "//" + "joint-surjective constraint between " + xz + " and " + yz + LINE + "\t";
		result += "all n:(" + NP + target.getName() + ") | let e1 = (some e : " + AP + xz.getName() + 
				" | e.trg = n), e2=(some e : " + AP + yz.getName() + " | e.trg = n)| e1 or e2" + LINE;
		return result;
	}
	private Object translateIrreflexive(Constraint constraint) {
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "reflexive on " + arrow +  LINE + "\t";
		result += "no e:(" + AP + arrow.getName() + ")| e.src = e.trg" + LINE;
		return result;
	}
	private String translateGeneral(Constraint constraint) {
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
					real += NP + nodeHash.get(variable);
				}else if(arrowHash.containsKey(variable)){
					real += AP + arrowHash.get(variable);
				}else return "";
				first = second = second + 1;
			}
			return real + LINE;
		}else if(predicate.getSymbol().equals("enum")){
			String literals = constraint.getParameters();
			String LITERALS = "literal:{";
			String theenum = nodeSig(constraint.getNodes().get(0));
			literals = literals.substring(literals.indexOf(LITERALS) + LITERALS.length(), literals.length() - 1);
			String[] liters = literals.split(",");
			String real = "";
			real += "\t" + theenum;
			real += " in N" + liters[0].trim();
			for (int i = 1; i < liters.length; i++) {
				real += "+N" + liters[i].trim();
			}
			real += LINE;
			return real;
		}
		return "";
	}
	private String translateReflexive(Constraint constraint) {
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "reflexive on " + arrow +  LINE + "\t";
		result += "all e:(" + AP + arrow.getName() + ")| e.src = e.trg" + LINE; 
		return result;
	}
	private String translateSplitNAND(Constraint constraint) {
		Node z = getNode(constraint, "Z");
		Arrow zx = getArrow(constraint, "ZX"), zy = getArrow(constraint, "ZY");
		String result = "//" + "NAND constraint between " + zx + " and " + zy + LINE + "\t";
		result += "all n:(" + NP + z.getName() + ") | let e1 = (some e : " + AP + zx.getName() + 
				" | e.src = n), e2=(some e : " + AP + zy.getName() + " | e.src = n)|not(e1 and e2)" + LINE;
		return result;
	}
	private String translateMergeNAND(Constraint constraint) {
		Node target = getNode(constraint, "Z");
		Arrow xz = getArrow(constraint, "XZ"), yz = getArrow(constraint, "YZ");
		String result = "//" + "NAND constraint between " + xz + " and " + yz + LINE + "\t";
		result += "all n:(" + NP + target.getName() + ") | let e1 = (some e : " + AP + xz.getName() + 
				" | e.trg = n), e2=(some e : " + AP + yz.getName() + " | e.trg = n)|not(e1 and e2)" + LINE;
		return result;
	}
	private String translateXOR4(Constraint constraint) {
		Node source = getNode(constraint, "X");
		Arrow xy1 = getArrow(constraint, "XY1"), xy2 = getArrow(constraint, "XY2"), xy3 = getArrow(constraint, "XY3"), xy4 = getArrow(constraint, "XY4");
		String result = "//" + "XOR constraint between " + xy1 + ","+ xy2 + ","+ xy3 + " and " + xy4 + LINE + "\t";
		result += "all n:(" + NP + source.getName() + ") | let e1=(some e : " + AP + xy1.getName() + 
				"|e.src = n), e2=(some e : " + AP + xy2.getName() + 
				"|e.src = n), e3=(some e : " + AP + xy3.getName() + 
				"|e.src = n), e4=(some e : " + AP + xy4.getName() + 
				"|e.src = n)|(e1 or e2 or e3 or e4) and not(((e1 and (e2 or e3 or e4)) or (e2 and (e1 or e3 or e4)) or (e3 and (e2 or e1 or e4)) or (e4 and (e2 or e3 or e1))))" + LINE;
		return result;
	}
	private String translateXOR(Constraint constraint) {
		Node source = getNode(constraint, "Z");
		Arrow zx = getArrow(constraint, "ZX"), zy = getArrow(constraint, "ZY");
		String result = "//" + "XOR constraint between " + zx + " and " + zy + LINE + "\t";
		result += "all n:(" + NP + source.getName() + ") | let e1 = (some e : " + AP + zx.getName() + 
				" | e.src = n), e2=(some e : " + AP + zy.getName() + " | e.src = n)|(e1 or e2) and not(e1 and e2)" + LINE;
		return result;
	}
	private String translateNodeMultiplicity(Constraint constraint) {
		Node source = getNode(constraint, "X");
		String result = "//" + "mulitplicity on " + source.getName() + " " + constraint.getParameters() + LINE + "\t";
		Map<String, String> parameters = PredicateImpl.getParameterMap(constraint.getParameters());
		if(parameters == null) return result;
		String min = parameters.get("min");
		String max = parameters.get("max");
		result += "let count = #" + NP + source.getName() + 
				" | count>=" + min;
		if(!(max.equals("*") || max.equals("-1")))
			result += " and count <=" + max;
		return result; 
	}
	private String translateArrowMultiplicity(Constraint constraint) {
		Node source = getNode(constraint, "X");
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "mulitplicity on " + arrow +  constraint.getParameters() +  LINE + "\t";
		Map<String, String> parameters = PredicateImpl.getParameterMap(constraint.getParameters());
		if(parameters == null) return result;
		String min = parameters.get("min");
		String max = parameters.get("max");
		result += "all n:(" + NP + source.getName() + ")| let count = #{e:(" + AP + arrow.getName() + 
				")| e.src = n}| count>=" + min;
		if(!(max.equals("*") || max.equals("-1")))
			result += " and count <=" + max;
		return result; 
	}
	private String translateSurjective(Constraint constraint) {
		Node source = getNode(constraint, "Y");
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "surjective on " + arrow +  LINE + "\t";
		return result + "all n:(" + NP + source.getName() + ")| some e:(" + AP + arrow.getName() + 
				")| e.trg = n" + LINE;
	}
	private String translateArrowMultiplicity(Arrow arrow) {
		String result = "//" + "mulitplicity on " + arrow +  "[0,1]" + LINE  + "\t";
		return result + "all n:(" + NP + arrow.getSource().getName() + ")| lone e:(" + AP + arrow.getName()+ 
				")|e.src=n" + LINE;
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
		String result = "//" + "check injective on " + arrow +  LINE + "\t";
		result += "all n:(" + NP + source.getName() + ")| no e1, e2:(" + AP + arrow.getName() + 
				")| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)" + LINE; 
		return result ;
	}


	public List<Object[]> alloycommands = new ArrayList<Object[]>();
	/*
	 * the entrance method to encode a model transformation system
	 */
	@SuppressWarnings("unchecked")
	public void translate(){
		nodeSigs();
		edgeSigs();
		pre_source_valid();
		List<Object> constraints = new ArrayList<Object>();
		constraints.addAll(hash.keySet());
		for (int i = 0; i < constraints.size() ; i++) {
			for (int j = i + 1; j < constraints.size() ; j++) {
				Object iter = constraints.get(i), iter1 = constraints.get(j);
				Object[] overlap = findOverlap(iter, iter1);
				if(overlap == null) continue;
				alloycommands.add(new Object[]{iter, iter1});
				buffer.append("run{(" + hash.get(iter) + "[] and not " + hash.get(iter1) + "[]) or (not " + hash.get(iter) + "[] and " + hash.get(iter1) + "[])} for 0 but ");
				List<Node> nodes = (List<Node>) overlap[0];
				List<Arrow> edges = (List<Arrow>) overlap[1];
				List<String> strings = new ArrayList<String>();
				for(Node in : nodes){
					strings.add(nodeSig(in));
				}
				for(Arrow ie : edges){
					strings.add(edgeSig(ie));
				}
				buffer.append("5 " + strings.get(0));
				for (int k = 1; k < strings.size(); k++) {
					buffer.append(", 5 " + strings.get(k));
				}
				buffer.append(LINE);
			}
		}
//		if(check == null)
//			buffer.append("run {}");
//		else
//			translate(check, "check");
//		buffer.append(" for 5");
			
	}
	private String getConstraintName(Constraint constraint){
		String result = "";
		result += constraint.getPredicate().getSymbol();
		GraphHomomorphism mapping = constraint.getMappings();
		if(mapping.getArrowMapping().isEmpty()){
			for(Node entry : mapping.getNodeMapping().values())
				result += "_N" + entry.getName();
		}
		else
			for(Arrow entry : mapping.getArrowMapping().values())
				result += "_E" + entry.getName();
		return result;
	}

	/**
	 * translate Model to Alloy
	 */
	public TranslateDPFToAlloyForAnalysis(DSpecification model){
		this.model  = model;
		dGraph = model.getDGraph();
	}

	public List<String> commands = new ArrayList<String>();
	String current = null;
	private Constraints uc;
	private Constraint check;

	public void writeToFile(File file) throws IOException{
		FileWriter writer = new FileWriter(file);
		writer.write(buffer.toString());
		writer.close();
	}
	public void setUConstraints(Constraints constraints) {
		uc = constraints;
	}
	public void setCheckConstraint(Constraint constraint) {
		check = constraint;
	}
}
