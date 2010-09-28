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

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.Constraint;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
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
	PolylineConnection connection = new PolylineConnection();
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


}