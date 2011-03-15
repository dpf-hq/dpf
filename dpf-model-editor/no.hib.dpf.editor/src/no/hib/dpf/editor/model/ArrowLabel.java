package no.hib.dpf.editor.model;

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

import org.eclipse.draw2d.geometry.Point;

public class ArrowLabel extends ModelElement {

	public static final String NAME_PROP = "ConnectionLabel.Name";
	public static final String POSITION_PROP = "ConnectionLabel.Position";
	private static final long serialVersionUID = -3733055120855210860L;
	private String labelText = "";
	private Point offset = new Point();

	public ArrowLabel(String labelText) { //, String position) {
		this.labelText = labelText;
	}

	public void setOffset(Point offset) {
		this.offset = offset;
		firePropertyChange(POSITION_PROP, null, null);
	}

	public Point getOffset() {
		return offset;
	}

	public void setLabelText(String string) {
		labelText = string;
		firePropertyChange(NAME_PROP, null, null);		
	}

	public String getLabelText() {
		return labelText;
	}

}