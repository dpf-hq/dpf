package no.hib.dpf.editor.parts;

import java.beans.PropertyChangeEvent;

import no.hib.dpf.editor.figures.BasicRectangleFigure;
import no.hib.dpf.editor.figures.LineConstraintAnchor_2;
import no.hib.dpf.editor.model.ConstraintElement;
import no.hib.dpf.editor.model.commands.ConstraintDeleteCommand;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

public abstract class ConstraintEditPart extends ModelElementConnectionEditPart {

	public ConstraintEditPart() {
		super();
	}

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
			if (getSource() instanceof ShapeConnectionEditPart) {
				ShapeConnectionEditPart source = (ShapeConnectionEditPart)getSource();
			
				if (source.getSource() != null) {
					if (source.getSource() instanceof ShapeEditPart) {
						ShapeEditPart shapeEditPart;
						if (fromSource) {
							shapeEditPart = (ShapeEditPart)source.getSource();
						} else {
							shapeEditPart = (ShapeEditPart)source.getTarget();
							
						}
						if (shapeEditPart.getFigure() instanceof BasicRectangleFigure) {
							basicRectangleFigure = (BasicRectangleFigure) shapeEditPart.getFigure();
						}
					}
				}
			}
		}
		return basicRectangleFigure;
		
	}
	
	protected ConstraintElement getCastedModel() {
		return (ConstraintElement) getModel();
	}
	
//	/**
//	 * Updates the source ConnectionAnchor. Subclasses should override
//	 * {@link #getSourceConnectionAnchor()} if necessary, and not this method.
//	 */
//	@Override
//	protected void refreshSourceAnchor() {
//		try {
//			getConnectionFigure().setSourceAnchor(getSourceConnectionAnchor());
//		} catch (Exception e) {}
//	}	
	
	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		String property = event.getPropertyName();
		if (ConstraintElement.LINESTYLE_PROP.equals(property)) {
			((PolylineConnection) getFigure()).setLineStyle(getCastedModel().getLineStyle());
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

	/**
	 * Produces a ConnectionAnchor for either the source or target end of this
	 * connection. The source (or target) needs to be an instance of 
	 * <code>ShapeConnectionEditPart</code>,
	 * @param supplier the source or target of this edit part.
	 * @param isSource true if supplier is source, false if not.
	 * @return A new LineConstraintAnchor.
	 */
	private ConnectionAnchor getConnectionAnchor(EditPart supplier, boolean isSource) {
		LineConstraintAnchor_2 retval = new LineConstraintAnchor_2(new Point(100, 100), true);
		if ((supplier == null)  || (!(supplier instanceof ShapeConnectionEditPart))) {
			return retval;
		}
		ShapeConnectionEditPart targetSupplier = getConnectionEditPart(supplier, isSource);
		
		retval.setConnectionFigure((PolylineConnection)targetSupplier.getFigure());
		
		if ((targetSupplier.getTarget() != null) && (targetSupplier.getSource() instanceof ShapeEditPart)) {
			ShapeEditPart shapeEditPart = (ShapeEditPart)targetSupplier.getTarget();
			if (shapeEditPart.getFigure() instanceof BasicRectangleFigure) {
				retval.setSourceNodeFigure((BasicRectangleFigure) shapeEditPart.getFigure());
			}
		}	
		return retval;
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

}