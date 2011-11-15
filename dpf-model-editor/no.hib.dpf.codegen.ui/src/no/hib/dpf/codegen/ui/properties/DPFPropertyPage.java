package no.hib.dpf.codegen.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.PropertyPage;

public class DPFPropertyPage extends PropertyPage implements
		IWorkbenchPropertyPage, DPFCodegenConstants {
	
	CodegenProperties properties;
	//UI Elements
	Button hasGenerateCodeNature, modelDirDialog, contDirDialog, generateAnnotations;
	Text modelDir, controllerDir;
	Group cgOptions;
	Label modelt, controllert;

	public DPFPropertyPage() {
		super();
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = buildUI(parent);

		try {
			IAdaptable adaptable = getElement();
			//TODO: What about other project types?
			if(adaptable instanceof IJavaProject) {
				properties = new CodegenProperties(((IJavaProject) adaptable).getProject());
			} else
				properties = new CodegenProperties((IProject)adaptable);
			
			readProperties();
		} catch(CoreException e) {
			e.printStackTrace();
			System.err.println("Something went wrong when initializing project settings");
		}
		return control;
	}
	
	private void readProperties() throws CoreException {
		hasGenerateCodeNature.setSelection(properties.hasNature());
		generateAnnotations.setSelection(Boolean.valueOf(properties.getGenerateAnnotations()));
		
		modelDir.setText(properties.getModelSrcDir());
		controllerDir.setText(properties.getControllerSrcDir());
		
		if(!properties.hasNature()) {
			enableDisableAllWidgets(false);
		}
	}
	
	private void writeProperties() throws CoreException {
		properties.setNature(hasGenerateCodeNature.getSelection());
		properties.setGenerateAnnotations(generateAnnotations.getSelection());
		properties.setTargetDirs(modelDir.getText(), controllerDir.getText());
	}
	
	private Control buildUI(final Composite parent) {
		Composite comp = new Composite(parent, SWT.NULL);
		RowLayout rLayout = new RowLayout();
		GridData gd;
		
		rLayout.type = SWT.VERTICAL;
		comp.setLayout(rLayout);
		
		GridLayout groupLayout = new GridLayout();
		groupLayout.numColumns = 3;

		//Checkbox
		hasGenerateCodeNature = new Button(comp, SWT.CHECK);
		hasGenerateCodeNature.setText("Generate Code");
		
		cgOptions = new Group(comp, SWT.NONE);
		cgOptions.setText("Code generation options");
		cgOptions.setLayout(groupLayout);
		
		gd = new GridData();
		gd.horizontalSpan = 3;
		generateAnnotations = new Button(cgOptions, SWT.CHECK);
		generateAnnotations.setLayoutData(gd);
		generateAnnotations.setText("Generate JPA/Hibernate annotations");
		
		modelt = new Label(cgOptions, SWT.RIGHT);
		modelt.setText("Model directory");
		
		modelDir = new Text(cgOptions, SWT.SINGLE);
		gd = new GridData();
		gd.widthHint = super.convertWidthInCharsToPixels(40);
		modelDir.setLayoutData(gd);
		
		modelDirDialog = new Button(cgOptions, SWT.PUSH);
		modelDirDialog.setText("Browse");
		
		controllert = new Label(cgOptions, SWT.RIGHT);
		controllert.setText("Controller directory");
		
		controllerDir = new Text(cgOptions, SWT.SINGLE);
		controllerDir.setLayoutData(gd);
		
		contDirDialog = new Button(cgOptions, SWT.PUSH);
		contDirDialog.setText("Browse");
		
		hasGenerateCodeNature.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				enableDisableAllWidgets(hasGenerateCodeNature.getSelection());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		modelDirDialog.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog dialog = new ContainerSelectionDialog(parent.getShell(), 
						properties.getProject(), true, "Select target directory");
				dialog.open();
				if(dialog.getResult() != null) {
					Path p = (Path)dialog.getResult()[0];
					modelDir.setText(p.toFile().getAbsolutePath());
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		contDirDialog.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog dialog = new ContainerSelectionDialog(parent.getShell(), 
						properties.getProject(), true, "Select target directory");
				dialog.open();
				if(dialog.getResult() != null) {
					Path p = (Path)dialog.getResult()[0];
					controllerDir.setText(p.toFile().getAbsolutePath());
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		return parent;
	}
	
	private void enableDisableAllWidgets(boolean val) {
		cgOptions.setEnabled(val);
		modelDir.setEnabled(val);
		modelt.setEnabled(val);
		modelDirDialog.setEnabled(val);
		contDirDialog.setEnabled(val);
		controllert.setEnabled(val);
		controllerDir.setEnabled(val);
		generateAnnotations.setEnabled(val);
	}
	
	@Override
	public boolean performOk() {
		try {
			writeProperties();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return super.performOk();
	}
	@Override
	protected void performApply() {
		try {
			writeProperties();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		super.performApply();
	}
	@Override
	protected void performDefaults() {
		//TODO: fjerne defaultknapp?
		super.performDefaults();
	}
}
