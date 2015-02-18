package no.hib.dpf.editor.policies;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.diagram.DArrow;
//import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DNode;
//import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.editor.commands.DArrowCreateCommand;
import no.hib.dpf.editor.commands.DArrowReconnectCommand;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
//import no.hib.dpf.diagram.DArrowDAttribute;
//import no.hib.dpf.editor.commands.DArrowReconnectCommand;
//import no.hib.dpf.editor.commands.attribute.DArrowDAttributeCreateCommand;
//import no.hib.dpf.editor.commands.attribute.DArrowDAttributeReconnectCommand;
//import no.hib.dpf.editor.commands.attribute.DNodeAttributeCreateCommand;
//import no.hib.dpf.editor.commands.attribute.DNodeAttributeReconnectCommand;

/**
 * 
 * @author Ole Klokkhammer
 *
 */
public class DConnectionCreatePolicy extends GraphicalNodeEditPolicy {

	/**
	 * @author Ole Klokkhammer
	 */
	@Override
	protected Command getConnectionCreateCommand( CreateConnectionRequest request) {
		Object objectType = request.getNewObjectType();
		Command cmd = null;
		
//		if (objectType == DNodeDAttribute.class) {
//			Object sourceDNode = getHost().getModel();
//			if(sourceDNode instanceof DNode){
//				DNodeDAttribute dattribute = (DNodeDAttribute) request.getNewObject();
//				cmd = new DNodeAttributeCreateCommand((DNode)sourceDNode, dattribute);
//			}
//		}
//		
//		else if (objectType == DArrowDAttribute.class) {
//			
//			Object sourceDArrow = getHost().getModel();
//			if(sourceDArrow instanceof DArrow){
//				DArrowDAttribute dattribute = (DArrowDAttribute) request.getNewObject();
//				cmd = new DArrowDAttributeCreateCommand((DArrow)sourceDArrow, dattribute);
//			}
//		}
		
//		else 
			if (objectType == DArrow.class) {
			DArrow darrow = (DArrow) request.getNewObject();
			Object sourceDNode = getHost().getModel();
			if(sourceDNode instanceof DNode){
				// only create the command if the type is correct
				if(canCreateConnection((DNode)sourceDNode, darrow)){
					cmd = new DArrowCreateCommand((DNode)sourceDNode, darrow);
				}
			}
		}
		
		if(cmd != null){
			request.setStartCommand(cmd);
		}
		return cmd;
	}
	
	/**
	 *@author Ole Klokkhammer
	 */
	@Override
	protected Command getConnectionCompleteCommand( CreateConnectionRequest request) {
		Command cmd = null;
		if(request.getNewObjectType() == DArrow.class){
			cmd = request.getStartCommand();
			
			if(cmd != null){
				Object targetDNode = getHost().getModel();
				if(targetDNode instanceof DNode){
					((DArrowCreateCommand)cmd).setTarget((DNode) targetDNode);
					return cmd;
				}
			}
			
//		}else if(request.getNewObjectType() == DNodeDAttribute.class){
//			cmd = request.getStartCommand();
//			
//			if(cmd != null){
//				Object targetDDataNode = getHost().getModel();
////				if(targetDDataNode instanceof DDataNode){
////					((DNodeAttributeCreateCommand)cmd).setTarget((DDataNode) targetDDataNode);
////					return cmd;
////				}
//			}
//		}
		
//		else if(request.getNewObjectType() == DArrowDAttribute.class){
//			cmd = request.getStartCommand();
//			
//			if(cmd != null){
//				Object targetDDataNode = getHost().getModel();
//				if(targetDDataNode instanceof DDataNode){
//					((DArrowDAttributeCreateCommand)cmd).setTarget((DDataNode) targetDDataNode);
//					return cmd;
//				}
//			}
		}
		return null;
	}

