/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import java.util.Collection;

import no.hib.dpf.core.Specification;
import no.hib.dpf.transform.ExSpecification;
import no.hib.dpf.transform.Reduction;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transform</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getSourceMeta <em>Source Meta</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getTargetMeta <em>Target Meta</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getJointMeta <em>Joint Meta</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformImpl extends EObjectImpl implements Transform {
	/**
	 * The cached value of the '{@link #getSourceMeta() <em>Source Meta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMeta()
	 * @generated
	 * @ordered
	 */
	protected Specification sourceMeta;

	/**
	 * The cached value of the '{@link #getTargetMeta() <em>Target Meta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMeta()
	 * @generated
	 * @ordered
	 */
	protected Specification targetMeta;

	/**
	 * The cached value of the '{@link #getJointMeta() <em>Joint Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJointMeta()
	 * @generated
	 * @ordered
	 */
	protected ExSpecification jointMeta;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Reduction> rules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformPackage.Literals.TRANSFORM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification getSourceMeta() {
		if (sourceMeta != null && sourceMeta.eIsProxy()) {
			InternalEObject oldSourceMeta = (InternalEObject)sourceMeta;
			sourceMeta = (Specification)eResolveProxy(oldSourceMeta);
			if (sourceMeta != oldSourceMeta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformPackage.TRANSFORM__SOURCE_META, oldSourceMeta, sourceMeta));
			}
		}
		return sourceMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification basicGetSourceMeta() {
		return sourceMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMeta(Specification newSourceMeta) {
		Specification oldSourceMeta = sourceMeta;
		sourceMeta = newSourceMeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__SOURCE_META, oldSourceMeta, sourceMeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification getTargetMeta() {
		if (targetMeta != null && targetMeta.eIsProxy()) {
			InternalEObject oldTargetMeta = (InternalEObject)targetMeta;
			targetMeta = (Specification)eResolveProxy(oldTargetMeta);
			if (targetMeta != oldTargetMeta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformPackage.TRANSFORM__TARGET_META, oldTargetMeta, targetMeta));
			}
		}
		return targetMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification basicGetTargetMeta() {
		return targetMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMeta(Specification newTargetMeta) {
		Specification oldTargetMeta = targetMeta;
		targetMeta = newTargetMeta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__TARGET_META, oldTargetMeta, targetMeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExSpecification getJointMeta() {
		return jointMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJointMeta(ExSpecification newJointMeta, NotificationChain msgs) {
		ExSpecification oldJointMeta = jointMeta;
		jointMeta = newJointMeta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__JOINT_META, oldJointMeta, newJointMeta);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJointMeta(ExSpecification newJointMeta) {
		if (newJointMeta != jointMeta) {
			NotificationChain msgs = null;
			if (jointMeta != null)
				msgs = ((InternalEObject)jointMeta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformPackage.TRANSFORM__JOINT_META, null, msgs);
			if (newJointMeta != null)
				msgs = ((InternalEObject)newJointMeta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformPackage.TRANSFORM__JOINT_META, null, msgs);
			msgs = basicSetJointMeta(newJointMeta, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__JOINT_META, newJointMeta, newJointMeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Reduction> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Reduction>(Reduction.class, this, TransformPackage.TRANSFORM__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Specification> getMappings(Specification model, Reduction rule) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification applyReduction(Specification model, Reduction rule) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformPackage.TRANSFORM__JOINT_META:
				return basicSetJointMeta(null, msgs);
			case TransformPackage.TRANSFORM__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
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
			case TransformPackage.TRANSFORM__SOURCE_META:
				if (resolve) return getSourceMeta();
				return basicGetSourceMeta();
			case TransformPackage.TRANSFORM__TARGET_META:
				if (resolve) return getTargetMeta();
				return basicGetTargetMeta();
			case TransformPackage.TRANSFORM__JOINT_META:
				return getJointMeta();
			case TransformPackage.TRANSFORM__RULES:
				return getRules();
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
			case TransformPackage.TRANSFORM__SOURCE_META:
				setSourceMeta((Specification)newValue);
				return;
			case TransformPackage.TRANSFORM__TARGET_META:
				setTargetMeta((Specification)newValue);
				return;
			case TransformPackage.TRANSFORM__JOINT_META:
				setJointMeta((ExSpecification)newValue);
				return;
			case TransformPackage.TRANSFORM__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Reduction>)newValue);
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
			case TransformPackage.TRANSFORM__SOURCE_META:
				setSourceMeta((Specification)null);
				return;
			case TransformPackage.TRANSFORM__TARGET_META:
				setTargetMeta((Specification)null);
				return;
			case TransformPackage.TRANSFORM__JOINT_META:
				setJointMeta((ExSpecification)null);
				return;
			case TransformPackage.TRANSFORM__RULES:
				getRules().clear();
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
			case TransformPackage.TRANSFORM__SOURCE_META:
				return sourceMeta != null;
			case TransformPackage.TRANSFORM__TARGET_META:
				return targetMeta != null;
			case TransformPackage.TRANSFORM__JOINT_META:
				return jointMeta != null;
			case TransformPackage.TRANSFORM__RULES:
				return rules != null && !rules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransformImpl
