package no.hib.dpf.codegen.xpand.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;

import no.hib.dpf.codegen.xpand.ui.nature.DpfMetaModelNature;

public class DpfMetaModelProperties {
		//Klasse som kan innhalde konstantar for properties osv.
		
		//Initial values
		public static final String PROPERTY_NAMESPACE_URI = "http://dpf.hib.no/2011/dpf/xpandmetamodel";
		
		public static final QualifiedName DSM_PATH_PROPERTY = new QualifiedName(PROPERTY_NAMESPACE_URI, "dsmpath");
		
		private IProject project;
		
		public DpfMetaModelProperties(IProject project) {
			this.project = project;
		}
		
		public boolean hasNature() throws CoreException {
			return project.hasNature(DpfMetaModelNature.NATURE_ID); 
		}
		
		public void setNature(boolean nature) throws CoreException {
			if(nature) {
				//If we enable nature without it existing
				if(!hasNature()) {
					IProjectDescription description = project.getDescription();
		            String[] old = description.getNatureIds(),
		                     natures= new String[old.length + 1];
		            System.arraycopy(old,0,natures,0,old.length);
		            natures[old.length] = DpfMetaModelNature.NATURE_ID;
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
						if (!old[i].equals(DpfMetaModelNature.NATURE_ID))
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
		
		public String getDsmPaths() throws CoreException {
			return getProperty(DSM_PATH_PROPERTY, null);
		}
		
		public void setDsmPaths(String path) throws CoreException {
			setProperty(DSM_PATH_PROPERTY, path);
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
}
