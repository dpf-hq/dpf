package no.hib.dpf.visualization.presentation;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class SpecificationEditPartFactory implements EditPartFactory {

	
	private EMap<IDObject, VElement> maps;

	public SpecificationEditPartFactory(Visualizations visualizations) {
		maps = visualizations.getEntries();
	}

	@Override
	public EditPart createEditPart(EditPart context, Object modelElement) {
		EditPart part = getPartForElement(modelElement);
		part.setModel(modelElement);
		return part;
	}

	protected EditPart getPartForElement(Object modelElement) {
		if (modelElement instanceof Graph) {
			return new GraphEditPart();
		}
		if (modelElement instanceof Node) {
			return new DPFNodeEditPart((VNode) maps.get(modelElement));
		}
		if (modelElement instanceof Arrow) {
			return new DPFArrowEditPart((VArrow) maps.get(modelElement));
		}
//		if (modelElement instanceof Offset) {
//			DOffset offset = (DOffset) modelElement;
//			if(offset.eContainer() instanceof DArrow)
//				return new ArrowLabelEditPart();
//		}
//		if(modelElement instanceof DGenericArrowConstraint)
//			return new TwoArrowsOneNodeConstraintEditPart();
//		if(modelElement instanceof DArrowLabelConstraint)
//			return new SingleArrowConstraintEditPart();
		throw new RuntimeException(
				"Can't create part for model element: "
				+ ((modelElement != null) ? modelElement.getClass().getName() : "null"));
	}
}
