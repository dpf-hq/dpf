/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arrows</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.ArrowsImpl#getSr <em>Sr</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.ArrowsImpl#getNext <em>Next</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrowsImpl extends ElementImpl implements Arrows
{
  /**
   * The cached value of the '{@link #getSr() <em>Sr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSr()
   * @generated
   * @ordered
   */
  protected Node sr;

  /**
   * The cached value of the '{@link #getNext() <em>Next</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNext()
   * @generated
   * @ordered
   */
  protected Arrows next;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArrowsImpl()
  {
    super();
    System.out.println("ArrowsImpl()");
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TdpfPackage.Literals.ARROWS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getSr()
  {
    return sr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSr(Node newSr, NotificationChain msgs)
  {
	System.out.println("ArrowsImpl()->NotificationChain basicSetSr(Node newSr, NotificationChain msgs)");
	Node oldSr = sr;
    sr = newSr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.ARROWS__SR, oldSr, newSr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSr(Node newSr)
  {
	System.out.println("ArrowsImpl()->setSr(Node newSr)");
    if (newSr != sr)
    {
      NotificationChain msgs = null;
      if (sr != null)
        msgs = ((InternalEObject)sr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.ARROWS__SR, null, msgs);
      if (newSr != null)
        msgs = ((InternalEObject)newSr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.ARROWS__SR, null, msgs);
      msgs = basicSetSr(newSr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.ARROWS__SR, newSr, newSr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arrows getNext()
  {
    return next;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNext(Arrows newNext, NotificationChain msgs)
  {
	System.out.println("ArrowsImpl()->basicSetNext(Arrows newNext, NotificationChain msgs)");
    Arrows oldNext = next;
    next = newNext;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.ARROWS__NEXT, oldNext, newNext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNext(Arrows newNext)
  {
	System.out.println("ArrowsImpl()->setNext(Arrows newNext)");
    if (newNext != next)
    {
      NotificationChain msgs = null;
      if (next != null)
        msgs = ((InternalEObject)next).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.ARROWS__NEXT, null, msgs);
      if (newNext != null)
        msgs = ((InternalEObject)newNext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.ARROWS__NEXT, null, msgs);
      msgs = basicSetNext(newNext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.ARROWS__NEXT, newNext, newNext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
	System.out.println("ArrowsImpl()->eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)");
    switch (featureID)
    {
      case TdpfPackage.ARROWS__SR:
        return basicSetSr(null, msgs);
      case TdpfPackage.ARROWS__NEXT:
        return basicSetNext(null, msgs);
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
      case TdpfPackage.ARROWS__SR:
        return getSr();
      case TdpfPackage.ARROWS__NEXT:
        return getNext();
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
	System.out.println("ArrowsImpl()->eSet(int featureID, Object newValue)");
	switch (featureID)
    {
      case TdpfPackage.ARROWS__SR:
        setSr((Node)newValue);
        return;
      case TdpfPackage.ARROWS__NEXT:
        setNext((Arrows)newValue);
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
	System.out.println("ArrowsImpl()->eUnset(int featureID)");
    switch (featureID)
    {
      case TdpfPackage.ARROWS__SR:
        setSr((Node)null);
        return;
      case TdpfPackage.ARROWS__NEXT:
        setNext((Arrows)null);
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
      case TdpfPackage.ARROWS__SR:
        return sr != null;
      case TdpfPackage.ARROWS__NEXT:
        return next != null;
    }
    return super.eIsSet(featureID);
  }
  
  
  @Override
  public String toString(){
	  return "Arrows";
  }

  
  
} //ArrowsImpl
