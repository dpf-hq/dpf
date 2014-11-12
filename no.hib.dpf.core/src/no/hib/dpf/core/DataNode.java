/**
 */
package no.hib.dpf.core;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.DataNode#getValue <em>Value</em>}</li>
 *   <li>{@link no.hib.dpf.core.DataNode#getIncomingNodeAttributes <em>Incoming Node Attributes</em>}</li>
 *   <li>{@link no.hib.dpf.core.DataNode#getIncomingArrowAtributes <em>Incoming Arrow Atributes</em>}</li>
 *   <li>{@link no.hib.dpf.core.DataNode#getTypeDataNode <em>Type Data Node</em>}</li>
 *   <li>{@link no.hib.dpf.core.DataNode#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link no.hib.dpf.core.DataNode#isIsDataType <em>Is Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getDataNode()
 * @model
 * @generated
 */
public interface DataNode extends MutableElement, IDObject {

	public static final int DATAVALUE = 0;
	public static final int DATATYPE = 1;
	
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"DataNode"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see no.hib.dpf.core.CorePackage#getDataNode_Value()
	 * @model default="DataNode"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.DataNode#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Incoming Node Attributes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.core.NodeAttribute}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.NodeAttribute#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Node Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Node Attributes</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getDataNode_IncomingNodeAttributes()
	 * @see no.hib.dpf.core.NodeAttribute#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<NodeAttribute> getIncomingNodeAttributes();

	/**
	 * Returns the value of the '<em><b>Incoming Arrow Atributes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.core.ArrowAttribute}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.ArrowAttribute#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Arrow Atributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Arrow Atributes</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getDataNode_IncomingArrowAtributes()
	 * @see no.hib.dpf.core.ArrowAttribute#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<ArrowAttribute> getIncomingArrowAtributes();

	/**
	 * Returns the value of the '<em><b>Type Data Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Data Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Data Node</em>' reference.
	 * @see #setTypeDataNode(DataNode)
	 * @see no.hib.dpf.core.CorePackage#getDataNode_TypeDataNode()
	 * @model required="true"
	 * @generated
	 */
	DataNode getTypeDataNode();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.DataNode#getTypeDataNode <em>Type Data Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Data Node</em>' reference.
	 * @see #getTypeDataNode()
	 * @generated
	 */
	void setTypeDataNode(DataNode value);

	/**
	 * Returns the value of the '<em><b>Datatype</b></em>' attribute.
	 * The default value is <code>"EDataType"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatype</em>' attribute.
	 * @see #setDatatype(String)
	 * @see no.hib.dpf.core.CorePackage#getDataNode_Datatype()
	 * @model default="EDataType" required="true"
	 * @generated
	 */
	String getDatatype();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.DataNode#getDatatype <em>Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datatype</em>' attribute.
	 * @see #getDatatype()
	 * @generated
	 */
	void setDatatype(String value);

	/**
	 * Returns the value of the '<em><b>Is Data Type</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Data Type</em>' attribute.
	 * @see #setIsDataType(boolean)
	 * @see no.hib.dpf.core.CorePackage#getDataNode_IsDataType()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsDataType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.DataNode#isIsDataType <em>Is Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Data Type</em>' attribute.
	 * @see #isIsDataType()
	 * @generated
	 */
	void setIsDataType(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getTypeValue();

	Graph getGraph();

} // DataNode
