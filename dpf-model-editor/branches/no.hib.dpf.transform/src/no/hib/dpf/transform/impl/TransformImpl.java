/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import java.util.Collection;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.transform.Production;
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
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getMetaModel <em>Meta Model</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getDSignature <em>DSignature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformImpl extends EObjectImpl implements Transform {
	/**
	 * The cached value of the '{@link #getMetaModel() <em>Meta Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaModel()
	 * @generated
	 * @ordered
	 */
	protected DSpecification metaModel;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Production> rules;

	/**
	 * The cached value of the '{@link #getDSignature() <em>DSignature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDSignature()
	 * @generated
	 * @ordered
	 */
	protected DSignature dSignature;

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
	public DSpecification getMetaModel() {
		return metaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetaModel(DSpecification newMetaModel, NotificationChain msgs) {
		DSpecification oldMetaModel = metaModel;
		metaModel = newMetaModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__META_MODEL, oldMetaModel, newMetaModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaModel(DSpecification newMetaModel) {
		if (newMetaModel != metaModel) {
			NotificationChain msgs = null;
			if (metaModel != null)
				msgs = ((InternalEObject)metaModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformPackage.TRANSFORM__META_MODEL, null, msgs);
			if (newMetaModel != null)
				msgs = ((InternalEObject)newMetaModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformPackage.TRANSFORM__META_MODEL, null, msgs);
			msgs = basicSetMetaModel(newMetaModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__META_MODEL, newMetaModel, newMetaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Production> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Production>(Production.class, this, TransformPackage.TRANSFORM__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSignature getDSignature() {
		if (dSignature != null && dSignature.eIsProxy()) {
			InternalEObject oldDSignature = (InternalEObject)dSignature;
			dSignature = (DSignature)eResolveProxy(oldDSignature);
			if (dSignature != oldDSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformPackage.TRANSFORM__DSIGNATURE, oldDSignature, dSignature));
			}
		}
		return dSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSignature basicGetDSignature() {
		return dSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDSignature(DSignature newDSignature) {
		DSignature oldDSignature = dSignature;
		dSignature = newDSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__DSIGNATURE, oldDSignature, dSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformPackage.TRANSFORM__META_MODEL:
				return basicSetMetaModel(null, msgs);
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
			case TransformPackage.TRANSFORM__META_MODEL:
				return getMetaModel();
			case TransformPackage.TRANSFORM__RULES:
				return getRules();
			case TransformPackage.TRANSFORM__DSIGNATURE:
				if (resolve) return getDSignature();
				return basicGetDSignature();
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
			case TransformPackage.TRANSFORM__META_MODEL:
				setMetaModel((DSpecification)newValue);
				return;
			case TransformPackage.TRANSFORM__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Production>)newValue);
				return;
			case TransformPackage.TRANSFORM__DSIGNATURE:
				setDSignature((DSignature)newValue);
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
			case TransformPackage.TRANSFORM__META_MODEL:
				setMetaModel((DSpecification)null);
				return;
			case TransformPackage.TRANSFORM__RULES:
				getRules().clear();
				return;
			case TransformPackage.TRANSFORM__DSIGNATURE:
				setDSignature((DSignature)null);
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
			case TransformPackage.TRANSFORM__META_MODEL:
				return metaModel != null;
			case TransformPackage.TRANSFORM__RULES:
				return rules != null && !rules.isEmpty();
			case TransformPackage.TRANSFORM__DSIGNATURE:
				return dSignature != null;
		}
		return super.eIsSet(featureID);
	}

} //TransformImpl
