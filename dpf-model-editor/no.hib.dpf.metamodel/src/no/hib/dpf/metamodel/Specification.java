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
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Specification#getSignature <em>Signature</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Specification#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Specification#getTypeGraph <em>Type Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends EObject {
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
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getSpecification_Signature()
	 * @model required="true"
	 * @generated
	 */
	Signature getSignature();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Specification#getSignature <em>Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' reference.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(Signature value);

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' reference.
	 * @see #setGraph(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getSpecification_Graph()
	 * @model required="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Specification#getGraph <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Type Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Graph</em>' reference.
	 * @see #setTypeGraph(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getSpecification_TypeGraph()
	 * @model required="true"
	 * @generated
	 */
	Graph getTypeGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Specification#getTypeGraph <em>Type Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Graph</em>' reference.
	 * @see #getTypeGraph()
	 * @generated
	 */
	void setTypeGraph(Graph value);

} // Specification
