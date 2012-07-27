package no.hib.dpf.text.ui.outline;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

public class TreeOutlinePage extends OutlinePage {

	private Menu contextMenu;
	private static final String contextMenuID = "DpfTextOutlineContextMenu";

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		configureContextMenu();
	}

	protected void configureContextMenu() {
		MenuManager manager = new MenuManager(contextMenuID, contextMenuID);
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		contextMenu = manager.createContextMenu(getTreeViewer().getTree());
		getTreeViewer().getTree().setMenu(contextMenu);

		IPageSite site = getSite();
		site.registerContextMenu("no.hib.dpf.text.tdpf.outline", manager, getTreeViewer()); //$NON-NLS-1$
	}

	protected void fillContextMenu(IMenuManager menu) {
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
}
