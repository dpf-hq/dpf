/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.IDObject;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visualization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.Visualization#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.Visualization#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.Visualization#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getVisualization()
 * @model
 * @generated
 */
public interface Visualization extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link no.hib.dpf.diagram.VisualizationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see no.hib.dpf.diagram.VisualizationType
	 * @see #setType(VisualizationType)
	 * @see no.hib.dpf.diagram.DiagramPackage#getVisualization_Type()
	 * @model
	 * @generated
	 */
	VisualizationType getType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.Visualization#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see no.hib.dpf.diagram.VisualizationType
	 * @see #getType()
	 * @generated
	 */
	void setType(VisualizationType value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(IDObject)
	 * @see no.hib.dpf.diagram.DiagramPackage#getVisualization_Source()
	 * @model
	 * @generated
	 */
	IDObject getSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.Visualization#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(IDObject value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(IDObject)
	 * @see no.hib.dpf.diagram.DiagramPackage#getVisualization_Target()
	 * @model
	 * @generated
	 */
	IDObject getTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.Visualization#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(IDObject value);

} // Visualization
