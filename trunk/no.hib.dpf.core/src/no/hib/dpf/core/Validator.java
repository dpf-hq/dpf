/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Validator#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.core.Validator#getValidatorText <em>Validator Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getValidator()
 * @model
 * @generated
 */
public interface Validator extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link no.hib.dpf.core.ValidatorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see no.hib.dpf.core.ValidatorType
	 * @see #setType(ValidatorType)
	 * @see no.hib.dpf.core.CorePackage#getValidator_Type()
	 * @model
	 * @generated
	 */
	ValidatorType getType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Validator#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see no.hib.dpf.core.ValidatorType
	 * @see #getType()
	 * @generated
	 */
	void setType(ValidatorType value);

	/**
	 * Returns the value of the '<em><b>Validator Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validator Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validator Text</em>' attribute.
	 * @see #setValidatorText(String)
	 * @see no.hib.dpf.core.CorePackage#getValidator_ValidatorText()
	 * @model
	 * @generated
	 */
	String getValidatorText();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Validator#getValidatorText <em>Validator Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validator Text</em>' attribute.
	 * @see #getValidatorText()
	 * @generated
	 */
	void setValidatorText(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model constraintParametersMany="true" typeNodesMany="true" typeArrowsMany="true" stuckedNodesMany="true" stuckedArrowsMany="true"
	 * @generated
	 */
	Boolean validateSemantics(EList<String> constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows, EList<Node> stuckedNodes, EList<Arrow> stuckedArrows);

} // Validator
