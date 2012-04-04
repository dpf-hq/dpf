package no.hib.dpf.signature;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Predicate;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.diagram.impl.DPredicateImpl;
import no.hib.dpf.editor.parts.listeners.UIAdapter;

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
	private DSignature dSignature;
	private TableViewer viewer;
	
	class DSignatureContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof DPredicate[]){
				return (DPredicate[])(inputElement);
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
			if(obj instanceof DPredicate){
				return ((DPredicate)obj).getPredicate().getSymbol();
			}
			return null;
		}
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}
	
	public SignatureMasterBlock(FormPage signatureFormPage) {
		page = signatureFormPage;
		dSignature = getMultiEditor().getSignature();
		
		dSignature.eAdapters().add(new UIAdapter() {

			@Override
			protected void safeNotifyChanged(Notification msg) {
				if(msg.getNotifier() == dSignature){
					switch(msg.getFeatureID(DSignature.class)){
					case DiagramPackage.DSIGNATURE__DPREDICATES:
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
				addDPredicate();
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
		viewer.setContentProvider(new DSignatureContentProvider());
		viewer.setLabelProvider(new SignatureLabelProvider());
		viewer.setInput(getDPredicates());
		viewer.setSelection(null);
	}

	protected void removePredicate(final List<? extends DPredicate> selected) {
		final SignatureEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		domain.getCommandStack().execute(new Command("Add Predicate" + (selected.size() > 1 ? "s" : "")){
			public boolean canExecute() {
				return dSignature != null && editor != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				for(DPredicate dPredicate : selected)
					dSignature.removeDPredicate(dPredicate);
			}
			public void undo() {
				for(DPredicate dPredicate : selected)
					dSignature.addDPredicate(dPredicate);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private List<? extends DPredicate> getSelection(ISelection selection){
		if(selection instanceof IStructuredSelection){
			return ((IStructuredSelection) selection).toList();
		}
		return new ArrayList<DPredicate>(0);
	}

	protected void addDPredicate() {
		final SignatureEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		final DPredicate created = getNewDPrediate();
		domain.getCommandStack().execute(new Command("Add Predicate") {
			public boolean canExecute() {
				return dSignature != null && editor != null && created != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				dSignature.addDPredicate(created);
			}
			public void undo() {
				dSignature.removeDPredicate(created);
			}
		});
	}
	
	private DPredicate getNewDPrediate(){
		DPredicate result = DiagramFactory.eINSTANCE.createDefaultDPredicate();
		int i = 0;
		Predicate search = null;
		for(; i < dSignature.getDPredicates().size(); ++i){
			search = dSignature.getSignature().getPredicateBySymbol("predicate" + i);
			if(search == null)
				break;
		}
		result.getPredicate().setSymbol("predicate" + i);
		return result;
	}

	private DPredicate[] getDPredicates() {
		if(dSignature != null){
			EList<DPredicate> predicates = dSignature.getDPredicates();
			return predicates.toArray(new DPredicate[predicates.size()]);
		}
		return new DPredicate[0];
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.registerPage(DPredicateImpl.class, new PredicateDetailBlock(this));
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) { }

	public void refresh(DPredicate predicate) {
		viewer.setInput(getDPredicates());
		viewer.setSelection(new StructuredSelection(predicate));
	}

	public void refresh() {
		DPredicate[] predicates = getDPredicates();
		viewer.setInput(getDPredicates());
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
