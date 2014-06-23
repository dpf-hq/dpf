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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DArrow createConstantDArrow();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DGraph createConstantDGraph();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DNode createConstantDNode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DSignature createConstantDSignature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DSpecification createConstantDSpecification();

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
	 * Returns a new object of class '<em>DArrow Label Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DArrow Label Constraint</em>'.
	 * @generated
	 */
	DArrowLabelConstraint createDArrowLabelConstraint();

	/**
	 * Returns a new object of class '<em>DComposed Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DComposed Constraint</em>'.
	 * @generated
	 */
	DComposedConstraint createDComposedConstraint();

	/**
	 * Returns a new object of class '<em>DConstraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DConstraint</em>'.
	 * @generated
	 */
	DConstraint createDConstraint();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DArrow createDefaultDArrow();

	public DConstraint createDefaultDConstraint();

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
	DNode createDefaultDNode();

	public DPredicate createDefaultDPredicate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DSignature createDefaultDSignature();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DSpecification createDefaultDSpecification();

	/**
	 * Returns a new object of class '<em>DElement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DElement</em>'.
	 * @generated
	 */
	DElement createDElement();

	/**
	 * Returns a new object of class '<em>DNode DAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DNode DAttribute</em>'.
	 * @generated
	 */
	DNodeDAttribute createDNodeDAttribute();

	/**
	 * Returns a new object of class '<em>DArrow DAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DArrow DAttribute</em>'.
	 * @generated
	 */
	DArrowDAttribute createDArrowDAttribute();

	/**
	 * Returns a new object of class '<em>DGeneric Arrow Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DGeneric Arrow Constraint</em>'.
	 * @generated
	 */
	DGenericArrowConstraint createDGenericArrowConstraint();

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
	 * Returns a new object of class '<em>DData Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DData Node</em>'.
	 * @generated
	 */
	DDataNode createDDataNode();

	/**
	 * Returns a new object of class '<em>DConstraint Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DConstraint Node</em>'.
	 * @generated
	 */
	DConstraintNode createDConstraintNode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	DNode createDNode(String name, DNode type);
	
	/**
	 * Returns a new object of class '<em>DOffset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DOffset</em>'.
	 * @generated
	 */
	DOffset createDOffset();
	
	/**
	 * Returns a new object of class '<em>DPredicate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DPredicate</em>'.
	 * @generated
	 */
	DPredicate createDPredicate();
	
	/**
	 * Returns a new object of class '<em>DSignature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSignature</em>'.
	 * @generated
	 */
	DSignature createDSignature();
	
	/**
	 * Returns a new object of class '<em>DSpecification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSpecification</em>'.
	 * @generated
	 */
	DSpecification createDSpecification();
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

	DOffset createDefaultDOffset();
	
	DNodeDAttribute createConstantDNodeDAttribute();
	
	DArrowDAttribute createConstantDArrowDAttribute();

	DDataNode createConstantDDataNode();
	
	DDataNode createDefaultDDataNode();

	DNodeDAttribute createDefaultDNodeDAttribute();
	
	DArrowDAttribute createDefaultDArrowDAttribute();

} //DiagramFactory
