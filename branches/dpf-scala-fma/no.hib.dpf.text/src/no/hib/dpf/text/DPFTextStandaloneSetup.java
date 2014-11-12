
package no.hib.dpf.text;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DPFTextStandaloneSetup extends DPFTextStandaloneSetupGenerated{

	public static void doSetup() {
		new DPFTextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

