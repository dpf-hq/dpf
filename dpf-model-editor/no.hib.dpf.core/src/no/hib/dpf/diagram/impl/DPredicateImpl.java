/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import no.hib.dpf.core.Predicate;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DiagramPackage;

import no.hib.dpf.diagram.Visualization;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DPredicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DPredicateImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DPredicateImpl#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DPredicateImpl#getDGraph <em>DGraph</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DPredicateImpl#getVisualization <em>Visualization</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DPredicateImpl#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DPredicateImpl extends EObjectImpl implements DPredicate {
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
	 * The default value of the '{@link #getSimpleName() <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleName()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSimpleName() <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleName()
	 * @generated
	 * @ordered
	 */
	protected String simpleName = SIMPLE_NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDGraph() <em>DGraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDGraph()
	 * @generated
	 * @ordered
	 */
	protected DGraph dGraph;

	/**
	 * The cached value of the '{@link #getVisualization() <em>Visualization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisualization()
	 * @generated
	 * @ordered
	 */
	protected Visualization visualization;

	/**
	 * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected String icon = ICON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DPREDICATE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DPREDICATE__PREDICATE, oldPredicate, predicate));
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
	 * @generated NOT
	 */
	public void setPredicate(Predicate newPredicate) {
		if(newPredicate == predicate) return;
		if(newPredicate.eIsProxy())
			newPredicate = (Predicate) eResolveProxy((InternalEObject) newPredicate);
		Predicate oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DPREDICATE__PREDICATE, oldPredicate, predicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSimpleName() {
		if(simpleName == null || simpleName.isEmpty())
			simpleName = getPredicate().getSymbol();
		return simpleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleName(String newSimpleName) {
		String oldSimpleName = simpleName;
		simpleName = newSimpleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DPREDICATE__SIMPLE_NAME, oldSimpleName, simpleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DGraph getDGraph() {
		return dGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDGraph(DGraph newDGraph, NotificationChain msgs) {
		DGraph oldDGraph = dGraph;
		dGraph = newDGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DPREDICATE__DGRAPH, oldDGraph, newDGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDGraph(DGraph newDGraph) {
		if (newDGraph != dGraph) {
			NotificationChain msgs = null;
			if (dGraph != null)
				msgs = ((InternalEObject)dGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DPREDICATE__DGRAPH, null, msgs);
			if (newDGraph != null)
				msgs = ((InternalEObject)newDGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DPREDICATE__DGRAPH, null, msgs);
			msgs = basicSetDGraph(newDGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DPREDICATE__DGRAPH, newDGraph, newDGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visualization getVisualization() {
		return visualization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVisualization(Visualization newVisualization, NotificationChain msgs) {
		Visualization oldVisualization = visualization;
		visualization = newVisualization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DPREDICATE__VISUALIZATION, oldVisualization, newVisualization);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisualization(Visualization newVisualization) {
		if (newVisualization != visualization) {
			NotificationChain msgs = null;
			if (visualization != null)
				msgs = ((InternalEObject)visualization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DPREDICATE__VISUALIZATION, null, msgs);
			if (newVisualization != null)
				msgs = ((InternalEObject)newVisualization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DPREDICATE__VISUALIZATION, null, msgs);
			msgs = basicSetVisualization(newVisualization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DPREDICATE__VISUALIZATION, newVisualization, newVisualization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(String newIcon) {
		String oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DPREDICATE__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DPREDICATE__DGRAPH:
				return basicSetDGraph(null, msgs);
			case DiagramPackage.DPREDICATE__VISUALIZATION:
				return basicSetVisualization(null, msgs);
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
			case DiagramPackage.DPREDICATE__PREDICATE:
				if (resolve) return getPredicate();
				return basicGetPredicate();
			case DiagramPackage.DPREDICATE__SIMPLE_NAME:
				return getSimpleName();
			case DiagramPackage.DPREDICATE__DGRAPH:
				return getDGraph();
			case DiagramPackage.DPREDICATE__VISUALIZATION:
				return getVisualization();
			case DiagramPackage.DPREDICATE__ICON:
				return getIcon();
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
			case DiagramPackage.DPREDICATE__PREDICATE:
				setPredicate((Predicate)newValue);
				return;
			case DiagramPackage.DPREDICATE__SIMPLE_NAME:
				setSimpleName((String)newValue);
				return;
			case DiagramPackage.DPREDICATE__DGRAPH:
				setDGraph((DGraph)newValue);
				return;
			case DiagramPackage.DPREDICATE__VISUALIZATION:
				setVisualization((Visualization)newValue);
				return;
			case DiagramPackage.DPREDICATE__ICON:
				setIcon((String)newValue);
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
			case DiagramPackage.DPREDICATE__PREDICATE:
				setPredicate((Predicate)null);
				return;
			case DiagramPackage.DPREDICATE__SIMPLE_NAME:
				setSimpleName(SIMPLE_NAME_EDEFAULT);
				return;
			case DiagramPackage.DPREDICATE__DGRAPH:
				setDGraph((DGraph)null);
				return;
			case DiagramPackage.DPREDICATE__VISUALIZATION:
				setVisualization((Visualization)null);
				return;
			case DiagramPackage.DPREDICATE__ICON:
				setIcon(ICON_EDEFAULT);
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
			case DiagramPackage.DPREDICATE__PREDICATE:
				return predicate != null;
			case DiagramPackage.DPREDICATE__SIMPLE_NAME:
				return SIMPLE_NAME_EDEFAULT == null ? simpleName != null : !SIMPLE_NAME_EDEFAULT.equals(simpleName);
			case DiagramPackage.DPREDICATE__DGRAPH:
				return dGraph != null;
			case DiagramPackage.DPREDICATE__VISUALIZATION:
				return visualization != null;
			case DiagramPackage.DPREDICATE__ICON:
				return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
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
		result.append(" (simpleName: ");
		result.append(simpleName);
		result.append(", icon: ");
		result.append(icon);
		result.append(')');
		return result.toString();
	}

} //DPredicateImpl
