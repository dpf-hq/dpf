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

public class DPF2Alloy {

	/*
	 * Graph structure to alloy specification
	 */

	static public  final String LINE = System.lineSeparator();
	static public  final String NP = "N";
	static public  final String AP = "E";
	static public  final String SIG = "sig ";

	private DGraph dGraph = null;
	public DSpecification model = null;

	protected Map<Node, String> node2Sig = new HashMap<Node, String>();
	protected Map<Arrow, String> edge2Sig = new HashMap<Arrow, String>();
	public List<IDObject> sig2DPF = new ArrayList<IDObject>();
	protected List<String> enumNodes = new ArrayList<String>();
	protected Map<String, String> name2cons_alloy = new HashMap<String, String>();
	protected Map<Node, List<String>> node2enums = new HashMap<Node, List<String>>();
	
	private int index = 0;
	/*
	 * Translate a node in DPF to a signature named by NP plus node's name
	 */
	public  String getSigForNode(Node node){ 
		String sigName = node2Sig.get(node); 
		if(sigName == null){ 
			sigName = NP + index++;//node.getName();
			node2Sig.put(node, sigName);
			if(node == null)
			System.out.println(node);
			sig2DPF.add(node);
		}
		return sigName;
	}
	
	/*
	 * Translate a edge in DPF to a signature named by NP plus edge's name
	 */
	public  String getSigForEdge(Arrow edge){ 
		String sigName = edge2Sig.get(edge); 
		if(sigName == null){ 
			sigName = AP + index++;//edge.getName();
			edge2Sig.put(edge, sigName);
			sig2DPF.add(edge);
		}
		return sigName;
	}

	/*
	 * Get all the signatures for nodes
	 */
	public  void nodeSigs(){
		for(Node node : dGraph.getGraph().getNodes()){
			//Get the signature for the node
			String name = getSigForNode(node);
			//Check if a node is specified as an enumeration type
			Constraint cenum = null;
			for (Constraint iter : node.getConstraints()) {
				if(iter.getPredicate() == null)
					System.out.println(iter);
				if(iter.getPredicate().getSymbol().equals("enum"))
					cenum = iter;
			}
			if(cenum != null){
				//If the node is an enumeration type, create a signature for each literal the node has
				String literals = cenum.getParameters();
				String LITERALS = "literal:{";
				literals = literals.substring(literals.indexOf(LITERALS) + LITERALS.length(), literals.length() - 1);
				String[] liters = literals.split(",");
				List<String> enums = new ArrayList<String>();
				for(int index = 0; index < liters.length; ++index){
					enums.add(liters[index].trim());
				}
				node2enums.put(node, enums);
				enumNodes.add(name);
			}
		}
	}
	/*
	 * Get the signatures for edges
	 */
	public void edgeSigs(){
		for(Arrow arrow : dGraph.getGraph().getArrows())
			getSigForEdge(arrow);
	}

