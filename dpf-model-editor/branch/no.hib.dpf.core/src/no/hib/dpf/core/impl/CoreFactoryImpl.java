/**
 * <copyright>
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, �yvind Bech and Dag Viggo Lok�en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import java.io.IOException;
import java.util.Map;

import no.hib.dpf.constant.DPFConstants;
import no.hib.dpf.core.*;

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
public class CoreFactoryImpl extends EFactoryImpl implements CoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoreFactory init() {
		try {
			CoreFactory theCoreFactory = (CoreFactory)EPackage.Registry.INSTANCE.getEFactory("http://no.hib.dpf.core"); 
			if (theCoreFactory != null) {
				return theCoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactoryImpl() {
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
			case CorePackage.GRAPH: return createGraph();
			case CorePackage.NODE: return createNode();
			case CorePackage.ARROW: return createArrow();
			case CorePackage.SIGNATURE: return createSignature();
			case CorePackage.PREDICATE: return createPredicate();
			case CorePackage.SEMANTICS_VALIDATOR: return createSemanticsValidator();
			case CorePackage.VISUALIZATION: return createVisualization();
			case CorePackage.NODE_TO_NODE_MAP: return (EObject)createNodeToNodeMap();
			case CorePackage.CONSTRAINT: return createConstraint();
			case CorePackage.ARROW_TO_ARROW_MAP: return (EObject)createArrowToArrowMap();
			case CorePackage.TYPING_MORPHISM: return createTypingMorphism();
			case CorePackage.GRAPH_HOMOMORPHISM: return createGraphHomomorphism();
			case CorePackage.ID_OBJECT: return createIDObject();
			case CorePackage.SPECIFICATION: return createSpecification();
			case CorePackage.MODEL_HIERARCHY: return createModelHierarchy();
			case CorePackage.JOINTLY_SURJECTIVE_SEMANTICS: return createJointlySurjectiveSemantics();
			case CorePackage.INVERSE_SEMANTICS: return createInverseSemantics();
			case CorePackage.IRREFLEXIVE_SEMANTICS: return createIrreflexiveSemantics();
			case CorePackage.MULTIPLICITY_SEMANTICS: return createMultiplicitySemantics();
			case CorePackage.XOR_SEMANTICS: return createXORSemantics();
			case CorePackage.TRANSITIVE_IRREFLEXIVE_SEMANTICS: return createTransitiveIrreflexiveSemantics();
			case CorePackage.SURJECTIVE_SEMANTICS: return createSurjectiveSemantics();
			case CorePackage.NAND_SEMANTICS: return createNANDSemantics();
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
			case CorePackage.VALIDATOR_TYPE:
				return createValidatorTypeFromString(eDataType, initialValue);
			case CorePackage.VISUALIZATION_TYPE:
				return createVisualizationTypeFromString(eDataType, initialValue);
			case CorePackage.EURI:
				return createEURIFromString(eDataType, initialValue);
			case CorePackage.EIO_EXCEPTION:
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
			case CorePackage.VALIDATOR_TYPE:
				return convertValidatorTypeToString(eDataType, instanceValue);
			case CorePackage.VISUALIZATION_TYPE:
				return convertVisualizationTypeToString(eDataType, instanceValue);
			case CorePackage.EURI:
				return convertEURIToString(eDataType, instanceValue);
			case CorePackage.EIO_EXCEPTION:
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
		Graph g = CoreFactory.eINSTANCE.createGraph();
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
	 * @generated NOT
	 */
	public Predicate createPredicate() {
		PredicateImpl predicate = new PredicateImpl();
		predicate.setShape(createGraph());
		predicate.setSemanticsValidator(createSemanticsValidator());
		predicate.setVisualization(createVisualization());
		return predicate;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SemanticsValidator createSemanticsValidator() {
		SemanticsValidatorImpl semanticsValidator = new SemanticsValidatorImpl();
		semanticsValidator.setType(ValidatorType.JAVA);
		semanticsValidator.setValidator("");
		return semanticsValidator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Visualization createVisualization() {
		VisualizationImpl visualization = new VisualizationImpl();
		visualization.setType(VisualizationType.ARROW_LABEL);
		return visualization;
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
		Resource graph = resourceSet.createResource(DPFConstants.DefaultGraph);
		graph.getContents().add(DPFConstants.REFLEXIVE_TYPE_GRAPH);
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
	public InverseSemantics createInverseSemantics() {
		InverseSemanticsImpl inverseSemantics = new InverseSemanticsImpl();
		return inverseSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IrreflexiveSemantics createIrreflexiveSemantics() {
		IrreflexiveSemanticsImpl irreflexiveSemantics = new IrreflexiveSemanticsImpl();
		return irreflexiveSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicitySemantics createMultiplicitySemantics() {
		MultiplicitySemanticsImpl multiplicitySemantics = new MultiplicitySemanticsImpl();
		return multiplicitySemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XORSemantics createXORSemantics() {
		XORSemanticsImpl xorSemantics = new XORSemanticsImpl();
		return xorSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitiveIrreflexiveSemantics createTransitiveIrreflexiveSemantics() {
		TransitiveIrreflexiveSemanticsImpl transitiveIrreflexiveSemantics = new TransitiveIrreflexiveSemanticsImpl();
		return transitiveIrreflexiveSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SurjectiveSemantics createSurjectiveSemantics() {
		SurjectiveSemanticsImpl surjectiveSemantics = new SurjectiveSemanticsImpl();
		return surjectiveSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NANDSemantics createNANDSemantics() {
		NANDSemanticsImpl nandSemantics = new NANDSemanticsImpl();
		return nandSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidatorType createValidatorTypeFromString(EDataType eDataType, String initialValue) {
		ValidatorType result = ValidatorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValidatorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationType createVisualizationTypeFromString(EDataType eDataType, String initialValue) {
		VisualizationType result = VisualizationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisualizationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public CorePackage getCorePackage() {
		return (CorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CorePackage getPackage() {
		return CorePackage.eINSTANCE;
	}


} //MetamodelFactoryImpl