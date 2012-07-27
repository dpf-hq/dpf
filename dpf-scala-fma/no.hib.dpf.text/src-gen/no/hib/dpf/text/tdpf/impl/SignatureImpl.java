/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import java.util.Collection;

import no.hib.dpf.text.tdpf.ConstraintSemantic;
import no.hib.dpf.text.tdpf.Signature;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SignatureImpl#getConstraintSemantics <em>Constraint Semantics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignatureImpl extends ModelImpl implements Signature
{
  /**
   * The cached value of the '{@link #getConstraintSemantics() <em>Constraint Semantics</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintSemantics()
   * @generated
   * @ordered
   */
  protected EList<ConstraintSemantic> constraintSemantics;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SignatureImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TdpfPackage.Literals.SIGNATURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstraintSemantic> getConstraintSemantics()
  {
    if (constraintSemantics == null)
    {
      constraintSemantics = new EObjectContainmentEList<ConstraintSemantic>(ConstraintSemantic.class, this, TdpfPackage.SIGNATURE__CONSTRAINT_SEMANTICS);
    }
    return constraintSemantics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TdpfPackage.SIGNATURE__CONSTRAINT_SEMANTICS:
        return ((InternalEList<?>)getConstraintSemantics()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TdpfPackage.SIGNATURE__CONSTRAINT_SEMANTICS:
        return getConstraintSemantics();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TdpfPackage.SIGNATURE__CONSTRAINT_SEMANTICS:
        getConstraintSemantics().clear();
        getConstraintSemantics().addAll((Collection<? extends ConstraintSemantic>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TdpfPackage.SIGNATURE__CONSTRAINT_SEMANTICS:
        getConstraintSemantics().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TdpfPackage.SIGNATURE__CONSTRAINT_SEMANTICS:
        return constraintSemantics != null && !constraintSemantics.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SignatureImpl
