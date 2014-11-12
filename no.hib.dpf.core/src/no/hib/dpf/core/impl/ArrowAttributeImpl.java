package no.hib.dpf.core.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.MutableElement;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.core.runtime.Assert;
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
 * An implementation of the model object '<em><b>Arrow Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.ArrowAttributeImpl#getMutability <em>Mutability</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowAttributeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowAttributeImpl#getTypeAttribute <em>Type Attribute</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowAttributeImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.ArrowAttributeImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrowAttributeImpl extends IDObjectImpl implements ArrowAttribute {
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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Arrow source;

	/**
	 * The cached value of the '{@link #getTypeAttribute() <em>Type Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeAttribute()
	 * @generated
	 * @ordered
	 */
	protected ArrowAttribute typeAttribute;

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
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected DataNode target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrowAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.ARROW_ATTRIBUTE;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMutability(int newMutability) {
		int oldMutability = mutability;
		mutability = newMutability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW_ATTRIBUTE__MUTABILITY, oldMutability, mutability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arrow getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Arrow)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.ARROW_ATTRIBUTE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arrow basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Arrow newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, CorePackage.ARROW__OUTGOING_ATTRIBUTES, Arrow.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, CorePackage.ARROW__OUTGOING_ATTRIBUTES, Arrow.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW_ATTRIBUTE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowAttribute getTypeAttribute() {
		if (typeAttribute != null && typeAttribute.eIsProxy()) {
			InternalEObject oldTypeAttribute = (InternalEObject)typeAttribute;
			typeAttribute = (ArrowAttribute)eResolveProxy(oldTypeAttribute);
			if (typeAttribute != oldTypeAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.ARROW_ATTRIBUTE__TYPE_ATTRIBUTE, oldTypeAttribute, typeAttribute));
			}
		}
		return typeAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowAttribute basicGetTypeAttribute() {
		return typeAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeAttribute(ArrowAttribute newTypeAttribute) {
		ArrowAttribute oldTypeAttribute = typeAttribute;
		typeAttribute = newTypeAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW_ATTRIBUTE__TYPE_ATTRIBUTE, oldTypeAttribute, typeAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectWithInverseResolvingEList.ManyInverse<Constraint>(Constraint.class, this, CorePackage.ARROW_ATTRIBUTE__CONSTRAINTS, CorePackage.CONSTRAINT__ARROW_ATTRIBUTES);
		}
		return constraints;
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
	 * @generated not
	 */
	public void setName(String newName) {
		String oldName = name;
		if(newName != null && newName.equals(getTypeName()) || getTypeName().equals(DPFCoreConstants.ARROW_ATTRIBUTE)){
			name = newName;
		}else if(mutability != 0){
			name = newName;	
		}
		
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW_ATTRIBUTE__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataNode getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (DataNode)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.ARROW_ATTRIBUTE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataNode basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(DataNode newTarget, NotificationChain msgs) {
		DataNode oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.ARROW_ATTRIBUTE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(DataNode newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES, DataNode.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES, DataNode.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ARROW_ATTRIBUTE__TARGET, newTarget, newTarget));
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
			case CorePackage.ARROW_ATTRIBUTE__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, CorePackage.ARROW__OUTGOING_ATTRIBUTES, Arrow.class, msgs);
				return basicSetSource((Arrow)otherEnd, msgs);
			case CorePackage.ARROW_ATTRIBUTE__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
			case CorePackage.ARROW_ATTRIBUTE__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES, DataNode.class, msgs);
				return basicSetTarget((DataNode)otherEnd, msgs);
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
			case CorePackage.ARROW_ATTRIBUTE__SOURCE:
				return basicSetSource(null, msgs);
			case CorePackage.ARROW_ATTRIBUTE__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case CorePackage.ARROW_ATTRIBUTE__TARGET:
				return basicSetTarget(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Arrow newSource, NotificationChain msgs) {
		Arrow oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.ARROW_ATTRIBUTE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ARROW_ATTRIBUTE__MUTABILITY:
				return getMutability();
			case CorePackage.ARROW_ATTRIBUTE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case CorePackage.ARROW_ATTRIBUTE__TYPE_ATTRIBUTE:
				if (resolve) return getTypeAttribute();
				return basicGetTypeAttribute();
			case CorePackage.ARROW_ATTRIBUTE__CONSTRAINTS:
				return getConstraints();
			case CorePackage.ARROW_ATTRIBUTE__NAME:
				return getName();
			case CorePackage.ARROW_ATTRIBUTE__TARGET:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.ARROW_ATTRIBUTE__MUTABILITY:
				setMutability((Integer)newValue);
				return;
			case CorePackage.ARROW_ATTRIBUTE__SOURCE:
				setSource((Arrow)newValue);
				return;
			case CorePackage.ARROW_ATTRIBUTE__TYPE_ATTRIBUTE:
				setTypeAttribute((ArrowAttribute)newValue);
				return;
			case CorePackage.ARROW_ATTRIBUTE__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case CorePackage.ARROW_ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case CorePackage.ARROW_ATTRIBUTE__TARGET:
				setTarget((DataNode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.ARROW_ATTRIBUTE__SOURCE:
				setSource((Arrow)null);
				return;
			case CorePackage.ARROW_ATTRIBUTE__TYPE_ATTRIBUTE:
				setTypeAttribute(DPFCoreConstants.REFLEXIVE_TYPE_ARROW_ATTRIBUTE);
				return;
			case CorePackage.ARROW_ATTRIBUTE__CONSTRAINTS:
				getConstraints().clear();
				return;
			case CorePackage.ARROW_ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CorePackage.ARROW_ATTRIBUTE__TARGET:
				setTarget((DataNode)null);
				return;
			case CorePackage.ARROW_ATTRIBUTE__MUTABILITY:
				setMutability(MUTABILITY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.ARROW_ATTRIBUTE__SOURCE:
				return source != null;
			case CorePackage.ARROW_ATTRIBUTE__TYPE_ATTRIBUTE:
				return typeAttribute != null && typeAttribute != DPFCoreConstants.REFLEXIVE_TYPE_ARROW_ATTRIBUTE;
			case CorePackage.ARROW_ATTRIBUTE__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case CorePackage.ARROW_ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CorePackage.ARROW_ATTRIBUTE__TARGET:
				return target != null;
			case CorePackage.ARROW_ATTRIBUTE__MUTABILITY:
				return mutability != MUTABILITY_EDEFAULT;
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
				case CorePackage.ARROW_ATTRIBUTE__MUTABILITY: return CorePackage.MUTABLE_ELEMENT__MUTABILITY;
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
				case CorePackage.MUTABLE_ELEMENT__MUTABILITY: return CorePackage.ARROW_ATTRIBUTE__MUTABILITY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (mutability: ");
		result.append(mutability);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	@Override
	public IDObject getTemplateElement() {
		return (ArrowAttribute) getElement(SpecificationImpl.METALEVEL_EDEFAULT);
	}

	@Override
	public boolean isTemplateElement() {
		if (this == getTemplateElement()) {
			return true;
		}
		return false;
	}

	@Override
	public IDObject getElement(int metalevel) {
		try {
			if (getMetaLevel() == metalevel) {
				return this;
			} else if(getMetaLevel() > metalevel){
				Assert.isNotNull(getTypeAttribute());
				return getTypeAttribute().getElement(metalevel);
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public int getMetaLevel() throws NullPointerException {
		Specification spec = (Specification) eContainer().eContainer();
		Assert.isNotNull(spec);
		return spec.getMetalevel();
	}
	
	@Override
	public Graph getGraph() {
		return (Graph) eContainer();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getTypeName() {
		if ((getTypeAttribute() == null) || (getTypeAttribute().getName() == null)) {
			return "";
		}
		return getTypeAttribute().getName();
	}
	
	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs) {
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if (mutability != 0 && newContainer instanceof Graph && getName() == null && getTypeAttribute() != null) {
			String name = getTypeAttribute().getName();
			List<Integer> indexs = new ArrayList<Integer>();
			for (ArrowAttribute iter : ((Graph) newContainer).getArrowAttributes()) {
				String current = iter.getName();
				if (current != null && current.startsWith(name)) {
					try {
						indexs.add(Integer.valueOf(current.substring(name.length())));
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

} //ArrowAttributeImpl