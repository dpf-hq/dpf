/**
 * <copyright>
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, �yvind Bech and Dag Viggo Lok�en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFConstants;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getMetaFile <em>Meta File</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getSignatureFile <em>Signature File</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationImpl extends EObjectImpl implements Specification {
	

	/**
	 * The cached value of the '{@link #getGraph() <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph graph;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * The default value of the '{@link #getMetaFile() <em>Meta File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaFile()
	 * @generated
	 * @ordered
	 */
	protected static final String META_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetaFile() <em>Meta File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaFile()
	 * @generated
	 * @ordered
	 */
	protected String metaFile = META_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignatureFile() <em>Signature File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatureFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSignatureFile() <em>Signature File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatureFile()
	 * @generated
	 * @ordered
	 */
	protected String signatureFile = SIGNATURE_FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected Signature signature;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Specification type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		Graph oldGraph = graph;
		graph = newGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__GRAPH, oldGraph, newGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != graph) {
			NotificationChain msgs = null;
			if (graph != null)
				msgs = ((InternalEObject)graph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.SPECIFICATION__GRAPH, null, msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.SPECIFICATION__GRAPH, null, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, CorePackage.SPECIFICATION__CONSTRAINTS);
		}
		return constraints;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetaFile() {
		return metaFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaFile(String newMetaFile) {
		String oldMetaFile = metaFile;
		metaFile = newMetaFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__META_FILE, oldMetaFile, metaFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSignatureFile() {
		return signatureFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignatureFile(String newSignatureFile) {
		String oldSignatureFile = signatureFile;
		signatureFile = newSignatureFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__SIGNATURE_FILE, oldSignatureFile, signatureFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature getSignature() {
		if (signature != null && signature.eIsProxy()) {
			InternalEObject oldSignature = (InternalEObject)signature;
			signature = (Signature)eResolveProxy(oldSignature);
			if (signature != oldSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.SPECIFICATION__SIGNATURE, oldSignature, signature));
			}
		}
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetSignature() {
		return signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setSignature(Signature newSignature) {
		if(newSignature == signature) return;
		Signature oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__SIGNATURE, oldSignature, signature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Specification)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.SPECIFICATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setType(Specification newType) {
		Specification oldType = type;
		type = newType;
		
		if(graph != null && !graph.eIsProxy())
			graph.setType(type == null  || type.eIsProxy() ? null : type.getGraph());
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__TYPE, oldType, type));
	}

	//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public Graph createOStar(Constraint constraint) {
//		
//		EList<Arrow> constrainedTypeArrows = constraint.getArrows();
//		EList<Node> constrainedTypeNodes = constraint.getNodes();
//		
//		EList<Node> constrainedNodes = graph.getNodes(constrainedTypeNodes);
//		EList<Arrow> constrainedArrows = graph.getArrows(constrainedTypeArrows);
//		
//		return graph.extractSubgraph(constrainedNodes, constrainedArrows);
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Graph createGraph(String name) {
		Graph graph = CoreFactory.eINSTANCE.createDefaultGraph();
		graph.setName(name);
		setGraph(graph);
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return 
	 * @generated NOT
	 */
	public Constraint createConstraint(Predicate predicate, String parameters, GraphHomomorphism mapping, EList<Node> stuckedNodes, EList<Arrow> stuckedArrows, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		Constraint constraint = CoreFactory.eINSTANCE.createConstraint();
		constraint.setPredicate(predicate);
		constraint.setMappings(mapping);
		constraint.setParameters(parameters);
		constraint.getNodes().addAll(stuckedNodes);
		constraint.getArrows().addAll(stuckedArrows);
		this.getConstraints().add(constraint);
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validate() {
		boolean result = true;
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification getTemplateSpecification() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.SPECIFICATION__GRAPH:
				return basicSetGraph(null, msgs);
			case CorePackage.SPECIFICATION__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
			case CorePackage.SPECIFICATION__GRAPH:
				return getGraph();
			case CorePackage.SPECIFICATION__CONSTRAINTS:
				return getConstraints();
			case CorePackage.SPECIFICATION__META_FILE:
				return getMetaFile();
			case CorePackage.SPECIFICATION__SIGNATURE_FILE:
				return getSignatureFile();
			case CorePackage.SPECIFICATION__SIGNATURE:
				if (resolve) return getSignature();
				return basicGetSignature();
			case CorePackage.SPECIFICATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case CorePackage.SPECIFICATION__GRAPH:
				setGraph((Graph)newValue);
				return;
			case CorePackage.SPECIFICATION__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case CorePackage.SPECIFICATION__META_FILE:
				setMetaFile((String)newValue);
				return;
			case CorePackage.SPECIFICATION__SIGNATURE_FILE:
				setSignatureFile((String)newValue);
				return;
			case CorePackage.SPECIFICATION__SIGNATURE:
				setSignature((Signature)newValue);
				return;
			case CorePackage.SPECIFICATION__TYPE:
				setType((Specification)newValue);
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
			case CorePackage.SPECIFICATION__GRAPH:
				setGraph((Graph)null);
				return;
			case CorePackage.SPECIFICATION__CONSTRAINTS:
				getConstraints().clear();
				return;
			case CorePackage.SPECIFICATION__META_FILE:
				setMetaFile(META_FILE_EDEFAULT);
				return;
			case CorePackage.SPECIFICATION__SIGNATURE_FILE:
				setSignatureFile(SIGNATURE_FILE_EDEFAULT);
				return;
			case CorePackage.SPECIFICATION__SIGNATURE:
				setSignature(DPFConstants.DEFAULT_SIGNATURE);
				return;
			case CorePackage.SPECIFICATION__TYPE:
				setType(DPFConstants.REFLEXIVE_SPECIFICATION);
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
			case CorePackage.SPECIFICATION__GRAPH:
				return graph != null;
			case CorePackage.SPECIFICATION__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case CorePackage.SPECIFICATION__META_FILE:
				return META_FILE_EDEFAULT == null ? metaFile != null : !META_FILE_EDEFAULT.equals(metaFile);
			case CorePackage.SPECIFICATION__SIGNATURE_FILE:
				return SIGNATURE_FILE_EDEFAULT == null ? signatureFile != null : !SIGNATURE_FILE_EDEFAULT.equals(signatureFile);
			case CorePackage.SPECIFICATION__SIGNATURE:
				return signature != null && signature != DPFConstants.DEFAULT_SIGNATURE;
			case CorePackage.SPECIFICATION__TYPE:
				return type != null && type != DPFConstants.REFLEXIVE_SPECIFICATION;
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
		result.append(" (metaFile: ");
		result.append(metaFile);
		result.append(", signatureFile: ");
		result.append(signatureFile);
		result.append(')');
		return result.toString();
	}

} //SpecificationImpl
