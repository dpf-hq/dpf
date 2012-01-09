package no.hib.dpf.signature;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.impl.PredicateImpl;
import no.hib.dpf.editor.displaymodel.DPFDiagram;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
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

public class SignatureMasterBlock extends MasterDetailsBlock {

	private FormPage page;
	private Signature signature;
	private TableViewer viewer;
	
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
	
	public SignatureMasterBlock(FormPage signatureFormPage) {
		page = signatureFormPage;
		signature = getMultiEditor().getSignature();
		
		signature.eAdapters().add(new no.hib.dpf.editor.parts.UIAdapter() {

			@Override
			protected void safeNotifyChanged(Notification msg) {
				if(msg.getNotifier() == signature){
					switch(msg.getFeatureID(Signature.class)){
					case CorePackage.SIGNATURE__PREDICATES:
						refresh();
						break;
					}
				}
			}
		});
	}

	@Override
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		//final ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		Section section = toolkit.createSection(parent, Section.TWISTIE| Section.TITLE_BAR);
		section.setText("Predicates"); 
		section.setExpanded(true);
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
		gridData.verticalSpan = 2;
		table.setLayoutData(gridData);
		toolkit.paintBordersFor(client);
		Button addBt = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
		addBt.setLayoutData(new GridData(GridData.FILL, GridData.END, false, false));
		addBt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				addPredicate();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		final Button deBtn = toolkit.createButton(client, "REMOVE", SWT.PUSH); //$NON-NLS-1$
		deBtn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
		deBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				removePredicate(getSelection(viewer.getSelection()));
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
				deBtn.setVisible(!event.getSelection().isEmpty());
			}
		});
		viewer.setContentProvider(new SignatureContentProvider());
		viewer.setLabelProvider(new SignatureLabelProvider());
		viewer.setInput(getPredicates());
		viewer.setSelection(null);
	}

	protected void removePredicate(final List<? extends Predicate> selected) {
		final SignatureEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor .getEditDomain();
		final List<DPFDiagram> graphs = editor.findDGraph(selected);
		domain.getCommandStack().execute(new Command("Add Predicate" + (selected.size() > 1 ? "s" : "")){
			public boolean canExecute() {
				return signature != null && editor != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				if(signature.getPredicates().containsAll(selected))
					signature.getPredicates().removeAll(selected);
				editor.removeDGraph(graphs);
			}
			public void undo() {
				editor.addDGraph(graphs);
				if(!signature.getPredicates().containsAll(selected))
					signature.getPredicates().addAll(selected);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private List<? extends Predicate> getSelection(ISelection selection){
		if(selection instanceof IStructuredSelection){
			return ((IStructuredSelection) selection).toList();
		}
		return new ArrayList<Predicate>(0);
	}

	protected void addPredicate() {
		final SignatureEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		final Predicate created = getNewPrediate();
		DPFDiagram dGraph = new DPFDiagram(null);//.eINSTANCE.createDGraph();
		dGraph.setDpfGraph(created.getShape());
		final List<DPFDiagram> dGraphs = new ArrayList<DPFDiagram>(1);
		dGraphs.add(dGraph);
		domain.getCommandStack().execute(new Command("Add Predicate") {
			public boolean canExecute() {
				return signature != null && editor != null && created != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				editor.addDGraph(dGraphs);
				if(!signature.getPredicates().contains(created))
					signature.getPredicates().add(created);
			}
			public void undo() {
				if(signature.getPredicates().contains(created))
					signature.getPredicates().remove(created);
				editor.removeDGraph(dGraphs);
			}
		});
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

	private Predicate[] getPredicates() {
		if(signature != null){
			EList<Predicate> predicates = signature.getPredicates();
			return predicates.toArray(new Predicate[predicates.size()]);
		}
		return new Predicate[0];
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.registerPage(PredicateImpl.class, new PredicateDetailBlock(this));
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) { }

	public void refresh(Predicate predicate) {
		viewer.setInput(getPredicates());
		viewer.setSelection(new StructuredSelection(predicate));
	}

	public void refresh() {
		Predicate[] predicates = getPredicates();
		viewer.setInput(getPredicates());
		if(predicates.length > 0)
			viewer.setSelection(new StructuredSelection(predicates[predicates.length - 1]));
		else
			viewer.setSelection(null);
	}
	
	public SignatureEditor getMultiEditor() {
		return (SignatureEditor) page.getEditor();
	}

	public FormPage getEditor() {
		return page;
	};
}
