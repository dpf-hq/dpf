/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph To Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.core.GraphToConstraint#getNodesToConstraints <em>Nodes To Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.GraphToConstraint#getArrowsToConstraints <em>Arrows To Constraints</em>}</li>
 *   <li>{@link no.hib.dpf.core.GraphToConstraint#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.core.CorePackage#getGraphToConstraint()
 * @model
 * @generated
 */
public interface GraphToConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes To Constraints</b></em>' reference list.
	 * The list contents are of type {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes To Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes To Constraints</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getGraphToConstraint_NodesToConstraints()
	 * @model mapType="no.hib.dpf.core.NodeToConstraintMap<no.hib.dpf.core.Node, no.hib.dpf.core.Constraint>"
	 * @generated NOT
	 */
	EList<Entry<Node, EList<Constraint>>> getNodesToConstraints();

	/**
	 * Returns the value of the '<em><b>Arrows To Constraints</b></em>' reference list.
	 * The list contents are of type {@link java.util.Map.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrows To Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrows To Constraints</em>' reference list.
	 * @see no.hib.dpf.core.CorePackage#getGraphToConstraint_ArrowsToConstraints()
	 * @model mapType="no.hib.dpf.core.ArrowToConstraintMap<no.hib.dpf.core.Arrow, no.hib.dpf.core.Constraint>"
	 * @generated NOT
	 */
	EList<Map.Entry<Arrow, EList<Constraint>>> getArrowsToConstraints();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.core.Specification#getGraphToConstraint <em>Graph To Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' container reference.
	 * @see #setSpecification(Specification)
	 * @see no.hib.dpf.core.CorePackage#getGraphToConstraint_Specification()
	 * @see no.hib.dpf.core.Specification#getGraphToConstraint
	 * @model opposite="graphToConstraint" required="true" transient="false"
	 * @generated
	 */
	Specification getSpecification();

	/**
	 * Sets the value of the '{@link no.hib.dpf.core.GraphToConstraint#getSpecification <em>Specification</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' container reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(Specification value);

} // GraphToConstraint
