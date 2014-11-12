package no.hib.dpf.core.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode; 
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.DataNodeImpl#getMutability <em>Mutability</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.DataNodeImpl#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.DataNodeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.DataNodeImpl#getIncomingNodeAttributes <em>Incoming Node Attributes</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.DataNodeImpl#getIncomingArrowAtributes <em>Incoming Arrow Atributes</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.DataNodeImpl#getTypeDataNode <em>Type Data Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.DataNodeImpl#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.DataNodeImpl#isIsDataType <em>Is Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataNodeImpl extends EObjectImpl implements DataNode {
	

	
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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = "DataNode";

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIncomingNodeAttributes() <em>Incoming Node Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingNodeAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeAttribute> incomingNodeAttributes;

	/**
	 * The cached value of the '{@link #getIncomingArrowAtributes() <em>Incoming Arrow Atributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingArrowAtributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ArrowAttribute> incomingArrowAtributes;

	/**
	 * The cached value of the '{@link #getTypeDataNode() <em>Type Data Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeDataNode()
	 * @generated
	 * @ordered
	 */
	protected DataNode typeDataNode;

	/**
	 * The default value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected static final String DATATYPE_EDEFAULT = "EDataType";

	/**
	 * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype()
	 * @generated
	 * @ordered
	 */
	protected String datatype = DATATYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDataType() <em>Is Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDataType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DATA_TYPE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDataType() <em>Is Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDataType()
	 * @generated
	 * @ordered
	 */
	protected boolean isDataType = IS_DATA_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.DATA_NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DATA_NODE__MUTABILITY, oldMutability, mutability));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DATA_NODE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		
		if(isDataType){
			return;
		}
		
		if(newValue != null && newValue.equals(getTypeValue()) || (getTypeDataNode() != null && !getTypeDataNode().eIsSet(CorePackage.Literals.DATA_NODE__VALUE))){
			value = newValue;
		}else if(mutability != 0){
			value = newValue;	
		}
		
		if (eNotificationRequired()){
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DATA_NODE__VALUE, oldValue, value));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeAttribute> getIncomingNodeAttributes() {
		if (incomingNodeAttributes == null) {
			incomingNodeAttributes = new EObjectWithInverseResolvingEList<NodeAttribute>(NodeAttribute.class, this, CorePackage.DATA_NODE__INCOMING_NODE_ATTRIBUTES, CorePackage.NODE_ATTRIBUTE__TARGET);
		}
		return incomingNodeAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArrowAttribute> getIncomingArrowAtributes() {
		if (incomingArrowAtributes == null) {
			incomingArrowAtributes = new EObjectWithInverseResolvingEList<ArrowAttribute>(ArrowAttribute.class, this, CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES, CorePackage.ARROW_ATTRIBUTE__TARGET);
		}
		return incomingArrowAtributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataNode getTypeDataNode() {
		if (typeDataNode != null && typeDataNode.eIsProxy()) {
			InternalEObject oldTypeDataNode = (InternalEObject)typeDataNode;
			typeDataNode = (DataNode)eResolveProxy(oldTypeDataNode);
			if (typeDataNode != oldTypeDataNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.DATA_NODE__TYPE_DATA_NODE, oldTypeDataNode, typeDataNode));
			}
		}
		return typeDataNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataNode basicGetTypeDataNode() {
		return typeDataNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeDataNode(DataNode newTypeDataNode) {
		DataNode oldTypeDataNode = typeDataNode;
		typeDataNode = newTypeDataNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DATA_NODE__TYPE_DATA_NODE, oldTypeDataNode, typeDataNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDatatype() {
		return datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setDatatype(String newDatatype) {
		String oldDatatype = datatype;
		datatype = newDatatype;
		
	//	setValue(datatype);
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DATA_NODE__DATATYPE, oldDatatype, datatype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDataType() {
		return isDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDataType(boolean newIsDataType) {
		boolean oldIsDataType = isDataType;
		isDataType = newIsDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DATA_NODE__IS_DATA_TYPE, oldIsDataType, isDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getTypeValue() {
		if ((getTypeDataNode() == null) || (getTypeDataNode().getValue() == null)) {
			return "";
		}
		return getTypeDataNode().getValue();
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
			case CorePackage.DATA_NODE__INCOMING_NODE_ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingNodeAttributes()).basicAdd(otherEnd, msgs);
			case CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingArrowAtributes()).basicAdd(otherEnd, msgs);
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
			case CorePackage.DATA_NODE__INCOMING_NODE_ATTRIBUTES:
				return ((InternalEList<?>)getIncomingNodeAttributes()).basicRemove(otherEnd, msgs);
			case CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES:
				return ((InternalEList<?>)getIncomingArrowAtributes()).basicRemove(otherEnd, msgs);
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
			case CorePackage.DATA_NODE__MUTABILITY:
				return getMutability();
			case CorePackage.DATA_NODE__ID:
				return getId();
			case CorePackage.DATA_NODE__VALUE:
				return getValue();
			case CorePackage.DATA_NODE__INCOMING_NODE_ATTRIBUTES:
				return getIncomingNodeAttributes();
			case CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES:
				return getIncomingArrowAtributes();
			case CorePackage.DATA_NODE__TYPE_DATA_NODE:
				if (resolve) return getTypeDataNode();
				return basicGetTypeDataNode();
			case CorePackage.DATA_NODE__DATATYPE:
				return getDatatype();
			case CorePackage.DATA_NODE__IS_DATA_TYPE:
				return isIsDataType();
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
			case CorePackage.DATA_NODE__MUTABILITY:
				setMutability((Integer)newValue);
				return;
			case CorePackage.DATA_NODE__ID:
				setId((String)newValue);
				return;
			case CorePackage.DATA_NODE__VALUE:
				setValue((String)newValue);
				return;
			case CorePackage.DATA_NODE__INCOMING_NODE_ATTRIBUTES:
				getIncomingNodeAttributes().clear();
				getIncomingNodeAttributes().addAll((Collection<? extends NodeAttribute>)newValue);
				return;
			case CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES:
				getIncomingArrowAtributes().clear();
				getIncomingArrowAtributes().addAll((Collection<? extends ArrowAttribute>)newValue);
				return;
			case CorePackage.DATA_NODE__TYPE_DATA_NODE:
				setTypeDataNode((DataNode)newValue);
				return;
			case CorePackage.DATA_NODE__DATATYPE:
				setDatatype((String)newValue);
				return;
			case CorePackage.DATA_NODE__IS_DATA_TYPE:
				setIsDataType((Boolean)newValue);
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
			case CorePackage.DATA_NODE__IS_DATA_TYPE:
				setIsDataType(IS_DATA_TYPE_EDEFAULT);
				return;
			case CorePackage.DATA_NODE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case CorePackage.DATA_NODE__DATATYPE:
				setDatatype(DATATYPE_EDEFAULT);
				return;
			case CorePackage.DATA_NODE__INCOMING_NODE_ATTRIBUTES:
				getIncomingNodeAttributes().clear();
				return;
			case CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES:
				getIncomingArrowAtributes().clear();
				return;
			case CorePackage.DATA_NODE__TYPE_DATA_NODE:
				setTypeDataNode(DPFCoreConstants.REFLEXIVE_TYPE_DATANODE);
				return;
			case CorePackage.DATA_NODE__ID:
				setId(ID_EDEFAULT);
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
			case CorePackage.DATA_NODE__IS_DATA_TYPE:
				return isDataType == IS_DATA_TYPE_EDEFAULT;
			case CorePackage.DATA_NODE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case CorePackage.DATA_NODE__DATATYPE:
				return DATATYPE_EDEFAULT == null ? datatype != null : !DATATYPE_EDEFAULT.equals(datatype);
			case CorePackage.DATA_NODE__MUTABILITY:
				return mutability != MUTABILITY_EDEFAULT;
			case CorePackage.DATA_NODE__INCOMING_NODE_ATTRIBUTES:
				return incomingNodeAttributes != null && !incomingNodeAttributes.isEmpty();
			case CorePackage.DATA_NODE__INCOMING_ARROW_ATRIBUTES:
				return incomingArrowAtributes != null && !incomingArrowAtributes.isEmpty();
			case CorePackage.DATA_NODE__TYPE_DATA_NODE:
				return typeDataNode != null && typeDataNode != DPFCoreConstants.REFLEXIVE_TYPE_DATANODE;
			case CorePackage.DATA_NODE__ID:
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
		if (baseClass == IDObject.class) {
			switch (derivedFeatureID) {
				case CorePackage.DATA_NODE__ID: return CorePackage.ID_OBJECT__ID;
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
		if (baseClass == IDObject.class) {
			switch (baseFeatureID) {
				case CorePackage.ID_OBJECT__ID: return CorePackage.DATA_NODE__ID;
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
		result.append(", id: ");
		result.append(id);
		result.append(", value: ");
		result.append(value);
		result.append(", datatype: ");
		result.append(datatype);
		result.append(", isDataType: ");
		result.append(isDataType);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer,
			int newContainerFeatureID, NotificationChain msgs) {
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if (mutability != 0 && newContainer instanceof Graph && getValue() == null && getTypeDataNode() != null) {
			String name = getTypeDataNode().getValue();
			setValue(name);
		}
		return msgs;
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
	public DataNode getTemplateElement() {
		return getElement(SpecificationImpl.METALEVEL_EDEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean isTemplateElement() {
		if (this == getTemplateElement()) {
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public DataNode getElement(int metalevel) {
		try {
			if (getMetaLevel() == metalevel) {
				return this;
			} else if(getMetaLevel() > metalevel){
				Assert.isNotNull(getTypeValue()); 
				return (DataNode) getTypeDataNode().getElement(metalevel);
			}
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public int getMetaLevel() {
		Specification spec = (Specification) eContainer().eContainer();
		Assert.isNotNull(spec);
		return spec.getMetalevel();
	}
	
} //DataNodeImpl