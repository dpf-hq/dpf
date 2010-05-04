/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package protolayout.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import protolayout.LayoutSystem;
import protolayout.NodeLayout;
import protolayout.ProtolayoutFactory;
import protolayout.ProtolayoutPackage;

import protomodel.ProtomodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProtolayoutPackageImpl extends EPackageImpl implements ProtolayoutPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layoutSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeLayoutEClass = null;

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
	 * @see protolayout.ProtolayoutPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProtolayoutPackageImpl() {
		super(eNS_URI, ProtolayoutFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProtolayoutPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProtolayoutPackage init() {
		if (isInited) return (ProtolayoutPackage)EPackage.Registry.INSTANCE.getEPackage(ProtolayoutPackage.eNS_URI);

		// Obtain or create and register package
		ProtolayoutPackageImpl theProtolayoutPackage = (ProtolayoutPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProtolayoutPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProtolayoutPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ProtomodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProtolayoutPackage.createPackageContents();

		// Initialize created meta-data
		theProtolayoutPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProtolayoutPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProtolayoutPackage.eNS_URI, theProtolayoutPackage);
		return theProtolayoutPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayoutSystem() {
		return layoutSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayoutSystem_NodeLayouts() {
		return (EReference)layoutSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeLayout() {
		return nodeLayoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeLayout_Node() {
		return (EReference)nodeLayoutEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeLayout_X() {
		return (EAttribute)nodeLayoutEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeLayout_Y() {
		return (EAttribute)nodeLayoutEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtolayoutFactory getProtolayoutFactory() {
		return (ProtolayoutFactory)getEFactoryInstance();
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
		layoutSystemEClass = createEClass(LAYOUT_SYSTEM);
		createEReference(layoutSystemEClass, LAYOUT_SYSTEM__NODE_LAYOUTS);

		nodeLayoutEClass = createEClass(NODE_LAYOUT);
		createEReference(nodeLayoutEClass, NODE_LAYOUT__NODE);
		createEAttribute(nodeLayoutEClass, NODE_LAYOUT__X);
		createEAttribute(nodeLayoutEClass, NODE_LAYOUT__Y);
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
		ProtomodelPackage theProtomodelPackage = (ProtomodelPackage)EPackage.Registry.INSTANCE.getEPackage(ProtomodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(layoutSystemEClass, LayoutSystem.class, "LayoutSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayoutSystem_NodeLayouts(), this.getNodeLayout(), null, "nodeLayouts", null, 0, -1, LayoutSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeLayoutEClass, NodeLayout.class, "NodeLayout", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeLayout_Node(), theProtomodelPackage.getClazz(), null, "node", null, 0, 1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeLayout_X(), ecorePackage.getEInt(), "x", null, 0, 1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeLayout_Y(), ecorePackage.getEInt(), "y", null, 0, 1, NodeLayout.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ProtolayoutPackageImpl
