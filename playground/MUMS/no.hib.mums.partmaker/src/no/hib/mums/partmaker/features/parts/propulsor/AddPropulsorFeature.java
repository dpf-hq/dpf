package no.hib.mums.partmaker.features.parts.propulsor;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.features.parts.AddPartFeature;
import no.hib.mums.shared.ImageProvider;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.util.ColorConstant;

public class AddPropulsorFeature extends AddPartFeature {

	public AddPropulsorFeature(IFeatureProvider fp) {
		super(fp);
		this.setColors(new ColorConstant("A61300"), 
			    new ColorConstant("FF5640"), 
			    new ColorConstant("FF1E00"));
	}
	
//	@Override
//	public PictogramElement add(IAddContext context) {
//		Node n = (Node)context.getNewObject();
//		ContainerShape cs = peCreateService.createContainerShape(getDiagram(), true);
//		Shape s = peCreateService.createShape(cs, true);
//		Image i = gaService.createImage(s, ImageProvider.PROPULSOR);
//		Text t = gaService.createText(s, n.getName());
////		layoutPictogramElement(cs);
//		
//		return cs;
//	}
}
