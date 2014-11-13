package no.hib.dpf.transform.presentation;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class TransformFormPage extends FormPage {

	private TransformMasterBlock block;

	public TransformFormPage(FormEditor editor) {
		super(editor, "Tranform", "Tranform"); //$NON-NLS-1$ //$NON-NLS-2$
		block = new TransformMasterBlock(this);
	}
	
	protected void createFormContent(final IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		form.setText("Tranform Productions"); //$NON-NLS-1$
		block.createContent(managedForm);
	}
	public boolean isEditor() {
		return true;
	}
}
