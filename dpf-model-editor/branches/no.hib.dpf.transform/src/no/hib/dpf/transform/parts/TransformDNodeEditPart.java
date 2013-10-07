package no.hib.dpf.transform.parts;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.figures.NodeFigure;
import no.hib.dpf.editor.parts.DNodeEditPart;
import no.hib.dpf.editor.parts.listeners.UIAdapter;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.preferences.TransformEditorPreferences;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class TransformDNodeEditPart extends DNodeEditPart{
	private DNode editObject = null;
	private Production production = null;
	
	 protected UIAdapter modelListener = new UIAdapter()
	    {
	        /**
	         * @see org.topcased.modeler.listeners.UIAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
	         */
	        @Override
	        protected void safeNotifyChanged(Notification msg)
	        {
	            handleModelChanged(msg);
	        }

	    };
	public TransformDNodeEditPart(Object modelElement){
		super();
		editObject = (DNode) modelElement;
		production = (Production) editObject.eContainer().eContainer().eContainer();
	}
	
	private void refreshLabel() {
		NodeFigure tableFigure = (NodeFigure) getFigure();
		EditableLabel label = tableFigure.getNameLabel();
		label.setText(getNodeLabelName());
		label.setVisible(true);
		label.revalidate();
	}
	@Override
	protected void refreshVisuals() {
		NodeFigure figure = (NodeFigure)getFigure();
		DPFEditor editor = getEditor();
		if(editor != null){
			boolean flag = editor.isMakerExisting(getDNode().getNode());
			if(figure.getErrorImageFlag() != flag)
				figure.setErrorImageFlag(flag);
		}
		getFigure().setBounds(new Rectangle(getDiagramModel().getLocation(), getDiagramModel().getSize()));
		refreshLabel();
		if(production.getLeftNodes().contains(editObject)){
			figure.setBackgroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
		}
		if(production.getCommonNodes().contains(editObject)){
			figure.setBackgroundColor(TransformEditorPreferences.getDefault().getPreserveForegroundColor());
		}
		if(production.getRightNodes().contains(editObject)){
			figure.setBackgroundColor(TransformEditorPreferences.getDefault().getInsertForegroundColor());
		}
		//			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent
		// container (the Figure of the DPFDiagramEditPart), will not know the bounds of
		// this figure and will not draw it correctly.
	}
	@Override
	protected IFigure createFigure() {
		IFigure figure = new NodeFigure(new EditableLabel(getNodeLabelName()));
		return figure;
	}
	
	private String getNodeLabelName() {
		String result = "";
		if(getDPFNode().getName() != null)
			result += getDPFNode().getName();
		Node type = getType();
		if (TransformEditorPreferences.getDefault().getDisplayTypeNames() && type != null && type.getName() != null) 
			result += " : " + type.getName();
		return result;
	}
	
	@Override
	protected void handleModelChanged(Notification msg) {
		if(msg.getNotifier() != null && msg.getNotifier() == getDPFNode()){ 
			switch(msg.getFeatureID(Node.class)){
			case CorePackage.NODE__NAME:
				refreshVisuals();
				break;
			case CorePackage.NODE__INCOMINGS:
				verifyOnArrowChange((Node)msg.getNotifier(), msg.getOldValue(), msg.getNewValue());
				break;
			case CorePackage.NODE__OUTGOINGS:
				verifyOnArrowChange((Node)msg.getNotifier(), msg.getOldValue(), msg.getNewValue());
				break;
			}
		}
	}
	
	protected void listen(){
		super.listen();
		addUIAdapter(getDNode(), modelListener);
	}
	private void verifyOnArrowChange(Node node, Object oldArrow, Object newArrow){
		Arrow checkedArrow = null;
		DPFEditor editor = getEditor();
		if(editor == null)
			return;
		if (newArrow == null && oldArrow instanceof Arrow){
			checkedArrow = (Arrow) oldArrow;
			if(checkedArrow.getSource() == null && checkedArrow.getTarget() == null)
				editor.deleteMaker(checkedArrow);
		}
		else if (newArrow instanceof Arrow)
			checkedArrow = (Arrow) newArrow;

		EList<Constraint> constraints = new BasicEList<Constraint>();
		constraints.addAll(checkedArrow.getTypeArrow().getConstraints());

		Graph graph = node.getGraph();
		if(editor == null || graph == null) return;

		for (Constraint constraint : constraints) {
			EList<Node> nodes = new BasicEList<Node>();
			EList<Arrow> arrows = new BasicEList<Arrow>();

			DPFCoreUtil.findRelatedElements(node, constraint, graph, nodes, arrows);

			boolean valid = constraint.validate(nodes, arrows);
			if(!valid){
				for(Node iter : nodes)
					editor.addMarker(iter, constraint);
				for(Arrow iter : arrows)
					editor.addMarker(iter, constraint);
			}else{
				for(Node iter : nodes)
					editor.deleteMaker(iter, constraint);
				for(Arrow iter : arrows)
					editor.deleteMaker(iter, constraint);
			}

		}
	}
}
