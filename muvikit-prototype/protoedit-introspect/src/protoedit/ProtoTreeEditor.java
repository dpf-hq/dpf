package protoedit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.ui.parts.TreeViewer;

import protoedit.actions.CreateClassAction;
import protoedit.actions.CreateReferenceAction;
import protoedit.actions.ProtoTreeContextMenuProvider;
import protoedit.editparts.tree.ProtoTreeEditPartFactory;
import protomodel.Clazz;
import protomodel.Diagram;
import protomodel.ProtomodelFactory;
import protomodel.ProtomodelPackage;
import protomodel.Reference;

import muvitorkit.ui.ContextMenuProviderWithActionRegistry;
import muvitorkit.ui.MuvitorTreeEditor;

public class ProtoTreeEditor extends MuvitorTreeEditor {
	public static final String GRAPH_VIEW_ID = "protoedit.ui.graphs.GraphView";
	static {
		registerViewID(ProtomodelPackage.Literals.DIAGRAM, GRAPH_VIEW_ID);
	}
	
	@Override
	protected ContextMenuProviderWithActionRegistry createContextMenuProvider(
			TreeViewer viewer) {
		return new ProtoTreeContextMenuProvider(viewer);
	}

	@Override
	protected void createCustomActions() {
		registerAction(new CreateReferenceAction(this));
		registerAction(new CreateClassAction(this));
	}

	@Override
	protected EObject createDefaultModel() {

		Clazz clazz = ProtomodelFactory.eINSTANCE.createClazz();
		clazz.setName("theclazz");
		Reference ref = ProtomodelFactory.eINSTANCE.createReference();
		ref.setName("theref");
		ref.setSource(clazz);
		ref.setDest(clazz);
		clazz.getReferences().add(ref);
		
		Clazz clazz2 = ProtomodelFactory.eINSTANCE.createClazz();
		clazz2.setName("name2");
		Reference ref2 = ProtomodelFactory.eINSTANCE.createReference();
		ref2.setName("theConnection");
		ref2.setSource(clazz);
		ref2.setDest(clazz2);
		clazz.getReferences().add(ref2);
		
		Diagram diagram = ProtomodelFactory.eINSTANCE.createDiagram();
		diagram.setName("default");
		diagram.getClasses().add(clazz);
		
		return diagram;
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
