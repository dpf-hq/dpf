package no.hib.dpf.visualization.part;
 
  
import java.util.List;

import no.hib.dpf.core.Node; 
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
//import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramAttributeUtilities;
//import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
//import no.hib.dpf.editor.diagrams.classdiagram.dialogs.ClassDiagramMethodUtilities;
//import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
//import no.hib.dpf.editor.parts.TextCellEditorLocator;  
import no.hib.dpf.visual.presentation.ComposedNodeFactory;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.commands.ChildDNodeDeleteCommand; 
import no.hib.dpf.visualization.figures.CompartmentFigure;
import no.hib.dpf.visualization.policies.VCompartmentElementNameDirectEditPolicy;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.emf.common.notify.Notification;


public class VCompartmentElementEditPart extends GraphicalEditPartWithListener {
	
	@Override
	protected void listen(){
		super.listen();
		addUIAdapter((VCompartment)getModel(), modelListener);
	}
	
	@Override
	protected void unlisten(){
		removeUIAdapter((VCompartment)getModel(), modelListener);
		super.unlisten();
	}

	@Override
	protected IFigure createFigure() {
		return new CompartmentFigure(((VCompartment)getModel()).getName());
	}
	
	@Override
	public IFigure getContentPane(){
		return ((CompartmentFigure)getFigure()).getContentPane();
	}

	@Override
	protected void createEditPolicies() {
	}
	
	public VCompartment getCompartment() {
		return (VCompartment)getModel();
	}
	

	@Override
	protected List<VCompartmentElement> getModelChildren() {
		List<VCompartmentElement> list = getCompartment().getChildren();
		return list;
	}
	
	@Override
	protected void handleModelChanged(Notification msg) {
		refreshChildren();
	}
	
	@Override
	public DragTracker getDragTracker(Request request) {
	    if (REQ_SELECTION.equals(request.getType())) {
	        return getParent().getDragTracker(request);
	    } else return super.getDragTracker(request);
	}
	
	
//	@Override
//    protected void listen(){
//		super.listen();
//		addUIAdapter(getDNode(), modelListener);
//	}
//	
//	@Override
//	protected void unlisten(){
//		removeUIAdapter(getDNode(), modelListener);
//		super.unlisten();
//	}
//    
//	@Override
//	protected IFigure createFigure() {
//		return new CompartmentFigure(((VCompartment)getModel()).getName());
////		IConfigurationElement configure = FigureConfigureManager.getInstance()
////				.getConfigurationElement(getDNode().getConfigureString());
////		ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
////
////		Node node = getDNode().getNode();
//////		Integer potency = null;
//////		Integer mutability = null;
//////		if(node != null){
//////			potency = node.getPotency();
////////		mutability = node.getMutability();
//////		}
////		EditableLabel label = new EditableLabel(getNodeLabelName()); //, potency, mutability);
////		if(smallIcon != null){
////			label.setIcon((Image)smallIcon.createResource(null));	
////		}
////		
////		return label;
//	}
//
//	@Override
//	protected void createEditPolicies() {
//		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new VCompartmentElementNameDirectEditPolicy());
//		installEditPolicy(EditPolicy.CONNECTION_ROLE,
//				new ConnectionEditPolicy() {
//					@Override
//					protected Command getDeleteCommand(GroupRequest request) {
//						if(getDNode() != null && getDNode().getDGraph() != null){
//							return new ChildDNodeDeleteCommand((VCompartmentElement)getModel()); 
//						}
//						return null;
//					}
//				});
//	}
//	
//	public DNode getDNode(){
//		return ((VCompartmentElement)getModel()).getDNode();
//	}
//
//	private String getNodeLabelName() {
//		String result = "";
//		DNode dnode = getDNode();
//		Node node = dnode.getNode();
////		if(node != null){
////			Node templateNode = (Node) node.getTemplateElement();
////			if(templateNode != null && templateNode.getName().equals(ClassDiagramConstants.NODE_METHOD)){
////				result += ClassDiagramMethodUtilities.generateMethodString(node);
////			}else if(templateNode != null && templateNode.getName().equals(ClassDiagramConstants.NODE_ATTRIBUTE)){
////				result += ClassDiagramAttributeUtilities.generateAttributeString(node); 
////			}else{
////				result += node.getName();
////			}
////		}
//		
//		return result;
//	}	
//
//	@Override
//	protected void refreshVisuals() {
//		EditableLabel figure = (EditableLabel)getFigure();
//		figure.setLabelAlignment(PositionConstants.LEFT);
//		figure.setText(getNodeLabelName());
//		figure.setVisible(true);
//		figure.revalidate();
//	}
//	
//	@Override
//	public void performRequest(Request req) {
////		IF (REQ.GETTYPE().EQUALS(REQUESTCONSTANTS.REQ_DIRECT_EDIT)) {
////			VTEXTDIRECTEDITMANAGER MANAGER = NEW VTEXTDIRECTEDITMANAGER(THIS, TEXTCELLEDITOR.CLASS, NEW TEXTCELLEDITORLOCATOR((EDITABLELABEL)GETFIGURE()));
////			MANAGER.SHOW();
////			RETURN;
////		}
//		super.performRequest(req);
//	}
//	
//	@Override
//	public DNode getDiagramModel(){ 
//		return (DNode) ((VCompartmentElement)getModel()).getDNode(); 
//	}

	
}
