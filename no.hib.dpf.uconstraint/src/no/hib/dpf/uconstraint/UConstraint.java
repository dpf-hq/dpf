/**
 */
package no.hib.dpf.uconstraint;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UConstraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getSum <em>Sum</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getLeftNodes <em>Left Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getRightNodes <em>Right Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getRightArrows <em>Right Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getLeftArrows <em>Left Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getCommonNodes <em>Common Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getCommonArrows <em>Common Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.UConstraint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint()
 * @model
 * @generated
 */
public interface UConstraint extends EObject {
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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_Sum()
	 * @model containment="true"
	 * @generated
	 */
	DSpecification getSum();

	/**
	 * Sets the value of the '{@link no.hib.dpf.uconstraint.UConstraint#getSum <em>Sum</em>}' containment reference.
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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_LeftNodes()
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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_RightNodes()
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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_RightArrows()
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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_LeftArrows()
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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_CommonNodes()
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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_CommonArrows()
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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link no.hib.dpf.uconstraint.UConstraint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link no.hib.dpf.uconstraint.UCType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see no.hib.dpf.uconstraint.UCType
	 * @see #setType(UCType)
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getUConstraint_Type()
	 * @model required="true"
	 * @generated
	 */
	UCType getType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.uconstraint.UConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see no.hib.dpf.uconstraint.UCType
	 * @see #getType()
	 * @generated
	 */
	void setType(UCType value);
	
	void setAdded(DNode node);
	boolean isAdded(DNode node);
	void setDeled(DNode node);
	boolean isDeled(DNode node);
	void setKept(DNode node, boolean is);
	boolean isKept(DNode node);
	
	void setAdded(DArrow arrow);
	boolean isAdded(DArrow arrow);
	void setDeled(DArrow arrow);
	boolean isDeled(DArrow arrow);
	void setKept(DArrow arrow, boolean is);
	boolean isKept(DArrow arrow);

} // UConstraint
