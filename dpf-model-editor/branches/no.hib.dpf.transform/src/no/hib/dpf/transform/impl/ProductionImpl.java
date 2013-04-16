/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import java.util.Collection;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Production</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.impl.ProductionImpl#getSum <em>Sum</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.ProductionImpl#getLeftNodes <em>Left Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.ProductionImpl#getRightNodes <em>Right Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.ProductionImpl#getRightArrows <em>Right Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.ProductionImpl#getLeftArrows <em>Left Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.ProductionImpl#getCommonNodes <em>Common Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.ProductionImpl#getCommonArrows <em>Common Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.transform.impl.ProductionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProductionImpl extends EObjectImpl implements Production {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformPackage.Literals.PRODUCTION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformPackage.PRODUCTION__SUM, oldSum, newSum);
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
				msgs = ((InternalEObject)sum).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformPackage.PRODUCTION__SUM, null, msgs);
			if (newSum != null)
				msgs = ((InternalEObject)newSum).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformPackage.PRODUCTION__SUM, null, msgs);
			msgs = basicSetSum(newSum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.PRODUCTION__SUM, newSum, newSum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DNode> getLeftNodes() {
		if (leftNodes == null) {
			leftNodes = new EObjectResolvingEList<DNode>(DNode.class, this, TransformPackage.PRODUCTION__LEFT_NODES);
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
			rightNodes = new EObjectResolvingEList<DNode>(DNode.class, this, TransformPackage.PRODUCTION__RIGHT_NODES);
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
			rightArrows = new EObjectResolvingEList<DArrow>(DArrow.class, this, TransformPackage.PRODUCTION__RIGHT_ARROWS);
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
			leftArrows = new EObjectResolvingEList<DArrow>(DArrow.class, this, TransformPackage.PRODUCTION__LEFT_ARROWS);
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
			commonNodes = new EObjectResolvingEList<DNode>(DNode.class, this, TransformPackage.PRODUCTION__COMMON_NODES);
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
			commonArrows = new EObjectResolvingEList<DArrow>(DArrow.class, this, TransformPackage.PRODUCTION__COMMON_ARROWS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, TransformPackage.PRODUCTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformPackage.PRODUCTION__SUM:
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
			case TransformPackage.PRODUCTION__SUM:
				return getSum();
			case TransformPackage.PRODUCTION__LEFT_NODES:
				return getLeftNodes();
			case TransformPackage.PRODUCTION__RIGHT_NODES:
				return getRightNodes();
			case TransformPackage.PRODUCTION__RIGHT_ARROWS:
				return getRightArrows();
			case TransformPackage.PRODUCTION__LEFT_ARROWS:
				return getLeftArrows();
			case TransformPackage.PRODUCTION__COMMON_NODES:
				return getCommonNodes();
			case TransformPackage.PRODUCTION__COMMON_ARROWS:
				return getCommonArrows();
			case TransformPackage.PRODUCTION__NAME:
				return getName();
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
			case TransformPackage.PRODUCTION__SUM:
				setSum((DSpecification)newValue);
				return;
			case TransformPackage.PRODUCTION__LEFT_NODES:
				getLeftNodes().clear();
				getLeftNodes().addAll((Collection<? extends DNode>)newValue);
				return;
			case TransformPackage.PRODUCTION__RIGHT_NODES:
				getRightNodes().clear();
				getRightNodes().addAll((Collection<? extends DNode>)newValue);
				return;
			case TransformPackage.PRODUCTION__RIGHT_ARROWS:
				getRightArrows().clear();
				getRightArrows().addAll((Collection<? extends DArrow>)newValue);
				return;
			case TransformPackage.PRODUCTION__LEFT_ARROWS:
				getLeftArrows().clear();
				getLeftArrows().addAll((Collection<? extends DArrow>)newValue);
				return;
			case TransformPackage.PRODUCTION__COMMON_NODES:
				getCommonNodes().clear();
				getCommonNodes().addAll((Collection<? extends DNode>)newValue);
				return;
			case TransformPackage.PRODUCTION__COMMON_ARROWS:
				getCommonArrows().clear();
				getCommonArrows().addAll((Collection<? extends DArrow>)newValue);
				return;
			case TransformPackage.PRODUCTION__NAME:
				setName((String)newValue);
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
			case TransformPackage.PRODUCTION__SUM:
				setSum((DSpecification)null);
				return;
			case TransformPackage.PRODUCTION__LEFT_NODES:
				getLeftNodes().clear();
				return;
			case TransformPackage.PRODUCTION__RIGHT_NODES:
				getRightNodes().clear();
				return;
			case TransformPackage.PRODUCTION__RIGHT_ARROWS:
				getRightArrows().clear();
				return;
			case TransformPackage.PRODUCTION__LEFT_ARROWS:
				getLeftArrows().clear();
				return;
			case TransformPackage.PRODUCTION__COMMON_NODES:
				getCommonNodes().clear();
				return;
			case TransformPackage.PRODUCTION__COMMON_ARROWS:
				getCommonArrows().clear();
				return;
			case TransformPackage.PRODUCTION__NAME:
				setName(NAME_EDEFAULT);
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
			case TransformPackage.PRODUCTION__SUM:
				return sum != null;
			case TransformPackage.PRODUCTION__LEFT_NODES:
				return leftNodes != null && !leftNodes.isEmpty();
			case TransformPackage.PRODUCTION__RIGHT_NODES:
				return rightNodes != null && !rightNodes.isEmpty();
			case TransformPackage.PRODUCTION__RIGHT_ARROWS:
				return rightArrows != null && !rightArrows.isEmpty();
			case TransformPackage.PRODUCTION__LEFT_ARROWS:
				return leftArrows != null && !leftArrows.isEmpty();
			case TransformPackage.PRODUCTION__COMMON_NODES:
				return commonNodes != null && !commonNodes.isEmpty();
			case TransformPackage.PRODUCTION__COMMON_ARROWS:
				return commonArrows != null && !commonArrows.isEmpty();
			case TransformPackage.PRODUCTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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

} //ProductionImpl
