/**
 */
package no.hib.dpf.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.MutableElement#getMutability <em>Mutability</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getMutableElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MutableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Mutability</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutability</em>' attribute.
	 * @see #setMutability(int)
	 * @see no.hib.dpf.core.CorePackage#getMutableElement_Mutability()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getMutability();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.MutableElement#getMutability <em>Mutability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutability</em>' attribute.
	 * @see #getMutability()
	 * @generated
	 */
	void setMutability(int value);

} // MutableElement
