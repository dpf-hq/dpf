/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import java.util.Collection;

import no.hib.dpf.text.tdpf.ChoosenSpecfication;
import no.hib.dpf.text.tdpf.ConstraintSemantic;
import no.hib.dpf.text.tdpf.InstanceSpecification;
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
 * An implementation of the model object '<em><b>Instance Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.InstanceSpecificationImpl#getId <em>Id</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.InstanceSpecificationImpl#getModel <em>Model</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.InstanceSpecificationImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link no.hib.dpf.text.tdpf.impl.InstanceSpecificationImpl#getConstraintSemantics <em>Constraint Semantics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceSpecificationImpl extends DefinitionImpl implements InstanceSpecification
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
   * The cached value of the '{@link #getModel() <em>Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModel()
   * @generated
   * @ordered
   */
  protected ChoosenSpecfication model;

  /**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected ChoosenSpecfication metamodel;

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
  protected InstanceSpecificationImpl()
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
    return TdpfPackage.Literals.INSTANCE_SPECIFICATION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.INSTANCE_SPECIFICATION__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoosenSpecfication getModel()
  {
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModel(ChoosenSpecfication newModel, NotificationChain msgs)
  {
    ChoosenSpecfication oldModel = model;
    model = newModel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.INSTANCE_SPECIFICATION__MODEL, oldModel, newModel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModel(ChoosenSpecfication newModel)
  {
    if (newModel != model)
    {
      NotificationChain msgs = null;
      if (model != null)
        msgs = ((InternalEObject)model).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.INSTANCE_SPECIFICATION__MODEL, null, msgs);
      if (newModel != null)
        msgs = ((InternalEObject)newModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.INSTANCE_SPECIFICATION__MODEL, null, msgs);
      msgs = basicSetModel(newModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.INSTANCE_SPECIFICATION__MODEL, newModel, newModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoosenSpecfication getMetamodel()
  {
    return metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMetamodel(ChoosenSpecfication newMetamodel, NotificationChain msgs)
  {
    ChoosenSpecfication oldMetamodel = metamodel;
    metamodel = newMetamodel;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL, oldMetamodel, newMetamodel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetamodel(ChoosenSpecfication newMetamodel)
  {
    if (newMetamodel != metamodel)
    {
      NotificationChain msgs = null;
      if (metamodel != null)
        msgs = ((InternalEObject)metamodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL, null, msgs);
      if (newMetamodel != null)
        msgs = ((InternalEObject)newMetamodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL, null, msgs);
      msgs = basicSetMetamodel(newMetamodel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL, newMetamodel, newMetamodel));
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
      constraintSemantics = new EObjectContainmentEList<ConstraintSemantic>(ConstraintSemantic.class, this, TdpfPackage.INSTANCE_SPECIFICATION__CONSTRAINT_SEMANTICS);
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
      case TdpfPackage.INSTANCE_SPECIFICATION__MODEL:
        return basicSetModel(null, msgs);
      case TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL:
        return basicSetMetamodel(null, msgs);
      case TdpfPackage.INSTANCE_SPECIFICATION__CONSTRAINT_SEMANTICS:
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
      case TdpfPackage.INSTANCE_SPECIFICATION__ID:
        return getId();
      case TdpfPackage.INSTANCE_SPECIFICATION__MODEL:
        return getModel();
      case TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL:
        return getMetamodel();
      case TdpfPackage.INSTANCE_SPECIFICATION__CONSTRAINT_SEMANTICS:
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
      case TdpfPackage.INSTANCE_SPECIFICATION__ID:
        setId((String)newValue);
        return;
      case TdpfPackage.INSTANCE_SPECIFICATION__MODEL:
        setModel((ChoosenSpecfication)newValue);
        return;
      case TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL:
        setMetamodel((ChoosenSpecfication)newValue);
        return;
      case TdpfPackage.INSTANCE_SPECIFICATION__CONSTRAINT_SEMANTICS:
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
      case TdpfPackage.INSTANCE_SPECIFICATION__ID:
        setId(ID_EDEFAULT);
        return;
      case TdpfPackage.INSTANCE_SPECIFICATION__MODEL:
        setModel((ChoosenSpecfication)null);
        return;
      case TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL:
        setMetamodel((ChoosenSpecfication)null);
        return;
      case TdpfPackage.INSTANCE_SPECIFICATION__CONSTRAINT_SEMANTICS:
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
      case TdpfPackage.INSTANCE_SPECIFICATION__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case TdpfPackage.INSTANCE_SPECIFICATION__MODEL:
        return model != null;
      case TdpfPackage.INSTANCE_SPECIFICATION__METAMODEL:
        return metamodel != null;
      case TdpfPackage.INSTANCE_SPECIFICATION__CONSTRAINT_SEMANTICS:
        return constraintSemantics != null && !constraintSemantics.isEmpty();
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

} //InstanceSpecificationImpl
