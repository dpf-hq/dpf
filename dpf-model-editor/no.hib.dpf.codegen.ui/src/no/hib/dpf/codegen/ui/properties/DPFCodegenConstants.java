package no.hib.dpf.codegen.ui.properties;

import org.eclipse.core.runtime.QualifiedName;

public interface DPFCodegenConstants {
	//This interface contains properties which the project can set and their corresponding QualifiedNames which has to
	//be used internally in IProject
	//Also contains default values set in the project
	
	public static final String NATURE_ID = "no.hib.dpf.codegen.ui.nature.codegennature";
	
	public static final String PROPERTY_NAMESPACE_URI = "http://dpf.hib.no/2011/dpf/codegen";

	//Local property
	public static final String MODEL_TARGET_SRC_DIR_PROPERTY = "modeltarget";
	public static final String CONTROLLER_TARGET_SRC_DIR_PROPERTY = "controllertarget";
	public static final String VIEW_TARGET_SRC_DIR_PROPERTY = "viewtarget";
	public static final String GENERATE_ANNOTATIONS_PROPERTY = "annotations";
	public static final String TARGET_DIR_PROPERTY = "targetproperty";
	
	public static final QualifiedName MODEL_TARGET_SOURCE_DIR_PROPERTY = new QualifiedName(PROPERTY_NAMESPACE_URI, MODEL_TARGET_SRC_DIR_PROPERTY);
	public static final QualifiedName CONTROLLER_TARGET_SOURCE_DIR_PROPERTY = new QualifiedName(PROPERTY_NAMESPACE_URI, CONTROLLER_TARGET_SRC_DIR_PROPERTY);
	public static final QualifiedName VIEW_TARGET_SOURCE_DIR_PROPERTY = new QualifiedName(PROPERTY_NAMESPACE_URI, VIEW_TARGET_SRC_DIR_PROPERTY);
	public static final QualifiedName ANNOTATIONS_PROPERTY = new QualifiedName(PROPERTY_NAMESPACE_URI, GENERATE_ANNOTATIONS_PROPERTY);
	public static final QualifiedName TARGET_SOURCE_DIR_PROPERTY = new QualifiedName(PROPERTY_NAMESPACE_URI, TARGET_DIR_PROPERTY);
	
	//Default values
	public static final String DEFAULT_MODEL_TARGET_SRC_DIR = "app/models";
	public static final String DEFAULT_CONTROLLER_TARGET_SRC_DIR = "app/controller";
	public static final String DEFAULT_VIEW_TARGET_SRC_DIR = "app/view";
	public static final String DEFAULT_ANNOTATIONS = String.valueOf(false);
	public static final String DEFAULT_TARGET_DIR = "app";
}
