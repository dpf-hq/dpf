package no.hib.dpf.editor;

import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;

public class ShowConstraintToolEntry extends ToolEntry {
private static ImageDescriptor SHOW_SMALL_ICON = ImageDescriptor
.createFromURL(DPFPlugin.getDefault().getBundle().getResource("icons/showconstraint_16.png")),
SHOW_LARGE_ICON = ImageDescriptor
.createFromURL(DPFPlugin.getDefault().getBundle().getResource("icons/showconstraint_24.png")),
HIDE_SMALL_ICON = ImageDescriptor
.createFromURL(DPFPlugin.getDefault().getBundle().getResource("icons/hide_16.png")),
HIDE_LARGE_ICON = ImageDescriptor
.createFromURL(DPFPlugin.getDefault().getBundle().getResource("icons/hide_24.png"));

	public ShowConstraintToolEntry() {
		super("Show Constraint", "Show or hide constraints", 
				ImageDescriptor
				.createFromURL(DPFPlugin.getDefault().getBundle().getResource("icons/showconstraint_16.png")),
				ImageDescriptor.createFromFile(ShowConstraintToolEntry.class, "icons/showconstraint_24.png"));
	}

	public void changeIcon(boolean constraintVisible) {
		setSmallIcon(!constraintVisible ? SHOW_SMALL_ICON : HIDE_SMALL_ICON);
		setLargeIcon(!constraintVisible ? SHOW_LARGE_ICON : HIDE_LARGE_ICON);
		
	}

}
