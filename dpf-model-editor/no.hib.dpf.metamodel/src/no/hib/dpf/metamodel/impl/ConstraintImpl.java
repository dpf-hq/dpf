/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getConstrainedModel <em>Constrained Model</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends IDObjectImpl implements Constraint {
	/**
	 * The cached value of the '{@link #getConstrainedModel() <em>Constrained Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedModel()
	 * @generated
	 * @ordered
	 */
	protected Graph constrainedModel;

	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected Predicate predicate;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected GraphHomomorphism mappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getConstrainedModel() {
		if (constrainedModel != null && constrainedModel.eIsProxy()) {
			InternalEObject oldConstrainedModel = (InternalEObject)constrainedModel;
			constrainedModel = (Graph)eResolveProxy(oldConstrainedModel);
			if (constrainedModel != oldConstrainedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL, oldConstrainedModel, constrainedModel));
			}
		}
		return constrainedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetConstrainedModel() {
		return constrainedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstrainedModel(Graph newConstrainedModel) {
		Graph oldConstrainedModel = constrainedModel;
		constrainedModel = newConstrainedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL, oldConstrainedModel, constrainedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate getPredicate() {
		if (predicate != null && predicate.eIsProxy()) {
			InternalEObject oldPredicate = (InternalEObject)predicate;
			predicate = (Predicate)eResolveProxy(oldPredicate);
			if (predicate != oldPredicate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__PREDICATE, oldPredicate, predicate));
			}
		}
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate basicGetPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(Predicate newPredicate) {
		Predicate oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__PREDICATE, oldPredicate, predicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphHomomorphism getMappings() {
		if (mappings != null && mappings.eIsProxy()) {
			InternalEObject oldMappings = (InternalEObject)mappings;
			mappings = (GraphHomomorphism)eResolveProxy(oldMappings);
			if (mappings != oldMappings) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__MAPPINGS, oldMappings, mappings));
			}
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphHomomorphism basicGetMappings() {
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappings(GraphHomomorphism newMappings) {
		GraphHomomorphism oldMappings = mappings;
		mappings = newMappings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__MAPPINGS, oldMappings, mappings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL:
				if (resolve) return getConstrainedModel();
				return basicGetConstrainedModel();
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				if (resolve) return getPredicate();
				return basicGetPredicate();
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				if (resolve) return getMappings();
				return basicGetMappings();
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL:
				setConstrainedModel((Graph)newValue);
				return;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				setPredicate((Predicate)newValue);
				return;
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				setMappings((GraphHomomorphism)newValue);
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL:
				setConstrainedModel((Graph)null);
				return;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				setPredicate((Predicate)null);
				return;
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				setMappings((GraphHomomorphism)null);
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL:
				return constrainedModel != null;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				return predicate != null;
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				return mappings != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstraintImpl
