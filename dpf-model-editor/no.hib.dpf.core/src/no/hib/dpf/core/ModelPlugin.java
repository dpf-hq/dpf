package no.hib.dpf.core;


import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class ModelPlugin extends Plugin{
	public static final String PLUGIN_ID = "no.hib.dpf.core";

	/** Single plugin instance. */
	private static ModelPlugin INSTANCE;
	public ModelPlugin(){
		super();
	}
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
	
	public static ModelPlugin getDefault(){
		return INSTANCE;
	}
}
