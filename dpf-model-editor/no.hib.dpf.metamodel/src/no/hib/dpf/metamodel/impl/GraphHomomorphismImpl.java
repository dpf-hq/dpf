/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.Map;

import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Homomorphism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getTyping <em>Typing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphHomomorphismImpl extends EObjectImpl implements GraphHomomorphism {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Graph source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Graph target;

	/**
	 * The cached value of the '{@link #getTyping() <em>Typing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTyping()
	 * @generated
	 * @ordered
	 */
	protected Map<?, ?> typing;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphHomomorphismImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.GRAPH_HOMOMORPHISM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Graph)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Graph newSource) {
		Graph oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Graph)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Graph newTarget) {
		Graph oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> getTyping() {
		return typing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTyping(Map<?, ?> newTyping) {
		Map<?, ?> oldTyping = typing;
		typing = newTyping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.GRAPH_HOMOMORPHISM__TYPING, oldTyping, typing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TYPING:
				return getTyping();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE:
				setSource((Graph)newValue);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET:
				setTarget((Graph)newValue);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TYPING:
				setTyping((Map<?, ?>)newValue);
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE:
				setSource((Graph)null);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET:
				setTarget((Graph)null);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TYPING:
				setTyping((Map<?, ?>)null);
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
			case MetamodelPackage.GRAPH_HOMOMORPHISM__SOURCE:
				return source != null;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TARGET:
				return target != null;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__TYPING:
				return typing != null;
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
		result.append(" (typing: ");
		result.append(typing);
		result.append(')');
		return result.toString();
	}

} //GraphHomomorphismImpl
