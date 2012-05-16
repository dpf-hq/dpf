/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import no.hib.dpf.core.Specification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ex Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.ExSpecification#getExgraph <em>Exgraph</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.transform.TransformPackage#getExSpecification()
 * @model
 * @generated
 */
public interface ExSpecification extends Specification {
	/**
	 * Returns the value of the '<em><b>Exgraph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exgraph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exgraph</em>' containment reference.
	 * @see #setExgraph(ExGraph)
	 * @see no.hib.dpf.transform.TransformPackage#getExSpecification_Exgraph()
	 * @model containment="true"
	 * @generated
	 */
	ExGraph getExgraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.transform.ExSpecification#getExgraph <em>Exgraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exgraph</em>' containment reference.
	 * @see #getExgraph()
	 * @generated
	 */
	void setExgraph(ExGraph value);

} // ExSpecification
