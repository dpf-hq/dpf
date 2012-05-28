/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import java.util.Collection;

import no.hib.dpf.text.tdpf.Element;
import no.hib.dpf.text.tdpf.ExtSubTGraph;
import no.hib.dpf.text.tdpf.TGraphExtSubName;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ext Sub TGraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.ExtSubTGraphImpl#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.ExtSubTGraphImpl#getExtendsGraph <em>Extends Graph</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.ExtSubTGraphImpl#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtSubTGraphImpl extends DefinitionImpl implements ExtSubTGraph
{
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getExtendsGraph() <em>Extends Graph</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtendsGraph()
   * @generated
   * @ordered
   */
  protected TGraphExtSubName extendsGraph;

  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<Element> elements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtSubTGraphImpl()
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
    return TdpfPackage.Literals.EXT_SUB_TGRAPH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(String newId)
  {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.EXT_SUB_TGRAPH__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TGraphExtSubName getExtendsGraph()
  {
    return extendsGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtendsGraph(TGraphExtSubName newExtendsGraph, NotificationChain msgs)
  {
    TGraphExtSubName oldExtendsGraph = extendsGraph;
    extendsGraph = newExtendsGraph;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH, oldExtendsGraph, newExtendsGraph);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtendsGraph(TGraphExtSubName newExtendsGraph)
  {
    if (newExtendsGraph != extendsGraph)
    {
      NotificationChain msgs = null;
      if (extendsGraph != null)
        msgs = ((InternalEObject)extendsGraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH, null, msgs);
      if (newExtendsGraph != null)
        msgs = ((InternalEObject)newExtendsGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH, null, msgs);
      msgs = basicSetExtendsGraph(newExtendsGraph, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH, newExtendsGraph, newExtendsGraph));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Element> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentEList<Element>(Element.class, this, TdpfPackage.EXT_SUB_TGRAPH__ELEMENTS);
    }
    return elements;
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
      case TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH:
        return basicSetExtendsGraph(null, msgs);
      case TdpfPackage.EXT_SUB_TGRAPH__ELEMENTS:
        return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
      case TdpfPackage.EXT_SUB_TGRAPH__ID:
        return getId();
      case TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH:
        return getExtendsGraph();
      case TdpfPackage.EXT_SUB_TGRAPH__ELEMENTS:
        return getElements();
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
      case TdpfPackage.EXT_SUB_TGRAPH__ID:
        setId((String)newValue);
        return;
      case TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH:
        setExtendsGraph((TGraphExtSubName)newValue);
        return;
      case TdpfPackage.EXT_SUB_TGRAPH__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends Element>)newValue);
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
      case TdpfPackage.EXT_SUB_TGRAPH__ID:
        setId(ID_EDEFAULT);
        return;
      case TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH:
        setExtendsGraph((TGraphExtSubName)null);
        return;
      case TdpfPackage.EXT_SUB_TGRAPH__ELEMENTS:
        getElements().clear();
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
      case TdpfPackage.EXT_SUB_TGRAPH__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case TdpfPackage.EXT_SUB_TGRAPH__EXTENDS_GRAPH:
        return extendsGraph != null;
      case TdpfPackage.EXT_SUB_TGRAPH__ELEMENTS:
        return elements != null && !elements.isEmpty();
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
    result.append(" (id: ");
    result.append(id);
    result.append(')');
    return result.toString();
  }

} //ExtSubTGraphImpl
