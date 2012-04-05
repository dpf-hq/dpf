/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.provider;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.provider.ArrowItemProvider;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.utils.DPFConstants;

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
 * This is the item provider adapter for a {@link no.hib.dpf.diagram.DArrow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DArrowItemProvider
	extends DElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	
	ArrowItemProvider arrowItemProvider = null;
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DArrowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		arrowItemProvider = new ArrowItemProvider(adapterFactory);
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

//			addDTypePropertyDescriptor(object);
			addConfigureStringPropertyDescriptor(object);
			addLineStylePropertyDescriptor(object);
//			addDSourcePropertyDescriptor(object);
//			addDTargetPropertyDescriptor(object);
//			addDConstraintsPropertyDescriptor(object);
			addBendpointsPropertyDescriptor(object);
			addNameOffsetPropertyDescriptor(object);
//			addConstraintsFromPropertyDescriptor(object);
//			addConstraintsToPropertyDescriptor(object);
			if(object instanceof DArrow)
				itemPropertyDescriptors.addAll(arrowItemProvider.getPropertyDescriptors(((DArrow)object).getArrow()));
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_DArrow_dType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrow_dType_feature", "_UI_DArrow_type"),
				 DiagramPackage.Literals.DARROW__DTYPE,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DARROW_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Arrow feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addArrowPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrow_arrow_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrow_arrow_feature", "_UI_DArrow_type"),
				 DiagramPackage.Literals.DARROW__ARROW,
				 true,
				 false,
				 true,
				 null,
				 DPFConstants.DARROW_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Configure String feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addConfigureStringPropertyDescriptor(Object object) {
		ItemPropertyDescriptor current = new ItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_DArrow_configureString_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DArrow_configureString_feature", "_UI_DArrow_type"),
				DiagramPackage.Literals.DARROW__CONFIGURE_STRING,
				true,
				false,
				false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				DPFConstants.DARROW_CATEGORY,
				null){
			public Collection<?> getChoiceOfValues(Object object)
			{
				return Arrays.asList(FigureConfigureManager.INSTANCE.getArrowNames());
			}
		};
		itemPropertyDescriptors.add(current);
	}

	/**
	 * This adds a property descriptor for the Line Style feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addLineStylePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrow_lineStyle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrow_lineStyle_feature", "_UI_DArrow_type"),
				 DiagramPackage.Literals.DARROW__LINE_STYLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 DPFConstants.DARROW_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DSource feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrow_dSource_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrow_dSource_feature", "_UI_DArrow_type"),
				 DiagramPackage.Literals.DARROW__DSOURCE,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DARROW_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DTarget feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrow_dTarget_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrow_dTarget_feature", "_UI_DArrow_type"),
				 DiagramPackage.Literals.DARROW__DTARGET,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DARROW_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DConstraints feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDConstraintsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrow_dConstraints_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrow_dConstraints_feature", "_UI_DArrow_type"),
				 DiagramPackage.Literals.DARROW__DCONSTRAINTS,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DARROW_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bendpoints feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addBendpointsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrow_bendpoints_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrow_bendpoints_feature", "_UI_DArrow_type"),
				 DiagramPackage.Literals.DARROW__BENDPOINTS,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 DPFConstants.DARROW_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name Offset feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addNameOffsetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DArrow_nameOffset_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DArrow_nameOffset_feature", "_UI_DArrow_type"),
				 DiagramPackage.Literals.DARROW__NAME_OFFSET,
				 false,
				 false,
				 false,
				 null,
				 DPFConstants.DARROW_CATEGORY,
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
			childrenFeatures.add(DiagramPackage.Literals.DARROW__NAME_OFFSET);
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
	 * This returns DArrow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DArrow"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((DArrow)object).getName();
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

		switch (notification.getFeatureID(DArrow.class)) {
			case DiagramPackage.DARROW__CONFIGURE_STRING:
			case DiagramPackage.DARROW__LINE_STYLE:
			case DiagramPackage.DARROW__BENDPOINTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DiagramPackage.DARROW__NAME_OFFSET:
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
				(DiagramPackage.Literals.DARROW__NAME_OFFSET,
				 DiagramFactory.eINSTANCE.createDOffset()));
	}

}
