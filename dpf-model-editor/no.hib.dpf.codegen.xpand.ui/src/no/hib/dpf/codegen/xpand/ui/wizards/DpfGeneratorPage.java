package no.hib.dpf.codegen.xpand.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DpfGeneratorPage extends WizardPage {

	private Text projectName, dsmLocation;
	private Label pname, dsml;
	
	protected DpfGeneratorPage() {
		super("New DPF Generator");
		super.setTitle("New DPF Generator");
		super.setDescription("Create a new DPF Xpand generator project");
	}

	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NULL);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		
		comp.setLayout(gridLayout);
		
		pname = new Label(comp, SWT.RIGHT);
		pname.setText("Project Name:");
		
		projectName = new Text(comp, SWT.SINGLE);
		projectName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		dsml = new Label(comp, SWT.RIGHT);
		dsml.setText("DSM location:");
		
		dsmLocation = new Text(comp, SWT.SINGLE);
		dsmLocation.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		setControl(comp);
		setPageComplete(true);
	}
	
	public String getProjectName() {
		return projectName.getText();
	}
	
	public String getDsmLocation() {
		return dsmLocation.getText();
	}
}