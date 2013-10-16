package no.hib.dpf.transform.presentation;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.DPFEditorPaletteFactory;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;
import no.hib.dpf.editor.displaymodel.factories.DPFConnectionCreationToolEntry;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;

public class DPFTransformPaletteFactory extends DPFEditorPaletteFactory {

	private static final String PUBLIC = "Public";
	private PaletteGroup publicGroup = new PaletteGroup(PUBLIC);

	public PaletteRoot createPalette() {
		super.createPalette();
		if(palette != null){
			palette.add(new PaletteSeparator());
			publicGroup.add(new ActionToolEntry("Add", "set this as an add element", null, null, AddTool.class));
			publicGroup.add(new ActionToolEntry("Delete", "set this as a delete element", null, null, DeleteTool.class));
			publicGroup.add(new ActionToolEntry("Preserve", "set this as a preserve element", null, null, PreserveTool.class));
			palette.add(publicGroup);
		}
		return palette;
	}

	public void updatePalette(PaletteRoot root, DGraph sourceGraph) {
		for(DNode dnode : sourceGraph.getDNodes()){
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
			//			add Arrow:Node-->Node to tooltip in case several arrows with same name showing up in the metamodel.
			arrowGroup.add(new DPFConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->" + arrow.getTarget().getName(), new DArrowFactory(darrow), 
					SMALLARROW, LARGEARROW));
		}
	}
	public void updatePaletteForExogenous(PaletteRoot root, DGraph sourceGraph, DGraph targetGraph) {
		for(DNode dnode : sourceGraph.getDNodes()){
			Node node = dnode.getNode();
			Assert.isTrue(node != null);
			Assert.isTrue(dnode != null);
			nodeGroup.add(new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new DNodeFactory(dnode), 
					SMALLICON, LARGEICON));
		}
		for(DNode dnode : targetGraph.getDNodes()){
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
			//			add Arrow:Node-->Node to tooltip in case several arrows with same name showing up in the metamodel.
			arrowGroup.add(new DPFConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->" + arrow.getTarget().getName(), new DArrowFactory(darrow), 
					SMALLARROW, LARGEARROW));
		}
		for(DArrow darrow : targetGraph.getDArrows()){
			Arrow arrow = darrow.getArrow();
			Assert.isTrue(arrow != null);
			Assert.isTrue(darrow != null);
			//			add Arrow:Node-->Node to tooltip in case several arrows with same name showing up in the metamodel.
			arrowGroup.add(new DPFConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->" + arrow.getTarget().getName(), new DArrowFactory(darrow), 
					SMALLARROW, LARGEARROW));
		}
	}

}

