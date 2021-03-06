/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.visualization.impl;

import java.util.Collection;

import no.hib.dpf.diagram.DNode;
import no.hib.dpf.visual.impl.VElementImpl;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationPackage;

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
 * An implementation of the model object '<em><b>VCompartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.visualization.impl.VCompartmentImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.impl.VCompartmentImpl#getCompartmentDNode <em>Compartment DNode</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.impl.VCompartmentImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VCompartmentImpl extends VElementImpl implements VCompartment {
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected DNode parent;

	/**
	 * The cached value of the '{@link #getCompartmentDNode() <em>Compartment DNode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartmentDNode()
	 * @generated
	 * @ordered
	 */
	protected DNode compartmentDNode;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<VCompartmentElement> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisualizationPackage.Literals.VCOMPARTMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DNode getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (DNode)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisualizationPackage.VCOMPARTMENT__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(DNode newParent) {
		DNode oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualizationPackage.VCOMPARTMENT__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode getCompartmentDNode() {
		if (compartmentDNode != null && compartmentDNode.eIsProxy()) {
			InternalEObject oldCompartmentDNode = (InternalEObject)compartmentDNode;
			compartmentDNode = (DNode)eResolveProxy(oldCompartmentDNode);
			if (compartmentDNode != oldCompartmentDNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisualizationPackage.VCOMPARTMENT__COMPARTMENT_DNODE, oldCompartmentDNode, compartmentDNode));
			}
		}
		return compartmentDNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode basicGetCompartmentDNode() {
		return compartmentDNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompartmentDNode(DNode newCompartmentDNode) {
		DNode oldCompartmentDNode = compartmentDNode;
		compartmentDNode = newCompartmentDNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualizationPackage.VCOMPARTMENT__COMPARTMENT_DNODE, oldCompartmentDNode, compartmentDNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VCompartmentElement> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<VCompartmentElement>(VCompartmentElement.class, this, VisualizationPackage.VCOMPARTMENT__CHILDREN);
		}
		return children;
	}

	@Override
	public void addChild(VCompartmentElement child) {
		getChildren().add(child);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VisualizationPackage.VCOMPARTMENT__CHILDREN:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisualizationPackage.VCOMPARTMENT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case VisualizationPackage.VCOMPARTMENT__COMPARTMENT_DNODE:
				if (resolve) return getCompartmentDNode();
				return basicGetCompartmentDNode();
			case VisualizationPackage.VCOMPARTMENT__CHILDREN:
				return getChildren();
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
			case VisualizationPackage.VCOMPARTMENT__PARENT:
				setParent((DNode)newValue);
				return;
			case VisualizationPackage.VCOMPARTMENT__COMPARTMENT_DNODE:
				setCompartmentDNode((DNode)newValue);
				return;
			case VisualizationPackage.VCOMPARTMENT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends VCompartmentElement>)newValue);
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
			case VisualizationPackage.VCOMPARTMENT__PARENT:
				setParent((DNode)null);
				return;
			case VisualizationPackage.VCOMPARTMENT__COMPARTMENT_DNODE:
				setCompartmentDNode((DNode)null);
				return;
			case VisualizationPackage.VCOMPARTMENT__CHILDREN:
				getChildren().clear();
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
			case VisualizationPackage.VCOMPARTMENT__PARENT:
				return parent != null;
			case VisualizationPackage.VCOMPARTMENT__COMPARTMENT_DNODE:
				return compartmentDNode != null;
			case VisualizationPackage.VCOMPARTMENT__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VCompartmentImpl
