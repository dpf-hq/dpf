package no.hib.dpf.signature;

import java.util.EventObject;

import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.ValidatorType;
import no.hib.dpf.core.VisualizationType;
import no.hib.dpf.editor.displaymodel.DPFDiagram;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.viewers.ComboViewer;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
	private FormPage page;
	
	private Text name;
	private Text icon;
//	private Canvas graph;
	private Button iconChooser;
	private Text validator;
	private ComboViewer validatorCombo;
	private Combo targetCombo;
	private Combo sourceCombo;
	private Combo visulationCombo;
	private Section infoSection;
	static private final String[] VALIDATOR_TYPES = getEnumeratorStrings(ValidatorType.values());;//{"OCL", "Java"};;
	static private final String[] VISULATION_TYPES = getEnumeratorStrings(VisualizationType.values());;
	private SignatureMasterBlock master;
	
	public PredicateDetailBlock(FormPage page, SignatureMasterBlock signatureMasterBlock) {
		super();
		this.master = signatureMasterBlock;
		this.page = page;
	}

	private static String[] getEnumeratorStrings(Enumerator[] values){
		String[] result = new String[values.length];
		for(int i = 0; i < values.length; ++i)
			result[i] = values[i].getName();
		return result;
	}
//	private static String[] getVisulationTypes() {
//		return getEnumeratorStrings(VisualizationType.values());
////		VisualizationType[] values = VisualizationType.values();
////		String[] result = new String[values.length];
////		for(int i = 0; i < values.length; ++i)
////			result[i] = values[i].getName();
////		return result;
//	}
//
//	private static String[] getValidatorTypes() {
//		ValidatorType[] values = ValidatorType.values();
//		String[] result = new String[values.length];
//		for(int i = 0; i < values.length; ++i)
//			result[i] = values[i].getName();
//		return result;
//	}

	@Override
	public void initialize(IManagedForm form) {
		this.form = form;
	}

	@Override
	public void dispose() {
		if(predicate != null){
			if(predicate.eAdapters().contains(adpater))
				predicate.eAdapters().remove(adpater);
		}
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

	public void commandStackChanged(EventObject event){
		super.commandStackChanged(event);
		master.getEditor().setDirty(true);
	}
	private EContentAdapter adpater = new EContentAdapter(){
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			master.getEditor().setDirty(true);
		}
	};
	
	@Override
	public void refresh() {
		DPFDiagram diagram = new DPFDiagram();
		diagram.setDpfGraph(predicate.getShape());
		predicate.getShape().eAdapters().add(adpater);
		getGraphicalViewer().setContents(diagram);
		name.setText(getNNullString(predicate.getSymbol()));
		infoSection.setText(getNNullString(predicate.getSymbol()));
		icon.setText(getNNullString(predicate.getIcon()));
		int selection = getSelectionIndex(predicate.getSemanticsValidator().getType());
		validatorCombo.setSelection(new StructuredSelection(predicate.getSemanticsValidator().getType()));
		validator.setText(getNNullString(predicate.getSemanticsValidator().getValidator()));
	}

	private String getNNullString(String value){
		return value == null ? "" : value;
	}
	private int getSelectionIndex(ValidatorType validatorType) {
		return validatorType == null ? ValidatorType.JAVA_VALUE : validatorType.getValue();
	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection)selection;
		Object selected = null;
		if(ssel.size() == 1) selected = ssel.getFirstElement();
		if(selected instanceof Predicate){
			if(predicate != null){
				if(predicate.eAdapters().contains(adpater))
					predicate.eAdapters().remove(adpater);
			}
			predicate = (Predicate) selected;
			refresh();
		}
	}

	@Override
	public void createContents(Composite parent) {

		GridLayout gridLayout1 = new GridLayout();
		
		parent.setLayout(gridLayout1);

		FormToolkit toolkit = form.getToolkit();
		infoSection = toolkit.createSection(parent, Section.TWISTIE
				| Section.TITLE_BAR | Section.DESCRIPTION | Section.EXPANDED);
		infoSection.marginWidth = 10;
		infoSection.setText("Predicate Details"); //$NON-NLS-1$
		
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		infoSection.setLayoutData(gridData);
		Composite root = toolkit.createComposite(infoSection);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		root.setLayout(gridLayout);

		new Label(root, SWT.NONE).setText("Name:");
		name = new Text(root, SWT.SINGLE | SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		gridData.horizontalSpan = 2;
		name.setLayoutData(gridData);
		name.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(!name.getText().equals(predicate.getSymbol()))
					changePredicateName(name.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) { }
		});

		new Label(root, SWT.NONE).setText("Icon:");
		icon = new Text(root, SWT.SINGLE | SWT.BORDER);
		icon.setEditable(false);
		gridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		icon.setLayoutData(gridData);

		iconChooser = new Button(root, SWT.PUSH);
		iconChooser.setText("Choose");
		iconChooser.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false, false));
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

		//Validator
		Label validateLabel = new Label(root, SWT.NONE);
		validateLabel.setText("Validator:");
		gridData = new GridData(GridData.BEGINNING, GridData.BEGINNING, false, true);
		gridData.verticalSpan = 3;
		validateLabel.setLayoutData(gridData);
		validatorCombo = new ComboViewer(root, SWT.NONE);
