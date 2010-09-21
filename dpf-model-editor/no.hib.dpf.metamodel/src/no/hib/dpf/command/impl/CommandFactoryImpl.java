/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command.impl;

import no.hib.dpf.command.*;
import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;

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
public class CommandFactoryImpl extends EFactoryImpl implements CommandFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandFactory init() {
		try {
			CommandFactory theCommandFactory = (CommandFactory)EPackage.Registry.INSTANCE.getEFactory("http://no.hib.dpf.command"); 
			if (theCommandFactory != null) {
				return theCommandFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CommandFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandFactoryImpl() {
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
			case CommandPackage.CREATE_NODE_COMMAND: return createCreateNodeCommand();
			case CommandPackage.CREATE_EDGE_COMMAND: return createCreateEdgeCommand();
			case CommandPackage.DELETE_NODE_COMMAND: return createDeleteNodeCommand();
			case CommandPackage.DELETE_EDGE_COMMAND: return createDeleteEdgeCommand();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateNodeCommand createCreateNodeCommand() {
		CreateNodeCommandImpl createNodeCommand = new CreateNodeCommandImpl();
		return createNodeCommand;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CreateNodeCommand createCreateNodeCommand(Graph graph, String name) {
		CreateNodeCommandImpl createNodeCommand = new CreateNodeCommandImpl(graph, name);
		return createNodeCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateEdgeCommand createCreateEdgeCommand() {
		CreateEdgeCommandImpl createEdgeCommand = new CreateEdgeCommandImpl();
		return createEdgeCommand;
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CreateEdgeCommand createCreateEdgeCommand(Graph graph, String name, Node source, Node target) {
		CreateEdgeCommandImpl createEdgeCommand = new CreateEdgeCommandImpl(graph, name, source, target);
		return createEdgeCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteNodeCommand createDeleteNodeCommand() {
		DeleteNodeCommandImpl deleteNodeCommand = new DeleteNodeCommandImpl();
		return deleteNodeCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteEdgeCommand createDeleteEdgeCommand() {
		DeleteEdgeCommandImpl deleteEdgeCommand = new DeleteEdgeCommandImpl();
		return deleteEdgeCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandPackage getCommandPackage() {
		return (CommandPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CommandPackage getPackage() {
		return CommandPackage.eINSTANCE;
	}

} //CommandFactoryImpl
