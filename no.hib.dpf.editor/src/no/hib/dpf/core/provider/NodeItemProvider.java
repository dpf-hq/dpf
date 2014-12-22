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
import no.hib.dpf.core.Node;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.utils.DPFConstants;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link no.hib.dpf.core.Node} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NodeItemProvider
	extends IDObjectItemProvider {
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
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

			addNamePropertyDescriptor(object);
			addTypeNodePropertyDescriptor(object);
			addOutgoingsPropertyDescriptor(object);
			addIncomingsPropertyDescriptor(object);
			addConstraintsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 "Node Name",//getString("_UI_Node_name_feature"),
				 "Node Name2",//getString("_UI_PropertyDescriptor_description", "_UI_Node_name_feature", "_UI_Node_type"),
				 CorePackage.Literals.NODE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 DPFConstants.NODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTypeNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 "Type node",//getString("_UI_Node_typeNode_feature"),
				 "type node",//getString("_UI_PropertyDescriptor_description", "_UI_Node_typeNode_feature", "_UI_Node_type"),
				 CorePackage.Literals.NODE__TYPE_NODE,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.NODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Outgoings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addOutgoingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 "_UI_Node_outgoings_feature",//getString("_UI_Node_outgoings_feature"),
				 "_UI_Node_outgoings_feature2", //getString("_UI_PropertyDescriptor_description", "_UI_Node_outgoings_feature", "_UI_Node_type"),
				 CorePackage.Literals.NODE__OUTGOINGS,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.NODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Incomings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addIncomingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 "_UI_Node_incomings_feature", //getString("_UI_Node_incomings_feature"),
				 "_UI_Node_incomings_feature2",// getString("_UI_PropertyDescriptor_description", "_UI_Node_incomings_feature", "_UI_Node_type"),
				 CorePackage.Literals.NODE__INCOMINGS,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.NODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Constraints feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addConstraintsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 "_UI_Node_constraints_feature",//getString("_UI_Node_constraints_feature"),
				 "_UI_Node_constraints_feature2",//getString("_UI_PropertyDescriptor_description", "_UI_Node_constraints_feature", "_UI_Node_type"),
				 CorePackage.Literals.NODE__CONSTRAINTS,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.NODE_CATEGORY,
				 null));
	}

	/**
	 * This returns Node.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		//return overlayImage(object, getResourceLocator().getImage("full/obj16/Node"));
		return overlayImage(object, DPFPlugin.INSTANCE.getImageRegistry().get("full/obj16/Node"));
		
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((Node)object).getName();
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

		switch (notification.getFeatureID(Node.class)) {
			case CorePackage.NODE__NAME:
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
}
