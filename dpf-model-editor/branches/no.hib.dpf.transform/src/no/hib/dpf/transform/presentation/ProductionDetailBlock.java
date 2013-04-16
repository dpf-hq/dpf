package no.hib.dpf.transform.presentation;


import java.util.jar.Attributes.Name;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.transform.Production;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class ProductionDetailBlock extends ProductionEditor implements IDetailsPage {


	private IManagedForm form;

	private Text name;
	private Section infoSection;
	private TransformMasterBlock master;
	private static String currentProduction;

	public ProductionDetailBlock(TransformMasterBlock master) {
		super();
		this.master = master;
		setEditDomain(master.getMultiEditor().getEditDomain());
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

	protected void initializeGraphicalViewer(){
		super.initializeGraphicalViewer();
		getSite().setSelectionProvider(getGraphicalViewer());
		master.getMultiEditor().loadProperties(getGraphicalViewer());
	}

	private DGraph dGraph;

	protected ActionRegistry getActionRegistry() {
		return master.getMultiEditor().getActionRegistry();
	}
	@Override
	public void refresh() {
		if(production != null){
			getGraphicalViewer().setContents(production.getSum().getDGraph());
			name.setText(getNNullString(production.getName()));
		}
	}

	private String getNNullString(String value){
		return value == null ? "" : value;
	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection)selection;
		Object selected = null;
		if(ssel.size() == 1) selected = ssel.getFirstElement();
		if(selected instanceof Production){
			production = (Production) selected;
			currentProduction = production.getName();
			dGraph = production.getSum().getDGraph();
			Assert.isNotNull(dGraph);
			refresh();
		}
	}

	protected void addListners(){
		name.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if(!name.getText().equals(production.getName()))
					changeProductName(name.getText());
			}
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
		
		Section graphSection = toolkit.createSection(parent, Section.TWISTIE| Section.TITLE_BAR);
		graphSection.setExpanded(true);
		graphSection.marginWidth = 10;
		graphSection.setText("Graph Details"); //$NON-NLS-1$
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		graphSection.setLayoutData(gridData);
		Composite graphComposite = new Composite(graphSection, SWT.BORDER);//toolkit.createComposite(s2);

		graphComposite.setLayout(new FillLayout());
		createPartControl(graphComposite);

		toolkit.paintBordersFor(infoSection);
		toolkit.paintBordersFor(graphSection);
		infoSection.setClient(infoComposite);
		graphSection.setClient(graphComposite);
		refresh();
		addListners();
	}


	protected Object[] getArrows() {
		return toArray(production.getSum().getDGraph().getGraph().getArrows());
	}

	protected Object[] getNodes() {
		return toArray(production.getSum().getDGraph().getGraph().getNodes());
	}

	private Object[] toArray(EList<?> lists){
		return lists.toArray(new Object[lists.size()]);
	}

	protected void changeProductName(String newText) {
		production.setName(newText);
		currentProduction = newText;
		master.refresh(production);
		master.getMultiEditor().setDirty(true);
	}
	

	@Override
	public void doSave(IProgressMonitor monitor) {
		master.getMultiEditor().doSave(monitor);
	}
	public static String getCurrentProduction(){
		return currentProduction;
	}
}
