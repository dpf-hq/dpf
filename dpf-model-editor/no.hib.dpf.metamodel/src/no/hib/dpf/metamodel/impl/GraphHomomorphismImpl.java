/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.Map;

import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelPackage;

import no.hib.dpf.metamodel.Node;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Homomorphism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getNodeMapping <em>Node Mapping</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getEdgeMapping <em>Edge Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphHomomorphismImpl extends EObjectImpl implements GraphHomomorphism {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Graph source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Graph target;

	/**
	 * The cached value of the '{@link #getNodeMapping() <em>Node Mapping</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeMapping()
	 * @generated
	 * @ordered
	 */
	protected EMap<Node, Node> nodeMapping;

	/**
	 * The cached value of the '{@link #getEdgeMapping() <em>Edge Mapping</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeMapping()
	 * @generated
	 * @ordered
	 */
	protected Map.Entry<Edge, Edge> edgeMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphHomomorphismImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.GRAPH_HOMOMORPHISM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Graph)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Graph newSource) {
		Graph oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Graph)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Graph newTarget) {
		Graph oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Node, Node> getNodeMapping() {
		if (nodeMapping == null) {
			nodeMapping = new EcoreEMap<Node,Node>(MetamodelPackage.Literals.NODE_TO_NODE_MAP, NodeToNodeMapImpl.class, this, MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING);
		}
		return nodeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Edge, Edge> getEdgeMapping() {
		return edgeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEdgeMapping(Map.Entry<Edge, Edge> newEdgeMapping, NotificationChain msgs) {
		Map.Entry<Edge, Edge> oldEdgeMapping = edgeMapping;
		edgeMapping = newEdgeMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING, oldEdgeMapping, newEdgeMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeMapping(Map.Entry<Edge, Edge> newEdgeMapping) {
		if (newEdgeMapping != edgeMapping) {
			NotificationChain msgs = null;
			if (edgeMapping != null)
				msgs = ((InternalEObject)edgeMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING, null, msgs);
			if (newEdgeMapping != null)
				msgs = ((InternalEObject)newEdgeMapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING, null, msgs);
			msgs = basicSetEdgeMapping(newEdgeMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING, newEdgeMapping, newEdgeMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				return ((InternalEList<?>)getNodeMapping()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				return basicSetEdgeMapping(null, msgs);
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				if (coreType) return getNodeMapping();
				else return getNodeMapping().map();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				return getEdgeMapping();
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE:
				setSource((Graph)newValue);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET:
				setTarget((Graph)newValue);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				((EStructuralFeature.Setting)getNodeMapping()).set(newValue);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				setEdgeMapping((Map.Entry<Edge, Edge>)newValue);
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE:
				setSource((Graph)null);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET:
				setTarget((Graph)null);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				getNodeMapping().clear();
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				setEdgeMapping((Map.Entry<Edge, Edge>)null);
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE:
				return source != null;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET:
				return target != null;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				return nodeMapping != null && !nodeMapping.isEmpty();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				return edgeMapping != null;
		}
		return super.eIsSet(featureID);
	}

} //GraphHomomorphismImpl
