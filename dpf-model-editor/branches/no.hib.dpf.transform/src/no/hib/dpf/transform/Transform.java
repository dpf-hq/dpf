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
 *   <li>{@link no.hib.dpf.transform.Transform#getSourceMetaModel <em>Source Meta Model</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getTargetMetaModel <em>Target Meta Model</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getRules <em>Rules</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getDSignature <em>DSignature</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#isGenerate <em>Generate</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getSourceLocation <em>Source Location</em>}</li>
 *   <li>{@link no.hib.dpf.transform.Transform#getTargetLocation <em>Target Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.transform.TransformPackage#getTransform()
 * @model
 * @generated
 */
public interface Transform extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Meta Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Meta Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Meta Model</em>' containment reference.
	 * @see #setSourceMetaModel(DSpecification)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_SourceMetaModel()
	 * @model containment="true"
	 * @generated
	 */
	DSpecification getSourceMetaModel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getSourceMetaModel <em>Source Meta Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Meta Model</em>' containment reference.
	 * @see #getSourceMetaModel()
	 * @generated
	 */
	void setSourceMetaModel(DSpecification value);

	/**
	 * Returns the value of the '<em><b>Target Meta Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Meta Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Meta Model</em>' containment reference.
	 * @see #setTargetMetaModel(DSpecification)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_TargetMetaModel()
	 * @model containment="true"
	 * @generated
	 */
	DSpecification getTargetMetaModel();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getTargetMetaModel <em>Target Meta Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Meta Model</em>' containment reference.
	 * @see #getTargetMetaModel()
	 * @generated
	 */
	void setTargetMetaModel(DSpecification value);

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

	/**
	 * Returns the value of the '<em><b>Generate</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate</em>' attribute.
	 * @see #setGenerate(boolean)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_Generate()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isGenerate();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#isGenerate <em>Generate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate</em>' attribute.
	 * @see #isGenerate()
	 * @generated
	 */
	void setGenerate(boolean value);

	/**
	 * Returns the value of the '<em><b>Source Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Location</em>' attribute.
	 * @see #setSourceLocation(String)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_SourceLocation()
	 * @model
	 * @generated
	 */
	String getSourceLocation();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getSourceLocation <em>Source Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Location</em>' attribute.
	 * @see #getSourceLocation()
	 * @generated
	 */
	void setSourceLocation(String value);

	/**
	 * Returns the value of the '<em><b>Target Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Location</em>' attribute.
	 * @see #setTargetLocation(String)
	 * @see no.hib.dpf.transform.TransformPackage#getTransform_TargetLocation()
	 * @model
	 * @generated
	 */
	String getTargetLocation();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Transform#getTargetLocation <em>Target Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Location</em>' attribute.
	 * @see #getTargetLocation()
	 * @generated
	 */
	void setTargetLocation(String value);

} // Transform
