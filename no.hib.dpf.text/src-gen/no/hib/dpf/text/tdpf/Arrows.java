/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrows</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.Arrows#getSr <em>Sr</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Arrows#getNext <em>Next</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getArrows()
 * @model
 * @generated
 */
public interface Arrows extends Element
{
  /**
   * Returns the value of the '<em><b>Sr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sr</em>' containment reference.
   * @see #setSr(Node)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getArrows_Sr()
   * @model containment="true"
   * @generated
   */
  Node getSr();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Arrows#getSr <em>Sr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sr</em>' containment reference.
   * @see #getSr()
   * @generated
   */
  void setSr(Node value);

  /**
   * Returns the value of the '<em><b>Next</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Next</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Next</em>' containment reference.
   * @see #setNext(Arrows)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getArrows_Next()
   * @model containment="true"
   * @generated
   */
  Arrows getNext();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Arrows#getNext <em>Next</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Next</em>' containment reference.
   * @see #getNext()
   * @generated
   */
  void setNext(Arrows value);

} // Arrows
