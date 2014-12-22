/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.Arrow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DArrow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getArrow <em>Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getLineStyle <em>Line Style</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getDSource <em>DSource</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getDTarget <em>DTarget</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getNameOffset <em>Name Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrow#getBendpoints <em>Bendpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow()
 * @model
 * @generated
 */
public interface DArrow extends DElement {
	/**
	 * Returns the value of the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DType</em>' reference.
	 * @see #setDType(DArrow)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_DType()
	 * @model required="true"
	 * @generated
	 */
	DArrow getDType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrow#getDType <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DType</em>' reference.
	 * @see #getDType()
	 * @generated
	 */
	void setDType(DArrow value);

	/**
	 * Returns the value of the '<em><b>Arrow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrow</em>' reference.
	 * @see #setArrow(Arrow)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_Arrow()
	 * @model required="true"
	 * @generated
	 */
	Arrow getArrow();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrow#getArrow <em>Arrow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrow</em>' reference.
	 * @see #getArrow()
	 * @generated
	 */
	void setArrow(Arrow value);

	/**
	 * Returns the value of the '<em><b>Configure String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configure String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configure String</em>' attribute.
	 * @see #setConfigureString(String)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_ConfigureString()
	 * @model
	 * @generated
	 */
	String getConfigureString();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrow#getConfigureString <em>Configure String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configure String</em>' attribute.
	 * @see #getConfigureString()
	 * @generated
	 */
	void setConfigureString(String value);

	/**
	 * Returns the value of the '<em><b>Line Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Style</em>' attribute.
	 * @see #setLineStyle(int)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_LineStyle()
	 * @model required="true"
	 * @generated
	 */
	int getLineStyle();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrow#getLineStyle <em>Line Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Style</em>' attribute.
	 * @see #getLineStyle()
	 * @generated
	 */
	void setLineStyle(int value);

	/**
	 * Returns the value of the '<em><b>DSource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DNode#getDOutgoings <em>DOutgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSource</em>' reference.
	 * @see #setDSource(DNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_DSource()
	 * @see no.hib.dpf.diagram.DNode#getDOutgoings
	 * @model opposite="dOutgoings" required="true"
	 * @generated
	 */
	DNode getDSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrow#getDSource <em>DSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DSource</em>' reference.
	 * @see #getDSource()
	 * @generated
	 */
	void setDSource(DNode value);

	/**
	 * Returns the value of the '<em><b>DTarget</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DNode#getDIncomings <em>DIncomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DTarget</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DTarget</em>' reference.
	 * @see #setDTarget(DNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_DTarget()
	 * @see no.hib.dpf.diagram.DNode#getDIncomings
	 * @model opposite="dIncomings" required="true"
	 * @generated
	 */
	DNode getDTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrow#getDTarget <em>DTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DTarget</em>' reference.
	 * @see #getDTarget()
	 * @generated
	 */
	void setDTarget(DNode value);

	/**
	 * Returns the value of the '<em><b>DConstraints</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DConstraint}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DConstraint#getDArrows <em>DArrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DConstraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DConstraints</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_DConstraints()
	 * @see no.hib.dpf.diagram.DConstraint#getDArrows
	 * @model opposite="dArrows"
	 * @generated
	 */
	EList<DConstraint> getDConstraints();

	/**
	 * Returns the value of the '<em><b>Bendpoints</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DOffset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bendpoints</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bendpoints</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_Bendpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<DOffset> getBendpoints();

	/**
	 * Returns the value of the '<em><b>Name Offset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Offset</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Offset</em>' containment reference.
	 * @see #setNameOffset(DOffset)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrow_NameOffset()
	 * @model containment="true"
	 * @generated
	 */
	DOffset getNameOffset();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrow#getNameOffset <em>Name Offset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Offset</em>' containment reference.
	 * @see #getNameOffset()
	 * @generated
	 */
	void setNameOffset(DOffset value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void reconnect(DNode source, DNode target);

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
	 * @model kind="operation"
	 * @generated
	 */
	String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getTypeName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DArrow getTemplateDArrow();

} // DArrow
