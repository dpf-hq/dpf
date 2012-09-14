package no.hib.mums.shipmaker;

import java.util.HashMap;

import no.hials.mums.partmaker.generator.GeneratorSetup;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.handlers.HandlerUtil;

public class GenerateCodeHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		HashMap<String, String> props = new HashMap<String, String>();
		
		//The DPF Reader component uses platform:/resource URIs
		IFile file = getFile(event);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		props.put("xmiLocation", uri.toString());
		
		//The Xpand Generator component uses absolute/relative paths
		IResource ff = file.getProject().findMember("src-gen");
		props.put("outputPath", ff.getLocation().toOSString());
		
		GeneratorSetup gs = new GeneratorSetup();
		gs.generate(props);
		
		try {
			ff.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private IFile getFile(ExecutionEvent event) {
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
		
		return (IFile) structuredSelection.getFirstElement();
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
