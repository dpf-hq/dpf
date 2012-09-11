/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.Transform#getMetaModel <em>Meta Model</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getRules <em>Rules</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getDSignature <em>DSignature</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.transform.TransformPackage#getTransform()
 * @model
 * @generated
 */
public interface Transform extends EObject {
	/**
	 * Returns the value of the '<em><b>Meta Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Model</em>' containment reference.
	 * @see #setMetaModel(DSpecification)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_MetaModel()
	 * @model containment="true"
	 * @generated
	 */
	DSpecification getMetaModel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getMetaModel <em>Meta Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Model</em>' containment reference.
	 * @see #getMetaModel()
	 * @generated
	 */
	void setMetaModel(DSpecification value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.transform.Production}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Production> getRules();

	/**
	 * Returns the value of the '<em><b>DSignature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSignature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSignature</em>' reference.
	 * @see #setDSignature(DSignature)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_DSignature()
	 * @model
	 * @generated
	 */
	DSignature getDSignature();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getDSignature <em>DSignature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DSignature</em>' reference.
	 * @see #getDSignature()
	 * @generated
	 */
	void setDSignature(DSignature value);

} // Transform
