package no.hib.dpf.editor.utilities;

import java.util.ArrayList;

import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
import no.hib.dpf.editor.displaymodel.factories.DArrowDAttributeFactory;
import no.hib.dpf.editor.displaymodel.factories.DArrowFactory;
import no.hib.dpf.editor.displaymodel.factories.DDataNodeFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeDAttributeFactory;
import no.hib.dpf.editor.displaymodel.factories.DNodeFactory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.geometry.Point;


public class DPFTemplateUtils {

	public static final String DEFAULT_CLASS_DIAGRAM_TEMPLATE = "Template";
	private static final Point replicationLocation = new Point(5, 500);

	/**
	 * @author Ole Klokkhammer
	 * @param sourceDNode
	 * @return
	 */
	public static ArrayList<String> getTemplateArrows(DNode sourceDNode) {
		ArrayList<String> templateArrows = new ArrayList<String>();
		
		DGraph dgraph = (DGraph)sourceDNode.eContainer();
		if(dgraph != null){
			for (DArrow darrow : dgraph.getDArrows()) {
				DArrow templateDArrow = darrow.getTemplateDArrow();
				if(templateDArrow != null){
					templateArrows.add(templateDArrow.getName());
				}
			}
		}
		return templateArrows;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param dgraph
	 * @return
	 */
	public static ArrayList<String> getTemplateArrows(DGraph dgraph) {
		ArrayList<String> templateArrows = new ArrayList<String>();
		
		if(dgraph != null){
			for (DArrow darrow : dgraph.getDArrows()) {
				DArrow templateDArrow = darrow.getTemplateDArrow();
				if(templateDArrow != null){
					templateArrows.add(templateDArrow.getName());
				}
			}
		}
		return templateArrows;
	}

	
	/**
	 * @author Ole Klokkhammer
	 * @param dgraph
	 * @return
	 */
	public static ArrayList<String> getTemplateNodes(DGraph dgraph) {
		ArrayList<String> templateNodes = new ArrayList<String>();
		
		if(dgraph != null){
			for (DNode dnode : dgraph.getDNodes()) {
				DNode templateDNode = dnode.getTemplateDNode();
				if(templateDNode != null){
					templateNodes.add(templateDNode.getName());
				}
			}
		}
		return templateNodes;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dgraph
	 * @return
	 */
	public static ArrayList<String> getTemplateNodes(Graph graph) {
		ArrayList<String> templateNodes = new ArrayList<String>();
		
		if(graph != null){
			for (Node node : graph.getNodes()) {
				Node templateNode = (Node) node.getTemplateElement();
				if(templateNode != null){
					templateNodes.add(templateNode.getName());
				}
			}
		}
		return templateNodes;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dgraph
	 * @return
	 */
	public static ArrayList<String> getTemplateArrowAttributes(DArrow sourceDArrow) {
		ArrayList<String> templateArrowAttributes = new ArrayList<String>();
		
		DGraph dgraph = (DGraph)sourceDArrow.eContainer();
		if(dgraph != null){
			for (DArrowDAttribute darrowdattribute : dgraph.getDArrowDAttributes()) {
				DArrowDAttribute templateDArrowDAttribute = darrowdattribute.getTemplateDAttribute();
				if(templateDArrowDAttribute != null){
					templateArrowAttributes.add(templateDArrowDAttribute.getName());	
				}
			}
		}
		return templateArrowAttributes;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dgraph
	 * @return
	 */
	public static ArrayList<String> getTemplateArrowAttributes(DGraph dgraph) {
		ArrayList<String> templateArrowAttributes = new ArrayList<String>();
		
		if(dgraph != null){
			for (DArrowDAttribute darrowdattribute : dgraph.getDArrowDAttributes()) {
				DArrowDAttribute templateDArrowDAttribute = darrowdattribute.getTemplateDAttribute();
				if(templateDArrowDAttribute != null){
					templateArrowAttributes.add(templateDArrowDAttribute.getName());	
				}
			}
		}
		return templateArrowAttributes;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dgraph
	 * @return
	 */
	public static ArrayList<String> getTemplateNodeAttributes(DNode sourceDNode) {
		ArrayList<String> templateNodeAttributes = new ArrayList<String>();
		
		DGraph dgraph = (DGraph)sourceDNode.eContainer();
		if(dgraph != null){
			for (DNodeDAttribute dnodedattribute : dgraph.getDNodeDAttributes()) {
				DNodeDAttribute templateDNodeDAttribute = dnodedattribute.getTemplateDAttribute();
				if(templateDNodeDAttribute != null){
					templateNodeAttributes.add(templateDNodeDAttribute.getName());	
				}
			}
		}
		return templateNodeAttributes;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param dgraph
	 * @return
	 */
	public static ArrayList<String> getTemplateNodeAttributes(DGraph dgraph) {
		ArrayList<String> templateNodeAttributes = new ArrayList<String>();
		
		if(dgraph != null){
			for (DNodeDAttribute dnodedattribute : dgraph.getDNodeDAttributes()) {
				DNodeDAttribute templateDNodeDAttribute = dnodedattribute.getTemplateDAttribute();
				if(templateDNodeDAttribute != null){
					templateNodeAttributes.add(templateDNodeDAttribute.getName());	
				}
			}
		}
		return templateNodeAttributes;
	}

	/**
	 * TODO should not replicate if we are at the bottom-most metalevel
	 * 
	 * @author Ole Klokkhammer
	 * @param dSpecification
	 */
	public static void replicateTemplateElements(DGraph currentDGraph) {
		Assert.isNotNull(currentDGraph);
		DGraph typeDGraph = currentDGraph.getDType();
		
		DSpecification DType = (DSpecification) currentDGraph.eContainer();
		if(DType != null && DType.getSpecification().getMetalevel() < 0){
			return; // we do not want to replicate model elements at linguistic metalevels
		}
		
		if(typeDGraph != null){
			for (String templateDNodeName : DPFTemplateUtils.getTemplateNodes(typeDGraph)) {
				
				// get the typenode
				DNode typeDNode = DPFModelUtils.getDNodeFromDGraph(templateDNodeName, typeDGraph);
				
				// try to get the node from the graph. if successful, the node is already added
				DNode newDNode = DPFModelUtils.getDNodeFromDGraph(templateDNodeName, currentDGraph);
				if(newDNode != null || typeDNode == null){
					continue;
				}
				
				// if the node is not created already, create the node:
				newDNode = DPFModelUtils.createDNode(typeDNode);
				newDNode.getNode().setName(typeDNode.getName());
				newDNode.setLocation(replicationLocation);
				currentDGraph.addDNode(newDNode);
				
				// replicate attributes
				replicateTemplateNodeAttributesForNode(newDNode, currentDGraph);
			}
			
			// create and connect the arrows between the nodes
			for (String templateDArrowName : DPFTemplateUtils.getTemplateArrows(typeDGraph)) {
				// check if the arrow is already added:
				DArrow newDArrow = DPFModelUtils.getDArrowFromDGraph(templateDArrowName, currentDGraph);
				if(newDArrow != null){
					continue; // TODO
				}
				
				// get the typeArrow so we can create a new one
				DArrow typeDArrow = DPFModelUtils.getDArrowFromDGraph(templateDArrowName, typeDGraph);
				if(typeDArrow == null || typeDArrow.getDSource() == null || typeDArrow.getDTarget() == null){
					continue;// TODO
				}
				
				// get source and target nodes
				DNode dsource = DPFModelUtils.getDNodeFromDGraph(typeDArrow.getDSource().getName(), currentDGraph);
				DNode dtarget = DPFModelUtils.getDNodeFromDGraph(typeDArrow.getDTarget().getName(), currentDGraph);
				if(dsource == null || dtarget == null){
					continue;// TODO
				}
				
				newDArrow = DPFModelUtils.createDArrow(typeDArrow);
				DPFModelUtils.connectDArrow(dsource, newDArrow, dtarget);
				newDArrow.getArrow().setName(templateDArrowName);
				currentDGraph.addDArrow(newDArrow);
				
				// replicate arrowattributes 
				replicateTemplateArrowAttributesForArrow(newDArrow, currentDGraph);
			}
		}
	}

	public static void replicateTemplateArrowAttributesForArrow(DArrow newDArrow, DGraph currentdgraph) {
		Assert.isNotNull(newDArrow);
		DArrow newDArrowDType = newDArrow.getDType();
		
		// start generating node-attributes
		for (DArrowDAttribute dattribute : newDArrowDType.getDOutgoingAttributes()) {
			
			DDataNode typeDatanode = dattribute.getDTarget();
			DDataNodeFactory datanodeFactory = new DDataNodeFactory(typeDatanode);
			DDataNode ddatanode = (DDataNode)datanodeFactory.getNewObject();
			ddatanode.getDatanode().setValue(ddatanode.getDType().getDatanode().getValue());
			ddatanode.getDatanode().setDatatype(ddatanode.getDType().getDatanode().getDatatype());
			ddatanode.setLocation(replicationLocation);
			currentdgraph.addDDataNode(ddatanode);
			
			
			DArrowDAttribute darrowAttribute = DPFModelUtils.createDArrowDAttribute(dattribute);
			DPFModelUtils.connectDArrowDAttribute(newDArrow, darrowAttribute, ddatanode);
			darrowAttribute.getArrowAttribute().setName(dattribute.getName());
			currentdgraph.addDArrowDAttribute(darrowAttribute);
		}
	}

	public static void replicateTemplateNodeAttributesForNode(DNode newDNode, DGraph currentdgraph) {
		Assert.isNotNull(newDNode);
		DNode newDNodeDType = newDNode.getDType();
		
		// start generating node-attributes
		for (DNodeDAttribute dattribute : newDNodeDType.getDOutgoingAttributes()) {
			
			for (DNodeDAttribute existing_dattribute : newDNode.getDOutgoingAttributes()) {
				if(dattribute.getName().equals(existing_dattribute.getName())){
					continue;
				}
			}
			
			// create new datanode
			DDataNode typeDatanode = dattribute.getDTarget();
			DDataNodeFactory datanodeFactory = new DDataNodeFactory(typeDatanode);
			DDataNode ddatanode = (DDataNode)datanodeFactory.getNewObject();
			ddatanode.getDatanode().setValue(ddatanode.getDType().getDatanode().getValue());
			ddatanode.getDatanode().setDatatype(ddatanode.getDType().getDatanode().getDatatype());
			ddatanode.setLocation(replicationLocation);
			currentdgraph.addDDataNode(ddatanode);
			
			// create the node-attribute
			DNodeDAttribute dnodeAttribute = DPFModelUtils.createDNodeDAttribute(dattribute);
			DPFModelUtils.connectDNodeDAttribute(newDNode, dnodeAttribute, ddatanode);
			dnodeAttribute.getNodeAttribute().setName(dattribute.getName());
			currentdgraph.addDNodeDAttribute(dnodeAttribute);
		}
	}

	public static void generateDNodeElements(DNode currentDNode, DGraph currentDGraph) {
		
		DNode newDNodeDType = currentDNode.getDType();
		
		//check if outgoing arrow of typenode is containment arrow
		ArrayList<String> templateArrows = DPFTemplateUtils.getTemplateArrows(currentDGraph);
		for (DArrow outgoingDArrowDType : newDNodeDType.getDOutgoings()) {
			
			// if the arrow is a template arrow, we wont add it:
			if(templateArrows.contains(outgoingDArrowDType.getName())){
				return;
			}
			

		 	boolean isContainment = DPFMetaLanguageUtils.isContainment(outgoingDArrowDType.getArrow());
			if(isContainment){
				
				// generate target node
				DNode targetDNodeDType = outgoingDArrowDType.getDTarget();
				DNodeFactory factory = new DNodeFactory(targetDNodeDType);
				DNode newDNode = (DNode) factory.getNewObject();
				newDNode.setLocation(new Point(5,5));
				newDNode.getNode().setName(targetDNodeDType.getName());
				currentDGraph.addDNode(newDNode);
				DPFTemplateUtils.replicateTemplateNodeAttributesForNode(newDNode, currentDGraph);
				newDNode.getNode().setPotency(newDNode.getNode().getPotency());
				
				DArrowFactory darrowFactory = new DArrowFactory(outgoingDArrowDType);
				DArrow newDArrow = (DArrow) darrowFactory.getNewObject();
				currentDGraph.addDArrow(newDArrow);
				newDArrow.setDSource(currentDNode);
				newDArrow.setDTarget(newDNode);
				newDArrow.getArrow().setName(outgoingDArrowDType.getName());
				newDArrow.getArrow().setPotency(newDNode.getNode().getPotency());
				DPFTemplateUtils.replicateTemplateArrowAttributesForArrow(newDArrow, currentDGraph);
				
				// recursively regenerate
				generateDNodeElements(newDNode, currentDGraph);
			}
		}
		 
	}
}
