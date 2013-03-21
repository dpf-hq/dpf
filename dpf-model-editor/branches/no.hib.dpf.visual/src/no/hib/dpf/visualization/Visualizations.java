/**
 */
package no.hib.dpf.visualization;

import java.util.Map;

import no.hib.dpf.core.IDObject;

import no.hib.dpf.visual.VElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visualizations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.visualization.Visualizations#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.visualization.VisualizationPackage#getVisualizations()
 * @model
 * @generated
 */
public interface Visualizations extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' reference list.
	 * The list contents are of type {@link java.util.Map.Entry}&lt;no.hib.dpf.core.IDObject, no.hib.dpf.visual.VElement>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' reference list.
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVisualizations_Entries()
	 * @model mapType="no.hib.dpf.visualization.ModelToVisualEntry<no.hib.dpf.core.IDObject, no.hib.dpf.visual.VElement>"
	 * @generated
	 */
	EList<Map.Entry<IDObject, VElement>> getEntries();

} // Visualizations
