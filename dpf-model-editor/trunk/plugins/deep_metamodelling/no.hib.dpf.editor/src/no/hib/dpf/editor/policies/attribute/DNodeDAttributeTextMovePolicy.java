/**
 * Original code taken from now-defunct site qvtp.org.
 * 
 * Copyright (c) 2004, QVT-Partners.
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the QVT-Partners nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission. 

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS 
BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
OF SUCH DAMAGE. 
 */
package no.hib.dpf.editor.policies.attribute;
/**
 * 
 * Copyright (c) 2004, QVT-Partners.
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the QVT-Partners nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS 
 BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
 GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
 OF SUCH DAMAGE. 
 */

import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.commands.ArrowTextMoveCommand;
import no.hib.dpf.editor.figures.draw2d.Draw2dUtil;
import no.hib.dpf.editor.parts.attribute.DDataNodeEditPart;
import no.hib.dpf.editor.parts.attribute.DNodeDAttributeLabelEditPart;
import no.hib.dpf.editor.parts.node.DNodeEditPart;
import no.hib.dpf.editor.preferences.DPFEditorPreferences;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;

public class DNodeDAttributeTextMovePolicy extends NonResizableEditPolicy {

	@Override
	public Command getMoveCommand(ChangeBoundsRequest request) {
		ArrowTextMoveCommand command = null;
		DNodeDAttributeLabelEditPart editpart = (DNodeDAttributeLabelEditPart)getHost();
		
		DOffset model = editpart.getDOffset();
		IFigure label = editpart.getFigure();
		ConnectionEditPart connection = (ConnectionEditPart) editpart.getParent();
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DDataNodeEditPart) connection.getTarget()).getFigure();
		Point p = label.getBounds().getTopLeft().getTranslated(request.getMoveDelta());
		command = new ArrowTextMoveCommand(model, Draw2dUtil.getDOffset(source, target, ((Connection)connection.getFigure()).getPoints(), p));
		return command;
	}
	@Override
	protected void showSelection() {
		super.showSelection();
		DNodeDAttributeLabelEditPart editpart = (DNodeDAttributeLabelEditPart)getHost();
		ConnectionEditPart connection = (ConnectionEditPart) editpart.getParent();
		connection.getFigure().setForegroundColor(DPFEditorPreferences.getDefault().getArrowLabelSelectedArrowColor());		
	}
	@Override
	protected void removeSelectionHandles() {
		DNodeDAttributeLabelEditPart editpart = (DNodeDAttributeLabelEditPart)getHost();
		ConnectionEditPart connection = (ConnectionEditPart) editpart.getParent();
		connection.getFigure().setForegroundColor(DPFEditorPreferences.getDefault().getArrowForegroundColor());	
		super.removeSelectionHandles();
	}
}