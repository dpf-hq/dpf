package no.hib.mums.shipmaker.features.parts;

import static no.hib.mums.shared.MumsConstants.RELATION;
import no.hib.dpf.core.Arrow;
import no.hib.mums.shipmaker.DiagramTypeProvider;
import no.hib.mums.shipmaker.ShipHelper;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

public class AddPartConnectionFeature extends AbstractAddFeature {

	private static ShipHelper sh = DiagramTypeProvider.getHelperInstance();
	
	public AddPartConnectionFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		if(context instanceof IAddConnectionContext 
				&& context.getNewObject() instanceof Arrow) {
			
			if(sh.descendantOf((Arrow)context.getNewObject(), RELATION)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
        Arrow addedArrow = (Arrow) context.getNewObject();
        IPeCreateService peCreateService = Graphiti.getPeCreateService();
       
        // CONNECTION WITH POLYLINE
        Connection connection = peCreateService
            .createFreeFormConnection(getDiagram());
        connection.setStart(addConContext.getSourceAnchor());
        connection.setEnd(addConContext.getTargetAnchor());
 
        IGaService gaService = Graphiti.getGaService();
        Polyline polyline = gaService.createPolyline(connection);
        polyline.setLineWidth(2);
        polyline.setForeground(manageColor(IColorConstant.BLACK));
 
        ConnectionDecorator textDecorator =
        		peCreateService.createConnectionDecorator(connection, true,
        				0.5, true);
        Text text = gaService.createText(textDecorator);
        text.setForeground(manageColor(IColorConstant.BLACK));
        gaService.setLocation(text, 10, 0);
        // set reference name in the text decorator
        text.setValue(addedArrow.getName());

        // add static graphical decorator (composition and navigable)
        ConnectionDecorator cd;
        cd = peCreateService
        		.createConnectionDecorator(connection, false, 1.0, true);
        createArrow(cd);
      
     // create link and wire it
        link(connection, addedArrow);
        
        return connection;
	}

	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
		IGaService gaService = Graphiti.getGaService();
		Polyline polyline =
				gaService.createPolyline(gaContainer, new int[] { -15, 10, 0, 0, -15,
						-10 });
		polyline.setForeground(manageColor(IColorConstant.BLACK));
		polyline.setLineWidth(2);
		return polyline;
	}
}
