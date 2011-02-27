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
package no.hib.dpf.editor.parts;

import no.hib.dpf.editor.viewmodel.DPFDiagram;
import no.hib.dpf.editor.viewmodel.VNode;
import no.hib.dpf.editor.viewmodel.commands.VNodeDeleteCommand;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;


/**
 * This edit policy enables the removal of a VNode instance from its container. 
 * @see NodeEditPart#createEditPolicies()
 * @see NodeTreeEditPart#createEditPolicies()
 * @author Elias Volanakis
 */
class NodeComponentEditPolicy extends ComponentEditPolicy {

/* (non-Javadoc)
 * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
 */
protected Command createDeleteCommand(GroupRequest deleteRequest) {
	Object parent = getHost().getParent().getModel();
	Object child = getHost().getModel();
	if (parent instanceof DPFDiagram && child instanceof VNode) {
		return new VNodeDeleteCommand((DPFDiagram) parent, (VNode) child);
	}
	return super.createDeleteCommand(deleteRequest);
}
}