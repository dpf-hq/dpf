/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import java.util.Collection;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DComposedConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DFakeNode;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DComposed Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DComposedConstraintImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DComposedConstraintImpl#getFakeNode <em>Fake Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DComposedConstraintImpl extends DConstraintImpl implements DComposedConstraint {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<DConstraint> children;

	/**
	 * The cached value of the '{@link #getFakeNode() <em>Fake Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFakeNode()
	 * @generated
	 * @ordered
	 */
	protected DFakeNode fakeNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DComposedConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DFakeNode basicGetFakeNode() {
		return fakeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void disconnect() {
		DSpecification dSpecification = (DSpecification) eContainer();
		for(DConstraint constraint : children){
			DGenericArrowConstraint generic = (DGenericArrowConstraint) constraint;
			generic.setDSource(null);
			generic.setDTarget(null);
		}
		dSpecification.getDGraph().removeDNode(getFakeNode());
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
			case DiagramPackage.DCOMPOSED_CONSTRAINT__CHILDREN:
				return getChildren();
			case DiagramPackage.DCOMPOSED_CONSTRAINT__FAKE_NODE:
				if (resolve) return getFakeNode();
				return basicGetFakeNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DCOMPOSED_CONSTRAINT__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagramPackage.DCOMPOSED_CONSTRAINT__CHILDREN:
				return children != null && !children.isEmpty();
			case DiagramPackage.DCOMPOSED_CONSTRAINT__FAKE_NODE:
				return fakeNode != null;
		}
		return super.eIsSet(featureID);
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
			case DiagramPackage.DCOMPOSED_CONSTRAINT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends DConstraint>)newValue);
				return;
			case DiagramPackage.DCOMPOSED_CONSTRAINT__FAKE_NODE:
				setFakeNode((DFakeNode)newValue);
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
		return DiagramPackage.Literals.DCOMPOSED_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramPackage.DCOMPOSED_CONSTRAINT__CHILDREN:
				getChildren().clear();
				return;
			case DiagramPackage.DCOMPOSED_CONSTRAINT__FAKE_NODE:
				setFakeNode((DFakeNode)null);
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
	public EList<DConstraint> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<DConstraint>(DConstraint.class, this, DiagramPackage.DCOMPOSED_CONSTRAINT__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DFakeNode getFakeNode() {
		if (fakeNode != null && fakeNode.eIsProxy()) {
			InternalEObject oldFakeNode = (InternalEObject)fakeNode;
			fakeNode = (DFakeNode)eResolveProxy(oldFakeNode);
			if (fakeNode != oldFakeNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DCOMPOSED_CONSTRAINT__FAKE_NODE, oldFakeNode, fakeNode));
			}
		}
		return fakeNode;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void reconnect(EList<DNode> dNodes, EList<DArrow> dArrows, DSpecification dSpecification) {
		super.reconnect(dNodes, dArrows, dSpecification);
		dSpecification.getDGraph().addDNode(getFakeNode());
		for (int i = 0; i < children.size(); i++) {
			DGenericArrowConstraint generic = (DGenericArrowConstraint) children.get(i);
			generic.setDSource(getFakeNode());
			generic.setDTarget(dArrows.get(i));
		}
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFakeNode(DFakeNode newFakeNode) {
		DFakeNode oldFakeNode = fakeNode;
		fakeNode = newFakeNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DCOMPOSED_CONSTRAINT__FAKE_NODE, oldFakeNode, fakeNode));
	}

} //DComposedConstraintImpl
