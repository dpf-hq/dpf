/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.provider;

import java.util.ArrayList;
import java.util.Collection;

import no.hib.dpf.diagram.util.DiagramAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramItemProviderAdapterFactory extends DiagramAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();


	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DSpecification} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSpecificationItemProvider dSpecificationItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDSpecificationAdapter() {
		if (dSpecificationItemProvider == null) {
			dSpecificationItemProvider = new DSpecificationItemProvider(this);
		}

		return dSpecificationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DGraph} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DGraphItemProvider dGraphItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DGraph}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDGraphAdapter() {
		if (dGraphItemProvider == null) {
			dGraphItemProvider = new DGraphItemProvider(this);
		}

		return dGraphItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DNodeItemProvider dNodeItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDNodeAdapter() {
		if (dNodeItemProvider == null) {
			dNodeItemProvider = new DNodeItemProvider(this);
		}

		return dNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DDataNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DDataNodeItemProvider dDataNodeItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DDataNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDDataNodeAdapter() {
		if (dDataNodeItemProvider == null) {
			dDataNodeItemProvider = new DDataNodeItemProvider(this);
		}

		return dDataNodeItemProvider;
	}



	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DConstraintNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DConstraintNodeItemProvider dConstraintNodeItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DConstraintNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDConstraintNodeAdapter() {
		if (dConstraintNodeItemProvider == null) {
			dConstraintNodeItemProvider = new DConstraintNodeItemProvider(this);
		}

		return dConstraintNodeItemProvider;
	}



	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DArrow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DArrowItemProvider dArrowItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DArrow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDArrowAdapter() {
		if (dArrowItemProvider == null) {
			dArrowItemProvider = new DArrowItemProvider(this);
		}

		return dArrowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DConstraintItemProvider dConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDConstraintAdapter() {
		if (dConstraintItemProvider == null) {
			dConstraintItemProvider = new DConstraintItemProvider(this);
		}

		return dConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DArrowLabelConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DArrowLabelConstraintItemProvider dArrowLabelConstraintItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DArrowLabelConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDArrowLabelConstraintAdapter() {
		if (dArrowLabelConstraintItemProvider == null) {
			dArrowLabelConstraintItemProvider = new DArrowLabelConstraintItemProvider(this);
		}

		return dArrowLabelConstraintItemProvider;
	}



	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DGenericArrowConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DGenericArrowConstraintItemProvider dGenericArrowConstraintItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DGenericArrowConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDGenericArrowConstraintAdapter() {
		if (dGenericArrowConstraintItemProvider == null) {
			dGenericArrowConstraintItemProvider = new DGenericArrowConstraintItemProvider(this);
		}

		return dGenericArrowConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DComposedConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DComposedConstraintItemProvider dComposedConstraintItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DComposedConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDComposedConstraintAdapter() {
		if (dComposedConstraintItemProvider == null) {
			dComposedConstraintItemProvider = new DComposedConstraintItemProvider(this);
		}

		return dComposedConstraintItemProvider;
	}



	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DPredicate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DPredicateItemProvider dPredicateItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DPredicate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDPredicateAdapter() {
		if (dPredicateItemProvider == null) {
			dPredicateItemProvider = new DPredicateItemProvider(this);
		}

		return dPredicateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DOffset} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DOffsetItemProvider dOffsetItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DOffset}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDOffsetAdapter() {
		if (dOffsetItemProvider == null) {
			dOffsetItemProvider = new DOffsetItemProvider(this);
		}

		return dOffsetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DSignature} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSignatureItemProvider dSignatureItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DSignature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDSignatureAdapter() {
		if (dSignatureItemProvider == null) {
			dSignatureItemProvider = new DSignatureItemProvider(this);
		}

		return dSignatureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.Visualization} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualizationItemProvider visualizationItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.Visualization}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVisualizationAdapter() {
		if (visualizationItemProvider == null) {
			visualizationItemProvider = new VisualizationItemProvider(this);
		}

		return visualizationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DElementItemProvider dElementItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDElementAdapter() {
		if (dElementItemProvider == null) {
			dElementItemProvider = new DElementItemProvider(this);
		}

		return dElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DNodeDAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DNodeDAttributeItemProvider dNodeDAttributeItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DNodeDAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDNodeDAttributeAdapter() {
		if (dNodeDAttributeItemProvider == null) {
			dNodeDAttributeItemProvider = new DNodeDAttributeItemProvider(this);
		}

		return dNodeDAttributeItemProvider;
	}



	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.diagram.DArrowDAttribute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DArrowDAttributeItemProvider dArrowDAttributeItemProvider;


	/**
	 * This creates an adapter for a {@link no.hib.dpf.diagram.DArrowDAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDArrowDAttributeAdapter() {
		if (dArrowDAttributeItemProvider == null) {
			dArrowDAttributeItemProvider = new DArrowDAttributeItemProvider(this);
		}

		return dArrowDAttributeItemProvider;
	}



	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		if (dSpecificationItemProvider != null) dSpecificationItemProvider.dispose();
		if (dGraphItemProvider != null) dGraphItemProvider.dispose();
		if (dNodeItemProvider != null) dNodeItemProvider.dispose();
		if (dDataNodeItemProvider != null) dDataNodeItemProvider.dispose();
		if (dConstraintNodeItemProvider != null) dConstraintNodeItemProvider.dispose();
		if (dArrowItemProvider != null) dArrowItemProvider.dispose();
		if (dNodeDAttributeItemProvider != null) dNodeDAttributeItemProvider.dispose();
		if (dArrowDAttributeItemProvider != null) dArrowDAttributeItemProvider.dispose();
		if (dConstraintItemProvider != null) dConstraintItemProvider.dispose();
		if (dArrowLabelConstraintItemProvider != null) dArrowLabelConstraintItemProvider.dispose();
		if (dGenericArrowConstraintItemProvider != null) dGenericArrowConstraintItemProvider.dispose();
		if (dComposedConstraintItemProvider != null) dComposedConstraintItemProvider.dispose();
		if (dPredicateItemProvider != null) dPredicateItemProvider.dispose();
		if (dOffsetItemProvider != null) dOffsetItemProvider.dispose();
		if (dSignatureItemProvider != null) dSignatureItemProvider.dispose();
		if (visualizationItemProvider != null) visualizationItemProvider.dispose();
		if (dElementItemProvider != null) dElementItemProvider.dispose();
	}

}
