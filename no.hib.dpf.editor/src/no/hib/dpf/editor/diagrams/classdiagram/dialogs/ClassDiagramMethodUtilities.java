package no.hib.dpf.editor.diagrams.classdiagram.dialogs;

import no.hib.dpf.core.Arrow;
//import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
import no.hib.dpf.editor.utilities.DPFModelUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.geometry.Point;

/**
 * 
 */
public class ClassDiagramMethodUtilities {
	
	/**
	 * 
	 * @author Ole Klokkhammer
	 * @param methodName
	 * @param parameters
	 * @param dgraph
	 * @param returnType
	 * @return
	 */
	public static DNode createNewMethodForMethodDNode(DNode method, String methodName, int potency, String returnTypeName, DGraph dgraph) {
		Assert.isNotNull(dgraph); 
		DGraph dgraphDType = dgraph.getDType();
		Assert.isNotNull(dgraphDType);
		
		method.getNode().setName(methodName);
//		method.getNode().setPotency(potency);
		generateParameterDNode(method, dgraph, potency, returnTypeName);
		
		return method;
	}

	private static void generateParameterDNode(DNode method, DGraph dgraph, int potency, String returnTypeName) {
		Assert.isNotNull(dgraph); 
		DGraph dgraphDType = dgraph.getDType();
		Assert.isNotNull(dgraphDType);
		
		// get type parameter node and arrow
		DNode parameterDNodetype = DPFModelUtils.getDNodeFromDGraph(ClassDiagramConstants.NODE_METHOD_PARAMETER, dgraphDType);
		DArrow parameterDArrowtype = DPFModelUtils.getDArrowFromDGraph(ClassDiagramConstants.ARROW_METHOD_PARAMETER, dgraphDType);
		
		if(parameterDNodetype != null && parameterDArrowtype != null){
			
			// generate parameternode
//			DNode parameterDNode = generateParameterForMethod(method, parameterDArrowtype, parameterDNodetype, potency, dgraph);
//			DataNode direction_datanode = TemplateNodeAttributeUtils.getDataNode(parameterDNode.getNode(), ClassDiagramConstants.NODE_ATTRIBUTE_PARAMETER_DIRECTION);
//			direction_datanode.setValue("return");
//			DataNode value_datanode = DPFMetaLanguageUtils.getValueNode(parameterDNode.getNode());
//			value_datanode.setValue(returnTypeName);
		}			
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param methodDNode
	 * @param parameterTypeDArrow
	 * @param parameterTypeDNode
	 * @param potency
	 * @param dgraph
	 * @return
	 */
	public static DNode generateParameterForMethod(DNode methodDNode, DArrow parameterTypeDArrow, DNode parameterTypeDNode, int potency, DGraph dgraph) {

		// create parameter node
		DNode parameterDNode = DPFModelUtils.createDNode(parameterTypeDNode);
		parameterDNode.setLocation(new Point(5,5));
		dgraph.addDNode(parameterDNode); 
		
		// create parameter arrow to connect the method and the parameter
		DArrow method_to_parameterDArrow = DPFModelUtils.createDArrow(parameterTypeDArrow);
		DPFModelUtils.connectDArrow(methodDNode, method_to_parameterDArrow, parameterDNode);
//		method_to_parameterDArrow.getArrow().setPotency(potency);
		dgraph.addDArrow(method_to_parameterDArrow);
		
		// generate attributes for the parameter-node
//		DPFTemplateUtils.replicateTemplateNodeAttributesForNode(parameterDNode, dgraph);
//		parameterDNode.getNode().setPotency(potency);
		parameterDNode.getNode().setName(methodDNode.getName());
		
		return parameterDNode;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param node
	 * @return
	 */
	public static String generateMethodString(Node node) {
		Node defaultNode = (Node) node.getTemplateElement();
		if(node != null && defaultNode.getName().equals(ClassDiagramConstants.NODE_METHOD)){
			
			// iterate over the attributes to find the attributevalue datanode
			String name = node.getName();
//			String visibility = TemplateNodeAttributeUtils.getNodeAttributeData(node, ClassDiagramConstants.NODE_ATTRIBUTE_VISIBILITY)[DataNode.DATAVALUE];
//			String visibilityIcon = ClassDiagramConstants.getDefaultVisiblityMap().get(visibility);
			String visibilityIcon = "?";
			
//			Node parameter_value = null;
			String methodReturnType = "";
			for (Arrow arrow : node.getOutgoings()) {
				if(arrow != null){
					Node targetNode = arrow.getTarget();
					if(targetNode != null){ 
//						Node templateNode = (Node) targetNode.getTemplateElement();
//						if(templateNode != null && templateNode.getName() != null && templateNode.getName().equals(ClassDiagramConstants.NODE_METHOD_PARAMETER)){
//							parameter_value = DPFMetaLanguageUtils.getValueNode(targetNode);
//						}
					}
				}
			}
			
//			if(parameter_value != null){
//				methodReturnType = parameter_value.getValue();
//			}
			
			
			
			String retVal = visibilityIcon + name + "()";
//			if(methodReturnType == null){
//				retVal += " : void";
//			}else
				if(methodReturnType.equals("")){
				retVal += " : void";
			}else{
				retVal += " : " + methodReturnType;
			}
			
			return retVal;
		}
		return "";
	}

	//*********************************************************************************************************************************************
}
