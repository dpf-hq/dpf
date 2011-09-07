/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;

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
public class DPFPlugin extends AbstractUIPlugin {

	/** Single plugin instance. */
	private static DPFPlugin singleton;
	
	private IStatusLineManager statusLineManager;

	/**
	 * Returns the shared plugin instance.
	 */
	public static DPFPlugin getDefault() {
		return singleton;
	}

	/**
	 * The constructor.
	 */
	public DPFPlugin() {
		if (singleton == null) {
			singleton = this;
		}
	}

	public void setStatusLineManager(IStatusLineManager statusLineManager) {
		this.statusLineManager = statusLineManager;
	}

	public IStatusLineManager getStatusLineManager() {
		return statusLineManager;
	}
	

}