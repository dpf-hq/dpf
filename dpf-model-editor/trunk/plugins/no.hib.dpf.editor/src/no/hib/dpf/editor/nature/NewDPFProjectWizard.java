package no.hib.dpf.editor.nature;

import java.net.URI;

import no.hib.dpf.editor.nature.DPFProjectSupport;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;


public class NewDPFProjectWizard extends Wizard implements INewWizard, IExecutableExtension {

	private WizardNewProjectCreationPage pageone;
	private IConfigurationElement configurationElement;
	
	public NewDPFProjectWizard() {
		setWindowTitle("DPF Project Wizard");
	}

	@Override
	public void addPages() {
		super.addPages();
		
		pageone = new WizardNewProjectCreationPage("dpfwizard");
		pageone.setTitle("DPF Project");
		pageone.setDescription("Create a new DPF project");
		
		addPage(pageone);
	}


	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean performFinish() {
		String name = pageone.getProjectName();
		URI location = null;
		if(!pageone.useDefaults()) {
			location = pageone.getLocationURI();
			System.err.println("Location: " + location.toString());
		}

		DPFProjectSupport.createProject(name, location);
		BasicNewProjectResourceWizard.updatePerspective(configurationElement);
		
		return true;
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		configurationElement = config;
	}

}
