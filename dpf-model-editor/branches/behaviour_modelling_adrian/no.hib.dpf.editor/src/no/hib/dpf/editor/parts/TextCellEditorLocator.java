package no.hib.dpf.editor.parts;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;

public class TextCellEditorLocator implements CellEditorLocator {

	private Label label;
	 
    public TextCellEditorLocator(Label label2) {
          super();
          this.label = label2;
    }

    public void relocate(CellEditor celleditor) {
          Text text = (Text) celleditor.getControl();
          if(text == null) return;
          Rectangle constraints = label.getBounds();
          if(constraints != null)
        	  text.setBounds(constraints.x, constraints.y, constraints.width, constraints.height);
    }

}
