package no.hib.dpf.text.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

public class DPFTextDocumentProvider extends XtextDocumentProvider {

	
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) 
			throws CoreException {
		Normalizer.normalize(document);
		super.doSaveDocument(monitor, element, document, overwrite);
	} 
	
}
