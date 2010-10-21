/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor.model;

import java.lang.reflect.InvocationTargetException;

import no.hib.dpf.metamodel.Constraint;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.IDObject;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Predicate;

import org.eclipse.draw2d.Graphics;
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
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * A connection between two distinct shapes.
 * 
 * @author Elias Volanakis
 */
public class ConstraintElement extends ModelElement implements Constraint, IDObjectContainer {
	/**
	 * Used for indicating that a Connection with solid line style should be
	 * created.
	 * 
	 * @see no.hib.dpf.editor.parts.ShapeEditPart#createEditPolicies()
	 */
	public static final Integer SOLID_CONNECTION = new Integer(
			Graphics.LINE_SOLID);
	/**
	 * Used for indicating that a Connection with dashed line style should be
	 * created.
	 * 
	 * @see no.hib.dpf.editor.parts.ShapeEditPart#createEditPolicies()
	 */
	public static final Integer DASHED_CONNECTION = new Integer(
			Graphics.LINE_DASH);
	/** Property ID to use when the line style of this connection is modified. */
	public static final String LINESTYLE_PROP = "LineStyle";
	private static final IPropertyDescriptor[] descriptors = new IPropertyDescriptor[1];
	private static final String SOLID_STR = "Solid";
	private static final String DASHED_STR = "Dashed";
	private static final long serialVersionUID = 1;

	/** True, if the connection is attached to its endpoints. */
	protected boolean isConnected;
	/** Line drawing style for this constraint. */
	protected int lineStyle = Graphics.LINE_SOLID;
	/** Constraint's source endpoint. */
	protected Connection source;
	/** Constraint target endpoint. */
	protected Connection target;

	static {
		descriptors[0] = new ComboBoxPropertyDescriptor(LINESTYLE_PROP,
				LINESTYLE_PROP, new String[] { SOLID_STR, DASHED_STR });
	}

	private transient Constraint constraintComponent;
	private String constraintID;

	@Override
	public String getIDObjectID() {
		return constraintID;
	}	
	
	public enum ConstraintType {
		JointlyInjective,
		JointImage,
		Multiplicity
	}
	
	private ConstraintType constraintType;
	
	/**
	 * Create a (solid) connection between two distinct shapes.
	 * 
	 * @param source
	 *            a source endpoint for this connection (non null)
	 * @param target
	 *            a target endpoint for this connection (non null)
	 * @throws IllegalArgumentException
	 *             if any of the parameters are null or source == target
	 * @see #setLineStyle(int)
	 */
	public ConstraintElement(Connection source, Connection target, ConstraintType constraintType) {
		this.setConstraintType(constraintType);
		// The dpf Constraint object must be initialized before the connection of the shapes.
		setIDObject(MetamodelFactory.eINSTANCE.createConstraint());
		reconnect(source, target);		
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
			target.removeConstraint(this);
			isConnected = false;
		}
	}

	/**
	 * Returns the line drawing style of this connection.
	 * 
	 * @return an int value (Graphics.LINE_DASH or Graphics.LINE_SOLID)
	 */
	public int getLineStyle() {
		return lineStyle;
	}

	/**
	 * Returns the descriptor for the lineStyle property
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return descriptors;
	}

	/**
	 * Returns the lineStyle as String for the Property Sheet
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {
		if (id.equals(LINESTYLE_PROP)) {
			if (getLineStyle() == Graphics.LINE_DASH)
				// Dashed is the second value in the combo dropdown
				return new Integer(1);
			// Solid is the first value in the combo dropdown
			return new Integer(0);
		}
		return super.getPropertyValue(id);
	}

	/**
	 * Returns the source endpoint of this connection.
	 * 
	 * @return a non-null Shape instance
	 */
	public Connection getConnectionSource() {
		return source;
	}

	/**
	 * Returns the target endpoint of this connection.
	 * 
	 * @return a non-null Shape instance
	 */
	public Connection getConnectionTarget() {
		return target;
	}

	/**
	 * Reconnect this connection. The connection will reconnect with the shapes
	 * it was previously attached to.
	 */
	public void reconnect() {
		if (!isConnected) {
			source.addConstraint(this);
			target.addConstraint(this);
			isConnected = true;
		}
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
	public void reconnect(Connection newSource, Connection newTarget) {
		if (newSource == null || newTarget == null || newSource == newTarget) {
			throw new IllegalArgumentException();
		}
		disconnect();
		this.source = newSource;
		this.target = newTarget;
		reconnect();
	}

	/**
	 * Set the line drawing style of this connection.
	 * 
	 * @param lineStyle
	 *            one of following values: Graphics.LINE_DASH or
	 *            Graphics.LINE_SOLID
	 * @see Graphics#LINE_DASH
	 * @see Graphics#LINE_SOLID
	 * @throws IllegalArgumentException
	 *             if lineStyle does not have one of the above values
	 */
	public void setLineStyle(int lineStyle) {
		if (lineStyle != Graphics.LINE_DASH && lineStyle != Graphics.LINE_SOLID) {
			throw new IllegalArgumentException();
		}
		this.lineStyle = lineStyle;
		firePropertyChange(LINESTYLE_PROP, null, new Integer(this.lineStyle));
	}

	/**
	 * Sets the lineStyle based on the String provided by the PropertySheet
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object,
	 *      java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
		if (id.equals(LINESTYLE_PROP))
			setLineStyle(new Integer(1).equals(value) ? Graphics.LINE_DASH
					: Graphics.LINE_SOLID);
		else
			super.setPropertyValue(id, value);
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

}