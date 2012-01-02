package no.hib.dpf.signature;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class SignatureFormPage extends FormPage {

	private SignatureMasterBlock block;

	public SignatureFormPage(FormEditor editor) {
		super(editor, "signature", "Signature"); //$NON-NLS-1$ //$NON-NLS-2$
		block = new SignatureMasterBlock(this, (SignatureEditor)editor);
	}
	
	protected void createFormContent(final IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		form.setText("Signature Predicates"); //$NON-NLS-1$
		block.createContent(managedForm);
	}
}
