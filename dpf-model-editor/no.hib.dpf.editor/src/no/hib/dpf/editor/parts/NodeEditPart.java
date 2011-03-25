/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *����Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.MultipleArrowsChopboxAnchor;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.model.LocationAndSize;
import no.hib.dpf.editor.model.ModelElement;
import no.hib.dpf.editor.model.VArrow;
import no.hib.dpf.editor.model.VNode;
import no.hib.dpf.editor.model.commands.ConnectionCreateCommand;
import no.hib.dpf.editor.model.commands.ConnectionReconnectCommand;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;
import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Node;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.jface.util.IPropertyChangeListener;


/**
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
public class NodeEditPart extends AbstractGraphicalEditPart implements
		PropertyChangeListener, org.eclipse.gef.NodeEditPart {

	private Map<NodeEditPart, List<ConnectionAnchor>> anchors = new HashMap<NodeEditPart, List<ConnectionAnchor>>();

	public NodeEditPart() {
		listenToDisplayNameProperty();
	}

	/**
	 * Upon activation, attach to the model element as a property change
	 * listener.
	 */
	public void activate() {
		if (!isActive()) {
			super.activate();
			((ModelElement) getModel()).addPropertyChangeListener(this);
		}
	}

	private void listenToDisplayNameProperty() {
		DPFEditorPreferences.getDefault().getPreferenceStore().addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				if ((event.getProperty().equals(PreferenceConstants.P_DISPLAY_ARROWS)) ||
					(event.getProperty().equals(PreferenceConstants.P_DISPLAY_TYPES))) {
					refreshVisuals();
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new NodeComponentEditPolicy());
		// allow the creation of connections and
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new GraphicalNodeEditPolicy() {

					protected Command getConnectionCompleteCommand(
							CreateConnectionRequest request) {
						ConnectionCreateCommand cmd = (ConnectionCreateCommand) request
								.getStartCommand();
						cmd.setTarget((VNode) getHost().getModel());
						return cmd;
					}

					protected Command getConnectionCreateCommand(
							CreateConnectionRequest request) {

						VNode source = (VNode) getHost().getModel();
						Arrow typeArrow = (Arrow) request.getNewObjectType();

						ConnectionCreateCommand cmd = new ConnectionCreateCommand(
								source, typeArrow);
						request.setStartCommand(cmd);
						return cmd;
					}

					protected Command getReconnectSourceCommand(
							ReconnectRequest request) {
						VArrow conn = (VArrow) request.getConnectionEditPart()
								.getModel();
						VNode newSource = (VNode) getHost().getModel();
						ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(
								conn);
						cmd.setNewSource(newSource);
						return cmd;
					}

					protected Command getReconnectTargetCommand(
							ReconnectRequest request) {
						VArrow conn = (VArrow) request.getConnectionEditPart()
								.getModel();
						VNode newTarget = (VNode) getHost().getModel();
						ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(
								conn);
						cmd.setNewTarget(newTarget);
						return cmd;
					}
				});
	}

	/**
	 * @param handles
	 *            the name change during an edit
	 */
	public void handleNameChange(String value) {
		// Dodgy code, but probably not used: TODO: check direct editing of node names
		NodeFigure tableFigure = (NodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setVisible(false);
		refreshVisuals();
	}
	
	private VNode getShape() {
		return (VNode) getModel();
	}

	/**
	 * Reverts to existing name in model when exiting from a direct edit
	 * (possibly before a commit which will result in a change in the label
	 * value)
	 */
	public void revertNameChange() {
		refreshVisuals();
	}

	private String getFullName() {
		
		if (DPFEditorPreferences.getDefault().getDisplayTypeNames()) {
			return getShape().getNameExec() + " : " + getShape().getTypeName();
		} else {
			return getShape().getNameExec();
		}
		
	}

	/**
	 * Handles change in name when committing a direct edit
	 */
	private void commitNameChange(PropertyChangeEvent evt) {
		revertNameChange();
	}

	protected IFigure createFigure() {
		return new NodeFigure(new EditableLabel(getFullName()));
	}

	/**
	 * Upon deactivation, detach from the model element as a property change
	 * listener.
	 */
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((ModelElement) getModel()).removePropertyChangeListener(this);
		}
	}

	private VNode getCastedModel() {
		return (VNode) getModel();
	}

	public Node getModelAsEMFInstance() {
		return getCastedModel().getNodeComponent();
	}

	private ConnectionAnchor getConnectionAnchor(ConnectionEditPart connection, boolean isSourceAnchor) {
		
		NodeEditPart oppositeEnd = getOppositeEnd(connection, isSourceAnchor);
		List<ConnectionAnchor> previousAnchorList;
		ConnectionAnchor previousAnchor;
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

		if ((connection == null) || (connection.getSource() == null) || (connection.getSource().equals(connection.getTarget()))) {
			previousAnchorList.add(new ChopboxAnchor(getFigure()));

		} else {
			// Check if this connection already has got an anchor:
			if (!anchorListContainsConnection(previousAnchorList, connection)) {
				previousAnchorList.add(new MultipleArrowsChopboxAnchor(getFigure(), connection, previousAnchor));
			}
		}
		return previousAnchorList.get(previousAnchorList.size() - 1);
	}
	
	private boolean anchorListContainsConnection(List<ConnectionAnchor> previousAnchorList, ConnectionEditPart connection) {
		for (ConnectionAnchor connectionAnchor : previousAnchorList) {
			if (connectionAnchor instanceof MultipleArrowsChopboxAnchor) {
				MultipleArrowsChopboxAnchor multipleArrowsChopboxAnchor = (MultipleArrowsChopboxAnchor)connectionAnchor;
				if (multipleArrowsChopboxAnchor.getConnectionEditPart().equals(connection)) {
					return true;
				}
			}
		}
		return false;
	}

	private NodeEditPart getOppositeEnd(ConnectionEditPart connection,
			boolean isSourceAnchor) {
		if (connection == null) {
			return null;
		} else if (isSourceAnchor) {
			return (NodeEditPart) connection.getTarget();
		}
		return (NodeEditPart) connection.getSource();
	}

	@Override
	protected List<VArrow> getModelSourceConnections() {
		return getCastedModel().getSourceConnections();
	}

	@Override
	protected List<VArrow> getModelTargetConnections() {
		return getCastedModel().getTargetConnections();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor(connection, true);
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getConnectionAnchor(null, true);
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor(connection, false);
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return getConnectionAnchor(null, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.
	 * PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String prop = evt.getPropertyName();
		DiagramEditPart diagram = (DiagramEditPart) getParent();
		if (LocationAndSize.SIZE_PROP.equals(prop)
				|| LocationAndSize.LOCATION_PROP.equals(prop)) {
			refreshVisuals();
		} else if (VNode.SOURCE_CONNECTIONS_PROP.equals(prop)) {
			refreshSourceConnections();
		} else if (VNode.TARGET_CONNECTIONS_PROP.equals(prop)) {
			refreshTargetConnections();
			diagram.validateSemantics();
		} else if (VNode.NAME_PROP.equals(prop)) {
			commitNameChange(evt);
		}
	}

	protected void refreshVisuals() {
		try {
			refreshLabel();
			// notify parent container of changed position & location
			// if this line is removed, the XYLayoutManager used by the parent
			// container (the Figure of the DPFDiagramEditPart), will not know the bounds of
			// this figure and will not draw it correctly.
			Rectangle bounds = new Rectangle(getCastedModel().getLocation(), getCastedModel().getSize());
			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
		} catch (Exception e) {
			
			
		}
	}

	private void refreshLabel() {
		NodeFigure tableFigure = (NodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setText(getFullName());
		label.setVisible(true);
	}
}