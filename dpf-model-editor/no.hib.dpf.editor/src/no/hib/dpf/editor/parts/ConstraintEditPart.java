package no.hib.dpf.editor.parts;

import java.beans.PropertyChangeEvent;

import no.hib.dpf.editor.displaymodel.DConstraint;
import no.hib.dpf.editor.displaymodel.commands.ConstraintDeleteCommand;
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

public abstract class ConstraintEditPart extends ModelElementConnectionEditPart {

	private boolean constraintFromTargetEnd;
		
	public ConstraintEditPart(boolean constraintFromTargetEnd) {
		super();
		this.constraintFromTargetEnd = constraintFromTargetEnd;
	}
	
	@Override
	protected IFigure createFigure() {
		IFigure retval = createFigureExec();
		return retval;
	}		
	
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

	public abstract NodeFigure getRectangleFigureForFigure();
	
	protected NodeFigure getRectangleFigureForFigure(boolean fromSource) {
		NodeFigure basicRectangleFigure = null;
		
		if (getSource() != null) {
			ArrowEditPart source = (ArrowEditPart) getSource();

			if (source.getSource() != null) {
				if (source.getSource() instanceof NodeEditPart) {
					NodeEditPart shapeEditPart;
					if (fromSource) {
						shapeEditPart = (NodeEditPart) source.getSource();
					} else {
						shapeEditPart = (NodeEditPart) source.getTarget();

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
	
	protected DConstraint getCastedModel() {
		return (DConstraint) getModel();
	}
	
	
	/**
	 * Returns the <code>ConnectionAnchor</code> for the <i>source</i> end of
	 * the connection. If the source is an instance of {@link ArrowEditPart},
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
	 * the connection. If the target is an instance of {@link ArrowEditPart},
	 * that interface will be used to determine the proper ConnectionAnchor.
	 * 
	 * @return ConnectionAnchor for the target end of the Connection
	 */
	protected ConnectionAnchor getTargetConnectionAnchor() {
		return getConnectionAnchor(getTarget(), false);
	}
	
	/**
	 * Produces a ConnectionAnchor for either the source or target end of this
	 * constraint. The source (or target) needs to be an instance of 
	 * <code>ArrowEditPart</code>,
	 * @param supplier the source or target of this edit part.
	 * @param isSource true if supplier is source, false if not.
	 * @return A new ConnectionAnchor.
	 */
	protected ConnectionAnchor getConnectionAnchor(EditPart supplier, boolean isSource) {
		// Now, the connection constraint anchor is constructed, setting from which end of the line it
		// should anchor itself:
		ConstraintAnchor retval = new ConstraintAnchor(constraintFromTargetEnd);
		if ((supplier == null)  || (!(supplier instanceof ArrowEditPart))) {
			return retval;
		}
		updateAnchor(retval, supplier, isSource);
		
		return retval;
	}

	protected void updateAnchor(ConstraintAnchor anchor, EditPart supplier, boolean isSource) {
		ArrowEditPart targetSupplier = getConnectionEditPart(supplier, isSource);
		anchor.setConnectionFigure((PolylineConnection)targetSupplier.getFigure());
	}

	private ArrowEditPart getConnectionEditPart(EditPart supplier, boolean isSource) {
		ArrowEditPart retVal = (ArrowEditPart)supplier;
		if (isSource) {
			retVal = (ArrowEditPart)getSource();		
		} else {
			retVal = (ArrowEditPart)getTarget();				
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
		ArrowEditPart shapeEditPart = (ArrowEditPart)editPart;
		shapeEditPart.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}	

	
	// -----------------------------
	
		
}