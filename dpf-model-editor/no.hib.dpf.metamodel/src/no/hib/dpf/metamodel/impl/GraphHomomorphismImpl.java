/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.Collection;
import java.util.Map;

import java.util.Map.Entry;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

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
	protected EMap<Edge, Edge> edgeMapping;

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
	@SuppressWarnings("unchecked")
	public EMap<Edge, Edge> getEdgeMapping() {
		if (edgeMapping == null) {
			edgeMapping = new EcoreEMap<Edge,Edge>(MetamodelPackage.Literals.EDGE_TO_EDGE_MAP, EdgeToEdgeMapImpl.class, this, MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING);
		}
		return edgeMapping;
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
				return ((InternalEList<?>)getEdgeMapping()).basicRemove(otherEnd, msgs);
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				if (coreType) return getNodeMapping();
				else return getNodeMapping().map();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				if (coreType) return getEdgeMapping();
				else return getEdgeMapping().map();
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
				((EStructuralFeature.Setting)getNodeMapping()).set(newValue);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				((EStructuralFeature.Setting)getEdgeMapping()).set(newValue);
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
				getNodeMapping().clear();
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				getEdgeMapping().clear();
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
				return nodeMapping != null && !nodeMapping.isEmpty();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				return edgeMapping != null && !edgeMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GraphHomomorphismImpl
