package no.hib.dpf.editor.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * See http://www.eclipsepluginsite.com/preference-pages.html for howto on how to extend this.
 * 
 * This class represents a preference page that is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace that allows
 * us to create a page that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can be accessed directly via the preference store.
 */

public class DPFEditorPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	private Composite fieldEditorParent;
	private BooleanFieldEditor displayDynTypedArrowTools;
	private BooleanFieldEditor displayTypedArrowTools;

	public DPFEditorPreferencePage() {
		super(GRID);
		setPreferenceStore(DPFEditorPreferences.getDefault().getPreferenceStore());
		setDescription("Preferences for DPF Sketcher");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
//		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, 
//				"&Directory preference:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceConstants.P_DISPLAY_ARROWS, "Display names on &arrows", getFieldEditorParent()));
		
		addField(new BooleanFieldEditor(PreferenceConstants.P_DISPLAY_TYPES, "Display &type names", getFieldEditorParent()));		
		
		addField(new ColorFieldEditor(PreferenceConstants.P_NODE_COLOR, "Node fill &color", getFieldEditorParent()));

		displayDynTypedArrowTools = new BooleanFieldEditor(PreferenceConstants.P_DISPLAY_DYNTYPED_ARROWS, "Display create tool for &dynamically typed arrows", getFieldEditorParent()); 
		addField(displayDynTypedArrowTools); 

		fieldEditorParent = getFieldEditorParent();
		displayTypedArrowTools = new BooleanFieldEditor(PreferenceConstants.P_DISPLAY_TYPED_ARROWS, "Display create tool for &statically typed arrows", fieldEditorParent);
		addField(displayTypedArrowTools);
		
		displayTypedArrowTools.setEnabled(DPFEditorPreferences.getDefault().getDisplayDynamicallyTypedArrows(), fieldEditorParent);
		
		
//		addField(new RadioGroupFieldEditor(
//				PreferenceConstants.P_CHOICE,
//			"An example of a multiple-choice preference",
//			1,
//			new String[][] { { "&Choice 1", "choice1" }, {
//				"C&hoice 2", "choice2" }
//		}, getFieldEditorParent()));
//		addField(
//			new StringFieldEditor(PreferenceConstants.P_STRING, "A &text preference:", getFieldEditorParent()));
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		displayTypedArrowTools.setEnabled(displayDynTypedArrowTools.getBooleanValue(), fieldEditorParent);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}