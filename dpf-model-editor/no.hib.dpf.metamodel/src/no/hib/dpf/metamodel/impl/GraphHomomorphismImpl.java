/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.GraphHomomorphism;
import no.hib.dpf.metamodel.MetamodelFactory;
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
	 * @generated NOT
	 */
	private Map<Node, Node> backwardsNodeMap;

	/**
	 * @generated NOT
	 */
	private Map<Edge, Edge> backwardsEdgeMap;
	
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
	 * Checks wether a graph can be mapped onto a set of nodes and edges. The target
	 * set of nodes and edges presumably belong to another, possibly larger graph.
	 * The first graph is supposed to be a predicate arity of some sort.
	 * 
	 * If the method succeeds, the graph homomorphism is actually created as a side
	 * effect. TODO: evaluate this!
	 * 
	 * TODO: refactor this!
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean tryToCreateGraphHomomorphism(Graph sourceGraph, EList<?> nodes, EList<?> edges) {
		if ((sourceGraph.getEdges().size() != edges.size()) ||
			(sourceGraph.getNodes().size() != nodes.size())) {
			return false;
		}
		if (sourceGraph.getNodes().size() == 0) {
			// SIDE EFFECT:			
			createSimpleEdgeMapping(sourceGraph, edges);			
			return true;
		}
		
		// This is done to avoid testing on the graph to wich nodes and edges do belong;
		// We don't want to do the following in relation to any other objects present in the target
		// graph:
		Graph targetGraph = createTemporaryTargetGraph(nodes, edges);
		// Check that mappings from node to node and arrow to arrow preserving structure can be made:
		
		Node[] sourceNodes = sourceGraph.getNodes().toArray(new Node[sourceGraph.getNodes().size()]);
		Node[] targetNodes = targetGraph.getNodes().toArray(new Node[targetGraph.getNodes().size()]);
		
		Edge[] sourceEdges = sourceGraph.getEdges().toArray(new Edge[sourceGraph.getEdges().size()]);
		Edge[] targetEdges = targetGraph.getEdges().toArray(new Edge[targetGraph.getEdges().size()]);
		
		// For all permutations of the target nodes:
		List<Node[]> targetNodePermutations = heapPermuteExec(targetNodes);
		for (int i = 0; i < targetNodePermutations.size(); i++) {
			EcoreEMap<Node,Node> nodeMapping = createMapping(sourceNodes, targetNodePermutations, i);
			if (testMapping(nodeMapping)) {
				// SIDE EFFECT:
				// Found a suitable node mapping. Use this and the backwards maps to create
				// a proper homomorphism mapping for this instance.
				EcoreEMap<Edge,Edge> edgeMapping = createEdgeMapping(nodeMapping);
				fixUnmappedArrows(edgeMapping, nodeMapping, sourceEdges, targetEdges);
				
				// Now check that all edges are mapped
				if (sourceEdges.length == edgeMapping.size()) {
					resolveBackwardMappingsAndCreateFinalMapping(nodeMapping, edgeMapping);
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	 * TODO: make this return a boolean signalling non-mappable combinations OR use a dummy null node for each graph.
	 * @generated NOT
	 */
	private void fixUnmappedArrows(EcoreEMap<Edge, Edge> edgeMapping, EcoreEMap<Node, Node> nodeMappings, Edge[] sourceEdges, Edge[] targetEdges) {
		for (Edge sourceEdge : sourceEdges) {
			if (sourceEdge.getSource() == null) {
				for (Edge targetEdge : targetEdges) {
					if (targetEdge.getSource() == null) {
						// Edge to same target?
						Node mappedTarget = nodeMappings.get(sourceEdge.getTarget());
						if (targetEdge.getTarget().equals(mappedTarget)) {				
							if ((!edgeMapping.containsKey(sourceEdge)) && (!edgeMapping.containsValue(targetEdge))) { 
								edgeMapping.put(sourceEdge, targetEdge);
							}
						}
					}
				}				
			}
		}
	}
	
	/**
	 * @generated NOT
	 */
	private void resolveBackwardMappingsAndCreateFinalMapping(EcoreEMap<Node,Node> nodeMapping, EcoreEMap<Edge,Edge> edgeMapping) {
		resolveBackwardsNodeMapping(nodeMapping);
		resolveBackwardsEdgeMapping(edgeMapping);
	}

	/**
	 * @generated NOT
	 */
	private void resolveBackwardsNodeMapping(EcoreEMap<Node, Node> nodeMapping) {
		for (Entry<Node, Node> entry : nodeMapping.entrySet()) {
			if (backwardsNodeMap.containsKey(entry.getValue())) {
				Node resolvedtargetNode = backwardsNodeMap.get(entry.getValue());
				getNodeMapping().put(entry.getKey(), resolvedtargetNode);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	private void resolveBackwardsEdgeMapping(EcoreEMap<Edge, Edge> edgeMapping) {
		for (Entry<Edge, Edge> entry : edgeMapping.entrySet()) {
			if (backwardsEdgeMap.containsKey(entry.getValue())) {
				Edge resolvedTargetEdge = backwardsEdgeMap.get(entry.getValue());
				getEdgeMapping().put(entry.getKey(), resolvedTargetEdge);
			}
		}
	}

	/**
	 * Just map any arrow to another arrow:
	 * @generated NOT
	 */
	private void createSimpleEdgeMapping(Graph sourceGraph, EList<?> edges) {
		for (int i = 0; i < sourceGraph.getEdges().size(); i++) {
			Edge source = sourceGraph.getEdges().get(i);
			Edge target = (Edge)edges.get(i);				
			this.getEdgeMapping().put(source, target);
		}
	}
	
	/**
	 * Creates a new graph, containing only nodes and edges corresponding to the ones given in the argument.
	 * Also creates "backwards" maps, keeping back references into the original graph from the
	 * new elements.
	 * 
	 * @generated NOT
	 */
	private Graph createTemporaryTargetGraph(EList<?> nodes, EList<?> edges) {
		Graph retval = MetamodelFactory.eINSTANCE.createGraph();
		
		backwardsNodeMap = new HashMap<Node, Node>();
		backwardsEdgeMap = new HashMap<Edge, Edge>();
		
		Map<String, Node> newNodes = createNewNodes(nodes, retval);		
		createNewEdges(edges, retval, newNodes);
		
		return retval;		
	}

	/** 
	 * Create new nodes, putting references to them in the "newNodes" map:
	 * @generated NOT
	 */
	private Map<String, Node> createNewNodes(EList<?> nodes, Graph retval) {
		Map<String, Node> newNodes = new HashMap<String, Node>();
		for (Object node : nodes) {
			Node newNode = retval.createNode(((Node)node).getName());
			newNodes.put(((Node)node).getName(), newNode);
			backwardsNodeMap.put(newNode, (Node)node);
		}
		return newNodes;
	}
	
	/** 
	 * Create new edges, using the "newNodes" map to get sources and targets:
	 * @generated NOT
	 */
	private void createNewEdges(EList<?> edges, Graph retval, Map<String, Node> newNodes) {
		for (Object edge : edges) {
			Node sourceNode = getNodeFromMap(newNodes, ((Edge)edge).getSource());
			Node targetNode = getNodeFromMap(newNodes, ((Edge)edge).getTarget());
			Edge newEdge = retval.createEdge(((Edge)edge).getName(), sourceNode, targetNode);
			backwardsEdgeMap.put(newEdge, (Edge)edge);
		}
	}

	/** 
	 * @generated NOT
	 */
	private Node getNodeFromMap(Map<String, Node> nodes, Node graphNode) {
		if ((graphNode != null) && (nodes.containsKey(graphNode.getName()))) {
			return nodes.get(graphNode.getName());
		}
		return null;
	}
	
	/**
	 * Requires a valid node map.
	 * @generated NOT
	 */
	private EcoreEMap<Edge, Edge> createEdgeMapping(EcoreEMap<Node,Node> mapping) {
		EcoreEMap<Edge,Edge> retval = new EcoreEMap<Edge,Edge>(MetamodelPackage.Literals.EDGE_TO_EDGE_MAP, EdgeToEdgeMapImpl.class, this, MetamodelPackage.GRAPH_HOMOMORPHISM__EDGE_MAPPING);
		
		for (Node source : mapping.keySet()) {			
			Node mappedSource = mapping.get(source);
			// Follow the arrows:
			for (Edge outgoingEdge : source.getOutgoingEdges()) {
				Node target = outgoingEdge.getTarget();
				Node mappedTarget = mapping.get(target);
				for (Edge outgoingEdgeFromMappedSource : mappedSource.getOutgoingEdges()) {
					if (((target == null) && (outgoingEdgeFromMappedSource.getTarget() == null)) ||
						(mappedTarget.equals(outgoingEdgeFromMappedSource.getTarget()))) {
						// Only unique mappings from one source edge to one target edge:
						if ((!retval.containsKey(outgoingEdge)) && (!retval.containsValue(outgoingEdgeFromMappedSource))) { 
							retval.put(outgoingEdge, outgoingEdgeFromMappedSource);
						}
					}
				}
			}
		}
		return retval;
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
		
		for (Node source : mapping.keySet()) {			
			Node mappedSource = mapping.get(source);
			// Follow the arrows:
			for (Edge outgoingEdge : source.getOutgoingEdges()) {
				Node target = outgoingEdge.getTarget();
				Node mappedTarget = mapping.get(target);
				boolean found = false;
				for (Edge outgoingEdgeFromMappedSource : mappedSource.getOutgoingEdges()) {
					if (mappedTarget == null) {
						// null is always found
						found = true;
					} else if (mappedTarget.equals(outgoingEdgeFromMappedSource.getTarget())) {
						found = true;
					}
				}
				if (!found) {
					// An edge could not be mapped to a similar edge in the other graph
					return false;
				}
			}
		}
		
		
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
			retval.put(sourceNodes[i], targetNodes[i]);
		}
		
		return retval;
	}	
	
	/**
	 * Makes permutations of the items in the array. This should not be
	 * run on arrays of sizes exceeding 8... TODO: make a check on this!
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
