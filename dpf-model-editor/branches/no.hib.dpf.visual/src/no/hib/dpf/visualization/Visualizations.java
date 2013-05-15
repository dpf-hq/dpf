/**
 */
package no.hib.dpf.visualization;


import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.Visuals;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
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
 *   <li>{@link no.hib.dpf.visualization.Visualizations#getModel <em>Model</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.Visualizations#getVisual <em>Visual</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.Visualizations#getInstance <em>Instance</em>}</li>
 *   <li>{@link no.hib.dpf.visualization.Visualizations#getCompartments <em>Compartments</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.visualization.VisualizationPackage#getVisualizations()
 * @model
 * @generated
 */
public interface Visualizations extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' map.
	 * The key is of type {@link no.hib.dpf.core.IDObject},
	 * and the value is of type {@link no.hib.dpf.visual.VElement},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' map.
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVisualizations_Entries()
	 * @model mapType="no.hib.dpf.visualization.ModelToVisualEntry<no.hib.dpf.core.IDObject, no.hib.dpf.visual.VElement>"
	 * @generated
	 */
	EMap<IDObject, VElement> getEntries();

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(Specification)
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVisualizations_Model()
	 * @model required="true"
	 * @generated
	 */
	Specification getModel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visualization.Visualizations#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Specification value);

	/**
	 * Returns the value of the '<em><b>Visual</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visual</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visual</em>' reference.
	 * @see #setVisual(Visuals)
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVisualizations_Visual()
	 * @model required="true"
	 * @generated
	 */
	Visuals getVisual();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visualization.Visualizations#getVisual <em>Visual</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visual</em>' reference.
	 * @see #getVisual()
	 * @generated
	 */
	void setVisual(Visuals value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' containment reference.
	 * @see #setInstance(DSpecification)
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVisualizations_Instance()
	 * @model containment="true"
	 * @generated
	 */
	DSpecification getInstance();

	/**
	 * Sets the value of the '{@link no.hib.dpf.visualization.Visualizations#getInstance <em>Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' containment reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(DSpecification value);

	/**
	 * Returns the value of the '<em><b>Compartments</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.visualization.VCompartment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartments</em>' containment reference list.
	 * @see no.hib.dpf.visualization.VisualizationPackage#getVisualizations_Compartments()
	 * @model containment="true"
	 * @generated
	 */
	EList<VCompartment> getCompartments();

} // Visualizations
