/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import java.util.Collection;

import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.ConstraintSemantic;
import no.hib.dpf.text.tdpf.DpfId;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Semantic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.ConstraintSemanticImpl#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.ConstraintSemanticImpl#getArrows <em>Arrows</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.ConstraintSemanticImpl#getOcl <em>Ocl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintSemanticImpl extends MinimalEObjectImpl.Container implements ConstraintSemantic
{
  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected DpfId id;

  /**
   * The cached value of the '{@link #getArrows() <em>Arrows</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrows()
   * @generated
   * @ordered
   */
  protected EList<Arrows> arrows;

  /**
   * The default value of the '{@link #getOcl() <em>Ocl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOcl()
   * @generated
   * @ordered
   */
  protected static final String OCL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOcl() <em>Ocl</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOcl()
   * @generated
   * @ordered
   */
  protected String ocl = OCL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstraintSemanticImpl()
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
    return TdpfPackage.Literals.CONSTRAINT_SEMANTIC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DpfId getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetId(DpfId newId, NotificationChain msgs)
  {
    DpfId oldId = id;
    id = newId;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.CONSTRAINT_SEMANTIC__ID, oldId, newId);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(DpfId newId)
  {
    if (newId != id)
    {
      NotificationChain msgs = null;
      if (id != null)
        msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.CONSTRAINT_SEMANTIC__ID, null, msgs);
      if (newId != null)
        msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.CONSTRAINT_SEMANTIC__ID, null, msgs);
      msgs = basicSetId(newId, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.CONSTRAINT_SEMANTIC__ID, newId, newId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Arrows> getArrows()
  {
    if (arrows == null)
    {
      arrows = new EObjectContainmentEList<Arrows>(Arrows.class, this, TdpfPackage.CONSTRAINT_SEMANTIC__ARROWS);
    }
    return arrows;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOcl()
  {
    return ocl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOcl(String newOcl)
  {
    String oldOcl = ocl;
    ocl = newOcl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.CONSTRAINT_SEMANTIC__OCL, oldOcl, ocl));
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
      case TdpfPackage.CONSTRAINT_SEMANTIC__ID:
        return basicSetId(null, msgs);
      case TdpfPackage.CONSTRAINT_SEMANTIC__ARROWS:
        return ((InternalEList<?>)getArrows()).basicRemove(otherEnd, msgs);
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
      case TdpfPackage.CONSTRAINT_SEMANTIC__ID:
        return getId();
      case TdpfPackage.CONSTRAINT_SEMANTIC__ARROWS:
        return getArrows();
      case TdpfPackage.CONSTRAINT_SEMANTIC__OCL:
        return getOcl();
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
      case TdpfPackage.CONSTRAINT_SEMANTIC__ID:
        setId((DpfId)newValue);
        return;
      case TdpfPackage.CONSTRAINT_SEMANTIC__ARROWS:
        getArrows().clear();
        getArrows().addAll((Collection<? extends Arrows>)newValue);
        return;
      case TdpfPackage.CONSTRAINT_SEMANTIC__OCL:
        setOcl((String)newValue);
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
      case TdpfPackage.CONSTRAINT_SEMANTIC__ID:
        setId((DpfId)null);
        return;
      case TdpfPackage.CONSTRAINT_SEMANTIC__ARROWS:
        getArrows().clear();
        return;
      case TdpfPackage.CONSTRAINT_SEMANTIC__OCL:
        setOcl(OCL_EDEFAULT);
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
      case TdpfPackage.CONSTRAINT_SEMANTIC__ID:
        return id != null;
      case TdpfPackage.CONSTRAINT_SEMANTIC__ARROWS:
        return arrows != null && !arrows.isEmpty();
      case TdpfPackage.CONSTRAINT_SEMANTIC__OCL:
        return OCL_EDEFAULT == null ? ocl != null : !OCL_EDEFAULT.equals(ocl);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (ocl: ");
    result.append(ocl);
    result.append(')');
    return result.toString();
  }

} //ConstraintSemanticImpl
