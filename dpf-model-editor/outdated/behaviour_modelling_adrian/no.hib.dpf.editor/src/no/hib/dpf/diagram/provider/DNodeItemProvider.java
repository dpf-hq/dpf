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

import no.hib.dpf.core.provider.NodeItemProvider;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.utils.DPFConstants;

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
 * This is the item provider adapter for a {@link no.hib.dpf.diagram.DNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DNodeItemProvider
	extends DBoundItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	NodeItemProvider nodeItemProvider = null;
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DNodeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		nodeItemProvider = new NodeItemProvider(adapterFactory);
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
//			addDOutgoingsPropertyDescriptor(object);
//			addDIncomingsPropertyDescriptor(object);
//			addDConstraintsPropertyDescriptor(object);
			if(object instanceof DNode)
				itemPropertyDescriptors.addAll(nodeItemProvider.getPropertyDescriptors(((DNode)object).getNode()));
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
				 getString("_UI_DNode_dType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNode_dType_feature", "_UI_DNode_type"),
				 DiagramPackage.Literals.DNODE__DTYPE,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DNODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNode_node_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNode_node_feature", "_UI_DNode_type"),
				 DiagramPackage.Literals.DNODE__NODE,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DNODE_CATEGORY,
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
				 getString("_UI_DNode_configureString_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNode_configureString_feature", "_UI_DNode_type"),
				 DiagramPackage.Literals.DNODE__CONFIGURE_STRING,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 DPFConstants.DNODE_CATEGORY,
				 null){
			public Collection<?> getChoiceOfValues(Object object)
			{
				return Arrays.asList(FigureConfigureManager.INSTANCE.getNodeNames());
			}
		};
		itemPropertyDescriptors.add(current);
	}

	/**
	 * This adds a property descriptor for the DOutgoings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDOutgoingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNode_dOutgoings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNode_dOutgoings_feature", "_UI_DNode_type"),
				 DiagramPackage.Literals.DNODE__DOUTGOINGS,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DNODE_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the DIncomings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDIncomingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DNode_dIncomings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNode_dIncomings_feature", "_UI_DNode_type"),
				 DiagramPackage.Literals.DNODE__DINCOMINGS,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DNODE_CATEGORY,
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
				 getString("_UI_DNode_dConstraints_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DNode_dConstraints_feature", "_UI_DNode_type"),
				 DiagramPackage.Literals.DNODE__DCONSTRAINTS,
				 false,
				 false,
				 true,
				 null,
				 DPFConstants.DNODE_CATEGORY,
				 null));
	}

	/**
	 * This returns DNode.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DNode"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((DNode)object).getName();
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

		switch (notification.getFeatureID(DNode.class)) {
			case DiagramPackage.DNODE__CONFIGURE_STRING:
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
