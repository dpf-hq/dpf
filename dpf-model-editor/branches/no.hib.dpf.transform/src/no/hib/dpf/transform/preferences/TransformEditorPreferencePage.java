package no.hib.dpf.transform.preferences;


import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class TransformEditorPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	private Composite fieldEditorParent;
	private ColorFieldEditor nodebg, nodefg, preservebg, insertbg, deletebg, arrowbg, arrowfg, arrowSource, arrowTarget, arrowLabelSelected, arrowValidationError;
	
	public TransformEditorPreferencePage() {
		super(GRID);
		setPreferenceStore(TransformEditorPreferences.getDefault().getPreferenceStore());
		setDescription("Preferences for Transform Sketcher");
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {		
		addField(new BooleanFieldEditor(PreferenceTransformConstants.P_DISPLAY_TYPES, "Display &type names", getFieldEditorParent()));	
	
		fieldEditorParent = getFieldEditorParent();
		
		nodebg = new ColorFieldEditor(PreferenceTransformConstants.P_NODE_BGCOLOR, "Node Background Color", fieldEditorParent);
		nodefg = new ColorFieldEditor(PreferenceTransformConstants.P_NODE_FGCOLOR, "Node Foreground Color", fieldEditorParent);
		preservebg = new ColorFieldEditor(PreferenceTransformConstants.PRESERVE_ITEMS_COLOR, "Preserve Item Background Color", fieldEditorParent);
		insertbg = new ColorFieldEditor(PreferenceTransformConstants.INSERT_ITEMS_COLOR, "Insert Item Background Color", fieldEditorParent);
		deletebg = new ColorFieldEditor(PreferenceTransformConstants.DELETE_ITEMS_COLOR, "Delete Item Background Color", fieldEditorParent);
		
		addField(nodebg);
		addField(nodefg);
		addField(preservebg);
		addField(insertbg);
		addField(deletebg);
	}

}
