/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.IDObject;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Node;
import no.hib.dpf.metamodel.Predicate;

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
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphImpl#getArrows <em>Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphImpl#getConstraints <em>Constraints</em>}</li>
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
		return MetamodelPackage.Literals.GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<Node>(Node.class, this, MetamodelPackage.GRAPH__NODES, MetamodelPackage.NODE__GRAPH);
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
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arrow> getArrows() {
		if (arrows == null) {
			arrows = new EObjectContainmentWithInverseEList<Arrow>(Arrow.class, this, MetamodelPackage.GRAPH__ARROWS, MetamodelPackage.ARROW__GRAPH);
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
			constraints = new EObjectContainmentWithInverseEList<Constraint>(Constraint.class, this, MetamodelPackage.GRAPH__CONSTRAINTS, MetamodelPackage.CONSTRAINT__GRAPH);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Node createNode(String name) {
		Node node = MetamodelFactory.eINSTANCE.createNode();
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
		Graph retval = MetamodelFactory.eINSTANCE.createGraph();
		
		for (Node node : nodes) {
			Node newNode = retval.createNode(node.getName(), node);
			nodeMap.put(node, newNode);
		}
		for (Arrow arrow : arrows) {
			try {
				retval.createArrow(arrow.getName(), nodeMap.get(arrow.getSource()), nodeMap.get(arrow.getTarget()), arrow);
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
	 * @generated NOT
	 */
	private Arrow createArrowExec(String name, Node source, Node target) {
		Arrow arrow = MetamodelFactory.eINSTANCE.createArrow();
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
			case MetamodelPackage.GRAPH__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case MetamodelPackage.GRAPH__ARROWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArrows()).basicAdd(otherEnd, msgs);
			case MetamodelPackage.GRAPH__CONSTRAINTS:
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
			case MetamodelPackage.GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.GRAPH__ARROWS:
				return ((InternalEList<?>)getArrows()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.GRAPH__CONSTRAINTS:
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
			case MetamodelPackage.GRAPH__NODES:
				return getNodes();
			case MetamodelPackage.GRAPH__NAME:
				return getName();
			case MetamodelPackage.GRAPH__ARROWS:
				return getArrows();
			case MetamodelPackage.GRAPH__CONSTRAINTS:
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
			case MetamodelPackage.GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case MetamodelPackage.GRAPH__NAME:
				setName((String)newValue);
				return;
			case MetamodelPackage.GRAPH__ARROWS:
				getArrows().clear();
				getArrows().addAll((Collection<? extends Arrow>)newValue);
				return;
			case MetamodelPackage.GRAPH__CONSTRAINTS:
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
			case MetamodelPackage.GRAPH__NODES:
				getNodes().clear();
				return;
			case MetamodelPackage.GRAPH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MetamodelPackage.GRAPH__ARROWS:
				getArrows().clear();
				return;
			case MetamodelPackage.GRAPH__CONSTRAINTS:
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
			case MetamodelPackage.GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case MetamodelPackage.GRAPH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MetamodelPackage.GRAPH__ARROWS:
				return arrows != null && !arrows.isEmpty();
			case MetamodelPackage.GRAPH__CONSTRAINTS:
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
