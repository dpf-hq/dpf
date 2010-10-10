/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
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
	 * Returns the value of the '<em><b>Node Mapping</b></em>' map.
	 * The key is of type {@link no.hib.dpf.metamodel.Node},
	 * and the value is of type {@link no.hib.dpf.metamodel.Node},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Mapping</em>' map.
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism_NodeMapping()
	 * @model mapType="no.hib.dpf.metamodel.NodeToNodeMap<no.hib.dpf.metamodel.Node, no.hib.dpf.metamodel.Node>"
	 * @generated
	 */
	EMap<Node, Node> getNodeMapping();

	/**
	 * Returns the value of the '<em><b>Edge Mapping</b></em>' map.
	 * The key is of type {@link no.hib.dpf.metamodel.Edge},
	 * and the value is of type {@link no.hib.dpf.metamodel.Edge},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Mapping</em>' map.
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism_EdgeMapping()
	 * @model mapType="no.hib.dpf.metamodel.EdgeToEdgeMap<no.hib.dpf.metamodel.Edge, no.hib.dpf.metamodel.Edge>"
	 * @generated
	 */
	EMap<Edge, Edge> getEdgeMapping();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="false" edgesMany="false"
	 * @generated
	 */
	boolean canCreateBijectiveGraphHomomorphism(Graph sourceGraph, EList<?> nodes, EList<?> edges);

} // GraphHomomorphism
