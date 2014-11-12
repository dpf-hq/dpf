package no.hib.dpf.visualization.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.nature.DPFProjectSupport;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.VisualUtils;
import no.hib.dpf.visual.Visuals;
import no.hib.dpf.visual.util.DPFVisualTemplateMappingUtils;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.Visualizations;
import no.hib.dpf.visualization.presentation.VisualizationEditor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * 
 * @author Ole Klokkhammer
 */
public class VisualizationModelUtils {
	
	/**
	 * @author Ole Klokkhammer
	 * @param delement from current graph
	 * @param maps
	 * @return the delements corresponding VElement
	 */
	public static VElement getVElement(DElement delement, EMap<DElement, VElement> maps) {
		VElement velement = null; 
		
		if(delement instanceof DNode){
			DNode templateDNode = ((DNode)delement).getTemplateDNode();
			velement = maps.get(templateDNode);
		}
		
		if(delement instanceof DArrow){
			DArrow defaultDArrow = ((DArrow)delement).getTemplateDArrow();
			velement = maps.get(defaultDArrow);
		}
		
		return velement;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param compElementDNode
	 * @param compartment
	 * @return
	 */
	public static boolean canAdd(VCompartmentElement newCompElement, VCompartment compartment) {

		DNode dnode = newCompElement.getDNode();
		if(dnode == null){
			return false;
		}
		
		DNode templateDNnode = dnode.getDType().getTemplateDNode();
		if(templateDNnode == null){
			return false;
		}

		DNode compartmentDNode = (DNode)compartment.getCompartmentDNode();
		if(templateDNnode == compartmentDNode){
			return true;
		}
		
		return false;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param compElement
	 * @param parent
	 * @return
	 */
	public static boolean canConnect(DNode compElement, DNode parent) {
		DNode sourceDType = null;
		DNode targetDType = null;
		
		// the compartment element determines what metalevel we're at:
		DNode typeDNode = compElement.getDType();
		Assert.isNotNull(typeDNode);
		Node typeNode = typeDNode.getNode();
		Assert.isNotNull(typeNode); 
		
		ArrayList<String> templateNodes = DPFTemplateUtils.getTemplateNodes((DGraph)typeDNode.eContainer());
		
		boolean isExtensionFromDefaultMetalevel = false;
		if(templateNodes.contains(typeNode.getName())){
			isExtensionFromDefaultMetalevel = true;
		}
		
		// align 
		if(isExtensionFromDefaultMetalevel){
			sourceDType = parent.getDType().getTemplateDNode();
			targetDType = compElement.getDType().getTemplateDNode();
		}else{
			sourceDType = parent.getDType();
			targetDType = compElement.getDType();
		}
		
		// sanity check
		if(sourceDType == null || targetDType == null){
			return false;
		}
		
		for (DArrow darrow : sourceDType.getDOutgoings()) {
			DNode target = darrow.getDTarget();
			
			if(target == targetDType){
				return true;
			}
		}

		return false;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param vElement
	 * @return
	 */
	public static boolean isComposedVArrow(VElement vElement) {
		return vElement != null && vElement instanceof VArrow && ((VArrow)vElement).isComposed();
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param vElement
	 * @return
	 */
	public static boolean isCompositeVNode(VElement vElement) {
		return vElement != null && vElement instanceof VNode && ((VNode)vElement).isComposite();
	}
	
	/*
	 * find if there is a composed visual configure for the arrow which target to the node. 
	 */
	public static boolean isVCompartmentElement(DNode dnode, EMap<DElement, VElement> maps){
		VNode vnode = (VNode)VisualizationModelUtils.getVElement(dnode, maps);
		if(vnode != null && vnode.isComposite()){
			return false;
		}
		
		for(DArrow typeDArrow : dnode.getDIncomings()){
			
			VElement varrow = VisualizationModelUtils.getVElement(typeDArrow, maps);
			if(varrow != null && isComposedVArrow(varrow)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dSpecification
	 * @param visuals
	 * @return
	 */
	public static Visualizations getNewVisualization(DSpecification dSpecification, Visuals visuals) {
		Visualizations visualizations = VisualizationFactory.eINSTANCE.createVisualizations();
		
		// set visual model
		visualizations.setVisual(visuals);
		
		// create default mapping between elements
		Map<DElement, VElement> maps = DPFVisualTemplateMappingUtils.getTemplateMapping(dSpecification, visuals);
		visualizations.getEntries().putAll(maps);
		
		// set the specification instance
		visualizations.setInstance(dSpecification);
		
		return visualizations;
	}

	
	
	public static Visuals getDefaultVisualModel(String initialLocation) {
		String filePath = new String(initialLocation);
		
		String workspace = VisualizationEditor.getWorkspaceDirectory();
		workspace = workspace.replace("/", "\\");
		if(filePath.contains(workspace)){
			filePath = filePath.substring(workspace.length(), filePath.length());
		}
		int i = filePath.indexOf("\\");
		if(i == 0){
			i = filePath.indexOf("\\", 2);
		}
		filePath = filePath.substring(0, i);
		
		workspace += filePath + "\\" + DPFProjectSupport.FOLDERNAME_TEMPLATE_VISUALIZATION_MODELS + "\\class_diagram.visual";
		
		Visuals visuals = VisualUtils.loadVisuals(new ResourceSetImpl(), URI.createFileURI(workspace), new HashMap<Resource, Diagnostic>());
		
		return visuals;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param newObject
	 * @return
	 */
	public static ArrayList<DNode> getParameterList(DNode newObject, EMap<DElement, VElement> maps) {
		ArrayList<DNode> pList = new ArrayList<DNode>();
		if(maps != null){
			for (DArrow darrow : newObject.getDOutgoings()) {
				Assert.isNotNull(darrow);
				DNode dTarget = darrow.getDTarget();
				Assert.isNotNull(dTarget);
				
				VNode vnode = (VNode)getVElement(dTarget, maps);
				if(vnode != null && vnode.isComposite()){
					continue;
				}
				
				DArrow typeDArrow = darrow.getDType();
				VArrow varrow = (VArrow) getVElement(typeDArrow, maps);
				if(varrow.isComposed() ){
					pList.add(dTarget);
				}
			}
		}
		return pList;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param newObject
	 * @return
	 */
	public static boolean hasParameters(DNode newObject, EMap<DElement, VElement> maps) {
		DNode templateDNode = newObject.getTemplateDNode();
		if(maps != null){
			for (DArrow darrow : templateDNode.getDOutgoings()) {
				Assert.isNotNull(darrow);
				DNode dTarget = darrow.getDTarget();
				Assert.isNotNull(dTarget);
				DNode typeDTarget = dTarget.getDType();
				
				VNode vnode = (VNode)maps.get(typeDTarget);
				if(vnode != null && vnode.isComposite()){
					continue;
				}
				
				DArrow typeDArrow = darrow.getDType();
				VArrow varrow = (VArrow) maps.get(typeDArrow);
				if(varrow.isComposed() ){
					return true;
				}
			}
		}
		return false;
	}	
}
