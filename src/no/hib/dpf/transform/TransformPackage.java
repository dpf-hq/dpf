/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see no.hib.dpf.transform.TransformFactory
 * @model kind="package"
 * @generated
 */
public interface TransformPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "transform";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://no.hib.dpf.transform";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "transform";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TransformPackage eINSTANCE = no.hib.dpf.transform.impl.TransformPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.TransformImpl <em>Transform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.TransformImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getTransform()
	 * @generated
	 */
	int TRANSFORM = 0;

	/**
	 * The feature id for the '<em><b>Source Meta Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__SOURCE_META_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Target Meta Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__TARGET_META_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__RULES = 2;

	/**
	 * The feature id for the '<em><b>DSignature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__DSIGNATURE = 3;

	/**
	 * The feature id for the '<em><b>Generate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__GENERATE = 4;

	/**
	 * The feature id for the '<em><b>Source Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__SOURCE_LOCATION = 5;

	/**
	 * The feature id for the '<em><b>Target Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__TARGET_LOCATION = 6;

	/**
	 * The feature id for the '<em><b>Element Type Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__ELEMENT_TYPE_GRAPH = 7;

	/**
	 * The feature id for the '<em><b>Correspondance Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__CORRESPONDANCE_GRAPH = 8;

	/**
	 * The feature id for the '<em><b>Correspondance Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__CORRESPONDANCE_LOCATION = 9;

	/**
	 * The number of structural features of the '<em>Transform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.ProductionImpl <em>Production</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.ProductionImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getProduction()
	 * @generated
	 */
	int PRODUCTION = 1;

	/**
	 * The feature id for the '<em><b>Sum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION__SUM = 0;

	/**
	 * The feature id for the '<em><b>Left Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION__LEFT_NODES = 1;

	/**
	 * The feature id for the '<em><b>Right Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION__RIGHT_NODES = 2;

	/**
	 * The feature id for the '<em><b>Right Arrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION__RIGHT_ARROWS = 3;

	/**
	 * The feature id for the '<em><b>Left Arrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION__LEFT_ARROWS = 4;

	/**
	 * The feature id for the '<em><b>Common Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION__COMMON_NODES = 5;

	/**
	 * The feature id for the '<em><b>Common Arrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION__COMMON_ARROWS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION__NAME = 7;

	/**
	 * The number of structural features of the '<em>Production</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCTION_FEATURE_COUNT = 8;


	/**
	 * Returns the meta object for class '{@link no.hib.dpf.transform.Transform <em>Transform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transform</em>'.
	 * @see no.hib.dpf.transform.Transform
	 * @generated
	 */
	EClass getTransform();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.transform.Transform#getSourceMetaModel <em>Source Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Meta Model</em>'.
	 * @see no.hib.dpf.transform.Transform#getSourceMetaModel()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_SourceMetaModel();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.transform.Transform#getTargetMetaModel <em>Target Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Meta Model</em>'.
	 * @see no.hib.dpf.transform.Transform#getTargetMetaModel()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_TargetMetaModel();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.transform.Transform#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see no.hib.dpf.transform.Transform#getRules()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_Rules();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.transform.Transform#getDSignature <em>DSignature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DSignature</em>'.
	 * @see no.hib.dpf.transform.Transform#getDSignature()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_DSignature();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.transform.Transform#isGenerate <em>Generate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate</em>'.
	 * @see no.hib.dpf.transform.Transform#isGenerate()
	 * @see #getTransform()
	 * @generated
	 */
	EAttribute getTransform_Generate();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.transform.Transform#getSourceLocation <em>Source Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Location</em>'.
	 * @see no.hib.dpf.transform.Transform#getSourceLocation()
	 * @see #getTransform()
	 * @generated
	 */
	EAttribute getTransform_SourceLocation();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.transform.Transform#getTargetLocation <em>Target Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Location</em>'.
	 * @see no.hib.dpf.transform.Transform#getTargetLocation()
	 * @see #getTransform()
	 * @generated
	 */
	EAttribute getTransform_TargetLocation();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.transform.Transform#getElementTypeGraph <em>Element Type Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type Graph</em>'.
	 * @see no.hib.dpf.transform.Transform#getElementTypeGraph()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_ElementTypeGraph();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.transform.Transform#getCorrespondanceGraph <em>Correspondance Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Correspondance Graph</em>'.
	 * @see no.hib.dpf.transform.Transform#getCorrespondanceGraph()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_CorrespondanceGraph();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.transform.Transform#getCorrespondanceLocation <em>Correspondance Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Correspondance Location</em>'.
	 * @see no.hib.dpf.transform.Transform#getCorrespondanceLocation()
	 * @see #getTransform()
	 * @generated
	 */
	EAttribute getTransform_CorrespondanceLocation();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.transform.Production <em>Production</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Production</em>'.
	 * @see no.hib.dpf.transform.Production
	 * @generated
	 */
	EClass getProduction();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.transform.Production#getSum <em>Sum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sum</em>'.
	 * @see no.hib.dpf.transform.Production#getSum()
	 * @see #getProduction()
	 * @generated
	 */
	EReference getProduction_Sum();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.transform.Production#getLeftNodes <em>Left Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Left Nodes</em>'.
	 * @see no.hib.dpf.transform.Production#getLeftNodes()
	 * @see #getProduction()
	 * @generated
	 */
	EReference getProduction_LeftNodes();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.transform.Production#getRightNodes <em>Right Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Right Nodes</em>'.
	 * @see no.hib.dpf.transform.Production#getRightNodes()
	 * @see #getProduction()
	 * @generated
	 */
	EReference getProduction_RightNodes();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.transform.Production#getRightArrows <em>Right Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Right Arrows</em>'.
	 * @see no.hib.dpf.transform.Production#getRightArrows()
	 * @see #getProduction()
	 * @generated
	 */
	EReference getProduction_RightArrows();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.transform.Production#getLeftArrows <em>Left Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Left Arrows</em>'.
	 * @see no.hib.dpf.transform.Production#getLeftArrows()
	 * @see #getProduction()
	 * @generated
	 */
	EReference getProduction_LeftArrows();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.transform.Production#getCommonNodes <em>Common Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Common Nodes</em>'.
	 * @see no.hib.dpf.transform.Production#getCommonNodes()
	 * @see #getProduction()
	 * @generated
	 */
	EReference getProduction_CommonNodes();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.transform.Production#getCommonArrows <em>Common Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Common Arrows</em>'.
	 * @see no.hib.dpf.transform.Production#getCommonArrows()
	 * @see #getProduction()
	 * @generated
	 */
	EReference getProduction_CommonArrows();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.transform.Production#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.transform.Production#getName()
	 * @see #getProduction()
	 * @generated
	 */
	EAttribute getProduction_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TransformFactory getTransformFactory();

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
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.TransformImpl <em>Transform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.TransformImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getTransform()
		 * @generated
		 */
		EClass TRANSFORM = eINSTANCE.getTransform();

		/**
		 * The meta object literal for the '<em><b>Source Meta Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__SOURCE_META_MODEL = eINSTANCE.getTransform_SourceMetaModel();

		/**
		 * The meta object literal for the '<em><b>Target Meta Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__TARGET_META_MODEL = eINSTANCE.getTransform_TargetMetaModel();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__RULES = eINSTANCE.getTransform_Rules();

		/**
		 * The meta object literal for the '<em><b>DSignature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__DSIGNATURE = eINSTANCE.getTransform_DSignature();

		/**
		 * The meta object literal for the '<em><b>Generate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM__GENERATE = eINSTANCE.getTransform_Generate();

		/**
		 * The meta object literal for the '<em><b>Source Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM__SOURCE_LOCATION = eINSTANCE.getTransform_SourceLocation();

		/**
		 * The meta object literal for the '<em><b>Target Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM__TARGET_LOCATION = eINSTANCE.getTransform_TargetLocation();

		/**
		 * The meta object literal for the '<em><b>Element Type Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__ELEMENT_TYPE_GRAPH = eINSTANCE.getTransform_ElementTypeGraph();

		/**
		 * The meta object literal for the '<em><b>Correspondance Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__CORRESPONDANCE_GRAPH = eINSTANCE.getTransform_CorrespondanceGraph();

		/**
		 * The meta object literal for the '<em><b>Correspondance Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSFORM__CORRESPONDANCE_LOCATION = eINSTANCE.getTransform_CorrespondanceLocation();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.ProductionImpl <em>Production</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.ProductionImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getProduction()
		 * @generated
		 */
		EClass PRODUCTION = eINSTANCE.getProduction();

		/**
		 * The meta object literal for the '<em><b>Sum</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION__SUM = eINSTANCE.getProduction_Sum();

		/**
		 * The meta object literal for the '<em><b>Left Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION__LEFT_NODES = eINSTANCE.getProduction_LeftNodes();

		/**
		 * The meta object literal for the '<em><b>Right Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION__RIGHT_NODES = eINSTANCE.getProduction_RightNodes();

		/**
		 * The meta object literal for the '<em><b>Right Arrows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION__RIGHT_ARROWS = eINSTANCE.getProduction_RightArrows();

		/**
		 * The meta object literal for the '<em><b>Left Arrows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION__LEFT_ARROWS = eINSTANCE.getProduction_LeftArrows();

		/**
		 * The meta object literal for the '<em><b>Common Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION__COMMON_NODES = eINSTANCE.getProduction_CommonNodes();

		/**
		 * The meta object literal for the '<em><b>Common Arrows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCTION__COMMON_ARROWS = eINSTANCE.getProduction_CommonArrows();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCTION__NAME = eINSTANCE.getProduction_Name();

	}

} //TransformPackage