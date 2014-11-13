package no.hib.dpf.editor;

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;
import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_DSPECIFICATION;
import static no.hib.dpf.utils.DPFConstants.DefaultDSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class DPFUtils extends DPFCoreUtil {
	
	/**save a diagram model. Firstly save the underlying model.
	 * Since we offer no function to update a model when the metamodel is changed, 
	 * we simply store all the metamodels in the same file. 
	 * @param resourceSet : the resourceSet
	 * @param modelFileURI : file location
	 * @param specification : the model
	 * @param resourceToDiagnosticMap : used as analyzing exception shown up during saving
	 */
	public static void saveDSpecification(ResourceSetImpl resourceSet, DSpecification newSpec,
			URI createFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		DPFCoreUtil.saveSpecification(resourceSet, getModelURI(createFileURI), newSpec.getSpecification(), resourceToDiagnosticMap);
		Resource diagram = createResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		EcoreUtil.resolveAll(newSpec.getDType().eResource());
		DSpecification iter = newSpec;
		while(iter != DPFConstants.REFLEXIVE_DSPECIFICATION){
			diagram.getContents().add(iter);
			iter = iter.getDType();
		}
		iter = newSpec;
		while(iter != DPFConstants.REFLEXIVE_DSPECIFICATION){
			if(iter.getDSignature() != DPFConstants.DEFAULT_DSIGNATURE)
				diagram.getContents().add(iter.getDSignature());
			iter = iter.getDType();
		}
		try {
			diagram.save(null);
		} catch (IOException e) {
			analyzeResourceProblems(diagram, e, resourceToDiagnosticMap);
			logError(e);
		}
	}
	
	/*
	 * Load a DSpecification. If no model is loaded, a default DSpecification is created and return.
	 */
	public static DSpecification loadDSpecification(ResourceSetImpl resourceSet,
			URI diagramURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		loadSpecification(resourceSet, getModelURI(diagramURI), resourceToDiagnosticMap);
		Resource diagram = createResource(resourceSet, diagramURI, resourceToDiagnosticMap);
		Object result = getObjectFromResource(diagram);
		if(result instanceof DSpecification)
			return (DSpecification) result;
		return null;
	}
	/*
	 * load a DSpecification
	 */
	public static DSpecification loadDModel(ResourceSetImpl resourceSet,
			URI diagramURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		return loadDSpecification(resourceSet, diagramURI, resourceToDiagnosticMap);
	}
	public static DSpecification loadDSpecification(URI createFileURI) {
		return loadDSpecification(getResourceSet(), createFileURI, new HashMap<Resource, Diagnostic>());
	}
	
	public static DSpecification loadDModel(URI createFileURI) {
		return loadDModel(getResourceSet(), createFileURI, new HashMap<Resource, Diagnostic>());
	}
	public static DSignature loadDSignature(ResourceSetImpl resourceSet, URI createFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Resource signature = createResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		Object result = getObjectFromResource(signature);
		if(result instanceof DSignature)
			return (DSignature) result;
		return null;
	}
	
	/*
	 * Get Model file name from Diagram file name
	 */
	public static String getModelFromDiagram(String filename) {
		int index = filename.lastIndexOf(DEFAULT_DIAGRAM_MODEL_EXTENSION);
		if(index == -1)
			return filename + DEFAULT_MODEL_EXTENSION;
		return filename.substring(0, index) + DEFAULT_MODEL_EXTENSION;
	}

	/*
	 * Get Model URI from Diagam URI
	 */
	public static URI getModelURI(URI diagramURI) {
		return diagramURI.trimFileExtension().appendFileExtension("xmi");
	}
	
	/*
	 * Get Diagram file name from Model file name
	 */
	public static String getDiagramFromModel(String filename) {
		int index = filename.lastIndexOf(DEFAULT_MODEL_EXTENSION);
		if(index == -1)
			return filename + DEFAULT_DIAGRAM_MODEL_EXTENSION;
		return filename.substring(0, index) + DEFAULT_DIAGRAM_MODEL_EXTENSION;
	}
	public static final String DEFAULT_DIAGRAM_MODEL_EXTENSION = ".dpf";
	public static final String DEFAULT_MODEL_EXTENSION = ".xmi";
	public static DSignature loadDSignature(URI createFileURI) {
		return loadDSignature(new ResourceSetImpl(), createFileURI, new LinkedHashMap<Resource, Diagnostic>());
	}

	public static ResourceSetImpl getResourceSet() {
		ResourceSetImpl resourceSet = DPFCoreUtil.getResourceSet();
		resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap() .put("dpf", new XMIResourceFactoryImpl());
		
		Resource resource = resourceSet.createResource(DefaultDSpecification);
		resource.getContents().add(REFLEXIVE_DSPECIFICATION);
		resource.getContents().add(DEFAULT_DSIGNATURE);
		resourceSet.getURIResourceMap().put(DefaultDSpecification, resource);
		return resourceSet;
	}

	public static AbstractUIPlugin getPlugin() {
		return DPFPlugin.getDefault();
	}

	public static String getPluginID() {
		return DPFPlugin.PLUGIN_ID;
	}
	public static URI getFileURI(IFile file){
		return URI.createFileURI(file.getLocation().toOSString());
	}
	
	public static URI updateRelativeURI(URI oldBaseURI, URI newBaseURI, URI relative){
		return relative.resolve(oldBaseURI).deresolve(newBaseURI);
	}
	
	public static String printConstraint(Constraint constraint) {
		String result = "";
		EList<Node> nodes = constraint.getNodes();
		for (int i = 0; i < nodes.size(); i++) {
			result += nodes.get(i).getName();
			if(i != nodes.size() - 1)
				result += ",";
		}
		result += ";";
		EList<Arrow> edges = constraint.getArrows();
		for (int i = 0; i < edges.size(); i++) {
			Arrow edge = edges.get(i);
			result += edge.getName() + "|" + edge.getSource().getName() + "->" + edge.getTarget().getName();
			if(i != edges.size() - 1)
				result += ",";
		}
		return result;
	}
	
	public static final IResource select(Shell shell, String title, String message, final String[] suffixs, final String validErrorMessage, IProject project, IFile file, String helpId){
		//This is copy from org.eclipse.pde.internal.ui.editor.plugin.ExtensionPointDetails
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setDoubleClickSelects(false);
		dialog.setAllowMultiple(false);
		if(suffixs != null)
		dialog.addFilter(new ViewerFilter() {
			public boolean select(Viewer viewer, Object parent, Object element) {
				if (element instanceof IFile) {
					String ext = ((IFile) element).getFullPath().getFileExtension();
					for (int i = 0; i < suffixs.length; i++) 
						if(suffixs[i].equals(ext))
							return true;
					return false;
				} else if (element instanceof IContainer) { // i.e. IProject, IFolder
					try {
						IResource[] resources = ((IContainer) element).members();
						for (int i = 0; i < resources.length; i++) {
							if (select(viewer, parent, resources[i]))
								return true;
						}
					} catch (CoreException e) {
						DPFUtils.logError(e);
					}
				}
				return false;
			}
		});
		dialog.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {

				String errorMessage = validErrorMessage == null ? "" : validErrorMessage;
				if (selection == null || selection.length != 1 || !(selection[0] instanceof IFile) )
					return new Status(IStatus.ERROR, DPFPlugin.PLUGIN_ID, IStatus.ERROR, errorMessage, null);
				IFile file = (IFile) selection[0];
				String ext = file.getFullPath().getFileExtension();
				if(suffixs == null)
					return new Status(IStatus.OK, DPFPlugin.PLUGIN_ID, IStatus.OK, "", null);
				for (int i = 0; i < suffixs.length; i++) 
					if(suffixs[i].equals(ext))
						return new Status(IStatus.OK, DPFPlugin.PLUGIN_ID, IStatus.OK, "", null);
				return new Status(IStatus.ERROR, DPFPlugin.PLUGIN_ID, IStatus.ERROR, errorMessage, null);
			}
		});
		dialog.setStatusLineAboveButtons(true);
		dialog.setInput(project);
		dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
		if(file != null)
			dialog.setInitialSelection(file);
		dialog.create();
		if(helpId != null)PlatformUI.getWorkbench().getHelpSystem().setHelp(dialog.getShell(), helpId);
		if (dialog.open() == Window.OK) {
			Object[] elements = dialog.getResult();
			if (elements.length > 0) 
				return (IResource) elements[0];
		}
		return null;
	}
	/*
	 * Set the initial name according to the folder's children files
	 */
	public static void updateFileName(WizardNewFileCreationPage newFileCreationPage, IStructuredSelection selection, String defaultModelBaseFilename, String defaultModelFilenameExtension){
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
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
	}
	
	public static boolean isFileExist(URI uri){
		if(uri.isFile()){
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(uri.toFileString()));
			return file != null && file.exists();
		}
		return false;
	}
	public static DSpecification createDSpecificationFromSpecification(ResourceSetImpl resourceSet, URI modelUri, Specification specification, DSpecification dType, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		if(dType == null && specification.getType() == DPFConstants.REFLEXIVE_SPECIFICATION)
			return createDSpecificationFromSpecification(resourceSet, modelUri, specification, DPFConstants.REFLEXIVE_DSPECIFICATION, resourceToDiagnosticMap);
		URI diagramURI = URI.createURI(DPFUtils.getDiagramFromModel(modelUri.toString()));
		DSpecification model = null;
		if(isFileExist(diagramURI))
			model = DPFUtils.loadDSpecification(resourceSet, diagramURI, resourceToDiagnosticMap);
		if(model != null)
			return model;
		if(dType == null){
			URI typeFileAbsoluteURI = URI.createURI(specification.getMetaFile()).resolve(modelUri);
			Specification type = DPFUtils.loadSpecification(resourceSet, typeFileAbsoluteURI, resourceToDiagnosticMap);
			dType = createDSpecificationFromSpecification(resourceSet, typeFileAbsoluteURI, type, null, resourceToDiagnosticMap);
		}
		DSpecification result = new GenerateDiagramFromModel(specification, dType).result;
		result.setMetaFile(dType.eResource().getURI().deresolve(diagramURI).toFileString());
		if(specification.eResource() != null)
			specification.eResource().getContents().clear();
		DPFUtils.saveDSpecification(resourceSet, result, diagramURI, resourceToDiagnosticMap);
		return result;
	}

	public static String getFileNameWithExtension(String fileName) {
		int index = fileName.lastIndexOf('.');
		if(index == -1)
			return fileName;
		else
			return fileName.substring(0, index);
	}

}
