package no.hib.dpf.editor.model.commands;

import java.util.Iterator;

import no.hib.dpf.editor.model.VArrow;
import no.hib.dpf.editor.model.VConstraint;

import org.eclipse.gef.commands.Command;

/**
 * A command to create a constraint between two connections. The command can be
 * undone or redone.
 */
public class JImgConstraintCreateCommand extends Command {
	/** The connection instance. */
	private VConstraint constraint;

	private final VArrow source;
	private VArrow target;

	/**
	 * Instantiate a command that can create a connection between two
	 * connections.
	 */
	public JImgConstraintCreateCommand(VArrow source, VArrow target) {
		if (source == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection creation");
		this.source = source;
		this.target = target;
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
		constraint = new VConstraint(source, target, VConstraint.ConstraintType.JointImage);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		constraint.reconnect();
	}

	/**
	 * Set the target endpoint for the connection.
	 * @param target that target endpoint (a non-null Shape instance)
	 * @throws IllegalArgumentException if target is null
	 */
	public void setTarget(VArrow target) {
		if (target == null) {
			throw new IllegalArgumentException();
		}
		this.target = target;
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
