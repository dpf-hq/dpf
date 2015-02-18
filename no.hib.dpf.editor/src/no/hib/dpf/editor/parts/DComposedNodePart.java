package no.hib.dpf.editor.parts;

import java.util.ArrayList;
import java.util.List;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.editor.figures.LineSegment;
import no.hib.dpf.editor.policies.NodeComponentEditPolicy;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;


public class DComposedNodePart extends GraphicalEditPartWithListener  implements NodeEditPart{

	
	class ComposedNodeAdapter extends UIAdapter {
		DConstraintNode constraint;
		DElement ele;
		boolean isNode;
		public ComposedNodeAdapter(DConstraintNode node, DElement element, boolean is) {
			super();
			ele = element;
			constraint = node;
			isNode = is;
		}
		@Override
		protected void safeNotifyChanged(Notification msg)
		{
			if(msg.getNotifier() != null && msg.getNotifier() == ele){ 
				if(isNode){
					switch(msg.getFeatureID(DNode.class)){
					case DiagramPackage.DNODE__LOCATION:
					case DiagramPackage.DNODE__SIZE:
						refreshVisuals();
						break;
					}
				}else{
					switch(msg.getFeatureID(DArrow.class)){
					case DiagramPackage.DARROW__BENDPOINTS:
						refreshVisuals();
						break;
					}
				}
			}
		}

	};
	List<DArrowEditPart> arrows = null;
	Label label = null;
	List<DNodeEditPart> nodes = null;
	public void add(EditPart target) {
		if(target instanceof DArrowEditPart){
			DArrowEditPart dArrowEditPart = (DArrowEditPart) target;
			DArrow dArrow = dArrowEditPart.getDArrow();
			addListner(dArrow, false);
			add(dArrowEditPart, false);
			addListner(dArrow.getDSource(), true);
			add(dArrowEditPart.getSource(), true);
			addListner(dArrow.getDTarget(), true);
			add(dArrowEditPart.getTarget(), true);
		}else if(target instanceof DNodeEditPart){
			addListner(((DNodeEditPart)target).getDiagramModel(), true);
			add(target, true);
		}
	}

	private void add(EditPart editPart, boolean b) {
		if(b && !getNodes().contains(editPart))
			getNodes().add((DNodeEditPart) editPart);
		if(!b && !getArrows().contains(editPart))
			getArrows().add((DArrowEditPart) editPart);
	}
	private void addListner(DElement element, boolean isNode) {
		EList<Adapter> list = element.eAdapters();
		DConstraintNode node = getDConstraintNode();
		boolean exist = false;
		for(Adapter adapter : list){
			if(adapter instanceof ComposedNodeAdapter && ((ComposedNodeAdapter)adapter).constraint == node)
				exist = true;
			break;
		}
		if(exist == false)
			list.add(new ComposedNodeAdapter(getDConstraintNode(), element, isNode));
		Constraint constraint = getDConstraint().getConstraint();
		String parameter = constraint.getPredicate().getParameters();
		if(parameter != null && !parameter.isEmpty()){
			constraint.eAdapters().add(paraListner);
		}
	}
	UIAdapter paraListner = new UIAdapter() {
		
		@Override
		protected void safeNotifyChanged(Notification msg) {
			if(msg.getNotifier() == getDConstraint().getConstraint()){
				switch(msg.getFeatureID(Constraint.class)){
				case CorePackage.CONSTRAINT__PARAMETERS:
					refreshVisuals();
				}
			}
		}
	};
	@Override
	protected void createEditPolicies() {
		// allow removal of the associated model element
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
	}

	protected String getFullName() {
		DConstraint dConstraint = getDConstraint();
		String result = dConstraint.getDPredicate().getSimpleName();
		String parameter = dConstraint.getConstraint().getParameters();
		if(result.endsWith("enum")){
			result = "[" + result;
			if(parameter != null && !parameter.isEmpty()){
				String[] pair = parameter.split(":");
				if(pair.length != 2) return "";
				result += pair[1];
			}
			return result + "]";
		}
		result = "[" + result + "]";
		if(parameter != null && !parameter.isEmpty()){
			result += "(" + parameter + ")";
		}
		return result;
	}
	
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
		label.setLocation(getDConstraintNode().getLocation());
		return label;
	}
	public List<DArrowEditPart> getArrows() {
		if(arrows == null) 
			arrows = new ArrayList<DArrowEditPart>();
		return arrows;
	}

	public Rectangle getBound(){
		Rectangle bound = null;
		for(DNodeEditPart iter : getNodes()){
			Rectangle cur = iter.getFigure().getBounds();
			if(bound == null)
				bound = cur.getCopy();
			else
				bound = bound.getUnion(cur);
		}
		for(DArrowEditPart iter : getArrows()){
			Rectangle cur = iter.getFigure().getBounds();
			if(bound == null)
				bound = cur.getCopy();
			else
				bound = bound.getUnion(cur);
		}
		return bound;
	}
	public Point getCrossPoint(Point newLocation){
		Rectangle bound = getBound();
		if(bound != null && bound.contains(newLocation)){
			newLocation = new LineSegment(newLocation, null).getCrossPoint(bound);
		}
		return newLocation;
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

	public List<DNodeEditPart> getNodes(){
		if(nodes == null) 
			nodes = new ArrayList<DNodeEditPart>();
		return nodes;
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return new ChopboxAnchor(label);
	}
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return null;
	}


	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return null;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return null;
	}

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
	@Override
	protected void refreshVisuals() {
		label.setText(getFullName());
		label.setLocation(getDConstraintNode().getLocation());
	}
	public void remove(EditPart target){
		if(target instanceof DArrowEditPart){
			DArrowEditPart dArrowEditPart = (DArrowEditPart) target;
			DArrow dArrow = dArrowEditPart.getDArrow();
			removeListner(dArrow);
			remove(dArrowEditPart, false);
			removeListner(dArrow.getDSource());
			remove(dArrowEditPart.getSource(), true);
			removeListner(dArrow.getDTarget());
			remove(dArrowEditPart.getTarget(), true);
		}else if(target instanceof DNodeEditPart){
			removeListner(((DNodeEditPart)target).getDiagramModel());
			remove(target, true);
		}
	}
	private void remove(EditPart editPart, boolean b) {
		if(b){
			getNodes().remove(editPart);
		}else
			getArrows().remove(editPart);
	}
	private void removeListner(DElement element){
		Constraint constraint = getDConstraint().getConstraint();
		String parameter = constraint.getPredicate().getParameters();
		if(parameter != null && !parameter.isEmpty()){
			constraint.eAdapters().remove(paraListner);
		}
		EList<Adapter> list = element.eAdapters();
		DConstraintNode node = getDConstraintNode();
		for(Adapter adapter : list){
			if(adapter instanceof ComposedNodeAdapter && ((ComposedNodeAdapter)adapter).constraint == node){
				list.remove(adapter);
				return;
			}
		}
	}
	protected void listen(){
		super.listen();
		addUIAdapter(getDConstraint().getConstraint(), paraListner);
	}
	
	/*
	 * Unlisten to diagram model
	 */
	protected void unlisten(){
		removeUIAdapter(getDConstraint().getConstraint(), paraListner);
		super.unlisten();
	}
}
