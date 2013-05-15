/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.visualization;

import no.hib.dpf.diagram.DNode;

import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;

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
	 * @see #setParent(VNode)
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVCompartment_Parent()
	 * @model
	 * @generated
	 */
	VNode getParent();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visualization.VCompartment#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(VNode value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNode}.
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
	EList<DNode> getChildren();
	
	void addChild(DNode child);

} // VCompartment
