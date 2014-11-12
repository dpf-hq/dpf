package protoedit.ui.graphs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.part.IPage;

import protomodel.Diagram;

import muvitorkit.ui.MuvitorPageBookView;

public class GraphView extends MuvitorPageBookView {

	@Override
	protected String calculatePartName() {
		return "Diagram: " + ((Diagram) getModel()).getName();

	}

	@Override
	protected IPage createPageForModel(EObject forModel) {
		return new GraphPage(this);
	}

}
