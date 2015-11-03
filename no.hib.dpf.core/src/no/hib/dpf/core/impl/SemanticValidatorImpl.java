/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.SemanticValidator;
import no.hib.dpf.core.ValidatorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Validator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.core.impl.SemanticValidatorImpl#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.SemanticValidatorImpl#getValidator <em>Validator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SemanticValidatorImpl extends EObjectImpl implements SemanticValidator {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ValidatorType TYPE_EDEFAULT = ValidatorType.OCL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ValidatorType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidator() <em>Validator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidator()
	 * @generated
	 * @ordered
	 */
	protected static final String VALIDATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidator() <em>Validator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidator()
	 * @generated
	 * @ordered
	 */
	protected String validator = VALIDATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticValidatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.SEMANTIC_VALIDATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidatorType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ValidatorType newType) {
		ValidatorType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SEMANTIC_VALIDATOR__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValidator() {
		return validator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidator(String newValidator) {
		String oldValidator = validator;
		validator = newValidator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.SEMANTIC_VALIDATOR__VALIDATOR, oldValidator, validator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean validateSemantics(EList<String> constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows, EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.SEMANTIC_VALIDATOR__TYPE:
				return getType();
			case CorePackage.SEMANTIC_VALIDATOR__VALIDATOR:
				return getValidator();
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
			case CorePackage.SEMANTIC_VALIDATOR__TYPE:
				setType((ValidatorType)newValue);
				return;
			case CorePackage.SEMANTIC_VALIDATOR__VALIDATOR:
				setValidator((String)newValue);
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
			case CorePackage.SEMANTIC_VALIDATOR__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CorePackage.SEMANTIC_VALIDATOR__VALIDATOR:
				setValidator(VALIDATOR_EDEFAULT);
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
			case CorePackage.SEMANTIC_VALIDATOR__TYPE:
				return type != TYPE_EDEFAULT;
			case CorePackage.SEMANTIC_VALIDATOR__VALIDATOR:
				return VALIDATOR_EDEFAULT == null ? validator != null : !VALIDATOR_EDEFAULT.equals(validator);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(", validator: ");
		result.append(validator);
		result.append(')');
		return result.toString();
	}

} //SemanticValidatorImpl
