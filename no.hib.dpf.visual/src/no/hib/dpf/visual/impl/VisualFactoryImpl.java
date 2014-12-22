/**
 */
package no.hib.dpf.visual.impl;

import no.hib.dpf.visual.*;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.VisualFactory;
import no.hib.dpf.visual.VisualPackage;
import no.hib.dpf.visual.Visuals;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualFactoryImpl extends EFactoryImpl implements VisualFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisualFactory init() {
		try {
			VisualFactory theVisualFactory = (VisualFactory)EPackage.Registry.INSTANCE.getEFactory(VisualPackage.eNS_URI);
			if (theVisualFactory != null) {
				return theVisualFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VisualFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualFactoryImpl() {
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
			case VisualPackage.VARROW: return createVArrow();
			case VisualPackage.VNODE: return createVNode();
			case VisualPackage.VISUALS: return createVisuals();
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
			case VisualPackage.ECOLOR:
				return createEColorFromString(eDataType, initialValue);
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
			case VisualPackage.ECOLOR:
				return convertEColorToString(eDataType, instanceValue);
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
	public VArrow createVArrow() {
		VArrowImpl vArrow = new VArrowImpl();
		return vArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VNode createVNode() {
		VNodeImpl vNode = new VNodeImpl();
		return vNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Visuals createVisuals() {
		VisualsImpl visuals = new VisualsImpl();
		return visuals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public RGB createEColorFromString(EDataType eDataType, String initialValue) {
		String[] result = initialValue.split(" ");
		Assert.isTrue(result.length == 3);
		return new RGB(Integer.valueOf(result[0]).intValue(),Integer.valueOf(result[1]).intValue(),Integer.valueOf(result[2]).intValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEColorToString(EDataType eDataType, Object instanceValue) {
		RGB rgb = (RGB) instanceValue;
		return rgb.red + " " + rgb.green + " " + rgb.blue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VisualPackage getVisualPackage() {
		return (VisualPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VisualPackage getPackage() {
		return VisualPackage.eINSTANCE;
	}

} //VisualFactoryImpl
