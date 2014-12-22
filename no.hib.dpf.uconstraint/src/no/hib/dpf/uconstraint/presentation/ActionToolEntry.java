package no.hib.dpf.uconstraint.presentation;

import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;

public class ActionToolEntry extends ToolEntry {

	public ActionToolEntry(String label, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge, @SuppressWarnings("rawtypes") Class clazz) {
		super(label, shortDesc, iconSmall, iconLarge, clazz);
	}

}
