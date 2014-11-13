package no.hib.dpf.editor;


import no.hib.dpf.core.*;
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
		dSpecification = DPFUtils.createDSpecificationFromSpecification(resourceSet, modelURI, specification, null, resourceToDiagnosticMap);
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
}
