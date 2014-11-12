package no.hib.mums.partmaker;

import no.hib.mums.shared.DPFResourceHandler;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.platform.IDiagramEditor;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class DiagramTypeProvider extends AbstractDiagramTypeProvider
		implements IDiagramTypeProvider {

	private static PartHelper ph;
	
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
		resourceHandler.createInstanceSpecification(getDiagram().eResource().getURI(), "PartMaker Graph");
		ph = new PartHelper(resourceHandler.getModel());
		setFeatureProvider(new FeatureProvider(this));
	}

	public DPFResourceHandler getResourceHandler() {
		return resourceHandler;
	}
	
	public static PartHelper getHelperInstance() {
		return ph;
	}
}
