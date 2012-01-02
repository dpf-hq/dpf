package no.hib.dpf.signature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import no.hib.dpf.core.*;
import no.hib.dpf.core.impl.PredicateImpl;

public class SignatureMasterBlock extends MasterDetailsBlock {

	private FormPage page;
	private Signature signature;
	private TableViewer viewer;
	private SignatureEditor editor;
	
	class SignatureContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Predicate[]){
				return (Predicate[])(inputElement);
			}
			return new Object[0];
		}
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	class SignatureLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			if(obj instanceof Predicate){
				return ((Predicate)obj).getSymbol();
			}
			return null;
		}
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}
	public SignatureMasterBlock(FormPage signatureFormPage, SignatureEditor editor) {
		page = signatureFormPage;
		this.editor = editor;
		this.signature = editor.getSignature();
	}

	@Override
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		//final ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		Section section = toolkit.createSection(parent, Section.DESCRIPTION | Section.TITLE_BAR);
		section.setText("Predicates"); //$NON-NLS-1$
		section.setDescription("Predicates"); //$NON-NLS-1$
		section.marginWidth = 10;
		section.marginHeight = 5;
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);
		Table table = toolkit.createTable(client, SWT.NULL);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 20;
		gridData.widthHint = 100;
		table.setLayoutData(gridData);
		toolkit.paintBordersFor(client);
		Button addBt = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
		gridData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		addBt.setLayoutData(gridData);
		addBt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				addPredicate();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		section.setClient(client);
		final SectionPart spart = new SectionPart(section);
		managedForm.addPart(spart);
		viewer = new TableViewer(table);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(spart, event.getSelection());
			}
		});
		viewer.setContentProvider(new SignatureContentProvider());
		viewer.setLabelProvider(new SignatureLabelProvider());
		viewer.setInput(getPredicates());
	}
	

	protected void addPredicate() {
		Predicate created = getNewPrediate();
		signature.getPredicates().add(created);
		refresh(created);
		editor.setDirty(true);
	}
	
	private Predicate getNewPrediate(){
		Predicate result = CoreFactory.eINSTANCE.createPredicate();
		int i = 0;
		Predicate search = null;
		for(; i < signature.getPredicates().size(); ++i){
			search = signature.getPredicateBySymbol("predicate" + i);
			if(search == null)
				break;
		}
		result.setSymbol("predicate" + i);
		return result;
	}

	private Object getPredicates() {
		SignatureEditor editor = (SignatureEditor) page.getEditor();
		Signature signature = editor.getSignature();
		if(signature != null){
			EList<Predicate> predicates = signature.getPredicates();
			return predicates.toArray(new Predicate[predicates.size()]);
		}
		return new Object[0];
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.registerPage(PredicateImpl.class, new PredicateDetailBlock(page, this));
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) { }

	public void refresh(Predicate predicate) {
		viewer.setInput(getPredicates());
		viewer.setSelection(new StructuredSelection(predicate));
	}

	public SignatureEditor getEditor() {
		return editor;
	};
}
