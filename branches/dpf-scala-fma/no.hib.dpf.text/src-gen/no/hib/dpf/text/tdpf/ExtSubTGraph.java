/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ext Sub TGraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.ExtSubTGraph#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.ExtSubTGraph#getExtendsGraph <em>Extends Graph</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.ExtSubTGraph#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.text.tdpf.TdpfPackage#getExtSubTGraph()
 * @model
 * @generated
 */
public interface ExtSubTGraph extends Command
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
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getExtSubTGraph_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.ExtSubTGraph#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Extends Graph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends Graph</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends Graph</em>' containment reference.
   * @see #setExtendsGraph(ChoosenExtSubTGraph)
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getExtSubTGraph_ExtendsGraph()
   * @model containment="true"
   * @generated
   */
  ChoosenExtSubTGraph getExtendsGraph();

  /**
   * Sets the value of the '{@link no.hib.dpf.text.tdpf.ExtSubTGraph#getExtendsGraph <em>Extends Graph</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends Graph</em>' containment reference.
   * @see #getExtendsGraph()
   * @generated
   */
  void setExtendsGraph(ChoosenExtSubTGraph value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link no.hib.dpf.text.tdpf.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see no.hib.dpf.text.tdpf.TdpfPackage#getExtSubTGraph_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Element> getElements();

} // ExtSubTGraph
