package no.hib.dpf.editor;

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;
import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_DSPECIFICATION;
import static no.hib.dpf.utils.DPFConstants.DEFAULT_SIGNATURE;
import static no.hib.dpf.utils.DPFConstants.DefaultDSpecification;
import static no.hib.dpf.utils.DPFConstants.DefaultSpecification;
import static no.hib.dpf.utils.DPFConstants.REFLEXIVE_SPECIFICATION;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.util.DPFConstants;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.navigator.ResourceComparator;

public class DPFUtils extends DPFCoreUtil {
	
	public static void saveDSpecification(ResourceSetImpl resourceSet, DSpecification newSpec,
			URI createFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		URI modelFileURI = getModelURI(createFileURI);
		Resource diagram = createResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		diagram.getContents().add(newSpec);
		Resource model = createResource(resourceSet, modelFileURI, resourceToDiagnosticMap);
		model.getContents().add(newSpec.getSpecification());
		if(newSpec.getDType() != DPFConstants.REFLEXIVE_DSPECIFICATION){
			diagram.getContents().add(newSpec.getDType());
			model.getContents().add(newSpec.getDType().getSpecification());
		}
		if(newSpec.getDSignature() != DPFConstants.DEFAULT_DSIGNATURE){
			diagram.getContents().add(newSpec.getDSignature());
			model.getContents().add(newSpec.getSpecification().getSignature());
		}
		try {
			diagram.save(null);
			model.save(null);
		} catch (IOException e) {
			analyzeResourceProblems(diagram, e, resourceToDiagnosticMap);
			logError(e);
		}
	}
	
	@SuppressWarnings("finally")
	public static DSpecification loadDSpecification(ResourceSetImpl resourceSet,
			URI diagramURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		URI modelFileURI = getModelURI(diagramURI);
		Resource diagram = createResource(resourceSet, diagramURI, resourceToDiagnosticMap);
		Resource model = createResource(resourceSet, modelFileURI, resourceToDiagnosticMap);
		try {
			diagram.load(null);
		} catch (Exception e) {
			logError(e);
			analyzeResourceProblems(diagram, e, resourceToDiagnosticMap);
		} finally {
			if (diagram.getContents().size() == 0) {
				DSpecification result = DiagramFactory.eINSTANCE .createDefaultDSpecification();
				diagram.getContents().add(result);
				model.getContents().add(result.getSpecification());
				return result;
			}
			DSpecification dsp = (DSpecification) diagram.getContents().get(0);
			return dsp;
		}
	}
	public static DSpecification loadDSpecification(URI createFileURI) {
		return loadDSpecification(new ResourceSetImpl(), createFileURI, new HashMap<Resource, Diagnostic>());
	}
	
	public static DSignature loadDSignature(ResourceSetImpl resourceSet, URI createFileURI, Map<Resource, Diagnostic> resourceToDiagnosticMap) {
		Resource signature = createResource(resourceSet, createFileURI, resourceToDiagnosticMap);
		try {
			signature.load(null);
		} catch (IOException e) {
			logError(e);
			analyzeResourceProblems(signature, e, resourceToDiagnosticMap);
		}
		int size = signature.getContents().size();
		return size == 2 ? (DSignature) signature.getContents().get(0) : null;
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
		return loadDSignature(new ResourceSetImpl(), createFileURI, new HashMap<Resource, Diagnostic>());
	}

	public static ResourceSetImpl getResourceSet() {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.setURIResourceMap(new LinkedHashMap<URI, Resource>());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap() .put("xmi", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap() .put("dpf", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(DefaultDSpecification);
		resource.getContents().add(REFLEXIVE_DSPECIFICATION);
		resource.getContents().add(DEFAULT_DSIGNATURE);
		resourceSet.getURIResourceMap().put(DefaultDSpecification, resource);
		Resource model = resourceSet.createResource(DefaultSpecification);
		model.getContents().add(REFLEXIVE_SPECIFICATION);
		model.getContents().add(DEFAULT_SIGNATURE);
		resourceSet.getURIResourceMap().put(DefaultSpecification, model);
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
}