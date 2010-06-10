/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typing Morphism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.TypingMorphism#getTheModel <em>The Model</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.TypingMorphism#getTheMetamodel <em>The Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getTypingMorphism()
 * @model
 * @generated
 */
public interface TypingMorphism extends GraphHomomorphism {
	/**
	 * Returns the value of the '<em><b>The Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Model</em>' reference.
	 * @see #setTheModel(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getTypingMorphism_TheModel()
	 * @model required="true"
	 * @generated
	 */
	Graph getTheModel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.TypingMorphism#getTheModel <em>The Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Model</em>' reference.
	 * @see #getTheModel()
	 * @generated
	 */
	void setTheModel(Graph value);

	/**
	 * Returns the value of the '<em><b>The Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Metamodel</em>' reference.
	 * @see #setTheMetamodel(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getTypingMorphism_TheMetamodel()
	 * @model required="true"
	 * @generated
	 */
	Graph getTheMetamodel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.TypingMorphism#getTheMetamodel <em>The Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>The Metamodel</em>' reference.
	 * @see #getTheMetamodel()
	 * @generated
	 */
	void setTheMetamodel(Graph value);

} // TypingMorphism
