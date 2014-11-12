/**
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.NodeAttribute;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DNode DAttribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getDSource <em>DSource</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getNodeAttribute <em>Node Attribute</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getLineStyle <em>Line Style</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getDTarget <em>DTarget</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getNameOffset <em>Name Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DNodeDAttribute#getBendpoints <em>Bendpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute()
 * @model
 * @generated
 */
public interface DNodeDAttribute extends DElement {
	/**
	 * Returns the value of the '<em><b>DSource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DNode#getDOutgoingAttributes <em>DOutgoing Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSource</em>' reference.
	 * @see #setDSource(DNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_DSource()
	 * @see no.hib.dpf.diagram.DNode#getDOutgoingAttributes
	 * @model opposite="dOutgoingAttributes" required="true"
	 * @generated
	 */
	DNode getDSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNodeDAttribute#getDSource <em>DSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DSource</em>' reference.
	 * @see #getDSource()
	 * @generated
	 */
	void setDSource(DNode value);

	/**
	 * Returns the value of the '<em><b>Node Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Attribute</em>' reference.
	 * @see #setNodeAttribute(NodeAttribute)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_NodeAttribute()
	 * @model required="true"
	 * @generated
	 */
	NodeAttribute getNodeAttribute();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNodeDAttribute#getNodeAttribute <em>Node Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Attribute</em>' reference.
	 * @see #getNodeAttribute()
	 * @generated
	 */
	void setNodeAttribute(NodeAttribute value);
	
	/**
	 * Returns the value of the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DType</em>' reference.
	 * @see #setDType(DNodeDAttribute)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_DType()
	 * @model required="true"
	 * @generated
	 */
	DNodeDAttribute getDType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNodeDAttribute#getDType <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DType</em>' reference.
	 * @see #getDType()
	 * @generated
	 */
	void setDType(DNodeDAttribute value);

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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_ConfigureString()
	 * @model
	 * @generated
	 */
	String getConfigureString();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNodeDAttribute#getConfigureString <em>Configure String</em>}' attribute.
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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_LineStyle()
	 * @model required="true"
	 * @generated
	 */
	int getLineStyle();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNodeDAttribute#getLineStyle <em>Line Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Style</em>' attribute.
	 * @see #getLineStyle()
	 * @generated
	 */
	void setLineStyle(int value);

	/**
	 * Returns the value of the '<em><b>DTarget</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DDataNode#getDIncomingDNodeDAttributes <em>DIncoming DNode DAttributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DTarget</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DTarget</em>' reference.
	 * @see #setDTarget(DDataNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_DTarget()
	 * @see no.hib.dpf.diagram.DDataNode#getDIncomingDNodeDAttributes
	 * @model opposite="dIncomingDNodeDAttributes" required="true"
	 * @generated
	 */
	DDataNode getDTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNodeDAttribute#getDTarget <em>DTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DTarget</em>' reference.
	 * @see #getDTarget()
	 * @generated
	 */
	void setDTarget(DDataNode value);

	/**
	 * Returns the value of the '<em><b>DConstraints</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DConstraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DConstraints</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_DConstraints()
	 * @model
	 * @generated
	 */
	EList<DConstraint> getDConstraints();

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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_NameOffset()
	 * @model containment="true"
	 * @generated
	 */
	DOffset getNameOffset();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DNodeDAttribute#getNameOffset <em>Name Offset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Offset</em>' containment reference.
	 * @see #getNameOffset()
	 * @generated
	 */
	void setNameOffset(DOffset value);

	/**
	 * Returns the value of the '<em><b>Bendpoints</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DOffset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bendpoints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bendpoints</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDNodeDAttribute_Bendpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<DOffset> getBendpoints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void reconnect(DNode source, DDataNode target);

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
	DNodeDAttribute getTemplateDAttribute();

	void setDGraph(DGraph graph);

	DGraph getDGraph();

} // DNodeDAttribute
