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
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.DPFErrorReport;
import no.hib.dpf.editor.commands.DArrowDeleteCommand;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.extension_points.IArrowPainting;
import no.hib.dpf.editor.figures.ArrowConnection;
import no.hib.dpf.editor.figures.ConstraintAnchor;
import no.hib.dpf.editor.figures.OpenArrowDecoration;
import no.hib.dpf.editor.policies.ArrowBendpointEditPolicy;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RoutingAnimator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;


/**
 * Edit part for VEdge model elements.
 * <p>This edit part must implement the PropertyChangeListener interface, 
 * so it can be notified of property changes in the corresponding model element.
 * </p>
 */
public class DArrowEditPart extends GraphicalConnectionEditPart implements NodeEditPart {

	ArrowLabelEditPart labelEditPart = null;
	protected PolylineConnection connectionFigure; 
	Label connectionLabel;	

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

	/*
	 * (non-Javadoc)
	(ArrowBendpoint) * 
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		refreshBendpointEditPolicy();

		// Selection handle edit policy.
		// Makes the connection show a feedback, when selected by the user.
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		// Allows the removal of the connection model element		
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			protected Command getDeleteCommand(GroupRequest request) {
				return new DArrowDeleteCommand(getDArrow());
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		if(getArrowPaint() != null)
			connectionFigure = arrowPaint.createConnectionFigure();
		else
			createConnectionFigure();
		connectionFigure.addRoutingListener(RoutingAnimator.getDefault());
		if(arrowPaint != null)
			connectionFigure.setTargetDecoration(arrowPaint.createTargetDecoration());
		else
			setArrowHead(connectionFigure);
		for(Object edit : getChildren())
			if(edit instanceof AbstractGraphicalEditPart)
				connectionFigure.add(((AbstractGraphicalEditPart)edit).getFigure());
		return connectionFigure;		
	}

	private IArrowPainting getArrowPaint(){
		if(arrowPaint == null)
			try {
				String name = getDArrow().getConfigureString();
				if(name == null || name.isEmpty())
					return null;
				IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(name);
				if(configure != null)
					arrowPaint = (IArrowPainting) configure.createExecutableExtension(FigureConfigureManager.PAINT_ATT);
			} catch (CoreException e) {
				DPFErrorReport.logError(e);
			}
		return arrowPaint;
	}

	private IArrowPainting arrowPaint;

	protected void createConnectionFigure() {
		connectionFigure = new ArrowConnection();
		//		connectionFigure.setLineStyle(getDArrow().parentLineSytle == 0 ? SWT.LINE_SOLID : getCastedModel().parentLineSytle);
	}

	protected void setArrowHead(PolylineConnection connectionFigure) {
		PolygonDecoration arrowHead = new OpenArrowDecoration();
		arrowHead.setFill(false);
		arrowHead.setScale(16, 6);
		connectionFigure.setTargetDecoration(arrowHead); // arrow at target endpoint		
	}

	protected void handleModelChanged(Notification msg){
		super.handleDiagramModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDPFArrow()){ 
			switch(msg.getFeatureID(Arrow.class)){
			case CorePackage.ARROW__NAME:
				for(Object edit : getChildren())
					if(edit instanceof AbstractGraphicalEditPart)
						((AbstractGraphicalEditPart)edit).refresh();
			}
		}
	}

	protected void handleDiagramModelChanged(Notification msg){
		super.handleDiagramModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()){ 
			switch(msg.getFeatureID(DArrow.class)){
			case DiagramPackage.DARROW__DCONSTRAINTS:
				if(msg.getOldValue() instanceof DArrowLabelConstraint || msg.getNewValue() instanceof DArrowLabelConstraint)
					refresh();
				return;
			case DiagramPackage.DARROW__CONSTRAINTS_FROM:{
				refreshSourceConnections();
				return;
			}
			case DiagramPackage.DARROW__CONSTRAINTS_TO:{
				refreshTargetConnections();
				return;
			}
			case DiagramPackage.DARROW__BENDPOINTS:
				refresh();
			}
		}
	}
	PropertyChangeListener listener = new PropertyChangeListener() {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			if (Connection.PROPERTY_CONNECTION_ROUTER.equals(evt.getPropertyName())){
				refreshBendpoints();
				refreshBendpointEditPolicy();
			}
		}

	};

	protected void listen(){
		super.listen();
		if(!getDPFArrow().eAdapters().contains(modelListener))
			getDPFArrow().eAdapters().add(modelListener);
		getFigure().addPropertyChangeListener(listener); 
	}

	protected void unlisten(){
		getFigure().removePropertyChangeListener(listener); 
		if(getDPFArrow().eAdapters().contains(modelListener))
			getDPFArrow().eAdapters().remove(modelListener);
		super.unlisten();
	}
	public DArrow getDArrow(){
		return (DArrow) getModel();
	}

	public Arrow getDPFArrow(){
		DArrow darrow = getDArrow();
		if(darrow != null)
			return darrow.getArrow();
		return null;
	}

	//	/**
	//	 * Finds an endpoint on a connection. TODO: make readable.
	//	 */
	//	public class EndpointLocator extends ConnectionLocator {
	//
	//		public EndpointLocator(org.eclipse.draw2d.Connection c) {
	//			super(c);
	//		}
	//
	//		protected Point getReferencePoint() {
	//			org.eclipse.draw2d.Connection conn = getConnection();
	//			return calculateConnectionPoint(conn.getPoints());
	//		}
	//
	//		private int maxDistanceToConnectionPoint = 50; 
	//		
	//		private Point calculateConnectionPoint(PointList points) {
	//			if (points.size() < 2) return points.getLastPoint();
	//			
	//			double distanceBetweenLastPoints = points.getLastPoint().getDistance(points.getPoint(points.size() - 2));
	//			if (distanceBetweenLastPoints < 0.01) {
	//				return points.getLastPoint();
	//			}
	//
	//			double distanceToConnectionPoint = distanceBetweenLastPoints/2;
	//			if (distanceToConnectionPoint > maxDistanceToConnectionPoint) {
	//				distanceToConnectionPoint = maxDistanceToConnectionPoint;
	//			}
	//			
	//			double factor = distanceToConnectionPoint/distanceBetweenLastPoints;
	//
	//			int deltaX = points.getPoint(points.size() - 2).x - points.getPoint(points.size() - 1).x;
	//			int deltaY = points.getPoint(points.size() - 2).y - points.getPoint(points.size() - 1).y;
	//			
	//			deltaX = (int)(deltaX * factor);
	//			deltaY = (int)(deltaY * factor);
	//			
	//			return new Point(points.getLastPoint().x + deltaX, points.getLastPoint().y + deltaY - 10);
	//		}		
	//		
	//	}


