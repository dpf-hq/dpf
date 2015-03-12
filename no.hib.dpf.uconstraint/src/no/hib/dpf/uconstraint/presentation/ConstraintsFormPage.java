package no.hib.dpf.uconstraint.presentation;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class ConstraintsFormPage extends FormPage {

	private ConstraintsMasterBlock block;

	public ConstraintsFormPage(FormEditor editor) {
		super(editor, "Constraints", "Constraints");
		block = new ConstraintsMasterBlock(this);
	}
	
	protected void createFormContent(final IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		form.setText("Constraints"); 
		block.createContent(managedForm);
	}
	public boolean isEditor() {
		return true;
	}
}
