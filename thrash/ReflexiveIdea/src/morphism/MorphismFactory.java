/**
 * <copyright>
 * </copyright>
 *
 * $Id: MorphismFactory.java,v 1.1 2010-05-19 13:09:35 fma Exp $
 */
package morphism;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see morphism.MorphismPackage
 * @generated
 */
public interface MorphismFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MorphismFactory eINSTANCE = morphism.impl.MorphismFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Morphism</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Morphism</em>'.
	 * @generated
	 */
	Morphism createMorphism();

	/**
	 * Returns a new object of class '<em>Node Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Mapping</em>'.
	 * @generated
	 */
	NodeMapping createNodeMapping();

	/**
	 * Returns a new object of class '<em>Reference Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Mapping</em>'.
	 * @generated
	 */
	ReferenceMapping createReferenceMapping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MorphismPackage getMorphismPackage();

} //MorphismFactory
