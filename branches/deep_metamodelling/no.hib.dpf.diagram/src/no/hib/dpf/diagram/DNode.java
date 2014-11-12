/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.Node;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DNode#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNode#getNode <em>Node</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNode#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNode#getDOutgoings <em>DOutgoings</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNode#getDIncomings <em>DIncomings</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNode#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNode#getLocation <em>Location</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNode#getSize <em>Size</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNode#getDOutgoingAttributes <em>DOutgoing Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDNode()
 * @model
 * @generated
 */
public interface DNode extends DElement {
	
	public static final Dimension DEFAULT_DIMENSION = new Dimension(100, 30);
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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_ConfigureString()
	 * @model
	 * @generated
	 */
	String getConfigureString();

	/**
	 * Returns the value of the '<em><b>DConstraints</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DConstraint}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DConstraint#getDNodes <em>DNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DConstraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DConstraints</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_DConstraints()
	 * @see no.hib.dpf.diagram.DConstraint#getDNodes
	 * @model opposite="dNodes"
	 * @generated
	 */
	EList<DConstraint> getDConstraints();

	DGraph getDGraph();

	/**
	 * Returns the value of the '<em><b>DIncomings</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrow}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DArrow#getDTarget <em>DTarget</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DIncomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DIncomings</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_DIncomings()
	 * @see no.hib.dpf.diagram.DArrow#getDTarget
	 * @model opposite="dTarget"
	 * @generated
	 */
	EList<DArrow> getDIncomings();

	/**
	 * Returns the value of the '<em><b>DOutgoings</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrow}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DArrow#getDSource <em>DSource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DOutgoings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DOutgoings</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_DOutgoings()
	 * @see no.hib.dpf.diagram.DArrow#getDSource
	 * @model opposite="dSource"
	 * @generated
	 */
	EList<DArrow> getDOutgoings();

	/**
	 * Returns the value of the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DType</em>' reference.
	 * @see #setDType(DNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_DType()
	 * @model required="true"
	 * @generated
	 */
	DNode getDType();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(Point)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_Location()
	 * @model dataType="no.hib.dpf.diagram.ELocation"
	 * @generated
	 */
	Point getLocation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Node)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_Node()
	 * @model required="true"
	 * @generated
	 */
	Node getNode();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(Dimension)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_Size()
	 * @model dataType="no.hib.dpf.diagram.EDimension"
	 * @generated
	 */
	Dimension getSize();

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
	DNode getTemplateDNode();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNode#getConfigureString <em>Configure String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configure String</em>' attribute.
	 * @see #getConfigureString()
	 * @generated
	 */
	void setConfigureString(String value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNode#getDType <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DType</em>' reference.
	 * @see #getDType()
	 * @generated
	 */
	void setDType(DNode value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNode#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Point value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNode#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Node value);

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNode#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Dimension value);

	/**
	 * Returns the value of the '<em><b>DOutgoing Attributes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNodeDAttribute}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DNodeDAttribute#getDSource <em>DSource</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DOutgoing Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DOutgoing Attributes</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNode_DOutgoingAttributes()
	 * @see no.hib.dpf.diagram.DNodeDAttribute#getDSource
	 * @model opposite="dSource"
	 * @generated
	 */
	EList<DNodeDAttribute> getDOutgoingAttributes();

} // DNode
