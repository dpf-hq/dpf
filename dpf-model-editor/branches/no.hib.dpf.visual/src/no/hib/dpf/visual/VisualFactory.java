/**
 */
package no.hib.dpf.visual;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.visual.VisualPackage
 * @generated
 */
public interface VisualFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualFactory eINSTANCE = no.hib.dpf.visual.impl.VisualFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>VArrow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VArrow</em>'.
	 * @generated
	 */
	VArrow createVArrow();

	/**
	 * Returns a new object of class '<em>VNode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>VNode</em>'.
	 * @generated
	 */
	VNode createVNode();

	/**
	 * Returns a new object of class '<em>Visuals</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visuals</em>'.
	 * @generated
	 */
	Visuals createVisuals();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VisualPackage getVisualPackage();

} //VisualFactory
