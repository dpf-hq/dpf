/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package protolayout.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import protolayout.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProtolayoutFactoryImpl extends EFactoryImpl implements ProtolayoutFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProtolayoutFactory init() {
		try {
			ProtolayoutFactory theProtolayoutFactory = (ProtolayoutFactory)EPackage.Registry.INSTANCE.getEFactory("protolayout"); 
			if (theProtolayoutFactory != null) {
				return theProtolayoutFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProtolayoutFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtolayoutFactoryImpl() {
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
			case ProtolayoutPackage.LAYOUT_SYSTEM: return createLayoutSystem();
			case ProtolayoutPackage.NODE_LAYOUT: return createNodeLayout();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayoutSystem createLayoutSystem() {
		LayoutSystemImpl layoutSystem = new LayoutSystemImpl();
		return layoutSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeLayout createNodeLayout() {
		NodeLayoutImpl nodeLayout = new NodeLayoutImpl();
		return nodeLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtolayoutPackage getProtolayoutPackage() {
		return (ProtolayoutPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProtolayoutPackage getPackage() {
		return ProtolayoutPackage.eINSTANCE;
	}

} //ProtolayoutFactoryImpl
