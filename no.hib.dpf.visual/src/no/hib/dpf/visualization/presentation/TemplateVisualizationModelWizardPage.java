package no.hib.dpf.visualization.presentation;

/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM Corporation - initial API and implementation 
 *   Sebastian Davids <sdavids@gmx.de> - Fix for bug 19346 - Dialog
 * 	 	font should be activated and used by other components.
 *******************************************************************************/

//import org.eclipse.core.filesystem.IFileStore;
import java.util.HashMap;

import no.hib.dpf.core.Graph;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFEditor;
//import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
//import no.hib.dpf.editor.nature.DPFProjectSupport;
import no.hib.dpf.editor.utilities.DPFModelPersistanceUtils;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;
import no.hib.dpf.utils.DPFCoreConstants;
import no.hib.dpf.visual.VisualUtils;
import no.hib.dpf.visual.Visuals;
import no.hib.dpf.visualization.util.VisualizationModelUtils;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewLinkPage;

/**
 * This class is copypasta from {@link WizardNewLinkPage} which can't be
 * subclassed. Internal classes has been replaced with Eclipse API classes. The
 * Variable button has been removed, as well as validation for folders.
 */
public class TemplateVisualizationModelWizardPage extends WizardPage {
	protected Text metaModelFileText;

	private Button metaModelFileChooser;

	protected Text visualModelFileText;
	
	private Button visualModelFileChooser;
	
	private Text sigFileText;

	private Button sigFileChooser;

	private DSpecification metaModel;
	
	private Visuals visualModel;

	private DSignature sig;

	private static final String DEFAULTMETAMODEL = "Default Template Metamodel (Class Diagram)";
	
	private static final String DEFAULTVISUALMODEL = "Default Visual Model (Class Diagram)";

	private static final String DEFAULTSIGNATURE = "Default Signature";
	
	public TemplateVisualizationModelWizardPage(String pageId) {
		super(pageId);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.grabExcessVerticalSpace = true;
			composite.setLayoutData(data);
		}

		//*************************************************************************************************
		// diagram model
		
		final Button defaultMetamodelButton = new Button(composite, SWT.CHECK);
		{
			defaultMetamodelButton.setText("Use " + DEFAULTMETAMODEL);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			defaultMetamodelButton.setLayoutData(data);
		}

		metaModelFileText = new Text(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			metaModelFileText.setLayoutData(data);
		}

