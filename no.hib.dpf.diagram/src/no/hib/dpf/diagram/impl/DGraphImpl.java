/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import java.util.Collection;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.diagram.util.DPFDiagramConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DGraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DGraphImpl#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DGraphImpl#getDNodes <em>DNodes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DGraphImpl#getDArrows <em>DArrows</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DGraphImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DGraphImpl#getDDataNodes <em>DData Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DGraphImpl#getDArrowDAttributes <em>DArrow DAttributes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DGraphImpl#getDNodeDAttributes <em>DNode DAttributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DGraphImpl extends EObjectImpl implements DGraph {
	/**
	 * The cached value of the '{@link #getDType() <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDType()
	 * @generated
	 * @ordered
	 */
	protected DGraph dType;

	/**
	 * The cached value of the '{@link #getDNodes() <em>DNodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DNode> dNodes;

	/**
	 * The cached value of the '{@link #getDArrows() <em>DArrows</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDArrows()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrow> dArrows;

	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph graph;

	/**
	 * The cached value of the '{@link #getDDataNodes() <em>DData Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDDataNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DDataNode> dDataNodes;

	/**
	 * The cached value of the '{@link #getDArrowDAttributes() <em>DArrow DAttributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDArrowDAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrowDAttribute> dArrowDAttributes;

	/**
	 * The cached value of the '{@link #getDNodeDAttributes() <em>DNode DAttributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNodeDAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<DNodeDAttribute> dNodeDAttributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DGraphImpl() {
		super();
	}

	@Override
	public void addDArrow(DArrow Arrow) {
		if(!getDArrows().contains(Arrow))
			getDArrows().add(Arrow);
		
	}

	@Override
	public void addDNode(DNode node) {
		if(!getDNodes().contains(node))
			getDNodes().add(node);	
	}
	
	@Override
	public void addDNodeDAttribute(DNodeDAttribute dattribute) {
		if(!getDNodeDAttributes().contains(dattribute)){
			getDNodeDAttributes().add(dattribute);
		}
	}
	
	@Override
	public void addDArrowDAttribute(DArrowDAttribute dattribute) {
		if(!getDArrowDAttributes().contains(dattribute)){
			getDArrowDAttributes().add(dattribute);
		}
	}
	
	@Override
	public void addDDataNode(DDataNode ddatanode) {
		if(!getDDataNodes().contains(ddatanode)){
			getDDataNodes().add(ddatanode);
		}		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DGraph basicGetDType() {
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetGraph() {
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DArrow createDArrow(Arrow arrow, DNode dSource, DNode dTarget, DArrow dType) {
		Assert.isTrue(dSource != null && dTarget != null && dType !=null);
		DArrow result = new DArrowImpl();
		result.setArrow(arrow);
		result.setDSource(dSource);
		result.setDTarget(dTarget);
		result.setDType(dType);
		addDArrow(result);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DArrow createDArrow(String name, DNode dSource, DNode dTarget, DArrow dType) {
		Assert.isTrue(dSource != null && dTarget != null && dType !=null);
		return createDArrow(getGraph().createArrow(name, dSource.getNode(), dTarget.getNode(), dType.getArrow()), dSource, dTarget, dType);
	}

 

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public DGraph getTemplateDGraph() {
		try {
			DSpecification spec = (DSpecification)this.eContainer();
			if(spec.getSpecification().getMetalevel() >= 0){
				return getDType().getTemplateDGraph();
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
	 * @generated NOT
	 */
	public DNode createDNode(Node node, DNode dType) {
		DNode newNode = new DNodeImpl();
		newNode.setDType(dType);
		newNode.setNode(node);
		addDNode(newNode);
		return newNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DNode createDNode(String name, DNode dType) {
		Assert.isNotNull(dType);
		return createDNode(getGraph().createNode(name, dType.getNode()), dType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.DGRAPH__DTYPE:
				if (resolve) return getDType();
				return basicGetDType();
			case DiagramPackage.DGRAPH__DNODES:
				return getDNodes();
			case DiagramPackage.DGRAPH__DARROWS:
				return getDArrows();
			case DiagramPackage.DGRAPH__GRAPH:
				if (resolve) return getGraph();
				return basicGetGraph();
			case DiagramPackage.DGRAPH__DDATA_NODES:
				return getDDataNodes();
			case DiagramPackage.DGRAPH__DARROW_DATTRIBUTES:
				return getDArrowDAttributes();
			case DiagramPackage.DGRAPH__DNODE_DATTRIBUTES:
				return getDNodeDAttributes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DGRAPH__DNODES:
				return ((InternalEList<?>)getDNodes()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DGRAPH__DARROWS:
				return ((InternalEList<?>)getDArrows()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DGRAPH__DDATA_NODES:
				return ((InternalEList<?>)getDDataNodes()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DGRAPH__DARROW_DATTRIBUTES:
				return ((InternalEList<?>)getDArrowDAttributes()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DGRAPH__DNODE_DATTRIBUTES:
				return ((InternalEList<?>)getDNodeDAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagramPackage.DGRAPH__DTYPE:
				return dType != null && dType != DPFDiagramConstants.REFLEXIVE_TYPE_DGRAPH;
			case DiagramPackage.DGRAPH__DNODES:
				return dNodes != null && !dNodes.isEmpty();
			case DiagramPackage.DGRAPH__DARROWS:
				return dArrows != null && !dArrows.isEmpty();
			case DiagramPackage.DGRAPH__DARROW_DATTRIBUTES:
				return dArrowDAttributes != null && !dArrowDAttributes.isEmpty();
			case DiagramPackage.DGRAPH__DNODE_DATTRIBUTES:
				return dNodeDAttributes != null && !dNodeDAttributes.isEmpty();
			case DiagramPackage.DGRAPH__DDATA_NODES:
				return dDataNodes != null && !dDataNodes.isEmpty();
			case DiagramPackage.DGRAPH__GRAPH:
				return graph != null;
		}
		return super.eIsSet(featureID);
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
			case DiagramPackage.DGRAPH__DTYPE:
				setDType((DGraph)newValue);
				return;
			case DiagramPackage.DGRAPH__DNODES:
				getDNodes().clear();
				getDNodes().addAll((Collection<? extends DNode>)newValue);
				return;
			case DiagramPackage.DGRAPH__DARROWS:
				getDArrows().clear();
				getDArrows().addAll((Collection<? extends DArrow>)newValue);
				return;
			case DiagramPackage.DGRAPH__GRAPH:
				setGraph((Graph)newValue);
				return;
			case DiagramPackage.DGRAPH__DDATA_NODES:
				getDDataNodes().clear();
				getDDataNodes().addAll((Collection<? extends DDataNode>)newValue);
				return;
			case DiagramPackage.DGRAPH__DARROW_DATTRIBUTES:
				getDArrowDAttributes().clear();
				getDArrowDAttributes().addAll((Collection<? extends DArrowDAttribute>)newValue);
				return;
			case DiagramPackage.DGRAPH__DNODE_DATTRIBUTES:
				getDNodeDAttributes().clear();
				getDNodeDAttributes().addAll((Collection<? extends DNodeDAttribute>)newValue);
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
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.DGRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramPackage.DGRAPH__DTYPE:
				setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DGRAPH);
				return;
			case DiagramPackage.DGRAPH__DNODES:
				getDNodes().clear();
				return;
			case DiagramPackage.DGRAPH__DARROWS:
				getDArrows().clear();
				return;
			case DiagramPackage.DGRAPH__GRAPH:
				setGraph((Graph)null);
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
	public DArrow getDArrow(Arrow arrow) {
		for(DArrow darrow : getDArrows())
			if(darrow.getArrow() == arrow)
				return darrow;
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DArrow> getDArrows() {
		if (dArrows == null) {
			dArrows = new EObjectContainmentEList<DArrow>(DArrow.class, this, DiagramPackage.DGRAPH__DARROWS);
		}
		return dArrows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DNode getDNode(Node node) {
		for(DNode dnode : getDNodes())
			if(dnode.getNode() == node)
				return dnode;
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DNodeDAttribute getDNodeDAttribute(NodeAttribute nodeattribute) {
		for(DNodeDAttribute dnodeattribute : getDNodeDAttributes())
			if(dnodeattribute.getNodeAttribute() == nodeattribute)
				return dnodeattribute;
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DDataNode getDDataNode(DataNode node) {
		for(DDataNode dnode : getDDataNodes())
			if(dnode.getDatanode() == node)
				return dnode;
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DNode> getDNodes() {
		if (dNodes == null) {
			dNodes = new EObjectContainmentEList<DNode>(DNode.class, this, DiagramPackage.DGRAPH__DNODES);
		}
		return dNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DGraph getDType() {
		if (dType != null && dType.eIsProxy()) {
			InternalEObject oldDType = (InternalEObject)dType;
			dType = (DGraph)eResolveProxy(oldDType);
			if (dType != oldDType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DGRAPH__DTYPE, oldDType, dType));
			}
		}
		return dType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Graph getGraph() {
		if (graph != null && graph.eIsProxy()) {
			InternalEObject oldGraph = (InternalEObject)graph;
			graph = (Graph)eResolveProxy(oldGraph);
			if (graph != oldGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DGRAPH__GRAPH, oldGraph, graph));
			}
		}
		return graph;
	}

	@Override
	public void removeDArrow(DArrow Arrow) {
		if(getDArrows().contains(Arrow)){
			getDArrows().remove(Arrow);
		}
	}

	@Override
	public void removeDNode(DNode node) {
		if(getDNodes().contains(node)){
			getDNodes().remove(node);
		}
	}
	
	@Override
	public void removeDNodeDAttribute(DNodeDAttribute dattribute) {
		if(getDNodeDAttributes().contains(dattribute)){
			getDNodeDAttributes().remove(dattribute);
		}
	}
	
	@Override
	public void removeDArrowDAttribute(DArrowDAttribute dattribute) {
		if(getDArrowDAttributes().contains(dattribute)){
			getDArrowDAttributes().remove(dattribute);
		}
	}
	
	@Override
	public void removeDDataNode(DDataNode ddatanode) {
		if(getDDataNodes().contains(ddatanode)){
			getDDataNodes().remove(ddatanode);
		}		
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setDType(DGraph newDType) {
		DGraph oldDType = dType;
		dType = newDType;
		if(graph != null && !graph.eIsProxy())
			graph.setType(dType == null ? null : dType.getGraph());
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DGRAPH__DTYPE, oldDType, dType));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGraph(Graph newGraph) {
		Graph oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DGRAPH__GRAPH, oldGraph, graph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DDataNode> getDDataNodes() {
		if (dDataNodes == null) {
			dDataNodes = new EObjectContainmentEList<DDataNode>(DDataNode.class, this, DiagramPackage.DGRAPH__DDATA_NODES);
		}
		return dDataNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DArrowDAttribute> getDArrowDAttributes() {
		if (dArrowDAttributes == null) {
			dArrowDAttributes = new EObjectContainmentEList<DArrowDAttribute>(DArrowDAttribute.class, this, DiagramPackage.DGRAPH__DARROW_DATTRIBUTES);
		}
		return dArrowDAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DNodeDAttribute> getDNodeDAttributes() {
		if (dNodeDAttributes == null) {
			dNodeDAttributes = new EObjectContainmentEList<DNodeDAttribute>(DNodeDAttribute.class, this, DiagramPackage.DGRAPH__DNODE_DATTRIBUTES);
		}
		return dNodeDAttributes;
	}
} //DGraphImpl
