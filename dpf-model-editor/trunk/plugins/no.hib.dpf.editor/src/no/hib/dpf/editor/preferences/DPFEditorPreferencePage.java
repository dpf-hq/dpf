/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
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
	private ColorFieldEditor nodebg, nodefg, arrowbg, arrowfg, arrowSource, arrowTarget, arrowLabelSelected, arrowValidationError;

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
		addField(new BooleanFieldEditor(PreferenceConstants.P_DISPLAY_ARROWS, "Display names on &arrows", getFieldEditorParent()));
		
		addField(new BooleanFieldEditor(PreferenceConstants.P_DISPLAY_TYPES, "Display &type names", getFieldEditorParent()));		
		
		addField(new ColorFieldEditor(PreferenceConstants.P_NODE_COLOR, "Node fill &color", getFieldEditorParent()));

		displayDynTypedArrowTools = new BooleanFieldEditor(PreferenceConstants.P_DISPLAY_DYNTYPED_ARROWS, "Display create tool for &dynamically typed arrows", getFieldEditorParent()); 
		addField(displayDynTypedArrowTools); 

		fieldEditorParent = getFieldEditorParent();
		displayTypedArrowTools = new BooleanFieldEditor(PreferenceConstants.P_DISPLAY_TYPED_ARROWS, "Display create tool for &statically typed arrows", fieldEditorParent);
		addField(displayTypedArrowTools);
		
		displayTypedArrowTools.setEnabled(DPFEditorPreferences.getDefault().getDisplayDynamicallyTypedArrows(), fieldEditorParent);
		
		nodebg = new ColorFieldEditor(PreferenceConstants.P_NODE_BGCOLOR, "Node Background Color", fieldEditorParent);
		nodefg = new ColorFieldEditor(PreferenceConstants.P_NODE_FGCOLOR, "Node Foreground Color", fieldEditorParent);
		arrowbg = new ColorFieldEditor(PreferenceConstants.P_ARROW_BGCOLOR, "Arrow Background Color", fieldEditorParent);
		arrowfg = new ColorFieldEditor(PreferenceConstants.P_ARROW_FGCOLOR, "Arrow Foreground Color", fieldEditorParent);
		arrowSource = new ColorFieldEditor(PreferenceConstants.P_ARROW_SOURCE_COLOR, "Qualified Arrow Source Color", fieldEditorParent);
		arrowTarget = new ColorFieldEditor(PreferenceConstants.P_ARROW_TARGET_COLOR, "Qualified Arrow Target Color", fieldEditorParent);
		arrowLabelSelected = new ColorFieldEditor(PreferenceConstants.P_ARROW_LABEL_SELECTED_ARROW_COLOR, "Arrow Color when clicking on Arrow Label", fieldEditorParent);
		arrowValidationError = new ColorFieldEditor(PreferenceConstants.P_ARROW_VALIDATION_ERROR_ARROW_COLOR, "Arrow Color at Validation Error", fieldEditorParent);
		
		addField(nodebg);
		addField(nodefg);
		addField(arrowbg);
		addField(arrowfg);
		addField(arrowSource);
		addField(arrowTarget);
		addField(arrowLabelSelected);
		addField(arrowValidationError);
		
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