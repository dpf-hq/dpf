/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import java.util.Collection;

import no.hib.dpf.core.impl.IDObjectImpl;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DElement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DElementImpl#getConstraintsFrom <em>Constraints From</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DElementImpl#getConstraintsTo <em>Constraints To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DElementImpl extends IDObjectImpl implements DElement {
	/**
	 * The cached value of the '{@link #getConstraintsFrom() <em>Constraints From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintsFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<DConstraint> constraintsFrom;

	/**
	 * The cached value of the '{@link #getConstraintsTo() <em>Constraints To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<DConstraint> constraintsTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.DELEMENT__CONSTRAINTS_FROM:
				return getConstraintsFrom();
			case DiagramPackage.DELEMENT__CONSTRAINTS_TO:
				return getConstraintsTo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagramPackage.DELEMENT__CONSTRAINTS_FROM:
				return constraintsFrom != null && !constraintsFrom.isEmpty();
			case DiagramPackage.DELEMENT__CONSTRAINTS_TO:
				return constraintsTo != null && !constraintsTo.isEmpty();
		}
		return super.eIsSet(featureID);
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
			case DiagramPackage.DELEMENT__CONSTRAINTS_FROM:
				getConstraintsFrom().clear();
				getConstraintsFrom().addAll((Collection<? extends DConstraint>)newValue);
				return;
			case DiagramPackage.DELEMENT__CONSTRAINTS_TO:
				getConstraintsTo().clear();
				getConstraintsTo().addAll((Collection<? extends DConstraint>)newValue);
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
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramPackage.DELEMENT__CONSTRAINTS_FROM:
				getConstraintsFrom().clear();
				return;
			case DiagramPackage.DELEMENT__CONSTRAINTS_TO:
				getConstraintsTo().clear();
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
	public EList<DConstraint> getConstraintsFrom() {
		if (constraintsFrom == null) {
			constraintsFrom = new EObjectResolvingEList<DConstraint>(DConstraint.class, this, DiagramPackage.DELEMENT__CONSTRAINTS_FROM);
		}
		return constraintsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DConstraint> getConstraintsTo() {
		if (constraintsTo == null) {
			constraintsTo = new EObjectResolvingEList<DConstraint>(DConstraint.class, this, DiagramPackage.DELEMENT__CONSTRAINTS_TO);
		}
		return constraintsTo;
	}

} //DElementImpl
