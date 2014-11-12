/**
 */
package no.hib.dpf.core;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.NodeAttribute#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.core.NodeAttribute#getTypeAttribute <em>Type Attribute</em>}</li>
 *   <li>{@link no.hib.dpf.core.NodeAttribute#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.NodeAttribute#getTarget <em>Target</em>}</li>
 *   <li>{@link no.hib.dpf.core.NodeAttribute#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getNodeAttribute()
 * @model
 * @generated
 */
public interface NodeAttribute extends IDObject, MutableElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Node#getOutgoingAttributes <em>Outgoing Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see no.hib.dpf.core.CorePackage#getNodeAttribute_Source()
	 * @see no.hib.dpf.core.Node#getOutgoingAttributes
	 * @model opposite="outgoingAttributes" required="true"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.NodeAttribute#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Type Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Attribute</em>' reference.
	 * @see #setTypeAttribute(NodeAttribute)
	 * @see no.hib.dpf.core.CorePackage#getNodeAttribute_TypeAttribute()
	 * @model required="true"
	 * @generated
	 */
	NodeAttribute getTypeAttribute();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.NodeAttribute#getTypeAttribute <em>Type Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Attribute</em>' reference.
	 * @see #getTypeAttribute()
	 * @generated
	 */
	void setTypeAttribute(NodeAttribute value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.core.Constraint}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Constraint#getNodeAttributes <em>Node Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getNodeAttribute_Constraints()
	 * @see no.hib.dpf.core.Constraint#getNodeAttributes
	 * @model opposite="nodeAttributes"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.DataNode#getIncomingNodeAttributes <em>Incoming Node Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(DataNode)
	 * @see no.hib.dpf.core.CorePackage#getNodeAttribute_Target()
	 * @see no.hib.dpf.core.DataNode#getIncomingNodeAttributes
	 * @model opposite="incomingNodeAttributes" required="true"
	 * @generated
	 */
	DataNode getTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.NodeAttribute#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(DataNode value);

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
	 * @see no.hib.dpf.core.CorePackage#getNodeAttribute_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.NodeAttribute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getTypeName();

	Graph getGraph();

} // NodeAttribute
