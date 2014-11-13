/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DGeneric Arrow Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DGenericArrowConstraintImpl#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DGenericArrowConstraintImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DGenericArrowConstraintImpl extends DConstraintImpl implements DGenericArrowConstraint {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected DElement source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected DElement target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DGenericArrowConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DElement basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DElement basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void disconnect() {
		setDSource(null);
		setDTarget(null);
		super.disconnect();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT__SOURCE:
				return source != null;
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT__SOURCE:
				setSource((DElement)newValue);
				return;
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT__TARGET:
				setTarget((DElement)newValue);
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
		return DiagramPackage.Literals.DGENERIC_ARROW_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT__SOURCE:
				setSource((DElement)null);
				return;
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT__TARGET:
				setTarget((DElement)null);
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
	public DElement getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (DElement)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DGENERIC_ARROW_CONSTRAINT__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DElement getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (DElement)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DGENERIC_ARROW_CONSTRAINT__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void reconnect(EList<DNode> dNodes, EList<DArrow> dArrows, DSpecification dSpecification) {
		super.reconnect(dNodes, dArrows, dSpecification);
		setDSource(findDElement(getConstraint().getMappings(), getDPredicate().getVisualization().getSource()));
		setDTarget(findDElement(getConstraint().getMappings(), getDPredicate().getVisualization().getTarget()));
	}

	/*
	 * 
	 */
	@Override
	public void setDSource(DElement object) {
		DElement old = getSource();
		if(old != null && old.getConstraintsFrom().contains(this))
			old.getConstraintsFrom().remove(this);
		setSource(object);
		DElement _new = getSource();
		if(_new != null && !_new.getConstraintsFrom().contains(this))
			_new.getConstraintsFrom().add(this);
	}


	@Override
	public void setDTarget(DElement object) {
		DElement old = getTarget();
		if(old != null && old.getConstraintsTo().contains(this))
			old.getConstraintsTo().remove(this);
		setTarget(object);
		DElement _new = getTarget();
		if(_new != null && !_new.getConstraintsTo().contains(this))
			_new.getConstraintsTo().add(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(DElement newSource) {
		DElement oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DGENERIC_ARROW_CONSTRAINT__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(DElement newTarget) {
		DElement oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DGENERIC_ARROW_CONSTRAINT__TARGET, oldTarget, target));
	}
} //DGenericArrowConstraintImpl
