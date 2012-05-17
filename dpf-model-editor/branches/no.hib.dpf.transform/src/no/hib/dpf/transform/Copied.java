/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Copied</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.Copied#getCopiedType <em>Copied Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.transform.TransformPackage#getCopied()
 * @model
 * @generated
 */
public interface Copied extends EObject {
	/**
	 * Returns the value of the '<em><b>Copied Type</b></em>' attribute.
	 * The literals are from the enumeration {@link no.hib.dpf.transform.CopiedType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copied Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copied Type</em>' attribute.
	 * @see no.hib.dpf.transform.CopiedType
	 * @see #setCopiedType(CopiedType)
	 * @see no.hib.dpf.transform.TransformPackage#getCopied_CopiedType()
	 * @model
	 * @generated
	 */
	CopiedType getCopiedType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.Copied#getCopiedType <em>Copied Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copied Type</em>' attribute.
	 * @see no.hib.dpf.transform.CopiedType
	 * @see #getCopiedType()
	 * @generated
	 */
	void setCopiedType(CopiedType value);

} // Copied
