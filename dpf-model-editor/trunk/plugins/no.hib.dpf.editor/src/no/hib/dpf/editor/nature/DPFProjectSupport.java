package no.hib.dpf.editor.nature;

import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import no.hib.dpf.editor.nature.DPFProjectNature;

public class DPFProjectSupport {
	public static IProject createProject(String projectName, URI location) {
		Assert.isNotNull(projectName);
		
		IProject project = createBaseProject(projectName, location);
		if(project != null) {
			try {
				String[] paths = { "src", 
						"specifications" };
				addToProjectStructure(project, paths);
			} catch (CoreException e) {
				e.printStackTrace();
				project = null;
			}
		}
		return project;
	}

	private static void addToProjectStructure(IProject project, String[] paths) 
			throws CoreException {
		for(String path : paths) {
			IFolder etcFolders = project.getFolder(path);
			
			createFolder(etcFolders);
		}
	}

	private static void createFolder(IFolder folder) throws CoreException {
		IContainer parent = folder.getParent();
		if(parent instanceof IFolder) {
			createFolder((IFolder)parent);
		} 
		if(!folder.exists()) {
			folder.create(false, true, null);
		}
	}

	private static IProject createBaseProject(String projectName, URI location) {
		IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if(!newProject.exists()) {
			URI projectLocation = location;
			IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName());
			if(location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
				projectLocation = null;
			}
			desc.setLocationURI(projectLocation);
			try {
				newProject.create(desc, null);
				if(!newProject.isOpen()) {
					newProject.open(null);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		try {
			addNature(newProject);
			return newProject;
		} catch(CoreException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static void addNature(IProject project) throws CoreException {
		if(!project.hasNature(DPFProjectNature.NATURE_ID)) {
			IProjectDescription description = project.getDescription();
			String[] prevNatures = description.getNatureIds();
			String[] newNatures = new String[prevNatures.length+1];
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
			newNatures[prevNatures.length] = DPFProjectNature.NATURE_ID;
			description.setNatureIds(newNatures);
			IProgressMonitor monitor = null;
			project.setDescription(description, monitor);
		}
	}
}














