/**
 */
package no.hib.dpf.visual.impl;

import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VCompositeElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.VisualFactory;
import no.hib.dpf.visual.VisualPackage;
import no.hib.dpf.visual.Visuals;

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
public class VisualFactoryImpl extends EFactoryImpl implements VisualFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisualFactory init() {
		try {
			VisualFactory theVisualFactory = (VisualFactory)EPackage.Registry.INSTANCE.getEFactory("http://no.hib.dpf.visual"); 
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
	public VArrow createVArrow() {
		VArrowImpl vArrow = new VArrowImpl();
		return vArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VNode createVNode() {
		VNodeImpl vNode = new VNodeImpl();
		return vNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visuals createVisuals() {
		VisualsImpl visuals = new VisualsImpl();
		return visuals;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VCompositeElement createVCompositeElement() {
		VCompositeElementImpl vCompositeElement = new VCompositeElementImpl();
		return vCompositeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
