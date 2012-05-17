/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform.impl;

import no.hib.dpf.transform.Copied;
import no.hib.dpf.transform.CopiedArrow;
import no.hib.dpf.transform.CopiedConstraint;
import no.hib.dpf.transform.CopiedNode;
import no.hib.dpf.transform.CopiedType;
import no.hib.dpf.transform.MapArrow;
import no.hib.dpf.transform.Reduction;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class TransformFactoryImpl extends EFactoryImpl implements TransformFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformFactory init() {
		try {
			TransformFactory theTransformFactory = (TransformFactory)EPackage.Registry.INSTANCE.getEFactory("http://no.hib.dpf.transform"); 
			if (theTransformFactory != null) {
				return theTransformFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TransformFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformFactoryImpl() {
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
			case TransformPackage.TRANSFORM: return createTransform();
			case TransformPackage.COPIED_NODE: return createCopiedNode();
			case TransformPackage.MAP_ARROW: return createMapArrow();
			case TransformPackage.COPIED_ARROW: return createCopiedArrow();
			case TransformPackage.REDUCTION: return createReduction();
			case TransformPackage.COPIED_CONSTRAINT: return createCopiedConstraint();
			case TransformPackage.COPIED: return createCopied();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TransformPackage.COPIED_TYPE:
				return createCopiedTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TransformPackage.COPIED_TYPE:
				return convertCopiedTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transform createTransform() {
		TransformImpl transform = new TransformImpl();
		return transform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopiedNode createCopiedNode() {
		CopiedNodeImpl copiedNode = new CopiedNodeImpl();
		return copiedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapArrow createMapArrow() {
		MapArrowImpl mapArrow = new MapArrowImpl();
		return mapArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopiedArrow createCopiedArrow() {
		CopiedArrowImpl copiedArrow = new CopiedArrowImpl();
		return copiedArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reduction createReduction() {
		ReductionImpl reduction = new ReductionImpl();
		return reduction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopiedConstraint createCopiedConstraint() {
		CopiedConstraintImpl copiedConstraint = new CopiedConstraintImpl();
		return copiedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Copied createCopied() {
		CopiedImpl copied = new CopiedImpl();
		return copied;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopiedType createCopiedTypeFromString(EDataType eDataType, String initialValue) {
		CopiedType result = CopiedType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCopiedTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformPackage getTransformPackage() {
		return (TransformPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TransformPackage getPackage() {
		return TransformPackage.eINSTANCE;
	}

} //TransformFactoryImpl
