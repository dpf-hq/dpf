package no.hib.dpf.api.wizards.projectwizard.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class DPFPerspective implements IPerspectiveFactory {
	//Only runs the first time the perspective is used... is otherwise loaded from .metadata
	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 
				(float) 0.15, editorArea);
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 
				(float) 0.75, editorArea);
		
		left.addView(IPageLayout.ID_PROJECT_EXPLORER);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
		//Vi kan lage custom views (f.eks ein spesialisert properties explorer)
		//		bottom.addView("no.hib.dpf.projectwizard.dpfview");
	}
}
