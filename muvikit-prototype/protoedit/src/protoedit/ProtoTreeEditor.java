package protoedit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.ui.parts.TreeViewer;

import protoedit.actions.ProtoTreeContextMenuProvider;
import protoedit.editparts.tree.ProtoTreeEditPartFactory;
import protomodel.Clazz;
import protomodel.Diagram;
import protomodel.ProtomodelFactory;
import protomodel.Reference;

import muvitorkit.ui.ContextMenuProviderWithActionRegistry;
import muvitorkit.ui.MuvitorTreeEditor;

public class ProtoTreeEditor extends MuvitorTreeEditor {

	@Override
	protected ContextMenuProviderWithActionRegistry createContextMenuProvider(
			TreeViewer viewer) {
		return new ProtoTreeContextMenuProvider(viewer);
	}

	@Override
	protected void createCustomActions() {
		// TODO Auto-generated method stub

	}

	@Override
	protected EObject createDefaultModel() {
		/*Diagram diagram = ProtomodelFactory.eINSTANCE.createDiagram();
		diagram.setName("default");*/
		Clazz clazz = ProtomodelFactory.eINSTANCE.createClazz();
		clazz.setName("theclazz");
		Reference ref = ProtomodelFactory.eINSTANCE.createReference();
		ref.setName("theref");
		ref.setSource(clazz);
		ref.setDest(clazz);
		clazz.getReferences().add(ref);
		
		return clazz;
	}

	@Override
	protected EditPartFactory createTreeEditPartFactory() {
		return new ProtoTreeEditPartFactory();
	}

	@Override
	protected void setupKeyHandler(KeyHandler arg0) {
		// TODO Auto-generated method stub

	}

}
