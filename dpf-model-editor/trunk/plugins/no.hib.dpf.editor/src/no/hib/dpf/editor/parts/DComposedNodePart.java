package no.hib.dpf.editor.parts;

import java.util.List;

import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.diagram.DComposedConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

public class DComposedNodePart extends GraphicalEditPartWithListener  implements NodeEditPart{

	Label label = null;
	@Override
	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
	}

	protected String getFullName() {
		DConstraint dConstraint = getDConstraint();
		String result = dConstraint.getDPredicate().getSimpleName();
		result = "[" + result + "]";
		String parameter = dConstraint.getConstraint().getParameters();
		if(parameter != null && !parameter.isEmpty()){
			result += "(" + parameter + ")";
		}
		return result;
	}
	/*
	 * Make the label size equals to the text size
	 */
	public IFigure createFigure() {
		label = new Label(){
			protected String getTruncationString() {
				return getText();
			}
			public void setText(String s) {
				boolean changed = !getText().equals(s);
				super.setText(s);
				if(changed) setSize(getMinimumSize());
			}
		};
		label.setOpaque(true);
		return label;
	}

	public DConstraint getDConstraint() {
		return getDConstraintNode().getDConstraint();
	}

	protected DConstraintNode getDConstraintNode(){
		return (DConstraintNode) getModel();
	}

	public Label getLabel() { return (Label)getFigure(); }

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getModelSourceConnections() {
		EList sources = new BasicEList();
		sources.addAll(getDConstraintNode().getConstraintsFrom());
		return sources;
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor( ConnectionEditPart connection) {
		return new ChopboxAnchor(label);
	}
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) { return null; }

	@Override
	public ConnectionAnchor getTargetConnectionAnchor( ConnectionEditPart connection) { return null; }

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) { return null; }

	/*
	 * react to parameter changing
	 */
	protected void handleModelChanged(Notification msg){
		super.handleModelChanged(msg);
		if(msg.getNotifier() == getDConstraint().getConstraint()){
			switch(msg.getFeatureID(Constraint.class)){
			case CorePackage.CONSTRAINT__PARAMETERS:
				refreshVisuals();
			}
		}
	}
	/*
	 * react to connection creating and deleting
	 */
	@Override
	protected void handleDiagramModelChanged(Notification msg) {
		super.handleDiagramModelChanged(msg);
		if(msg.getNotifier() != null && msg.getNotifier() == getDiagramModel()){ 
			switch(msg.getFeatureID(DNode.class)){
			case DiagramPackage.DNODE__CONSTRAINTS_FROM:
				refreshSourceConnections();
				break;
			}

		}
	}
	protected void refreshVisuals() {
		label.setText(getFullName());
		if(getDConstraintNode().getLocation() != null){
			label.setLocation(getDConstraintNode().getLocation());
		}else{
			DComposedConstraint composed = (DComposedConstraint) getDConstraint();
			if(getSourceConnections().size() == composed.getChildren().size()){
				/*
				 * Set the initial position of the node when every connection is connected
				 */
				Rectangle bounds = null;
				for(Object object : getSourceConnections()){
					if(object instanceof DConstraintEditPart){
						EditPart target = ((DConstraintEditPart)object).getTarget();
						if(target instanceof AbstractGraphicalEditPart){
							Rectangle cur = ((AbstractGraphicalEditPart)target).getFigure().getBounds();
							if(bounds == null) bounds = cur;
							else bounds = bounds.getUnion(cur);
						}
					}
				}
				Point initial = bounds.getTop();
				initial.y -= label.getSize().height;
				initial.x -= (label.getSize().width/2); 
				getDConstraintNode().setLocation(initial);
			}
		}
	}
}
