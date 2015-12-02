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
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.figures.DPFShortestPathConnectionRouter;
import no.hib.dpf.editor.policies.DArrowCreateFeedBackPolicy;
import no.hib.dpf.editor.policies.DGraphXYLayoutEditPolicy;
import no.hib.dpf.utils.DPFCoreUtil;

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
import org.eclipse.gef.EditPart;
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

	protected IFigure createFigure() {
		Figure f = new FreeformLayer();
		f.setBorder(new MarginBorder(3));
		f.setLayoutManager(new FreeformLayout());

		// Create the static router for the connection layer
		ConnectionLayer connLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		connLayer.setConnectionRouter(new DPFShortestPathConnectionRouter(f));

		return f;
	}

	@Override
	protected List<DNode> getModelChildren() {
		EList<DNode> child = new BasicEList<DNode>();
		if(getEditor() == null || getEditor().isConstraintVisible())
			child.addAll(getDGraph().getDNodes());
		else{
			for(DNode iter : getDGraph().getDNodes()){
				if(!(iter instanceof DConstraintNode)){
					child.add(iter);
				}
			}
		}
		return child;
	}

	/*
	 * For Node
	 * 1. Add a node, check constraint related to the node's type
	 * 2. Remove a arrow, check constraint related to the node's type, the related incoming and outgoing connections's constraint
	 *  is already checked when deleting them
	 */
	private void verifyOnNodeChange(Graph graph, Node newNode, Node oldNode) {
		Node checkedNode = null;
		DPFEditor editor = getEditor();
		if(editor == null) return;
		if (newNode == null && oldNode != null){
			checkedNode = oldNode;
			editor.deleteMaker(oldNode);
		}
		else if (newNode != null)
			checkedNode = newNode;

		EList<Constraint> constraints = new BasicEList<Constraint>();
		constraints.addAll(checkedNode.getTypeNode().getConstraints());

		if(graph == null || editor == null) return;

		for (Constraint constraint : constraints) {
			EList<Node> nodes = new BasicEList<Node>();
			EList<Arrow> arrows = new BasicEList<Arrow>();
			DPFCoreUtil.findRelatedElements(checkedNode, constraint, nodes, arrows);
			if(newNode == null) {
				nodes.remove(oldNode);
				List<Arrow> delete = new ArrayList<Arrow>();
				for(Arrow iter : arrows)
					if(iter.getSource() == oldNode || iter.getTarget() == oldNode)
						delete.add(iter);
				arrows.removeAll(delete);
			}
			boolean valid = constraint.validate(nodes, arrows);
			if(!valid){
				for(Node iter : nodes)
					editor.addMarker(iter, constraint);
			}else{
				for(Node iter : nodes)
					editor.deleteMaker(iter, constraint);
			}
		}
	}
	protected void fireChildAdded(EditPart child, int index) {
		super.fireChildAdded(child, index);
		if(child.getModel() instanceof DNode){
			Node node = ((DNode)child.getModel()).getNode();
			if(node == null) return;
			EList<Node> nodes = new BasicEList<Node>();
			nodes.add(node);
			verifyOnNodeChange(this.getDGraph().getGraph(), node, null);
		}
	}

	protected void fireRemovingChild(EditPart child, int index) {
		super.fireRemovingChild(child, index);
		if(child.getModel() instanceof DNode && ((DNode)child.getModel()).getNode() != null)
			verifyOnNodeChange(this.getDGraph().getGraph(), null, ((DNode)child.getModel()).getNode());
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
	public DGraph getDGraph(){
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