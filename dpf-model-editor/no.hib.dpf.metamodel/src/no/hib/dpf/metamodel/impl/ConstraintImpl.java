/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends IDObjectImpl implements Constraint {
	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected Predicate predicate;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected GraphHomomorphism mappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (eContainerFeatureID() != MetamodelPackage.CONSTRAINT__GRAPH) return null;
		return (Graph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, MetamodelPackage.CONSTRAINT__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != MetamodelPackage.CONSTRAINT__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, MetamodelPackage.GRAPH__CONSTRAINTS, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate getPredicate() {
		if (predicate != null && predicate.eIsProxy()) {
			InternalEObject oldPredicate = (InternalEObject)predicate;
			predicate = (Predicate)eResolveProxy(oldPredicate);
			if (predicate != oldPredicate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__PREDICATE, oldPredicate, predicate));
			}
		}
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate basicGetPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(Predicate newPredicate) {
		Predicate oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__PREDICATE, oldPredicate, predicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphHomomorphism getMappings() {
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappings(GraphHomomorphism newMappings, NotificationChain msgs) {
		GraphHomomorphism oldMappings = mappings;
		mappings = newMappings;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__MAPPINGS, oldMappings, newMappings);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappings(GraphHomomorphism newMappings) {
		if (newMappings != mappings) {
			NotificationChain msgs = null;
			if (mappings != null)
				msgs = ((InternalEObject)mappings).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.CONSTRAINT__MAPPINGS, null, msgs);
			if (newMappings != null)
				msgs = ((InternalEObject)newMappings).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.CONSTRAINT__MAPPINGS, null, msgs);
			msgs = basicSetMappings(newMappings, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__MAPPINGS, newMappings, newMappings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.CONSTRAINT__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
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
			case MetamodelPackage.CONSTRAINT__GRAPH:
				return basicSetGraph(null, msgs);
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				return basicSetMappings(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case MetamodelPackage.CONSTRAINT__GRAPH:
				return eInternalContainer().eInverseRemove(this, MetamodelPackage.GRAPH__CONSTRAINTS, Graph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.CONSTRAINT__GRAPH:
				return getGraph();
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				if (resolve) return getPredicate();
				return basicGetPredicate();
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				return getMappings();
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
			case MetamodelPackage.CONSTRAINT__GRAPH:
				setGraph((Graph)newValue);
				return;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				setPredicate((Predicate)newValue);
				return;
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				setMappings((GraphHomomorphism)newValue);
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
			case MetamodelPackage.CONSTRAINT__GRAPH:
				setGraph((Graph)null);
				return;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				setPredicate((Predicate)null);
				return;
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				setMappings((GraphHomomorphism)null);
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
			case MetamodelPackage.CONSTRAINT__GRAPH:
				return getGraph() != null;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				return predicate != null;
			case MetamodelPackage.CONSTRAINT__MAPPINGS:
				return mappings != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstraintImpl
