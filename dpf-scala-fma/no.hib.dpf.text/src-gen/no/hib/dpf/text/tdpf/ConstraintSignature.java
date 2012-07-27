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
 * A representation of the model object '<em><b>Constraint Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.ConstraintSignature#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.ConstraintSignature#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraintSignature()
 * @model
 * @generated
 */
public interface ConstraintSignature extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' containment reference.
   * @see #setId(DpfId)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraintSignature_Id()
   * @model containment="true"
   * @generated
   */
  DpfId getId();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.ConstraintSignature#getId <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' containment reference.
   * @see #getId()
   * @generated
   */
  void setId(DpfId value);

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' attribute list.
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraintSignature_Parameter()
   * @model unique="false"
   * @generated
   */
  EList<String> getParameter();

} // ConstraintSignature
