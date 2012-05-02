package no.hib.dpf.m2m.transformation.parser;



import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class DPFTemplates {
	public static DSpecification newSpec;
	public static void dpfFileTempleteToGenerate(String dpfFile, IFile file){
		//DSpecification newSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		ResourceSetImpl resourceSet = DPFDiagramUtil.getResourceSet();
		newSpec = DPFDiagramUtil.loadSpecWithMetaModel(resourceSet);
		DPFDiagramUtil.loadSMODLModel(resourceSet,newSpec,dpfFile,file);
		XmlParser.SmodlXMLParser(file);
		DPFDiagramUtil.saveDSpecification(resourceSet,dpfFile);
		//return newSpec;
	}
	
	public static void SpecificationContent(String targetnodeName,String targetnodeValue, String sourceNodeName,String sourceNodeValue,Point p){
		
		Assert.isNotNull(targetnodeName);
		DNode node = DiagramFactory.eINSTANCE.createDefaultDNode();
		for(DNode typeNode : newSpec.getDType().getDGraph().getDNodes()){
			if(targetnodeName.equalsIgnoreCase(typeNode.getName().toString())){
				node.setDType(typeNode);
				node.getNode().setName(targetnodeValue);
				//node.setConfigureString(targetnodeValue);
				//node.setName(targetnodeValue);
				node.setLocation(p);
				newSpec.getDGraph().addDNode(node);
				break;
			}
			
		}
		
		//Assert.isNotNull(sourceNodeName);
		if(sourceNodeName!= null){
			DArrow arrow = DiagramFactory.eINSTANCE.createDefaultDArrow();
			for(DArrow typeArrow :newSpec.getDType().getDGraph().getDArrows()){
				if(typeArrow.getDSource().getName().equalsIgnoreCase(sourceNodeName) && 
						typeArrow.getDTarget().getName().equalsIgnoreCase(targetnodeName)){
					arrow.setDType(typeArrow);
					arrow.getArrow().setName(targetnodeValue);
					arrow.setDTarget(node);
					
					for(DNode sourceNode:newSpec.getDGraph().getDNodes()){
						if(sourceNodeValue.equalsIgnoreCase(sourceNode.getName().toString()))
						arrow.setDSource(sourceNode);
					}
					newSpec.getDGraph().addDArrow(arrow);
				break;
				}
					
			}
		}
		/*DNode node1 = newSpec.getDType().getDGraph().getDNodes().get(0);
		//DNode node = DiagramFactory.eINSTANCE.createDNode("test",node1 );
		DNode node = DiagramFactory.eINSTANCE.createDefaultDNode();
		node.setDType(node1);
		Point p1 = new Point(100,100);
		node.setLocation(p1);
		newSpec.getDGraph().addDNode(node);
		
		DNode node2 = newSpec.getDType().getDGraph().getDNodes().get(2);
		//DNode node = DiagramFactory.eINSTANCE.createDNode("test",node1 );
		DNode node3 = DiagramFactory.eINSTANCE.createDefaultDNode();
		node3.setDType(node2);
		Point p2 = new Point(200,100);
		node3.setLocation(p2);
		newSpec.getDGraph().addDNode(node3);
		
		DArrow arrow = newSpec.getDType().getDGraph().getDArrows().get(1);
		//DArrow arrow1 = DiagramFactory.eINSTANCE.createDArrow("dfd", node, node3, arrow);
		DArrow arrow1 = DiagramFactory.eINSTANCE.createDefaultDArrow();
		arrow1.setDType(arrow);
		arrow1.setDSource(node);
		arrow1.setDTarget(node3);
	
		newSpec.getDGraph().addDArrow(arrow1);*/

		
		
	
		
	}
	
}
