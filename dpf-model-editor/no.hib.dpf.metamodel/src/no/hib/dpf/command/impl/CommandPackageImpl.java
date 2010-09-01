/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.impl;

import no.hib.dpf.command.Command;
import no.hib.dpf.command.CommandFactory;
import no.hib.dpf.command.CommandPackage;

import no.hib.dpf.command.CreateEdgeCommand;
import no.hib.dpf.command.CreateNodeCommand;
import no.hib.dpf.command.DeleteEdgeCommand;
import no.hib.dpf.command.DeleteNodeCommand;
import no.hib.dpf.metamodel.MetamodelPackage;

import no.hib.dpf.metamodel.impl.MetamodelPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandPackageImpl extends EPackageImpl implements CommandPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createNodeCommandEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createEdgeCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteNodeCommandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteEdgeCommandEClass = null;

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
	 * @see no.hib.dpf.command.CommandPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CommandPackageImpl() {
		super(eNS_URI, CommandFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CommandPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CommandPackage init() {
		if (isInited) return (CommandPackage)EPackage.Registry.INSTANCE.getEPackage(CommandPackage.eNS_URI);

		// Obtain or create and register package
		CommandPackageImpl theCommandPackage = (CommandPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CommandPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CommandPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MetamodelPackageImpl theMetamodelPackage = (MetamodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI) instanceof MetamodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI) : MetamodelPackage.eINSTANCE);

		// Create package meta-data objects
		theCommandPackage.createPackageContents();
		theMetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theCommandPackage.initializePackageContents();
		theMetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCommandPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CommandPackage.eNS_URI, theCommandPackage);
		return theCommandPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateNodeCommand() {
		return createNodeCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateEdgeCommand() {
		return createEdgeCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteNodeCommand() {
		return deleteNodeCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteEdgeCommand() {
		return deleteEdgeCommandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandFactory getCommandFactory() {
		return (CommandFactory)getEFactoryInstance();
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
		commandEClass = createEClass(COMMAND);

		createNodeCommandEClass = createEClass(CREATE_NODE_COMMAND);

		createEdgeCommandEClass = createEClass(CREATE_EDGE_COMMAND);

		deleteNodeCommandEClass = createEClass(DELETE_NODE_COMMAND);

		deleteEdgeCommandEClass = createEClass(DELETE_EDGE_COMMAND);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		createNodeCommandEClass.getESuperTypes().add(this.getCommand());
		createEdgeCommandEClass.getESuperTypes().add(this.getCommand());
		deleteNodeCommandEClass.getESuperTypes().add(this.getCommand());
		deleteEdgeCommandEClass.getESuperTypes().add(this.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(commandEClass, Command.class, "Command", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(commandEClass, null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(commandEClass, null, "undo", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(createNodeCommandEClass, CreateNodeCommand.class, "CreateNodeCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createEdgeCommandEClass, CreateEdgeCommand.class, "CreateEdgeCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteNodeCommandEClass, DeleteNodeCommand.class, "DeleteNodeCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteEdgeCommandEClass, DeleteEdgeCommand.class, "DeleteEdgeCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CommandPackageImpl
