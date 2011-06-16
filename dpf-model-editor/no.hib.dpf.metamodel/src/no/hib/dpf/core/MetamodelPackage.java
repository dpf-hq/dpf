/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see no.hib.dpf.core.MetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface MetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://no.hib.dpf.core";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "no.hib.dpf.core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelPackage eINSTANCE = no.hib.dpf.core.impl.MetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.GraphImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.NodeImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.SignatureImpl <em>Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.SignatureImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getSignature()
	 * @generated
	 */
	int SIGNATURE = 3;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.PredicateImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.VisualizationImpl <em>Visualization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.VisualizationImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getVisualization()
	 * @generated
	 */
	int VISUALIZATION = 6;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.NodeToNodeMapImpl <em>Node To Node Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.NodeToNodeMapImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getNodeToNodeMap()
	 * @generated
	 */
	int NODE_TO_NODE_MAP = 7;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.ConstraintImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 8;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.TypingMorphismImpl <em>Typing Morphism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.TypingMorphismImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getTypingMorphism()
	 * @generated
	 */
	int TYPING_MORPHISM = 10;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.GraphHomomorphismImpl <em>Graph Homomorphism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.GraphHomomorphismImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getGraphHomomorphism()
	 * @generated
	 */
	int GRAPH_HOMOMORPHISM = 11;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.IDObjectImpl <em>ID Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.IDObjectImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getIDObject()
	 * @generated
	 */
	int ID_OBJECT = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_OBJECT__ID = 0;

	/**
	 * The number of structural features of the '<em>ID Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_OBJECT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NAME = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arrows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__ARROWS = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__CONSTRAINTS = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GRAPH = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE_NODE = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.ArrowImpl <em>Arrow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.ArrowImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getArrow()
	 * @generated
	 */
	int ARROW = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__TARGET = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__GRAPH = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Arrow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__TYPE_ARROW = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__SOURCE = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__NAME = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Arrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__PREDICATES = 0;

	/**
	 * The number of structural features of the '<em>Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__SHAPE = 0;

	/**
	 * The feature id for the '<em><b>Semantics Validator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__SEMANTICS_VALIDATOR = 1;

	/**
	 * The feature id for the '<em><b>Visualization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__VISUALIZATION = 2;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__SYMBOL = 3;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.SemanticsValidator <em>Semantics Validator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.SemanticsValidator
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getSemanticsValidator()
	 * @generated
	 */
	int SEMANTICS_VALIDATOR = 5;

	/**
	 * The number of structural features of the '<em>Semantics Validator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTICS_VALIDATOR_FEATURE_COUNT = 0;

	/**
	 * The number of structural features of the '<em>Visualization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATION_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TO_NODE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TO_NODE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Node To Node Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_TO_NODE_MAP_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__GRAPH = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__PREDICATE = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__MAPPINGS = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__PARAMETERS = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.ArrowToArrowMapImpl <em>Arrow To Arrow Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.ArrowToArrowMapImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getArrowToArrowMap()
	 * @generated
	 */
	int ARROW_TO_ARROW_MAP = 9;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_TO_ARROW_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_TO_ARROW_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Arrow To Arrow Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_TO_ARROW_MAP_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING_MORPHISM__MODEL = 0;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING_MORPHISM__METAMODEL = 1;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING_MORPHISM__MAPPINGS = 2;

	/**
	 * The number of structural features of the '<em>Typing Morphism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPING_MORPHISM_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Node Mapping</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_HOMOMORPHISM__NODE_MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Arrow Mapping</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_HOMOMORPHISM__ARROW_MAPPING = 1;

	/**
	 * The number of structural features of the '<em>Graph Homomorphism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_HOMOMORPHISM_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.SpecificationImpl <em>Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.SpecificationImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getSpecification()
	 * @generated
	 */
	int SPECIFICATION = 13;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Type Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__TYPE_GRAPH = 1;

	/**
	 * The number of structural features of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.ModelHierarchyImpl <em>Model Hierarchy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.ModelHierarchyImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getModelHierarchy()
	 * @generated
	 */
	int MODEL_HIERARCHY = 14;

	/**
	 * The feature id for the '<em><b>Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_HIERARCHY__SPECIFICATIONS = 0;

	/**
	 * The number of structural features of the '<em>Model Hierarchy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_HIERARCHY_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.JointlySurjectiveSemanticsImpl <em>Jointly Surjective Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.JointlySurjectiveSemanticsImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getJointlySurjectiveSemantics()
	 * @generated
	 */
	int JOINTLY_SURJECTIVE_SEMANTICS = 15;

	/**
	 * The number of structural features of the '<em>Jointly Surjective Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOINTLY_SURJECTIVE_SEMANTICS_FEATURE_COUNT = SEMANTICS_VALIDATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.InverseSemanticsImpl <em>Inverse Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.InverseSemanticsImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getInverseSemantics()
	 * @generated
	 */
	int INVERSE_SEMANTICS = 16;

	/**
	 * The number of structural features of the '<em>Inverse Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVERSE_SEMANTICS_FEATURE_COUNT = SEMANTICS_VALIDATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.IrreflexiveSemanticsImpl <em>Irreflexive Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.IrreflexiveSemanticsImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getIrreflexiveSemantics()
	 * @generated
	 */
	int IRREFLEXIVE_SEMANTICS = 17;

	/**
	 * The number of structural features of the '<em>Irreflexive Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IRREFLEXIVE_SEMANTICS_FEATURE_COUNT = SEMANTICS_VALIDATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.MultiplicitySemanticsImpl <em>Multiplicity Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.MultiplicitySemanticsImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getMultiplicitySemantics()
	 * @generated
	 */
	int MULTIPLICITY_SEMANTICS = 18;

	/**
	 * The number of structural features of the '<em>Multiplicity Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICITY_SEMANTICS_FEATURE_COUNT = SEMANTICS_VALIDATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.XORSemanticsImpl <em>XOR Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.XORSemanticsImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getXORSemantics()
	 * @generated
	 */
	int XOR_SEMANTICS = 19;

	/**
	 * The number of structural features of the '<em>XOR Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_SEMANTICS_FEATURE_COUNT = SEMANTICS_VALIDATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.TransitiveIrreflexiveSemanticsImpl <em>Transitive Irreflexive Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.TransitiveIrreflexiveSemanticsImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getTransitiveIrreflexiveSemantics()
	 * @generated
	 */
	int TRANSITIVE_IRREFLEXIVE_SEMANTICS = 20;

	/**
	 * The number of structural features of the '<em>Transitive Irreflexive Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITIVE_IRREFLEXIVE_SEMANTICS_FEATURE_COUNT = SEMANTICS_VALIDATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.SurjectiveSemanticsImpl <em>Surjective Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.SurjectiveSemanticsImpl
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getSurjectiveSemantics()
	 * @generated
	 */
	int SURJECTIVE_SEMANTICS = 21;

	/**
	 * The number of structural features of the '<em>Surjective Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURJECTIVE_SEMANTICS_FEATURE_COUNT = SEMANTICS_VALIDATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>EURI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getEURI()
	 * @generated
	 */
	int EURI = 22;

	/**
	 * The meta object id for the '<em>EIO Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.IOException
	 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getEIOException()
	 * @generated
	 */
	int EIO_EXCEPTION = 23;


	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see no.hib.dpf.core.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.core.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see no.hib.dpf.core.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Graph#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.core.Graph#getName()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.core.Graph#getArrows <em>Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arrows</em>'.
	 * @see no.hib.dpf.core.Graph#getArrows()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Arrows();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.core.Graph#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see no.hib.dpf.core.Graph#getConstraints()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Constraints();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see no.hib.dpf.core.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.core.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the container reference '{@link no.hib.dpf.core.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see no.hib.dpf.core.Node#getGraph()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Graph();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Node#getTypeNode <em>Type Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Node</em>'.
	 * @see no.hib.dpf.core.Node#getTypeNode()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_TypeNode();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.Arrow <em>Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arrow</em>'.
	 * @see no.hib.dpf.core.Arrow
	 * @generated
	 */
	EClass getArrow();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Arrow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see no.hib.dpf.core.Arrow#getTarget()
	 * @see #getArrow()
	 * @generated
	 */
	EReference getArrow_Target();

	/**
	 * Returns the meta object for the container reference '{@link no.hib.dpf.core.Arrow#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see no.hib.dpf.core.Arrow#getGraph()
	 * @see #getArrow()
	 * @generated
	 */
	EReference getArrow_Graph();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Arrow#getTypeArrow <em>Type Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Arrow</em>'.
	 * @see no.hib.dpf.core.Arrow#getTypeArrow()
	 * @see #getArrow()
	 * @generated
	 */
	EReference getArrow_TypeArrow();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Arrow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see no.hib.dpf.core.Arrow#getSource()
	 * @see #getArrow()
	 * @generated
	 */
	EReference getArrow_Source();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Arrow#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.core.Arrow#getName()
	 * @see #getArrow()
	 * @generated
	 */
	EAttribute getArrow_Name();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.Signature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signature</em>'.
	 * @see no.hib.dpf.core.Signature
	 * @generated
	 */
	EClass getSignature();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.core.Signature#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predicates</em>'.
	 * @see no.hib.dpf.core.Signature#getPredicates()
	 * @see #getSignature()
	 * @generated
	 */
	EReference getSignature_Predicates();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see no.hib.dpf.core.Predicate
	 * @generated
	 */
	EClass getPredicate();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.core.Predicate#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Shape</em>'.
	 * @see no.hib.dpf.core.Predicate#getShape()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Shape();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.core.Predicate#getSemanticsValidator <em>Semantics Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Semantics Validator</em>'.
	 * @see no.hib.dpf.core.Predicate#getSemanticsValidator()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_SemanticsValidator();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Predicate#getVisualization <em>Visualization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Visualization</em>'.
	 * @see no.hib.dpf.core.Predicate#getVisualization()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Visualization();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Predicate#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see no.hib.dpf.core.Predicate#getSymbol()
	 * @see #getPredicate()
	 * @generated
	 */
	EAttribute getPredicate_Symbol();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.SemanticsValidator <em>Semantics Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantics Validator</em>'.
	 * @see no.hib.dpf.core.SemanticsValidator
	 * @generated
	 */
	EClass getSemanticsValidator();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.Visualization <em>Visualization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visualization</em>'.
	 * @see no.hib.dpf.core.Visualization
	 * @generated
	 */
	EClass getVisualization();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Node To Node Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node To Node Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="no.hib.dpf.core.Node"
	 *        valueType="no.hib.dpf.core.Node"
	 * @generated
	 */
	EClass getNodeToNodeMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getNodeToNodeMap()
	 * @generated
	 */
	EReference getNodeToNodeMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getNodeToNodeMap()
	 * @generated
	 */
	EReference getNodeToNodeMap_Value();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see no.hib.dpf.core.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the container reference '{@link no.hib.dpf.core.Constraint#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see no.hib.dpf.core.Constraint#getGraph()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Graph();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Constraint#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see no.hib.dpf.core.Constraint#getPredicate()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Predicate();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.core.Constraint#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mappings</em>'.
	 * @see no.hib.dpf.core.Constraint#getMappings()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Mappings();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Constraint#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameters</em>'.
	 * @see no.hib.dpf.core.Constraint#getParameters()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Parameters();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Arrow To Arrow Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arrow To Arrow Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="no.hib.dpf.core.Arrow"
	 *        valueType="no.hib.dpf.core.Arrow"
	 * @generated
	 */
	EClass getArrowToArrowMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getArrowToArrowMap()
	 * @generated
	 */
	EReference getArrowToArrowMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getArrowToArrowMap()
	 * @generated
	 */
	EReference getArrowToArrowMap_Value();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.TypingMorphism <em>Typing Morphism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typing Morphism</em>'.
	 * @see no.hib.dpf.core.TypingMorphism
	 * @generated
	 */
	EClass getTypingMorphism();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.TypingMorphism#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see no.hib.dpf.core.TypingMorphism#getModel()
	 * @see #getTypingMorphism()
	 * @generated
	 */
	EReference getTypingMorphism_Model();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.TypingMorphism#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metamodel</em>'.
	 * @see no.hib.dpf.core.TypingMorphism#getMetamodel()
	 * @see #getTypingMorphism()
	 * @generated
	 */
	EReference getTypingMorphism_Metamodel();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.TypingMorphism#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mappings</em>'.
	 * @see no.hib.dpf.core.TypingMorphism#getMappings()
	 * @see #getTypingMorphism()
	 * @generated
	 */
	EReference getTypingMorphism_Mappings();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.GraphHomomorphism <em>Graph Homomorphism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Homomorphism</em>'.
	 * @see no.hib.dpf.core.GraphHomomorphism
	 * @generated
	 */
	EClass getGraphHomomorphism();

	/**
	 * Returns the meta object for the map '{@link no.hib.dpf.core.GraphHomomorphism#getNodeMapping <em>Node Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Node Mapping</em>'.
	 * @see no.hib.dpf.core.GraphHomomorphism#getNodeMapping()
	 * @see #getGraphHomomorphism()
	 * @generated
	 */
	EReference getGraphHomomorphism_NodeMapping();

	/**
	 * Returns the meta object for the map '{@link no.hib.dpf.core.GraphHomomorphism#getArrowMapping <em>Arrow Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Arrow Mapping</em>'.
	 * @see no.hib.dpf.core.GraphHomomorphism#getArrowMapping()
	 * @see #getGraphHomomorphism()
	 * @generated
	 */
	EReference getGraphHomomorphism_ArrowMapping();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.IDObject <em>ID Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ID Object</em>'.
	 * @see no.hib.dpf.core.IDObject
	 * @generated
	 */
	EClass getIDObject();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.IDObject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see no.hib.dpf.core.IDObject#getId()
	 * @see #getIDObject()
	 * @generated
	 */
	EAttribute getIDObject_Id();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specification</em>'.
	 * @see no.hib.dpf.core.Specification
	 * @generated
	 */
	EClass getSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.core.Specification#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graph</em>'.
	 * @see no.hib.dpf.core.Specification#getGraph()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Graph();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.core.Specification#getTypeGraph <em>Type Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Graph</em>'.
	 * @see no.hib.dpf.core.Specification#getTypeGraph()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_TypeGraph();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.ModelHierarchy <em>Model Hierarchy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Hierarchy</em>'.
	 * @see no.hib.dpf.core.ModelHierarchy
	 * @generated
	 */
	EClass getModelHierarchy();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.core.ModelHierarchy#getSpecifications <em>Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specifications</em>'.
	 * @see no.hib.dpf.core.ModelHierarchy#getSpecifications()
	 * @see #getModelHierarchy()
	 * @generated
	 */
	EReference getModelHierarchy_Specifications();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.JointlySurjectiveSemantics <em>Jointly Surjective Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Jointly Surjective Semantics</em>'.
	 * @see no.hib.dpf.core.JointlySurjectiveSemantics
	 * @generated
	 */
	EClass getJointlySurjectiveSemantics();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.InverseSemantics <em>Inverse Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inverse Semantics</em>'.
	 * @see no.hib.dpf.core.InverseSemantics
	 * @generated
	 */
	EClass getInverseSemantics();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.IrreflexiveSemantics <em>Irreflexive Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Irreflexive Semantics</em>'.
	 * @see no.hib.dpf.core.IrreflexiveSemantics
	 * @generated
	 */
	EClass getIrreflexiveSemantics();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.MultiplicitySemantics <em>Multiplicity Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicity Semantics</em>'.
	 * @see no.hib.dpf.core.MultiplicitySemantics
	 * @generated
	 */
	EClass getMultiplicitySemantics();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.XORSemantics <em>XOR Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XOR Semantics</em>'.
	 * @see no.hib.dpf.core.XORSemantics
	 * @generated
	 */
	EClass getXORSemantics();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.TransitiveIrreflexiveSemantics <em>Transitive Irreflexive Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transitive Irreflexive Semantics</em>'.
	 * @see no.hib.dpf.core.TransitiveIrreflexiveSemantics
	 * @generated
	 */
	EClass getTransitiveIrreflexiveSemantics();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.SurjectiveSemantics <em>Surjective Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Surjective Semantics</em>'.
	 * @see no.hib.dpf.core.SurjectiveSemantics
	 * @generated
	 */
	EClass getSurjectiveSemantics();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>EURI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EURI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getEURI();

	/**
	 * Returns the meta object for data type '{@link java.io.IOException <em>EIO Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EIO Exception</em>'.
	 * @see java.io.IOException
	 * @model instanceClass="java.io.IOException"
	 * @generated
	 */
	EDataType getEIOException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetamodelFactory getMetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.GraphImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NAME = eINSTANCE.getGraph_Name();

		/**
		 * The meta object literal for the '<em><b>Arrows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__ARROWS = eINSTANCE.getGraph_Arrows();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__CONSTRAINTS = eINSTANCE.getGraph_Constraints();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.NodeImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__GRAPH = eINSTANCE.getNode_Graph();

		/**
		 * The meta object literal for the '<em><b>Type Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__TYPE_NODE = eINSTANCE.getNode_TypeNode();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.ArrowImpl <em>Arrow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.ArrowImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getArrow()
		 * @generated
		 */
		EClass ARROW = eINSTANCE.getArrow();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW__TARGET = eINSTANCE.getArrow_Target();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW__GRAPH = eINSTANCE.getArrow_Graph();

		/**
		 * The meta object literal for the '<em><b>Type Arrow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW__TYPE_ARROW = eINSTANCE.getArrow_TypeArrow();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW__SOURCE = eINSTANCE.getArrow_Source();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARROW__NAME = eINSTANCE.getArrow_Name();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.SignatureImpl <em>Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.SignatureImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getSignature()
		 * @generated
		 */
		EClass SIGNATURE = eINSTANCE.getSignature();

		/**
		 * The meta object literal for the '<em><b>Predicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIGNATURE__PREDICATES = eINSTANCE.getSignature_Predicates();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.PredicateImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__SHAPE = eINSTANCE.getPredicate_Shape();

		/**
		 * The meta object literal for the '<em><b>Semantics Validator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__SEMANTICS_VALIDATOR = eINSTANCE.getPredicate_SemanticsValidator();

		/**
		 * The meta object literal for the '<em><b>Visualization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__VISUALIZATION = eINSTANCE.getPredicate_Visualization();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE__SYMBOL = eINSTANCE.getPredicate_Symbol();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.SemanticsValidator <em>Semantics Validator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.SemanticsValidator
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getSemanticsValidator()
		 * @generated
		 */
		EClass SEMANTICS_VALIDATOR = eINSTANCE.getSemanticsValidator();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.VisualizationImpl <em>Visualization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.VisualizationImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getVisualization()
		 * @generated
		 */
		EClass VISUALIZATION = eINSTANCE.getVisualization();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.NodeToNodeMapImpl <em>Node To Node Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.NodeToNodeMapImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getNodeToNodeMap()
		 * @generated
		 */
		EClass NODE_TO_NODE_MAP = eINSTANCE.getNodeToNodeMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TO_NODE_MAP__KEY = eINSTANCE.getNodeToNodeMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_TO_NODE_MAP__VALUE = eINSTANCE.getNodeToNodeMap_Value();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.ConstraintImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__GRAPH = eINSTANCE.getConstraint_Graph();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__PREDICATE = eINSTANCE.getConstraint_Predicate();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__MAPPINGS = eINSTANCE.getConstraint_Mappings();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__PARAMETERS = eINSTANCE.getConstraint_Parameters();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.ArrowToArrowMapImpl <em>Arrow To Arrow Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.ArrowToArrowMapImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getArrowToArrowMap()
		 * @generated
		 */
		EClass ARROW_TO_ARROW_MAP = eINSTANCE.getArrowToArrowMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW_TO_ARROW_MAP__KEY = eINSTANCE.getArrowToArrowMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW_TO_ARROW_MAP__VALUE = eINSTANCE.getArrowToArrowMap_Value();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.TypingMorphismImpl <em>Typing Morphism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.TypingMorphismImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getTypingMorphism()
		 * @generated
		 */
		EClass TYPING_MORPHISM = eINSTANCE.getTypingMorphism();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPING_MORPHISM__MODEL = eINSTANCE.getTypingMorphism_Model();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPING_MORPHISM__METAMODEL = eINSTANCE.getTypingMorphism_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPING_MORPHISM__MAPPINGS = eINSTANCE.getTypingMorphism_Mappings();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.GraphHomomorphismImpl <em>Graph Homomorphism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.GraphHomomorphismImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getGraphHomomorphism()
		 * @generated
		 */
		EClass GRAPH_HOMOMORPHISM = eINSTANCE.getGraphHomomorphism();

		/**
		 * The meta object literal for the '<em><b>Node Mapping</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_HOMOMORPHISM__NODE_MAPPING = eINSTANCE.getGraphHomomorphism_NodeMapping();

		/**
		 * The meta object literal for the '<em><b>Arrow Mapping</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_HOMOMORPHISM__ARROW_MAPPING = eINSTANCE.getGraphHomomorphism_ArrowMapping();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.IDObjectImpl <em>ID Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.IDObjectImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getIDObject()
		 * @generated
		 */
		EClass ID_OBJECT = eINSTANCE.getIDObject();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_OBJECT__ID = eINSTANCE.getIDObject_Id();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.SpecificationImpl <em>Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.SpecificationImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getSpecification()
		 * @generated
		 */
		EClass SPECIFICATION = eINSTANCE.getSpecification();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__GRAPH = eINSTANCE.getSpecification_Graph();

		/**
		 * The meta object literal for the '<em><b>Type Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__TYPE_GRAPH = eINSTANCE.getSpecification_TypeGraph();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.ModelHierarchyImpl <em>Model Hierarchy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.ModelHierarchyImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getModelHierarchy()
		 * @generated
		 */
		EClass MODEL_HIERARCHY = eINSTANCE.getModelHierarchy();

		/**
		 * The meta object literal for the '<em><b>Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_HIERARCHY__SPECIFICATIONS = eINSTANCE.getModelHierarchy_Specifications();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.JointlySurjectiveSemanticsImpl <em>Jointly Surjective Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.JointlySurjectiveSemanticsImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getJointlySurjectiveSemantics()
		 * @generated
		 */
		EClass JOINTLY_SURJECTIVE_SEMANTICS = eINSTANCE.getJointlySurjectiveSemantics();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.InverseSemanticsImpl <em>Inverse Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.InverseSemanticsImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getInverseSemantics()
		 * @generated
		 */
		EClass INVERSE_SEMANTICS = eINSTANCE.getInverseSemantics();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.IrreflexiveSemanticsImpl <em>Irreflexive Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.IrreflexiveSemanticsImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getIrreflexiveSemantics()
		 * @generated
		 */
		EClass IRREFLEXIVE_SEMANTICS = eINSTANCE.getIrreflexiveSemantics();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.MultiplicitySemanticsImpl <em>Multiplicity Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.MultiplicitySemanticsImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getMultiplicitySemantics()
		 * @generated
		 */
		EClass MULTIPLICITY_SEMANTICS = eINSTANCE.getMultiplicitySemantics();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.XORSemanticsImpl <em>XOR Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.XORSemanticsImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getXORSemantics()
		 * @generated
		 */
		EClass XOR_SEMANTICS = eINSTANCE.getXORSemantics();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.TransitiveIrreflexiveSemanticsImpl <em>Transitive Irreflexive Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.TransitiveIrreflexiveSemanticsImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getTransitiveIrreflexiveSemantics()
		 * @generated
		 */
		EClass TRANSITIVE_IRREFLEXIVE_SEMANTICS = eINSTANCE.getTransitiveIrreflexiveSemantics();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.SurjectiveSemanticsImpl <em>Surjective Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.SurjectiveSemanticsImpl
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getSurjectiveSemantics()
		 * @generated
		 */
		EClass SURJECTIVE_SEMANTICS = eINSTANCE.getSurjectiveSemantics();

		/**
		 * The meta object literal for the '<em>EURI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getEURI()
		 * @generated
		 */
		EDataType EURI = eINSTANCE.getEURI();

		/**
		 * The meta object literal for the '<em>EIO Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.IOException
		 * @see no.hib.dpf.core.impl.MetamodelPackageImpl#getEIOException()
		 * @generated
		 */
		EDataType EIO_EXCEPTION = eINSTANCE.getEIOException();

	}

} //MetamodelPackage
