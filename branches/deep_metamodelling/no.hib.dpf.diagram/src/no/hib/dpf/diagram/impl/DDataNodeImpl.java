package no.hib.dpf.diagram.impl;


import java.util.ArrayList;
import java.util.Collection;

import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Graph;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DData Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DDataNodeImpl#getDatanode <em>Datanode</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DDataNodeImpl#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DDataNodeImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DDataNodeImpl#getSize <em>Size</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DDataNodeImpl#getDIncomingDNodeDAttributes <em>DIncoming DNode DAttributes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DDataNodeImpl#getDIncomingDArrowDAttributes <em>DIncoming DArrow DAttributes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DDataNodeImpl#getDType <em>DType</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DDataNodeImpl extends DElementImpl implements DDataNode {
	/**
	 * The cached value of the '{@link #getDatanode() <em>Datanode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatanode()
	 * @generated
	 * @ordered
	 */
	protected DataNode datanode;

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
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final Point LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Point location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final Dimension SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Dimension size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDIncomingDNodeDAttributes() <em>DIncoming DNode DAttributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDIncomingDNodeDAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<DNodeDAttribute> dIncomingDNodeDAttributes;

	/**
	 * The cached value of the '{@link #getDIncomingDArrowDAttributes() <em>DIncoming DArrow DAttributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDIncomingDArrowDAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrowDAttribute> dIncomingDArrowDAttributes;

	/**
	 * The cached value of the '{@link #getDType() <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDType()
	 * @generated
	 * @ordered
	 */
	protected DDataNode dType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DDataNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DDATA_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataNode getDatanode() {
		if (datanode != null && datanode.eIsProxy()) {
			InternalEObject oldDatanode = (InternalEObject)datanode;
			datanode = (DataNode)eResolveProxy(oldDatanode);
			if (datanode != oldDatanode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DDATA_NODE__DATANODE, oldDatanode, datanode));
			}
		}
		return datanode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataNode basicGetDatanode() {
		return datanode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatanode(DataNode newDatanode) {
		DataNode oldDatanode = datanode;
		datanode = newDatanode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DDATA_NODE__DATANODE, oldDatanode, datanode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DDATA_NODE__CONFIGURE_STRING, oldConfigureString, configureString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Point newLocation) {
		Point oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DDATA_NODE__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(Dimension newSize) {
		Dimension oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DDATA_NODE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DNodeDAttribute> getDIncomingDNodeDAttributes() {
		if (dIncomingDNodeDAttributes == null) {
			dIncomingDNodeDAttributes = new EObjectWithInverseResolvingEList<DNodeDAttribute>(DNodeDAttribute.class, this, DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES, DiagramPackage.DNODE_DATTRIBUTE__DTARGET);
		}
		return dIncomingDNodeDAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public EList<DArrowDAttribute> getDIncomingDArrowDAttributes() {
		
		if (dIncomingDArrowDAttributes == null) {
			dIncomingDArrowDAttributes = new EObjectWithInverseResolvingEList<DArrowDAttribute>(DArrowDAttribute.class, this, DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES, DiagramPackage.DARROW_DATTRIBUTE__DTARGET);	
		}
		
		 
		return dIncomingDArrowDAttributes;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DDataNode getDType() {
		if (dType != null && dType.eIsProxy()) {
			InternalEObject oldDType = (InternalEObject)dType;
			dType = (DDataNode)eResolveProxy(oldDType);
			if (dType != oldDType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DDATA_NODE__DTYPE, oldDType, dType));
			}
		}
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DDataNode basicGetDType() {
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setDType(DDataNode newDType) {
		DDataNode oldDType = dType;
		dType = newDType;
		
		if(datanode != null && !datanode.eIsProxy()){
			datanode.setTypeDataNode(dType != null ? dType.getDatanode() : null);
		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DDATA_NODE__DTYPE, oldDType, dType));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DDataNode getTemplateDDataNode() {
		try {
			DSpecification spec = (DSpecification)this.eContainer().eContainer();
			if(spec.getSpecification().getMetalevel() >= 0){
				return getDType().getTemplateDDataNode();
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.DDATA_NODE__DATANODE:
				if (resolve) return getDatanode();
				return basicGetDatanode();
			case DiagramPackage.DDATA_NODE__CONFIGURE_STRING:
				return getConfigureString();
			case DiagramPackage.DDATA_NODE__LOCATION:
				return getLocation();
			case DiagramPackage.DDATA_NODE__SIZE:
				return getSize();
			case DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES:
				return getDIncomingDNodeDAttributes();
			case DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES:
				return getDIncomingDArrowDAttributes();
			case DiagramPackage.DDATA_NODE__DTYPE:
				if (resolve) return getDType();
				return basicGetDType();
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
			case DiagramPackage.DDATA_NODE__DATANODE:
				setDatanode((DataNode)newValue);
				return;
			case DiagramPackage.DDATA_NODE__CONFIGURE_STRING:
				setConfigureString((String)newValue);
				return;
			case DiagramPackage.DDATA_NODE__LOCATION:
				setLocation((Point)newValue);
				return;
			case DiagramPackage.DDATA_NODE__SIZE:
				setSize((Dimension)newValue);
				return;
			case DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES:
				getDIncomingDNodeDAttributes().clear();
				getDIncomingDNodeDAttributes().addAll((Collection<? extends DNodeDAttribute>)newValue);
				return;
			case DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES:
				getDIncomingDArrowDAttributes().clear();
				getDIncomingDArrowDAttributes().addAll((Collection<? extends DArrowDAttribute>)newValue);
				return;
			case DiagramPackage.DDATA_NODE__DTYPE:
				setDType((DDataNode)newValue);
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
			case DiagramPackage.DDATA_NODE__DATANODE:
				setDatanode((DataNode)null);
				return;
			case DiagramPackage.DDATA_NODE__CONFIGURE_STRING:
				setConfigureString(CONFIGURE_STRING_EDEFAULT);
				return;
			case DiagramPackage.DDATA_NODE__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case DiagramPackage.DDATA_NODE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES:
				getDIncomingDNodeDAttributes().clear();
				return;
			case DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES:
				getDIncomingDArrowDAttributes().clear();
				return;
			case DiagramPackage.DDATA_NODE__DTYPE:
				setDType((DDataNode)null);
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
			case DiagramPackage.DDATA_NODE__DATANODE:
				return datanode != null;
			case DiagramPackage.DDATA_NODE__CONFIGURE_STRING:
				return CONFIGURE_STRING_EDEFAULT == null ? configureString != null : !CONFIGURE_STRING_EDEFAULT.equals(configureString);
			case DiagramPackage.DDATA_NODE__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case DiagramPackage.DDATA_NODE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
			case DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES:
				return dIncomingDNodeDAttributes != null && !dIncomingDNodeDAttributes.isEmpty();
			case DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES:
				return dIncomingDArrowDAttributes != null && !dIncomingDArrowDAttributes.isEmpty();
			case DiagramPackage.DDATA_NODE__DTYPE:
				return dType != null;
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
		result.append(", location: ");
		result.append(location);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

	@Override
	public DGraph getDGraph() {
		DGraph dgraph = (DGraph)eContainer();
		return dgraph;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDIncomingDArrowDAttributes()).basicAdd(otherEnd, msgs);
			case DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDIncomingDNodeDAttributes()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES:
				return ((InternalEList<?>)getDIncomingDNodeDAttributes()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES:
				return ((InternalEList<?>)getDIncomingDArrowDAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	@Override
	public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs){
		DGraph oldGraph = getDGraph();
		if(oldGraph instanceof DGraph){
			Graph graph = oldGraph.getGraph();
			if(graph != null && getDatanode() != null  && graph.getDatanodes().contains(getDatanode()))
				graph.getDatanodes().remove(getDatanode());
		}
		super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
		if(newContainer instanceof DGraph){
			Graph graph = ((DGraph) newContainer).getGraph();
			if(graph != null && getDatanode() != null && !graph.getDatanodes().contains(getDatanode()))
				graph.getDatanodes().add(getDatanode());
		}
		return msgs;
	}

} //DDataNodeImpl