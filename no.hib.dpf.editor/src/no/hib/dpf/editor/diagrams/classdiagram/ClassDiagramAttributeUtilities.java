package no.hib.dpf.editor.diagrams.classdiagram;

import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;
import no.hib.dpf.editor.utilities.TemplateNodeAttributeUtils;
import no.hib.dpf.utils.DPFCoreConstants;

/**
 * 
 * @author Ole Klokkhammer
 */
public class ClassDiagramAttributeUtilities {
	
	/**
	 * @author Ole Klokkhammer
	 * @param node
	 * @return
	 */
	public static String generateAttributeString(Node node) {
		Node defaultNode = (Node) node.getTemplateElement();
		if(defaultNode != null && defaultNode.getName().equals(ClassDiagramConstants.NODE_ATTRIBUTE)){
			String retVal = "";
			
			// visibility:
			String visibility = TemplateNodeAttributeUtils.getNodeAttributeData(node, ClassDiagramConstants.NODE_ATTRIBUTE_VISIBILITY)[DataNode.DATAVALUE];
			String visibilityIcon = ClassDiagramConstants.getDefaultVisiblityMap().get(visibility);
			if(visibilityIcon != null){
				retVal += visibilityIcon;
			}
			
			// name:
			String name = node.getName();
			retVal += name;
			
			// value and datatype:
			DataNode valuenode = TemplateNodeAttributeUtils.getDataNode(node, ClassDiagramConstants.NODE_ATTRIBUTE_VALUE);
			DataNode datatype = valuenode.getTypeDataNode();
			if(valuenode != null){
				if(DPFCoreConstants.getEDataTypesMap().containsKey(valuenode.getValue())){
					retVal += " : " + valuenode.getValue();
				}else{
					retVal += " = " + valuenode.getValue();
					retVal += " : " + datatype.getValue();
				}
			}
			
			return retVal;
		}
		return "";
	}

}
