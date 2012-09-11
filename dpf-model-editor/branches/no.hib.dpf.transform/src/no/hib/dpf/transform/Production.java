/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Production</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.Production#getSum <em>Sum</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Production#getLeftNodes <em>Left Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Production#getRightNodes <em>Right Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Production#getRightArrows <em>Right Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Production#getLeftArrows <em>Left Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Production#getCommonNodes <em>Common Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Production#getCommonArrows <em>Common Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Production#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.transform.TransformPackage#getProduction()
 * @model
 * @generated
 */
public interface Production extends EObject {
	/**
	 * Returns the value of the '<em><b>Sum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sum</em>' containment reference.
	 * @see #setSum(DSpecification)
	 * @see no.hib.dpf.transform.TransformPackage#getProduction_Sum()
	 * @model containment="true"
	 * @generated
	 */
	DSpecification getSum();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Production#getSum <em>Sum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sum</em>' containment reference.
	 * @see #getSum()
	 * @generated
	 */
	void setSum(DSpecification value);

	/**
	 * Returns the value of the '<em><b>Left Nodes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Nodes</em>' reference list.
	 * @see no.hib.dpf.transform.TransformPackage#getProduction_LeftNodes()
	 * @model
	 * @generated
	 */
	EList<DNode> getLeftNodes();

	/**
	 * Returns the value of the '<em><b>Right Nodes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Nodes</em>' reference list.
	 * @see no.hib.dpf.transform.TransformPackage#getProduction_RightNodes()
	 * @model
	 * @generated
	 */
	EList<DNode> getRightNodes();

	/**
	 * Returns the value of the '<em><b>Right Arrows</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Arrows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Arrows</em>' reference list.
	 * @see no.hib.dpf.transform.TransformPackage#getProduction_RightArrows()
	 * @model
	 * @generated
	 */
	EList<DArrow> getRightArrows();

	/**
	 * Returns the value of the '<em><b>Left Arrows</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Arrows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Arrows</em>' reference list.
	 * @see no.hib.dpf.transform.TransformPackage#getProduction_LeftArrows()
	 * @model
	 * @generated
	 */
	EList<DArrow> getLeftArrows();

	/**
	 * Returns the value of the '<em><b>Common Nodes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Common Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Common Nodes</em>' reference list.
	 * @see no.hib.dpf.transform.TransformPackage#getProduction_CommonNodes()
	 * @model
	 * @generated
	 */
	EList<DNode> getCommonNodes();

	/**
	 * Returns the value of the '<em><b>Common Arrows</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Common Arrows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Common Arrows</em>' reference list.
	 * @see no.hib.dpf.transform.TransformPackage#getProduction_CommonArrows()
	 * @model
	 * @generated
	 */
	EList<DArrow> getCommonArrows();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see no.hib.dpf.transform.TransformPackage#getProduction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Production#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Production
