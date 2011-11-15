package no.hib.dpf.codegen.ui.properties;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;

public class CodegenProperties implements DPFCodegenConstants {
	//Klasse som kan innhalde konstantar for properties osv.
	
	//Initial values
	public static String CODEGEN_ENABLED = String.valueOf(false);
	public static String TARGET_DIRECTORY = "";
	
	private IProject project;
	
	public CodegenProperties(IProject project) {
		this.project = project;
	}
	
	public boolean hasNature() throws CoreException {
		return project.hasNature(NATURE_ID); 
	}
	
	public void setNature(boolean nature) throws CoreException {
		if(nature) {
			//If we enable nature without it existing
			if(!hasNature()) {
				IProjectDescription description = project.getDescription();
	            String[] old = description.getNatureIds(),
	                     natures= new String[old.length + 1];
	            System.arraycopy(old,0,natures,0,old.length);
	            natures[old.length] = NATURE_ID;
	            description.setNatureIds(natures);
	            project.setDescription(description,new NullProgressMonitor());
			}
		} else {
			//If we disable nature with it existing
			if(hasNature()) {
				IProjectDescription description = project.getDescription();
				String[] old = description.getNatureIds(), natures = new String[old.length - 1];
				int i = 0, j = 0;
				while (i < old.length) {
					if (!old[i].equals(NATURE_ID))
						natures[j++] = old[i];
						i++;
				}
				description.setNatureIds(natures);
				project.setDescription(description,new NullProgressMonitor());
			}
		}
	}
	
	public IProject getProject() {
		return project;
	}
	
	public String getModelSrcDir() throws CoreException {
		return getPathProperty(MODEL_TARGET_SOURCE_DIR_PROPERTY, DEFAULT_MODEL_TARGET_SRC_DIR);
	}
	
	public void setModelSrcDir(String value) throws CoreException {
		setProperty(MODEL_TARGET_SOURCE_DIR_PROPERTY , value);
	}
	
	public String getControllerSrcDir() throws CoreException {
		return getPathProperty(CONTROLLER_TARGET_SOURCE_DIR_PROPERTY, DEFAULT_CONTROLLER_TARGET_SRC_DIR);
	}
	
	public void setGenerateAnnotations(boolean value) throws CoreException {
		setProperty(ANNOTATIONS_PROPERTY, String.valueOf(value));
	}
	
	public String getGenerateAnnotations() throws CoreException {
		return getProperty(ANNOTATIONS_PROPERTY, DEFAULT_ANNOTATIONS);
	}
	
	public void setControllerSrcDir(String value) throws CoreException {
		setProperty(CONTROLLER_TARGET_SOURCE_DIR_PROPERTY , value);
	}
	
	private void setProperty(QualifiedName key, String value) throws CoreException {
		project.setPersistentProperty(key, value);
	}
	
	private String getProperty(QualifiedName key, String defaultValue) throws CoreException {
		if(project.getPersistentProperty(key) == null) 
			return defaultValue;
		else
			return project.getPersistentProperty(key);
	}
	
	private String getPathProperty(QualifiedName key, String defaultValue) throws CoreException {
		if(project.getPersistentProperty(key) == null) 
			return File.separator + project.getName() + File.separator + defaultValue;
		else
			return project.getPersistentProperty(key);
	}
	//FIXME: ein set berre folderpath men returnerer absoulutt path.
	public void setTargetDirs(String modelDir, String controllerDir) throws CoreException {
		StringBuffer buf = new StringBuffer();
		String mtmp = null, ctmp = null;
		for(int i = 0; i < modelDir.length(); ++i) {
			if(modelDir.charAt(i) == controllerDir.charAt(i)) 
				buf.append(modelDir.charAt(i));
			else {
				mtmp = modelDir.substring(i, modelDir.length());
				ctmp = controllerDir.substring(i, controllerDir.length());
				break;
			}
		}
		System.out.println(buf.toString() + "  " + mtmp + "   " + ctmp);
		setProperty(TARGET_SOURCE_DIR_PROPERTY, modelDir);
		setControllerSrcDir(ctmp);
		setModelSrcDir(modelDir); //<-----------------------
	}
}
