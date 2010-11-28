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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.metamodel.Graph;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * Abstract prototype of a shape. Has a size (width and height), a location (x
 * and y position) and a list of incoming and outgoing connections. Use
 * subclasses to instantiate a specific shape.
 * 
 * @see no.hib.dpf.editor.model.RectangularShape
 * @see no.hib.dpf.editor.model.EllipticalShape
 * @author Elias Volanakis
 */
public abstract class Shape extends ModelElement implements IDObjectContainer, MovableAndSizable {

	private static final long serialVersionUID = 7208811341274639248L;

	private static IPropertyDescriptor[] descriptors;

	/** Property ID to use when the list of outgoing connections is modified. */
	public static final String SOURCE_CONNECTIONS_PROP = "Shape.SourceConn";
	/** Property ID to use when the list of incoming connections is modified. */
	public static final String TARGET_CONNECTIONS_PROP = "Shape.TargetConn";
	
	public static final String NEW_LOCATION_PROP = "Shape.NewLocation";
	
	/** Property ID to use when the name is modified. */	
	public static final String NAME_PROP = "Shape.Name";

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
			new TextPropertyDescriptor(NAME_PROP, "Name") };
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
	private List<Connection> sourceConnections = new ArrayList<Connection>();
	/** List of incoming Connections. */
	private List<Connection> targetConnections = new ArrayList<Connection>();

	public void addIncomingConnection(Connection conn) {
		targetConnections.add(conn);
		firePropertyChange(TARGET_CONNECTIONS_PROP, null, conn);
	}

	public void addOutgoingConnection(Connection conn) {
		sourceConnections.add(conn);
		firePropertyChange(SOURCE_CONNECTIONS_PROP, null, conn);
	}

	/**
	 * Return a pictogram (small icon) describing this model element. Children
	 * should override this method and return an appropriate Image.
	 * 
	 * @return a 16x16 Image or null
	 */
	public abstract Image getIcon();

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
	public List<Connection> getSourceConnections() {
		return new ArrayList<Connection>(sourceConnections);
	}

	/**
	 * Return a List of incoming Connections.
	 */
	public List<Connection> getTargetConnections() {
		return new ArrayList<Connection>(targetConnections);
	}

	/**
	 * Remove an incoming or outgoing connection from this shape.
	 * 
	 * @param conn
	 *            a non-null connection instance
	 * @throws IllegalArgumentException
	 *             if the parameter is null
	 */
	public void removeConnection(Connection conn) {
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

	protected void removeIncomingConnection(Connection conn) {
		targetConnections.remove(conn);
		firePropertyChange(TARGET_CONNECTIONS_PROP, null, conn);
	}

	protected void removeOutgoingConnection(Connection conn) {
		sourceConnections.remove(conn);
		firePropertyChange(SOURCE_CONNECTIONS_PROP, null, conn);
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

	/**
	 * Sets the name of this shape.
	 */
	public abstract void setNameExec(String name);
	
	public abstract String getNameExec();

	public abstract void setGraphExec(Graph graph);

	public abstract void removeGraphExec();
	
}