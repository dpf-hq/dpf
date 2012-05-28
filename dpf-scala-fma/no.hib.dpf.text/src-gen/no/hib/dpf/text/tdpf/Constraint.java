/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.Constraint#getSignature <em>Signature</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Constraint#getArrows <em>Arrows</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject
{
  /**
   * Returns the value of the '<em><b>Signature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Signature</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Signature</em>' containment reference.
   * @see #setSignature(ConstraintSignature)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraint_Signature()
   * @model containment="true"
   * @generated
   */
  ConstraintSignature getSignature();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Constraint#getSignature <em>Signature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Signature</em>' containment reference.
   * @see #getSignature()
   * @generated
   */
  void setSignature(ConstraintSignature value);

  /**
   * Returns the value of the '<em><b>Arrows</b></em>' containment reference list.
   * The list contents are of type {@link no.hib.dpf.text.tdpf.Arrows}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arrows</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arrows</em>' containment reference list.
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraint_Arrows()
   * @model containment="true"
   * @generated
   */
  EList<Arrows> getArrows();

} // Constraint
