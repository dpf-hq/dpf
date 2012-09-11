package no.hib.dpf.transform.presentation;

import no.hib.dpf.editor.DPFEditorPaletteFactory;

import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;

public class DPFTransformPaletteFactory extends DPFEditorPaletteFactory {

	private static final String PUBLIC = "Public";
	private PaletteGroup publicGroup = new PaletteGroup(PUBLIC);
	public PaletteRoot createPalette() {
		PaletteRoot root = super.createPalette();
		if(root != null){
			publicGroup.add(new ActionToolEntry("Add", "set this as an add element", null, null, AddTool.class));
			publicGroup.add(new ActionToolEntry("Delete", "set this as a delete element", null, null, DeleteTool.class));
			root.add(publicGroup);
		}
		return root;
	}
}
