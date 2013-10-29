package no.hib.dpf.editor.actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import no.hib.dpf.core.Graph;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.verify.TranslateToAlloy;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public class TranslateAlloyAction implements IEditorActionDelegate {
	DPFEditor editor = null;
	public TranslateAlloyAction() {
		
	}

	@Override
	public void run(IAction action) {
		final GraphicalViewer graphicalViewer = (GraphicalViewer) editor.getAdapter(GraphicalViewer.class); // get it from your editor
		if(graphicalViewer == null) return;
		DGraph dGraph = (DGraph) graphicalViewer.getContents().getModel();
		if(dGraph != null){
			Graph graph = dGraph.getGraph();
			final String saveLocation = ((IFileEditorInput)editor.getEditorInput()).getFile().getLocation().toOSString() + ".als";
			try {
				File file = new File(saveLocation);
				if(!file.exists())
					file.createNewFile();
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(TranslateToAlloy.translateNodes(graph, true));
				fileWriter.write(TranslateToAlloy.translateNodes(graph, false));
				fileWriter.write(TranslateToAlloy.translateEdges(graph, true));
				fileWriter.write(TranslateToAlloy.translateEdges(graph, false));
				fileWriter.write("run {}");
				fileWriter.close();
				((IFileEditorInput)editor.getEditorInput()).getFile().getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (IOException | CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if(targetEditor == editor)
			return;
		if(targetEditor instanceof DPFEditor){
			editor = (DPFEditor) targetEditor;
			action.setEnabled(true);
		}else{
			editor = null;
			action.setEnabled(false);
		}
	}

}
