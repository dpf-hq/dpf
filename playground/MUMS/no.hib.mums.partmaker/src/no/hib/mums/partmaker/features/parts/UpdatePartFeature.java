package no.hib.mums.partmaker.features.parts;

import no.hib.dpf.core.Node;
import no.hib.mums.partmaker.DiagramTypeProvider;
import no.hib.mums.partmaker.PartHelper;

import org.eclipse.core.runtime.Assert;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class UpdatePartFeature extends AbstractUpdateFeature {

	private PartHelper ph = DiagramTypeProvider.getHelperInstance();
	
	public UpdatePartFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canUpdate(IUpdateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context
				.getPictogramElement());
		return (bo instanceof Node && ph.isPart((Node)bo));
	}

	public IReason updateNeeded(IUpdateContext context) {
		// retrieve name from pictogram model
		PictogramElement pictogramElement = context.getPictogramElement();
		
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;
			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text t = (Text)shape.getGraphicsAlgorithm();
					if(t.getValue().contains("Node")) {
						
					}
				}
			}
		}
		
//		String pictogramName = null;
//		PictogramElement pictogramElement = context.getPictogramElement();
//		if (pictogramElement instanceof ContainerShape) {
//			ContainerShape cs = (ContainerShape) pictogramElement;
//			for (Shape shape : cs.getChildren()) {
//				if (shape.getGraphicsAlgorithm() instanceof Text) {
//					Text text = (Text) shape.getGraphicsAlgorithm();
//					pictogramName = text.getValue();
//				}
//			}
//		}
//		// retrieve name from business model
//		String businessName = null;
//		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
//		if (bo instanceof Node) {
//			Node node = (Node) bo;
//			businessName = node.getName();
//		}
//
//		// update needed, if names are different
//		boolean updateNameNeeded = ((pictogramName == null && businessName != null) || (pictogramName != null && !pictogramName
//				.equals(businessName)));
//		if (updateNameNeeded) {
//			return Reason.createTrueReason("Name is out of date");
//		} else {
//			return Reason.createFalseReason();
//		}
		return Reason.createFalseReason();
	}

	public boolean update(IUpdateContext context) {
		boolean res = false;
		//Oppdatere namn (f.eks. Hull0 vert endra)
		//Oppdatere attributt-verdiar 
		//Oppdatere attributt-namn
		
		res = updateNodeName(context);
//		res = updateAttributes(context);
		// retrieve name from business model
//		String businessName = null;
//		PictogramElement pictogramElement = context.getPictogramElement();
//		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
//		if (bo instanceof Node) {
//			Node node = (Node) bo;
//			businessName = node.getName();
//		}
//
//		// Set name in pictogram model
//		if (pictogramElement instanceof ContainerShape) {
//			ContainerShape cs = (ContainerShape) pictogramElement;
//			for (Shape shape : cs.getChildren()) {
//				if (shape.getGraphicsAlgorithm() instanceof Text) {
//					Text text = (Text) shape.getGraphicsAlgorithm();
//					text.setValue(businessName);
//					return true;
//				}
//			}
//		}
//
		return res;
	}

	private void updateAttributes(IUpdateContext context) {
		// TODO Auto-generated method stub
		
	}

	private boolean updateNodeName(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		String name = ((Node)getBusinessObjectForPictogramElement(pe)).getName();
		
		Assert.isNotNull(name);
		
		if(pe instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pe;
			for(Shape s : cs.getChildren()) {
				System.out.println(s);
				if(s.getGraphicsAlgorithm() instanceof Text) {
					Text t = (Text) s.getGraphicsAlgorithm();
					t.setValue(name);
					return true;
				}
			}
		}
		return false;
	}
	
}
