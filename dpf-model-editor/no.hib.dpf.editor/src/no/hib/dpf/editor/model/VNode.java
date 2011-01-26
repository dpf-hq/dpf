/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
�* All rights reserved. This program and the accompanying materials
�* are made available under the terms of the Eclipse Public License v1.0
�* which accompanies this distribution, and is available at
�* http://www.eclipse.org/legal/epl-v10.html
�*
�* Contributors:
�*����Elias Volanakis - initial API and implementation
�*******************************************************************************/
package no.hib.dpf.editor.model;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.icons.ImageSettings;
import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.IDObject;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class VNode extends ModelElement implements Node, IDObjectContainer, MovableAndSizable {

	public void setGraphExec(Graph graph) {
		nodeComponent.setGraph(graph);
	}	

	public void removeGraphExec() {
		nodeComponent.setGraph(null);
	}

	public void setNameExec(String name) {
		nodeComponent.setName(name);		
		firePropertyChange(NAME_PROP, null, name);		
	}

	public String getNameExec() {
		// TODO: move non-null-value handling to EMF
		String retVal = nodeComponent.getName();
		if (retVal == null) {
			retVal = "";
			nodeComponent.setName(retVal);
		}
		return retVal;
	}
	
	private static final long serialVersionUID = 7208811341274639248L;

	private static IPropertyDescriptor[] descriptors;

	/** Property ID to use when the list of outgoing connections is modified. */
	public static final String SOURCE_CONNECTIONS_PROP = "Shape.SourceConn";
	/** Property ID to use when the list of incoming connections is modified. */
	public static final String TARGET_CONNECTIONS_PROP = "Shape.TargetConn";
	
	public static final String NEW_LOCATION_PROP = "Shape.NewLocation";
	
	/** Property ID to use when the name is modified. */	
	public static final String NAME_PROP = "Shape.Name";
	public static final String TYPE_PROP = "Shape.Type";

	private LocationAndSize locationAndSize;

	/*
	 * Initializes the property descriptors array.
	 * 
	 * @see #getPropertyDescriptors()
	 * 
	 * @see #getPropertyValue(Object)
	 * 
	 * @see #setPropertyValue(Object, Object)
	 */
	static {
		descriptors = new IPropertyDescriptor[] {
			new TextPropertyDescriptor(NAME_PROP, "Name"),
			new TextPropertyDescriptor(TYPE_PROP, "Type")};
	} // static

	protected static Image createImage(String name) {
		InputStream stream = DPFPlugin.class.getResourceAsStream(name);
		Image image = new Image(null, stream);
		try {
			stream.close();
		} catch (IOException ioe) {
		}
		return image;
	}
	
	/** List of outgoing Connections. */
	private List<VArrow> sourceConnections = new ArrayList<VArrow>();
	/** List of incoming Connections. */
	private List<VArrow> targetConnections = new ArrayList<VArrow>();

	/**
	 * Returns an array of IPropertyDescriptors for this shape.
	 * <p>
	 * The returned array is used to fill the property view, when the edit-part
	 * corresponding to this model element is selected.
	 * </p>
	 * 
	 * @see #descriptors
	 * @see #getPropertyValue(Object)
	 * @see #setPropertyValue(Object, Object)
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return getLocationAndSize().getPropertyDescriptors(descriptors);
	}

	/**
	 * Return the property value for the given propertyId, or null.
	 * <p>
	 * The property view uses the IDs from the IPropertyDescriptors array to
	 * obtain the value of the corresponding properties.
	 * </p>
	 * 
	 * @see #descriptors
	 * @see #getPropertyDescriptors()
	 */
	public Object getPropertyValue(Object propertyId) {
		Object valueFromLocation = getLocationAndSize().getPropertyValue(propertyId);
		if (valueFromLocation != null) {
			return valueFromLocation;
		}
		if (NAME_PROP.equals(propertyId)) {
			return getNameExec();
		}
		if (TYPE_PROP.equals(propertyId)) {
			return getTypeName();
		}
		return super.getPropertyValue(propertyId);
	}

	/* (non-Javadoc)
	 * @see no.hib.dpf.editor.model.MovableAndSizable#getLocation()
	 */
	@Override
	public Point getLocation() {
		return getLocationAndSize().getLocation();
	}
	
	/* (non-Javadoc)
	 * @see no.hib.dpf.editor.model.MovableAndSizable#getSize()
	 */
	@Override
	public Dimension getSize() {
		return getLocationAndSize().getSize();
	}
	
	/* (non-Javadoc)
	 * @see no.hib.dpf.editor.model.MovableAndSizable#setLocation(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public void setLocation(Point newLocation) {
		getLocationAndSize().setLocation(newLocation);
		firePropertyChange(LocationAndSize.LOCATION_PROP, null, getLocationAndSize().getLocation());
	}

	/* (non-Javadoc)
	 * @see no.hib.dpf.editor.model.MovableAndSizable#setSize(org.eclipse.draw2d.geometry.Dimension)
	 */
	@Override
	public void setSize(Dimension newSize) {
		getLocationAndSize().setSize(newSize);
		firePropertyChange(LocationAndSize.SIZE_PROP, null, getLocationAndSize().getSize());
	}

	/**
	 * Return a List of outgoing Connections.
	 */
	public List<VArrow> getSourceConnections() {
		return new ArrayList<VArrow>(sourceConnections);
	}

	/**
	 * Return a List of incoming Connections.
	 */
	public List<VArrow> getTargetConnections() {
		return new ArrayList<VArrow>(targetConnections);
	}

	/**
	 * Remove an incoming or outgoing connection from this shape.
	 * 
	 * @param conn
	 *            a non-null connection instance
	 * @throws IllegalArgumentException
	 *             if the parameter is null
	 */
	public void removeConnection(VArrow conn) {
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		if (conn.getShapeSource() == this) {
			removeOutgoingConnection(conn);
		}
		if (conn.getShapeTarget() == this) {
			removeIncomingConnection(conn);
		}
	}
			
	/**
	 * Set the property value for the given property id. If no matching id is
	 * found, the call is forwarded to the superclass.
	 * <p>
	 * The property view uses the IDs from the IPropertyDescriptors array to set
	 * the values of the corresponding properties.
	 * </p>
	 * 
	 * @see #descriptors
	 * @see #getPropertyDescriptors()
	 */
	public void setPropertyValue(Object propertyId, Object value) {
		if (!getLocationAndSize().setPropertyValue(propertyId, value)) {
			if (NAME_PROP.equals(propertyId)) {
				setNameExec((String)value);
			} else {
				super.setPropertyValue(propertyId, value);
			}
		}
	}
	
	private LocationAndSize getLocationAndSize() {
		if (locationAndSize == null) {
			locationAndSize = new LocationAndSize(this);
		}
		return locationAndSize;
	}	

	private transient Node nodeComponent;
	private String nodeID;

	public VNode() {
		super();
		setIDObject(MetamodelFactory.eINSTANCE.createNode());
	}

	public VNode(Node typeNode) {
		super();
		setIDObject(MetamodelFactory.eINSTANCE.createNode(typeNode));
	}

	@Override
	public String getIDObjectID() {
		return nodeID;
	}
	
	/** A pictogram of a rectangular shape. */
	private static final Image RECTANGLE_ICON = createImage(ImageSettings.getImageSettings().getFilePath(ImageSettings.SMALL_RECTANGLE));

	public Image getIcon() {
		return RECTANGLE_ICON;
	}

	public String toString() {
		return "Node " + hashCode();
	}
	
	public void addIncomingConnection(VArrow conn) {
		targetConnections.add(conn);
		firePropertyChange(TARGET_CONNECTIONS_PROP, null, conn);
		conn.setTarget(nodeComponent);
		setGraph(conn);
	}

	public void addOutgoingConnection(VArrow conn) {
		sourceConnections.add(conn);
		firePropertyChange(SOURCE_CONNECTIONS_PROP, null, conn);
		conn.setSource(nodeComponent);
		setGraph(conn);
	}
	
	private void setGraph(VArrow conn) {
		conn.setGraph(getGraph());
	}
	
	protected void removeIncomingConnection(VArrow conn) {
		targetConnections.remove(conn);
		firePropertyChange(TARGET_CONNECTIONS_PROP, null, conn);
		conn.setTarget(null);
		removeGraph(conn);
	}

	protected void removeOutgoingConnection(VArrow conn) {
		sourceConnections.remove(conn);
		firePropertyChange(SOURCE_CONNECTIONS_PROP, null, conn);
		conn.setSource(null);
		removeGraph(conn);
	}

	private void removeGraph(VArrow conn) {
		conn.setGraph(null);
	}
		
	@Override
	public void setIDObject(IDObject idObject) {
		if (idObject instanceof Node) {
			// TODO: opprett lytter?
			nodeComponent = (Node)idObject;
			nodeID = nodeComponent.getId();		
		}
	}

	// -----------------------------------------------------------------------------------
	// Node methods:
	// -----------------------------------------------------------------------------------

	@Override
	public EClass eClass() {
		return nodeComponent.eClass();
	}

	@Override
	public Resource eResource() {
		return nodeComponent.eResource();
	}

	@Override
	public EObject eContainer() {
		return nodeComponent.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return nodeComponent.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return nodeComponent.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return nodeComponent.eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return nodeComponent.eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return nodeComponent.eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return nodeComponent.eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return nodeComponent.eGet(feature);
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return nodeComponent.eGet(feature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		nodeComponent.eSet(feature, newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return nodeComponent.eIsSet(feature);
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		nodeComponent.eUnset(feature);
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		return nodeComponent.eInvoke(operation, arguments);
	}

	@Override
	public EList<Adapter> eAdapters() {
		return nodeComponent.eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return nodeComponent.eDeliver();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		nodeComponent.eSetDeliver(deliver);
	}

	@Override
	public void eNotify(Notification notification) {
		nodeComponent.eNotify(notification);
	}

	@Override
	public String getName() {
		return nodeComponent.getName();
	}

	@Override
	public void setName(String value) {
		nodeComponent.setName(value);
	}

	@Override
	public Graph getGraph() {
		return nodeComponent.getGraph();
	}

	@Override
	public void setGraph(Graph value) {
		nodeComponent.setGraph(value);
	}

	@Override
	public EList<Arrow> getOutgoingArrows() {
		return nodeComponent.getOutgoingArrows();
	}

	@Override
	public String getId() {
		return nodeComponent.getId();
	}

	@Override
	public void setId(String value) {
	}

	@Override
	protected void createDpfGraphElement() {
		setIDObject(nodeComponent.getGraph().createNode("Unnamed node"));
	}

	@Override
	public Node getTypeNode() {
		return nodeComponent.getTypeNode();
	}

	@Override
	public void setTypeNode(Node value) {
		nodeComponent.setTypeNode(value);
	}

	@Override
	public boolean canReachTargetByOneArrow(Node target) {
		return nodeComponent.canReachTargetByOneArrow(target);
	}

	@Override
	public boolean arrowCanMakeConnectionAsTarget(Node intendedTarget) {
		return nodeComponent.arrowCanMakeConnectionAsTarget(intendedTarget);
	}

	@Override
	public Boolean arrowCanMakeConnectionAsTarget(Node intendedTarget,
			Arrow typeArrow) {
		return nodeComponent.arrowCanMakeConnectionAsTarget(intendedTarget, typeArrow);
	}

	@Override
	public Boolean canReachTargetByTypeArrow(Node target, Arrow typeArrpw) {
		return nodeComponent.canReachTargetByTypeArrow(target, typeArrpw);
	}

	@Override
	public Arrow getArrowto(Node target) {
		return nodeComponent.getArrowto(target);
	}

	@Override
	public String getTypeName() {
		return nodeComponent.getTypeName();
	}



}
