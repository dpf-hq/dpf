/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package no.hib.dpf.editor.viewmodel.commands;

import no.hib.dpf.editor.viewmodel.ArrowBendpoint;

public class CreateBendpointCommand extends BendpointCommand {

	public void execute() {
		ArrowBendpoint wbp = new ArrowBendpoint();
		wbp.setRelativeDimensions(getFirstRelativeDimension(),
				getSecondRelativeDimension());
		getArrow().insertBendpoint(getIndex(), wbp);
		super.execute();
	}

	public void undo() {
		super.undo();
		getArrow().removeBendpoint(getIndex());
	}

}
