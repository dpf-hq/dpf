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
package no.hib.dpf.editor.parts;
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
import no.hib.dpf.diagram.util.DiagramUtil;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

class ArrowLabelLocator implements Locator {

	private String text;
	private DOffset offset;
	private DArrowEditPart connection;

	public ArrowLabelLocator(String text, DOffset dOffset, DArrowEditPart parent) {
		this.text = text == null ? "" : text;
		this.offset = dOffset;
		this.connection = parent;
	}

	public void relocate(IFigure figure) {
		Dimension minimum = FigureUtilities.getTextExtents(text, figure.getFont());
		figure.setSize(minimum);
		IFigure source = ((DNodeEditPart) connection.getSource()).getFigure();
		IFigure target = ((DNodeEditPart) connection.getTarget()).getFigure();
		Connection connectionFigure = this.connection.getConnectionFigure();
		PointList points = connectionFigure.getPoints();
		Point start, end;
		if(offset.getIndex() == 0 && points.size() == 2){
			start = source == target ? source.getBounds().getTop() : source.getBounds().getCenter();
			end = source == target ? source.getBounds().getBottom() : target.getBounds().getCenter();
		}else{
			start = points.getPoint(offset.getIndex());
			end = points.getPoint(offset.getIndex() + 1);
		}
		figure.setLocation(DiagramUtil.getAbsoluteBendPoint(start, end, offset));
	}
}