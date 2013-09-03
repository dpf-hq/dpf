package no.hib.dpf.transform.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RoutingAnimator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.extension_points.IArrowPainting;
import no.hib.dpf.editor.figures.ArrowConnection;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.DArrowEditPart;
import no.hib.dpf.editor.parts.listeners.UIAdapter;
import no.hib.dpf.editor.policies.ArrowBendpointEditPolicy;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.preferences.TransformEditorPreferences;

public class TransformDArrowEditPart extends DArrowEditPart {
	private DArrow editObject = null;
	private Production production = null;
	protected PolylineConnection connectionFigure = null;
	
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

			refreshVisuals();
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
	private IArrowPainting arrowPaint;
	
	@Override
	protected IFigure createFigure() {
		if(getArrowPaint() != null){
			connectionFigure = (ArrowConnection) arrowPaint.createConnectionFigure();
		}
		else{
			createConnectionFigure();
		}
		connectionFigure.addRoutingListener(RoutingAnimator.getDefault());
		if(arrowPaint != null)
			connectionFigure.setTargetDecoration(arrowPaint.createTargetDecoration());
		else
			setArrowHead(connectionFigure);
		for(Object edit : getChildren()){
			if(edit instanceof AbstractGraphicalEditPart){
				connectionFigure.add(((AbstractGraphicalEditPart)edit).getFigure());
			}
		}
		return connectionFigure;		
	}
	
	private IArrowPainting getArrowPaint(){
		if(arrowPaint == null)
			try {
				String name = editObject.getDType().getConfigureString();
				if(name == null || name.isEmpty())
					return null;
				IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(name);
				if(configure != null)
					arrowPaint = (IArrowPainting) configure.createExecutableExtension(FigureConfigureManager.PAINT_ATT);
			} catch (CoreException e) {
				DPFUtils.logError(e);
			}
		return arrowPaint;
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
	
	@Override
	protected void refreshVisuals() {
		DArrow darrow = editObject;
		if(getEditor() != null)
			((ArrowConnection)connectionFigure).setErrorImageFlag(getEditor().isMakerExisting(darrow.getArrow()));
		refreshBendpoints();
		if(production.getLeftArrows().contains(editObject)){
			connectionFigure.setForegroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
		}
		if(production.getCommonArrows().contains(editObject)){
			connectionFigure.setForegroundColor(TransformEditorPreferences.getDefault().getPreserveForegroundColor());
		}
		if(production.getRightArrows().contains(editObject)){
			connectionFigure.setForegroundColor(TransformEditorPreferences.getDefault().getInsertForegroundColor());
		}
		
	}
	public PolylineConnection getConnectionFigure(){
		return connectionFigure;
	}
	
	
	@Override
	protected void createConnectionFigure() {
		connectionFigure = new ArrowConnection();
		if(production.getLeftArrows().contains(editObject)){
			connectionFigure.setForegroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
		}
		if(production.getCommonArrows().contains(editObject)){
			connectionFigure.setForegroundColor(TransformEditorPreferences.getDefault().getPreserveForegroundColor());
		}
		if(production.getRightArrows().contains(editObject)){
			connectionFigure.setForegroundColor(TransformEditorPreferences.getDefault().getInsertForegroundColor());
		}
	}
}
