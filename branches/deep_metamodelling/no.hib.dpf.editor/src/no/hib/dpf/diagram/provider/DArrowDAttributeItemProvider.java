/**
 */
package no.hib.dpf.diagram.provider;

import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.provider.ArrowAttributeItemProvider;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.DiagramPackage;
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
 * This is the item provider adapter for a {@link no.hib.dpf.diagram.DArrowDAttribute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DArrowDAttributeItemProvider extends DElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	
	ArrowAttributeItemProvider arrowattributeItemProvider = null;
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	public DArrowDAttributeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		arrowattributeItemProvider = new ArrowAttributeItemProvider(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addLinestylePropertyDescriptor(object);
			addDConstraintsPropertyDescriptor(object);
			if(object instanceof DArrowDAttribute){
				itemPropertyDescriptors.addAll(arrowattributeItemProvider.getPropertyDescriptors(((DArrowDAttribute)object).getArrowAttribute()));
			}
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the DSource feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	protected void addDSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrowDAttribute_dSource_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrowDAttribute_dSource_feature", "_UI_DArrowDAttribute_type"),
				 DiagramPackage.Literals.DARROW_DATTRIBUTE__DSOURCE,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DARROW_DATTRIBUTE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Arrow Attribute feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	protected void addArrowAttributePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrowDAttribute_arrowAttribute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrowDAttribute_arrowAttribute_feature", "_UI_DArrowDAttribute_type"),
				 DiagramPackage.Literals.DARROW_DATTRIBUTE__ARROW_ATTRIBUTE,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DARROW_DATTRIBUTE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DType feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	protected void addDTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrowDAttribute_dType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrowDAttribute_dType_feature", "_UI_DArrowDAttribute_type"),
				 DiagramPackage.Literals.DARROW_DATTRIBUTE__DTYPE,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DARROW_DATTRIBUTE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DTarget feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	protected void addDTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrowDAttribute_dTarget_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrowDAttribute_dTarget_feature", "_UI_DArrowDAttribute_type"),
				 DiagramPackage.Literals.DARROW_DATTRIBUTE__DTARGET,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DARROW_DATTRIBUTE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Configure String feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConfigureStringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrowDAttribute_configureString_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrowDAttribute_configureString_feature", "_UI_DArrowDAttribute_type"),
				 DiagramPackage.Literals.DARROW_DATTRIBUTE__CONFIGURE_STRING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Linestyle feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	protected void addLinestylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrowDAttribute_linestyle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrowDAttribute_linestyle_feature", "_UI_DArrowDAttribute_type"),
				 DiagramPackage.Literals.DARROW_DATTRIBUTE__LINESTYLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 DPFCoreConstants.DARROW_DATTRIBUTE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DConstraints feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	protected void addDConstraintsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrowDAttribute_dConstraints_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrowDAttribute_dConstraints_feature", "_UI_DArrowDAttribute_type"),
				 DiagramPackage.Literals.DARROW_DATTRIBUTE__DCONSTRAINTS,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DARROW_DATTRIBUTE_CATEGORY,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DiagramPackage.Literals.DARROW_DATTRIBUTE__NAME_OFFSET);
			childrenFeatures.add(DiagramPackage.Literals.DARROW_DATTRIBUTE__BENDPOINTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DArrowDAttribute.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DArrowDAttribute"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((DArrowDAttribute)object).getName();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DArrowDAttribute.class)) {
			case DiagramPackage.DARROW_DATTRIBUTE__CONFIGURE_STRING:
			case DiagramPackage.DARROW_DATTRIBUTE__LINESTYLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DiagramPackage.DARROW_DATTRIBUTE__NAME_OFFSET:
			case DiagramPackage.DARROW_DATTRIBUTE__BENDPOINTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DARROW_DATTRIBUTE__NAME_OFFSET,
				 DiagramFactory.eINSTANCE.createDOffset()));

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DARROW_DATTRIBUTE__BENDPOINTS,
				 DiagramFactory.eINSTANCE.createDOffset()));
	}

	/**
	 * This returns the label text for
	 * {@link org.eclipse.emf.edit.command.CreateChildCommand}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == DiagramPackage.Literals.DARROW_DATTRIBUTE__NAME_OFFSET ||
			childFeature == DiagramPackage.Literals.DARROW_DATTRIBUTE__BENDPOINTS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
