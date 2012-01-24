/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class DConstraint extends ModelElement implements Constraint, IDObjectContainer {

	private transient IPropertyDescriptor[] descriptors = null;
	private static final long serialVersionUID = 1;

	/** True, if the connection is attached to its endpoints. */
	protected boolean isConnected;
	/** Constraint's source endpoint. */
	protected DArrow source;
	/** Constraint target endpoint. */
	protected List<DArrow> targets = new ArrayList<DArrow>();
	
	private transient Constraint constraintComponent;
	private String constraintID;
	public static final String PARAMETER_PROP = "Constraint.Parameter";
	
	@Override
	public String getIDObjectID() {
		return constraintID;
	}	
	
	public enum ConstraintType {
		JOINTLY_INJECTIVE,
		JOINTLY_SURJECTIVE,
		MULTIPLICITY,
		INVERSE,
		IMAGE_INCLUSION,
		COMPOSITION,
		INJECTIVE,
		IRREFLEXIVE,
		TRANSITIVE_IRREFLEXIVE,
		SURJECTIVE,
		XOR,
		NAND
	}
	
	protected ConstraintType constraintType;
	
	protected DConstraint() {
	}
	
	/**
	 * Create a constraint between two arrows.
	 * 
	 * @param source
	 *            a source endpoint for this connection (non null)
	 * @param target
	 *            a target endpoint for this connection (non null)
	 * @throws IllegalArgumentException
	 *             if any of the parameters are null or source == target
	 * @see #setLineStyle(int)
	 */
	public DConstraint(DArrow source, DArrow target, ConstraintType constraintType, Constraint idObject) {		
		this(source, new ArrayList<DArrow>(Arrays.asList(target)), constraintType, idObject);
	}
	
	
	/**
	 * Create a constraint on one or more arrows.
	 * 
	 * @param source
	 *            a source endpoint for this connection (non null)
	 * @param targets
	 *            a target endpoint for this connection (can be empty)
	 * @throws IllegalArgumentException
	 *             if any of the parameters are null or source == target
	 * @see #setLineStyle(int)
	 */
	public DConstraint(DArrow source, List<DArrow> targets, ConstraintType constraintType, Constraint idObject) {
		this.setConstraintType(constraintType);
		// The dpf Constraint object must be initialized before the connection of the shapes.
		setIDObject(idObject);
		reconnect(source, targets);
	}

	@Override
	public void setIDObject(IDObject idObject) {
		if (idObject instanceof Constraint) {
			constraintComponent = (Constraint)idObject;
			constraintID = constraintComponent.getId();		
		}
	}
	
	/**
	 * Disconnect this connection from the shapes it is attached to.
	 */
	public void disconnect() {
		if (isConnected) {
			source.removeConstraint(this);
			for (DArrow target : targets) {
				target.removeConstraint(this);
			}
			isConnected = false;
		}
	}

	/**
	 * Returns the descriptor for the lineStyle property
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public static String[] EMPTY_STRING = new String[0];
	private transient String[] properties = null;
	private transient String[] values = null;
	public String[] getValues() {
		if(values == null)
			initProperties();
		return values;
	}

	private void initProperties() {
		properties = EMPTY_STRING;
		values = EMPTY_STRING;
		String parString = getParameters();
		if(parString.isEmpty())
			return;
		String[] paras = parString.split(";");
		properties = new String[paras.length];
		values = new String[paras.length];
		for (int i = 0; i < paras.length; i++) {
			String string = paras[i];
			String[] keyValue = string.split(":");
			if(keyValue.length != 2){
				properties = EMPTY_STRING;
				values = EMPTY_STRING;
				return;
			}
			String key = keyValue[0];
			properties[i] = key;
			String value = keyValue[1];
			values[i] = value;
		}
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		if(descriptors == null){
			if(values == null)
				initProperties();
			descriptors = new IPropertyDescriptor[values.length];
			for (int i = 0; i < values.length; i++) {
				String key = properties[i];
				descriptors[i] = new NegativeIntegerTextPropertyDescriptor(key, key);
			}
		}
		return descriptors;
	}

	/**
	 * Returns the lineStyle as String for the Property Sheet
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {
		int i = 0;
		for (; i < properties.length; i++) {
			 if(id.equals(properties[i]))
				 break;
			
		}
		if(i < properties.length)
			return values[i];
		return super.getPropertyValue(id);
	}

	public void setPropertyValue(Object id, Object value) {
		int i = 0;
		for (; i < properties.length; i++) {
			 if(id.equals(properties[i]))
				 break;
			
		}
		if(i < properties.length && !values[i].equals(value)){
			values[i] = (String) value;
			setParameters(construstParameterString());
		}
		else 
			super.setPropertyValue(id, value);
	}
	private String construstParameterString() {
		String result = "";
		for (int i = 0; i < properties.length; i++) {
			result += properties[i];
			result += ":";
			result += values[i];
			if(i != properties.length - 1)
				result += ";";
		}
		return result;
	}

	/**
	 * Returns the source endpoint of this connection.
	 * 
	 * @return a non-null Shape instance
	 */
	public DArrow getConnectionSource() {
		return source;
	}

	/**
	 * Returns the target endpoint of this connection.
	 * 
	 * @return a non-null Shape instance
	 */
	public DArrow getConnectionTarget() {
		if (targets.size() == 0) {
			return null;
		}
		return targets.get(0);
	}
	
	/**
	 * Reconnect to a different source and/or target shape. The connection will
	 * disconnect from its current attachments and reconnect to the new source
	 * and target.
	 * 
	 * @param newSource
	 *            a new source endpoint for this connection (non null)
	 * @param newTarget
	 *            a new target endpoint for this connection (non null)
	 * @throws IllegalArgumentException
	 *             if any of the paramers are null or newSource == newTarget
	 */
	protected void reconnect(DArrow newSource, List<DArrow> newTargets) {
		if (newSource == null) {
			throw new IllegalArgumentException();
		}
		disconnect();
		source = newSource;
		targets = newTargets;
		reconnect();
	}

	/**
	 * Reconnect this connection. The connection will reconnect with the shapes
	 * it was previously attached to.
	 */
	public void reconnect() {
		if (!isConnected) {
			source.addConstraint(this);
			for (DArrow target : targets) {
				target.addConstraint(this);
			}
			isConnected = true;
		}
	}
	
	public void setConstraintType(ConstraintType constraintType) {
		this.constraintType = constraintType;
	}

	public ConstraintType getConstraintType() {
		return constraintType;
	}
	
	// -----------------------------------------------------------------------------------
	// Constraint methods:
	// -----------------------------------------------------------------------------------	

	@Override
	public EClass eClass() {
		return constraintComponent.eClass();
	}

	@Override
	public Resource eResource() {
		return constraintComponent.eResource();
	}

	@Override
	public EObject eContainer() {
		return constraintComponent.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return constraintComponent.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return constraintComponent.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return constraintComponent.eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return constraintComponent.eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return constraintComponent.eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return constraintComponent.eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return constraintComponent.eGet(feature);
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return constraintComponent.eGet(feature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		constraintComponent.eSet(feature, newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return constraintComponent.eIsSet(feature);
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		constraintComponent.eUnset(feature);
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		return constraintComponent.eInvoke(operation, arguments);
	}

	@Override
	public EList<Adapter> eAdapters() {
		return constraintComponent.eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return constraintComponent.eDeliver();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		constraintComponent.eSetDeliver(deliver);
	}

	@Override
	public void eNotify(Notification notification) {
		constraintComponent.eNotify(notification);
	}

	@Override
	public Graph getGraph() {
		return constraintComponent.getGraph();
	}

	@Override
	public void setGraph(Graph value) {
		constraintComponent.setGraph(value);
	}

	@Override
	public Predicate getPredicate() {
		return constraintComponent.getPredicate();
	}

	@Override
	public void setPredicate(Predicate value) {
		constraintComponent.setPredicate(value);
	}

	@Override
	public GraphHomomorphism getMappings() {
		return constraintComponent.getMappings();
	}

	@Override
	public void setMappings(GraphHomomorphism value) {
		constraintComponent.setMappings(value);
	}

	@Override
	public String getId() {
		return constraintComponent.getId();
	}

	@Override
	public void setId(String value) {
		constraintComponent.setId(value);
	}

	@Override
	public EList<Node> getConstrainedNodes() {
		return constraintComponent.getConstrainedNodes();
	}

	@Override
	public EList<Arrow> getConstrainedArrows() {
		return constraintComponent.getConstrainedArrows();
	}

	@Override
	public String getParameters() {
		return constraintComponent.getParameters();
	}

	@Override
	public void setParameters(String value) {
		String old = constraintComponent.getParameters();
		constraintComponent.setParameters(value);
		firePropertyChange(PARAMETER_PROP, old, value);
	}

}