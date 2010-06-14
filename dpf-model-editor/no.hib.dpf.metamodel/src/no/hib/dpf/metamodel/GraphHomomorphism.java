/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

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
 *   <li>{@link no.hib.dpf.metamodel.GraphHomomorphism#getNodeMapping <em>Node Mapping</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.GraphHomomorphism#getEdgeMapping <em>Edge Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism()
 * @model
 * @generated
 */
public interface GraphHomomorphism extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Mapping</em>' reference.
	 * @see #setNodeMapping(Map.Entry)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism_NodeMapping()
	 * @model mapType="no.hib.dpf.metamodel.NodeToNodeMap<no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node>"
	 * @generated
	 */
	Map.Entry<Node, Node> getNodeMapping();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.GraphHomomorphism#getNodeMapping <em>Node Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Mapping</em>' reference.
	 * @see #getNodeMapping()
	 * @generated
	 */
	void setNodeMapping(Map.Entry<Node, Node> value);

	/**
	 * Returns the value of the '<em><b>Edge Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Mapping</em>' reference.
	 * @see #setEdgeMapping(Map.Entry)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism_EdgeMapping()
	 * @model mapType="no.hib.dpf.metamodel.EdgeToEdgeMap<no.hib.dpf.metamodel.Edge, no.hib.dpf.metamodel.Edge>"
	 * @generated
	 */
	Map.Entry<Edge, Edge> getEdgeMapping();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.GraphHomomorphism#getEdgeMapping <em>Edge Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge Mapping</em>' reference.
	 * @see #getEdgeMapping()
	 * @generated
	 */
	void setEdgeMapping(Map.Entry<Edge, Edge> value);

} // GraphHomomorphism
