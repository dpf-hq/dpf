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
 * A representation of the model object '<em><b>Typing Morphism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.TypingMorphism#getModel <em>Model</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.TypingMorphism#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getTypingMorphism()
 * @model
 * @generated
 */
public interface TypingMorphism extends EObject {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getTypingMorphism_Model()
	 * @model required="true"
	 * @generated
	 */
	Graph getModel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.TypingMorphism#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Graph value);

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getTypingMorphism_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	Graph getMetamodel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.TypingMorphism#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(Graph value);

} // TypingMorphism
