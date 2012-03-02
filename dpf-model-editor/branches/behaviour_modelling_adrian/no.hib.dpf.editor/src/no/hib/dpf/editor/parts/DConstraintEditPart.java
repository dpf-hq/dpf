/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.parts;

import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.editor.commands.DConstraintDeleteCommand;
import no.hib.dpf.editor.figures.ConstraintAnchor;
import no.hib.dpf.editor.figures.NodeFigure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public abstract class DConstraintEditPart extends GraphicalConnectionEditPart {

	public DConstraintEditPart() { super(); }
	
	@Override
	protected IFigure createFigure() {
		IFigure retval = createFigureExec();
		return retval;
	}		
	
	protected abstract  IFigure createFigureExec();
	public abstract NodeFigure getRectangleFigureForFigure() ;

	@Override	
	protected void createEditPolicies() {
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			protected Command getDeleteCommand(GroupRequest request) {
				return new DConstraintDeleteCommand(getDConstraint());
			}
		});
	}

	protected DConstraint getDConstraint(){
		return (DConstraint) getModel();
	}
	
	protected NodeFigure getRectangleFigureForFigure(boolean fromSource) {
		NodeFigure basicRectangleFigure = null;
		
		if (getSource() != null) {
			DArrowEditPart source = (DArrowEditPart) getSource();

			if (source.getSource() != null) {
				if (source.getSource() instanceof DNodeEditPart) {
					DNodeEditPart shapeEditPart;
					if (fromSource) {
						shapeEditPart = (DNodeEditPart) source.getSource();
					} else {
						shapeEditPart = (DNodeEditPart) source.getTarget();

					}
					if (shapeEditPart.getFigure() instanceof NodeFigure) {
						basicRectangleFigure = (NodeFigure) shapeEditPart
								.getFigure();
					}
				}
			}
		}
		return basicRectangleFigure;
		
	}
	
	
	/**
	 * Returns the <code>ConnectionAnchor</code> for the <i>source</i> end of
	 * the connection. If the source is an instance of {@link DArrowEditPart},
	 * that interface will be used to determine the proper ConnectionAnchor.
	 * 
	 * @return ConnectionAnchor for the source end of the Connection
	 */
	@Override
	protected ConnectionAnchor getSourceConnectionAnchor() {
		return getConnectionAnchor(getSource());
	}

	/**
	 * Returns the <code>ConnectionAnchor</code> for the <i>target</i> end of
	 * the connection. If the target is an instance of {@link DArrowEditPart},
	 * that interface will be used to determine the proper ConnectionAnchor.
	 * 
	 * @return ConnectionAnchor for the target end of the Connection
	 */
	protected ConnectionAnchor getTargetConnectionAnchor() {
		return getConnectionAnchor(getTarget());
	}
	
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
		if ((supplier == null)  || (!(supplier instanceof DArrowEditPart))) return null; 
		return new ConstraintAnchor((PolylineConnection)((DArrowEditPart)supplier).getFigure());
	}
}