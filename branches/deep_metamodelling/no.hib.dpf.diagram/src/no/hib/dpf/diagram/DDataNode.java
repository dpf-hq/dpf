/**
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.DataNode;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DData Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DDataNode#getDatanode <em>Datanode</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DDataNode#getConfigureString <em>Configure String</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DDataNode#getLocation <em>Location</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DDataNode#getSize <em>Size</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DDataNode#getDIncomingDNodeDAttributes <em>DIncoming DNode DAttributes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DDataNode#getDIncomingDArrowDAttributes <em>DIncoming DArrow DAttributes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DDataNode#getDType <em>DType</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDDataNode()
 * @model
 * @generated
 */
public interface DDataNode extends DElement {
		/**
	 * Returns the value of the '<em><b>Datanode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datanode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datanode</em>' reference.
	 * @see #setDatanode(DataNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDDataNode_Datanode()
	 * @model required="true"
	 * @generated
	 */
	DataNode getDatanode();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DDataNode#getDatanode <em>Datanode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datanode</em>' reference.
	 * @see #getDatanode()
	 * @generated
	 */
	void setDatanode(DataNode value);

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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDDataNode_ConfigureString()
	 * @model
	 * @generated
	 */
	String getConfigureString();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DDataNode#getConfigureString <em>Configure String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configure String</em>' attribute.
	 * @see #getConfigureString()
	 * @generated
	 */
	void setConfigureString(String value);

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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDDataNode_Location()
	 * @model dataType="no.hib.dpf.diagram.ELocation"
	 * @generated
	 */
	Point getLocation();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DDataNode#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Point value);

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
	 * @see no.hib.dpf.diagram.DiagramPackage#getDDataNode_Size()
	 * @model dataType="no.hib.dpf.diagram.EDimension"
	 * @generated
	 */
	Dimension getSize();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DDataNode#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Dimension value);

	/**
	 * Returns the value of the '<em><b>DIncoming DNode DAttributes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNodeDAttribute}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DNodeDAttribute#getDTarget <em>DTarget</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DIncoming DNode DAttributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DIncoming DNode DAttributes</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDDataNode_DIncomingDNodeDAttributes()
	 * @see no.hib.dpf.diagram.DNodeDAttribute#getDTarget
	 * @model opposite="dTarget"
	 * @generated
	 */
	EList<DNodeDAttribute> getDIncomingDNodeDAttributes();

	/**
	 * Returns the value of the '<em><b>DIncoming DArrow DAttributes</b></em>' reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrowDAttribute}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.diagram.DArrowDAttribute#getDTarget <em>DTarget</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DIncoming DArrow DAttributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DIncoming DArrow DAttributes</em>' reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDDataNode_DIncomingDArrowDAttributes()
	 * @see no.hib.dpf.diagram.DArrowDAttribute#getDTarget
	 * @model opposite="dTarget"
	 * @generated
	 */
	EList<DArrowDAttribute> getDIncomingDArrowDAttributes();

	/**
	 * Returns the value of the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DType</em>' reference.
	 * @see #setDType(DDataNode)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDDataNode_DType()
	 * @model required="true"
	 * @generated
	 */
	DDataNode getDType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DDataNode#getDType <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DType</em>' reference.
	 * @see #getDType()
	 * @generated
	 */
	void setDType(DDataNode value);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DDataNode getTemplateDDataNode();

	DGraph getDGraph();

} // DDataNode

