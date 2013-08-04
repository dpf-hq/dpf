package no.hib.dpf.transform.presentation;

import no.hib.dpf.editor.DPFEditorPaletteFactory;

import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.jface.action.Separator;

public class DPFTransformPaletteFactory extends DPFEditorPaletteFactory {

	private static final String PUBLIC = "Public";
	private PaletteGroup publicGroup = new PaletteGroup(PUBLIC);
	public PaletteRoot createPalette() {
		PaletteRoot root = super.createPalette();
		if(root != null){
			root.add(new PaletteSeparator());
			publicGroup.add(new ActionToolEntry("Add", "set this as an add element", null, null, AddTool.class));
			publicGroup.add(new ActionToolEntry("Delete", "set this as a delete element", null, null, DeleteTool.class));
			publicGroup.add(new ActionToolEntry("Preserve", "set this as a preserve element", null, null, PreserveTool.class));
			//publicGroup.add(new ActionToolEntry("Generate Henshin", "Translates to Henshin rules", null, null, TranslateHenshin.class));
			root.add(publicGroup);
		}
		return root;
	}
}
