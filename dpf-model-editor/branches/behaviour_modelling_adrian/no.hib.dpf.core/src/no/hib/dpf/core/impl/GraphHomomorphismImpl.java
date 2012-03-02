/**
 * <copyright>
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Adrian Rutle, �yvind Bech and Dag Viggo Lok�en - DPF Editor
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;

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
 *   <li>{@link no.hib.dpf.core.impl.GraphHomomorphismImpl#getNodeMapping <em>Node Mapping</em>}</li>
 *   <li>{@link no.hib.dpf.core.impl.GraphHomomorphismImpl#getArrowMapping <em>Arrow Mapping</em>}</li>
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
	private Map<Arrow, Arrow> backwardsArrowMap;
	
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
	 * The cached value of the '{@link #getArrowMapping() <em>Arrow Mapping</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrowMapping()
	 * @generated
	 * @ordered
	 */
	protected EMap<Arrow, Arrow> arrowMapping;

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
		return CorePackage.Literals.GRAPH_HOMOMORPHISM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Node, Node> getNodeMapping() {
		if (nodeMapping == null) {
			nodeMapping = new EcoreEMap<Node,Node>(CorePackage.Literals.NODE_TO_NODE_MAP, NodeToNodeMapImpl.class, this, CorePackage.GRAPH_HOMOMORPHISM__NODE_MAPPING);
		}
		return nodeMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Arrow, Arrow> getArrowMapping() {
		if (arrowMapping == null) {
			arrowMapping = new EcoreEMap<Arrow,Arrow>(CorePackage.Literals.ARROW_TO_ARROW_MAP, ArrowToArrowMapImpl.class, this, CorePackage.GRAPH_HOMOMORPHISM__ARROW_MAPPING);
		}
		return arrowMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Checks wether a graph can be mapped onto a set of nodes and arrows. The target
	 * set of nodes and arrows presumably belong to another, possibly larger graph.
	 * The first graph is supposed to be a predicate arity of some sort.
	 * 
	 * If the method succeeds, the graph homomorphism is actually created as a side
	 * effect. TODO: evaluate this!
	 * 
	 * TODO: refactor this!
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public GraphHomomorphism createGraphHomomorphism(Graph sourceGraph, EList<Node> nodes, EList<Arrow> arrows) {
		if (sourceGraph.getArrows().size() != arrows.size()) {
			return null;
		}
		if ((arrows.size() == 0) &&
			(sourceGraph.getNodes().size() != nodes.size())) {
			return null;
		}
		if (sourceGraph.getNodes().size() == 0) {
			// SIDE EFFECT:			
			createSimpleArrowMapping(sourceGraph, arrows);			
			return this;
		}
		
		Graph targetGraph = null;
		// This is done to avoid testing on the graph to wich nodes and arrows do belong;
		// We don't want to do the following in relation to any other objects present in the target
		// graph:
		try {
			targetGraph = createTemporaryTargetGraph(nodes, arrows);
		} catch (Exception e) {
			// If the nodes and arrows don't contain a valid graph, we return false
			return null;
		}
		// Check that mappings from node to node and arrow to arrow preserving structure can be made:
		
		Node[] sourceNodes = sourceGraph.getNodes().toArray(new Node[sourceGraph.getNodes().size()]);
		Node[] targetNodes = targetGraph.getNodes().toArray(new Node[targetGraph.getNodes().size()]);
		
		Arrow[] sourceArrows = sourceGraph.getArrows().toArray(new Arrow[sourceGraph.getArrows().size()]);
		Arrow[] targetArrows = targetGraph.getArrows().toArray(new Arrow[targetGraph.getArrows().size()]);
		
		// For all permutations of the target nodes:
		List<Node[]> targetNodePermutations = heapPermuteExec(targetNodes);
		for (int i = 0; i < targetNodePermutations.size(); i++) {
			EcoreEMap<Node,Node> nodeMapping = createMapping(sourceNodes, targetNodePermutations, i);
			if (testMapping(nodeMapping)) {
				// SIDE EFFECT:
				// Found a suitable node mapping. Use this and the backwards maps to create
				// a proper homomorphism mapping for this instance.
				EcoreEMap<Arrow,Arrow> arrowMapping = createArrowMapping(nodeMapping);
				fixUnmappedArrows(arrowMapping, nodeMapping, sourceArrows, targetArrows);
				
				// Now check that all arrows are mapped
				if (sourceArrows.length == arrowMapping.size()) {
					resolveBackwardMappingsAndCreateFinalMapping(nodeMapping, arrowMapping);
					return this;
				}
			}
		}
		
		return null;
	}
	
	
	/**
	 * TODO: make this return a boolean signalling non-mappable combinations OR use a dummy null node for each graph.
	 * @generated NOT
	 */
	private void fixUnmappedArrows(EcoreEMap<Arrow, Arrow> arrowMapping, EcoreEMap<Node, Node> nodeMappings, Arrow[] sourceArrows, Arrow[] targetArrows) {
		for (Arrow sourceArrow : sourceArrows) {
			if (sourceArrow.getSource() == null) {
				for (Arrow targetArrow : targetArrows) {
					if (targetArrow.getSource() == null) {
						// Arrow to same target?
						Node mappedTarget = nodeMappings.get(sourceArrow.getTarget());
						if (targetArrow.getTarget().equals(mappedTarget)) {				
							if ((!arrowMapping.containsKey(sourceArrow)) && (!arrowMapping.containsValue(targetArrow))) { 
								arrowMapping.put(sourceArrow, targetArrow);
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
	private void resolveBackwardMappingsAndCreateFinalMapping(EcoreEMap<Node,Node> nodeMapping, EcoreEMap<Arrow,Arrow> arrowMapping) {
		resolveBackwardsNodeMapping(nodeMapping);
		resolveBackwardsArrowMapping(arrowMapping);
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
	private void resolveBackwardsArrowMapping(EcoreEMap<Arrow, Arrow> arrowMapping) {
		for (Entry<Arrow, Arrow> entry : arrowMapping.entrySet()) {
			if (backwardsArrowMap.containsKey(entry.getValue())) {
				Arrow resolvedTargetArrow = backwardsArrowMap.get(entry.getValue());
				getArrowMapping().put(entry.getKey(), resolvedTargetArrow);
			}
		}
	}

	/**
	 * Just map any arrow to another arrow:
	 * @generated NOT
	 */
	private void createSimpleArrowMapping(Graph sourceGraph, EList<?> arrows) {
		for (int i = 0; i < sourceGraph.getArrows().size(); i++) {
			Arrow source = sourceGraph.getArrows().get(i);
			Arrow target = (Arrow)arrows.get(i);				
			this.getArrowMapping().put(source, target);
		}
	}
	
	/**
	 * Creates a new graph, containing only nodes and arrows corresponding to the ones given in the argument.
	 * Also creates "backwards" maps, keeping back references into the original graph from the
	 * new elements.
	 * 
	 * @generated NOT
	 */
	private Graph createTemporaryTargetGraph(EList<Node> nodes, EList<Arrow> arrows) {
		Graph retval = CoreFactory.eINSTANCE.createGraph();
		
		backwardsNodeMap = new HashMap<Node, Node>();
		backwardsArrowMap = new HashMap<Arrow, Arrow>();
		
		Map<String, Node> newNodes = createNewNodes(nodes, retval);		
		createNewArrows(arrows, retval, newNodes);
		
		return retval;		
	}

	/** 
	 * Create new nodes, putting references to them in the "newNodes" map:
	 * @generated NOT
	 */
	private Map<String, Node> createNewNodes(EList<Node> nodes, Graph retval) {
		Map<String, Node> newNodes = new HashMap<String, Node>();
		for (Node node : nodes) {
			Node newNode = retval.createNode(node.getId());
			newNodes.put(node.getId(), newNode);
			backwardsNodeMap.put(newNode, node);
		}
		return newNodes;
	}
	
	/** 
	 * Create new arrows, using the "newNodes" map to get sources and targets:
	 * @generated NOT
	 */
	private void createNewArrows(EList<Arrow> arrows, Graph retval, Map<String, Node> newNodes) {
		for (Arrow arrow : arrows) {
			Node sourceNode = getArrowFromMap(newNodes, arrow.getSource());
			Node targetNode = getArrowFromMap(newNodes, arrow.getTarget());			
			Arrow newArrow = retval.createArrow(arrow.getId(), sourceNode, targetNode);
			backwardsArrowMap.put(newArrow, arrow);
		}
	}

	/** 
	 * @generated NOT
	 */
	private Node getArrowFromMap(Map<String, Node> nodes, Node graphNode) {
		if ((graphNode != null) && (nodes.containsKey(graphNode.getId()))) {
			return nodes.get(graphNode.getId());
		}
		return null;
	}
	
	/**
	 * Requires a valid node map.
	 * @generated NOT
	 */
	private EcoreEMap<Arrow, Arrow> createArrowMapping(EcoreEMap<Node,Node> mapping) {
		EcoreEMap<Arrow,Arrow> retval = new EcoreEMap<Arrow, Arrow>(CorePackage.Literals.ARROW_TO_ARROW_MAP, ArrowToArrowMapImpl.class, this, CorePackage.GRAPH_HOMOMORPHISM__ARROW_MAPPING);
		
		for (Node source : mapping.keySet()) {			
			Node mappedSource = mapping.get(source);
			// Follow the arrows:
			for (Arrow outgoingArrow : source.getOutgoings()) {
				Node target = outgoingArrow.getTarget();
				Node mappedTarget = mapping.get(target);
				for (Arrow outgoingArrowFromMappedSource : mappedSource.getOutgoings()) {
					if (((target == null) && (outgoingArrowFromMappedSource.getTarget() == null)) ||
						(mappedTarget.equals(outgoingArrowFromMappedSource.getTarget()))) {
						// Only unique mappings from one source arrow to one target arrow:
						if ((!retval.containsKey(outgoingArrow)) && (!retval.containsValue(outgoingArrowFromMappedSource))) { 
							retval.put(outgoingArrow, outgoingArrowFromMappedSource);
						}
					}
				}
			}
		}
		return retval;
	}	
	
	/**
	 * Checks a mapping to see wether it indicates a valid graph homomorphism
	 * if the arrows are mapped "one to one". TODO: explain this. Also to self.
	 * @generated NOT
	 */
	private boolean testMapping(EcoreEMap<Node,Node> mapping) {
		// Check to see wether the mapped nodes have the same number of input and output arrows:
//		int valueNumOutputEdges = 0;
//		int keyNumOutputEdges = 0;
		
//		for (Node key : mapping.keySet()) {
//			Node value = mapping.get(key);
//			valueNumOutputEdges += value.getOutgoingEdges().size();
//			keyNumOutputEdges += key.getOutgoingEdges().size();
//		}
//		if (valueNumOutputEdges != keyNumOutputEdges) {
//			return false;
//		}
	    // Now, check to see if we can follow every outgoing edge and end up on
		// the same node by following the edges directly and through mappings:
		
		for (Node source : mapping.keySet()) {			
			Node mappedSource = mapping.get(source);
			// Follow the arrows:
			for (Arrow outgoingArrow : source.getOutgoings()) {
				Node target = outgoingArrow.getTarget();
				Node mappedTarget = mapping.get(target);
				boolean found = false;
				for (Arrow outgoingArrowFromMappedSource : mappedSource.getOutgoings()) {
					if (mappedTarget == null) {
						// null is always found
						found = true;
					} else if (mappedTarget.equals(outgoingArrowFromMappedSource.getTarget())) {
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
		EcoreEMap<Node,Node> retval = new EcoreEMap<Node,Node>(CorePackage.Literals.NODE_TO_NODE_MAP, NodeToNodeMapImpl.class, this, CorePackage.GRAPH_HOMOMORPHISM__NODE_MAPPING);		
		Node[] targetNodes = targetNodePermutations.get(permutationIndex);
			
		for (int i = 0; i < sourceNodes.length; i++) {
			if (targetNodes.length > i) {
				retval.put(sourceNodes[i], targetNodes[i]);
			} else {
				retval.put(sourceNodes[i], targetNodes[0]);				
			}
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
			case CorePackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				return ((InternalEList<?>)getNodeMapping()).basicRemove(otherEnd, msgs);
			case CorePackage.GRAPH_HOMOMORPHISM__ARROW_MAPPING:
				return ((InternalEList<?>)getArrowMapping()).basicRemove(otherEnd, msgs);
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
			case CorePackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				if (coreType) return getNodeMapping();
				else return getNodeMapping().map();
			case CorePackage.GRAPH_HOMOMORPHISM__ARROW_MAPPING:
				if (coreType) return getArrowMapping();
				else return getArrowMapping().map();
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
			case CorePackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				((EStructuralFeature.Setting)getNodeMapping()).set(newValue);
				return;
			case CorePackage.GRAPH_HOMOMORPHISM__ARROW_MAPPING:
				((EStructuralFeature.Setting)getArrowMapping()).set(newValue);
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
			case CorePackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				getNodeMapping().clear();
				return;
			case CorePackage.GRAPH_HOMOMORPHISM__ARROW_MAPPING:
				getArrowMapping().clear();
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
			case CorePackage.GRAPH_HOMOMORPHISM__NODE_MAPPING:
				return nodeMapping != null && !nodeMapping.isEmpty();
			case CorePackage.GRAPH_HOMOMORPHISM__ARROW_MAPPING:
				return arrowMapping != null && !arrowMapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GraphHomomorphismImpl
