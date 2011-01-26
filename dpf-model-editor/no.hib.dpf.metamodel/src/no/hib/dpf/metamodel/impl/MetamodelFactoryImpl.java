/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.Map;
import no.hib.dpf.metamodel.*;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelFactoryImpl extends EFactoryImpl implements MetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetamodelFactory init() {
		try {
			MetamodelFactory theMetamodelFactory = (MetamodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://no.hib.dpf.metamodel"); 
			if (theMetamodelFactory != null) {
				return theMetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MetamodelPackage.GRAPH: return createGraph();
			case MetamodelPackage.NODE: return createNode();
			case MetamodelPackage.ARROW: return createArrow();
			case MetamodelPackage.SIGNATURE: return createSignature();
			case MetamodelPackage.PREDICATE: return createPredicate();
			case MetamodelPackage.SEMANTICS: return createSemantics();
			case MetamodelPackage.NODE_TO_NODE_MAP: return (EObject)createNodeToNodeMap();
			case MetamodelPackage.CONSTRAINT: return createConstraint();
			case MetamodelPackage.ARROW_TO_ARROW_MAP: return (EObject)createArrowToArrowMap();
			case MetamodelPackage.TYPING_MORPHISM: return createTypingMorphism();
			case MetamodelPackage.GRAPH_HOMOMORPHISM: return createGraphHomomorphism();
			case MetamodelPackage.ID_OBJECT: return createIDObject();
			case MetamodelPackage.SPECIFICATION: return createSpecification();
			case MetamodelPackage.MODEL_HIERARCHY: return createModelHierarchy();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Graph createGraph() {
		GraphImpl graph = new GraphImpl();
		graph.setName("Default name");
		return graph;
	}
	
	/**
	 * Returns a new object of class '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This is intended as a quick way of generating Graph instances using string parameters for
	 * nodes and edges. String formats: "gn1,gn2", "ge1:gn1:gn2"
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph</em>'.
	 * @generated NOT
	 */
	public Graph createGraph(String nodes, String edges) {
		return createGraph("Default name", nodes, edges);
	}
	
	/**
	 * Returns a new object of class '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This is intended as a quick way of generating Graph instances using string parameters for
	 * nodes and edges. String formats: "gn1,gn2", "ge1:gn1:gn2"
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph</em>'.
	 * @generated NOT
	 */
	public Graph createGraph(String name, String nodes, String edges) {
		Graph retval = createGraphNodes(nodes.split(","));
		addEdgesToGraph(retval, edges.split(","));		
		retval.setName(name);
		return retval;
	}
	
	/**
	 * @generated NOT
	 */
	private Graph createGraphNodes(String[] nodes) {
		Graph g = MetamodelFactory.eINSTANCE.createGraph();
		if (!((nodes.length == 1) && (nodes[0].equals("")))) {
			for (String node_name : nodes) {
				g.createNode(node_name.trim());
			}
		}
		return g;
	}
	
	/**
	 * @generated NOT
	 */
	private void addEdgesToGraph(Graph g, String[] edges) {
		if (!((edges.length == 1) && (edges[0].equals("")))) {
			for (String edgeDetails : edges) {
				String[] edgeDetailsSplit = edgeDetails.split(":");
				g.createArrow(edgeDetailsSplit[0].trim(), g.getNodeByName(edgeDetailsSplit[1].trim()), g.getNodeByName(edgeDetailsSplit[2].trim()));
			}
		}
	}	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arrow createArrow() {
		ArrowImpl arrow = new ArrowImpl();
		return arrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Node createNode(Node typeNode) {
		Node retval = createNode();
		retval.setTypeNode(typeNode);
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow createArrow(Arrow typeArrow) {
		Arrow retval = createArrow();
		retval.setTypeArrow(typeArrow);
		return retval;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature createSignature() {
		SignatureImpl signature = new SignatureImpl();
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate createPredicate() {
		PredicateImpl predicate = new PredicateImpl();
		return predicate;
	}
	
	/**
	 * Returns a new object of class '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate</em>'.
	 * @generated NOT
	 */
	public Predicate createPredicate(String nodes, String edges) {
		Predicate predicate = createPredicate();
		predicate.setShape(createGraph(nodes, edges));
		return predicate;		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Semantics createSemantics() {
		SemanticsImpl semantics = new SemanticsImpl();
		return semantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Node, Node> createNodeToNodeMap() {
		NodeToNodeMapImpl nodeToNodeMap = new NodeToNodeMapImpl();
		return nodeToNodeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Arrow, Arrow> createArrowToArrowMap() {
		ArrowToArrowMapImpl arrowToArrowMap = new ArrowToArrowMapImpl();
		return arrowToArrowMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypingMorphism createTypingMorphism() {
		TypingMorphismImpl typingMorphism = new TypingMorphismImpl();
		return typingMorphism;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphHomomorphism createGraphHomomorphism() {
		GraphHomomorphismImpl graphHomomorphism = new GraphHomomorphismImpl();
		return graphHomomorphism;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public GraphHomomorphism createGraphHomomorphism(EMap<Node, Node> nodeMap, EMap<Arrow, Arrow> arrowMap) {
		GraphHomomorphism retval = createGraphHomomorphism();
		retval.getNodeMapping().addAll(nodeMap);
		retval.getArrowMapping().addAll(arrowMap);
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDObject createIDObject() {
		IDObjectImpl idObject = new IDObjectImpl();
		return idObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification createSpecification() {
		SpecificationImpl specification = new SpecificationImpl();
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelHierarchy createModelHierarchy() {
		ModelHierarchyImpl modelHierarchy = new ModelHierarchyImpl();
		return modelHierarchy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelPackage getMetamodelPackage() {
		return (MetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetamodelPackage getPackage() {
		return MetamodelPackage.eINSTANCE;
	}


} //MetamodelFactoryImpl
