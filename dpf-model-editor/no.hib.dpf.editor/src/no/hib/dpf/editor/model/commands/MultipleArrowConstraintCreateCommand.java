package no.hib.dpf.editor.model.commands;

import java.util.Iterator;

import no.hib.dpf.editor.model.VArrow;
import no.hib.dpf.editor.model.VConstraint;
import no.hib.dpf.metamodel.Constraint;


/**
 * A command to create a constraint between two connections. The command can be
 * undone or redone.
 * TODO: generalize the class to accept more than two arrows.
 */
public class MultipleArrowConstraintCreateCommand extends ConstraintCreateCommand {
	private final VArrow source;
	private VArrow target;
	
	private VConstraint.ConstraintType constraintType;

	/**
	 * Instantiate a command that can create a connection between two
	 * connections.
	 */
	public MultipleArrowConstraintCreateCommand(VArrow source, VArrow target, VConstraint.ConstraintType constraintType, Constraint IDObject) {
		super(IDObject);
		if (source == null) {
			throw new IllegalArgumentException();
		}
		setLabel("constraint creation");
		this.source = source;
		this.target = target;
		this.constraintType = constraintType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		if (source.equals(target)) {
			return false;
		}
		if (doSourceToTargetAlreadyExist()) {
			return false;
		}
		return true;
	}

	private boolean doSourceToTargetAlreadyExist() {
		for (Iterator<VConstraint> iter = source.getSourceConstraints().iterator(); iter.hasNext();) {
			VConstraint constraint = iter.next();
			if (constraint.getConnectionTarget().equals(target)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		// create a new connection between source and target
		constraint = new VConstraint(source, target, constraintType, idObject);
	}

//	/**
//	 * Set the target endpoint for the connection.
//	 * @param target that target endpoint (a non-null Shape instance)
//	 * @throws IllegalArgumentException if target is null
//	 */
//	public void setTarget(VArrow target) {
//		if (target == null) {
//			throw new IllegalArgumentException();
//		}
//		this.target = target;
//	}

}
