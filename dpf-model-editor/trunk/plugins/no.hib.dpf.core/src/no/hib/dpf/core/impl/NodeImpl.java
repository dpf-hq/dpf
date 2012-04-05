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
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getTypeNode <em>Type Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends IDObjectImpl implements Node {

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
	 * The cached value of the '{@link #getTypeNode() <em>Type Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeNode()
	 * @generated
	 * @ordered
	 */
	protected Node typeNode;

	/**
	 * The cached value of the '{@link #getOutgoings() <em>Outgoings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<Arrow> outgoings;

	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<Arrow> incomings;

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
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NODE__NAME, oldName, name));
	}

	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs){
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if(newContainer instanceof Graph && getName() == null && getTypeNode() != null){
			String name = getTypeNode().getName();
			List<Integer> indexs = new ArrayList<Integer>();
			for(Node iter : ((Graph)newContainer).getNodes()){
				String current = iter.getName();
				if(current != null && current.startsWith(name))
					indexs.add(Integer.valueOf(current.substring(name.length())));
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
	public Node getTypeNode() {
		if (typeNode != null && typeNode.eIsProxy()) {
			InternalEObject oldTypeNode = (InternalEObject)typeNode;
			typeNode = (Node)eResolveProxy(oldTypeNode);
			if (typeNode != oldTypeNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.NODE__TYPE_NODE, oldTypeNode, typeNode));
			}
		}
		return typeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTypeNode() {
		return typeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeNode(Node newTypeNode) {
		Node oldTypeNode = typeNode;
		typeNode = newTypeNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NODE__TYPE_NODE, oldTypeNode, typeNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arrow> getOutgoings() {
		if (outgoings == null) {
			outgoings = new EObjectWithInverseResolvingEList<Arrow>(Arrow.class, this, CorePackage.NODE__OUTGOINGS, CorePackage.ARROW__SOURCE);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arrow> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<Arrow>(Arrow.class, this, CorePackage.NODE__INCOMINGS, CorePackage.ARROW__TARGET);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectWithInverseResolvingEList.ManyInverse<Constraint>(Constraint.class, this, CorePackage.NODE__CONSTRAINTS, CorePackage.CONSTRAINT__NODES);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean arrowCanMakeConnectionAsSource(Node intendedSource) {
		if (getTypeNode() == DPFConstants.REFLEXIVE_TYPE_NODE) {
			return true;
		}
		if ((intendedSource == null) || (intendedSource.getTypeNode() == null)) {
			return false;
		}
		return intendedSource.getTypeNode().canReachTargetByOneArrow(this.getTypeNode());		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */ 
	public boolean arrowCanMakeConnectionAsTarget(Node intendedTarget) {
		if (getTypeNode() == DPFConstants.REFLEXIVE_TYPE_NODE) {
			return true;
		}
		if ((intendedTarget == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return typeNode.canReachTargetByOneArrow(intendedTarget.getTypeNode());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean arrowCanMakeConnectionAsTarget(Node intendedTarget, Arrow typeArrow) {
		if ((getTypeNode() == DPFConstants.REFLEXIVE_TYPE_NODE) && (typeArrow == DPFConstants.REFLEXIVE_TYPE_NODE)) {
			return true;
		}
		if ((intendedTarget == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return typeNode.canReachTargetByTypeArrow(intendedTarget.getTypeNode(), typeArrow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean canReachTargetByTypeArrow(Node target, Arrow typeArrow) {
		if (typeArrow.getTarget().equals(target)) {
			return (getOutgoings().contains(typeArrow));
		}
		return false;		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow getArrowto(Node target) {
		for (Arrow arrow : getOutgoings()) {
			if (arrow.getTarget().equals(target)) {
				return arrow;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTypeName() {
		if ((getTypeNode() == null) || (getTypeNode().getName() == null)) {
			return "";
		}
		return getTypeNode().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private String getNameTemplate() {
		String typeName = getTypeName();
		if (typeName.equals("")) {
			return "Node ";
		} else {
			return typeName + " ";
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated ZOT!
	 */
	public String generateUniqueName() {
		String name;
		if(getGraph() == null) {
			name = getId();
		} else {
			int count = getGraph().getNodes().size();
			name = getNameTemplate() + count;
			while(nameIsUsed(name)) {
				count++;
				name = getNameTemplate() + count;
			}
		}
		
		return name;
	}
	public Graph getGraph() {
		return (Graph) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCreateTypedArrow(Node intendedTarget) {
		if (intendedTarget == null) {
			return false;
		}
		// By convention, we say that a connection can't be made between typed and untyped nodes:
		if ((getTypeNode() == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return (getTypeArrow(intendedTarget) != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow getTypeArrow(Node intendedTarget) {
		try {
			Node intendedTargetsTypeNode = intendedTarget.getTypeNode();
			for (Arrow arrow : getTypeNode().getOutgoings()) {
				if (arrow.getTarget().equals(intendedTargetsTypeNode)) {
					return arrow;
				}
			}			
		} catch (Exception e) {}
		return null;
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
		for(Node n : getGraph().getNodes()) {
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
	 * @generated NOT
	 */
	public boolean canReachTargetByOneArrow(Node target) {
		return (getArrowto(target) != null);
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
			case CorePackage.NODE__OUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoings()).basicAdd(otherEnd, msgs);
			case CorePackage.NODE__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
			case CorePackage.NODE__CONSTRAINTS:
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
			case CorePackage.NODE__OUTGOINGS:
				return ((InternalEList<?>)getOutgoings()).basicRemove(otherEnd, msgs);
			case CorePackage.NODE__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
			case CorePackage.NODE__CONSTRAINTS:
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
			case CorePackage.NODE__NAME:
				return getName();
			case CorePackage.NODE__TYPE_NODE:
				if (resolve) return getTypeNode();
				return basicGetTypeNode();
			case CorePackage.NODE__OUTGOINGS:
				return getOutgoings();
			case CorePackage.NODE__INCOMINGS:
				return getIncomings();
			case CorePackage.NODE__CONSTRAINTS:
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
			case CorePackage.NODE__NAME:
				setName((String)newValue);
				return;
			case CorePackage.NODE__TYPE_NODE:
				setTypeNode((Node)newValue);
				return;
			case CorePackage.NODE__OUTGOINGS:
				getOutgoings().clear();
				getOutgoings().addAll((Collection<? extends Arrow>)newValue);
				return;
			case CorePackage.NODE__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends Arrow>)newValue);
				return;
			case CorePackage.NODE__CONSTRAINTS:
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
			case CorePackage.NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CorePackage.NODE__TYPE_NODE:
				setTypeNode(DPFConstants.REFLEXIVE_TYPE_NODE);
				return;
			case CorePackage.NODE__OUTGOINGS:
				getOutgoings().clear();
				return;
			case CorePackage.NODE__INCOMINGS:
				getIncomings().clear();
				return;
			case CorePackage.NODE__CONSTRAINTS:
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
			case CorePackage.NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CorePackage.NODE__TYPE_NODE:
				return typeNode != null && typeNode != DPFConstants.REFLEXIVE_TYPE_NODE;
			case CorePackage.NODE__OUTGOINGS:
				return outgoings != null && !outgoings.isEmpty();
			case CorePackage.NODE__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
			case CorePackage.NODE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
