package no.hib.dpf.visualization.presentation;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.DPFEditPartFactory;
import no.hib.dpf.visual.VArrow;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VNode;
import no.hib.dpf.visualization.Visualizations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.EditPart;

public class VisualizationEditPartFactory extends DPFEditPartFactory {

	
	private EMap<IDObject, VElement> maps;

	public VisualizationEditPartFactory(Visualizations visualizations) {
		maps = visualizations.getEntries();
	}

	protected EditPart getPartForElement(Object modelElement) {
		if (modelElement instanceof DNode) {
			DNode dNode = (DNode) modelElement;
			EList<Node> composedChildren = new BasicEList<Node>();
			VNode vNode = (VNode) maps.get(dNode.getNode().getTypeNode());
			
			if(vNode.isComposite()) {
				EList<Arrow> arrows = dNode.getNode().getTypeNode().getOutgoings();
				for(Arrow arrow : arrows) {
					if(((VArrow) maps.get(arrow)).isComposed())
						composedChildren.add(arrow.getTarget());
				}
			}
			
			return new DPFNodeEditPart(vNode, composedChildren);
		}
		if (modelElement instanceof DArrow) {
			DArrow dArrow = (DArrow) modelElement;
			return new DPFArrowEditPart((VArrow) maps.get(dArrow.getArrow().getTypeArrow()));
		}
		return super.getPartForElement(modelElement);
	}
}
