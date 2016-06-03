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
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DFakeNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.diagram.impl.DNodeImpl;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.MultipleArrowsChopboxAnchor;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.figures.TextCellEditorLocator;
import no.hib.dpf.editor.policies.DArrowCreatePolicy;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.editor.policies.NodeComponentEditPolicy;
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
 * <p>
 * This edit part must implement the PropertyChangeListener interface, so it can
 * be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
public class DNodeEditPart extends GraphicalEditPartWithListener implements
NodeEditPart {

	private Map<NodeEditPart, List<ConnectionAnchor>> anchors = new HashMap<NodeEditPart, List<ConnectionAnchor>>();

	private INodePainting nodePaint;

	private boolean anchorListContainsConnection(
			List<ConnectionAnchor> previousAnchorList,
			ConnectionEditPart connection) {
		return (getConnectionsAnchor(previousAnchorList, connection) != null);
	}

	private ConnectionAnchor createAnchorUseConfigure() {
		if (getNodePaint() != null)
			return nodePaint.createConnectionAnchor(getFigure());
		return null;
	}

	public ConnectionAnchor createConnectionAnchor(
			ConnectionEditPart connection, boolean b, DNodeEditPart owner) {
		ConnectionAnchor anchor = owner.createAnchorUseConfigure();
		if(anchor != null)
			return anchor;
		return getConnectionAnchor(connection, b);
	}

	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new NodeComponentEditPolicy());
		// allow the creation of connections and
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new DArrowCreatePolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new NameDirectEditPolicy());
	}

	protected IFigure createFigure() {
		NodeFigure result = null;
		if (getNodePaint() != null) {
			result = nodePaint.createNodeFigure();
			result.isStandard = false;
		} else
			result = new NodeFigure(new EditableLabel(getNodeLabelName()));
		result.backgroundColor = result.getBackgroundColor();
		return result;
	}

	private DNodeEditPart getAnchorOwner(ConnectionEditPart connection,
			boolean source) {
		if (connection == null || source || connection.getTarget() == null)
			return this;
		return (DNodeEditPart) connection.getTarget();
	}

	private ConnectionAnchor getConnectionAnchor(ConnectionEditPart connection,
			boolean isSourceAnchor) {
		NodeEditPart oppositeEnd = getOppositeEnd(connection, isSourceAnchor);
		List<ConnectionAnchor> previousAnchorList;
		ConnectionAnchor previousAnchor;

		// Get any previous anchors:
		if (anchors.containsKey(oppositeEnd)) {
			if (oppositeEnd == null) {
				return anchors.get(null).get(0);
			}
			previousAnchorList = anchors.get(oppositeEnd);
			previousAnchor = previousAnchorList
					.get(previousAnchorList.size() - 1);
		} else {
			previousAnchorList = new ArrayList<ConnectionAnchor>();
			anchors.put(oppositeEnd, previousAnchorList);
			previousAnchor = null;
		}

		// Get an anchor for the connection:
		if ((connection == null) || (connection.getSource() == null)
				|| (connection.getSource().equals(connection.getTarget()))) {
			previousAnchorList.add(new ChopboxAnchor(getFigure()));
			return previousAnchorList.get(previousAnchorList.size() - 1);

		} else {
			// Check if this connection already has got an anchor:
			if (!anchorListContainsConnection(previousAnchorList, connection)) {
				previousAnchorList.add(new MultipleArrowsChopboxAnchor(
						getFigure(), connection, previousAnchor));
				return previousAnchorList.get(previousAnchorList.size() - 1);
			} else {
				// Return that anchor:
				return getConnectionsAnchor(previousAnchorList, connection);
			}
		}
	}

	private ConnectionAnchor getConnectionsAnchor(
			List<ConnectionAnchor> previousAnchorList,
			ConnectionEditPart connection) {
		for (ConnectionAnchor connectionAnchor : previousAnchorList) {
			if (connectionAnchor instanceof MultipleArrowsChopboxAnchor) {
				MultipleArrowsChopboxAnchor multipleArrowsChopboxAnchor = (MultipleArrowsChopboxAnchor) connectionAnchor;
				if (multipleArrowsChopboxAnchor.getConnectionEditPart().equals(
						connection)) {
					return multipleArrowsChopboxAnchor;
				}
			}
		}
		return null;
	}

	public DNode getDiagramModel() {
		return (DNode) getModel();
	}

	public DNode getDNode() {
		return (DNode) getModel();
	}

	public Node getDPFNode() {
		DNode dnode = getDNode();
		if (dnode != null)
			return dnode.getNode();
		return null;
	}

	public DNode getDType() {
		DNode model = getDNode();
		if (model != null)
			return model.getDType();
		return null;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getModelSourceConnections() {
		EList sources = new BasicEList();
		sources.addAll(getDNode().getDOutgoings());
		if (getEditor() == null || getEditor().isConstraintVisible())
			sources.addAll(getDNode().getConstraintsFrom());
		return sources;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected List<?> getModelTargetConnections() {
		EList targets = new BasicEList();
		targets.addAll(getDNode().getDIncomings());
		if (getEditor() == null || getEditor().isConstraintVisible())
			targets.addAll(getDNode().getConstraintsTo());
		return targets;
	}

	private String getNodeLabelName() {
		String result = "";
		if (getDPFNode().getName() != null)
			result += getDPFNode().getName();
		Node type = getType();
		if (DPFEditorPreferences.getDefault().getDisplayTypeNames()
				&& type != null && type.getName() != null)
			result += " : " + type.getName();
		return result;
	}

	private INodePainting getNodePaint() {
		if (nodePaint == null)
			try {
				String name = null;
				DNode node = getDNode();
				if (node instanceof DNode && !(node instanceof DFakeNode))
					name = node.getDType().getConfigureString();
				if (name == null || name.isEmpty())
					return null;
				IConfigurationElement configure = FigureConfigureManager
						.getConfigurationElement(name);
				if (configure != null)
					nodePaint = (INodePainting) configure
					.createExecutableExtension(FigureConfigureManager.PAINT_ATT);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		return nodePaint;
	}

	private NodeEditPart getOppositeEnd(ConnectionEditPart connection,
			boolean isSourceAnchor) {
		if (connection == null)
			return null;
		if (isSourceAnchor)
			return (NodeEditPart) connection.getTarget();
		return (NodeEditPart) connection.getSource();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		return createConnectionAnchor(connection, true,
				getAnchorOwner(connection, true));
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return createConnectionAnchor(null, true, getAnchorOwner(null, true));
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		return createConnectionAnchor(connection, false,
				getAnchorOwner(connection, false));
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return createConnectionAnchor(null, false, getAnchorOwner(null, false));
	}

	public Node getType() {
		Node model = getDPFNode();
		if (model != null)
			return model.getTypeNode();
		return null;
	}

	/*
	 * After the diagram elements is created or updated, then refresh the
	 * visualization
	 * 
	 * @see no.hib.dpf.editor.parts.GraphicalEditPartWithListener#
	 * handleDiagramModelChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleDiagramModelChanged(Notification msg) {
		super.handleDiagramModelChanged(msg);
		if (msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()) {
			switch (msg.getFeatureID(DNode.class)) {
			case DiagramPackage.DNODE__DOUTGOINGS:
			case DiagramPackage.DNODE__CONSTRAINTS_FROM:
				refreshSourceConnections();
				break;
			case DiagramPackage.DNODE__DINCOMINGS:
			case DiagramPackage.DNODE__CONSTRAINTS_TO:
				refreshTargetConnections();
				for (Object connect : getTargetConnections()) {
					if (connect instanceof DConstraintEditPart
							&& ((DConstraintEditPart) connect).getSource() instanceof DComposedNodePart) {
						DComposedNodePart editPart = (DComposedNodePart) ((DConstraintEditPart) connect)
								.getSource();
						editPart.refreshVisuals();
					}
				}
				break;
			}

		}
	}

	/*
	 * Verification of the model after arrows added or deleted.
	 * 
	 * @see
	 * no.hib.dpf.editor.parts.GraphicalEditPartWithListener#handleModelChanged
	 * (org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleModelChanged(Notification msg) {
		if (msg.getNotifier() != null && msg.getNotifier() == getDPFNode()) {
			switch (msg.getFeatureID(Node.class)) {
			case CorePackage.NODE__NAME:
				refreshVisuals();
				break;
			}
		}
	}

	protected void listen() {
		super.listen();
		addUIAdapter(getDPFNode(), modelListener);
	}

	@Override
	public void performRequest(Request req) {
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			TextDirectEditManager manager = new TextDirectEditManager(this,
					TextCellEditor.class, new TextCellEditorLocator(
							((NodeFigure) getFigure()).getNameLabel()));
			manager.show();
			return;
		}
		super.performRequest(req);
	}

	protected void refreshLabel() {
		NodeFigure tableFigure = (NodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setText(getNodeLabelName());
		label.setVisible(true);
	}

	public void refreshVisuals() {
		NodeFigure figure = (NodeFigure) getFigure();
		figure.setBackgroundColor(figure.backgroundColor);
		DPFEditor editor = getEditor();
		if (editor != null) {
			figure.setErrorFlag(editor.isMakerExisting(getDNode().getNode()));
		}
		DNode dNode = getDiagramModel();
		if (dNode.getSize().width == DNodeImpl.DEFAULT_DIMENSION.width
				&& dNode.getSize().height == DNodeImpl.DEFAULT_DIMENSION.height) {
			dNode.setSize(figure.getPreferredSize().getExpanded(
					figure.getNameLabel().getPreferredSize()));
		}
		figure.setBounds(new Rectangle(dNode.getLocation(), dNode.getSize()));
		figure.repaint();
		figure.invalidate();
		refreshLabel();
	}

	protected void unlisten() {
		removeUIAdapter(getDPFNode(), modelListener);
		super.unlisten();
	}

	private void verifyOnArrowChange(Node node, Arrow oldArrow, Arrow newArrow) {
		Arrow checkedArrow = null;
		DPFEditor editor = getEditor();
		if (editor == null)
			return;
		if (newArrow == null && oldArrow != null) {
			checkedArrow = oldArrow;
			editor.deleteMaker(oldArrow);
		} else if (newArrow != null)
			checkedArrow = newArrow;

		EList<Constraint> constraints = new BasicEList<Constraint>();
		constraints.addAll(checkedArrow.getTypeArrow().getConstraints());

		if (editor == null || node.getGraph() == null)
			return;

		for (Constraint constraint : constraints) {
			EList<Node> nodes = new BasicEList<Node>();
			EList<Arrow> arrows = new BasicEList<Arrow>();

			DPFCoreUtil.findRelatedElements(node, constraint, nodes, arrows);

			if (newArrow == null)
				arrows.remove(checkedArrow);
			boolean valid = constraint.validate(nodes, arrows);
			if (!valid) {
				for (Node iter : nodes)
					editor.addMarker(iter, constraint);
				for (Arrow iter : arrows)
					editor.addMarker(iter, constraint);
			} else {
				for (Node iter : nodes)
					editor.deleteMaker(iter, constraint);
				for (Arrow iter : arrows)
					editor.deleteMaker(iter, constraint);
			}
		}
	}

	protected void fireTargetConnectionAdded(ConnectionEditPart connection,
			int index) {
		super.fireTargetConnectionAdded(connection, index);
		//		if (connection.getModel() instanceof DArrow)
		//			verifyOnArrowChange(getDPFNode(), null,
		//					((DArrow) connection.getModel()).getArrow());
	}

	protected void fireRemovingSourceConnection(ConnectionEditPart connection,
			int index) {
		super.fireRemovingSourceConnection(connection, index);
		if (connection.getModel() instanceof DArrow)
			verifyOnArrowChange(getDPFNode(),
					((DArrow) connection.getModel()).getArrow(), null);
	}
}