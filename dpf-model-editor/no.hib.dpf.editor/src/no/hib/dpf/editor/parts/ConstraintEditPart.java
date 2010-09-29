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

import no.hib.dpf.editor.figures.DPFConstraintFigure;
import no.hib.dpf.editor.figures.LineConstraintAnchor_2;
import no.hib.dpf.editor.model.Constraint;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;


/**
 * Edit part for Constraint model elements.
 */
class ConstraintEditPart extends ModelElementConnectionEditPart {


/* (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
 */
protected void createEditPolicies() {
	// Selection handle edit policy. 
	// Makes the connection show a feedback, when selected by the user.
	installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
//	// Allows the removal of the connection model element
//	installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
//		protected Command getDeleteCommand(GroupRequest request) {
//			return new ConnectionDeleteCommand(getCastedModel());
//		}
//	});
}

/* (non-Javadoc)
 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
 */
protected IFigure createFigure() {
	DPFConstraintFigure connection = new DPFConstraintFigure();
	connection.setLineStyle(getCastedModel().getLineStyle());  // line drawing style
	return connection;
}


/* (non-Javadoc)
 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
 */
public void propertyChange(PropertyChangeEvent event) {
	String property = event.getPropertyName();
	if (Constraint.LINESTYLE_PROP.equals(property)) {
		((PolylineConnection) getFigure()).setLineStyle(getCastedModel().getLineStyle());
	}

}

private Constraint getCastedModel() {
	return (Constraint) getModel();
}

/**
 * Updates the source ConnectionAnchor. Subclasses should override
 * {@link #getSourceConnectionAnchor()} if necessary, and not this method.
 */
@Override
protected void refreshSourceAnchor() {
	try {
		getConnectionFigure().setSourceAnchor(getSourceConnectionAnchor());
	} catch (Exception e) {
		int stop = 23;
	}
}

/**
 * Returns the <code>ConnectionAnchor</code> for the <i>source</i> end of
 * the connection. If the source is an instance of {@link NodeEditPart},
 * that interface will be used to determine the proper ConnectionAnchor. If
 * the source is not an instance of <code>NodeEditPart</code>, this method
 * should be overridden to return the correct ConnectionAnchor. Failure to
 * do this will cause a default anchor to be used so that the connection
 * figure will be made visible to the developer.
 * 
 * @return ConnectionAnchor for the source end of the Connection
 */
@Override
protected ConnectionAnchor getSourceConnectionAnchor() {
	LineConstraintAnchor_2 retval = new LineConstraintAnchor_2(new Point(100, 100));

	if (getSource() != null) {
		if (getSource() instanceof MyConnectionEditPart) {
			MyConnectionEditPart source = (MyConnectionEditPart)getSource();
			retval.setConnectionFigure((PolylineConnection) source.getFigure());
		}
	}
	
	return retval;
}

/**
 * Returns the <code>ConnectionAnchor</code> for the <i>target</i> end of
 * the connection. If the target is an instance of {@link NodeEditPart},
 * that interface will be used to determine the proper ConnectionAnchor. If
 * the target is not an instance of <code>NodeEditPart</code>, this method
 * should be overridden to return the correct ConnectionAnchor. Failure to
 * do this will cause a default anchor to be used so that the connection
 * figure will be made visible to the developer.
 * 
 * @return ConnectionAnchor for the target end of the Connection
 */
protected ConnectionAnchor getTargetConnectionAnchor() {
	LineConstraintAnchor_2 retval = new LineConstraintAnchor_2(new Point(100, 100));

	if (getTarget() != null) {
		if (getTarget() instanceof MyConnectionEditPart) {
			MyConnectionEditPart target = (MyConnectionEditPart)getTarget();
			retval.setConnectionFigure((PolylineConnection) target.getFigure());
		}
	}
	
	return retval;
}

}