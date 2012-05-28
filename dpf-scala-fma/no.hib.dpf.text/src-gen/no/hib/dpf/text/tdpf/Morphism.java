/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Morphism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.Morphism#getDomain <em>Domain</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Morphism#getCodmain <em>Codmain</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Morphism#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getMorphism()
 * @model
 * @generated
 */
public interface Morphism extends Definition
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
   * @see #setDomain(Domain)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getMorphism_Domain()
   * @model containment="true"
   * @generated
   */
  Domain getDomain();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Morphism#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Domain value);

  /**
   * Returns the value of the '<em><b>Codmain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Codmain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Codmain</em>' containment reference.
   * @see #setCodmain(Codomain)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getMorphism_Codmain()
   * @model containment="true"
   * @generated
   */
  Codomain getCodmain();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Morphism#getCodmain <em>Codmain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Codmain</em>' containment reference.
   * @see #getCodmain()
   * @generated
   */
  void setCodmain(Codomain value);

  /**
   * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
   * The list contents are of type {@link no.hib.dpf.text.tdpf.Mapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mappings</em>' containment reference list.
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getMorphism_Mappings()
   * @model containment="true"
   * @generated
   */
  EList<Mapping> getMappings();

} // Morphism
