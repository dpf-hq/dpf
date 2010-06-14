/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.Map;

import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Homomorphism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getNodeMapping <em>Node Mapping</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getEdgeMapping <em>Edge Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphHomomorphismImpl extends EObjectImpl implements GraphHomomorphism {
	/**
	 * The cached value of the '{@link #getNodeMapping() <em>Node Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeMapping()
	 * @generated
	 * @ordered
	 */
	protected Map.Entry<Node, Node> nodeMapping;

	/**
	 * The cached value of the '{@link #getEdgeMapping() <em>Edge Mapping</em>}' reference.
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
	@SuppressWarnings("unchecked")
	public Map.Entry<Node, Node> getNodeMapping() {
		if (nodeMapping != null && ((EObject)nodeMapping).eIsProxy()) {
			InternalEObject oldNodeMapping = (InternalEObject)nodeMapping;
			nodeMapping = (Map.Entry<Node, Node>)eResolveProxy(oldNodeMapping);
			if (nodeMapping != oldNodeMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING, oldNodeMapping, nodeMapping));
			}
		}
		return nodeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Node, Node> basicGetNodeMapping() {
		return nodeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeMapping(Map.Entry<Node, Node> newNodeMapping) {
		Map.Entry<Node, Node> oldNodeMapping = nodeMapping;
		nodeMapping = newNodeMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING, oldNodeMapping, nodeMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Map.Entry<Edge, Edge> getEdgeMapping() {
		if (edgeMapping != null && ((EObject)edgeMapping).eIsProxy()) {
			InternalEObject oldEdgeMapping = (InternalEObject)edgeMapping;
			edgeMapping = (Map.Entry<Edge, Edge>)eResolveProxy(oldEdgeMapping);
			if (edgeMapping != oldEdgeMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING, oldEdgeMapping, edgeMapping));
			}
		}
		return edgeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Edge, Edge> basicGetEdgeMapping() {
		return edgeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeMapping(Map.Entry<Edge, Edge> newEdgeMapping) {
		Map.Entry<Edge, Edge> oldEdgeMapping = edgeMapping;
		edgeMapping = newEdgeMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING, oldEdgeMapping, edgeMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				if (resolve) return getNodeMapping();
				return basicGetNodeMapping();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				if (resolve) return getEdgeMapping();
				return basicGetEdgeMapping();
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				setNodeMapping((Map.Entry<Node, Node>)newValue);
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				setNodeMapping((Map.Entry<Node, Node>)null);
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				return nodeMapping != null;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				return edgeMapping != null;
		}
		return super.eIsSet(featureID);
	}

} //GraphHomomorphismImpl
