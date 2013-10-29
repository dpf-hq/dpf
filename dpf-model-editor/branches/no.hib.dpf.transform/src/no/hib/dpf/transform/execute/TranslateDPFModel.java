package no.hib.dpf.transform.execute;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.DPFUtils;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

@SuppressWarnings("unused")
public class TranslateDPFModel {
	
	private HenshinResourceSet resourceSet = null;
	private List<EObject> matches = null;
	private Rule currentRule = null;
	private URI dSpecificationURI = null;
	private URI specificationURI = null;
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();
	
	private Specification specification = null;
	private DSpecification dSpecification = null;
	
	private Graph graph = null;
	private DGraph dGraph = null;
	
	private boolean save = false;
	
//	public TranslateDPFModel(List<EObject> list, Rule rule, URI model, 
//			Specification specification, DSpecification dSpec, boolean save, HenshinResourceSet resourceSet){
	public TranslateDPFModel(){

	}
	
	public void executeChanges(){
		
		Specification spec = DPFUtils.loadSpecification(URI.createFileURI("C:/Users/Petter/runtime-EclipseApplication/Activity2PetriNet_old/PetriNet/targetModelInstance.xmi"));
		
		DSpecification dspec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		dspec.setDGraph(DiagramFactory.eINSTANCE.createDefaultDGraph());

		dspec.setSpecification(spec);
		dspec.setDSignature(DiagramFactory.eINSTANCE.createDefaultDSignature());
	
	
		File file = new File("C:/Users/Petter/runtime-EclipseApplication/Activity2PetriNet_old/PetriNet/targetModelInstance.dpf");
		if(file.exists()){
			file.delete();
		}
		DPFUtils.saveDSpecification(DPFUtils.getResourceSet(), 
				dspec, URI.createFileURI("C:/Users/Petter/runtime-EclipseApplication/Activity2PetriNet_old/PetriNet/targetModelInstance.dpf"), resourceToDiagnosticMap);
	}
}
