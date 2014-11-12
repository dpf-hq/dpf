/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceMappingImpl.java,v 1.1 2010-05-19 13:09:37 fma Exp $
 */
package morphism.impl;

import java.util.Collection;

import morphism.MorphismPackage;
import morphism.ReferenceMapping;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link morphism.impl.ReferenceMappingImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link morphism.impl.ReferenceMappingImpl#getTar <em>Tar</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceMappingImpl extends EObjectImpl implements ReferenceMapping {
	/**
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected EReference src;

	/**
	 * The cached value of the '{@link #getTar() <em>Tar</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTar()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> tar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorphismPackage.Literals.REFERENCE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSrc() {
		if (src != null && src.eIsProxy()) {
			InternalEObject oldSrc = (InternalEObject)src;
			src = (EReference)eResolveProxy(oldSrc);
			if (src != oldSrc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MorphismPackage.REFERENCE_MAPPING__SRC, oldSrc, src));
			}
		}
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc(EReference newSrc) {
		EReference oldSrc = src;
		src = newSrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorphismPackage.REFERENCE_MAPPING__SRC, oldSrc, src));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getTar() {
		if (tar == null) {
			tar = new EObjectResolvingEList<EReference>(EReference.class, this, MorphismPackage.REFERENCE_MAPPING__TAR);
		}
		return tar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MorphismPackage.REFERENCE_MAPPING__SRC:
				if (resolve) return getSrc();
				return basicGetSrc();
			case MorphismPackage.REFERENCE_MAPPING__TAR:
				return getTar();
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
			case MorphismPackage.REFERENCE_MAPPING__SRC:
				setSrc((EReference)newValue);
				return;
			case MorphismPackage.REFERENCE_MAPPING__TAR:
				getTar().clear();
				getTar().addAll((Collection<? extends EReference>)newValue);
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
			case MorphismPackage.REFERENCE_MAPPING__SRC:
				setSrc((EReference)null);
				return;
			case MorphismPackage.REFERENCE_MAPPING__TAR:
				getTar().clear();
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
			case MorphismPackage.REFERENCE_MAPPING__SRC:
				return src != null;
			case MorphismPackage.REFERENCE_MAPPING__TAR:
				return tar != null && !tar.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ReferenceMappingImpl
