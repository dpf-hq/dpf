package no.hib.dpf.editor.model.commands;

import no.hib.dpf.editor.model.SingleArrowConstraintElement;
import no.hib.dpf.editor.model.VArrow;
import no.hib.dpf.editor.model.VConstraint;
import no.hib.dpf.metamodel.Constraint;


/**
 * A command to create a constraint on one arrow. The command can be
 * undone or redone.
 */
public class SingleArrowConstraintCreateCommand extends ConstraintCreateCommand {
	private final VArrow arrow;	
	private VConstraint.ConstraintType constraintType;

	/**
	 * Instantiate a command that can create a connection between two
	 * connections.
	 */
	public SingleArrowConstraintCreateCommand(VArrow arrow, VConstraint.ConstraintType constraintType, Constraint IDObject) {
		super(IDObject);
		if (arrow == null) {
			throw new IllegalArgumentException();
		}
		setLabel("constraint creation");
		this.arrow = arrow;
		this.constraintType = constraintType;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		// TODO: check for some constraint already set(?)
		return super.canExecute();
	}	

	public void execute() {
		// create a new connection between source and target
		constraint = new SingleArrowConstraintElement(arrow, constraintType, idObject);
	}

}
