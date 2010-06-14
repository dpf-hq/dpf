/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.Map;
import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelPackage;

import no.hib.dpf.metamodel.Node;
import no.hib.dpf.metamodel.Predicate;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getConstrainedModel <em>Constrained Model</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getEdgeMappings <em>Edge Mappings</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.ConstraintImpl#getNodeMappings <em>Node Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends EObjectImpl implements Constraint {
	/**
	 * The cached value of the '{@link #getConstrainedModel() <em>Constrained Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedModel()
	 * @generated
	 * @ordered
	 */
	protected Graph constrainedModel;

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
	 * The cached value of the '{@link #getEdgeMappings() <em>Edge Mappings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeMappings()
	 * @generated
	 * @ordered
	 */
	protected Map.Entry<Edge, Edge> edgeMappings;

	/**
	 * The cached value of the '{@link #getNodeMappings() <em>Node Mappings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeMappings()
	 * @generated
	 * @ordered
	 */
	protected Map.Entry<Node, Node> nodeMappings;

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
	public Graph getConstrainedModel() {
		if (constrainedModel != null && constrainedModel.eIsProxy()) {
			InternalEObject oldConstrainedModel = (InternalEObject)constrainedModel;
			constrainedModel = (Graph)eResolveProxy(oldConstrainedModel);
			if (constrainedModel != oldConstrainedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL, oldConstrainedModel, constrainedModel));
			}
		}
		return constrainedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetConstrainedModel() {
		return constrainedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstrainedModel(Graph newConstrainedModel) {
		Graph oldConstrainedModel = constrainedModel;
		constrainedModel = newConstrainedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL, oldConstrainedModel, constrainedModel));
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
	@SuppressWarnings("unchecked")
	public Map.Entry<Edge, Edge> getEdgeMappings() {
		if (edgeMappings != null && ((EObject)edgeMappings).eIsProxy()) {
			InternalEObject oldEdgeMappings = (InternalEObject)edgeMappings;
			edgeMappings = (Map.Entry<Edge, Edge>)eResolveProxy(oldEdgeMappings);
			if (edgeMappings != oldEdgeMappings) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__EDGE_MAPPINGS, oldEdgeMappings, edgeMappings));
			}
		}
		return edgeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Edge, Edge> basicGetEdgeMappings() {
		return edgeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeMappings(Map.Entry<Edge, Edge> newEdgeMappings) {
		Map.Entry<Edge, Edge> oldEdgeMappings = edgeMappings;
		edgeMappings = newEdgeMappings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__EDGE_MAPPINGS, oldEdgeMappings, edgeMappings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Map.Entry<Node, Node> getNodeMappings() {
		if (nodeMappings != null && ((EObject)nodeMappings).eIsProxy()) {
			InternalEObject oldNodeMappings = (InternalEObject)nodeMappings;
			nodeMappings = (Map.Entry<Node, Node>)eResolveProxy(oldNodeMappings);
			if (nodeMappings != oldNodeMappings) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.CONSTRAINT__NODE_MAPPINGS, oldNodeMappings, nodeMappings));
			}
		}
		return nodeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Node, Node> basicGetNodeMappings() {
		return nodeMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeMappings(Map.Entry<Node, Node> newNodeMappings) {
		Map.Entry<Node, Node> oldNodeMappings = nodeMappings;
		nodeMappings = newNodeMappings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.CONSTRAINT__NODE_MAPPINGS, oldNodeMappings, nodeMappings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL:
				if (resolve) return getConstrainedModel();
				return basicGetConstrainedModel();
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				if (resolve) return getPredicate();
				return basicGetPredicate();
			case MetamodelPackage.CONSTRAINT__EDGE_MAPPINGS:
				if (resolve) return getEdgeMappings();
				return basicGetEdgeMappings();
			case MetamodelPackage.CONSTRAINT__NODE_MAPPINGS:
				if (resolve) return getNodeMappings();
				return basicGetNodeMappings();
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL:
				setConstrainedModel((Graph)newValue);
				return;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				setPredicate((Predicate)newValue);
				return;
			case MetamodelPackage.CONSTRAINT__EDGE_MAPPINGS:
				setEdgeMappings((Map.Entry<Edge, Edge>)newValue);
				return;
			case MetamodelPackage.CONSTRAINT__NODE_MAPPINGS:
				setNodeMappings((Map.Entry<Node, Node>)newValue);
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL:
				setConstrainedModel((Graph)null);
				return;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				setPredicate((Predicate)null);
				return;
			case MetamodelPackage.CONSTRAINT__EDGE_MAPPINGS:
				setEdgeMappings((Map.Entry<Edge, Edge>)null);
				return;
			case MetamodelPackage.CONSTRAINT__NODE_MAPPINGS:
				setNodeMappings((Map.Entry<Node, Node>)null);
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
			case MetamodelPackage.CONSTRAINT__CONSTRAINED_MODEL:
				return constrainedModel != null;
			case MetamodelPackage.CONSTRAINT__PREDICATE:
				return predicate != null;
			case MetamodelPackage.CONSTRAINT__EDGE_MAPPINGS:
				return edgeMappings != null;
			case MetamodelPackage.CONSTRAINT__NODE_MAPPINGS:
				return nodeMappings != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstraintImpl
