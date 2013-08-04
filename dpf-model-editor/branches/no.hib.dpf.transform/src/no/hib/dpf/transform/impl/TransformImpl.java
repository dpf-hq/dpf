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
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getSourceMetaModel <em>Source Meta Model</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getTargetMetaModel <em>Target Meta Model</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#getDSignature <em>DSignature</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.TransformImpl#isGenerate <em>Generate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformImpl extends EObjectImpl implements Transform {
	/**
	 * The cached value of the '{@link #getSourceMetaModel() <em>Source Meta Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMetaModel()
	 * @generated
	 * @ordered
	 */
	protected DSpecification sourceMetaModel;

	/**
	 * The cached value of the '{@link #getTargetMetaModel() <em>Target Meta Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMetaModel()
	 * @generated
	 * @ordered
	 */
	protected DSpecification targetMetaModel;

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
	 * The default value of the '{@link #isGenerate() <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isGenerate() <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerate()
	 * @generated
	 * @ordered
	 */
	protected boolean generate = GENERATE_EDEFAULT;

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
	public DSpecification getSourceMetaModel() {
		return sourceMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceMetaModel(DSpecification newSourceMetaModel, NotificationChain msgs) {
		DSpecification oldSourceMetaModel = sourceMetaModel;
		sourceMetaModel = newSourceMetaModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__SOURCE_META_MODEL, oldSourceMetaModel, newSourceMetaModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceMetaModel(DSpecification newSourceMetaModel) {
		if (newSourceMetaModel != sourceMetaModel) {
			NotificationChain msgs = null;
			if (sourceMetaModel != null)
				msgs = ((InternalEObject)sourceMetaModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformPackage.TRANSFORM__SOURCE_META_MODEL, null, msgs);
			if (newSourceMetaModel != null)
				msgs = ((InternalEObject)newSourceMetaModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformPackage.TRANSFORM__SOURCE_META_MODEL, null, msgs);
			msgs = basicSetSourceMetaModel(newSourceMetaModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__SOURCE_META_MODEL, newSourceMetaModel, newSourceMetaModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification getTargetMetaModel() {
		return targetMetaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetMetaModel(DSpecification newTargetMetaModel, NotificationChain msgs) {
		DSpecification oldTargetMetaModel = targetMetaModel;
		targetMetaModel = newTargetMetaModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__TARGET_META_MODEL, oldTargetMetaModel, newTargetMetaModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMetaModel(DSpecification newTargetMetaModel) {
		if (newTargetMetaModel != targetMetaModel) {
			NotificationChain msgs = null;
			if (targetMetaModel != null)
				msgs = ((InternalEObject)targetMetaModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformPackage.TRANSFORM__TARGET_META_MODEL, null, msgs);
			if (newTargetMetaModel != null)
				msgs = ((InternalEObject)newTargetMetaModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformPackage.TRANSFORM__TARGET_META_MODEL, null, msgs);
			msgs = basicSetTargetMetaModel(newTargetMetaModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__TARGET_META_MODEL, newTargetMetaModel, newTargetMetaModel));
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
	public boolean isGenerate() {
		return generate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerate(boolean newGenerate) {
		boolean oldGenerate = generate;
		generate = newGenerate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.TRANSFORM__GENERATE, oldGenerate, generate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				return basicSetSourceMetaModel(null, msgs);
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				return basicSetTargetMetaModel(null, msgs);
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
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				return getSourceMetaModel();
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				return getTargetMetaModel();
			case TransformPackage.TRANSFORM__RULES:
				return getRules();
			case TransformPackage.TRANSFORM__DSIGNATURE:
				if (resolve) return getDSignature();
				return basicGetDSignature();
			case TransformPackage.TRANSFORM__GENERATE:
				return isGenerate();
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
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				setSourceMetaModel((DSpecification)newValue);
				return;
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				setTargetMetaModel((DSpecification)newValue);
				return;
			case TransformPackage.TRANSFORM__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Production>)newValue);
				return;
			case TransformPackage.TRANSFORM__DSIGNATURE:
				setDSignature((DSignature)newValue);
				return;
			case TransformPackage.TRANSFORM__GENERATE:
				setGenerate((Boolean)newValue);
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
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				setSourceMetaModel((DSpecification)null);
				return;
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				setTargetMetaModel((DSpecification)null);
				return;
			case TransformPackage.TRANSFORM__RULES:
				getRules().clear();
				return;
			case TransformPackage.TRANSFORM__DSIGNATURE:
				setDSignature((DSignature)null);
				return;
			case TransformPackage.TRANSFORM__GENERATE:
				setGenerate(GENERATE_EDEFAULT);
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
			case TransformPackage.TRANSFORM__SOURCE_META_MODEL:
				return sourceMetaModel != null;
			case TransformPackage.TRANSFORM__TARGET_META_MODEL:
				return targetMetaModel != null;
			case TransformPackage.TRANSFORM__RULES:
				return rules != null && !rules.isEmpty();
			case TransformPackage.TRANSFORM__DSIGNATURE:
				return dSignature != null;
			case TransformPackage.TRANSFORM__GENERATE:
				return generate != GENERATE_EDEFAULT;
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
		result.append(" (generate: ");
		result.append(generate);
		result.append(')');
		return result.toString();
	}

} //TransformImpl
