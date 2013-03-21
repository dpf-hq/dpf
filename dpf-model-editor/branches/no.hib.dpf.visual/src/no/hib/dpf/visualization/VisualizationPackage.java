/**
 */
package no.hib.dpf.visualization;

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
	 * The feature id for the '<em><b>Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATIONS__ENTRIES = 0;

	/**
	 * The number of structural features of the '<em>Visualizations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATIONS_FEATURE_COUNT = 1;

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
	 * Returns the meta object for class '{@link no.hib.dpf.visualization.Visualizations <em>Visualizations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visualizations</em>'.
	 * @see no.hib.dpf.visualization.Visualizations
	 * @generated
	 */
	EClass getVisualizations();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.visualization.Visualizations#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entries</em>'.
	 * @see no.hib.dpf.visualization.Visualizations#getEntries()
	 * @see #getVisualizations()
	 * @generated
	 */
	EReference getVisualizations_Entries();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Model To Visual Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model To Visual Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="no.hib.dpf.core.IDObject"
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
		 * The meta object literal for the '<em><b>Entries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUALIZATIONS__ENTRIES = eINSTANCE.getVisualizations_Entries();

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

	}

} //VisualizationPackage
