/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.visualization;

import no.hib.dpf.diagram.DNode;
import no.hib.dpf.visual.VElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VCompartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.visualization.VCompartment#getParent <em>Parent</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.VCompartment#getCompartmentDNode <em>Compartment DNode</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.VCompartment#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.visualization.VisualizationPackage#getVCompartment()
 * @model
 * @generated
 */
public interface VCompartment extends VElement {
	
	
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(DNode)
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVCompartment_Parent()
	 * @model
	 * @generated
	 */
	DNode getParent();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visualization.VCompartment#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(DNode value);

	/**
	 * Returns the value of the '<em><b>Compartment DNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartment DNode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartment DNode</em>' reference.
	 * @see #setCompartmentDNode(DNode)
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVCompartment_CompartmentDNode()
	 * @model
	 * @generated
	 */
	DNode getCompartmentDNode();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visualization.VCompartment#getCompartmentDNode <em>Compartment DNode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compartment DNode</em>' reference.
	 * @see #getCompartmentDNode()
	 * @generated
	 */
	void setCompartmentDNode(DNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.visualization.VCompartmentElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVCompartment_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<VCompartmentElement> getChildren();
	
	void addChild(VCompartmentElement child);

} // VCompartment
