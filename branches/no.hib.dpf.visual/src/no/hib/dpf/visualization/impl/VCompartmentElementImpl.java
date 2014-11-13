/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.visualization.impl;

import no.hib.dpf.diagram.DNode;

import no.hib.dpf.visual.impl.VElementImpl;

import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VCompartment Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.visualization.impl.VCompartmentElementImpl#getDNode <em>DNode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VCompartmentElementImpl extends VElementImpl implements VCompartmentElement {
	/**
	 * The cached value of the '{@link #getDNode() <em>DNode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNode()
	 * @generated
	 * @ordered
	 */
	protected DNode dNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VCompartmentElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisualizationPackage.Literals.VCOMPARTMENT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode getDNode() {
		if (dNode != null && dNode.eIsProxy()) {
			InternalEObject oldDNode = (InternalEObject)dNode;
			dNode = (DNode)eResolveProxy(oldDNode);
			if (dNode != oldDNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisualizationPackage.VCOMPARTMENT_ELEMENT__DNODE, oldDNode, dNode));
			}
		}
		return dNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode basicGetDNode() {
		return dNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDNode(DNode newDNode) {
		DNode oldDNode = dNode;
		dNode = newDNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualizationPackage.VCOMPARTMENT_ELEMENT__DNODE, oldDNode, dNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisualizationPackage.VCOMPARTMENT_ELEMENT__DNODE:
				if (resolve) return getDNode();
				return basicGetDNode();
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
			case VisualizationPackage.VCOMPARTMENT_ELEMENT__DNODE:
				setDNode((DNode)newValue);
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
			case VisualizationPackage.VCOMPARTMENT_ELEMENT__DNODE:
				setDNode((DNode)null);
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
			case VisualizationPackage.VCOMPARTMENT_ELEMENT__DNODE:
				return dNode != null;
		}
		return super.eIsSet(featureID);
	}

} //VCompartmentElementImpl
