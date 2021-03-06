/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DComposedConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.diagram.Visualization;
import no.hib.dpf.diagram.VisualizationType;
import no.hib.dpf.diagram.util.DPFConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramFactoryImpl extends EFactoryImpl implements DiagramFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagramPackage getPackage() {
		return DiagramPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramFactory init() {
		try {
			DiagramFactory theDiagramFactory = (DiagramFactory)EPackage.Registry.INSTANCE.getEFactory(DiagramPackage.eNS_URI);
			if (theDiagramFactory != null) {
				return theDiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertEDimensionToString(EDataType eDataType, Object instanceValue) {
		Dimension point = (Dimension) instanceValue;
		return point.width + " " + point.height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertELocationToString(EDataType eDataType, Object instanceValue) {
		Point point = (Point) instanceValue;
		return point.x + " " + point.y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case DiagramPackage.VISUALIZATION_TYPE:
			return convertVisualizationTypeToString(eDataType, instanceValue);
		case DiagramPackage.EDIMENSION:
			return convertEDimensionToString(eDataType, instanceValue);
		case DiagramPackage.ELOCATION:
			return convertELocationToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisualizationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case DiagramPackage.DSPECIFICATION: return createDSpecification();
		case DiagramPackage.DGRAPH: return createDGraph();
		case DiagramPackage.DNODE: return createDNode();
		case DiagramPackage.DCONSTRAINT_NODE: return createDConstraintNode();
		case DiagramPackage.DARROW: return createDArrow();
		case DiagramPackage.DCONSTRAINT: return createDConstraint();
		case DiagramPackage.DARROW_LABEL_CONSTRAINT: return createDArrowLabelConstraint();
		case DiagramPackage.DGENERIC_ARROW_CONSTRAINT: return createDGenericArrowConstraint();
		case DiagramPackage.DCOMPOSED_CONSTRAINT: return createDComposedConstraint();
		case DiagramPackage.DPREDICATE: return createDPredicate();
		case DiagramPackage.DOFFSET: return createDOffset();
		case DiagramPackage.DSIGNATURE: return createDSignature();
		case DiagramPackage.VISUALIZATION: return createVisualization();
		case DiagramPackage.DELEMENT: return createDElement();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	private DPredicate createArrowLabelDPredicate(
			Predicate predicate, String icon) {
		if(predicate == null)
			return null;
		DPredicate result = createDPredicate(predicate, icon);
		Visualization visualization = result.getVisualization();
		visualization.setType(VisualizationType.ARROW_LABEL);
		Graph graph = result.getPredicate().getShape();
		visualization.setSource(graph.getArrowByName("XY"));
		return result;
	}

	private DPredicate createNodeDPredicate(
			Predicate predicate, String icon) {
		if(predicate == null)
			return null;
		DPredicate result = createDPredicate(predicate, icon);
		Visualization visualization = result.getVisualization();
		visualization.setType(VisualizationType.ON_NODE);
		Graph graph = result.getPredicate().getShape();
		visualization.setSource(graph.getArrowByName("X"));
		return result;
	}

	private DPredicate createArrowToArrowDPredicate(Predicate predicate,
			String icon, String source,
			String target) {
		if(predicate == null)
			return null;
		DPredicate result = createDPredicate(predicate, icon);
		Visualization visualization = result.getVisualization();
		visualization.setType(VisualizationType.ARROW_TO_ARROW);
//		Graph graph = result.getPredicate().getShape();
//		visualization.setSource(graph.getArrowByName(source));
//		visualization.setTarget(graph.getArrowByName(target));
		return result;
	}

	private DPredicate createComposedDPredicate(Predicate predicate, String icon) {
		if(predicate == null)
			return null;
		DPredicate result = createDPredicate(predicate, icon);
		Visualization visualization = result.getVisualization();
		visualization.setType(VisualizationType.COMPOSED);
		return result;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DArrow createConstantDArrow() {
		DArrow darrow = new DArrowImpl();
		darrow.setArrow(DPFConstants.REFLEXIVE_TYPE_ARROW);
		darrow.setDSource(DPFConstants.REFLEXIVE_TYPE_DNODE);
		darrow.setDTarget(DPFConstants.REFLEXIVE_TYPE_DNODE);
		darrow.setDType(darrow);
		return darrow;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DGraph createConstantDGraph() {
		DGraph dGraph = new DGraphImpl();
		dGraph.setGraph(DPFConstants.REFLEXIVE_TYPE_GRAPH);
		dGraph.addDNode(DPFConstants.REFLEXIVE_TYPE_DNODE);
		dGraph.addDArrow(DPFConstants.REFLEXIVE_TYPE_DARROW);
		return dGraph;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DNode createConstantDNode() {
		DNode dnode = new DNodeImpl();
		dnode.setNode(DPFConstants.REFLEXIVE_TYPE_NODE);
		dnode.setDType(dnode);
		return dnode;
	}

	@Override
	public DSignature createConstantDSignature() {
		DSignatureImpl result = new DSignatureImpl();
		result.setSignature(DPFConstants.DEFAULT_SIGNATURE);
		DPredicate dPredicate = createArrowLabelDPredicate(DPFConstants.INJECTIVE, "/icons/inj_36.png");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowLabelDPredicate(DPFConstants.SURJECTIVE, "/icons/surj_36.png");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowLabelDPredicate(DPFConstants.IRREFLEXIVE, "/icons/irr_36.png");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);		
		dPredicate = createArrowLabelDPredicate(DPFConstants.ARROW_MULTI, "/icons/mult_36.png");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowToArrowDPredicate(DPFConstants.INVERSE, "/icons/inv_36.png", "XY", "YX");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowToArrowDPredicate(DPFConstants.JOINT_SURJ, "/icons/js_36.png", "XZ", "YZ");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowToArrowDPredicate(DPFConstants.JOINT_INJE, "/icons/ji_36.png", "XY", "XZ");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowToArrowDPredicate(DPFConstants.XOR, "/icons/xor_36.png", "ZX", "ZY");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowToArrowDPredicate(DPFConstants.SPLIT_NAND, "/icons/nand_36.png", "ZX", "ZY");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowToArrowDPredicate(DPFConstants.MERGE_NAND, "/icons/nand_merge_36.png", "XZ", "YZ");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createNodeDPredicate(DPFConstants.NODE_MULTI, "/icons/mult_node_36.png");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createArrowLabelDPredicate(DPFConstants.REFLEXIVE, "/icons/ref_36.png");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		dPredicate = createComposedDPredicate(DPFConstants.XOR4, "/icons/xor4_36.png");
		dPredicate.setId("diagram-" + dPredicate.getPredicate().getId());
		result.addDPredicate(dPredicate);
		return result;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DSpecification createConstantDSpecification() {
		DSpecificationImpl result = new DSpecificationImpl();
		result.setSpecification(DPFConstants.REFLEXIVE_SPECIFICATION);
		result.setDSignature(DPFConstants.DEFAULT_DSIGNATURE);
		result.setDGraph(DPFConstants.REFLEXIVE_TYPE_DGRAPH);
		return result;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DArrow createDArrow() {
		DArrowImpl dArrow = new DArrowImpl();
		dArrow.setDType(DPFConstants.REFLEXIVE_TYPE_DARROW);
		return dArrow;
	}

	/**
	 * @generated NOT
	 */
	public DArrow createDArrow(Arrow arrow, DNode source, DNode target, DArrow type) {
		DArrow newArrow = new DArrowImpl();
		newArrow.setArrow(arrow);
		newArrow.setDSource(source);
		newArrow.setDTarget(target);
		newArrow.setDType(type);
		return newArrow;
	}
	@Override
	/**
	 * @generated NOT
	 */
	public DArrow createDArrow(String name, DNode source, DNode target, DArrow type) {
		if(type == null)
			type = DPFConstants.REFLEXIVE_TYPE_DARROW;
		return createDArrow(CoreFactory.eINSTANCE.createArrow(name, source.getNode(), target.getNode(), type.getArrow()), source, target, type);
	}

	@Override
	public DArrowLabelConstraint createDArrowLabelConstraint() {
		DArrowLabelConstraintImpl dArrowLabelConstraint = new DArrowLabelConstraintImpl();
		return dArrowLabelConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DComposedConstraint createDComposedConstraint() {
		DComposedConstraintImpl dComposedConstraint = new DComposedConstraintImpl();
		return dComposedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DConstraint createDConstraint() {
		DConstraintImpl dConstraint = new DConstraintImpl();
		return dConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * Default Value for DArrow
	 * Arrow : a new Arrow not Arrow.REFLEXIVE_TYPE_ARROW
	 * DType : DArrow.REFLEXIVE_TYPE_DARROW
	 * DSource : null
	 * DTarget : null
	 * DGraph : null
	 * Location : (0,0)
	 * Size : (0, 0)
	 * Configure : null
	 * @generated NOT
	 */
	public DArrow createDefaultDArrow() {
		DArrowImpl dArrow = new DArrowImpl();
		dArrow.setArrow(CoreFactory.eINSTANCE.createArrow());
		dArrow.setDType(DPFConstants.REFLEXIVE_TYPE_DARROW);
		dArrow.setNameOffset(DiagramFactory.eINSTANCE.createDefaultDOffset());
		return dArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DConstraint createDefaultDConstraint() {
		DConstraintImpl dConstraint = new DConstraintImpl();
		dConstraint.setConstraint(CoreFactory.eINSTANCE.createConstraint());
		return dConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * Default Value for DGraph
	 * Graph : a new Graph
	 * DType : DGraph.REFLEXIVE_TYPE_DGRAPH
	 * @generated NOT
	 */
	public DGraph createDefaultDGraph() {
		DGraphImpl dGraph = new DGraphImpl();
		dGraph.setGraph(CoreFactory.eINSTANCE.createGraph());
		dGraph.setDType(DPFConstants.REFLEXIVE_TYPE_DGRAPH);
		return dGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * Default Value for DNode
	 * Node : a new Node not Node.REFLEXIVE_TYPE_NODE
	 * DType : DNode.REFLEXIVE_TYPE_DNODE
	 * DGraph : null
	 * Location : (0,0)
	 * Size : (0, 0)
	 * Configure : null
	 * @generated NOT
	 */
	public DNode createDefaultDNode() {
		DNodeImpl dNode = new DNodeImpl();
		dNode.setNode(CoreFactory.eINSTANCE.createNode());
		dNode.setDType(DPFConstants.REFLEXIVE_TYPE_DNODE);
		dNode.setSize(DNode.DEFAULT_DIMENSION);
		dNode.setLocation(new Point());
		return dNode;
	}

	@Override
	public DOffset createDefaultDOffset() {
		//		Adjust the initial position of the arrow label
		return new DOffsetImpl(new Point(10, -3), 16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DPredicate createDefaultDPredicate() {
		DPredicateImpl dPredicate = new DPredicateImpl();
		dPredicate.setPredicate(CoreFactory.eINSTANCE.createDefaultPredicate());
		dPredicate.setDGraph(createDefaultDGraph());
		dPredicate.setVisualization(createVisualization());
		return dPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DSignature createDefaultDSignature() {
		DSignatureImpl dSignature = new DSignatureImpl();
		dSignature.setSignature(CoreFactory.eINSTANCE.createSignature());
		return dSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * Default Value for DSpecification
	 * @generated NOT
	 */
	public DSpecification createDefaultDSpecification() {
		DSpecificationImpl dSpecification = new DSpecificationImpl();
		dSpecification.setSpecification(CoreFactory.eINSTANCE.createDefaultSpecification());
		dSpecification.setDSignature(DPFConstants.DEFAULT_DSIGNATURE);
		dSpecification.setDType(DPFConstants.REFLEXIVE_DSPECIFICATION);
		dSpecification.setDGraph(DiagramFactory.eINSTANCE.createDefaultDGraph());
		dSpecification.setZoom(1.0);
		dSpecification.setGridVisible(false);
		dSpecification.setGrid(true);
		return dSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DElement createDElement() {
		DElementImpl dElement = new DElementImpl();
		return dElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DGenericArrowConstraint createDGenericArrowConstraint() {
		DGenericArrowConstraintImpl dGenericArrowConstraint = new DGenericArrowConstraintImpl();
		return dGenericArrowConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DGraph createDGraph() {
		DGraphImpl dGraph = new DGraphImpl();
		dGraph.setDType(DPFConstants.REFLEXIVE_TYPE_DGRAPH);
		return dGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DNode createDNode() {
		DNodeImpl dNode = new DNodeImpl();
		dNode.setDType(DPFConstants.REFLEXIVE_TYPE_DNODE);
		return dNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DConstraintNode createDConstraintNode() {
		DConstraintNodeImpl dConstraintNode = new DConstraintNodeImpl();
		return dConstraintNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DNode createDNode(Node node, DNode type) {
		DNode dNode = new DNodeImpl();
		dNode.setNode(node);
		dNode.setDType(type);
		return dNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DNode createDNode(String name, DNode type) {
		if(type == null)
			type = DPFConstants.REFLEXIVE_TYPE_DNODE;
		return createDNode(CoreFactory.eINSTANCE.createNode(name, type.getNode()), type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DOffset createDOffset() {
		DOffsetImpl dOffset = new DOffsetImpl();
		dOffset.setOffset(DOffset.DEFAULT);
		return dOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DPredicate createDPredicate() {
		DPredicateImpl dPredicate = new DPredicateImpl();
		return dPredicate;
	}

	/*
	 * Three different create method
	 * createX() method is automatic generated. Used when model is loaded. Do not change the code here.
	 * createDefaultX() method is default one. Used when you want to create a new instance.
	 * createConstantX() method is constants creation method. Those methods are only used in DPFConstants.
	 * xwa@hib.no
	 */

	private DPredicate createDPredicate(Predicate predicate, String icon){
		DPredicate dPredicate = createDefaultDPredicate();
		dPredicate.setPredicate(predicate);
		dPredicate.getDGraph().setGraph(predicate.getShape());
		dPredicate.setIcon(icon);
		return dPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSignature createDSignature() {
		DSignatureImpl dSignature = new DSignatureImpl();
		return dSignature;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DSpecification createDSpecification() {
		DSpecificationImpl dSpecification = new DSpecificationImpl();
		dSpecification.setDType(DPFConstants.REFLEXIVE_DSPECIFICATION);
		dSpecification.setDSignature(DPFConstants.DEFAULT_DSIGNATURE);
		return dSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Dimension createEDimensionFromString(EDataType eDataType, String initialValue) {
		String[] result = initialValue.split(" ");
		Assert.isTrue(result.length == 2);
		return new Dimension(Integer.valueOf(result[0]).intValue(), Integer.valueOf(result[1]).intValue());
		//		return (Dimension)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Point createELocationFromString(EDataType eDataType, String initialValue) {
		String[] result = initialValue.split(" ");
		Assert.isTrue(result.length == 2);
		return new Point(Integer.valueOf(result[0]).intValue(), Integer.valueOf(result[1]).intValue());
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case DiagramPackage.VISUALIZATION_TYPE:
			return createVisualizationTypeFromString(eDataType, initialValue);
		case DiagramPackage.EDIMENSION:
			return createEDimensionFromString(eDataType, initialValue);
		case DiagramPackage.ELOCATION:
			return createELocationFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Visualization createVisualization() {
		VisualizationImpl visualization = new VisualizationImpl();
		visualization.setType(VisualizationType.ARROW_LABEL);
		return visualization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationType createVisualizationTypeFromString(EDataType eDataType, String initialValue) {
		VisualizationType result = VisualizationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramPackage getDiagramPackage() {
		return (DiagramPackage)getEPackage();
	}

	@Override
	public DOffset createDOffset(DOffset nameOffset) {
		DOffsetImpl dOffset = new DOffsetImpl(nameOffset.getOffset().getCopy(), nameOffset.getLen());
		dOffset.setIndex(nameOffset.getIndex());
		return dOffset;
	}
} //DiagramFactoryImpl