	/*
	 * @author Ole Klokkhammer
	 * @param sourceDNode
	 * @param darrow
	 * @return
	 */
	private boolean canCreateConnection(DNode sourceDNode, DArrow darrow) {
		if(sourceDNode == null || darrow == null){
			return false;
		}
		
		DArrow typeDArrow = darrow.getDType();
		Assert.isNotNull(typeDArrow);
		Arrow typeArrow = typeDArrow.getArrow();
		Assert.isNotNull(typeArrow);
		
		// check to see if we are dealing with extension for the template metalevel or not:
		boolean isExtensionFromTemplateMetalevel = false;
		if(typeArrow.isTemplateElement() || DPFTemplateUtils.getTemplateArrows(sourceDNode.getDType()).contains(typeArrow.getName())){
			isExtensionFromTemplateMetalevel = true;
		}
		
		// align types after what metalevel we are extending from------
		DNode sourceDType = null;
		DNode arrowSrcDType = null;
		DNode sourceDNodeType = sourceDNode.getDType();
		DArrow arrowDType = darrow.getDType();
		if(sourceDNodeType == null || arrowDType == null){
			return false;
		}
		if(isExtensionFromTemplateMetalevel){
			sourceDType = sourceDNodeType.getTemplateDNode();
			arrowSrcDType = arrowDType.getDSource().getTemplateDNode();
		}else{
			sourceDType = sourceDNodeType;
			arrowSrcDType = arrowDType.getDSource();
		}
		// end of metalevel alignment ---------------------------------
		
		// sanity check
		if(sourceDType == null || arrowSrcDType == null){
			return false;
		}
		
		// finally, check if we can connect or not:
		if(arrowSrcDType == sourceDType){
			return true;
		}
		return false;
	}
	

