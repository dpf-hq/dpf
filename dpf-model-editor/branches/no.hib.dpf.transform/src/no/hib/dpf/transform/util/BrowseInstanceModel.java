package no.hib.dpf.transform.util;

import java.util.LinkedHashMap;

import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.presentation.TransformEditor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog; 
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;

public class BrowseInstanceModel extends Dialog {

	private Text modelInstance;
	private Text targetInstance;
	private Button instanceModelFileChooser;
	private Label errorSourceMessage;
	
	private Transform transform = null;
	
	private DSpecification sourceDSpecification = null;
	private DSpecification targetDSpecification = null;
	
	private Specification sourcespecification = null;
	private Specification targetspecification = null;
	
	private String sourceDSpec = "";
	private String sourceSpec = ""; 
	
	private String targetDSpec = "";
	private String targetSpec = ""; 
	
	private String modelInstanceFilePath;
	private String targetModelName;
	
	
	public BrowseInstanceModel(Shell parent, Transform transform) {
		super(parent);
		
		this.transform = transform;
		
		sourceDSpecification = transform.getSourceMetaModel();
		targetDSpecification = transform.getTargetMetaModel();

		sourceDSpec = transform.getSourceLocation();
		targetDSpec = transform.getTargetLocation();
		
		sourceSpec = sourceDSpec.replace(".dpf", ".xmi");
		targetSpec = targetDSpec.replace(".dpf", ".xmi");
		
		targetspecification = DPFUtils.loadSpecification(URI.createFileURI(sourceDSpec.replace(".dpf", ".xmi")));
		System.out.println("UIR: " + targetspecification.eResource().getURI());
	}
	
	protected Control createDialogArea(Composite parent) { 
		
		Composite composite = (Composite) super.createDialogArea(parent);
	    GridLayout layout = new GridLayout(3, false);
	    layout.marginRight = 5;
	    layout.marginLeft = 10;
	    layout.marginTop = 10;
	    composite.setLayout(layout);

	    Label source_model = new Label(composite, SWT.NONE);
	    source_model.setText("Source Model:");

	    modelInstance = new Text(composite, SWT.BORDER);
	    modelInstance.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
	        1, 1));

	    instanceModelFileChooser = new Button(composite, SWT.PUSH);
	    {
			setButtonLayoutData(instanceModelFileChooser);
			instanceModelFileChooser.setText("&Browse...");
			instanceModelFileChooser.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent event) {
					handleModelBrowseButtonPressed(modelInstance, "*.dpf");
					
					String uri = modelInstance.getText();
					DSpecification newTargetDSpec = DPFUtils.loadDSpecification(URI.createFileURI(uri));
					
				}
			});
			instanceModelFileChooser.setEnabled(true);
		}
	    
	    errorSourceMessage = new Label(composite, SWT.NONE);
	    errorSourceMessage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, SWT.FILL, 0));
	    errorSourceMessage.setFont(new Font(null, "Segoe UI", 9, SWT.BOLD));
	    errorSourceMessage.setText("Type specification from instance model does not match source specification");
	    errorSourceMessage.setForeground(new Color(null, 255, 0, 0));
	    errorSourceMessage.setVisible(false);
	    
	    
		Table table = new Table(composite, SWT.FULL_SELECTION | SWT.BORDER);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, SWT.FILL, 0));
		
		table.setHeaderVisible(true);
		
		TableColumn one = new TableColumn(table, SWT.NONE);
		
		TableColumn two = new TableColumn(table, SWT.NONE);
		
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0, "Source Metamodel");
		item.setText(1, sourceDSpec);
		
		item = new TableItem(table, SWT.NONE);
		item.setText(0, "Source Specification");
		item.setText(1, sourceSpec);
		
		item = new TableItem(table, SWT.NONE);
		item.setText(0, "Target Metamodel");
		item.setText(1, targetDSpec);
			
		item = new TableItem(table, SWT.NONE);
		item.setText(0, "Target Specification");
		item.setText(1, targetSpec);
	
		one.pack();
		two.pack();
		
		Label target_model = new Label(composite, SWT.NONE);
	    target_model.setText("Target Model Name:");
		
	    targetInstance = new Text(composite, SWT.BORDER);
	    targetInstance.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
	        1, 1));
	    
		return composite; 
		
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Execute", true);
		createButton(parent, IDialogConstants.CANCEL_ID,
	    IDialogConstants.CANCEL_LABEL, false);	
	}
	@Override
	protected Point getInitialSize() {
		return new Point(600, 300);
	}
	@Override
	protected void okPressed(){
		modelInstanceFilePath = modelInstance.getText().toString();
		targetModelName = targetInstance.getText().toString();
		super.okPressed();
	}
	
	public String getModelInstanceFilePath(){
		return modelInstanceFilePath;
	}
	public String getTargetModelName(){
		return targetModelName;
	}
	
	
	
	protected void handleModelBrowseButtonPressed(Text targetField, String name) {
		String selection = null;
		FileDialog fileDialog = new FileDialog(getShell(), SWT.SHEET);
		fileDialog.setFileName(null);
		fileDialog.setFilterExtensions(new String[]{name, "*.*"});
		selection = fileDialog.open();
		if (selection != null) {
			targetField.setText(selection);
		}
	}

}
