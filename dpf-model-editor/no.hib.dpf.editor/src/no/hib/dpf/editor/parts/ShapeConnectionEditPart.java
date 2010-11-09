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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.hib.dpf.editor.figures.DPFConnectionFigure;
import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.ConstraintElement;
import no.hib.dpf.editor.model.Shape;
import no.hib.dpf.editor.model.SingleLineConstraintElement;
import no.hib.dpf.editor.model.commands.ConnectionDeleteCommand;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;


/**
 * Edit part for Connection model elements.
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 */
public class ShapeConnectionEditPart extends ModelElementConnectionEditPart {

	private DPFConnectionFigure connection; 
	Label connectionLabel;
	private List<SingleLineConstraintElement> singleConstraints = new ArrayList<SingleLineConstraintElement>();
	private transient PropertyChangeSupport pcsDelegate = new PropertyChangeSupport(this);


	/**
	 * Attach a non-null PropertyChangeListener to this object.
	 * 
	 * @param l
	 *            a non-null PropertyChangeListener instance
	 * @throws IllegalArgumentException
	 *             if the parameter is null
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		if (l == null) {
			throw new IllegalArgumentException();
		}
		pcsDelegate.addPropertyChangeListener(l);
	}

	/**
	 * Report a property change to registered listeners (for example edit
	 * parts).
	 * 
	 * @param property
	 *            the programmatic name of the property that changed
	 * @param oldValue
	 *            the old value of this property
	 * @param newValue
	 *            the new value of this property
	 */
	protected void firePropertyChange(String property, Object oldValue, Object newValue) {
		if (pcsDelegate.hasListeners(property)) {
			pcsDelegate.firePropertyChange(property, oldValue, newValue);
		}
	}
	
	public void updateConstraints() {
		getCastedModel().updateConstraints();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// Selection handle edit policy.
		// Makes the connection show a feedback, when selected by the user.
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new ConnectionEndpointEditPolicy());
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE,
				new ConnectionEditPolicy() {
					protected Command getDeleteCommand(GroupRequest request) {
						return new ConnectionDeleteCommand(getCastedModel());
					}
				});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		connection = new DPFConnectionFigure();
		makeNewConstraintLabel();

		PolygonDecoration arrowHead = new PolygonDecoration();
		arrowHead.setScale(16, 6);
		connection.setTargetDecoration(arrowHead); // arrow at target endpoint
		connection.setLineStyle(getCastedModel().getLineStyle()); // line drawing style
		connection.setEditPart(this);
		return connection;
	}

	/**
	 * If any constraints are set on this connection, the connection is decorated
	 * with the appropriate vizualisation.
	 */
	private void makeNewConstraintLabel() {
		if (connection == null) {
			return;
		}

		if (singleConstraints.size() > 0) {
			if (connectionLabel != null) {
				connection.remove(connectionLabel);
			}

			connectionLabel = new Label();
			connectionLabel.setText(singleConstraints.get(0).toString());
			connection.add(connectionLabel);
			connection.getLayoutManager().setConstraint(connectionLabel, new EndpointLocator(connection));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.
	 * PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		String property = event.getPropertyName();
		if (Connection.LINESTYLE_PROP.equals(property)) {
			((DPFConnectionFigure) getFigure()).setLineStyle(getCastedModel()
					.getLineStyle());
		} else if (Connection.SOURCE_CONSTRAINTS_PROP.equals(property)) {
			refreshSourceConnections();
		} else if (Connection.TARGET_CONSTRAINTS_PROP.equals(property)) {
			refreshTargetConnections();
		} else if (Connection.SINGLE_CONSTRAINTS_PROP.equals(property)) {
			refreshSingleLineConstraints();
//		} else if (Shape.NEW_LOCATION_PROP.equals(property)) {
//			System.out.println("gabba-connect");
//			refresh();
//			getFigure().revalidate();
		}
	}
	
	@Override
	public IFigure getFigure() {
		if (figure == null) {
			setFigure(createFigure());
			figure.addPropertyChangeListener(this);
		}
		return figure;
	}	

	private void refreshSingleLineConstraints() {
		singleConstraints.clear();
		for (SingleLineConstraintElement singleLineConstraintElement : getCastedModel()
				.getSingleConstraints()) {
			singleConstraints.add(singleLineConstraintElement);
		}
		makeNewConstraintLabel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections
	 * ()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelSourceConnections() {
		return getModelConnections(getCastedModel().getSourceConstraints());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections
	 * ()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelTargetConnections() {
		return getModelConnections(getCastedModel().getTargetConstraints());
	}

	@SuppressWarnings("rawtypes")
	private List getModelConnections(List<ConstraintElement> constraints) {
		if (constraints.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		return constraints;		
	}

	private Connection getCastedModel() {
		return (Connection) getModel();
	}

	/**
	 * Finds an endpoint on a connection. TODO: make readable.
	 */
	public class EndpointLocator extends ConnectionLocator {

		public EndpointLocator(org.eclipse.draw2d.Connection c) {
			super(c);
		}

		protected Point getReferencePoint() {
			org.eclipse.draw2d.Connection conn = getConnection();
			return calculateConnectionPoint(conn.getPoints());
		}

		private int maxDistanceToConnectionPoint = 50; 
		
		private Point calculateConnectionPoint(PointList points) {
			if (points.size() < 2) return points.getLastPoint();
			
			double distanceBetweenLastPoints = points.getLastPoint().getDistance(points.getPoint(points.size() - 2));
			if (distanceBetweenLastPoints < 0.01) {
				return points.getLastPoint();
			}

			double distanceToConnectionPoint = distanceBetweenLastPoints/2;
			if (distanceToConnectionPoint > maxDistanceToConnectionPoint) {
				distanceToConnectionPoint = maxDistanceToConnectionPoint;
			}
			
			double factor = distanceToConnectionPoint/distanceBetweenLastPoints;

			int deltaX = points.getPoint(points.size() - 2).x - points.getPoint(points.size() - 1).x;
			int deltaY = points.getPoint(points.size() - 2).y - points.getPoint(points.size() - 1).y;
			
			deltaX = (int)(deltaX * factor);
			deltaY = (int)(deltaY * factor);
			
			return new Point(points.getLastPoint().x + deltaX, points.getLastPoint().y + deltaY - 10);
		}		
		
	}

}