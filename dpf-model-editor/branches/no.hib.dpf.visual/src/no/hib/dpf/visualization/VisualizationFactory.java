/**
 */
package no.hib.dpf.visualization;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.visualization.VisualizationPackage
 * @generated
 */
public interface VisualizationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualizationFactory eINSTANCE = no.hib.dpf.visualization.impl.VisualizationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Visualizations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visualizations</em>'.
	 * @generated
	 */
	Visualizations createVisualizations();

	/**
	 * Returns a new object of class '<em>VCompartment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VCompartment</em>'.
	 * @generated
	 */
	VCompartment createVCompartment();

	/**
	 * Returns a new object of class '<em>VCompartment Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VCompartment Element</em>'.
	 * @generated
	 */
	VCompartmentElement createVCompartmentElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VisualizationPackage getVisualizationPackage();

} //VisualizationFactory
