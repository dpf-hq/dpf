import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EMFTest {
	
	/**
	 * Meta-model and instance model need to be in the same resource set, in
	 * order to use the same (!!, not only equal) types.
	 */
	private static ResourceSet resourceSet = new ResourceSetImpl();

	
	public static void main(String[] args) {
		initializeResourceFactories();
		EObject o1 = loadModel("models/original_minimal_metamodel.ecore");
		System.out.println(resourceSet.getResources());
		EObject o = loadModel("models/original_model.xmi");
		System.out.println("Test:" + o);
		Iterator i = o.eAllContents();
		while(false && i.hasNext()){
			EObject e = (EObject)i.next();
			System.out.println(i);
		}
	}
		
	
	
	
	
	
	/**
	 * Calls EvolutionRuleGenerator.initializeResourceFactories() and
	 * furthermore registeres resource factories for files with extensions
	 * "ecore" and "xmi".
	 */
	private static void initializeResourceFactories() {
		//EvolutionRuleGenerator.initializeResourceFactories();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi",
				new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore",
				new EcoreResourceFactoryImpl());
	}// initializeResourceFactories
	
	private static EObject loadModel(String fnameModel) {
		return loadModel(fnameModel, true);
	}	

	/**
	 * Loads models, if the model is already loaded, it is unload and re-loaded again.
	 * 
	 * @return
	 */
	private static EObject loadModel(String fnameModel,boolean unload) {
		
		/*
		 * Note the usage of ".getAbsolutePath()" below! This is necessary for
		 * EMF to resolve relative paths in instance models. In our case, the
		 * typing i.e. the meta-model petri.ecore is given relative to this
		 * instance models location.
		 */
		URI instanceUri = URI.createFileURI(new File(fnameModel).getAbsolutePath());
		Resource resourceInstance = resourceSet.getResource(instanceUri, true);
		
		/*
		 * The instance model is only aware of meta-model changes if it is
		 * reloaded afterwards. Accordingly, if already loaded, the instance
		 * model is unloaded and re-loaded again. Note, unloading only replaces
		 * each object with its proxy. The resource remains in the resource set
		 * and therefore can be easily reloaded.
		 */
		if (unload && resourceInstance.isLoaded()) {
			resourceInstance.unload();
			try {
				resourceInstance.load(null);
			} catch (IOException e) {
				e.printStackTrace();
			}// try catch
		}// if
		
		return resourceInstance.getContents().get(0);
	}// loadPetriInstanceModel

}