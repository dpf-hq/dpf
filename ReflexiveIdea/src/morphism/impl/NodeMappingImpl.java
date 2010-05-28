/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodeMappingImpl.java,v 1.1 2010-05-19 13:09:36 fma Exp $
 */
package morphism.impl;

import java.util.Collection;

import morphism.MorphismPackage;
import morphism.NodeMapping;

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
 * An implementation of the model object '<em><b>Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link morphism.impl.NodeMappingImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link morphism.impl.NodeMappingImpl#getTar <em>Tar</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeMappingImpl extends EObjectImpl implements NodeMapping {
	/**
	 * The cached value of the '{@link #getSrc() <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc()
	 * @generated
	 * @ordered
	 */
	protected EClass src;

	/**
	 * The cached value of the '{@link #getTar() <em>Tar</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTar()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> tar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorphismPackage.Literals.NODE_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSrc() {
		if (src != null && src.eIsProxy()) {
			InternalEObject oldSrc = (InternalEObject)src;
			src = (EClass)eResolveProxy(oldSrc);
			if (src != oldSrc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MorphismPackage.NODE_MAPPING__SRC, oldSrc, src));
			}
		}
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetSrc() {
		return src;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc(EClass newSrc) {
		EClass oldSrc = src;
		src = newSrc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorphismPackage.NODE_MAPPING__SRC, oldSrc, src));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getTar() {
		if (tar == null) {
			tar = new EObjectResolvingEList<EClass>(EClass.class, this, MorphismPackage.NODE_MAPPING__TAR);
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
			case MorphismPackage.NODE_MAPPING__SRC:
				if (resolve) return getSrc();
				return basicGetSrc();
			case MorphismPackage.NODE_MAPPING__TAR:
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
			case MorphismPackage.NODE_MAPPING__SRC:
				setSrc((EClass)newValue);
				return;
			case MorphismPackage.NODE_MAPPING__TAR:
				getTar().clear();
				getTar().addAll((Collection<? extends EClass>)newValue);
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
			case MorphismPackage.NODE_MAPPING__SRC:
				setSrc((EClass)null);
				return;
			case MorphismPackage.NODE_MAPPING__TAR:
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
			case MorphismPackage.NODE_MAPPING__SRC:
				return src != null;
			case MorphismPackage.NODE_MAPPING__TAR:
				return tar != null && !tar.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeMappingImpl
