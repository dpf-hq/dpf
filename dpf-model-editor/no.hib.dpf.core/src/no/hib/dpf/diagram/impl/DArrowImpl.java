/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import java.util.Collection;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.utils.DPFConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DArrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getArrow <em>Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getLineStyle <em>Line Style</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getDSource <em>DSource</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getDTarget <em>DTarget</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getBendpoints <em>Bendpoints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getNameOffset <em>Name Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getConstraintOffset <em>Constraint Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getConstraintsFrom <em>Constraints From</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowImpl#getConstraintsTo <em>Constraints To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DArrowImpl extends EObjectImpl implements DArrow {

	/**
	 * The cached value of the '{@link #getDType() <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDType()
	 * @generated
	 * @ordered
	 */
	protected DArrow dType;

	/**
	 * The cached value of the '{@link #getArrow() <em>Arrow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrow()
	 * @generated
	 * @ordered
	 */
	protected Arrow arrow;

	/**
	 * The default value of the '{@link #getConfigureString() <em>Configure String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigureString()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIGURE_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigureString() <em>Configure String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigureString()
	 * @generated
	 * @ordered
	 */
	protected String configureString = CONFIGURE_STRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineStyle() <em>Line Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineStyle()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_STYLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineStyle() <em>Line Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineStyle()
	 * @generated
	 * @ordered
	 */
	protected int lineStyle = LINE_STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDSource() <em>DSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDSource()
	 * @generated
	 * @ordered
	 */
	protected DNode dSource;

	/**
	 * The cached value of the '{@link #getDTarget() <em>DTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDTarget()
	 * @generated
	 * @ordered
	 */
	protected DNode dTarget;

	/**
	 * The cached value of the '{@link #getDConstraints() <em>DConstraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<DConstraint> dConstraints;

	/**
	 * The cached value of the '{@link #getBendpoints() <em>Bendpoints</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBendpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<Point> bendpoints;

	/**
	 * The cached value of the '{@link #getNameOffset() <em>Name Offset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameOffset()
	 * @generated
	 * @ordered
	 */
	protected DOffset nameOffset;

	/**
	 * The cached value of the '{@link #getConstraintOffset() <em>Constraint Offset</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintOffset()
	 * @generated
	 * @ordered
	 */
	protected EList<DOffset> constraintOffset;

	/**
	 * The cached value of the '{@link #getConstraintsFrom() <em>Constraints From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintsFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<DConstraint> constraintsFrom;

	/**
	 * The cached value of the '{@link #getConstraintsTo() <em>Constraints To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintsTo()
	 * @generated
	 * @ordered
	 */
	protected EList<DConstraint> constraintsTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DArrowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DARROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DArrow getDType() {
		if (dType != null && dType.eIsProxy()) {
			InternalEObject oldDType = (InternalEObject)dType;
			dType = (DArrow)eResolveProxy(oldDType);
			if (dType != oldDType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DARROW__DTYPE, oldDType, dType));
			}
		}
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DArrow basicGetDType() {
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDType(DArrow newDType) {
		DArrow oldDType = dType;
		dType = newDType;
		if(getArrow() != null)
			getArrow().setTypeArrow(getDType() == null ? null : getDType().getArrow());
		if(getDSource() != null)
			getDSource().setDType(getDType() == null ? null : getDType().getDSource());
		if(getDTarget() != null)
			getDTarget().setDType(getDType() == null ? null : getDType().getDTarget());
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__DTYPE, oldDType, dType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arrow getArrow() {
		if (arrow != null && arrow.eIsProxy()) {
			InternalEObject oldArrow = (InternalEObject)arrow;
			arrow = (Arrow)eResolveProxy(oldArrow);
			if (arrow != oldArrow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DARROW__ARROW, oldArrow, arrow));
			}
		}
		return arrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arrow basicGetArrow() {
		return arrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrow(Arrow newArrow) {
		Arrow oldArrow = arrow;
		arrow = newArrow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__ARROW, oldArrow, arrow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigureString() {
		return configureString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigureString(String newConfigureString) {
		String oldConfigureString = configureString;
		configureString = newConfigureString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__CONFIGURE_STRING, oldConfigureString, configureString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineStyle() {
		return lineStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineStyle(int newLineStyle) {
		int oldLineStyle = lineStyle;
		lineStyle = newLineStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__LINE_STYLE, oldLineStyle, lineStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode getDSource() {
		if (dSource != null && dSource.eIsProxy()) {
			InternalEObject oldDSource = (InternalEObject)dSource;
			dSource = (DNode)eResolveProxy(oldDSource);
			if (dSource != oldDSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DARROW__DSOURCE, oldDSource, dSource));
			}
		}
		return dSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode basicGetDSource() {
		return dSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDSource(DNode newDSource, NotificationChain msgs) {
		DNode oldDSource = dSource;
		dSource = newDSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__DSOURCE, oldDSource, newDSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDSource(DNode newDSource) {
		if (newDSource != dSource) {
			NotificationChain msgs = null;
			if (dSource != null)
				msgs = ((InternalEObject)dSource).eInverseRemove(this, DiagramPackage.DNODE__DOUTGOINGS, DNode.class, msgs);
			if (newDSource != null)
				msgs = ((InternalEObject)newDSource).eInverseAdd(this, DiagramPackage.DNODE__DOUTGOINGS, DNode.class, msgs);
			msgs = basicSetDSource(newDSource, msgs);
			if(getArrow() != null)
				getArrow().setSource(getDSource() != null ? getDSource().getNode() : null);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__DSOURCE, newDSource, newDSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode getDTarget() {
		if (dTarget != null && dTarget.eIsProxy()) {
			InternalEObject oldDTarget = (InternalEObject)dTarget;
			dTarget = (DNode)eResolveProxy(oldDTarget);
			if (dTarget != oldDTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DARROW__DTARGET, oldDTarget, dTarget));
			}
		}
		return dTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode basicGetDTarget() {
		return dTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDTarget(DNode newDTarget, NotificationChain msgs) {
		DNode oldDTarget = dTarget;
		dTarget = newDTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__DTARGET, oldDTarget, newDTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDTarget(DNode newDTarget) {
		if (newDTarget != dTarget) {
			NotificationChain msgs = null;
			if (dTarget != null)
				msgs = ((InternalEObject)dTarget).eInverseRemove(this, DiagramPackage.DNODE__DINCOMINGS, DNode.class, msgs);
			if (newDTarget != null)
				msgs = ((InternalEObject)newDTarget).eInverseAdd(this, DiagramPackage.DNODE__DINCOMINGS, DNode.class, msgs);
			msgs = basicSetDTarget(newDTarget, msgs);
			if(getArrow() != null)
				getArrow().setTarget(getDTarget() != null ? getDTarget().getNode() : null);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__DTARGET, newDTarget, newDTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DConstraint> getDConstraints() {
		if (dConstraints == null) {
			dConstraints = new EObjectWithInverseResolvingEList.ManyInverse<DConstraint>(DConstraint.class, this, DiagramPackage.DARROW__DCONSTRAINTS, DiagramPackage.DCONSTRAINT__DARROWS);
		}
		return dConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Point> getBendpoints() {
		if (bendpoints == null) {
			bendpoints = new EDataTypeUniqueEList<Point>(Point.class, this, DiagramPackage.DARROW__BENDPOINTS);
		}
		return bendpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DOffset getNameOffset() {
		return nameOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNameOffset(DOffset newNameOffset, NotificationChain msgs) {
		DOffset oldNameOffset = nameOffset;
		nameOffset = newNameOffset;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__NAME_OFFSET, oldNameOffset, newNameOffset);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameOffset(DOffset newNameOffset) {
		if (newNameOffset != nameOffset) {
			NotificationChain msgs = null;
			if (nameOffset != null)
				msgs = ((InternalEObject)nameOffset).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DARROW__NAME_OFFSET, null, msgs);
			if (newNameOffset != null)
				msgs = ((InternalEObject)newNameOffset).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DARROW__NAME_OFFSET, null, msgs);
			msgs = basicSetNameOffset(newNameOffset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW__NAME_OFFSET, newNameOffset, newNameOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DOffset> getConstraintOffset() {
		if (constraintOffset == null) {
			constraintOffset = new EObjectResolvingEList<DOffset>(DOffset.class, this, DiagramPackage.DARROW__CONSTRAINT_OFFSET);
		}
		return constraintOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DConstraint> getConstraintsFrom() {
		if (constraintsFrom == null) {
			constraintsFrom = new EObjectWithInverseResolvingEList<DConstraint>(DConstraint.class, this, DiagramPackage.DARROW__CONSTRAINTS_FROM, DiagramPackage.DCONSTRAINT__SOURCE);
		}
		return constraintsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DConstraint> getConstraintsTo() {
		if (constraintsTo == null) {
			constraintsTo = new EObjectWithInverseResolvingEList<DConstraint>(DConstraint.class, this, DiagramPackage.DARROW__CONSTRAINTS_TO, DiagramPackage.DCONSTRAINT__TARGET);
		}
		return constraintsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reconnect(DNode source, DNode target) {
		DGraph graph = source.getDGraph();
		Assert.isNotNull(graph);
		setDGraph(graph);
		setDSource(source);
		setDTarget(target);
	}

	private void setDGraph(DGraph graph) {
		DGraph oldGraph = getDGraph();
		if(graph == oldGraph) return;
		if(oldGraph != null)
			oldGraph.removeDArrow(this);
		if(graph != null)
			graph.addDArrow(this);
	}

	private DGraph getDGraph() {
		return (DGraph) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void disconnect() {
		setDGraph(null);
		setDSource(null);
		setDTarget(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		if(getArrow() != null)
			return getArrow().getName();
		return "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTypeName() {
		if(getDType() != null)
			return getDType().getName();
		return DPFConstants.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DARROW__DSOURCE:
				if (dSource != null)
					msgs = ((InternalEObject)dSource).eInverseRemove(this, DiagramPackage.DNODE__DOUTGOINGS, DNode.class, msgs);
				return basicSetDSource((DNode)otherEnd, msgs);
			case DiagramPackage.DARROW__DTARGET:
				if (dTarget != null)
					msgs = ((InternalEObject)dTarget).eInverseRemove(this, DiagramPackage.DNODE__DINCOMINGS, DNode.class, msgs);
				return basicSetDTarget((DNode)otherEnd, msgs);
			case DiagramPackage.DARROW__DCONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDConstraints()).basicAdd(otherEnd, msgs);
			case DiagramPackage.DARROW__CONSTRAINTS_FROM:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraintsFrom()).basicAdd(otherEnd, msgs);
			case DiagramPackage.DARROW__CONSTRAINTS_TO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraintsTo()).basicAdd(otherEnd, msgs);
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
			case DiagramPackage.DARROW__DSOURCE:
				return basicSetDSource(null, msgs);
			case DiagramPackage.DARROW__DTARGET:
				return basicSetDTarget(null, msgs);
			case DiagramPackage.DARROW__DCONSTRAINTS:
				return ((InternalEList<?>)getDConstraints()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DARROW__NAME_OFFSET:
				return basicSetNameOffset(null, msgs);
			case DiagramPackage.DARROW__CONSTRAINTS_FROM:
				return ((InternalEList<?>)getConstraintsFrom()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DARROW__CONSTRAINTS_TO:
				return ((InternalEList<?>)getConstraintsTo()).basicRemove(otherEnd, msgs);
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
			case DiagramPackage.DARROW__DTYPE:
				if (resolve) return getDType();
				return basicGetDType();
			case DiagramPackage.DARROW__ARROW:
				if (resolve) return getArrow();
				return basicGetArrow();
			case DiagramPackage.DARROW__CONFIGURE_STRING:
				return getConfigureString();
			case DiagramPackage.DARROW__LINE_STYLE:
				return getLineStyle();
			case DiagramPackage.DARROW__DSOURCE:
				if (resolve) return getDSource();
				return basicGetDSource();
			case DiagramPackage.DARROW__DTARGET:
				if (resolve) return getDTarget();
				return basicGetDTarget();
			case DiagramPackage.DARROW__DCONSTRAINTS:
				return getDConstraints();
			case DiagramPackage.DARROW__BENDPOINTS:
				return getBendpoints();
			case DiagramPackage.DARROW__NAME_OFFSET:
				return getNameOffset();
			case DiagramPackage.DARROW__CONSTRAINT_OFFSET:
				return getConstraintOffset();
			case DiagramPackage.DARROW__CONSTRAINTS_FROM:
				return getConstraintsFrom();
			case DiagramPackage.DARROW__CONSTRAINTS_TO:
				return getConstraintsTo();
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
			case DiagramPackage.DARROW__DTYPE:
				setDType((DArrow)newValue);
				return;
			case DiagramPackage.DARROW__ARROW:
				setArrow((Arrow)newValue);
				return;
			case DiagramPackage.DARROW__CONFIGURE_STRING:
				setConfigureString((String)newValue);
				return;
			case DiagramPackage.DARROW__LINE_STYLE:
				setLineStyle((Integer)newValue);
				return;
			case DiagramPackage.DARROW__DSOURCE:
				setDSource((DNode)newValue);
				return;
			case DiagramPackage.DARROW__DTARGET:
				setDTarget((DNode)newValue);
				return;
			case DiagramPackage.DARROW__DCONSTRAINTS:
				getDConstraints().clear();
				getDConstraints().addAll((Collection<? extends DConstraint>)newValue);
				return;
			case DiagramPackage.DARROW__BENDPOINTS:
				getBendpoints().clear();
				getBendpoints().addAll((Collection<? extends Point>)newValue);
				return;
			case DiagramPackage.DARROW__NAME_OFFSET:
				setNameOffset((DOffset)newValue);
				return;
			case DiagramPackage.DARROW__CONSTRAINT_OFFSET:
				getConstraintOffset().clear();
				getConstraintOffset().addAll((Collection<? extends DOffset>)newValue);
				return;
			case DiagramPackage.DARROW__CONSTRAINTS_FROM:
				getConstraintsFrom().clear();
				getConstraintsFrom().addAll((Collection<? extends DConstraint>)newValue);
				return;
			case DiagramPackage.DARROW__CONSTRAINTS_TO:
				getConstraintsTo().clear();
				getConstraintsTo().addAll((Collection<? extends DConstraint>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramPackage.DARROW__DTYPE:
				setDType(DPFConstants.REFLEXIVE_TYPE_DARROW);
				return;
			case DiagramPackage.DARROW__ARROW:
				setArrow((Arrow)null);
				return;
			case DiagramPackage.DARROW__CONFIGURE_STRING:
				setConfigureString(CONFIGURE_STRING_EDEFAULT);
				return;
			case DiagramPackage.DARROW__LINE_STYLE:
				setLineStyle(LINE_STYLE_EDEFAULT);
				return;
			case DiagramPackage.DARROW__DSOURCE:
				setDSource(DPFConstants.REFLEXIVE_TYPE_DNODE);
				return;
			case DiagramPackage.DARROW__DTARGET:
				setDTarget(DPFConstants.REFLEXIVE_TYPE_DNODE);
				return;
			case DiagramPackage.DARROW__DCONSTRAINTS:
				getDConstraints().clear();
				return;
			case DiagramPackage.DARROW__BENDPOINTS:
				getBendpoints().clear();
				return;
			case DiagramPackage.DARROW__NAME_OFFSET:
				setNameOffset((DOffset)null);
				return;
			case DiagramPackage.DARROW__CONSTRAINT_OFFSET:
				getConstraintOffset().clear();
				return;
			case DiagramPackage.DARROW__CONSTRAINTS_FROM:
				getConstraintsFrom().clear();
				return;
			case DiagramPackage.DARROW__CONSTRAINTS_TO:
				getConstraintsTo().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagramPackage.DARROW__DTYPE:
				return dType != null && dType != DPFConstants.REFLEXIVE_TYPE_DARROW;
			case DiagramPackage.DARROW__ARROW:
				return arrow != null;
			case DiagramPackage.DARROW__CONFIGURE_STRING:
				return CONFIGURE_STRING_EDEFAULT == null ? configureString != null : !CONFIGURE_STRING_EDEFAULT.equals(configureString);
			case DiagramPackage.DARROW__LINE_STYLE:
				return lineStyle != LINE_STYLE_EDEFAULT;
			case DiagramPackage.DARROW__DSOURCE:
				return dSource != null && dSource != DPFConstants.REFLEXIVE_TYPE_DNODE;
			case DiagramPackage.DARROW__DTARGET:
				return dTarget != null && dTarget != DPFConstants.REFLEXIVE_TYPE_DNODE;
			case DiagramPackage.DARROW__DCONSTRAINTS:
				return dConstraints != null && !dConstraints.isEmpty();
			case DiagramPackage.DARROW__BENDPOINTS:
				return bendpoints != null && !bendpoints.isEmpty();
			case DiagramPackage.DARROW__NAME_OFFSET:
				return nameOffset != null;
			case DiagramPackage.DARROW__CONSTRAINT_OFFSET:
				return constraintOffset != null && !constraintOffset.isEmpty();
			case DiagramPackage.DARROW__CONSTRAINTS_FROM:
				return constraintsFrom != null && !constraintsFrom.isEmpty();
			case DiagramPackage.DARROW__CONSTRAINTS_TO:
				return constraintsTo != null && !constraintsTo.isEmpty();
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
		result.append(" (configureString: ");
		result.append(configureString);
		result.append(", lineStyle: ");
		result.append(lineStyle);
		result.append(", bendpoints: ");
		result.append(bendpoints);
		result.append(')');
		return result.toString();
	}
	
	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs){
		DGraph oldGraph = getDGraph();
		if(oldGraph instanceof DGraph){
			Graph graph = ((DGraph) oldGraph).getGraph();
			if(graph != null && getArrow() != null  && graph.getArrows().contains(getArrow()))
				graph.getArrows().remove(getArrow());
		}
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if(newContainer instanceof DGraph){
			Graph graph = ((DGraph) newContainer).getGraph();
			if(graph != null && getArrow() != null  && !graph.getArrows().contains(getArrow()))
				graph.getArrows().add(getArrow());
		}
		return msgs;
	}

} //DArrowImpl
