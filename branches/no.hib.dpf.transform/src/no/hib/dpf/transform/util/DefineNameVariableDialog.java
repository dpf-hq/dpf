package no.hib.dpf.transform.util;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DefineNameVariableDialog extends Dialog { 
	
	private Text variableName;
	private Shell shell=null; 
	private Object variable;
	private String name;
	
	public DefineNameVariableDialog( Shell parent, EditPart editPart) { 
		super(parent); 
		variableName = null;
		variable = editPart;
	} 

	protected Control createDialogArea(Composite parent) { 

		Composite composite = (Composite) super.createDialogArea(parent); 
		createControls(composite); 
		//add controls to composite as necessary 
		return composite; 
	} 


	private void createControls(Composite composite) { 
		//whatall component you want here you can create 
		shell = composite.getShell(); 
		composite.setSize(100, 10);
		shell.setText("Set variable name"); ; 
		
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		composite.setLayout(new GridLayout(2, false));
		Label variable = new Label(composite, SWT.None); 
		variable.setText("name: "); 

		variableName = new Text(composite,SWT.BORDER); 
		variableName.setText(""); 
		variableName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL)); 

		composite.pack(); 
	} 
	protected void createButtonsForButtonBar(Composite parent) { 
		//you can create your own button or can call super method to create default ok and cancel button 
		super.createButtonsForButtonBar(parent); 
	} 
	@Override
	protected void okPressed() {
		name = variableName.getText();
	    super.okPressed();
	  }
	public String getVariable(){
		return name;
	}
}
