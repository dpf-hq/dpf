package no.hib.dpf.editor;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

class UnwrappingPropertySource implements IPropertySource {
    private IPropertySource source;

    public UnwrappingPropertySource(final IPropertySource source) {
        this.source = source;
    }

    @Override
    public Object getEditableValue() {
        Object value = source.getEditableValue();
        return value instanceof PropertyValueWrapper ? ((PropertyValueWrapper) value).getEditableValue(null) : source.getEditableValue();
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
        return source.getPropertyDescriptors();
    }

    @Override
    public Object getPropertyValue(Object id) {
        Object value = source.getPropertyValue(id);
        if(value == null)
        	return null;
        return value instanceof PropertyValueWrapper ? ((PropertyValueWrapper) value).getEditableValue(null) : value;//source.getEditableValue();
    }

    @Override
    public boolean isPropertySet(Object id) {
        return source.isPropertySet(id);
    }

    @Override
    public void resetPropertyValue(Object id) {
        source.resetPropertyValue(id);
    }

    @Override
    public void setPropertyValue(Object id, Object value) {
        source.setPropertyValue(id, value);
    }
}