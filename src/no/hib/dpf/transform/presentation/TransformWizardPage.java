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

import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.util.TransformUtils;

import org.eclipse.emf.common.util.URI;
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
 * This class is copypasta from {@link WizardNewLinkPage} which can't be subclassed.
 * Internal classes has been replaced with Eclipse API classes. 
 * The Variable button has been removed, as well as validation for folders.
 */
public class TransformWizardPage extends WizardPage {
	protected Text sourceMetaModelFileText;
	protected Text targetMetaModelFileText;

	private String sourceURIMetamodel = "";
	private String targetURIMetamodel = "";

	private Button sourceMetaModelFileChooser;
	private Button targetMetaModelFileChooser;

	private Text sigFileText;

	private Button sigFileChooser;

	private DSpecification sourceMetaModel = DPFConstants.REFLEXIVE_DSPECIFICATION;
	private DSpecification targetMetaModel = DPFConstants.REFLEXIVE_DSPECIFICATION;

	private DSignature sig;


	private static final String DEFAULT_SOURCE_METAMODEL = "Souce Default Metamodel";
	private static final String DEFAULT_TARGET_METAMODEL = "Target Default Metamodel";
	private static final String DEFAULTSIGNATURE = "Source Default Signature";
	private static final String ENDOGENOUS_TRANSFORMATION = "Endogenous Transformation";

	public TransformWizardPage(String pageId) {
		super(pageId);
	}
	private ResourceSetImpl resourceSet = TransformUtils.getResourceSet();
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

		final Button endogenous = new Button(composite, SWT.CHECK);{
			endogenous.setText(ENDOGENOUS_TRANSFORMATION);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			endogenous.setLayoutData(data);
		}

		final Button sourceMetaModelButton = new Button(composite, SWT.CHECK);{
			sourceMetaModelButton.setText(DEFAULT_SOURCE_METAMODEL);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			sourceMetaModelButton.setLayoutData(data);
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
					sourceMetaModel = DPFUtils.loadDSpecification(resourceSet, URI.createFileURI(sourceMetaModelFileText.getText()));
					sourceURIMetamodel = sourceMetaModelFileText.getText();
					if(endogenous.getSelection()){
						targetMetaModel = sourceMetaModel;
						targetURIMetamodel = sourceURIMetamodel;
					}
					setPageComplete(validatePage());
				}
			});
		}
		final Button targetMetaModelButton = new Button(composite, SWT.CHECK);{
			targetMetaModelButton.setText(DEFAULT_TARGET_METAMODEL);
			GridData data = new GridData();
			data.horizontalSpan = 3;
			targetMetaModelButton.setLayoutData(data);
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
					targetMetaModel = DPFUtils.loadDSpecification(resourceSet, URI.createFileURI(targetMetaModelFileText.getText()));
					targetURIMetamodel = targetMetaModelFileText.getText();
					setPageComplete(validatePage());
				}
			});
		}
		sourceMetaModelButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean useDefault = sourceMetaModelButton.getSelection();
				sourceMetaModelFileText.setEnabled(!useDefault);
				sourceMetaModelFileChooser.setEnabled(!useDefault);
				sourceMetaModel = useDefault ? DPFConstants.REFLEXIVE_DSPECIFICATION : DPFUtils.loadDSpecification(resourceSet, URI.createFileURI(sourceMetaModelFileText.getText()));
				sourceURIMetamodel = useDefault ? null : sourceMetaModelFileText.getText();
				if(endogenous.getSelection()){
					targetMetaModel = sourceMetaModel;
					targetURIMetamodel = sourceURIMetamodel;
				}
				setPageComplete(validatePage());
			}
		});
		endogenous.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean endo = endogenous.getSelection();
				boolean checked = sourceMetaModelButton.getSelection();
				sourceMetaModelFileChooser.setEnabled(!checked);
				sourceMetaModelFileText.setEnabled(!checked);
				targetMetaModelButton.setEnabled(!endo);
				endo = !endo &&  !targetMetaModelButton.getSelection();
				targetMetaModelFileText.setEnabled(endo);
				targetMetaModelFileChooser.setEnabled(endo);
			}
		});

		targetMetaModelButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean useDefault = targetMetaModelButton.getSelection();
				targetMetaModelFileText.setEnabled(!useDefault);
				targetMetaModelFileChooser.setEnabled(!useDefault);
				targetMetaModel = useDefault ? DPFConstants.REFLEXIVE_DSPECIFICATION : DPFUtils.loadDSpecification(resourceSet, URI.createFileURI(targetMetaModelFileText.getText()));
				targetURIMetamodel = useDefault ? null : targetMetaModelFileText.getText();
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
		}
		defaultSigButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean useDefault = defaultSigButton.getSelection();
				sigFileText.setEnabled(!useDefault);
				sigFileChooser.setEnabled(!useDefault);
				sig = useDefault ? DPFConstants.DEFAULT_DSIGNATURE : DPFUtils.loadDSignature(URI.createFileURI(sourceMetaModelFileText.getText()));
				setPageComplete(validatePage());
			}
		});

		/*
		 * Initialize the fields to make sure the default metamodel and default signature are used by default
		 */
		endogenous.setSelection(true);
		sourceMetaModelButton.setSelection(true);
		sourceMetaModelFileText.setEnabled(false);
		sourceMetaModelFileChooser.setEnabled(false);
		targetMetaModelButton.setSelection(true);
		targetMetaModelButton.setEnabled(false);
		targetMetaModelFileText.setEnabled(false);
		targetMetaModelFileChooser.setEnabled(false);

		sourceMetaModel = DPFConstants.REFLEXIVE_DSPECIFICATION;
		targetMetaModel = DPFConstants.REFLEXIVE_DSPECIFICATION;
		sourceURIMetamodel = null;
		targetURIMetamodel = null;

		//		DSpecification defaultSpec = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		//		defaultSpec.setDSignature(DiagramFactory.eINSTANCE.createDefaultDSignature());
		//		defaultSpec.setDType(DiagramFactory.eINSTANCE.createDefaultDSpecification());
		//		targetMetaModel = defaultSpec;

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
		return sourceMetaModel != null && sig != null && targetMetaModel != null;
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
