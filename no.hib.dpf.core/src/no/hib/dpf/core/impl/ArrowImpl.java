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
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DeepElement;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
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
 * <em><b>Arrow</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getMutability <em>Mutability</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getPotency <em>Potency</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getTypeArrow <em>Type Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowImpl#getOutgoingAttributes <em>Outgoing Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrowImpl extends IDObjectImpl implements Arrow {

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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * The cached value of the '{@link #getTypeArrow() <em>Type Arrow</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTypeArrow()
	 * @generated
	 * @ordered
	 */
	protected Arrow typeArrow;

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
	protected EList<ArrowAttribute> outgoingAttributes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	public int getMutability() {
		return mutability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer,
			int newContainerFeatureID, NotificationChain msgs) {
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if (mutability != 0 && newContainer instanceof Graph && getName() == null && getTypeArrow() != null) {
			String name = getTypeArrow().getName();
			List<Integer> indexs = new ArrayList<Integer>();
			for (Arrow iter : ((Graph) newContainer).getArrows()) {
				String current = iter.getName();
				if (current != null && current.startsWith(name)) {
					String s = current.substring(name.length());
					try {
						indexs.add(Integer.valueOf(s));
					} catch (NumberFormatException e) {
					}
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
	 * @generated
	 */
	@Override
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Arrow basicGetTypeArrow() {
		return typeArrow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTypeArrow(Arrow newTypeArrow) {
		Arrow oldTypeArrow = typeArrow;
		typeArrow = newTypeArrow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__TYPE_ARROW, oldTypeArrow, typeArrow));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectWithInverseResolvingEList.ManyInverse<Constraint>(Constraint.class, this, CorePackage.ARROW__CONSTRAINTS, CorePackage.CONSTRAINT__ARROWS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Node newSource,
			NotificationChain msgs) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		if(newName != null && newName.equals(getTypeName()) || getTypeName().equals(DPFCoreConstants.ARROW)){
			name = newName;
		}else if(mutability != 0){
			name = newName;	
		}
		
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ArrowAttribute> getOutgoingAttributes() {
		if (outgoingAttributes == null) {
			outgoingAttributes = new EObjectWithInverseResolvingEList<ArrowAttribute>(ArrowAttribute.class, this, CorePackage.ARROW__OUTGOING_ATTRIBUTES, CorePackage.ARROW_ATTRIBUTE__SOURCE);
		}
		return outgoingAttributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getTypeName() {
		if ((getTypeArrow() == null) || (getTypeArrow().getName() == null)) {
			return "";
		}
		return getTypeArrow().getName();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String generateUniqueName() {
		String name;
		if (getGraph() == null) {
			name = getId();
		} else {
			int count = getGraph().getArrows().size();
			name = getNameTemplate() + count;
			while (nameIsUsed(name)) {
				count++;
				name = getNameTemplate() + count;
			}
		}

		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Arrow getTemplateElement() {
		return (Arrow) getElement(SpecificationImpl.METALEVEL_EDEFAULT);
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @generated NOT
	 */
	@Override
	public IDObject getElement(int metalevel) {
		try {
			if (getMetaLevel() == metalevel) {
				return this;
			} else if(getMetaLevel() > metalevel){
				Assert.isNotNull(getTypeArrow());
				return getTypeArrow().getElement(metalevel);
			}
		} catch (Exception e) {
		}
		return null;
	}
	

	/**
	 * TODO WHAT IF THE CONTAINER IS NOT SET???
	 * 
	 * @generated NOT
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

	@Override
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
		for (Arrow n : getGraph().getArrows()) {
			if (n.getName() != null && n.getName().equals(name)) {
				used = true;
				break;
			}
		}
		return used;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated not
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
			case CorePackage.ARROW__OUTGOING_ATTRIBUTES:
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
			case CorePackage.ARROW__SOURCE:
				return basicSetSource(null, msgs);
			case CorePackage.ARROW__TARGET:
				return basicSetTarget(null, msgs);
			case CorePackage.ARROW__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case CorePackage.ARROW__OUTGOING_ATTRIBUTES:
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
			case CorePackage.ARROW__MUTABILITY:
				return getMutability();
			case CorePackage.ARROW__POTENCY:
				return getPotency();
			case CorePackage.ARROW__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case CorePackage.ARROW__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case CorePackage.ARROW__CONSTRAINTS:
				return getConstraints();
			case CorePackage.ARROW__TYPE_ARROW:
				if (resolve) return getTypeArrow();
				return basicGetTypeArrow();
			case CorePackage.ARROW__NAME:
				return getName();
			case CorePackage.ARROW__OUTGOING_ATTRIBUTES:
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
			case CorePackage.ARROW__MUTABILITY:
				setMutability((Integer)newValue);
				return;
			case CorePackage.ARROW__POTENCY:
				setPotency((Integer)newValue);
				return;
			case CorePackage.ARROW__SOURCE:
				setSource((Node)newValue);
				return;
			case CorePackage.ARROW__TARGET:
				setTarget((Node)newValue);
				return;
			case CorePackage.ARROW__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case CorePackage.ARROW__TYPE_ARROW:
				setTypeArrow((Arrow)newValue);
				return;
			case CorePackage.ARROW__NAME:
				setName((String)newValue);
				return;
			case CorePackage.ARROW__OUTGOING_ATTRIBUTES:
				getOutgoingAttributes().clear();
				getOutgoingAttributes().addAll((Collection<? extends ArrowAttribute>)newValue);
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
		case CorePackage.ARROW__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CorePackage.ARROW__SOURCE:
			setSource(null);
			return;
		case CorePackage.ARROW__TARGET:
			setTarget(null);
			return;
		case CorePackage.ARROW__OUTGOING_ATTRIBUTES:
			getOutgoingAttributes().clear();
			return;
		case CorePackage.ARROW__TYPE_ARROW:
			setTypeArrow(DPFCoreConstants.REFLEXIVE_TYPE_ARROW);
			return;
		case CorePackage.ARROW__CONSTRAINTS:
			getConstraints().clear();
			return;
		case CorePackage.ARROW__MUTABILITY:
			setMutability(MUTABILITY_EDEFAULT);
			return;
		case CorePackage.ARROW__POTENCY:
			setPotency(POTENCY_EDEFAULT);
			return;
		case CorePackage.ARROW__ID:
			setId(ID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CorePackage.ARROW__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case CorePackage.ARROW__SOURCE:
			return source != null;
		case CorePackage.ARROW__TARGET:
			return target != null;
		case CorePackage.ARROW__OUTGOING_ATTRIBUTES:
			return outgoingAttributes != null && !outgoingAttributes.isEmpty();
		case CorePackage.ARROW__TYPE_ARROW:
			return typeArrow != null
					&& typeArrow != DPFCoreConstants.REFLEXIVE_TYPE_ARROW;
		case CorePackage.ARROW__CONSTRAINTS:
			return constraints != null && !constraints.isEmpty();
		case CorePackage.ARROW__MUTABILITY:
			return mutability != MUTABILITY_EDEFAULT;
		case CorePackage.ARROW__POTENCY:
			return potency != POTENCY_EDEFAULT;
		case CorePackage.ARROW__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
				case CorePackage.ARROW__MUTABILITY: return CorePackage.MUTABLE_ELEMENT__MUTABILITY;
				default: return -1;
			}
		}
		if (baseClass == DeepElement.class) {
			switch (derivedFeatureID) {
				case CorePackage.ARROW__POTENCY: return CorePackage.DEEP_ELEMENT__POTENCY;
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
				case CorePackage.MUTABLE_ELEMENT__MUTABILITY: return CorePackage.ARROW__MUTABILITY;
				default: return -1;
			}
		}
		if (baseClass == DeepElement.class) {
			switch (baseFeatureID) {
				case CorePackage.DEEP_ELEMENT__POTENCY: return CorePackage.ARROW__POTENCY;
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
		for (ArrowAttribute arrowattribute : getOutgoingAttributes()) {
			arrowattribute.setMutability(newMutability);
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW__POTENCY, oldPotency, potency));
	}


} // ArrowImpl
