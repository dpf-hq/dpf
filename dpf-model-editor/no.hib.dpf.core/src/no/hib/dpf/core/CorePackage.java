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
package no.hib.dpf.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see no.hib.dpf.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

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
	CorePackage eINSTANCE = no.hib.dpf.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.IDObjectImpl <em>ID Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.IDObjectImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getIDObject()
	 * @generated
	 */
	int ID_OBJECT = 11;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.GraphImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.NodeImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.ArrowImpl <em>Arrow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.ArrowImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getArrow()
	 * @generated
	 */
	int ARROW = 3;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.SignatureImpl <em>Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.SignatureImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getSignature()
	 * @generated
	 */
	int SIGNATURE = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.PredicateImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 5;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.NodeToNodeMapImpl <em>Node To Node Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.NodeToNodeMapImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getNodeToNodeMap()
	 * @generated
	 */
	int NODE_TO_NODE_MAP = 9;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.ConstraintImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 7;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.ArrowToArrowMapImpl <em>Arrow To Arrow Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.ArrowToArrowMapImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getArrowToArrowMap()
	 * @generated
	 */
	int ARROW_TO_ARROW_MAP = 10;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.GraphHomomorphismImpl <em>Graph Homomorphism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.GraphHomomorphismImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getGraphHomomorphism()
	 * @generated
	 */
	int GRAPH_HOMOMORPHISM = 8;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.SpecificationImpl <em>Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.SpecificationImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getSpecification()
	 * @generated
	 */
	int SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__CONSTRAINTS = 1;

	/**
	 * The feature id for the '<em><b>Meta File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__META_FILE = 2;

	/**
	 * The feature id for the '<em><b>Signature File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__SIGNATURE_FILE = 3;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__SIGNATURE = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__TYPE = 5;

	/**
	 * The number of structural features of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_FEATURE_COUNT = 6;

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
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__TYPE = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arrows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__ARROWS = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOINGS = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMINGS = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONSTRAINTS = ID_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__NAME = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__SOURCE = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__TARGET = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__GRAPH = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type Arrow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__TYPE_ARROW = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW__CONSTRAINTS = ID_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Arrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Predicates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__PREDICATES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__SYMBOL = 0;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__SHAPE = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__PARAMETERS = 2;

	/**
	 * The feature id for the '<em><b>Validator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__VALIDATOR = 3;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.core.impl.SemanticValidatorImpl <em>Semantic Validator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.impl.SemanticValidatorImpl
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getSemanticValidator()
	 * @generated
	 */
	int SEMANTIC_VALIDATOR = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_VALIDATOR__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Validator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_VALIDATOR__VALIDATOR = 1;

	/**
	 * The number of structural features of the '<em>Semantic Validator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_VALIDATOR_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NODES = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ARROWS = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__PREDICATE = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__MAPPINGS = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__PARAMETERS = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 5;

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
	 * The meta object id for the '{@link no.hib.dpf.core.ValidatorType <em>Validator Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.core.ValidatorType
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getValidatorType()
	 * @generated
	 */
	int VALIDATOR_TYPE = 12;

	/**
	 * The meta object id for the '<em>EResource Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.resource.ResourceSet
	 * @see no.hib.dpf.core.impl.CorePackageImpl#getEResourceSet()
	 * @generated
	 */
	int ERESOURCE_SET = 13;


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
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Graph#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see no.hib.dpf.core.Graph#getType()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Type();

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
	 * Returns the meta object for the reference list '{@link no.hib.dpf.core.Node#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see no.hib.dpf.core.Node#getOutgoings()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Outgoings();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.core.Node#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see no.hib.dpf.core.Node#getIncomings()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Incomings();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.core.Node#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see no.hib.dpf.core.Node#getConstraints()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Constraints();

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
	 * Returns the meta object for the reference list '{@link no.hib.dpf.core.Arrow#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see no.hib.dpf.core.Arrow#getConstraints()
	 * @see #getArrow()
	 * @generated
	 */
	EReference getArrow_Constraints();

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
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Signature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.core.Signature#getName()
	 * @see #getSignature()
	 * @generated
	 */
	EAttribute getSignature_Name();

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
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Predicate#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameters</em>'.
	 * @see no.hib.dpf.core.Predicate#getParameters()
	 * @see #getPredicate()
	 * @generated
	 */
	EAttribute getPredicate_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.core.Predicate#getValidator <em>Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Validator</em>'.
	 * @see no.hib.dpf.core.Predicate#getValidator()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Validator();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.core.SemanticValidator <em>Semantic Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Validator</em>'.
	 * @see no.hib.dpf.core.SemanticValidator
	 * @generated
	 */
	EClass getSemanticValidator();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.SemanticValidator#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see no.hib.dpf.core.SemanticValidator#getType()
	 * @see #getSemanticValidator()
	 * @generated
	 */
	EAttribute getSemanticValidator_Type();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.SemanticValidator#getValidator <em>Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validator</em>'.
	 * @see no.hib.dpf.core.SemanticValidator#getValidator()
	 * @see #getSemanticValidator()
	 * @generated
	 */
	EAttribute getSemanticValidator_Validator();

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
	 * Returns the meta object for the reference list '{@link no.hib.dpf.core.Constraint#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nodes</em>'.
	 * @see no.hib.dpf.core.Constraint#getNodes()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.core.Constraint#getArrows <em>Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arrows</em>'.
	 * @see no.hib.dpf.core.Constraint#getArrows()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Arrows();

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
	 * Returns the meta object for enum '{@link no.hib.dpf.core.ValidatorType <em>Validator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Validator Type</em>'.
	 * @see no.hib.dpf.core.ValidatorType
	 * @generated
	 */
	EEnum getValidatorType();

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
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.core.Specification#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see no.hib.dpf.core.Specification#getConstraints()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Constraints();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Specification#getMetaFile <em>Meta File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta File</em>'.
	 * @see no.hib.dpf.core.Specification#getMetaFile()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_MetaFile();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.core.Specification#getSignatureFile <em>Signature File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signature File</em>'.
	 * @see no.hib.dpf.core.Specification#getSignatureFile()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_SignatureFile();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Specification#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see no.hib.dpf.core.Specification#getSignature()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Signature();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.core.Specification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see no.hib.dpf.core.Specification#getType()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Type();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.ecore.resource.ResourceSet <em>EResource Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EResource Set</em>'.
	 * @see org.eclipse.emf.ecore.resource.ResourceSet
	 * @model instanceClass="org.eclipse.emf.ecore.resource.ResourceSet"
	 * @generated
	 */
	EDataType getEResourceSet();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getGraph()
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
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__TYPE = eINSTANCE.getGraph_Type();

		/**
		 * The meta object literal for the '<em><b>Arrows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__ARROWS = eINSTANCE.getGraph_Arrows();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.NodeImpl
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getNode()
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
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOINGS = eINSTANCE.getNode_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMINGS = eINSTANCE.getNode_Incomings();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CONSTRAINTS = eINSTANCE.getNode_Constraints();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.ArrowImpl <em>Arrow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.ArrowImpl
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getArrow()
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
		 * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW__CONSTRAINTS = eINSTANCE.getArrow_Constraints();

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
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getSignature()
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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNATURE__NAME = eINSTANCE.getSignature_Name();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.PredicateImpl
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE__SYMBOL = eINSTANCE.getPredicate_Symbol();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__SHAPE = eINSTANCE.getPredicate_Shape();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICATE__PARAMETERS = eINSTANCE.getPredicate_Parameters();

		/**
		 * The meta object literal for the '<em><b>Validator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__VALIDATOR = eINSTANCE.getPredicate_Validator();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.SemanticValidatorImpl <em>Semantic Validator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.SemanticValidatorImpl
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getSemanticValidator()
		 * @generated
		 */
		EClass SEMANTIC_VALIDATOR = eINSTANCE.getSemanticValidator();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMANTIC_VALIDATOR__TYPE = eINSTANCE.getSemanticValidator_Type();

		/**
		 * The meta object literal for the '<em><b>Validator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMANTIC_VALIDATOR__VALIDATOR = eINSTANCE.getSemanticValidator_Validator();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.NodeToNodeMapImpl <em>Node To Node Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.NodeToNodeMapImpl
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getNodeToNodeMap()
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
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__NODES = eINSTANCE.getConstraint_Nodes();

		/**
		 * The meta object literal for the '<em><b>Arrows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__ARROWS = eINSTANCE.getConstraint_Arrows();

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
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getArrowToArrowMap()
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
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.GraphHomomorphismImpl <em>Graph Homomorphism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.GraphHomomorphismImpl
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getGraphHomomorphism()
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
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getIDObject()
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
		 * The meta object literal for the '{@link no.hib.dpf.core.ValidatorType <em>Validator Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.ValidatorType
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getValidatorType()
		 * @generated
		 */
		EEnum VALIDATOR_TYPE = eINSTANCE.getValidatorType();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.core.impl.SpecificationImpl <em>Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.core.impl.SpecificationImpl
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getSpecification()
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
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__CONSTRAINTS = eINSTANCE.getSpecification_Constraints();

		/**
		 * The meta object literal for the '<em><b>Meta File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__META_FILE = eINSTANCE.getSpecification_MetaFile();

		/**
		 * The meta object literal for the '<em><b>Signature File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__SIGNATURE_FILE = eINSTANCE.getSpecification_SignatureFile();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__SIGNATURE = eINSTANCE.getSpecification_Signature();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__TYPE = eINSTANCE.getSpecification_Type();

		/**
		 * The meta object literal for the '<em>EResource Set</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecore.resource.ResourceSet
		 * @see no.hib.dpf.core.impl.CorePackageImpl#getEResourceSet()
		 * @generated
		 */
		EDataType ERESOURCE_SET = eINSTANCE.getEResourceSet();

	}

} //CorePackage
