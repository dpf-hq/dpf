package no.hib.dpf.codegen.ui.handlers;

import java.util.HashMap;

import no.hib.dpf.codegen.generator.GeneratorSetup;
import no.hib.dpf.codegen.ui.properties.DPFCodegenConstants;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.handlers.HandlerUtil;

public class GenerateCodeHandler implements IHandler {

	private IProject project;
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String[] views = { "org.eclipse.jdt.ui.PackageExplorer",
				"org.eclipse.ui.views.ResourceNavigator",
				"org.eclipse.ui.navigator.ProjectExplorer" };

		ISelectionService service = HandlerUtil.getActiveWorkbenchWindow(event).getSelectionService();
		IStructuredSelection structuredSelection = null;
		for (String view : views) {
			structuredSelection = (IStructuredSelection) service
					.getSelection(view);
			if (structuredSelection != null)
				break;
		}
		
		if (structuredSelection == null) {
			System.err.println("Resource not found");
			return null;
		}
		
		IFile file = (IFile) structuredSelection.getFirstElement();

		GeneratorSetup gen = new GeneratorSetup();
		
		try {
			project = getIProject(file.getProject().getPersistentProperty(
					DPFCodegenConstants.TARGET_SOURCE_DIR_PROPERTY));
			
			HashMap<String, String> properties = new HashMap<String, String>();
			properties.put("outputPath", getProjectPath(file.getProject().getPersistentProperty(
					DPFCodegenConstants.TARGET_SOURCE_DIR_PROPERTY)));
			properties.put("modelOutputPath", getProjectPath(file.getProject().getPersistentProperty(
					DPFCodegenConstants.MODEL_TARGET_SOURCE_DIR_PROPERTY)));
			properties.put("controllerOutputPath", getProjectPath(file.getProject().getPersistentProperty(
					DPFCodegenConstants.CONTROLLER_TARGET_SOURCE_DIR_PROPERTY)));
			properties.put("generateAnnotations", project.getPersistentProperty(DPFCodegenConstants.ANNOTATIONS_PROPERTY));
			properties.put("xmiLocation", file.getLocationURI().toString());
			properties.put("templateEntryPoint", "no::hib::dpf::codegen::generator::template::play::Init::init");
			
			gen.generate(properties);
					
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		//Default return value
		return null;
	}
	
	private IProject getIProject(String path) {
		String tmp = path.substring(1);
	
		String projectName = tmp.substring(0, tmp.indexOf('/'));

		IResource res = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(projectName);
		if (res instanceof IProject) {
			return (IProject) res;
		}
		return null;
	}
	
	private String getProjectPath(String path) {
		String tmp = path.substring(1);
		// Gets the project name
		String pathName = tmp.substring(tmp.indexOf('/'), tmp.length());

		StringBuffer result = new StringBuffer();
		result.append(project.getLocation().toString());
		result.append(pathName);
		return result.toString();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
