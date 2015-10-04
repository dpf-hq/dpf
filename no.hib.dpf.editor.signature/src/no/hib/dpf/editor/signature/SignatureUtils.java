package no.hib.dpf.editor.signature;

import java.io.IOException;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.editor.DPFUtils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class SignatureUtils extends DPFUtils{

	public static ResourceSetImpl getResourceSet(){
		ResourceSetImpl resourceSet = DPFUtils.getResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("sig", new XMIResourceFactoryImpl(){
			 @Override
			  public Resource createResource(URI uri)
			  {
			    return new XMIResourceImpl(uri){
			    	@Override
			    	  protected boolean useUUIDs()
			    	  {
			    		/*
			    		 * It should be changed to ture when elements are store based on their ids
			    		 */
			    	    return false;
			    	  }
			    };
			  }
		});
		return resourceSet;
	}
	
	public static void saveDSignature(ResourceSetImpl resourceSet, URI osString, DSignature signature2) {
		Resource signature = createResource(resourceSet, osString);
		signature.getContents().add(signature2);
		signature.getContents().add(signature2.getSignature());
		try {
			signature.save(null);
		} catch (IOException e) {
			logError(e);
		}
	}
	public static AbstractUIPlugin getPlugin() {
		return SignaturePlugin.getDefault();
	}
}
