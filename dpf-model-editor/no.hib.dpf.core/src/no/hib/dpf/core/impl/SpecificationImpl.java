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

import java.io.IOException;

import no.hib.dpf.constant.DPFConstants;
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getTypeGraph <em>Type Graph</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getSignature <em>Signature</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SpecificationImpl#getSignatureFile <em>Signature File</em>}</li>
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
	 * The cached value of the '{@link #getTypeGraph() <em>Type Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph typeGraph;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SpecificationImpl() {
		super();
		setTypeGraph(CoreFactory.eINSTANCE.createGraph());
		setGraph(CoreFactory.eINSTANCE.createGraph());
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
	public Graph getTypeGraph() {
		return typeGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeGraph(Graph newTypeGraph, NotificationChain msgs) {
		Graph oldTypeGraph = typeGraph;
		typeGraph = newTypeGraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__TYPE_GRAPH, oldTypeGraph, newTypeGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeGraph(Graph newTypeGraph) {
		if (newTypeGraph != typeGraph) {
			NotificationChain msgs = null;
			if (typeGraph != null)
				msgs = ((InternalEObject)typeGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.SPECIFICATION__TYPE_GRAPH, null, msgs);
			if (newTypeGraph != null)
				msgs = ((InternalEObject)newTypeGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.SPECIFICATION__TYPE_GRAPH, null, msgs);
			msgs = basicSetTypeGraph(newTypeGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SPECIFICATION__TYPE_GRAPH, newTypeGraph, newTypeGraph));
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
	 * @generated
	 */
	public void setSignature(Signature newSignature) {
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
	 * @generated NOT
	 */
	public void save(URI uri) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new  XMLResourceFactoryImpl());		

		Resource resource = resourceSet.createResource(uri);
		Resource graph = resourceSet.createResource(DPFConstants.DefaultGraph);
		graph.getContents().add(DPFConstants.REFLEXIVE_TYPE_GRAPH);
		resource.getContents().add(this);		
		
		resource.save(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Graph createOStar(Constraint constraint) {
		
		EList<Arrow> constrainedTypeArrows = constraint.getConstrainedArrows();
		EList<Node> constrainedTypeNodes = constraint.getConstrainedNodes();
		
		EList<Node> constrainedNodes = graph.getNodes(constrainedTypeNodes);
		EList<Arrow> constrainedArrows = graph.getArrows(constrainedTypeArrows);
		
		return graph.extractSubgraph(constrainedNodes, constrainedArrows);
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
			case CorePackage.SPECIFICATION__TYPE_GRAPH:
				return basicSetTypeGraph(null, msgs);
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
			case CorePackage.SPECIFICATION__TYPE_GRAPH:
				return getTypeGraph();
			case CorePackage.SPECIFICATION__SIGNATURE:
				if (resolve) return getSignature();
				return basicGetSignature();
			case CorePackage.SPECIFICATION__SIGNATURE_FILE:
				return getSignatureFile();
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
			case CorePackage.SPECIFICATION__GRAPH:
				setGraph((Graph)newValue);
				return;
			case CorePackage.SPECIFICATION__TYPE_GRAPH:
				setTypeGraph((Graph)newValue);
				return;
			case CorePackage.SPECIFICATION__SIGNATURE:
				setSignature((Signature)newValue);
				return;
			case CorePackage.SPECIFICATION__SIGNATURE_FILE:
				setSignatureFile((String)newValue);
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
			case CorePackage.SPECIFICATION__GRAPH:
				setGraph((Graph)null);
				return;
			case CorePackage.SPECIFICATION__TYPE_GRAPH:
				setTypeGraph((Graph)null);
				return;
			case CorePackage.SPECIFICATION__SIGNATURE:
				setSignature((Signature)null);
				return;
			case CorePackage.SPECIFICATION__SIGNATURE_FILE:
				setSignatureFile(SIGNATURE_FILE_EDEFAULT);
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
			case CorePackage.SPECIFICATION__GRAPH:
				return graph != null;
			case CorePackage.SPECIFICATION__TYPE_GRAPH:
				return typeGraph != null;
			case CorePackage.SPECIFICATION__SIGNATURE:
				return signature != null;
			case CorePackage.SPECIFICATION__SIGNATURE_FILE:
				return SIGNATURE_FILE_EDEFAULT == null ? signatureFile != null : !SIGNATURE_FILE_EDEFAULT.equals(signatureFile);
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
		result.append(" (signatureFile: ");
		result.append(signatureFile);
		result.append(')');
		return result.toString();
	}

} //SpecificationImpl
