/**
 */
package no.hib.dpf.visualization.impl;

import java.util.Map;

import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.visual.VisualPackage;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.VisualizationPackage;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualizationPackageImpl extends EPackageImpl implements VisualizationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visualizationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelToVisualEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vCompartmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vCompartmentElementEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see no.hib.dpf.visualization.VisualizationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VisualizationPackageImpl() {
		super(eNS_URI, VisualizationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link VisualizationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VisualizationPackage init() {
		if (isInited) return (VisualizationPackage)EPackage.Registry.INSTANCE.getEPackage(VisualizationPackage.eNS_URI);

		// Obtain or create and register package
		VisualizationPackageImpl theVisualizationPackage = (VisualizationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VisualizationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VisualizationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiagramPackage.eINSTANCE.eClass();
		VisualPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theVisualizationPackage.createPackageContents();

		// Initialize created meta-data
		theVisualizationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVisualizationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VisualizationPackage.eNS_URI, theVisualizationPackage);
		return theVisualizationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVisualizations() {
		return visualizationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVisualizations_Entries() {
		return (EReference)visualizationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVisualizations_Visual() {
		return (EReference)visualizationsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVisualizations_Instance() {
		return (EReference)visualizationsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVisualizations_Compartments() {
		return (EReference)visualizationsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelToVisualEntry() {
		return modelToVisualEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelToVisualEntry_Key() {
		return (EReference)modelToVisualEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelToVisualEntry_Value() {
		return (EReference)modelToVisualEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVCompartment() {
		return vCompartmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVCompartment_Parent() {
		return (EReference)vCompartmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVCompartment_CompartmentDNode() {
		return (EReference)vCompartmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVCompartment_Children() {
		return (EReference)vCompartmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVCompartmentElement() {
		return vCompartmentElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVCompartmentElement_DNode() {
		return (EReference)vCompartmentElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VisualizationFactory getVisualizationFactory() {
		return (VisualizationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		visualizationsEClass = createEClass(VISUALIZATIONS);
		createEReference(visualizationsEClass, VISUALIZATIONS__ENTRIES);
		createEReference(visualizationsEClass, VISUALIZATIONS__VISUAL);
		createEReference(visualizationsEClass, VISUALIZATIONS__INSTANCE);
		createEReference(visualizationsEClass, VISUALIZATIONS__COMPARTMENTS);

		modelToVisualEntryEClass = createEClass(MODEL_TO_VISUAL_ENTRY);
		createEReference(modelToVisualEntryEClass, MODEL_TO_VISUAL_ENTRY__KEY);
		createEReference(modelToVisualEntryEClass, MODEL_TO_VISUAL_ENTRY__VALUE);

		vCompartmentEClass = createEClass(VCOMPARTMENT);
		createEReference(vCompartmentEClass, VCOMPARTMENT__PARENT);
		createEReference(vCompartmentEClass, VCOMPARTMENT__COMPARTMENT_DNODE);
		createEReference(vCompartmentEClass, VCOMPARTMENT__CHILDREN);

		vCompartmentElementEClass = createEClass(VCOMPARTMENT_ELEMENT);
		createEReference(vCompartmentElementEClass, VCOMPARTMENT_ELEMENT__DNODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		VisualPackage theVisualPackage = (VisualPackage)EPackage.Registry.INSTANCE.getEPackage(VisualPackage.eNS_URI);
		DiagramPackage theDiagramPackage = (DiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		vCompartmentEClass.getESuperTypes().add(theVisualPackage.getVElement());
		vCompartmentElementEClass.getESuperTypes().add(theVisualPackage.getVElement());

		// Initialize classes and features; add operations and parameters
		initEClass(visualizationsEClass, Visualizations.class, "Visualizations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVisualizations_Entries(), this.getModelToVisualEntry(), null, "entries", null, 0, -1, Visualizations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualizations_Visual(), theVisualPackage.getVisuals(), null, "visual", null, 1, 1, Visualizations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualizations_Instance(), theDiagramPackage.getDSpecification(), null, "instance", null, 0, 1, Visualizations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualizations_Compartments(), this.getVCompartment(), null, "compartments", null, 0, -1, Visualizations.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelToVisualEntryEClass, Map.Entry.class, "ModelToVisualEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelToVisualEntry_Key(), theDiagramPackage.getDElement(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelToVisualEntry_Value(), theVisualPackage.getVElement(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vCompartmentEClass, VCompartment.class, "VCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVCompartment_Parent(), theDiagramPackage.getDNode(), null, "parent", null, 0, 1, VCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVCompartment_CompartmentDNode(), theDiagramPackage.getDNode(), null, "compartmentDNode", null, 0, 1, VCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVCompartment_Children(), this.getVCompartmentElement(), null, "children", null, 0, -1, VCompartment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vCompartmentElementEClass, VCompartmentElement.class, "VCompartmentElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVCompartmentElement_DNode(), theDiagramPackage.getDNode(), null, "dNode", null, 0, 1, VCompartmentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //VisualizationPackageImpl
