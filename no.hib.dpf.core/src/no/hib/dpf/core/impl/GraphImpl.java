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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getArrows <em>Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphImpl extends EObjectImpl implements Graph {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Graph type;

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
	 * The cached value of the '{@link #getArrows() <em>Arrows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrows()
	 * @generated
	 * @ordered
	 */
	protected EList<Arrow> arrows;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "DEFAULT_GRAPH";

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
			nodes = new EObjectContainmentEList<Node>(Node.class, this, CorePackage.GRAPH__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Graph)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.GRAPH__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Graph newType) {
		Graph oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.GRAPH__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arrow> getArrows() {
		if (arrows == null) {
			arrows = new EObjectContainmentEList<Arrow>(Arrow.class, this, CorePackage.GRAPH__ARROWS);
		}
		return arrows;
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
	 * @generated NOT
	 */
	public Node createNode(String name) {
		Node node = CoreFactory.eINSTANCE.createNode();
		node.setName(name);
		node.setTypeNode(DPFConstants.REFLEXIVE_TYPE_NODE);
		getNodes().add(node);
		return node;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow createArrow(String name, Node source, Node target) {
		testSourceAndTarget(source, target);
		
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
		testSourceAndTarget(source, target);
		if(typeArrow.getTarget() != target.getTypeNode())
		/*if (!source.arrowCanMakeConnectionAsTarget(target, typeArrow))*/ {
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
		Graph retval = CoreFactory.eINSTANCE.createDefaultGraph();
		
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
		for(Node node : getNodes())
			if(typeNodes.contains(node.getTypeNode()))
				retval.add(node);
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated COPIED
	 */
	public EList<Arrow> getArrows(EList<Arrow> types) {
		EList<Arrow> retval = new BasicEList<Arrow>();
		for(Arrow arrow : getArrows())
			if(types.contains(arrow.getTypeArrow()))
				retval.add(arrow);
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Graph getCopy() {
		Graph retval = CoreFactory.eINSTANCE.createDefaultGraph();
		for (Node node : getNodes()) {
			retval.createNode(node.getName());
		}
		for (Arrow arrow : getArrows()) {
			retval.createArrow(arrow.getName(), retval.getNodeByName(arrow.getSource().getName()), retval.getNodeByName(arrow.getTarget().getName()));
		}
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Specification getSpecification() {
		Specification result = (Specification) eContainer();
		Assert.isNotNull(result);
		return result;
	}

	/**
	 * @generated NOT
	 */
	private Arrow createArrowExec(String name, Node source, Node target) {
		Arrow arrow = CoreFactory.eINSTANCE.createArrow();
		arrow.setTypeArrow(DPFConstants.REFLEXIVE_TYPE_ARROW);
		arrow.setSource(source);
		arrow.setTarget(target);
		getArrows().add(arrow);
		arrow.setName(name);
		return arrow;
	}

	/**
	 * @generated NOT
	 */
	private void testSourceAndTarget(Node source, Node target) {
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
		 *  1) Forel�pig vil ikke predikatet ha en valideringsmetode som sier om det kan
		 *  appliseres p� nodes og arrows. TODO: lage slik. Forel�pig antar vi at dette er OK.
		 *  
		 *  2) Opprett Constraint-objekt, som m� lenkes til predikatet.
		 *  
		 *  3) Opprett ny GraphHomomorphism-objekt. Predikatet har en shape-referanse. Hvert
		 *  element i shape-en m� lenkes til et eksisterende element, hentet fra nodes og/eller
		 *  arrows.
		 * 
		 * 4) Q&D-l�sning for raske resultat: f�rste node i nodeliste -> f�rste node i shape-en etc.
		 * 
		 * Returverdien skal p� sikt brukes til � signalisere endringer i modellen til viewmodellen.
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
	@Override
	public Arrow getArrowByName(String name) {
		for (Arrow arrow : getArrows()) {
			if (arrow.getName().equals(name)) {
				return arrow;
			}
		}
		return null;
	}
	public Arrow getArrowByName(String name, String src, String trg) {
		for (Arrow arrow : getArrows()) {
			if (arrow.getName().equals(name) && arrow.getSource().getName().equals(src) && arrow.getTarget().getName().equals(trg)) {
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.GRAPH__ARROWS:
				return ((InternalEList<?>)getArrows()).basicRemove(otherEnd, msgs);
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
			case CorePackage.GRAPH__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CorePackage.GRAPH__NODES:
				return getNodes();
			case CorePackage.GRAPH__ARROWS:
				return getArrows();
			case CorePackage.GRAPH__NAME:
				return getName();
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
			case CorePackage.GRAPH__TYPE:
				setType((Graph)newValue);
				return;
			case CorePackage.GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case CorePackage.GRAPH__ARROWS:
				getArrows().clear();
				getArrows().addAll((Collection<? extends Arrow>)newValue);
				return;
			case CorePackage.GRAPH__NAME:
				setName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.GRAPH__TYPE:
				setType(DPFConstants.REFLEXIVE_TYPE_GRAPH);
				return;
			case CorePackage.GRAPH__NODES:
				getNodes().clear();
				return;
			case CorePackage.GRAPH__ARROWS:
				getArrows().clear();
				return;
			case CorePackage.GRAPH__NAME:
				name = NAME_EDEFAULT;
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.GRAPH__TYPE:
				return type != null && type != DPFConstants.REFLEXIVE_TYPE_GRAPH;
			case CorePackage.GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case CorePackage.GRAPH__ARROWS:
				return arrows != null && !arrows.isEmpty();
			case CorePackage.GRAPH__NAME:
				return name != null && !name.isEmpty() && !name.equals(NAME_EDEFAULT);
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
	@Override
	public void addNode(Node node) {
		if(node != null && !getNodes().contains(node))
			getNodes().add(node);
		
	}

	@Override
	public void addArrow(Arrow Arrow) {
		if(Arrow != null && !getArrows().contains(Arrow))
			getArrows().add(Arrow);
		
	}
	@Override
	public void removeNode(Node node) {
		if(node != null && getNodes().contains(node)){
			for(Arrow arrow : node.getIncomings())
				removeArrow(arrow);
			for(Arrow arrow : node.getOutgoings())
				removeArrow(arrow);
			getNodes().remove(node);
		}
		
	}
	
	@Override
	public void removeArrow(Arrow Arrow) {
		if(Arrow != null && getArrows().contains(Arrow)){
			Arrow.setSource(null);
			Arrow.setTarget(null);
			getArrows().remove(Arrow);
		}
		
	}
} //GraphImpl
