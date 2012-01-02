/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import org.eclipse.emf.ecore.EClass;
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
 * @see no.hib.dpf.diagram.DiagramFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://no.hib.dpf.diagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "no.hib.dpf.diagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramPackage eINSTANCE = no.hib.dpf.diagram.impl.DiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DSignatureImpl <em>DSignature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DSignatureImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDSignature()
	 * @generated
	 */
	int DSIGNATURE = 0;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSIGNATURE__SIGNATURE = 0;

	/**
	 * The feature id for the '<em><b>DPredicates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSIGNATURE__DPREDICATES = 1;

	/**
	 * The number of structural features of the '<em>DSignature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSIGNATURE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DPredicateImpl <em>DPredicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DPredicateImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDPredicate()
	 * @generated
	 */
	int DPREDICATE = 1;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPREDICATE__PREDICATE = 0;

	/**
	 * The number of structural features of the '<em>DPredicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPREDICATE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DSignature <em>DSignature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSignature</em>'.
	 * @see no.hib.dpf.diagram.DSignature
	 * @generated
	 */
	EClass getDSignature();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DSignature#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see no.hib.dpf.diagram.DSignature#getSignature()
	 * @see #getDSignature()
	 * @generated
	 */
	EReference getDSignature_Signature();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DSignature#getDPredicates <em>DPredicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>DPredicates</em>'.
	 * @see no.hib.dpf.diagram.DSignature#getDPredicates()
	 * @see #getDSignature()
	 * @generated
	 */
	EReference getDSignature_DPredicates();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DPredicate <em>DPredicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DPredicate</em>'.
	 * @see no.hib.dpf.diagram.DPredicate
	 * @generated
	 */
	EClass getDPredicate();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DPredicate#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see no.hib.dpf.diagram.DPredicate#getPredicate()
	 * @see #getDPredicate()
	 * @generated
	 */
	EReference getDPredicate_Predicate();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramFactory getDiagramFactory();

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
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DSignatureImpl <em>DSignature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DSignatureImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDSignature()
		 * @generated
		 */
		EClass DSIGNATURE = eINSTANCE.getDSignature();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSIGNATURE__SIGNATURE = eINSTANCE.getDSignature_Signature();

		/**
		 * The meta object literal for the '<em><b>DPredicates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSIGNATURE__DPREDICATES = eINSTANCE.getDSignature_DPredicates();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DPredicateImpl <em>DPredicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DPredicateImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDPredicate()
		 * @generated
		 */
		EClass DPREDICATE = eINSTANCE.getDPredicate();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DPREDICATE__PREDICATE = eINSTANCE.getDPredicate_Predicate();

	}

} //DiagramPackage
