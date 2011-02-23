/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.io.IOException;
import java.util.Map;
import no.hib.dpf.metamodel.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

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
			case MetamodelPackage.NODE_TO_NODE_MAP: return (EObject)createNodeToNodeMap();
			case MetamodelPackage.CONSTRAINT: return createConstraint();
			case MetamodelPackage.ARROW_TO_ARROW_MAP: return (EObject)createArrowToArrowMap();
			case MetamodelPackage.TYPING_MORPHISM: return createTypingMorphism();
			case MetamodelPackage.GRAPH_HOMOMORPHISM: return createGraphHomomorphism();
			case MetamodelPackage.ID_OBJECT: return createIDObject();
			case MetamodelPackage.SPECIFICATION: return createSpecification();
			case MetamodelPackage.MODEL_HIERARCHY: return createModelHierarchy();
			case MetamodelPackage.JOINTLY_SURJECTIVE_SEMANTICS: return createJointlySurjectiveSemantics();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MetamodelPackage.EURI:
				return createEURIFromString(eDataType, initialValue);
			case MetamodelPackage.EIO_EXCEPTION:
				return createEIOExceptionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MetamodelPackage.EURI:
				return convertEURIToString(eDataType, instanceValue);
			case MetamodelPackage.EIO_EXCEPTION:
				return convertEIOExceptionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	 * nodes and arrows. String formats: "gn1,gn2", "ge1:gn1:gn2"
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph</em>'.
	 * @generated NOT
	 */
	public Graph createGraph(String nodes, String arrows) {
		return createGraph("Default name", nodes, arrows);
	}
	
	/**
	 * Returns a new object of class '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This is intended as a quick way of generating Graph instances using string parameters for
	 * nodes and arrows. String formats: "gn1,gn2", "ge1:gn1:gn2"
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph</em>'.
	 * @generated NOT
	 */
	public Graph createGraph(String name, String nodes, String arrows) {
		Graph retval = createGraphNodes(nodes.split(","));
		addArrowsToGraph(retval, arrows.split(","));		
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
	private void addArrowsToGraph(Graph g, String[] arrows) {
		if (!((arrows.length == 1) && (arrows[0].equals("")))) {
			for (String arrowDetails : arrows) {
				String[] arrowDetailsSplit = arrowDetails.split(":");
				g.createArrow(arrowDetailsSplit[0].trim(), g.getNodeByName(arrowDetailsSplit[1].trim()), g.getNodeByName(arrowDetailsSplit[2].trim()));
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
	public Predicate createPredicate(String nodes, String arrows) {
		Predicate predicate = createPredicate();
		predicate.setShape(createGraph(nodes, arrows));
		return predicate;		
	}
	
	/**
	 * Returns a new object of class '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate</em>'.
	 * @generated NOT
	 */
	public Predicate createPredicate(String symbol, String nodes, String arrows) {
		Predicate predicate = createPredicate(nodes, arrows);
		predicate.setSymbol(symbol);
		return predicate;		
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
	
	@Override
	/**
	 * @generated NOT
	 */
	public Specification loadSpecification(URI uri) throws IOException {
		return (Specification)createLoadResource(uri).getContents().get(0);
	}

	@Override
	/**
	 * @generated NOT
	 */
	public Signature loadSignature(URI uri) throws IOException {
		return (Signature)createLoadResource(uri).getContents().get(0);
	}

	private Resource createLoadResource(URI uri) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMLResourceFactoryImpl());

		resourceSet.getLoadOptions().put(XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true);
			
		Resource resource = resourceSet.createResource(uri);
		resource.load(null);
		return resource;
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
	public JointlySurjectiveSemantics createJointlySurjectiveSemantics() {
		JointlySurjectiveSemanticsImpl jointlySurjectiveSemantics = new JointlySurjectiveSemanticsImpl();
		return jointlySurjectiveSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createEURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOException createEIOExceptionFromString(EDataType eDataType, String initialValue) {
		return (IOException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEIOExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
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
