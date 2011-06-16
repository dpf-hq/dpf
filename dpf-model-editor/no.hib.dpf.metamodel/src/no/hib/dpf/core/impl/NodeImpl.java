/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.MetamodelPackage;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.NodeImpl#getTypeNode <em>Type Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends IDObjectImpl implements Node {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypeNode() <em>Type Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeNode()
	 * @generated
	 * @ordered
	 */
	protected Node typeNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected NodeImpl() {
		super();
		this.name = ""; //null is a stupid default.
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (eContainerFeatureID() != CorePackage.NODE__GRAPH) return null;
		return (Graph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, CorePackage.NODE__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != CorePackage.NODE__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, CorePackage.GRAPH__NODES, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NODE__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTypeNode() {
		if (typeNode != null && typeNode.eIsProxy()) {
			InternalEObject oldTypeNode = (InternalEObject)typeNode;
			typeNode = (Node)eResolveProxy(oldTypeNode);
			if (typeNode != oldTypeNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.NODE__TYPE_NODE, oldTypeNode, typeNode));
			}
		}
		return typeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTypeNode() {
		return typeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeNode(Node newTypeNode) {
		Node oldTypeNode = typeNode;
		typeNode = newTypeNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.NODE__TYPE_NODE, oldTypeNode, typeNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Arrow> getOutgoingArrows() {
		EList<Arrow> arrows = new BasicEList<Arrow>();
		for(Arrow a : getGraph().getArrows()) {
			if(a.getSource() == this) {
				arrows.add(a);
			}
		}
		
		return arrows;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean arrowCanMakeConnectionAsSource(Node intendedSource) {
		if (getTypeNode() == null) {
			return true;
		}
		if ((intendedSource == null) || (intendedSource.getTypeNode() == null)) {
			return false;
		}
		return intendedSource.getTypeNode().canReachTargetByOneArrow(this.getTypeNode());		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */ 
	public boolean arrowCanMakeConnectionAsTarget(Node intendedTarget) {
		if (getTypeNode() == null) {
			return true;
		}
		if ((intendedTarget == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return typeNode.canReachTargetByOneArrow(intendedTarget.getTypeNode());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean arrowCanMakeConnectionAsTarget(Node intendedTarget, Arrow typeArrow) {
		if ((getTypeNode() == null) && (typeArrow == null)) {
			return true;
		}
		if ((intendedTarget == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return typeNode.canReachTargetByTypeArrow(intendedTarget.getTypeNode(), typeArrow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean canReachTargetByTypeArrow(Node target, Arrow typeArrow) {
		if (typeArrow.getTarget().equals(target)) {
			return (getOutgoingArrows().contains(typeArrow));
		}
		return false;		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow getArrowto(Node target) {
		for (Arrow arrow : getOutgoingArrows()) {
			if (arrow.getTarget().equals(target)) {
				return arrow;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getTypeName() {
		if ((getTypeNode() == null) || (getTypeNode().getName() == null)) {
			return "";
		}
		return getTypeNode().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private String getNameTemplate() {
		String typeName = getTypeName();
		if (typeName.equals("")) {
			return "Node ";
		} else {
			return typeName + " ";
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated ZOT!
	 */
	public String generateUniqueName() {
		String name;
		if(getGraph() == null) {
			name = getId();
		} else {
			int count = getGraph().getNodes().size();
			name = getNameTemplate() + count;
			while(nameIsUsed(name)) {
				count++;
				name = getNameTemplate() + count;
			}
		}
		
		return name;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCreateTypedArrow(Node intendedTarget) {
		if (intendedTarget == null) {
			return false;
		}
		// By convention, we say that a connection can't be made between typed and untyped nodes:
		if ((getTypeNode() == null) || (intendedTarget.getTypeNode() == null)) {
			return false;
		}
		return (getTypeArrow(intendedTarget) != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Arrow getTypeArrow(Node intendedTarget) {
		try {
			Node intendedTargetsTypeNode = intendedTarget.getTypeNode();
			for (Arrow arrow : getTypeNode().getOutgoingArrows()) {
				if (arrow.getTarget().equals(intendedTargetsTypeNode)) {
					return arrow;
				}
			}			
		} catch (Exception e) {}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Arrow> getIncomingArrows() {
		EList<Arrow> arrows = new BasicEList<Arrow>();
		for(Arrow a : getGraph().getArrows()) {
			if(a.getTarget() == this) {
				arrows.add(a);
			}
		}
		
		return arrows;		
	}

	/**
	 * 
	 * @param name
	 * @return
	 * 
	 * @generated NOT
	 */
	private boolean nameIsUsed(String name) {
		boolean used = false;
		for(Node n : getGraph().getNodes()) {
			if(n.getName().equals(name)) {
				used = true;
				break;
			}
		}
		return used;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canReachTargetByOneArrow(Node target) {
		return (getArrowto(target) != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.NODE__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
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
			case CorePackage.NODE__GRAPH:
				return basicSetGraph(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CorePackage.NODE__GRAPH:
				return eInternalContainer().eInverseRemove(this, CorePackage.GRAPH__NODES, Graph.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.NODE__NAME:
				return getName();
			case CorePackage.NODE__GRAPH:
				return getGraph();
			case CorePackage.NODE__TYPE_NODE:
				if (resolve) return getTypeNode();
				return basicGetTypeNode();
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
			case CorePackage.NODE__NAME:
				setName((String)newValue);
				return;
			case CorePackage.NODE__GRAPH:
				setGraph((Graph)newValue);
				return;
			case CorePackage.NODE__TYPE_NODE:
				setTypeNode((Node)newValue);
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
			case CorePackage.NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CorePackage.NODE__GRAPH:
				setGraph((Graph)null);
				return;
			case CorePackage.NODE__TYPE_NODE:
				setTypeNode((Node)null);
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
			case CorePackage.NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CorePackage.NODE__GRAPH:
				return getGraph() != null;
			case CorePackage.NODE__TYPE_NODE:
				return typeNode != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
