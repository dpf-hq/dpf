/**
 */
package no.hib.dpf.uconstraint;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.uconstraint.UConstraintPackage
 * @generated
 */
public interface UConstraintFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UConstraintFactory eINSTANCE = no.hib.dpf.uconstraint.impl.UConstraintFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Constraints</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraints</em>'.
	 * @generated
	 */
	Constraints createConstraints();

	/**
	 * Returns a new object of class '<em>UConstraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UConstraint</em>'.
	 * @generated
	 */
	UConstraint createUConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UConstraintPackage getUConstraintPackage();

} //UConstraintFactory
