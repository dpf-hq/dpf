package no.hib.dpf.transform.presentation;

import no.hib.dpf.core.Graph;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.verify.TranslateToAlloy;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class TranslateToAlloyHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil .getActiveWorkbenchWindowChecked(event);
		if (window == null)
			return null;
		
		IWorkbenchPage page = window.getActivePage();
		if (page == null)
			return null;
		
		IEditorPart editor = page.getActiveEditor();
		if(editor instanceof TransformEditor){
			TransformEditor transformEditor = (TransformEditor) editor;
			Transform transform = transformEditor.getTransform();
			DSpecification specification = transform.getElementTypeGraph();
			Graph graph = specification.getDGraph().getGraph();
			String src = TranslateToAlloy.translateNodes(graph, true) + TranslateToAlloy.translateEdges(graph, true);
			String trg = TranslateToAlloy.translateNodes(graph, false) + TranslateToAlloy.translateEdges(graph, false);
			for(Production iter : transform.getRules()){
				StringBuffer buffer = new StringBuffer();
				buffer.append(src);
				buffer.append(trg);
				buffer.append(TranslateToAlloy.translate(iter, specification.getDGraph()));
				System.out.println(buffer.toString());
				break;
			}
		}
		return null;
	}

}
