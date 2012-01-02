/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.Predicate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DPredicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DPredicate#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDPredicate()
 * @model
 * @generated
 */
public interface DPredicate extends EObject {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' reference.
	 * @see #setPredicate(Predicate)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDPredicate_Predicate()
	 * @model
	 * @generated
	 */
	Predicate getPredicate();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DPredicate#getPredicate <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);

} // DPredicate
