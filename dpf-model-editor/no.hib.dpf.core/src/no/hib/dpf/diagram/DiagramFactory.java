/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;



import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.diagram.DiagramPackage
 * @generated
 */
public interface DiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramFactory eINSTANCE = no.hib.dpf.diagram.impl.DiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>DSpecification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSpecification</em>'.
	 * @generated
	 */
	DSpecification createDSpecification();

	/**
	 * Returns a new object of class '<em>DGraph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DGraph</em>'.
	 * @generated
	 */
	DGraph createDGraph();

	/**
	 * Returns a new object of class '<em>DNode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DNode</em>'.
	 * @generated
	 */
	DNode createDNode();

	/**
	 * Returns a new object of class '<em>DNode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DNode</em>'.
	 * @generated NOT
	 */
	//DNode createDNode();

	/**
	 * Returns a new object of class '<em>DArrow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DArrow</em>'.
	 * @generated
	 */
	DArrow createDArrow();

	/**
	 * Returns a new object of class '<em>DArrow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DArrow</em>'.
	 * @generated NOT
	 */
//	DArrow createDArrow(Arrow arrow, DNode source, DNode target, DArrow type);
	
	/**
	 * Returns a new object of class '<em>DArrow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DArrow</em>'.
	 * @generated NOT
	 */
	DArrow createDArrow(String name, DNode source, DNode target, DArrow type);

	/**
	 * Returns a new object of class '<em>DConstraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DConstraint</em>'.
	 * @generated
	 */
	DConstraint createDConstraint();

	/**
	 * Returns a new object of class '<em>DPredicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DPredicate</em>'.
	 * @generated
	 */
	DPredicate createDPredicate();

	/**
	 * Returns a new object of class '<em>DBound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DBound</em>'.
	 * @generated
	 */
	DBound createDBound();

	/**
	 * Returns a new object of class '<em>DOffset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DOffset</em>'.
	 * @generated
	 */
	DOffset createDOffset();

	/**
	 * Returns a new object of class '<em>DSignature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSignature</em>'.
	 * @generated
	 */
	DSignature createDSignature();

	/**
	 * Returns a new object of class '<em>Visualization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visualization</em>'.
	 * @generated
	 */
	Visualization createVisualization();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagramPackage getDiagramPackage();
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
//	DNode createDNode(Node node, DNode type);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DNode createDNode(String name, DNode type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DNode createDefaultDNode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DGraph createDefaultDGraph();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DArrow createDefaultDArrow();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DSpecification createDefaultDSpecification();

	DSignature createDefaultDSignature();


} //DiagramFactory
