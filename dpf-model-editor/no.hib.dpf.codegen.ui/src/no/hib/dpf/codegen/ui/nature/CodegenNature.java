package no.hib.dpf.codegen.ui.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class CodegenNature implements IProjectNature {
	public static String NATURE_ID = "no.hib.dpf.codegen.ui.nature.codegennature";
	
	IProject project;
	
	@Override
	public void configure() throws CoreException {
		System.setProperty("no.hib.dpf.codegen.ui.codegennature", "true");
	}

	@Override
	public void deconfigure() throws CoreException {
		System.setProperty("no.hib.dpf.codegen.ui.codegennature", "false");
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

}
