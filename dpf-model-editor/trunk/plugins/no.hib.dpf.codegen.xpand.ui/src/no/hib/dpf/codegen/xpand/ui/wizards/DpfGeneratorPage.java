package no.hib.dpf.codegen.xpand.ui.wizards;

import no.hib.dpf.codegen.xpand.ui.DpfMetaModelUIPlugin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class DpfGeneratorPage extends WizardPage implements Listener {

	private Text projectName, metaModelLocation;
	private Label pname, mml;
	private Button bml;
	private IStatus pstatus, mstatus;
	
	protected boolean canFinish;
	
	protected DpfGeneratorPage() {
		super("New DPF Generator");
		super.setTitle("New DPF Generator");
		super.setDescription("Create a new DPF Xpand generator project");
		pstatus = new Status(IStatus.OK, DpfMetaModelUIPlugin.PLUGIN_ID, "");
		mstatus = new Status(IStatus.OK, DpfMetaModelUIPlugin.PLUGIN_ID, "");
	}

	@Override
	public void createControl(final Composite parent) {
		Composite comp = new Composite(parent, SWT.NULL);
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		
		comp.setLayout(gridLayout);
		
		pname = new Label(comp, SWT.RIGHT);
		pname.setText("Project name:");

		projectName = new Text(comp, SWT.SINGLE | SWT.BORDER);
		projectName.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false, 2, 1));
		projectName.addListener(SWT.CHANGED, this);
		
		mml = new Label(comp, SWT.RIGHT);
		mml.setText("Metamodel location:");
		
		metaModelLocation = new Text(comp, SWT.SINGLE |	SWT.BORDER);
		metaModelLocation.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		metaModelLocation.addListener(SWT.CHANGED, this);
		
		bml = new Button(comp, SWT.PUSH);
		bml.setText("&Location");
		bml.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(parent.getShell());
				fd.setFilterExtensions(new String[] {"*.xmi"});
				fd.setFilterNames(new String[] {"*.xmi"});
				fd.open();
				if(!fd.getFileName().isEmpty()) {
					metaModelLocation.setText(fd.getFilterPath() + "/" + fd.getFileName());
					DpfGeneratorPage.this.metaModelLocation.notifyListeners(SWT.CHANGED, new Event());
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		setControl(comp);
		setPageComplete(true);
	}
	
	public String getProjectName() {
		return projectName.getText();
	}
	
	public String getMetaModelLocation() {
		return metaModelLocation.getText();
	}

	@Override
	public void handleEvent(Event event) {
		IStatus stmp = new Status(IStatus.OK, DpfMetaModelUIPlugin.PLUGIN_ID, "Create a new DPF Xpand generator project");
		canFinish = false;
		
		if(event.widget == projectName) {
			if(projectName.getText().isEmpty()) {
				stmp = new Status(IStatus.ERROR, DpfMetaModelUIPlugin.PLUGIN_ID, "Project name is not defined");
			}
			pstatus = stmp;
		} else if(event.widget == metaModelLocation) {
			if(metaModelLocation.getText().isEmpty()) {
				stmp = new Status(IStatus.ERROR, DpfMetaModelUIPlugin.PLUGIN_ID, "Metamodel location is not defined");
			}
			mstatus = stmp;
		}
		
		if(pstatus.matches(IStatus.ERROR)) {
			setErrorMessage(pstatus.getMessage());
			setMessage(null);
		} else if(mstatus.matches(IStatus.ERROR)) {
			setErrorMessage(mstatus.getMessage());
			setMessage(null);
		} else {
			setErrorMessage(null);
			setMessage(stmp.getMessage());
			if(!metaModelLocation.getText().isEmpty() && !projectName.getText().isEmpty()) {
				canFinish = true;
			}
		}
		getWizard().getContainer().updateButtons();
	}
}
