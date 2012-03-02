/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.icons;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.editor.DPFPlugin;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

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
	
	private String fileName;
	
	ImageSettings(String filename) {
		fileName = "/icons/" + filename;
	}
	Map<String, ImageDescriptor> maps = new HashMap<String, ImageDescriptor>();
	public String getFileName(){
		return fileName;
	}
	public Image getImage(){
		Image result = null;
		try {
			result = new Image(null, DPFPlugin.getDefault().getBundle().getResource(fileName).openStream());
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor result = maps.get(fileName);
		if(result == null){
			result = ImageDescriptor.createFromURL(DPFPlugin.getDefault().getBundle().getResource(fileName));
			maps.put(fileName, result);
		}
		return result;
	}
}
