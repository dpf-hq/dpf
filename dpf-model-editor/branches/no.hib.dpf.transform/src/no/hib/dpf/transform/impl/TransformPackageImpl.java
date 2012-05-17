/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import no.hib.dpf.core.CorePackage;
import no.hib.dpf.transform.Copied;
import no.hib.dpf.transform.CopiedArrow;
import no.hib.dpf.transform.CopiedConstraint;
import no.hib.dpf.transform.CopiedNode;
import no.hib.dpf.transform.CopiedType;
import no.hib.dpf.transform.MapArrow;
import no.hib.dpf.transform.Reduction;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
	private EClass copiedNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapArrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copiedArrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reductionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copiedConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copiedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum copiedTypeEEnum = null;

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
		CorePackage.eINSTANCE.eClass();

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
	public EReference getTransform_SourceMeta() {
		return (EReference)transformEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_TargetMeta() {
		return (EReference)transformEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_JointMeta() {
		return (EReference)transformEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransform_Rules() {
		return (EReference)transformEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopiedNode() {
		return copiedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapArrow() {
		return mapArrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopiedArrow() {
		return copiedArrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReduction() {
		return reductionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReduction_Left() {
		return (EReference)reductionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReduction_Right() {
		return (EReference)reductionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReduction_Mapping() {
		return (EReference)reductionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopiedConstraint() {
		return copiedConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopied() {
		return copiedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopied_CopiedType() {
		return (EAttribute)copiedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCopiedType() {
		return copiedTypeEEnum;
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
		createEReference(transformEClass, TRANSFORM__SOURCE_META);
		createEReference(transformEClass, TRANSFORM__TARGET_META);
		createEReference(transformEClass, TRANSFORM__JOINT_META);
		createEReference(transformEClass, TRANSFORM__RULES);

		copiedNodeEClass = createEClass(COPIED_NODE);

		mapArrowEClass = createEClass(MAP_ARROW);

		copiedArrowEClass = createEClass(COPIED_ARROW);

		reductionEClass = createEClass(REDUCTION);
		createEReference(reductionEClass, REDUCTION__LEFT);
		createEReference(reductionEClass, REDUCTION__RIGHT);
		createEReference(reductionEClass, REDUCTION__MAPPING);

		copiedConstraintEClass = createEClass(COPIED_CONSTRAINT);

		copiedEClass = createEClass(COPIED);
		createEAttribute(copiedEClass, COPIED__COPIED_TYPE);

		// Create enums
		copiedTypeEEnum = createEEnum(COPIED_TYPE);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		copiedNodeEClass.getESuperTypes().add(theCorePackage.getNode());
		copiedNodeEClass.getESuperTypes().add(this.getCopied());
		mapArrowEClass.getESuperTypes().add(theCorePackage.getArrow());
		copiedArrowEClass.getESuperTypes().add(theCorePackage.getArrow());
		copiedArrowEClass.getESuperTypes().add(this.getCopied());
		copiedConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		copiedConstraintEClass.getESuperTypes().add(this.getCopied());

		// Initialize classes and features; add operations and parameters
		initEClass(transformEClass, Transform.class, "Transform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransform_SourceMeta(), theCorePackage.getSpecification(), null, "sourceMeta", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransform_TargetMeta(), theCorePackage.getSpecification(), null, "targetMeta", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransform_JointMeta(), theCorePackage.getSpecification(), null, "jointMeta", null, 0, 1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransform_Rules(), this.getReduction(), null, "rules", null, 0, -1, Transform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(transformEClass, theCorePackage.getSpecification(), "getMappings", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCorePackage.getSpecification(), "model", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getReduction(), "rule", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(transformEClass, theCorePackage.getSpecification(), "applyReduction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCorePackage.getSpecification(), "model", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getReduction(), "rule", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(copiedNodeEClass, CopiedNode.class, "CopiedNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapArrowEClass, MapArrow.class, "MapArrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(copiedArrowEClass, CopiedArrow.class, "CopiedArrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reductionEClass, Reduction.class, "Reduction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReduction_Left(), theCorePackage.getSpecification(), null, "left", null, 0, 1, Reduction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReduction_Right(), theCorePackage.getSpecification(), null, "right", null, 0, 1, Reduction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReduction_Mapping(), theCorePackage.getGraphHomomorphism(), null, "mapping", null, 0, 1, Reduction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(copiedConstraintEClass, CopiedConstraint.class, "CopiedConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(copiedEClass, Copied.class, "Copied", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCopied_CopiedType(), this.getCopiedType(), "copiedType", null, 0, 1, Copied.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(copiedTypeEEnum, CopiedType.class, "CopiedType");
		addEEnumLiteral(copiedTypeEEnum, CopiedType.SOURCE);
		addEEnumLiteral(copiedTypeEEnum, CopiedType.TARGET);

		// Create resource
		createResource(eNS_URI);
	}

} //TransformPackageImpl
