package no.hib.dpf.editor.viewmodel.commands;

import no.hib.dpf.editor.viewmodel.SingleLineConstraintElement;
import no.hib.dpf.editor.viewmodel.VArrow;
import no.hib.dpf.editor.viewmodel.VConstraint;

import org.eclipse.gef.commands.Command;

/**
 * A command to create a constraint between two connections. The command can be
 * undone or redone.
 */
public class MultiplicityConstraintCreateCommand extends Command {
	/** The connection instance. */
	private VConstraint constraint;

	private final VArrow connection;

	/**
	 * Instantiate a command that can create a connection between two
	 * connections.
	 */
	public MultiplicityConstraintCreateCommand(VArrow connection) {
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
		constraint = new SingleLineConstraintElement(connection, VConstraint.ConstraintType.MULTIPLICITY);
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
