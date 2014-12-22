/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor;

import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
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
	public static DPFPlugin INSTANCE; //= new DPFPlugin();
	public static String PLUGIN_ID = "no.hib.dpf.editor";

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