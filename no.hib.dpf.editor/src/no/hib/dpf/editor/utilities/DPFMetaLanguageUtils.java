package no.hib.dpf.editor.utilities;

import java.util.ArrayList;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class DPFMetaLanguageUtils {
	
	// Meta-language types
	//*************************************************************************************************
	public static final String DEEP_NODE = "DeepNode"; 
	
	public static final String DEEP_ARROW = "DeepArrow";
	public static final String INHERITANCE = "Inheritance";
	public static final String NODE_VALUE = "Value";
	public static final String NODE_PROPERTY = "NodeProperty";
	public static final String NODE_VISUALIZATION = "NodeVisualization";
	public static final String ARROW_PROPERTY = "ArrowProperty";
	public static final String ARROW_VISUALIZATION = "ArrowVisualization";
	public static final String ARROW_CONTAINMENT = "Containment";
	 
	/**
	 * 
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static ArrayList<String> getMetaTypes(){
		ArrayList<String> lingNames = new ArrayList<String>();
		lingNames.add(DEEP_NODE);
		lingNames.add(DEEP_ARROW );
		lingNames.add(INHERITANCE);
		lingNames.add(NODE_PROPERTY);
		lingNames.add(NODE_VISUALIZATION);
		lingNames.add(NODE_VALUE);
		lingNames.add(ARROW_CONTAINMENT);
		lingNames.add(ARROW_PROPERTY);
		lingNames.add(ARROW_VISUALIZATION);
		return lingNames;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param node
	 * @return
	 */
	public static String getVisualizationData(Node node){
		for (NodeAttribute nodeAttr : node.getOutgoingAttributes()) {
			NodeAttribute metaAttribute = (NodeAttribute) nodeAttr.getElement(DPFCoreConstants.ENRICHED_GRAPH_METALEVEL);
			if(metaAttribute != null && metaAttribute.getName().equals(NODE_VISUALIZATION)){
				DataNode target = nodeAttr.getTarget();
				return target.getValue();
			}
		}
		
		return "";
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param arrow
	 * @return
	 */
	public static String getVisualizationData(Arrow arrow){
		for (ArrowAttribute arrowAttr : arrow.getOutgoingAttributes()) {
			ArrowAttribute metaAttribute = (ArrowAttribute) arrowAttr.getElement(DPFCoreConstants.ENRICHED_GRAPH_METALEVEL);
			if(metaAttribute != null && metaAttribute.getName().equals(ARROW_VISUALIZATION)){
				ArrowAttribute templateAttribute = (ArrowAttribute) arrowAttr.getElement(DPFCoreConstants.TEMPLATE_METALEVEL);
				if(templateAttribute != null){
					DataNode target = arrowAttr.getTarget();
					return target.getValue();
				}
			}
		}
		
		return "";
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param arrow
	 * @return
	 */
	public static boolean isContainment(Arrow arrow){
		for (ArrowAttribute arrowAttr : arrow.getOutgoingAttributes()) {
			ArrowAttribute metaAttribute = (ArrowAttribute) arrowAttr.getElement(DPFCoreConstants.ENRICHED_GRAPH_METALEVEL);
			if(metaAttribute != null && metaAttribute.getName().equals(ARROW_CONTAINMENT)){
				ArrowAttribute templateAttribute = (ArrowAttribute) arrowAttr.getElement(DPFCoreConstants.TEMPLATE_METALEVEL);
				if(templateAttribute != null){
					DataNode target = arrowAttr.getTarget();
					return Boolean.parseBoolean(target.getValue().trim());
				}
			}
		}
		
		return false;
	}

	
	/**
	 * @author Ole Klokkhammer
	 * @param newObject
	 * @param potency
	 * @return a list of DNodes in which has a value nodeattribute and has the specified potency
	 */
	public static ArrayList<DNode> getContainmentDNodes(DNode newObject, int potency) {
		ArrayList<DNode> containmentDNodes = new ArrayList<DNode>();
		for (DArrow outgoingDArrow : newObject.getDOutgoings()) {
			if(isContainment(outgoingDArrow.getArrow())){
				containmentDNodes.add(outgoingDArrow.getDTarget());
			}
		}
		
		return containmentDNodes;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param arrow
	 * @return
	 */
	public static DataNode getValueNode(Node node){
		for (NodeAttribute nodeAttr : node.getOutgoingAttributes()) {
			NodeAttribute metaAttribute = (NodeAttribute) nodeAttr.getElement(DPFCoreConstants.ENRICHED_GRAPH_METALEVEL);
			if(metaAttribute != null && metaAttribute.getName().equals(NODE_VALUE)){
				return nodeAttr.getTarget();
			}
		}
		
		return null;
	}
	
	
	/**
	 * @author Ole Klokkhammer
	 * @param sourceDType
	 * @return
	 */
	public static boolean hasSuperTypes(DNode sourceDType) {
		return !getSuperTypes(sourceDType).isEmpty();
	}
	

	/**
	 * 
	 * Used for inheritance, but needs improvements as inheritance of potency is a complicated thing
	 * @author Ole Klokkhammer
	 * @param dnode
	 * @return
	 */
	public static ArrayList<DNode> getSuperTypes(DNode dnode){
		ArrayList<DNode> superTypes = new ArrayList<DNode>();
	
		if(dnode == null || dnode.getNode() == null || dnode.getNode().isTemplateElement()){
			return superTypes;
		}
		
		// check each outgoing arrow if its an generalization arrow - add it to the arraylist if it is
		for(DArrow darrow  : dnode.getDOutgoings()){
			Arrow arrow = darrow.getArrow();
			Assert.isNotNull(arrow);
			Arrow templateType = (Arrow) arrow.getTemplateElement();
			if(templateType != null && templateType.getTypeArrow() != null){
				String metaLanguageType = templateType.getTypeArrow().getName();
				
				if(metaLanguageType.equals(DPFMetaLanguageUtils.INHERITANCE)){
					if(arrow.eIsSet(CorePackage.Literals.DEEP_ELEMENT__POTENCY)){
						superTypes.add(darrow.getDTarget());
					}
				}
			}
		}
		return superTypes;
	}
	// End of linguistic definition
	//*************************************************************************************************
}
