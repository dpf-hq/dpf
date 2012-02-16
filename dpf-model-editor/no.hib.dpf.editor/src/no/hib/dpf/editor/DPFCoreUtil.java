package no.hib.dpf.editor;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class DPFCoreUtil {

	public static Resource getResource(ResourceSet resourceSet, URI resourceURI, Map<Resource, Diagnostic> resourceToDiagnosticMap){
		Assert.isTrue(resourceSet != null);
		Assert.isTrue(resourceToDiagnosticMap != null);
		Resource resource = null;
		try{
			resource = getResource(resourceSet, resourceURI);
		}
		catch(Exception exception){
			analyzeResourceProblems(resource, exception, resourceToDiagnosticMap);
		}
		return resource;
	}

	private static String fileError(URI uri) {
		return "Problems encountered in file " + uri.toString();
	}

	public static  void analyzeResourceProblems(Resource resource, Exception exception, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			resourceToDiagnosticMap.put(resource,  analyzeResourceProblems(resource, exception));
		}
	}
	public static  Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
		if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic =
					new BasicDiagnostic
					(Diagnostic.ERROR,
							"no.hib.dpf.editor",
							0,
							fileError(resource.getURI()),
							new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		}
		else if (exception != null) {
			return
					new BasicDiagnostic
					(Diagnostic.ERROR,
							"no.hib.dpf.editor",
							0,
							fileError(resource.getURI()),
							new Object[] { exception });
		}
		else {
			return Diagnostic.OK_INSTANCE;
		}
	}
	

	
	@SuppressWarnings("finally")
	public static Resource getResource(ResourceSet resourceSet, URI resourceURI){
		Resource resource = null;
		try {
			// Load the resource through the editing domain.
			//
			resource = resourceSet.getResource(resourceURI, true);
		}
		catch (Exception e) {
			resource = resourceSet.getResource(resourceURI, false);
			throw e;
		}
		finally{
			return resource;
		}
	}

	public static URI getFileURI(IFile file){
		return URI.createFileURI(file.getLocation().toOSString());
	}
	
	public static URI updateRelativeURI(URI oldBaseURI, URI newBaseURI, URI relative){
		return relative.resolve(oldBaseURI).deresolve(newBaseURI);
	}
}
