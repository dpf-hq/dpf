package no.hib.dpf.editor.parts;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DOffset;

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
		if(text == null)
			return;
        Object object = getEditPart().getModel();
        String name = "";
        if(object instanceof DNode){
        	name = ((DNode)object).getNode().getName();
        }
        
        if(object instanceof DNodeDAttribute){
        	name = ((DNodeDAttribute)object).getNodeAttribute().getName();
        }
        
        if(object instanceof DOffset && ((DOffset)object).eContainer() instanceof DArrow){
        	name = ((DArrow)((DOffset)object).eContainer()).getArrow().getName();
        }
        
        if(object instanceof DOffset && ((DOffset)object).eContainer() instanceof DNodeDAttribute){
        	name = ((DNodeDAttribute)((DOffset)object).eContainer()).getNodeAttribute().getName();
        }
        
        if(object instanceof DOffset && ((DOffset)object).eContainer() instanceof DArrowDAttribute){
        	name = ((DArrowDAttribute)((DOffset)object).eContainer()).getArrowAttribute().getName();
        }
        
        if(name == null) name = ""; 
        text.setText(name);
	}

}
