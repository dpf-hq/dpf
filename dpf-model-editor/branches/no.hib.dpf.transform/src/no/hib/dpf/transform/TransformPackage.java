/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import no.hib.dpf.core.CorePackage;

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
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.CopiedNodeImpl <em>Copied Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.CopiedNodeImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopiedNode()
	 * @generated
	 */
	int COPIED_NODE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_NODE__ID = CorePackage.NODE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_NODE__NAME = CorePackage.NODE__NAME;

	/**
	 * The feature id for the '<em><b>Type Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_NODE__TYPE_NODE = CorePackage.NODE__TYPE_NODE;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_NODE__OUTGOINGS = CorePackage.NODE__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_NODE__INCOMINGS = CorePackage.NODE__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_NODE__CONSTRAINTS = CorePackage.NODE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Copied Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_NODE__COPIED_TYPE = CorePackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Copied Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_NODE_FEATURE_COUNT = CorePackage.NODE_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.CopiedArrowImpl <em>Copied Arrow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.CopiedArrowImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopiedArrow()
	 * @generated
	 */
	int COPIED_ARROW = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_ARROW__ID = CorePackage.ARROW__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_ARROW__NAME = CorePackage.ARROW__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_ARROW__SOURCE = CorePackage.ARROW__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_ARROW__TARGET = CorePackage.ARROW__TARGET;

	/**
	 * The feature id for the '<em><b>Type Arrow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_ARROW__TYPE_ARROW = CorePackage.ARROW__TYPE_ARROW;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_ARROW__CONSTRAINTS = CorePackage.ARROW__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Copied Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_ARROW__COPIED_TYPE = CorePackage.ARROW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Copied Arrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_ARROW_FEATURE_COUNT = CorePackage.ARROW_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.ReductionImpl <em>Reduction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.ReductionImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getReduction()
	 * @generated
	 */
	int REDUCTION = 4;

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
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.CopiedConstraintImpl <em>Copied Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.CopiedConstraintImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopiedConstraint()
	 * @generated
	 */
	int COPIED_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_CONSTRAINT__ID = CorePackage.CONSTRAINT__ID;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_CONSTRAINT__NODES = CorePackage.CONSTRAINT__NODES;

	/**
	 * The feature id for the '<em><b>Arrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_CONSTRAINT__ARROWS = CorePackage.CONSTRAINT__ARROWS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_CONSTRAINT__PREDICATE = CorePackage.CONSTRAINT__PREDICATE;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_CONSTRAINT__MAPPINGS = CorePackage.CONSTRAINT__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_CONSTRAINT__PARAMETERS = CorePackage.CONSTRAINT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Copied Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_CONSTRAINT__COPIED_TYPE = CorePackage.CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Copied Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_CONSTRAINT_FEATURE_COUNT = CorePackage.CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.impl.CopiedImpl <em>Copied</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.impl.CopiedImpl
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopied()
	 * @generated
	 */
	int COPIED = 6;

	/**
	 * The feature id for the '<em><b>Copied Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED__COPIED_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Copied</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPIED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.transform.CopiedType <em>Copied Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.transform.CopiedType
	 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopiedType()
	 * @generated
	 */
	int COPIED_TYPE = 7;

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
	 * Returns the meta object for class '{@link no.hib.dpf.transform.CopiedNode <em>Copied Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copied Node</em>'.
	 * @see no.hib.dpf.transform.CopiedNode
	 * @generated
	 */
	EClass getCopiedNode();

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
	 * Returns the meta object for class '{@link no.hib.dpf.transform.CopiedArrow <em>Copied Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copied Arrow</em>'.
	 * @see no.hib.dpf.transform.CopiedArrow
	 * @generated
	 */
	EClass getCopiedArrow();

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
	 * Returns the meta object for class '{@link no.hib.dpf.transform.CopiedConstraint <em>Copied Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copied Constraint</em>'.
	 * @see no.hib.dpf.transform.CopiedConstraint
	 * @generated
	 */
	EClass getCopiedConstraint();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.transform.Copied <em>Copied</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copied</em>'.
	 * @see no.hib.dpf.transform.Copied
	 * @generated
	 */
	EClass getCopied();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.transform.Copied#getCopiedType <em>Copied Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Copied Type</em>'.
	 * @see no.hib.dpf.transform.Copied#getCopiedType()
	 * @see #getCopied()
	 * @generated
	 */
	EAttribute getCopied_CopiedType();

	/**
	 * Returns the meta object for enum '{@link no.hib.dpf.transform.CopiedType <em>Copied Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Copied Type</em>'.
	 * @see no.hib.dpf.transform.CopiedType
	 * @generated
	 */
	EEnum getCopiedType();

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
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.CopiedNodeImpl <em>Copied Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.CopiedNodeImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopiedNode()
		 * @generated
		 */
		EClass COPIED_NODE = eINSTANCE.getCopiedNode();

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
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.CopiedArrowImpl <em>Copied Arrow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.CopiedArrowImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopiedArrow()
		 * @generated
		 */
		EClass COPIED_ARROW = eINSTANCE.getCopiedArrow();

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
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.CopiedConstraintImpl <em>Copied Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.CopiedConstraintImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopiedConstraint()
		 * @generated
		 */
		EClass COPIED_CONSTRAINT = eINSTANCE.getCopiedConstraint();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.transform.impl.CopiedImpl <em>Copied</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.impl.CopiedImpl
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopied()
		 * @generated
		 */
		EClass COPIED = eINSTANCE.getCopied();

		/**
		 * The meta object literal for the '<em><b>Copied Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COPIED__COPIED_TYPE = eINSTANCE.getCopied_CopiedType();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.transform.CopiedType <em>Copied Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.transform.CopiedType
		 * @see no.hib.dpf.transform.impl.TransformPackageImpl#getCopiedType()
		 * @generated
		 */
		EEnum COPIED_TYPE = eINSTANCE.getCopiedType();

	}

} //TransformPackage
