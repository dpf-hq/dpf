/**
 */
package no.hib.dpf.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.Mutability#getDurability <em>Durability</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getMutability()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Mutability extends EObject {
	/**
	 * Returns the value of the '<em><b>Durability</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Durability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Durability</em>' attribute.
	 * @see #setDurability(int)
	 * @see no.hib.dpf.core.CorePackage#getMutability_Durability()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getDurability();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.Mutability#getDurability <em>Durability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Durability</em>' attribute.
	 * @see #getDurability()
	 * @generated
	 */
	void setDurability(int value);

} // Mutability
