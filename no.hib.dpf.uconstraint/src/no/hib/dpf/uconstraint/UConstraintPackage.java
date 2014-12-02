/**
 */
package no.hib.dpf.uconstraint;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see no.hib.dpf.uconstraint.UConstraintFactory
 * @model kind="package"
 * @generated
 */
public interface UConstraintPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uconstraint";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://no.hib.dpf.uconstraint";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "UConstraint";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UConstraintPackage eINSTANCE = no.hib.dpf.uconstraint.impl.UConstraintPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.uconstraint.impl.ConstraintsImpl <em>Constraints</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.uconstraint.impl.ConstraintsImpl
	 * @see no.hib.dpf.uconstraint.impl.UConstraintPackageImpl#getConstraints()
	 * @generated
	 */
	int CONSTRAINTS = 0;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__RULES = 0;

	/**
	 * The feature id for the '<em><b>DSignature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__DSIGNATURE = 1;

	/**
	 * The feature id for the '<em><b>Element Type Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__ELEMENT_TYPE_GRAPH = 2;

	/**
	 * The feature id for the '<em><b>Source Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__SOURCE_LOCATION = 3;

	/**
	 * The number of structural features of the '<em>Constraints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.uconstraint.impl.UConstraintImpl <em>UConstraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.uconstraint.impl.UConstraintImpl
	 * @see no.hib.dpf.uconstraint.impl.UConstraintPackageImpl#getUConstraint()
	 * @generated
	 */
	int UCONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Sum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__SUM = 0;

	/**
	 * The feature id for the '<em><b>Left Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__LEFT_NODES = 1;

	/**
	 * The feature id for the '<em><b>Right Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__RIGHT_NODES = 2;

	/**
	 * The feature id for the '<em><b>Right Arrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__RIGHT_ARROWS = 3;

	/**
	 * The feature id for the '<em><b>Left Arrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__LEFT_ARROWS = 4;

	/**
	 * The feature id for the '<em><b>Common Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__COMMON_NODES = 5;

	/**
	 * The feature id for the '<em><b>Common Arrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__COMMON_ARROWS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__NAME = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT__TYPE = 8;

	/**
	 * The number of structural features of the '<em>UConstraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UCONSTRAINT_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link no.hib.dpf.uconstraint.UCType <em>UC Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.uconstraint.UCType
	 * @see no.hib.dpf.uconstraint.impl.UConstraintPackageImpl#getUCType()
	 * @generated
	 */
	int UC_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link no.hib.dpf.uconstraint.Constraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraints</em>'.
	 * @see no.hib.dpf.uconstraint.Constraints
	 * @generated
	 */
	EClass getConstraints();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.uconstraint.Constraints#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see no.hib.dpf.uconstraint.Constraints#getRules()
	 * @see #getConstraints()
	 * @generated
	 */
	EReference getConstraints_Rules();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.uconstraint.Constraints#getDSignature <em>DSignature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DSignature</em>'.
	 * @see no.hib.dpf.uconstraint.Constraints#getDSignature()
	 * @see #getConstraints()
	 * @generated
	 */
	EReference getConstraints_DSignature();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.uconstraint.Constraints#getElementTypeGraph <em>Element Type Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type Graph</em>'.
	 * @see no.hib.dpf.uconstraint.Constraints#getElementTypeGraph()
	 * @see #getConstraints()
	 * @generated
	 */
	EReference getConstraints_ElementTypeGraph();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.uconstraint.Constraints#getSourceLocation <em>Source Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Location</em>'.
	 * @see no.hib.dpf.uconstraint.Constraints#getSourceLocation()
	 * @see #getConstraints()
	 * @generated
	 */
	EAttribute getConstraints_SourceLocation();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.uconstraint.UConstraint <em>UConstraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UConstraint</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint
	 * @generated
	 */
	EClass getUConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.uconstraint.UConstraint#getSum <em>Sum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sum</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getSum()
	 * @see #getUConstraint()
	 * @generated
	 */
	EReference getUConstraint_Sum();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.uconstraint.UConstraint#getLeftNodes <em>Left Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Left Nodes</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getLeftNodes()
	 * @see #getUConstraint()
	 * @generated
	 */
	EReference getUConstraint_LeftNodes();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.uconstraint.UConstraint#getRightNodes <em>Right Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Right Nodes</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getRightNodes()
	 * @see #getUConstraint()
	 * @generated
	 */
	EReference getUConstraint_RightNodes();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.uconstraint.UConstraint#getRightArrows <em>Right Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Right Arrows</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getRightArrows()
	 * @see #getUConstraint()
	 * @generated
	 */
	EReference getUConstraint_RightArrows();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.uconstraint.UConstraint#getLeftArrows <em>Left Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Left Arrows</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getLeftArrows()
	 * @see #getUConstraint()
	 * @generated
	 */
	EReference getUConstraint_LeftArrows();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.uconstraint.UConstraint#getCommonNodes <em>Common Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Common Nodes</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getCommonNodes()
	 * @see #getUConstraint()
	 * @generated
	 */
	EReference getUConstraint_CommonNodes();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.uconstraint.UConstraint#getCommonArrows <em>Common Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Common Arrows</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getCommonArrows()
	 * @see #getUConstraint()
	 * @generated
	 */
	EReference getUConstraint_CommonArrows();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.uconstraint.UConstraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getName()
	 * @see #getUConstraint()
	 * @generated
	 */
	EAttribute getUConstraint_Name();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.uconstraint.UConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see no.hib.dpf.uconstraint.UConstraint#getType()
	 * @see #getUConstraint()
	 * @generated
	 */
	EAttribute getUConstraint_Type();

	/**
	 * Returns the meta object for enum '{@link no.hib.dpf.uconstraint.UCType <em>UC Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>UC Type</em>'.
	 * @see no.hib.dpf.uconstraint.UCType
	 * @generated
	 */
	EEnum getUCType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UConstraintFactory getUConstraintFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link no.hib.dpf.uconstraint.impl.ConstraintsImpl <em>Constraints</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.uconstraint.impl.ConstraintsImpl
		 * @see no.hib.dpf.uconstraint.impl.UConstraintPackageImpl#getConstraints()
		 * @generated
		 */
		EClass CONSTRAINTS = eINSTANCE.getConstraints();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINTS__RULES = eINSTANCE.getConstraints_Rules();

		/**
		 * The meta object literal for the '<em><b>DSignature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINTS__DSIGNATURE = eINSTANCE.getConstraints_DSignature();

		/**
		 * The meta object literal for the '<em><b>Element Type Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINTS__ELEMENT_TYPE_GRAPH = eINSTANCE.getConstraints_ElementTypeGraph();

		/**
		 * The meta object literal for the '<em><b>Source Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINTS__SOURCE_LOCATION = eINSTANCE.getConstraints_SourceLocation();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.uconstraint.impl.UConstraintImpl <em>UConstraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.uconstraint.impl.UConstraintImpl
		 * @see no.hib.dpf.uconstraint.impl.UConstraintPackageImpl#getUConstraint()
		 * @generated
		 */
		EClass UCONSTRAINT = eINSTANCE.getUConstraint();

		/**
		 * The meta object literal for the '<em><b>Sum</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCONSTRAINT__SUM = eINSTANCE.getUConstraint_Sum();

		/**
		 * The meta object literal for the '<em><b>Left Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCONSTRAINT__LEFT_NODES = eINSTANCE.getUConstraint_LeftNodes();

		/**
		 * The meta object literal for the '<em><b>Right Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCONSTRAINT__RIGHT_NODES = eINSTANCE.getUConstraint_RightNodes();

		/**
		 * The meta object literal for the '<em><b>Right Arrows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCONSTRAINT__RIGHT_ARROWS = eINSTANCE.getUConstraint_RightArrows();

		/**
		 * The meta object literal for the '<em><b>Left Arrows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCONSTRAINT__LEFT_ARROWS = eINSTANCE.getUConstraint_LeftArrows();

		/**
		 * The meta object literal for the '<em><b>Common Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCONSTRAINT__COMMON_NODES = eINSTANCE.getUConstraint_CommonNodes();

		/**
		 * The meta object literal for the '<em><b>Common Arrows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UCONSTRAINT__COMMON_ARROWS = eINSTANCE.getUConstraint_CommonArrows();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UCONSTRAINT__NAME = eINSTANCE.getUConstraint_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UCONSTRAINT__TYPE = eINSTANCE.getUConstraint_Type();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.uconstraint.UCType <em>UC Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.uconstraint.UCType
		 * @see no.hib.dpf.uconstraint.impl.UConstraintPackageImpl#getUCType()
		 * @generated
		 */
		EEnum UC_TYPE = eINSTANCE.getUCType();

	}

} //UConstraintPackage
