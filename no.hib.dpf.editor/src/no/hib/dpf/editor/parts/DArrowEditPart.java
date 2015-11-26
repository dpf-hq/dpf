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
import org.eclipse.draw2d.geometry.Rectangle;
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

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.commands.DArrowDeleteCommand;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.extension_points.IArrowPainting;
import no.hib.dpf.editor.figures.ArrowConnection;
import no.hib.dpf.editor.figures.ConstraintAnchor;
import no.hib.dpf.editor.figures.Draw2dUtil;
import no.hib.dpf.editor.figures.OpenArrowDecoration;
import no.hib.dpf.editor.policies.ArrowBendpointEditPolicy;


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

	protected IFigure createFigure() {
		if(getArrowPaint() != null){
			connectionFigure = arrowPaint.createConnectionFigure();
			connectionFigure.setTargetDecoration(arrowPaint.createTargetDecoration());
			((ArrowConnection)connectionFigure).isStandard = false;
		}
		else{
			createConnectionFigure();
			setArrowHead(connectionFigure);
		}
		connectionFigure.addRoutingListener(RoutingAnimator.getDefault());
		((ArrowConnection)connectionFigure).foreGroundColor = connectionFigure.getForegroundColor();
		for(Object edit : getChildren())
			if(edit instanceof AbstractGraphicalEditPart)
				connectionFigure.add(((AbstractGraphicalEditPart)edit).getFigure());
		return connectionFigure;		
	}

	private IArrowPainting getArrowPaint(){
		if(arrowPaint == null)
			try {
				String name = getDArrow().getDType().getConfigureString();
				if(name == null || name.isEmpty())
					return null;
				IConfigurationElement configure = FigureConfigureManager.getConfigurationElement(name);
				if(configure != null)
					arrowPaint = (IArrowPainting) configure.createExecutableExtension(FigureConfigureManager.PAINT_ATT);
			} catch (CoreException e) {
				DPFUtils.logError(e);
			}
		return arrowPaint;
	}

	private IArrowPainting arrowPaint;

	protected void createConnectionFigure() {
		connectionFigure = new ArrowConnection();
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
					refreshChildren();
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

	/**
	 * Updates the bendpoints, based on the model.
	 */
	protected void refreshBendpoints() {
		if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter)  return;
		List<DOffset> points = getDArrow().getBendpoints();
		List<Bendpoint> figureConstraint = new ArrayList<Bendpoint>();
		if(getSource() != null && getTarget() != null){
			Rectangle source = ((NodeEditPart)getSource()).getFigure().getBounds();
			Rectangle target = ((NodeEditPart)getTarget()).getFigure().getBounds();
			Point start = source.getCenter(), end = target.getCenter();
			if(getSource() == getTarget()){
				start = source.getTop();
				end = source.getBottom();
				if(points.size() == 0){
					int x = start.x, y = start.y;
					points.add(Draw2dUtil.getDOffset(start, end, new Point(x, y = y - source.height / 2)));
					points.add(Draw2dUtil.getDOffset(start, end, new Point(x = x - source.width, y)));
					points.add(Draw2dUtil.getDOffset(start, end, new Point(x, y = y + source.height * 2)));
					points.add(Draw2dUtil.getDOffset(start, end, new Point(x + source.width, y)));
				}
			}
			for(DOffset p : points){
				Point point = Draw2dUtil.getAbsoluteBendPoint(start, end, p);
				figureConstraint.add(new AbsoluteBendpoint(point));
			}
			getConnectionFigure().setRoutingConstraint(figureConstraint);
		}
	}

	protected void refreshBendpointEditPolicy(){
		if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter) {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, null);
		} else {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new ArrowBendpointEditPolicy());
		}
	}

	@Override
	public void refreshVisuals() {
		DArrow darrow = getDArrow();
		if(getEditor() != null && connectionFigure instanceof ArrowConnection)
			((ArrowConnection)connectionFigure).setErrorFlag(getEditor().isMakerExisting(darrow.getArrow()));
		refreshBendpoints();
		ArrowConnection arrowConnection = (ArrowConnection) getFigure();
		arrowConnection.setForegroundColor(arrowConnection.foreGroundColor);
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
	protected List<?> getModelSourceConnections() {
		return getDArrow().getConstraintsFrom();
	}

	@Override
	protected List<DConstraint> getModelTargetConnections() {
		return getDArrow().getConstraintsTo();
	}

	/*
	 * The source and the target anchors are used to create constraints.
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor( ConnectionEditPart connection) { return getConnectionAnchor(connection); }


	@Override
	public ConnectionAnchor getTargetConnectionAnchor( ConnectionEditPart connection) {return getConnectionAnchor(connection);}


	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {return null;}


	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {return null;}
	
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