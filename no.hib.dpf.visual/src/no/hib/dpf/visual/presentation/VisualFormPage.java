package no.hib.dpf.visual.presentation;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class VisualFormPage extends FormPage {

	private VisualMasterBlock block;

	public VisualFormPage(FormEditor editor) {
		super(editor, "Visual", "Visual"); //$NON-NLS-1$ //$NON-NLS-2$
		block = new VisualMasterBlock(this);
	}
	
	@Override
	protected void createFormContent(final IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		form.setText("Visual Items"); //$NON-NLS-1$
		block.createContent(managedForm);
	}
	@Override
	public boolean isEditor() {
		return true;
	}
}
