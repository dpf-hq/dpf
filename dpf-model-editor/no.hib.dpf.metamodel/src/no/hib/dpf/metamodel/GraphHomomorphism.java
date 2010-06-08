/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

import org.eclipse.emf.common.util.EMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Homomorphism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.GraphHomomorphism#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.GraphHomomorphism#getTarget <em>Target</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.GraphHomomorphism#getTyping <em>Typing</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism()
 * @model
 * @generated
 */
public interface GraphHomomorphism extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism_Source()
	 * @model
	 * @generated
	 */
	Graph getSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.GraphHomomorphism#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Graph value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism_Target()
	 * @model
	 * @generated
	 */
	Graph getTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.GraphHomomorphism#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Graph value);

	/**
	 * Returns the value of the '<em><b>Typing</b></em>' map.
	 * The key is of type {@link no.hib.dpf.metamodel.Node},
	 * and the value is of type {@link no.hib.dpf.metamodel.Node},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typing</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typing</em>' map.
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism_Typing()
	 * @model mapType="no.hib.dpf.metamodel.NodeToNodeMap<no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node>"
	 * @generated
	 */
	EMap<Node, Node> getTyping();

} // GraphHomomorphism