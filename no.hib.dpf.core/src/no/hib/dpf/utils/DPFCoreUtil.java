package no.hib.dpf.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.DPFCorePlugin;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;


public class DPFCoreUtil {

	public static Resource createResource(ResourceSetImpl resourceSet, URI resourceURI) {
		Resource resource = null;
		resource = resourceSet.getResource(resourceURI, false);
		if(resource == null && !resourceURI.isEmpty()) {
			resource = resourceSet.createResource(resourceURI);
			resourceSet.getURIResourceMap().put(resourceURI, resource);
		}
		return resource;
	}

	
	public static Resource createResource(ResourceSet resourceSet, URI resourceURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Exception exception = null;
		Resource resource = null;
		try {
			resource = resourceSet.getResource(resourceURI, true);
		}
		catch (Exception e) {
			exception = e;
			resource = resourceSet.getResource(resourceURI, false);
		}
		analyzeResourceProblems(resource, exception, resourceToDiagnosticMap);
		return resource;
	}
	
	public static Diagnostic analyzeResourceProblems(Resource resource, Exception exception, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		BasicDiagnostic basicDiagnostic = null;
		if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
			basicDiagnostic =
					new BasicDiagnostic
					(Diagnostic.ERROR,
							getPluginID(),
							0,
							getErrorMessage(resource),
							new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
		}
		else if (exception != null) {
			basicDiagnostic =
					new BasicDiagnostic
					(Diagnostic.ERROR,
							getPluginID(),
							0,
							getErrorMessage(resource),
							new Object[] { exception });
		}
		else {
			return Diagnostic.OK_INSTANCE;
		}
		if (basicDiagnostic.getSeverity() != Diagnostic.OK) {
			resourceToDiagnosticMap.put(resource,  basicDiagnostic);
		}else
			resourceToDiagnosticMap.remove(resource);
		return basicDiagnostic;
	}
	
	
	protected static String getErrorMessage(Resource resource) {return "Problems encountered in file " + resource.getURI().toFileString();};

	public static ResourceSetImpl getResourceSet(){
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl(){
			 @Override
			  public Resource createResource(URI uri)
			  {
			    return new XMIResourceImpl(uri){
			    	@Override
			    	  protected boolean useUUIDs()
			    	  {
			    	    return true;
			    	  }
			    };
			  }
		});

