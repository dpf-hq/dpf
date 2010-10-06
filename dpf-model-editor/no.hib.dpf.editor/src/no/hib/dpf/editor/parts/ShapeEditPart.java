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
import java.util.List;

import no.hib.dpf.editor.figures.BasicRectangleFigure;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.ModelElement;
import no.hib.dpf.editor.model.RectangularShape;
import no.hib.dpf.editor.model.Shape;
import no.hib.dpf.editor.model.commands.ConnectionCreateCommand;
import no.hib.dpf.editor.model.commands.ConnectionReconnectCommand;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;


/**
 * EditPart used for Shape instances (more specific for EllipticalShape and
 * RectangularShape instances).
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * 
 * @author Elias Volanakis
 */
public class ShapeEditPart extends AbstractGraphicalEditPart 
	implements PropertyChangeListener, NodeEditPart {
	
private ConnectionAnchor anchor;

/**
 * Upon activation, attach to the model element as a property change listener.
 */
public void activate() {
	if (!isActive()) {
		super.activate();
		((ModelElement) getModel()).addPropertyChangeListener(this);
	}
}

/* (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
 */
protected void createEditPolicies() {
//	installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new TableNodeEditPolicy());
//	installEditPolicy(EditPolicy.LAYOUT_ROLE, new TableLayoutEditPolicy());
//	installEditPolicy(EditPolicy.CONTAINER_ROLE, new TableContainerEditPolicy());
//	installEditPolicy(EditPolicy.COMPONENT_ROLE, new TableEditPolicy());
//	installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new ShapeDirectEditPolicy());
	
	// allow removal of the associated model element
	installEditPolicy(EditPolicy.COMPONENT_ROLE, new ShapeComponentEditPolicy());
	// allow the creation of connections and 
	// and the reconnection of connections between Shape instances
	installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
		/* (non-Javadoc)
		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
		 */
		protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
			ConnectionCreateCommand cmd 
				= (ConnectionCreateCommand) request.getStartCommand();
			cmd.setTarget((Shape) getHost().getModel());
			return cmd;
		}
		/* (non-Javadoc)
		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
		 */
		protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
			Shape source = (Shape) getHost().getModel();
			int style = ((Integer) request.getNewObjectType()).intValue();
			ConnectionCreateCommand cmd = new ConnectionCreateCommand(source, style);
			request.setStartCommand(cmd);
			return cmd;
		}
		/* (non-Javadoc)
		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
		 */
		protected Command getReconnectSourceCommand(ReconnectRequest request) {
			Connection conn = (Connection) request.getConnectionEditPart().getModel();
			Shape newSource = (Shape) getHost().getModel();
			ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
			cmd.setNewSource(newSource);
			return cmd;
		}
		/* (non-Javadoc)
		 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
		 */
		protected Command getReconnectTargetCommand(ReconnectRequest request) {
			Connection conn = (Connection) request.getConnectionEditPart().getModel();
			Shape newTarget = (Shape) getHost().getModel();
			ConnectionReconnectCommand cmd = new ConnectionReconnectCommand(conn);
			cmd.setNewTarget(newTarget);
			return cmd;
		}
	});
}

/**
 * @param handles
 *            the name change during an edit
 */
public void handleNameChange(String value)
{
	BasicRectangleFigure tableFigure = (BasicRectangleFigure) getFigure();
	EditableLabel label = tableFigure.getNameLabel();
	label.setVisible(false);
	refreshVisuals();
}

private Shape getShape() {
	return (Shape)getModel();
}

/**
 * Reverts to existing name in model when exiting from a direct edit
 * (possibly before a commit which will result in a change in the label
 * value)
 */
public void revertNameChange()
{
	BasicRectangleFigure tableFigure = (BasicRectangleFigure) getFigure();
	EditableLabel label = tableFigure.getNameLabel();
	label.setText(getShape().getNameExec());
	label.setVisible(true);
	refreshVisuals();
}

/**
 * Handles change in name when committing a direct edit
 */
private void commitNameChange(PropertyChangeEvent evt)
{
	BasicRectangleFigure tableFigure = (BasicRectangleFigure) getFigure();
	EditableLabel label = tableFigure.getNameLabel();
	label.setText(getShape().getNameExec());
	label.setVisible(true);
	refreshVisuals();
}

	
/*(non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
 */
protected IFigure createFigure() {
	IFigure f = createFigureForModel();
	return f;
}

/**
 * Return a IFigure depending on the instance of the current model element.
 * This allows this EditPart to be used for both sublasses of Shape. 
 */
private IFigure createFigureForModel() {
	if (getModel() instanceof RectangularShape) {
		
		EditableLabel label = new EditableLabel(((Shape)getModel()).getNameExec());
		return new BasicRectangleFigure(label);
	} else {
		// if Shapes gets extended the conditions above must be updated
		throw new IllegalArgumentException();
	}
}

/**
 * Upon deactivation, detach from the model element as a property change listener.
 */
public void deactivate() {
	if (isActive()) {
		super.deactivate();
		((ModelElement) getModel()).removePropertyChangeListener(this);
	}
}

private Shape getCastedModel() {
	return (Shape) getModel();
}

protected ConnectionAnchor getConnectionAnchor() {
	if (anchor == null) {
		if (getModel() instanceof RectangularShape)
			anchor = new ChopboxAnchor(getFigure());
		else
			// if Shapes gets extended the conditions above must be updated
			throw new IllegalArgumentException("unexpected model");
	}
	return anchor;
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
 */
@Override
protected List<Connection> getModelSourceConnections() {
	return getCastedModel().getSourceConnections();
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
 */
@Override
protected List<Connection> getModelTargetConnections() {
	return getCastedModel().getTargetConnections();
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
 */
public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
	return getConnectionAnchor();
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
 */
public ConnectionAnchor getSourceConnectionAnchor(Request request) {
	return getConnectionAnchor();
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
 */
public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
	return getConnectionAnchor();
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
 */
public ConnectionAnchor getTargetConnectionAnchor(Request request) {
	return getConnectionAnchor();
}

/* (non-Javadoc)
 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
 */
public void propertyChange(PropertyChangeEvent evt) {
	String prop = evt.getPropertyName();
	if (Shape.SIZE_PROP.equals(prop) || Shape.LOCATION_PROP.equals(prop)) {
		refreshVisuals();
	} else if (Shape.SOURCE_CONNECTIONS_PROP.equals(prop)) {
		refreshSourceConnections();
	} else if (Shape.TARGET_CONNECTIONS_PROP.equals(prop)) {
		refreshTargetConnections();
	} else if (Shape.NAME_PROP.equals(prop)) {
		commitNameChange(evt);
	}
}

protected void refreshVisuals() {
	// notify parent container of changed position & location
	// if this line is removed, the XYLayoutManager used by the parent container 
	// (the Figure of the DPFDiagramEditPart), will not know the bounds of this figure
	// and will not draw it correctly.
	Rectangle bounds = new Rectangle(getCastedModel().getLocation(),
			getCastedModel().getSize());
	((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
}
}