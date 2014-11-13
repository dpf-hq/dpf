/**
 * <copyright>
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, �yvind Bech and Dag Viggo Lok�en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import java.util.Collection;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Specification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.ConstraintImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ConstraintImpl#getArrows <em>Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ConstraintImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ConstraintImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ConstraintImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends IDObjectImpl implements Constraint {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getArrows() <em>Arrows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrows()
	 * @generated
	 * @ordered
	 */
	protected EList<Arrow> arrows;

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
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected GraphHomomorphism mappings;

	/**
	 * The default value of the '{@link #getParameters() <em>Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected String parameters = PARAMETERS_EDEFAULT;

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
		return CorePackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectWithInverseResolvingEList.ManyInverse<Node>(Node.class, this, CorePackage.CONSTRAINT__NODES, CorePackage.NODE__CONSTRAINTS);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arrow> getArrows() {
		if (arrows == null) {
			arrows = new EObjectWithInverseResolvingEList.ManyInverse<Arrow>(Arrow.class, this, CorePackage.CONSTRAINT__ARROWS, CorePackage.ARROW__CONSTRAINTS);
		}
		return arrows;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.CONSTRAINT__PREDICATE, oldPredicate, predicate));
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
	 * @generated NOT
	 */
	public void setPredicate(Predicate newPredicate) {
		if(newPredicate == predicate) return;
		Predicate oldPredicate = predicate;
		predicate = newPredicate;
		if(getParameters() == null || getParameters().isEmpty())
			setParameters(newPredicate.getParameters());
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONSTRAINT__PREDICATE, oldPredicate, predicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphHomomorphism getMappings() {
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappings(GraphHomomorphism newMappings, NotificationChain msgs) {
		GraphHomomorphism oldMappings = mappings;
		mappings = newMappings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.CONSTRAINT__MAPPINGS, oldMappings, newMappings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappings(GraphHomomorphism newMappings) {
		if (newMappings != mappings) {
			NotificationChain msgs = null;
			if (mappings != null)
				msgs = ((InternalEObject)mappings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.CONSTRAINT__MAPPINGS, null, msgs);
			if (newMappings != null)
				msgs = ((InternalEObject)newMappings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.CONSTRAINT__MAPPINGS, null, msgs);
			msgs = basicSetMappings(newMappings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONSTRAINT__MAPPINGS, newMappings, newMappings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameters(String newParameters) {
		String oldParameters = parameters;
		parameters = newParameters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.CONSTRAINT__PARAMETERS, oldParameters, parameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reconnect(EList<Node> nodes, EList<Arrow> arrows, Specification specification) {
		if(!getNodes().isEmpty())
			getNodes().clear();
		if(!getArrows().isEmpty())
			getArrows().clear();
		getNodes().addAll(nodes);
		getArrows().addAll(arrows);
		if(specification != null && !specification.getConstraints().contains(this))
			specification.getConstraints().add(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void disconnect() {
		Specification specification = (Specification) eContainer();
		if(specification != null && specification.getConstraints().contains(this))
			specification.getConstraints().remove(this);
		getArrows().clear();
		getNodes().clear();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addArrow(Arrow arrow) {
		if(!getArrows().contains(arrow))
			getArrows().add(arrow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addNode(Node node) {
		if(!getNodes().contains(node))
			getNodes().add(node);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validate(EList<Node> nodes, EList<Arrow> arrows) 
	{
		return getPredicate().validateSemantics(getParameters(), getMappings(),nodes,  arrows);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CONSTRAINT__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case CorePackage.CONSTRAINT__ARROWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArrows()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.CONSTRAINT__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case CorePackage.CONSTRAINT__ARROWS:
				return ((InternalEList<?>)getArrows()).basicRemove(otherEnd, msgs);
			case CorePackage.CONSTRAINT__MAPPINGS:
				return basicSetMappings(null, msgs);
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
			case CorePackage.CONSTRAINT__NODES:
				return getNodes();
			case CorePackage.CONSTRAINT__ARROWS:
				return getArrows();
			case CorePackage.CONSTRAINT__PREDICATE:
				if (resolve) return getPredicate();
				return basicGetPredicate();
			case CorePackage.CONSTRAINT__MAPPINGS:
				return getMappings();
			case CorePackage.CONSTRAINT__PARAMETERS:
				return getParameters();
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
			case CorePackage.CONSTRAINT__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case CorePackage.CONSTRAINT__ARROWS:
				getArrows().clear();
				getArrows().addAll((Collection<? extends Arrow>)newValue);
				return;
			case CorePackage.CONSTRAINT__PREDICATE:
				setPredicate((Predicate)newValue);
				return;
			case CorePackage.CONSTRAINT__MAPPINGS:
				setMappings((GraphHomomorphism)newValue);
				return;
			case CorePackage.CONSTRAINT__PARAMETERS:
				setParameters((String)newValue);
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
			case CorePackage.CONSTRAINT__NODES:
				getNodes().clear();
				return;
			case CorePackage.CONSTRAINT__ARROWS:
				getArrows().clear();
				return;
			case CorePackage.CONSTRAINT__PREDICATE:
				setPredicate((Predicate)null);
				return;
			case CorePackage.CONSTRAINT__MAPPINGS:
				setMappings((GraphHomomorphism)null);
				return;
			case CorePackage.CONSTRAINT__PARAMETERS:
				setParameters(PARAMETERS_EDEFAULT);
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
			case CorePackage.CONSTRAINT__NODES:
				return nodes != null && !nodes.isEmpty();
			case CorePackage.CONSTRAINT__ARROWS:
				return arrows != null && !arrows.isEmpty();
			case CorePackage.CONSTRAINT__PREDICATE:
				return predicate != null;
			case CorePackage.CONSTRAINT__MAPPINGS:
				return mappings != null;
			case CorePackage.CONSTRAINT__PARAMETERS:
				return PARAMETERS_EDEFAULT == null ? parameters != null : !PARAMETERS_EDEFAULT.equals(parameters);
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
		result.append(" (parameters: ");
		result.append(parameters);
		result.append(')');
		return result.toString();
	}

} //ConstraintImpl
