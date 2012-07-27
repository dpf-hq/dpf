/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.MappingNode#getDomain <em>Domain</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.MappingNode#getCodomain <em>Codomain</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getMappingNode()
 * @model
 * @generated
 */
public interface MappingNode extends Mapping
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
   * @see #setDomain(Node)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getMappingNode_Domain()
   * @model containment="true"
   * @generated
   */
  Node getDomain();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.MappingNode#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Node value);

  /**
   * Returns the value of the '<em><b>Codomain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Codomain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Codomain</em>' containment reference.
   * @see #setCodomain(Node)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getMappingNode_Codomain()
   * @model containment="true"
   * @generated
   */
  Node getCodomain();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.MappingNode#getCodomain <em>Codomain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Codomain</em>' containment reference.
   * @see #getCodomain()
   * @generated
   */
  void setCodomain(Node value);

} // MappingNode
