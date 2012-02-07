package no.hib.dpf.codegen.xpand.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.core.Specification;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.expression.TypeSystem;
import org.eclipse.xtend.shared.ui.MetamodelContainer;
import org.eclipse.xtend.shared.ui.MetamodelContributor2;
import org.eclipse.xtend.typesystem.MetaModel;

public class DpfMetaModelContributor implements MetamodelContributor2 {

		private static Map<IJavaProject,MetamodelContainer> metamodels = new HashMap<IJavaProject,MetamodelContainer>();

		public MetaModel[] getMetamodels(IJavaProject project, TypeSystem builtin) {
	        MetamodelContainer container = metamodels.get(project); //Kvart prosjekt i workspace har(kan ha) fleire metamodeller assosiert
			if (container == null || container.hasChanged()) {
				if (container!=null) {
					metamodels.remove(project);
					JavaCore.removeElementChangedListener(container);
					ResourcesPlugin.getWorkspace().removeResourceChangeListener(container);
				}
				Map<Specification,MetaModel> result = new HashMap<Specification,MetaModel>();
				List<IJavaProject> projects = new ArrayList<IJavaProject>();
				projects.add(project);
				
				try {
					IProject[] ps = project.getProject().getReferencedProjects();
					for (int i = 0; i < ps.length; i++) {
						IProject p = ps[i];
						IJavaProject jp = JavaCore.create(p);
						if (jp!=null) {
							projects.add(jp);
						}
					}
				} catch (CoreException e1) {
					e1.printStackTrace();
				}
			
				Set<IResource> resources = new HashSet<IResource>();
				Map<IResource, Specification> models = DpfMetaModelUIPlugin.getFileModels();
				if (!models.isEmpty()) {
					for (IResource r : models.keySet()) {
						IFile f = (IFile) r;
						if (f.getProject().equals(project.getProject())) {
							Specification model = models.get(f);
							result.put(model, new DpfMetamodel(model));
							resources.add(f);
						}
					}
				}
	            container = new MetamodelContainer(projects, resources, new HashSet<MetaModel>(result.values()));
				JavaCore.addElementChangedListener(container);
				ResourcesPlugin.getWorkspace().addResourceChangeListener(container);
				metamodels.put(project, container);
			}
	        return container.getMetaModels().toArray(new MetaModel[container.getMetaModels().size()]);
		}
		
		public static MetaModel[] getMetamodelForProject(IProject project) {
			IJavaProject p = JavaCore.create(project);
			return metamodels.get(p).getMetaModels().toArray(new MetaModel[metamodels.get(p).getMetaModels().size()]);
		}
		
//		private boolean isOnProjectsClasspath(IFile f, Set<IJavaProject> jps) {
//			for (Iterator<IJavaProject> iter = jps.iterator(); iter.hasNext();) {
//				IJavaProject element = iter.next();
//				if (element.isOnClasspath(f)) {
//					return true;
//				}
//			}
//			return false;
//		}

		@Override
		public IStorage getUnderlyingStorage(IJavaProject project,
				String typeName) {
			System.out.println("DPFMETAMODELCONTRIBUTOR#getUnderlyingStorage");
			return null;
		}
}
