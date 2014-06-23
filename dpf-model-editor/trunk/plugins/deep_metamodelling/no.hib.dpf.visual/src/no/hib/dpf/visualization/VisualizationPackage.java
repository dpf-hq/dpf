/**
 */
package no.hib.dpf.visualization;

import no.hib.dpf.visual.VisualPackage;

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
 * @see no.hib.dpf.visualization.VisualizationFactory
 * @model kind="package"
 * @generated
 */
public interface VisualizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "visualization";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "no.hib.dpf.visualization";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "visualization";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualizationPackage eINSTANCE = no.hib.dpf.visualization.impl.VisualizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.visualization.impl.VisualizationsImpl <em>Visualizations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.visualization.impl.VisualizationsImpl
	 * @see no.hib.dpf.visualization.impl.VisualizationPackageImpl#getVisualizations()
	 * @generated
	 */
	int VISUALIZATIONS = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATIONS__ENTRIES = 0;

	/**
	 * The feature id for the '<em><b>Visual</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATIONS__VISUAL = 1;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATIONS__INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATIONS__COMPARTMENTS = 3;

	/**
	 * The number of structural features of the '<em>Visualizations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATIONS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.visualization.impl.ModelToVisualEntryImpl <em>Model To Visual Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.visualization.impl.ModelToVisualEntryImpl
	 * @see no.hib.dpf.visualization.impl.VisualizationPackageImpl#getModelToVisualEntry()
	 * @generated
	 */
	int MODEL_TO_VISUAL_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TO_VISUAL_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TO_VISUAL_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Model To Visual Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TO_VISUAL_ENTRY_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link no.hib.dpf.visualization.impl.VCompartmentImpl <em>VCompartment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.visualization.impl.VCompartmentImpl
	 * @see no.hib.dpf.visualization.impl.VisualizationPackageImpl#getVCompartment()
	 * @generated
	 */
	int VCOMPARTMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT__NAME = VisualPackage.VELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT__ICON = VisualPackage.VELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT__PARENT = VisualPackage.VELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Compartment DNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT__COMPARTMENT_DNODE = VisualPackage.VELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT__CHILDREN = VisualPackage.VELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VCompartment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT_FEATURE_COUNT = VisualPackage.VELEMENT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link no.hib.dpf.visualization.impl.VCompartmentElementImpl <em>VCompartment Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.visualization.impl.VCompartmentElementImpl
	 * @see no.hib.dpf.visualization.impl.VisualizationPackageImpl#getVCompartmentElement()
	 * @generated
	 */
	int VCOMPARTMENT_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT_ELEMENT__NAME = VisualPackage.VELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT_ELEMENT__ICON = VisualPackage.VELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>DNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT_ELEMENT__DNODE = VisualPackage.VELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>VCompartment Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VCOMPARTMENT_ELEMENT_FEATURE_COUNT = VisualPackage.VELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link no.hib.dpf.visualization.Visualizations <em>Visualizations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visualizations</em>'.
	 * @see no.hib.dpf.visualization.Visualizations
	 * @generated
	 */
	EClass getVisualizations();

	/**
	 * Returns the meta object for the map '{@link no.hib.dpf.visualization.Visualizations#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Entries</em>'.
	 * @see no.hib.dpf.visualization.Visualizations#getEntries()
	 * @see #getVisualizations()
	 * @generated
	 */
	EReference getVisualizations_Entries();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.visualization.Visualizations#getVisual <em>Visual</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Visual</em>'.
	 * @see no.hib.dpf.visualization.Visualizations#getVisual()
	 * @see #getVisualizations()
	 * @generated
	 */
	EReference getVisualizations_Visual();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.visualization.Visualizations#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see no.hib.dpf.visualization.Visualizations#getInstance()
	 * @see #getVisualizations()
	 * @generated
	 */
	EReference getVisualizations_Instance();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.visualization.Visualizations#getCompartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Compartments</em>'.
	 * @see no.hib.dpf.visualization.Visualizations#getCompartments()
	 * @see #getVisualizations()
	 * @generated
	 */
	EReference getVisualizations_Compartments();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Model To Visual Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model To Visual Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="no.hib.dpf.diagram.DElement"
	 *        valueType="no.hib.dpf.visual.VElement"
	 * @generated
	 */
	EClass getModelToVisualEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getModelToVisualEntry()
	 * @generated
	 */
	EReference getModelToVisualEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getModelToVisualEntry()
	 * @generated
	 */
	EReference getModelToVisualEntry_Value();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.visualization.VCompartment <em>VCompartment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VCompartment</em>'.
	 * @see no.hib.dpf.visualization.VCompartment
	 * @generated
	 */
	EClass getVCompartment();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.visualization.VCompartment#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see no.hib.dpf.visualization.VCompartment#getParent()
	 * @see #getVCompartment()
	 * @generated
	 */
	EReference getVCompartment_Parent();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.visualization.VCompartment#getCompartmentDNode <em>Compartment DNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Compartment DNode</em>'.
	 * @see no.hib.dpf.visualization.VCompartment#getCompartmentDNode()
	 * @see #getVCompartment()
	 * @generated
	 */
	EReference getVCompartment_CompartmentDNode();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.visualization.VCompartment#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see no.hib.dpf.visualization.VCompartment#getChildren()
	 * @see #getVCompartment()
	 * @generated
	 */
	EReference getVCompartment_Children();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.visualization.VCompartmentElement <em>VCompartment Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VCompartment Element</em>'.
	 * @see no.hib.dpf.visualization.VCompartmentElement
	 * @generated
	 */
	EClass getVCompartmentElement();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.visualization.VCompartmentElement#getDNode <em>DNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DNode</em>'.
	 * @see no.hib.dpf.visualization.VCompartmentElement#getDNode()
	 * @see #getVCompartmentElement()
	 * @generated
	 */
	EReference getVCompartmentElement_DNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VisualizationFactory getVisualizationFactory();

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
		 * The meta object literal for the '{@link no.hib.dpf.visualization.impl.VisualizationsImpl <em>Visualizations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.visualization.impl.VisualizationsImpl
		 * @see no.hib.dpf.visualization.impl.VisualizationPackageImpl#getVisualizations()
		 * @generated
		 */
		EClass VISUALIZATIONS = eINSTANCE.getVisualizations();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUALIZATIONS__ENTRIES = eINSTANCE.getVisualizations_Entries();

		/**
		 * The meta object literal for the '<em><b>Visual</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUALIZATIONS__VISUAL = eINSTANCE.getVisualizations_Visual();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUALIZATIONS__INSTANCE = eINSTANCE.getVisualizations_Instance();

		/**
		 * The meta object literal for the '<em><b>Compartments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUALIZATIONS__COMPARTMENTS = eINSTANCE.getVisualizations_Compartments();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.visualization.impl.ModelToVisualEntryImpl <em>Model To Visual Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.visualization.impl.ModelToVisualEntryImpl
		 * @see no.hib.dpf.visualization.impl.VisualizationPackageImpl#getModelToVisualEntry()
		 * @generated
		 */
		EClass MODEL_TO_VISUAL_ENTRY = eINSTANCE.getModelToVisualEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TO_VISUAL_ENTRY__KEY = eINSTANCE.getModelToVisualEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_TO_VISUAL_ENTRY__VALUE = eINSTANCE.getModelToVisualEntry_Value();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.visualization.impl.VCompartmentImpl <em>VCompartment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.visualization.impl.VCompartmentImpl
		 * @see no.hib.dpf.visualization.impl.VisualizationPackageImpl#getVCompartment()
		 * @generated
		 */
		EClass VCOMPARTMENT = eINSTANCE.getVCompartment();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCOMPARTMENT__PARENT = eINSTANCE.getVCompartment_Parent();

		/**
		 * The meta object literal for the '<em><b>Compartment DNode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCOMPARTMENT__COMPARTMENT_DNODE = eINSTANCE.getVCompartment_CompartmentDNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCOMPARTMENT__CHILDREN = eINSTANCE.getVCompartment_Children();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.visualization.impl.VCompartmentElementImpl <em>VCompartment Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.visualization.impl.VCompartmentElementImpl
		 * @see no.hib.dpf.visualization.impl.VisualizationPackageImpl#getVCompartmentElement()
		 * @generated
		 */
		EClass VCOMPARTMENT_ELEMENT = eINSTANCE.getVCompartmentElement();

		/**
		 * The meta object literal for the '<em><b>DNode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VCOMPARTMENT_ELEMENT__DNODE = eINSTANCE.getVCompartmentElement_DNode();

	}

} //VisualizationPackage
