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
 * A representation of the model object '<em><b>Constraint Semantic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.ConstraintSemantic#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.ConstraintSemantic#getArrows <em>Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.ConstraintSemantic#getOcl <em>Ocl</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraintSemantic()
 * @model
 * @generated
 */
public interface ConstraintSemantic extends EObject
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
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraintSemantic_Id()
   * @model containment="true"
   * @generated
   */
  DpfId getId();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.ConstraintSemantic#getId <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' containment reference.
   * @see #getId()
   * @generated
   */
  void setId(DpfId value);

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
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraintSemantic_Arrows()
   * @model containment="true"
   * @generated
   */
  EList<Arrows> getArrows();

  /**
   * Returns the value of the '<em><b>Ocl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ocl</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ocl</em>' attribute.
   * @see #setOcl(String)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getConstraintSemantic_Ocl()
   * @model
   * @generated
   */
  String getOcl();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.ConstraintSemantic#getOcl <em>Ocl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ocl</em>' attribute.
   * @see #getOcl()
   * @generated
   */
  void setOcl(String value);

} // ConstraintSemantic
