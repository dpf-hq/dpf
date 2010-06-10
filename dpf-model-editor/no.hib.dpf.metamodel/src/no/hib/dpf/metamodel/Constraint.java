/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Constraint#getConstrainedModelPart <em>Constrained Model Part</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Constraint#getPredicateShape <em>Predicate Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends GraphHomomorphism {
	/**
	 * Returns the value of the '<em><b>Constrained Model Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Model Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Model Part</em>' reference.
	 * @see #setConstrainedModelPart(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getConstraint_ConstrainedModelPart()
	 * @model required="true"
	 * @generated
	 */
	Graph getConstrainedModelPart();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Constraint#getConstrainedModelPart <em>Constrained Model Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constrained Model Part</em>' reference.
	 * @see #getConstrainedModelPart()
	 * @generated
	 */
	void setConstrainedModelPart(Graph value);

	/**
	 * Returns the value of the '<em><b>Predicate Shape</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate Shape</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate Shape</em>' reference.
	 * @see #setPredicateShape(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getConstraint_PredicateShape()
	 * @model required="true"
	 * @generated
	 */
	Graph getPredicateShape();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Constraint#getPredicateShape <em>Predicate Shape</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate Shape</em>' reference.
	 * @see #getPredicateShape()
	 * @generated
	 */
	void setPredicateShape(Graph value);

} // Constraint
