/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.InstanceSpecification#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.InstanceSpecification#getModel <em>Model</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.InstanceSpecification#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.InstanceSpecification#getConstraintSemantics <em>Constraint Semantics</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getInstanceSpecification()
 * @model
 * @generated
 */
public interface InstanceSpecification extends Definition
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
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getInstanceSpecification_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.InstanceSpecification#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' containment reference.
   * @see #setModel(ChoosenSpecfication)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getInstanceSpecification_Model()
   * @model containment="true"
   * @generated
   */
  ChoosenSpecfication getModel();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.InstanceSpecification#getModel <em>Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' containment reference.
   * @see #getModel()
   * @generated
   */
  void setModel(ChoosenSpecfication value);

  /**
   * Returns the value of the '<em><b>Metamodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metamodel</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel</em>' containment reference.
   * @see #setMetamodel(ChoosenSpecfication)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getInstanceSpecification_Metamodel()
   * @model containment="true"
   * @generated
   */
  ChoosenSpecfication getMetamodel();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.InstanceSpecification#getMetamodel <em>Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel</em>' containment reference.
   * @see #getMetamodel()
   * @generated
   */
  void setMetamodel(ChoosenSpecfication value);

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
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getInstanceSpecification_ConstraintSemantics()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintSemantic> getConstraintSemantics();

} // InstanceSpecification
