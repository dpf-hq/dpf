/**
 */
package no.hib.dpf.diagram.provider;


import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.provider.DataNodeItemProvider;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link no.hib.dpf.diagram.DDataNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DDataNodeItemProvider
	extends DElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	DataNodeItemProvider datanodeItemProvider = null;
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DDataNodeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		datanodeItemProvider = new DataNodeItemProvider(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addConfigureStringPropertyDescriptor(object);
			if(object instanceof DDataNode){
				List<IItemPropertyDescriptor> desc = datanodeItemProvider.getPropertyDescriptors(((DDataNode)object).getDatanode());
				itemPropertyDescriptors.addAll(desc);
			}
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Datanode feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDatanodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DDataNode_datanode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DDataNode_datanode_feature", "_UI_DDataNode_type"),
				 DiagramPackage.Literals.DDATA_NODE__DATANODE,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DDATANODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Configure String feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addConfigureStringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DDataNode_configureString_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DDataNode_configureString_feature", "_UI_DDataNode_type"),
				 DiagramPackage.Literals.DDATA_NODE__CONFIGURE_STRING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 DPFCoreConstants.DDATANODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Location feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addLocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DDataNode_location_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DDataNode_location_feature", "_UI_DDataNode_type"),
				 DiagramPackage.Literals.DDATA_NODE__LOCATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 DPFCoreConstants.DDATANODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DDataNode_size_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DDataNode_size_feature", "_UI_DDataNode_type"),
				 DiagramPackage.Literals.DDATA_NODE__SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 DPFCoreConstants.DDATANODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DIncoming DNode DAttributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDIncomingDNodeDAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DDataNode_dIncomingDNodeDAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DDataNode_dIncomingDNodeDAttributes_feature", "_UI_DDataNode_type"),
				 DiagramPackage.Literals.DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DDATANODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DIncoming DArrow DAttributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDIncomingDArrowDAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DDataNode_dIncomingDArrowDAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DDataNode_dIncomingDArrowDAttributes_feature", "_UI_DDataNode_type"),
				 DiagramPackage.Literals.DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DDATANODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DType feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DDataNode_dType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DDataNode_dType_feature", "_UI_DDataNode_type"),
				 DiagramPackage.Literals.DDATA_NODE__DTYPE,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DDATANODE_CATEGORY,
				 null));
	}

	/**
	 * This returns DDataNode.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DDataNode"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((DDataNode)object).getDatanode().getValue();
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

		switch (notification.getFeatureID(DDataNode.class)) {
			case DiagramPackage.DDATA_NODE__CONFIGURE_STRING:
			case DiagramPackage.DDATA_NODE__LOCATION:
			case DiagramPackage.DDATA_NODE__SIZE:
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
