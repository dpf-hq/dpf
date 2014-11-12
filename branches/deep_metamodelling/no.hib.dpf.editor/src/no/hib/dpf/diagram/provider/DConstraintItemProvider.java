/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.provider;


import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.provider.ConstraintItemProvider;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * This is the item provider adapter for a {@link no.hib.dpf.diagram.DConstraint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DConstraintItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	public static final String DConstraint_CATEGORY = "DConstraint";
	ConstraintItemProvider constraintItemProvider = null;
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DConstraintItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		constraintItemProvider = new ConstraintItemProvider(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		super.getPropertyDescriptors(object);
		itemPropertyDescriptors.addAll(constraintItemProvider.getPropertyDescriptors(((DConstraint)object).getConstraint()));
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Constraint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addConstraintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DConstraint_constraint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DConstraint_constraint_feature", "_UI_DConstraint_type"),
				 DiagramPackage.Literals.DCONSTRAINT__CONSTRAINT,
				 true,
				 false,
				 true,
				 null,
				 DConstraint_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DNodes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDNodesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DConstraint_dNodes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DConstraint_dNodes_feature", "_UI_DConstraint_type"),
				 DiagramPackage.Literals.DCONSTRAINT__DNODES,
				 true,
				 false,
				 true,
				 null,
				 DConstraint_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DArrows feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDArrowsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DConstraint_dArrows_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DConstraint_dArrows_feature", "_UI_DConstraint_type"),
				 DiagramPackage.Literals.DCONSTRAINT__DARROWS,
				 true,
				 false,
				 true,
				 null,
				 DConstraint_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DPredicate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDPredicatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DConstraint_dPredicate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DConstraint_dPredicate_feature", "_UI_DConstraint_type"),
				 DiagramPackage.Literals.DCONSTRAINT__DPREDICATE,
				 true,
				 false,
				 true,
				 null,
				 DConstraint_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DNode DAttributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDNodeDAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DConstraint_dNodeDAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DConstraint_dNodeDAttributes_feature", "_UI_DConstraint_type"),
				 DiagramPackage.Literals.DCONSTRAINT__DNODE_DATTRIBUTES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the DArrow DAttributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDArrowDAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DConstraint_DArrowDAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DConstraint_DArrowDAttributes_feature", "_UI_DConstraint_type"),
				 DiagramPackage.Literals.DCONSTRAINT__DARROW_DATTRIBUTES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns DConstraint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DConstraint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_DConstraint_type");
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
		return DiagramMetamodelEditPlugin.INSTANCE;
	}

}
