package no.hib.dpf.editor.utilities;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.DataNode;  
public class TemplateArrowAttributeUtils {

	/**
	 * @author Ole Klokkhammer
	 * @param arrow
	 * @param templateNodeAttribute
	 * @param direction
	 */
	public static void setDataValue(Arrow arrow, String templateNodeAttribute, String value) {
		for (ArrowAttribute arrowattribute : arrow.getOutgoingAttributes()) {
			if(getTemplateArrowAttributeName(arrowattribute).equals(templateNodeAttribute)){
				arrowattribute.getTarget().setValue(value);
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
	public static String getTemplateArrowAttributeName(ArrowAttribute arrowAttribute){
		String retVal = "";
		ArrowAttribute templateArrowAttribute = (ArrowAttribute) arrowAttribute.getTemplateElement();
		if(templateArrowAttribute != null){
			Arrow templateSourceDArrow = templateArrowAttribute.getSource();
			retVal = templateArrowAttribute.getName().replaceFirst(templateSourceDArrow.getName().toLowerCase(), "");
		}
		return retVal; 
	}

	/**
	 * 
	 * @author Ole Klokkhammer
	 * @param attributeDNode
	 * @return
	 */
	public static String[] getArrowAttributeData(Arrow arrow, String templateArrowAttributeName){
		String retVal[] = {"", ""};  
		Arrow templateArrow = (Arrow) arrow.getTemplateElement();
		if(templateArrow != null){
			for (ArrowAttribute outgoingArrowAttribute : arrow.getOutgoingAttributes()) {
				
				String outgoingAttributeName = getTemplateArrowAttributeName(outgoingArrowAttribute);
				
				// now match up the string
				if(outgoingAttributeName.equals(templateArrowAttributeName)){
					DataNode datanode = outgoingArrowAttribute.getTarget();
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
	 * @author Ole Klokkhammer
	 * @param arrow
	 * @param defaultNodeAttribute
	 * @return
	 */
	public static DataNode getDataNode(Arrow arrow, String defaultArrowAttributeName){
		for (ArrowAttribute arrowattribute : arrow.getOutgoingAttributes()) {
			if(getTemplateArrowAttributeName(arrowattribute).equals(defaultArrowAttributeName)){
				return arrowattribute.getTarget();
			}
		}
		
		return null;
	}	
}
