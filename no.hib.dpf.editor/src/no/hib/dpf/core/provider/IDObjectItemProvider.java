/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.provider;


import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.diagram.provider.ExtendItemPropertyDescriptor;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.utils.DPFConstants;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link no.hib.dpf.core.IDObject} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IDObjectItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDObjectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	protected ItemPropertyDescriptor createItemPropertyDescriptor(
		    AdapterFactory adapterFactory,
		    ResourceLocator resourceLocator,
		    String displayName,
		    String description,
		    EStructuralFeature feature,
		    boolean isSettable,
		    boolean multiLine,
		    boolean sortChoices,
		    Object staticImage,
		    String category,
		    String[] filterFlags)
		  {
		if(this instanceof ArrowItemProvider)
			category = DPFConstants.ARROW_CATEGORY;
		else if(this instanceof NodeItemProvider)
			category = DPFConstants.NODE_CATEGORY;
		else if(this instanceof ConstraintItemProvider)
			category = ConstraintItemProvider.Constraint_CATEGORY;
		    return new ExtendItemPropertyDescriptor(
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
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIdPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 "IDObject Feature",//getString("_UI_IDObject_id_feature"),
				 "IDObject Feature2",//getString("_UI_PropertyDescriptor_description", "_UI_IDObject_id_feature", "_UI_IDObject_type"),
				 CorePackage.Literals.ID_OBJECT__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IDObject)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_IDObject_type") :
			getString("_UI_IDObject_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(IDObject.class)) {
			case CorePackage.ID_OBJECT__ID:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

//	/**
//	 * Return the resource locator for this item provider's resources.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public ResourceLocator getResourceLocator() {
//		return DPFPlugin.INSTANCE;
//	}

}
