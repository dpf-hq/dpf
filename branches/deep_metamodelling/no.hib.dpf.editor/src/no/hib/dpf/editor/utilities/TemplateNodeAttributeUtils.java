package no.hib.dpf.editor.utilities;

import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;  
public class TemplateNodeAttributeUtils {

	/**
	 * @author Ole Klokkhammer
	 * @param node
	 * @param defaultNodeAttribute
	 * @param direction
	 */
	public static void setDataValue(Node node, String defaultNodeAttribute, String value) {
		for (NodeAttribute nodeattribute : node.getOutgoingAttributes()) {
			if(getTemplateNodeAttributeName(nodeattribute).equals(defaultNodeAttribute)){
				nodeattribute.getTarget().setValue(value);
			}
		}
	}

	/**
	 * 
	 * 
	 * @author Ole Klokkhammer
	 * @param name
	 * @return
	 */
	public static String getTemplateNodeAttributeName(NodeAttribute nodeAttribute){
		String retVal = "";
		NodeAttribute templateNodeAttribute = (NodeAttribute) nodeAttribute.getTemplateElement();
		if(templateNodeAttribute != null){
			Node templateSourceDNode = templateNodeAttribute.getSource();
			retVal = templateNodeAttribute.getName().replaceFirst(templateSourceDNode.getName().toLowerCase(), "");
		}
		return retVal;
	}

	/**
	 * 
	 * @author Ole Klokkhammer
	 * @param attributeDNode
	 * @return
	 */
	public static String[] getNodeAttributeData(Node node, String templateNodeAttributeName){
		String retVal[] = {"", ""};  
		Node templateNode = (Node) node.getTemplateElement();
		if(templateNode != null){
			for (NodeAttribute outgoingNodeAttribute : node.getOutgoingAttributes()) {
				
				String outgoingAttributeName = getTemplateNodeAttributeName(outgoingNodeAttribute);
				
				// now match up the string
				if(outgoingAttributeName.equals(templateNodeAttributeName)){
					DataNode datanode = outgoingNodeAttribute.getTarget();
					if(datanode != null){
						retVal[DataNode.DATAVALUE] = datanode.getValue();
						retVal[DataNode.DATATYPE] = datanode.getDatatype();
					}
				}
			}
		}
		return retVal;
	}
	
	/**
	 * 
	 * @author Ole Klokkhammer
	 * @param attributeDNode
	 * @return
	 */
	public static DataNode getNodeAttributeDataNode(Node node, String templateNodeAttributeName){
		DataNode datanode = null;
		Node templateNode = (Node) node.getTemplateElement();
		if(templateNode != null){
			for (NodeAttribute outgoingNodeAttribute : node.getOutgoingAttributes()) {
				
				String outgoingAttributeName = getTemplateNodeAttributeName(outgoingNodeAttribute);
				
				// now match up the string
				if(outgoingAttributeName.equals(templateNodeAttributeName)){
					datanode = outgoingNodeAttribute.getTarget();
					if(datanode != null){
						break;
					}
				}
			}
		}
		return datanode;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param node
	 * @param defaultNodeAttribute
	 * @return
	 */
	public static DataNode getDataNode(Node node, String templateNodeAttributeName){
		for (NodeAttribute nodeattribute : node.getOutgoingAttributes()) {
			if(getTemplateNodeAttributeName(nodeattribute).equals(templateNodeAttributeName)){
				return nodeattribute.getTarget();
			}
		}
		
		return null;
	}	
}
