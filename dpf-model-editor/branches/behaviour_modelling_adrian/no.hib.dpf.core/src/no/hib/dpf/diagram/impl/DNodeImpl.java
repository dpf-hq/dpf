/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import java.util.Collection;

import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.utils.DPFConstants;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeImpl#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeImpl#getNode <em>Node</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeImpl#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeImpl#getDOutgoings <em>DOutgoings</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeImpl#getDIncomings <em>DIncomings</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DNodeImpl#getDConstraints <em>DConstraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DNodeImpl extends DBoundImpl implements DNode {
	

	/**
	 * The cached value of the '{@link #getDType() <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDType()
	 * @generated
	 * @ordered
	 */
	protected DNode dType;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected Node node;

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
	 * The cached value of the '{@link #getDOutgoings() <em>DOutgoings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrow> dOutgoings;

	/**
	 * The cached value of the '{@link #getDIncomings() <em>DIncomings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrow> dIncomings;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DNODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode getDType() {
		if (dType != null && dType.eIsProxy()) {
			InternalEObject oldDType = (InternalEObject)dType;
			dType = (DNode)eResolveProxy(oldDType);
			if (dType != oldDType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DNODE__DTYPE, oldDType, dType));
			}
		}
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DNode basicGetDType() {
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setDType(DNode newDType) {
		DNode oldDType = dType;
		dType = newDType;
		getNode().setTypeNode(getDType().getNode());
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE__DTYPE, oldDType, dType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNode() {
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject)node;
			node = (Node)eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DNODE__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Node newNode) {
		Node oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE__NODE, oldNode, node));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DNODE__CONFIGURE_STRING, oldConfigureString, configureString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DArrow> getDOutgoings() {
		if (dOutgoings == null) {
			dOutgoings = new EObjectWithInverseResolvingEList<DArrow>(DArrow.class, this, DiagramPackage.DNODE__DOUTGOINGS, DiagramPackage.DARROW__DSOURCE);
		}
		return dOutgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DArrow> getDIncomings() {
		if (dIncomings == null) {
			dIncomings = new EObjectWithInverseResolvingEList<DArrow>(DArrow.class, this, DiagramPackage.DNODE__DINCOMINGS, DiagramPackage.DARROW__DTARGET);
		}
		return dIncomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DConstraint> getDConstraints() {
		if (dConstraints == null) {
			dConstraints = new EObjectWithInverseResolvingEList.ManyInverse<DConstraint>(DConstraint.class, this, DiagramPackage.DNODE__DCONSTRAINTS, DiagramPackage.DCONSTRAINT__DNODES);
		}
		return dConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		if(getNode() != null)
			return getNode().getName();
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
			case DiagramPackage.DNODE__DOUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDOutgoings()).basicAdd(otherEnd, msgs);
			case DiagramPackage.DNODE__DINCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDIncomings()).basicAdd(otherEnd, msgs);
			case DiagramPackage.DNODE__DCONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDConstraints()).basicAdd(otherEnd, msgs);
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
			case DiagramPackage.DNODE__DOUTGOINGS:
				return ((InternalEList<?>)getDOutgoings()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DNODE__DINCOMINGS:
				return ((InternalEList<?>)getDIncomings()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DNODE__DCONSTRAINTS:
				return ((InternalEList<?>)getDConstraints()).basicRemove(otherEnd, msgs);
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
			case DiagramPackage.DNODE__DTYPE:
				if (resolve) return getDType();
				return basicGetDType();
			case DiagramPackage.DNODE__NODE:
				if (resolve) return getNode();
				return basicGetNode();
			case DiagramPackage.DNODE__CONFIGURE_STRING:
				return getConfigureString();
			case DiagramPackage.DNODE__DOUTGOINGS:
				return getDOutgoings();
			case DiagramPackage.DNODE__DINCOMINGS:
				return getDIncomings();
			case DiagramPackage.DNODE__DCONSTRAINTS:
				return getDConstraints();
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
			case DiagramPackage.DNODE__DTYPE:
				setDType((DNode)newValue);
				return;
			case DiagramPackage.DNODE__NODE:
				setNode((Node)newValue);
				return;
			case DiagramPackage.DNODE__CONFIGURE_STRING:
				setConfigureString((String)newValue);
				return;
			case DiagramPackage.DNODE__DOUTGOINGS:
				getDOutgoings().clear();
				getDOutgoings().addAll((Collection<? extends DArrow>)newValue);
				return;
			case DiagramPackage.DNODE__DINCOMINGS:
				getDIncomings().clear();
				getDIncomings().addAll((Collection<? extends DArrow>)newValue);
				return;
			case DiagramPackage.DNODE__DCONSTRAINTS:
				getDConstraints().clear();
				getDConstraints().addAll((Collection<? extends DConstraint>)newValue);
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
			case DiagramPackage.DNODE__DTYPE:
				setDType(DPFConstants.REFLEXIVE_TYPE_DNODE);
				return;
			case DiagramPackage.DNODE__NODE:
				setNode((Node)null);
				return;
			case DiagramPackage.DNODE__CONFIGURE_STRING:
				setConfigureString(CONFIGURE_STRING_EDEFAULT);
				return;
			case DiagramPackage.DNODE__DOUTGOINGS:
				getDOutgoings().clear();
				return;
			case DiagramPackage.DNODE__DINCOMINGS:
				getDIncomings().clear();
				return;
			case DiagramPackage.DNODE__DCONSTRAINTS:
				getDConstraints().clear();
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
			case DiagramPackage.DNODE__DTYPE:
				return dType != null && dType != DPFConstants.REFLEXIVE_TYPE_DNODE;
			case DiagramPackage.DNODE__NODE:
				return node != null;
			case DiagramPackage.DNODE__CONFIGURE_STRING:
				return CONFIGURE_STRING_EDEFAULT == null ? configureString != null : !CONFIGURE_STRING_EDEFAULT.equals(configureString);
			case DiagramPackage.DNODE__DOUTGOINGS:
				return dOutgoings != null && !dOutgoings.isEmpty();
			case DiagramPackage.DNODE__DINCOMINGS:
				return dIncomings != null && !dIncomings.isEmpty();
			case DiagramPackage.DNODE__DCONSTRAINTS:
				return dConstraints != null && !dConstraints.isEmpty();
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
		result.append(')');
		return result.toString();
	}
	
	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs){
		DGraph oldGraph = getDGraph();
		if(oldGraph instanceof DGraph){
			Graph graph = ((DGraph) oldGraph).getGraph();
			if(graph != null && graph.getNodes().contains(getNode()))
				graph.getNodes().remove(getNode());
		}
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if(newContainer instanceof DGraph){
			Graph graph = ((DGraph) newContainer).getGraph();
			if(graph != null && !graph.getNodes().contains(getNode()))
				graph.getNodes().add(getNode());
		}
		return msgs;
	}

	public DGraph getDGraph() {
		return (DGraph) eContainer();
	}

} //DNodeImpl
