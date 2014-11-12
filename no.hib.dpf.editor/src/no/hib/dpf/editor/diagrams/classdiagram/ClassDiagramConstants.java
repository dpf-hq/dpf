package no.hib.dpf.editor.diagrams.classdiagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassDiagramConstants {
	// Default Node types
	// *************************************************************************************************
	public static final String NODE_CLABJECT = "Clabject";
	public static final String NODE_ATTRIBUTE = "Attribute";
	public static final String NODE_METHOD = "Method";
	public static final String NODE_METHOD_PARAMETER = "Parameter";

	/**
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static final ArrayList<String> getTemplateNodeNames() {
		ArrayList<String> nodeList = new ArrayList<String>();
		nodeList.add(NODE_METHOD);
		nodeList.add(NODE_CLABJECT);
		nodeList.add(NODE_METHOD_PARAMETER);
		nodeList.add(NODE_ATTRIBUTE);
		return nodeList;
	}

	// End of Node definition
	// *************************************************************************************************
	
	// NodeAttribute definition
	//*************************************************************************************************
	public static final String NODE_ATTRIBUTE_VISUALIZATION = "Visualization";
	public static final String NODE_ATTRIBUTE_VISIBILITY = "Visibility";
	public static final String NODE_ATTRIBUTE_NAME = "Name";
	public static final String NODE_ATTRIBUTE_VALUE = "Value";
	public static final String NODE_ATTRIBUTE_DATATYPE = "DataType";
	public static final String NODE_ATTRIBUTE_PARAMETER_DIRECTION = "Direction";
	public static final String NODE_ATTRIBUTE_PARAMETER_ORDER = "Order";
	public static final String NODE_ATTRIBUTE_IS_STATIC = "IsStatic";
	public static final String NODE_ATTRIBUTE_IS_FINAL = "IsFinal";
	public static final String NODE_ATTRIBUTE_IS_ABSTRACT = "IsAbstract";
	public static final String NODE_ATTRIBUTE_IS_INTERFACE = "IsInterface";

	/**
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static final ArrayList<String> getDefaultNodeAttributeNames(){
		ArrayList<String> nodeAttributeList = new ArrayList<String>();
		
		nodeAttributeList.add(NODE_ATTRIBUTE_IS_STATIC);
		nodeAttributeList.add(NODE_ATTRIBUTE_IS_FINAL);
		nodeAttributeList.add(NODE_ATTRIBUTE_IS_ABSTRACT);
		nodeAttributeList.add(NODE_ATTRIBUTE_VISIBILITY);
		nodeAttributeList.add(NODE_ATTRIBUTE_NAME);
		nodeAttributeList.add(NODE_ATTRIBUTE_VALUE);
		nodeAttributeList.add(NODE_ATTRIBUTE_DATATYPE);
		nodeAttributeList.add(NODE_ATTRIBUTE_IS_INTERFACE);
		nodeAttributeList.add(NODE_ATTRIBUTE_PARAMETER_DIRECTION);
		nodeAttributeList.add(NODE_ATTRIBUTE_PARAMETER_ORDER);
		nodeAttributeList.add(NODE_ATTRIBUTE_VISUALIZATION);
		
		return nodeAttributeList;
	}
	// End of NodeAttribute definition
	//*************************************************************************************************
	
	// Default Arrow types
	//*************************************************************************************************
	public static final String ARROW_METHOD = "Method";
	public static final String ARROW_METHOD_PARAMETER = "MethodParameter";
	public static final String ARROW_METHOD_PARAMETER_TYPE = "MethodParameterType";
	public static final String ARROW_REFERENCE = "Reference";
	public static final String ARROW_GENERALIZATION = "Generalization";	
	public static final String ARROW_ATTRIBUTE = "Attribute";
	
	/**
	 * 
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static final ArrayList<String> getTemplateArrowNames(){
		ArrayList<String> arrowList = new ArrayList<String>();
		arrowList.add(ARROW_ATTRIBUTE);
		arrowList.add(ARROW_METHOD);
		arrowList.add(ARROW_METHOD_PARAMETER); 
		arrowList.add(ARROW_METHOD_PARAMETER_TYPE); 
		arrowList.add(ARROW_REFERENCE);
		arrowList.add(ARROW_GENERALIZATION);
		return arrowList;
	}
	// End of Arrow definition
	//*************************************************************************************************
	
	//*************************************************************************************************
	public static final String ARROW_ATTRIBUTE_VISUALIZATION = "Visualization";
	public static final String ARROW_ATTRIBUTE_IS_CONTAINMENT = "ReferenceIsContainment";

	/**
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static final ArrayList<String> getDefaultArrowAttributeNames(){
		ArrayList<String> arrowAttributeList = new ArrayList<String>();
		
		arrowAttributeList.add(ARROW_ATTRIBUTE_VISUALIZATION);
		
		return arrowAttributeList;
	}
	// End of NodeAttribute definition
	//*************************************************************************************************
	
	// Method Parameter
	public static final String PARAMETER_DIRECTION_RETURN = "return";
	public static final String PARAMETER_DIRECTION_INPUT = "input";
	
	// Visibility
	public static final String VISIBILITY_DEFAULT = "default";
	public static final String VISIBILITY_PUBLIC = "public";
	public static final String VISIBILITY_PROTECTED = "protected";
	public static final String VISIBILITY_PRIVATE = "private";
	public static final String VISIBILITY_STATIC = "static";
	public static final String VISIBILITY_DERIVED = "derived";
	
	/**
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static final ArrayList<String> getDefaultVisibilityValues(){
		ArrayList<String> visibilityValues = new ArrayList<String>();
		visibilityValues.add(VISIBILITY_DEFAULT);
		visibilityValues.add(VISIBILITY_PUBLIC);
		visibilityValues.add(VISIBILITY_PROTECTED);
		visibilityValues.add(VISIBILITY_PRIVATE);
		visibilityValues.add(VISIBILITY_STATIC);
		visibilityValues.add(VISIBILITY_DERIVED);
		
		return visibilityValues;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @return
	 */
	public static final Map<String, String> getDefaultVisiblityMap(){
		Map<String, String> visibilityMap = new HashMap<String, String>();
		
		visibilityMap.put(VISIBILITY_DEFAULT, " ~ ");
		visibilityMap.put(VISIBILITY_PUBLIC, " + ");
		visibilityMap.put(VISIBILITY_PROTECTED, " # ");
		visibilityMap.put(VISIBILITY_PRIVATE, " - ");
		visibilityMap.put(VISIBILITY_STATIC, " _ ");
		visibilityMap.put(VISIBILITY_DERIVED, " / ");
		
		return visibilityMap;
	}
	
	
	//*************************************************************************************************
}
