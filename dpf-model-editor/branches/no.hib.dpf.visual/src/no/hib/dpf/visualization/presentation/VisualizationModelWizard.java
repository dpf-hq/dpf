/**
 */
package no.hib.dpf.visualization.presentation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.utils.DPFCoreUtil;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visual.VisualPlugin;
import no.hib.dpf.visual.VisualUtils;
import no.hib.dpf.visual.Visuals;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.VisualizationPackage;
import no.hib.dpf.visualization.Visualizations;
import no.hib.dpf.visualization.impl.VisualizationFactoryImpl;
import no.hib.dpf.visualization.util.VisualizationUtils;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class VisualizationModelWizard extends Wizard implements INewWizard {
	/**
	 * The supported extensions for created files.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS =
			Collections.unmodifiableList(Arrays.asList(VisualPlugin.INSTANCE.getString("_UI_VisualizationEditorFilenameExtensions").split("\\s*,\\s*")));

	/**
	 * A formatted list of supported file extensions, suitable for display.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS =
			VisualPlugin.INSTANCE.getString("_UI_VisualizationEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualizationPackage visualizationPackage = VisualizationPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualizationFactory visualizationFactory = visualizationPackage.getVisualizationFactory();

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualizationModelWizardNewFileCreationPage newFileCreationPage;

	/**
	 * This is the initial object creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualizationModelWizardInitialObjectCreationPage initialObjectCreationPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * Caches the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected List<String> initialObjectNames;

	public Text visualFile;

	public Button visualbrowseButton;

	protected Specification specification = null;
	protected Visuals visuals = null;
	protected Map<IDObject, VElement> maps = new HashMap<IDObject, VElement>();
	/**
	 * This just records the information.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(VisualPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(VisualPlugin.INSTANCE.getImage("full/wizban/NewVisualization")));
	}

	/**
	 * Returns the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			for (EClassifier eClassifier : visualizationPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						initialObjectNames.add(eClass.getName());
					}
				}
			}
			Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		}
		return initialObjectNames;
	}

	/**
	 * Create a new model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Visualizations createInitialModel() {
		Visualizations visualizations = VisualizationFactory.eINSTANCE.createVisualizations();
		visualizations.setModel(specification);
		visualizations.setVisual(visuals);
		DSpecification instance = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		DSpecification type = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		type.setSpecification(specification);
		type.getDGraph().setGraph(specification.getGraph());
		
		instance.setDType(type);
		visualizations.setInstance(instance);
		visualizations.getEntries().putAll(maps);
		
		for(Node node : visualizations.getModel().getGraph().getNodes()){
			VElement element = maps.get(node);
			if(element instanceof VNode){
				VNode vNode = (VNode) element;
				if(vNode.isComposite()) {
					VisualizationFactory factory = new VisualizationFactoryImpl();
					EList<Arrow> arrows = node.getOutgoings();
					for(Arrow arrow : arrows) {
						if(maps.containsKey(arrow) && ((VArrow) maps.get(arrow)).isComposed()) {
							VCompartment vCompartment = factory.createVCompartment();
							vCompartment.setName(arrow.getTarget().getName());
							vCompartment.setParent(vNode);
							visualizations.getCompartments().add(vCompartment);
						}
					}
				}
			}
		}
		
		return visualizations;
	}

	/**
	 * Do the work after everything is specified.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation =
					new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						// Create a resource set
						//
						Visualizations result = createInitialModel();
						ResourceSetImpl resourceSet = VisualizationUtils.getResourceSet();

						// Get the URI of the model file.
						//
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

						// Create a resource for this file.
						//
						VisualizationUtils.saveVisualizations(resourceSet, result, fileURI, new HashMap<Resource, Diagnostic>());
					}
					catch (Exception exception) {
						VisualizationUtils.logError(exception);
					}
					finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec
				(new Runnable() {
					public void run() {
						((ISetSelectionTarget)activePart).selectReveal(targetSelection);
					}
				});
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor
				(new FileEditorInput(modelFile),
						workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());					 	 
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), VisualPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			VisualizationUtils.logError(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class VisualizationModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public VisualizationModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		protected boolean validatePage() {
			if (super.validatePage()) {
				String extension = new Path(getFileName()).getFileExtension();
				if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
					String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
					setErrorMessage(VisualPlugin.INSTANCE.getString(key, new Object [] { FORMATTED_FILE_EXTENSIONS }));
					return false;
				}
				return true;
			}
			return false;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public IFile getModelFile() {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
		}
	}


	/**
	 * This is the page where the type of object to create is selected.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class VisualizationModelWizardInitialObjectCreationPage extends WizardPage {
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Text modelFile;


		private Button browseButton;


		private CheckboxTableViewer modelTable;


		private CheckboxTableViewer visualTable;


		private Label modelTableLabel;


		private Label visualTableLabel;




		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public VisualizationModelWizardInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE); {
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.grabExcessVerticalSpace = true;
				composite.setLayoutData(data);
			}

			Label modelLabel = new Label(composite, SWT.LEFT);
			{
				modelLabel.setText(VisualPlugin.INSTANCE.getString("_UI_ModelObject"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				modelLabel.setLayoutData(data);
			}

			modelFile = new Text(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				modelFile.setLayoutData(data);
			}
			browseButton = new Button(composite, SWT.PUSH);
			{
				setButtonLayoutData(browseButton);
				browseButton.setText("&Browse...");
				browseButton.addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent event) {
						handleModelBrowseButtonPressed(modelFile, getModelFile().getParent().getLocation().toOSString(), "*.xmi");
						specification = DPFCoreUtil.loadSpecification(URI.createFileURI(modelFile.getText()));
						setPageComplete(validatePage());
						updateControl();
						if(modelTable.getTable().getColumns().length > 0)
							modelTable.getTable().setSelection(0);
					}
				});
				browseButton.setEnabled(true);
			}

			Label visualLabel = new Label(composite, SWT.LEFT);
			{
				visualLabel.setText(VisualPlugin.INSTANCE.getString("_UI_VisualObject"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.horizontalSpan = 2;
				visualLabel.setLayoutData(data);
			}

			visualFile = new Text(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				visualFile.setLayoutData(data);
			}
			visualbrowseButton = new Button(composite, SWT.PUSH);
			{
				setButtonLayoutData(browseButton);
				//				browseButton.setFont(font);
				visualbrowseButton.setText("&Browse...");
				visualbrowseButton.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						handleModelBrowseButtonPressed(visualFile, getModelFile().getParent().getLocation().toOSString(), "*.visual");
						visuals = VisualUtils.loadVisuals(new ResourceSetImpl(), URI.createFileURI(visualFile.getText()), new HashMap<Resource, Diagnostic>());
						setPageComplete(validatePage());
						updateControl();
					}
				});
				visualbrowseButton.setEnabled(true);
			}

			Composite compos = new Composite(composite, SWT.NONE); {
				GridLayout layout = new GridLayout();
				layout.numColumns = 2;
				layout.verticalSpacing = 12;
				layout.makeColumnsEqualWidth = true;
				compos.setLayout(layout);

				GridData data = new GridData();
				data.grabExcessHorizontalSpace = true;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = SWT.FILL;
				data.verticalAlignment = SWT.FILL;
				data.horizontalSpan = 2;
				compos.setLayoutData(data);
			}
			modelTableLabel = new Label(compos, SWT.NONE);
			{
				modelTableLabel.setText("Model");
				GridData data1 = new GridData();
				data1.horizontalAlignment = SWT.CENTER;
				data1.grabExcessHorizontalSpace = true;
				modelTableLabel.setLayoutData(data1);

			}
			visualTableLabel = new Label(compos, SWT.NONE);
			{
				visualTableLabel.setText("Visual");
				GridData data1 = new GridData();
				data1.horizontalAlignment = SWT.CENTER;
				data1.grabExcessHorizontalSpace = true;
				visualTableLabel.setLayoutData(data1);
			}
			GridData data = new GridData();
			data.horizontalAlignment = SWT.CENTER;
			data.grabExcessHorizontalSpace = true;
			data.horizontalAlignment = SWT.FILL;
			data.verticalAlignment = SWT.FILL;
			data.grabExcessHorizontalSpace = true;
			data.grabExcessVerticalSpace = true;
			modelTable = CheckboxTableViewer.newCheckList(compos, SWT.BORDER);
			modelTable.addSelectionChangedListener(new ISelectionChangedListener() {

				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					updateControl();
				}
			});
			modelTable.addCheckStateListener(new ICheckStateListener() {

				@Override
				public void checkStateChanged(CheckStateChangedEvent event) {
					boolean checked = event.getChecked();
					Object model = event.getElement();
					if(model instanceof IDObject){
						if(checked){
							Object visual = getSelectionObject(visualTable.getSelection());
							if(visual instanceof VElement)
							{
								modelTable.setChecked(model, true);
								maps.put((IDObject)model, (VElement)visual);
								visualTable.setChecked(visual, true);
							}
							else
								modelTable.setChecked(model, false);
						}else{
							Object visual = maps.get(model);
							if(visual  instanceof VElement){
								visualTable.setChecked(visual, false);
							}
							modelTable.setChecked(model, false);
							maps.remove(model);
						}
					}
				}
			});
			modelTable.getTable().setLayoutData(data);
			modelTable.setContentProvider(new ArrayContentProvider());
			modelTable.setLabelProvider(new LabelProvider(){
				public String getText(Object element) {
					if(element instanceof Node){
						return ((Node)element).getName();
					}else if(element instanceof Arrow){
						return ((Arrow)element).getName();
					}
					return super.getText(element);
				}
			});

			visualTable = CheckboxTableViewer.newCheckList(compos, SWT.BORDER);
			visualTable.getTable().setLayoutData(data);
			visualTable.setContentProvider(new ArrayContentProvider());
			visualTable.setLabelProvider(new LabelProvider(){
				public String getText(Object element) {
					if(element instanceof VElement){
						return ((VElement)element).getName();
					}
					return super.getText(element);
				}
			});
			visualTable.addCheckStateListener(new ICheckStateListener() {

				@Override
				public void checkStateChanged(CheckStateChangedEvent event) {
					Object o = event.getElement();
					boolean checked = event.getChecked();
					Object model = getSelectionObject(modelTable.getSelection());
					if(model != null){
						Object visual = maps.get(model);
						if(checked && visual != null && visual != o){
							visualTable.setChecked(visual, false);
						}
					}
					modelTable.setChecked(model, checked);
					maps.put((IDObject)model, (VElement)(checked ? o : null));
					visualTable.setChecked(o, event.getChecked());
				}
			});

			setPageComplete(validatePage());
			setControl(composite);
		}



		protected void handleModelBrowseButtonPressed(Text targetField, String parent, String name) {
			String selection = null;
			FileDialog fileDialog = new FileDialog(getShell(), SWT.SHEET);
			fileDialog.setFilterPath(parent);
			fileDialog.setFilterExtensions(new String[]{name, "*.*"});
			selection = fileDialog.open();
			if (selection != null) {
				targetField.setText(selection);
			}
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected boolean validatePage() {
			if(specification != null && visuals != null){
				return true;
			}
			return false;
		}

		public void setVisible(boolean visible) {
			super.setVisible(visible);
			updateControl();
		}
		public Object getSelectionObject(ISelection selection){
			if(selection instanceof StructuredSelection){
				StructuredSelection ss = (StructuredSelection) selection;
				return ss.getFirstElement();
			}
			return null;
		}
		public void updateControl() {
			boolean old = modelTable.getTable().isVisible();
			boolean visible = specification != null;
			modelTable.getTable().setVisible(visible);
			modelTableLabel.setVisible(visible);
			boolean vv = visuals != null && modelTable.getTable().getSelectionCount() != 0 && visible;
			visualTable.getTable().setVisible(vv);
			visualTableLabel.setVisible(vv);
			if(visible){
				modelTable.setInput(specification.getGraph().eContents());
				if(old != visible){
					for(Entry<IDObject, VElement> item : maps.entrySet()){
						modelTable.setChecked(item.getKey(), true);
					}
					if(modelTable.getTable().getItems().length > 0)
						modelTable.getTable().setSelection(0);
				}
			}
			if(vv){
				Object key = getSelectionObject(modelTable.getSelection());
				if(key instanceof IDObject){
					boolean node = key instanceof Node;
					visualTable.setInput(node ? getVNodes() : getVArrows());
					Object[] objects = visualTable.getCheckedElements();
					if(objects.length != 0){
						visualTable.setChecked(objects[0], false);
					}
					VElement e = maps.get(key);
					if(e instanceof VElement)
						visualTable.setChecked(e, true);
				}else
					visualTable.setInput(null);
			}
		}

		List<VNode> nodes = null;
		List<VArrow> arrows = null;
		private List<VNode> getVNodes(){
			if(nodes == null && visuals != null){
				nodes = new ArrayList<VNode>();
				for(VElement v : visuals.getItems()){
					if(v instanceof VNode)
						nodes.add((VNode) v);
				}
			}
			return nodes;
		}
		private List<VArrow> getVArrows(){
			if(arrows == null && visuals != null){
				arrows = new ArrayList<VArrow>();
				for(VElement v : visuals.getItems()){
					if(v instanceof VArrow)
						arrows.add((VArrow) v);
				}
			}
			return arrows;
		}
		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public String getInitialObjectName() {
			String label = modelFile.getText();

			for (String name : getInitialObjectNames()) {
				if (getLabel(name).equals(label)) {
					return name;
				}
			}
			return null;
		}

		/**
		 * Returns the label for the specified type name.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected String getLabel(String typeName) {
			try {
				return VisualPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
			}
			catch(MissingResourceException mre) {
				VisualPlugin.INSTANCE.log(mre);
			}
			return typeName;
		}

	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new VisualizationModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(VisualPlugin.INSTANCE.getString("_UI_VisualizationModelWizard_label"));
		newFileCreationPage.setDescription(VisualPlugin.INSTANCE.getString("_UI_VisualizationModelWizard_description"));
		newFileCreationPage.setFileName(VisualPlugin.INSTANCE.getString("_UI_VisualizationEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = VisualPlugin.INSTANCE.getString("_UI_VisualizationEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new VisualizationModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(VisualPlugin.INSTANCE.getString("_UI_VisualizationModelWizard_label"));
		initialObjectCreationPage.setDescription(VisualPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		addPage(initialObjectCreationPage);
	}

	/**
	 * Get the file from the page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}

	/**
	 * Get the file store for the string.
	 * 
	 * @param string
	 * @return IFileStore or <code>null</code> if there is a
	 *         {@link CoreException}.
	 */
	public static org.eclipse.core.filesystem.IFileStore getFileStore(String string) {
		return getFileStore(new Path(string).toFile().toURI());
	}

	/**
	 * Get the file store for the URI.
	 * 
	 * @param uri
	 * @return IFileStore or <code>null</code> if there is a
	 *         {@link CoreException}.
	 */
	public static IFileStore getFileStore(java.net.URI uri) {
		try {
			return EFS.getStore(uri);
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}
	}
}
