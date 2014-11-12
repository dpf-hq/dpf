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
 *   <li>{@link no.hib.dpf.text.tdpf.Specification#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Specification#getConstraintSemantic <em>Constraint Semantic</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Specification#getSequenceNumber <em>Sequence Number</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Specification#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.Specification#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends Model
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(ChoosenSpecification)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification_Type()
   * @model containment="true"
   * @generated
   */
  ChoosenSpecification getType();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Specification#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(ChoosenSpecification value);

  /**
   * Returns the value of the '<em><b>Constraint Semantic</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Semantic</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Semantic</em>' containment reference.
   * @see #setConstraintSemantic(ChoosenConstraintSemantic)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification_ConstraintSemantic()
   * @model containment="true"
   * @generated
   */
  ChoosenConstraintSemantic getConstraintSemantic();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Specification#getConstraintSemantic <em>Constraint Semantic</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint Semantic</em>' containment reference.
   * @see #getConstraintSemantic()
   * @generated
   */
  void setConstraintSemantic(ChoosenConstraintSemantic value);

  /**
   * Returns the value of the '<em><b>Sequence Number</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Number</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Number</em>' containment reference.
   * @see #setSequenceNumber(SequenceNumber)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification_SequenceNumber()
   * @model containment="true"
   * @generated
   */
  SequenceNumber getSequenceNumber();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Specification#getSequenceNumber <em>Sequence Number</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Number</em>' containment reference.
   * @see #getSequenceNumber()
   * @generated
   */
  void setSequenceNumber(SequenceNumber value);

  /**
   * Returns the value of the '<em><b>Graph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Graph</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Graph</em>' containment reference.
   * @see #setGraph(Graph)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getSpecification_Graph()
   * @model containment="true"
   * @generated
   */
  Graph getGraph();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.Specification#getGraph <em>Graph</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Graph</em>' containment reference.
   * @see #getGraph()
   * @generated
   */
  void setGraph(Graph value);

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
