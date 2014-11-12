package no.hib.dpf.text;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

public class DPFTextLauncher extends LaunchConfigurationDelegate{

	public static final String LAUNCH_FILE = "DPF_TEXT_LAUNCH_FILE"; 
	public static final String LAUNCH_FILE_ENDING = ".tdpf"; 
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		try {
			final Path path = new Path(configuration.getAttribute(DPFTextLauncher.LAUNCH_FILE,""));
		    final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			System.out.println("Launch TEST: " + file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
