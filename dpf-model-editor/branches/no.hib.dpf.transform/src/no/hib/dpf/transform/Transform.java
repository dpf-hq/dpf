/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import no.hib.dpf.core.Specification;

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
 *   <li>{@link no.hib.dpf.transform.Transform#getSourceMeta <em>Source Meta</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getTargetMeta <em>Target Meta</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getJointMeta <em>Joint Meta</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.transform.TransformPackage#getTransform()
 * @model
 * @generated
 */
public interface Transform extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Meta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Meta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Meta</em>' reference.
	 * @see #setSourceMeta(Specification)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_SourceMeta()
	 * @model
	 * @generated
	 */
	Specification getSourceMeta();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getSourceMeta <em>Source Meta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Meta</em>' reference.
	 * @see #getSourceMeta()
	 * @generated
	 */
	void setSourceMeta(Specification value);

	/**
	 * Returns the value of the '<em><b>Target Meta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Meta</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Meta</em>' reference.
	 * @see #setTargetMeta(Specification)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_TargetMeta()
	 * @model
	 * @generated
	 */
	Specification getTargetMeta();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getTargetMeta <em>Target Meta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Meta</em>' reference.
	 * @see #getTargetMeta()
	 * @generated
	 */
	void setTargetMeta(Specification value);

	/**
	 * Returns the value of the '<em><b>Joint Meta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Joint Meta</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Joint Meta</em>' containment reference.
	 * @see #setJointMeta(Specification)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_JointMeta()
	 * @model containment="true"
	 * @generated
	 */
	Specification getJointMeta();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getJointMeta <em>Joint Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Joint Meta</em>' containment reference.
	 * @see #getJointMeta()
	 * @generated
	 */
	void setJointMeta(Specification value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.transform.Reduction}.
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
	EList<Reduction> getRules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Specification> getMappings(Specification model, Reduction rule);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Specification applyReduction(Specification model, Reduction rule);

} // Transform
