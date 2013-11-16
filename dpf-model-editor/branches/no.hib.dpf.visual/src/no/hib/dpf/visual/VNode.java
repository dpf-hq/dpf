/**
 */
package no.hib.dpf.visual;

import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.visual.VNode#isComposite <em>Composite</em>}</li>
 *   <li>{@link no.hib.dpf.visual.VNode#getColor <em>Color</em>}</li>
 *   <li>{@link no.hib.dpf.visual.VNode#isRounded <em>Rounded</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.visual.VisualPackage#getVNode()
 * @model
 * @generated
 */
public interface VNode extends VElement {
	/**
	 * Returns the value of the '<em><b>Composite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite</em>' attribute.
	 * @see #setComposite(boolean)
	 * @see no.hib.dpf.visual.VisualPackage#getVNode_Composite()
	 * @model default="false"
	 * @generated
	 */
	boolean isComposite();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visual.VNode#isComposite <em>Composite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite</em>' attribute.
	 * @see #isComposite()
	 * @generated
	 */
	void setComposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(RGB)
	 * @see no.hib.dpf.visual.VisualPackage#getVNode_Color()
	 * @model dataType="no.hib.dpf.visual.EColor"
	 * @generated
	 */
	RGB getColor();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visual.VNode#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(RGB value);

	/**
	 * Returns the value of the '<em><b>Rounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rounded</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rounded</em>' attribute.
	 * @see #setRounded(boolean)
	 * @see no.hib.dpf.visual.VisualPackage#getVNode_Rounded()
	 * @model
	 * @generated
	 */
	boolean isRounded();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visual.VNode#isRounded <em>Rounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rounded</em>' attribute.
	 * @see #isRounded()
	 * @generated
	 */
	void setRounded(boolean value);

} // VNode
