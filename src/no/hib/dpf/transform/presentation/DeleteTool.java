package no.hib.dpf.transform.presentation;


public class DeleteTool   extends AddTool  {

	public final static String REQ_MAKE_DELETE = "make_delete";
	@Override
	protected String getCommandName() {
		return REQ_MAKE_DELETE;
	}
}
