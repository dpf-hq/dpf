package no.hib.mums.shipmaker;

import java.io.IOException;

import no.hib.mums.shared.DPFResourceHandler;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.PropertyBag;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.platform.IDiagramEditor;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.jface.preference.PreferenceStore;

public class DiagramTypeProvider extends AbstractDiagramTypeProvider
		implements IDiagramTypeProvider {

	public static PropertyBag properties = new PropertyBag();
	
	private static ShipHelper sh;
	
	private DPFResourceHandler resourceHandler;
	
	private IToolBehaviorProvider[] toolproviders;
	
	public DiagramTypeProvider() {
		super();
	}

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		 if (toolproviders == null) {
			 toolproviders =
	                new IToolBehaviorProvider[] { new ToolProvider(
	                    this) };
	        }
	        return toolproviders;
	}
	
	@Override
	public void init(Diagram diagram, IDiagramEditor diagramEditor) {
		super.init(diagram, diagramEditor);
		
		resourceHandler = new DPFResourceHandler(getDiagramEditor().getEditingDomain());
		if(resourceHandler.getModel() == null) {
			URI uri = URI.createFileURI(readSettings(diagram.eResource().getURI().toPlatformString(false)));
			Assert.isNotNull(uri);
			if(uri != null) {
				resourceHandler.createInstanceSpecification(uri, "ShipMaker Graph");
			}
		}

		Assert.isNotNull(resourceHandler.getModel());
		
		sh = new ShipHelper(resourceHandler.getModel());
		
		FeatureProvider fp = new FeatureProvider(this);
		setFeatureProvider(fp);
		
		fp.init();
	}

	public DPFResourceHandler getResourceHandler() {
		return resourceHandler;
	}
	
	public static ShipHelper getHelperInstance() {
		return sh;
	}
	
	private String readSettings(String key) {
		IWorkspaceRoot wr = ResourcesPlugin.getWorkspace().getRoot();
		String[] tmp = key.split("/");
		IProject p = wr.getProject(tmp[1]);
		IFile f = p.getFile(new Path(".settings/no.hib.mums.shipmaker.prefs"));
		
		PreferenceStore store = new PreferenceStore();
		Assert.isTrue(f.exists());
		try {
			store.load(f.getContents());
			return store.getString(key);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			try {
				//If resource is out of sync, we get a resource exception. We then try to refresh our projects resources
				p.refreshLocal(IResource.DEPTH_INFINITE, null);
				store.load(f.getContents());
				return store.getString(key);
			} catch (CoreException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		} 
		return null;
	}
}
