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
import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.IDObject;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;

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
public class Connection extends ModelElement implements Edge, IDObjectContainer {
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
	private static final IPropertyDescriptor[] descriptors = new IPropertyDescriptor[3];
	private static final String SOLID_STR = "Solid";
	private static final String DASHED_STR = "Dashed";
	private static final long serialVersionUID = 1;

	private static final String CONSTRAINT_1_PROP = "Connection.constraint1";
	private static final String CONSTRAINT_2_PROP = "Connection.constraint2";

	/** Property ID to use when the list of outgoing constraints is modified. */
	public static final String SOURCE_CONSTRAINTS_PROP = "Connection.SourceConstraint";
	/** Property ID to use when the list of incoming constraints is modified. */
	public static final String TARGET_CONSTRAINTS_PROP = "Connection.TargetConstaint";
	/** Property ID to use when the list of single constraints is modified. */
	public static final String SINGLE_CONSTRAINTS_PROP = "Connection.SingleConstaint";
	
	/** True, if the connection is attached to its endpoints. */
	private boolean isConnected;
	/** Line drawing style for this connection. */
	private int lineStyle = Graphics.LINE_SOLID;
	/** Connection's source endpoint. */
	private Shape source;
	/** Connection's target endpoint. */
	private Shape target;

	/** List of outgoing Connections. */
	private List<ConstraintElement> sourceConstraints = new ArrayList<ConstraintElement>();
	/** List of incoming Connections. */
	private List<ConstraintElement> targetConnstraints = new ArrayList<ConstraintElement>();
	/** List of single Constraints */
	private List<SingleLineConstraintElement> singleConstraints = new ArrayList<SingleLineConstraintElement>();
	
	static {
		descriptors[0] = new ComboBoxPropertyDescriptor(LINESTYLE_PROP,
				LINESTYLE_PROP, new String[] { SOLID_STR, DASHED_STR });
		
		descriptors[1] = new NegativeIntegerTextPropertyDescriptor(CONSTRAINT_1_PROP, "Constraints (1)");
		descriptors[2] = new NegativeIntegerTextPropertyDescriptor(CONSTRAINT_2_PROP, "Constraints (2)");
		
	}

	private transient Edge edgeComponent;
	private String edgeID;

	@Override
	public String getIDObjectID() {
		return edgeID;
	}	
	
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
	public Connection(Shape source, Shape target) {
		// The dpf Edge object must be initialized before the connection of the shapes.
		setIDObject(MetamodelFactory.eINSTANCE.createEdge());
		reconnect(source, target);
	}

	@Override
	public void setIDObject(IDObject idObject) {
		if (idObject instanceof Edge) {
			edgeComponent = (Edge)idObject;
			edgeID = edgeComponent.getId();		
		}
	}
	
