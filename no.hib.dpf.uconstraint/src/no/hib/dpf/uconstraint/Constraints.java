/**
 */
package no.hib.dpf.uconstraint;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraints</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.uconstraint.Constraints#getRules <em>Rules</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.Constraints#getDSignature <em>DSignature</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.Constraints#getElementTypeGraph <em>Element Type Graph</em>}</li>
 *   <li>{@link no.hib.dpf.uconstraint.Constraints#getSourceLocation <em>Source Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.uconstraint.UConstraintPackage#getConstraints()
 * @model
 * @generated
 */
public interface Constraints extends EObject {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.uconstraint.UConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getConstraints_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<UConstraint> getRules();

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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getConstraints_DSignature()
	 * @model
	 * @generated
	 */
	DSignature getDSignature();

	/**
	 * Sets the value of the '{@link no.hib.dpf.uconstraint.Constraints#getDSignature <em>DSignature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DSignature</em>' reference.
	 * @see #getDSignature()
	 * @generated
	 */
	void setDSignature(DSignature value);

	/**
	 * Returns the value of the '<em><b>Element Type Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Graph</em>' reference.
	 * @see #setElementTypeGraph(DSpecification)
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getConstraints_ElementTypeGraph()
	 * @model
	 * @generated
	 */
	DSpecification getElementTypeGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.uconstraint.Constraints#getElementTypeGraph <em>Element Type Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Graph</em>' reference.
	 * @see #getElementTypeGraph()
	 * @generated
	 */
	void setElementTypeGraph(DSpecification value);

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
	 * @see no.hib.dpf.uconstraint.UConstraintPackage#getConstraints_SourceLocation()
	 * @model
	 * @generated
	 */
	String getSourceLocation();

	/**
	 * Sets the value of the '{@link no.hib.dpf.uconstraint.Constraints#getSourceLocation <em>Source Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Location</em>' attribute.
	 * @see #getSourceLocation()
	 * @generated
	 */
	void setSourceLocation(String value);

} // Constraints
