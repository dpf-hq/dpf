/**
 */
package no.hib.dpf.visualization.impl;

import java.util.Map;

import no.hib.dpf.core.IDObject;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visualization.*;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.VisualizationPackage;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualizationFactoryImpl extends EFactoryImpl implements VisualizationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisualizationFactory init() {
		try {
			VisualizationFactory theVisualizationFactory = (VisualizationFactory)EPackage.Registry.INSTANCE.getEFactory("no.hib.dpf.visualization"); 
			if (theVisualizationFactory != null) {
				return theVisualizationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VisualizationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VisualizationPackage.VISUALIZATIONS: return createVisualizations();
			case VisualizationPackage.MODEL_TO_VISUAL_ENTRY: return (EObject)createModelToVisualEntry();
			case VisualizationPackage.VCOMPARTMENT: return createVCompartment();
			case VisualizationPackage.VCOMPARTMENT_ELEMENT: return createVCompartmentElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visualizations createVisualizations() {
		VisualizationsImpl visualizations = new VisualizationsImpl();
		return visualizations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<IDObject, VElement> createModelToVisualEntry() {
		ModelToVisualEntryImpl modelToVisualEntry = new ModelToVisualEntryImpl();
		return modelToVisualEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VCompartment createVCompartment() {
		VCompartmentImpl vCompartment = new VCompartmentImpl();
		return vCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VCompartmentElement createVCompartmentElement() {
		VCompartmentElementImpl vCompartmentElement = new VCompartmentElementImpl();
		return vCompartmentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationPackage getVisualizationPackage() {
		return (VisualizationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VisualizationPackage getPackage() {
		return VisualizationPackage.eINSTANCE;
	}

} //VisualizationFactoryImpl
