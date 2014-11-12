package no.hib.mums.shipmaker.features.parts;

import no.hib.dpf.core.Arrow;
import static no.hib.mums.shared.MumsConstants.*;
import no.hib.mums.shipmaker.DiagramTypeProvider;
import no.hib.mums.shipmaker.ShipHelper;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class DirectEditArrowNameFeature extends AbstractDirectEditingFeature {

	ShipHelper sh = DiagramTypeProvider.getHelperInstance();
	
	public DirectEditArrowNameFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		if(pe instanceof Arrow) {
			return ((Arrow)pe).getName();
		}
		return null;
	}

	@Override
	public void setValue(String value, IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		if(pe instanceof ConnectionDecorator) {
			ConnectionDecorator cd = (ConnectionDecorator)pe;
			pe = cd.getConnection();
		}
		((Text)context.getPictogramElement().getGraphicsAlgorithm()).setValue(value);
        Arrow bo = (Arrow)getBusinessObjectForPictogramElement(pe);
        bo.setName(value);
        
        System.out.println(bo);
		updatePictogramElement(((Shape) context.getPictogramElement()).getContainer());
	}
	
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
		
		if(pe instanceof ConnectionDecorator) {
			ConnectionDecorator cd = (ConnectionDecorator)pe;
			pe = cd.getConnection();
		}
		
        Object bo = getBusinessObjectForPictogramElement(pe);
        GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        if (bo instanceof Arrow 
        		&& sh.descendantOf((Arrow)bo, RELATION) 
        		&& ga instanceof Text) {
            return true;
        }
        // direct editing not supported in all other cases
        return false;	
	}
	
}