	@Override
	protected Command getReconnectSourceCommand( ReconnectRequest request) {
		Object model = request.getConnectionEditPart().getModel();
//		if(model instanceof DNodeDAttribute){
//			DNodeDAttribute conn = (DNodeDAttribute) model;
//			Object newSource = getHost().getModel();
//			if(newSource instanceof DNode){
//				DNodeAttributeReconnectCommand cmd = new DNodeAttributeReconnectCommand(conn);
//				cmd.setNewSource((DNode)newSource);
//				return cmd;
//			}
//		}
//		else if(model instanceof DArrowDAttribute){
//			DArrowDAttribute conn = (DArrowDAttribute) model;
//			Object newSource = getHost().getModel();
//			if(newSource instanceof DArrow){
//				DArrowDAttributeReconnectCommand cmd = new DArrowDAttributeReconnectCommand(conn);
//				cmd.setNewSource((DArrow)newSource);
//				return cmd;
//			}
//		}
//		
//		else 
		if(model instanceof DArrow){
			DArrow conn = (DArrow) model;
			Object newSource = getHost().getModel();
			if(newSource instanceof DNode){
				DArrowReconnectCommand cmd = new DArrowReconnectCommand(conn);
				cmd.setNewSource((DNode)newSource);
				return cmd;
			}
		}
		
		return null;
	}

//	@Ove

//	@Override
//	public void showSourceFeedback(Request request) {
//		Object type = request.getType();
//		if ((REQ_CONNECTION_START.equals(type) || REQ_CONNECTION_END.equals(type)) && request instanceof CreateConnectionRequest){
//			CreateConnectionRequest create = (CreateConnectionRequest) request;
//			
//			EditPart target = create.getTargetEditPart();
//			EditPart host = getHost();
//			if(host instanceof DNodeEditPart){
//				host = getHost();
//			}else if(host instanceof DArrowEditPart){
//				host = getHost();
//			}
//			
//			if(host == null){
//				return;
//			}
//			
//			EditPart source = create.getSourceEditPart();
//			if(source == host){
//				super.showSourceFeedback(request);
//			}
//			
//			NodeFigure figure = null;
//			if(host instanceof DNodeEditPart){
//				figure = (NodeFigure) ((AbstractGraphicalEditPart) host).getFigure();
//			}else if(host instanceof DArrowEditPart){
//			//	figure = (NodeFigure) ((AbstractGraphicalEditPart) host).getFigure();
//			}
//			
//			// sanity check
//			if(figure == null){
//				return;
//			}
//			
//			if(target instanceof DGraphEditPart){
//				if(REQ_CONNECTION_START.equals(type)){
//					figure.showFeedBack(1);
//				}else if(REQ_CONNECTION_END.equals(type)){
//					if(create.getNewObjectType() == DArrow.class){
//						DArrow arrow = (DArrow) create.getNewObject();
//						if(!(create.getSourceEditPart() == host && ((DNodeEditPart)host).getDType() != arrow.getDType().getDTarget())){
//							figure.showFeedBack(2);
//						}
//					}else if(create.getNewObjectType() == DNodeDAttribute.class){
//						DNodeDAttribute dattribute = (DNodeDAttribute) create.getNewObject();
//						if(!(create.getSourceEditPart() == host && ((DNodeEditPart)host).getDType() != dattribute.getDType().getDTarget())){
//							figure.showFeedBack(2);
//						}
//					}
//					else if(create.getNewObjectType() == DArrowDAttribute.class){
//						DArrowDAttribute dattribute = (DArrowDAttribute) create.getNewObject();
//						if(!(create.getSourceEditPart() == host && ((DArrowDAttribute)host).getDType() != dattribute.getDType().getDTarget())){
//							figure.showFeedBack(2);
//						}
//					}
//				}
//			}else if(target instanceof DNodeEditPart){
//				if(REQ_CONNECTION_START.equals(type)){
//					figure.showFeedBack(1);
//				}else if(REQ_CONNECTION_END.equals(type)){
//					DNode dType = ((DNodeEditPart)host).getDType();
//					DGraphEditPart parent = (DGraphEditPart) host.getParent();
//					List<DNodeEditPart> result = new ArrayList<DNodeEditPart>();
//					for(Object child : parent.getChildren()){
//						if(child instanceof DNodeEditPart){
//							DNode dNode = ((DNodeEditPart) child).getDiagramModel();
//							if(!(dNode instanceof DConstraintNode) && dNode.getDType() == dType)
//								result.add((DNodeEditPart) child);
//						}
//					}
//					result.remove(target);
//					for(DNodeEditPart iter : result){
//						NodeFigure figure1 = (NodeFigure) iter.getFigure();
//						figure1.showFeedBack(0);
//					}
//					figure.showFeedBack(0);
//				}
//			}else if(target instanceof DArrowEditPart){
//				if(REQ_CONNECTION_START.equals(type)){
//					figure.showFeedBack(1);
//				}else if(REQ_CONNECTION_END.equals(type)){
//					DNode dType = ((DNodeEditPart)host).getDType();
//					DGraphEditPart parent = (DGraphEditPart) host.getParent();
//					List<DArrowEditPart> result = new ArrayList<DArrowEditPart>();
//					for(Object child : parent.getChildren()){
//						if(child instanceof DArrowEditPart){
//							DNode dArrow = ((DNodeEditPart) child).getDiagramModel();
//							if(!(dArrow instanceof DConstraintNode) && dArrow.getDType() == dType)
//								result.add((DArrowEditPart) child);
//						}
//					}
//					result.remove(target);
//					for(DArrowEditPart iter : result){
//						NodeFigure figure1 = (NodeFigure) iter.getFigure();
//						figure1.showFeedBack(0);
//					}
//					figure.showFeedBack(0);
//				}
//			}
//		}
//	}
	@Override
	public void eraseSourceFeedback(Request request){
		if ((REQ_CONNECTION_START.equals(request.getType()) || REQ_CONNECTION_END.equals(request.getType()))
				&& request instanceof CreateConnectionRequest){
			super.eraseSourceFeedback(request);
			
//			EditPart host = getHost();
//			NodeFigure figure = null;
//			if(host instanceof DNodeEditPart){
//				figure = (NodeFigure) ((DNodeEditPart) host).getFigure();
//			}else if(host instanceof DNodeEditPart){
//				figure = (NodeFigure) ((DNodeEditPart) host).getFigure();
//			}
			
//			if(figure != null){
//				figure.showFeedBack(0);
//			}
		}
	}

	
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


}
