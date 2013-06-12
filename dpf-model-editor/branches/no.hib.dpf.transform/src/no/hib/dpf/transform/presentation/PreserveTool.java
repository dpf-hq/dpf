package no.hib.dpf.transform.presentation;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.SelectionTool;

public class PreserveTool  extends AddTool  {

	public final static String REQ_MAKE_COMMON = "make_common";
	@Override
	protected String getCommandName() {
		return REQ_MAKE_COMMON;
	}
}	