/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor.model.commands;

import no.hib.dpf.editor.model.SingleNodeConnection;
import no.hib.dpf.editor.model.VEdge;
import no.hib.dpf.editor.model.VNode;
import no.hib.dpf.metamodel.Edge;

import org.eclipse.gef.commands.Command;



/**
 * A command to create a connection between two shapes.
 * The command can be undone or redone.
 * <p>
 * This command is designed to be used together with a GraphicalNodeEditPolicy.
 * To use this command properly, following steps are necessary:
 * </p>
 * <ol>
 * <li>Create a subclass of GraphicalNodeEditPolicy.</li>
 * <li>Override the <tt>getConnectionCreateCommand(...)</tt> method, 
 * to create a new instance of this class and put it into the CreateConnectionRequest.</li>
 * <li>Override the <tt>getConnectionCompleteCommand(...)</tt>  method,
 * to obtain the Command from the ConnectionRequest, call setTarget(...) to set the
 * target endpoint of the connection and return this command instance.</li>
 * </ol>
 * @see no.hib.dpf.editor.parts.VNodeEditPart#createEditPolicies() for an
 * 			 example of the above procedure.
 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy
 * @author Elias Volanakis
 */
public class ConnectionCreateCommand extends Command {
/** The connection instance. */
private VEdge connection;
private Edge typeEdge;

/** Start endpoint for the connection. */
private final VNode source;
/** Target endpoint for the connection. */
private VNode target;

/**
 *	Instantiate a command that can create a connection between two shapes.
 * @param source the source endpoint (a non-null Shape instance)
 * @param lineStyle the desired line style. See Connection#setLineStyle(int) for details
 * @throws IllegalArgumentException if source is null
 * @see VEdge#setLineStyle(int)
 */
public ConnectionCreateCommand(VNode source, Edge typeEdge) {
	if (source == null) {
		throw new IllegalArgumentException();
	}
	setLabel("connection creation");
	this.source = source;
	this.typeEdge = typeEdge;
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#canExecute()
 */
public boolean canExecute() {
//	if (doSourceToTargetAlreadyExist()) {
//		return false;
//	}
	if ((target == null) || (source == null)) {
		return true;
	}
	return source.edgeCanMakeConnectionAsTarget(target, typeEdge);
}

//private boolean doSourceToTargetAlreadyExist() {
//	for (Iterator<VEdge> iter = source.getSourceConnections().iterator(); iter.hasNext();) {
//		VEdge conn = iter.next();
//		if (conn.getShapeTarget().equals(target)) {
//			return true;
//		}
//	}
//	return false;
//}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#execute()
 */
public void execute() {
	// create a new connection between source and target
	if (!source.equals(target)) {
		connection = new VEdge(source, target);
	} else {
		connection = new SingleNodeConnection(source);
	}
//	// use the supplied line style
//	connection.setLineStyle(lineStyle);
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#redo()
 */
public void redo() {
	connection.reconnect();
}

/**
 * Set the target endpoint for the connection.
 * @param target that target endpoint (a non-null Shape instance)
 * @throws IllegalArgumentException if target is null
 */
public void setTarget(VNode target) {
	if (target == null) {
		throw new IllegalArgumentException();
	}
	this.target = target;
}

/* (non-Javadoc)
 * @see org.eclipse.gef.commands.Command#undo()
 */
public void undo() {
	connection.disconnect();
}
}
