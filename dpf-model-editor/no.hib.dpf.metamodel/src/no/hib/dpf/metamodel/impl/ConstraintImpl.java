/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelPackage;

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
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getConstrainedModelPart <em>Constrained Model Part</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getPredicateShape <em>Predicate Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends GraphHomomorphismImpl implements Constraint {
	/**
	 * The cached value of the '{@link #getConstrainedModelPart() <em>Constrained Model Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedModelPart()
	 * @generated
	 * @ordered
	 */
	protected Graph constrainedModelPart;

	/**
	 * The cached value of the '{@link #getPredicateShape() <em>Predicate Shape</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicateShape()
	 * @generated
	 * @ordered
	 */
	protected Graph predicateShape;

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
	public Graph getConstrainedModelPart() {
		if (constrainedModelPart != null && constrainedModelPart.eIsProxy()) {
			InternalEObject oldConstrainedModelPart = (InternalEObject)constrainedModelPart;
			constrainedModelPart = (Graph)eResolveProxy(oldConstrainedModelPart);
			if (constrainedModelPart != oldConstrainedModelPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL_PART, oldConstrainedModelPart, constrainedModelPart));
			}
		}
		return constrainedModelPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetConstrainedModelPart() {
		return constrainedModelPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstrainedModelPart(Graph newConstrainedModelPart) {
		Graph oldConstrainedModelPart = constrainedModelPart;
		constrainedModelPart = newConstrainedModelPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL_PART, oldConstrainedModelPart, constrainedModelPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getPredicateShape() {
		if (predicateShape != null && predicateShape.eIsProxy()) {
			InternalEObject oldPredicateShape = (InternalEObject)predicateShape;
			predicateShape = (Graph)eResolveProxy(oldPredicateShape);
			if (predicateShape != oldPredicateShape) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__PREDICATE_SHAPE, oldPredicateShape, predicateShape));
			}
		}
		return predicateShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetPredicateShape() {
		return predicateShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicateShape(Graph newPredicateShape) {
		Graph oldPredicateShape = predicateShape;
		predicateShape = newPredicateShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__PREDICATE_SHAPE, oldPredicateShape, predicateShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL_PART:
				if (resolve) return getConstrainedModelPart();
				return basicGetConstrainedModelPart();
			case MetamodelPackage.CONSTRAINT__PREDICATE_SHAPE:
				if (resolve) return getPredicateShape();
				return basicGetPredicateShape();
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL_PART:
				setConstrainedModelPart((Graph)newValue);
				return;
			case MetamodelPackage.CONSTRAINT__PREDICATE_SHAPE:
				setPredicateShape((Graph)newValue);
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL_PART:
				setConstrainedModelPart((Graph)null);
				return;
			case MetamodelPackage.CONSTRAINT__PREDICATE_SHAPE:
				setPredicateShape((Graph)null);
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL_PART:
				return constrainedModelPart != null;
			case MetamodelPackage.CONSTRAINT__PREDICATE_SHAPE:
				return predicateShape != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstraintImpl
