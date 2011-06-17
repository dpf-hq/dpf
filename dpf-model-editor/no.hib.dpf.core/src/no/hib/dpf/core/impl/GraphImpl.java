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
package no.hib.dpf.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getArrows <em>Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphImpl extends IDObjectImpl implements Graph {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArrows() <em>Arrows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrows()
	 * @generated
	 * @ordered
	 */
	protected EList<Arrow> arrows;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<Node>(Node.class, this, CorePackage.GRAPH__NODES, CorePackage.NODE__GRAPH);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.GRAPH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arrow> getArrows() {
		if (arrows == null) {
			arrows = new EObjectContainmentWithInverseEList<Arrow>(Arrow.class, this, CorePackage.GRAPH__ARROWS, CorePackage.ARROW__GRAPH);
		}
		return arrows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentWithInverseEList<Constraint>(Constraint.class, this, CorePackage.GRAPH__CONSTRAINTS, CorePackage.CONSTRAINT__GRAPH);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Node createNode(String name) {
		Node node = CoreFactory.eINSTANCE.createNode();
		node.setName(name);
		node.setGraph(this);
		return node;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow createArrow(String name, Node source, Node target) {
		testSurceAndTarget(source, target);
		
		if (!source.arrowCanMakeConnectionAsTarget(target)) {
			throw new AssertionError(String.format("The target node, %s, had the wrong type for an arrow to be connected from the node %s.", target, source));
		}
						
		Arrow arrow = createArrowExec(name, source, target);
		if ((source.getTypeNode() != null) && (target.getTypeNode() != null)) {
			arrow.setTypeArrow(source.getTypeNode().getArrowto(target.getTypeNode()));
		}
		return arrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow createArrow(String name, Node source, Node target, Arrow typeArrow) {
		testSurceAndTarget(source, target);
		if (!source.arrowCanMakeConnectionAsTarget(target, typeArrow)) {
			throw new AssertionError(String.format("The target node, %s, had the wrong type for an arrow to be connected from the node %s via the type arrow %s.", target, source, typeArrow));			
		}
		Arrow arrow = createArrowExec(name, source, target);
		arrow.setTypeArrow(typeArrow);
		return arrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Graph extractSubgraph(EList<Node> nodes, EList<Arrow> arrows) {
		Map<Node, Node> nodeMap = new HashMap<Node, Node>();
		Graph retval = CoreFactory.eINSTANCE.createGraph();
		
		for (Node node : nodes) {
			Node newNode = retval.createNode(node.getName(), node.getTypeNode());
			nodeMap.put(node, newNode);
		}
		for (Arrow arrow : arrows) {
			try {
				retval.createArrow(arrow.getName(), nodeMap.get(arrow.getSource()), nodeMap.get(arrow.getTarget()), arrow.getTypeArrow());
			} catch (Exception e) {
				throw new IllegalArgumentException("Could not create a subgraph from the submitted parameters.", e);
			}
		}
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Node> getNodesForConstraint(Constraint constraint) {
		return new BasicEList<Node>(constraint.getMappings().getNodeMapping().values());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Arrow> getArrowsForConstraint(Constraint constraint) {
		return new BasicEList<Arrow>(constraint.getMappings().getArrowMapping().values());

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Node> getNodes(EList<Node> typeNodes) {
		EList<Node> retval = new BasicEList<Node>();
		for (Node typeNode : typeNodes) {
			for (Node node : getNodes()) {
				if(node.getTypeNode().equals(typeNode)) {
					retval.add(node);
				}
			}
		}
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated COPIED
	 */
	public EList<Arrow> getArrows(EList<Arrow> types) {
		EList<Arrow> retval = new BasicEList<Arrow>();
		for (Arrow typeArrow : types) {
			for (Arrow arrow : getArrows()) {
				if(arrow.getTypeArrow().equals(typeArrow)) {
					retval.add(arrow);
				}
			}
		}
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Graph getCopy() {
		Graph retval = CoreFactory.eINSTANCE.createGraph();
		for (Node node : getNodes()) {
			retval.createNode(node.getName());
		}
		for (Arrow arrow : getArrows()) {
			retval.createArrow(arrow.getName(), retval.getNodeByName(arrow.getSource().getName()), retval.getNodeByName(arrow.getTarget().getName()));
		}
		return retval;
	}

	/**
	 * @generated NOT
	 */
	private Arrow createArrowExec(String name, Node source, Node target) {
		Arrow arrow = CoreFactory.eINSTANCE.createArrow();
		arrow.setSource(source);
		arrow.setTarget(target);
		arrow.setGraph(this);
		arrow.setName(name);
		return arrow;
	}

	/**
	 * @generated NOT
	 */
	private void testSurceAndTarget(Node source, Node target) {
		if ((source == null) || (target == null)) {
			throw new NullPointerException("Tried to create an Arrow instance with no target and/or source.");
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return 
	 * @generated NOT
	 */
	public Constraint applyPredicate(Predicate predicate, EList<Node> nodes, EList<Arrow> arrows) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
		/*
		 *  1) Forelï¿½pig vil ikke predikatet ha en valideringsmetode som sier om det kan
		 *  appliseres pï¿½ nodes og arrows. TODO: lage slik. Forelï¿½pig antar vi at dette er OK.
		 *  
		 *  2) Opprett Constraint-objekt, som mï¿½ lenkes til predikatet.
		 *  
		 *  3) Opprett ny GraphHomomorphism-objekt. Predikatet har en shape-referanse. Hvert
		 *  element i shape-en mï¿½ lenkes til et eksisterende element, hentet fra nodes og/eller
		 *  arrows.
		 * 
		 * 4) Q&D-lï¿½sning for raske resultat: fï¿½rste node i nodeliste -> fï¿½rste node i shape-en etc.
		 * 
		 * Returverdien skal pï¿½ sikt brukes til ï¿½ signalisere endringer i modellen til viewmodellen.
		 * 
		 */
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns any IDPointer member of the graph having the provided id value.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IDObject getGraphMember(String id) {
		// TODO: FIX, goddamnit!
		for (Arrow anArrow : getArrows()) {
			if (anArrow.getId().equals(id)) return anArrow;
		}		
		for (Node aNode : getNodes()) {
			if (aNode.getId().equals(id)) return aNode;
		}
		for (Constraint aConstraint : getConstraints()) {
			if (aConstraint.getId().equals(id)) return aConstraint;
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	private List<Arrow> connectedArrows(Node node) {
		List<Arrow> retval = new ArrayList<Arrow>();
		for (Arrow arrow : getArrows()) {
			if ((arrow.getSource() == node) || (arrow.getTarget() == node)) {
				retval.add(arrow);
			}
		}
		return retval;
	}

	/**
	 * @generated NOT
	 */
	private void deleteConnectedArrows(Node node) {
		for (Arrow arrow : connectedArrows(node)) {
			arrows.remove(arrow);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deleteNode(Node node) {
		if (getNodes().contains(node)) {
			deleteConnectedArrows(node);
			getNodes().remove(node);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void deleteArrow(Arrow arrow) {
		if (getArrows().contains(arrow)) {
			arrows.remove(arrow);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Node getNodeByName(String name) {
		for (Node node : getNodes()) {
			if (node.getName().equals(name)) {
				return node;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow getArrowByName(String name) {
		for (Arrow arrow : getArrows()) {
			if (arrow.getName().equals(name)) {
				return arrow;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Node createNode(String name, Node typeNode) {
		Node retval = createNode(name);
		retval.setTypeNode(typeNode);
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.GRAPH__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case CorePackage.GRAPH__ARROWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArrows()).basicAdd(otherEnd, msgs);
			case CorePackage.GRAPH__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.GRAPH__ARROWS:
				return ((InternalEList<?>)getArrows()).basicRemove(otherEnd, msgs);
			case CorePackage.GRAPH__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.GRAPH__NODES:
				return getNodes();
			case CorePackage.GRAPH__NAME:
				return getName();
			case CorePackage.GRAPH__ARROWS:
				return getArrows();
			case CorePackage.GRAPH__CONSTRAINTS:
				return getConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case CorePackage.GRAPH__NAME:
				setName((String)newValue);
				return;
			case CorePackage.GRAPH__ARROWS:
				getArrows().clear();
				getArrows().addAll((Collection<? extends Arrow>)newValue);
				return;
			case CorePackage.GRAPH__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.GRAPH__NODES:
				getNodes().clear();
				return;
			case CorePackage.GRAPH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CorePackage.GRAPH__ARROWS:
				getArrows().clear();
				return;
			case CorePackage.GRAPH__CONSTRAINTS:
				getConstraints().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case CorePackage.GRAPH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CorePackage.GRAPH__ARROWS:
				return arrows != null && !arrows.isEmpty();
			case CorePackage.GRAPH__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}


} //GraphImpl
