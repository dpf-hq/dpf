package no.hib.dpf.diagram.impl;


import java.util.Collection;

import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
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
 * An implementation of the model object '<em><b>DNode DAttribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getDSource <em>DSource</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getNodeAttribute <em>Node Attribute</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getLineStyle <em>Line Style</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getDTarget <em>DTarget</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getNameOffset <em>Name Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeDAttributeImpl#getBendpoints <em>Bendpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DNodeDAttributeImpl extends DElementImpl implements DNodeDAttribute {
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
	 * The cached value of the '{@link #getNodeAttribute() <em>Node Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeAttribute()
	 * @generated
	 * @ordered
	 */
	protected NodeAttribute nodeAttribute;

	/**
	 * The cached value of the '{@link #getDType() <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDType()
	 * @generated
	 * @ordered
	 */
	protected DNodeDAttribute dType;

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
	 * The cached value of the '{@link #getDTarget() <em>DTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDTarget()
	 * @generated
	 * @ordered
	 */
	protected DDataNode dTarget;

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
	protected DNodeDAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DNODE_DATTRIBUTE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DNODE_DATTRIBUTE__DSOURCE, oldDSource, dSource));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__DSOURCE, oldDSource, newDSource);
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
				msgs = ((InternalEObject)dSource).eInverseRemove(this, DiagramPackage.DNODE__DOUTGOING_ATTRIBUTES, DNode.class, msgs);
			if (newDSource != null)
				msgs = ((InternalEObject)newDSource).eInverseAdd(this, DiagramPackage.DNODE__DOUTGOING_ATTRIBUTES, DNode.class, msgs);
			msgs = basicSetDSource(newDSource, msgs);
			
			if (nodeAttribute != null && !nodeAttribute.eIsProxy()){
				nodeAttribute.setSource(dSource != null ? dSource.getNode() : null);
			}
			
			if (msgs != null){
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__DSOURCE, newDSource, newDSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeAttribute getNodeAttribute() {
		if (nodeAttribute != null && nodeAttribute.eIsProxy()) {
			InternalEObject oldNodeAttribute = (InternalEObject)nodeAttribute;
			nodeAttribute = (NodeAttribute)eResolveProxy(oldNodeAttribute);
			if (nodeAttribute != oldNodeAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DNODE_DATTRIBUTE__NODE_ATTRIBUTE, oldNodeAttribute, nodeAttribute));
			}
		}
		return nodeAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeAttribute basicGetNodeAttribute() {
		return nodeAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeAttribute(NodeAttribute newNodeAttribute) {
		NodeAttribute oldNodeAttribute = nodeAttribute;
		nodeAttribute = newNodeAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__NODE_ATTRIBUTE, oldNodeAttribute, nodeAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNodeDAttribute getDType() {
		if (dType != null && dType.eIsProxy()) {
			InternalEObject oldDType = (InternalEObject)dType;
			dType = (DNodeDAttribute)eResolveProxy(oldDType);
			if (dType != oldDType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DNODE_DATTRIBUTE__DTYPE, oldDType, dType));
			}
		}
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNodeDAttribute basicGetDType() {
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setDType(DNodeDAttribute newDType) {
		DNodeDAttribute oldDType = dType;
		dType = newDType;
		if(nodeAttribute != null && !nodeAttribute.eIsProxy()){
			nodeAttribute.setTypeAttribute(dType == null ? null : dType.getNodeAttribute());
		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__DTYPE, oldDType, dType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__CONFIGURE_STRING, oldConfigureString, configureString));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__LINE_STYLE, oldLineStyle, lineStyle));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DNODE_DATTRIBUTE__DTARGET, oldDTarget, dTarget));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__DTARGET, oldDTarget, newDTarget);
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
				msgs = ((InternalEObject)dTarget).eInverseRemove(this, DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES, DDataNode.class, msgs);
			if (newDTarget != null)
				msgs = ((InternalEObject)newDTarget).eInverseAdd(this, DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES, DDataNode.class, msgs);
			msgs = basicSetDTarget(newDTarget, msgs);
			
			if (nodeAttribute != null && !nodeAttribute.eIsProxy()){
				nodeAttribute.setTarget(dTarget != null ? dTarget.getDatanode() : null);
			}
			
			if (msgs != null){
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__DTARGET, newDTarget, newDTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DConstraint> getDConstraints() {
		if (dConstraints == null) {
			dConstraints = new EObjectResolvingEList<DConstraint>(DConstraint.class, this, DiagramPackage.DNODE_DATTRIBUTE__DCONSTRAINTS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET, oldNameOffset, newNameOffset);
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
				msgs = ((InternalEObject)nameOffset).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET, null, msgs);
			if (newNameOffset != null)
				msgs = ((InternalEObject)newNameOffset).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET, null, msgs);
			msgs = basicSetNameOffset(newNameOffset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET, newNameOffset, newNameOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DOffset> getBendpoints() {
		if (bendpoints == null) {
			bendpoints = new EObjectContainmentEList<DOffset>(DOffset.class, this, DiagramPackage.DNODE_DATTRIBUTE__BENDPOINTS);
		}
		return bendpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DNODE_DATTRIBUTE__DSOURCE:
				return basicSetDSource(null, msgs);
			case DiagramPackage.DNODE_DATTRIBUTE__DTARGET:
				return basicSetDTarget(null, msgs);
			case DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET:
				return basicSetNameOffset(null, msgs);
			case DiagramPackage.DNODE_DATTRIBUTE__BENDPOINTS:
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
			case DiagramPackage.DNODE_DATTRIBUTE__DSOURCE:
				if (resolve) return getDSource();
				return basicGetDSource();
			case DiagramPackage.DNODE_DATTRIBUTE__NODE_ATTRIBUTE:
				if (resolve) return getNodeAttribute();
				return basicGetNodeAttribute();
			case DiagramPackage.DNODE_DATTRIBUTE__DTYPE:
				if (resolve) return getDType();
				return basicGetDType();
			case DiagramPackage.DNODE_DATTRIBUTE__CONFIGURE_STRING:
				return getConfigureString();
			case DiagramPackage.DNODE_DATTRIBUTE__LINE_STYLE:
				return getLineStyle();
			case DiagramPackage.DNODE_DATTRIBUTE__DTARGET:
				if (resolve) return getDTarget();
				return basicGetDTarget();
			case DiagramPackage.DNODE_DATTRIBUTE__DCONSTRAINTS:
				return getDConstraints();
			case DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET:
				return getNameOffset();
			case DiagramPackage.DNODE_DATTRIBUTE__BENDPOINTS:
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
			case DiagramPackage.DNODE_DATTRIBUTE__DSOURCE:
				setDSource((DNode)newValue);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__NODE_ATTRIBUTE:
				setNodeAttribute((NodeAttribute)newValue);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__DTYPE:
				setDType((DNodeDAttribute)newValue);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__CONFIGURE_STRING:
				setConfigureString((String)newValue);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__LINE_STYLE:
				setLineStyle((Integer)newValue);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__DTARGET:
				setDTarget((DDataNode)newValue);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__DCONSTRAINTS:
				getDConstraints().clear();
				getDConstraints().addAll((Collection<? extends DConstraint>)newValue);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET:
				setNameOffset((DOffset)newValue);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__BENDPOINTS:
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
			case DiagramPackage.DNODE_DATTRIBUTE__DSOURCE:
				setDSource((DNode)null);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__NODE_ATTRIBUTE:
				setNodeAttribute((NodeAttribute)null);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__DTYPE:
				setDType((DNodeDAttribute)null);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__CONFIGURE_STRING:
				setConfigureString(CONFIGURE_STRING_EDEFAULT);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__LINE_STYLE:
				setLineStyle(LINE_STYLE_EDEFAULT);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__DTARGET:
				setDTarget((DDataNode)null);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__DCONSTRAINTS:
				getDConstraints().clear();
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET:
				setNameOffset((DOffset)null);
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__BENDPOINTS:
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
			case DiagramPackage.DNODE_DATTRIBUTE__DSOURCE:
				return dSource != null;
			case DiagramPackage.DNODE_DATTRIBUTE__NODE_ATTRIBUTE:
				return nodeAttribute != null;
			case DiagramPackage.DNODE_DATTRIBUTE__DTYPE:
				return dType != null;
			case DiagramPackage.DNODE_DATTRIBUTE__CONFIGURE_STRING:
				return CONFIGURE_STRING_EDEFAULT == null ? configureString != null : !CONFIGURE_STRING_EDEFAULT.equals(configureString);
			case DiagramPackage.DNODE_DATTRIBUTE__LINE_STYLE:
				return lineStyle != LINE_STYLE_EDEFAULT;
			case DiagramPackage.DNODE_DATTRIBUTE__DTARGET:
				return dTarget != null;
			case DiagramPackage.DNODE_DATTRIBUTE__DCONSTRAINTS:
				return dConstraints != null && !dConstraints.isEmpty();
			case DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET:
				return nameOffset != null;
			case DiagramPackage.DNODE_DATTRIBUTE__BENDPOINTS:
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
		result.append(", lineStyle: ");
		result.append(lineStyle);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void reconnect(DNode source, DDataNode target) {
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
			oldGraph.removeDNodeDAttribute(this);
		if (graph != null)
			graph.addDNodeDAttribute(this);
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
		if (getNodeAttribute() != null)
			return getNodeAttribute().getName();
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
		return no.hib.dpf.utils.DPFCoreConstants.NODE_ATTRIBUTE;
	}
 

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public DNodeDAttribute getTemplateDAttribute() {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DNODE_DATTRIBUTE__DSOURCE:
				if (dSource != null)
					msgs = ((InternalEObject)dSource).eInverseRemove(this, DiagramPackage.DNODE__DOUTGOING_ATTRIBUTES, DNode.class, msgs);
				return basicSetDSource((DNode)otherEnd, msgs);
			case DiagramPackage.DNODE_DATTRIBUTE__DTARGET:
				if (dTarget != null)
					msgs = ((InternalEObject)dTarget).eInverseRemove(this, DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES, DDataNode.class, msgs);
				return basicSetDTarget((DDataNode)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}
	
	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs) {
		DGraph oldGraph = getDGraph();
		if (oldGraph instanceof DGraph) {
			Graph graph = oldGraph.getGraph();
			if (graph != null && getNodeAttribute() != null && graph.getNodeAttributes().contains(getNodeAttribute()))
				graph.getNodeAttributes().remove(getNodeAttribute());
		}
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if (newContainer instanceof DGraph) {
			Graph graph = ((DGraph) newContainer).getGraph();
			if (graph != null && getNodeAttribute() != null && !graph.getNodeAttributes().contains(getNodeAttribute()))
				graph.getNodeAttributes().add(getNodeAttribute());
		}
		return msgs;
	}

} //DNodeDAttributeImpl