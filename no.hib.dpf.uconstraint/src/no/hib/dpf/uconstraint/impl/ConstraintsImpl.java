/**
 */
package no.hib.dpf.uconstraint.impl;

import java.util.Collection;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;

import no.hib.dpf.uconstraint.Constraints;
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.UConstraintPackage;

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
 * An implementation of the model object '<em><b>Constraints</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.uconstraint.impl.ConstraintsImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.ConstraintsImpl#getDSignature <em>DSignature</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.ConstraintsImpl#getElementTypeGraph <em>Element Type Graph</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.ConstraintsImpl#getSourceLocation <em>Source Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintsImpl extends EObjectImpl implements Constraints {
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<UConstraint> rules;

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
	 * The cached value of the '{@link #getElementTypeGraph() <em>Element Type Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeGraph()
	 * @generated
	 * @ordered
	 */
	protected DSpecification elementTypeGraph;

	/**
	 * The default value of the '{@link #getSourceLocation() <em>Source Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceLocation() <em>Source Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLocation()
	 * @generated
	 * @ordered
	 */
	protected String sourceLocation = SOURCE_LOCATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UConstraintPackage.Literals.CONSTRAINTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UConstraint> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<UConstraint>(UConstraint.class, this, UConstraintPackage.CONSTRAINTS__RULES);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UConstraintPackage.CONSTRAINTS__DSIGNATURE, oldDSignature, dSignature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UConstraintPackage.CONSTRAINTS__DSIGNATURE, oldDSignature, dSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification getElementTypeGraph() {
		if (elementTypeGraph != null && elementTypeGraph.eIsProxy()) {
			InternalEObject oldElementTypeGraph = (InternalEObject)elementTypeGraph;
			elementTypeGraph = (DSpecification)eResolveProxy(oldElementTypeGraph);
			if (elementTypeGraph != oldElementTypeGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UConstraintPackage.CONSTRAINTS__ELEMENT_TYPE_GRAPH, oldElementTypeGraph, elementTypeGraph));
			}
		}
		return elementTypeGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification basicGetElementTypeGraph() {
		return elementTypeGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeGraph(DSpecification newElementTypeGraph) {
		DSpecification oldElementTypeGraph = elementTypeGraph;
		elementTypeGraph = newElementTypeGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UConstraintPackage.CONSTRAINTS__ELEMENT_TYPE_GRAPH, oldElementTypeGraph, elementTypeGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceLocation() {
		return sourceLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceLocation(String newSourceLocation) {
		String oldSourceLocation = sourceLocation;
		sourceLocation = newSourceLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UConstraintPackage.CONSTRAINTS__SOURCE_LOCATION, oldSourceLocation, sourceLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UConstraintPackage.CONSTRAINTS__RULES:
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
			case UConstraintPackage.CONSTRAINTS__RULES:
				return getRules();
			case UConstraintPackage.CONSTRAINTS__DSIGNATURE:
				if (resolve) return getDSignature();
				return basicGetDSignature();
			case UConstraintPackage.CONSTRAINTS__ELEMENT_TYPE_GRAPH:
				if (resolve) return getElementTypeGraph();
				return basicGetElementTypeGraph();
			case UConstraintPackage.CONSTRAINTS__SOURCE_LOCATION:
				return getSourceLocation();
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
			case UConstraintPackage.CONSTRAINTS__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends UConstraint>)newValue);
				return;
			case UConstraintPackage.CONSTRAINTS__DSIGNATURE:
				setDSignature((DSignature)newValue);
				return;
			case UConstraintPackage.CONSTRAINTS__ELEMENT_TYPE_GRAPH:
				setElementTypeGraph((DSpecification)newValue);
				return;
			case UConstraintPackage.CONSTRAINTS__SOURCE_LOCATION:
				setSourceLocation((String)newValue);
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
			case UConstraintPackage.CONSTRAINTS__RULES:
				getRules().clear();
				return;
			case UConstraintPackage.CONSTRAINTS__DSIGNATURE:
				setDSignature((DSignature)null);
				return;
			case UConstraintPackage.CONSTRAINTS__ELEMENT_TYPE_GRAPH:
				setElementTypeGraph((DSpecification)null);
				return;
			case UConstraintPackage.CONSTRAINTS__SOURCE_LOCATION:
				setSourceLocation(SOURCE_LOCATION_EDEFAULT);
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
			case UConstraintPackage.CONSTRAINTS__RULES:
				return rules != null && !rules.isEmpty();
			case UConstraintPackage.CONSTRAINTS__DSIGNATURE:
				return dSignature != null;
			case UConstraintPackage.CONSTRAINTS__ELEMENT_TYPE_GRAPH:
				return elementTypeGraph != null;
			case UConstraintPackage.CONSTRAINTS__SOURCE_LOCATION:
				return SOURCE_LOCATION_EDEFAULT == null ? sourceLocation != null : !SOURCE_LOCATION_EDEFAULT.equals(sourceLocation);
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
		result.append(" (sourceLocation: ");
		result.append(sourceLocation);
		result.append(')');
		return result.toString();
	}

} //ConstraintsImpl
