/**
 */
package no.hib.dpf.visual.impl;

import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VisualPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VArrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.visual.impl.VArrowImpl#isIsComposed <em>Is Composed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VArrowImpl extends VElementImpl implements VArrow {
	/**
	 * The default value of the '{@link #isIsComposed() <em>Is Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsComposed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COMPOSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsComposed() <em>Is Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsComposed()
	 * @generated
	 * @ordered
	 */
	protected boolean isComposed = IS_COMPOSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VArrowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisualPackage.Literals.VARROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsComposed() {
		return isComposed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsComposed(boolean newIsComposed) {
		boolean oldIsComposed = isComposed;
		isComposed = newIsComposed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualPackage.VARROW__IS_COMPOSED, oldIsComposed, isComposed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisualPackage.VARROW__IS_COMPOSED:
				return isIsComposed();
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
			case VisualPackage.VARROW__IS_COMPOSED:
				setIsComposed((Boolean)newValue);
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
			case VisualPackage.VARROW__IS_COMPOSED:
				setIsComposed(IS_COMPOSED_EDEFAULT);
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
			case VisualPackage.VARROW__IS_COMPOSED:
				return isComposed != IS_COMPOSED_EDEFAULT;
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
		result.append(" (isComposed: ");
		result.append(isComposed);
		result.append(')');
		return result.toString();
	}

} //VArrowImpl
