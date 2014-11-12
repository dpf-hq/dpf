/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.SequenceNumber#getNextNumber <em>Next Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getSequenceNumber()
 * @model
 * @generated
 */
public interface SequenceNumber extends EObject
{
  /**
   * Returns the value of the '<em><b>Next Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Next Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Next Number</em>' attribute.
   * @see #setNextNumber(int)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSequenceNumber_NextNumber()
   * @model
   * @generated
   */
  int getNextNumber();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.SequenceNumber#getNextNumber <em>Next Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Next Number</em>' attribute.
   * @see #getNextNumber()
   * @generated
   */
  void setNextNumber(int value);

} // SequenceNumber
