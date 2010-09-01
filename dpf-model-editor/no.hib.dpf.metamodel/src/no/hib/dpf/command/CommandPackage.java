/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see no.hib.dpf.command.CommandFactory
 * @model kind="package"
 * @generated
 */
public interface CommandPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "command";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://no.hib.dpf.command";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "no.hib.dpf.command";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandPackage eINSTANCE = no.hib.dpf.command.impl.CommandPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.command.impl.CommandImpl <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.command.impl.CommandImpl
	 * @see no.hib.dpf.command.impl.CommandPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 0;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link no.hib.dpf.command.impl.CreateNodeCommandImpl <em>Create Node Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.command.impl.CreateNodeCommandImpl
	 * @see no.hib.dpf.command.impl.CommandPackageImpl#getCreateNodeCommand()
	 * @generated
	 */
	int CREATE_NODE_COMMAND = 1;

	/**
	 * The number of structural features of the '<em>Create Node Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_NODE_COMMAND_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.command.impl.CreateEdgeCommandImpl <em>Create Edge Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.command.impl.CreateEdgeCommandImpl
	 * @see no.hib.dpf.command.impl.CommandPackageImpl#getCreateEdgeCommand()
	 * @generated
	 */
	int CREATE_EDGE_COMMAND = 2;

	/**
	 * The number of structural features of the '<em>Create Edge Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_EDGE_COMMAND_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link no.hib.dpf.command.impl.DeleteNodeCommandImpl <em>Delete Node Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.command.impl.DeleteNodeCommandImpl
	 * @see no.hib.dpf.command.impl.CommandPackageImpl#getDeleteNodeCommand()
	 * @generated
	 */
	int DELETE_NODE_COMMAND = 3;

	/**
	 * The number of structural features of the '<em>Delete Node Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_NODE_COMMAND_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.command.impl.DeleteEdgeCommandImpl <em>Delete Edge Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.command.impl.DeleteEdgeCommandImpl
	 * @see no.hib.dpf.command.impl.CommandPackageImpl#getDeleteEdgeCommand()
	 * @generated
	 */
	int DELETE_EDGE_COMMAND = 4;

	/**
	 * The number of structural features of the '<em>Delete Edge Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_EDGE_COMMAND_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link no.hib.dpf.command.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command</em>'.
	 * @see no.hib.dpf.command.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.command.CreateNodeCommand <em>Create Node Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Node Command</em>'.
	 * @see no.hib.dpf.command.CreateNodeCommand
	 * @generated
	 */
	EClass getCreateNodeCommand();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.command.CreateEdgeCommand <em>Create Edge Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Edge Command</em>'.
	 * @see no.hib.dpf.command.CreateEdgeCommand
	 * @generated
	 */
	EClass getCreateEdgeCommand();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.command.DeleteNodeCommand <em>Delete Node Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Node Command</em>'.
	 * @see no.hib.dpf.command.DeleteNodeCommand
	 * @generated
	 */
	EClass getDeleteNodeCommand();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.command.DeleteEdgeCommand <em>Delete Edge Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Edge Command</em>'.
	 * @see no.hib.dpf.command.DeleteEdgeCommand
	 * @generated
	 */
	EClass getDeleteEdgeCommand();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommandFactory getCommandFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link no.hib.dpf.command.impl.CommandImpl <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.command.impl.CommandImpl
		 * @see no.hib.dpf.command.impl.CommandPackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();
		/**
		 * The meta object literal for the '{@link no.hib.dpf.command.impl.CreateNodeCommandImpl <em>Create Node Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.command.impl.CreateNodeCommandImpl
		 * @see no.hib.dpf.command.impl.CommandPackageImpl#getCreateNodeCommand()
		 * @generated
		 */
		EClass CREATE_NODE_COMMAND = eINSTANCE.getCreateNodeCommand();
		/**
		 * The meta object literal for the '{@link no.hib.dpf.command.impl.CreateEdgeCommandImpl <em>Create Edge Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.command.impl.CreateEdgeCommandImpl
		 * @see no.hib.dpf.command.impl.CommandPackageImpl#getCreateEdgeCommand()
		 * @generated
		 */
		EClass CREATE_EDGE_COMMAND = eINSTANCE.getCreateEdgeCommand();
		/**
		 * The meta object literal for the '{@link no.hib.dpf.command.impl.DeleteNodeCommandImpl <em>Delete Node Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.command.impl.DeleteNodeCommandImpl
		 * @see no.hib.dpf.command.impl.CommandPackageImpl#getDeleteNodeCommand()
		 * @generated
		 */
		EClass DELETE_NODE_COMMAND = eINSTANCE.getDeleteNodeCommand();
		/**
		 * The meta object literal for the '{@link no.hib.dpf.command.impl.DeleteEdgeCommandImpl <em>Delete Edge Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.command.impl.DeleteEdgeCommandImpl
		 * @see no.hib.dpf.command.impl.CommandPackageImpl#getDeleteEdgeCommand()
		 * @generated
		 */
		EClass DELETE_EDGE_COMMAND = eINSTANCE.getDeleteEdgeCommand();

	}

} //CommandPackage
