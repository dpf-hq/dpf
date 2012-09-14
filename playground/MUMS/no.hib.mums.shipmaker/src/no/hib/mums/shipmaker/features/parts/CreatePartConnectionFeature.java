package no.hib.mums.shipmaker.features.parts;

import static no.hib.mums.shared.MumsConstants.PART;

import no.hib.dpf.core.Node;
import no.hib.mums.shipmaker.DiagramTypeProvider;
import no.hib.mums.shipmaker.ShipHelper;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreatePartConnectionFeature extends AbstractCreateConnectionFeature {

	private static ShipHelper sh = DiagramTypeProvider.getHelperInstance();
	
	public CreatePartConnectionFeature(IFeatureProvider fp, String name,
			String description) {
		super(fp, name, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		Node source = getNode(context.getSourceAnchor());
		Node target = getNode(context.getTargetAnchor());
		
		if(source != null && target != null && !source.equals(target)) {
			if(sh.descendantOf(source, PART) 
				&& sh.descendantOf(target, PART)
				&& source.arrowCanMakeConnectionAsTarget(target)) {
				return true;
			}
		}
		
		return false;
	}

	private Node getNode(Anchor anchor) {
		try {
			Object o = getBusinessObjectForPictogramElement(anchor.getParent());
			
			if(o instanceof Node) {
				return (Node)o;
			} else return null;
		} catch(NullPointerException e) {
			return null;
		}
	}
	
	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;
		
		Node source = getNode(context.getSourceAnchor());
		Node target = getNode(context.getTargetAnchor());
 
        if (source != null && target != null) {
            // create new business object
            // add connection for business object
        	source.getGraph().createArrow("Relation", source, target);
        	
            AddConnectionContext addContext =
                new AddConnectionContext(context.getSourceAnchor(), context
                    .getTargetAnchor());
            addContext.setNewObject(source.getArrowto(target));
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
        }
       
        return newConnection;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		Node n = getNode(context.getSourceAnchor());
		if(n != null)
			return true;
		
		return false;
	}

}
