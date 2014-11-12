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
import no.hib.dpf.core.DeepElement;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.MutableElement;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getMutability <em>Mutability</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getPotency <em>Potency</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getTypeNode <em>Type Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getOutgoingAttributes <em>Outgoing Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends IDObjectImpl implements Node { 

	/**
	 * The default value of the '{@link #getMutability() <em>Mutability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutability()
	 * @generated
	 * @ordered
	 */
	protected static final int MUTABILITY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMutability() <em>Mutability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutability()
	 * @generated
	 * @ordered
	 */
	protected int mutability = MUTABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPotency() <em>Potency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotency()
	 * @generated
	 * @ordered
	 */
	protected static final int POTENCY_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPotency() <em>Potency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPotency()
	 * @generated
	 * @ordered
	 */
	protected int potency = POTENCY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoings() <em>Outgoings</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<Arrow> outgoings;

	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<Arrow> incomings;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoingAttributes() <em>Outgoing Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeAttribute> outgoingAttributes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	public int getMutability() {
		return mutability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		if(newName != null && newName.equals(getTypeName()) || getTypeName().equals(DPFCoreConstants.NODE)){
			name = newName;
		}else if(mutability != 0){
			name = newName;	
		}
		
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NODE__NAME, oldName, name));
		}
	}

	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs) {
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if (mutability != 0 && newContainer instanceof Graph && getName() == null && getTypeNode() != null) {
			String name = getTypeNode().getName();
			List<Integer> indexs = new ArrayList<Integer>();
			for (Node iter : ((Graph) newContainer).getNodes()) {
				String current = iter.getName();
				if (current != null && current.startsWith(name))
					try {
						indexs.add(Integer.valueOf(current.substring(name.length())));
					} catch (NumberFormatException e) {
					}
			}
			Collections.sort(indexs);
			int i = 0;
			for (; i < indexs.size(); ++i)
				if (indexs.get(i).intValue() != i)
					setName(name + i);
			if (i >= indexs.size())
				setName(name + i);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
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
	@Override
	public void setTypeNode(Node newTypeNode) {
		Node oldTypeNode = typeNode;
		typeNode = newTypeNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NODE__TYPE_NODE, oldTypeNode, typeNode));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Arrow> getOutgoings() {
		if (outgoings == null) {
			outgoings = new EObjectWithInverseResolvingEList<Arrow>(Arrow.class, this, CorePackage.NODE__OUTGOINGS, CorePackage.ARROW__SOURCE);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Arrow> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<Arrow>(Arrow.class, this, CorePackage.NODE__INCOMINGS, CorePackage.ARROW__TARGET);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectWithInverseResolvingEList.ManyInverse<Constraint>(Constraint.class, this, CorePackage.NODE__CONSTRAINTS, CorePackage.CONSTRAINT__NODES);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NodeAttribute> getOutgoingAttributes() {
		if (outgoingAttributes == null) {
			outgoingAttributes = new EObjectWithInverseResolvingEList<NodeAttribute>(NodeAttribute.class, this, CorePackage.NODE__OUTGOING_ATTRIBUTES, CorePackage.NODE_ATTRIBUTE__SOURCE);
		}
		return outgoingAttributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean arrowCanMakeConnectionAsSource(Node intendedSource) {
		if (getTypeNode() == DPFCoreConstants.REFLEXIVE_TYPE_NODE) {
			return true;
		}
		if ((intendedSource == null) || (intendedSource.getTypeNode() == null)) {
			return false;
		}
		return intendedSource.getTypeNode().canReachTargetByOneArrow(
				this.getTypeNode());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean arrowCanMakeConnectionAsTarget(Node intendedTarget) {
		if (getTypeNode() == DPFCoreConstants.REFLEXIVE_TYPE_NODE) {
			return true;
		}
		if ((intendedTarget == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return typeNode.canReachTargetByOneArrow(intendedTarget.getTypeNode());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Boolean arrowCanMakeConnectionAsTarget(Node intendedTarget,
			Arrow typeArrow) {
		if ((getTypeNode() == DPFCoreConstants.REFLEXIVE_TYPE_NODE)
				&& (typeArrow == DPFCoreConstants.REFLEXIVE_TYPE_NODE)) {
			return true;
		}
		if ((intendedTarget == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return typeNode.canReachTargetByTypeArrow(intendedTarget.getTypeNode(),
				typeArrow);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Boolean canReachTargetByTypeArrow(Node target, Arrow typeArrow) {
		if (typeArrow.getTarget().equals(target)) {
			return (getOutgoings().contains(typeArrow));
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
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
	 * @generated
	 */
	public String generateUniqueName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getTypeName() {
		if ((getTypeNode() == null) || (getTypeNode().getName() == null)) {
			return "";
		}
		return getTypeNode().getName();
	}


	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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


	@Override
	public Graph getGraph() {
		return (Graph) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean canCreateTypedArrow(Node intendedTarget) {
		if (intendedTarget == null) {
			return false;
		}
		// By convention, we say that a connection can't be made between typed
		// and untyped nodes:
		if ((getTypeNode() == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return (getTypeArrow(intendedTarget) != null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @author Ole Klokkhammer
	 * @generated NOT
	 */
	@Override
	public Node getElement(int metalevel) {
		try {
			if (getMetaLevel() == metalevel) {
				return this;
			} else if(getMetaLevel() > metalevel){
				Assert.isNotNull(getTypeName());
				return (Node) getTypeNode().getElement(metalevel);
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @returns the current metalevel
	 */
	@Override
	public int getMetaLevel() throws NullPointerException{
		Specification spec = (Specification) eContainer().eContainer();
		Assert.isNotNull(spec);
		return spec.getMetalevel();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Node getTemplateElement() {
		return getElement(SpecificationImpl.METALEVEL_EDEFAULT);
	}

	/**
	 * @author Ole Klokkhammer
	 * @generated NOT
	 */
	@Override
	public boolean isTemplateElement() {
		if (this == getTemplateElement()) {
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @author Ole Klokkhammer
	 * @generated NOT
	 */
	@Override
	public String getTemplateElementType() {
		if ((getTemplateElement() == null) || getTemplateElement().getName() == null) {
			return "";
		}
		return getTemplateElement().getName();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Arrow getTypeArrow(Node intendedTarget) {
		try {
			Node intendedTargetsTypeNode = intendedTarget.getTypeNode();
			for (Arrow arrow : getTypeNode().getOutgoings()) {
				if (arrow.getTarget().equals(intendedTargetsTypeNode)) {
					return arrow;
				}
			}
		} catch (Exception e) {
		}
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
		for (Node n : getGraph().getNodes()) {
			if (n.getName() != null && n.getName().equals(name)) {
				used = true;
				break;
			}
		}
		return used;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean canReachTargetByOneArrow(Node target) {
		return (getArrowto(target) != null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated not
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.NODE__OUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoings()).basicAdd(otherEnd, msgs);
			case CorePackage.NODE__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
			case CorePackage.NODE__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
			case CorePackage.NODE__OUTGOING_ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingAttributes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.NODE__OUTGOINGS:
				return ((InternalEList<?>)getOutgoings()).basicRemove(otherEnd, msgs);
			case CorePackage.NODE__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
			case CorePackage.NODE__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case CorePackage.NODE__OUTGOING_ATTRIBUTES:
				return ((InternalEList<?>)getOutgoingAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.NODE__MUTABILITY:
				return getMutability();
			case CorePackage.NODE__POTENCY:
				return getPotency();
			case CorePackage.NODE__OUTGOINGS:
				return getOutgoings();
			case CorePackage.NODE__INCOMINGS:
				return getIncomings();
			case CorePackage.NODE__CONSTRAINTS:
				return getConstraints();
			case CorePackage.NODE__TYPE_NODE:
				if (resolve) return getTypeNode();
				return basicGetTypeNode();
			case CorePackage.NODE__NAME:
				return getName();
			case CorePackage.NODE__OUTGOING_ATTRIBUTES:
				return getOutgoingAttributes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.NODE__MUTABILITY:
				setMutability((Integer)newValue);
				return;
			case CorePackage.NODE__POTENCY:
				setPotency((Integer)newValue);
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
			case CorePackage.NODE__TYPE_NODE:
				setTypeNode((Node)newValue);
				return;
			case CorePackage.NODE__NAME:
				setName((String)newValue);
				return;
			case CorePackage.NODE__OUTGOING_ATTRIBUTES:
				getOutgoingAttributes().clear();
				getOutgoingAttributes().addAll((Collection<? extends NodeAttribute>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CorePackage.NODE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CorePackage.NODE__TYPE_NODE:
			setTypeNode(DPFCoreConstants.REFLEXIVE_TYPE_NODE);
			return;
		case CorePackage.NODE__OUTGOINGS:
			getOutgoings().clear();
			return;
		case CorePackage.NODE__INCOMINGS:
			getIncomings().clear();
			return;
		case CorePackage.NODE__OUTGOING_ATTRIBUTES:
			getOutgoingAttributes().clear();
			return;
		case CorePackage.NODE__CONSTRAINTS:
			getConstraints().clear();
			return;
		case CorePackage.NODE__MUTABILITY:
			setMutability(MUTABILITY_EDEFAULT);
			return;
		case CorePackage.NODE__POTENCY:
			setPotency(POTENCY_EDEFAULT);
			return;
		case CorePackage.NODE__ID:
			setId(ID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CorePackage.NODE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case CorePackage.NODE__TYPE_NODE:
			return typeNode != null
					&& typeNode != DPFCoreConstants.REFLEXIVE_TYPE_NODE;
		case CorePackage.NODE__OUTGOINGS:
			return outgoings != null && !outgoings.isEmpty();
		case CorePackage.NODE__INCOMINGS:
			return incomings != null && !incomings.isEmpty();
		case CorePackage.NODE__CONSTRAINTS:
			return constraints != null && !constraints.isEmpty();
		case CorePackage.NODE__MUTABILITY:
			return mutability != MUTABILITY_EDEFAULT;
		case CorePackage.NODE__POTENCY:
			return potency != POTENCY_EDEFAULT;
		case CorePackage.NODE__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case CorePackage.NODE__OUTGOING_ATTRIBUTES:
			return outgoingAttributes != null && !outgoingAttributes.isEmpty();
	
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MutableElement.class) {
			switch (derivedFeatureID) {
				case CorePackage.NODE__MUTABILITY: return CorePackage.MUTABLE_ELEMENT__MUTABILITY;
				default: return -1;
			}
		}
		if (baseClass == DeepElement.class) {
			switch (derivedFeatureID) {
				case CorePackage.NODE__POTENCY: return CorePackage.DEEP_ELEMENT__POTENCY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MutableElement.class) {
			switch (baseFeatureID) {
				case CorePackage.MUTABLE_ELEMENT__MUTABILITY: return CorePackage.NODE__MUTABILITY;
				default: return -1;
			}
		}
		if (baseClass == DeepElement.class) {
			switch (baseFeatureID) {
				case CorePackage.DEEP_ELEMENT__POTENCY: return CorePackage.NODE__POTENCY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mutability: ");
		result.append(mutability);
		result.append(", potency: ");
		result.append(potency);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public void setMutability(int newMutability) {
		int oldMutability = mutability;
		mutability = newMutability;
		
		// set mutability on attributes:
		for (NodeAttribute nodeattribute : getOutgoingAttributes()) {
			nodeattribute.setMutability(newMutability);
		}
		
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.MUTABLE_ELEMENT__MUTABILITY, oldMutability, newMutability));
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPotency() {
		return potency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPotency(int newPotency) {
		int oldPotency = potency;
		potency = newPotency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NODE__POTENCY, oldPotency, potency));
	}

} // NodeImpl
