/**
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.ArrowAttribute;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DArrow DAttribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getDSource <em>DSource</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getArrowAttribute <em>Arrow Attribute</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getDTarget <em>DTarget</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getLinestyle <em>Linestyle</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getDConstraints <em>DConstraints</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getNameOffset <em>Name Offset</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DArrowDAttribute#getBendpoints <em>Bendpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute()
 * @model
 * @generated
 */
public interface DArrowDAttribute extends DElement {
	/**
	 * Returns the value of the '<em><b>DSource</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DArrow#getDOutgoingAttributes <em>DOutgoing Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSource</em>' reference.
	 * @see #setDSource(DArrow)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_DSource()
	 * @see no.hib.dpf.diagram.DArrow#getDOutgoingAttributes
	 * @model opposite="dOutgoingAttributes" required="true"
	 * @generated
	 */
	DArrow getDSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowDAttribute#getDSource <em>DSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DSource</em>' reference.
	 * @see #getDSource()
	 * @generated
	 */
	void setDSource(DArrow value);

	/**
	 * Returns the value of the '<em><b>Arrow Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrow Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrow Attribute</em>' reference.
	 * @see #setArrowAttribute(ArrowAttribute)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_ArrowAttribute()
	 * @model required="true"
	 * @generated
	 */
	ArrowAttribute getArrowAttribute();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowDAttribute#getArrowAttribute <em>Arrow Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrow Attribute</em>' reference.
	 * @see #getArrowAttribute()
	 * @generated
	 */
	void setArrowAttribute(ArrowAttribute value);

	/**
	 * Returns the value of the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DType</em>' reference.
	 * @see #setDType(DArrowDAttribute)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_DType()
	 * @model required="true"
	 * @generated
	 */
	DArrowDAttribute getDType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowDAttribute#getDType <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DType</em>' reference.
	 * @see #getDType()
	 * @generated
	 */
	void setDType(DArrowDAttribute value);

	/**
	 * Returns the value of the '<em><b>DTarget</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DDataNode#getDIncomingDArrowDAttributes <em>DIncoming DArrow DAttributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DTarget</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DTarget</em>' reference.
	 * @see #setDTarget(DDataNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_DTarget()
	 * @see no.hib.dpf.diagram.DDataNode#getDIncomingDArrowDAttributes
	 * @model opposite="dIncomingDArrowDAttributes" required="true"
	 * @generated
	 */
	DDataNode getDTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowDAttribute#getDTarget <em>DTarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DTarget</em>' reference.
	 * @see #getDTarget()
	 * @generated
	 */
	void setDTarget(DDataNode value);

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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_ConfigureString()
	 * @model
	 * @generated
	 */
	String getConfigureString();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowDAttribute#getConfigureString <em>Configure String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configure String</em>' attribute.
	 * @see #getConfigureString()
	 * @generated
	 */
	void setConfigureString(String value);

	/**
	 * Returns the value of the '<em><b>Linestyle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linestyle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linestyle</em>' attribute.
	 * @see #setLinestyle(int)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_Linestyle()
	 * @model
	 * @generated
	 */
	int getLinestyle();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowDAttribute#getLinestyle <em>Linestyle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linestyle</em>' attribute.
	 * @see #getLinestyle()
	 * @generated
	 */
	void setLinestyle(int value);

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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_DConstraints()
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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_NameOffset()
	 * @model containment="true"
	 * @generated
	 */
	DOffset getNameOffset();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DArrowDAttribute#getNameOffset <em>Name Offset</em>}' containment reference.
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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDArrowDAttribute_Bendpoints()
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
	void reconnect(DArrow source, DDataNode target);

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
	DArrowDAttribute getTemplateDAttribute();

	DGraph getDGraph();

	void setDGraph(DGraph graph);

} // DArrowDAttribute