//		validatorCombo = new Combo(root, SWT.NONE);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		validatorCombo.getControl().setLayoutData(gridData);
		validatorCombo.setContentProvider(new IStructuredContentProvider() {
			
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
			
			@Override
			public void dispose() { }
			
			@Override
			public Object[] getElements(Object inputElement) {
				assert(inputElement instanceof Enumerator[]);
				return (Enumerator[])inputElement;
			}
		});
		validatorCombo.setLabelProvider(new LabelProvider(){
			public String getText(Object element) {
				assert(element instanceof Enumerator);
				return ((Enumerator)element).getLiteral();
//				return element == null ? "" : element.toString();//$NON-NLS-1$
			}
		});
		validatorCombo.setInput(ValidatorType.values());
//		validatorCombo.setLayoutData(gridData);
//		validatorCombo.setItems(VALIDATOR_TYPES);
		validatorCombo.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ValidatorType type = ValidatorType.get(0);
				if (!event.getSelection().isEmpty())
					type = (ValidatorType)((IStructuredSelection)event.getSelection()).getFirstElement();
				changePredicateValidator(type);
			}
		});
//		validatorCombo.addSelectionListener(new SelectionListener() {
//			
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				int selected = (Integer) e.data;
//				changePredicateValidator(ValidatorType.get(selected));
//			}
//			
//			@Override
//			public void widgetDefaultSelected(SelectionEvent e) { }
//		});
		validator = new Text(root, SWT.BORDER | SWT.MULTI);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalSpan = 2;
		gridData.verticalSpan = 2;
		validator.setLayoutData(gridData);
		validator.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				changePredicateValidator(validator.getText());
			}
			
			@Override
			public void focusGained(FocusEvent e) { }
		});

		//Visulation
		Label visulationLabel = new Label(root, SWT.NONE);
		visulationLabel.setText("Visulation:");
		gridData = new GridData(GridData.BEGINNING, GridData.BEGINNING, false, false);
		gridData.verticalSpan = 3;
		visulationLabel.setLayoutData(gridData);
		visulationCombo = new Combo(root, SWT.NONE);
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		gridData.horizontalSpan = 2;
		visulationCombo.setLayoutData(gridData);
		visulationCombo.setItems(VISULATION_TYPES);
		visulationCombo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selected = (Integer) e.data;
//				ValidatorType type = VisualizationType.get(selected);
				switch(selected){
				case VisualizationType.ARROW_LABEL_VALUE:
					targetCombo.setVisible(false);
//					sourceCombo.setI
					break;
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Composite source = new Composite(root, SWT.NONE);
		RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = false;
		source.setLayout(rowLayout);
		new Label(source, SWT.NONE).setText("Source:");
		sourceCombo = new Combo(source, SWT.NONE);
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		gridData.horizontalSpan = 2;
		source.setLayoutData(gridData);
		Composite target = new Composite(root, SWT.NONE);
		target.setLayout(rowLayout);
		gridData = new GridData(GridData.FILL, GridData.CENTER, false, false);
		gridData.horizontalSpan = 2;
		target.setLayoutData(gridData);
		new Label(target, SWT.NONE).setText("Target:");
		targetCombo = new Combo(target, SWT.NONE);
		
		Section s2 = toolkit.createSection(parent, Section.TWISTIE | Section.TITLE_BAR | Section.DESCRIPTION | Section.EXPANDED);
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
	}
	
	protected void changePredicateValidator(String data) {
		predicate.getSemanticsValidator().setValidator(data);
		master.getEditor().setDirty(true);
	}

	protected void changePredicateValidator(ValidatorType validatorType) {
		predicate.getSemanticsValidator().setType(validatorType);
		master.getEditor().setDirty(true);
	}

	protected void changePredicateIcon(String fileName) {
		predicate.setIcon(fileName);
		master.getEditor().setDirty(true);
	}

	protected void changePredicateName(String newText) {
		predicate.setSymbol(newText);
		master.refresh(predicate);
		master.getEditor().setDirty(true);
	}

	public IWorkbenchPartSite getSite() {
        return page.getEditor().getSite();
    }

	@Override
	public void doSave(IProgressMonitor monitor) {
		page.getEditor().doSave(monitor);
	}
}
