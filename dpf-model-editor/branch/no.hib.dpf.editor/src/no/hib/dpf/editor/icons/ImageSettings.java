/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.icons;

import java.io.File;

public enum ImageSettings {
	SMALL_RECTANGLE("rectangle32.png"),
	LARGE_RECTANGLE("rectangle48.png"),
	SMALL_CONNECTION("connection_s16.gif"),
	LARGE_CONNECTION("connection_s24.gif"),
	MULTIPLICITY("mult_36.png"),
	INVERSE("inv_36.png"),
	JOINTLY_INJECTIVE("ji_36.png"),
	JOINTLY_SURJECTIVE("js_36.png"),
	IMAGE_INCLUSION("img_incl_36.png"),
	COMPOSITION("comp_36.png"),
	INJECTIVE("inj_36.png"),
	IRREFLEXIVE("irr_36.png"),
	TRANSITIVE_IRREFLEXIVE("t-irr_36.png"),
	SURJECTIVE("surj_36.png"),
	XOR("xor_36.png"),
	NAND("nand_36.png");
	
	private String filePath;
	
	ImageSettings(String filename) {
		String directoryPrefix = "icons" + File.separatorChar;
		filePath = directoryPrefix + filename;
	}
	
	public String getFilePath() {
		return filePath;
	}
}
