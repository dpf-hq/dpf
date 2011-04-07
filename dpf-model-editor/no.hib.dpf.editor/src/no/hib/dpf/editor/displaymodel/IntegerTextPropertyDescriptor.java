package no.hib.dpf.editor.displaymodel;

import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

/**
 * Extracted from Shape. Validates integer properties.
 * @author oyvind
 *
 */
public class IntegerTextPropertyDescriptor extends TextPropertyDescriptor {
	
	public IntegerTextPropertyDescriptor(Object id, String displayName) {
		super(id, displayName);
		super.setValidator(new IntegerCellEditorValidator());
	}

	private class IntegerCellEditorValidator implements ICellEditorValidator {

		@Override
		public String isValid(Object value) {
			int intValue = -1;
			try {
				intValue = Integer.parseInt((String) value);
			} catch (NumberFormatException exc) {
				return "Not a number";
			}
			return (intValue >= 0) ? null : "Value must be >=  0";
		}
		
	}	
}

