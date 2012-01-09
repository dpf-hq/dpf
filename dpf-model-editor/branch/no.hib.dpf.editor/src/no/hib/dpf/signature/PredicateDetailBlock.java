package no.hib.dpf.signature;

import java.util.EventObject;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.ValidatorType;
import no.hib.dpf.core.VisualizationType;
import no.hib.dpf.editor.displaymodel.DPFDiagram;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class PredicateDetailBlock extends PredicateEditor implements IDetailsPage {


	private IManagedForm form;

	private Text name;
	private Text icon;
	private Button iconChooser;
	private Text validator;
	private ComboViewer validatorCombo;
	private ComboViewer targetCombo;
	private ComboViewer sourceCombo;
	private ComboViewer visulationCombo;
	private Section infoSection;
	private SignatureMasterBlock master;

	public PredicateDetailBlock(SignatureMasterBlock signatureMasterBlock) {
		super();
		this.master = signatureMasterBlock;
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
	}
	
	public void commandStackChanged(EventObject event){
		super.commandStackChanged(event);
		refresh();
		master.getMultiEditor().setDirty(true);
	}
	private DPFDiagram dGraph;
	private Label sourceLabel;
	private Label targetLabel;

	protected ActionRegistry getActionRegistry() {
		return master.getMultiEditor().getActionRegistry();
	}
	@Override
	public void refresh() {

		if(predicate != null){
			getGraphicalViewer().setContents(dGraph);
			name.setText(getNNullString(predicate.getSymbol()));
			infoSection.setText(getNNullString(predicate.getSymbol()));
			icon.setText(getNNullString(predicate.getIcon()));
			validatorCombo.setSelection(new StructuredSelection(predicate.getSemanticsValidator().getType()));
			validator.setText(getNNullString(predicate.getSemanticsValidator().getValidator()));
			visulationCombo.setSelection(new StructuredSelection(predicate.getVisualization().getType()));
			switch(predicate.getVisualization().getType()){
			case ARROW_LABEL: 
				targetCombo.getControl().setVisible(false);
				targetLabel.setVisible(false);
				sourceCombo.setInput(getArrows());
				IDObject source = predicate.getVisualization().getSource();
				sourceCombo.setSelection(source == null ? null : new StructuredSelection(predicate.getVisualization().getSource()));
				break;
			case NODE_TO_NODE:
				updateVisualization(getNodes(), getNodes());
				break;
			case NODE_TO_ARROW:
				updateVisualization(getNodes(), getArrows());
				break;
			case ARROW_TO_ARROW:
				updateVisualization(getArrows(), getArrows());
				break;
			case ARROW_TO_NODE:
				updateVisualization(getArrows(), getNodes());
				break;
			}
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
		if(selected instanceof Predicate){
			predicate = (Predicate) selected;
			dGraph = master.getMultiEditor().findDGraph(predicate.getShape());
			Assert.isNotNull(dGraph);
			refresh();
		}
	}


	private void updateVisualization(Object[] sources, Object[] targets){
		sourceCombo.setInput(sources);
		IDObject source1 = predicate.getVisualization().getSource();
		sourceCombo.setSelection(source1 == null ? null : new StructuredSelection(source1));
		targetCombo.setInput(targets);
		IDObject target = predicate.getVisualization().getTarget();
		targetCombo.setSelection(target == null ? null : new StructuredSelection(target));
		sourceCombo.refresh();
		targetCombo.getControl().setVisible(true);
		targetLabel.setVisible(true);
	}

	protected void addListners(){
		visulationCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				VisualizationType type = VisualizationType.get(0);
				if (!event.getSelection().isEmpty())
					type = (VisualizationType)((IStructuredSelection)event.getSelection()).getFirstElement();
				if(type == predicate.getVisualization().getType())
					return;
				predicate.getVisualization().setType(type);
				master.getMultiEditor().setDirty(true);
				refresh();
			}
		});
		sourceCombo.addSelectionChangedListener(new ISelectionChangedListener(){

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				changeVisualizationSource((IDObject)((IStructuredSelection)event.getSelection()).getFirstElement());
			}

		});
		targetCombo.addSelectionChangedListener(new ISelectionChangedListener(){

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				changeVisualizationTarget((IDObject)((IStructuredSelection)event.getSelection()).getFirstElement());
			}

		});
		validatorCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ValidatorType type = ValidatorType.get(0);
				if (!event.getSelection().isEmpty())
					type = (ValidatorType)((IStructuredSelection)event.getSelection()).getFirstElement();
				changePredicateValidator(type);
			}
		});
		validator.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				changePredicateValidator(validator.getText());
			}

			@Override
			public void focusGained(FocusEvent e) { }
		});
		name.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if(!name.getText().equals(predicate.getSymbol()))
					changePredicateName(name.getText());
			}

			@Override
			public void focusGained(FocusEvent e) { }
		});
		iconChooser.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String fileName = new FileDialog(e.display.getActiveShell()).open();
				if (fileName != null) {
					changePredicateIcon(fileName);
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
		Composite root = toolkit.createComposite(infoSection);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		root.setLayout(gridLayout);

		new Label(root, SWT.NONE).setText("Name:");
		name = new Text(root, SWT.SINGLE | SWT.BORDER);
		GridData gridData = null;
		gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		gridData.horizontalSpan = 2;
		name.setLayoutData(gridData);

		new Label(root, SWT.NONE).setText("Icon:");
		icon = new Text(root, SWT.SINGLE | SWT.BORDER);
		icon.setEditable(false);
		gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		icon.setLayoutData(gridData);
		iconChooser = new Button(root, SWT.PUSH);
		iconChooser.setText("Choose");
		iconChooser.setLayoutData(new GridData(GridData.BEGINNING, GridData.FILL, false, false));

		//Visulation
		Label visulationLabel = new Label(root, SWT.NONE);
		visulationLabel.setText("Visualtion:");
		gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		gridData.verticalSpan = 3;
		visulationLabel.setLayoutData(gridData);
		visulationCombo = new EnumeratorCombo(root, SWT.NONE);
		visulationCombo.setInput(VisualizationType.values());

		Composite source = new Composite(root, SWT.NONE);
		RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = false;
		source.setLayout(rowLayout);
		sourceLabel = new Label(source, SWT.NONE);
		sourceLabel.setText("Source:");
		sourceCombo = new ComboViewer(source, SWT.NONE);
		final IContentProvider contentProvider = new IStructuredContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }

			@Override
			public void dispose() { }

			@Override
			public Object[] getElements(Object inputElement) {
				Assert.isTrue(inputElement instanceof Object[]);
				return (Object[])inputElement;
			}
		};
		final ILabelProvider labelProvider = new LabelProvider(){
			public String getText(Object element) {
				Assert.isTrue(element instanceof IDObject);
				if(element instanceof Node)
					return "Node " + ((Node)element).getName();
				return "Arrow " + ((Arrow)element).getName();
			}
		};
		sourceCombo.setContentProvider(contentProvider);
		sourceCombo.setLabelProvider(labelProvider);
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		gridData.horizontalSpan = 2;
		gridData.minimumWidth = 20;
		source.setLayoutData(gridData);
		Composite target = new Composite(root, SWT.NONE);
		target.setLayout(rowLayout);
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		gridData.horizontalSpan = 2;
		gridData.minimumWidth = 20;
		target.setLayoutData(gridData);
		targetLabel = new Label(target, SWT.NONE);
		targetLabel.setText("Target:");
		targetCombo = new ComboViewer(target, SWT.NONE);
		targetCombo.setContentProvider(contentProvider);
		targetCombo.setLabelProvider(labelProvider);

		//Validator
		Section validSection = toolkit.createSection(parent, Section.TWISTIE| Section.TITLE_BAR);
		validSection.setExpanded(true);
		validSection.marginWidth = 10;
		validSection.setText("Validator");
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		validSection.setLayoutData(gridData);
		Composite root1 = toolkit.createComposite(validSection);
		root1.setLayout(new GridLayout());

		validatorCombo = new EnumeratorCombo(root1, SWT.NONE);
		gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		validatorCombo.getControl().setLayoutData(gridData);
		validatorCombo.setInput(ValidatorType.values());
		validator = new Text(root1, SWT.MULTI | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		validator.setLayoutData(gridData);


		Section s2 = toolkit.createSection(parent, Section.TWISTIE| Section.TITLE_BAR);
		s2.setExpanded(true);
		s2.marginWidth = 10;
		s2.setText("Graph Details"); //$NON-NLS-1$
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		s2.setLayoutData(gridData);
		Composite root2 = new Composite(s2, SWT.BORDER);//toolkit.createComposite(s2);

		root2.setLayout(new FillLayout());
		createPartControl(root2);
		toolkit.paintBordersFor(infoSection);
		toolkit.paintBordersFor(s2);
		infoSection.setClient(root);
		s2.setClient(root2);
		validSection.setClient(root1);
		refresh();
		addListners();
	}


	protected Object[] getArrows() {
		return toArray(predicate.getShape().getArrows());
	}

	protected Object[] getNodes() {
		return toArray(predicate.getShape().getNodes());
	}

	private Object[] toArray(EList<?> lists){
		return lists.toArray(new Object[lists.size()]);
	}

	protected void changeVisualizationSource(IDObject firstElement) {
		if(firstElement == predicate.getVisualization().getSource())
			return;
		predicate.getVisualization().setSource(firstElement);
		master.getMultiEditor().setDirty(true);
	}

	protected void changeVisualizationTarget(IDObject firstElement) {
		if(firstElement == predicate.getVisualization().getTarget())
			return;
		predicate.getVisualization().setTarget(firstElement);
		master.getMultiEditor().setDirty(true);
	}

	protected void changePredicateValidator(String data) {
		if(data.equals(predicate.getSemanticsValidator().getValidator()))
			return;
		predicate.getSemanticsValidator().setValidator(data);
		master.getMultiEditor().setDirty(true);
	}


	protected void changePredicateValidator(ValidatorType validatorType) {
		if(validatorType == predicate.getSemanticsValidator().getType())
			return;
		predicate.getSemanticsValidator().setType(validatorType);
		master.getMultiEditor().setDirty(true);
	}

	protected void changePredicateIcon(String fileName) {
		if(fileName.equals(predicate.getIcon()))
			return;
		predicate.setIcon(fileName);
		master.getMultiEditor().setDirty(true);
	}

	protected void changePredicateName(String newText) {
		if(newText.equals(predicate.getSymbol()))
			return;
		predicate.setSymbol(newText);
		master.refresh(predicate);
		master.getMultiEditor().setDirty(true);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		master.getMultiEditor().doSave(monitor);
	}
}
