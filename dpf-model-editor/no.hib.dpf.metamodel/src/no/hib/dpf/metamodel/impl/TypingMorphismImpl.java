/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.TypingMorphism;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typing Morphism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.TypingMorphismImpl#getTheModel <em>The Model</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.TypingMorphismImpl#getTheMetamodel <em>The Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypingMorphismImpl extends GraphHomomorphismImpl implements TypingMorphism {
	/**
	 * The cached value of the '{@link #getTheModel() <em>The Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheModel()
	 * @generated
	 * @ordered
	 */
	protected Graph theModel;

	/**
	 * The cached value of the '{@link #getTheMetamodel() <em>The Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTheMetamodel()
	 * @generated
	 * @ordered
	 */
	protected Graph theMetamodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypingMorphismImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.TYPING_MORPHISM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getTheModel() {
		if (theModel != null && theModel.eIsProxy()) {
			InternalEObject oldTheModel = (InternalEObject)theModel;
			theModel = (Graph)eResolveProxy(oldTheModel);
			if (theModel != oldTheModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.TYPING_MORPHISM__THE_MODEL, oldTheModel, theModel));
			}
		}
		return theModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetTheModel() {
		return theModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheModel(Graph newTheModel) {
		Graph oldTheModel = theModel;
		theModel = newTheModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.TYPING_MORPHISM__THE_MODEL, oldTheModel, theModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getTheMetamodel() {
		if (theMetamodel != null && theMetamodel.eIsProxy()) {
			InternalEObject oldTheMetamodel = (InternalEObject)theMetamodel;
			theMetamodel = (Graph)eResolveProxy(oldTheMetamodel);
			if (theMetamodel != oldTheMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetamodelPackage.TYPING_MORPHISM__THE_METAMODEL, oldTheMetamodel, theMetamodel));
			}
		}
		return theMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetTheMetamodel() {
		return theMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheMetamodel(Graph newTheMetamodel) {
		Graph oldTheMetamodel = theMetamodel;
		theMetamodel = newTheMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelPackage.TYPING_MORPHISM__THE_METAMODEL, oldTheMetamodel, theMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.TYPING_MORPHISM__THE_MODEL:
				if (resolve) return getTheModel();
				return basicGetTheModel();
			case MetamodelPackage.TYPING_MORPHISM__THE_METAMODEL:
				if (resolve) return getTheMetamodel();
				return basicGetTheMetamodel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.TYPING_MORPHISM__THE_MODEL:
				setTheModel((Graph)newValue);
				return;
			case MetamodelPackage.TYPING_MORPHISM__THE_METAMODEL:
				setTheMetamodel((Graph)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.TYPING_MORPHISM__THE_MODEL:
				setTheModel((Graph)null);
				return;
			case MetamodelPackage.TYPING_MORPHISM__THE_METAMODEL:
				setTheMetamodel((Graph)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.TYPING_MORPHISM__THE_MODEL:
				return theModel != null;
			case MetamodelPackage.TYPING_MORPHISM__THE_METAMODEL:
				return theMetamodel != null;
		}
		return super.eIsSet(featureID);
	}

} //TypingMorphismImpl
