package no.hib.dpf.editor.diagrams.classdiagram.dialogs;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
//import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * 
 * @author Ole Klokkhammer
 * 
 */
public class ClassDiagramMethodDialog extends Dialog {

	protected Shell shell;
	private Text methodNameInput;
	Combo returnTypeCombo;

	//
	protected DGraph dgraph;
	protected DNode newMethodDNode;
	private Label lblName;
	private Label lblType;
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Text potencyText;
	private Label potency;
	private Button cancelButton;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param dspec
	 */
	public ClassDiagramMethodDialog(Shell parent, DGraph dgraph, DNode newMethodDNode) {
		super(parent, SWT.ON_TOP);
		setText("Create new method");
		this.dgraph = dgraph;
		this.newMethodDNode = newMethodDNode;

	}

	/**
	 * Opens a dialog, creating a new method with basis on the input sourceDNode
	 * 
	 * @param sourceDNode
	 * @return the newly created method
	 */
	public DNode open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		getParent().setEnabled(false);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		getParent().setEnabled(true);
		return newMethodDNode;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.BORDER | SWT.CLOSE);
		shell.setSize(268, 158);
		Monitor primary = shell.getMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
		
		shell.setText("Create New Method");
		shell.setLayout(null);

		lblName = new Label(shell, SWT.NONE);
		lblName.setBounds(5, 10, 36, 15);
		lblName.setImage(null);
		lblName.setText("Name");
										Label label = new Label(shell, SWT.NONE);
										label.setBounds(171, 74, 0, 15);
										formToolkit.adapt(label, true, true);
								
										potency = new Label(shell, SWT.NONE);
										potency.setBounds(5, 37, 43, 15);
										potency.setText("Potency");
						
								lblType = new Label(shell, SWT.NONE);
								lblType.setBounds(5, 65, 61, 15);
								lblType.setText("Return type");
				
						methodNameInput = new Text(shell, SWT.BORDER);
						methodNameInput.setBounds(72, 7, 157, 21);
		
				potencyText = new Text(shell, SWT.BORDER);
				potencyText.setBounds(72, 34, 157, 21);
				formToolkit.adapt(potencyText, true, true);
		
		returnTypeCombo = new Combo(shell, SWT.READ_ONLY);
		returnTypeCombo.setBounds(72, 61, 157, 23);
		for (String datatype : DPFCoreConstants.getEDataTypesMap().keySet()) {
			returnTypeCombo.add(datatype);
		}
		
		
		formToolkit.adapt(returnTypeCombo);
		formToolkit.paintBordersFor(returnTypeCombo);
		
				Button btnGenerate = formToolkit.createButton(shell, "Ok", SWT.CENTER);
				btnGenerate.setBounds(153, 95, 76, 25);
				btnGenerate.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
					}
				});
				btnGenerate.addListener(SWT.Selection,
						new GenerateMethodActionListener());
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(5, 152, 0, 15);
		formToolkit.adapt(label_1, true, true);
		
		cancelButton = formToolkit.createButton(shell, "Cancel", SWT.CENTER);
		cancelButton.setBounds(72, 95, 61, 25);
		cancelButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});
	}

	/**
	 * 
	 * @author Ole Klokkhammer
	 */
	class GenerateMethodActionListener implements Listener {

		@Override
		public void handleEvent(Event e) {
			if (e.type == SWT.Selection) {
//				int potency = (int) CorePackage.Literals.DEEP_ELEMENT__POTENCY
//						.getDefaultValue();
//				try {
//					potency = Integer.parseInt(potencyText.getText().trim());
//				} catch (NumberFormatException nEx) {
//				}
				
//				String returnType = returnTypeCombo.getItem(returnTypeCombo.getSelectionIndex());
				
				// create the method:
//				newMethodDNode = ClassDiagramMethodUtilities.createNewMethodForMethodDNode(
//						newMethodDNode, methodNameInput.getText(), potency, returnType, dgraph);

				// close the dialog
				shell.dispose();
			}
		}
	}
}
