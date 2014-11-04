package no.hib.dpf.editor.tests;

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;
import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_DSPECIFICATION;
import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_TYPE_DARROW;
import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_TYPE_DGRAPH;
import static no.hib.dpf.diagram.util.DPFConstants.REFLEXIVE_TYPE_DNODE;
import static no.hib.dpf.utils.DPFConstants.DEFAULT_SIGNATURE;
import static no.hib.dpf.utils.DPFConstants.REFLEXIVE_SPECIFICATION;
import static no.hib.dpf.utils.DPFConstants.REFLEXIVE_TYPE_ARROW;
import static no.hib.dpf.utils.DPFConstants.REFLEXIVE_TYPE_GRAPH;
import static no.hib.dpf.utils.DPFConstants.REFLEXIVE_TYPE_NODE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.VisualizationType;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.signature.SignatureEditor;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

public class Persistance {

/*	private DSpecification getExampleDSpecification(){
		DSpecification dSpecification = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		Specification specification1 = dSpecification.getSpecification();
		Graph graph = specification1.getGraph();
		Node node1 = CoreFactory.eINSTANCE.createDefaultNode();
		node1.setName("Node1");
		Node node2 = CoreFactory.eINSTANCE.createDefaultNode();
		node2.setName("Node2");
		Arrow arrow = CoreFactory.eINSTANCE.createDefaultArrow();
		arrow.setName("Arrow");
		arrow.setSource(node1);
		arrow.setTarget(node2);
		graph.getNodes().add(node1);
		graph.getNodes().add(node2);
		graph.getArrows().add(arrow);
		DNode dNode1 = DiagramFactory.eINSTANCE.createDefaultDNode();
		dNode1.setNode(node1);
		DNode dNode2 = DiagramFactory.eINSTANCE.createDefaultDNode();
		dNode2.setNode(node2);
		DArrow dArrow = DiagramFactory.eINSTANCE.createDefaultDArrow();
		dArrow.setArrow(arrow);
		dArrow.setDSource(dNode1);
		dArrow.setDTarget(dNode2);
		DGraph dGraph = dSpecification.getDGraph();
		dGraph.getDNodes().add(dNode1);
		dGraph.getDNodes().add(dNode2);
		dGraph.getDArrows().add(dArrow);
		return dSpecification;
	}

	private void saveDPFSpecification(ResourceSetImpl resourceSet, DSpecification dSpecification, URI diagram){
		DPFEditor.saveDSpecification(resourceSet, dSpecification, diagram, new HashMap<Resource, Diagnostic>());
	}
	private DSignature getExampleDSignature(){
		DSignature result = DiagramFactory.eINSTANCE.createDefaultDSignature();
		DPredicate dPredicate = DiagramFactory.eINSTANCE.createDefaultDPredicate();
		DGraph dGraph = dPredicate.getDGraph();
		DNode X = DiagramFactory.eINSTANCE.createDNode("X", null);
		DNode Y = DiagramFactory.eINSTANCE.createDNode("Y", null);
		DArrow XY = DiagramFactory.eINSTANCE.createDArrow("XY", X, Y, null);
		dGraph.addDNode(X);
		dGraph.addDNode(Y);
		dGraph.addDArrow(XY);
		dPredicate.getVisualization().setType(VisualizationType.COMPOSED);
		dPredicate.setSimpleName("TEST");
		result.getDPredicates().add(dPredicate);
		return result;
	}

	@Test
	public void testDPFSignature(){
		DSignature sample = getExampleDSignature();
		ResourceSetImpl resourceSet = DPFEditor.getResourceSet();
		URI signatureURI = URI.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + IPath.SEPARATOR +  "Example.sig");
		SignatureEditor.saveDSignature(resourceSet, signatureURI, sample, new HashMap<Resource, Diagnostic>());

		resourceSet = DPFEditor.getResourceSet();
		sample = SignatureEditor.loadDSignature(resourceSet, signatureURI, new HashMap<Resource, Diagnostic>());
		EcoreUtil.resolveAll(sample);
		DSpecification example = getExampleDSpecification();
		example.setDSignature(sample);
		URI diagramURI = URI.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + IPath.SEPARATOR + "Example.dpf");
		DPFEditor.updateResourceSet(resourceSet, example, null, diagramURI);
		checkResourceSet(resourceSet, example, diagramURI);
		DPFEditor.saveDSpecification(resourceSet, example, diagramURI, new HashMap<Resource, Diagnostic>());
		
		resourceSet = DPFEditor.getResourceSet();
		example = DPFEditor.loadDSpecification(resourceSet, diagramURI, new HashMap<Resource, Diagnostic>());
		EcoreUtil.resolveAll(example);
		EcoreUtil.resolveAll(example.getSpecification());
		if(example.getDSignature() != null){
			EcoreUtil.resolveAll(example.getDSignature());
			EcoreUtil.resolveAll(example.getDSignature().getSignature());
		}
		testDSpecification(example);
		DPFEditor.saveDSpecification(resourceSet, example, diagramURI, new HashMap<Resource, Diagnostic>());
		
		
	}
	private void checkResourceSet(ResourceSetImpl resourceSet,
			DSpecification example, URI uri) {
		Resource resource = resourceSet.getResource(uri, false);
		checkResource(example, resource);
		checkResource(example.getSpecification(), resourceSet.getResource(DPFEditor.getModelURI(uri), false));
	}

	private void checkResource(EObject example, Resource resource) {
		if(example instanceof DSpecification){
			DSpecification dSpecification = (DSpecification) example;
			assertTrue(example.eResource() == resource);
			checkResource(dSpecification.getDSignature(), resource);
		}

		if(example instanceof Specification){
			Specification dSpecification = (Specification) example;
			assertTrue(example.eResource() == resource);
			checkResource(dSpecification.getSignature(), resource);
		}

		if(example instanceof DSignature){
			DSignature dSpecification = (DSignature) example;
			assertTrue(example.eResource() == resource);
			for(DPredicate predicate : dSpecification.getDPredicates()){
				assertTrue(predicate.eResource() == resource);
				checkResource(predicate.getDGraph(), resource);
			}
		}
		if(example instanceof Signature){
			Signature dSpecification = (Signature) example;
			assertTrue(example.eResource() == resource);
			for(Predicate predicate : dSpecification.getPredicates()){
				assertTrue(predicate.eResource() == resource);
				checkResource(predicate.getShape(), resource);
			}
		}
		if(example instanceof DGraph){
			DGraph dGraph = (DGraph) example;
			for(DNode dNode : dGraph.getDNodes())
				checkResource(dNode , resource);
					for(DArrow dNode : dGraph.getDArrows())
						checkResource(dNode , resource);
		}
		if(example instanceof Graph){
			Graph dGraph = (Graph) example;
			for(Node dNode : dGraph.getNodes())
				checkResource(dNode , resource);
					for(Arrow dNode : dGraph.getArrows())
						checkResource(dNode , resource);
		}
		if(example != null)
			assertTrue(example.eResource() == resource);
	}
	@Test
	public void testDPFPersisitence() {
		DSpecification dSpecification = getExampleDSpecification();
		testDSpecification(dSpecification );

		ResourceSetImpl resourceSet = DPFEditor.getResourceSet();
		URI diagramURI = URI.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + IPath.SEPARATOR + "Example.dpf");
		DPFEditor.updateResourceSet(resourceSet, dSpecification, null, diagramURI);
		saveDPFSpecification(resourceSet, dSpecification, diagramURI);

		//create two level specification
		resourceSet = DPFEditor.getResourceSet();
		dSpecification = DPFEditor.loadDSpecification(resourceSet, diagramURI, new HashMap<Resource, Diagnostic>());
		testDSpecification(dSpecification);

		DSpecification twoLevel = DiagramFactory.eINSTANCE.createDefaultDSpecification();
		twoLevel.setDType(dSpecification);
		testDSpecification(twoLevel);

		URI twoLevelURI = URI.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + IPath.SEPARATOR + "Twolevel.dpf");
		DPFEditor.updateResourceSet(resourceSet, twoLevel, diagramURI, twoLevelURI);
		saveDPFSpecification(resourceSet, twoLevel, twoLevelURI);

		//store it to another place
		resourceSet = DPFEditor.getResourceSet();
		twoLevel = DPFEditor.loadDSpecification(resourceSet, twoLevelURI, new HashMap<Resource, Diagnostic>());
		testDSpecification(twoLevel);

		URI anotherURI = URI.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + IPath.SEPARATOR + "Another.dpf");
		DPFEditor.updateResourceSet(resourceSet, twoLevel, twoLevelURI, anotherURI);
		saveDPFSpecification(resourceSet, twoLevel, anotherURI);

		twoLevel = DPFEditor.loadDSpecification(DPFEditor.getResourceSet(), anotherURI, new HashMap<Resource, Diagnostic>());
		testDSpecification(twoLevel);
	}

	@Test
	public void testDefaults(){
		testNode(CoreFactory.eINSTANCE.createDefaultNode());
		testDNode(DiagramFactory.eINSTANCE.createDefaultDNode());
		testArrow(CoreFactory.eINSTANCE.createDefaultArrow());
		testDArrow(DiagramFactory.eINSTANCE.createDefaultDArrow());
		testGraph(CoreFactory.eINSTANCE.createDefaultGraph());
		testDGraph(DiagramFactory.eINSTANCE.createDefaultDGraph());
		testSpecification(CoreFactory.eINSTANCE.createDefaultSpecification());
		testDSpecification(DiagramFactory.eINSTANCE.createDefaultDSpecification());
	}
	@Test
	public void testConstants(){
		assertNotNull(REFLEXIVE_TYPE_NODE);
		assertNull(REFLEXIVE_TYPE_NODE.getTypeNode());

		assertNotNull(REFLEXIVE_TYPE_DNODE);
		assertNull(REFLEXIVE_TYPE_DNODE.getDType());
		assertTrue(REFLEXIVE_TYPE_DNODE.getNode() == REFLEXIVE_TYPE_NODE);

		assertNotNull(REFLEXIVE_TYPE_ARROW);
		assertNull(REFLEXIVE_TYPE_ARROW.getTypeArrow());
		assertTrue(REFLEXIVE_TYPE_ARROW.getSource() == REFLEXIVE_TYPE_NODE);
		assertTrue(REFLEXIVE_TYPE_ARROW.getTarget() == REFLEXIVE_TYPE_NODE);

		assertNotNull(REFLEXIVE_TYPE_DARROW);
		assertNull(REFLEXIVE_TYPE_DARROW.getDType());
		assertTrue(REFLEXIVE_TYPE_DARROW.getArrow() == REFLEXIVE_TYPE_ARROW);
		assertTrue(REFLEXIVE_TYPE_DARROW.getDSource() == REFLEXIVE_TYPE_DNODE);
		assertTrue(REFLEXIVE_TYPE_DARROW.getDTarget() == REFLEXIVE_TYPE_DNODE);

		assertNotNull(REFLEXIVE_TYPE_GRAPH);
		assertNull(REFLEXIVE_TYPE_GRAPH.getType());
		assertTrue(REFLEXIVE_TYPE_GRAPH.getNodes().size() == 1);
		assertTrue(REFLEXIVE_TYPE_GRAPH.getArrows().size() == 1);
		assertTrue(REFLEXIVE_TYPE_GRAPH.getNodes().get(0) == REFLEXIVE_TYPE_NODE);
		assertTrue(REFLEXIVE_TYPE_GRAPH.getArrows().get(0) == REFLEXIVE_TYPE_ARROW);
		assertTrue(REFLEXIVE_TYPE_NODE.eContainer() == REFLEXIVE_TYPE_GRAPH);
		assertTrue(REFLEXIVE_TYPE_ARROW.eContainer() == REFLEXIVE_TYPE_GRAPH);

		assertNotNull(REFLEXIVE_TYPE_DGRAPH);
		assertNull(REFLEXIVE_TYPE_DGRAPH.getDType());
		assertTrue(REFLEXIVE_TYPE_DGRAPH.getDNodes().size() == 1);
		assertTrue(REFLEXIVE_TYPE_DGRAPH.getDArrows().size() == 1);
		assertTrue(REFLEXIVE_TYPE_DGRAPH.getDNodes().get(0) == REFLEXIVE_TYPE_DNODE);
		assertTrue(REFLEXIVE_TYPE_DGRAPH.getDArrows().get(0) == REFLEXIVE_TYPE_DARROW);
		assertTrue(REFLEXIVE_TYPE_DNODE.eContainer() == REFLEXIVE_TYPE_DGRAPH);
		assertTrue(REFLEXIVE_TYPE_DARROW.eContainer() == REFLEXIVE_TYPE_DGRAPH);

		assertNotNull(DEFAULT_SIGNATURE);
		assertNotNull(DEFAULT_DSIGNATURE);
		assertTrue(DEFAULT_DSIGNATURE.getSignature() == DEFAULT_SIGNATURE);

		testDSignature(DEFAULT_DSIGNATURE);

		assertNotNull(REFLEXIVE_SPECIFICATION);
		assertNull(REFLEXIVE_SPECIFICATION.getType());
		assertTrue(REFLEXIVE_SPECIFICATION.getGraph() == REFLEXIVE_TYPE_GRAPH);
		assertTrue(REFLEXIVE_TYPE_GRAPH.eContainer() == REFLEXIVE_SPECIFICATION);

		assertNotNull(REFLEXIVE_DSPECIFICATION);
		assertTrue(REFLEXIVE_TYPE_DGRAPH.eContainer() == REFLEXIVE_DSPECIFICATION);
		assertNull(REFLEXIVE_DSPECIFICATION.getDType());
		assertTrue(REFLEXIVE_DSPECIFICATION.getDGraph() == REFLEXIVE_TYPE_DGRAPH);
		assertTrue(REFLEXIVE_DSPECIFICATION.getDSignature() == DEFAULT_DSIGNATURE);
	}

	private void testNode(Node node) {
		if(node != REFLEXIVE_TYPE_NODE){
			Node type = node.getTypeNode();
			assertNotNull(type);
			testNode(type);
		}
	}

	private void testDNode(DNode dNode) {
		if(dNode != REFLEXIVE_TYPE_DNODE){
			DNode type = dNode.getDType();
			assertNotNull(dNode.getNode());
			assertNotNull(type);
			assertTrue(type.getNode() == dNode.getNode().getTypeNode());
			testDNode(type);
			testNode(type.getNode());
			testNode(dNode.getNode());
		}
	}

	private void testArrow(Arrow arrow) {
		if(arrow != REFLEXIVE_TYPE_ARROW){
			Arrow type = arrow.getTypeArrow();
			assertNotNull(type);
			assertTrue(arrow.getSource() != null || arrow.getTarget() == null);
			if(arrow.getSource() != null){
				assertTrue(arrow.getSource().getTypeNode() == type.getSource());
				assertTrue(arrow.getTarget().getTypeNode() == type.getTarget());
				testNode(type.getSource());
				testNode(type.getTarget());
			}
			testArrow(type);
		}
	}

	private void testDArrow(DArrow dArrow) {
		if(dArrow != REFLEXIVE_TYPE_DARROW){
			DArrow type = dArrow.getDType();
			assertNotNull(dArrow.getArrow());
			assertNotNull(type);
			assertTrue(type.getArrow() == dArrow.getArrow().getTypeArrow());
			assertTrue(dArrow.getDSource() != null || dArrow.getDTarget() == null);
			if(dArrow.getDSource() != null){
				assertTrue(dArrow.getDSource().getNode() == dArrow.getArrow().getSource());
				assertTrue(dArrow.getDTarget().getNode() == dArrow.getArrow().getTarget());
			}
			testDArrow(type);
			testArrow(type.getArrow());
			testArrow(dArrow.getArrow());
		}
	}

	public void testSpecification(Specification specification){
		if(specification != REFLEXIVE_SPECIFICATION){
			Specification type = specification.getType();
			assertNotNull(type);
			testSpecification(type);
			assertNotNull(specification.getGraph());
			assertTrue(specification.getType().getGraph() == specification.getGraph().getType());
			testGraph(specification.getGraph());
		}
	}

	public void testDGraphWithGraph(DGraph dGraph, Graph graph){
		assertTrue(dGraph.getGraph() == graph);
		for(DNode dNode : dGraph.getDNodes())
			graph.getNodes().contains(dNode.getNode());
				for(DArrow dArrow : dGraph.getDArrows())
					graph.getArrows().contains(dArrow.getArrow());
	}

	public void testDSpecification(DSpecification dSpecification){
		if(dSpecification != REFLEXIVE_DSPECIFICATION){
			DSpecification type = dSpecification.getDType();
			assertNotNull(type);
			assertNotNull(dSpecification.getSpecification());
			assertTrue(type.getSpecification() == dSpecification.getSpecification().getType());
			assertTrue(type.getDGraph() == dSpecification.getDGraph().getDType());
			testDSpecification(type);
			testSpecification(dSpecification.getSpecification());
			testDGraph(dSpecification.getDGraph());
			testDSignature(dSpecification.getDSignature());
			testDGraphWithGraph(dSpecification.getDGraph(), dSpecification.getSpecification().getGraph());
		}

	}

	public void testDSignature(DSignature signature){
		if(signature != null){
			assertTrue(signature.getDPredicates().size() == signature.getSignature().getPredicates().size());
		for(DPredicate dPredicate : signature.getDPredicates()){
			testDGraph(dPredicate.getDGraph());
			testGraph(dPredicate.getPredicate().getShape());
			testDGraphWithGraph(dPredicate.getDGraph(), dPredicate.getPredicate().getShape());
		}
		
		}
	}
	private void testGraph(Graph graph) {
		if(graph != REFLEXIVE_TYPE_GRAPH){
			Graph type = graph.getType();
			assertNotNull(type);
			for(Node node : graph.getNodes())
				testNode(node);
					for(Arrow arrow : graph.getArrows())
						testArrow(arrow);
							testGraph(type);
		}
	}

	public void testDGraph(DGraph dGraph) {
		if(dGraph != REFLEXIVE_TYPE_DGRAPH){
			DGraph type = dGraph.getDType();
			assertNotNull(dGraph.getGraph());
			assertNotNull(type != null);
			testDGraph(type);
			for(DArrow dArrow : dGraph.getDArrows()){
				assertTrue(dArrow.eContainer() == dGraph);
				testDArrow(dArrow);
			}
			for(DNode dNode : dGraph.getDNodes()){
				assertTrue(dNode.eContainer() == dGraph);
				testDNode(dNode);
			}
			testGraph(dGraph.getGraph());
		}
	}


	@Test
	public void testModelLoading(){
		Specification model = DPFCoreUtil.loadSpecification(URI.createFileURI("model/testModel.xmi"));
		assertNotNull(model);
		EList<Constraint> constraints = model.getConstraints();
		for(Constraint constraint : constraints)
			System.out.println(constraint);
				
		Graph graph = model.getGraph();
		for(Node node : graph.getNodes())
			System.out.println(node.getName());
		
		for(Arrow arrow : graph.getArrows()){
			System.out.print(arrow.getName() + " : ");
			System.out.print(arrow.getSource().getName() + " --> ");
			System.out.println(arrow.getTarget().getName());
		}
				
		Specification instance = CoreFactory.eINSTANCE.createDefaultSpecification();
		instance.setType(model);
		Graph igraph = instance.getGraph();
		Node page1 = igraph.createNode("page1", graph.getNodeByName("Webpage"));
		Node page2 = igraph.createNode("page2", graph.getNodeByName("Webpage"));
		Node entity = igraph.createNode("entity", graph.getNodeByName("Entiy"));
		Node type = igraph.createNode("image", graph.getNodeByName("Datatype"));
		Node Application = igraph.createNode("app", graph.getNodeByName("Application"));
		igraph.createArrow("data1", page1, entity, graph.getArrowByName("data"));
		igraph.createArrow("attribute", entity, type, graph.getArrowByName("attribute"));
		igraph.createArrow("href1", page1, page2, graph.getArrowByName("href"));
		igraph.createArrow("mainPage", Application, page1, graph.getArrowByName("startPage"));
		DPFCoreUtil.saveSpecification(URI.createFileURI("model/testInstance.xmi"), instance);
	}

*/
}
