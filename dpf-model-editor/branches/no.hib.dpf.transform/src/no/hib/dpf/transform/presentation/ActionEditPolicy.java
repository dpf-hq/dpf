package no.hib.dpf.transform.presentation;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.EmptyExecutableCommand;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.command.AddTransformCommand;
import no.hib.dpf.transform.command.DeleteTransformCommand;
import no.hib.dpf.transform.command.PreserveTransformCommand;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

public class ActionEditPolicy extends AbstractEditPolicy {

	private Object object;
	
	public Command getCommand(Request request) {
		if (AddTool.REQ_MAKE_ADD.equals(request.getType()))
			return MakeAddCommand(getHost());
		if (DeleteTool.REQ_MAKE_DELETE.equals(request.getType()))
			return MakeDeleteCommand(getHost());
		if(PreserveTool.REQ_MAKE_COMMON.equals(request.getType()))
			return MakeCommonCommand(getHost());
		return null;
	}

	private Command MakeCommonCommand(EditPart editPart) {
		Object editObject = editPart.getModel();
		Production production = null;
		
		if(editObject instanceof DArrow){
			DArrow dArrow = (DArrow) editObject;
			production = (Production) dArrow.eContainer().eContainer().eContainer();
		}
		if(editObject instanceof DNode){
			DNode dNode = ((DNode) editObject);
			production = (Production) (dNode).eContainer().eContainer().eContainer();
		}
		if(editPart != null && production != null){
			return new PreserveTransformCommand(editObject, production);
			//
		}
		return EmptyExecutableCommand.INSTANCE;
	}

	private Command MakeDeleteCommand(EditPart editPart) {
		Object editObject = editPart.getModel();
		Production production = null;
		
		if(editObject instanceof DArrow){
			DArrow dArrow = (DArrow) editObject;
			production = (Production) dArrow.eContainer().eContainer().eContainer();
		}
		if(editObject instanceof DNode){
			DNode dNode = ((DNode) editObject);
			production = (Production) (dNode).eContainer().eContainer().eContainer();
		}
		if(editPart != null && production != null){
			return new DeleteTransformCommand(editObject, production);
		}
		return EmptyExecutableCommand.INSTANCE;
	}

	private Command MakeAddCommand(EditPart editPart) {
		Object editObject = editPart.getModel();
		Production production = null;
		
		if(editObject instanceof DArrow){
			DArrow dArrow = (DArrow) editObject;
			production = (Production) dArrow.eContainer().eContainer().eContainer();
			System.out.println("Ger " + (dArrow).eContainer().eContainer().eContainer());
		}
		if(editObject instanceof DNode){
			DNode dNode = ((DNode) editObject);
			production = (Production) (dNode).eContainer().eContainer().eContainer();
		}
		if(editPart != null && production != null){
			return new AddTransformCommand(editObject, production);
		}
		return EmptyExecutableCommand.INSTANCE;
	}
	
	public EditPart getTargetEditPart(Request request) {
		if (AddTool.REQ_MAKE_ADD.equals(request.getType()) || 
			DeleteTool.REQ_MAKE_DELETE.equals(request.getType()) || 
			PreserveTool.REQ_MAKE_COMMON.equals(request.getType()))
			return getHost();
		return null;
	}
}
;