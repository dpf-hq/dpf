/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command;

import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.command.CommandPackage
 * @generated
 */
public interface CommandFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandFactory eINSTANCE = no.hib.dpf.command.impl.CommandFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Create Node Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Node Command</em>'.
	 * @generated
	 */
	CreateNodeCommand createCreateNodeCommand();
	
	/**
	 * Returns a new object of class '<em>Create Node Command</em>'.
	 * <!-- begin-user-doc -->
	 * Set name when creating node.
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Node Command</em>'.
	 * @generated NOT
	 */
	CreateNodeCommand createCreateNodeCommand(Graph graph, String name);

	/**
	 * Returns a new object of class '<em>Create Edge Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Edge Command</em>'.
	 * @generated
	 */
	CreateEdgeCommand createCreateEdgeCommand();
	
	/**
	 * Returns a new object of class '<em>Create Edge Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Edge Command</em>'.
	 * @generated NOT
	 */
	CreateEdgeCommand createCreateEdgeCommand(Graph graph, String name, Node source, Node target);

	/**
	 * Returns a new object of class '<em>Delete Node Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Node Command</em>'.
	 * @generated
	 */
	DeleteNodeCommand createDeleteNodeCommand();

	/**
	 * Returns a new object of class '<em>Delete Edge Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Edge Command</em>'.
	 * @generated
	 */
	DeleteEdgeCommand createDeleteEdgeCommand();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CommandPackage getCommandPackage();

} //CommandFactory
