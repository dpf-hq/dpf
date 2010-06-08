/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Signature#getPredicates <em>Predicates</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getSignature()
 * @model
 * @generated
 */
public interface Signature extends EObject {
	/**
	 * Returns the value of the '<em><b>Predicates</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.metamodel.Predicate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicates</em>' containment reference list.
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getSignature_Predicates()
	 * @model containment="true"
	 * @generated
	 */
	EList<Predicate> getPredicates();

} // Signature
