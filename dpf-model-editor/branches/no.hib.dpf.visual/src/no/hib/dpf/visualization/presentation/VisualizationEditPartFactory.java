package no.hib.dpf.visualization.presentation;

import no.hib.dpf.core.IDObject;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.DPFEditPartFactory;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.EditPart;

public class VisualizationEditPartFactory extends DPFEditPartFactory {

	
	private EMap<IDObject, VElement> maps;
	private EList<VCompartment> compartments;

	public VisualizationEditPartFactory(Visualizations visualizations) {
		maps = visualizations.getEntries();
		compartments = visualizations.getCompartments();
	}

	protected EditPart getPartForElement(Object modelElement) {
		if (modelElement instanceof DGraph) {
			return new DPFGraphEditPart(maps);
		}
		if (modelElement instanceof DNode) {
			DNode dNode = (DNode) modelElement;
			EList<VCompartment> nodeCompartments = new BasicEList<VCompartment>();
			for(VCompartment compartment: compartments){
				if(compartment.getParent() == maps.get(dNode.getNode().getTypeNode()))
					nodeCompartments.add(compartment);
			}
			return new DPFNodeEditPart((VNode) maps.get(dNode.getNode().getTypeNode()), nodeCompartments, maps);
		}
		if (modelElement instanceof DArrow) {
			DArrow dArrow = (DArrow) modelElement;
			return new DPFArrowEditPart((VArrow) maps.get(dArrow.getArrow().getTypeArrow()));
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
