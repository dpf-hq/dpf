package no.hib.dpf.m2m.transformation.parser;

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;
import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_DSPECIFICATION;
import static no.hib.dpf.m2m.transformation.M2MConstants.META_DIAGRAM_FILE;
import static no.hib.dpf.utils.DPFConstants.DEFAULT_SIGNATURE;
import static no.hib.dpf.utils.DPFConstants.DefaultDSpecification;
import static no.hib.dpf.utils.DPFConstants.DefaultSpecification;
import static no.hib.dpf.utils.DPFConstants.REFLEXIVE_SPECIFICATION;

import java.io.IOException;
import java.util.LinkedHashMap;

import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class DPFDiagramUtil {
	
	
	public static ResourceSetImpl getResourceSet() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("dpf", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(DefaultDSpecification);
		resource.getContents().add(REFLEXIVE_DSPECIFICATION);
		resource.getContents().add(DEFAULT_DSIGNATURE);
		resourceSet.getURIResourceMap().put(DefaultDSpecification, resource);
		Resource model = resourceSet.createResource(DefaultSpecification);
		model.getContents().add(REFLEXIVE_SPECIFICATION);
		model.getContents().add(DEFAULT_SIGNATURE);
		resourceSet.getURIResourceMap().put(DefaultSpecification, model);
		return resourceSet;
	}
	
public static DSpecification loadSpecWithMetaModel(ResourceSetImpl resourceSet) {
	URI metaDiagramURI = URI.createFileURI(META_DIAGRAM_FILE);
	//URI metaDiagramURI = URI.createPlatformResourceURI(META_DIAGRAM_FILE);
	URI modelFileURI = metaDiagramURI.trimFileExtension().appendFileExtension("xmi");
	DSpecification newSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
	//ResourceSetImpl resourceSet = getResourceSet();
	Resource metaDiagram = resourceSet.createResource(metaDiagramURI);
	Resource metaModel = resourceSet.createResource(modelFileURI);
	resourceSet.getURIResourceMap().put(metaDiagramURI, metaDiagram);
	resourceSet.getURIResourceMap().put(modelFileURI, metaModel);
	DSpecification typeSpec = null;
	try {
		metaDiagram.load(null);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} finally {
		if (metaDiagram.getContents().size() == 0) {
			DSpecification result = DiagramFactory.eINSTANCE.createDefaultDSpecification();
			metaDiagram.getContents().add(result);
			metaModel.getContents().add(result.getSpecification());
			typeSpec = result;
		}else
			typeSpec = (DSpecification) metaDiagram.getContents().get(0);
	}
		EcoreUtil.resolveAll(typeSpec);
		newSpec.setDType(typeSpec != null ? typeSpec: REFLEXIVE_DSPECIFICATION);
		if(newSpec.getDSignature() == null && newSpec.getDType() != null)
			newSpec.setDSignature(newSpec.getDType().getDSignature());
		return newSpec;
	}
		
	public static void loadSMODLModel(ResourceSetImpl resourceSet,DSpecification newSpec,String dpfFile,IFile file){
		//ResourceSetImpl resourceSet = getResourceSet();
		URI diagramFileURI = URI.createFileURI(dpfFile);
		URI modelFileURI = diagramFileURI.trimFileExtension().appendFileExtension("xmi");
		Resource diagram = resourceSet.createResource(diagramFileURI);
		Resource model = resourceSet.createResource(modelFileURI);
		resourceSet.getURIResourceMap().put(diagramFileURI, diagram);
		resourceSet.getURIResourceMap().put(modelFileURI, model);
		DSpecification iter = newSpec;
		while(iter != REFLEXIVE_DSPECIFICATION){
			EcoreUtil.resolveAll(iter.getDType());
			iter = iter.getDType();
		}
		iter = newSpec;
		while(iter != REFLEXIVE_DSPECIFICATION){
			updateMetaModelReference(iter, null, diagramFileURI);
			model.getContents().add(iter.getSpecification());
			diagram.getContents().add(iter);
			if(iter.getDSignature() != null && iter.getDSignature() != DEFAULT_DSIGNATURE){
				updateSignatureReference(newSpec, diagramFileURI);
				model.getContents().add(iter.getDSignature().getSignature());
				diagram.getContents().add(iter.getDSignature());
			}
			iter = iter.getDType();
		}
		
		/*XmlParser.SmodlXMLParser(file);
		DNode node1 = newSpec.getDType().getDGraph().getDNodes().get(0);
		//DNode node = DiagramFactory.eINSTANCE.createDNode("test",node1 );
		DNode node = DiagramFactory.eINSTANCE.createDefaultDNode();
		node.setDType(node1);
		Point p1 = new Point(100,100);
		node.setLocation(p1);
		newSpec.getDGraph().addDNode(node);
		try {
			model.save(null);
			diagram.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
	}
	
	
	public static void saveDSpecification(ResourceSetImpl resourceSet,String dpfFile) {
		//ResourceSetImpl resourceSet = getResourceSet();
		Assert.isNotNull(resourceSet);
		URI diagramFileURI = URI.createFileURI(dpfFile);
		URI modelFileURI = diagramFileURI.trimFileExtension().appendFileExtension("xmi");//getModelURI(createFileURI);
		Resource diagram = resourceSet.getResource(diagramFileURI, false);
		Resource model = resourceSet.getResource(modelFileURI, false);
		Assert.isTrue(diagram != null && model != null);
		try {
			diagram.save(null);
			model.save(null);
		} catch (IOException e) {
			//DPFCoreUtil.analyzeResourceProblems(diagram, e, resourceToDiagnosticMap);
			//DPFErrorReport.logError(e);
			System.out.println(e);
		}

	}
	
	public static String getModelFromDiagram(String filename) {
		int index = filename.lastIndexOf(".dpf");
		if(index == -1)
			return filename + ".xmi";
		return filename.substring(0, index) + ".xmi";
	}
	public static void updateMetaModelReference(DSpecification iter, URI oldBase, URI createFileURI){
		if(oldBase == null){
			DSpecification typeSpec = iter.getDType();
			if(typeSpec != null && typeSpec != REFLEXIVE_DSPECIFICATION){
				String relative = typeSpec.eResource().getURI().deresolve(createFileURI).toFileString();
				//URI typeSpecURI = typeSpec.eResource().getURI();
				iter.setMetaFile(relative);
				iter.getSpecification().setMetaFile(getModelFromDiagram(relative));
			}
			DSignature signature = iter.getDSignature();
			if(signature != null){
				String relative = "";
				DSpecification type = iter.getDType();
				if(type != null && type.getDSignature() == signature)
					relative = type.getSignatureFile();
				else
					relative = signature.eResource().getURI().deresolve(createFileURI).toFileString();
				iter.setSignatureFile(relative);
				iter.getSpecification().setSignatureFile(relative);
			}
			return;
		}
		if(iter.getMetaFile() != null && !iter.getMetaFile().isEmpty()){
			String newMetaFile = DPFCoreUtil.updateRelativeURI(oldBase, createFileURI, URI.createFileURI(iter.getMetaFile())).toFileString();
			iter.setMetaFile(newMetaFile);
			iter.getSpecification().setMetaFile(getModelFromDiagram(newMetaFile));
		}
		if(iter.getSignatureFile() != null && !iter.getSignatureFile().isEmpty()){
			String newSignatureFile = DPFCoreUtil.updateRelativeURI(oldBase, createFileURI, URI.createFileURI(iter.getSignatureFile())).toFileString();
			iter.setSignatureFile(newSignatureFile);
			iter.getSpecification().setSignatureFile(newSignatureFile);
		}
	}
	
	private static void updateSignatureReference(DSpecification iter, URI newBase){
		DSignature dSignature = iter.getDSignature();
		if(dSignature != null){
			URI oldBase = dSignature.eResource().getURI();
			for(DPredicate predicate : dSignature.getDPredicates()){
				String icon = predicate.getIcon();
				if(icon != null && !icon.isEmpty())
					predicate.setIcon(DPFCoreUtil.updateRelativeURI(oldBase, newBase, URI.createFileURI(predicate.getIcon())).toFileString());
			}
		}
	}


	
}
