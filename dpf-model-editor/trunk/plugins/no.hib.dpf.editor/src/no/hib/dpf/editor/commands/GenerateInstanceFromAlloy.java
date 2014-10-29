package no.hib.dpf.editor.commands;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.GenerateDiagramFromModel;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyRelation;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.AlloyType;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;

public class GenerateInstanceFromAlloy {

	/**
	 * Generate a production from a alloy solution
	 */
	/**
	 * Generate a dspecification from a alloy solution
	 */
	public static DSpecification generateDSpecificationFromAlloy(A4Solution solution, DSpecification type) throws Err{
		if(!solution.satisfiable()){
			return null;
		}
		solution.writeXML("instance.xml");
		AlloyInstance inst = StaticInstanceReader.parseInstance(new File("instance.xml"));
	
		Specification instance = CoreFactory.eINSTANCE.createDefaultSpecification();
		instance.setType(type.getSpecification());
		instance.getGraph().setType(type.getSpecification().getGraph());
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
			} else if(alloyTypeName.startsWith("E")){
				Arrow dpfType = graphType.getArrowByName(typeName);
				for(AlloyAtom alloyAtom : inst.type2atoms(alloyType)){
					Arrow arrow = CoreFactory.eINSTANCE.createArrow();
					arrow.setName(alloyAtom.toString().substring(1));
					arrow.setTypeArrow(dpfType);
					graph.getArrows().add(arrow);
					maps.put(alloyAtom, arrow);
				}
			}
		}
		for(AlloyRelation alloyType : inst.model.getRelations()){
			String alloyTypeName = alloyType.getName();
			if(alloyTypeName.equals("src")){
				for(AlloyTuple alloyTuple : inst.relation2tuples(alloyType)){
					((Arrow)maps.get(alloyTuple.getStart())).setSource((Node) maps.get(alloyTuple.getEnd()));
				}
			}else if(alloyTypeName.equals("trg")){
				for(AlloyTuple alloyTuple : inst.relation2tuples(alloyType))
					((Arrow)maps.get(alloyTuple.getStart())).setTarget((Node) maps.get(alloyTuple.getEnd()));
			}
		}
		GenerateDiagramFromModel generator = new GenerateDiagramFromModel(instance, type);
		return generator.result;
	}
	public static void main(String[] args){
		AlloyInstance inst;
		try {
			inst = StaticInstanceReader.parseInstance(new File("test.xml"));
			for(AlloyType alloyType : inst.model.getTypes()){
				System.out.println(alloyType);
				System.out.print("{");
				for(AlloyAtom alloyAtom : inst.type2atoms(alloyType)){
					System.out.print(alloyAtom);
					System.out.print(",");
				}
				System.out.println("}");
			}
		} catch (Err e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
