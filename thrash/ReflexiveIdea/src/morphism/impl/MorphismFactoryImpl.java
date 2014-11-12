/**
 * <copyright>
 * </copyright>
 *
 * $Id: MorphismFactoryImpl.java,v 1.1 2010-05-19 13:09:36 fma Exp $
 */
package morphism.impl;

import morphism.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MorphismFactoryImpl extends EFactoryImpl implements MorphismFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MorphismFactory init() {
		try {
			MorphismFactory theMorphismFactory = (MorphismFactory)EPackage.Registry.INSTANCE.getEFactory("morphism"); 
			if (theMorphismFactory != null) {
				return theMorphismFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MorphismFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MorphismFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MorphismPackage.MORPHISM: return createMorphism();
			case MorphismPackage.NODE_MAPPING: return createNodeMapping();
			case MorphismPackage.REFERENCE_MAPPING: return createReferenceMapping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Morphism createMorphism() {
		MorphismImpl morphism = new MorphismImpl();
		return morphism;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeMapping createNodeMapping() {
		NodeMappingImpl nodeMapping = new NodeMappingImpl();
		return nodeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceMapping createReferenceMapping() {
		ReferenceMappingImpl referenceMapping = new ReferenceMappingImpl();
		return referenceMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MorphismPackage getMorphismPackage() {
		return (MorphismPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MorphismPackage getPackage() {
		return MorphismPackage.eINSTANCE;
	}

} //MorphismFactoryImpl
