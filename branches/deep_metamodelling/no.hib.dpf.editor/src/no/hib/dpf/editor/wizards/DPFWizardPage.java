package no.hib.dpf.editor.wizards;

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
import no.hib.dpf.core.Graph;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFDiagramConstants;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.nature.DPFProjectSupport;
import no.hib.dpf.editor.utilities.DPFModelPersistanceUtils;
import no.hib.dpf.utils.DPFCoreConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewLinkPage;

/**
 * This class is copypasta from {@link WizardNewLinkPage} which can't be
 * subclassed. Internal classes has been replaced with Eclipse API classes. The
 * Variable button has been removed, as well as validation for folders.
 */
public class DPFWizardPage extends WizardPage {
	protected Text metaModelFileText;

	private Button metaModelFileChooser;

	private Combo selectDefaultMetaModel;

	private Text sigFileText;
	
	private Label infoText;

	private Button sigFileChooser;

	private DSpecification metaModel;

	private DSignature sig;

	private static final String DEFAULTMETAMODEL = "Default Metamodel";

	private static final String DEFAULTSIGNATURE = "Default Signature";
	
	public DPFWizardPage(String pageId) {
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

		final Button defaultMetamodelButton = new Button(composite, SWT.CHECK);
		{
			defaultMetamodelButton.setText("Use " + DEFAULTMETAMODEL);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			defaultMetamodelButton.setLayoutData(data);
		}

		selectDefaultMetaModel = new Combo(composite, SWT.READ_ONLY);
		{
			String[] elements = { DPFCoreConstants.NODE};
			selectDefaultMetaModel.setItems(elements);
			GridData data = new GridData();
			data.horizontalSpan = 2;
			selectDefaultMetaModel.setLayoutData(data);
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
					selectDefaultMetaModel.setEnabled(true);
					selectDefaultMetaModel.select(1);
					metaModel = getDefaultMetamodel();
				} else {
					metaModelFileText.setEnabled(true);
					metaModelFileChooser.setEnabled(true);
					selectDefaultMetaModel.setEnabled(false);
					metaModel = DPFModelPersistanceUtils.loadDModel(URI.createFileURI(metaModelFileText.getText()));
				}
				setPageComplete(validatePage());
			}
		});

		selectDefaultMetaModel.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String selection = selectDefaultMetaModel.getText();
				metaModel = getDefaultMetamodel();
				setPageComplete(validatePage());
			}
		});

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
					sig = DPFDiagramConstants.DEFAULT_DSIGNATURE;
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
		
		selectDefaultMetaModel.setEnabled(true);
		selectDefaultMetaModel.select(1);
		metaModel = getDefaultMetamodel();
		defaultSigButton.setSelection(true);

		sigFileText.setEnabled(false);
		sigFileChooser.setEnabled(false);
		sig = DPFDiagramConstants.DEFAULT_DSIGNATURE;
		setPageComplete(validatePage());
		setControl(composite);
	}

	
	private DSpecification getDefaultMetamodel() {
			return DPFDiagramConstants.REFLEXIVE_DSPECIFICATION;
	}

	private DSpecification getClabjectMetamodel() {
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
		filePath = filePath.substring(0, i);
		
		workspace += filePath + "\\" + DPFProjectSupport.FOLDERNAME_TEMPLATE_METAMODELS + "\\Template.dpf";
		
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
			if(graph != null && graph.getPotency() == 0){
				if(infoText != null){
					infoText.setText("ERROR!");
				}
				return false;
			}
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

	public DSignature getSignature() {
		return sig;
	}

}
