/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Signature;
import no.hib.dpf.metamodel.Specification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.SpecificationImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.SpecificationImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.SpecificationImpl#getTypeGraph <em>Type Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationImpl extends EObjectImpl implements Specification {
	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected Signature signature;

	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph graph;

	/**
	 * The cached value of the '{@link #getTypeGraph() <em>Type Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph typeGraph;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature getSignature() {
		if (signature != null && signature.eIsProxy()) {
			InternalEObject oldSignature = (InternalEObject)signature;
			signature = (Signature)eResolveProxy(oldSignature);
			if (signature != oldSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.SPECIFICATION__SIGNATURE, oldSignature, signature));
			}
		}
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(Signature newSignature) {
		Signature oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SPECIFICATION__SIGNATURE, oldSignature, signature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (graph != null && graph.eIsProxy()) {
			InternalEObject oldGraph = (InternalEObject)graph;
			graph = (Graph)eResolveProxy(oldGraph);
			if (graph != oldGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.SPECIFICATION__GRAPH, oldGraph, graph));
			}
		}
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetGraph() {
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		Graph oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SPECIFICATION__GRAPH, oldGraph, graph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getTypeGraph() {
		if (typeGraph != null && typeGraph.eIsProxy()) {
			InternalEObject oldTypeGraph = (InternalEObject)typeGraph;
			typeGraph = (Graph)eResolveProxy(oldTypeGraph);
			if (typeGraph != oldTypeGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.SPECIFICATION__TYPE_GRAPH, oldTypeGraph, typeGraph));
			}
		}
		return typeGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetTypeGraph() {
		return typeGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeGraph(Graph newTypeGraph) {
		Graph oldTypeGraph = typeGraph;
		typeGraph = newTypeGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.SPECIFICATION__TYPE_GRAPH, oldTypeGraph, typeGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.SPECIFICATION__SIGNATURE:
				if (resolve) return getSignature();
				return basicGetSignature();
			case MetamodelPackage.SPECIFICATION__GRAPH:
				if (resolve) return getGraph();
				return basicGetGraph();
			case MetamodelPackage.SPECIFICATION__TYPE_GRAPH:
				if (resolve) return getTypeGraph();
				return basicGetTypeGraph();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.SPECIFICATION__SIGNATURE:
				setSignature((Signature)newValue);
				return;
			case MetamodelPackage.SPECIFICATION__GRAPH:
				setGraph((Graph)newValue);
				return;
			case MetamodelPackage.SPECIFICATION__TYPE_GRAPH:
				setTypeGraph((Graph)newValue);
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
			case MetamodelPackage.SPECIFICATION__SIGNATURE:
				setSignature((Signature)null);
				return;
			case MetamodelPackage.SPECIFICATION__GRAPH:
				setGraph((Graph)null);
				return;
			case MetamodelPackage.SPECIFICATION__TYPE_GRAPH:
				setTypeGraph((Graph)null);
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
			case MetamodelPackage.SPECIFICATION__SIGNATURE:
				return signature != null;
			case MetamodelPackage.SPECIFICATION__GRAPH:
				return graph != null;
			case MetamodelPackage.SPECIFICATION__TYPE_GRAPH:
				return typeGraph != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecificationImpl
