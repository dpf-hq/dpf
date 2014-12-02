/**
 */
package no.hib.dpf.uconstraint.impl;

import java.util.Collection;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.uconstraint.UCType;
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.UConstraintPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UConstraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getSum <em>Sum</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getLeftNodes <em>Left Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getRightNodes <em>Right Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getRightArrows <em>Right Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getLeftArrows <em>Left Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getCommonNodes <em>Common Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getCommonArrows <em>Common Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.impl.UConstraintImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UConstraintImpl extends EObjectImpl implements UConstraint {
	/**
	 * The cached value of the '{@link #getSum() <em>Sum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSum()
	 * @generated
	 * @ordered
	 */
	protected DSpecification sum;

	/**
	 * The cached value of the '{@link #getLeftNodes() <em>Left Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DNode> leftNodes;

	/**
	 * The cached value of the '{@link #getRightNodes() <em>Right Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DNode> rightNodes;

	/**
	 * The cached value of the '{@link #getRightArrows() <em>Right Arrows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightArrows()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrow> rightArrows;

	/**
	 * The cached value of the '{@link #getLeftArrows() <em>Left Arrows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftArrows()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrow> leftArrows;

	/**
	 * The cached value of the '{@link #getCommonNodes() <em>Common Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommonNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DNode> commonNodes;

	/**
	 * The cached value of the '{@link #getCommonArrows() <em>Common Arrows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommonArrows()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrow> commonArrows;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final UCType TYPE_EDEFAULT = UCType.ALL_LEFT_EXIST_RIGHT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected UCType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UConstraintPackage.Literals.UCONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification getSum() {
		return sum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSum(DSpecification newSum, NotificationChain msgs) {
		DSpecification oldSum = sum;
		sum = newSum;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UConstraintPackage.UCONSTRAINT__SUM, oldSum, newSum);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSum(DSpecification newSum) {
		if (newSum != sum) {
			NotificationChain msgs = null;
			if (sum != null)
				msgs = ((InternalEObject)sum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UConstraintPackage.UCONSTRAINT__SUM, null, msgs);
			if (newSum != null)
				msgs = ((InternalEObject)newSum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UConstraintPackage.UCONSTRAINT__SUM, null, msgs);
			msgs = basicSetSum(newSum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UConstraintPackage.UCONSTRAINT__SUM, newSum, newSum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DNode> getLeftNodes() {
		if (leftNodes == null) {
			leftNodes = new EObjectResolvingEList<DNode>(DNode.class, this, UConstraintPackage.UCONSTRAINT__LEFT_NODES);
		}
		return leftNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DNode> getRightNodes() {
		if (rightNodes == null) {
			rightNodes = new EObjectResolvingEList<DNode>(DNode.class, this, UConstraintPackage.UCONSTRAINT__RIGHT_NODES);
		}
		return rightNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DArrow> getRightArrows() {
		if (rightArrows == null) {
			rightArrows = new EObjectResolvingEList<DArrow>(DArrow.class, this, UConstraintPackage.UCONSTRAINT__RIGHT_ARROWS);
		}
		return rightArrows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DArrow> getLeftArrows() {
		if (leftArrows == null) {
			leftArrows = new EObjectResolvingEList<DArrow>(DArrow.class, this, UConstraintPackage.UCONSTRAINT__LEFT_ARROWS);
		}
		return leftArrows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DNode> getCommonNodes() {
		if (commonNodes == null) {
			commonNodes = new EObjectResolvingEList<DNode>(DNode.class, this, UConstraintPackage.UCONSTRAINT__COMMON_NODES);
		}
		return commonNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DArrow> getCommonArrows() {
		if (commonArrows == null) {
			commonArrows = new EObjectResolvingEList<DArrow>(DArrow.class, this, UConstraintPackage.UCONSTRAINT__COMMON_ARROWS);
		}
		return commonArrows;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UConstraintPackage.UCONSTRAINT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(UCType newType) {
		UCType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UConstraintPackage.UCONSTRAINT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UConstraintPackage.UCONSTRAINT__SUM:
				return basicSetSum(null, msgs);
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
			case UConstraintPackage.UCONSTRAINT__SUM:
				return getSum();
			case UConstraintPackage.UCONSTRAINT__LEFT_NODES:
				return getLeftNodes();
			case UConstraintPackage.UCONSTRAINT__RIGHT_NODES:
				return getRightNodes();
			case UConstraintPackage.UCONSTRAINT__RIGHT_ARROWS:
				return getRightArrows();
			case UConstraintPackage.UCONSTRAINT__LEFT_ARROWS:
				return getLeftArrows();
			case UConstraintPackage.UCONSTRAINT__COMMON_NODES:
				return getCommonNodes();
			case UConstraintPackage.UCONSTRAINT__COMMON_ARROWS:
				return getCommonArrows();
			case UConstraintPackage.UCONSTRAINT__NAME:
				return getName();
			case UConstraintPackage.UCONSTRAINT__TYPE:
				return getType();
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
			case UConstraintPackage.UCONSTRAINT__SUM:
				setSum((DSpecification)newValue);
				return;
			case UConstraintPackage.UCONSTRAINT__LEFT_NODES:
				getLeftNodes().clear();
				getLeftNodes().addAll((Collection<? extends DNode>)newValue);
				return;
			case UConstraintPackage.UCONSTRAINT__RIGHT_NODES:
				getRightNodes().clear();
				getRightNodes().addAll((Collection<? extends DNode>)newValue);
				return;
			case UConstraintPackage.UCONSTRAINT__RIGHT_ARROWS:
				getRightArrows().clear();
				getRightArrows().addAll((Collection<? extends DArrow>)newValue);
				return;
			case UConstraintPackage.UCONSTRAINT__LEFT_ARROWS:
				getLeftArrows().clear();
				getLeftArrows().addAll((Collection<? extends DArrow>)newValue);
				return;
			case UConstraintPackage.UCONSTRAINT__COMMON_NODES:
				getCommonNodes().clear();
				getCommonNodes().addAll((Collection<? extends DNode>)newValue);
				return;
			case UConstraintPackage.UCONSTRAINT__COMMON_ARROWS:
				getCommonArrows().clear();
				getCommonArrows().addAll((Collection<? extends DArrow>)newValue);
				return;
			case UConstraintPackage.UCONSTRAINT__NAME:
				setName((String)newValue);
				return;
			case UConstraintPackage.UCONSTRAINT__TYPE:
				setType((UCType)newValue);
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
			case UConstraintPackage.UCONSTRAINT__SUM:
				setSum((DSpecification)null);
				return;
			case UConstraintPackage.UCONSTRAINT__LEFT_NODES:
				getLeftNodes().clear();
				return;
			case UConstraintPackage.UCONSTRAINT__RIGHT_NODES:
				getRightNodes().clear();
				return;
			case UConstraintPackage.UCONSTRAINT__RIGHT_ARROWS:
				getRightArrows().clear();
				return;
			case UConstraintPackage.UCONSTRAINT__LEFT_ARROWS:
				getLeftArrows().clear();
				return;
			case UConstraintPackage.UCONSTRAINT__COMMON_NODES:
				getCommonNodes().clear();
				return;
			case UConstraintPackage.UCONSTRAINT__COMMON_ARROWS:
				getCommonArrows().clear();
				return;
			case UConstraintPackage.UCONSTRAINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UConstraintPackage.UCONSTRAINT__TYPE:
				setType(TYPE_EDEFAULT);
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
			case UConstraintPackage.UCONSTRAINT__SUM:
				return sum != null;
			case UConstraintPackage.UCONSTRAINT__LEFT_NODES:
				return leftNodes != null && !leftNodes.isEmpty();
			case UConstraintPackage.UCONSTRAINT__RIGHT_NODES:
				return rightNodes != null && !rightNodes.isEmpty();
			case UConstraintPackage.UCONSTRAINT__RIGHT_ARROWS:
				return rightArrows != null && !rightArrows.isEmpty();
			case UConstraintPackage.UCONSTRAINT__LEFT_ARROWS:
				return leftArrows != null && !leftArrows.isEmpty();
			case UConstraintPackage.UCONSTRAINT__COMMON_NODES:
				return commonNodes != null && !commonNodes.isEmpty();
			case UConstraintPackage.UCONSTRAINT__COMMON_ARROWS:
				return commonArrows != null && !commonArrows.isEmpty();
			case UConstraintPackage.UCONSTRAINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UConstraintPackage.UCONSTRAINT__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

	@Override
	public void setAdded(DNode dNode) {
		if(getLeftNodes().contains(dNode)){
			getLeftNodes().remove(dNode);
			if(isKept(dNode))
				getCommonNodes().remove(dNode);
		}
		if(!getRightNodes().contains(dNode))
			getRightNodes().add(dNode);
	}

	@Override
	public boolean isAdded(DNode node) {
		return !isKept(node) && getRightNodes().contains(node);
	}

	@Override
	public void setDeled(DNode dNode) {
		if(getRightNodes().contains(dNode)){
			getRightNodes().remove(dNode);
			if(isKept(dNode))
				getCommonNodes().remove(dNode);
		}
		if(!getLeftNodes().contains(dNode))
			getLeftNodes().add(dNode);
	}

	@Override
	public boolean isDeled(DNode node) {
		return !isKept(node) && getLeftNodes().contains(node);
	}

	@Override
	public void setKept(DNode dNode, boolean is) {
		boolean isKept = isKept(dNode);
		if(is){
			if(!isKept) {
				if(!getRightNodes().contains(dNode))
					getRightNodes().add(dNode);
				if(!getLeftNodes().contains(dNode))
					getLeftNodes().add(dNode);
				getCommonNodes().add(dNode);
			}
		}else{
			if(getRightNodes().contains(dNode))
				getRightNodes().remove(dNode);
			if(getLeftNodes().contains(dNode))
				getLeftNodes().remove(dNode);
			if(getCommonNodes().contains(dNode))
				getCommonNodes().remove(dNode);
		}
	}

	@Override
	public boolean isKept(DNode node) {
		return getCommonNodes().contains(node);
	}

	@Override
	public void setAdded(DArrow dArrow) {
		if(getLeftArrows().contains(dArrow)){
			getLeftArrows().remove(dArrow);
			if(isKept(dArrow))
				getCommonArrows().remove(dArrow);
		}
		if(!getRightArrows().contains(dArrow))
			getRightArrows().add(dArrow);
	}

	@Override
	public boolean isAdded(DArrow dArrow) {
		return !isKept(dArrow) && getRightArrows().contains(dArrow);
	}

	@Override
	public void setDeled(DArrow dArrow) {
		if(getRightArrows().contains(dArrow)){
			getRightArrows().remove(dArrow);
			if(isKept(dArrow))
				getCommonArrows().remove(dArrow);
		}
		if(!getLeftArrows().contains(dArrow))
			getLeftArrows().add(dArrow);
	}

	@Override
	public boolean isDeled(DArrow dArrow) {
		return !isKept(dArrow) && getLeftArrows().contains(dArrow);
	}

	@Override
	public void setKept(DArrow dArrow, boolean is) {
		boolean isKept = isKept(dArrow);
		if(is){
			if(!isKept) {
				if(!getRightArrows().contains(dArrow))
					getRightArrows().add(dArrow);
				if(!getLeftArrows().contains(dArrow))
					getLeftArrows().add(dArrow);
				getCommonArrows().add(dArrow);
			}
		}
		else {
			if(getRightArrows().contains(dArrow))
				getRightArrows().remove(dArrow);
			if(getLeftArrows().contains(dArrow))
				getLeftArrows().remove(dArrow);
			if(getCommonArrows().contains(dArrow))
				getCommonArrows().remove(dArrow);
		}
	}

	@Override
	public boolean isKept(DArrow arrow) {
		return getCommonArrows().contains(arrow);
	}
} //UConstraintImpl
