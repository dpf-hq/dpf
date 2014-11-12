package no.hib.dpf.editor.displaymodel.factories;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;

public class DPFConnectionCreationToolEntry extends ConnectionCreationToolEntry {

	public DPFConnectionCreationToolEntry(String label, String shortDesc,
			CreationFactory factory, ImageDescriptor iconSmall,
			ImageDescriptor iconLarge) {
		super(label, shortDesc, factory, iconSmall, iconLarge);
		setToolClass(DPFConnectionCreationTool.class);
	}

}
