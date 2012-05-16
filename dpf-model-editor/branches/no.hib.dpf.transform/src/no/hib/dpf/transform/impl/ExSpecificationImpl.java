/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import no.hib.dpf.core.impl.SpecificationImpl;
import no.hib.dpf.transform.ExGraph;
import no.hib.dpf.transform.ExSpecification;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ex Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.impl.ExSpecificationImpl#getExgraph <em>Exgraph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExSpecificationImpl extends SpecificationImpl implements ExSpecification {
	/**
	 * The cached value of the '{@link #getExgraph() <em>Exgraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExgraph()
	 * @generated
	 * @ordered
	 */
	protected ExGraph exgraph;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformPackage.Literals.EX_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExGraph getExgraph() {
		return exgraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExgraph(ExGraph newExgraph, NotificationChain msgs) {
		ExGraph oldExgraph = exgraph;
		exgraph = newExgraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformPackage.EX_SPECIFICATION__EXGRAPH, oldExgraph, newExgraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExgraph(ExGraph newExgraph) {
		if (newExgraph != exgraph) {
			NotificationChain msgs = null;
			if (exgraph != null)
				msgs = ((InternalEObject)exgraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformPackage.EX_SPECIFICATION__EXGRAPH, null, msgs);
			if (newExgraph != null)
				msgs = ((InternalEObject)newExgraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformPackage.EX_SPECIFICATION__EXGRAPH, null, msgs);
			msgs = basicSetExgraph(newExgraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.EX_SPECIFICATION__EXGRAPH, newExgraph, newExgraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformPackage.EX_SPECIFICATION__EXGRAPH:
				return basicSetExgraph(null, msgs);
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
			case TransformPackage.EX_SPECIFICATION__EXGRAPH:
				return getExgraph();
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
			case TransformPackage.EX_SPECIFICATION__EXGRAPH:
				setExgraph((ExGraph)newValue);
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
			case TransformPackage.EX_SPECIFICATION__EXGRAPH:
				setExgraph((ExGraph)null);
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
			case TransformPackage.EX_SPECIFICATION__EXGRAPH:
				return exgraph != null;
		}
		return super.eIsSet(featureID);
	}

} //ExSpecificationImpl
