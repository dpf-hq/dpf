/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.Collection;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Predicate;
import no.hib.dpf.metamodel.Semantics;
import no.hib.dpf.metamodel.Visualization;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.PredicateImpl#getShape <em>Shape</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.PredicateImpl#getSemantics <em>Semantics</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.PredicateImpl#getVisualization <em>Visualization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredicateImpl extends EObjectImpl implements Predicate {
	/**
	 * The cached value of the '{@link #getShape() <em>Shape</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShape()
	 * @generated
	 * @ordered
	 */
	protected Graph shape;

	/**
	 * The cached value of the '{@link #getSemantics() <em>Semantics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantics()
	 * @generated
	 * @ordered
	 */
	protected EList<Semantics> semantics;

	/**
	 * The cached value of the '{@link #getVisualization() <em>Visualization</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualization()
	 * @generated
	 * @ordered
	 */
	protected EList<Visualization> visualization;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getShape() {
		if (shape != null && shape.eIsProxy()) {
			InternalEObject oldShape = (InternalEObject)shape;
			shape = (Graph)eResolveProxy(oldShape);
			if (shape != oldShape) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.PREDICATE__SHAPE, oldShape, shape));
			}
		}
		return shape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetShape() {
		return shape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShape(Graph newShape) {
		Graph oldShape = shape;
		shape = newShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PREDICATE__SHAPE, oldShape, shape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Semantics> getSemantics() {
		if (semantics == null) {
			semantics = new EObjectResolvingEList<Semantics>(Semantics.class, this, MetamodelPackage.PREDICATE__SEMANTICS);
		}
		return semantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Visualization> getVisualization() {
		if (visualization == null) {
			visualization = new EObjectResolvingEList<Visualization>(Visualization.class, this, MetamodelPackage.PREDICATE__VISUALIZATION);
		}
		return visualization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.PREDICATE__SHAPE:
				if (resolve) return getShape();
				return basicGetShape();
			case MetamodelPackage.PREDICATE__SEMANTICS:
				return getSemantics();
			case MetamodelPackage.PREDICATE__VISUALIZATION:
				return getVisualization();
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
			case MetamodelPackage.PREDICATE__SHAPE:
				setShape((Graph)newValue);
				return;
			case MetamodelPackage.PREDICATE__SEMANTICS:
				getSemantics().clear();
				getSemantics().addAll((Collection<? extends Semantics>)newValue);
				return;
			case MetamodelPackage.PREDICATE__VISUALIZATION:
				getVisualization().clear();
				getVisualization().addAll((Collection<? extends Visualization>)newValue);
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
			case MetamodelPackage.PREDICATE__SHAPE:
				setShape((Graph)null);
				return;
			case MetamodelPackage.PREDICATE__SEMANTICS:
				getSemantics().clear();
				return;
			case MetamodelPackage.PREDICATE__VISUALIZATION:
				getVisualization().clear();
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
			case MetamodelPackage.PREDICATE__SHAPE:
				return shape != null;
			case MetamodelPackage.PREDICATE__SEMANTICS:
				return semantics != null && !semantics.isEmpty();
			case MetamodelPackage.PREDICATE__VISUALIZATION:
				return visualization != null && !visualization.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PredicateImpl
