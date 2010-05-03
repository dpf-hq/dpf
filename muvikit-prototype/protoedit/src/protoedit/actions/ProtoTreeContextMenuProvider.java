package protoedit.actions;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IMenuManager;

import muvitorkit.ui.ContextMenuProviderWithActionRegistry;

public class ProtoTreeContextMenuProvider extends
		ContextMenuProviderWithActionRegistry {

	public ProtoTreeContextMenuProvider(EditPartViewer viewer) {
		super(viewer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buildContextMenu(IMenuManager menu) {
		String group = GEFActionConstants.GROUP_EDIT;
		dynamicAppendActionToGroup(menu, CreateReferenceAction.ID, group);

	}

}
