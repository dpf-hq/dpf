/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Homomorphism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getNodeMapping <em>Node Mapping</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.impl.GraphHomomorphismImpl#getEdgeMapping <em>Edge Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphHomomorphismImpl extends EObjectImpl implements GraphHomomorphism {
	/**
	 * The cached value of the '{@link #getNodeMapping() <em>Node Mapping</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeMapping()
	 * @generated
	 * @ordered
	 */
	protected EMap<Node, Node> nodeMapping;

	/**
	 * The cached value of the '{@link #getEdgeMapping() <em>Edge Mapping</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeMapping()
	 * @generated
	 * @ordered
	 */
	protected EMap<Edge, Edge> edgeMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphHomomorphismImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.GRAPH_HOMOMORPHISM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Node, Node> getNodeMapping() {
		if (nodeMapping == null) {
			nodeMapping = new EcoreEMap<Node,Node>(MetamodelPackage.Literals.NODE_TO_NODE_MAP, NodeToNodeMapImpl.class, this, MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING);
		}
		return nodeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Edge, Edge> getEdgeMapping() {
		if (edgeMapping == null) {
			edgeMapping = new EcoreEMap<Edge,Edge>(MetamodelPackage.Literals.EDGE_TO_EDGE_MAP, EdgeToEdgeMapImpl.class, this, MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING);
		}
		return edgeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canCreateBijectiveGraphHomomorphism(Graph sourceGraph, EList<?> nodes, EList<?> edges) {
		if ((sourceGraph.getEdges().size() != edges.size()) ||
			(sourceGraph.getNodes().size() != nodes.size())) {
			return false;
		}
		if (sourceGraph.getNodes().size() == 0) {
			return true;
		}
		// Check that mappings from node to node and arrow to arrow preserving structure can be made:
		
		Node[] sourceNodes = sourceGraph.getNodes().toArray(new Node[sourceGraph.getNodes().size()]);
		Node[] targetNodes = nodes.toArray(new Node[nodes.size()]);
		
		// For all permutations of the target nodes:
		List<Node[]> targetNodePermutations = heapPermuteExec(targetNodes);
		for (int i = 0; i < targetNodePermutations.size(); i++) {
			EcoreEMap<Node,Node> mapping = createMapping(sourceNodes, targetNodePermutations, i);
			if (testMapping(mapping)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks a mapping to see wether it indicates a valid graph homomorphism
	 * if the edges are mapped "one to one". TODO: explain this. Also to self.
	 * @generated NOT
	 */
	private boolean testMapping(EcoreEMap<Node,Node> mapping) {
		// Check to see wether the mapped nodes have the same number of input and output edges:
		for (Node key : mapping.keySet()) {
			Node value = mapping.get(key);
			if (key.getOutgoingEdges().size() != value.getOutgoingEdges().size()) {
				return false;
			}
		}
	    // Now, check to see if we can follow every outgoing edge and end up on
		// the same node by following the edges directly and through mappings:
		
		return true;
	}

	/**
	 * Creates mappings from the source nodes to the indexed permutation of the target nodes.
	 * 
	 * Expects souce and target node arrays of same length.
	 * 
	 * @generated NOT
	 */
	private EcoreEMap<Node,Node> createMapping(Node [] sourceNodes, List<Node[]> targetNodePermutations, int permutationIndex) {
		EcoreEMap<Node,Node> retval = new EcoreEMap<Node,Node>(MetamodelPackage.Literals.NODE_TO_NODE_MAP, NodeToNodeMapImpl.class, this, MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING);
		
		Node[] targetNodes = targetNodePermutations.get(permutationIndex);
			
		for (int i = 0; i < sourceNodes.length; i++) {
			NodeToNodeMapImpl nodeToNodeMap = new NodeToNodeMapImpl();
			nodeToNodeMap.key = sourceNodes[i];
			nodeToNodeMap.value = targetNodes[i];
			retval.add(nodeToNodeMap);			
		}
		
		return retval;
	}	
	
	/**
	 * Makes permutations of the items in the array. This should not be
	 * run on arrays of sizes exceeding 8...
	 * 
	 * @generated NOT
	 */
	private List<Node[]> heapPermuteExec(Node[] nodeArray) {
		List<Node[]> targetNodePermutations = new ArrayList<Node[]>();
		Node [] arrayWithDummyValue = new Node[nodeArray.length + 1];
		arrayWithDummyValue[0] = null;
		System.arraycopy(nodeArray, 0, arrayWithDummyValue, 1, nodeArray.length);
		heapPermute(targetNodePermutations, nodeArray.length, arrayWithDummyValue);
		return targetNodePermutations;
	}
	
	/**
	 * @generated NOT
	 */
	private void heapPermute(List<Node[]> permutations, int n, Node[] nodeArray) {
		if (n == 1) {
			Node [] retval = new Node[nodeArray.length - 1];
			System.arraycopy(nodeArray, 1, retval, 0, nodeArray.length - 1);
			permutations.add(retval);
		} else {
			for (int i = 1; i <= n; i++) {
				heapPermute(permutations, n - 1, nodeArray);

				if ((n % 2) == 1) {
					swap(1, n, nodeArray);
				} else {
					swap(i, n, nodeArray);
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	private void swap(int first, int second, Node[] array) {
		Node temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				return ((InternalEList<?>)getNodeMapping()).basicRemove(otherEnd, msgs);
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				return ((InternalEList<?>)getEdgeMapping()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				if (coreType) return getNodeMapping();
				else return getNodeMapping().map();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				if (coreType) return getEdgeMapping();
				else return getEdgeMapping().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				((EStructuralFeature.Setting)getNodeMapping()).set(newValue);
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				((EStructuralFeature.Setting)getEdgeMapping()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				getNodeMapping().clear();
				return;
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				getEdgeMapping().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetamodelPackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				return nodeMapping != null && !nodeMapping.isEmpty();
			case MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING:
				return edgeMapping != null && !edgeMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GraphHomomorphismImpl
