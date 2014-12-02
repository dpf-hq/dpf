package no.hib.dpf.uconstraint.presentation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.SelectionTool;

public class AddTool  extends SelectionTool  {

	public final static String REQ_MAKE_ADD = "make_add";
	@Override
	protected String getCommandName() {
		return REQ_MAKE_ADD;
	}
	
	protected Request createTargetRequest() {
		SelectionRequest request = new SelectionRequest();
		request.setType(getCommandName());
		return request;
	}
	protected void updateTargetRequest() {
		SelectionRequest request = (SelectionRequest) getTargetRequest();
		request.setLocation(getLocation());
	}
	
	protected boolean handleButtonDown(int button) {
		if(super.handleButtonDown(button)){
			EditPart editpart = getTargetEditPart();
			if (editpart != null) {
				setCurrentCommand(getCommand());
				return true;
			}
		}
		return false;
	}
	
	protected boolean handleButtonUp(int button) {
		if(super.handleButtonUp(button)){
			executeCurrentCommand();
			return true;
		}
		return false;
	}
	protected EditPartViewer.Conditional getTargetingConditional() {
		return new EditPartViewer.Conditional() {
			public boolean evaluate(EditPart editpart) {
				EditPart targetEditPart = editpart .getTargetEditPart(getTargetRequest());
				return targetEditPart != null && targetEditPart.isSelectable();
			}
		};
	}
	
	
}	