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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Node;
import no.hib.dpf.editor.DPFErrorReport;
import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DNode;
import no.hib.dpf.editor.displaymodel.LocationAndSize;
import no.hib.dpf.editor.displaymodel.ModelElement;
import no.hib.dpf.editor.displaymodel.commands.ConnectionReconnectCommand;
import no.hib.dpf.editor.displaymodel.commands.VArrowCreateCommand;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.extension_points.INodePainting;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.MultipleArrowsChopboxAnchor;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.TextCellEditorLocator;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.editor.policies.TextDirectEditManager;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;
import no.hib.dpf.editor.preferences.PreferenceConstants;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.TextCellEditor;

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

	protected IConfigurationElement configure = null;

	public IConfigurationElement getConfigure() {
		return configure;
	}

	public void setConfigure(IConfigurationElement configure) {
		this.configure = configure;
		
	}

	public NodeEditPart(IConfigurationElement figure) {
		super();
		configure = figure;
	}

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

	 @Override
     public void performRequest(Request req) {
           if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
        	   TextDirectEditManager manager = new TextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator(((NodeFigure)getFigure()).getNameLabel()));
        	   manager.show();
        	   return;
           }
           super.performRequest(req);
     }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		// allow the creation of connections and
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new GraphicalNodeEditPolicy() {

					protected Command getConnectionCompleteCommand(
							CreateConnectionRequest request) {
						VArrowCreateCommand cmd = (VArrowCreateCommand) request
								.getStartCommand();
						if(cmd != null)
							cmd.setTarget((DNode) getHost().getModel());
						return cmd;
					}

					protected Command getConnectionCreateCommand(
							CreateConnectionRequest request) {

						DNode source = (DNode) getHost().getModel();
						Object objectType = request.getNewObjectType();
						VArrowCreateCommand cmd = null;
						if (objectType == DArrow.class) {
							DArrow darrow = (DArrow) request.getNewObject();
							cmd = new VArrowCreateCommand(darrow, source);
						}
						request.setStartCommand(cmd);
						return cmd;
					}

					protected Command getReconnectSourceCommand(
							ReconnectRequest request) {
						DArrow conn = (DArrow) request.getConnectionEditPart()
								.getModel();
						DNode newSource = (DNode) getHost().getModel();
						ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(
								conn);
						cmd.setNewSource(newSource);
						return cmd;
					}

					protected Command getReconnectTargetCommand(
							ReconnectRequest request) {
						DArrow conn = (DArrow) request.getConnectionEditPart()
								.getModel();
						DNode newTarget = (DNode) getHost().getModel();
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
	
	private DNode getShape() {
		return (DNode) getModel();
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
		if(configure != null)
			getNodePaint();
		if(nodePaint != null)
			return nodePaint.createNodeFigure();
		return new NodeFigure(new EditableLabel(getFullName()));
	}

	private INodePainting nodePaint;
	private INodePainting getNodePaint() {
		if(nodePaint == null)
			try {
				nodePaint = (INodePainting) configure.createExecutableExtension(FigureConfigureManager.PAINT_ATT);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		return nodePaint;
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

	private DNode getCastedModel() {
		return (DNode) getModel();
	}

	public Node getModelAsEMFInstance() {
		return getCastedModel().getNodeComponent();
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
	
	private boolean anchorListContainsConnection(List<ConnectionAnchor> previousAnchorList, ConnectionEditPart connection) {
		return (getConnectionsAnchor(previousAnchorList, connection) != null);
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
	protected List<DArrow> getModelSourceConnections() {
		return getCastedModel().getSourceConnections();
	}

	@Override
	protected List<DArrow> getModelTargetConnections() {
		return getCastedModel().getTargetConnections();
	}

	public ConnectionAnchor createConnectionAnchor(ConnectionEditPart connection, boolean b, NodeEditPart owner){
		ConnectionAnchor anchor = owner.createAnchorUseConfigure();
		if(anchor != null)
			return anchor;
		return getConnectionAnchor(connection, b);
	}
	private ConnectionAnchor createAnchorUseConfigure(){
		if(configure != null)
			getNodePaint();
		if(nodePaint != null)
			return nodePaint.createConnectionAnchor(getFigure());
		return null;
	}
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return createConnectionAnchor(connection, true, getAnchorOwner(connection, true));
	}

	private NodeEditPart getAnchorOwner(ConnectionEditPart connection, boolean source){
		if(connection == null || source || connection.getTarget() == null)
			return this;
		return (NodeEditPart) connection.getTarget();
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
		} else if (DNode.SOURCE_CONNECTIONS_PROP.equals(prop)) {
			refreshSourceConnections();
		} else if (DNode.TARGET_CONNECTIONS_PROP.equals(prop)) {
			refreshTargetConnections();
			diagram.validateSemantics();
		} else if (DNode.NAME_PROP.equals(prop)) {
			commitNameChange(evt);
		}
	}

	protected void refreshVisuals() {
		try {
			super.refreshVisuals();
			refreshLabel();
			// notify parent container of changed position & location
			// if this line is removed, the XYLayoutManager used by the parent
			// container (the Figure of the DPFDiagramEditPart), will not know the bounds of
			// this figure and will not draw it correctly.
			Rectangle bounds = new Rectangle(getCastedModel().getLocation(), getCastedModel().getSize());
			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
		} catch (Exception e) {
			DPFErrorReport.logError(e);
		}
	}

	private void refreshLabel() {
		NodeFigure tableFigure = (NodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setText(getFullName());
		label.setVisible(true);
	}
}