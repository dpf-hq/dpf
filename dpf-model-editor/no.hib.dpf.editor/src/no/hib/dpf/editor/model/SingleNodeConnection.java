package no.hib.dpf.editor.model;

import no.hib.dpf.metamodel.Arrow;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class SingleNodeConnection extends VArrow implements MovableAndSizable {

	private static final long serialVersionUID = 764028909094201787L;

	private LocationAndSize locationAndSize;
		
	public SingleNodeConnection(VNode source, Arrow typeArrow) {
		super(source, source, typeArrow);
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		IPropertyDescriptor[] retval = super.getPropertyDescriptors();
		return getLocationAndSize().getPropertyDescriptors(retval);
	}
	
	public Object getPropertyValue(Object propertyId) {
		Object valueFromLocation = getLocationAndSize().getPropertyValue(propertyId);
		if (valueFromLocation != null) {
			return valueFromLocation;
		}
		return super.getPropertyValue(propertyId);
	}
	
	@Override
	public Point getLocation() {
		return getLocationAndSize().getLocation();
	}

	@Override
	public Dimension getSize() {
		return getLocationAndSize().getSize();
	}
	
	private LocationAndSize getLocationAndSize() {
		if (locationAndSize == null) {
			locationAndSize = new LocationAndSize(this);
		}
		return locationAndSize;
	}

	@Override
	public void setLocation(Point newLocation) {
		getLocationAndSize().setLocation(newLocation);
		firePropertyChange(LocationAndSize.LOCATION_PROP, null, locationAndSize.getLocation());
	}

	@Override
	public void setSize(Dimension newSize) {
		getLocationAndSize().setSize(newSize);
		firePropertyChange(LocationAndSize.SIZE_PROP, null, locationAndSize.getSize());
	}

}