		Resource defaultSpecification = resourceSet.createResource(DPFConstants.DefaultSpecification);
		defaultSpecification.getContents().add(DPFConstants.REFLEXIVE_SPECIFICATION);
		defaultSpecification.getContents().add(DPFConstants.DEFAULT_SIGNATURE);
		resourceSet.getURIResourceMap().put(DPFConstants.DefaultSpecification, defaultSpecification);
		return resourceSet;
	}

	public static Specification loadSpecification(ResourceSetImpl resourceSet, URI modelFileURI){
		Resource model = createResource(resourceSet, modelFileURI);
		Object result = getObjectFromResource(model);
		if(result instanceof Specification)
			return (Specification) result;
		return null;
	}

	public static Object getObjectFromResource(Resource resource){
		if(resource == null) return null;
		try {
			resource.load(null);
		} catch (IOException e) {
			logError(e);
		}
		if(resource.getContents().isEmpty()) return null;
		return resource.getContents().get(0);
	}

	public static Specification loadSpecification(URI modelFileURI){
		return loadSpecification(getResourceSet(), modelFileURI);
	}


	/**To save a model. Since we offer no function to update a model when the metamodel is changed, 
	 * we simply store all the metamodels in the same file.
	 * @param resourceSet : the resourceSet
	 * @param modelFileURI : file location
	 * @param specification : the model
	 * @param resourceToDiagnosticMap : used as analyzing exception shown up during saving
	 */
	public static void saveSpecification(ResourceSetImpl resourceSet,URI modelFileURI, Specification specification){
		Resource model = createResource(resourceSet, modelFileURI);
		Assert.isNotNull(model);
		EcoreUtil.resolveAll(specification.getType().eResource());
		Specification iter = specification;	
		while(iter != DPFConstants.REFLEXIVE_SPECIFICATION){
			model.getContents().add(iter);
			iter = iter.getType();
		}
		iter = specification;
		while(iter != DPFConstants.REFLEXIVE_SPECIFICATION){
			if(iter.getSignature() != DPFConstants.DEFAULT_SIGNATURE)
				model.getContents().add(iter.getSignature());
			iter = iter.getType();
		}
		try {
			model.save(null);
		} catch (IOException e) {
			logError(e);
		} 
	}
	public static void saveSpecification(URI modelFileURI, Specification specification){
		saveSpecification(getResourceSet(), modelFileURI, specification);
	}

	/** 
	 * This is a temporary method which should be replaced by loadSpecification.
	 * As it is desirable for clients to handle an eventual IOException in its own 
	 * manner, this method is provided.
	 * 
	 * @param uri
	 * 		{@link URI} to the DPF models xmi file
	 * @throws {@link IOException} 		
	 * @return a {@link Specification} object that contains the given model
	 */
	public static Specification loadSpecification2(URI uri) throws IOException {
		Resource model = createResource(getResourceSet(), uri);
		Assert.isNotNull(model);
		Specification dsp = null;
		try {
			model.load(null);
			if(!model.getContents().isEmpty()){
				Object first = model.getContents().get(0);
				if(first instanceof Specification)
					dsp = (Specification) first;
			}
		} catch (IOException e) {
			throw new IOException(e);
		} 
		return dsp;
	}
	/**Find the elements which are constrained by the constraint and related to the node. 
	 * Right now, we assume that the arity is a connected graph.
	 * @param node
	 * @param constraint {@link Constraint}: the constraint
	 * @param nodes : the constrained nodes
	 * @param arrows : the constrained arrows
	 */
	public static void findRelatedElements(Node node, Constraint constraint,
			EList<Node> nodes, EList<Arrow> arrows) {
		List<Node> visit = new ArrayList<Node>();
		visit.add(node);
		while(!visit.isEmpty()){
			Node cur = visit.get(0);
			for (Arrow arrow : cur.getOutgoings()){
				if(constraint.getArrows().contains(arrow.getTypeArrow())){
					Node target = arrow.getTarget();
					if(target != null){
						if(!arrows.contains(arrow)) arrows.add(arrow);
						if(!nodes.contains(target) && !visit.contains(target)) visit.add(target);
					}

				}
			}
			for (Arrow arrow : cur.getIncomings()){
				if(constraint.getArrows().contains(arrow.getTypeArrow())){
					Node source = arrow.getSource();
					if(source != null){
						if(!arrows.contains(arrow)) arrows.add(arrow);
						if(!nodes.contains(source) && !visit.contains(source)) visit.add(source);
					}

				}
			}
			nodes.add(cur);
			visit.remove(0);
		}
	}

	public static Plugin getPlugin(){return DPFCorePlugin.getDefault();};
	public static String getPluginID(){return getPlugin().getBundle().getSymbolicName();};

	public  static void logInfo(String message) {
		log(IStatus.INFO, IStatus.OK, message, null);
	}
	public  static void logError(Throwable exception) {
		logError("Unexpected Exception", exception);
	}
	public static  IStatus createStatus(int severity, int code,
			String message, Throwable exception) {
		return new Status(severity, getPluginID(), code,
				message, exception);
	}
	public  static void log(IStatus status) {
		getPlugin().getLog().log(status);
	}
	public  static void log(int severity, int code, String message, Throwable exception) {
		log(createStatus(severity, code, message, exception));
	}
	public static void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getPlugin().getLog().log( new Status(IStatus.ERROR, getPluginID(), IStatus.OK, error, throwable));
		debug(error, throwable);
	}

	private static void debug(String message, Throwable throwable) {
		if (!getPlugin().isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}
}
