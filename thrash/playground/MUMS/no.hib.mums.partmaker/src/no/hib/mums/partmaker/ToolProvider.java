package no.hib.mums.partmaker;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.features.parts.AddAttributeCustomFeature;
import no.hib.mums.shared.ImageProvider;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;

public class ToolProvider extends DefaultToolBehaviorProvider {

	public ToolProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
		// TODO Auto-generated constructor stub
	}
	@Override
    public GraphicsAlgorithm[] getClickArea(PictogramElement pe) {
        IFeatureProvider featureProvider = getFeatureProvider();
        Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
        
//        System.out.println(bo instanceof Arrow ? "Arrow" : "");
        
        if (bo instanceof Node) {
//            GraphicsAlgorithm parent = pe.getGraphicsAlgorithm();
        	
//            System.out.println("Selected " + parent);
//            System.out.println("\tChildren: " + parent.getGraphicsAlgorithmChildren());
//            GraphicsAlgorithm bleh = parent.getParentGraphicsAlgorithm();
//            List<GraphicsAlgorithm> rectangle = parent.getGraphicsAlgorithmChildren();
//            System.out.println(rectangle);
//            	return new GraphicsAlgorithm[] {rectangle.get(0)};
//            else
//            	return new GraphicsAlgorithm[] {invisible};
        }
        return super.getClickArea(pe);
    }
    
    @Override
    public GraphicsAlgorithm getSelectionBorder(
    		PictogramElement pe) {
    	IFeatureProvider featureProvider = getFeatureProvider();
    	Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
    	
//    	System.out.println(bo);
    	
    	if (bo instanceof Node) {
//            GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
    		
//            System.out.println(invisible.getPictogramElement().getLink().getBusinessObjects());
//            List<GraphicsAlgorithm> graphicsAlgorithmChildren =
//                 invisible.getGraphicsAlgorithmChildren();
           
//            if (!graphicsAlgorithmChildren.isEmpty()) {
//                 return graphicsAlgorithmChildren.get(0);
//            }
        }
        return super.getSelectionBorder(pe);
    }
    
    @Override
    public IContextButtonPadData getContextButtonPad(
    		IPictogramElementContext context) {
    	IContextButtonPadData data = super.getContextButtonPad(context);
    	PictogramElement pe = context.getPictogramElement();

    	setGenericContextButtons(data, pe, CONTEXT_BUTTON_UPDATE | CONTEXT_BUTTON_REMOVE);
    	
    	createReferenceButton(data, pe, context);
    	
    	createAddAttributeButton(data, pe, context);
    	
        return data;
    }
    
	private void createAddAttributeButton(IContextButtonPadData data, PictogramElement pe, IPictogramElementContext context) {
		 CustomContext cc = new CustomContext(new PictogramElement[] { pe });
		 ICustomFeature[] cf = getFeatureProvider().getCustomFeatures(cc);
		 
		 for(ICustomFeature c : cf) {
			 if(c instanceof AddAttributeCustomFeature) {
			
				 ContextButtonEntry button = new ContextButtonEntry(c, cc);
				 button.setText("Test");
				 button.setDescription("Descrip");
				 button.setIconId(ImageProvider.ADD_ATTRIBUTE);
				 data.getDomainSpecificContextButtons().add(button);
			 }
		 }
		 
		 
	}
	
	private void createReferenceButton(IContextButtonPadData data, PictogramElement pe, IPictogramElementContext context) {
		CreateConnectionContext ccc = new CreateConnectionContext();
        ccc.setSourcePictogramElement(pe);
        Anchor anchor = null;
        if (pe instanceof Anchor) {
            anchor = (Anchor) pe;
        } else if (pe instanceof AnchorContainer) {
            // assume, that our shapes always have chopbox anchors
            anchor = Graphiti.getPeService()
                     .getChopboxAnchor((AnchorContainer) pe);
        }
        ccc.setSourceAnchor(anchor);
       
        // 3.b. create context button and add all applicable features
        ContextButtonEntry button = new ContextButtonEntry(null, context);
        button.setText("Create connection");
        button.setIconId(ImageProvider.ARROW_REFERENCE);
        ICreateConnectionFeature[] features =
            getFeatureProvider().getCreateConnectionFeatures();
        for (ICreateConnectionFeature feature : features) {
            if (feature.isAvailable(ccc) && feature.canStartConnection(ccc))
                button.addDragAndDropFeature(feature);
        }
 
        // 3.c. add context button, if it contains at least one feature
        if (button.getDragAndDropFeatures().size() > 0) {
           data.getDomainSpecificContextButtons().add(button);
        }
	}
}
