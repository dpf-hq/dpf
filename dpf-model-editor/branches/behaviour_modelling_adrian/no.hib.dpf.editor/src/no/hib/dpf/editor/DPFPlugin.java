/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The plugin class (singleton).
 * <p>
 * This instance can be shared between all extensions in the plugin. Information
 * shared between extensions can be persisted by using the PreferenceStore.
 * </p>
 * 
 * @see org.eclipse.ui.plugin.AbstractUIPlugin#getPreferenceStore()
 * @author Elias Volanakis
 */
public final class DPFPlugin extends AbstractUIPlugin {

	/** Single plugin instance. */
	private static DPFPlugin INSTANCE;
	public DPFPlugin(){
		super();
	}
	public static String PLUGIN_ID = "no.hib.dpf.editor";

	private IStatusLineManager statusLineManager = null;

	public void setStatusLineManager(IStatusLineManager statusLineManager) {
		this.statusLineManager = statusLineManager;
	}

	public IStatusLineManager getStatusLineManager() {
		return statusLineManager;
	}

//	public static final String DEFAULT_MODEL_EXTENSION = ".xmi";
//	public static final String DEFAULT_DIAGRAM_MODEL_EXTENSION = ".dpf";
//
//	//dpf name to xmi name
//	public static String getModelFromDiagram(String diagram){
//		return diagram + DPFPlugin.DEFAULT_MODEL_EXTENSION;
//	}
//	//xmi name to dpf name
//	public static String getDiagramFromModel(String model){
//		return model.substring(0, model.indexOf(DPFPlugin.DEFAULT_MODEL_EXTENSION));
//	}

	/**
	 * This method is called upon plug-in activation.
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}
	/**
	 * This method is called when the plug-in is stopped.
	 */
	public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}
	
	public static DPFPlugin getDefault(){
		return INSTANCE;
	}
}