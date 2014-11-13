package no.hib.dpf.editor.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class DPFProjectNature implements IProjectNature {
	public static final String NATURE_ID = "no.hib.dpf.editor.nature.dpfprojectnature"; 
	
	@Override
	public void configure() throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public IProject getProject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProject(IProject project) {
		// TODO Auto-generated method stub

	}
 
}
