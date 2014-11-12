/**
 * <copyright>
 * </copyright>
 *
 * $Id: MorphismImpl.java,v 1.1 2010-05-19 13:09:37 fma Exp $
 */
package morphism.impl;

import java.util.Collection;

import morphism.Morphism;
import morphism.MorphismPackage;
import morphism.NodeMapping;
import morphism.ReferenceMapping;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Morphism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link morphism.impl.MorphismImpl#getNodeMappings <em>Node Mappings</em>}</li>
 *   <li>{@link morphism.impl.MorphismImpl#getReferenceMappings <em>Reference Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MorphismImpl extends EObjectImpl implements Morphism {
	/**
	 * The cached value of the '{@link #getNodeMappings() <em>Node Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeMapping> nodeMappings;

	/**
	 * The cached value of the '{@link #getReferenceMappings() <em>Reference Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceMapping> referenceMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MorphismImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorphismPackage.Literals.MORPHISM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeMapping> getNodeMappings() {
		if (nodeMappings == null) {
			nodeMappings = new EObjectContainmentEList<NodeMapping>(NodeMapping.class, this, MorphismPackage.MORPHISM__NODE_MAPPINGS);
		}
		return nodeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceMapping> getReferenceMappings() {
		if (referenceMappings == null) {
			referenceMappings = new EObjectContainmentEList<ReferenceMapping>(ReferenceMapping.class, this, MorphismPackage.MORPHISM__REFERENCE_MAPPINGS);
		}
		return referenceMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorphismPackage.MORPHISM__NODE_MAPPINGS:
				return ((InternalEList<?>)getNodeMappings()).basicRemove(otherEnd, msgs);
			case MorphismPackage.MORPHISM__REFERENCE_MAPPINGS:
				return ((InternalEList<?>)getReferenceMappings()).basicRemove(otherEnd, msgs);
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
			case MorphismPackage.MORPHISM__NODE_MAPPINGS:
				return getNodeMappings();
			case MorphismPackage.MORPHISM__REFERENCE_MAPPINGS:
				return getReferenceMappings();
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
			case MorphismPackage.MORPHISM__NODE_MAPPINGS:
				getNodeMappings().clear();
				getNodeMappings().addAll((Collection<? extends NodeMapping>)newValue);
				return;
			case MorphismPackage.MORPHISM__REFERENCE_MAPPINGS:
				getReferenceMappings().clear();
				getReferenceMappings().addAll((Collection<? extends ReferenceMapping>)newValue);
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
			case MorphismPackage.MORPHISM__NODE_MAPPINGS:
				getNodeMappings().clear();
				return;
			case MorphismPackage.MORPHISM__REFERENCE_MAPPINGS:
				getReferenceMappings().clear();
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
			case MorphismPackage.MORPHISM__NODE_MAPPINGS:
				return nodeMappings != null && !nodeMappings.isEmpty();
			case MorphismPackage.MORPHISM__REFERENCE_MAPPINGS:
				return referenceMappings != null && !referenceMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MorphismImpl
