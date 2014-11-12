package no.hib.dpf.visualization.part;
 
  
import no.hib.dpf.core.Node; 
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramAttributeUtilities;
import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
import no.hib.dpf.editor.diagrams.classdiagram.dialogs.ClassDiagramMethodUtilities;
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.figures.EditableLabel;
import no.hib.dpf.editor.parts.GraphicalEditPartWithListener;
import no.hib.dpf.editor.parts.TextCellEditorLocator;  
import no.hib.dpf.visual.presentation.ComposedNodeFactory;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.commands.ChildDNodeDeleteCommand; 
import no.hib.dpf.visualization.policies.VCompartmentElementNameDirectEditPolicy;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
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

public class VCompartmentElementEditPart extends GraphicalEditPartWithListener {
	
	@Override
    protected void listen(){
		super.listen();
		addUIAdapter(getDNode(), modelListener);
	}
	
	@Override
	protected void unlisten(){
		removeUIAdapter(getDNode(), modelListener);
		super.unlisten();
	}
    
	@Override
	protected IFigure createFigure() {
		IConfigurationElement configure = FigureConfigureManager.getInstance()
				.getConfigurationElement(getDNode().getConfigureString());
		ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);

		Node node = getDNode().getNode();
		Integer potency = null;
		Integer mutability = null;
		if(node != null){
			potency = node.getPotency();
//			mutability = node.getMutability();
		}
		EditableLabel label = new EditableLabel(getNodeLabelName(), potency, mutability);
		if(smallIcon != null){
			label.setIcon((Image)smallIcon.createResource(null));	
		}
		
		return label;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new VCompartmentElementNameDirectEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE,
				new ConnectionEditPolicy() {
					@Override
					protected Command getDeleteCommand(GroupRequest request) {
						if(getDNode() != null && getDNode().getDGraph() != null){
							return new ChildDNodeDeleteCommand((VCompartmentElement)getModel()); 
						}
						return null;
					}
				});
	}
	
	public DNode getDNode(){
		return ((VCompartmentElement)getModel()).getDNode();
	}

	private String getNodeLabelName() {
		String result = "";
		DNode dnode = getDNode();
		Node node = dnode.getNode();
		if(node != null){
			Node templateNode = (Node) node.getTemplateElement();
			if(templateNode != null && templateNode.getName().equals(ClassDiagramConstants.NODE_METHOD)){
				result += ClassDiagramMethodUtilities.generateMethodString(node);
			}else if(templateNode != null && templateNode.getName().equals(ClassDiagramConstants.NODE_ATTRIBUTE)){
				result += ClassDiagramAttributeUtilities.generateAttributeString(node); 
			}else{
				result += node.getName();
			}
		}
		
		return result;
	}	

	@Override
	protected void refreshVisuals() {
		EditableLabel figure = (EditableLabel)getFigure();
		figure.setLabelAlignment(PositionConstants.LEFT);
		figure.setText(getNodeLabelName());
		figure.setVisible(true);
		figure.revalidate();
	}
	
	@Override
	public void performRequest(Request req) {
		if (req.getType().equals(RequestConstants.REQ_DIRECT_EDIT)) {
			VTextDirectEditManager manager = new VTextDirectEditManager(this, TextCellEditor.class, new TextCellEditorLocator((EditableLabel)getFigure()));
			manager.show();
			return;
		}
		super.performRequest(req);
	}
	
	@Override
	public DNode getDiagramModel(){ 
		return (DNode) ((VCompartmentElement)getModel()).getDNode(); 
	}
}
