package no.hib.dpf.editor.commands.attribute;

import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.editor.commands.EmptyExecutableCommand;

import org.eclipse.gef.commands.CompoundCommand;
 
public class DNodeAttributeDeleteCommand extends CompoundCommand {

	/** Connection instance to disconnect. */
	private final DNodeDAttribute connection;
	private DNode source;
	private DDataNode target;

	/**
	 * Create a command that will disconnect a connection from its endpoints.
	 * 
	 * @param conn
	 *            the connection instance to disconnect (non-null)
	 * @throws IllegalArgumentException
	 *             if conn is null
	 */
	public DNodeAttributeDeleteCommand(DNodeDAttribute conn) {
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		
		setLabel("connection deletion");
		this.connection = conn;
		source = conn.getDSource();
		target = conn.getDTarget();
		if(getCommands().size() == 0)
			add(EmptyExecutableCommand.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		super.execute();
		if(connection.getDSource() == source && connection.getDTarget() == target && source.getDGraph() == target.getDGraph()){
			connection.disconnect();
		}
	}
	
	@Override
	public void redo(){
		execute();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		if(connection.getDSource() == null && connection.getDTarget() == null && source.getDGraph() == target.getDGraph())
			connection.reconnect(source, target);
		super.undo();
	}
}
