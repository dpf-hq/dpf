/**
 */
package no.hib.dpf.visual;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VArrow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.visual.VArrow#isComposed <em>Composed</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.visual.VisualPackage#getVArrow()
 * @model
 * @generated
 */
public interface VArrow extends VElement {
	/**
	 * Returns the value of the '<em><b>Composed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed</em>' attribute.
	 * @see #setComposed(boolean)
	 * @see no.hib.dpf.visual.VisualPackage#getVArrow_Composed()
	 * @model default="false"
	 * @generated
	 */
	boolean isComposed();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visual.VArrow#isComposed <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composed</em>' attribute.
	 * @see #isComposed()
	 * @generated
	 */
	void setComposed(boolean value);

} // VArrow
