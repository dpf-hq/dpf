package no.hib.dpf.visualization.part;
 
import no.hib.dpf.core.Node;
import no.hib.dpf.editor.parts.TextDirectEditManager;
import no.hib.dpf.visualization.VCompartmentElement;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.swt.widgets.Text;

public class VTextDirectEditManager extends TextDirectEditManager {

	public VTextDirectEditManager(GraphicalEditPart source, Class<?> editorType, CellEditorLocator locator) {
		super(source, editorType, locator);
	}

	@Override
	protected void initCellEditor() {
		super.initCellEditor();
		Text text = (Text) getCellEditor().getControl();
		if(text == null || !text.getText().equals("")){
			return;
		}
        Object object = getEditPart().getModel();
        String name = "";
        if(object instanceof VCompartmentElement){
        	Node node = ((VCompartmentElement)object).getDNode().getNode();
        //	name = NodeAttributeUtils.getNodeAttributeData(node, ClassDiagramNodeAttributeConstants.DEFAULT_NAME)[DataNode.DATAVALUE];
        	name = node.getName();
        }
        
        if(name == null) name = ""; 
        text.setText(name);
	}

}
