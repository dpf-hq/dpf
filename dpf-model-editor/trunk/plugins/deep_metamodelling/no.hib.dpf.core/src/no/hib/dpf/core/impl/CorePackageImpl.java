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
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode; 
import no.hib.dpf.core.DeepElement;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Mutability;
import no.hib.dpf.core.MutableElement;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticValidator;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.core.ValidatorType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;

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
	private EClass semanticValidatorEClass = null;

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
	private EClass dataNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrowAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deepElementEClass = null;

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
	private EClass specificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eResourceSetEDataType = null;

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
	@Override
	public EClass getGraph() {
		return graphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraph_Nodes() {
		return (EReference)graphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraph_Type() {
		return (EReference)graphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraph_Arrows() {
		return (EReference)graphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraph_Name() {
		return (EAttribute)graphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Datanodes() {
		return (EReference)graphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraph_ArrowAttributes() {
		return (EReference)graphEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraph_NodeAttributes() {
		return (EReference)graphEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Outgoings() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Incomings() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Constraints() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_TypeNode() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_Name() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_OutgoingAttributes() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArrow() {
		return arrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrow_Target() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrow_Constraints() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrow_TypeArrow() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArrow_Name() {
		return (EAttribute)arrowEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrow_OutgoingAttributes() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrow_Source() {
		return (EReference)arrowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSignature() {
		return signatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSignature_Predicates() {
		return (EReference)signatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSignature_Name() {
		return (EAttribute)signatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPredicate_Symbol() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicate_Shape() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPredicate_Parameters() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicate_Validator() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSemanticValidator() {
		return semanticValidatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSemanticValidator_Type() {
		return (EAttribute)semanticValidatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSemanticValidator_Validator() {
		return (EAttribute)semanticValidatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeToNodeMap() {
		return nodeToNodeMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeToNodeMap_Key() {
		return (EReference)nodeToNodeMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeToNodeMap_Value() {
		return (EReference)nodeToNodeMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraint_Nodes() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraint_Arrows() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraint_Predicate() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraint_Mappings() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstraint_Parameters() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraint_ArrowAttributes() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraint_NodeAttributes() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArrowToArrowMap() {
		return arrowToArrowMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrowToArrowMap_Key() {
		return (EReference)arrowToArrowMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrowToArrowMap_Value() {
		return (EReference)arrowToArrowMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphHomomorphism() {
		return graphHomomorphismEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphHomomorphism_NodeMapping() {
		return (EReference)graphHomomorphismEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphHomomorphism_ArrowMapping() {
		return (EReference)graphHomomorphismEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIDObject() {
		return idObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIDObject_Id() {
		return (EAttribute)idObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataNode() {
		return dataNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataNode_Value() {
		return (EAttribute)dataNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataNode_IncomingNodeAttributes() {
		return (EReference)dataNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataNode_IncomingArrowAtributes() {
		return (EReference)dataNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataNode_TypeDataNode() {
		return (EReference)dataNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataNode_Datatype() {
		return (EAttribute)dataNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataNode_IsDataType() {
		return (EAttribute)dataNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeAttribute() {
		return nodeAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeAttribute_Source() {
		return (EReference)nodeAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeAttribute_TypeAttribute() {
		return (EReference)nodeAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeAttribute_Constraints() {
		return (EReference)nodeAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeAttribute_Target() {
		return (EReference)nodeAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeAttribute_Name() {
		return (EAttribute)nodeAttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArrowAttribute() {
		return arrowAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrowAttribute_Source() {
		return (EReference)arrowAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrowAttribute_TypeAttribute() {
		return (EReference)arrowAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArrowAttribute_Constraints() {
		return (EReference)arrowAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrowAttribute_Name() {
		return (EAttribute)arrowAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrowAttribute_Target() {
		return (EReference)arrowAttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutableElement() {
		return mutableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutableElement_Mutability() {
		return (EAttribute)mutableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeepElement() {
		return deepElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeepElement_Potency() {
		return (EAttribute)deepElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getValidatorType() {
		return validatorTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSpecification() {
		return specificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecification_Graph() {
		return (EReference)specificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecification_Constraints() {
		return (EReference)specificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpecification_MetaFile() {
		return (EAttribute)specificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpecification_SignatureFile() {
		return (EAttribute)specificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecification_Signature() {
		return (EReference)specificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSpecification_Type() {
		return (EReference)specificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSpecification_Metalevel() {
		return (EAttribute)specificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEResourceSet() {
		return eResourceSetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		specificationEClass = createEClass(SPECIFICATION);
		createEReference(specificationEClass, SPECIFICATION__GRAPH);
		createEReference(specificationEClass, SPECIFICATION__CONSTRAINTS);
		createEAttribute(specificationEClass, SPECIFICATION__META_FILE);
		createEAttribute(specificationEClass, SPECIFICATION__SIGNATURE_FILE);
		createEReference(specificationEClass, SPECIFICATION__SIGNATURE);
		createEReference(specificationEClass, SPECIFICATION__TYPE);
		createEAttribute(specificationEClass, SPECIFICATION__METALEVEL);

		graphEClass = createEClass(GRAPH);
		createEReference(graphEClass, GRAPH__TYPE);
		createEReference(graphEClass, GRAPH__NODES);
		createEReference(graphEClass, GRAPH__ARROWS);
		createEAttribute(graphEClass, GRAPH__NAME);
		createEReference(graphEClass, GRAPH__DATANODES);
		createEReference(graphEClass, GRAPH__ARROW_ATTRIBUTES);
		createEReference(graphEClass, GRAPH__NODE_ATTRIBUTES);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__OUTGOINGS);
		createEReference(nodeEClass, NODE__INCOMINGS);
		createEReference(nodeEClass, NODE__CONSTRAINTS);
		createEReference(nodeEClass, NODE__TYPE_NODE);
		createEAttribute(nodeEClass, NODE__NAME);
		createEReference(nodeEClass, NODE__OUTGOING_ATTRIBUTES);

		arrowEClass = createEClass(ARROW);
		createEReference(arrowEClass, ARROW__SOURCE);
		createEReference(arrowEClass, ARROW__TARGET);
		createEReference(arrowEClass, ARROW__CONSTRAINTS);
		createEReference(arrowEClass, ARROW__TYPE_ARROW);
		createEAttribute(arrowEClass, ARROW__NAME);
		createEReference(arrowEClass, ARROW__OUTGOING_ATTRIBUTES);

		signatureEClass = createEClass(SIGNATURE);
		createEReference(signatureEClass, SIGNATURE__PREDICATES);
		createEAttribute(signatureEClass, SIGNATURE__NAME);

		predicateEClass = createEClass(PREDICATE);
		createEAttribute(predicateEClass, PREDICATE__SYMBOL);
		createEReference(predicateEClass, PREDICATE__SHAPE);
		createEAttribute(predicateEClass, PREDICATE__PARAMETERS);
		createEReference(predicateEClass, PREDICATE__VALIDATOR);

		semanticValidatorEClass = createEClass(SEMANTIC_VALIDATOR);
		createEAttribute(semanticValidatorEClass, SEMANTIC_VALIDATOR__TYPE);
		createEAttribute(semanticValidatorEClass, SEMANTIC_VALIDATOR__VALIDATOR);

		constraintEClass = createEClass(CONSTRAINT);
		createEReference(constraintEClass, CONSTRAINT__NODES);
		createEReference(constraintEClass, CONSTRAINT__ARROWS);
		createEReference(constraintEClass, CONSTRAINT__PREDICATE);
		createEReference(constraintEClass, CONSTRAINT__MAPPINGS);
		createEAttribute(constraintEClass, CONSTRAINT__PARAMETERS);
		createEReference(constraintEClass, CONSTRAINT__ARROW_ATTRIBUTES);
		createEReference(constraintEClass, CONSTRAINT__NODE_ATTRIBUTES);

		graphHomomorphismEClass = createEClass(GRAPH_HOMOMORPHISM);
		createEReference(graphHomomorphismEClass, GRAPH_HOMOMORPHISM__NODE_MAPPING);
		createEReference(graphHomomorphismEClass, GRAPH_HOMOMORPHISM__ARROW_MAPPING);

		nodeToNodeMapEClass = createEClass(NODE_TO_NODE_MAP);
		createEReference(nodeToNodeMapEClass, NODE_TO_NODE_MAP__KEY);
		createEReference(nodeToNodeMapEClass, NODE_TO_NODE_MAP__VALUE);

		arrowToArrowMapEClass = createEClass(ARROW_TO_ARROW_MAP);
		createEReference(arrowToArrowMapEClass, ARROW_TO_ARROW_MAP__KEY);
		createEReference(arrowToArrowMapEClass, ARROW_TO_ARROW_MAP__VALUE);

		idObjectEClass = createEClass(ID_OBJECT);
		createEAttribute(idObjectEClass, ID_OBJECT__ID);

		dataNodeEClass = createEClass(DATA_NODE);
		createEAttribute(dataNodeEClass, DATA_NODE__VALUE);
		createEReference(dataNodeEClass, DATA_NODE__INCOMING_NODE_ATTRIBUTES);
		createEReference(dataNodeEClass, DATA_NODE__INCOMING_ARROW_ATRIBUTES);
		createEReference(dataNodeEClass, DATA_NODE__TYPE_DATA_NODE);
		createEAttribute(dataNodeEClass, DATA_NODE__DATATYPE);
		createEAttribute(dataNodeEClass, DATA_NODE__IS_DATA_TYPE);

		nodeAttributeEClass = createEClass(NODE_ATTRIBUTE);
		createEReference(nodeAttributeEClass, NODE_ATTRIBUTE__SOURCE);
		createEReference(nodeAttributeEClass, NODE_ATTRIBUTE__TYPE_ATTRIBUTE);
		createEReference(nodeAttributeEClass, NODE_ATTRIBUTE__CONSTRAINTS);
		createEReference(nodeAttributeEClass, NODE_ATTRIBUTE__TARGET);
		createEAttribute(nodeAttributeEClass, NODE_ATTRIBUTE__NAME);

		arrowAttributeEClass = createEClass(ARROW_ATTRIBUTE);
		createEReference(arrowAttributeEClass, ARROW_ATTRIBUTE__SOURCE);
		createEReference(arrowAttributeEClass, ARROW_ATTRIBUTE__TYPE_ATTRIBUTE);
		createEReference(arrowAttributeEClass, ARROW_ATTRIBUTE__CONSTRAINTS);
		createEAttribute(arrowAttributeEClass, ARROW_ATTRIBUTE__NAME);
		createEReference(arrowAttributeEClass, ARROW_ATTRIBUTE__TARGET);

		mutableElementEClass = createEClass(MUTABLE_ELEMENT);
		createEAttribute(mutableElementEClass, MUTABLE_ELEMENT__MUTABILITY);

		deepElementEClass = createEClass(DEEP_ELEMENT);
		createEAttribute(deepElementEClass, DEEP_ELEMENT__POTENCY);

		// Create enums
		validatorTypeEEnum = createEEnum(VALIDATOR_TYPE);

		// Create data types
		eResourceSetEDataType = createEDataType(ERESOURCE_SET);
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
		graphEClass.getESuperTypes().add(this.getDeepElement());
		nodeEClass.getESuperTypes().add(this.getIDObject());
		nodeEClass.getESuperTypes().add(this.getMutableElement());
		nodeEClass.getESuperTypes().add(this.getDeepElement());
		arrowEClass.getESuperTypes().add(this.getIDObject());
		arrowEClass.getESuperTypes().add(this.getMutableElement());
		arrowEClass.getESuperTypes().add(this.getDeepElement());
		constraintEClass.getESuperTypes().add(this.getIDObject());
		dataNodeEClass.getESuperTypes().add(this.getMutableElement());
		dataNodeEClass.getESuperTypes().add(this.getIDObject());
		nodeAttributeEClass.getESuperTypes().add(this.getIDObject());
		nodeAttributeEClass.getESuperTypes().add(this.getMutableElement());
		arrowAttributeEClass.getESuperTypes().add(this.getIDObject());
		arrowAttributeEClass.getESuperTypes().add(this.getMutableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(specificationEClass, Specification.class, "Specification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecification_Graph(), this.getGraph(), null, "graph", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecification_Constraints(), this.getConstraint(), null, "constraints", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecification_MetaFile(), ecorePackage.getEString(), "metaFile", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecification_SignatureFile(), ecorePackage.getEString(), "signatureFile", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecification_Signature(), this.getSignature(), null, "signature", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecification_Type(), this.getSpecification(), null, "type", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpecification_Metalevel(), ecorePackage.getEInt(), "metalevel", "-1", 1, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(specificationEClass, this.getGraph(), "createGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(specificationEClass, this.getConstraint(), "createConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPredicate(), "predicate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameters", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraphHomomorphism(), "mapping", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "stuckedNodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "stuckedArrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "typeNodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "typeArrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(specificationEClass, ecorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(specificationEClass, this.getSpecification(), "getTemplateSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(graphEClass, Graph.class, "Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraph_Type(), this.getGraph(), null, "type", null, 1, 1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_Nodes(), this.getNode(), null, "nodes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_Arrows(), this.getArrow(), null, "arrows", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraph_Name(), ecorePackage.getEString(), "name", null, 0, 1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_Datanodes(), this.getDataNode(), null, "datanodes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_ArrowAttributes(), this.getArrowAttribute(), null, "arrowAttributes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_NodeAttributes(), this.getNodeAttribute(), null, "nodeAttributes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(graphEClass, this.getNode(), "createNode", 0, 1, IS_UNIQUE, IS_ORDERED);
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
		initEReference(getNode_Outgoings(), this.getArrow(), this.getArrow_Source(), "outgoings", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Incomings(), this.getArrow(), this.getArrow_Target(), "incomings", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Constraints(), this.getConstraint(), this.getConstraint_Nodes(), "constraints", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_TypeNode(), this.getNode(), null, "typeNode", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OutgoingAttributes(), this.getNodeAttribute(), this.getNodeAttribute_Source(), "outgoingAttributes", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		addEOperation(nodeEClass, ecorePackage.getEString(), "generateUniqueName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, ecorePackage.getEBoolean(), "canCreateTypedArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "intendedTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, this.getArrow(), "getTypeArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "intendedTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nodeEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nodeEClass, ecorePackage.getEString(), "getTemplateElementType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(arrowEClass, Arrow.class, "Arrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrow_Source(), this.getNode(), this.getNode_Outgoings(), "source", null, 1, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrow_Target(), this.getNode(), this.getNode_Incomings(), "target", null, 1, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrow_Constraints(), this.getConstraint(), this.getConstraint_Arrows(), "constraints", null, 0, -1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrow_TypeArrow(), this.getArrow(), null, "typeArrow", null, 1, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrow_Name(), ecorePackage.getEString(), "name", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrow_OutgoingAttributes(), this.getArrowAttribute(), this.getArrowAttribute_Source(), "outgoingAttributes", null, 0, -1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(arrowEClass, ecorePackage.getEString(), "generateUniqueName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(arrowEClass, ecorePackage.getEString(), "getTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(arrowEClass, ecorePackage.getEString(), "getTemplateElementType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(signatureEClass, Signature.class, "Signature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSignature_Predicates(), this.getPredicate(), null, "predicates", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(signatureEClass, this.getPredicate(), "getPredicateBySymbol", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "symbol", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(signatureEClass, null, "addPredicate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPredicate(), "dPredicate", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(signatureEClass, null, "removePredicate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPredicate(), "dPredicate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(predicateEClass, Predicate.class, "Predicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPredicate_Symbol(), ecorePackage.getEString(), "symbol", null, 1, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_Shape(), this.getGraph(), null, "shape", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredicate_Parameters(), ecorePackage.getEString(), "parameters", null, 1, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_Validator(), this.getSemanticValidator(), null, "validator", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(predicateEClass, this.getConstraint(), "createConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "arrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(predicateEClass, ecorePackage.getEBoolean(), "canCreateConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "arrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "modelToBeConstrained", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(predicateEClass, ecorePackage.getEBoolean(), "validateSemantics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameters", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraphHomomorphism(), "mapping", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(semanticValidatorEClass, SemanticValidator.class, "SemanticValidator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSemanticValidator_Type(), this.getValidatorType(), "type", null, 0, 1, SemanticValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticValidator_Validator(), ecorePackage.getEString(), "validator", null, 0, 1, SemanticValidator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(semanticValidatorEClass, ecorePackage.getEBooleanObject(), "validateSemantics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintParameters", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "typeNodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "typeArrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "stuckedNodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "stuckedArrows", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraint_Nodes(), this.getNode(), this.getNode_Constraints(), "nodes", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Arrows(), this.getArrow(), this.getArrow_Constraints(), "arrows", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Predicate(), this.getPredicate(), null, "predicate", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Mappings(), this.getGraphHomomorphism(), null, "mappings", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_Parameters(), ecorePackage.getEString(), "parameters", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_ArrowAttributes(), this.getArrowAttribute(), this.getArrowAttribute_Constraints(), "arrowAttributes", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_NodeAttributes(), this.getNodeAttribute(), this.getNodeAttribute_Constraints(), "nodeAttributes", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(constraintEClass, null, "reconnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "arrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSpecification(), "specification", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(constraintEClass, null, "disconnect", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(constraintEClass, null, "addArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getArrow(), "arrow", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(constraintEClass, null, "addNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(constraintEClass, ecorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(graphHomomorphismEClass, GraphHomomorphism.class, "GraphHomomorphism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphHomomorphism_NodeMapping(), this.getNodeToNodeMap(), null, "nodeMapping", null, 0, -1, GraphHomomorphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphHomomorphism_ArrowMapping(), this.getArrowToArrowMap(), null, "arrowMapping", null, 0, -1, GraphHomomorphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeToNodeMapEClass, Map.Entry.class, "NodeToNodeMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeToNodeMap_Key(), this.getNode(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeToNodeMap_Value(), this.getNode(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrowToArrowMapEClass, Map.Entry.class, "ArrowToArrowMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrowToArrowMap_Key(), this.getArrow(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowToArrowMap_Value(), this.getArrow(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(idObjectEClass, IDObject.class, "IDObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIDObject_Id(), ecorePackage.getEString(), "id", "", 0, 1, IDObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(idObjectEClass, this.getIDObject(), "getTemplateElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(idObjectEClass, ecorePackage.getEBoolean(), "isTemplateElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(idObjectEClass, this.getIDObject(), "getElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "metalevel", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(idObjectEClass, ecorePackage.getEInt(), "getMetaLevel", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataNodeEClass, DataNode.class, "DataNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataNode_Value(), ecorePackage.getEString(), "value", "DataNode", 0, 1, DataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataNode_IncomingNodeAttributes(), this.getNodeAttribute(), this.getNodeAttribute_Target(), "incomingNodeAttributes", null, 0, -1, DataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataNode_IncomingArrowAtributes(), this.getArrowAttribute(), this.getArrowAttribute_Target(), "incomingArrowAtributes", null, 0, -1, DataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataNode_TypeDataNode(), this.getDataNode(), null, "typeDataNode", null, 1, 1, DataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataNode_Datatype(), ecorePackage.getEString(), "datatype", "EDataType", 1, 1, DataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataNode_IsDataType(), ecorePackage.getEBoolean(), "isDataType", "false", 1, 1, DataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(dataNodeEClass, ecorePackage.getEString(), "getTypeValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(nodeAttributeEClass, NodeAttribute.class, "NodeAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeAttribute_Source(), this.getNode(), this.getNode_OutgoingAttributes(), "source", null, 1, 1, NodeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeAttribute_TypeAttribute(), this.getNodeAttribute(), null, "typeAttribute", null, 1, 1, NodeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeAttribute_Constraints(), this.getConstraint(), this.getConstraint_NodeAttributes(), "constraints", null, 0, -1, NodeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeAttribute_Target(), this.getDataNode(), this.getDataNode_IncomingNodeAttributes(), "target", null, 1, 1, NodeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, NodeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(nodeAttributeEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(arrowAttributeEClass, ArrowAttribute.class, "ArrowAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrowAttribute_Source(), this.getArrow(), this.getArrow_OutgoingAttributes(), "source", null, 1, 1, ArrowAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowAttribute_TypeAttribute(), this.getArrowAttribute(), null, "typeAttribute", null, 1, 1, ArrowAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowAttribute_Constraints(), this.getConstraint(), this.getConstraint_ArrowAttributes(), "constraints", null, 0, -1, ArrowAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrowAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, ArrowAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrowAttribute_Target(), this.getDataNode(), this.getDataNode_IncomingArrowAtributes(), "target", null, 1, 1, ArrowAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(arrowAttributeEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mutableElementEClass, MutableElement.class, "MutableElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMutableElement_Mutability(), ecorePackage.getEInt(), "mutability", "-1", 1, 1, MutableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deepElementEClass, DeepElement.class, "DeepElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeepElement_Potency(), ecorePackage.getEInt(), "potency", "-1", 0, 1, DeepElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(validatorTypeEEnum, ValidatorType.class, "ValidatorType");
		addEEnumLiteral(validatorTypeEEnum, ValidatorType.OCL);
		addEEnumLiteral(validatorTypeEEnum, ValidatorType.JAVA);

		// Initialize data types
		initEDataType(eResourceSetEDataType, ResourceSet.class, "EResourceSet", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */ 
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore#/"
		   });
	}

} //MetamodelPackageImpl
