package no.hib.dpf.diagram.provider;

import java.util.Collection;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.utils.DPFConstants;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

public class ExtendItemPropertyDescriptor extends ItemPropertyDescriptor {

	public ExtendItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EReference[] parentReferences) {
		super(adapterFactory, resourceLocator, displayName, description, parentReferences);
	}

	  public ExtendItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable,
			boolean multiLine, boolean sortChoices, Object staticImage,
			String category, String[] filterFlags) {
		  super(
	      adapterFactory,
	      resourceLocator,
	      displayName,
	      description,
	      feature,
	      isSettable,
	      multiLine,
	      sortChoices,
	      staticImage,
	      category,
	      filterFlags);
	}

	/**
	   * This will be called to populate a list of choices.
	   * The label provider will be used to determine the labels for the objects this returns.
	   * This default implementation uses {@link #getReachableObjectsOfType getReachableObjectsOfType}.
	   */
	  protected Collection<?> getComboBoxObjects(Object object)
	  {
		  return super.getComboBoxObjects(isModelElement() ? getModelElement(object) : object);
	  }

	 
	  protected Object createPropertyValueWrapper(Object object, Object propertyValue)
	  {
	    return new PropertyValueWrapper(adapterFactory, isModelElement() ? getModelElement(object) : object, propertyValue, null);
	  }

	  /**
	   * This does the delegated job of getting the property value from the given object; 
	   * and it sets object, which is necessary if {@link #getComboBoxObjects getComboBoxObjects} is called.
	   * It is implemented in a generic way using the structural feature or parent references.
	   */
	  public Object getPropertyValue(Object object)
	  {
		  return super.getPropertyValue(isModelElement() ? getModelElement(object) : object);
	  }

	  /**
	   * This does the delegated job of determine whether the property value from the given object is set.
	   * It is implemented in a generic way using the structural feature.
	   */
	  public boolean isPropertySet(Object object)
	  {
		  return super.isPropertySet(isModelElement() ? getModelElement(object) : object);
	  }

	  /**
	   * This determines whether this descriptor's property for the object supports set (and reset).
	   */
	  public boolean canSetProperty(Object object)
	  {
		  return super.canSetProperty(isModelElement() ? getModelElement(object) : object);
	  }



	  /**
	   * This does the delegated job of resetting property value back to it's default value.
	   */
	  public void resetPropertyValue(Object object)
	  {
		  super.resetPropertyValue(isModelElement() ? getModelElement(object) : object);
	  }

	  public EditingDomain getEditingDomain(Object object)
	  {
		  return super.getEditingDomain(isModelElement() ? getModelElement(object) : object);
	  }

	  private boolean isModelElement(){
		  if(category == null)
			  return true;
		  if(this.category.equals(DPFConstants.DNODE_CATEGORY) || category.equals(DPFConstants.DARROW_CATEGORY) || category.equals(DConstraintItemProvider.DConstraint_CATEGORY))
			  return false;
		  return true;
	  }
	  
	  private Object getModelElement(Object object){
		  if(object instanceof DNode)
			  return ((DNode)object).getNode();
		  if(object instanceof DArrow)
			  return ((DArrow)object).getArrow();
		  if(object instanceof DConstraint)
			  return ((DConstraint)object).getConstraint();
		  return object;
	  }
	  /**
	   * This does the delegated job of setting the property to the given value.
	   * It is implemented in a generic way using the structural feature.
	   */
	  public void setPropertyValue(Object object, Object value)
	  {
		  super.setPropertyValue(isModelElement() ? getModelElement(object) : object, value);
	  }
}
