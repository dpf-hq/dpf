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
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Predicate#getShape <em>Shape</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Predicate#getSemantics <em>Semantics</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Predicate#getVisualization <em>Visualization</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate()
 * @model
 * @generated
 */
public interface Predicate extends EObject {
	/**
	 * Returns the value of the '<em><b>Shape</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape</em>' reference.
	 * @see #setShape(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate_Shape()
	 * @model
	 * @generated
	 */
	Graph getShape();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Predicate#getShape <em>Shape</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape</em>' reference.
	 * @see #getShape()
	 * @generated
	 */
	void setShape(Graph value);

	/**
	 * Returns the value of the '<em><b>Semantics</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantics</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantics</em>' reference.
	 * @see #setSemantics(Semantics)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate_Semantics()
	 * @model
	 * @generated
	 */
	Semantics getSemantics();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Predicate#getSemantics <em>Semantics</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantics</em>' reference.
	 * @see #getSemantics()
	 * @generated
	 */
	void setSemantics(Semantics value);

	/**
	 * Returns the value of the '<em><b>Visualization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visualization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visualization</em>' reference.
	 * @see #setVisualization(Visualization)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate_Visualization()
	 * @model
	 * @generated
	 */
	Visualization getVisualization();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Predicate#getVisualization <em>Visualization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visualization</em>' reference.
	 * @see #getVisualization()
	 * @generated
	 */
	void setVisualization(Visualization value);

} // Predicate
