/**
 */
package no.hib.dpf.visual;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VNode</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.visual.VNode#isComposite <em>Composite</em>}</li>
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
	
	EList<VCompositeElement> getCompartments();
	
	void addCompartment(VCompositeElement compartment);

} // VNode
