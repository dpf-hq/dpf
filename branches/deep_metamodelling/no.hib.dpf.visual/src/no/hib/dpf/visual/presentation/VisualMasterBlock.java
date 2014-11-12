package no.hib.dpf.visual.presentation;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.editor.parts.listeners.UIAdapter;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VisualFactory;
import no.hib.dpf.visual.VisualPackage;
import no.hib.dpf.visual.Visuals;
import no.hib.dpf.visual.impl.VArrowImpl;
import no.hib.dpf.visual.impl.VNodeImpl;

import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class VisualMasterBlock extends MasterDetailsBlock {

	private FormPage page;
	private Visuals visuals;
	private TableViewer viewer;
	
	class VElementContentProvider implements IStructuredContentProvider {
		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof VElement[]){
				return (VElement[])(inputElement);
			}
			return new Object[0];
		}
		@Override
		public void dispose() {
		}
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}
	
	class VElementLabelProvider extends LabelProvider implements ITableLabelProvider {
		@Override
		public String getColumnText(Object obj, int index) {
			if(obj instanceof VElement){
				return ((VElement)obj).getName();
			}
			return null;
		}
		@Override
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}
	
	public VisualMasterBlock(FormPage signatureFormPage) {
		page = signatureFormPage;
		visuals = getMultiEditor().getVisuals();
		
		visuals.eAdapters().add(new UIAdapter() {

			@Override
			protected void safeNotifyChanged(Notification msg) {
				if(msg.getNotifier() == visuals){
					switch(msg.getFeatureID(visuals.getClass())){
					case VisualPackage.VISUALS__ITEMS:
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
		Section section = toolkit.createSection(parent, ExpandableComposite.TWISTIE| ExpandableComposite.TITLE_BAR);
		section.setText("VElements"); 
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
		gridData.verticalSpan = 3;
		table.setLayoutData(gridData);
		toolkit.paintBordersFor(client);
		Button addVBt = toolkit.createButton(client, "Add Node", SWT.PUSH); //$NON-NLS-1$
		addVBt.setLayoutData(new GridData(GridData.FILL, GridData.END, false, false));
		addVBt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				addVElement(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		Button addEBt = toolkit.createButton(client, "Add Arrow", SWT.PUSH); //$NON-NLS-1$
		addEBt.setLayoutData(new GridData(GridData.FILL, GridData.END, false, false));
		addEBt.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				addVElement(false);
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
				removeVElement(getSelection(viewer.getSelection()));
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
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(spart, event.getSelection());
				deBtn.setVisible(!event.getSelection().isEmpty());
			}
		});
		viewer.setContentProvider(new VElementContentProvider());
		viewer.setLabelProvider(new VElementLabelProvider());
		viewer.setInput(getVElements());
		viewer.setSelection(null);
	}

	protected void removeVElement(final List<? extends VElement> selected) {
		final VisualFormEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		domain.getCommandStack().execute(new Command("Remove VElement" + (selected.size() > 1 ? "s" : "")){
			@Override
			public boolean canExecute() {
				return visuals != null && editor != null;
			}

			@Override
			public boolean canUndo() {
				return canExecute();
			}
			@Override
			public void execute() {
				for(VElement item : selected)
					visuals.removeItem(item);
			}
			@Override
			public void undo() {
				for(VElement item : selected)
					visuals.addItem(item);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private List<? extends VElement> getSelection(ISelection selection){
		if(selection instanceof IStructuredSelection){
			return ((IStructuredSelection) selection).toList();
		}
		return new ArrayList<VElement>(0);
	}

	protected void addVElement(boolean isNode) {
		final VisualFormEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		final VElement created = getNewVisual(isNode);
		domain.getCommandStack().execute(new Command("Add " + created.getName()) {
			@Override
			public boolean canExecute() {
				return visuals != null && editor != null && created != null;
			}

			@Override
			public boolean canUndo() {
				return canExecute();
			}
			@Override
			public void execute() {
				visuals.addItem(created);
			}
			@Override
			public void undo() {
				visuals.removeItem(created);
			}
		});
	}
	
	private VElement getNewVisual(boolean isNode){
		VElement result = isNode ? VisualFactory.eINSTANCE.createVNode() : VisualFactory.eINSTANCE.createVArrow();
		int i = 0;
		VElement search = null;
		for(; i < visuals.getItems().size(); ++i){
			search = getVisualBySymbol(visuals, (isNode ? "node" : "edge") + i);
			if(search == null)
				break;
		}
		result.setName((isNode ? "node" : "edge") + i);
		return result;
	}

	private VElement getVisualBySymbol(Visuals visuals2, String string) {
		for(VElement e : visuals2.getItems())
			if(e.getName().equals(string))
				return e;
		return null;
	}

	private VElement[] getVElements() {
		if(visuals != null){
			return visuals.getItems().toArray(new VElement[visuals.getItems().size()]);
		}
		return new VElement[0];
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.registerPage(VNodeImpl.class, new VNodeBlock(this));
		detailsPart.registerPage(VArrowImpl.class, new VArrowBlock(this));
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) { }

	public void refresh(VElement vElement) {
		viewer.setInput(getVElements());
		viewer.setSelection(new StructuredSelection(vElement));
	}

	public void refresh() {
		VElement[] elements = getVElements();
		viewer.setInput(getVElements());
		if(elements.length > 0)
			viewer.setSelection(new StructuredSelection(elements[elements.length - 1]));
		else
			viewer.setSelection(null);
	}
	
	public VisualFormEditor getMultiEditor() {
		return (VisualFormEditor) page.getEditor();
	}

	public FormPage getEditor() {
		return page;
	};
}
