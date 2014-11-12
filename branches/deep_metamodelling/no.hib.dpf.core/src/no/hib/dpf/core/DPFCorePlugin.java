package no.hib.dpf.core;


import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class DPFCorePlugin extends Plugin{
	public static final String PLUGIN_ID = "no.hib.dpf.core"; 

	/** Single plugin instance. */
	private static DPFCorePlugin INSTANCE;
	public DPFCorePlugin(){
		super();
	}
	/**
	 * This method is called upon plug-in activation.
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}
	/**
	 * This method is called when the plug-in is stopped.
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}
	
	public static DPFCorePlugin getDefault(){
		return INSTANCE;
	}
}
