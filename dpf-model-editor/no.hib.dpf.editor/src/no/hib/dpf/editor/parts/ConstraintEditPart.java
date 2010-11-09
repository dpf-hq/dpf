package no.hib.dpf.editor.parts;

import java.beans.PropertyChangeEvent;

import no.hib.dpf.editor.figures.BasicRectangleFigure;
import no.hib.dpf.editor.figures.ConnectionConstraintAnchor;
import no.hib.dpf.editor.model.ConstraintElement;
import no.hib.dpf.editor.model.commands.ConstraintDeleteCommand;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public abstract class ConstraintEditPart extends ModelElementConnectionEditPart {

	///** Property ID to use when a connection has been redrawn. */
	//public static final String CONNECTION_REDRAWN = "ConstraintEditPart.ConnectionRedrawn";
	
	private boolean constraintFromTargetEnd;
	
	private ConnectionConstraintAnchor sourceAnchor;
	private ConnectionConstraintAnchor targetAnchor;
	
	public ConstraintEditPart(boolean constraintFromTargetEnd) {
		super();
		this.constraintFromTargetEnd = constraintFromTargetEnd;
	}
	
	@Override
	protected IFigure createFigure() {
		IFigure retval = createFigureExec();
//		addFigureToConstrainedPartsFigures(retval);
		return retval;
	}
	
//	/**
//	 * Upon activation, attach to the model element as a property change listener.
//	 */
//	@Override
//	public void activate() {
//		super.activate();
//		deactivateFigure();
//		activateFigure();		
//	}
	

//	private void addFigureToConstrainedPartsFigures(IFigure retval) {
//		if (getSource() != null) {
//			ShapeConnectionEditPart source = (ShapeConnectionEditPart) getSource();
//			source.getFigure().add(retval);
//		}
//		if (getTarget() != null) {
//			ShapeConnectionEditPart target = (ShapeConnectionEditPart) getTarget();
//			target.getFigure().add(retval);
//		}
//	}
	
	
	protected abstract IFigure createFigureExec();

	@Override	
	protected void createEditPolicies() {
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			protected Command getDeleteCommand(GroupRequest request) {
				return new ConstraintDeleteCommand(getCastedModel());
			}
		});
	}

	protected BasicRectangleFigure getRectangleFigureForFigure(boolean fromSource) {
		BasicRectangleFigure basicRectangleFigure = null;
		
		if (getSource() != null) {
			ShapeConnectionEditPart source = (ShapeConnectionEditPart) getSource();

			if (source.getSource() != null) {
				if (source.getSource() instanceof ShapeEditPart) {
					ShapeEditPart shapeEditPart;
					if (fromSource) {
						shapeEditPart = (ShapeEditPart) source.getSource();
					} else {
						shapeEditPart = (ShapeEditPart) source.getTarget();

					}
					if (shapeEditPart.getFigure() instanceof BasicRectangleFigure) {
						basicRectangleFigure = (BasicRectangleFigure) shapeEditPart
								.getFigure();
					}
				}
			}
		}
		return basicRectangleFigure;
		
	}
	
	protected ConstraintElement getCastedModel() {
		return (ConstraintElement) getModel();
	}
	
	
	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		String property = event.getPropertyName();
		if (ConstraintElement.LINESTYLE_PROP.equals(property)) {
			((PolylineConnection) getFigure()).setLineStyle(getCastedModel().getLineStyle());
		} else if (ConstraintElement.NEW_LOCATION_PROP.equals(property)) {
			updateAnchors();
			System.out.println("gabba-constraint");
			refresh();
			getFigure().revalidate();
//		} else if (ConstraintElement.RESET_PROPERTY.equals(property)) {
//			deactivateFigure();
//			activateFigure();
		}			
	}
	
	/**
	 * Returns the <code>ConnectionAnchor</code> for the <i>source</i> end of
	 * the connection. If the source is an instance of {@link ShapeConnectionEditPart},
	 * that interface will be used to determine the proper ConnectionAnchor.
	 * 
	 * @return ConnectionAnchor for the source end of the Connection
	 */
	@Override
	protected ConnectionAnchor getSourceConnectionAnchor() {
		return getConnectionAnchor(getSource(), true);
	}

	/**
	 * Returns the <code>ConnectionAnchor</code> for the <i>target</i> end of
	 * the connection. If the target is an instance of {@link ShapeConnectionEditPart},
	 * that interface will be used to determine the proper ConnectionAnchor.
	 * 
	 * @return ConnectionAnchor for the target end of the Connection
	 */
	protected ConnectionAnchor getTargetConnectionAnchor() {
		return getConnectionAnchor(getTarget(), false);
	}
	
	private void updateAnchors() {
		updateAnchor(sourceAnchor, getSource(), true);
		updateAnchor(targetAnchor, getTarget(), false);
	}

	/**
	 * Produces a ConnectionAnchor for either the source or target end of this
	 * connection. The source (or target) needs to be an instance of 
	 * <code>ShapeConnectionEditPart</code>,
	 * @param supplier the source or target of this edit part.
	 * @param isSource true if supplier is source, false if not.
	 * @return A new LineConstraintAnchor.
	 */
	private ConnectionAnchor getConnectionAnchor(EditPart supplier, boolean isSource) {
		// Now, the connection constraint anchor is constructed, setting from which end of the line it
		// should anchor itself:
		ConnectionConstraintAnchor retval = new ConnectionConstraintAnchor(new Point(100, 100), constraintFromTargetEnd);
		if (isSource) {
			sourceAnchor = retval;
		} else {
			targetAnchor = retval;
		}
		if ((supplier == null)  || (!(supplier instanceof ShapeConnectionEditPart))) {
			return retval;
		}
		updateAnchor(retval, supplier, isSource);
		
		return retval;
	}

	private void updateAnchor(ConnectionConstraintAnchor anchor, EditPart supplier, boolean isSource) {
		ShapeConnectionEditPart targetSupplier = getConnectionEditPart(supplier, isSource);
		anchor.setConnectionFigure((PolylineConnection)targetSupplier.getFigure());
	}

	private ShapeConnectionEditPart getConnectionEditPart(EditPart supplier, boolean isSource) {
		ShapeConnectionEditPart retVal = (ShapeConnectionEditPart)supplier;
		if (isSource) {
			retVal = (ShapeConnectionEditPart)getSource();		
		} else {
			retVal = (ShapeConnectionEditPart)getTarget();				
		}
		return retVal;
	}	
	
	/**
	 * Sets the source EditPart of this connection.
	 * 
	 * @param editPart
	 *            EditPart which is the source.
	 */
	@Override
	public void setSource(EditPart editPart) {
		listenToConnectionPart(editPart);
		super.setSource(editPart);
		
	}

	@Override
	public void setTarget(EditPart editPart) {
		listenToConnectionPart(editPart);
		super.setTarget(editPart);
	}	

	private void listenToConnectionPart(EditPart editPart) {
		if (editPart == null) {
			return;
		}
		ShapeConnectionEditPart shapeEditPart = (ShapeConnectionEditPart)editPart;
		shapeEditPart.addPropertyChangeListener(this);
	}	

	
	// -----------------------------
	
	/**
	 * Activates the Figure representing this, by setting up the start and end
	 * connections, and adding the figure to the Connection Layer.
	 * 
	 * @see #deactivate()
	 */
	@Override
	protected void activateFigure() {
		getLayer(CONNECTION_LAYER).add(getFigure());
	}

	/**
	 * @see org.eclipse.gef.EditPart#addNotify()
	 */
	@Override
	public void addNotify() {
//		activateFigure();
		super.addNotify();
	}	
	
	/**
	 * Deactivates the Figure representing this, by removing it from the
	 * connection layer, and resetting the source and target connections to
	 * <code>null</code>.
	 */
	protected void deactivateFigure() {
		getLayer(CONNECTION_LAYER).remove(getFigure());
		getConnectionFigure().setSourceAnchor(null);
		getConnectionFigure().setTargetAnchor(null);
	}

	/**
	 * Extended here to remove the ConnectionEditPart's connection figure from
	 * the connection layer.
	 * 
	 * @see org.eclipse.gef.EditPart#removeNotify()
	 */
	public void removeNotify() {
		deactivateFigure();
		super.removeNotify();
	}

	
}