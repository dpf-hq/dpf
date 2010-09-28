package no.hib.dpf.editor.model.commands;

import java.util.Iterator;

import no.hib.dpf.editor.model.Connection;
import no.hib.dpf.editor.model.Constraint;

import org.eclipse.gef.commands.Command;



/**
 * A command to create a constraint between two connections.
 * The command can be undone or redone.
 */
public class ConstraintCreateCommand extends Command {
/** The connection instance. */
private Constraint constraint;
/** The desired line style for the connection (dashed or solid). */
private final int lineStyle;

private final Connection source;
private Connection target;

/**
 *	Instantiate a command that can create a connection between two connections.
 */
public ConstraintCreateCommand(Connection source, Connection target, int lineStyle) {
	if (source == null) {
		throw new IllegalArgumentException();
	}
	setLabel("connection creation");
	this.source = source;
	this.target = target;
	this.lineStyle = lineStyle;
}

/* (non-Javadoc)
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
	for (Iterator<Constraint> iter = source.getSourceConstraints().iterator(); iter.hasNext();) {
		Constraint constraint = iter.next();
		if (constraint.getConnectionTarget().equals(target)) {
			return true;
		}
	}
	return false;
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#execute()
 */
public void execute() {
	// create a new connection between source and target
	constraint = new Constraint(source, target);
	// use the supplied line style
	constraint.setLineStyle(lineStyle);
}

/* (non-Javadoc)
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
public void setTarget(Connection target) {
	if (target == null) {
		throw new IllegalArgumentException();
	}
	this.target = target;
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#undo()
 */
public void undo() {
	constraint.disconnect();
}
}
