package no.hib.dpf.api;

import org.eclipse.ui.plugin.AbstractUIPlugin;

public class DPFUtilPlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "no.hib.dpf.api";

	/** Single plugin instance. */
	private static DPFUtilPlugin singleton = new DPFUtilPlugin();
	

	/**
	 * Returns the shared plugin instance.
	 */
	public static DPFUtilPlugin getDefault() {
		return singleton;
	}
}
