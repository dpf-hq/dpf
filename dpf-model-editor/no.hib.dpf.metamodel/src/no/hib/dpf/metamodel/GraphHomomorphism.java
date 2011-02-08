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
 *   <li>{@link no.hib.dpf.metamodel.GraphHomomorphism#getArrowMapping <em>Arrow Mapping</em>}</li>
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
	 * Returns the value of the '<em><b>Arrow Mapping</b></em>' map.
	 * The key is of type {@link no.hib.dpf.metamodel.Arrow},
	 * and the value is of type {@link no.hib.dpf.metamodel.Arrow},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrow Mapping</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrow Mapping</em>' map.
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraphHomomorphism_ArrowMapping()
	 * @model mapType="no.hib.dpf.metamodel.ArrowToArrowMap<no.hib.dpf.metamodel.Arrow, no.hib.dpf.metamodel.Arrow>"
	 * @generated
	 */
	EMap<Arrow, Arrow> getArrowMapping();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" edgesMany="true"
	 * @generated
	 */
	boolean tryToCreateGraphHomomorphism(Graph sourceGraph, EList<Node> nodes, EList<Arrow> edges);

} // GraphHomomorphism
