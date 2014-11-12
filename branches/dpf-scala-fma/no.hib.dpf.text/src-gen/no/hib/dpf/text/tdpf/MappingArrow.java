/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Arrow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.MappingArrow#getDomain <em>Domain</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.MappingArrow#getCodmain <em>Codmain</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getMappingArrow()
 * @model
 * @generated
 */
public interface MappingArrow extends Mapping
{
  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference.
   * @see #setDomain(Arrow)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getMappingArrow_Domain()
   * @model containment="true"
   * @generated
   */
  Arrow getDomain();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.MappingArrow#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Arrow value);

  /**
   * Returns the value of the '<em><b>Codmain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Codmain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Codmain</em>' containment reference.
   * @see #setCodmain(Arrow)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getMappingArrow_Codmain()
   * @model containment="true"
   * @generated
   */
  Arrow getCodmain();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.MappingArrow#getCodmain <em>Codmain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Codmain</em>' containment reference.
   * @see #getCodmain()
   * @generated
   */
  void setCodmain(Arrow value);

} // MappingArrow
