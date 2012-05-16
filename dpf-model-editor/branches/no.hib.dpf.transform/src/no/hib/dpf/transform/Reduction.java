/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import no.hib.dpf.core.GraphHomomorphism;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reduction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.Reduction#getLeft <em>Left</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Reduction#getRight <em>Right</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Reduction#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.transform.TransformPackage#getReduction()
 * @model
 * @generated
 */
public interface Reduction extends EObject {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(ExSpecification)
	 * @see no.hib.dpf.transform.TransformPackage#getReduction_Left()
	 * @model containment="true"
	 * @generated
	 */
	ExSpecification getLeft();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Reduction#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(ExSpecification value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(ExSpecification)
	 * @see no.hib.dpf.transform.TransformPackage#getReduction_Right()
	 * @model containment="true"
	 * @generated
	 */
	ExSpecification getRight();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Reduction#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(ExSpecification value);

	/**
	 * Returns the value of the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapping</em>' containment reference.
	 * @see #setMapping(GraphHomomorphism)
	 * @see no.hib.dpf.transform.TransformPackage#getReduction_Mapping()
	 * @model containment="true"
	 * @generated
	 */
	GraphHomomorphism getMapping();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Reduction#getMapping <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' containment reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(GraphHomomorphism value);

} // Reduction
