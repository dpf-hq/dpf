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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.MultipleArrowsChopboxAnchor;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.policies.DArrowCreatePolicy;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;


/**
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
public class DNodeEditPart extends GraphicalEditPartWithListener implements NodeEditPart{

	private Map<NodeEditPart, List<ConnectionAnchor>> anchors = new HashMap<NodeEditPart, List<ConnectionAnchor>>();

	private INodePainting nodePaint;
	public DNodeEditPart() {
		super();

	}

	private boolean anchorListContainsConnection(List<ConnectionAnchor> previousAnchorList, ConnectionEditPart connection) {
		return (getConnectionsAnchor(previousAnchorList, connection) != null);
	}

	private ConnectionAnchor createAnchorUseConfigure(){
		if(getNodePaint() != null)
			return nodePaint.createConnectionAnchor(getFigure());
		return null;
	}


	public ConnectionAnchor createConnectionAnchor(ConnectionEditPart connection, boolean b, DNodeEditPart owner){
		ConnectionAnchor anchor = owner.createAnchorUseConfigure();
		if(anchor != null)
			return anchor;
		return getConnectionAnchor(connection, b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
		// allow the creation of connections and
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DArrowCreatePolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
	}

	protected IFigure createFigure() {
		if(getNodePaint() != null)
			return nodePaint.createNodeFigure();
		IFigure figure = new NodeFigure(new EditableLabel(getNodeLabelName()));
		return figure;
	}

	private DNodeEditPart getAnchorOwner(ConnectionEditPart connection, boolean source){
		if(connection == null || source || connection.getTarget() == null)
			return this;
		return (DNodeEditPart) connection.getTarget();
	}

	private ConnectionAnchor getConnectionAnchor(ConnectionEditPart connection, boolean isSourceAnchor) {
		NodeEditPart oppositeEnd = getOppositeEnd(connection, isSourceAnchor);
		List<ConnectionAnchor> previousAnchorList;
		ConnectionAnchor previousAnchor;

		// Get any previous anchors:
		if (anchors.containsKey(oppositeEnd)) {
			if (oppositeEnd == null) {
				return anchors.get(null).get(0);
			}
			previousAnchorList = anchors.get(oppositeEnd);
			previousAnchor = previousAnchorList.get(previousAnchorList.size() - 1);
		} else {
			previousAnchorList = new ArrayList<ConnectionAnchor>();
			anchors.put(oppositeEnd, previousAnchorList);
			previousAnchor = null;
		}

		// Get an anchor for the connection:
		if ((connection == null) || (connection.getSource() == null) || (connection.getSource().equals(connection.getTarget()))) {
			previousAnchorList.add(new ChopboxAnchor(getFigure()));
			return previousAnchorList.get(previousAnchorList.size() - 1);

		} else {
			// Check if this connection already has got an anchor:
			if (!anchorListContainsConnection(previousAnchorList, connection)) {
				previousAnchorList.add(new MultipleArrowsChopboxAnchor(getFigure(), connection, previousAnchor));
				return previousAnchorList.get(previousAnchorList.size() - 1);
			} else {
				// Return that anchor:
				return getConnectionsAnchor(previousAnchorList, connection);
			}
		}
	}

	private ConnectionAnchor getConnectionsAnchor(List<ConnectionAnchor> previousAnchorList, ConnectionEditPart connection) {
		for (ConnectionAnchor connectionAnchor : previousAnchorList) {
			if (connectionAnchor instanceof MultipleArrowsChopboxAnchor) {
				MultipleArrowsChopboxAnchor multipleArrowsChopboxAnchor = (MultipleArrowsChopboxAnchor)connectionAnchor;
				if (multipleArrowsChopboxAnchor.getConnectionEditPart().equals(connection)) {
					return multipleArrowsChopboxAnchor;
				}
			}
		}
		return null;		
	}
	protected DNode getDiagramModel(){ return (DNode) getModel(); }

	public DNode getDNode(){
		return (DNode) getModel();
	}

	public Node getDPFNode(){
		DNode dnode = getDNode();
		if(dnode != null)
			return dnode.getNode();
		return null;
	}

	public DNode getDType(){
		DNode model = getDNode();
		if(model != null)
			return model.getDType();
		return null;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getModelSourceConnections() {
		EList sources = new BasicEList();
		sources.addAll(getDNode().getDOutgoings());
		sources.addAll(getDNode().getConstraintsFrom());
		return sources;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected List<?> getModelTargetConnections() {
		EList targets = new BasicEList();
		targets.addAll(getDNode().getDIncomings());
		targets.addAll(getDNode().getConstraintsTo());
		return targets;
	}

	private String getNodeLabelName() {
		String result = "";
		if(getDPFNode().getName() != null)
			result += getDPFNode().getName();
		Node type = getType();
		if (DPFEditorPreferences.getDefault().getDisplayTypeNames() && type != null && type.getName() != null) 
			result += " : " + type.getName();
		return result;
	}

	private INodePainting getNodePaint() {
		if(nodePaint == null)
			try {
				String name = null;
				if(getDNode() instanceof DNode)
					name = getDNode().getDType().getConfigureString();
				if(name == null || name.isEmpty())
					return null;
				IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(name);
				if(configure != null)
					nodePaint = (INodePainting) configure.createExecutableExtension(FigureConfigureManager.PAINT_ATT);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		return nodePaint;
	}

	private NodeEditPart getOppositeEnd(ConnectionEditPart connection, boolean isSourceAnchor) {
		if (connection == null) 
			return null;
		if (isSourceAnchor) 
			return (NodeEditPart) connection.getTarget();
		return (NodeEditPart) connection.getSource();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return createConnectionAnchor(connection, true, getAnchorOwner(connection, true));
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return createConnectionAnchor(null, true, getAnchorOwner(null, true));
	}
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return createConnectionAnchor(connection, false, getAnchorOwner(connection, false));
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return createConnectionAnchor(null, false, getAnchorOwner(null, false));
	}

	public Node getType(){
		Node model = getDPFNode();
		if(model != null)
			return model.getTypeNode();
		return null;
	}

	/*
	 * After the diagram elements is created or updated, then refresh the visualization
	 * @see no.hib.dpf.editor.parts.GraphicalEditPartWithListener#handleDiagramModelChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleDiagramModelChanged(Notification msg) {
		super.handleDiagramModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()){ 
			switch(msg.getFeatureID(DNode.class)){
			case DiagramPackage.DNODE__DOUTGOINGS:
			case DiagramPackage.DNODE__CONSTRAINTS_FROM:
				refreshSourceConnections();
				break;
			case DiagramPackage.DNODE__DINCOMINGS:
			case DiagramPackage.DNODE__CONSTRAINTS_TO:
				refreshTargetConnections();
				break;
			case DiagramPackage.DNODE__LOCATION:
			case DiagramPackage.DNODE__SIZE:
				refresh();
				for(Object connect : getTargetConnections()){
					if(connect instanceof DConstraintEditPart && ((DConstraintEditPart)connect).getSource() instanceof DComposedNodePart){
						DComposedNodePart editPart = (DComposedNodePart) ((DConstraintEditPart)connect).getSource();
						editPart.resize(getDNode().getLocation());
						
					}
				}
			}

		}
	}

	/*
	 * Verification of the model after arrows added or deleted.
	 * @see no.hib.dpf.editor.parts.GraphicalEditPartWithListener#handleModelChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleModelChanged(Notification msg) {
		if(msg.getNotifier() != null && msg.getNotifier() == getDPFNode()){ 
			switch(msg.getFeatureID(Node.class)){
			case CorePackage.NODE__NAME:
				refreshVisuals();
				break;
			case CorePackage.NODE__INCOMINGS:
				verifyOnArrowChange((Node)msg.getNotifier(), msg.getOldValue(), msg.getNewValue());
				break;
			case CorePackage.NODE__OUTGOINGS:
				verifyOnArrowChange((Node)msg.getNotifier(), msg.getOldValue(), msg.getNewValue());
				break;
			}
		}
	}

	protected void listen(){
		super.listen();
		addUIAdapter(getDPFNode(), modelListener);
	}

	@Override
	public void performRequest(Request req) {
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			TextDirectEditManager manager = new TextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator(((NodeFigure)getFigure()).getNameLabel()));
			manager.show();
			return;
		}
		super.performRequest(req);
	}
	private void refreshLabel() {
		NodeFigure tableFigure = (NodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setText(getNodeLabelName());
		label.setVisible(true);
		label.revalidate();
	}
	public void refreshVisuals() {
		NodeFigure figure = (NodeFigure)getFigure();
		DPFEditor editor = getEditor();
		if(editor != null){
			boolean flag = editor.isMakerExisting(getDNode().getNode());
			if(figure.getErrorImageFlag() != flag)
				figure.setErrorImageFlag(flag);
		}
		getFigure().setBounds(new Rectangle(getDiagramModel().getLocation(), getDiagramModel().getSize()));
		refreshLabel();
		//			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent
		// container (the Figure of the DPFDiagramEditPart), will not know the bounds of
		// this figure and will not draw it correctly.
	}

	protected void unlisten(){
		removeUIAdapter(getDPFNode(), modelListener);
		super.unlisten();
	}

	private void verifyOnArrowChange(Node node, Object oldArrow, Object newArrow){
		Arrow checkedArrow = null;
		DPFEditor editor = getEditor();
		if(editor == null)
			return;
		if (newArrow == null && oldArrow instanceof Arrow){
			checkedArrow = (Arrow) oldArrow;
			if(checkedArrow.getSource() == null && checkedArrow.getTarget() == null)
				editor.deleteMaker(checkedArrow);
		}
		else if (newArrow instanceof Arrow)
			checkedArrow = (Arrow) newArrow;

		EList<Constraint> constraints = new BasicEList<Constraint>();
		constraints.addAll(checkedArrow.getTypeArrow().getConstraints());

		Graph graph = node.getGraph();
		if(editor == null || graph == null) return;

		for (Constraint constraint : constraints) {
			EList<Node> nodes = new BasicEList<Node>();
			EList<Arrow> arrows = new BasicEList<Arrow>();

			DPFCoreUtil.findRelatedElements(node, constraint, graph, nodes, arrows);

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
}