/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends ElementImpl implements Node
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeImpl()
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
    return TdpfPackage.Literals.NODE;
  }

  
  @Override
  public String toString(){
    return "Node";
  }  
} //NodeImpl
