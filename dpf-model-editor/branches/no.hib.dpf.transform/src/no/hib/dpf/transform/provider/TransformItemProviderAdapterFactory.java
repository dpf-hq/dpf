/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.provider;

import java.util.ArrayList;
import java.util.Collection;

import no.hib.dpf.transform.util.TransformAdapterFactory;

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
public class TransformItemProviderAdapterFactory extends TransformAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public TransformItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.transform.Transform} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformItemProvider transformItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.transform.Transform}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTransformAdapter() {
		if (transformItemProvider == null) {
			transformItemProvider = new TransformItemProvider(this);
		}

		return transformItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.transform.CopiedNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopiedNodeItemProvider copiedNodeItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.transform.CopiedNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCopiedNodeAdapter() {
		if (copiedNodeItemProvider == null) {
			copiedNodeItemProvider = new CopiedNodeItemProvider(this);
		}

		return copiedNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.transform.MapArrow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MapArrowItemProvider mapArrowItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.transform.MapArrow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMapArrowAdapter() {
		if (mapArrowItemProvider == null) {
			mapArrowItemProvider = new MapArrowItemProvider(this);
		}

		return mapArrowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.transform.CopiedArrow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopiedArrowItemProvider copiedArrowItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.transform.CopiedArrow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCopiedArrowAdapter() {
		if (copiedArrowItemProvider == null) {
			copiedArrowItemProvider = new CopiedArrowItemProvider(this);
		}

		return copiedArrowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.transform.Reduction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReductionItemProvider reductionItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.transform.Reduction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReductionAdapter() {
		if (reductionItemProvider == null) {
			reductionItemProvider = new ReductionItemProvider(this);
		}

		return reductionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.transform.CopiedConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopiedConstraintItemProvider copiedConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.transform.CopiedConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCopiedConstraintAdapter() {
		if (copiedConstraintItemProvider == null) {
			copiedConstraintItemProvider = new CopiedConstraintItemProvider(this);
		}

		return copiedConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link no.hib.dpf.transform.Copied} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopiedItemProvider copiedItemProvider;

	/**
	 * This creates an adapter for a {@link no.hib.dpf.transform.Copied}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCopiedAdapter() {
		if (copiedItemProvider == null) {
			copiedItemProvider = new CopiedItemProvider(this);
		}

		return copiedItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public void dispose() {
		if (transformItemProvider != null) transformItemProvider.dispose();
		if (copiedNodeItemProvider != null) copiedNodeItemProvider.dispose();
		if (mapArrowItemProvider != null) mapArrowItemProvider.dispose();
		if (copiedArrowItemProvider != null) copiedArrowItemProvider.dispose();
		if (reductionItemProvider != null) reductionItemProvider.dispose();
		if (copiedConstraintItemProvider != null) copiedConstraintItemProvider.dispose();
		if (copiedItemProvider != null) copiedItemProvider.dispose();
	}

}