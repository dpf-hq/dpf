/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.Signature#getConstraintSemantics <em>Constraint Semantics</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getSignature()
 * @model
 * @generated
 */
public interface Signature extends Model
{
  /**
   * Returns the value of the '<em><b>Constraint Semantics</b></em>' containment reference list.
   * The list contents are of type {@link no.hib.dpf.text.tdpf.ConstraintSemantic}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Semantics</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Semantics</em>' containment reference list.
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSignature_ConstraintSemantics()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintSemantic> getConstraintSemantics();

} // Signature
