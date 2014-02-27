package no.hib.dpf.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.DPFCorePlugin;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class DPFCoreUtil {

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
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		Resource defaultSpecification = resourceSet.createResource(DPFConstants.DefaultSpecification);
		defaultSpecification.getContents().add(DPFConstants.REFLEXIVE_SPECIFICATION);
		defaultSpecification.getContents().add(DPFConstants.DEFAULT_SIGNATURE);
		resourceSet.getURIResourceMap().put(DPFConstants.DefaultSpecification, defaultSpecification);
		return resourceSet;
	}
	
	public static Specification loadSpecification(ResourceSetImpl resourceSet, URI modelFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap){
		Resource model = createResource(resourceSet, modelFileURI, resourceToDiagnosticMap);
		Object result = getObjectFromResource(model);
		if(result instanceof Specification)
			return (Specification) result;
		return null;
	}
	public static Object getObjectFromResource(Resource resource){
		if(resource == null) return null;
		if(resource.getContents().isEmpty()) return null;
		return resource.getContents().get(0);
	}
	public static Specification loadSpecification(URI modelFileURI){
		return loadSpecification(getResourceSet(), modelFileURI, new LinkedHashMap<Resource, Diagnostic>());
	}
	
	
	/**To save a model. Since we offer no function to update a model when the metamodel is changed, 
	 * we simply store all the metamodels in the same file.
	 * @param resourceSet : the resourceSet
	 * @param modelFileURI : file location
	 * @param specification : the model
	 * @param resourceToDiagnosticMap : used as analyzing exception shown up during saving
	 */
	public static void saveSpecification(ResourceSetImpl resourceSet,URI modelFileURI, Specification specification, Map<Resource, Diagnostic> resourceToDiagnosticMap){
		Resource model = createResource(resourceSet, modelFileURI, resourceToDiagnosticMap);
		Assert.isNotNull(model);
		EcoreUtil.resolveAll(specification.getType().eResource());
		Specification iter = specification;	
		for(Constraint constraint : iter.getConstraints()){
			System.out.println(constraint.getPredicate().eContainer().eContents().size());
			break;
		}
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
			analyzeResourceProblems(model, e, new LinkedHashMap<Resource, Diagnostic>());
		} 
	}
	public static void saveSpecification(URI modelFileURI, Specification specification){
		saveSpecification(getResourceSet(), modelFileURI, specification, new LinkedHashMap<Resource, Diagnostic>());
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
		Resource model = createResource(getResourceSet(), uri, new HashMap<Resource, Diagnostic>());
		Assert.isNotNull(model);
		Specification dsp = null;
		try {
			model.load(null);
		} catch (IOException e) {
			analyzeResourceProblems(model, e, new HashMap<Resource, Diagnostic>());
			throw new IOException(e);
		} 
		return dsp;
	}
	/**Find the elements which are constrained by the constraint and related to the node. 
	 * Right now, we assume that the arity is a connected graph.
	 * @param node
	 * @param constraint {@link Constraint}: the constraint
	 * @param graph
	 * @param nodes : the constrained nodes
	 * @param arrows : the constrained arrows
	 */
	public static void findRelatedElements(Node node, Constraint constraint, Graph graph,
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
	public static String getPluginID(){return DPFCorePlugin.PLUGIN_ID;};
	public  static void logInfo(String message) {
		log(IStatus.INFO, IStatus.OK, message, null);
	}
	public  static void logError(Throwable exception) {
		logError("Unexpected Exception", exception);
	}
	public  static void logError(String message, Throwable exception) {
		log(IStatus.ERROR, IStatus.OK, message, exception);
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
}
