/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package protolayout;

import org.eclipse.emf.ecore.EObject;

import protomodel.Clazz;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Layout</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link protolayout.NodeLayout#getNode <em>Node</em>}</li>
 *   <li>{@link protolayout.NodeLayout#getX <em>X</em>}</li>
 *   <li>{@link protolayout.NodeLayout#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see protolayout.ProtolayoutPackage#getNodeLayout()
 * @model
 * @generated
 */
public interface NodeLayout extends EObject {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Clazz)
	 * @see protolayout.ProtolayoutPackage#getNodeLayout_Node()
	 * @model
	 * @generated
	 */
	Clazz getNode();

	/**
	 * Sets the value of the '{@link protolayout.NodeLayout#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Clazz value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see protolayout.ProtolayoutPackage#getNodeLayout_X()
	 * @model
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link protolayout.NodeLayout#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see protolayout.ProtolayoutPackage#getNodeLayout_Y()
	 * @model
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link protolayout.NodeLayout#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

} // NodeLayout
