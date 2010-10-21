package no.hib.dpf.editor.model.commands;

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.ConstraintElement;
import no.hib.dpf.editor.model.SingleLineConstraintElement;

import org.eclipse.gef.commands.Command;

/**
 * A command to create a constraint between two connections. The command can be
 * undone or redone.
 */
public class MultiplicityConstraintCreateCommand extends Command {
	/** The connection instance. */
	private ConstraintElement constraint;

	private final Connection connection;

	/**
	 * Instantiate a command that can create a connection between two
	 * connections.
	 */
	public MultiplicityConstraintCreateCommand(Connection connection) {
		if (connection == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection creation");
		this.connection = connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		// TODO: check for constraint already set
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		constraint = new SingleLineConstraintElement(connection, ConstraintElement.ConstraintType.Multiplicity);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		constraint.reconnect();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		constraint.disconnect();
	}
}