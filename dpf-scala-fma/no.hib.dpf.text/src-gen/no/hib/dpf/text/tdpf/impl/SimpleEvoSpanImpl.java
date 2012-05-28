/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import no.hib.dpf.text.tdpf.SimpleEvoSpan;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Evo Span</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SimpleEvoSpanImpl#getLhs <em>Lhs</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SimpleEvoSpanImpl#getDiff <em>Diff</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SimpleEvoSpanImpl#getRhS <em>Rh S</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SimpleEvoSpanImpl#getTypeGraph <em>Type Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleEvoSpanImpl extends DefinitionImpl implements SimpleEvoSpan
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
   * The default value of the '{@link #getDiff() <em>Diff</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiff()
   * @generated
   * @ordered
   */
  protected static final String DIFF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDiff() <em>Diff</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDiff()
   * @generated
   * @ordered
   */
  protected String diff = DIFF_EDEFAULT;

  /**
   * The default value of the '{@link #getRhS() <em>Rh S</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRhS()
   * @generated
   * @ordered
   */
  protected static final String RH_S_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRhS() <em>Rh S</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRhS()
   * @generated
   * @ordered
   */
  protected String rhS = RH_S_EDEFAULT;

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
  protected SimpleEvoSpanImpl()
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
    return TdpfPackage.Literals.SIMPLE_EVO_SPAN;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.SIMPLE_EVO_SPAN__LHS, oldLhs, lhs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDiff()
  {
    return diff;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDiff(String newDiff)
  {
    String oldDiff = diff;
    diff = newDiff;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.SIMPLE_EVO_SPAN__DIFF, oldDiff, diff));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRhS()
  {
    return rhS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRhS(String newRhS)
  {
    String oldRhS = rhS;
    rhS = newRhS;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.SIMPLE_EVO_SPAN__RH_S, oldRhS, rhS));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.SIMPLE_EVO_SPAN__TYPE_GRAPH, oldTypeGraph, typeGraph));
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
      case TdpfPackage.SIMPLE_EVO_SPAN__LHS:
        return getLhs();
      case TdpfPackage.SIMPLE_EVO_SPAN__DIFF:
        return getDiff();
      case TdpfPackage.SIMPLE_EVO_SPAN__RH_S:
        return getRhS();
      case TdpfPackage.SIMPLE_EVO_SPAN__TYPE_GRAPH:
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
      case TdpfPackage.SIMPLE_EVO_SPAN__LHS:
        setLhs((String)newValue);
        return;
      case TdpfPackage.SIMPLE_EVO_SPAN__DIFF:
        setDiff((String)newValue);
        return;
      case TdpfPackage.SIMPLE_EVO_SPAN__RH_S:
        setRhS((String)newValue);
        return;
      case TdpfPackage.SIMPLE_EVO_SPAN__TYPE_GRAPH:
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
      case TdpfPackage.SIMPLE_EVO_SPAN__LHS:
        setLhs(LHS_EDEFAULT);
        return;
      case TdpfPackage.SIMPLE_EVO_SPAN__DIFF:
        setDiff(DIFF_EDEFAULT);
        return;
      case TdpfPackage.SIMPLE_EVO_SPAN__RH_S:
        setRhS(RH_S_EDEFAULT);
        return;
      case TdpfPackage.SIMPLE_EVO_SPAN__TYPE_GRAPH:
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
      case TdpfPackage.SIMPLE_EVO_SPAN__LHS:
        return LHS_EDEFAULT == null ? lhs != null : !LHS_EDEFAULT.equals(lhs);
      case TdpfPackage.SIMPLE_EVO_SPAN__DIFF:
        return DIFF_EDEFAULT == null ? diff != null : !DIFF_EDEFAULT.equals(diff);
      case TdpfPackage.SIMPLE_EVO_SPAN__RH_S:
        return RH_S_EDEFAULT == null ? rhS != null : !RH_S_EDEFAULT.equals(rhS);
      case TdpfPackage.SIMPLE_EVO_SPAN__TYPE_GRAPH:
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
    result.append(", diff: ");
    result.append(diff);
    result.append(", rhS: ");
    result.append(rhS);
    result.append(", typeGraph: ");
    result.append(typeGraph);
    result.append(')');
    return result.toString();
  }

} //SimpleEvoSpanImpl
