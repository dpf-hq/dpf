/**
 */
package no.hib.dpf.core.provider;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.diagram.provider.ExtendItemPropertyDescriptor;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.utils.DPFCoreConstants;

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
 * This is the item provider adapter for a {@link no.hib.dpf.core.DataNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DataNodeItemProvider
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
	public DataNodeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	protected ItemPropertyDescriptor createItemPropertyDescriptor(
			AdapterFactory adapterFactory, ResourceLocator resourceLocator,
			String displayName, String description, EStructuralFeature feature,
			boolean isSettable, boolean multiLine, boolean sortChoices,
			Object staticImage, String category, String[] filterFlags) {

		category = DPFCoreConstants.DATANODE_CATEGORY;
		return new ExtendItemPropertyDescriptor(adapterFactory,
				resourceLocator, displayName, description, feature, isSettable,
				multiLine, sortChoices, staticImage, category, filterFlags);
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

			addMutabilityPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addValuePropertyDescriptor(object);
			addIncomingNodeAttributesPropertyDescriptor(object);
			addIncomingArrowAtributesPropertyDescriptor(object);
			addTypeDataNodePropertyDescriptor(object);
			addDatatypePropertyDescriptor(object);
			addIsDataTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Mutability feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMutabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_MutableElement_mutability_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_MutableElement_mutability_feature", "_UI_MutableElement_type"),
				 CorePackage.Literals.MUTABLE_ELEMENT__MUTABILITY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_IDObject_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IDObject_id_feature", "_UI_IDObject_type"),
				 CorePackage.Literals.ID_OBJECT__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataNode_value_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataNode_value_feature", "_UI_DataNode_type"),
				 CorePackage.Literals.DATA_NODE__VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Incoming Node Attributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncomingNodeAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataNode_incomingNodeAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataNode_incomingNodeAttributes_feature", "_UI_DataNode_type"),
				 CorePackage.Literals.DATA_NODE__INCOMING_NODE_ATTRIBUTES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Incoming Arrow Atributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncomingArrowAtributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataNode_incomingArrowAtributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataNode_incomingArrowAtributes_feature", "_UI_DataNode_type"),
				 CorePackage.Literals.DATA_NODE__INCOMING_ARROW_ATRIBUTES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type Data Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypeDataNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataNode_typeDataNode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataNode_typeDataNode_feature", "_UI_DataNode_type"),
				 CorePackage.Literals.DATA_NODE__TYPE_DATA_NODE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Datatype feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	protected void addDatatypePropertyDescriptor(Object object) {
		ItemPropertyDescriptor current = new ExtendItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
						 getResourceLocator(),
						 getString("_UI_DataNode_datatype_feature"),
						 getString("_UI_PropertyDescriptor_description", "_UI_DataNode_datatype_feature", "_UI_DataNode_type"),
						 CorePackage.Literals.DATA_NODE__DATATYPE,
						 true,
						 false,
						 false,
						 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
						 DPFCoreConstants.DATANODE_CATEGORY,
						 null){
			@Override
			public Collection<?> getChoiceOfValues(Object object){
				return DPFCoreConstants.getEDataTypesMap().keySet();
			}
		};
		
		itemPropertyDescriptors.add(current);
	}

	/**
	 * This adds a property descriptor for the Is Data Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsDataTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DataNode_isDataType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DataNode_isDataType_feature", "_UI_DataNode_type"),
				 CorePackage.Literals.DATA_NODE__IS_DATA_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns DataNode.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DataNode"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((DataNode)object).getValue();
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

		switch (notification.getFeatureID(DataNode.class)) {
			case CorePackage.DATA_NODE__MUTABILITY:
			case CorePackage.DATA_NODE__ID:
			case CorePackage.DATA_NODE__VALUE:
			case CorePackage.DATA_NODE__DATATYPE:
			case CorePackage.DATA_NODE__IS_DATA_TYPE:
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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return MetamodelEditPlugin.INSTANCE;
	}
}
