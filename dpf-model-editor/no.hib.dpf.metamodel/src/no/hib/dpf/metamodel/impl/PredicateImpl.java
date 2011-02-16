/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Node;
import no.hib.dpf.metamodel.Predicate;
import no.hib.dpf.metamodel.Semantics;
import no.hib.dpf.metamodel.Visualization;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

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
 *   <li>{@link no.hib.dpf.metamodel.impl.PredicateImpl#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredicateImpl extends EObjectImpl implements Predicate {
	/**
	 * The cached value of the '{@link #getShape() <em>Shape</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShape()
	 * @generated
	 * @ordered
	 */
	protected Graph shape;

	/**
	 * The cached value of the '{@link #getSemantics() <em>Semantics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemantics()
	 * @generated
	 * @ordered
	 */
	protected Semantics semantics;

	/**
	 * The cached value of the '{@link #getVisualization() <em>Visualization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualization()
	 * @generated
	 * @ordered
	 */
	protected Visualization visualization;

	/**
	 * The default value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected String symbol = SYMBOL_EDEFAULT;

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
		return shape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShape(Graph newShape, NotificationChain msgs) {
		Graph oldShape = shape;
		shape = newShape;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.PREDICATE__SHAPE, oldShape, newShape);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShape(Graph newShape) {
		if (newShape != shape) {
			NotificationChain msgs = null;
			if (shape != null)
				msgs = ((InternalEObject)shape).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.PREDICATE__SHAPE, null, msgs);
			if (newShape != null)
				msgs = ((InternalEObject)newShape).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.PREDICATE__SHAPE, null, msgs);
			msgs = basicSetShape(newShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PREDICATE__SHAPE, newShape, newShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Semantics getSemantics() {
		return semantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSemantics(Semantics newSemantics, NotificationChain msgs) {
		Semantics oldSemantics = semantics;
		semantics = newSemantics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetamodelPackage.PREDICATE__SEMANTICS, oldSemantics, newSemantics);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemantics(Semantics newSemantics) {
		if (newSemantics != semantics) {
			NotificationChain msgs = null;
			if (semantics != null)
				msgs = ((InternalEObject)semantics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.PREDICATE__SEMANTICS, null, msgs);
			if (newSemantics != null)
				msgs = ((InternalEObject)newSemantics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetamodelPackage.PREDICATE__SEMANTICS, null, msgs);
			msgs = basicSetSemantics(newSemantics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PREDICATE__SEMANTICS, newSemantics, newSemantics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visualization getVisualization() {
		if (visualization != null && visualization.eIsProxy()) {
			InternalEObject oldVisualization = (InternalEObject)visualization;
			visualization = (Visualization)eResolveProxy(oldVisualization);
			if (visualization != oldVisualization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.PREDICATE__VISUALIZATION, oldVisualization, visualization));
			}
		}
		return visualization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visualization basicGetVisualization() {
		return visualization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualization(Visualization newVisualization) {
		Visualization oldVisualization = visualization;
		visualization = newVisualization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PREDICATE__VISUALIZATION, oldVisualization, visualization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbol(String newSymbol) {
		String oldSymbol = symbol;
		symbol = newSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.PREDICATE__SYMBOL, oldSymbol, symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns a newly created constraint. If the nodes and/or edges provided don't match the shape
	 * of this predicate, null is returned.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Constraint createConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained) {
		GraphHomomorphism graphHomomorphism = MetamodelFactory.eINSTANCE.createGraphHomomorphism();
		if (graphHomomorphism.tryToCreateGraphHomomorphism(getShape(), nodes, arrows)) {
			return constructConstraint(modelToBeConstrained, graphHomomorphism);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCreateConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained) {
		GraphHomomorphism graphHomomorphism = MetamodelFactory.eINSTANCE.createGraphHomomorphism();
		return graphHomomorphism.tryToCreateGraphHomomorphism(getShape(), nodes, arrows);
	}

	/**
	 * @generated NOT
	 */
	private Constraint constructConstraint(Graph modelToBeConstrained, GraphHomomorphism graphHomomorphism) {
		Constraint retval = MetamodelFactory.eINSTANCE.createConstraint();
		retval.setMappings(graphHomomorphism);
		retval.setPredicate(this);
		retval.setGraph(modelToBeConstrained);
		return retval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.PREDICATE__SHAPE:
				return basicSetShape(null, msgs);
			case MetamodelPackage.PREDICATE__SEMANTICS:
				return basicSetSemantics(null, msgs);
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
			case MetamodelPackage.PREDICATE__SHAPE:
				return getShape();
			case MetamodelPackage.PREDICATE__SEMANTICS:
				return getSemantics();
			case MetamodelPackage.PREDICATE__VISUALIZATION:
				if (resolve) return getVisualization();
				return basicGetVisualization();
			case MetamodelPackage.PREDICATE__SYMBOL:
				return getSymbol();
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
			case MetamodelPackage.PREDICATE__SHAPE:
				setShape((Graph)newValue);
				return;
			case MetamodelPackage.PREDICATE__SEMANTICS:
				setSemantics((Semantics)newValue);
				return;
			case MetamodelPackage.PREDICATE__VISUALIZATION:
				setVisualization((Visualization)newValue);
				return;
			case MetamodelPackage.PREDICATE__SYMBOL:
				setSymbol((String)newValue);
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
				setSemantics((Semantics)null);
				return;
			case MetamodelPackage.PREDICATE__VISUALIZATION:
				setVisualization((Visualization)null);
				return;
			case MetamodelPackage.PREDICATE__SYMBOL:
				setSymbol(SYMBOL_EDEFAULT);
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
				return semantics != null;
			case MetamodelPackage.PREDICATE__VISUALIZATION:
				return visualization != null;
			case MetamodelPackage.PREDICATE__SYMBOL:
				return SYMBOL_EDEFAULT == null ? symbol != null : !SYMBOL_EDEFAULT.equals(symbol);
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
		result.append(" (symbol: ");
		result.append(symbol);
		result.append(')');
		return result.toString();
	}

} //PredicateImpl
