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
import no.hib.dpf.editor.extension_points.FigureConfigureManager;
import no.hib.dpf.editor.icons.ImageSettings;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;

public class DPFTransformPaletteFactory  {

	private static final String PUBLIC = "Public";
	private PaletteGroup publicGroup = new PaletteGroup(PUBLIC);
	
	private static final String ARROWS = "Arrows";
	private static final String NODES = "Nodes";

	public final static ImageDescriptor LARGEARROW = ImageSettings.LARGE_CONNECTION.getImageDescriptor();
	public static final ImageDescriptor LARGEICON = ImageSettings.LARGE_RECTANGLE.getImageDescriptor();
	public final static ImageDescriptor SMALLARROW = ImageSettings.SMALL_CONNECTION.getImageDescriptor();
	public static final ImageDescriptor SMALLICON = ImageSettings.SMALL_RECTANGLE.getImageDescriptor();
	
	private PaletteGroup arrowGroup = new PaletteGroup(ARROWS);
	private PaletteGroup nodeGroup = new PaletteGroup(NODES);
	private PaletteRoot palette;
	
	public PaletteRoot createPalette() {
		palette = new PaletteRoot();
		palette.add(createToolsGroup(palette));
		palette.add(arrowGroup);
		palette.add(new PaletteSeparator());
		palette.add(nodeGroup);
	
		if(palette!=null){
				palette.add(new PaletteSeparator());
				publicGroup.add(new ActionToolEntry("Add", "set this as an add element", null, null, AddTool.class));
				publicGroup.add(new ActionToolEntry("Delete", "set this as a delete element", null, null, DeleteTool.class));
				publicGroup.add(new ActionToolEntry("Preserve", "set this as a preserve element", null, null, PreserveTool.class));
				palette.add(publicGroup);
		}
		return palette;
	}
	/** Create the "Tools" group. */
	private PaletteContainer createToolsGroup(PaletteRoot palette) {
		PaletteToolbar toolbar = new PaletteToolbar("Tools");

		// Add a selection tool to the group
		ToolEntry tool = new PanningSelectionToolEntry();
		toolbar.add(tool);
		palette.setDefaultEntry(tool);

		// Add a marquee tool to the group
		MarqueeToolEntry mqtool = new MarqueeToolEntry();
		mqtool.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR,
				MarqueeSelectionTool.BEHAVIOR_NODES_CONTAINED_AND_RELATED_CONNECTIONS);
		toolbar.add(mqtool);

		return toolbar;
	}

	public void updatePalette(PaletteRoot root, DGraph sourceGraph) {
		for(DNode dnode : sourceGraph.getDNodes()){
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(dnode.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Node node = dnode.getNode();
			Assert.isTrue(node != null);
			Assert.isTrue(dnode != null);
			nodeGroup.add(new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new DNodeFactory(dnode), 
					smallIcon != null ? smallIcon : SMALLICON, 
							largeIcon != null ? largeIcon : LARGEICON));
		}
		for(DArrow darrow : sourceGraph.getDArrows()){
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(darrow.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Arrow arrow = darrow.getArrow();
			Assert.isTrue(arrow != null);
			Assert.isTrue(darrow != null);
//			add Arrow:Node-->Node to tooltip in case several arrows with same name showing up in the metamodel.
			arrowGroup.add(new DPFConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->" + arrow.getTarget().getName(), new DArrowFactory(darrow), 
					smallIcon != null ? smallIcon : SMALLARROW, 
							largeIcon != null ? largeIcon : LARGEARROW));
		}
	}
	public void updatePaletteForExogenous(PaletteRoot root, DGraph sourceGraph, DGraph targetGraph) {
		for(DNode dnode : sourceGraph.getDNodes()){
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(dnode.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Node node = dnode.getNode();
			Assert.isTrue(node != null);
			Assert.isTrue(dnode != null);
			nodeGroup.add(new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new DNodeFactory(dnode), 
					smallIcon != null ? smallIcon : SMALLICON, 
							largeIcon != null ? largeIcon : LARGEICON));
		}
		for(DNode dnode : targetGraph.getDNodes()){
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(dnode.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Node node = dnode.getNode();
			Assert.isTrue(node != null);
			Assert.isTrue(dnode != null);
			nodeGroup.add(new CreationToolEntry(node.getName(), "Create a new " + node.getName(), new DNodeFactory(dnode), 
					smallIcon != null ? smallIcon : SMALLICON, 
							largeIcon != null ? largeIcon : LARGEICON));
		}
		for(DArrow darrow : sourceGraph.getDArrows()){
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(darrow.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Arrow arrow = darrow.getArrow();
			Assert.isTrue(arrow != null);
			Assert.isTrue(darrow != null);
//			add Arrow:Node-->Node to tooltip in case several arrows with same name showing up in the metamodel.
			arrowGroup.add(new DPFConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->" + arrow.getTarget().getName(), new DArrowFactory(darrow), 
					smallIcon != null ? smallIcon : SMALLARROW, 
							largeIcon != null ? largeIcon : LARGEARROW));
		}
		for(DArrow darrow : targetGraph.getDArrows()){
			IConfigurationElement configure = FigureConfigureManager.getInstance().getConfigurationElement(darrow.getConfigureString());
			ImageDescriptor smallIcon = configure == null ? null : FigureConfigureManager.getSmallIcon(configure);
			ImageDescriptor largeIcon = configure == null ? null : FigureConfigureManager.getLargeIcon(configure);
			Arrow arrow = darrow.getArrow();
			Assert.isTrue(arrow != null);
			Assert.isTrue(darrow != null);
//			add Arrow:Node-->Node to tooltip in case several arrows with same name showing up in the metamodel.
			arrowGroup.add(new DPFConnectionCreationToolEntry(arrow.getName(), "Create a new " + arrow.getName() + ":" + arrow.getSource().getName() + "-->" + arrow.getTarget().getName(), new DArrowFactory(darrow), 
					smallIcon != null ? smallIcon : SMALLARROW, 
							largeIcon != null ? largeIcon : LARGEARROW));
		}
	}
	
}

