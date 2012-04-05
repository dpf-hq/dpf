package no.hib.dpf.codegen.xpand.ui.wizards;

/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import no.hib.dpf.codegen.xpand.ui.properties.DpfMetaModelProperties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.xtend.shared.ui.Messages;
import org.eclipse.xtend.shared.ui.core.metamodel.Contributor;
import org.eclipse.xtend.shared.ui.core.metamodel.MetamodelContributorRegistry;
import org.eclipse.xtend.shared.ui.core.preferences.PreferenceConstants;
import org.eclipse.xtend.shared.ui.wizards.EclipseHelper;
import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

public class NewDpfGeneratorWizard extends Wizard implements INewWizard,
		IExecutableExtension {

	private DpfGeneratorPage page;

	private DpfMetaModelProperties props;
	
	private IConfigurationElement configElement;
	
	private String metaModelLocation;

	private String workflowContent;
	
	public NewDpfGeneratorWizard() {
		super();
		super.setWindowTitle("New DPF Xpand Generator Project");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		page = new DpfGeneratorPage();
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		final String name = page.getProjectName();
		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(final IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					 doFinish(name, monitor);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (final InterruptedException e) {
			return false;
		} catch (final InvocationTargetException e) {
			final Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(),
					Messages.XtendXpandProjectWizard_ErrorLabel,
					realException.getMessage());
			return false;
		}
		BasicNewProjectResourceWizard.updatePerspective(configElement);
		return true;
	}

	void doFinish(final String name,
			final IProgressMonitor monitor) {
		final String projectName = name;

		final Set<String> refs = new HashSet<String>();
		final List<String> srcfolders = new ArrayList<String>();
		
		srcfolders.add("src");
		srcfolders.add("src-gen");

		refs.add("org.eclipse.jdt.core;bundle-version=\"3.5.0\"");
		refs.add("org.apache.commons.logging");
		refs.add("org.apache.log4j;resolution:=optional");
		refs.add("org.eclipse.xtend.profiler;resolution:=optional");
		//Xpand project with DPF specific includes
		refs.add("no.hib.dpf.codegen.xpand.metamodel;bundle-version=\"1.0.0\"");
		refs.add("no.hib.dpf.core;bundle-version=\"0.1.1\"");
		refs.add("no.hib.dpf.codegen.xpand.ui;bundle-version=\"1.0.0\"");
		
		final IProject p = EclipseHelper.createExtXptProject(projectName,
				srcfolders, Collections.<IProject> emptyList(), refs, null,
				new SubProgressMonitor(monitor, 3), getShell());

		if (p == null)
			return;

		String encoding = ResourcesPlugin.getEncoding();
		EclipseHelper.createFile(".settings/org.eclipse.core.resources.prefs",
				p, "eclipse.preferences.version=1\nencoding/<project>="
						+ encoding + "\n", new NullProgressMonitor());
		monitor.worked(1);

		EclipseHelper.createFile(
				 ".settings/org.eclipse.xtend.shared.ui.prefs", 
				 p, 
				 "eclipse.preferences.version=1\n"
				 	+ PreferenceConstants.PROJECT_SPECIFIC_METAMODEL
				 	+ "=true\n"
				 	+ PreferenceConstants.METAMODELCONTRIBUTORS + "="
				 	+ getMetamodelContributor().getClassName(), new NullProgressMonitor());
		
		monitor.worked(1);
		
		//Cant access stuff outside of ui thread without this
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				props = new DpfMetaModelProperties(p);
				try {
					props.setNature(true);
					//We use .settings file instead
//					props.setDsmPaths(page.getMetaModelLocation());
					metaModelLocation = page.getMetaModelLocation();
				} catch (CoreException e) {
					System.err.println("Problem loading dsmlocation from wizard.");
					e.printStackTrace();
				}
				
				try {
					WorkflowParser parse = new WorkflowParser(getContentStream("workflowtemplate.txt"));
					parse.setProperty("dpf_metamodel", metaModelLocation);
					parse.setXpandEntryPoint("template::templ::main FOR dpf");
					workflowContent = parse.getXml();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (TransformerException e) {
					e.printStackTrace();
				}
				
			
			}
		});
		
		
		EclipseHelper.createFile("src/workflow/workflow.mwe", p, workflowContent, monitor);
		
		monitor.worked(1);
		
		EclipseHelper.createFile("src/template/templ.xpt", p, getContents("xpttemplate.txt"), monitor);
		
		monitor.worked(1);
		
		EclipseHelper.createFile(".settings/no.hib.dpf.codegen.xpand.ui.prefs", 
				p, 
				"eclipse.preferences.version=1\n"
				+ "metamodel.location=" + metaModelLocation, 
				new NullProgressMonitor());
		monitor.worked(1);
	}

	private Contributor getMetamodelContributor() {
		final Map<String, Contributor> availableMetamodelContributors = MetamodelContributorRegistry
				.getRegisteredMetamodelContributors();

		for (Contributor c : availableMetamodelContributors.values()) {
			if (c.getClassName().equals(
					"no.hib.dpf.codegen.xpand.ui.DpfMetaModelContributor")) {
				return c;
			}
		}

		return null;
	}

	private InputStream getContentStream(final String resource) {
		Bundle b = Platform.getBundle("no.hib.dpf.codegen.xpand.ui");
		Enumeration<URL> ee = b.findEntries("resources", resource, false);
		
		URL fileURL = null;
		
		if(ee.hasMoreElements()) {
			fileURL = ee.nextElement();
		}
		try {
			return fileURL.openStream();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String getContents(final String resource) {
		Bundle b = Platform.getBundle("no.hib.dpf.codegen.xpand.ui");
		Enumeration<URL> ee = b.findEntries("resources", resource, false);
		
		URL fileURL = null;
		
		if(ee.hasMoreElements()) {
			fileURL = ee.nextElement();
		}
		
		try {
			final InputStream inputStream = fileURL.openStream();

			final byte[] buffer = new byte[4096];
			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			while (true) {
				int read;
				read = inputStream.read(buffer);

				if (read == -1) {
					break;
				}

				outputStream.write(buffer, 0, read);
			}

			outputStream.close();
			inputStream.close();

			return outputStream.toString("UTF-8");
		}
		catch (final IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	/**
	 * We will accept the selection in the workbench to see if we can initialize
	 * from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(final IWorkbench workbench,
			final IStructuredSelection selection) {
	}

	public void setInitializationData(final IConfigurationElement config,
			final String propertyName, final Object data) throws CoreException {
		this.configElement = config;
	}
}
