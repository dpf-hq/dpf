package no.hib.dpf.editor.model;

import java.io.Serializable;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class LocationAndSize implements Serializable {
	private static IPropertyDescriptor[] descriptors;

	private static final long serialVersionUID = -1181005252896429955L;

	private Point location = new Point(0, 0);
	private Dimension size = new Dimension(50, 50);
	
	public static final String LOCATION_PROP = "Shape.Location";
	public static final String SIZE_PROP = "Shape.Size";
	
	public static final String XPOS_PROP = "Shape.xPos";
	public static final String YPOS_PROP = "Shape.yPos";

	public static final String HEIGHT_PROP = "Shape.Height";
	public static final String WIDTH_PROP = "Shape.Width";	
	
	private MovableAndSizable movableAndSizable;
	
	static {
		descriptors = new IPropertyDescriptor[] {
			new IntegerTextPropertyDescriptor(XPOS_PROP, "X"), // id and description pair
			new IntegerTextPropertyDescriptor(YPOS_PROP, "Y"),
			new IntegerTextPropertyDescriptor(WIDTH_PROP, "Width"),
			new IntegerTextPropertyDescriptor(HEIGHT_PROP, "Height")};
	} // static
	
	public LocationAndSize(MovableAndSizable movableAndSizable) {
		this.movableAndSizable = movableAndSizable;
	}

	public Object getPropertyValue(Object propertyId) {
		if (XPOS_PROP.equals(propertyId)) {
			return Integer.toString(getLocation().x);
		}
		if (YPOS_PROP.equals(propertyId)) {
			return Integer.toString(getLocation().y);
		}
		if (HEIGHT_PROP.equals(propertyId)) {
			return Integer.toString(getSize().height);
		}
		if (WIDTH_PROP.equals(propertyId)) {
			return Integer.toString(getSize().width);
		}
		return null;
	}
	
	public boolean setPropertyValue(Object propertyId, Object value) {
		if (XPOS_PROP.equals(propertyId)) {
			int x = Integer.parseInt((String) value);
			movableAndSizable.setLocation(new Point(x, getLocation().y));
			return true;
		} else if (YPOS_PROP.equals(propertyId)) {
			int y = Integer.parseInt((String) value);
			movableAndSizable.setLocation(new Point(getLocation().x, y));
			return true;
		} else if (HEIGHT_PROP.equals(propertyId)) {
			int height = Integer.parseInt((String) value);
			movableAndSizable.setSize(new Dimension(getSize().width, height));
			return true;
		} else if (WIDTH_PROP.equals(propertyId)) {
			int width = Integer.parseInt((String) value);
			movableAndSizable.setSize(new Dimension(width, getSize().height));
			return true;
		}
		return false;
	}
	
	public IPropertyDescriptor[] getPropertyDescriptors(IPropertyDescriptor[] baseDescriptors) {
		IPropertyDescriptor[] retval = new IPropertyDescriptor[baseDescriptors.length + descriptors.length];
		System.arraycopy(baseDescriptors, 0, retval, 0, baseDescriptors.length);
		System.arraycopy(descriptors, 0, retval, baseDescriptors.length, descriptors.length);		
		return retval;
	}

	public void setLocation(Point location) {
		if (location == null) {
			throw new IllegalArgumentException();
		}
		this.location = location;
	}
	
	public Point getLocation() {
		return location.getCopy();
	}
	
	public void setSize(Dimension size) {
		if (size != null) {
			this.size = size;
		}
	}
	
	public Dimension getSize() {
		return size.getCopy();
	}

}
