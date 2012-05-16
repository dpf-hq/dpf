/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import no.hib.dpf.core.CorePackage;

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
	 * The feature id for the '<em><b>Source Meta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__SOURCE_META = 0;

	/**
	 * The feature id for the '<em><b>Target Meta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__TARGET_META = 1;

	/**
	 * The feature id for the '<em><b>Joint Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__JOINT_META = 2;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM__RULES = 3;

	/**
	 * The number of structural features of the '<em>Transform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.ExGraphImpl <em>Ex Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.ExGraphImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getExGraph()
	 * @generated
	 */
	int EX_GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_GRAPH__ID = CorePackage.GRAPH__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_GRAPH__TYPE = CorePackage.GRAPH__TYPE;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_GRAPH__NODES = CorePackage.GRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Arrows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_GRAPH__ARROWS = CorePackage.GRAPH__ARROWS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_GRAPH__NAME = CorePackage.GRAPH__NAME;

	/**
	 * The feature id for the '<em><b>Map Arrow</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_GRAPH__MAP_ARROW = CorePackage.GRAPH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ex Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_GRAPH_FEATURE_COUNT = CorePackage.GRAPH_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.MapArrowImpl <em>Map Arrow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.MapArrowImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getMapArrow()
	 * @generated
	 */
	int MAP_ARROW = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ARROW__ID = CorePackage.ARROW__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ARROW__NAME = CorePackage.ARROW__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ARROW__SOURCE = CorePackage.ARROW__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ARROW__TARGET = CorePackage.ARROW__TARGET;

	/**
	 * The feature id for the '<em><b>Type Arrow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ARROW__TYPE_ARROW = CorePackage.ARROW__TYPE_ARROW;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ARROW__CONSTRAINTS = CorePackage.ARROW__CONSTRAINTS;

	/**
	 * The number of structural features of the '<em>Map Arrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_ARROW_FEATURE_COUNT = CorePackage.ARROW_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.ReductionImpl <em>Reduction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.ReductionImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getReduction()
	 * @generated
	 */
	int REDUCTION = 3;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION__LEFT = 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION__RIGHT = 1;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION__MAPPING = 2;

	/**
	 * The number of structural features of the '<em>Reduction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.ExSpecificationImpl <em>Ex Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.ExSpecificationImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getExSpecification()
	 * @generated
	 */
	int EX_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_SPECIFICATION__GRAPH = CorePackage.SPECIFICATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_SPECIFICATION__CONSTRAINTS = CorePackage.SPECIFICATION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Meta File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_SPECIFICATION__META_FILE = CorePackage.SPECIFICATION__META_FILE;

	/**
	 * The feature id for the '<em><b>Signature File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_SPECIFICATION__SIGNATURE_FILE = CorePackage.SPECIFICATION__SIGNATURE_FILE;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_SPECIFICATION__SIGNATURE = CorePackage.SPECIFICATION__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_SPECIFICATION__TYPE = CorePackage.SPECIFICATION__TYPE;

	/**
	 * The feature id for the '<em><b>Exgraph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_SPECIFICATION__EXGRAPH = CorePackage.SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ex Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EX_SPECIFICATION_FEATURE_COUNT = CorePackage.SPECIFICATION_FEATURE_COUNT + 1;


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
	 * Returns the meta object for the reference '{@link no.hib.dpf.transform.Transform#getSourceMeta <em>Source Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Meta</em>'.
	 * @see no.hib.dpf.transform.Transform#getSourceMeta()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_SourceMeta();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.transform.Transform#getTargetMeta <em>Target Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Meta</em>'.
	 * @see no.hib.dpf.transform.Transform#getTargetMeta()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_TargetMeta();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.transform.Transform#getJointMeta <em>Joint Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Joint Meta</em>'.
	 * @see no.hib.dpf.transform.Transform#getJointMeta()
	 * @see #getTransform()
	 * @generated
	 */
	EReference getTransform_JointMeta();

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
	 * Returns the meta object for class '{@link no.hib.dpf.transform.ExGraph <em>Ex Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ex Graph</em>'.
	 * @see no.hib.dpf.transform.ExGraph
	 * @generated
	 */
	EClass getExGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.transform.ExGraph#getMapArrow <em>Map Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Map Arrow</em>'.
	 * @see no.hib.dpf.transform.ExGraph#getMapArrow()
	 * @see #getExGraph()
	 * @generated
	 */
	EReference getExGraph_MapArrow();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.transform.MapArrow <em>Map Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Arrow</em>'.
	 * @see no.hib.dpf.transform.MapArrow
	 * @generated
	 */
	EClass getMapArrow();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.transform.Reduction <em>Reduction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reduction</em>'.
	 * @see no.hib.dpf.transform.Reduction
	 * @generated
	 */
	EClass getReduction();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.transform.Reduction#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see no.hib.dpf.transform.Reduction#getLeft()
	 * @see #getReduction()
	 * @generated
	 */
	EReference getReduction_Left();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.transform.Reduction#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see no.hib.dpf.transform.Reduction#getRight()
	 * @see #getReduction()
	 * @generated
	 */
	EReference getReduction_Right();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.transform.Reduction#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping</em>'.
	 * @see no.hib.dpf.transform.Reduction#getMapping()
	 * @see #getReduction()
	 * @generated
	 */
	EReference getReduction_Mapping();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.transform.ExSpecification <em>Ex Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ex Specification</em>'.
	 * @see no.hib.dpf.transform.ExSpecification
	 * @generated
	 */
	EClass getExSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.transform.ExSpecification#getExgraph <em>Exgraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exgraph</em>'.
	 * @see no.hib.dpf.transform.ExSpecification#getExgraph()
	 * @see #getExSpecification()
	 * @generated
	 */
	EReference getExSpecification_Exgraph();

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
		 * The meta object literal for the '<em><b>Source Meta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__SOURCE_META = eINSTANCE.getTransform_SourceMeta();

		/**
		 * The meta object literal for the '<em><b>Target Meta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__TARGET_META = eINSTANCE.getTransform_TargetMeta();

		/**
		 * The meta object literal for the '<em><b>Joint Meta</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__JOINT_META = eINSTANCE.getTransform_JointMeta();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM__RULES = eINSTANCE.getTransform_Rules();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.ExGraphImpl <em>Ex Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.ExGraphImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getExGraph()
		 * @generated
		 */
		EClass EX_GRAPH = eINSTANCE.getExGraph();

		/**
		 * The meta object literal for the '<em><b>Map Arrow</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EX_GRAPH__MAP_ARROW = eINSTANCE.getExGraph_MapArrow();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.MapArrowImpl <em>Map Arrow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.MapArrowImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getMapArrow()
		 * @generated
		 */
		EClass MAP_ARROW = eINSTANCE.getMapArrow();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.ReductionImpl <em>Reduction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.ReductionImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getReduction()
		 * @generated
		 */
		EClass REDUCTION = eINSTANCE.getReduction();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUCTION__LEFT = eINSTANCE.getReduction_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUCTION__RIGHT = eINSTANCE.getReduction_Right();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUCTION__MAPPING = eINSTANCE.getReduction_Mapping();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.ExSpecificationImpl <em>Ex Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.ExSpecificationImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getExSpecification()
		 * @generated
		 */
		EClass EX_SPECIFICATION = eINSTANCE.getExSpecification();

		/**
		 * The meta object literal for the '<em><b>Exgraph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EX_SPECIFICATION__EXGRAPH = eINSTANCE.getExSpecification_Exgraph();

	}

} //TransformPackage
