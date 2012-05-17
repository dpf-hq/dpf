/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import no.hib.dpf.transform.Copied;
import no.hib.dpf.transform.CopiedType;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Copied</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.impl.CopiedImpl#getCopiedType <em>Copied Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CopiedImpl extends EObjectImpl implements Copied {
	/**
	 * The default value of the '{@link #getCopiedType() <em>Copied Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopiedType()
	 * @generated
	 * @ordered
	 */
	protected static final CopiedType COPIED_TYPE_EDEFAULT = CopiedType.SOURCE;

	/**
	 * The cached value of the '{@link #getCopiedType() <em>Copied Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopiedType()
	 * @generated
	 * @ordered
	 */
	protected CopiedType copiedType = COPIED_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopiedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformPackage.Literals.COPIED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopiedType getCopiedType() {
		return copiedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopiedType(CopiedType newCopiedType) {
		CopiedType oldCopiedType = copiedType;
		copiedType = newCopiedType == null ? COPIED_TYPE_EDEFAULT : newCopiedType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.COPIED__COPIED_TYPE, oldCopiedType, copiedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransformPackage.COPIED__COPIED_TYPE:
				return getCopiedType();
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
			case TransformPackage.COPIED__COPIED_TYPE:
				setCopiedType((CopiedType)newValue);
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
			case TransformPackage.COPIED__COPIED_TYPE:
				setCopiedType(COPIED_TYPE_EDEFAULT);
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
			case TransformPackage.COPIED__COPIED_TYPE:
				return copiedType != COPIED_TYPE_EDEFAULT;
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
		result.append(" (copiedType: ");
		result.append(copiedType);
		result.append(')');
		return result.toString();
	}

} //CopiedImpl
