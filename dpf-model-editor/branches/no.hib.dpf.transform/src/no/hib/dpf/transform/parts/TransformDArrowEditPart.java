package no.hib.dpf.transform.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.figures.ArrowConnection;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.listeners.UIAdapter;
import no.hib.dpf.editor.policies.ArrowBendpointEditPolicy;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.preferences.TransformEditorPreferences;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class TransformDArrowEditPart extends DArrowEditPart {
	public enum CHANGE{
		DEF, ADD, DEL, KEP;
	} 
	private CHANGE current = CHANGE.DEF;
	public void setChange(CHANGE change){
		current = change;		
		IFigure figure = getFigure();
		figure.setForegroundColor(TransformEditorPreferences.getDefault().getInsertForegroundColor());
		figure.revalidate();
		figure.repaint();
	}
	public void refreshVisual(){
		super.refreshVisuals();
		IFigure figure = getFigure();
		figure.setForegroundColor(TransformEditorPreferences.getDefault().getInsertForegroundColor());
		figure.revalidate();
		figure.repaint();
	}
	private DArrow editObject = null;
	private Production production = null;	
	PropertyChangeListener listener = new PropertyChangeListener() {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			if (Connection.PROPERTY_CONNECTION_ROUTER.equals(evt.getPropertyName())){
				refreshBendpoints();
				refreshBendpointEditPolicy();
			}
		}

	};
    /**
     * Listener for the node notifications
     */
    protected UIAdapter diagrammodelListener = new UIAdapter()
    {
        /**
         * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
         */
        @Override
        protected void safeNotifyChanged(Notification msg)
        {
            handleDiagramModelChanged(msg);
        }

    };
	
	@Override
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
	@Override
	protected void handleDiagramModelChanged(Notification msg){
		super.handleDiagramModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()){ 
			
//			ArrowConnection arrowConnection = (ArrowConnection) figure;
//			
//			arrowConnection.setBackgroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
//			arrowConnection.setForegroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
//			arrowConnection.repaint();
//			
//			System.out.println("HER " + figure.getForegroundColor());
//			figure.setBackgroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
//			figure.setForegroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
//			System.out.println("HER " + figure.getBackgroundColor());
//			System.out.println("HER " + figure.getForegroundColor());
//			figure.repaint();
//			System.out.println("Parent " + figure.getParent());
			
			
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
	
	public TransformDArrowEditPart(Object modelElement){
		editObject = (DArrow) modelElement;
		production = (Production) editObject.eContainer().eContainer().eContainer();
	}
	
	private void refreshBendpointEditPolicy(){
		if (getConnectionFigure().getConnectionRouter() instanceof ManhattanConnectionRouter) {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, null);
		} else {
			installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new ArrowBendpointEditPolicy());
		}
	}
	

	@Override
	public DArrow getDArrow(){
		return editObject;
	}

	@Override
	public Arrow getDPFArrow(){
		DArrow darrow = getDArrow();
		if(darrow != null)
			return darrow.getArrow();
		return null;
	}
}
