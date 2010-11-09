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
public abstract class Shape extends ModelElement implements IDObjectContainer {

	private static final long serialVersionUID = 7208811341274639248L;

	private static IPropertyDescriptor[] descriptors;

	private static final String HEIGHT_PROP = "Shape.Height";
	/** Property ID to use when the location of this shape is modified. */
	public static final String LOCATION_PROP = "Shape.Location";
	/** Property ID to use then the size of this shape is modified. */
	public static final String SIZE_PROP = "Shape.Size";
	/** Property ID to use when the list of outgoing connections is modified. */
	public static final String SOURCE_CONNECTIONS_PROP = "Shape.SourceConn";
	/** Property ID to use when the list of incoming connections is modified. */
	public static final String TARGET_CONNECTIONS_PROP = "Shape.TargetConn";
	
	public static final String NEW_LOCATION_PROP = "Shape.NewLocation";
	
	/** Property ID to use when the name is modified. */	
	public static final String NAME_PROP = "Shape.Name";

	private static final String WIDTH_PROP = "Shape.Width";

	/**
	 * ID for the X property value (used for by the corresponding property
	 * descriptor).
	 */
	private static final String XPOS_PROP = "Shape.xPos";
	/**
	 * ID for the Y property value (used for by the corresponding property
	 * descriptor).
	 */
	private static final String YPOS_PROP = "Shape.yPos";

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
			new IntegerTextPropertyDescriptor(XPOS_PROP, "X"), // id and description pair
			new IntegerTextPropertyDescriptor(YPOS_PROP, "Y"),
			new IntegerTextPropertyDescriptor(WIDTH_PROP, "Width"),
			new IntegerTextPropertyDescriptor(HEIGHT_PROP, "Height"),
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

	/** Location of this shape. */
	private Point location = new Point(0, 0);
	/** Size of this shape. */
	private Dimension size = new Dimension(50, 50);
	/** List of outgoing Connections. */
	private List<Connection> sourceConnections = new ArrayList<Connection>();
	/** List of incoming Connections. */
	private List<Connection> targetConnections = new ArrayList<Connection>();

	/**
	 * Add an incoming or outgoing connection to this shape.
	 * 
	 * @param conn
	 *            a non-null connection instance
	 * @throws IllegalArgumentException
	 *             if the connection is null or has not distinct endpoints
	 */
	public void addConnection(Connection conn) {
		if (conn == null || conn.getShapeSource() == conn.getShapeTarget()) {
			throw new IllegalArgumentException();
		}
		if (conn.getShapeSource() == this) {
			addOutgoingConnection(conn);
		} else if (conn.getShapeTarget() == this) {
			addIncomingConnection(conn);
		}
	}

	protected void addIncomingConnection(Connection conn) {
		targetConnections.add(conn);
		firePropertyChange(TARGET_CONNECTIONS_PROP, null, conn);
	}

	protected void addOutgoingConnection(Connection conn) {
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
	 * Return the Location of this shape.
	 * 
	 * @return a non-null location instance
	 */
	public Point getLocation() {
		return location.getCopy();
	}

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
		return descriptors;
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
		if (XPOS_PROP.equals(propertyId)) {
			return Integer.toString(location.x);
		}
		if (YPOS_PROP.equals(propertyId)) {
			return Integer.toString(location.y);
		}
		if (HEIGHT_PROP.equals(propertyId)) {
			return Integer.toString(size.height);
		}
		if (WIDTH_PROP.equals(propertyId)) {
			return Integer.toString(size.width);
		}
		if (NAME_PROP.equals(propertyId)) {
			return getNameExec();
		}
		return super.getPropertyValue(propertyId);
	}

	/**
	 * Return the Size of this shape.
	 * 
	 * @return a non-null Dimension instance
	 */
	public Dimension getSize() {
		return size.getCopy();
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
	void removeConnection(Connection conn) {
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		if (conn.getShapeSource() == this) {
			removeOutgoingConnection(conn);
		} else if (conn.getShapeTarget() == this) {
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
	 * Set the Location of this shape.
	 * 
	 * @param newLocation
	 *            a non-null Point instance
	 * @throws IllegalArgumentException
	 *             if the parameter is null
	 */
	public void setLocation(Point newLocation) {
		if (newLocation == null) {
			throw new IllegalArgumentException();
		}
		location.setLocation(newLocation);
		firePropertyChange(LOCATION_PROP, null, location);
//		firePropertyChange(NEW_LOCATION_PROP, null, location);
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
		if (XPOS_PROP.equals(propertyId)) {
			int x = Integer.parseInt((String) value);
			setLocation(new Point(x, location.y));
		} else if (YPOS_PROP.equals(propertyId)) {
			int y = Integer.parseInt((String) value);
			setLocation(new Point(location.x, y));
		} else if (HEIGHT_PROP.equals(propertyId)) {
			int height = Integer.parseInt((String) value);
			setSize(new Dimension(size.width, height));
		} else if (WIDTH_PROP.equals(propertyId)) {
			int width = Integer.parseInt((String) value);
			setSize(new Dimension(width, size.height));
		} else if (NAME_PROP.equals(propertyId)) {
			setNameExec((String)value);
		} else {
			super.setPropertyValue(propertyId, value);
		}
	}

	/**
	 * Set the Size of this shape. Will not modify the size if newSize is null.
	 * 
	 * @param newSize
	 *            a non-null Dimension instance or null
	 */
	public void setSize(Dimension newSize) {
		if (newSize != null) {
			size.setSize(newSize);
			firePropertyChange(SIZE_PROP, null, size);
		}
	}
	
	/**
	 * Sets the name of this shape.
	 */
	public abstract void setNameExec(String name);
	
	public abstract String getNameExec();

	public abstract void setGraphExec(Graph graph);

	public abstract void removeGraphExec();
	
}