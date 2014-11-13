/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.Signature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSignature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DSignature#getSignature <em>Signature</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DSignature#getDPredicates <em>DPredicates</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDSignature()
 * @model
 * @generated
 */
public interface DSignature extends EObject {
	/**
	 * Returns the value of the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' reference.
	 * @see #setSignature(Signature)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSignature_Signature()
	 * @model
	 * @generated
	 */
	Signature getSignature();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DSignature#getSignature <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' reference.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(Signature value);

	/**
	 * Returns the value of the '<em><b>DPredicates</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DPredicate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DPredicates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DPredicates</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDSignature_DPredicates()
	 * @model containment="true"
	 * @generated
	 */
	EList<DPredicate> getDPredicates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addDPredicate(DPredicate dPredicate);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeDPredicate(DPredicate dPredicate);

} // DSignature
