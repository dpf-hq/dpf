package no.hib.dpf.transform.presentation;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.parts.listeners.UIAdapter;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.TransformFactory;
import no.hib.dpf.transform.TransformPackage;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

public class TransformMasterBlock extends MasterDetailsBlock {

	private FormPage page;
	private Transform transform;
	private TableViewer viewer;

//	class TransformContentProvider extends ArrayContentProvider {
//		public Object[] getElements(Object inputElement) {
//			return inputElement instanceof Production[] ? (Production[])(inputElement) : super.getElements(inputElement);
//		}
//	}

	class ProductionLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return obj instanceof Production ? ((Production)obj).getName() : null;
		}
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}

	public TransformMasterBlock(FormPage signatureFormPage) {
		page = signatureFormPage;
		transform = getMultiEditor().getTransform();
		Assert.isNotNull(transform);
		transform.eAdapters().add(new UIAdapter() {

			@Override
			protected void safeNotifyChanged(Notification msg) {
				if(msg.getNotifier() == transform){
					switch(msg.getFeatureID(Transform.class)){
					case TransformPackage.TRANSFORM__RULES:
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
		section.setText("Productions"); 
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
		table.setSize(30, SWT.FILL);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.heightHint = 20;
		gridData.widthHint = 100;
		gridData.verticalSpan = 4;
		table.setLayoutData(gridData);
		toolkit.paintBordersFor(client);
		Button addBt = toolkit.createButton(client, "Add", SWT.PUSH); //$NON-NLS-1$
		addBt.setLayoutData(new GridData(GridData.FILL, GridData.END, false, false));
		addBt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addProduction();
			}
		});
		

		final Button deBtn = toolkit.createButton(client, "REMOVE", SWT.PUSH); //$NON-NLS-1$
		deBtn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
		deBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeProduction(getSelection(viewer.getSelection()));
			}
		});
		
		Button upBtn = toolkit.createButton(client, "Move Up", SWT.PUSH); //$NON-NLS-1$
		upBtn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
		upBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveProductionUp(getSelection(viewer.getSelection()));
			}

			
		});
		
		Button downBtn = toolkit.createButton(client, "Move Down", SWT.PUSH); //$NON-NLS-1$
		downBtn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
		downBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveProductionDown(getSelection(viewer.getSelection()));
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
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new ProductionLabelProvider());
		viewer.setInput(getProductions());
		viewer.setSelection(null);
	}

	protected void removeProduction(final List<? extends Production> selected) {
		final TransformEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		domain.getCommandStack().execute(new Command("Add Production" + (selected.size() > 1 ? "s" : "")){
			public boolean canExecute() {
				return transform != null && editor != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				for(Production product : selected)
					transform.getRules().remove(product);
			}
			public void undo() {
				for(Production product : selected)
					transform.getRules().add(product);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private List<? extends Production> getSelection(ISelection selection){
		if(selection instanceof IStructuredSelection){
			return ((IStructuredSelection) selection).toList();
		}
		return new ArrayList<Production>(0);
	}
	
	protected void moveProductionUp(final List<? extends Production> selection) {
		final TransformEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		domain.getCommandStack().execute(new Command("Move Production Up"){
			private Production tempProd = null;
			
			public boolean canExecute() {
				return transform != null && editor != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				for(Production product : selection){
					tempProd=product;
				}
				boolean foundSelected = false;
				for(int i = 0;i<transform.getRules().size();i++){
					if(transform.getRules().get(i).equals(tempProd) && !foundSelected){
						if(i!=0){
							transform.getRules().move(i, transform.getRules().get(i-1));
							transform.getRules().remove(i-1);
							transform.getRules().add(i-1, tempProd);
							foundSelected = true;
						}
					}
				}
					
			}
			public void undo() {
				boolean foundSelected = false;
				for(int i = 0;i<transform.getRules().size();i++){
					if(transform.getRules().get(i).equals(tempProd) && !foundSelected && i!=(transform.getRules().size()-1)){
						transform.getRules().move(i, transform.getRules().get(i+1));
						transform.getRules().remove(i+1);
						transform.getRules().add(i+1, tempProd);
						foundSelected = true;
					}
				}
			}
		});
	}
	
	protected void moveProductionDown(final List<? extends Production> selection) {
		final TransformEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		domain.getCommandStack().execute(new Command("Move Production Down"){
			private Production tempProd = null;
			
			public boolean canExecute() {
				return transform != null && editor != null;
			}
			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				for(Production product : selection){
					tempProd=product;
				}
				boolean foundSelected = false;
				for(int i = 0;i<transform.getRules().size();i++){
					if(transform.getRules().get(i).equals(tempProd) && !foundSelected){
						if(i!=(transform.getRules().size()-1)){
							transform.getRules().move(i, transform.getRules().get(i+1));
							transform.getRules().remove(i+1);
							transform.getRules().add(i+1, tempProd);
							foundSelected = true;
						}
					}
				}
			}
			public void undo() {
				boolean foundSelected = false;
				for(int i = 0;i<transform.getRules().size();i++){
					if(transform.getRules().get(i).equals(tempProd) && !foundSelected){
						transform.getRules().move(i, transform.getRules().get(i-1));
						transform.getRules().remove(i-1);
						transform.getRules().add(i-1, tempProd);
						foundSelected = true;
					}
				}
			}
		});
	}
	
	protected void addProduction() {
		final TransformEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		final Production created = getNewProduction();
		domain.getCommandStack().execute(new Command("Add Production") {
			public boolean canExecute() {
				return transform != null && editor != null && created != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				transform.getRules().add(created);
			}
			public void undo() {
				transform.getRules().remove(created);
			}
		});
	}

	private Production getNewProduction(){
		Production result = TransformFactory.eINSTANCE.createProduction();
		result.setSum(DiagramFactory.eINSTANCE.createDefaultDSpecification());
		//		int i = 0;
		//		Production search = null;
		//		for(; i < transform.getRules().size(); ++i){
		//			Production current = transform.getRules().get(i);
		//			search = transform.getRules().getProductionBySymbol("production" + i);
		//			if(search == null)
		//				break;
		//		}
		//		result.getRules().setSymbol("Production" + i);
		return result;
	}

	private Production[] getProductions() {
		if(transform != null){
			EList<Production> productions = transform.getRules();
			return productions.toArray(new Production[productions.size()]);
		}
		return new Production[0];
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.registerPage(no.hib.dpf.transform.impl.ProductionImpl.class, new ProductionDetailBlock(this));
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) { }

	public void refresh(Production production) {
		viewer.setInput(getProductions());
		viewer.setSelection(new StructuredSelection(production));
	}

	public void refresh() {
		Production[] productions = getProductions();
		viewer.setInput(getProductions());
		if(productions.length > 0)
			viewer.setSelection(new StructuredSelection(productions[productions.length - 1]));
		else
			viewer.setSelection(null);
	}

	public TransformEditor getMultiEditor() {
		return (TransformEditor) page.getEditor();
	}

	public FormPage getEditor() {
		return page;
	};
}
