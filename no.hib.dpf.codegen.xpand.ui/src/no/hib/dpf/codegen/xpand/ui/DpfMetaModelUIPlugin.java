/**
 * <copyright>
 * Copyright (c) 2012 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * @author OAw/Itemis
 * @author Anders Sandven <anders.sandven@gmail.com>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.codegen.xpand.ui;

import no.hib.dpf.codegen.xpand.metamodel.Logger;
import no.hib.dpf.codegen.xpand.ui.wizards.WorkflowParser;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.BundleContext;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.resource.ImageDescriptor;

public class DpfMetaModelUIPlugin extends AbstractUIPlugin {
	// A resource set to store the loaded profiles in
	private static Logger log;
	
	public static ResourceSet dpfResourceSet = new ResourceSetImpl();

	final static Map<IResource, Specification> fileModels = new HashMap<IResource, Specification>();

	public final static Map<IResource, Specification> getFileModels() {
		return Collections.unmodifiableMap(fileModels);
	}

	public static void removeFileModel(IResource resource) {
		URI uri = URI.createURI(resource.getFullPath().toString());
		Resource r = dpfResourceSet.getResource(uri, false);
		if (r != null) {
			if (r.isLoaded()) // Is this a request to reload the resource?
				r.unload();
		}
		fileModels.remove(resource);
	}

	private static IResourceChangeListener listener = new IResourceChangeListener() {
		public void resourceChanged(IResourceChangeEvent event) {
			// we are only interested in POST_CHANGE events
			if (event.getType() != IResourceChangeEvent.POST_CHANGE)
				return;
			IResourceDelta rootDelta = event.getDelta();
			try {
				rootDelta
						.accept(new DpfMetaModelUIPlugin.DpfResourceDeltaVisitor());
			} catch (CoreException e) {
				log.error("CoreException", e);
			}

		}
	};

	protected static List<EObject> loadContents(IFile file) {
		try {
			URI uri = URI.createFileURI(file.getFullPath().toString());
			Resource r = new ResourceSetImpl().createResource(uri);
			r.load(file.getContents(), Collections.EMPTY_MAP);
			return r.getContents();
		} catch (IOException e) {
			log.error("IOException", e);
		} catch (CoreException e) {
			log.error("CoreException", e);
		}
		return null;
	}

	// The plug-in ID
	public static final String PLUGIN_ID = "no.hib.dpf.codegen.xpand.ui"; //$NON-NLS-1$

	// The shared instance
	private static DpfMetaModelUIPlugin plugin;

	/**
	 * The constructor
	 */
	public DpfMetaModelUIPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		try {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			
//			loadLogger("no.hib.dpf.codegen.xpand.ui");
//			loadLogger("no.hib.dpf.codegen.xpand.metamodel");
//			
//			log = Logger.getLogger(DpfMetaModelUIPlugin.class);
			
			log = Logger.getLogger(DpfMetaModelUIPlugin.class);
			
			workspace.addResourceChangeListener(listener);
			workspace.getRoot().accept(
					new DpfMetaModelUIPlugin.DpfResourceDeltaVisitor());
		} catch (CoreException e) {
			e.printStackTrace();
		} 
	}

//	private void loadLogger(String bundle) {
//		//Load l4j on metamodel
//		Bundle b = Platform.getBundle(bundle);
//		
//		System.out.println(b.getBundleId());
//		System.out.println(b.getLocation());
//		System.out.println(b.getSymbolicName());
//		System.out.println(b.getState());
////		System.out.println(b.);
//		Enumeration<URL> ee = b.findEntries("/", "log4j.properties", true);
//		
//		URL fileURL = null;
//		try {
//			if(ee.hasMoreElements()) {
//				fileURL = ee.nextElement();
//			}
//			PropertyConfigurator.configure(fileURL);
//		} catch(NullPointerException e) {
//			e.printStackTrace();
//		}
//	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(listener);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static DpfMetaModelUIPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path.
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(getId(), path);
	}

	public static String getId() {
		return getDefault().getBundle().getSymbolicName();
	}
	
	/**
	 * Scans the workspace for projects that contain a .settings file, or a workflow file
	 */
	static class DpfResourceDeltaVisitor implements IResourceDeltaVisitor,
			IResourceVisitor {
		public boolean visit(IResourceDelta delta) {

			if (delta.getKind() == IResourceDelta.REMOVED) {
				DpfMetaModelUIPlugin.removeFileModel(delta.getResource());
				return true;
			} else {
				IResource resource = delta.getResource();
				return visit(resource);
			}
		}

		public boolean visit(IResource resource) {
			String path = "";
			if(resource instanceof IFile) {
				if(resource.isAccessible() && resource.getName().endsWith(".mwe")) {
					path = retrievePathFromWorkflow((IFile)resource);
				}
			} else if(resource instanceof IProject) {
				if(resource.isAccessible()) {
					path = retrievePathFromPersistentProperties(resource.getProject());
					return true;
				} else return false; //We do not expand projects which isnt relevant
			}

			if(!path.equals("")) {
				createAndStoreSpecification(resource.getProject(), path);
			}

			return true;
		}
		
		private void createAndStoreSpecification(IProject project, String path) {
			URI uri = URI.createURI(path);
			if(!path.equals("")) {
				//Her må vi loade evt. ny spesifikasjon og samanlikne med den gamle for så å oppdatere
				if(!fileModels.containsKey(project.getFile(new Path(path)))) {
					Specification spectmp = null;
					try {
						spectmp = DPFCoreUtil.loadSpecification2(uri);
						log.info("Successfully loaded metamodel for project \"" + project.getName() + "\" from path: " + path);
					} catch (IOException e) {
						log.error("Could not load metamodel for project: " + project.getName() + " with path: " + path);
						e.printStackTrace(); 
					}
					if(spectmp != null) {
						fileModels.put(project.getFile(new Path(path)), spectmp);
					}
				}
			}
		}
		
		private String retrievePathFromWorkflow(IFile f) {
			String res = null;
			try {
				WorkflowParser parse = new WorkflowParser(f.getContents());
				res = parse.getProperty("dpf_metamodel");

				//Update .settings file if workflow contains different value
				//					String tmp = retrievePathFromPersistentProperties(f.getProject());
				//					if(!res.equals(tmp)) {
				//						ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, PLUGIN_ID);
				//						IScopeContext[] context = {new ProjectScope(f.getProject()), InstanceScope.INSTANCE};
				//						store.setSearchContexts(context);
				//						store.setValue("metamodel.location", res);
				//					}

			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (CoreException e) {
				e.printStackTrace();
			}	
			return res;
		}
		
		private String retrievePathFromPersistentProperties(IProject f) {
			if(f.findMember(".settings/no.hib.dpf.codegen.xpand.ui.prefs") != null) {
				ScopedPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, PLUGIN_ID);
				IScopeContext[] context = {new ProjectScope(f), InstanceScope.INSTANCE};

				store.setSearchContexts(context);

				return store.getString("metamodel.location");
			}
			return "";		
		}
	}
}
