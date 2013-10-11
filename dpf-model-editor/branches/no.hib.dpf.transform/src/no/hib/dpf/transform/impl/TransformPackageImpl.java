/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.emf.ecore.EAttribute;
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
public class TransformPackageImpl extends EPackageImpl implements TransformPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productionEClass = null;

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
	 * @see no.hib.dpf.transform.TransformPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TransformPackageImpl() {
		super(eNS_URI, TransformFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TransformPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TransformPackage init() {
		if (isInited) return (TransformPackage)EPackage.Registry.INSTANCE.getEPackage(TransformPackage.eNS_URI);

		// Obtain or create and register package
		TransformPackageImpl theTransformPackage = (TransformPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TransformPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TransformPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiagramPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTransformPackage.createPackageContents();

		// Initialize created meta-data
		theTransformPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTransformPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TransformPackage.eNS_URI, theTransformPackage);
		return theTransformPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransform() {
		return transformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_SourceMetaModel() {
		return (EReference)transformEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_TargetMetaModel() {
		return (EReference)transformEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_Rules() {
		return (EReference)transformEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_DSignature() {
		return (EReference)transformEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransform_Generate() {
		return (EAttribute)transformEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransform_SourceLocation() {
		return (EAttribute)transformEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransform_TargetLocation() {
		return (EAttribute)transformEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_ElementTypeGraph() {
		return (EReference)transformEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_CorrespondanceGraph() {
		return (EReference)transformEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransform_CorrespondanceLocation() {
		return (EAttribute)transformEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProduction() {
		return productionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduction_Sum() {
		return (EReference)productionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduction_LeftNodes() {
		return (EReference)productionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduction_RightNodes() {
		return (EReference)productionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduction_RightArrows() {
		return (EReference)productionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduction_LeftArrows() {
		return (EReference)productionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduction_CommonNodes() {
		return (EReference)productionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduction_CommonArrows() {
		return (EReference)productionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProduction_Name() {
		return (EAttribute)productionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformFactory getTransformFactory() {
		return (TransformFactory)getEFactoryInstance();
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
		transformEClass = createEClass(TRANSFORM);
		createEReference(transformEClass, TRANSFORM__SOURCE_META_MODEL);
		createEReference(transformEClass, TRANSFORM__TARGET_META_MODEL);
		createEReference(transformEClass, TRANSFORM__RULES);
		createEReference(transformEClass, TRANSFORM__DSIGNATURE);
		createEAttribute(transformEClass, TRANSFORM__GENERATE);
		createEAttribute(transformEClass, TRANSFORM__SOURCE_LOCATION);
		createEAttribute(transformEClass, TRANSFORM__TARGET_LOCATION);
		createEReference(transformEClass, TRANSFORM__ELEMENT_TYPE_GRAPH);
		createEReference(transformEClass, TRANSFORM__CORRESPONDANCE_GRAPH);
		createEAttribute(transformEClass, TRANSFORM__CORRESPONDANCE_LOCATION);

		productionEClass = createEClass(PRODUCTION);
		createEReference(productionEClass, PRODUCTION__SUM);
		createEReference(productionEClass, PRODUCTION__LEFT_NODES);
		createEReference(productionEClass, PRODUCTION__RIGHT_NODES);
		createEReference(productionEClass, PRODUCTION__RIGHT_ARROWS);
		createEReference(productionEClass, PRODUCTION__LEFT_ARROWS);
		createEReference(productionEClass, PRODUCTION__COMMON_NODES);
		createEReference(productionEClass, PRODUCTION__COMMON_ARROWS);
		createEAttribute(productionEClass, PRODUCTION__NAME);
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
		DiagramPackage theDiagramPackage = (DiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(transformEClass, Transform.class, "Transform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransform_SourceMetaModel(), theDiagramPackage.getDSpecification(), null, "sourceMetaModel", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransform_TargetMetaModel(), theDiagramPackage.getDSpecification(), null, "targetMetaModel", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransform_Rules(), this.getProduction(), null, "rules", null, 0, -1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransform_DSignature(), theDiagramPackage.getDSignature(), null, "dSignature", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransform_Generate(), ecorePackage.getEBoolean(), "generate", "true", 1, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransform_SourceLocation(), ecorePackage.getEString(), "sourceLocation", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransform_TargetLocation(), ecorePackage.getEString(), "targetLocation", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransform_ElementTypeGraph(), theDiagramPackage.getDSpecification(), null, "elementTypeGraph", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransform_CorrespondanceGraph(), theDiagramPackage.getDSpecification(), null, "correspondanceGraph", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransform_CorrespondanceLocation(), ecorePackage.getEString(), "correspondanceLocation", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(productionEClass, Production.class, "Production", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProduction_Sum(), theDiagramPackage.getDSpecification(), null, "sum", null, 0, 1, Production.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProduction_LeftNodes(), theDiagramPackage.getDNode(), null, "leftNodes", null, 0, -1, Production.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProduction_RightNodes(), theDiagramPackage.getDNode(), null, "rightNodes", null, 0, -1, Production.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProduction_RightArrows(), theDiagramPackage.getDArrow(), null, "rightArrows", null, 0, -1, Production.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProduction_LeftArrows(), theDiagramPackage.getDArrow(), null, "leftArrows", null, 0, -1, Production.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProduction_CommonNodes(), theDiagramPackage.getDNode(), null, "commonNodes", null, 0, -1, Production.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProduction_CommonArrows(), theDiagramPackage.getDArrow(), null, "commonArrows", null, 0, -1, Production.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProduction_Name(), ecorePackage.getEString(), "name", null, 0, 1, Production.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TransformPackageImpl
