package no.hib.dpf.uconstraint.preferences;


import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class ConstraintsEditorPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	private Composite fieldEditorParent;
	private ColorFieldEditor nodebg, nodefg, preservebg, insertbg, deletebg;
	
	public ConstraintsEditorPreferencePage() {
		super(GRID);
		setPreferenceStore(ConstraintsEditorPreferences.getDefault().getPreferenceStore());
		setDescription("Preferences for Constraints Sketcher");
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {		
		addField(new BooleanFieldEditor(PreferenceConstraintsConstants.P_DISPLAY_TYPES, "Display &type names", getFieldEditorParent()));	
	
		fieldEditorParent = getFieldEditorParent();
		
		nodebg = new ColorFieldEditor(PreferenceConstraintsConstants.P_NODE_BGCOLOR, "Node Background Color", fieldEditorParent);
		nodefg = new ColorFieldEditor(PreferenceConstraintsConstants.P_NODE_FGCOLOR, "Node Foreground Color", fieldEditorParent);
		preservebg = new ColorFieldEditor(PreferenceConstraintsConstants.PRESERVE_ITEMS_COLOR, "Preserve Item Background Color", fieldEditorParent);
		insertbg = new ColorFieldEditor(PreferenceConstraintsConstants.INSERT_ITEMS_COLOR, "Insert Item Background Color", fieldEditorParent);
		deletebg = new ColorFieldEditor(PreferenceConstraintsConstants.DELETE_ITEMS_COLOR, "Delete Item Background Color", fieldEditorParent);
		
		addField(nodebg);
		addField(nodefg);
		addField(preservebg);
		addField(insertbg);
		addField(deletebg);
	}

}
