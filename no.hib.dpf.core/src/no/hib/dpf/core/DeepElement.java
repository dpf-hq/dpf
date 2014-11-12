/**
 */
package no.hib.dpf.core;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deep Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.DeepElement#getPotency <em>Potency</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getDeepElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface DeepElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Potency</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Potency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Potency</em>' attribute.
	 * @see #setPotency(int)
	 * @see no.hib.dpf.core.CorePackage#getDeepElement_Potency()
	 * @model default="-1"
	 * @generated
	 */
	int getPotency();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.DeepElement#getPotency <em>Potency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Potency</em>' attribute.
	 * @see #getPotency()
	 * @generated
	 */
	void setPotency(int value);

} // DeepElement