	/**
	 * Disconnect this connection from the shapes it is attached to.
	 */
	public void disconnect() {
		if (isConnected) {
			source.removeConnection(this);
			target.removeConnection(this);
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
		if (id.equals(CONSTRAINT_1_PROP)) {
			if (singleConstraints.size() > 0) {
				return Integer.toString(singleConstraints.get(0).getVal_1());
			}
		}
		if (id.equals(CONSTRAINT_2_PROP)) {
			if (singleConstraints.size() > 0) {
				return Integer.toString(singleConstraints.get(0).getVal_2());
			}
		}
		return super.getPropertyValue(id);
	}

	/**
	 * Returns the source endpoint of this connection.
	 * 
	 * @return a non-null Shape instance
	 */
	public Shape getShapeSource() {
		return source;
	}

	/**
	 * Returns the target endpoint of this connection.
	 * 
	 * @return a non-null Shape instance
	 */
	public Shape getShapeTarget() {
		return target;
	}

	/**
	 * Reconnect this connection. The connection will reconnect with the shapes
	 * it was previously attached to.
	 */
	public void reconnect() {
		if (!isConnected) {
			source.addConnection(this);
			target.addConnection(this);
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
	public void reconnect(Shape newSource, Shape newTarget) {
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

	private void setConstraintValue1(int value) {
		if (singleConstraints.size() > 0) {
			singleConstraints.get(0).setVal_1(value);
			firePropertyChange(SINGLE_CONSTRAINTS_PROP, null, 0);		
		}
	}

	private void setConstraintValue2(int value) {
		if (singleConstraints.size() > 0) {
			singleConstraints.get(0).setVal_2(value);
			firePropertyChange(SINGLE_CONSTRAINTS_PROP, null, 0);		
		}
	}
	
	/**
	 * Sets the lineStyle based on the String provided by the PropertySheet
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object,
	 *      java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
		if (id.equals(LINESTYLE_PROP)) {
			setLineStyle(new Integer(1).equals(value) ? Graphics.LINE_DASH
					: Graphics.LINE_SOLID);
		} else if (id.equals(CONSTRAINT_1_PROP)) {
			setConstraintValue1(Integer.parseInt((String) value));
		} else if (id.equals(CONSTRAINT_2_PROP)) {
			setConstraintValue2(Integer.parseInt((String) value));
		} else {
			super.setPropertyValue(id, value);
		}
	}

	public List<ConstraintElement> getSourceConstraints() {
		return new ArrayList<ConstraintElement>(sourceConstraints);
	}

	public List<ConstraintElement> getTargetConstraints() {
		return new ArrayList<ConstraintElement>(targetConnstraints);
	}
	
	protected void addIncomingConstraint(ConstraintElement constraint) {
		targetConnstraints.add(constraint);
		firePropertyChange(TARGET_CONSTRAINTS_PROP, null, constraint);
	}

	protected void addOutgoingConstraint(ConstraintElement constraint) {
		sourceConstraints.add(constraint);
		firePropertyChange(SOURCE_CONSTRAINTS_PROP, null, constraint);
	}
	
	protected void addSingleConstraint(SingleLineConstraintElement constraint) {
		singleConstraints.add(constraint);
		firePropertyChange(SINGLE_CONSTRAINTS_PROP, null, constraint);
	}
	
	public void addConstraint(ConstraintElement constraint) {
		if (constraint == null || constraint.getConnectionSource() == constraint.getConnectionTarget()) {
			throw new IllegalArgumentException();
		}
		if (constraint.getConnectionSource() == this) {
			addOutgoingConstraint(constraint);
		} else if (constraint.getConnectionTarget() == this) {
			addIncomingConstraint(constraint);
		}
	}
	
	protected void removeIncomingConstraint(ConstraintElement constraint) {
		targetConnstraints.remove(constraint);
		firePropertyChange(TARGET_CONSTRAINTS_PROP, null, constraint);
	}

	protected void removeOutgoingConstraint(ConstraintElement constraint) {
		sourceConstraints.remove(constraint);
		firePropertyChange(SOURCE_CONSTRAINTS_PROP, null, constraint);
	}
	
	protected void removeSingleConstraint(SingleLineConstraintElement constraint) {
		singleConstraints.remove(constraint);
		firePropertyChange(SINGLE_CONSTRAINTS_PROP, null, constraint);
	}
	
	void removeConstraint(ConstraintElement constraint) {
		if (constraint == null) {
			throw new IllegalArgumentException();
		}
		if (constraint.getConnectionSource() == this) {
			removeOutgoingConstraint(constraint);
		} else if (constraint.getConnectionTarget() == this) {
			removeIncomingConstraint(constraint);
		}
	}
	
	public List<SingleLineConstraintElement> getSingleConstraints() {
		return singleConstraints;
	}	
	
	// -----------------------------------------------------------------------------------
	// Edge methods:
	// -----------------------------------------------------------------------------------

	@Override
	public EClass eClass() {
		return edgeComponent.eClass();
	}

	@Override
	public Resource eResource() {
		return edgeComponent.eResource();
	}

	@Override
	public EObject eContainer() {
		return edgeComponent.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return edgeComponent.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return edgeComponent.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return edgeComponent.eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return edgeComponent.eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return edgeComponent.eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return edgeComponent.eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return edgeComponent.eGet(feature);
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return edgeComponent.eGet(feature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		edgeComponent.eSet(feature, newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return edgeComponent.eIsSet(feature);
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		edgeComponent.eUnset(feature);
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		return edgeComponent.eInvoke(operation, arguments);
	}

	@Override
	public EList<Adapter> eAdapters() {
		return edgeComponent.eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return edgeComponent.eDeliver();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		edgeComponent.eSetDeliver(deliver);
	}

	@Override
	public void eNotify(Notification notification) {
		edgeComponent.eNotify(notification);
	}

	@Override
	public void setSource(Node value) {
		edgeComponent.setSource(value);
	}

	@Override
	public void setTarget(Node value) {
		edgeComponent.setTarget(value);
	}

	@Override
	public String getName() {
		return edgeComponent.getName();
	}

	@Override
	public void setName(String value) {
		edgeComponent.setName(value);
	}

	@Override
	public Graph getGraph() {
		return edgeComponent.getGraph();
	}

	@Override
	public void setGraph(Graph value) {
		edgeComponent.setGraph(value);
	}

	@Override
	public Node getSource() {
		return edgeComponent.getSource();
	}

	@Override
	public Node getTarget() {
		return edgeComponent.getTarget();
	}

	@Override
	public String getId() {
		return edgeComponent.getId();
	}

	@Override
	public void setId(String value) {
		edgeComponent.setId(value);
	}

}