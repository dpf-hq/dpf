/*
 * /*******************************************************************************
 * Copyright (c) 2005, 2009 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.codegen.xpand.ui;

import no.hib.dpf.codegen.xpand.ui.properties.DpfMetaModelProperties;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Specification;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.resource.ImageDescriptor;

public class DpfMetaModelUIPlugin extends AbstractUIPlugin {
	// A resource set to store the loaded profiles in
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
				System.out.println();
			}

		}
	};

	protected static List<EObject> loadContents(IFile file) {
		try {
			URI uri = URI.createFileURI(file.getFullPath().toString());
			Resource r = new ResourceSetImpl().createResource(uri);
			r.load(file.getContents(), Collections.EMPTY_MAP);
			return r.getContents();
		} catch (Exception e) {
			System.out.println();
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
		// Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml2",
		// UML22UMLResource.Factory.INSTANCE);
		try {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.addResourceChangeListener(listener);
			workspace.getRoot().accept(
					new DpfMetaModelUIPlugin.DpfResourceDeltaVisitor());
		} catch (CoreException e) {
			System.out.println();
		}
	}

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
	 * Scans the project for files that are valid according to  
	 * hasValidDsm. 
	 */
	static class DpfResourceDeltaVisitor implements IResourceDeltaVisitor,
			IResourceVisitor {
		public boolean visit(IResourceDelta delta) {

			if (delta.getKind() == IResourceDelta.REMOVED) {
				DpfMetaModelUIPlugin.removeFileModel(delta.getResource());
				return true;
			} else {
				IResource resource = delta.getResource();
				try {
					return visit(resource);
				} catch (CoreException e) {
					System.out.println();
					return true;
				}
			}
		}

		public boolean visit(IResource resource) throws CoreException {
			if (resource instanceof IProject) {
				IProject f = (IProject) resource;
				String path = hasValidDsm(f);
				if (path != null) {
						try {
							URI uri = URI.createURI(path);
							Specification spectmp = CoreFactory.eINSTANCE.loadSpecification(uri);
							System.out.println("FOUND AND SUCCESSFULLY LOADED VALID DSM: " + path);
							if(spectmp != null) {
								fileModels.put(f.getFile(new Path(path)), spectmp);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
			}
			return true;
		}
		
		private String hasValidDsm(IProject f) {
			try {
				if(f.isAccessible()) {
					String path = f.getPersistentProperty(DpfMetaModelProperties.DSM_PATH_PROPERTY);
					if(path != null) {
						//TODO: Properly handle input. file is needed to make the URI stuff work
						return "file:/" + path;
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//Returns every IFile which matches isValidDsm
//		public boolean visit(IResource resource) throws CoreException {
//			if (resource instanceof IFile) {
//				IFile f = (IFile) resource;
//				if (isValidDsm(f)) {
////					if (JavaCore.create(f.getParent()) != null) { //dafuq
//						try {
//							URI uri = URI.createURI(f.getFullPath().toString());
////							DpfMetamodel p = loadDsm(uri);
//							Specification spectmp = CoreFactory.eINSTANCE.loadSpecification(uri);
////							if (p != null) {
////								fileModels.put(f, p);
////							}
//							if(spectmp != null) {
//								fileModels.put(f, spectmp);
//							}
//						} catch (Exception e) {
//							System.out.println();
//						}
////					}
//				}
//			}
//			return true;
//		}
		
//		private boolean isValidDsm(IFile f) {
//		return !f.isDerived()
//				&& f.isAccessible()
//				&& !f.isLinked()
//				&& (f.getName().endsWith("dsm.xmi") && f.exists());
//	}
		
//		public synchronized final static DpfMetamodel loadDsm(URI uri) {
//			Resource r = dpfResourceSet.getResource(uri, false);
//			if (r == null) {
//				// this resource has not been loaded before...
//				// hence, demandLoad it
//				r = dpfResourceSet.getResource(uri, true);
//			} else {
//				if (r.isLoaded()) { // Is this a request to reload the resource?
//					r.unload();
//				}
//				try {
//					r.load(new HashMap<Object, Object>());
//				} catch (IOException e) {
//					throw new RuntimeException(e);
//				}
//			}
//
//			List<EObject> c = r.getContents();
//			if (c.isEmpty()) {
//				return null;
//			}
//			if (c.get(0) instanceof DpfMetamodel) {
//				DpfMetamodel p = (DpfMetamodel) c.get(0);
//				URIConverter.URI_MAP.put(URI.createURI(uri.lastSegment()), uri);
//				return p;
//			}
//			return null;
//		}
	}
}
