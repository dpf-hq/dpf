/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor.parts;

import java.beans.PropertyChangeEvent;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import no.hib.dpf.editor.figures.DPFConnectionFigure;
import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.Constraint;
import no.hib.dpf.editor.model.commands.ConnectionDeleteCommand;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;


/**
 * Edit part for Connection model elements.
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 * @author Elias Volanakis
 */
class MyConnectionEditPart extends ModelElementConnectionEditPart implements NodeEditPart {


/* (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
 */
protected void createEditPolicies() {
	// Selection handle edit policy. 
	// Makes the connection show a feedback, when selected by the user.
	installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
			new ConnectionEndpointEditPolicy());
	// Allows the removal of the connection model element
	installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
		protected Command getDeleteCommand(GroupRequest request) {
			return new ConnectionDeleteCommand(getCastedModel());
		}
	});
}

/* (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
 */
protected IFigure createFigure() {
	DPFConnectionFigure connection = new DPFConnectionFigure();
	connection.setTargetDecoration(new PolygonDecoration()); // arrow at target endpoint
	connection.setLineStyle(getCastedModel().getLineStyle());  // line drawing style
	return connection;
}


/* (non-Javadoc)
 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
 */
public void propertyChange(PropertyChangeEvent event) {
	String property = event.getPropertyName();
	if (Connection.LINESTYLE_PROP.equals(property)) {
		((DPFConnectionFigure) getFigure()).setLineStyle(getCastedModel().getLineStyle());
	} else if (Connection.SOURCE_CONSTRAINTS_PROP.equals(property)) {
		refreshSourceConnections();
	} else if (Connection.TARGET_CONSTRAINTS_PROP.equals(property)) {
		refreshTargetConnections();
	}
	
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
 */
@Override
protected List getModelSourceConnections() {
	//return super.getModelSourceConnections();
	List retval = getCastedModel().getSourceConstraints();
	if (retval.size() == 0) return Collections.EMPTY_LIST;
 	return retval;
}

/*
 * (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
 */
@Override
protected List getModelTargetConnections() {
//	return super.getModelTargetConnections();
	List retval = getCastedModel().getTargetConstraints();
	if (retval.size() == 0) return Collections.EMPTY_LIST;
 	return retval;
}

private Connection getCastedModel() {
	return (Connection) getModel();
}


/*
 * (non-Javadoc)
 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
 */
@Override
public ConnectionAnchor getSourceConnectionAnchor(Request request) {
	return getConnectionAnchor();
}



/*
 * (non-Javadoc)
 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
 */
public ConnectionAnchor getTargetConnectionAnchor(Request request) {
	return getConnectionAnchor();
}

private ConnectionAnchor anchor;

protected ConnectionAnchor getConnectionAnchor() {
	Random random = new Random();
	
	if (anchor == null) {
		anchor = new XYAnchor(new Point(random.nextInt(400), random.nextInt(400)));
	}
	return anchor;
}

@Override
public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
	return getConnectionAnchor();
}

@Override
public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
	return getConnectionAnchor();
}



}