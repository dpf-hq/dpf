/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DConstraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.impl.DConstraintImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DConstraintImpl#getDNodes <em>DNodes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DConstraintImpl#getDArrows <em>DArrows</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.impl.DConstraintImpl#getDPredicate <em>DPredicate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DConstraintImpl extends EObjectImpl implements DConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public enum ConstraintType {
		COMPOSITION,
		IMAGE_INCLUSION,
		INJECTIVE,
		INVERSE,
		IRREFLEXIVE,
		JOINTLY_INJECTIVE,
		JOINTLY_SURJECTIVE,
		MULTIPLICITY,
		NAND,
		SURJECTIVE,
		TRANSITIVE_IRREFLEXIVE,
		XOR
	}

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected Constraint constraint;
	/**
	 * The cached value of the '{@link #getDNodes() <em>DNodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<DNode> dNodes;
	/**
	 * The cached value of the '{@link #getDArrows() <em>DArrows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDArrows()
	 * @generated
	 * @ordered
	 */
	protected EList<DArrow> dArrows;

	/**
	 * The cached value of the '{@link #getDPredicate() <em>DPredicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDPredicate()
	 * @generated
	 * @ordered
	 */
	protected DPredicate dPredicate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DConstraintImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void addDArrow(DArrow dArrow) {
		if(getConstraint() != null && dArrow.getArrow() != null)
			getConstraint().addArrow(dArrow.getArrow());
		getDArrows().add(dArrow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void addDNode(DNode dNode) {
		if(getConstraint() != null && dNode.getNode() != null)
			getConstraint().addNode(dNode.getNode());
		getDNodes().add(dNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint basicGetConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DPredicate basicGetDPredicate() {
		return dPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void disconnect() {
		DSpecification dSpecification = (DSpecification) eContainer();
		Assert.isNotNull(dSpecification);
		if(dSpecification.getDConstraints().contains(this))
			dSpecification.getDConstraints().remove(this);
		getDArrows().clear();
		getDNodes().clear();
		getConstraint().disconnect();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.DCONSTRAINT__CONSTRAINT:
				if (resolve) return getConstraint();
				return basicGetConstraint();
			case DiagramPackage.DCONSTRAINT__DNODES:
				return getDNodes();
			case DiagramPackage.DCONSTRAINT__DARROWS:
				return getDArrows();
			case DiagramPackage.DCONSTRAINT__DPREDICATE:
				if (resolve) return getDPredicate();
				return basicGetDPredicate();
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.DCONSTRAINT__DNODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDNodes()).basicAdd(otherEnd, msgs);
			case DiagramPackage.DCONSTRAINT__DARROWS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDArrows()).basicAdd(otherEnd, msgs);
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
			case DiagramPackage.DCONSTRAINT__DNODES:
				return ((InternalEList<?>)getDNodes()).basicRemove(otherEnd, msgs);
			case DiagramPackage.DCONSTRAINT__DARROWS:
				return ((InternalEList<?>)getDArrows()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagramPackage.DCONSTRAINT__CONSTRAINT:
				return constraint != null;
			case DiagramPackage.DCONSTRAINT__DNODES:
				return dNodes != null && !dNodes.isEmpty();
			case DiagramPackage.DCONSTRAINT__DARROWS:
				return dArrows != null && !dArrows.isEmpty();
			case DiagramPackage.DCONSTRAINT__DPREDICATE:
				return dPredicate != null;
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
			case DiagramPackage.DCONSTRAINT__CONSTRAINT:
				setConstraint((Constraint)newValue);
				return;
			case DiagramPackage.DCONSTRAINT__DNODES:
				getDNodes().clear();
				getDNodes().addAll((Collection<? extends DNode>)newValue);
				return;
			case DiagramPackage.DCONSTRAINT__DARROWS:
				getDArrows().clear();
				getDArrows().addAll((Collection<? extends DArrow>)newValue);
				return;
			case DiagramPackage.DCONSTRAINT__DPREDICATE:
				setDPredicate((DPredicate)newValue);
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
		return DiagramPackage.Literals.DCONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramPackage.DCONSTRAINT__CONSTRAINT:
				setConstraint((Constraint)null);
				return;
			case DiagramPackage.DCONSTRAINT__DNODES:
				getDNodes().clear();
				return;
			case DiagramPackage.DCONSTRAINT__DARROWS:
				getDArrows().clear();
				return;
			case DiagramPackage.DCONSTRAINT__DPREDICATE:
				setDPredicate((DPredicate)null);
				return;
		}
		super.eUnset(featureID);
	}

	protected DArrow findDArrow(Arrow arrow, List<DArrow> darrows){
		for(DArrow dArrow : darrows)
			if(dArrow.getArrow() == arrow)
				return dArrow;
				return null;
	}

	protected DElement findDElement(GraphHomomorphism graHomomorphism, IDObject idObject){
		if(idObject instanceof Node)
			return findDNode(graHomomorphism.getNodeMapping().get(idObject), this.getDNodes());
		if(idObject instanceof Arrow)
			return findDArrow(graHomomorphism.getArrowMapping().get(idObject), this.getDArrows());
		return null;
	}

	protected DNode findDNode(Node node, List<DNode> dnodes){
		for(DNode dNode : dnodes)
			if(dNode.getNode() == node)
				return dNode;
				return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Constraint getConstraint() {
		if (constraint != null && constraint.eIsProxy()) {
			InternalEObject oldConstraint = (InternalEObject)constraint;
			constraint = (Constraint)eResolveProxy(oldConstraint);
			if (constraint != oldConstraint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DCONSTRAINT__CONSTRAINT, oldConstraint, constraint));
			}
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DArrow> getDArrows() {
		if (dArrows == null) {
			dArrows = new EObjectWithInverseResolvingEList.ManyInverse<DArrow>(DArrow.class, this, DiagramPackage.DCONSTRAINT__DARROWS, DiagramPackage.DARROW__DCONSTRAINTS);
		}
		return dArrows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DNode> getDNodes() {
		if (dNodes == null) {
			dNodes = new EObjectWithInverseResolvingEList.ManyInverse<DNode>(DNode.class, this, DiagramPackage.DCONSTRAINT__DNODES, DiagramPackage.DNODE__DCONSTRAINTS);
		}
		return dNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DPredicate getDPredicate() {
		if (dPredicate != null && dPredicate.eIsProxy()) {
			InternalEObject oldDPredicate = (InternalEObject)dPredicate;
			dPredicate = (DPredicate)eResolveProxy(oldDPredicate);
			if (dPredicate != oldDPredicate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.DCONSTRAINT__DPREDICATE, oldDPredicate, dPredicate));
			}
		}
		return dPredicate;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void reconnect(EList<DNode> dNodes, EList<DArrow> dArrows, DSpecification dSpecification) {
		Assert.isNotNull(dSpecification);
		EList<Node> nodes = new BasicEList<Node>();
		EList<Arrow> arrows = new BasicEList<Arrow>();
		for(DNode node : dNodes) nodes.add(node.getNode());
		for(DArrow arrow : dArrows) arrows.add(arrow.getArrow());
		getConstraint().reconnect(nodes, arrows, dSpecification.getSpecification());
		if(!getDNodes().isEmpty())
			getDNodes().clear();
		getDNodes().addAll(dNodes);
		if(!getDArrows().isEmpty())
			getDArrows().clear();
		getDArrows().addAll(dArrows);
		if(!dSpecification.getDConstraints().contains(this))
			dSpecification.getDConstraints().add(this);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstraint(Constraint newConstraint) {
		Constraint oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DCONSTRAINT__CONSTRAINT, oldConstraint, constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setDPredicate(DPredicate newDPredicate) {
		DPredicate oldDPredicate = dPredicate;
		dPredicate = newDPredicate;
		if(constraint != null && !constraint.eIsProxy())
			constraint.setPredicate(dPredicate == null || dPredicate.eIsProxy() ? null : dPredicate.getPredicate());
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.DCONSTRAINT__DPREDICATE, oldDPredicate, dPredicate));
	}

} //DConstraintImpl
