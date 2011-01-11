/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see no.hib.dpf.metamodel.MetamodelFactory
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
	String eNS_URI = "http://no.hib.dpf.metamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "no.hib.dpf.metamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelPackage eINSTANCE = no.hib.dpf.metamodel.impl.MetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.GraphImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.NodeImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.EdgeImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.SignatureImpl <em>Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.SignatureImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getSignature()
	 * @generated
	 */
	int SIGNATURE = 3;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.PredicateImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.SemanticsImpl <em>Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.SemanticsImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getSemantics()
	 * @generated
	 */
	int SEMANTICS = 5;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.VisualizationImpl <em>Visualization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.VisualizationImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getVisualization()
	 * @generated
	 */
	int VISUALIZATION = 6;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.NodeToNodeMapImpl <em>Node To Node Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.NodeToNodeMapImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getNodeToNodeMap()
	 * @generated
	 */
	int NODE_TO_NODE_MAP = 7;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.ConstraintImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 8;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.EdgeToEdgeMapImpl <em>Edge To Edge Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.EdgeToEdgeMapImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getEdgeToEdgeMap()
	 * @generated
	 */
	int EDGE_TO_EDGE_MAP = 9;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.TypingMorphismImpl <em>Typing Morphism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.TypingMorphismImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getTypingMorphism()
	 * @generated
	 */
	int TYPING_MORPHISM = 10;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl <em>Graph Homomorphism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.GraphHomomorphismImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getGraphHomomorphism()
	 * @generated
	 */
	int GRAPH_HOMOMORPHISM = 11;

	/**
	 * The meta object id for the '{@link no.hib.dpf.metamodel.impl.IDObjectImpl <em>ID Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.metamodel.impl.IDObjectImpl
	 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getIDObject()
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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__EDGES = ID_OBJECT_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__GRAPH = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TYPE_EDGE = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 5;

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
	 * The feature id for the '<em><b>Shape</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__SHAPE = 0;

	/**
	 * The feature id for the '<em><b>Semantics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__SEMANTICS = 1;

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
	 * The number of structural features of the '<em>Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTICS_FEATURE_COUNT = 0;

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
	 * The feature id for the '<em><b>Mappings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__MAPPINGS = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TO_EDGE_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TO_EDGE_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Edge To Edge Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_TO_EDGE_MAP_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Edge Mapping</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_HOMOMORPHISM__EDGE_MAPPING = 1;

	/**
	 * The number of structural features of the '<em>Graph Homomorphism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_HOMOMORPHISM_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see no.hib.dpf.metamodel.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.metamodel.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see no.hib.dpf.metamodel.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.metamodel.Graph#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.metamodel.Graph#getName()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.metamodel.Graph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see no.hib.dpf.metamodel.Graph#getEdges()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Edges();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.metamodel.Graph#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see no.hib.dpf.metamodel.Graph#getConstraints()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Constraints();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see no.hib.dpf.metamodel.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.metamodel.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.metamodel.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the container reference '{@link no.hib.dpf.metamodel.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see no.hib.dpf.metamodel.Node#getGraph()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Graph();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.Node#getTypeNode <em>Type Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Node</em>'.
	 * @see no.hib.dpf.metamodel.Node#getTypeNode()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_TypeNode();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see no.hib.dpf.metamodel.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see no.hib.dpf.metamodel.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.metamodel.Edge#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.metamodel.Edge#getName()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Name();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.Edge#getTypeEdge <em>Type Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Edge</em>'.
	 * @see no.hib.dpf.metamodel.Edge#getTypeEdge()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_TypeEdge();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see no.hib.dpf.metamodel.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the container reference '{@link no.hib.dpf.metamodel.Edge#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see no.hib.dpf.metamodel.Edge#getGraph()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Graph();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.Signature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signature</em>'.
	 * @see no.hib.dpf.metamodel.Signature
	 * @generated
	 */
	EClass getSignature();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.metamodel.Signature#getPredicates <em>Predicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predicates</em>'.
	 * @see no.hib.dpf.metamodel.Signature#getPredicates()
	 * @see #getSignature()
	 * @generated
	 */
	EReference getSignature_Predicates();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see no.hib.dpf.metamodel.Predicate
	 * @generated
	 */
	EClass getPredicate();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.Predicate#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shape</em>'.
	 * @see no.hib.dpf.metamodel.Predicate#getShape()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Shape();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.metamodel.Predicate#getSemantics <em>Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Semantics</em>'.
	 * @see no.hib.dpf.metamodel.Predicate#getSemantics()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Semantics();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.Predicate#getVisualization <em>Visualization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Visualization</em>'.
	 * @see no.hib.dpf.metamodel.Predicate#getVisualization()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Visualization();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.metamodel.Predicate#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see no.hib.dpf.metamodel.Predicate#getSymbol()
	 * @see #getPredicate()
	 * @generated
	 */
	EAttribute getPredicate_Symbol();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.Semantics <em>Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantics</em>'.
	 * @see no.hib.dpf.metamodel.Semantics
	 * @generated
	 */
	EClass getSemantics();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.Visualization <em>Visualization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visualization</em>'.
	 * @see no.hib.dpf.metamodel.Visualization
	 * @generated
	 */
	EClass getVisualization();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Node To Node Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node To Node Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="no.hib.dpf.metamodel.Node"
	 *        valueType="no.hib.dpf.metamodel.Node"
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
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see no.hib.dpf.metamodel.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the container reference '{@link no.hib.dpf.metamodel.Constraint#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Graph</em>'.
	 * @see no.hib.dpf.metamodel.Constraint#getGraph()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Graph();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.Constraint#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see no.hib.dpf.metamodel.Constraint#getPredicate()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Predicate();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.Constraint#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mappings</em>'.
	 * @see no.hib.dpf.metamodel.Constraint#getMappings()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Mappings();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Edge To Edge Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge To Edge Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="no.hib.dpf.metamodel.Edge"
	 *        valueType="no.hib.dpf.metamodel.Edge"
	 * @generated
	 */
	EClass getEdgeToEdgeMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEdgeToEdgeMap()
	 * @generated
	 */
	EReference getEdgeToEdgeMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEdgeToEdgeMap()
	 * @generated
	 */
	EReference getEdgeToEdgeMap_Value();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.TypingMorphism <em>Typing Morphism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typing Morphism</em>'.
	 * @see no.hib.dpf.metamodel.TypingMorphism
	 * @generated
	 */
	EClass getTypingMorphism();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.TypingMorphism#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see no.hib.dpf.metamodel.TypingMorphism#getModel()
	 * @see #getTypingMorphism()
	 * @generated
	 */
	EReference getTypingMorphism_Model();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.TypingMorphism#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metamodel</em>'.
	 * @see no.hib.dpf.metamodel.TypingMorphism#getMetamodel()
	 * @see #getTypingMorphism()
	 * @generated
	 */
	EReference getTypingMorphism_Metamodel();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.metamodel.TypingMorphism#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mappings</em>'.
	 * @see no.hib.dpf.metamodel.TypingMorphism#getMappings()
	 * @see #getTypingMorphism()
	 * @generated
	 */
	EReference getTypingMorphism_Mappings();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.GraphHomomorphism <em>Graph Homomorphism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Homomorphism</em>'.
	 * @see no.hib.dpf.metamodel.GraphHomomorphism
	 * @generated
	 */
	EClass getGraphHomomorphism();

	/**
	 * Returns the meta object for the map '{@link no.hib.dpf.metamodel.GraphHomomorphism#getNodeMapping <em>Node Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Node Mapping</em>'.
	 * @see no.hib.dpf.metamodel.GraphHomomorphism#getNodeMapping()
	 * @see #getGraphHomomorphism()
	 * @generated
	 */
	EReference getGraphHomomorphism_NodeMapping();

	/**
	 * Returns the meta object for the map '{@link no.hib.dpf.metamodel.GraphHomomorphism#getEdgeMapping <em>Edge Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Edge Mapping</em>'.
	 * @see no.hib.dpf.metamodel.GraphHomomorphism#getEdgeMapping()
	 * @see #getGraphHomomorphism()
	 * @generated
	 */
	EReference getGraphHomomorphism_EdgeMapping();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.metamodel.IDObject <em>ID Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ID Object</em>'.
	 * @see no.hib.dpf.metamodel.IDObject
	 * @generated
	 */
	EClass getIDObject();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.metamodel.IDObject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see no.hib.dpf.metamodel.IDObject#getId()
	 * @see #getIDObject()
	 * @generated
	 */
	EAttribute getIDObject_Id();

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
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.GraphImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getGraph()
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
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__CONSTRAINTS = eINSTANCE.getGraph_Constraints();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.NodeImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getNode()
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
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.EdgeImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__NAME = eINSTANCE.getEdge_Name();

		/**
		 * The meta object literal for the '<em><b>Type Edge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TYPE_EDGE = eINSTANCE.getEdge_TypeEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__GRAPH = eINSTANCE.getEdge_Graph();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.SignatureImpl <em>Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.SignatureImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getSignature()
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
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.PredicateImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__SHAPE = eINSTANCE.getPredicate_Shape();

		/**
		 * The meta object literal for the '<em><b>Semantics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__SEMANTICS = eINSTANCE.getPredicate_Semantics();

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
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.SemanticsImpl <em>Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.SemanticsImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getSemantics()
		 * @generated
		 */
		EClass SEMANTICS = eINSTANCE.getSemantics();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.VisualizationImpl <em>Visualization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.VisualizationImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getVisualization()
		 * @generated
		 */
		EClass VISUALIZATION = eINSTANCE.getVisualization();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.NodeToNodeMapImpl <em>Node To Node Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.NodeToNodeMapImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getNodeToNodeMap()
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
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.ConstraintImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getConstraint()
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
		 * The meta object literal for the '<em><b>Mappings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__MAPPINGS = eINSTANCE.getConstraint_Mappings();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.EdgeToEdgeMapImpl <em>Edge To Edge Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.EdgeToEdgeMapImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getEdgeToEdgeMap()
		 * @generated
		 */
		EClass EDGE_TO_EDGE_MAP = eINSTANCE.getEdgeToEdgeMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TO_EDGE_MAP__KEY = eINSTANCE.getEdgeToEdgeMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_TO_EDGE_MAP__VALUE = eINSTANCE.getEdgeToEdgeMap_Value();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.TypingMorphismImpl <em>Typing Morphism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.TypingMorphismImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getTypingMorphism()
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
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl <em>Graph Homomorphism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.GraphHomomorphismImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getGraphHomomorphism()
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
		 * The meta object literal for the '<em><b>Edge Mapping</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH_HOMOMORPHISM__EDGE_MAPPING = eINSTANCE.getGraphHomomorphism_EdgeMapping();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.metamodel.impl.IDObjectImpl <em>ID Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.metamodel.impl.IDObjectImpl
		 * @see no.hib.dpf.metamodel.impl.MetamodelPackageImpl#getIDObject()
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

	}

} //MetamodelPackage
