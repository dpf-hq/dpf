/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.transform.TransformPackage
 * @generated
 */
public interface TransformFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransformFactory eINSTANCE = no.hib.dpf.transform.impl.TransformFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transform</em>'.
	 * @generated
	 */
	Transform createTransform();

	/**
	 * Returns a new object of class '<em>Copied Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copied Node</em>'.
	 * @generated
	 */
	CopiedNode createCopiedNode();

	/**
	 * Returns a new object of class '<em>Map Arrow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map Arrow</em>'.
	 * @generated
	 */
	MapArrow createMapArrow();

	/**
	 * Returns a new object of class '<em>Copied Arrow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copied Arrow</em>'.
	 * @generated
	 */
	CopiedArrow createCopiedArrow();

	/**
	 * Returns a new object of class '<em>Reduction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reduction</em>'.
	 * @generated
	 */
	Reduction createReduction();

	/**
	 * Returns a new object of class '<em>Copied Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copied Constraint</em>'.
	 * @generated
	 */
	CopiedConstraint createCopiedConstraint();

	/**
	 * Returns a new object of class '<em>Copied</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copied</em>'.
	 * @generated
	 */
	Copied createCopied();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TransformPackage getTransformPackage();

} //TransformFactory
