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

import java.util.Map;

import no.hib.dpf.core.*;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticValidator;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.core.ValidatorType;
import no.hib.dpf.utils.DPFCoreConstants;
import no.hib.dpf.utils.internal.signature.InjectivePredicate;
import no.hib.dpf.utils.internal.signature.InversePredicate;
import no.hib.dpf.utils.internal.signature.IrreflexivePredicate;
import no.hib.dpf.utils.internal.signature.JointlyInjectivePredicate;
import no.hib.dpf.utils.internal.signature.JointlySurjectiveValidator;
import no.hib.dpf.utils.internal.signature.MultiplicityPredicate;
import no.hib.dpf.utils.internal.signature.NANDPredicate;
import no.hib.dpf.utils.internal.signature.SurjectivePredicate;
import no.hib.dpf.utils.internal.signature.XORPredicate;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;

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
			CoreFactory theCoreFactory = (CoreFactory)EPackage.Registry.INSTANCE.getEFactory(CorePackage.eNS_URI);
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
			case CorePackage.SPECIFICATION: return createSpecification();
			case CorePackage.GRAPH: return createGraph();
			case CorePackage.NODE: return createNode();
			case CorePackage.ARROW: return createArrow();
			case CorePackage.SIGNATURE: return createSignature();
			case CorePackage.PREDICATE: return createPredicate();
			case CorePackage.SEMANTIC_VALIDATOR: return createSemanticValidator();
			case CorePackage.CONSTRAINT: return createConstraint();
			case CorePackage.GRAPH_HOMOMORPHISM: return createGraphHomomorphism();
			case CorePackage.NODE_TO_NODE_MAP: return (EObject)createNodeToNodeMap();
			case CorePackage.ARROW_TO_ARROW_MAP: return (EObject)createArrowToArrowMap();
			case CorePackage.DATA_NODE: return createDataNode();
			case CorePackage.NODE_ATTRIBUTE: return createNodeAttribute();
			case CorePackage.ARROW_ATTRIBUTE: return createArrowAttribute();
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
			case CorePackage.ERESOURCE_SET:
				return createEResourceSetFromString(eDataType, initialValue);
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
			case CorePackage.ERESOURCE_SET:
				return convertEResourceSetToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	@Override
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
	@Override
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
		Graph g = CoreFactory.eINSTANCE.createDefaultGraph();
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
	 * Default Value For Graph
	 * name : null
	 * Id : null
	 * type : null which will be set when DGraph's type is set
	 * @generated NOT
	 */
	@Override
	public Graph createDefaultGraph() {
		Graph graph = new GraphImpl();
		graph.setType(DPFCoreConstants.REFLEXIVE_TYPE_GRAPH);
		return graph;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * Default Value For Node
	 * name : null
	 * Id : null
	 * graph : null
	 * type : null which will be set when DNode's type is set
	 * @generated NOT
	 */
	@Override
	public Node createDefaultNode() {
		NodeImpl node = new NodeImpl();
		node.setTypeNode(DPFCoreConstants.REFLEXIVE_TYPE_NODE);
		return node;
	}
	
	@Override 
	public DataNode createDefaultDataNode() {
		DataNodeImpl datanode = new DataNodeImpl();
		datanode.setTypeDataNode(DPFCoreConstants.REFLEXIVE_TYPE_DATANODE);
		return datanode;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * Default Value For Arrow
	 * name : null
	 * Id : null
	 * graph : null
	 * type : null, which will be set when DArrow's type is set
	 * @generated NOT
	 */
	@Override
	public Arrow createDefaultArrow() {
		ArrowImpl arrow = new ArrowImpl();
		arrow.setTypeArrow(DPFCoreConstants.REFLEXIVE_TYPE_ARROW);
		return arrow;
	}
	
	@Override
	public ArrowAttribute createDefaultArrowAttribute() {
		ArrowAttributeImpl attribute = new ArrowAttributeImpl();
		attribute.setTypeAttribute(DPFCoreConstants.REFLEXIVE_TYPE_ARROW_ATTRIBUTE);
		return attribute;
	}
	
	@Override
	public NodeAttribute createDefaultNodeAttribute() {
		NodeAttributeImpl attribute = new NodeAttributeImpl();
		attribute.setTypeAttribute(DPFCoreConstants.REFLEXIVE_TYPE_NODE_ATTRIBUTE);
		return attribute;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Predicate createDefaultPredicate() {
		PredicateImpl predicate = new PredicateImpl();
		predicate.setShape(createDefaultGraph());
		predicate.setValidator(createDefaultSemanticValidator());
		return predicate;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Specification createDefaultSpecification() {
		Specification specification = new SpecificationImpl();
		specification.setGraph(createDefaultGraph());
		specification.setType(DPFCoreConstants.REFLEXIVE_SPECIFICATION);
		return specification;
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Node createNode(Node typeNode) {
		return createNode(null, typeNode);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Node createNode(String name, Node typeNode) {
		Node retval = createNode();
		retval.setName(name);
		retval.setTypeNode(typeNode);
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Arrow createArrow(Node source, Node target, Arrow typeArrow) {
		return createArrow(null, source, target, typeArrow);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Arrow createArrow(String name, Node source, Node target, Arrow typeArrow) {
		Arrow retval = createArrow();
		retval.setName(name);
		retval.setSource(source);
		retval.setTarget(target);
		retval.setTypeArrow(typeArrow);
		return retval;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Signature createSignature() {
		SignatureImpl signature = new SignatureImpl();
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Predicate createPredicate() {
		PredicateImpl predicate = new PredicateImpl();
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SemanticValidator createSemanticValidator() {
		SemanticValidatorImpl semanticValidator = new SemanticValidatorImpl();
		return semanticValidator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public SemanticValidator createDefaultSemanticValidator() {
		SemanticValidator result = new SemanticValidatorImpl();
		result.setType(ValidatorType.JAVA);
		result.setValidator(DPFCoreConstants.DefaultChecker);
		return result;
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
	@Override
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
	 * @generated not
	 */
	@Override
	public DataNode createDataNode() {
		DataNodeImpl dataNode = new DataNodeImpl();
		dataNode.setTypeDataNode(DPFCoreConstants.REFLEXIVE_TYPE_DATANODE);
		return dataNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public NodeAttribute createNodeAttribute() {
		NodeAttributeImpl nodeAttribute = new NodeAttributeImpl();
		nodeAttribute.setTypeAttribute(DPFCoreConstants.REFLEXIVE_TYPE_NODE_ATTRIBUTE);
		return nodeAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public ArrowAttribute createArrowAttribute() {
		ArrowAttributeImpl arrowAttribute = new ArrowAttributeImpl();
		arrowAttribute.setTypeAttribute(DPFCoreConstants.REFLEXIVE_TYPE_ARROW_ATTRIBUTE);
		return arrowAttribute;
	} 

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	 * Default Value For Specification
	 * Graph : null which will be set when DSpecification's DGraph is set //Graph.REFLEXIVE_TYPE_GRAPH
	 * @generated NOT
	 */
	@Override
	public Specification createSpecification() {
		SpecificationImpl specification = new SpecificationImpl();
		specification.setType(DPFCoreConstants.REFLEXIVE_SPECIFICATION);
		return specification;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Graph createGraph() {
		GraphImpl graph = new GraphImpl();
		graph.setType(DPFCoreConstants.REFLEXIVE_TYPE_GRAPH);
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		node.setTypeNode(DPFCoreConstants.REFLEXIVE_TYPE_NODE);
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Arrow createArrow() {
		ArrowImpl arrow = new ArrowImpl();
		arrow.setTypeArrow(DPFCoreConstants.REFLEXIVE_TYPE_ARROW);
		return arrow;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceSet createEResourceSetFromString(EDataType eDataType, String initialValue) {
		return (ResourceSet)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEResourceSetToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Predicate createPredicate(String name, String string, String string2) {
		Predicate predicate = createPredicate();
		if(name == null || name.isEmpty())
			predicate.setSymbol("Default Name");
		else
			predicate.setSymbol(name);
		predicate.setShape(createGraph(string, string2));
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Graph createConstantGraph() {
		Graph graph = new GraphImpl();
		graph.addArrow(DPFCoreConstants.REFLEXIVE_TYPE_ARROW);
		graph.addNode(DPFCoreConstants.REFLEXIVE_TYPE_NODE);
		graph.addDataNode(DPFCoreConstants.REFLEXIVE_TYPE_DATANODE);
		graph.addNodeAttribute(DPFCoreConstants.REFLEXIVE_TYPE_NODE_ATTRIBUTE);
		graph.addArrowAttribute(DPFCoreConstants.REFLEXIVE_TYPE_ARROW_ATTRIBUTE);
		return graph;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Specification createConstantSpecification() {
		Specification result = new SpecificationImpl();
		result.setGraph(DPFCoreConstants.REFLEXIVE_TYPE_GRAPH);
		return result;
	}

	@Override
	public Signature createConstantSignature() {
		Signature result = new SignatureImpl();
		result.getPredicates().add(new InjectivePredicate());
		result.getPredicates().add(new SurjectivePredicate());
		result.getPredicates().add(new IrreflexivePredicate());
		result.getPredicates().add(new MultiplicityPredicate());
		result.getPredicates().add(new InversePredicate());
		result.getPredicates().add(new JointlySurjectiveValidator());
		result.getPredicates().add(new JointlyInjectivePredicate());
		result.getPredicates().add(new XORPredicate());
		result.getPredicates().add(new NANDPredicate());
		return result;
	}

	@Override
	public Node createConstantNode() {
		Node node = new NodeImpl();
		node.setName(DPFCoreConstants.NODE);
		return node;
	}
	
	@Override
	public DataNode createConstantDataNode() {
		DataNode result = new DataNodeImpl();
		return result;
	}
	
	@Override
	public Arrow createConstantArrow() {
		Arrow result = new ArrowImpl();
		result.setName(DPFCoreConstants.ARROW);
		result.setSource(DPFCoreConstants.REFLEXIVE_TYPE_NODE);
		result.setTarget(DPFCoreConstants.REFLEXIVE_TYPE_NODE);
		return result;
	}

	@Override
	public Signature createDefaultSignature() {
		return new SignatureImpl();
	}



	@Override
	public NodeAttribute createConstantNodeAttribute() {
		NodeAttribute result = new NodeAttributeImpl(); 
		result.setName(DPFCoreConstants.NODE_ATTRIBUTE);
		result.setSource(DPFCoreConstants.REFLEXIVE_TYPE_NODE); 
		result.setTarget(DPFCoreConstants.REFLEXIVE_TYPE_DATANODE);
		return result;
	}
	
	@Override
	public ArrowAttribute createConstantArrowAttribute() {
		ArrowAttribute result = new ArrowAttributeImpl(); 
		result.setName(DPFCoreConstants.ARROW_ATTRIBUTE);
		result.setTarget(DPFCoreConstants.REFLEXIVE_TYPE_DATANODE);
		result.setSource(DPFCoreConstants.REFLEXIVE_TYPE_ARROW); 
		return result;
	}

	
} //MetamodelFactoryImpl