		metaModelFileChooser = new Button(composite, SWT.PUSH);
		{
			setButtonLayoutData(metaModelFileChooser);
			metaModelFileChooser.setText("&Browse...");
			metaModelFileChooser.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					handleModelBrowseButtonPressed(metaModelFileText, "*.dpf");
					metaModel = DPFModelPersistanceUtils.loadDModel(URI.createFileURI(metaModelFileText.getText()));
					setPageComplete(validatePage());
				}
			});
			metaModelFileChooser.setEnabled(true);
		}
		defaultMetamodelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean useDefault = defaultMetamodelButton.getSelection();
				if (useDefault) {
					metaModelFileText.setEnabled(false);
					metaModelFileChooser.setEnabled(false);
					metaModel = getDefaultMetamodel(DPFTemplateUtils.DEFAULT_CLASS_DIAGRAM_TEMPLATE);
				} else {
					metaModelFileText.setEnabled(true);
					metaModelFileChooser.setEnabled(true);
					metaModel = DPFModelPersistanceUtils.loadDModel(URI.createFileURI(metaModelFileText.getText()));
				}
				setPageComplete(validatePage());
			}
		});
		
		// end of diagram model spec
		//******************************************************************************************************************
		
		//******************************************************************************************************************
		// visual model
		final Button defaultVisualmodelButton = new Button(composite, SWT.CHECK);
		{
			defaultVisualmodelButton.setText("Use " + DEFAULTVISUALMODEL);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			defaultVisualmodelButton.setLayoutData(data);
		}

		visualModelFileText = new Text(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			visualModelFileText.setLayoutData(data);
		}

		visualModelFileChooser = new Button(composite, SWT.PUSH);
		{
			setButtonLayoutData(visualModelFileChooser);
			visualModelFileChooser.setText("&Browse...");
			visualModelFileChooser.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					handleModelBrowseButtonPressed(visualModelFileText, "*.visual");
					visualModel = VisualizationModelUtils.getDefaultVisualModel(initialLocation);
					visualModel = VisualUtils.loadVisuals(new ResourceSetImpl(), URI.createFileURI(visualModelFileText.getText()), new HashMap<Resource, Diagnostic>());
					setPageComplete(validatePage());
				}
			});
			visualModelFileChooser.setEnabled(true);
		}
		defaultVisualmodelButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean useDefault = defaultVisualmodelButton.getSelection();
				if (useDefault) {
					visualModelFileText.setEnabled(false);
					visualModelFileChooser.setEnabled(false);
					visualModel = VisualizationModelUtils.getDefaultVisualModel(initialLocation);
				} else {
					visualModelFileText.setEnabled(true);
					visualModelFileChooser.setEnabled(true);
					visualModel = VisualUtils.loadVisuals(new ResourceSetImpl(), URI.createFileURI(visualModelFileText.getText()), new HashMap<Resource, Diagnostic>());
				}
				setPageComplete(validatePage());
			}
		});
		
		// end of visual model spec
		//******************************************************************************************************************

		final Button defaultSigButton = new Button(composite, SWT.CHECK);
		{
			defaultSigButton.setText("Use " + DEFAULTSIGNATURE);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			defaultSigButton.setLayoutData(data);
		}

		sigFileText = new Text(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			sigFileText.setLayoutData(data);
		}
		sigFileChooser = new Button(composite, SWT.PUSH);
		{
			setButtonLayoutData(metaModelFileChooser);
			sigFileChooser.setText("&Browse...");
			sigFileChooser.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					handleModelBrowseButtonPressed(sigFileText, "*.sig");
					sig = DPFModelPersistanceUtils.loadDSignature(URI.createFileURI(sigFileText
							.getText()));
					setPageComplete(validatePage());
				}
			});
			sigFileChooser.setEnabled(true);
		}
		defaultSigButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				boolean useDefault = defaultSigButton.getSelection();
				if (useDefault) {
					sigFileText.setEnabled(false);
					sigFileChooser.setEnabled(false);
					sig = DPFConstants.DEFAULT_DSIGNATURE;
				} else {
					sigFileText.setEnabled(true);
					sigFileChooser.setEnabled(true);
					sig = DPFModelPersistanceUtils.loadDSignature(URI
							.createFileURI(metaModelFileText.getText()));
				}
				setPageComplete(validatePage());
			}
		});

		/*
		 * Initialize the fields to make sure the default metamodel and default
		 * signature are used by default
		 */
		defaultMetamodelButton.setSelection(true);
		metaModelFileText.setEnabled(false);
		metaModelFileChooser.setEnabled(false);
		
		
		defaultVisualmodelButton.setSelection(true);
		visualModelFileText.setEnabled(false);
		visualModelFileChooser.setEnabled(false);
		
		
		metaModel = getDefaultMetamodel(DPFTemplateUtils.DEFAULT_CLASS_DIAGRAM_TEMPLATE);
		visualModel = VisualizationModelUtils.getDefaultVisualModel(initialLocation);
		defaultSigButton.setSelection(true);

		sigFileText.setEnabled(false);
		sigFileChooser.setEnabled(false);
		sig = DPFConstants.DEFAULT_DSIGNATURE;
		setPageComplete(validatePage());
		setControl(composite);
	}

	
	private DSpecification getDefaultMetamodel(String selection) {
		switch (selection) {
		case DPFCoreConstants.NODE:
			return DPFConstants.REFLEXIVE_DSPECIFICATION;
		case DPFTemplateUtils.DEFAULT_CLASS_DIAGRAM_TEMPLATE:	
			return getDefaultTemplateMetamodel();
		}
		return null;
	}

	/**
	 * TODO refer to file in filestructure instead of copying the metamodel to the new project?
	 * @return
	 */
	private DSpecification getDefaultTemplateMetamodel() {
		String filePath = new String(initialLocation);
		
		String workspace = DPFEditor.getWorkspaceDirectory();
		workspace = workspace.replace("/", "\\");
		if(filePath.contains(workspace)){
			filePath = filePath.substring(workspace.length(), filePath.length());
		}
		int i = filePath.indexOf("\\");
		if(i == 0){
			i = filePath.indexOf("\\", 2);
		}
		//System.out.println("filePaht: "+filePath);
		if(i != -1){
		  filePath = filePath.substring(0, i);
		}
		//workspace += filePath + "\\" + DPFProjectSupport.FOLDERNAME_TEMPLATE_METAMODELS + "\\Template.dpf";
		
		DSpecification spec = DPFModelPersistanceUtils.loadDModel(URI.createFileURI(workspace));
		return spec;
	}

	protected void handleModelBrowseButtonPressed(Text targetField, String name) {
		String selection = null;
		FileDialog fileDialog = new FileDialog(getShell(), SWT.SHEET);
		fileDialog.setFileName(initialLocation);
		fileDialog.setFilterExtensions(new String[] { name, "*.*" });
		selection = fileDialog.open();
		if (selection != null) {
			targetField.setText(selection);
		}
	}

	protected boolean validatePage() {
		if (metaModel != null && sig != null) {
			Graph graph = metaModel.getDGraph().getGraph();
//			if(graph != null && graph.getPotency() == 0){
//				return false;//TODO
//			}
			return true;
		}
		return false;
	}

	public Object getSelectionObject(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection;
			return ss.getFirstElement();
		}
		return null;
	}

	String initialLocation = null;

	public void setInitialLocation(String filename) {
		initialLocation = filename;
	}

	public DSpecification getMetaModel() {
		return metaModel;
	}
	
	public Visuals getVisualModel() {
		return visualModel;
	}

	public DSignature getSignature() {
		return sig;
	}

}
