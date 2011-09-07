/**
 * <copyright>
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.util;

import java.util.Map;

import no.hib.dpf.core.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.core.CorePackage
 * @generated
 */
public class CoreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreSwitch<Adapter> modelSwitch =
		new CoreSwitch<Adapter>() {
			@Override
			public Adapter caseGraph(Graph object) {
				return createGraphAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseArrow(Arrow object) {
				return createArrowAdapter();
			}
			@Override
			public Adapter caseSignature(Signature object) {
				return createSignatureAdapter();
			}
			@Override
			public Adapter casePredicate(Predicate object) {
				return createPredicateAdapter();
			}
			@Override
			public Adapter caseSemanticsValidator(SemanticsValidator object) {
				return createSemanticsValidatorAdapter();
			}
			@Override
			public Adapter caseVisualization(Visualization object) {
				return createVisualizationAdapter();
			}
			@Override
			public Adapter caseNodeToNodeMap(Map.Entry<Node, Node> object) {
				return createNodeToNodeMapAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseArrowToArrowMap(Map.Entry<Arrow, Arrow> object) {
				return createArrowToArrowMapAdapter();
			}
			@Override
			public Adapter caseTypingMorphism(TypingMorphism object) {
				return createTypingMorphismAdapter();
			}
			@Override
			public Adapter caseGraphHomomorphism(GraphHomomorphism object) {
				return createGraphHomomorphismAdapter();
			}
			@Override
			public Adapter caseIDObject(IDObject object) {
				return createIDObjectAdapter();
			}
			@Override
			public Adapter caseSpecification(Specification object) {
				return createSpecificationAdapter();
			}
			@Override
			public Adapter caseModelHierarchy(ModelHierarchy object) {
				return createModelHierarchyAdapter();
			}
			@Override
			public Adapter caseJointlySurjectiveSemantics(JointlySurjectiveSemantics object) {
				return createJointlySurjectiveSemanticsAdapter();
			}
			@Override
			public Adapter caseInverseSemantics(InverseSemantics object) {
				return createInverseSemanticsAdapter();
			}
			@Override
			public Adapter caseIrreflexiveSemantics(IrreflexiveSemantics object) {
				return createIrreflexiveSemanticsAdapter();
			}
			@Override
			public Adapter caseMultiplicitySemantics(MultiplicitySemantics object) {
				return createMultiplicitySemanticsAdapter();
			}
			@Override
			public Adapter caseXORSemantics(XORSemantics object) {
				return createXORSemanticsAdapter();
			}
			@Override
			public Adapter caseTransitiveIrreflexiveSemantics(TransitiveIrreflexiveSemantics object) {
				return createTransitiveIrreflexiveSemanticsAdapter();
			}
			@Override
			public Adapter caseSurjectiveSemantics(SurjectiveSemantics object) {
				return createSurjectiveSemanticsAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.Graph
	 * @generated
	 */
	public Adapter createGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.Arrow <em>Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.Arrow
	 * @generated
	 */
	public Adapter createArrowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.Signature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.Signature
	 * @generated
	 */
	public Adapter createSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.Predicate
	 * @generated
	 */
	public Adapter createPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.SemanticsValidator <em>Semantics Validator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.SemanticsValidator
	 * @generated
	 */
	public Adapter createSemanticsValidatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.Visualization <em>Visualization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.Visualization
	 * @generated
	 */
	public Adapter createVisualizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Node To Node Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createNodeToNodeMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Arrow To Arrow Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createArrowToArrowMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.TypingMorphism <em>Typing Morphism</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.TypingMorphism
	 * @generated
	 */
	public Adapter createTypingMorphismAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.GraphHomomorphism <em>Graph Homomorphism</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.GraphHomomorphism
	 * @generated
	 */
	public Adapter createGraphHomomorphismAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.IDObject <em>ID Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.IDObject
	 * @generated
	 */
	public Adapter createIDObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.Specification
	 * @generated
	 */
	public Adapter createSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.ModelHierarchy <em>Model Hierarchy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.ModelHierarchy
	 * @generated
	 */
	public Adapter createModelHierarchyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.JointlySurjectiveSemantics <em>Jointly Surjective Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.JointlySurjectiveSemantics
	 * @generated
	 */
	public Adapter createJointlySurjectiveSemanticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.InverseSemantics <em>Inverse Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.InverseSemantics
	 * @generated
	 */
	public Adapter createInverseSemanticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.IrreflexiveSemantics <em>Irreflexive Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.IrreflexiveSemantics
	 * @generated
	 */
	public Adapter createIrreflexiveSemanticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.MultiplicitySemantics <em>Multiplicity Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.MultiplicitySemantics
	 * @generated
	 */
	public Adapter createMultiplicitySemanticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.XORSemantics <em>XOR Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.XORSemantics
	 * @generated
	 */
	public Adapter createXORSemanticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.TransitiveIrreflexiveSemantics <em>Transitive Irreflexive Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.TransitiveIrreflexiveSemantics
	 * @generated
	 */
	public Adapter createTransitiveIrreflexiveSemanticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.core.SurjectiveSemantics <em>Surjective Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.core.SurjectiveSemantics
	 * @generated
	 */
	public Adapter createSurjectiveSemanticsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MetamodelAdapterFactory
