/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package protolayout;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see protolayout.ProtolayoutPackage
 * @generated
 */
public interface ProtolayoutFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProtolayoutFactory eINSTANCE = protolayout.impl.ProtolayoutFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Layout System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layout System</em>'.
	 * @generated
	 */
	LayoutSystem createLayoutSystem();

	/**
	 * Returns a new object of class '<em>Node Layout</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Layout</em>'.
	 * @generated
	 */
	NodeLayout createNodeLayout();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProtolayoutPackage getProtolayoutPackage();

} //ProtolayoutFactory
