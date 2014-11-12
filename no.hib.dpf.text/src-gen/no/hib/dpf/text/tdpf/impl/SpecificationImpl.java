/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import java.util.Collection;

import no.hib.dpf.text.tdpf.ChoosenConstraintSemantic;
import no.hib.dpf.text.tdpf.ChoosenSpecification;
import no.hib.dpf.text.tdpf.Constraint;
import no.hib.dpf.text.tdpf.Graph;
import no.hib.dpf.text.tdpf.SequenceNumber;
import no.hib.dpf.text.tdpf.Specification;
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
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SpecificationImpl#getType <em>Type</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SpecificationImpl#getConstraintSemantic <em>Constraint Semantic</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SpecificationImpl#getSequenceNumber <em>Sequence Number</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SpecificationImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.SpecificationImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationImpl extends ModelImpl implements Specification
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ChoosenSpecification type;

  /**
   * The cached value of the '{@link #getConstraintSemantic() <em>Constraint Semantic</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintSemantic()
   * @generated
   * @ordered
   */
  protected ChoosenConstraintSemantic constraintSemantic;

  /**
   * The cached value of the '{@link #getSequenceNumber() <em>Sequence Number</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceNumber()
   * @generated
   * @ordered
   */
  protected SequenceNumber sequenceNumber;

  /**
   * The cached value of the '{@link #getGraph() <em>Graph</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGraph()
   * @generated
   * @ordered
   */
  protected Graph graph;

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected EList<Constraint> constraints;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecificationImpl()
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
    return TdpfPackage.Literals.SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoosenSpecification getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(ChoosenSpecification newType, NotificationChain msgs)
  {
    ChoosenSpecification oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.SPECIFICATION__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(ChoosenSpecification newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.SPECIFICATION__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.SPECIFICATION__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.SPECIFICATION__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoosenConstraintSemantic getConstraintSemantic()
  {
    return constraintSemantic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConstraintSemantic(ChoosenConstraintSemantic newConstraintSemantic, NotificationChain msgs)
  {
    ChoosenConstraintSemantic oldConstraintSemantic = constraintSemantic;
    constraintSemantic = newConstraintSemantic;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC, oldConstraintSemantic, newConstraintSemantic);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintSemantic(ChoosenConstraintSemantic newConstraintSemantic)
  {
    if (newConstraintSemantic != constraintSemantic)
    {
      NotificationChain msgs = null;
      if (constraintSemantic != null)
        msgs = ((InternalEObject)constraintSemantic).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC, null, msgs);
      if (newConstraintSemantic != null)
        msgs = ((InternalEObject)newConstraintSemantic).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC, null, msgs);
      msgs = basicSetConstraintSemantic(newConstraintSemantic, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC, newConstraintSemantic, newConstraintSemantic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequenceNumber getSequenceNumber()
  {
    return sequenceNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceNumber(SequenceNumber newSequenceNumber, NotificationChain msgs)
  {
    SequenceNumber oldSequenceNumber = sequenceNumber;
    sequenceNumber = newSequenceNumber;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER, oldSequenceNumber, newSequenceNumber);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceNumber(SequenceNumber newSequenceNumber)
  {
    if (newSequenceNumber != sequenceNumber)
    {
      NotificationChain msgs = null;
      if (sequenceNumber != null)
        msgs = ((InternalEObject)sequenceNumber).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER, null, msgs);
      if (newSequenceNumber != null)
        msgs = ((InternalEObject)newSequenceNumber).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER, null, msgs);
      msgs = basicSetSequenceNumber(newSequenceNumber, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER, newSequenceNumber, newSequenceNumber));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Graph getGraph()
  {
    return graph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs)
  {
    Graph oldGraph = graph;
    graph = newGraph;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.SPECIFICATION__GRAPH, oldGraph, newGraph);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGraph(Graph newGraph)
  {
    if (newGraph != graph)
    {
      NotificationChain msgs = null;
      if (graph != null)
        msgs = ((InternalEObject)graph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.SPECIFICATION__GRAPH, null, msgs);
      if (newGraph != null)
        msgs = ((InternalEObject)newGraph).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.SPECIFICATION__GRAPH, null, msgs);
      msgs = basicSetGraph(newGraph, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.SPECIFICATION__GRAPH, newGraph, newGraph));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Constraint> getConstraints()
  {
    if (constraints == null)
    {
      constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, TdpfPackage.SPECIFICATION__CONSTRAINTS);
    }
    return constraints;
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
      case TdpfPackage.SPECIFICATION__TYPE:
        return basicSetType(null, msgs);
      case TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC:
        return basicSetConstraintSemantic(null, msgs);
      case TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER:
        return basicSetSequenceNumber(null, msgs);
      case TdpfPackage.SPECIFICATION__GRAPH:
        return basicSetGraph(null, msgs);
      case TdpfPackage.SPECIFICATION__CONSTRAINTS:
        return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
      case TdpfPackage.SPECIFICATION__TYPE:
        return getType();
      case TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC:
        return getConstraintSemantic();
      case TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER:
        return getSequenceNumber();
      case TdpfPackage.SPECIFICATION__GRAPH:
        return getGraph();
      case TdpfPackage.SPECIFICATION__CONSTRAINTS:
        return getConstraints();
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
      case TdpfPackage.SPECIFICATION__TYPE:
        setType((ChoosenSpecification)newValue);
        return;
      case TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC:
        setConstraintSemantic((ChoosenConstraintSemantic)newValue);
        return;
      case TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER:
        setSequenceNumber((SequenceNumber)newValue);
        return;
      case TdpfPackage.SPECIFICATION__GRAPH:
        setGraph((Graph)newValue);
        return;
      case TdpfPackage.SPECIFICATION__CONSTRAINTS:
        getConstraints().clear();
        getConstraints().addAll((Collection<? extends Constraint>)newValue);
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
      case TdpfPackage.SPECIFICATION__TYPE:
        setType((ChoosenSpecification)null);
        return;
      case TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC:
        setConstraintSemantic((ChoosenConstraintSemantic)null);
        return;
      case TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER:
        setSequenceNumber((SequenceNumber)null);
        return;
      case TdpfPackage.SPECIFICATION__GRAPH:
        setGraph((Graph)null);
        return;
      case TdpfPackage.SPECIFICATION__CONSTRAINTS:
        getConstraints().clear();
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
      case TdpfPackage.SPECIFICATION__TYPE:
        return type != null;
      case TdpfPackage.SPECIFICATION__CONSTRAINT_SEMANTIC:
        return constraintSemantic != null;
      case TdpfPackage.SPECIFICATION__SEQUENCE_NUMBER:
        return sequenceNumber != null;
      case TdpfPackage.SPECIFICATION__GRAPH:
        return graph != null;
      case TdpfPackage.SPECIFICATION__CONSTRAINTS:
        return constraints != null && !constraints.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SpecificationImpl
