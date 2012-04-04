/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DGeneric Arrow Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DGenericArrowConstraint#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DGenericArrowConstraint#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDGenericArrowConstraint()
 * @model
 * @generated
 */
public interface DGenericArrowConstraint extends DConstraint {
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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGenericArrowConstraint_Source()
	 * @model
	 * @generated
	 */
	DElement getSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DGenericArrowConstraint#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(DElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(DElement)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGenericArrowConstraint_Target()
	 * @model
	 * @generated
	 */
	DElement getTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DGenericArrowConstraint#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(DElement value);


	void setDSource(DElement object);
	void setDTarget(DElement object);

} // DGenericArrowConstraint
