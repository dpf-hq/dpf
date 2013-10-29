/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.parts;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.figures.DPFShortestPathConnectionRouter;
import no.hib.dpf.editor.policies.DArrowCreateFeedBackPolicy;
import no.hib.dpf.editor.policies.DGraphXYLayoutEditPolicy;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToGuides;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.gef.rulers.RulerProvider;

/**
 * EditPart for the a DPFDiagram instance.
 * <p>
 * This edit part server as the main diagram container, the white area where
 * everything else is in. Also responsible for the container's layout (the way
 * the container rearanges is contents) and the container's capabilities (edit
 * policies).
 * </p>
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
public class DGraphEditPart extends GraphicalEditPartWithListener {

	/**
	 * Upon activation, attach to the model element as a property change
	 * listener.
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// disallows the removal of this edit part from its parent
		// handles constraint changes (e.g. moving and/or resizing) of model
		// elements
		// and creation of new model elements
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DGraphXYLayoutEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DArrowCreateFeedBackPolicy());
		// Shows a snap line when nodes align:
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy()); //$NON-NLS-1$
	}
	

	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (adapter == SnapToHelper.class) {
			List<SnapToHelper> snapStrategies = new ArrayList<SnapToHelper>();
			Boolean val = (Boolean)getViewer().getProperty(RulerProvider.PROPERTY_RULER_VISIBILITY);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGuides(this));
			val = (Boolean)getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGeometry(this));
			val = (Boolean)getViewer().getProperty(SnapToGrid.PROPERTY_GRID_ENABLED);
			if (val != null && val.booleanValue())
				snapStrategies.add(new SnapToGrid(this));
			
			if (snapStrategies.size() == 0)
				return null;
			if (snapStrategies.size() == 1)
				return snapStrategies.get(0);

			SnapToHelper ss[] = new SnapToHelper[snapStrategies.size()];
			for (int i = 0; i < snapStrategies.size(); i++)
				ss[i] = (SnapToHelper)snapStrategies.get(i);
			return new CompoundSnapToHelper(ss);
		}
		return super.getAdapter(adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		Figure f = new FreeformLayer();
		f.setBorder(new MarginBorder(3));
		f.setLayoutManager(new FreeformLayout());

		// Create the static router for the connection layer
		ConnectionLayer connLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		connLayer.setConnectionRouter(new DPFShortestPathConnectionRouter(f));

		return f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@Override
	protected List<DNode> getModelChildren() {
		EList<DNode> child = new BasicEList<DNode>();
		child.addAll(getDGraph().getDNodes());
		return child; 
	}

	/*
	 * For Node
	 * 1. Add a node, check constraint related to the node's type
	 * 2. Remove a arrow, check constraint related to the node's type, the related incoming and outgoing connections's constraint
	 *  is already checked when deleting them
	 */
	private void verifyOnNodeChange(Graph graph, Object oldNode, Object newNode) {
		Node checkedNode = null;
		DPFEditor editor = getEditor();
		if(editor == null)
			return;
		if (newNode == null && oldNode instanceof Node){
			checkedNode = (Node) oldNode;
			editor.deleteMaker(checkedNode);
		}
		else if (newNode instanceof Node)
			checkedNode = (Node) newNode;
		
		EList<Constraint> constraints = new BasicEList<Constraint>();
		constraints.addAll(checkedNode.getTypeNode().getConstraints());
		
		if(graph == null || editor == null) return;

		for (Constraint constraint : constraints) {
			EList<Node> nodes = new BasicEList<Node>();
			EList<Arrow> arrows = new BasicEList<Arrow>();

			findRelatedElements(checkedNode, graph, nodes, arrows);
			List<Node> nodeList = graph.getNodes();
			if (!nodeList.contains(checkedNode))
				if (nodes.contains(checkedNode))
					nodes.remove(checkedNode);
			boolean valid = constraint.validate(nodes, arrows);
			if(!valid){
				for(Node iter : nodes)
					editor.addMarker(iter, constraint);
				for(Arrow iter : arrows)
					editor.addMarker(iter, constraint);
			}else{
				for(Node iter : nodes)
					editor.deleteMaker(iter, constraint);
				for(Arrow iter : arrows)
					editor.deleteMaker(iter, constraint);
			}
		}
	}

	private void findRelatedElements(Node checkedNode, Graph graph,
			EList<Node> nodes, EList<Arrow> arrows) {
		List<Node> nodeList = graph.getNodes();
		if (nodeList.contains(checkedNode))
			if (!nodes.contains(checkedNode))
				nodes.add(checkedNode);
	}
	
	protected void handleModelChanged(Notification msg){
		if(msg.getNotifier() != null && msg.getNotifier() == getDGraph().getGraph()){ 
			switch(msg.getFeatureID(Graph.class)){
			case CorePackage.GRAPH__NODES:
				verifyOnNodeChange((Graph)msg.getNotifier(), msg.getOldValue(), msg.getNewValue());
				break;
			}
		}
	}

	protected void handleDiagramModelChanged(Notification msg){
		super.handleDiagramModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDGraph()){ 
			switch(msg.getFeatureID(DGraph.class)){
			case DiagramPackage.DGRAPH__DNODES:
				refreshChildren();
				break;
			}
		}
	}
	private DGraph getDGraph(){
		return (DGraph) getModel();
	}
	protected void listen(){
		super.listen();
		addUIAdapter(getDGraph().getGraph(), modelListener);
	}
	
	protected void unlisten(){
		removeUIAdapter(getDGraph().getGraph(), modelListener);
		super.unlisten();
	}
}