package no.hib.dpf.editor.model.commands;

import no.hib.dpf.editor.model.VConstraint;

import org.eclipse.gef.commands.Command;

/**
 * A command to disconnect (remove) a sonstraint from its endpoints. The command
 * can be undone or redone.
 */
public class ConstraintDeleteCommand extends Command {

	/** Connection instance to disconnect. */
	private final VConstraint constraint;

	/**
	 * Create a command that will disconnect a connection from its endpoints.
	 * 
	 * @param conn
	 *            the connection instance to disconnect (non-null)
	 * @throws IllegalArgumentException
	 *             if conn is null
	 */
	public ConstraintDeleteCommand(VConstraint constraint) {
		if (constraint == null) {
			throw new IllegalArgumentException();
		}
		setLabel("constraint deletion");
		this.constraint = constraint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		constraint.disconnect();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		constraint.reconnect();
	}
}
