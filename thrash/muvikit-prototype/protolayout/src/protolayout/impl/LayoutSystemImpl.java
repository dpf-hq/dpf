/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package protolayout.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import protolayout.LayoutSystem;
import protolayout.NodeLayout;
import protolayout.ProtolayoutPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link protolayout.impl.LayoutSystemImpl#getNodeLayouts <em>Node Layouts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayoutSystemImpl extends EObjectImpl implements LayoutSystem {
	/**
	 * The cached value of the '{@link #getNodeLayouts() <em>Node Layouts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeLayouts()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeLayout> nodeLayouts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LayoutSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtolayoutPackage.Literals.LAYOUT_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeLayout> getNodeLayouts() {
		if (nodeLayouts == null) {
			nodeLayouts = new EObjectContainmentEList<NodeLayout>(NodeLayout.class, this, ProtolayoutPackage.LAYOUT_SYSTEM__NODE_LAYOUTS);
		}
		return nodeLayouts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProtolayoutPackage.LAYOUT_SYSTEM__NODE_LAYOUTS:
				return ((InternalEList<?>)getNodeLayouts()).basicRemove(otherEnd, msgs);
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
			case ProtolayoutPackage.LAYOUT_SYSTEM__NODE_LAYOUTS:
				return getNodeLayouts();
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
			case ProtolayoutPackage.LAYOUT_SYSTEM__NODE_LAYOUTS:
				getNodeLayouts().clear();
				getNodeLayouts().addAll((Collection<? extends NodeLayout>)newValue);
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
			case ProtolayoutPackage.LAYOUT_SYSTEM__NODE_LAYOUTS:
				getNodeLayouts().clear();
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
			case ProtolayoutPackage.LAYOUT_SYSTEM__NODE_LAYOUTS:
				return nodeLayouts != null && !nodeLayouts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LayoutSystemImpl
