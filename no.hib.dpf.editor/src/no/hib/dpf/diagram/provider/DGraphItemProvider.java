/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.provider;


import java.util.Collection;
import java.util.List;

import no.hib.dpf.core.provider.GraphItemProvider;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.DiagramPackage;
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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link no.hib.dpf.diagram.DGraph} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DGraphItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	GraphItemProvider graphItemProvider = null;
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public DGraphItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		graphItemProvider = new GraphItemProvider(adapterFactory);
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
			addDTypePropertyDescriptor(object);
			addGraphPropertyDescriptor(object);
			
			if(object instanceof DGraph){
				itemPropertyDescriptors.addAll(graphItemProvider.getPropertyDescriptors(((DGraph)object).getGraph()));
			}
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
				 getString("_UI_DGraph_dType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DGraph_dType_feature", "_UI_DGraph_type"),
				 DiagramPackage.Literals.DGRAPH__DTYPE,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DGRAPH_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Graph feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addGraphPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DGraph_graph_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DGraph_graph_feature", "_UI_DGraph_type"),
				 DiagramPackage.Literals.DGRAPH__GRAPH,
				 true,
				 false,
				 true,
				 null,
				 DPFCoreConstants.DGRAPH_CATEGORY,
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
			childrenFeatures.add(DiagramPackage.Literals.DGRAPH__DNODES);
			childrenFeatures.add(DiagramPackage.Literals.DGRAPH__DARROWS);
			childrenFeatures.add(DiagramPackage.Literals.DGRAPH__DDATA_NODES);
			childrenFeatures.add(DiagramPackage.Literals.DGRAPH__DARROW_DATTRIBUTES);
			childrenFeatures.add(DiagramPackage.Literals.DGRAPH__DNODE_DATTRIBUTES);
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
	 * This returns DGraph.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DGraph"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_DGraph_type");
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

		switch (notification.getFeatureID(DGraph.class)) {
			case DiagramPackage.DGRAPH__DNODES:
			case DiagramPackage.DGRAPH__DARROWS:
			case DiagramPackage.DGRAPH__DDATA_NODES:
			case DiagramPackage.DGRAPH__DARROW_DATTRIBUTES:
			case DiagramPackage.DGRAPH__DNODE_DATTRIBUTES:
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
				(DiagramPackage.Literals.DGRAPH__DNODES,
				 DiagramFactory.eINSTANCE.createDNode()));

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DGRAPH__DNODES,
				 DiagramFactory.eINSTANCE.createDConstraintNode()));

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DGRAPH__DARROWS,
				 DiagramFactory.eINSTANCE.createDArrow()));

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DGRAPH__DDATA_NODES,
				 DiagramFactory.eINSTANCE.createDDataNode()));

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DGRAPH__DARROW_DATTRIBUTES,
				 DiagramFactory.eINSTANCE.createDArrowDAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(DiagramPackage.Literals.DGRAPH__DNODE_DATTRIBUTES,
				 DiagramFactory.eINSTANCE.createDNodeDAttribute()));
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
