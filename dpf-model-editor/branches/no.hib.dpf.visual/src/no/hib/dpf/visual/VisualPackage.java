/**
 */
package no.hib.dpf.visual;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see no.hib.dpf.visual.VisualFactory
 * @model kind="package"
 * @generated
 */
public interface VisualPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "visual";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://no.hib.dpf.visual";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "visual";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualPackage eINSTANCE = no.hib.dpf.visual.impl.VisualPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.visual.impl.VElementImpl <em>VElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.visual.impl.VElementImpl
	 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getVElement()
	 * @generated
	 */
	int VELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VELEMENT__ICON = 1;

	/**
	 * The number of structural features of the '<em>VElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.visual.impl.VArrowImpl <em>VArrow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.visual.impl.VArrowImpl
	 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getVArrow()
	 * @generated
	 */
	int VARROW = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARROW__NAME = VELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARROW__ICON = VELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Composed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARROW__COMPOSED = VELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VArrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARROW_FEATURE_COUNT = VELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.visual.impl.VNodeImpl <em>VNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.visual.impl.VNodeImpl
	 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getVNode()
	 * @generated
	 */
	int VNODE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE__NAME = VELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE__ICON = VELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE__COMPOSITE = VELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE__COLOR = VELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rounded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE__ROUNDED = VELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNODE_FEATURE_COUNT = VELEMENT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link no.hib.dpf.visual.impl.VisualsImpl <em>Visuals</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.visual.impl.VisualsImpl
	 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getVisuals()
	 * @generated
	 */
	int VISUALS = 3;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALS__ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Visuals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALS_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '<em>EColor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.RGB
	 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getEColor()
	 * @generated
	 */
	int ECOLOR = 4;


	/**
	 * Returns the meta object for class '{@link no.hib.dpf.visual.VElement <em>VElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VElement</em>'.
	 * @see no.hib.dpf.visual.VElement
	 * @generated
	 */
	EClass getVElement();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.visual.VElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see no.hib.dpf.visual.VElement#getName()
	 * @see #getVElement()
	 * @generated
	 */
	EAttribute getVElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.visual.VElement#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see no.hib.dpf.visual.VElement#getIcon()
	 * @see #getVElement()
	 * @generated
	 */
	EAttribute getVElement_Icon();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.visual.VArrow <em>VArrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VArrow</em>'.
	 * @see no.hib.dpf.visual.VArrow
	 * @generated
	 */
	EClass getVArrow();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.visual.VArrow#isComposed <em>Composed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composed</em>'.
	 * @see no.hib.dpf.visual.VArrow#isComposed()
	 * @see #getVArrow()
	 * @generated
	 */
	EAttribute getVArrow_Composed();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.visual.VNode <em>VNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VNode</em>'.
	 * @see no.hib.dpf.visual.VNode
	 * @generated
	 */
	EClass getVNode();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.visual.VNode#isComposite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composite</em>'.
	 * @see no.hib.dpf.visual.VNode#isComposite()
	 * @see #getVNode()
	 * @generated
	 */
	EAttribute getVNode_Composite();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.visual.VNode#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see no.hib.dpf.visual.VNode#getColor()
	 * @see #getVNode()
	 * @generated
	 */
	EAttribute getVNode_Color();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.visual.VNode#isRounded <em>Rounded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rounded</em>'.
	 * @see no.hib.dpf.visual.VNode#isRounded()
	 * @see #getVNode()
	 * @generated
	 */
	EAttribute getVNode_Rounded();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.visual.Visuals <em>Visuals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visuals</em>'.
	 * @see no.hib.dpf.visual.Visuals
	 * @generated
	 */
	EClass getVisuals();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.visual.Visuals#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see no.hib.dpf.visual.Visuals#getItems()
	 * @see #getVisuals()
	 * @generated
	 */
	EReference getVisuals_Items();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.RGB <em>EColor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EColor</em>'.
	 * @see org.eclipse.swt.graphics.RGB
	 * @model instanceClass="org.eclipse.swt.graphics.RGB"
	 * @generated
	 */
	EDataType getEColor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VisualFactory getVisualFactory();

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
		 * The meta object literal for the '{@link no.hib.dpf.visual.impl.VElementImpl <em>VElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.visual.impl.VElementImpl
		 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getVElement()
		 * @generated
		 */
		EClass VELEMENT = eINSTANCE.getVElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VELEMENT__NAME = eINSTANCE.getVElement_Name();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VELEMENT__ICON = eINSTANCE.getVElement_Icon();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.visual.impl.VArrowImpl <em>VArrow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.visual.impl.VArrowImpl
		 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getVArrow()
		 * @generated
		 */
		EClass VARROW = eINSTANCE.getVArrow();

		/**
		 * The meta object literal for the '<em><b>Composed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARROW__COMPOSED = eINSTANCE.getVArrow_Composed();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.visual.impl.VNodeImpl <em>VNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.visual.impl.VNodeImpl
		 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getVNode()
		 * @generated
		 */
		EClass VNODE = eINSTANCE.getVNode();

		/**
		 * The meta object literal for the '<em><b>Composite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VNODE__COMPOSITE = eINSTANCE.getVNode_Composite();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VNODE__COLOR = eINSTANCE.getVNode_Color();

		/**
		 * The meta object literal for the '<em><b>Rounded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VNODE__ROUNDED = eINSTANCE.getVNode_Rounded();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.visual.impl.VisualsImpl <em>Visuals</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.visual.impl.VisualsImpl
		 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getVisuals()
		 * @generated
		 */
		EClass VISUALS = eINSTANCE.getVisuals();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUALS__ITEMS = eINSTANCE.getVisuals_Items();

		/**
		 * The meta object literal for the '<em>EColor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.RGB
		 * @see no.hib.dpf.visual.impl.VisualPackageImpl#getEColor()
		 * @generated
		 */
		EDataType ECOLOR = eINSTANCE.getEColor();

	}

} //VisualPackage
