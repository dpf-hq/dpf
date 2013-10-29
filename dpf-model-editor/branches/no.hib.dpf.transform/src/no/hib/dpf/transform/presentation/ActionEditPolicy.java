package no.hib.dpf.transform.presentation;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.command.AddTransformCommand;
import no.hib.dpf.transform.command.DeleteTransformCommand;
import no.hib.dpf.transform.command.PreserveTransformCommand;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

public class ActionEditPolicy extends AbstractEditPolicy {

	public Command getCommand(Request request) { 
		EditPart part = getHost();
		Object editObject = part.getModel();
		Production production = getProduction((DElement) editObject);
		if(production != null){
			if (AddTool.REQ_MAKE_ADD.equals(request.getType()) && 
					((editObject instanceof DNode && !production.isAdded((DNode) editObject)) || 
							(editObject instanceof DArrow && !production.isAdded((DArrow)editObject))))
				return new AddTransformCommand(editObject, production);
			if (DeleteTool.REQ_MAKE_DELETE.equals(request.getType()) && 
					((editObject instanceof DNode && !production.isDeled((DNode) editObject)) || 
							(editObject instanceof DArrow && !production.isDeled((DArrow)editObject))))
				return new DeleteTransformCommand(editObject, production);
			if (PreserveTool.REQ_MAKE_COMMON.equals(request.getType()) && 
					((editObject instanceof DNode && !production.isKept((DNode) editObject)) || 
							(editObject instanceof DArrow && !production.isKept((DArrow)editObject))))
				return  new PreserveTransformCommand(editObject, production);;
		}
		return null;
	}

	private Production getProduction(DElement element){
		return (Production) element.eContainer().eContainer().eContainer();
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