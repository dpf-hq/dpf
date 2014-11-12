/**
 * <copyright>
 * </copyright>
 *
 * $Id: MorphismPackage.java,v 1.1 2010-05-19 13:09:35 fma Exp $
 */
package morphism;

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
 * @see morphism.MorphismFactory
 * @model kind="package"
 * @generated
 */
public interface MorphismPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "morphism";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "morphism";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "morphism";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MorphismPackage eINSTANCE = morphism.impl.MorphismPackageImpl.init();

	/**
	 * The meta object id for the '{@link morphism.impl.MorphismImpl <em>Morphism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see morphism.impl.MorphismImpl
	 * @see morphism.impl.MorphismPackageImpl#getMorphism()
	 * @generated
	 */
	int MORPHISM = 0;

	/**
	 * The feature id for the '<em><b>Node Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORPHISM__NODE_MAPPINGS = 0;

	/**
	 * The feature id for the '<em><b>Reference Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORPHISM__REFERENCE_MAPPINGS = 1;

	/**
	 * The number of structural features of the '<em>Morphism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORPHISM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link morphism.impl.NodeMappingImpl <em>Node Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see morphism.impl.NodeMappingImpl
	 * @see morphism.impl.MorphismPackageImpl#getNodeMapping()
	 * @generated
	 */
	int NODE_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPING__SRC = 0;

	/**
	 * The feature id for the '<em><b>Tar</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPING__TAR = 1;

	/**
	 * The number of structural features of the '<em>Node Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link morphism.impl.ReferenceMappingImpl <em>Reference Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see morphism.impl.ReferenceMappingImpl
	 * @see morphism.impl.MorphismPackageImpl#getReferenceMapping()
	 * @generated
	 */
	int REFERENCE_MAPPING = 2;

	/**
	 * The feature id for the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MAPPING__SRC = 0;

	/**
	 * The feature id for the '<em><b>Tar</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MAPPING__TAR = 1;

	/**
	 * The number of structural features of the '<em>Reference Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MAPPING_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link morphism.Morphism <em>Morphism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Morphism</em>'.
	 * @see morphism.Morphism
	 * @generated
	 */
	EClass getMorphism();

	/**
	 * Returns the meta object for the containment reference list '{@link morphism.Morphism#getNodeMappings <em>Node Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node Mappings</em>'.
	 * @see morphism.Morphism#getNodeMappings()
	 * @see #getMorphism()
	 * @generated
	 */
	EReference getMorphism_NodeMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link morphism.Morphism#getReferenceMappings <em>Reference Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reference Mappings</em>'.
	 * @see morphism.Morphism#getReferenceMappings()
	 * @see #getMorphism()
	 * @generated
	 */
	EReference getMorphism_ReferenceMappings();

	/**
	 * Returns the meta object for class '{@link morphism.NodeMapping <em>Node Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Mapping</em>'.
	 * @see morphism.NodeMapping
	 * @generated
	 */
	EClass getNodeMapping();

	/**
	 * Returns the meta object for the reference '{@link morphism.NodeMapping#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see morphism.NodeMapping#getSrc()
	 * @see #getNodeMapping()
	 * @generated
	 */
	EReference getNodeMapping_Src();

	/**
	 * Returns the meta object for the reference list '{@link morphism.NodeMapping#getTar <em>Tar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tar</em>'.
	 * @see morphism.NodeMapping#getTar()
	 * @see #getNodeMapping()
	 * @generated
	 */
	EReference getNodeMapping_Tar();

	/**
	 * Returns the meta object for class '{@link morphism.ReferenceMapping <em>Reference Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Mapping</em>'.
	 * @see morphism.ReferenceMapping
	 * @generated
	 */
	EClass getReferenceMapping();

	/**
	 * Returns the meta object for the reference '{@link morphism.ReferenceMapping#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src</em>'.
	 * @see morphism.ReferenceMapping#getSrc()
	 * @see #getReferenceMapping()
	 * @generated
	 */
	EReference getReferenceMapping_Src();

	/**
	 * Returns the meta object for the reference list '{@link morphism.ReferenceMapping#getTar <em>Tar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tar</em>'.
	 * @see morphism.ReferenceMapping#getTar()
	 * @see #getReferenceMapping()
	 * @generated
	 */
	EReference getReferenceMapping_Tar();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MorphismFactory getMorphismFactory();

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
		 * The meta object literal for the '{@link morphism.impl.MorphismImpl <em>Morphism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see morphism.impl.MorphismImpl
		 * @see morphism.impl.MorphismPackageImpl#getMorphism()
		 * @generated
		 */
		EClass MORPHISM = eINSTANCE.getMorphism();

		/**
		 * The meta object literal for the '<em><b>Node Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MORPHISM__NODE_MAPPINGS = eINSTANCE.getMorphism_NodeMappings();

		/**
		 * The meta object literal for the '<em><b>Reference Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MORPHISM__REFERENCE_MAPPINGS = eINSTANCE.getMorphism_ReferenceMappings();

		/**
		 * The meta object literal for the '{@link morphism.impl.NodeMappingImpl <em>Node Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see morphism.impl.NodeMappingImpl
		 * @see morphism.impl.MorphismPackageImpl#getNodeMapping()
		 * @generated
		 */
		EClass NODE_MAPPING = eINSTANCE.getNodeMapping();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_MAPPING__SRC = eINSTANCE.getNodeMapping_Src();

		/**
		 * The meta object literal for the '<em><b>Tar</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_MAPPING__TAR = eINSTANCE.getNodeMapping_Tar();

		/**
		 * The meta object literal for the '{@link morphism.impl.ReferenceMappingImpl <em>Reference Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see morphism.impl.ReferenceMappingImpl
		 * @see morphism.impl.MorphismPackageImpl#getReferenceMapping()
		 * @generated
		 */
		EClass REFERENCE_MAPPING = eINSTANCE.getReferenceMapping();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_MAPPING__SRC = eINSTANCE.getReferenceMapping_Src();

		/**
		 * The meta object literal for the '<em><b>Tar</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_MAPPING__TAR = eINSTANCE.getReferenceMapping_Tar();

	}

} //MorphismPackage
