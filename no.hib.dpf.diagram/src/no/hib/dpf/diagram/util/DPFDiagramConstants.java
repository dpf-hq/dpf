package no.hib.dpf.diagram.util;

  
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;

public class DPFDiagramConstants extends no.hib.dpf.utils.DPFCoreConstants{
	
	public static final DNode REFLEXIVE_TYPE_DNODE = DiagramFactory.eINSTANCE.createConstantDNode();
	public static final DDataNode REFLEXIVE_TYPE_DDATANODE = DiagramFactory.eINSTANCE.createConstantDDataNode(); 
	
	public static final DArrow REFLEXIVE_TYPE_DARROW = DiagramFactory.eINSTANCE.createConstantDArrow();
	public static final DNodeDAttribute REFLEXIVE_TYPE_DNODE_DATTRIBUTE = DiagramFactory.eINSTANCE.createConstantDNodeDAttribute(); 
	public static final DArrowDAttribute REFLEXIVE_TYPE_DARROW_DATTRIBUTE = DiagramFactory.eINSTANCE.createConstantDArrowDAttribute(); 
	
	
	public static final DGraph REFLEXIVE_TYPE_DGRAPH = DiagramFactory.eINSTANCE.createConstantDGraph();
	public static final DSignature DEFAULT_DSIGNATURE = DiagramFactory.eINSTANCE.createConstantDSignature();
	public static final DSpecification REFLEXIVE_DSPECIFICATION = DiagramFactory.eINSTANCE.createConstantDSpecification();
}
