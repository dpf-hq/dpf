package no.hib.dpf.editor.nature;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class DPFProjectSupport {
	
	public static final String FOLDERNAME_SRC = "src";
	public static final String FOLDERNAME_SPECIFICATIONS = "specifications";
	public static final String FOLDERNAME_TEMPLATE_METAMODELS = "template_metamodels";
	public static final String FOLDERNAME_TEMPLATE_VISUALIZATION_MODELS = "visual_models";
	private static final String PATH_TEMPLATE_METAMODEL = "/" + FOLDERNAME_TEMPLATE_METAMODELS;
	private static final String PATH_TEMPLATE_VISUALIZATION_MODEL = "/" + FOLDERNAME_TEMPLATE_VISUALIZATION_MODELS;
	
	public static IProject createProject(String projectName, URI location) {
		Assert.isNotNull(projectName);
		
		IProject project = createBaseProject(projectName, location);
		if(project != null) {
			try {
				String[] folders = { 
						FOLDERNAME_SRC, 
						FOLDERNAME_SPECIFICATIONS };
				String[] hiddenFolders = {FOLDERNAME_TEMPLATE_METAMODELS, FOLDERNAME_TEMPLATE_VISUALIZATION_MODELS};
				
				addToProjectStructure(project, folders);
				addToProjectStructure(project, hiddenFolders, false); // false = dont hide
				addFileToProjectStructure(project, PATH_TEMPLATE_METAMODEL + "/Composition.dpf");
				addFileToProjectStructure(project, PATH_TEMPLATE_METAMODEL + "/Composition.xmi");
				addFileToProjectStructure(project, PATH_TEMPLATE_METAMODEL + "/Template.dpf");
				addFileToProjectStructure(project, PATH_TEMPLATE_METAMODEL + "/Template.xmi");
				addFileToProjectStructure(project, PATH_TEMPLATE_VISUALIZATION_MODEL + "/class_diagram.visual");
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
			createFolder(etcFolders, false);
		}
	}
	
	private static void addToProjectStructure(IProject project, String[] paths, boolean hidden) 
			throws CoreException {
		for(String path : paths) {
			IFolder etcFolders = project.getFolder(path);
			createFolder(etcFolders, hidden);
		}
	}
	
	private static void addFileToProjectStructure(IProject project, String path) throws CoreException{
		IFile file = project.getFile(path);
		InputStream stream = DPFProjectSupport.class.getResourceAsStream(path);
		file.create(stream, false, null);
		
		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createFolder(IFolder folder, boolean hidden) throws CoreException {
		IContainer parent = folder.getParent();
		if(parent instanceof IFolder) {
			createFolder((IFolder)parent, hidden);
		}
		if(!folder.exists()) {
			folder.create(false, true, null);
			folder.setHidden(hidden);
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
