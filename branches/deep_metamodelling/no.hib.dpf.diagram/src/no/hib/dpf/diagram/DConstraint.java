/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.Constraint;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DConstraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DConstraint#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DConstraint#getDNodes <em>DNodes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DConstraint#getDArrows <em>DArrows</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DConstraint#getDPredicate <em>DPredicate</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DConstraint#getDNodeDAttributes <em>DNode DAttributes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DConstraint#getDArrowDAttributes <em>DArrow DAttributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDConstraint()
 * @model
 * @generated
 */
public interface DConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' reference.
	 * @see #setConstraint(Constraint)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDConstraint_Constraint()
	 * @model
	 * @generated
	 */
	Constraint getConstraint();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DConstraint#getConstraint <em>Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint</em>' reference.
	 * @see #getConstraint()
	 * @generated
	 */
	void setConstraint(Constraint value);
/**
	 * Returns the value of the '<em><b>DNodes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNode}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DNode#getDConstraints <em>DConstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DNodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DNodes</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDConstraint_DNodes()
	 * @see no.hib.dpf.diagram.DNode#getDConstraints
	 * @model opposite="dConstraints"
	 * @generated
	 */
	EList<DNode> getDNodes();

	/**
	 * Returns the value of the '<em><b>DArrows</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrow}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DArrow#getDConstraints <em>DConstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DArrows</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DArrows</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDConstraint_DArrows()
	 * @see no.hib.dpf.diagram.DArrow#getDConstraints
	 * @model opposite="dConstraints"
	 * @generated
	 */
	EList<DArrow> getDArrows();
/**
	 * Returns the value of the '<em><b>DPredicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DPredicate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DPredicate</em>' reference.
	 * @see #setDPredicate(DPredicate)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDConstraint_DPredicate()
	 * @model
	 * @generated
	 */
	DPredicate getDPredicate();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DConstraint#getDPredicate <em>DPredicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DPredicate</em>' reference.
	 * @see #getDPredicate()
	 * @generated
	 */
	void setDPredicate(DPredicate value);

/**
	 * Returns the value of the '<em><b>DNode DAttributes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNodeDAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DNode DAttributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DNode DAttributes</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDConstraint_DNodeDAttributes()
	 * @model
	 * @generated
	 */
	EList<DNodeDAttribute> getDNodeDAttributes();

	/**
	 * Returns the value of the '<em><b>DArrow DAttributes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrowDAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DArrow DAttributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DArrow DAttributes</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDConstraint_DArrowDAttributes()
	 * @model
	 * @generated
	 */
	EList<DArrowDAttribute> getDArrowDAttributes();

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" arrowsMany="true"
	 * @generated
	 */
	void reconnect(EList<DNode> nodes, EList<DArrow> arrows, DSpecification specification);

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void disconnect();

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addDArrow(DArrow dArrow);

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addDNode(DNode dNode);
} // DConstraint