	/**
	 * Each source model satisfies all the constraints on the metamodel. In this way, every source model is valid.<br>
	 * 1. Each arrow has a default constraint multi[0,1]. Translate the default constraint first.<br>
	 * 2. Then translate the other constraint associated with the metamodel.<br>
	 */
	private Map<String, Object> name2cons_DPF = new HashMap<String, Object>();
	public void facts(){
		for(Arrow arrow : model.getSpecification().getGraph().getArrows()){
			boolean isMult = false;
			for(Constraint constraint : arrow.getConstraints()){
				if(constraint.getPredicate() == DPFConstants.ARROW_MULTI){
					isMult = true;
					break;
				}
			}
			if(!isMult){
				String name = "mult1_" + getSigForEdge(arrow);
				name2cons_DPF.put(name, arrow);
				name2cons_alloy.put(name, translateArrowMultiplicity(arrow));
			}
		}
		for(Constraint constraint : model.getSpecification().getConstraints()){
			Predicate predicate  = constraint.getPredicate();
			if(predicate.getSymbol().equals("enum") || predicate.getSymbol().equals("string")
					|| predicate.getSymbol().equals("int") 
					|| predicate.getSymbol().equals("bool"))
				continue;
			String predName = getConstraintName(constraint);
			name2cons_DPF.put(predName, constraint);
			if(predicate == DPFConstants.INJECTIVE)
				name2cons_alloy.put(predName, translateInjective(constraint));
			else if(predicate == DPFConstants.SURJECTIVE)
				name2cons_alloy.put(predName, translateSurjective(constraint));
			else if(predicate == DPFConstants.ARROW_MULTI)
				name2cons_alloy.put(predName, translateArrowMultiplicity(constraint));
			else if(predicate == DPFConstants.NODE_MULTI)
				name2cons_alloy.put(predName, translateNodeMultiplicity(constraint));
			else if(predicate == DPFConstants.XOR)
				name2cons_alloy.put(predName, translateXOR(constraint));
			else if(predicate == DPFConstants.XOR4)
				name2cons_alloy.put(predName, translateXOR4(constraint));
			else if(predicate == DPFConstants.MERGE_NAND)
				name2cons_alloy.put(predName, translateMergeNAND(constraint));
			else if(predicate == DPFConstants.SPLIT_NAND)
				name2cons_alloy.put(predName, translateSplitNAND(constraint));
			else if(predicate == DPFConstants.REFLEXIVE)
				name2cons_alloy.put(predName, translateReflexive(constraint));
			else if(predicate == DPFConstants.IRREFLEXIVE)
				name2cons_alloy.put(predName, translateIrreflexive(constraint));
			else if(predicate == DPFConstants.JOINT_SURJ)
				name2cons_alloy.put(predName, translateJointSurjective(constraint));
			else{
				String result = translateGeneral(constraint);
				if(result != null && !result.isEmpty())
				name2cons_alloy.put(predName, result);
			}
		}
		if(uc != null){
			for(UConstraint iter : uc.getRules()){
				name2cons_DPF.put(iter.getName(), iter);
				name2cons_alloy.put(iter.getName(), getConsInAlloyForUC(iter));
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
			if(B.contains(iter))
				result.add(iter);
		}
		return result;
	}
	public String translateRelatedMatch(List<DNode> leftNodes, List<DArrow> leftEdges,  
			List<DNode> commonNodes, List<DArrow> commonEdges, 
			List<DNode> rightNodes, List<DArrow> rightEdges) {
		List<DArrow> visited = new ArrayList<DArrow>();
		List<DNode> visitedNode= new ArrayList<DNode>();
		String name = null, type = null;
		boolean isLeftExist = true;
		StringBuffer cons_Alloy = new StringBuffer();
		if(!commonEdges.isEmpty()){
			cons_Alloy.append(translateRelatedMatch(commonEdges.get(0), "all ", visited, visitedNode, commonNodes, commonEdges));
		}else if(!commonNodes.isEmpty()){
			DNode node = commonNodes.get(0);
			visitedNode.add(node);
			name = node.getNode().getName();
			type = getSigForNode(node.getNode().getTypeNode());
			cons_Alloy.append("all " + name + ":" + type + "|");
		}else{
			isLeftExist = false;
		}
		if(leftEdges.size() > commonEdges.size()){
			if(isLeftExist) cons_Alloy.append(" and");
			cons_Alloy.append(" not (");
			for(DArrow iter : leftEdges){
				if(!visited.contains(iter)){
					cons_Alloy.append(translateRelatedMatch(iter, "some ", visited, visitedNode, leftNodes, leftEdges));
				}
			}
			cons_Alloy.append(")");
			isLeftExist = true;
		}
		if(isLeftExist)
			cons_Alloy.append(" implies (");
		for(DArrow iter : rightEdges){
			if(!visited.contains(iter)){
				cons_Alloy.append(translateRelatedMatch(iter, "some ", visited, visitedNode,  rightNodes, rightEdges));
			}
		}
		if(isLeftExist)
			cons_Alloy.append(") ");
		return cons_Alloy.toString();
	}
	public  String translateRelatedMatch(DArrow cur, String prefix, 
			List<DArrow> visited, List<DNode> visitedNode, 
			List<DNode> leftNodes, List<DArrow> leftEdges) {
		String the = cur.getArrow().getName(), source = cur.getArrow().getSource().getName(), target = cur.getArrow().getTarget().getName();
		StringBuffer buffer = new StringBuffer();
		buffer.append(prefix);//kept ? "some " : "one ");
		buffer.append(the +":");
		buffer.append(getSigForEdge(cur.getArrow().getTypeArrow()));
		buffer.append("|");
		boolean srcVisited = visitedNode.contains(cur.getDSource()), trgVisited =  visitedNode.contains(cur.getDTarget());
		boolean srcIsEnum = IsEnum(cur.getArrow().getSource().getTypeNode(), source), trgIsEnum = IsEnum(cur.getArrow().getTarget().getTypeNode(), target);
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
			return buffer.toString();
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
					buffer1.append(translateRelatedMatch(arrow, "some ", visited, visitedNode, leftNodes, leftEdges));
				}
			}
			for(DArrow arrow : cur.getDSource().getDOutgoings()){
				if(leftEdges.contains(arrow)  && !visited.contains(arrow)){
					if(buffer1.length() > 0)
						buffer1.append(" and (");
					buffer1.append(translateRelatedMatch(arrow, "some ", visited, visitedNode, leftNodes, leftEdges));
					buffer1.append(")");
				}
			}
		}
		if(!trgVisited && !ref){
			for(DArrow arrow : cur.getDTarget().getDIncomings()){
				if(leftEdges.contains(arrow) && !visited.contains(arrow)){
					if(buffer1.length() > 0)
						buffer1.append(" and (");
					buffer1.append(translateRelatedMatch(arrow, "some ", visited, visitedNode, leftNodes, leftEdges));
					buffer1.append(")");
				}
			}
			for(DArrow arrow : cur.getDTarget().getDOutgoings()){
				if(leftEdges.contains(arrow) && !visited.contains(arrow)){
					if(buffer1.length() > 0)
						buffer1.append(" and (");
					buffer1.append(translateRelatedMatch(arrow, "some ", visited, visitedNode, leftNodes, leftEdges));
					buffer1.append(")");
				}
			}
		}
		if(buffer1.length() == 0) buffer1.append(let.replace(",", " and "));

		boolean containAnd = buffer1.length() > 0 && buffer1.indexOf(" and ") != -1;
		if(containAnd) buffer.append("(");
		buffer.append(buffer1.toString());
		if(containAnd) buffer.append(")");
		return buffer.toString();
	}
	private boolean IsEnum(Node name, String target) {
		return node2enums.containsKey(name) && node2enums.get(name).contains(target);
	}
	@SuppressWarnings("unchecked")
	public String getConsInAlloyForUC(UConstraint rule){
		List<Object> relatedSet = new ArrayList<Object>();
		getConnectedSubgraphs(rule.getSum().getDGraph().getDNodes(), rule.getSum().getDGraph().getDArrows(), relatedSet);
		StringBuffer buffer = new StringBuffer();
		for(int index = 0; index < relatedSet.size(); index += 2){
			List<DNode> subn = (List<DNode>) relatedSet.get(index);
			List<DArrow> suba = (List<DArrow>) relatedSet.get(index + 1);
			buffer.append(translateRelatedMatch(intersection(subn, rule.getLeftNodes()), intersection(suba, rule.getLeftArrows()),
					intersection(subn, rule.getCommonNodes()), intersection(suba, rule.getCommonArrows()),
					intersection(subn, rule.getRightNodes()), intersection(suba, rule.getRightArrows())));
		}
		return buffer.toString() + LINE;
	}
	private String translateJointSurjective(Constraint constraint) {
		Node target = getNode(constraint, "Z");
		Arrow xz = getArrow(constraint, "XZ"), yz = getArrow(constraint, "YZ");
		String result = "//" + "joint-surjective constraint between " + xz + " and " + yz + LINE + "\t";
		result += "all n:(" + getSigForNode(target) + ") | let e1 = (some e : " + getSigForEdge(xz) + 
				" | e.trg = n), e2=(some e : " + getSigForEdge(yz) + " | e.trg = n)| e1 or e2" + LINE;
		return result;
	}
	private String translateIrreflexive(Constraint constraint) {
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "reflexive on " + arrow +  LINE + "\t";
		result += "no e:(" + getSigForEdge(arrow) + ")| e.src = e.trg" + LINE;
		return result;
	}
	private String translateGeneral(Constraint constraint) {
		Predicate predicate = constraint.getPredicate();
		if(predicate.getValidator().getType() == ValidatorType.ALLOY)
		{
			GraphHomomorphism mapping = constraint.getMappings();
			Map<String,Node> nodeHash = new HashMap<String,Node>(); 
			Map<String,Arrow> arrowHash = new HashMap<String,Arrow>();
			for(Entry<Arrow, Arrow> entry : mapping.getArrowMapping().entrySet())
				arrowHash.put(entry.getKey().getName(), entry.getValue());
			for(Entry<Node, Node> entry : mapping.getNodeMapping().entrySet())
				nodeHash.put(entry.getKey().getName(), entry.getValue());
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
					real += getSigForNode(nodeHash.get(variable));
				}else if(arrowHash.containsKey(variable)){
					real += getSigForEdge(arrowHash.get(variable));
				}else return "";
				first = second = second + 1;
			}
			return real + LINE;
		}
		return "";
	}
	private String translateReflexive(Constraint constraint) {
		Arrow arrow = getArrow(constraint, "XY");
		String result = "//" + "reflexive on " + arrow +  LINE + "\t";
		result += "all e:(" + getSigForEdge(arrow) + ")| e.src = e.trg" + LINE; 
		return result;
	}
	private String translateSplitNAND(Constraint constraint) {
		Node z = getNode(constraint, "Z");
		Arrow zx = getArrow(constraint, "ZX"), zy = getArrow(constraint, "ZY");
		String result = "//" + "NAND constraint between " + zx + " and " + zy + LINE + "\t";
		result += "all n:(" + getSigForNode(z) + ") | let e1 = (some e : " + getSigForEdge(zx) + 
				" | e.src = n), e2=(some e : " + getSigForEdge(zy) + " | e.src = n)|not(e1 and e2)" + LINE;
		return result;
	}
	private String translateMergeNAND(Constraint constraint) {
		Node target = getNode(constraint, "Z");
		Arrow xz = getArrow(constraint, "XZ"), yz = getArrow(constraint, "YZ");
		String result = "//" + "NAND constraint between " + xz + " and " + yz + LINE + "\t";
		result += "all n:(" + getSigForNode(target) + 
				") | let e1 = (some e : " + getSigForEdge(xz) + 
				" | e.trg = n), e2=(some e : " + getSigForEdge(yz) + 
				" | e.trg = n)|not(e1 and e2)" + LINE;
		return result;
	}
	private String translateXOR4(Constraint constraint) {
		Node source = getNode(constraint, "X");
		Arrow xy1 = getArrow(constraint, "XY1"), xy2 = getArrow(constraint, "XY2"), xy3 = getArrow(constraint, "XY3"), xy4 = getArrow(constraint, "XY4");
		String result = "//" + "XOR constraint between " + xy1 + ","+ xy2 + ","+ xy3 + " and " + xy4 + LINE + "\t";
		result += "all n:(" + getSigForNode(source) + ") | let e1=(some e : " + getSigForEdge(xy1) + 
				"|e.src = n), e2=(some e : " + getSigForEdge(xy2) + 
				"|e.src = n), e3=(some e : " + getSigForEdge(xy3) + 
				"|e.src = n), e4=(some e : " + getSigForEdge(xy4) + 
				"|e.src = n)|(e1 or e2 or e3 or e4) and not(((e1 and (e2 or e3 or e4)) or (e2 and (e1 or e3 or e4)) or (e3 and (e2 or e1 or e4)) or (e4 and (e2 or e3 or e1))))" + LINE;
		return result;
	}
	private String translateXOR(Constraint constraint) {
		Node source = getNode(constraint, "Z");
		Arrow zx = getArrow(constraint, "ZX"), zy = getArrow(constraint, "ZY");
		String result = "//" + "XOR constraint between " + zx + " and " + zy + LINE + "\t";
		result += "all n:(" + getSigForNode(source) + ") | let e1 = (some e : " + getSigForEdge(zx) + 
				" | e.src = n), e2=(some e : " + getSigForEdge(zy) + " | e.src = n)|(e1 or e2) and not(e1 and e2)" + LINE;
		return result;
	}
	private String translateNodeMultiplicity(Constraint constraint) {
		Node source = getNode(constraint, "X");
		String result = "//" + "mulitplicity on " + source.getName() + " " + constraint.getParameters() + LINE + "\t";
		Map<String, String> parameters = PredicateImpl.getParameterMap(constraint.getParameters());
		if(parameters == null) return result;
		String min = parameters.get("min");
		String max = parameters.get("max");
		result += "let count = #" + getSigForNode(source) + 
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
		result += "all n:(" + getSigForNode(source) + ")| let count = #{e:(" + getSigForEdge(arrow) + 
				")| e.src = n}| count>=" + min;
		if(!(max.equals("*") || max.equals("-1")))
			result += " and count <=" + max;
		return result; 
	}
	private String translateSurjective(Constraint constraint) {
		Node source = getNode(constraint, "Y");
		Arrow arrow = getArrow(constraint, "XY");
		if(source == null && arrow != null){
			System.out.println(arrow);
		}
		String result = "//" + "surjective on " + arrow +  LINE + "\t";
		return result + "all n:(" + getSigForNode(source)  + 
				")| some e:(" + getSigForEdge(arrow) + 
				")| e.trg = n" + LINE;
	}
	private String translateArrowMultiplicity(Arrow arrow) {
		String result = "//" + "mulitplicity on " + arrow +  "[0,1]" + LINE  + "\t";
		return result + "all n:(" + getSigForNode(arrow.getSource()) + 
				")|lone e:(" + getSigForEdge(arrow)+ 
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
		result += "all n:(" + getSigForNode(source) + 
				")| no e1, e2:(" + getSigForEdge(arrow) + 
				")| (e1 != e2 and e1.src = n and e2.src = n and e1.trg = e2.trg)" + LINE; 
		return result ;
	}


	/*
	 * the entrance method to encode a model transformation system
	 */
	public void translate(){
		nodeSigs();
		edgeSigs();
		facts();
	}
	private String getConstraintName(Constraint constraint){
		String result = "";
		result += constraint.getPredicate().getSymbol();
		GraphHomomorphism mapping = constraint.getMappings();
		if(mapping.getArrowMapping().isEmpty()){
			for(Node entry : mapping.getNodeMapping().values())
				result += "_" + getSigForNode(entry);
		}
		else
			for(Arrow entry : mapping.getArrowMapping().values())
				result += "_" + getSigForEdge(entry);
		return result;
	}

	/**
	 * translate Model to Alloy
	 */
	public DPF2Alloy(DSpecification model){
		this.model  = model;
		dGraph = model.getDGraph();
	}

	public List<String> commands = new ArrayList<String>();
	String current = null;
	private Constraints uc;

	public void writeToFile(File file) throws IOException{
		FileWriter writer = new FileWriter(file);
		writer.write("//Signatures for nodes" + LINE);
		for(Entry<Node, String> cur : node2Sig.entrySet()){
			String iter = cur.getValue();
			if(enumNodes.contains(iter))
				writer.write("abstract ");
			writer.write(SIG + iter + "{} // for " + cur.getKey().getName() + LINE);
		}
		for(Entry<Node, List<String>> iter : node2enums.entrySet()){
			writer.write("lone " + SIG);
			List<String> literals = iter.getValue();
			writer.write(NP + literals.get(0));
			for(int index = 1; index < literals.size(); ++index)
				writer.write(", " + NP + literals.get(index));
			writer.write(" extends " + node2Sig.get(iter.getKey()) + "{}" + LINE);
		}
		
		writer.write(LINE + "//Signatures for edges" + LINE);
		for(Entry<Arrow, String> iter : edge2Sig.entrySet()){
			writer.write(SIG + iter.getValue() + "{src:one "
					+ node2Sig.get(iter.getKey().getSource()) + ", trg:one "
					+ node2Sig.get(iter.getKey().getTarget()) + "} // for " + iter.getKey().toString() + LINE);
		}
		write(writer);
		writer.close();
	}
	
	public void write(FileWriter writer) throws IOException{
		writer.write(LINE + "//facts" + LINE);
		for(Entry<String, String> iter : name2cons_alloy.entrySet()){
			writer.write("fact " + iter.getKey() + "{" + LINE);
			writer.write("\t" + iter.getValue());
			writer.write("}" + LINE + LINE);
		}
		writer.write("run{} for 3" + LINE);
	}
	public void setUConstraints(Constraints constraints) {
		uc = constraints;
	}
}
