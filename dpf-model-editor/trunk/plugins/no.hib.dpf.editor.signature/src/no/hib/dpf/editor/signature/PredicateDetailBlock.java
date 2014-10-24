package no.hib.dpf.editor.signature;


import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticValidator;
import no.hib.dpf.core.ValidatorType;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.VisualizationType;
import no.hib.dpf.diagram.util.DPFConstants;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IFileEditorInput;
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
		master.getMultiEditor().loadProperties(getGraphicalViewer());
	}

	private DGraph dGraph;
	private Label sourceLabel;
	private Label targetLabel;

	protected ActionRegistry getActionRegistry() {
		return master.getMultiEditor().getActionRegistry();
	}
	@Override
	public void refresh() {
		if(dPredicate != null){
			Predicate predicate = dPredicate.getPredicate();
			getGraphicalViewer().setContents(dGraph);
			name.setText(getNNullString(predicate.getSymbol()));
			infoSection.setText(getNNullString(predicate.getSymbol()));
			icon.setText(getNNullString(dPredicate.getIcon()));
			validatorCombo.setSelection(new StructuredSelection(predicate.getValidator().getType()));
			validator.setText(getNNullString(predicate.getValidator().getValidator()));
			visulationCombo.setSelection(new StructuredSelection(dPredicate.getVisualization().getType()));
			parameters.setText(getNNullString(predicate.getParameters()));
			refreshVisualization();
		}
	}
	
	private void refreshVisualization(){
		switch(dPredicate.getVisualization().getType()){
		case ARROW_LABEL: 
			sourceCombo.getControl().setVisible(true);
			sourceLabel.setVisible(true);
			targetCombo.getControl().setVisible(false);
			targetLabel.setVisible(false);
			sourceCombo.setInput(getArrows());
			IDObject source = dPredicate.getVisualization().getSource();
			sourceCombo.setSelection(source == null ? null : new StructuredSelection(dPredicate.getVisualization().getSource()));
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
		case COMPOSED:
		case ON_NODE:
			targetCombo.getControl().setVisible(false);
			targetLabel.setVisible(false);
			sourceCombo.getControl().setVisible(false);
			sourceLabel.setVisible(false);
			break;
		}
	}

	private String getNNullString(String value){
		return value == null ? "" : value;
	}

	private EContentAdapter adapter = new EContentAdapter() {

		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			refreshVisualization();
		}
	};

	private Text parameters;
	/*
	 * Used to indicate if a predicate is selected. 
	 * After selecting a predicate, the initial is true. After update all related controls, the initial is false;
	 */
	
	
	private boolean initial = false;
	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection)selection;
		Object selected = null;
		if(ssel.size() == 1) selected = ssel.getFirstElement();
		if(selected instanceof DPredicate && selected != dPredicate){
			initial = true;
			if(dGraph != null){
				if(dGraph.getGraph().eAdapters().contains(adapter))
					dGraph.getGraph().eAdapters().remove(adapter);
			}
			dPredicate = (DPredicate) selected;
			dGraph = dPredicate.getDGraph();
			Assert.isNotNull(dGraph);
			if(!dGraph.getGraph().eAdapters().contains(adapter))
				dGraph.getGraph().eAdapters().add(adapter);
			refresh();
			initial = false;
		}
	}


	private void updateVisualization(Object[] sources, Object[] targets){
		sourceCombo.getControl().setVisible(true);
		sourceLabel.setVisible(true);
		sourceCombo.setInput(sources);
		IDObject source1 = dPredicate.getVisualization().getSource();
		sourceCombo.setSelection(source1 == null ? null : new StructuredSelection(source1));
		targetCombo.setInput(targets);
		IDObject target = dPredicate.getVisualization().getTarget();
		targetCombo.setSelection(target == null ? null : new StructuredSelection(target));
		sourceCombo.refresh();
		targetCombo.getControl().setVisible(true);
		targetLabel.setVisible(true);
	}

	private void createOneNode(DGraph dGraph){
		DNode node = dGraph.createDNode("X", DPFConstants.REFLEXIVE_TYPE_DNODE);
		node.setLocation(new Point(50, 50));
	}
	private void createOneArrow(DGraph dGraph){
		DNode source = dGraph.createDNode("X", DPFConstants.REFLEXIVE_TYPE_DNODE),
				target = dGraph.createDNode("Y", DPFConstants.REFLEXIVE_TYPE_DNODE);
		source.setLocation(new Point(50, 50));
		target.setLocation(new Point(200, 50));
		dGraph.createDArrow("XY", source, target, DPFConstants.REFLEXIVE_TYPE_DARROW);
	}
	private void createArrowToArrow(DGraph dGraph){
		DNode source1 = dGraph.createDNode("X1", DPFConstants.REFLEXIVE_TYPE_DNODE),
				target1 = dGraph.createDNode("Y1", DPFConstants.REFLEXIVE_TYPE_DNODE);
		source1.setLocation(new Point(50, 50));
		target1.setLocation(new Point(200, 50));
		dGraph.createDArrow("XY1", source1, target1, DPFConstants.REFLEXIVE_TYPE_DARROW);
		DNode source2 = dGraph.createDNode("X2", DPFConstants.REFLEXIVE_TYPE_DNODE),
				target2 = dGraph.createDNode("Y2", DPFConstants.REFLEXIVE_TYPE_DNODE);
		source2.setLocation(new Point(50, 100));
		target2.setLocation(new Point(200, 100));
		dGraph.createDArrow("XY2", source2, target2, DPFConstants.REFLEXIVE_TYPE_DARROW);
	}
	protected void addListners(){
		visulationCombo.addSelectionChangedListener(new ISelectionChangedListener() {

			@SuppressWarnings("incomplete-switch")
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if(initial) return;
				VisualizationType type = VisualizationType.get(0);
				if (!event.getSelection().isEmpty()){
					type = (VisualizationType)((IStructuredSelection)event.getSelection()).getFirstElement();
					DGraph dGraph = dPredicate.getDGraph();
					if(dGraph != null){
						switch(type){
						case ARROW_LABEL:
							clearGraph(dGraph);
							createOneArrow(dGraph);
							break;
						case ON_NODE:
							clearGraph(dGraph);
							createOneNode(dGraph);
							break;
						case ARROW_TO_ARROW:
							clearGraph(dGraph);
							createArrowToArrow(dGraph);
							break;
						}
					}
				}
				if(type == dPredicate.getVisualization().getType())
					return;
				dPredicate.getVisualization().setType(type);
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
				if(!name.getText().equals(dPredicate.getPredicate().getSymbol()))
					changePredicateName(name.getText());
			}

			@Override
			public void focusGained(FocusEvent e) { }
		});
		parameters.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if(!parameters.getText().equals(dPredicate.getPredicate().getParameters()))
					changeParameters(parameters.getText());
			}

			@Override
			public void focusGained(FocusEvent e) { }
		});
		iconChooser.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IFile signature = ((IFileEditorInput)master.getMultiEditor().getEditorInput()).getFile();
				IProject project = signature.getProject();
				URI uri = dPredicate.eResource().getURI();
				IResource image = SignatureUtils.select(e.display.getActiveShell(), "Icon Selection", "Select a image", null, "This is not a image file", project, null, null);
				if(image == null) return;
				URI relative = URI.createFileURI(image.getLocation().toOSString());
				String fileName = relative.deresolve(uri).path();
				if (fileName != null && !fileName.equals(dPredicate.getIcon())) {
					changePredicateIcon(fileName);
					icon.setText(fileName);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
	}

	protected void clearGraph(DGraph dGraph2) {
		List<DArrow> arrows = new ArrayList<DArrow>();
		arrows.addAll(dGraph2.getDArrows());
		for(DArrow a : arrows)
			dGraph2.removeDArrow(a);
		List<DNode> nodes = new ArrayList<DNode>();
		nodes.addAll(dGraph2.getDNodes());
		for(DNode n : nodes)
			dGraph2.removeDNode(n);
		master.getMultiEditor().setDirty(true);
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
		
		new Label(infoComposite, SWT.NONE).setText("Parameters:");
		parameters = new Text(infoComposite, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		gridData.minimumWidth = 20;
		parameters.setLayoutData(gridData);
		parameters.setToolTipText("parameter1:defaultValue1;parameter2:defaultValue2;...");
		
		new Label(infoComposite, SWT.NONE).setText("Icon:");
		icon = new Text(infoComposite, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		icon.setEditable(false);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.minimumWidth = 20;
		icon.setLayoutData(gridData);
		iconChooser = new Button(infoComposite, SWT.PUSH);
		iconChooser.setText("Choose");
		iconChooser.setLayoutData(new GridData(GridData.BEGINNING, GridData.FILL, false, false));

		//Visulation
		Label visulationLabel = new Label(infoComposite, SWT.NONE);
		visulationLabel.setText("Visualization:");
		gridData = new GridData(GridData.BEGINNING, GridData.FILL, false, false);
		gridData.minimumWidth = 20;
		visulationLabel.setLayoutData(gridData);
		
		Composite visualComposite = new Composite(infoComposite, SWT.NONE);
		visualComposite.setLayoutData(new GridData(GridData.BEGINNING, GridData.FILL, false, false));
		gridLayout = new GridLayout(1, true);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		visualComposite.setLayout(gridLayout);
		
		visulationCombo = new EnumeratorCombo(visualComposite, SWT.NONE);
		visulationCombo.setInput(VisualizationType.values());
		visulationCombo.getControl().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));

		Composite source = new Composite(visualComposite, SWT.NONE);
		source.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
		gridLayout = new GridLayout(2, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		source.setLayout(gridLayout);
		sourceLabel = new Label(source, SWT.NONE);
		sourceLabel.setText("Source:");
		sourceCombo = new ComboViewer(source, SWT.NONE);
		sourceCombo.getControl().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
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
		
		Composite target = new Composite(visualComposite, SWT.NONE);
		target.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
		gridLayout = new GridLayout(2, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		target.setLayout(gridLayout);
		targetLabel = new Label(target, SWT.NONE);
		targetLabel.setText("Target:");
		targetCombo = new ComboViewer(target, SWT.NONE);
		targetCombo.getControl().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
		targetCombo.setContentProvider(contentProvider);
		targetCombo.setLabelProvider(labelProvider);

		//Validator
		Section validSection = toolkit.createSection(parent, Section.TWISTIE| Section.TITLE_BAR);
		validSection.setExpanded(true);
		validSection.marginWidth = 10;
		validSection.setText("Validator");
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		validSection.setLayoutData(gridData);
		Composite validComposite = toolkit.createComposite(validSection);
		validComposite.setLayout(gridLayout);

		Label validatorLabel = new Label(validComposite, SWT.NONE);
		validatorLabel.setText("Validator Type:");
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		validatorLabel.setData(gridData);
		
		validatorCombo = new EnumeratorCombo(validComposite, SWT.NONE);
		gridData = new GridData(GridData.BEGINNING, GridData.CENTER, false, false);
		gridData.minimumWidth = 20;
		validatorCombo.getControl().setLayoutData(gridData);
		validatorCombo.setInput(ValidatorType.values());
		
		validator = new Text(validComposite, SWT.MULTI | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalSpan = 2;
		validator.setLayoutData(gridData);

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
		toolkit.paintBordersFor(validSection);
		infoSection.setClient(infoComposite);
		graphSection.setClient(graphComposite);
		validSection.setClient(validComposite);
		refresh();
		addListners();
	}


	protected Object[] getArrows() {
		return toArray(dPredicate.getPredicate().getShape().getArrows());
	}

	protected Object[] getNodes() {
		return toArray(dPredicate.getPredicate().getShape().getNodes());
	}

	private Object[] toArray(EList<?> lists){
		return lists.toArray(new Object[lists.size()]);
	}

	protected void changeVisualizationSource(IDObject firstElement) {
		if(firstElement == dPredicate.getVisualization().getSource())
			return;
		dPredicate.getVisualization().setSource(firstElement);
		master.getMultiEditor().setDirty(true);
	}

	protected void changeVisualizationTarget(IDObject firstElement) {
		if(firstElement == dPredicate.getVisualization().getTarget())
			return;
		dPredicate.getVisualization().setTarget(firstElement);
		master.getMultiEditor().setDirty(true);
	}

	protected void changePredicateValidator(String data) {
		String old = dPredicate.getPredicate().getValidator().getValidator();
		if(data.equals(old)) return;
		dPredicate.getPredicate().getValidator().setValidator(data);
		master.getMultiEditor().setDirty(true);
	}

	protected void changePredicateValidator(ValidatorType validatorType) {
		SemanticValidator validator = dPredicate.getPredicate().getValidator();
		ValidatorType newType = validator.getType();
		if(validatorType == newType) return;
		if(!MessageDialog.openConfirm(validatorCombo.getControl().getShell(), 
				"Validator Change Confirmation", 
				"Are you changing the validator from " + validatorType.toString() + " to " + newType.toString())) return;
		validator.setType(validatorType);
		if(validatorType == ValidatorType.JAVA) validator.setValidator(no.hib.dpf.utils.DPFConstants.DefaultChecker);
		else validator.setValidator("");
		master.getMultiEditor().setDirty(true);
		refresh();
	}

	protected void changePredicateIcon(String fileName) {
		dPredicate.setIcon(fileName);
		master.getMultiEditor().setDirty(true);
	}

	protected void changePredicateName(String newText) {
		dPredicate.getPredicate().setSymbol(newText);
		master.refresh(dPredicate);
		master.getMultiEditor().setDirty(true);
	}
	protected void changeParameters(String text) {
		dPredicate.getPredicate().setParameters(text);
		master.getMultiEditor().setDirty(true);
	}
	
	protected void changePredicateParameter(String newText) {
		if(newText.equals(dPredicate.getPredicate().getParameters()))
			return;
		dPredicate.getPredicate().setParameters(newText);
		master.refresh(dPredicate);
		master.getMultiEditor().setDirty(true);
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		master.getMultiEditor().doSave(monitor);
	}
}
