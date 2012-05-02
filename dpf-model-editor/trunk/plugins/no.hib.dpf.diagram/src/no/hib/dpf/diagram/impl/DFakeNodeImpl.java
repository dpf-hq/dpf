/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DFakeNode;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFake Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DFakeNodeImpl#getDConstraint <em>DConstraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DFakeNodeImpl extends DNodeImpl implements DFakeNode {
	/**
	 * The cached value of the '{@link #getDConstraint() <em>DConstraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDConstraint()
	 * @generated
	 * @ordered
	 */
	protected DConstraint dConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFakeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DFAKE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DConstraint getDConstraint() {
		if (dConstraint != null && dConstraint.eIsProxy()) {
			InternalEObject oldDConstraint = (InternalEObject)dConstraint;
			dConstraint = (DConstraint)eResolveProxy(oldDConstraint);
			if (dConstraint != oldDConstraint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DFAKE_NODE__DCONSTRAINT, oldDConstraint, dConstraint));
			}
		}
		return dConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DConstraint basicGetDConstraint() {
		return dConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDConstraint(DConstraint newDConstraint) {
		DConstraint oldDConstraint = dConstraint;
		dConstraint = newDConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DFAKE_NODE__DCONSTRAINT, oldDConstraint, dConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.DFAKE_NODE__DCONSTRAINT:
				if (resolve) return getDConstraint();
				return basicGetDConstraint();
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
			case DiagramPackage.DFAKE_NODE__DCONSTRAINT:
				setDConstraint((DConstraint)newValue);
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
			case DiagramPackage.DFAKE_NODE__DCONSTRAINT:
				setDConstraint((DConstraint)null);
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
			case DiagramPackage.DFAKE_NODE__DCONSTRAINT:
				return dConstraint != null;
		}
		return super.eIsSet(featureID);
	}

} //DFakeNodeImpl
