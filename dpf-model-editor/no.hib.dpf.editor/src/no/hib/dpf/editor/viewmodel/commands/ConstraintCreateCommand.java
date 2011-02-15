package no.hib.dpf.editor.viewmodel.commands;

import no.hib.dpf.editor.viewmodel.VConstraint;

import org.eclipse.gef.commands.Command;

public abstract class ConstraintCreateCommand extends Command {

	/** The connection instance. */
	protected VConstraint constraint;

	public ConstraintCreateCommand() {
		super();
	}

	public ConstraintCreateCommand(String label) {
		super(label);
	}

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