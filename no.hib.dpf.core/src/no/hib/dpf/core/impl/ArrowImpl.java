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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.utils.DPFConstants;

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
 * An implementation of the model object '<em><b>Arrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getTypeArrow <em>Type Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrowImpl extends IDObjectImpl implements Arrow {

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * The cached value of the '{@link #getTypeArrow() <em>Type Arrow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArrow()
	 * @generated
	 * @ordered
	 */
	protected Arrow typeArrow;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ARROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Node)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.ARROW__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Node newTarget, NotificationChain msgs) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, CorePackage.NODE__INCOMINGS, Node.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, CorePackage.NODE__INCOMINGS, Node.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__TARGET, newTarget, newTarget));
	}

	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs){
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if(newContainer instanceof Graph && getName() == null && getTypeArrow() != null){
			String name = getTypeArrow().getName();
			List<Integer> indexs = new ArrayList<Integer>();
			for(Arrow iter : ((Graph)newContainer).getArrows()){
				String current = iter.getName();
				if(current != null && current.startsWith(name)){
					try{
					indexs.add(Integer.valueOf(current.substring(name.length())));
					}catch(NumberFormatException e){}
				}
			}
			Collections.sort(indexs);
			int i = 0;
			for(; i < indexs.size(); ++i)
				if(indexs.get(i).intValue() != i)
					setName(name + i);
			if(i >= indexs.size())
				setName(name + i);
		}
		return msgs;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arrow getTypeArrow() {
		if (typeArrow != null && typeArrow.eIsProxy()) {
			InternalEObject oldTypeArrow = (InternalEObject)typeArrow;
			typeArrow = (Arrow)eResolveProxy(oldTypeArrow);
			if (typeArrow != oldTypeArrow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.ARROW__TYPE_ARROW, oldTypeArrow, typeArrow));
			}
		}
		return typeArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arrow basicGetTypeArrow() {
		return typeArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeArrow(Arrow newTypeArrow) {
		Arrow oldTypeArrow = typeArrow;
		typeArrow = newTypeArrow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__TYPE_ARROW, oldTypeArrow, typeArrow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectWithInverseResolvingEList.ManyInverse<Constraint>(Constraint.class, this, CorePackage.ARROW__CONSTRAINTS, CorePackage.CONSTRAINT__ARROWS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Node)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.ARROW__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Node newSource, NotificationChain msgs) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, CorePackage.NODE__OUTGOINGS, Node.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, CorePackage.NODE__OUTGOINGS, Node.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTypeName() {
		if ((getTypeArrow() == null) || (getTypeArrow().getName() == null)) {
			return "";
		}
		return getTypeArrow().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private String getNameTemplate() {
		String typeName = getTypeName();
		if (typeName.equals("")) {
			return "Arrow ";
		} else {
			return typeName + " ";
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String generateUniqueName() {
		String name;
		if(getGraph() == null) {
			name = getId();
		} else {
			int count = getGraph().getArrows().size();
			name = getNameTemplate() + count;
			while(nameIsUsed(name)) {
				count++;
				name = getNameTemplate() + count;
			}
		}

		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemplateElementType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	public Graph getGraph() {
		return (Graph) eContainer();
	}

	/**
	 * 
	 * @param name
	 * @return
	 * 
	 * @generated NOT
	 */
	private boolean nameIsUsed(String name) {
		boolean used = false;
		for(Arrow n : getGraph().getArrows()) {
			if(n.getName() != null && n.getName().equals(name)) {
				used = true;
				break;
			}
		}
		return used;
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
			case CorePackage.ARROW__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, CorePackage.NODE__OUTGOINGS, Node.class, msgs);
				return basicSetSource((Node)otherEnd, msgs);
			case CorePackage.ARROW__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, CorePackage.NODE__INCOMINGS, Node.class, msgs);
				return basicSetTarget((Node)otherEnd, msgs);
			case CorePackage.ARROW__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
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
			case CorePackage.ARROW__SOURCE:
				return basicSetSource(null, msgs);
			case CorePackage.ARROW__TARGET:
				return basicSetTarget(null, msgs);
			case CorePackage.ARROW__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case CorePackage.ARROW__NAME:
				return getName();
			case CorePackage.ARROW__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case CorePackage.ARROW__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case CorePackage.ARROW__TYPE_ARROW:
				if (resolve) return getTypeArrow();
				return basicGetTypeArrow();
			case CorePackage.ARROW__CONSTRAINTS:
				return getConstraints();
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
			case CorePackage.ARROW__NAME:
				setName((String)newValue);
				return;
			case CorePackage.ARROW__SOURCE:
				setSource((Node)newValue);
				return;
			case CorePackage.ARROW__TARGET:
				setTarget((Node)newValue);
				return;
			case CorePackage.ARROW__TYPE_ARROW:
				setTypeArrow((Arrow)newValue);
				return;
			case CorePackage.ARROW__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.ARROW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CorePackage.ARROW__SOURCE:
				setSource(null);
				return;
			case CorePackage.ARROW__TARGET:
				setTarget(null);
				return;
			case CorePackage.ARROW__TYPE_ARROW:
				setTypeArrow(DPFConstants.REFLEXIVE_TYPE_ARROW);
				return;
			case CorePackage.ARROW__CONSTRAINTS:
				getConstraints().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.ARROW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CorePackage.ARROW__SOURCE:
				return source != null;
			case CorePackage.ARROW__TARGET:
				return target != null;
			case CorePackage.ARROW__TYPE_ARROW:
				return typeArrow != null && typeArrow != DPFConstants.REFLEXIVE_TYPE_ARROW;
			case CorePackage.ARROW__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer("");
		result.append(getName() + ":");
		Node node = getSource();
		result.append((node == null ? node : node.getName()) + "->");
		node = getTarget();
		result.append((node == null ? node : node.getName()));
		return result.toString();
	}

	@Override
	public IDObject getTemplateElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTemplateElement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IDObject getElement(int metaLevel) {
		// TODO Auto-generated method stub
		return null;
	}

} //ArrowImpl
