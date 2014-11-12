/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFake Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DFakeNode#getDConstraint <em>DConstraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDFakeNode()
 * @model
 * @generated
 */
public interface DFakeNode extends DNode {
	/**
	 * Returns the value of the '<em><b>DConstraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DConstraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DConstraint</em>' reference.
	 * @see #setDConstraint(DConstraint)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDFakeNode_DConstraint()
	 * @model
	 * @generated
	 */
	DConstraint getDConstraint();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DFakeNode#getDConstraint <em>DConstraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DConstraint</em>' reference.
	 * @see #getDConstraint()
	 * @generated
	 */
	void setDConstraint(DConstraint value);

} // DFakeNode
