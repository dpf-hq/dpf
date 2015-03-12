package no.hib.dpf.uconstraint.presentation;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DFakeNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.DPFEditorPaletteFactory;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;

public class DPFConstraintsPaletteFactory extends DPFEditorPaletteFactory {

	private static final String PUBLIC = "Public";
	private PaletteGroup publicGroup = new PaletteGroup(PUBLIC);

	public PaletteRoot createPalette() {
		super.createPalette();
		if(palette != null){
			publicGroup.add(new ActionToolEntry("Left", "set this as a left element", null, null, PreserveTool.class));
			publicGroup.add(new ActionToolEntry("Right", "set this as a right element", null, null, AddTool.class));
			publicGroup.add(new ActionToolEntry("NAC", "set this as a nac element", null, null, DeleteTool.class));
			palette.add(publicGroup);
		}
		return palette;
	}

	public void updatePalette(PaletteRoot root, DGraph sourceGraph) {
		for(DNode dnode : sourceGraph.getDNodes()){
			if(dnode instanceof DConstraintNode || dnode instanceof DFakeNode) continue;
			Node node = dnode.getNode();
			Assert.isTrue(node != null);
			Assert.isTrue(dnode != null);
			nodeGroup.add(new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new DNodeFactory(dnode), 
					SMALLICON, LARGEICON));
		}
		for(DArrow darrow : sourceGraph.getDArrows()){
			Arrow arrow = darrow.getArrow();
			Assert.isTrue(arrow != null);
			Assert.isTrue(darrow != null);
			arrowGroup.add(new ConnectionCreationToolEntry(arrow.getName(), 
					"Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->" + arrow.getTarget().getName(), new DArrowFactory(darrow), 
					SMALLARROW, LARGEARROW));
		}
	}

}

