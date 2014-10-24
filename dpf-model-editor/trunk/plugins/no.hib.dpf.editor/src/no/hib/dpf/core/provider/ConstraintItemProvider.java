/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.diagram.provider.ExtendItemPropertyDescriptor;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link no.hib.dpf.core.Constraint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintItemProvider
	extends IDObjectItemProvider {
	private final class ConstraintParameterItemProvider extends
			ExtendItemPropertyDescriptor {
		private ConstraintParameterItemProvider(AdapterFactory adapterFactory,
				ResourceLocator resourceLocator, String displayName,
				String description, EStructuralFeature feature,
				boolean isSettable, boolean multiLine, boolean sortChoices,
				Object staticImage, String category, String[] filterFlags) {
			super(adapterFactory, resourceLocator, displayName, description,
					feature, isSettable, multiLine, sortChoices, staticImage,
					category, filterFlags);
		}

		public Object getPropertyValue(Object object){
			Object result = super.getPropertyValue(object);
			if(result instanceof PropertyValueWrapper){
				String para = (String) (( PropertyValueWrapper) result).getEditableValue(null);
				int index = para.indexOf(displayName);
				index = index + displayName.length() + 1;
				int end = para.indexOf(";", index);
				if(end == -1) end = para.length();
				return para.substring(index, end);
			}
			return result;
		}

		public void setPropertyValue(Object object, Object value){
			Object result = super.getPropertyValue(object);
			if(result instanceof PropertyValueWrapper){
			String para = (String) (( PropertyValueWrapper) result).getEditableValue(null);
			int index = para.indexOf(displayName);
			index = index + displayName.length() + 1;
			int end = para.indexOf(";", index);
			if(end == -1) end = para.length();
			super.setPropertyValue(object, para.substring(0, index) + value + para.substring(end));
			}else
				super.setPropertyValue(object, value);
		}
		public String getId(Object object) {
			return super.getId(object) + displayName;
		}
	}

	public static final String Constraint_CATEGORY = "Constraint";
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null){
			super.getPropertyDescriptors(object);
			addNodesPropertyDescriptor(object);
			addArrowsPropertyDescriptor(object);
			addPredicatePropertyDescriptor(object);
		}
		List<IItemPropertyDescriptor> dynamic = new ArrayList<IItemPropertyDescriptor>();
		dynamic.addAll(itemPropertyDescriptors);
		addParametersPropertyDescriptor(dynamic, object);
		return dynamic;
	}

	/**
	 * This adds a property descriptor for the Nodes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addNodesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Constraint_nodes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Constraint_nodes_feature", "_UI_Constraint_type"),
				 CorePackage.Literals.CONSTRAINT__NODES,
				 true,
				 false,
				 true,
				 null,
				 Constraint_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Arrows feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addArrowsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Constraint_arrows_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Constraint_arrows_feature", "_UI_Constraint_type"),
				 CorePackage.Literals.CONSTRAINT__ARROWS,
				 true,
				 false,
				 true,
				 null,
				 Constraint_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Predicate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addPredicatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Constraint_predicate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Constraint_predicate_feature", "_UI_Constraint_type"),
				 CorePackage.Literals.CONSTRAINT__PREDICATE,
				 true,
				 false,
				 true,
				 null,
				 Constraint_CATEGORY,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Constraint_parameters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Constraint_parameters_feature", "_UI_Constraint_type"),
				 CorePackage.Literals.CONSTRAINT__PARAMETERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	private static Map<Predicate, List<IItemPropertyDescriptor>> database = new HashMap<Predicate, List<IItemPropertyDescriptor>>();
	protected void addParametersPropertyDescriptor(List<IItemPropertyDescriptor> object2, Object object) {
		if(object instanceof Constraint){
			Constraint constraint = (Constraint) object;
			if(constraint.getParameters() == null || constraint.getParameters().isEmpty())
				return;
			List<IItemPropertyDescriptor> paras = database.get(constraint.getPredicate());
			if(paras != null)
				object2.addAll(paras);
			else{
				paras = new ArrayList<IItemPropertyDescriptor>();
				String parameter = constraint.getParameters();
				if(parameter != null && !parameter.isEmpty()){
					String[] paras1 = parameter.split(";");
					for (int i = 0; i < paras1.length; i++) {
						String[] pair = paras1[i].split(":");
						if(pair.length != 2) return;
						paras.add
						(new ConstraintParameterItemProvider(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
								pair[0], getString("_UI_PropertyDescriptor_description", "_UI_Constraint_parameters_feature", "_UI_Constraint_type"), CorePackage.Literals.CONSTRAINT__PARAMETERS, true, false,
								false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, Constraint_CATEGORY, null));
						
					}
					
				}
				database.put(constraint.getPredicate(), paras);
				object2.addAll(paras);
			}
				
		}
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
			childrenFeatures.add(CorePackage.Literals.CONSTRAINT__MAPPINGS);
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
	 * This returns Constraint.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Constraint"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Constraint constraint = (Constraint)object;
		return constraint.getPredicate().getSymbol();
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

		switch (notification.getFeatureID(Constraint.class)) {
			case CorePackage.CONSTRAINT__PARAMETERS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CorePackage.CONSTRAINT__MAPPINGS:
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
				(CorePackage.Literals.CONSTRAINT__MAPPINGS,
				 CoreFactory.eINSTANCE.createGraphHomomorphism()));
	}

}
