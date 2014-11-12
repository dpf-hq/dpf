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
 *   <li>{@link no.hib.dpf.diagram.DPredicate#getDGraph <em>DGraph</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DPredicate#getVisualization <em>Visualization</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DPredicate#getIcon <em>Icon</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DPredicate#getSimpleName <em>Simple Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDPredicate()
 * @model
 * @generated
 */
public interface DPredicate extends EObject {
	/**
	 * Returns the value of the '<em><b>DGraph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DGraph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DGraph</em>' containment reference.
	 * @see #setDGraph(DGraph)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDPredicate_DGraph()
	 * @model containment="true"
	 * @generated
	 */
	DGraph getDGraph();

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDPredicate_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

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
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDPredicate_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Returns the value of the '<em><b>Visualization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visualization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visualization</em>' containment reference.
	 * @see #setVisualization(Visualization)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDPredicate_Visualization()
	 * @model containment="true"
	 * @generated
	 */
	Visualization getVisualization();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DPredicate#getDGraph <em>DGraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DGraph</em>' containment reference.
	 * @see #getDGraph()
	 * @generated
	 */
	void setDGraph(DGraph value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DPredicate#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DPredicate#getPredicate <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DPredicate#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DPredicate#getVisualization <em>Visualization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visualization</em>' containment reference.
	 * @see #getVisualization()
	 * @generated
	 */
	void setVisualization(Visualization value);

} // DPredicate
