/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.transform;

import no.hib.dpf.core.Graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ex Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.transform.ExGraph#getMapArrow <em>Map Arrow</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.transform.TransformPackage#getExGraph()
 * @model
 * @generated
 */
public interface ExGraph extends Graph {
	/**
	 * Returns the value of the '<em><b>Map Arrow</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.transform.MapArrow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Arrow</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Arrow</em>' containment reference list.
	 * @see no.hib.dpf.transform.TransformPackage#getExGraph_MapArrow()
	 * @model containment="true"
	 * @generated
	 */
	EList<MapArrow> getMapArrow();

} // ExGraph
