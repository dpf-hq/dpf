package no.hib.dpf.transform.presentation;
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
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
 * This class is copypasta from {@link WizardNewLinkPage} which can't be subclassed.
 * Internal classes has been replaced with Eclipse API classes. 
 * The Variable button has been removed, as well as validation for folders.
 */
public class TransformWizardPage extends WizardPage {
	protected Text sourceMetaModelFileText;
	protected Text targetMetaModelFileText;
	
	private String sourceURIMetamodel;
	private String targetURIMetamodel;

	private Button sourceMetaModelFileChooser;
	private Button targetMetaModelFileChooser;

	private Text sigFileText;

	private Button sigFileChooser;

	private DSpecification sourceMetaModel;
	private DSpecification targetMetaModel;

	private DSignature sig;
	
	private Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	private static final String DEFAULTMETAMODEL = "Default Metamodel";
	private static final String DEFAULTSIGNATURE = "Default Signature";
	private static final String ENDOGENOUS_TRANSFORMATION = "Endogenous Transformation";

	public TransformWizardPage(String pageId) {
		super(pageId);
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE); {
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

		final Button defaultMetamodelButton = new Button(composite, SWT.CHECK);{
			defaultMetamodelButton.setText("Use " + DEFAULTMETAMODEL);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			defaultMetamodelButton.setLayoutData(data);
		}
		sourceMetaModelFileText = new Text(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			sourceMetaModelFileText.setLayoutData(data);
		}
		
		sourceMetaModelFileChooser = new Button(composite, SWT.PUSH);
		{
			setButtonLayoutData(sourceMetaModelFileChooser);
			sourceMetaModelFileChooser.setText("&Browse...");
			sourceMetaModelFileChooser.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent event) {
					handleModelBrowseButtonPressed(sourceMetaModelFileText, "*.dpf");
					//metaModel = DPFUtils.loadDSpecification(TransformEditor.getResourceSet(), URI.createFileURI(metaModelFileText.getText()), resourceToDiagnosticMap);
					sourceMetaModel = DPFUtils.loadDModel(URI.createFileURI(sourceMetaModelFileText.getText()));
					sourceURIMetamodel = sourceMetaModelFileText.getText();
					setPageComplete(validatePage());
				}
			});
			sourceMetaModelFileChooser.setEnabled(true);
		}
		final Button targetMetaModelFileButton = new Button(composite, SWT.CHECK);{
			targetMetaModelFileButton.setText(ENDOGENOUS_TRANSFORMATION);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			targetMetaModelFileButton.setLayoutData(data);
		}
		targetMetaModelFileText = new Text(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			targetMetaModelFileText.setLayoutData(data);
		}
		
		targetMetaModelFileChooser = new Button(composite, SWT.PUSH);
		{
			setButtonLayoutData(targetMetaModelFileChooser);
			targetMetaModelFileChooser.setText("&Browse...");
			targetMetaModelFileChooser.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent event) {
					handleModelBrowseButtonPressed(targetMetaModelFileText, "*.dpf");
					//metaModel = DPFUtils.loadDSpecification(TransformEditor.getResourceSet(), URI.createFileURI(metaModelFileText.getText()), resourceToDiagnosticMap);
					targetMetaModel = DPFUtils.loadDModel(URI.createFileURI(targetMetaModelFileText.getText()));
					targetURIMetamodel = targetMetaModelFileText.getText();
					setPageComplete(validatePage());
				}
			});
			targetMetaModelFileChooser.setEnabled(true);
		}
		defaultMetamodelButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean useDefault = defaultMetamodelButton.getSelection();
				if(useDefault){
					sourceMetaModelFileText.setEnabled(false);
					sourceMetaModelFileChooser.setEnabled(false);
					sourceMetaModel = DPFConstants.REFLEXIVE_DSPECIFICATION;
				}else{
					sourceMetaModelFileText.setEnabled(true);
					sourceMetaModelFileChooser.setEnabled(true);
					sourceMetaModel = DPFUtils.loadDModel(URI.createFileURI(sourceMetaModelFileText.getText()));
					if(targetMetaModelFileButton.getEnabled()){
						System.out.println("Check");
						targetMetaModel = sourceMetaModel;
						targetURIMetamodel = sourceMetaModelFileText.getText();
					}
					//metaModel = DPFUtils.loadDSpecification(TransformEditor.getResourceSet(), URI.createFileURI(metaModelFileText.getText()), resourceToDiagnosticMap);
					sourceURIMetamodel = sourceMetaModelFileText.getText();
				}
				setPageComplete(validatePage());
			}
		});
		targetMetaModelFileButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean isEndogenous_transformation = targetMetaModelFileButton.getSelection();
				if(isEndogenous_transformation){
					targetMetaModelFileText.setEnabled(false);
					targetMetaModelFileChooser.setEnabled(false);
				}else{
					targetMetaModelFileText.setEnabled(true);
					targetMetaModelFileChooser.setEnabled(true);
					targetMetaModel = DPFUtils.loadDModel(URI.createFileURI(targetMetaModelFileText.getText()));
					System.out.println("herigjen");
					//metaModel = DPFUtils.loadDSpecification(TransformEditor.getResourceSet(), URI.createFileURI(metaModelFileText.getText()), resourceToDiagnosticMap);
					targetURIMetamodel = targetMetaModelFileText.getText();
				}
				setPageComplete(validatePage());
			}
		});

		final Button defaultSigButton = new Button(composite, SWT.CHECK);{
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
			setButtonLayoutData(sourceMetaModelFileChooser);
			sigFileChooser.setText("&Browse...");
			sigFileChooser.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					handleModelBrowseButtonPressed(sigFileText, "*.sig");
					sig = DPFUtils.loadDSignature(URI.createFileURI(sigFileText.getText()));
					setPageComplete(validatePage());
				}
			});
			sigFileChooser.setEnabled(true);
		}
		defaultSigButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean useDefault = defaultSigButton.getSelection();
				if(useDefault){
					sigFileText.setEnabled(false);
					sigFileChooser.setEnabled(false);
					sig = DPFConstants.DEFAULT_DSIGNATURE;
				}else{
					sigFileText.setEnabled(true);
					sigFileChooser.setEnabled(true);
					sig = DPFUtils.loadDSignature(URI.createFileURI(sourceMetaModelFileText.getText()));
				}
				setPageComplete(validatePage());
			}
		});

		/*
		 * Initialize the fields to make sure the default metamodel and default signature are used by default
		 */
		defaultMetamodelButton.setSelection(true);
		sourceMetaModelFileText.setEnabled(false);
		sourceMetaModelFileChooser.setEnabled(false);
		sourceMetaModel = DPFConstants.REFLEXIVE_DSPECIFICATION;
		
		targetMetaModelFileButton.setSelection(true);
		targetMetaModelFileText.setEnabled(false);
		targetMetaModelFileChooser.setEnabled(false);
		targetMetaModel = sourceMetaModel;
		
		defaultSigButton.setSelection(true);
		sigFileText.setEnabled(false);
		sigFileChooser.setEnabled(false);
		sig = DPFConstants.DEFAULT_DSIGNATURE;
		setPageComplete(validatePage());
		setControl(composite);
	}

	protected void handleModelBrowseButtonPressed(Text targetField, String name) {
		String selection = null;
		FileDialog fileDialog = new FileDialog(getShell(), SWT.SHEET);
		fileDialog.setFileName(initialLocation);
		fileDialog.setFilterExtensions(new String[]{name, "*.*"});
		selection = fileDialog.open();
		if (selection != null) {
			targetField.setText(selection);
		}
	}

	protected boolean validatePage() {
		if(sourceMetaModel != null && sig != null){
			return true;
		}
		return false;
	}

	public Object getSelectionObject(ISelection selection){
		if(selection instanceof StructuredSelection){
			StructuredSelection ss = (StructuredSelection) selection;
			return ss.getFirstElement();
		}
		return null;
	}

	String initialLocation = null;
	public void setInitialLocation(String filename) {
		initialLocation = filename;
	}

	public DSpecification getSourceMetaModel() {
		return sourceMetaModel;
	}
	
	public DSpecification getTargetMetaModel() {
		return targetMetaModel;
	}

	public DSignature getSignature() {
		return sig;
	}
	public String getSourceMetaModelURI(){
		return sourceURIMetamodel;
	}
	public String getTargetMetaModelURI(){
		return targetURIMetamodel;
	}
}
