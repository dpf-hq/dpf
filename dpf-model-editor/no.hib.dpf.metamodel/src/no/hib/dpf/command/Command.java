/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.command;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see no.hib.dpf.command.CommandPackage#getCommand()
 * @model abstract="true"
 * @generated
 */
public interface Command extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void execute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void undo();

} // Command
