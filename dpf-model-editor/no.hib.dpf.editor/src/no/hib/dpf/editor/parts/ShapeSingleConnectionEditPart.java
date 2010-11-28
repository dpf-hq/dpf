package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.figures.DPFEpiConnectionFigure;
import no.hib.dpf.editor.model.SingleNodeConnection;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;

public class ShapeSingleConnectionEditPart extends ShapeConnectionEditPart {
	
//	private static final ConnectionAnchor DEFAULT_SOURCE_ANCHOR = new XYAnchor(new Point(10, 10));
//	private static final ConnectionAnchor DEFAULT_TARGET_ANCHOR = new XYAnchor(new Point(200, 100));

	@Override
	protected IFigure createFigure() {
		connectionFigure = new DPFEpiConnectionFigure();
		PolygonDecoration arrowHead = new PolygonDecoration();
		arrowHead.setScale(16, 6);
		connectionFigure.setTargetDecoration(arrowHead); // arrow at target endpoint
		return connectionFigure;
	}
	
	public ShapeSingleConnectionEditPart() {
		super();
	}
		
//	public void propertyChange(PropertyChangeEvent evt) {
//		super.propertyChange(evt);
//		String prop = evt.getPropertyName();
//		if (LocationAndSize.SIZE_PROP.equals(prop) || LocationAndSize.LOCATION_PROP.equals(prop)) {
//			((DPFEpiConnectionFigure)connectionFigure).setNewSize(getCastedModel().getSize());
//			((DPFEpiConnectionFigure)connectionFigure).setNewLocation(getCastedModel().getLocation());
//			refreshVisuals();
//		}
//	}

//	/**
//	 * Returns the <code>ConnectionAnchor</code> for the <i>source</i> end of
//	 * the connection. If the source is an instance of {@link NodeEditPart},
//	 * that interface will be used to determine the proper ConnectionAnchor. If
//	 * the source is not an instance of <code>NodeEditPart</code>, this method
//	 * should be overridden to return the correct ConnectionAnchor. Failure to
//	 * do this will cause a default anchor to be used so that the connection
//	 * figure will be made visible to the developer.
//	 * 
//	 * @return ConnectionAnchor for the source end of the Connection
//	 */
//	@Override
//	protected ConnectionAnchor getSourceConnectionAnchor() {
//		if (getSource() != null) {
//			if (getSource() instanceof ShapeEditPart) {
//				NodeEditPart editPart = (ShapeEditPart) getSource();
//				return editPart.getSourceConnectionAnchor(this);
//			}
//			IFigure f = ((GraphicalEditPart) getSource()).getFigure();
//			return new ChopboxAnchor(f);
//		}
//		return DEFAULT_SOURCE_ANCHOR;
//	}
//	
//	/**
//	 * Returns the <code>ConnectionAnchor</code> for the <i>target</i> end of
//	 * the connection. If the target is an instance of {@link NodeEditPart},
//	 * that interface will be used to determine the proper ConnectionAnchor. If
//	 * the target is not an instance of <code>NodeEditPart</code>, this method
//	 * should be overridden to return the correct ConnectionAnchor. Failure to
//	 * do this will cause a default anchor to be used so that the connection
//	 * figure will be made visible to the developer.
//	 * 
//	 * @return ConnectionAnchor for the target end of the Connection
//	 */
//	@Override
//	protected ConnectionAnchor getTargetConnectionAnchor() {
//		if (getTarget() != null) {
//			if (getTarget() instanceof ShapeEditPart) {
//				NodeEditPart editPart = (ShapeEditPart) getTarget();
//				return editPart.getTargetConnectionAnchor(this);
//			}
//			IFigure f = ((GraphicalEditPart) getTarget()).getFigure();
//			return new ChopboxAnchor(f);
//		}
//		return DEFAULT_TARGET_ANCHOR;
//	}	
	
	@Override
	protected SingleNodeConnection getCastedModel() {
		return (SingleNodeConnection)getModel();
	}

//	@Override
//	protected void refreshVisuals() {
//		// notify parent container of changed position & location
//		// if this line is removed, the XYLayoutManager used by the parent container 
//		// (the Figure of the DPFDiagramEditPart), will not know the bounds of this figure
//		// and will not draw it correctly.
//		Rectangle bounds = new Rectangle(getCastedModel().getLocation(),
//				getCastedModel().getSize());
//		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
//	}
//	
//	
////	/**
////	 * Overridden to return a default <code>DragTracker</code> for
////	 * GraphicalEditParts.
////	 * 
////	 * @see org.eclipse.gef.EditPart#getDragTracker(Request)
////	 */
////	public DragTracker getDragTracker(Request request) {
////		return new org.eclipse.gef.tools.DragEditPartsTracker(this);
////	}
//	
//	@Override
//	protected void createEditPolicies() {
//		// Selection handle edit policy.
//		// Makes the connection show a feedback, when selected by the user.
//		installEditPolicy(EditPolicy.NODE_ROLE,
//				new ResizableEditPolicy());
//		// Allows the removal of the connection model element
//		installEditPolicy(EditPolicy.CONNECTION_ROLE,
//				new ConnectionEditPolicy() {
//					protected Command getDeleteCommand(GroupRequest request) {
//						return new ConnectionDeleteCommand(getCastedModel());
//					}
//				});
//	}
	
	
}
