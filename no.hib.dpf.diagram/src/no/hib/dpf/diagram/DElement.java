/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.IDObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DElement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DElement#getConstraintsFrom <em>Constraints From</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DElement#getConstraintsTo <em>Constraints To</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDElement()
 * @model
 * @generated
 */
public interface DElement extends IDObject {
	/**
	 * Returns the value of the '<em><b>Constraints From</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints From</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDElement_ConstraintsFrom()
	 * @model
	 * @generated
	 */
	EList<DConstraint> getConstraintsFrom();

	/**
	 * Returns the value of the '<em><b>Constraints To</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints To</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDElement_ConstraintsTo()
	 * @model
	 * @generated
	 */
	EList<DConstraint> getConstraintsTo();

} // DElement
