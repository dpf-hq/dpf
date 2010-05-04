/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package protolayout;

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
 * @see protolayout.ProtolayoutFactory
 * @model kind="package"
 * @generated
 */
public interface ProtolayoutPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "protolayout";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "protolayout";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "protolayout";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProtolayoutPackage eINSTANCE = protolayout.impl.ProtolayoutPackageImpl.init();

	/**
	 * The meta object id for the '{@link protolayout.impl.LayoutSystemImpl <em>Layout System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see protolayout.impl.LayoutSystemImpl
	 * @see protolayout.impl.ProtolayoutPackageImpl#getLayoutSystem()
	 * @generated
	 */
	int LAYOUT_SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Node Layouts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_SYSTEM__NODE_LAYOUTS = 0;

	/**
	 * The number of structural features of the '<em>Layout System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_SYSTEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link protolayout.impl.NodeLayoutImpl <em>Node Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see protolayout.impl.NodeLayoutImpl
	 * @see protolayout.impl.ProtolayoutPackageImpl#getNodeLayout()
	 * @generated
	 */
	int NODE_LAYOUT = 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__NODE = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__X = 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT__Y = 2;

	/**
	 * The number of structural features of the '<em>Node Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_LAYOUT_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link protolayout.LayoutSystem <em>Layout System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout System</em>'.
	 * @see protolayout.LayoutSystem
	 * @generated
	 */
	EClass getLayoutSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link protolayout.LayoutSystem#getNodeLayouts <em>Node Layouts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node Layouts</em>'.
	 * @see protolayout.LayoutSystem#getNodeLayouts()
	 * @see #getLayoutSystem()
	 * @generated
	 */
	EReference getLayoutSystem_NodeLayouts();

	/**
	 * Returns the meta object for class '{@link protolayout.NodeLayout <em>Node Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Layout</em>'.
	 * @see protolayout.NodeLayout
	 * @generated
	 */
	EClass getNodeLayout();

	/**
	 * Returns the meta object for the reference '{@link protolayout.NodeLayout#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see protolayout.NodeLayout#getNode()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EReference getNodeLayout_Node();

	/**
	 * Returns the meta object for the attribute '{@link protolayout.NodeLayout#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see protolayout.NodeLayout#getX()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EAttribute getNodeLayout_X();

	/**
	 * Returns the meta object for the attribute '{@link protolayout.NodeLayout#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see protolayout.NodeLayout#getY()
	 * @see #getNodeLayout()
	 * @generated
	 */
	EAttribute getNodeLayout_Y();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProtolayoutFactory getProtolayoutFactory();

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
		 * The meta object literal for the '{@link protolayout.impl.LayoutSystemImpl <em>Layout System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see protolayout.impl.LayoutSystemImpl
		 * @see protolayout.impl.ProtolayoutPackageImpl#getLayoutSystem()
		 * @generated
		 */
		EClass LAYOUT_SYSTEM = eINSTANCE.getLayoutSystem();

		/**
		 * The meta object literal for the '<em><b>Node Layouts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT_SYSTEM__NODE_LAYOUTS = eINSTANCE.getLayoutSystem_NodeLayouts();

		/**
		 * The meta object literal for the '{@link protolayout.impl.NodeLayoutImpl <em>Node Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see protolayout.impl.NodeLayoutImpl
		 * @see protolayout.impl.ProtolayoutPackageImpl#getNodeLayout()
		 * @generated
		 */
		EClass NODE_LAYOUT = eINSTANCE.getNodeLayout();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_LAYOUT__NODE = eINSTANCE.getNodeLayout_Node();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_LAYOUT__X = eINSTANCE.getNodeLayout_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_LAYOUT__Y = eINSTANCE.getNodeLayout_Y();

	}

} //ProtolayoutPackage
