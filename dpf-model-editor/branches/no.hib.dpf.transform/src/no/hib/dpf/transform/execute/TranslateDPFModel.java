package no.hib.dpf.transform.execute;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.commands.DArrowDeleteCommand;
import no.hib.dpf.transform.presentation.TransformEditor;
import no.hib.dpf.transform.util.TransformActivePage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;

public class TranslateDPFModel {
	
	private HenshinResourceSet resourceSet = null;
	private List<EObject> matches = null;
	private Rule currentRule = null;
	private URI dSpecificationURI = null;
	private URI specificationURI = null;
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
	
	private Specification specification = null;
	private DSpecification dSpecification = null;
	
	private Graph graph = null;
	private DGraph dGraph = null;
	
	private boolean save = false;
	
	public TranslateDPFModel(List<EObject> list, Rule rule, URI model, 
			Specification specification, DSpecification dSpec, boolean save, HenshinResourceSet resourceSet){

		this.specification = specification;
		this.resourceSet = resourceSet;
		
		
		
		this.save = save;
		dSpecificationURI = model;
	
		URI dSpecURI = URI.createURI("C:/Users/Petter/workspace/DPFTest/specifications/theModelInstance.xmi");
		dSpecification = dSpec;
		
		specificationURI = dSpecification.getSpecification().eResource().getURI();
		
		currentRule = rule;
		matches = list;
		dGraph = dSpec.getDGraph();
		graph = dSpec.getSpecification().getGraph();

		

		for(int i = 0;i<dSpecification.getDGraph().getDArrows().size();i++){
			System.out.println("Arrow " + i + " " + dSpecification.getDGraph().getDArrows().get(i).getName());
		}
		
		
		System.out.println("DSPEC " + dSpec.getDGraph().getDNodes());
	}
	
	public void executeChanges(){
		
		
		Arrow arrow = (Arrow) matches.get(0);
		System.out.println("Her" + arrow.getName());
		Arrow newArrow = graph.getArrowByName(arrow.getName());
		
		System.out.println("NewArrow" + newArrow.getName());
		DArrow dArrow = null;
		for(int i = 0;i<dSpecification.getDGraph().getDArrows().size();i++){
			if(dSpecification.getDGraph().getDArrows().get(i).getName().equals(newArrow.getName())){
				System.out.println("I: " + i);
				dArrow = dSpecification.getDGraph().getDArrows().get(i);
			}
		}
		
	
		
		System.out.println("Darrow" + dArrow);
		System.out.println("HER " + dArrow.getName());
//		new DArrowDeleteCommand(dArrow);
		DArrowDeleteCommand delete = new DArrowDeleteCommand(dArrow);
		delete.execute();
		dSpecification.getDGraph().removeDArrow(dArrow);
//		specification.getGraph().removeArrow(arrow);

		System.out.println("HER " + dArrow.getName());
		for(int i = 0;i<dSpecification.getDGraph().getDArrows().size();i++){
//			System.out.println("Arrow " + i + " " + dSpecification.getDGraph().getDArrows().get(i).getName());
			System.out.println("Arrow " + i);
		}
//		Node node = (Node) matches.get(2);
//		System.out.println("Her" + node.getName());
//		Node newNode = graph.getNodeByName(node.getName());
//		
//		System.out.println("newNode" + newNode.getName());
//		DNode dNode = null;
//		for(int i = 0;i<dSpecification.getDGraph().getDNodes().size();i++){
//			if(dSpecification.getDGraph().getDNodes().get(i).getName().equals(newNode.getName())){
//				dNode = dSpecification.getDGraph().getDNodes().get(i);
//			}
//		}
//		
//		System.out.println("Darrow" + dNode);
//		System.out.println("HER " + dNode.getName());
//		
//		if(dSpecification.eResource().isModified()){
//			System.out.println("No Changes");
//		}
//
//		dSpecification.getDGraph().removeDNode(dNode);
//		
//		
//		System.out.println("HER " + dNode.getName());
//		for(int i = 0;i<dSpecification.getDGraph().getDNodes().size();i++){
//			System.out.println("Arrow " + i + " " + dSpecification.getDGraph().getDNodes().get(i).getName());
//		}
//		
		URI modelFileURI = DPFUtils.getModelURI(dSpecificationURI);
		Resource diagram = resourceSet.createResource(dSpecificationURI);
		Resource model = resourceSet.createResource(modelFileURI);
		diagram.getContents().add(dSpecification);
		model.getContents().add(dSpecification.getSpecification());
		if(dSpecification.getDType() != DPFConstants.REFLEXIVE_DSPECIFICATION){
			diagram.getContents().add(dSpecification.getDType());
			model.getContents().add(dSpecification.getDType().getSpecification());
		}
		try {
			diagram.save(null);
		} catch (IOException e) {
			System.out.println("Exc" + e);
		}
		
		/*
		 * Resource diagram = createResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		diagram.getContents().add(newSpec);
		Resource model = createResource(resourceSet, modelFileURI, resourceToDiagnosticMap);
		model.getContents().add(newSpec.getSpecification());
		if(newSpec.getDType() != DPFConstants.REFLEXIVE_DSPECIFICATION){
			diagram.getContents().add(newSpec.getDType());
			model.getContents().add(newSpec.getDType().getSpecification());
		}
		if(newSpec.getDSignature() != DPFConstants.DEFAULT_DSIGNATURE){
			diagram.getContents().add(newSpec.getDSignature());
			model.getContents().a
		 */
	}
}
