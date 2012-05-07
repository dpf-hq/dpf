/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DArrow Label Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DArrowLabelConstraint#getOffset <em>Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowLabelConstraint#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowLabelConstraint()
 * @model
 * @generated
 */
public interface DArrowLabelConstraint extends DConstraint {
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' containment reference.
	 * @see #setOffset(DOffset)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowLabelConstraint_Offset()
	 * @model containment="true"
	 * @generated
	 */
	DOffset getOffset();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(DElement)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowLabelConstraint_Source()
	 * @model
	 * @generated
	 */
	DElement getSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowLabelConstraint#getOffset <em>Offset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' containment reference.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(DOffset value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowLabelConstraint#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(DElement value);

} // DArrowLabelConstraint
