/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Constraint#getConstrainedModel <em>Constrained Model</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Constraint#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Constraint#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends IDObject {
	/**
	 * Returns the value of the '<em><b>Constrained Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Model</em>' reference.
	 * @see #setConstrainedModel(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getConstraint_ConstrainedModel()
	 * @model required="true"
	 * @generated
	 */
	Graph getConstrainedModel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Constraint#getConstrainedModel <em>Constrained Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constrained Model</em>' reference.
	 * @see #getConstrainedModel()
	 * @generated
	 */
	void setConstrainedModel(Graph value);

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
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getConstraint_Predicate()
	 * @model
	 * @generated
	 */
	Predicate getPredicate();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Constraint#getPredicate <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' reference.
	 * @see #setMappings(GraphHomomorphism)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getConstraint_Mappings()
	 * @model
	 * @generated
	 */
	GraphHomomorphism getMappings();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Constraint#getMappings <em>Mappings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mappings</em>' reference.
	 * @see #getMappings()
	 * @generated
	 */
	void setMappings(GraphHomomorphism value);

} // Constraint
