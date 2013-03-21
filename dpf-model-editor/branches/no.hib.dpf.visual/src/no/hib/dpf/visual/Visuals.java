/**
 */
package no.hib.dpf.visual;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visuals</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.visual.Visuals#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.visual.VisualPackage#getVisuals()
 * @model
 * @generated
 */
public interface Visuals extends EObject {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.visual.VElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see no.hib.dpf.visual.VisualPackage#getVisuals_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<VElement> getItems();

	void addItem(VElement item);

	void removeItem(VElement item);

} // Visuals
