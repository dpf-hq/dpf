package no.hib.dpf.transform.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.Dialog; 
import org.eclipse.swt.widgets.Shell;

public class BrowseInstance extends Dialog {

	public BrowseInstance(Shell parent) {
		super(parent);
	}
	protected Control createDialogArea(Composite parent) { 

		Composite composite = (Composite) super.createDialogArea(parent); 
		createControls(composite); 
		//add controls to composite as necessary 
		return composite; 
	}
	private void createControls(Composite composite) {
		// TODO Auto-generated method stub
		
	} 
	protected void handleModelBrowseButtonPressed(Text targetField, String name) {
		String selection = null;
		FileDialog fileDialog = new FileDialog(getShell(), SWT.SHEET);
		fileDialog.setFileName(null);
		fileDialog.setFilterExtensions(new String[]{name, "*.*"});
		selection = fileDialog.open();
		if (selection != null) {
			targetField.setText(selection);
		}
	}

}
