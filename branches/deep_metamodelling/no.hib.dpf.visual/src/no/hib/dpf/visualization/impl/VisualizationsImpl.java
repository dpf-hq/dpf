/**
 */
package no.hib.dpf.visualization.impl;


import java.util.Collection;

import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.Visuals;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VisualizationPackage;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visualizations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.visualization.impl.VisualizationsImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.impl.VisualizationsImpl#getVisual <em>Visual</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.impl.VisualizationsImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.impl.VisualizationsImpl#getCompartments <em>Compartments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VisualizationsImpl extends EObjectImpl implements Visualizations {
	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EMap<DElement, VElement> entries;

	/**
	 * The cached value of the '{@link #getVisual() <em>Visual</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisual()
	 * @generated
	 * @ordered
	 */
	protected Visuals visual;

	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected DSpecification instance;

	/**
	 * The cached value of the '{@link #getCompartments() <em>Compartments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompartments()
	 * @generated
	 * @ordered
	 */
	protected EList<VCompartment> compartments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualizationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VisualizationPackage.Literals.VISUALIZATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<DElement, VElement> getEntries() {
		if (entries == null) {
			entries = new EcoreEMap<DElement,VElement>(VisualizationPackage.Literals.MODEL_TO_VISUAL_ENTRY, ModelToVisualEntryImpl.class, this, VisualizationPackage.VISUALIZATIONS__ENTRIES);
		}
		return entries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Visuals getVisual() {
		if (visual != null && visual.eIsProxy()) {
			InternalEObject oldVisual = (InternalEObject)visual;
			visual = (Visuals)eResolveProxy(oldVisual);
			if (visual != oldVisual) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisualizationPackage.VISUALIZATIONS__VISUAL, oldVisual, visual));
			}
		}
		return visual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visuals basicGetVisual() {
		return visual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisual(Visuals newVisual) {
		Visuals oldVisual = visual;
		visual = newVisual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualizationPackage.VISUALIZATIONS__VISUAL, oldVisual, visual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DSpecification getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject)instance;
			instance = (DSpecification)eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VisualizationPackage.VISUALIZATIONS__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSpecification basicGetInstance() {
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstance(DSpecification newInstance) {
		DSpecification oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VisualizationPackage.VISUALIZATIONS__INSTANCE, oldInstance, instance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VCompartment> getCompartments() {
		if (compartments == null) {
			compartments = new EObjectContainmentEList<VCompartment>(VCompartment.class, this, VisualizationPackage.VISUALIZATIONS__COMPARTMENTS);
		}
		return compartments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VisualizationPackage.VISUALIZATIONS__ENTRIES:
				return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
			case VisualizationPackage.VISUALIZATIONS__COMPARTMENTS:
				return ((InternalEList<?>)getCompartments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VisualizationPackage.VISUALIZATIONS__ENTRIES:
				if (coreType) return getEntries();
				else return getEntries().map();
			case VisualizationPackage.VISUALIZATIONS__VISUAL:
				if (resolve) return getVisual();
				return basicGetVisual();
			case VisualizationPackage.VISUALIZATIONS__INSTANCE:
				if (resolve) return getInstance();
				return basicGetInstance();
			case VisualizationPackage.VISUALIZATIONS__COMPARTMENTS:
				return getCompartments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VisualizationPackage.VISUALIZATIONS__ENTRIES:
				((EStructuralFeature.Setting)getEntries()).set(newValue);
				return;
			case VisualizationPackage.VISUALIZATIONS__VISUAL:
				setVisual((Visuals)newValue);
				return;
			case VisualizationPackage.VISUALIZATIONS__INSTANCE:
				setInstance((DSpecification)newValue);
				return;
			case VisualizationPackage.VISUALIZATIONS__COMPARTMENTS:
				getCompartments().clear();
				getCompartments().addAll((Collection<? extends VCompartment>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VisualizationPackage.VISUALIZATIONS__ENTRIES:
				getEntries().clear();
				return;
			case VisualizationPackage.VISUALIZATIONS__VISUAL:
				setVisual((Visuals)null);
				return;
			case VisualizationPackage.VISUALIZATIONS__INSTANCE:
				setInstance((DSpecification)null);
				return;
			case VisualizationPackage.VISUALIZATIONS__COMPARTMENTS:
				getCompartments().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VisualizationPackage.VISUALIZATIONS__ENTRIES:
				return entries != null && !entries.isEmpty();
			case VisualizationPackage.VISUALIZATIONS__VISUAL:
				return visual != null;
			case VisualizationPackage.VISUALIZATIONS__INSTANCE:
				return instance != null;
			case VisualizationPackage.VISUALIZATIONS__COMPARTMENTS:
				return compartments != null && !compartments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VisualizationsImpl
