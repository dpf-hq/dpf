package protoedit.ui.graphs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.KeyHandler;

import muvitorkit.gef.palette.MuvitorPaletteRoot;
import muvitorkit.ui.ContextMenuProviderWithActionRegistry;
import muvitorkit.ui.MuvitorPage;
import muvitorkit.ui.MuvitorPageBookView;

public class GraphPage extends MuvitorPage {

	public GraphPage(MuvitorPageBookView view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ContextMenuProviderWithActionRegistry createContextMenuProvider(
			EditPartViewer viewer) {
		return new GraphContextMenuProvider(viewer);
	}

	@Override
	protected void createCustomActions() {
		// TODO Auto-generated method stub

	}

	@Override
	protected EditPartFactory createEditPartFactory() {
		return new GraphEditPartFactory();
	}

	@Override
	protected MuvitorPaletteRoot createPaletteRoot() {
		return new GraphPaletteRoot();
	}

	@Override
	protected EObject[] getViewerContents() {
		return new EObject[] { getModel() };
	}

	@Override
	protected void setupKeyHandler(KeyHandler kh) {
		// TODO Auto-generated method stub

	}

}
