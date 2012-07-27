/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import no.hib.dpf.text.tdpf.EvoCospan;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Evo Cospan</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.EvoCospanImpl#getLhs <em>Lhs</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.EvoCospanImpl#getRhs <em>Rhs</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.EvoCospanImpl#getTypeGraph <em>Type Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EvoCospanImpl extends CommandImpl implements EvoCospan
{
  /**
   * The default value of the '{@link #getLhs() <em>Lhs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLhs()
   * @generated
   * @ordered
   */
  protected static final String LHS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLhs() <em>Lhs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLhs()
   * @generated
   * @ordered
   */
  protected String lhs = LHS_EDEFAULT;

  /**
   * The default value of the '{@link #getRhs() <em>Rhs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRhs()
   * @generated
   * @ordered
   */
  protected static final String RHS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRhs() <em>Rhs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRhs()
   * @generated
   * @ordered
   */
  protected String rhs = RHS_EDEFAULT;

  /**
   * The default value of the '{@link #getTypeGraph() <em>Type Graph</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeGraph()
   * @generated
   * @ordered
   */
  protected static final String TYPE_GRAPH_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeGraph() <em>Type Graph</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeGraph()
   * @generated
   * @ordered
   */
  protected String typeGraph = TYPE_GRAPH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EvoCospanImpl()
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
    return TdpfPackage.Literals.EVO_COSPAN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLhs()
  {
    return lhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLhs(String newLhs)
  {
    String oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.EVO_COSPAN__LHS, oldLhs, lhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRhs()
  {
    return rhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRhs(String newRhs)
  {
    String oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.EVO_COSPAN__RHS, oldRhs, rhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeGraph()
  {
    return typeGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeGraph(String newTypeGraph)
  {
    String oldTypeGraph = typeGraph;
    typeGraph = newTypeGraph;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.EVO_COSPAN__TYPE_GRAPH, oldTypeGraph, typeGraph));
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
      case TdpfPackage.EVO_COSPAN__LHS:
        return getLhs();
      case TdpfPackage.EVO_COSPAN__RHS:
        return getRhs();
      case TdpfPackage.EVO_COSPAN__TYPE_GRAPH:
        return getTypeGraph();
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
      case TdpfPackage.EVO_COSPAN__LHS:
        setLhs((String)newValue);
        return;
      case TdpfPackage.EVO_COSPAN__RHS:
        setRhs((String)newValue);
        return;
      case TdpfPackage.EVO_COSPAN__TYPE_GRAPH:
        setTypeGraph((String)newValue);
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
      case TdpfPackage.EVO_COSPAN__LHS:
        setLhs(LHS_EDEFAULT);
        return;
      case TdpfPackage.EVO_COSPAN__RHS:
        setRhs(RHS_EDEFAULT);
        return;
      case TdpfPackage.EVO_COSPAN__TYPE_GRAPH:
        setTypeGraph(TYPE_GRAPH_EDEFAULT);
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
      case TdpfPackage.EVO_COSPAN__LHS:
        return LHS_EDEFAULT == null ? lhs != null : !LHS_EDEFAULT.equals(lhs);
      case TdpfPackage.EVO_COSPAN__RHS:
        return RHS_EDEFAULT == null ? rhs != null : !RHS_EDEFAULT.equals(rhs);
      case TdpfPackage.EVO_COSPAN__TYPE_GRAPH:
        return TYPE_GRAPH_EDEFAULT == null ? typeGraph != null : !TYPE_GRAPH_EDEFAULT.equals(typeGraph);
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
    result.append(" (lhs: ");
    result.append(lhs);
    result.append(", rhs: ");
    result.append(rhs);
    result.append(", typeGraph: ");
    result.append(typeGraph);
    result.append(')');
    return result.toString();
  }

} //EvoCospanImpl
