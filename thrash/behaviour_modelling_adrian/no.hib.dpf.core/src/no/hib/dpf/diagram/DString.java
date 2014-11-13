/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.IDObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DString</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DString#getStringProvider <em>String Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDString()
 * @model
 * @generated
 */
public interface DString extends DBound {
	/**
	 * Returns the value of the '<em><b>String Provider</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Provider</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Provider</em>' reference.
	 * @see #setStringProvider(IDObject)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDString_StringProvider()
	 * @model
	 * @generated
	 */
	IDObject getStringProvider();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DString#getStringProvider <em>String Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Provider</em>' reference.
	 * @see #getStringProvider()
	 * @generated
	 */
	void setStringProvider(IDObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getString();

} // DString
