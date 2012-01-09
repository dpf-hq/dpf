package no.hib.dpf.editor.policies;


import no.hib.dpf.editor.displaymodel.DArrow;
import no.hib.dpf.editor.displaymodel.DNode;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.widgets.Text;

public class TextDirectEditManager extends DirectEditManager {

	public TextDirectEditManager(GraphicalEditPart source, Class<?> editorType,
			CellEditorLocator locator) {
		super(source, editorType, locator);
	}

	@Override
	protected void initCellEditor() {
		Text text = (Text) getCellEditor().getControl();
        Object object = getEditPart().getModel();
        String name = "";
        if(object instanceof DNode)
        	name = ((DNode)object).getName();
        if(object instanceof DArrow)
        	name = ((DArrow)object).getName();
        text.setText(name);
	}

}
