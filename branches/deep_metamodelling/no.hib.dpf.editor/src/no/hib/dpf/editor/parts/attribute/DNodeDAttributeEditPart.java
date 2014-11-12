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
package no.hib.dpf.editor.parts.attribute;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.commands.attribute.DNodeAttributeDeleteCommand;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.extension_points.IArrowPainting;
import no.hib.dpf.editor.figures.ArrowConnection;
import no.hib.dpf.editor.figures.ConstraintAnchor;
import no.hib.dpf.editor.figures.OpenArrowDecoration;
import no.hib.dpf.editor.figures.draw2d.Draw2dUtil;
import no.hib.dpf.editor.parts.GraphicalConnectionEditPart;
import no.hib.dpf.editor.parts.node.DNodeEditPart;
import no.hib.dpf.editor.policies.attribute.DNodeDAttributeBendpointEditPolicy;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RoutingAnimator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
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

public class DNodeDAttributeEditPart extends GraphicalConnectionEditPart implements NodeEditPart {

	//ArrowLabelEditPart labelEditPart = null;
	protected PolylineConnection connectionFigure;
	Label connectionLabel;
	private IArrowPainting arrowPaint;

	@Override
	protected void createEditPolicies() {
		refreshBendpointEditPolicy();

		// Selection handle edit policy.
		// Makes the connection show a feedback, when selected by the user.
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE,
				new ConnectionEditPolicy() {
					@Override
					protected Command getDeleteCommand(GroupRequest request) {
						return new DNodeAttributeDeleteCommand(getDNodeDAttribute());
					}
				});
	
		}

	public PointList getRealPointList() {
		PointList result = new PointList();
		IFigure source = ((DNodeEditPart) getSource()).getFigure();
		IFigure target = ((DDataNodeEditPart) getTarget()).getFigure();
		Point start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
		Point end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		result.addPoint(start);
		
		DNodeDAttribute dattribute = getDNodeDAttribute();
		for (DOffset offset : dattribute.getBendpoints())
			result.addPoint(Draw2dUtil.getAbsoluteBendPoint(start, end, offset));
		result.addPoint(end);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		
		if (getArrowPaint() != null){
			connectionFigure = arrowPaint.createConnectionFigure();
		}else{
			createConnectionFigure();
			connectionFigure.setLineStyle(Graphics.LINE_CUSTOM);
			connectionFigure.setLineDash(new float[]{1,2});
		}
		
		connectionFigure.addRoutingListener(RoutingAnimator.getDefault());
		if (arrowPaint != null){
			connectionFigure.setTargetDecoration(arrowPaint.createTargetDecoration());
		}else{
			setArrowHead(connectionFigure);
		}
		
		for (Object edit : getChildren()){
			if (edit instanceof AbstractGraphicalEditPart){
				connectionFigure.add(((AbstractGraphicalEditPart) edit).getFigure());
			}
		}
		
		
		return connectionFigure;
	}

	private IArrowPainting getArrowPaint() {
		if (arrowPaint == null)
			try {
				String name = getDNodeDAttribute().getDType().getConfigureString();
				if (name == null || name.isEmpty()){
					return null;
				}
				
				IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(name);
				if (configure != null){
					arrowPaint = (IArrowPainting) configure.createExecutableExtension(FigureConfigureManager.PAINT_ATT);
				}
				
			} catch (CoreException e) {
				DPFCoreUtil.logError(e);
			}
		return arrowPaint;
	}
	protected void createConnectionFigure() {
		connectionFigure = new ArrowConnection();
	}

	protected void setArrowHead(PolylineConnection connectionFigure) {
		PolygonDecoration arrowHead = new OpenArrowDecoration();
		arrowHead.setFill(false);
		arrowHead.setScale(11,4);
		arrowHead.setLineStyle(Graphics.LINE_CUSTOM);
		arrowHead.setLineDash(new float[]{1,1});
		connectionFigure.setTargetDecoration(arrowHead);
	}

	@Override
	protected void handleModelChanged(Notification msg) {
		super.handleDiagramModelChanged(msg);
		if (msg.getNotifier() != null && msg.getNotifier() == getDPFNodeAttribute()) {
			switch (msg.getFeatureID(NodeAttribute.class)) {
				case CorePackage.NODE_ATTRIBUTE__NAME:
					for (Object edit : getChildren())
						if (edit instanceof AbstractGraphicalEditPart)
							((AbstractGraphicalEditPart) edit).refresh();
				}
		}
	}

	@Override
	protected void handleDiagramModelChanged(Notification msg) {
		super.handleDiagramModelChanged(msg);
		if (msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()) {
			switch (msg.getFeatureID(DNodeDAttribute.class)) {
			case DiagramPackage.DNODE_DATTRIBUTE__DCONSTRAINTS:
				if (msg.getOldValue() instanceof DArrowLabelConstraint
						|| msg.getNewValue() instanceof DArrowLabelConstraint)
					refresh();
				return;
			case DiagramPackage.DNODE_DATTRIBUTE__CONSTRAINTS_FROM: {
				refreshSourceConnections();
				return;
			}
			case DiagramPackage.DNODE_DATTRIBUTE__CONSTRAINTS_TO: {
				refreshTargetConnections();
				return;
			}
			case DiagramPackage.DNODE_DATTRIBUTE__BENDPOINTS:
				refresh();
			}
		}
	}

	PropertyChangeListener listener = new PropertyChangeListener() {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			if (Connection.PROPERTY_CONNECTION_ROUTER.equals(evt.getPropertyName())) {
				refreshBendpoints();
				refreshBendpointEditPolicy();
			}
		}
	};

	@Override
	protected void listen() {
		super.listen();
		if (!getDPFNodeAttribute().eAdapters().contains(modelListener)) {
			getDPFNodeAttribute().eAdapters().add(modelListener);
		}
		getFigure().addPropertyChangeListener(listener);
	}

	@Override
	protected void unlisten() {
		getFigure().removePropertyChangeListener(listener);
		if (getDPFNodeAttribute().eAdapters().contains(modelListener)){
			getDPFNodeAttribute().eAdapters().remove(modelListener);
		}		
		super.unlisten();
	}

	public DNodeDAttribute getDNodeDAttribute() {
		return (DNodeDAttribute) getModel();
	}

	public NodeAttribute getDPFNodeAttribute() {
		DNodeDAttribute dattribute = getDNodeDAttribute();
		if (dattribute != null){
			NodeAttribute attr = dattribute.getNodeAttribute();
			if(attr != null){
				return attr;
			}
		}
		return null;
	}

	/**
	 * Updates the bendpoints, based on the model.
	 */
	protected void refreshBendpoints() {
		if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter) {
			return;
		}
		
		
		List<DOffset> points = getDNodeDAttribute().getBendpoints();
		List<Bendpoint> figureConstraint = new ArrayList<Bendpoint>();
		if (getSource() != null && getTarget() != null) {
			Rectangle source = ((NodeEditPart) getSource()).getFigure().getBounds();
			Rectangle target = ((NodeEditPart) getTarget()).getFigure().getBounds();
			Point start = source.getCenter(), end = target.getCenter();
			if (getSource() == getTarget()) {
				start = source.getTop();
				end = source.getBottom();
				if (points.size() == 0) {
					int x = start.x, y = start.y;
					points.add(Draw2dUtil.getDOffset(start, end, new Point(x,
							y = y - source.height / 2)));
					points.add(Draw2dUtil.getDOffset(start, end, new Point(
							x = x - source.width, y)));
					points.add(Draw2dUtil.getDOffset(start, end, new Point(x,
							y = y + source.height * 2)));
					points.add(Draw2dUtil.getDOffset(start, end, new Point(x
							+ source.width, y)));
				}
			}
			for (DOffset p : points) {
				Point point = Draw2dUtil.getAbsoluteBendPoint(start, end, p);
				figureConstraint.add(new AbsoluteBendpoint(point));
			}
			getConnectionFigure().setRoutingConstraint(figureConstraint);
		}
	}

	private void refreshBendpointEditPolicy() {
		if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter) {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, null);
		} else {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new DNodeDAttributeBendpointEditPolicy()); 
		}
	}

	@Override
	protected void refreshVisuals() {
		if (getEditor() != null && connectionFigure instanceof ArrowConnection)
		//	 ((ArrowConnection)connectionFigure).setErrorImageFlag(getEditor().isMakerExisting(darrow.getArrow()));
		refreshBendpoints();
	}

	@Override
	protected List<EObject> getModelChildren() {
		List<EObject> result = new ArrayList<EObject>();
		result.add(getDNodeDAttribute().getNameOffset());
		for (DConstraint constraint : getDNodeDAttribute().getDConstraints()){
			if (constraint instanceof DArrowLabelConstraint){
				result.add(constraint);
			}
		}
		return result;
	}

	@Override
	protected List<DConstraint> getModelSourceConnections() {
		return getDNodeDAttribute().getConstraintsFrom();
	}

	@Override
	protected List<DConstraint> getModelTargetConnections() {
		return getDNodeDAttribute().getConstraintsTo();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor(connection);
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor(connection);
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return null;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return null;
	}

	/**
	 * Produces a ConnectionAnchor for either the source or target end of this
	 * constraint. The source (or target) needs to be an instance of
	 * <code>ArrowEditPart</code>,
	 * 
	 * @param supplier
	 *            the source or target of this edit part.
	 * @param isSource
	 *            true if supplier is source, false if not.
	 * @return A new ConnectionAnchor.
	 */
	protected ConnectionAnchor getConnectionAnchor(EditPart supplier) {
		// Now, the connection constraint anchor is constructed, setting from
		// which end of the line it
		// should anchor itself:
		if (supplier == null)
			return null;
		return new ConstraintAnchor(connectionFigure);
	}

}