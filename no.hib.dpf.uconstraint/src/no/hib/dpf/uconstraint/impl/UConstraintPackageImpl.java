/**
 */
package no.hib.dpf.uconstraint.impl;

import no.hib.dpf.diagram.DiagramPackage;

import no.hib.dpf.uconstraint.Constraints;
import no.hib.dpf.uconstraint.UCType;
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.UConstraintFactory;
import no.hib.dpf.uconstraint.UConstraintPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UConstraintPackageImpl extends EPackageImpl implements UConstraintPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ucTypeEEnum = null;

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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UConstraintPackageImpl() {
		super(eNS_URI, UConstraintFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UConstraintPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UConstraintPackage init() {
		if (isInited) return (UConstraintPackage)EPackage.Registry.INSTANCE.getEPackage(UConstraintPackage.eNS_URI);

		// Obtain or create and register package
		UConstraintPackageImpl theUConstraintPackage = (UConstraintPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UConstraintPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UConstraintPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiagramPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUConstraintPackage.createPackageContents();

		// Initialize created meta-data
		theUConstraintPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUConstraintPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UConstraintPackage.eNS_URI, theUConstraintPackage);
		return theUConstraintPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraints() {
		return constraintsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraints_Rules() {
		return (EReference)constraintsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraints_DSignature() {
		return (EReference)constraintsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraints_ElementTypeGraph() {
		return (EReference)constraintsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraints_SourceLocation() {
		return (EAttribute)constraintsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUConstraint() {
		return uConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUConstraint_Sum() {
		return (EReference)uConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUConstraint_LeftNodes() {
		return (EReference)uConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUConstraint_RightNodes() {
		return (EReference)uConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUConstraint_RightArrows() {
		return (EReference)uConstraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUConstraint_LeftArrows() {
		return (EReference)uConstraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUConstraint_CommonNodes() {
		return (EReference)uConstraintEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUConstraint_CommonArrows() {
		return (EReference)uConstraintEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUConstraint_Name() {
		return (EAttribute)uConstraintEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUConstraint_Type() {
		return (EAttribute)uConstraintEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUCType() {
		return ucTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UConstraintFactory getUConstraintFactory() {
		return (UConstraintFactory)getEFactoryInstance();
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
		constraintsEClass = createEClass(CONSTRAINTS);
		createEReference(constraintsEClass, CONSTRAINTS__RULES);
		createEReference(constraintsEClass, CONSTRAINTS__DSIGNATURE);
		createEReference(constraintsEClass, CONSTRAINTS__ELEMENT_TYPE_GRAPH);
		createEAttribute(constraintsEClass, CONSTRAINTS__SOURCE_LOCATION);

		uConstraintEClass = createEClass(UCONSTRAINT);
		createEReference(uConstraintEClass, UCONSTRAINT__SUM);
		createEReference(uConstraintEClass, UCONSTRAINT__LEFT_NODES);
		createEReference(uConstraintEClass, UCONSTRAINT__RIGHT_NODES);
		createEReference(uConstraintEClass, UCONSTRAINT__RIGHT_ARROWS);
		createEReference(uConstraintEClass, UCONSTRAINT__LEFT_ARROWS);
		createEReference(uConstraintEClass, UCONSTRAINT__COMMON_NODES);
		createEReference(uConstraintEClass, UCONSTRAINT__COMMON_ARROWS);
		createEAttribute(uConstraintEClass, UCONSTRAINT__NAME);
		createEAttribute(uConstraintEClass, UCONSTRAINT__TYPE);

		// Create enums
		ucTypeEEnum = createEEnum(UC_TYPE);
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
		initEClass(constraintsEClass, Constraints.class, "Constraints", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraints_Rules(), this.getUConstraint(), null, "rules", null, 0, -1, Constraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraints_DSignature(), theDiagramPackage.getDSignature(), null, "dSignature", null, 0, 1, Constraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraints_ElementTypeGraph(), theDiagramPackage.getDSpecification(), null, "elementTypeGraph", null, 0, 1, Constraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraints_SourceLocation(), ecorePackage.getEString(), "sourceLocation", null, 0, 1, Constraints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uConstraintEClass, UConstraint.class, "UConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUConstraint_Sum(), theDiagramPackage.getDSpecification(), null, "sum", null, 0, 1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUConstraint_LeftNodes(), theDiagramPackage.getDNode(), null, "leftNodes", null, 0, -1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUConstraint_RightNodes(), theDiagramPackage.getDNode(), null, "rightNodes", null, 0, -1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUConstraint_RightArrows(), theDiagramPackage.getDArrow(), null, "rightArrows", null, 0, -1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUConstraint_LeftArrows(), theDiagramPackage.getDArrow(), null, "leftArrows", null, 0, -1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUConstraint_CommonNodes(), theDiagramPackage.getDNode(), null, "commonNodes", null, 0, -1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUConstraint_CommonArrows(), theDiagramPackage.getDArrow(), null, "commonArrows", null, 0, -1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUConstraint_Name(), ecorePackage.getEString(), "name", null, 0, 1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUConstraint_Type(), this.getUCType(), "type", null, 1, 1, UConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(ucTypeEEnum, UCType.class, "UCType");
		addEEnumLiteral(ucTypeEEnum, UCType.ALL_LEFT_EXIST_RIGHT);
		addEEnumLiteral(ucTypeEEnum, UCType.ALL_LEFT_NOT_EXIST_RIGHT);
		addEEnumLiteral(ucTypeEEnum, UCType.ALL_LEFT_IFF_RIGHT);
		addEEnumLiteral(ucTypeEEnum, UCType.ALL_LEFT_IFF_NOT_RIGHT);

		// Create resource
		createResource(eNS_URI);
	}

} //UConstraintPackageImpl
