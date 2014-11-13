/**
 */
package no.hib.dpf.visual.impl;

import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.VisualPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.visual.impl.VNodeImpl#isComposite <em>Composite</em>}</li>
 *   <li>{@link no.hib.dpf.visual.impl.VNodeImpl#getColor <em>Color</em>}</li>
 *   <li>{@link no.hib.dpf.visual.impl.VNodeImpl#isRounded <em>Rounded</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VNodeImpl extends VElementImpl implements VNode {
	/**
	 * The default value of the '{@link #isComposite() <em>Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isComposite() <em>Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposite()
	 * @generated
	 * @ordered
	 */
	protected boolean composite = COMPOSITE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final RGB COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected RGB color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #isRounded() <em>Rounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRounded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ROUNDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRounded() <em>Rounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRounded()
	 * @generated
	 * @ordered
	 */
	protected boolean rounded = ROUNDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisualPackage.Literals.VNODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposite() {
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposite(boolean newComposite) {
		boolean oldComposite = composite;
		composite = newComposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualPackage.VNODE__COMPOSITE, oldComposite, composite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RGB getColor() {
		if (color == null)
			color = new RGB(255,255,255);
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(RGB newColor) {
		RGB oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualPackage.VNODE__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRounded() {
		return rounded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRounded(boolean newRounded) {
		boolean oldRounded = rounded;
		rounded = newRounded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualPackage.VNODE__ROUNDED, oldRounded, rounded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisualPackage.VNODE__COMPOSITE:
				return isComposite();
			case VisualPackage.VNODE__COLOR:
				return getColor();
			case VisualPackage.VNODE__ROUNDED:
				return isRounded();
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
			case VisualPackage.VNODE__COMPOSITE:
				setComposite((Boolean)newValue);
				return;
			case VisualPackage.VNODE__COLOR:
				setColor((RGB)newValue);
				return;
			case VisualPackage.VNODE__ROUNDED:
				setRounded((Boolean)newValue);
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
			case VisualPackage.VNODE__COMPOSITE:
				setComposite(COMPOSITE_EDEFAULT);
				return;
			case VisualPackage.VNODE__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case VisualPackage.VNODE__ROUNDED:
				setRounded(ROUNDED_EDEFAULT);
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
			case VisualPackage.VNODE__COMPOSITE:
				return composite != COMPOSITE_EDEFAULT;
			case VisualPackage.VNODE__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case VisualPackage.VNODE__ROUNDED:
				return rounded != ROUNDED_EDEFAULT;
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
		result.append(" (composite: ");
		result.append(composite);
		result.append(", color: ");
		result.append(color);
		result.append(", rounded: ");
		result.append(rounded);
		result.append(')');
		return result.toString();
	}

} //VNodeImpl
