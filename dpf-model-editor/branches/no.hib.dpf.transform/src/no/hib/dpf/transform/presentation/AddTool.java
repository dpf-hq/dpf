package no.hib.dpf.transform.presentation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.tools.TargetingTool;

public class AddTool  extends TargetingTool  {

	public final static String REQ_MAKE_ADD = "make_add";
	@Override
	protected String getCommandName() {
		return REQ_MAKE_ADD;
	}
	
	protected Request createTargetRequest() {
		LocationRequest request = new LocationRequest();
		request.setType(getCommandName());
		return request;
	}
	protected void updateTargetRequest() {
		LocationRequest request = (LocationRequest) getTargetRequest();
		request.setLocation(getLocation());
	}
	
	protected boolean handleButtonDown(int button) {
		resetHover();
		updateTargetRequest();
		updateTargetUnderMouse();
		EditPart editpart = getTargetEditPart();
		if (editpart != null) {
			lockTargetEditPart(editpart);
			setCurrentCommand(getCommand());
			return true;
		}
		return false;
	}
	
	protected boolean handleButtonUp(int button) {
		if (getCurrentInput().isAnyButtonDown())
			return false;
		unlockTargetEditPart();
		return true;
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
