package no.hib.dpf.transform.util;

import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.transform.presentation.TransformWizardPage;
import no.hib.dpf.transform.presentation.DPFCreationWizard.CreationPage;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;	
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

public class BrowseInstanceModel extends Wizard implements IWizard{

	  protected CreationPage page = null;

	  public BrowseInstanceModel() {
	    super();
	    setNeedsProgressMonitor(true);
	  }

	  @Override
	  public void addPages() {
		  page = new CreationPage();
		  addPage(page);
	  }
  
	  @Override
	  public boolean performFinish() {
	    // Print the result to the console
	    System.out.println(page.getText1());

	    return true;
	  }

	public class CreationPage extends WizardPage {
		  private Text text1;
		  private Composite container;
	
		  public CreationPage() {
		    super("First Page");
		    
		  }
	
		  @Override
		  public void createControl(Composite parent) {
		    container = new Composite(parent, SWT.NONE);
		    GridLayout layout = new GridLayout();
		    container.setLayout(layout);
		    layout.numColumns = 2;
		    Label label1 = new Label(container, SWT.NONE);
		    label1.setText("Put here a value");
	
		    text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
		    text1.setText("");
		    text1.addKeyListener(new KeyListener() {
	
		      @Override
		      public void keyPressed(KeyEvent e) {
		      }
	
		      @Override
		      public void keyReleased(KeyEvent e) {
		        if (!text1.getText().isEmpty()) {
		          setPageComplete(true);
	
		        }
		      }
	
		    });
		    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		    text1.setLayoutData(gd);
		    // Required to avoid an error in the system
		    setControl(container);
		    setPageComplete(false);
	
		  }
	
		  public String getText1() {
		    return text1.getText();
		  }
	}
	public class NewDialogWindow extends WizardDialog{

		public NewDialogWindow(Shell parentShell, IWizard newWizard) {
			super(parentShell, newWizard);
			// TODO Auto-generated constructor stub
		}
	}
}
	 