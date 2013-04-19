/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DComposed Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DComposedConstraint#getChildren <em>Children</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DComposedConstraint#getFakeNode <em>Fake Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDComposedConstraint()
 * @model
 * @generated
 */
public interface DComposedConstraint extends DConstraint {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDComposedConstraint_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<DConstraint> getChildren();

	/**
	 * Returns the value of the '<em><b>Fake Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fake Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fake Node</em>' reference.
	 * @see #setFakeNode(DConstraintNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDComposedConstraint_FakeNode()
	 * @model
	 * @generated
	 */
	DConstraintNode getFakeNode();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DComposedConstraint#getFakeNode <em>Fake Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fake Node</em>' reference.
	 * @see #getFakeNode()
	 * @generated
	 */
	void setFakeNode(DConstraintNode value);

} // DComposedConstraint
