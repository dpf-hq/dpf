package no.hib.mums.partmaker.features.parts;

import static no.hib.mums.partmaker.PartHelper.*;

import no.hib.dpf.core.Arrow;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.FeatureProvider;
import no.hib.mums.partmaker.PartHelper;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class DirectEditingPartAttributeFeature extends AbstractDirectEditingFeature {

	private PartHelper ph = DiagramTypeProvider.getHelperInstance();
	
	public DirectEditingPartAttributeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public int getEditingType() {
		return TYPE_TEXT;
	}

	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		PictogramElement pe = context.getPictogramElement();
        Object bo = getBusinessObjectForPictogramElement(pe);
        GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        // support direct editing, if it is a EClass, and the user clicked
        // directly on the text and not somewhere else in the rectangle
        if (bo instanceof Arrow 
        		&& ph.isAttributeInstance((Arrow)bo) 
        		&& ga instanceof Text) {
            return true;
        }
        // direct editing not supported in all other cases
        return false;	
	}
	
	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		boolean valid = true;
		
		for(int i = 0; i < value.length(); ++i) {
			if(!Character.isDigit(value.charAt(i))) { 
				valid = false;
				break;
			}
		}
		
		if(!valid) {
			return "Only numbers are allowed";
		}

		// null means, that the value is valid
		return null;
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
		((Text)pe.getGraphicsAlgorithm()).setValue(value);
        Arrow bo = (Arrow)getBusinessObjectForPictogramElement(pe);
        bo.getTarget().setName(value);
        
        System.out.println(bo.getTarget());
		updatePictogramElement(((Shape) pe).getContainer());
	}
	
}
