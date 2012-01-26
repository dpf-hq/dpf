/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.codegen.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

import no.hib.dpf.codegen.xpand.ui.properties.DpfMetaModelProperties;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Specification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.displaymodel.DPFDiagram;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;

/**
 * Create a new .dpf-file.
 */
public class NewDPFPlayWizard extends Wizard implements INewWizard {

	private static int fileCount = 1;
	private CreationPage page1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#addPages()
	 */
	public void addPages() {
		// add pages to this wizard
		addPage(page1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		page1 = new CreationPage(workbench, selection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	public boolean performFinish() {
		return page1.finish();
	}

	/**
	 * This WizardPage can create an empty .shapes file for the ShapesEditor.
	 */
	private class CreationPage extends WizardNewFileCreationPage {

		/**
		 * Hides the advanced option widgets.
		 */
		protected void handleAdvancedButtonSelect() {
		}

		private static final String DEFAULT_EXTENSION = ".dpf";
		private final IWorkbench workbench;

		/**
		 * Create a new wizard page instance.
		 * 
		 * @param workbench
		 *            the current workbench
		 * @param selection
		 *            the current object selection
		 * @see NewDPFPlayWizard#init(IWorkbench, IStructuredSelection)
		 */
		CreationPage(IWorkbench workbench, IStructuredSelection selection) {
			super("dpfCreationPage1", selection);
			this.workbench = workbench;
			setTitle("Create a new " + DEFAULT_EXTENSION + " file");
			setDescription("Create a new " + DEFAULT_EXTENSION + " file");
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#createControl(org
		 * .eclipse.swt.widgets.Composite)
		 */
		public void createControl(Composite parent) {
			super.createControl(parent);
			setFileName("dpfSpecification" + fileCount + DEFAULT_EXTENSION);
			setPageComplete(validatePage());
		}

		/** Return a new DPFDiagram instance. */
		private Object createDefaultContent() {
			return new DPFDiagram();
		}

		/**
		 * This method will be invoked, when the "Finish" button is pressed.
		 * 
		 * @see NewDPFPlayWizard#performFinish()
		 */
		private boolean finish() {
			// create a new file, result != null if successful
			IFile newFile = createNewFile();
			fileCount++;
			
			Bundle bb = Platform.getBundle("no.hib.dpf.codegen.generator");
			Enumeration<URL> ce = bb.findEntries("metamodel", "m3.dpf.xmi", false);
			// Gets null value when user does not check checkbox
			URL typeFileURL = null;
			
			if(ce.hasMoreElements()) {
				typeFileURL = ce.nextElement();
			}
			System.out.println("Bundle location:" + bb.getLocation());
			
			URI specificationURI = null;
			try {
				specificationURI = URI.createURI(typeFileURL.toURI().toString());
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
			
			if (typeFileURL != null) {
				// TODO: move to validation (when wrong file, user must be
				// notified)
				Specification typeSpec = null;
				try {
					typeSpec = CoreFactory.eINSTANCE.loadSpecification(specificationURI);
				} catch (IOException e) {
					e.printStackTrace();
				}

				Specification newSpec = CoreFactory.eINSTANCE
						.createSpecification();
				newSpec.setTypeGraph(typeSpec.getGraph());

				String dpfFile = DPFEditor.getDPFFileName(newFile.getFullPath().toString());

				DPFEditor.saveDPF(dpfFile, newSpec);
			}

			// open newly created file in the editor
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
					.getActivePage();
			DpfMetaModelProperties properties;
			if (newFile != null && page != null) {
				try {
					properties = new DpfMetaModelProperties(newFile.getProject());
					properties.setNature(true);
					properties.setDsmPaths(typeFileURL.toURI().toString());
					
					IDE.openEditor(page, newFile, true);
				} catch (PartInitException e) {
					e.printStackTrace();
					return false;
				} catch (CoreException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#getInitialContents()
		 */
		protected InputStream getInitialContents() {
			ByteArrayInputStream bais = null;
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(createDefaultContent()); // argument must be
															// Serializable
				oos.flush();
				oos.close();
				bais = new ByteArrayInputStream(baos.toByteArray());
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			return bais;
		}

		/**
		 * Return true, if the file name entered in this page is valid.
		 */
		private boolean validateFilename() {
			if (getFileName() != null
					&& getFileName().endsWith(DEFAULT_EXTENSION)) {
				return true;
			}
			setErrorMessage("The 'file' name must end with "
					+ DEFAULT_EXTENSION);
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ui.dialogs.WizardNewFileCreationPage#validatePage()
		 */
		protected boolean validatePage() {
			return super.validatePage() && validateFilename();
		}
	}
}
