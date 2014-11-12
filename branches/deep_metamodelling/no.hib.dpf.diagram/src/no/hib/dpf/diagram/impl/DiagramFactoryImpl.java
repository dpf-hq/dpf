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
import no.hib.dpf.diagram.*;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DComposedConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.diagram.Visualization;
import no.hib.dpf.diagram.VisualizationType;
import no.hib.dpf.diagram.util.DPFDiagramConstants;
import no.hib.dpf.utils.DPFCoreConstants;

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
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class DiagramFactoryImpl extends EFactoryImpl implements DiagramFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagramPackage getPackage() {
		return DiagramPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertEDimensionToString(EDataType eDataType,
			Object instanceValue) {
		Dimension point = (Dimension) instanceValue;
		return point.width + " " + point.height;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertELocationToString(EDataType eDataType,
			Object instanceValue) {
		Point point = (Point) instanceValue;
		return point.x + " " + point.y;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisualizationTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiagramPackage.DSPECIFICATION: return createDSpecification();
			case DiagramPackage.DGRAPH: return createDGraph();
			case DiagramPackage.DNODE: return createDNode();
			case DiagramPackage.DDATA_NODE: return createDDataNode();
			case DiagramPackage.DCONSTRAINT_NODE: return createDConstraintNode();
			case DiagramPackage.DARROW: return createDArrow();
			case DiagramPackage.DNODE_DATTRIBUTE: return createDNodeDAttribute();
			case DiagramPackage.DARROW_DATTRIBUTE: return createDArrowDAttribute();
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

	private DPredicate createArrowLabelDPredicate(Predicate predicate,
			String icon) {
		if (predicate == null)
			return null;
		DPredicate result = createDPredicate(predicate, icon);
		Visualization visualization = result.getVisualization();
		visualization.setType(VisualizationType.ARROW_LABEL);
		Graph graph = result.getPredicate().getShape();
		visualization.setSource(graph.getArrowByName("XY"));
		return result;
	}

	private DPredicate createArrowToArrowDPredicate(Predicate predicate,
			String icon, String source, String target) {
		if (predicate == null)
			return null;
		DPredicate result = createDPredicate(predicate, icon);
		Visualization visualization = result.getVisualization();
		visualization.setType(VisualizationType.ARROW_TO_ARROW);
		Graph graph = result.getPredicate().getShape();
		visualization.setSource(graph.getArrowByName(source));
		visualization.setTarget(graph.getArrowByName(target));
		return result;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DArrow createConstantDArrow() {
		DArrow darrow = new DArrowImpl();
		darrow.setArrow(no.hib.dpf.utils.DPFCoreConstants.REFLEXIVE_TYPE_ARROW);
		darrow.setDSource(DPFDiagramConstants.REFLEXIVE_TYPE_DNODE);
		darrow.setDTarget(DPFDiagramConstants.REFLEXIVE_TYPE_DNODE);
		return darrow;
	}
	
	

	@Override
	public DNodeDAttribute createConstantDNodeDAttribute() {
		DNodeDAttribute dnodedattribute = new DNodeDAttributeImpl();
		dnodedattribute.setNodeAttribute(DPFCoreConstants.REFLEXIVE_TYPE_NODE_ATTRIBUTE);
		dnodedattribute.setDSource(DPFDiagramConstants.REFLEXIVE_TYPE_DNODE);
		dnodedattribute.setDTarget(DPFDiagramConstants.REFLEXIVE_TYPE_DDATANODE);
		return dnodedattribute;
	}

	@Override
	public DArrowDAttribute createConstantDArrowDAttribute() {
		DArrowDAttribute darrowdattribute = new DArrowDAttributeImpl();
		darrowdattribute.setArrowAttribute(DPFCoreConstants.REFLEXIVE_TYPE_ARROW_ATTRIBUTE);
		darrowdattribute.setDSource(DPFDiagramConstants.REFLEXIVE_TYPE_DARROW);
		darrowdattribute.setDTarget(DPFDiagramConstants.REFLEXIVE_TYPE_DDATANODE);
		return darrowdattribute;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public DNode createConstantDNode() {
		DNode dnode = new DNodeImpl();
		dnode.setNode(no.hib.dpf.utils.DPFCoreConstants.REFLEXIVE_TYPE_NODE);
		return dnode;
	}
	
	@Override
	public DDataNode createConstantDDataNode() {
		DDataNode dDataNode = new DDataNodeImpl();  
		dDataNode.setDatanode(DPFCoreConstants.REFLEXIVE_TYPE_DATANODE);
		return dDataNode;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DGraph createConstantDGraph() {
		DGraph dGraph = new DGraphImpl();
		dGraph.setGraph(no.hib.dpf.utils.DPFCoreConstants.REFLEXIVE_TYPE_GRAPH);
		dGraph.addDNode(DPFDiagramConstants.REFLEXIVE_TYPE_DNODE);
		dGraph.addDArrow(DPFDiagramConstants.REFLEXIVE_TYPE_DARROW);
		dGraph.addDDataNode(DPFDiagramConstants.REFLEXIVE_TYPE_DDATANODE);
		dGraph.addDNodeDAttribute(DPFDiagramConstants.REFLEXIVE_TYPE_DNODE_DATTRIBUTE);
		dGraph.addDArrowDAttribute(DPFDiagramConstants.REFLEXIVE_TYPE_DARROW_DATTRIBUTE);
		return dGraph;
	}



	@Override
	public DSignature createConstantDSignature() {
		DSignatureImpl result = new DSignatureImpl();
		result.setSignature(no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE);
		result.addDPredicate(createArrowLabelDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("inj"),
				"/icons/inj_36.png"));
		result.addDPredicate(createArrowLabelDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("surj"),
				"/icons/surj_36.png"));
		result.addDPredicate(createArrowLabelDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("irref"),
				"/icons/irr_36.png"));
		result.addDPredicate(createArrowLabelDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("multi"),
				"/icons/mult_36.png"));
		result.addDPredicate(createArrowToArrowDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("inv"),
				"/icons/inv_36.png", "XY", "YX"));
		result.addDPredicate(createArrowToArrowDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("js"),
				"/icons/js_36.png", "XZ", "YZ"));
		result.addDPredicate(createArrowToArrowDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("ji"),
				"/icons/ji_36.png", "XY", "XZ"));
		result.addDPredicate(createArrowToArrowDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("xor"),
				"/icons/xor_36.png", "ZX", "ZY"));
		result.addDPredicate(createArrowToArrowDPredicate(
				no.hib.dpf.utils.DPFCoreConstants.DEFAULT_SIGNATURE.getPredicateBySymbol("nand"),
				"/icons/nand_36.png", "ZX", "ZY"));
		return result;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DSpecification createConstantDSpecification() {
		DSpecificationImpl result = new DSpecificationImpl();
		result.setSpecification(no.hib.dpf.utils.DPFCoreConstants.REFLEXIVE_SPECIFICATION);
		result.setDSignature(DPFDiagramConstants.DEFAULT_DSIGNATURE);
		result.setDGraph(DPFDiagramConstants.REFLEXIVE_TYPE_DGRAPH);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DArrow createDArrow() {
		DArrowImpl dArrow = new DArrowImpl();
		dArrow.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DARROW);
		return dArrow;
	}

	/**
	 * @generated NOT
	 */
	public DArrow createDArrow(Arrow arrow, DNode source, DNode target,
			DArrow type) {
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
	public DArrow createDArrow(String name, DNode source, DNode target,
			DArrow type) {
		if (type == null)
			type = DPFDiagramConstants.REFLEXIVE_TYPE_DARROW;
		return createDArrow(CoreFactory.eINSTANCE.createArrow(name,
				source.getNode(), target.getNode(), type.getArrow()), source,
				target, type);
	}

	@Override
	public DArrowLabelConstraint createDArrowLabelConstraint() {
		DArrowLabelConstraintImpl dArrowLabelConstraint = new DArrowLabelConstraintImpl();
		return dArrowLabelConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DComposedConstraint createDComposedConstraint() {
		DComposedConstraintImpl dComposedConstraint = new DComposedConstraintImpl();
		return dComposedConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DConstraint createDConstraint() {
		DConstraintImpl dConstraint = new DConstraintImpl();
		return dConstraint;
	}


	
	/**
	 * @generated NOT
	 */
	@Override
	public DNodeDAttribute createDefaultDNodeDAttribute() {
		DNodeDAttribute dAttribute = new DNodeDAttributeImpl();
		dAttribute.setNodeAttribute(CoreFactory.eINSTANCE.createNodeAttribute());
		dAttribute.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DNODE_DATTRIBUTE);
		dAttribute.setNameOffset(DiagramFactory.eINSTANCE.createDefaultDOffset());
		return dAttribute;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> Default Value for DArrow
	 * Arrow : a new Arrow not Arrow.REFLEXIVE_TYPE_ARROW DType :
	 * DArrow.REFLEXIVE_TYPE_DARROW DSource : null DTarget : null DGraph : null
	 * Location : (0,0) Size : (0, 0) Configure : null
	 * 
	 * @generated NOT
	 */
	@Override
	public DArrow createDefaultDArrow() {
		DArrowImpl dArrow = new DArrowImpl();
		dArrow.setArrow(CoreFactory.eINSTANCE.createArrow());
		dArrow.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DARROW);
		dArrow.setNameOffset(DiagramFactory.eINSTANCE.createDefaultDOffset());
		return dArrow;
	}
	
	/**
	 * @generated NOT
	 */
	@Override 
	public DArrowDAttribute createDefaultDArrowDAttribute() {
		DArrowDAttribute dAttribute = new DArrowDAttributeImpl();
		dAttribute.setArrowAttribute(CoreFactory.eINSTANCE.createArrowAttribute());
		dAttribute.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DARROW_DATTRIBUTE);
		dAttribute.setNameOffset(DiagramFactory.eINSTANCE.createDefaultDOffset());
		return dAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DConstraint createDefaultDConstraint() {
		DConstraintImpl dConstraint = new DConstraintImpl();
		dConstraint.setConstraint(CoreFactory.eINSTANCE.createConstraint());
		return dConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> Default Value for DGraph
	 * Graph : a new Graph DType : DGraph.REFLEXIVE_TYPE_DGRAPH
	 * 
	 * @generated NOT
	 */
	@Override
	public DGraph createDefaultDGraph() {
		DGraphImpl dGraph = new DGraphImpl();
		dGraph.setGraph(CoreFactory.eINSTANCE.createGraph());
		dGraph.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DGRAPH);
		return dGraph;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> Default Value for DNode
	 * Node : a new Node not Node.REFLEXIVE_TYPE_NODE DType :
	 * DNode.REFLEXIVE_TYPE_DNODE DGraph : null Location : (0,0) Size : (0, 0)
	 * Configure : null
	 * 
	 * @generated NOT
	 */
	@Override
	public DNode createDefaultDNode() {
		DNodeImpl dNode = new DNodeImpl();
		dNode.setNode(CoreFactory.eINSTANCE.createNode());
		dNode.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DNODE);
		dNode.setSize(DNode.DEFAULT_DIMENSION);
		return dNode;
	}
	
	@Override
	public DDataNode createDefaultDDataNode() {
		DDataNodeImpl dNode = new DDataNodeImpl();
		dNode.setDatanode(CoreFactory.eINSTANCE.createDataNode());
		dNode.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DDATANODE);
		dNode.setSize(DDataNode.DEFAULT_DIMENSION);
		return dNode;
	}

	@Override
	public DOffset createDefaultDOffset() {
		// Adjust the initial position of the arrow label
		return new DOffsetImpl(new Point(10, -3), 16);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DPredicate createDefaultDPredicate() {
		DPredicateImpl dPredicate = new DPredicateImpl();
		dPredicate.setPredicate(CoreFactory.eINSTANCE.createDefaultPredicate());
		dPredicate.setDGraph(createDefaultDGraph());
		dPredicate.setVisualization(createVisualization());
		return dPredicate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DSignature createDefaultDSignature() {
		DSignatureImpl dSignature = new DSignatureImpl();
		dSignature.setSignature(CoreFactory.eINSTANCE.createSignature());
		return dSignature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> Default Value for
	 * DSpecification
	 * 
	 * @generated NOT
	 */
	@Override
	public DSpecification createDefaultDSpecification() {
		DSpecificationImpl dSpecification = new DSpecificationImpl();
		dSpecification.setSpecification(CoreFactory.eINSTANCE
				.createDefaultSpecification());
		dSpecification.setDType(DPFDiagramConstants.REFLEXIVE_DSPECIFICATION);
		dSpecification.setDGraph(DiagramFactory.eINSTANCE.createDefaultDGraph());
		dSpecification.setZoom(1.0);
		dSpecification.setGridVisible(false);
		dSpecification.setGrid(true);
		return dSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DElement createDElement() {
		DElementImpl dElement = new DElementImpl();
		return dElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DGenericArrowConstraint createDGenericArrowConstraint() {
		DGenericArrowConstraintImpl dGenericArrowConstraint = new DGenericArrowConstraintImpl();
		return dGenericArrowConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DGraph createDGraph() {
		DGraphImpl dGraph = new DGraphImpl();
		dGraph.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DGRAPH);
		return dGraph;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DNode createDNode() {
		DNodeImpl dNode = new DNodeImpl();
		dNode.setDType(DPFDiagramConstants.REFLEXIVE_TYPE_DNODE);
		return dNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DDataNode createDDataNode() {
		DDataNodeImpl dDataNode = new DDataNodeImpl();
		return dDataNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DConstraintNode createDConstraintNode() {
		DConstraintNodeImpl dConstraintNode = new DConstraintNodeImpl();
		return dConstraintNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public DNode createDNode(Node node, DNode type) {
		DNode dNode = new DNodeImpl();
		dNode.setNode(node);
		dNode.setDType(type);
		return dNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DNode createDNode(String name, DNode type) {
		if (type == null)
			type = DPFDiagramConstants.REFLEXIVE_TYPE_DNODE;
		return createDNode(CoreFactory.eINSTANCE.createNode(name, type.getNode()), type);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DOffset createDOffset() {
		DOffsetImpl dOffset = new DOffsetImpl();
		dOffset.setOffset(DOffset.DEFAULT);
		return dOffset;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DPredicate createDPredicate() {
		DPredicateImpl dPredicate = new DPredicateImpl();
		return dPredicate;
	}

	/*
	 * Three different create method createX() method is automatic generated.
	 * Used when model is loaded. Do not change the code here. createDefaultX()
	 * method is default one. Used when you want to create a new instance.
	 * createConstantX() method is constants creation method. Those methods are
	 * only used in DPFConstants. xwa@hib.no
	 */

	private DPredicate createDPredicate(Predicate predicate, String icon) {
		DPredicate dPredicate = createDefaultDPredicate();
		dPredicate.setPredicate(predicate);
		dPredicate.getDGraph().setGraph(predicate.getShape());
		dPredicate.setIcon(icon);
		return dPredicate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DSignature createDSignature() {
		DSignatureImpl dSignature = new DSignatureImpl();
		return dSignature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public DSpecification createDSpecification() {
		DSpecificationImpl dSpecification = new DSpecificationImpl();
		dSpecification.setDType(DPFDiagramConstants.REFLEXIVE_DSPECIFICATION);
		dSpecification.setDSignature(DPFDiagramConstants.DEFAULT_DSIGNATURE);
		return dSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Dimension createEDimensionFromString(EDataType eDataType,
			String initialValue) {
		String[] result = initialValue.split(" ");
		Assert.isTrue(result.length == 2);
		return new Dimension(Integer.valueOf(result[0]).intValue(), Integer
				.valueOf(result[1]).intValue());
		// return (Dimension)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Point createELocationFromString(EDataType eDataType,
			String initialValue) {
		String[] result = initialValue.split(" ");
		Assert.isTrue(result.length == 2);
		return new Point(Integer.valueOf(result[0]).intValue(), Integer
				.valueOf(result[1]).intValue());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Visualization createVisualization() {
		VisualizationImpl visualization = new VisualizationImpl();
		visualization.setType(VisualizationType.ARROW_LABEL);
		return visualization;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationType createVisualizationTypeFromString(
			EDataType eDataType, String initialValue) {
		VisualizationType result = VisualizationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagramPackage getDiagramPackage() {
		return (DiagramPackage)getEPackage();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DNodeDAttribute createDNodeDAttribute() {
		DNodeDAttributeImpl dNodeDAttribute = new DNodeDAttributeImpl();
		return dNodeDAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DArrowDAttribute createDArrowDAttribute() {
		DArrowDAttributeImpl dArrowDAttribute = new DArrowDAttributeImpl();
		return dArrowDAttribute;
	}

	
} // DiagramFactoryImpl
