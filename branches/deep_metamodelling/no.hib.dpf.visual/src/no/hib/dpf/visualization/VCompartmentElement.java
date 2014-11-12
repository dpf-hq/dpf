/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.visualization;

import no.hib.dpf.diagram.DNode;
import no.hib.dpf.visual.VElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VCompartment Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.visualization.VCompartmentElement#getDNode <em>DNode</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.visualization.VisualizationPackage#getVCompartmentElement()
 * @model
 * @generated
 */
public interface VCompartmentElement extends VElement {
	/**
	 * Returns the value of the '<em><b>DNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DNode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DNode</em>' reference.
	 * @see #setDNode(DNode)
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVCompartmentElement_DNode()
	 * @model
	 * @generated
	 */
	DNode getDNode();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visualization.VCompartmentElement#getDNode <em>DNode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DNode</em>' reference.
	 * @see #getDNode()
	 * @generated
	 */
	void setDNode(DNode value);

} // VCompartmentElement
