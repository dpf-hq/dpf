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
import java.util.List;
import java.util.Vector;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.icons.ImageSettings;

import org.eclipse.draw2d.Bendpoint;
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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class DArrow extends ModelElement implements Arrow, IDObjectContainer {
	/**
	 * Used for indicating that a Connection with solid line style should be
	 * created.
	 * 
	 * @see no.hib.dpf.editor.parts.NodeEditPart#createEditPolicies()
	 */
	public static final Integer SOLID_CONNECTION = new Integer(
			Graphics.LINE_SOLID);
	/**
	 * Used for indicating that a Connection with dashed line style should be
	 * created.
	 * 
	 * @see no.hib.dpf.editor.parts.NodeEditPart#createEditPolicies()
	 */
	public static final Integer DASHED_CONNECTION = new Integer(
			Graphics.LINE_DASH);
	/** Property ID to use when the line style of this connection is modified. */
	public static final String LINESTYLE_PROP = "LineStyle";

	private static final String[] LINE_STRS = new String[]{"LINE_SOLID", "LINE_DASH"};//, "LINE_DOT", "LINE_DASHDOT", "LINE_DASHDOTDOT"};
	private static final long serialVersionUID = 1;
	private static final String CONSTRAINT_1_PROP = "Connection.constraint1";
	private static final String CONSTRAINT_2_PROP = "Connection.constraint2";

	/** Property ID to use when the list of outgoing constraints is modified. */
	public static final String SOURCE_CONSTRAINTS_PROP = "Connection.SourceConstraint";
	/** Property ID to use when the list of incoming constraints is modified. */
	public static final String TARGET_CONSTRAINTS_PROP = "Connection.TargetConstaint";
	/** Property ID to use when the list of single constraints is modified. */
	public static final String SINGLE_CONSTRAINTS_PROP = "Connection.SingleConstaint";
	
	public static final String NAME_PROP = "Connection.Name";
	public static final String TYPE_PROP = "Connection.Type";
		
	/** True, if the connection is attached to its endpoints. */
	private boolean isConnected;
	/** Line drawing style for this connection. */
	private int lineStyle = Graphics.LINE_SOLID;
	public transient int parentLineSytle = Graphics.LINE_SOLID;
	/** Connection's source endpoint. */
	private DNode source;
	/** Connection's target endpoint. */
	private DNode target;

	/** List of outgoing Constraints. */
	private List<DConstraint> sourceConstraints = new ArrayList<DConstraint>();
	/** List of incoming Constraints. */
	private List<DConstraint> targetConnstraints = new ArrayList<DConstraint>();
	/** List of single Constraints */
	private List<SingleArrowConstraintElement> singleConstraints = new ArrayList<SingleArrowConstraintElement>();
	
	private ArrowLabel mainLabel;	
	private static final IPropertyDescriptor[] descriptors;

	private static final String[] configureLabels = FigureConfigureManager.getInstance().getArrowNames();
	protected final String[] getConfigureLabels(){ return configureLabels;}
	static{
		descriptors = new IPropertyDescriptor[] {
				new ComboBoxPropertyDescriptor(LINESTYLE_PROP, LINESTYLE_PROP, LINE_STRS),
				new NegativeIntegerTextPropertyDescriptor(CONSTRAINT_1_PROP, "Constraints (1)"),
				new NegativeIntegerTextPropertyDescriptor(CONSTRAINT_2_PROP, "Constraints (2)"),
				new TextPropertyDescriptor(NAME_PROP, "Name"),
				new TextPropertyDescriptor(TYPE_PROP, "Type"),
				new ComboBoxPropertyDescriptor(PROP_CONFIGURE, "Configure", configureLabels)
		};
	}

	private transient Arrow arrowComponent;
	private String arrowID;


	public final static ImageDescriptor SMALLARROW = ImageSettings.SMALL_CONNECTION.getImageDescriptor();
	public final static ImageDescriptor LARGEARROW = ImageSettings.LARGE_CONNECTION.getImageDescriptor();

	@Override
	public String getIDObjectID() {
		return arrowID;
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
	public DArrow(DNode source, DNode target, Arrow typeArrow) {
		// The dpf Arrow object must be initialized before the connection of the shapes.
		setIDObject(CoreFactory.eINSTANCE.createArrow(typeArrow));
		addLabel("ref");
		reconnect(source, target);
	}

	public DArrow(DNode source, DNode target, Arrow typeArrow, DArrow typeDArrow) {
		setIDObject(CoreFactory.eINSTANCE.createArrow(typeArrow));
		addLabel("ref");
		if(typeDArrow != null){
			configure = typeDArrow.getConfigure();
			configurationName = FigureConfigureManager.getName(configure);
		}
	}

	@Override
	public void setIDObject(IDObject idObject) {
		if (idObject instanceof Arrow) {
			arrowComponent = (Arrow)idObject;
			arrowID = arrowComponent.getId();		
		}
	}
	
	public Arrow getArrowComponent() {
		return arrowComponent;
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
			return new Integer(getLineStyle() - SWT.LINE_SOLID);
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
		if (id.equals(NAME_PROP)) {
			return getName();
		}
		
		if (id.equals(TYPE_PROP)) {
			return getTypeName();
		}

		return super.getPropertyValue(id);
	}

	/**
	 * Returns the source endpoint of this connection.
	 * 
	 * @return a non-null Shape instance
	 */
	public DNode getShapeSource() {
		return source;
	}

	/**
	 * Returns the target endpoint of this connection.
	 * 
	 * @return a non-null Shape instance
	 */
	public DNode getShapeTarget() {
		return target;
	}

	/**
	 * Reconnect this connection. The connection will reconnect with the shapes
	 * it was previously attached to.
	 */
	public void reconnect() {
		if (!isConnected) {
			source.addOutgoingConnection(this);
			target.addIncomingConnection(this);
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
	public void reconnect(DNode newSource, DNode newTarget) {
//		if (newSource == null || newTarget == null || newSource == newTarget) {
		if (newSource == null || newTarget == null) {
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
		this.lineStyle = lineStyle;
	}

	// TODO: REMOVE!
	private void setConstraintValue1(int value) {
		if (singleConstraints.size() > 0) {
			singleConstraints.get(0).setPropertyValue(SingleArrowConstraintElement.MULTIPLICITY_1_PROP, new Integer(value));
			firePropertyChange(SINGLE_CONSTRAINTS_PROP, null, 0);		
		}
	}	

	private void setConstraintValue2(int value) {
		if (singleConstraints.size() > 0) {
			singleConstraints.get(0).setPropertyValue(SingleArrowConstraintElement.MULTIPLICITY_2_PROP, new Integer(value));
			firePropertyChange(SINGLE_CONSTRAINTS_PROP, null, 0);		
		}
	}
	
	public void refreshSingleConstraints() {
		firePropertyChange(SINGLE_CONSTRAINTS_PROP, null, 0);		
	}
	
	
	/**
	 * Sets the lineStyle based on the String provided by the PropertySheet
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object,
	 *      java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
		if (id.equals(LINESTYLE_PROP)) {
			if(((Integer)value).intValue() != getLineStyle() - SWT.LINE_SOLID)
				setLineStyle(((Integer)value).intValue() + SWT.LINE_SOLID);
		} else if (id.equals(CONSTRAINT_1_PROP)) {
			setConstraintValue1(Integer.parseInt((String) value));
		} else if (id.equals(CONSTRAINT_2_PROP)) {
			setConstraintValue2(Integer.parseInt((String) value));
		} else if (id.equals(NAME_PROP)) {
			setNameExec((String) value);
		} else {
			super.setPropertyValue(id, value);
		}
	}

	public List<DConstraint> getSourceConstraints() {
		return new ArrayList<DConstraint>(sourceConstraints);
	}

	public List<DConstraint> getTargetConstraints() {
		return new ArrayList<DConstraint>(targetConnstraints);
	}
	
	protected void addIncomingConstraint(DConstraint constraint) {
		targetConnstraints.add(constraint);
		addedConstraint(constraint, TARGET_CONSTRAINTS_PROP);
	}

	protected void addOutgoingConstraint(DConstraint constraint) {
		sourceConstraints.add(constraint);		
		addedConstraint(constraint, SOURCE_CONSTRAINTS_PROP);
	}

	protected void addSingleConstraint(SingleArrowConstraintElement constraint) {
		singleConstraints.add(constraint);
		addedConstraint(constraint, SINGLE_CONSTRAINTS_PROP);
	}
	
	private void addedConstraint(DConstraint constraint, String property) {
		constraint.setGraph(getGraph());		
		firePropertyChange(property, null, constraint);
	}
	
	public void addConstraint(DConstraint constraint) {
		if (constraint == null || constraint.getConnectionSource() == constraint.getConnectionTarget()) {
			throw new IllegalArgumentException();
		}
		if (constraint.getConnectionSource() == this) {
			addOutgoingConstraint(constraint);
		} else if (constraint.getConnectionTarget() == this) {
			addIncomingConstraint(constraint);
		}
	}
	
	public void setNameExec(String name) {
		String oldName = arrowComponent.getName();
		arrowComponent.setName(name);
		setMainLabelText(name);
		firePropertyChange(NAME_PROP, oldName, name);
	}

	private void setMainLabelText(String name) {
		((ArrowLabel)getLabels().get(0)).setLabelText(name);
	}
	
	protected void removeIncomingConstraint(DConstraint constraint) {
		targetConnstraints.remove(constraint);
		removedConstraint(constraint, TARGET_CONSTRAINTS_PROP);
	}

	protected void removeOutgoingConstraint(DConstraint constraint) {
		sourceConstraints.remove(constraint);
		removedConstraint(constraint, SOURCE_CONSTRAINTS_PROP);
	}
	
	protected void removeSingleConstraint(SingleArrowConstraintElement constraint) {
		singleConstraints.remove(constraint);
		removedConstraint(constraint, SINGLE_CONSTRAINTS_PROP);
	}
	
	private void removedConstraint(DConstraint constraint, String property) {
		constraint.setGraph(null);		
		firePropertyChange(property, null, constraint);
	}	
	
	void removeConstraint(DConstraint constraint) {
		if (constraint == null) {
			throw new IllegalArgumentException();
		}
		if (constraint.getConnectionSource() == this) {
			removeOutgoingConstraint(constraint);
		} else if (constraint.getConnectionTarget() == this) {
			removeIncomingConstraint(constraint);
		}
	}
	
	public List<SingleArrowConstraintElement> getSingleConstraints() {
		return singleConstraints;
	}	
	
	
	
	// ------- * E X T R A
	protected List<Bendpoint> bendpoints = new ArrayList<Bendpoint>();
	
	public void insertBendpoint(int index, Bendpoint point) {
		getBendpoints().add(index, point);
		firePropertyChange("bendpoint", null, null);//$NON-NLS-1$
	}

	public void removeBendpoint(int index) {
		getBendpoints().remove(index);
		firePropertyChange("bendpoint", null, null);//$NON-NLS-1$
	}

	public void setBendpoint(int index, Bendpoint point) {
		getBendpoints().set(index, point);
		firePropertyChange("bendpoint", null, null);//$NON-NLS-1$
	}

	// TODO: refactor from giving away all bendpoints as list
	public List<Bendpoint> getBendpoints() {
		return bendpoints;
	}
	
	public void addLabel(String text) {
		mainLabel = new ArrowLabel(text, false);
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getLabels() {
		Vector retVal = new Vector();
		retVal.add(mainLabel);
		for (SingleArrowConstraintElement constraintElement : singleConstraints) {
			retVal.add(constraintElement.getConstraintLabel());
		}
		return retVal;
	}
	
	// -----------------------------------------------------------------------------------
	// Arrow methods:
	// -----------------------------------------------------------------------------------

	@Override
	public EClass eClass() {
		return arrowComponent.eClass();
	}

	@Override
	public Resource eResource() {
		return arrowComponent.eResource();
	}

	@Override
	public EObject eContainer() {
		return arrowComponent.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return arrowComponent.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return arrowComponent.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return arrowComponent.eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return arrowComponent.eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return arrowComponent.eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return arrowComponent.eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return arrowComponent.eGet(feature);
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return arrowComponent.eGet(feature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		arrowComponent.eSet(feature, newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return arrowComponent.eIsSet(feature);
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		arrowComponent.eUnset(feature);
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		return arrowComponent.eInvoke(operation, arguments);
	}

	@Override
	public EList<Adapter> eAdapters() {
		return arrowComponent.eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return arrowComponent.eDeliver();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		arrowComponent.eSetDeliver(deliver);
	}

	@Override
	public void eNotify(Notification notification) {
		arrowComponent.eNotify(notification);
	}

	@Override
	public void setSource(Node value) {
		arrowComponent.setSource(value);
	}

	@Override
	public void setTarget(Node value) {
		arrowComponent.setTarget(value);
	}

	@Override
	public String getName() {
		return arrowComponent.getName();
	}

	@Override
	public void setName(String value) {
		arrowComponent.setName(value);
	}

	@Override
	public Graph getGraph() {
		return arrowComponent.getGraph();
	}

	@Override
	public void setGraph(Graph value) {
		arrowComponent.setGraph(value);
	}

	@Override
	public Node getSource() {
		return arrowComponent.getSource();
	}

	@Override
	public Node getTarget() {
		return arrowComponent.getTarget();
	}

	@Override
	public String getId() {
		return arrowComponent.getId();
	}

	@Override
	public void setId(String value) {
		arrowComponent.setId(value);
	}


	@Override
	public Arrow getTypeArrow() {
		return arrowComponent.getTypeArrow();
	}


	@Override
	public void setTypeArrow(Arrow value) {
		arrowComponent.setTypeArrow(value);
	}


	@Override
	public String getTypeName() {
		return arrowComponent.getTypeName();
	}

	@Override
	public String generateUniqueName() {
		return arrowComponent.generateUniqueName();
	}	


}