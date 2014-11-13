package no.hib.dpf.m2m.transformation.parser;



import java.io.ObjectInputStream.GetField;

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
	
	
	
	
	/***************
	 * targetnode is the current node , source node is the previous node
	 * typearrow is getting by the target and source node names
	 * typenode is getting by the name of the targetnode
	 * ****************/
	public static void SpecificationContent(String targetnodeName,String targetnodeValue, String sourceNodeName,String sourceNodeValue,Point p){
		
		Assert.isNotNull(targetnodeName);
		boolean existNodeInGrp = false;
		if(targetnodeName.equals("type") ){
			if(targetnodeValue.equals("binary")||targetnodeValue.equals("bool")||targetnodeValue.equals("dateTime")||
				targetnodeValue.equals("double")||targetnodeValue.equals("float")||targetnodeValue.equals("int")||
				targetnodeValue.equals("long")||targetnodeValue.equals("string"))
					targetnodeName = "SimpleType";
			else
				targetnodeName = "Struct";
	
	}
		DNode node = DiagramFactory.eINSTANCE.createDefaultDNode();
		for(DNode typeNode : newSpec.getDType().getDGraph().getDNodes()){
			
			if(targetnodeName.equalsIgnoreCase(typeNode.getName().toString())){
				node.setDType(typeNode);
				node.getNode().setName(targetnodeValue);
				node.setLocation(p);
				if(targetnodeName.equalsIgnoreCase("SimpleType") ||targetnodeName.equalsIgnoreCase("Struct")){
					for(DNode existNode:newSpec.getDGraph().getDNodes()){
						if(targetnodeValue.equalsIgnoreCase(existNode.getName().toString())){
							existNodeInGrp = true;
							node = existNode;
							break;
						}
					}
				}
				if(!existNodeInGrp)
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
						if(sourceNodeValue.equalsIgnoreCase(sourceNode.getName().toString())){
							arrow.setDSource(sourceNode);
						}
					}
					newSpec.getDGraph().addDArrow(arrow);
				break;
				}
					
			}
		}


		
		
	
		
	}
	
}
