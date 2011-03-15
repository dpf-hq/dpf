/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
�* All rights reserved. This program and the accompanying materials
�* are made available under the terms of the Eclipse Public License v1.0
�* which accompanies this distribution, and is available at
�* http://www.eclipse.org/legal/epl-v10.html
�*
�* Contributors:
�*����Elias Volanakis - initial API and implementation
�*******************************************************************************/
package no.hib.dpf.editor.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import no.hib.dpf.editor.figures.ArrowConnection;
import no.hib.dpf.editor.model.ArrowBendpoint;
import no.hib.dpf.editor.model.SingleLineConstraintElement;
import no.hib.dpf.editor.model.VArrow;
import no.hib.dpf.editor.model.VConstraint;
import no.hib.dpf.editor.model.commands.ConnectionDeleteCommand;
import no.hib.dpf.metamodel.Arrow;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RelativeBendpoint;
import org.eclipse.draw2d.RoutingAnimator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.swt.SWT;


/**
 * Edit part for VEdge model elements.
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 */
public class ArrowEditPart extends ModelElementConnectionEditPart {

	protected ArrowConnection connectionFigure; 
	Label connectionLabel;	
	private List<SingleLineConstraintElement> singleConstraints = new ArrayList<SingleLineConstraintElement>();
	private transient PropertyChangeSupport pcsDelegate = new PropertyChangeSupport(this);
		
	/**
	 * Sets the source EditPart of this connection.
	 * 
	 * @param editPart
	 *            EditPart which is the source.
	 */
	public void setSource(EditPart editPart) {
		super.setSource(editPart);
		if (editPart != null) {
			setParent(editPart.getParent());
		}
	}


	/**
	 * Sets the target EditPart of this connection.
	 * 
	 * @param editPart
	 *            EditPart which is the target.
	 */
	public void setTarget(EditPart editPart) {
		super.setTarget(editPart);
		if (editPart != null) {
			setParent(editPart.getParent());
		}
	}
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
		
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		refreshBendpointEditPolicy();
				
		// Selection handle edit policy.
		// Makes the connection show a feedback, when selected by the user.
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		// Allows the removal of the connection model element		
		installEditPolicy(EditPolicy.CONNECTION_ROLE,
				new ConnectionEditPolicy() {
					protected Command getDeleteCommand(GroupRequest request) {
						return new ConnectionDeleteCommand(getCastedModel());
					}
				});
	}
	
	public VArrow getArrow() {
		return (VArrow) getModel();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		//EditableLabel label = new EditableLabel(getFullName());
		createConnectionFigure(); //label);
		connectionFigure.addRoutingListener(RoutingAnimator.getDefault());
		makeNewConstraintLabel();
		setArrowHead(connectionFigure);
//		connectionFigure.setLineStyle(getCastedModel().getLineStyle()); // line drawing style
		return connectionFigure;		
	}

	protected void createConnectionFigure() { //EditableLabel label) {
		connectionFigure = new ArrowConnection(); //label);
	}

	protected void setArrowHead(PolylineConnection connectionFigure) {
		PolygonDecoration arrowHead = new OpenArrowDecoration();
		arrowHead.setFill(false);
		arrowHead.setScale(16, 6);
		connectionFigure.setTargetDecoration(arrowHead); // arrow at target endpoint		
	}
	
	private class OpenArrowDecoration extends PolygonDecoration {

		public OpenArrowDecoration() {
			TRIANGLE_TIP.removeAllPoints();
			TRIANGLE_TIP.addPoint(-1, 1);
			TRIANGLE_TIP.addPoint(0, 0);
			TRIANGLE_TIP.addPoint(-1, -1);
		}
		
		@Override
		protected void outlineShape(Graphics g) {
			g.pushState();
			g.setAntialias(SWT.ON);
			g.drawPolyline(getPoints());
			g.popState();
		}

	}
	
	/**
	 * If any constraints are set on this connection, the connection is decorated
	 * with the appropriate vizualisation.
	 */
	private void makeNewConstraintLabel() {
		if (connectionFigure == null) {
			return;
		}

		if (singleConstraints.size() > 0) {
			if (connectionLabel != null) {
				connectionFigure.remove(connectionLabel);
			}

			connectionLabel = new Label();
			connectionLabel.setText(singleConstraints.get(0).toString());			
			connectionLabel.setOpaque(true);
			connectionFigure.add(connectionLabel);
			connectionFigure.getLayoutManager().setConstraint(connectionLabel, new EndpointLocator(connectionFigure));
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
				
		// * E X T R A S :
		
		if (Connection.PROPERTY_CONNECTION_ROUTER.equals(property)){
			refreshBendpoints();
			refreshBendpointEditPolicy();
		} else if ("value".equals(property)) {  //$NON-NLS-1$
			refreshVisuals();
		} else 	if ("bendpoint".equals(property)) {   //$NON-NLS-1$
			refreshBendpoints();
		} else if (VArrow.LINESTYLE_PROP.equals(property)) {
			((ArrowConnection) getFigure()).setLineStyle(getCastedModel()
					.getLineStyle());
		} else if (VArrow.SOURCE_CONSTRAINTS_PROP.equals(property)) {
			refreshSourceConnections();
		} else if (VArrow.TARGET_CONSTRAINTS_PROP.equals(property)) {
			refreshTargetConnections();
		} else if (VArrow.SINGLE_CONSTRAINTS_PROP.equals(property)) {
			refreshSingleLineConstraints();
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
	private List getModelConnections(List<VConstraint> constraints) {
		if (constraints.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		return constraints;		
	}

	protected VArrow getCastedModel() {
		return (VArrow)getModel();
	}
	
	public Arrow getModelAsEMFInstance() {
		return getCastedModel().getArrowComponent();
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
	
	
	public void activateFigure(){
		super.activateFigure();
		/*Once the figure has been added to the ConnectionLayer, start listening for its
		 * router to change.
		 */
		getFigure().addPropertyChangeListener(Connection.PROPERTY_CONNECTION_ROUTER, this);
	}
	
	public void deactivateFigure(){
		getFigure().removePropertyChangeListener(Connection.PROPERTY_CONNECTION_ROUTER, this);
		super.deactivateFigure();
	}

	
	/**
	 * Updates the bendpoints, based on the model.
	 */
	protected void refreshBendpoints() {
		if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter) {
			return;
		}
		List<Bendpoint> modelConstraint = getArrow().getBendpoints();
		List<Bendpoint> figureConstraint = new ArrayList<Bendpoint>();
		for (int i = 0; i < modelConstraint.size(); i++) {
			ArrowBendpoint wbp = (ArrowBendpoint)modelConstraint.get(i);
			RelativeBendpoint rbp = new RelativeBendpoint(getConnectionFigure());
			rbp.setRelativeDimensions(wbp.getFirstRelativeDimension(),
										wbp.getSecondRelativeDimension());
			rbp.setWeight((i+1) / ((float)modelConstraint.size()+1));
			figureConstraint.add(rbp);
		}
		getConnectionFigure().setRoutingConstraint(figureConstraint);
	}

	private void refreshBendpointEditPolicy(){
		if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter) {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, null);
		} else {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new ArrowBendpointEditPolicy());
		}
	}

	@Override
	protected void refreshVisuals() {
		refreshBendpoints();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelChildren() {
		VArrow model = getCastedModel();
		return model.getLabels();
	}	

}