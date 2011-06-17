/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticsValidator;
import no.hib.dpf.core.Visualization;

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
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getShape <em>Shape</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getSemanticsValidator <em>Semantics Validator</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getVisualization <em>Visualization</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.PredicateImpl#getSymbol <em>Symbol</em>}</li>
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
	 * The cached value of the '{@link #getSemanticsValidator() <em>Semantics Validator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticsValidator()
	 * @generated
	 * @ordered
	 */
	protected SemanticsValidator semanticsValidator;

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
		return CorePackage.Literals.PREDICATE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SHAPE, oldShape, newShape);
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
				msgs = ((InternalEObject)shape).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__SHAPE, null, msgs);
			if (newShape != null)
				msgs = ((InternalEObject)newShape).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__SHAPE, null, msgs);
			msgs = basicSetShape(newShape, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SHAPE, newShape, newShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticsValidator getSemanticsValidator() {
		return semanticsValidator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSemanticsValidator(SemanticsValidator newSemanticsValidator, NotificationChain msgs) {
		SemanticsValidator oldSemanticsValidator = semanticsValidator;
		semanticsValidator = newSemanticsValidator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SEMANTICS_VALIDATOR, oldSemanticsValidator, newSemanticsValidator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticsValidator(SemanticsValidator newSemanticsValidator) {
		if (newSemanticsValidator != semanticsValidator) {
			NotificationChain msgs = null;
			if (semanticsValidator != null)
				msgs = ((InternalEObject)semanticsValidator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__SEMANTICS_VALIDATOR, null, msgs);
			if (newSemanticsValidator != null)
				msgs = ((InternalEObject)newSemanticsValidator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.PREDICATE__SEMANTICS_VALIDATOR, null, msgs);
			msgs = basicSetSemanticsValidator(newSemanticsValidator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SEMANTICS_VALIDATOR, newSemanticsValidator, newSemanticsValidator));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.PREDICATE__VISUALIZATION, oldVisualization, visualization));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__VISUALIZATION, oldVisualization, visualization));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.PREDICATE__SYMBOL, oldSymbol, symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns a newly created constraint. If the nodes and/or arrows provided don't match the shape
	 * of this predicate, null is returned.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Constraint createConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained) {
		GraphHomomorphism graphHomomorphism = CoreFactory.eINSTANCE.createGraphHomomorphism();
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
		GraphHomomorphism graphHomomorphism = CoreFactory.eINSTANCE.createGraphHomomorphism();
		return graphHomomorphism.tryToCreateGraphHomomorphism(getShape(), nodes, arrows);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		if (getSemanticsValidator() != null) {
			return getSemanticsValidator().validateSemantics(oStar, constraintParameters, typeNodes, typeArrows);
		}
		return true;
	}

	/**
	 * @generated NOT
	 */
	private Constraint constructConstraint(Graph modelToBeConstrained, GraphHomomorphism graphHomomorphism) {
		Constraint retval = CoreFactory.eINSTANCE.createConstraint();
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
			case CorePackage.PREDICATE__SHAPE:
				return basicSetShape(null, msgs);
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				return basicSetSemanticsValidator(null, msgs);
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
			case CorePackage.PREDICATE__SHAPE:
				return getShape();
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				return getSemanticsValidator();
			case CorePackage.PREDICATE__VISUALIZATION:
				if (resolve) return getVisualization();
				return basicGetVisualization();
			case CorePackage.PREDICATE__SYMBOL:
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
			case CorePackage.PREDICATE__SHAPE:
				setShape((Graph)newValue);
				return;
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				setSemanticsValidator((SemanticsValidator)newValue);
				return;
			case CorePackage.PREDICATE__VISUALIZATION:
				setVisualization((Visualization)newValue);
				return;
			case CorePackage.PREDICATE__SYMBOL:
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
			case CorePackage.PREDICATE__SHAPE:
				setShape((Graph)null);
				return;
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				setSemanticsValidator((SemanticsValidator)null);
				return;
			case CorePackage.PREDICATE__VISUALIZATION:
				setVisualization((Visualization)null);
				return;
			case CorePackage.PREDICATE__SYMBOL:
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
			case CorePackage.PREDICATE__SHAPE:
				return shape != null;
			case CorePackage.PREDICATE__SEMANTICS_VALIDATOR:
				return semanticsValidator != null;
			case CorePackage.PREDICATE__VISUALIZATION:
				return visualization != null;
			case CorePackage.PREDICATE__SYMBOL:
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
