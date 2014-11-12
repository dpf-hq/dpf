package no.hib.dpf.diagram.impl;


import java.util.Collection;

import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DArrow DAttribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getDSource <em>DSource</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getArrowAttribute <em>Arrow Attribute</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getDTarget <em>DTarget</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getLinestyle <em>Linestyle</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getNameOffset <em>Name Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DArrowDAttributeImpl#getBendpoints <em>Bendpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DArrowDAttributeImpl extends DElementImpl implements DArrowDAttribute {
	/**
	 * The cached value of the '{@link #getDSource() <em>DSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDSource()
	 * @generated
	 * @ordered
	 */
	protected DArrow dSource;

	/**
	 * The cached value of the '{@link #getArrowAttribute() <em>Arrow Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrowAttribute()
	 * @generated
	 * @ordered
	 */
	protected ArrowAttribute arrowAttribute;

	/**
	 * The cached value of the '{@link #getDType() <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDType()
	 * @generated
	 * @ordered
	 */
	protected DArrowDAttribute dType;

	/**
	 * The cached value of the '{@link #getDTarget() <em>DTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDTarget()
	 * @generated
	 * @ordered
	 */
	protected DDataNode dTarget;

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
	 * The default value of the '{@link #getLinestyle() <em>Linestyle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinestyle()
	 * @generated
	 * @ordered
	 */
	protected static final int LINESTYLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLinestyle() <em>Linestyle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinestyle()
	 * @generated
	 * @ordered
	 */
	protected int linestyle = LINESTYLE_EDEFAULT;

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
	 * The cached value of the '{@link #getNameOffset() <em>Name Offset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameOffset()
	 * @generated
	 * @ordered
	 */
	protected DOffset nameOffset;

	/**
	 * The cached value of the '{@link #getBendpoints() <em>Bendpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBendpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<DOffset> bendpoints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DArrowDAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DARROW_DATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DArrow getDSource() {
		if (dSource != null && dSource.eIsProxy()) {
			InternalEObject oldDSource = (InternalEObject)dSource;
			dSource = (DArrow)eResolveProxy(oldDSource);
			if (dSource != oldDSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DARROW_DATTRIBUTE__DSOURCE, oldDSource, dSource));
			}
		}
		return dSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DArrow basicGetDSource() {
		return dSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDSource(DArrow newDSource, NotificationChain msgs) {
		DArrow oldDSource = dSource;
		dSource = newDSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__DSOURCE, oldDSource, newDSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDSource(DArrow newDSource) {
		if (newDSource != dSource) {
			NotificationChain msgs = null;
			if (dSource != null)
				msgs = ((InternalEObject)dSource).eInverseRemove(this, DiagramPackage.DARROW__DOUTGOING_ATTRIBUTES, DArrow.class, msgs);
			if (newDSource != null)
				msgs = ((InternalEObject)newDSource).eInverseAdd(this, DiagramPackage.DARROW__DOUTGOING_ATTRIBUTES, DArrow.class, msgs);
			msgs = basicSetDSource(newDSource, msgs);
			
			
			if (arrowAttribute != null && !arrowAttribute.eIsProxy()){
				arrowAttribute.setSource(dSource != null ? dSource.getArrow() : null);
			}
			
			if (msgs != null){
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__DSOURCE, newDSource, newDSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowAttribute getArrowAttribute() {
		if (arrowAttribute != null && arrowAttribute.eIsProxy()) {
			InternalEObject oldArrowAttribute = (InternalEObject)arrowAttribute;
			arrowAttribute = (ArrowAttribute)eResolveProxy(oldArrowAttribute);
			if (arrowAttribute != oldArrowAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DARROW_DATTRIBUTE__ARROW_ATTRIBUTE, oldArrowAttribute, arrowAttribute));
			}
		}
		return arrowAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowAttribute basicGetArrowAttribute() {
		return arrowAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrowAttribute(ArrowAttribute newArrowAttribute) {
		ArrowAttribute oldArrowAttribute = arrowAttribute;
		arrowAttribute = newArrowAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__ARROW_ATTRIBUTE, oldArrowAttribute, arrowAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DArrowDAttribute getDType() {
		if (dType != null && dType.eIsProxy()) {
			InternalEObject oldDType = (InternalEObject)dType;
			dType = (DArrowDAttribute)eResolveProxy(oldDType);
			if (dType != oldDType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DARROW_DATTRIBUTE__DTYPE, oldDType, dType));
			}
		}
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DArrowDAttribute basicGetDType() {
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setDType(DArrowDAttribute newDType) {
		DArrowDAttribute oldDType = dType;
		dType = newDType;
		if(arrowAttribute != null && !arrowAttribute.eIsProxy()){
			arrowAttribute.setTypeAttribute(dType == null ? null : dType.getArrowAttribute());
		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__DTYPE, oldDType, dType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DDataNode getDTarget() {
		if (dTarget != null && dTarget.eIsProxy()) {
			InternalEObject oldDTarget = (InternalEObject)dTarget;
			dTarget = (DDataNode)eResolveProxy(oldDTarget);
			if (dTarget != oldDTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DARROW_DATTRIBUTE__DTARGET, oldDTarget, dTarget));
			}
		}
		return dTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DDataNode basicGetDTarget() {
		return dTarget;
	}
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDTarget(DDataNode newDTarget, NotificationChain msgs) {
		DDataNode oldDTarget = dTarget;
		dTarget = newDTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__DTARGET, oldDTarget, newDTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDTarget(DDataNode newDTarget) {
		if (newDTarget != dTarget) {
			NotificationChain msgs = null;
			if (dTarget != null)
				msgs = ((InternalEObject)dTarget).eInverseRemove(this, DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES, DDataNode.class, msgs);
			if (newDTarget != null)
				msgs = ((InternalEObject)newDTarget).eInverseAdd(this, DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES, DDataNode.class, msgs);
			msgs = basicSetDTarget(newDTarget, msgs);
			
			if (arrowAttribute != null && !arrowAttribute.eIsProxy()){
				arrowAttribute.setTarget(dTarget != null ? dTarget.getDatanode() : null);
			}
			if (msgs != null){
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__DTARGET, newDTarget, newDTarget));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__CONFIGURE_STRING, oldConfigureString, configureString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLinestyle() {
		return linestyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinestyle(int newLinestyle) {
		int oldLinestyle = linestyle;
		linestyle = newLinestyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__LINESTYLE, oldLinestyle, linestyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DConstraint> getDConstraints() {
		if (dConstraints == null) {
			dConstraints = new EObjectResolvingEList<DConstraint>(DConstraint.class, this, DiagramPackage.DARROW_DATTRIBUTE__DCONSTRAINTS);
		}
		return dConstraints;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET, oldNameOffset, newNameOffset);
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
				msgs = ((InternalEObject)nameOffset).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET, null, msgs);
			if (newNameOffset != null)
				msgs = ((InternalEObject)newNameOffset).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET, null, msgs);
			msgs = basicSetNameOffset(newNameOffset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET, newNameOffset, newNameOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DOffset> getBendpoints() {
		if (bendpoints == null) {
			bendpoints = new EObjectContainmentEList<DOffset>(DOffset.class, this, DiagramPackage.DARROW_DATTRIBUTE__BENDPOINTS);
		}
		return bendpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DARROW_DATTRIBUTE__DSOURCE:
				if (dSource != null)
					msgs = ((InternalEObject)dSource).eInverseRemove(this, DiagramPackage.DARROW__DOUTGOING_ATTRIBUTES, DArrow.class, msgs);
				return basicSetDSource((DArrow)otherEnd, msgs);
			case DiagramPackage.DARROW_DATTRIBUTE__DTARGET:
				if (dTarget != null)
					msgs = ((InternalEObject)dTarget).eInverseRemove(this, DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES, DDataNode.class, msgs);
				return basicSetDTarget((DDataNode)otherEnd, msgs);
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
			case DiagramPackage.DARROW_DATTRIBUTE__DSOURCE:
				return basicSetDSource(null, msgs);
			case DiagramPackage.DARROW_DATTRIBUTE__DTARGET:
				return basicSetDTarget(null, msgs);
			case DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET:
				return basicSetNameOffset(null, msgs);
			case DiagramPackage.DARROW_DATTRIBUTE__BENDPOINTS:
				return ((InternalEList<?>)getBendpoints()).basicRemove(otherEnd, msgs);
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
			case DiagramPackage.DARROW_DATTRIBUTE__DSOURCE:
				if (resolve) return getDSource();
				return basicGetDSource();
			case DiagramPackage.DARROW_DATTRIBUTE__ARROW_ATTRIBUTE:
				if (resolve) return getArrowAttribute();
				return basicGetArrowAttribute();
			case DiagramPackage.DARROW_DATTRIBUTE__DTYPE:
				if (resolve) return getDType();
				return basicGetDType();
			case DiagramPackage.DARROW_DATTRIBUTE__DTARGET:
				if (resolve) return getDTarget();
				return basicGetDTarget();
			case DiagramPackage.DARROW_DATTRIBUTE__CONFIGURE_STRING:
				return getConfigureString();
			case DiagramPackage.DARROW_DATTRIBUTE__LINESTYLE:
				return getLinestyle();
			case DiagramPackage.DARROW_DATTRIBUTE__DCONSTRAINTS:
				return getDConstraints();
			case DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET:
				return getNameOffset();
			case DiagramPackage.DARROW_DATTRIBUTE__BENDPOINTS:
				return getBendpoints();
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
			case DiagramPackage.DARROW_DATTRIBUTE__DSOURCE:
				setDSource((DArrow)newValue);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__ARROW_ATTRIBUTE:
				setArrowAttribute((ArrowAttribute)newValue);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__DTYPE:
				setDType((DArrowDAttribute)newValue);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__DTARGET:
				setDTarget((DDataNode)newValue);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__CONFIGURE_STRING:
				setConfigureString((String)newValue);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__LINESTYLE:
				setLinestyle((Integer)newValue);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__DCONSTRAINTS:
				getDConstraints().clear();
				getDConstraints().addAll((Collection<? extends DConstraint>)newValue);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET:
				setNameOffset((DOffset)newValue);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__BENDPOINTS:
				getBendpoints().clear();
				getBendpoints().addAll((Collection<? extends DOffset>)newValue);
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
			case DiagramPackage.DARROW_DATTRIBUTE__DSOURCE:
				setDSource((DArrow)null);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__ARROW_ATTRIBUTE:
				setArrowAttribute((ArrowAttribute)null);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__DTYPE:
				setDType((DArrowDAttribute)null);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__DTARGET:
				setDTarget((DDataNode)null);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__CONFIGURE_STRING:
				setConfigureString(CONFIGURE_STRING_EDEFAULT);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__LINESTYLE:
				setLinestyle(LINESTYLE_EDEFAULT);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__DCONSTRAINTS:
				getDConstraints().clear();
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET:
				setNameOffset((DOffset)null);
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__BENDPOINTS:
				getBendpoints().clear();
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
			case DiagramPackage.DARROW_DATTRIBUTE__DSOURCE:
				return dSource != null;
			case DiagramPackage.DARROW_DATTRIBUTE__ARROW_ATTRIBUTE:
				return arrowAttribute != null;
			case DiagramPackage.DARROW_DATTRIBUTE__DTYPE:
				return dType != null;
			case DiagramPackage.DARROW_DATTRIBUTE__DTARGET:
				return dTarget != null;
			case DiagramPackage.DARROW_DATTRIBUTE__CONFIGURE_STRING:
				return CONFIGURE_STRING_EDEFAULT == null ? configureString != null : !CONFIGURE_STRING_EDEFAULT.equals(configureString);
			case DiagramPackage.DARROW_DATTRIBUTE__LINESTYLE:
				return linestyle != LINESTYLE_EDEFAULT;
			case DiagramPackage.DARROW_DATTRIBUTE__DCONSTRAINTS:
				return dConstraints != null && !dConstraints.isEmpty();
			case DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET:
				return nameOffset != null;
			case DiagramPackage.DARROW_DATTRIBUTE__BENDPOINTS:
				return bendpoints != null && !bendpoints.isEmpty();
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
		result.append(", linestyle: ");
		result.append(linestyle);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void reconnect(DArrow source, DDataNode target) {
		DGraph graph = source.getDGraph();
		Assert.isNotNull(graph);
		setDGraph(graph);
		setDSource(source);
		setDTarget(target);
	}

	@Override
	public void setDGraph(DGraph graph) {
		DGraph oldGraph = getDGraph();
		if (graph == oldGraph)
			return;
		if (oldGraph != null)
			oldGraph.removeDArrowDAttribute(this);
		if (graph != null)
			graph.addDArrowDAttribute(this);
	}
	
	@Override
	public DGraph getDGraph() {
		return (DGraph) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void disconnect() {
		setDGraph(null);
		setDSource(null);
		setDTarget(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getName() {
		if (getArrowAttribute() != null)
			return getArrowAttribute().getName();
		return "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public String getTypeName() {
		if (getDType() != null)
			return getDType().getName();
		return no.hib.dpf.utils.DPFCoreConstants.ARROW_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public DArrowDAttribute getTemplateDAttribute() {
		try {
			DSpecification spec = (DSpecification)this.eContainer().eContainer();
			if(spec.getSpecification().getMetalevel() >= 0){
				return getDType().getTemplateDAttribute();
			}else if(spec.getSpecification().getMetalevel() < -1){
				return null;
			}else{	
				return this;
			}
		} catch (Exception e) {
		}
		return null;
	}
	
	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs) {
		DGraph oldGraph = getDGraph();
		if (oldGraph instanceof DGraph) {
			Graph graph = oldGraph.getGraph();
			if (graph != null && getArrowAttribute() != null && graph.getArrowAttributes().contains(getArrowAttribute()))
				graph.getArrowAttributes().remove(getArrowAttribute());
		}
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if (newContainer instanceof DGraph) {
			Graph graph = ((DGraph) newContainer).getGraph();
			if (graph != null && getArrowAttribute() != null && !graph.getArrowAttributes().contains(getArrowAttribute()))
				graph.getArrowAttributes().add(getArrowAttribute());
		}
		return msgs;
	}

} //DArrowDAttributeImpl