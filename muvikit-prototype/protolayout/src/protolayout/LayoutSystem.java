/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package protolayout;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layout System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link protolayout.LayoutSystem#getNodeLayouts <em>Node Layouts</em>}</li>
 * </ul>
 * </p>
 *
 * @see protolayout.ProtolayoutPackage#getLayoutSystem()
 * @model
 * @generated
 */
public interface LayoutSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Layouts</b></em>' containment reference list.
	 * The list contents are of type {@link protolayout.NodeLayout}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Layouts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Layouts</em>' containment reference list.
	 * @see protolayout.ProtolayoutPackage#getLayoutSystem_NodeLayouts()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeLayout> getNodeLayouts();

} // LayoutSystem
