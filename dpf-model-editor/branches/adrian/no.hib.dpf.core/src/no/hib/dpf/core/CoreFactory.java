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

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.core.CorePackage
 * @generated
 */
public interface CoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoreFactory eINSTANCE = no.hib.dpf.core.impl.CoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph</em>'.
	 * @generated
	 */
	Graph createGraph();

	/**
	 * Returns a new object of class '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This is intended as a quick way of generating Graph instances using string parameters for
	 * nodes and edges.
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph</em>'.
	 * @generated NOT
	 */
	Graph createGraph(String nodes, String edges);
	
	/**
	 * Returns a new object of class '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This is intended as a quick way of generating Graph instances using string parameters for
	 * nodes and edges. String formats: "gn1,gn2", "ge1:gn1:gn2"
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph</em>'.
	 * @generated NOT
	 */
	Graph createGraph(String name, String nodes, String edges);
	
	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node</em>'.
	 * @generated
	 */
	Node createNode();

	/**
	 * Returns a new object of class '<em>Arrow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arrow</em>'.
	 * @generated
	 */
	Arrow createArrow();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node</em>'.
	 * @generated NOT
	 */
	Node createNode(Node typeNode);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	Arrow createArrow(Arrow typeArrow);
	
	/**
	 * Returns a new object of class '<em>Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signature</em>'.
	 * @generated
	 */
	Signature createSignature();

	/**
	 * Returns a new object of class '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate</em>'.
	 * @generated
	 */
	Predicate createPredicate();

	/**
	 * Returns a new object of class '<em>Semantics Validator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantics Validator</em>'.
	 * @generated
	 */
	SemanticsValidator createSemanticsValidator();

	/**
	 * Returns a new object of class '<em>Visualization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visualization</em>'.
	 * @generated
	 */
	Visualization createVisualization();

	/**
	 * Returns a new object of class '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * shapeDescription is used to construct a graph. See createGraph().
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate</em>'.
	 * @generated NOT
	 */
	Predicate createPredicate(String nodes, String edges);

	/**
	 * Returns a new object of class '<em>Predicate</em>'.
	 * @return a new object of class '<em>Predicate</em>'.
	 * @generated NOT
	 */
	Predicate createPredicate(String symbol, String nodes, String edges);
	
	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Typing Morphism</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typing Morphism</em>'.
	 * @generated
	 */
	TypingMorphism createTypingMorphism();

	/**
	 * Returns a new object of class '<em>Graph Homomorphism</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph Homomorphism</em>'.
	 * @generated
	 */
	GraphHomomorphism createGraphHomomorphism();

	/**
	 * Returns a new object of class '<em>Graph Homomorphism</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph Homomorphism</em>'.
	 * @generated NOT
	 */
	GraphHomomorphism createGraphHomomorphism(EMap<Node, Node> nodeMap, EMap<Arrow, Arrow> edgeMap);
	
	/**
	 * Returns a new object of class '<em>ID Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ID Object</em>'.
	 * @generated
	 */
	IDObject createIDObject();

	/**
	 * Returns a new object of class '<em>Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specification</em>'.
	 * @generated
	 */
	Specification createSpecification();

	/**
	 * Returns a new object of class '<em>Model Hierarchy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Hierarchy</em>'.
	 * @generated
	 */
	ModelHierarchy createModelHierarchy();

	/**
	 * Returns a new object of class '<em>Jointly Surjective Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Jointly Surjective Semantics</em>'.
	 * @generated
	 */
	JointlySurjectiveSemantics createJointlySurjectiveSemantics();

	/**
	 * Returns a new object of class '<em>Inverse Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inverse Semantics</em>'.
	 * @generated
	 */
	InverseSemantics createInverseSemantics();

	/**
	 * Returns a new object of class '<em>Irreflexive Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Irreflexive Semantics</em>'.
	 * @generated
	 */
	IrreflexiveSemantics createIrreflexiveSemantics();

	/**
	 * Returns a new object of class '<em>Multiplicity Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicity Semantics</em>'.
	 * @generated
	 */
	MultiplicitySemantics createMultiplicitySemantics();

	/**
	 * Returns a new object of class '<em>XOR Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XOR Semantics</em>'.
	 * @generated
	 */
	XORSemantics createXORSemantics();

	/**
	 * Returns a new object of class '<em>Transitive Irreflexive Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transitive Irreflexive Semantics</em>'.
	 * @generated
	 */
	TransitiveIrreflexiveSemantics createTransitiveIrreflexiveSemantics();

	/**
	 * Returns a new object of class '<em>Surjective Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Surjective Semantics</em>'.
	 * @generated
	 */
	SurjectiveSemantics createSurjectiveSemantics();

	/**
	 * Returns a new object of class '<em>NAND Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>NAND Semantics</em>'.
	 * @generated
	 */
	NANDSemantics createNANDSemantics();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CorePackage getCorePackage();

} //CoreFactory
