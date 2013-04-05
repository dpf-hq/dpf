package no.hib.dpf.visual.presentation;


import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.FileSelection;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.Visuals;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.EditorPart;

public abstract class AbstractBlock extends EditorPart implements IDetailsPage {


	private IManagedForm form;
	protected Text name;
	protected Text icon;
	protected Button iconChooser;
	protected Section infoSection;
	protected VisualMasterBlock master;
	protected static List<Boolean> BOOLEANS = new ArrayList<Boolean>();
	static{
		BOOLEANS.add(true);
		BOOLEANS.add(false);
	}

	public AbstractBlock(VisualMasterBlock signatureMasterBlock) {
		super();
		this.master = signatureMasterBlock;
	}

	private FormPage getEditor(){
		return master.getEditor();
	}

	public IWorkbenchPartSite getSite(){
		return getEditor().getSite();
	}
	@Override
	public void initialize(IManagedForm form) {
		this.form = form;
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public void commit(boolean onSave) {
	}

	@Override
	public boolean setFormInput(Object input) {
		return false;
	}

	@Override
	public void setFocus() {

	}

	@Override
	public boolean isStale() {
		return false;
	}
	protected Visuals visuals;
	protected VElement vElement;

	@Override
	public void refresh() {
		if(vElement != null){
			name.setText(getNNullString(vElement.getName()));
			icon.setText(getNNullString(vElement.getIcon()));
			refreshOthers();
		}
	}
	
	protected abstract void refreshOthers();

	private String getNNullString(String value){
		return value == null ? "" : value;
	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection)selection;
		Object selected = null;
		if(ssel.size() == 1) selected = ssel.getFirstElement();
		if(selected instanceof VElement){
			vElement =  (VElement) selected;
			visuals = (Visuals) vElement.eContainer();
			Assert.isNotNull(visuals);
			refresh();
		}
	}

	protected void addListners(){
		name.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if(!name.getText().equals(vElement.getName()))
					changeVisualName(name.getText());
			}

			@Override
			public void focusGained(FocusEvent e) { }
		});
		iconChooser.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IFile signature = ((IFileEditorInput)master.getMultiEditor().getEditorInput()).getFile();
				IProject project = signature.getProject();
				URI uri = vElement.eResource().getURI();
				IResource image = FileSelection.select(e.display.getActiveShell(), "Icon Selection", "Select a image", null, "This is not a image file", project, null, null);
				if(image == null) return;
				URI relative = URI.createFileURI(image.getLocation().toOSString());
				String fileName = relative.deresolve(uri).path();
				if (fileName != null && !fileName.equals(vElement.getIcon())) {
					changeVisualIcon(fileName);
					icon.setText(fileName);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
	}
	
	@Override
	public void createContents(Composite parent) {
		parent.setLayout(new GridLayout());

		FormToolkit toolkit = form.getToolkit();
		infoSection = toolkit.createSection(parent, Section.TWISTIE| Section.TITLE_BAR);
		infoSection.marginWidth = 10;
		infoSection.setExpanded(true);
		infoSection.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
		Composite infoComposite = toolkit.createComposite(infoSection);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		infoComposite.setLayout(gridLayout);

		new Label(infoComposite, SWT.NONE).setText("Name:");
		name = new Text(infoComposite, SWT.SINGLE | SWT.BORDER);
		GridData gridData = null;
		gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		gridData.minimumWidth = 20;
		name.setLayoutData(gridData);
		
		
		new Label(infoComposite, SWT.NONE).setText("Icon:");
		icon = new Text(infoComposite, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		icon.setEditable(false);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.minimumWidth = 20;
		icon.setLayoutData(gridData);
		iconChooser = new Button(infoComposite, SWT.PUSH);
		iconChooser.setText("Choose");
		iconChooser.setLayoutData(new GridData(GridData.BEGINNING, GridData.FILL, false, false));

		createControl(infoComposite);
		toolkit.paintBordersFor(infoSection);
		infoSection.setClient(infoComposite);
		refresh();
		addListners();
	}

	protected abstract void createControl(Composite infoComposite) ;

	protected void changeVisualIcon(String fileName) {
		vElement.setIcon(fileName);
		master.getMultiEditor().setDirty(true);
	}

	protected void changeVisualName(String newText) {
		vElement.setName(newText);
		master.refresh(vElement);
		master.getMultiEditor().setDirty(true);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		master.getMultiEditor().doSave(monitor);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void doSaveAs() {
		
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		
	}
}
