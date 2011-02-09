package no.hib.dpf.editor.viewmodel;


import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class NegativeIntegerTextPropertyDescriptor extends TextPropertyDescriptor {

	public NegativeIntegerTextPropertyDescriptor(Object id, String displayName) {
		super(id, displayName);
		super.setValidator(new IntegerCellEditorValidator());
	}

	private class IntegerCellEditorValidator implements ICellEditorValidator {

		@Override
		public String isValid(Object value) {
			int intValue = -2;
			try {
				intValue = Integer.parseInt((String) value);
			} catch (NumberFormatException exc) {
				return "Not a number";
			}
			return (intValue >= -1) ? null : "Value must be >= -1";
		}
		
	}	

}
