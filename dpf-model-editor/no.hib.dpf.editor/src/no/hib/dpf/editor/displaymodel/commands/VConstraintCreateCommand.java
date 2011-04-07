package no.hib.dpf.editor.displaymodel.commands;

import no.hib.dpf.editor.displaymodel.DConstraint;
import no.hib.dpf.metamodel.Constraint;

import org.eclipse.gef.commands.Command;

public abstract class VConstraintCreateCommand extends Command {

	protected DConstraint constraint;
	
	protected Constraint idObject;

	public VConstraintCreateCommand(Constraint idObject) {
		super();
		this.idObject = idObject;
	}

	public VConstraintCreateCommand(String label) {
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