package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Text;

public class TextCellEditorLocator implements CellEditorLocator {

	private Figure label;
	 
    public TextCellEditorLocator(Figure label2) {
          super();
          this.label = label2;
    }

    public void relocate(CellEditor celleditor) {
          Text text = (Text) celleditor.getControl();
          if(text == null) return;
          Rectangle constraints = label.getBounds().getCopy();
          label.getParent().translateToAbsolute(constraints);
          if(constraints != null && text.getDisplay() != null)
        	  text.setBounds(constraints.x, constraints.y + constraints.height, constraints.width, constraints.height);
    }

}
