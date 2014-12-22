package no.hib.dpf.uconstraint.presentation;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.command.AddConstraintsCommand;
import no.hib.dpf.uconstraint.command.DeleteConstraintsCommand;
import no.hib.dpf.uconstraint.command.PreserveConstraintsCommand;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;

public class ActionEditPolicy extends AbstractEditPolicy {

	public Command getCommand(Request request) { 
		EditPart part = getHost();
		Object editObject = part.getModel();
		UConstraint uconstraint = getUConstraint((DElement) editObject);
		if(uconstraint != null){
			if (AddTool.REQ_MAKE_ADD.equals(request.getType()) && 
					((editObject instanceof DNode && !uconstraint.isAdded((DNode) editObject)) || 
							(editObject instanceof DArrow && !uconstraint.isAdded((DArrow)editObject))))
				return new AddConstraintsCommand(editObject, uconstraint);
			if (DeleteTool.REQ_MAKE_DELETE.equals(request.getType()) && 
					((editObject instanceof DNode && !uconstraint.isDeled((DNode) editObject)) || 
							(editObject instanceof DArrow && !uconstraint.isDeled((DArrow)editObject))))
				return new DeleteConstraintsCommand(editObject, uconstraint);
			if (PreserveTool.REQ_MAKE_COMMON.equals(request.getType()) && 
					((editObject instanceof DNode && !uconstraint.isKept((DNode) editObject)) || 
							(editObject instanceof DArrow && !uconstraint.isKept((DArrow)editObject))))
				return  new PreserveConstraintsCommand(editObject, uconstraint);;
		}
		return null;
	}

	private UConstraint getUConstraint(DElement element){
		return (UConstraint) element.eContainer().eContainer().eContainer();
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