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

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.InverseSemantics;
import no.hib.dpf.core.IrreflexiveSemantics;
import no.hib.dpf.core.JointlySurjectiveSemantics;
import no.hib.dpf.core.ModelHierarchy;
import no.hib.dpf.core.MultiplicitySemantics;
import no.hib.dpf.core.NANDSemantics;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticsValidator;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.core.SurjectiveSemantics;
import no.hib.dpf.core.TransitiveIrreflexiveSemantics;
import no.hib.dpf.core.TypingMorphism;
import no.hib.dpf.core.ValidatorType;
import no.hib.dpf.core.Visualization;
import no.hib.dpf.core.VisualizationType;
import no.hib.dpf.core.XORSemantics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorePackageImpl extends EPackageImpl implements CorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticsValidatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visualizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeToNodeMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrowToArrowMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typingMorphismEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphHomomorphismEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelHierarchyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jointlySurjectiveSemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inverseSemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass irreflexiveSemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicitySemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorSemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitiveIrreflexiveSemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass surjectiveSemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nandSemanticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum validatorTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visualizationTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see no.hib.dpf.core.CorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CorePackageImpl() {
		super(eNS_URI, CoreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CorePackage init() {
		if (isInited) return (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Obtain or create and register package
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CorePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCorePackage.createPackageContents();

		// Initialize created meta-data
		theCorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CorePackage.eNS_URI, theCorePackage);
		return theCorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraph() {
		return graphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Nodes() {
		return (EReference)graphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGraph_Name() {
		return (EAttribute)graphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Arrows() {
		return (EReference)graphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Constraints() {
		return (EReference)graphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Name() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Graph() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_TypeNode() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrow() {
		return arrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrow_Target() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrow_Graph() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrow_TypeArrow() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrow_Source() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrow_Name() {
		return (EAttribute)arrowEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignature() {
		return signatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSignature_Predicates() {
		return (EReference)signatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSignature_Name() {
		return (EAttribute)signatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicate_Shape() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicate_SemanticsValidator() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPredicate_Parameters() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicate_Visualization() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPredicate_Symbol() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPredicate_Icon() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSemanticsValidator() {
		return semanticsValidatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticsValidator_Type() {
		return (EAttribute)semanticsValidatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticsValidator_Validator() {
		return (EAttribute)semanticsValidatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisualization() {
		return visualizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualization_Type() {
		return (EAttribute)visualizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualization_Source() {
		return (EReference)visualizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualization_Target() {
		return (EReference)visualizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeToNodeMap() {
		return nodeToNodeMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeToNodeMap_Key() {
		return (EReference)nodeToNodeMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeToNodeMap_Value() {
		return (EReference)nodeToNodeMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Graph() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Predicate() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Mappings() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Parameters() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrowToArrowMap() {
		return arrowToArrowMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrowToArrowMap_Key() {
		return (EReference)arrowToArrowMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrowToArrowMap_Value() {
		return (EReference)arrowToArrowMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypingMorphism() {
		return typingMorphismEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypingMorphism_Model() {
		return (EReference)typingMorphismEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypingMorphism_Metamodel() {
		return (EReference)typingMorphismEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypingMorphism_Mappings() {
		return (EReference)typingMorphismEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphHomomorphism() {
		return graphHomomorphismEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphHomomorphism_NodeMapping() {
		return (EReference)graphHomomorphismEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphHomomorphism_ArrowMapping() {
		return (EReference)graphHomomorphismEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIDObject() {
		return idObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIDObject_Id() {
		return (EAttribute)idObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecification() {
		return specificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecification_Graph() {
		return (EReference)specificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecification_TypeGraph() {
		return (EReference)specificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecification_Signature() {
		return (EReference)specificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecification_SignatureFile() {
		return (EAttribute)specificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelHierarchy() {
		return modelHierarchyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelHierarchy_Specifications() {
		return (EReference)modelHierarchyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJointlySurjectiveSemantics() {
		return jointlySurjectiveSemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInverseSemantics() {
		return inverseSemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIrreflexiveSemantics() {
		return irreflexiveSemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicitySemantics() {
		return multiplicitySemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXORSemantics() {
		return xorSemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitiveIrreflexiveSemantics() {
		return transitiveIrreflexiveSemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSurjectiveSemantics() {
		return surjectiveSemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNANDSemantics() {
		return nandSemanticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getValidatorType() {
		return validatorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisualizationType() {
		return visualizationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactory getCoreFactory() {
		return (CoreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		graphEClass = createEClass(GRAPH);
		createEReference(graphEClass, GRAPH__NODES);
		createEAttribute(graphEClass, GRAPH__NAME);
		createEReference(graphEClass, GRAPH__ARROWS);
		createEReference(graphEClass, GRAPH__CONSTRAINTS);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__NAME);
		createEReference(nodeEClass, NODE__GRAPH);
		createEReference(nodeEClass, NODE__TYPE_NODE);

		arrowEClass = createEClass(ARROW);
		createEReference(arrowEClass, ARROW__TARGET);
		createEReference(arrowEClass, ARROW__GRAPH);
		createEReference(arrowEClass, ARROW__TYPE_ARROW);
		createEReference(arrowEClass, ARROW__SOURCE);
		createEAttribute(arrowEClass, ARROW__NAME);

		signatureEClass = createEClass(SIGNATURE);
		createEReference(signatureEClass, SIGNATURE__PREDICATES);
		createEAttribute(signatureEClass, SIGNATURE__NAME);

		predicateEClass = createEClass(PREDICATE);
		createEReference(predicateEClass, PREDICATE__SHAPE);
		createEReference(predicateEClass, PREDICATE__SEMANTICS_VALIDATOR);
		createEAttribute(predicateEClass, PREDICATE__PARAMETERS);
		createEReference(predicateEClass, PREDICATE__VISUALIZATION);
		createEAttribute(predicateEClass, PREDICATE__SYMBOL);
		createEAttribute(predicateEClass, PREDICATE__ICON);

		semanticsValidatorEClass = createEClass(SEMANTICS_VALIDATOR);
		createEAttribute(semanticsValidatorEClass, SEMANTICS_VALIDATOR__TYPE);
		createEAttribute(semanticsValidatorEClass, SEMANTICS_VALIDATOR__VALIDATOR);

		visualizationEClass = createEClass(VISUALIZATION);
		createEAttribute(visualizationEClass, VISUALIZATION__TYPE);
		createEReference(visualizationEClass, VISUALIZATION__SOURCE);
		createEReference(visualizationEClass, VISUALIZATION__TARGET);

		nodeToNodeMapEClass = createEClass(NODE_TO_NODE_MAP);
		createEReference(nodeToNodeMapEClass, NODE_TO_NODE_MAP__KEY);
		createEReference(nodeToNodeMapEClass, NODE_TO_NODE_MAP__VALUE);

		constraintEClass = createEClass(CONSTRAINT);
		createEReference(constraintEClass, CONSTRAINT__GRAPH);
		createEReference(constraintEClass, CONSTRAINT__PREDICATE);
		createEReference(constraintEClass, CONSTRAINT__MAPPINGS);
		createEAttribute(constraintEClass, CONSTRAINT__PARAMETERS);

		arrowToArrowMapEClass = createEClass(ARROW_TO_ARROW_MAP);
		createEReference(arrowToArrowMapEClass, ARROW_TO_ARROW_MAP__KEY);
		createEReference(arrowToArrowMapEClass, ARROW_TO_ARROW_MAP__VALUE);

		typingMorphismEClass = createEClass(TYPING_MORPHISM);
		createEReference(typingMorphismEClass, TYPING_MORPHISM__MODEL);
		createEReference(typingMorphismEClass, TYPING_MORPHISM__METAMODEL);
		createEReference(typingMorphismEClass, TYPING_MORPHISM__MAPPINGS);

		graphHomomorphismEClass = createEClass(GRAPH_HOMOMORPHISM);
		createEReference(graphHomomorphismEClass, GRAPH_HOMOMORPHISM__NODE_MAPPING);
		createEReference(graphHomomorphismEClass, GRAPH_HOMOMORPHISM__ARROW_MAPPING);

		idObjectEClass = createEClass(ID_OBJECT);
		createEAttribute(idObjectEClass, ID_OBJECT__ID);

		specificationEClass = createEClass(SPECIFICATION);
		createEReference(specificationEClass, SPECIFICATION__GRAPH);
		createEReference(specificationEClass, SPECIFICATION__TYPE_GRAPH);
		createEReference(specificationEClass, SPECIFICATION__SIGNATURE);
		createEAttribute(specificationEClass, SPECIFICATION__SIGNATURE_FILE);

		modelHierarchyEClass = createEClass(MODEL_HIERARCHY);
		createEReference(modelHierarchyEClass, MODEL_HIERARCHY__SPECIFICATIONS);

		jointlySurjectiveSemanticsEClass = createEClass(JOINTLY_SURJECTIVE_SEMANTICS);

		inverseSemanticsEClass = createEClass(INVERSE_SEMANTICS);

		irreflexiveSemanticsEClass = createEClass(IRREFLEXIVE_SEMANTICS);

		multiplicitySemanticsEClass = createEClass(MULTIPLICITY_SEMANTICS);

		xorSemanticsEClass = createEClass(XOR_SEMANTICS);

		transitiveIrreflexiveSemanticsEClass = createEClass(TRANSITIVE_IRREFLEXIVE_SEMANTICS);

		surjectiveSemanticsEClass = createEClass(SURJECTIVE_SEMANTICS);

		nandSemanticsEClass = createEClass(NAND_SEMANTICS);

		// Create enums
		validatorTypeEEnum = createEEnum(VALIDATOR_TYPE);
		visualizationTypeEEnum = createEEnum(VISUALIZATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		graphEClass.getESuperTypes().add(this.getIDObject());
		nodeEClass.getESuperTypes().add(this.getIDObject());
		arrowEClass.getESuperTypes().add(this.getIDObject());
		constraintEClass.getESuperTypes().add(this.getIDObject());
		jointlySurjectiveSemanticsEClass.getESuperTypes().add(this.getSemanticsValidator());
		inverseSemanticsEClass.getESuperTypes().add(this.getSemanticsValidator());
		irreflexiveSemanticsEClass.getESuperTypes().add(this.getSemanticsValidator());
		multiplicitySemanticsEClass.getESuperTypes().add(this.getSemanticsValidator());
		xorSemanticsEClass.getESuperTypes().add(this.getSemanticsValidator());
		transitiveIrreflexiveSemanticsEClass.getESuperTypes().add(this.getSemanticsValidator());
		surjectiveSemanticsEClass.getESuperTypes().add(this.getSemanticsValidator());
		nandSemanticsEClass.getESuperTypes().add(this.getSemanticsValidator());

		// Initialize classes and features; add operations and parameters
		initEClass(graphEClass, Graph.class, "Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraph_Nodes(), this.getNode(), this.getNode_Graph(), "nodes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraph_Name(), ecorePackage.getEString(), "name", null, 0, 1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_Arrows(), this.getArrow(), this.getArrow_Graph(), "arrows", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_Constraints(), this.getConstraint(), this.getConstraint_Graph(), "constraints", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(graphEClass, this.getNode(), "createNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getIDObject(), "getGraphMember", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "id", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getArrow(), "createArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getConstraint(), "applyPredicate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPredicate(), "predicate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "edges", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, null, "deleteNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, null, "deleteArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "edge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getNode(), "getNodeByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getArrow(), "getArrowByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getNode(), "createNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "typeNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getArrow(), "createArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "typeEdge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getGraph(), "extractSubgraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "arrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getNode(), "getNodesForConstraint", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConstraint(), "constraint", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getArrow(), "getArrowsForConstraint", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConstraint(), "constraint", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getNode(), "getNodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "typeNodes", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(graphEClass, this.getArrow(), "getArrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "types", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(graphEClass, this.getGraph(), "getCopy", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Graph(), this.getGraph(), this.getGraph_Nodes(), "graph", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_TypeNode(), this.getNode(), null, "typeNode", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(nodeEClass, this.getArrow(), "getOutgoingArrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, ecorePackage.getEBoolean(), "arrowCanMakeConnectionAsTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "intendedTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, ecorePackage.getEBoolean(), "canReachTargetByOneArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, ecorePackage.getEBooleanObject(), "arrowCanMakeConnectionAsTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "intendedTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "typeEdge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, ecorePackage.getEBooleanObject(), "canReachTargetByTypeArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "typeEdge", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, this.getArrow(), "getArrowto", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nodeEClass, ecorePackage.getEString(), "getTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nodeEClass, ecorePackage.getEString(), "generateUniqueName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, ecorePackage.getEBoolean(), "canCreateTypedArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "intendedTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, this.getArrow(), "getTypeArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "intendedTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nodeEClass, this.getArrow(), "getIncomingArrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(arrowEClass, Arrow.class, "Arrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrow_Target(), this.getNode(), null, "target", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrow_Graph(), this.getGraph(), this.getGraph_Arrows(), "graph", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrow_TypeArrow(), this.getArrow(), null, "typeArrow", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrow_Source(), this.getNode(), null, "source", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrow_Name(), ecorePackage.getEString(), "name", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(arrowEClass, ecorePackage.getEString(), "getTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(arrowEClass, ecorePackage.getEString(), "generateUniqueName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(signatureEClass, Signature.class, "Signature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSignature_Predicates(), this.getPredicate(), null, "predicates", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(signatureEClass, this.getPredicate(), "getPredicateBySymbol", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "symbol", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(predicateEClass, Predicate.class, "Predicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicate_Shape(), this.getGraph(), null, "shape", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_SemanticsValidator(), this.getSemanticsValidator(), null, "semanticsValidator", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredicate_Parameters(), ecorePackage.getEString(), "parameters", null, 0, -1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_Visualization(), this.getVisualization(), null, "visualization", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredicate_Symbol(), ecorePackage.getEString(), "symbol", null, 1, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredicate_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(predicateEClass, this.getConstraint(), "createConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "arrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "modelToBeConstrained", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(predicateEClass, ecorePackage.getEBoolean(), "canCreateConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "arrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "modelToBeConstrained", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(predicateEClass, ecorePackage.getEBooleanObject(), "validateSemantics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "oStar", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintParameters", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "typeNodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "typeArrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(predicateEClass, ecorePackage.getEBoolean(), "validateSemantics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraphHomomorphism(), "mapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(semanticsValidatorEClass, SemanticsValidator.class, "SemanticsValidator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSemanticsValidator_Type(), this.getValidatorType(), "type", null, 0, 1, SemanticsValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticsValidator_Validator(), ecorePackage.getEString(), "validator", null, 0, 1, SemanticsValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(semanticsValidatorEClass, ecorePackage.getEBooleanObject(), "validateSemantics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "oStar", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintParameters", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "typeNodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "typeArrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(visualizationEClass, Visualization.class, "Visualization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVisualization_Type(), this.getVisualizationType(), "type", null, 0, 1, Visualization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualization_Source(), this.getIDObject(), null, "source", null, 0, 1, Visualization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualization_Target(), this.getIDObject(), null, "target", null, 0, 1, Visualization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeToNodeMapEClass, Map.Entry.class, "NodeToNodeMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeToNodeMap_Key(), this.getNode(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeToNodeMap_Value(), this.getNode(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraint_Graph(), this.getGraph(), this.getGraph_Constraints(), "graph", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Predicate(), this.getPredicate(), null, "predicate", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Mappings(), this.getGraphHomomorphism(), null, "mappings", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_Parameters(), ecorePackage.getEString(), "parameters", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(constraintEClass, this.getNode(), "getConstrainedNodes", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(constraintEClass, this.getArrow(), "getConstrainedArrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(arrowToArrowMapEClass, Map.Entry.class, "ArrowToArrowMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrowToArrowMap_Key(), this.getArrow(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowToArrowMap_Value(), this.getArrow(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typingMorphismEClass, TypingMorphism.class, "TypingMorphism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypingMorphism_Model(), this.getGraph(), null, "model", null, 1, 1, TypingMorphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypingMorphism_Metamodel(), this.getGraph(), null, "metamodel", null, 1, 1, TypingMorphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypingMorphism_Mappings(), this.getGraphHomomorphism(), null, "mappings", null, 0, 1, TypingMorphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphHomomorphismEClass, GraphHomomorphism.class, "GraphHomomorphism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphHomomorphism_NodeMapping(), this.getNodeToNodeMap(), null, "nodeMapping", null, 0, -1, GraphHomomorphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphHomomorphism_ArrowMapping(), this.getArrowToArrowMap(), null, "arrowMapping", null, 0, -1, GraphHomomorphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(graphHomomorphismEClass, ecorePackage.getEBoolean(), "tryToCreateGraphHomomorphism", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "sourceGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "edges", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(idObjectEClass, IDObject.class, "IDObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIDObject_Id(), ecorePackage.getEString(), "id", "", 0, 1, IDObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specificationEClass, Specification.class, "Specification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecification_Graph(), this.getGraph(), null, "graph", null, 1, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecification_TypeGraph(), this.getGraph(), null, "typeGraph", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecification_Signature(), this.getSignature(), null, "signature", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecification_SignatureFile(), ecorePackage.getEString(), "signatureFile", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(specificationEClass, this.getGraph(), "createOStar", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConstraint(), "constraint", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelHierarchyEClass, ModelHierarchy.class, "ModelHierarchy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelHierarchy_Specifications(), this.getSpecification(), null, "specifications", null, 0, -1, ModelHierarchy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jointlySurjectiveSemanticsEClass, JointlySurjectiveSemantics.class, "JointlySurjectiveSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inverseSemanticsEClass, InverseSemantics.class, "InverseSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(irreflexiveSemanticsEClass, IrreflexiveSemantics.class, "IrreflexiveSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiplicitySemanticsEClass, MultiplicitySemantics.class, "MultiplicitySemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xorSemanticsEClass, XORSemantics.class, "XORSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(transitiveIrreflexiveSemanticsEClass, TransitiveIrreflexiveSemantics.class, "TransitiveIrreflexiveSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(surjectiveSemanticsEClass, SurjectiveSemantics.class, "SurjectiveSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nandSemanticsEClass, NANDSemantics.class, "NANDSemantics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(validatorTypeEEnum, ValidatorType.class, "ValidatorType");
		addEEnumLiteral(validatorTypeEEnum, ValidatorType.OCL);
		addEEnumLiteral(validatorTypeEEnum, ValidatorType.JAVA);

		initEEnum(visualizationTypeEEnum, VisualizationType.class, "VisualizationType");
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_LABEL);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.NODE_TO_NODE);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.NODE_TO_ARROW);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_TO_NODE);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_TO_ARROW);

		// Create resource
		createResource(eNS_URI);
	}

} //MetamodelPackageImpl
