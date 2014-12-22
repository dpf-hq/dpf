package no.hib.dpf.uconstraint.presentation;


import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.parts.DComposedNodePart;
import no.hib.dpf.editor.parts.DConstraintFromNodeEditPart;
import no.hib.dpf.editor.parts.DPFEditPartFactory;
import no.hib.dpf.editor.parts.SingleArrowConstraintEditPart;
import no.hib.dpf.editor.parts.TwoArrowsOneNodeConstraintEditPart;
import no.hib.dpf.editor.parts.listeners.UIAdapter;
import no.hib.dpf.uconstraint.UCType;
import no.hib.dpf.uconstraint.UConstraint;
import no.hib.dpf.uconstraint.UConstraintPackage;
import no.hib.dpf.uconstraint.parts.ConstraintsArrowLabelEditPart;
import no.hib.dpf.uconstraint.parts.ConstraintsDArrowEditPart;
import no.hib.dpf.uconstraint.parts.ConstraintsDGraphEditPart;
import no.hib.dpf.uconstraint.parts.ConstraintsDNodeEditPart;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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

public class UConstraintDetailBlock extends UConstraintEditor implements IDetailsPage {


	private IManagedForm form;

	private Text name;
	private Section infoSection;
	private ConstraintsMasterBlock master;
	private static String currentUConstraint;
	
	public UConstraintDetailBlock(ConstraintsMasterBlock master) {
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

	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		paletteFactory.updatePalette(getPaletteRoot(), master.getMultiEditor().getConstraints().getElementTypeGraph().getDGraph());

		DPFEditPartFactory shapesEditPartFactory = new DPFEditPartFactory(){
			protected EditPart getPartForElement(Object modelElement) {
				if (modelElement instanceof DGraph) 
					return new ConstraintsDGraphEditPart();
				if (modelElement instanceof DNode) {
					if(modelElement instanceof DConstraintNode)
						return new DComposedNodePart();
					else
						return new ConstraintsDNodeEditPart();
				}
				if (modelElement instanceof DArrow) 
					return new ConstraintsDArrowEditPart();
				if (modelElement instanceof DOffset) {
					DOffset offset = (DOffset) modelElement;
					if(offset.eContainer() instanceof DArrow)
						return new ConstraintsArrowLabelEditPart();
				}
				if(modelElement instanceof DGenericArrowConstraint){
					DGenericArrowConstraint constraint = (DGenericArrowConstraint) modelElement;
					return constraint.getDPredicate() != null ? new TwoArrowsOneNodeConstraintEditPart()
					: new DConstraintFromNodeEditPart();
				}
				if(modelElement instanceof DArrowLabelConstraint)
					return new SingleArrowConstraintEditPart();
				return super.getPartForElement(modelElement);
			}
		};
		viewer.setEditPartFactory(shapesEditPartFactory);
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		ContextMenuProvider cmProvider = new ConstraintsEditorContextMenuProvider(viewer, getActionRegistry());
		viewer.setContextMenu(cmProvider);
	}
	protected ActionRegistry getActionRegistry() {
		return master.getMultiEditor().getActionRegistry();
	}
	@Override
	public void refresh() {
		if(uconstraint != null){
			getGraphicalViewer().setContents(uconstraint.getSum().getDGraph());
			name.setText(getNNullString(uconstraint.getName()));
			type.setSelection(new StructuredSelection(types[uconstraint.getType().getValue()]));
		}
	}

	private String getNNullString(String value){
		return value == null ? "" : value;
	}

	protected UIAdapter adapter = new UIAdapter()
	{
		@Override
		protected void safeNotifyChanged(Notification msg)
		{
			Object old = msg.getOldValue();
			if(old == null) old = msg.getNewValue();
			if(old == null) return;
			EditPart editpart = (EditPart) getGraphicalViewer().getEditPartRegistry().get(old);
			if(editpart == null) return;
			if(msg.getNotifier() != null && msg.getNotifier() == uconstraint){ 
				switch(msg.getFeatureID(UConstraint.class)){
				case UConstraintPackage.UCONSTRAINT__LEFT_NODES:
				case UConstraintPackage.UCONSTRAINT__COMMON_NODES:
				case UConstraintPackage.UCONSTRAINT__RIGHT_NODES:
				case UConstraintPackage.UCONSTRAINT__LEFT_ARROWS:
				case UConstraintPackage.UCONSTRAINT__COMMON_ARROWS:
				case UConstraintPackage.UCONSTRAINT__RIGHT_ARROWS:
					editpart.refresh();
					break;
				}
			}
		}
	};

	private ComboViewer type;
	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection)selection;
		Object selected = null;
		if(ssel.size() == 1) selected = ssel.getFirstElement();
		if(selected instanceof UConstraint){
			if(uconstraint != null)
				uconstraint.eAdapters().remove(adapter);
			uconstraint = (UConstraint) selected;
			uconstraint.eAdapters().add(adapter);
			setUConstraint(uconstraint);
			currentUConstraint = uconstraint.getName();
			refresh();
		}
	}

	protected void addListners(){
		name.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if(!name.getText().equals(uconstraint.getName()))
					changeProductName(name.getText());
			}
		});
		type.addSelectionChangedListener(new ISelectionChangedListener(){

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				String chosen = (String) ((IStructuredSelection)event.getSelection()).getFirstElement();
				if(!types[uconstraint.getType().getValue()].equals(chosen)){
					int index = 0;
					for(; index < types.length; ++index)
						if(types[index].equals(chosen)){
							uconstraint.setType(UCType.get(index));
							master.refresh(uconstraint);
							master.getMultiEditor().setDirty(true);
							return;
						}
				}
			}

		});
	}
	private static String[] types = new String[]{"L\u2192R", "L\u2192\u00acR", "L\u2194R", "L\u2194\u00acR"};
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
		
		new Label(infoComposite, SWT.NONE).setText("Type:");
		type = new ComboViewer(infoComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
		gridData = null;
		gridData = new GridData(GridData.FILL, GridData.FILL, true, false);
		gridData.horizontalSpan = 2;
		gridData.minimumWidth = 20;
		type.getCombo().setLayoutData(gridData);
		type.setContentProvider(new ArrayContentProvider());
		type.setInput(types);
		
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
		return toArray(uconstraint.getSum().getDGraph().getGraph().getArrows());
	}

	protected Object[] getNodes() {
		return toArray(uconstraint.getSum().getDGraph().getGraph().getNodes());
	}

	private Object[] toArray(EList<?> lists){
		return lists.toArray(new Object[lists.size()]);
	}

	protected void changeProductName(String newText) {
		uconstraint.setName(newText);
		currentUConstraint = newText;
		master.refresh(uconstraint);
		master.getMultiEditor().setDirty(true);
	}
	

	@Override
	public void doSave(IProgressMonitor monitor) {
		master.getMultiEditor().doSave(monitor);
	}
	public static String getCurrentUConstraint(){
		return currentUConstraint;
	}
}
