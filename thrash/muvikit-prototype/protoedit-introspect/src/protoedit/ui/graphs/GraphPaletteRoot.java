package protoedit.ui.graphs;

import org.eclipse.gef.tools.CreationTool;

import protoedit.ModelCreationFactory;
import protomodel.Clazz;
import muvitorkit.gef.palette.MuvitorPaletteRoot;

public class GraphPaletteRoot extends MuvitorPaletteRoot {
	
	public GraphPaletteRoot() {
		addToolEntry(defaultPaletteGroup, "Class", "Create class", 
				new ModelCreationFactory(Clazz.class), null, null,
				CreationTool.class);
	}
	

}
