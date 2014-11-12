/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.MappingArrow;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Arrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.MappingArrowImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.MappingArrowImpl#getCodmain <em>Codmain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingArrowImpl extends MappingImpl implements MappingArrow
{
  /**
   * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected Arrow domain;

  /**
   * The cached value of the '{@link #getCodmain() <em>Codmain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCodmain()
   * @generated
   * @ordered
   */
  protected Arrow codmain;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MappingArrowImpl()
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
    return TdpfPackage.Literals.MAPPING_ARROW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arrow getDomain()
  {
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDomain(Arrow newDomain, NotificationChain msgs)
  {
    Arrow oldDomain = domain;
    domain = newDomain;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.MAPPING_ARROW__DOMAIN, oldDomain, newDomain);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDomain(Arrow newDomain)
  {
    if (newDomain != domain)
    {
      NotificationChain msgs = null;
      if (domain != null)
        msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.MAPPING_ARROW__DOMAIN, null, msgs);
      if (newDomain != null)
        msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.MAPPING_ARROW__DOMAIN, null, msgs);
      msgs = basicSetDomain(newDomain, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.MAPPING_ARROW__DOMAIN, newDomain, newDomain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arrow getCodmain()
  {
    return codmain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCodmain(Arrow newCodmain, NotificationChain msgs)
  {
    Arrow oldCodmain = codmain;
    codmain = newCodmain;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.MAPPING_ARROW__CODMAIN, oldCodmain, newCodmain);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCodmain(Arrow newCodmain)
  {
    if (newCodmain != codmain)
    {
      NotificationChain msgs = null;
      if (codmain != null)
        msgs = ((InternalEObject)codmain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.MAPPING_ARROW__CODMAIN, null, msgs);
      if (newCodmain != null)
        msgs = ((InternalEObject)newCodmain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.MAPPING_ARROW__CODMAIN, null, msgs);
      msgs = basicSetCodmain(newCodmain, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.MAPPING_ARROW__CODMAIN, newCodmain, newCodmain));
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
      case TdpfPackage.MAPPING_ARROW__DOMAIN:
        return basicSetDomain(null, msgs);
      case TdpfPackage.MAPPING_ARROW__CODMAIN:
        return basicSetCodmain(null, msgs);
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
      case TdpfPackage.MAPPING_ARROW__DOMAIN:
        return getDomain();
      case TdpfPackage.MAPPING_ARROW__CODMAIN:
        return getCodmain();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TdpfPackage.MAPPING_ARROW__DOMAIN:
        setDomain((Arrow)newValue);
        return;
      case TdpfPackage.MAPPING_ARROW__CODMAIN:
        setCodmain((Arrow)newValue);
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
      case TdpfPackage.MAPPING_ARROW__DOMAIN:
        setDomain((Arrow)null);
        return;
      case TdpfPackage.MAPPING_ARROW__CODMAIN:
        setCodmain((Arrow)null);
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
      case TdpfPackage.MAPPING_ARROW__DOMAIN:
        return domain != null;
      case TdpfPackage.MAPPING_ARROW__CODMAIN:
        return codmain != null;
    }
    return super.eIsSet(featureID);
  }

} //MappingArrowImpl
