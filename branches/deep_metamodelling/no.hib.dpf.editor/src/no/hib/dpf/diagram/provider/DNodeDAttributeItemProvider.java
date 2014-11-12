/**
 */
package no.hib.dpf.diagram.provider;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.provider.NodeAttributeItemProvider;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
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
 * This is the item provider adapter for a {@link no.hib.dpf.diagram.DNodeDAttribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DNodeDAttributeItemProvider
	extends DElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	
	NodeAttributeItemProvider nodeAttributeItemProvider = null;
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public DNodeDAttributeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		nodeAttributeItemProvider = new NodeAttributeItemProvider(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		 
			addNodeAttributePropertyDescriptor(object);
			addConfigureStringPropertyDescriptor(object);
			addDConstraintsPropertyDescriptor(object);
			
			if(object instanceof DNodeDAttribute){
				itemPropertyDescriptors.addAll(nodeAttributeItemProvider.getPropertyDescriptors(((DNodeDAttribute)object).getNodeAttribute()));
			}
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the DType feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	protected void addDTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNodeDAttribute_dType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNodeDAttribute_dType_feature", "_UI_DNodeDAttribute_type"),
				 DiagramPackage.Literals.DNODE_DATTRIBUTE__DTYPE,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DNODE_DATTRIBUTE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DConstraints feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	protected void addDConstraintsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNodeDAttribute_dConstraints_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNodeDAttribute_dConstraints_feature", "_UI_DNodeDAttribute_type"),
				 DiagramPackage.Literals.DNODE_DATTRIBUTE__DCONSTRAINTS,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DNODE_DATTRIBUTE_CATEGORY,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DiagramPackage.Literals.DNODE_DATTRIBUTE__NAME_OFFSET);
			childrenFeatures.add(DiagramPackage.Literals.DNODE_DATTRIBUTE__BENDPOINTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This adds a property descriptor for the Configure String feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	protected void addConfigureStringPropertyDescriptor(Object object) {
		ItemPropertyDescriptor current = new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DNodeDAttribute_configureString_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DNodeDAttribute_configureString_feature", "_UI_DNodeDAttribute_type"),
				DiagramPackage.Literals.DNODE_DATTRIBUTE__CONFIGURE_STRING,
				true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null) {
			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				return Arrays.asList(FigureConfigureManager.INSTANCE
						.getArrowNames());
			}
		};
		itemPropertyDescriptors.add(current);
	}

	/**
	 * This adds a property descriptor for the Line Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLineStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNodeDAttribute_lineStyle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNodeDAttribute_lineStyle_feature", "_UI_DNodeDAttribute_type"),
				 DiagramPackage.Literals.DNODE_DATTRIBUTE__LINE_STYLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the DTarget feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNodeDAttribute_dTarget_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNodeDAttribute_dTarget_feature", "_UI_DNodeDAttribute_type"),
				 DiagramPackage.Literals.DNODE_DATTRIBUTE__DTARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the DSource feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNodeDAttribute_dSource_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNodeDAttribute_dSource_feature", "_UI_DNodeDAttribute_type"),
				 DiagramPackage.Literals.DNODE_DATTRIBUTE__DSOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Node Attribute feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNodeAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNodeDAttribute_nodeAttribute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNodeDAttribute_nodeAttribute_feature", "_UI_DNodeDAttribute_type"),
				 DiagramPackage.Literals.DNODE_DATTRIBUTE__NODE_ATTRIBUTE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns DNodeDAttribute.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DNodeDAttribute"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((DNodeDAttribute)object).getName();
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

		switch (notification.getFeatureID(DNodeDAttribute.class)) {
			case DiagramPackage.DNODE_DATTRIBUTE__CONFIGURE_STRING:
			case DiagramPackage.DNODE_DATTRIBUTE__LINE_STYLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__NAME_OFFSET:
			case DiagramPackage.DNODE_DATTRIBUTE__BENDPOINTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DNODE_DATTRIBUTE__NAME_OFFSET,
				 DiagramFactory.eINSTANCE.createDOffset()));

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DNODE_DATTRIBUTE__BENDPOINTS,
				 DiagramFactory.eINSTANCE.createDOffset()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == DiagramPackage.Literals.DNODE_DATTRIBUTE__NAME_OFFSET ||
			childFeature == DiagramPackage.Literals.DNODE_DATTRIBUTE__BENDPOINTS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
