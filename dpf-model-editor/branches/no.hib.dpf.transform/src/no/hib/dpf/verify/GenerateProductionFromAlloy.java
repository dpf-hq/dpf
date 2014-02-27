package no.hib.dpf.verify;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.GenerateDiagramFromModel;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyRelation;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.AlloyType;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;

public class GenerateProductionFromAlloy {

	/**
	 * Generate a production from a alloy solution
	 */
	public static Production generateProductionFromAlloy(A4Solution solution, Transform transform) throws Err{
		Production result = TransformFactory.eINSTANCE.createProduction();
		result.setName(solution.getOriginalCommand());
		if(!solution.satisfiable()){
			return null;
		}
		solution.writeXML("instance.xml");

		AlloyInstance inst = StaticInstanceReader.parseInstance(new File("instance.xml"));
		
		Specification type = transform.getElementTypeGraph().getSpecification();
		Specification instance = CoreFactory.eINSTANCE.createDefaultSpecification();
		instance.setType(type);
		instance.getGraph().setType(type.getGraph());
		Graph graph = instance.getGraph(), graphType = graph.getType();
		Map<AlloyAtom, IDObject> maps = new HashMap<AlloyAtom, IDObject>();
		for(AlloyType alloyType : inst.model.getTypes()){
			String alloyTypeName = alloyType.getName();
			String typeName = alloyTypeName.substring(1);
			if(alloyTypeName.startsWith("N")){
				Node dpfType = graphType.getNodeByName(typeName);
				for(AlloyAtom alloyAtom : inst.type2atoms(alloyType)){
					Node _new = graph.createNode(alloyAtom.toString().substring(1), dpfType);
					maps.put(alloyAtom, _new);
				}
			}
			if(alloyTypeName.startsWith("A")){
				Arrow dpfType = graphType.getArrowByName(typeName);
				for(AlloyAtom alloyAtom : inst.type2atoms(alloyType)){
					Arrow arrow = CoreFactory.eINSTANCE.createArrow();
					arrow.setName(alloyAtom.toString().substring(1));
					arrow.setTypeArrow(dpfType);
					graph.getArrows().add(arrow);
					maps.put(alloyAtom, arrow);
				}
			}
			if(alloyTypeName.equals("Rule")){
				for(AlloyType subType : inst.model.getSubTypes(alloyType))
					if(!inst.type2atoms(subType).isEmpty()){
						if(result.getName().startsWith("Run"))
							result.setName(result.getName() + " by rule " + subType.getName());
						else
							result.setName(subType.getName());
						break;
					}
			}
		}
		List<Node> aNodes = new ArrayList<Node>(), dNodes = new ArrayList<Node>();
		List<Arrow> aArrows = new ArrayList<Arrow>(), dArrows = new ArrayList<Arrow>();
		for(AlloyRelation alloyType : inst.model.getRelations()){
			String alloyTypeName = alloyType.getName();
			if(alloyTypeName.equals("src")){
				for(AlloyTuple alloyTuple : inst.relation2tuples(alloyType))
					((Arrow)maps.get(alloyTuple.getStart())).setSource((Node) maps.get(alloyTuple.getEnd()));
			}else if(alloyTypeName.equals("trg")){
				for(AlloyTuple alloyTuple : inst.relation2tuples(alloyType))
					((Arrow)maps.get(alloyTuple.getStart())).setTarget((Node) maps.get(alloyTuple.getEnd()));
			}else if(alloyTypeName.equals("anodes")){
				for(AlloyTuple alloyTuple : inst.relation2tuples(alloyType))
					aNodes.add((Node) maps.get(alloyTuple.getEnd()));
			}else if(alloyTypeName.equals("dnodes")){
				for(AlloyTuple alloyTuple : inst.relation2tuples(alloyType))
					dNodes.add((Node) maps.get(alloyTuple.getEnd()));
			}else if(alloyTypeName.equals("aarrows")){
				for(AlloyTuple alloyTuple : inst.relation2tuples(alloyType))
					aArrows.add((Arrow) maps.get(alloyTuple.getEnd()));
			}else if(alloyTypeName.equals("darrows")){
				for(AlloyTuple alloyTuple : inst.relation2tuples(alloyType))
					dArrows.add((Arrow) maps.get(alloyTuple.getEnd()));
			}
		}
		GenerateDiagramFromModel generator = new GenerateDiagramFromModel(instance, transform.getElementTypeGraph());
		result.setSum(generator.result);
		List<DNode> iterNode = result.getLeftNodes();
		for(Node node : dNodes)
			iterNode.add(generator.getDNode(node));
		iterNode = result.getRightNodes();
		for(Node node : aNodes)
			iterNode.add(generator.getDNode(node));
		List<DArrow> iterArrow = result.getLeftArrows();
		for(Arrow arrow : dArrows)
			iterArrow.add(generator.getDArrow(arrow));
		iterArrow = result.getRightArrows();
		for(Arrow arrow : aArrows)
			iterArrow.add(generator.getDArrow(arrow));
		List<DNode> common = new ArrayList<DNode>();
		common.addAll(generator.result.getDGraph().getDNodes());
		common.removeAll(result.getRightNodes());
		common.removeAll(result.getLeftNodes());
		result.getCommonNodes().addAll(common);
		result.getLeftNodes().addAll(common);
		result.getRightNodes().addAll(common);
		List<DArrow> commonArrows = new ArrayList<DArrow>();
		commonArrows.addAll(generator.result.getDGraph().getDArrows());
		commonArrows.removeAll(result.getRightArrows());
		commonArrows.removeAll(result.getLeftArrows());
		result.getCommonArrows().addAll(commonArrows);
		result.getLeftArrows().addAll(commonArrows);
		result.getRightArrows().addAll(commonArrows);
		return result;
	}
}
