package no.hib.dpf.visualization.part;
 
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.displaymodel.factories.DPFEditPartFactory;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.Visualizations;
import no.hib.dpf.visualization.util.VCompartmentUtils;
import no.hib.dpf.visualization.util.VisualizationModelUtils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.EditPart;

public class VisualizationEditPartFactory extends DPFEditPartFactory {
	
	private EMap<DElement, VElement> maps;
	private EList<VCompartment> compartments;
 
	public VisualizationEditPartFactory(Visualizations visualizations) {
		maps = visualizations.getEntries();
		compartments = visualizations.getCompartments();
	}

	@Override
	protected EditPart getPartForElement(Object modelElement) {
		if (modelElement instanceof DGraph) { 
			return new VGraphEditPart(maps, compartments);
		}
		if (modelElement instanceof DNode) {
			DNode dNode = (DNode) modelElement;
			EList<VCompartment> nodeCompartments = VCompartmentUtils.getCompartments(dNode, compartments, maps); 
			VNode vnode = (VNode)VisualizationModelUtils.getVElement(dNode.getDType(), maps);
			if(vnode == null){
				return super.getPartForElement(modelElement);
			}
			return new VNodeEditPart(vnode, nodeCompartments, maps);
		}
		if (modelElement instanceof DArrow) {
			DArrow dArrow = (DArrow) modelElement;
			VArrow vArrow = (VArrow)VisualizationModelUtils.getVElement(dArrow.getDType(), maps);
			return new VArrowEditPart((VArrow) vArrow);
		}
		if (modelElement instanceof VCompartment) {
			return new VCompartmentEditPart();
		}
		if (modelElement instanceof VCompartmentElement) {
			return new VCompartmentElementEditPart(); 
		}
		return super.getPartForElement(modelElement);
	}
}
