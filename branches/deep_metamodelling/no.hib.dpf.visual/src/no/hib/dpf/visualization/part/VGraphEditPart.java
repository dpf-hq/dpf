package no.hib.dpf.visualization.part;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.parts.DGraphEditPart;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.policies.VGraphXYLayoutEditPolicy;
import no.hib.dpf.visualization.util.VisualizationModelUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.gef.EditPolicy;

public class VGraphEditPart extends DGraphEditPart {
	
	EMap<DElement, VElement> maps;
	EList<VCompartment> compartments;
	
	public VGraphEditPart(EMap<DElement, VElement> maps, EList<VCompartment> compartments) {
		super();
		this.maps = maps;
		this.compartments = compartments;
	}	
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new VGraphXYLayoutEditPolicy(maps, compartments));
	}
	
	@Override
	protected List<DElement> getModelChildren() {
		EList<DElement> child = new BasicEList<DElement>();
		DGraph dgraph = getDGraph();
		Assert.isNotNull(dgraph);
		
		for (DNode dNode : dgraph.getDNodes()) {
			
			// Hide compartment elements etc..
			if(canAdd(dNode)){
				child.add(dNode);
			}
		}
		return child;
	}

	private boolean canAdd(DNode dNode) {	
		ArrayList<String> templateNodes = DPFTemplateUtils.getTemplateNodes((DGraph)dNode.eContainer());
		
		return !VisualizationModelUtils.isVCompartmentElement(dNode.getDType(), maps) && !templateNodes.contains(dNode.getName());
	}
}
