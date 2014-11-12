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

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.DeepElement;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getPotency <em>Potency</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getArrows <em>Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getDatanodes <em>Datanodes</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getArrowAttributes <em>Arrow Attributes</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphImpl#getNodeAttributes <em>Node Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphImpl extends IDObjectImpl implements Graph {
	
	/**
	 * The default value of the '{@link #getPotency() <em>Potency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotency()
	 * @generated
	 * @ordered
	 */
	protected static final int POTENCY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPotency() <em>Potency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotency()
	 * @generated
	 * @ordered
	 */
	protected int potency = POTENCY_EDEFAULT;

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
	 * The cached value of the '{@link #getDatanodes() <em>Datanodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatanodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataNode> datanodes;

	/**
	 * The cached value of the '{@link #getArrowAttributes() <em>Arrow Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrowAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrowAttribute> arrowAttributes;

	/**
	 * The cached value of the '{@link #getNodeAttributes() <em>Node Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeAttribute> nodeAttributes;

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
	public int getPotency() {
		return potency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPotency(int newPotency) {
		int oldPotency = potency;
		potency = newPotency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.GRAPH__POTENCY, oldPotency, potency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	public EList<DataNode> getDatanodes() {
		if (datanodes == null) {
			datanodes = new EObjectContainmentEList<DataNode>(DataNode.class, this, CorePackage.GRAPH__DATANODES);
		}
		return datanodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ArrowAttribute> getArrowAttributes() {
		if (arrowAttributes == null) {
			arrowAttributes = new EObjectContainmentEList<ArrowAttribute>(ArrowAttribute.class, this, CorePackage.GRAPH__ARROW_ATTRIBUTES);
		}
		return arrowAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeAttribute> getNodeAttributes() {
		if (nodeAttributes == null) {
			nodeAttributes = new EObjectContainmentEList<NodeAttribute>(NodeAttribute.class, this, CorePackage.GRAPH__NODE_ATTRIBUTES);
		}
		return nodeAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Node createNode(String name) {
		Node node = CoreFactory.eINSTANCE.createNode();
		node.setName(name);
		node.setTypeNode(DPFCoreConstants.REFLEXIVE_TYPE_NODE);
		getNodes().add(node);
		return node;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public EList<Node> getNodesForConstraint(Constraint constraint) {
		return new BasicEList<Node>(constraint.getMappings().getNodeMapping().values());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Arrow> getArrowsForConstraint(Constraint constraint) {
		return new BasicEList<Arrow>(constraint.getMappings().getArrowMapping().values());

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
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
	@Override
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
	@Override
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Graph getTemplateElement() {
		return getElement(SpecificationImpl.METALEVEL_EDEFAULT);
	}
	
	@Override
	public Graph getElement(int metalevel) { 
		try {
			if (getMetaLevel() == metalevel) {
				return this;
			} else if(getMetaLevel() > metalevel){
				Assert.isNotNull(getType());
				return (Graph) getType().getTemplateElement();
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	
	@Override
	public int getMetaLevel() throws NullPointerException{
		Specification spec = (Specification) eContainer();
		Assert.isNotNull(spec);
		return spec.getMetalevel();
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public boolean isTemplateElement() {
		Specification spec = (Specification)eContainer();
		if(spec.eIsSet(CorePackage.Literals.SPECIFICATION__METALEVEL)){ 
			return false; 
		}
		return true; 
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
		arrow.setTypeArrow(DPFCoreConstants.REFLEXIVE_TYPE_ARROW);
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
	@Override
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
	@Override
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
	private void deleteConnectedNodeAttributes(Node node) {
		for (NodeAttribute nodeAttribute : node.getOutgoingAttributes()) {
			nodeAttributes.remove(nodeAttribute);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void deleteNode(Node node) {
		if (getNodes().contains(node)) {
			deleteConnectedArrows(node);
			deleteConnectedNodeAttributes(node);
			getNodes().remove(node);
		}
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void deleteArrow(Arrow arrow) {
		if (getArrows().contains(arrow)) {
			deleteConnectedArrowAttributes(arrow);
			arrows.remove(arrow);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private void deleteConnectedArrowAttributes(Arrow arrow) {
		for (ArrowAttribute arrowAttribute : arrow.getOutgoingAttributes()) {
			arrowAttributes.remove(arrowAttribute);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Node getNodeByName(String name) {
		for (Node node : getNodes()) {
			if (node != null && node.getName() != null && node.getName().equals(name)) {
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
	public NodeAttribute getNodeAttributeByName(String name) {
		for (NodeAttribute nodeattribute : this.getNodeAttributes()) {
			if (nodeattribute.getName().equals(name)) {
				return nodeattribute;
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
	@Override
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
	@Override
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
			case CorePackage.GRAPH__DATANODES:
				return ((InternalEList<?>)getDatanodes()).basicRemove(otherEnd, msgs);
			case CorePackage.GRAPH__ARROW_ATTRIBUTES:
				return ((InternalEList<?>)getArrowAttributes()).basicRemove(otherEnd, msgs);
			case CorePackage.GRAPH__NODE_ATTRIBUTES:
				return ((InternalEList<?>)getNodeAttributes()).basicRemove(otherEnd, msgs);
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
			case CorePackage.GRAPH__POTENCY:
				return getPotency();
			case CorePackage.GRAPH__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case CorePackage.GRAPH__NODES:
				return getNodes();
			case CorePackage.GRAPH__ARROWS:
				return getArrows();
			case CorePackage.GRAPH__NAME:
				return getName();
			case CorePackage.GRAPH__DATANODES:
				return getDatanodes();
			case CorePackage.GRAPH__ARROW_ATTRIBUTES:
				return getArrowAttributes();
			case CorePackage.GRAPH__NODE_ATTRIBUTES:
				return getNodeAttributes();
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
			case CorePackage.GRAPH__POTENCY:
				setPotency((Integer)newValue);
				return;
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
			case CorePackage.GRAPH__DATANODES:
				getDatanodes().clear();
				getDatanodes().addAll((Collection<? extends DataNode>)newValue);
				return;
			case CorePackage.GRAPH__ARROW_ATTRIBUTES:
				getArrowAttributes().clear();
				getArrowAttributes().addAll((Collection<? extends ArrowAttribute>)newValue);
				return;
			case CorePackage.GRAPH__NODE_ATTRIBUTES:
				getNodeAttributes().clear();
				getNodeAttributes().addAll((Collection<? extends NodeAttribute>)newValue);
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
				setType(DPFCoreConstants.REFLEXIVE_TYPE_GRAPH);
				return;
			case CorePackage.GRAPH__NODES:
				getNodes().clear();
				return;
			case CorePackage.GRAPH__ARROWS:
				getArrows().clear();
				return;
			case CorePackage.GRAPH__NODE_ATTRIBUTES:
				getNodeAttributes().clear();
				return;
			case CorePackage.GRAPH__ARROW_ATTRIBUTES:
				getArrowAttributes().clear();
				return;
			case CorePackage.GRAPH__DATANODES:
				getDatanodes().clear();
				return;
			case CorePackage.GRAPH__NAME:
				name = NAME_EDEFAULT;
				return;
			case CorePackage.GRAPH__POTENCY:
				setPotency(POTENCY_EDEFAULT);
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
				return type != null && type != DPFCoreConstants.REFLEXIVE_TYPE_GRAPH;
			case CorePackage.GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case CorePackage.GRAPH__ARROWS:
				return arrows != null && !arrows.isEmpty();
			case CorePackage.GRAPH__NODE_ATTRIBUTES:
				return nodeAttributes != null && !nodeAttributes.isEmpty();
			case CorePackage.GRAPH__ARROW_ATTRIBUTES:
				return arrowAttributes != null && !arrowAttributes.isEmpty();
			case CorePackage.GRAPH__DATANODES:
				return datanodes != null && !datanodes.isEmpty();
			case CorePackage.GRAPH__NAME:
				return name != null && !name.isEmpty() && !name.equals(NAME_EDEFAULT);
			case CorePackage.GRAPH__POTENCY:
				return potency != POTENCY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DeepElement.class) {
			switch (derivedFeatureID) {
				case CorePackage.GRAPH__POTENCY: return CorePackage.DEEP_ELEMENT__POTENCY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DeepElement.class) {
			switch (baseFeatureID) {
				case CorePackage.DEEP_ELEMENT__POTENCY: return CorePackage.GRAPH__POTENCY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (potency: ");
		result.append(potency);
		result.append(", name: ");
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
			for(Arrow arrow : node.getIncomings()){
				removeArrow(arrow);
			}
			
			for(Arrow arrow : node.getOutgoings()){
				removeArrow(arrow);
			}
			
			for (NodeAttribute nodeAttribute : node.getOutgoingAttributes()) {
				nodeAttribute.setSource(null);
				nodeAttribute.setTarget(null);
				getNodeAttributes().remove(nodeAttribute);
			}
			
			getNodes().remove(node);
		}
		
	}
	
	@Override
	public void removeArrow(Arrow Arrow) {
		if(Arrow != null && getArrows().contains(Arrow)){
			
			for (ArrowAttribute arrowAttribute : Arrow.getOutgoingAttributes()) {
				arrowAttribute.setSource(null);
				arrowAttribute.setTarget(null);
				getArrowAttributes().remove(arrowAttribute);
			}
			
			Arrow.setSource(null);
			Arrow.setTarget(null);
			getArrows().remove(Arrow);
		}
	}

	@Override 
	public void addDataNode(DataNode datanode) {
		if(datanode != null && !getDatanodes().contains(datanode))
			getDatanodes().add(datanode);
	}

	@Override
	public void addNodeAttribute(NodeAttribute nodeAttribute) {
		if(nodeAttribute != null && !getNodeAttributes().contains(nodeAttribute))
			getNodeAttributes().add(nodeAttribute);
	}
	
	@Override
	public void addArrowAttribute(ArrowAttribute arrowAttribute) {
		if(arrowAttribute != null && !getArrowAttributes().contains(arrowAttribute))
			getArrowAttributes().add(arrowAttribute);
	}
} //GraphImpl
