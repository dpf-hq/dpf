package no.hib.dpf.editor;


import no.hib.dpf.core.*;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.parts.DPFEditPartFactory;

import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public class DPFEditor2 extends DPFEditor {

	protected void setInput(IEditorInput input) {
		IFile file = ((IFileEditorInput) input).getFile();
		URI modelURI = URI.createFileURI(file.getLocation().toOSString());
		Specification specification = DPFUtils.loadSpecification(resourceSet, modelURI, resourceToDiagnosticMap);
		dSpecification = createDSpecificationFromSpecification(modelURI, specification, null);
		IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(dSpecification.eResource().getURI().toFileString()));
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			DPFUtils.logError(e);
		}
		setInputWithNotify(new FileEditorInput(newFile));
		paletteFactory.updatePalette(getPaletteRoot(), dSpecification.getDType().getDGraph());
		shapesEditPartFactory = new DPFEditPartFactory();
	}

	private static boolean isFileExist(URI uri){
		if(uri.isFile()){
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(uri.toFileString()));
			return file != null && file.exists();
		}
		return false;
	}
	private DSpecification createDSpecificationFromSpecification(URI modelUri, Specification specification, DSpecification dType) {
		if(dType == null && specification.getType() == DPFConstants.REFLEXIVE_SPECIFICATION)
			return createDSpecificationFromSpecification(modelUri, specification, DPFConstants.REFLEXIVE_DSPECIFICATION);
		URI diagramURI = URI.createURI(DPFUtils.getDiagramFromModel(modelUri.toString()));
		DSpecification model = null;
		if(isFileExist(diagramURI))
			model = DPFUtils.loadDSpecification(resourceSet, diagramURI, resourceToDiagnosticMap);
		if(model != null)
			return model;
		if(dType == null){
			URI typeFileAbsoluteURI = URI.createURI(specification.getMetaFile()).resolve(modelUri);
			Specification type = DPFUtils.loadSpecification(resourceSet, typeFileAbsoluteURI, resourceToDiagnosticMap);
			dType = createDSpecificationFromSpecification(typeFileAbsoluteURI, type, null);
		}
		DSpecification result = new GenerateDiagramFromModel(specification, dType).result;
		result.setMetaFile(dType.eResource().getURI().deresolve(diagramURI).toFileString());
		if(specification.eResource() != null)
			specification.eResource().getContents().clear();
		DPFUtils.saveDSpecification(this.resourceSet, result, diagramURI, resourceToDiagnosticMap);
		return result;
	}

}
