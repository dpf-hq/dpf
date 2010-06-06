/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.EdgeConstraint#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getEdgeConstraint()
 * @model
 * @generated
 */
public interface EdgeConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' reference.
	 * @see #setEdges(Edge)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getEdgeConstraint_Edges()
	 * @model
	 * @generated
	 */
	Edge getEdges();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.EdgeConstraint#getEdges <em>Edges</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edges</em>' reference.
	 * @see #getEdges()
	 * @generated
	 */
	void setEdges(Edge value);

} // EdgeConstraint
