package no.hib.dpf.visualization.util;

import java.util.Comparator;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

public class VCompartmentUtils {

	/**
	 * @author Ole Klokkhammer
	 * @param visualization
	 */
	public static void addCompartments(Visualizations visualization) {
		DSpecification dspec = visualization.getInstance();
		DGraph dgraph = dspec.getDGraph();
		
		for(DNode dNode : dgraph.getDNodes()){
			DNode typeDNode = dNode.getDType();
			VElement element = VisualizationModelUtils.getVElement(typeDNode, visualization.getEntries());
			if(element instanceof VNode){
				VNode vNode = (VNode) element;
				if(vNode != null && vNode.isComposite()) {
					createCompartments(dNode, visualization.getCompartments(), visualization.getEntries()); 
				}
			}
		}
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dNode
	 * @param visualization
	 */
	public static void createCompartments(DNode dNode, EList<VCompartment> compartments, EMap<DElement, VElement> maps) {
		// Add compartments to composite nodes
		DNode nodeDType = dNode.getDType();
		DNode templateDNode = nodeDType.getTemplateDNode();
		for(DArrow templateDArrow : templateDNode.getDOutgoings()) {
			
			VElement ve = VisualizationModelUtils.getVElement(templateDArrow, maps);
			if(ve != null && ((VArrow) ve).isComposed()) {
				
				VCompartment comp = createCompartment(templateDArrow.getDTarget(), dNode);
				
				// add the new compartment to the visualization
				compartments.add(comp);
			}
		}
	}


	/**
	 * @author Ole Klokkhammer
	 * @param dTarget
	 * @param dNode
	 * @return
	 */
	private static VCompartment createCompartment(DNode dTarget, DNode dNode) {
		// create new compartment and add compartment-node and parent-node
		VCompartment vCompartment = VisualizationFactory.eINSTANCE.createVCompartment();
		vCompartment.setParent(dNode);
		
		DNode templateDNode = dTarget.getTemplateDNode();	
		vCompartment.setCompartmentDNode(templateDNode);
		vCompartment.setName(templateDNode.getName());
		
		return vCompartment;
	}
	
	// Public 
	//********************************************************************************************************************************
	
	/**
	 * 
	 * Used to arrange the compartments so Attributes is on top.
	 * 
	 * @author Ole Klokkhammer
	 * @param comp
	 */
	public static void sortAlphabetically(EList<VCompartment> comp) {
		java.util.Collections.sort(comp, new Comparator<VCompartment>() {
			@Override
			public int compare(VCompartment compartment1, VCompartment compartment2) {
				try{
					return compartment1.getCompartmentDNode().getName().compareTo(compartment2.getCompartmentDNode().getName());
				}catch(NullPointerException e){
				}
				return 0;
			}
		});
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dNode
	 * @param compartments
	 * @param maps
	 * @return
	 */
	public static EList<VCompartment> getCompartments(DNode dNode, EList<VCompartment> compartments, EMap<DElement, VElement> maps) {
		EList<VCompartment> nodeCompartments = new BasicEList<VCompartment>();
		for(VCompartment compartment: compartments){
			if(compartment.getParent() == dNode){
				nodeCompartments.add(compartment);
			}
		}
		
		DNode typeDNode = dNode.getDType();
		DNode templateDNode = typeDNode.getTemplateDNode();
		VNode vnode = (VNode)VisualizationModelUtils.getVElement(typeDNode, maps);
		if(vnode != null && vnode.isComposite() && nodeCompartments.isEmpty()) {
			for(DArrow templateDArrow : templateDNode.getDOutgoings()) {
				
				VElement velement = VisualizationModelUtils.getVElement(templateDArrow, maps);
				if(velement != null && ((VArrow) velement).isComposed()) {
					VCompartment vCompartment = VisualizationFactory.eINSTANCE.createVCompartment();
					vCompartment.setName(templateDArrow.getDTarget().getName());
					
					DNode templateTargetDNode = templateDArrow.getDTarget();
					vCompartment.setCompartmentDNode(templateTargetDNode);
					vCompartment.setParent(typeDNode);
					compartments.add(vCompartment);
					nodeCompartments.add(vCompartment);
				}	
			}
		}
		
		// Add compartmentElements to compartments if any are saved
		for(DArrow dArrow : dNode.getDOutgoings()){
			
			DArrow typeDArrow = dArrow.getDType();
			VElement velement = VisualizationModelUtils.getVElement(typeDArrow, maps);
			if(velement != null && ((VArrow) velement).isComposed()) {
				
				// create new compartmentelement
				VCompartmentElement compElement = VisualizationFactory.eINSTANCE.createVCompartmentElement();
				compElement.setDNode(dArrow.getDTarget());
				for(VCompartment compartment : nodeCompartments ){
					if(compartment.getParent() == dNode && VisualizationModelUtils.canAdd(compElement, compartment)){
						compartment.addChild(compElement);
					}
				}
			}
		}
		
		
		// sort the nodeCompartments alphabetically
		VCompartmentUtils.sortAlphabetically(nodeCompartments);
		return nodeCompartments;
	}
}
