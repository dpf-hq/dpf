/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.Specification#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Specification#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Specification#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends Definition
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Specification#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Graph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Graph</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Graph</em>' containment reference.
   * @see #setGraph(ChoosenGraph)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification_Graph()
   * @model containment="true"
   * @generated
   */
  ChoosenGraph getGraph();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Specification#getGraph <em>Graph</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Graph</em>' containment reference.
   * @see #getGraph()
   * @generated
   */
  void setGraph(ChoosenGraph value);

  /**
   * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
   * The list contents are of type {@link no.hib.dpf.text.tdpf.Constraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' containment reference list.
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification_Constraints()
   * @model containment="true"
   * @generated
   */
  EList<Constraint> getConstraints();

} // Specification