	/**
	 * Updates the bendpoints, based on the model.
	 */
	protected void refreshBendpoints() {
		if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter) {
			return;
		}
		List<Point> points = getDArrow().getBendpoints();
		List<Bendpoint> figureConstraint = new ArrayList<Bendpoint>();
		for(Point p : points)
			figureConstraint.add(new AbsoluteBendpoint(p));
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
		DArrow darrow = getDArrow();
		if(connectionFigure instanceof ArrowConnection)
			((ArrowConnection)connectionFigure).setEpi(darrow.getDSource() == darrow.getDTarget());
		super.getModelChildren();
		refreshBendpoints();
	}

	@Override
	protected List<EObject> getModelChildren() {
		List<EObject> result = new ArrayList<EObject>();
		result.add(getDArrow().getNameOffset());
		for(DConstraint constraint : getDArrow().getDConstraints())
			if(constraint instanceof DArrowLabelConstraint)
				result.add(constraint);
		return result;
	}
	@Override
	protected List<DConstraint> getModelSourceConnections() {
		return getDArrow().getConstraintsFrom();
	}

	@Override
	protected List<DConstraint> getModelTargetConnections() {
		return getDArrow().getConstraintsTo();
	}


	@Override
	public ConnectionAnchor getSourceConnectionAnchor( ConnectionEditPart connection) { return getConnectionAnchor(connection); }


	@Override
	public ConnectionAnchor getTargetConnectionAnchor( ConnectionEditPart connection) {return getConnectionAnchor(connection);}


	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {return getConnectionAnchor(null);}


	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {return getConnectionAnchor(null);}
	
	/**
	 * Produces a ConnectionAnchor for either the source or target end of this
	 * constraint. The source (or target) needs to be an instance of 
	 * <code>ArrowEditPart</code>,
	 * @param supplier the source or target of this edit part.
	 * @param isSource true if supplier is source, false if not.
	 * @return A new ConnectionAnchor.
	 */
	protected ConnectionAnchor getConnectionAnchor(EditPart supplier) {
		// Now, the connection constraint anchor is constructed, setting from which end of the line it
		// should anchor itself:
		if (supplier == null) return null; 
		return new ConstraintAnchor(connectionFigure);
	}

}