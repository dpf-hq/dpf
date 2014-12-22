package no.hib.dpf.uconstraint.presentation;


public class DeleteTool   extends AddTool  {

	public final static String REQ_MAKE_DELETE = "make_delete";
	@Override
	protected String getCommandName() {
		return REQ_MAKE_DELETE;
	}
}
