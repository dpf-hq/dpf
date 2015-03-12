package no.hib.dpf.uconstraint.presentation;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.parts.UIAdapter;
import no.hib.dpf.uconstraint.Constraints;
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.UConstraintFactory;
import no.hib.dpf.uconstraint.UConstraintPackage;

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

public class ConstraintsMasterBlock extends MasterDetailsBlock {

	private FormPage page;
	private Constraints constraints;
	private TableViewer viewer;

//	class ConstraintsContentProvider extends ArrayContentProvider {
//		public Object[] getElements(Object inputElement) {
//			return inputElement instanceof UConstraint[] ? (UConstraint[])(inputElement) : super.getElements(inputElement);
//		}
//	}

	class UConstraintLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return obj instanceof UConstraint ? ((UConstraint)obj).getName() : null;
		}
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}

	public ConstraintsMasterBlock(FormPage signatureFormPage) {
		page = signatureFormPage;
		constraints = getMultiEditor().getConstraints();
		Assert.isNotNull(constraints);
		constraints.eAdapters().add(new UIAdapter() {

			@Override
			protected void safeNotifyChanged(Notification msg) {
				if(msg.getNotifier() == constraints){
					switch(msg.getFeatureID(Constraints.class)){
					case UConstraintPackage.CONSTRAINTS__RULES:
						refresh();
						break;
					}
				}
			}
		});
	}

	@Override
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
		FormToolkit toolkit = managedForm.getToolkit();
		Section section = toolkit.createSection(parent, Section.TWISTIE| Section.TITLE_BAR);
		section.setText("Constraints"); 
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
				addUConstraint();
			}
		});
		

		final Button deBtn = toolkit.createButton(client, "REMOVE", SWT.PUSH); //$NON-NLS-1$
		deBtn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
		deBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				removeUConstraint(getSelection(viewer.getSelection()));
			}
		});
		
		Button upBtn = toolkit.createButton(client, "Move Up", SWT.PUSH); //$NON-NLS-1$
		upBtn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
		upBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveUConstraintUp(getSelection(viewer.getSelection()));
			}

			
		});
		
		Button downBtn = toolkit.createButton(client, "Move Down", SWT.PUSH); //$NON-NLS-1$
		downBtn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
		downBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveUConstraintDown(getSelection(viewer.getSelection()));
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
		viewer.setLabelProvider(new UConstraintLabelProvider());
		viewer.setInput(getUConstraints());
		viewer.setSelection(null);
	}

	protected void removeUConstraint(final List<? extends UConstraint> selected) {
		final ConstraintsEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		domain.getCommandStack().execute(new Command("Add UConstraint" + (selected.size() > 1 ? "s" : "")){
			public boolean canExecute() {
				return constraints != null && editor != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				for(UConstraint product : selected){
					constraints.getRules().remove(product);
					constraints.eResource().getContents().remove(product.getSum().getSpecification());
				}
				
			}
			public void undo() {
				for(UConstraint product : selected){
					constraints.getRules().add(product);
					constraints.eResource().getContents().add(product.getSum().getSpecification());
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	private List<? extends UConstraint> getSelection(ISelection selection){
		if(selection instanceof IStructuredSelection){
			return ((IStructuredSelection) selection).toList();
		}
		return new ArrayList<UConstraint>(0);
	}
	
	protected void moveUConstraintUp(final List<? extends UConstraint> selection) {
		final ConstraintsEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		domain.getCommandStack().execute(new Command("Move UConstraint Up"){
			private UConstraint tempProd = null;
			
			public boolean canExecute() {
				return constraints != null && editor != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				for(UConstraint product : selection){
					tempProd=product;
				}
				boolean foundSelected = false;
				for(int i = 0;i<constraints.getRules().size();i++){
					if(constraints.getRules().get(i).equals(tempProd) && !foundSelected){
						if(i!=0){
							constraints.getRules().move(i, constraints.getRules().get(i-1));
							constraints.getRules().remove(i-1);
							constraints.getRules().add(i-1, tempProd);
							foundSelected = true;
						}
					}
				}
					
			}
			public void undo() {
				boolean foundSelected = false;
				for(int i = 0;i<constraints.getRules().size();i++){
					if(constraints.getRules().get(i).equals(tempProd) && !foundSelected && i!=(constraints.getRules().size()-1)){
						constraints.getRules().move(i, constraints.getRules().get(i+1));
						constraints.getRules().remove(i+1);
						constraints.getRules().add(i+1, tempProd);
						foundSelected = true;
					}
				}
			}
		});
	}
	
	protected void moveUConstraintDown(final List<? extends UConstraint> selection) {
		final ConstraintsEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		domain.getCommandStack().execute(new Command("Move UConstraint Down"){
			private UConstraint tempProd = null;
			
			public boolean canExecute() {
				return constraints != null && editor != null;
			}
			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				for(UConstraint product : selection){
					tempProd=product;
				}
				boolean foundSelected = false;
				for(int i = 0;i<constraints.getRules().size();i++){
					if(constraints.getRules().get(i).equals(tempProd) && !foundSelected){
						if(i!=(constraints.getRules().size()-1)){
							constraints.getRules().move(i, constraints.getRules().get(i+1));
							constraints.getRules().remove(i+1);
							constraints.getRules().add(i+1, tempProd);
							foundSelected = true;
						}
					}
				}
			}
			public void undo() {
				boolean foundSelected = false;
				for(int i = 0;i<constraints.getRules().size();i++){
					if(constraints.getRules().get(i).equals(tempProd) && !foundSelected){
						constraints.getRules().move(i, constraints.getRules().get(i-1));
						constraints.getRules().remove(i-1);
						constraints.getRules().add(i-1, tempProd);
						foundSelected = true;
					}
				}
			}
		});
	}
	
	protected void addUConstraint() {
		final ConstraintsEditor editor = getMultiEditor();
		DefaultEditDomain domain = editor.getEditDomain();
		final UConstraint created = getNewUConstraint();
		created.getSum().setDType(constraints.getElementTypeGraph());
		domain.getCommandStack().execute(new Command("Add UConstraint") {
			public boolean canExecute() {
				return constraints != null && editor != null && created != null;
			}

			public boolean canUndo() {
				return canExecute();
			}
			public void execute() {
				constraints.getRules().add(created);
				constraints.eResource().getContents().add(created.getSum().getSpecification());
			}
			public void undo() {
				constraints.getRules().remove(created);
				constraints.eResource().getContents().remove(created.getSum().getSpecification());
			}
		});
	}

	private UConstraint getNewUConstraint(){
		UConstraint result = UConstraintFactory.eINSTANCE.createUConstraint();
		result.setSum(DiagramFactory.eINSTANCE.createDefaultDSpecification());
		//		int i = 0;
		//		UConstraint search = null;
		//		for(; i < constraints.getRules().size(); ++i){
		//			UConstraint current = constraints.getRules().get(i);
		//			search = constraints.getRules().getUConstraintBySymbol("uconstraint" + i);
		//			if(search == null)
		//				break;
		//		}
		//		result.getRules().setSymbol("UConstraint" + i);
		return result;
	}

	private UConstraint[] getUConstraints() {
		if(constraints != null){
			EList<UConstraint> uconstraints = constraints.getRules();
			return uconstraints.toArray(new UConstraint[uconstraints.size()]);
		}
		return new UConstraint[0];
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.registerPage(no.hib.dpf.uconstraint.impl.UConstraintImpl.class, new UConstraintDetailBlock(this));
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) { }

	public void refresh(UConstraint uconstraint) {
		viewer.setInput(getUConstraints());
		viewer.setSelection(new StructuredSelection(uconstraint));
	}

	public void refresh() {
		UConstraint[] uconstraints = getUConstraints();
		viewer.setInput(getUConstraints());
		if(uconstraints.length > 0)
			viewer.setSelection(new StructuredSelection(uconstraints[uconstraints.length - 1]));
		else
			viewer.setSelection(null);
	}

	public ConstraintsEditor getMultiEditor() {
		return (ConstraintsEditor) page.getEditor();
	}

	public FormPage getEditor() {
		return page;
	};
}
