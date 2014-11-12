package no.hib.dpf.visual.util;

import java.util.HashMap;
import java.util.Map;

import no.hib.dpf.core.DataNode;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
import no.hib.dpf.editor.utilities.DPFMetaLanguageUtils;
import no.hib.dpf.editor.utilities.TemplateArrowAttributeUtils;
import no.hib.dpf.editor.utilities.TemplateNodeAttributeUtils;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visual.VisualUtils;
import no.hib.dpf.visual.Visuals;

import org.eclipse.core.runtime.Assert;

public class DPFVisualTemplateMappingUtils {

	
	/**
	 * TODO: should be improved. possibly move visualization type to the enriched graph at metalevel -2, which should make the solution more generic and not only for class diagrams
	 * 
	 * @author Ole Klokkhammer
	 * @param dspec
	 * @param visuals
	 * @return
	 */
	public static Map<DElement, VElement> getTemplateMapping(DSpecification dspec, Visuals visuals) {
		Assert.isNotNull(dspec);
		DGraph currentDGraph = dspec.getDGraph(); 
		DGraph typeDGraph = currentDGraph.getTemplateDGraph();
		Map<DElement, VElement> maps = new HashMap<DElement, VElement>();
		
		// Map nodes to visualization
		for (DNode typeDNode : typeDGraph.getDNodes()) {
			// get the visualization value
			String visualization = DPFMetaLanguageUtils.getVisualizationData(typeDNode.getNode());
			
			// map against visualizationtype
			mapNodeVisualization(typeDNode, visualization, visuals, maps);
		}
		
		// Map arrows to visualization
		for (DArrow typeDArrow : typeDGraph.getDArrows()) {
			
			// get the visualization value
			String visualization = DPFMetaLanguageUtils.getVisualizationData(typeDArrow.getArrow()); 
			
			// map against visualizationtype
			mapArrowVisualization(typeDArrow, visualization, visuals, maps);
		}
		
		return maps;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param typeDNode
	 * @param visualization
	 * @param visuals
	 * @param maps
	 */
	private static void mapNodeVisualization(DNode typeDNode, String visualization,
			Visuals visuals, Map<DElement, VElement> maps) {
		
		// map against visualizationtype
		for (VElement velement : visuals.getItems()) {
			if(velement.getName().equals(visualization)){
				maps.put(typeDNode, velement);
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param outgoingDArrow
	 * @param visualization
	 * @param visuals
	 * @param maps
	 */
	private static void mapArrowVisualization(DArrow outgoingDArrow,
			String visualization, Visuals visuals, Map<DElement, VElement> maps) {
		
		// map against visualizationtype
		for (VElement velement : visuals.getItems()) {
			if(velement.getName().equals(visualization)){
				maps.put(outgoingDArrow, velement);
			}
		}
	}
	
}
