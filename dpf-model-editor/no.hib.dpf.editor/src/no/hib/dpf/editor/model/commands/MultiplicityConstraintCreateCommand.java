package no.hib.dpf.editor.model.commands;

import no.hib.dpf.editor.model.SingleArrowConstraintElement;
import no.hib.dpf.editor.model.VArrow;
import no.hib.dpf.editor.model.VConstraint;
import no.hib.dpf.metamodel.Constraint;

/**
 * A command to create a constraint on a single arrow. The command can be
 * undone or redone.
 */
public class MultiplicityConstraintCreateCommand extends ConstraintCreateCommand {

	private final VArrow arrow;

	/**
	 * Instantiate a command that can create a constraint on a single arrow.
	 */
	public MultiplicityConstraintCreateCommand(VArrow arrow, Constraint idObject) {
		super(idObject);
		if (arrow == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection creation");
		this.arrow = arrow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		// TODO: check for some constraint already set(?)
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		constraint = new SingleArrowConstraintElement(arrow, VConstraint.ConstraintType.MULTIPLICITY, idObject);
	}

}
