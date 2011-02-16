package no.hib.dpf.editor.viewmodel.commands;

import no.hib.dpf.editor.viewmodel.VConstraint;
import no.hib.dpf.metamodel.Constraint;

import org.eclipse.gef.commands.Command;

public abstract class ConstraintCreateCommand extends Command {

	protected VConstraint constraint;
	
	protected Constraint idObject;

	public ConstraintCreateCommand(Constraint idObject) {
		super();
		this.idObject = idObject;
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