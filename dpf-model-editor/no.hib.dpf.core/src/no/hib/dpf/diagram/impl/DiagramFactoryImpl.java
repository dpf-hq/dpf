/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DBound;
import no.hib.dpf.diagram.DConstraint;
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
import no.hib.dpf.utils.DPFConstants;

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
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramFactory init() {
		try {
			DiagramFactory theDiagramFactory = (DiagramFactory)EPackage.Registry.INSTANCE.getEFactory("http://no.hib.dpf.diagram"); 
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
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiagramPackage.DSPECIFICATION: return createDSpecification();
			case DiagramPackage.DGRAPH: return createDGraph();
			case DiagramPackage.DNODE: return createDNode();
			case DiagramPackage.DARROW: return createDArrow();
			case DiagramPackage.DCONSTRAINT: return createDConstraint();
			case DiagramPackage.DPREDICATE: return createDPredicate();
			case DiagramPackage.DBOUND: return createDBound();
			case DiagramPackage.DOFFSET: return createDOffset();
			case DiagramPackage.DSIGNATURE: return createDSignature();
			case DiagramPackage.VISUALIZATION: return createVisualization();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	 * Default Value for DSpecification
	 * @generated NOT
	 */
	public DSpecification createDSpecification() {
		DSpecificationImpl dSpecification = new DSpecificationImpl();
		dSpecification.setSpecification(CoreFactory.eINSTANCE.createSpecification());
		dSpecification.setDGraph(DiagramFactory.eINSTANCE.createDGraph());
		dSpecification.setDType(DPFConstants.REFLEXIVE_DSPECIFICATION);
		dSpecification.setZoom(1.0);
		dSpecification.setGridVisible(false);
		dSpecification.setGrid(true);
		return dSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * Default Value for DGraph
	 * Graph : a new Graph
	 * DType : DGraph.REFLEXIVE_TYPE_DGRAPH
	 * @generated NOT
	 */
	public DGraph createDGraph() {
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
	public DNode createDNode() {
		DNodeImpl dNode = new DNodeImpl();
		dNode.setNode(CoreFactory.eINSTANCE.createNode());
		dNode.setDType(DPFConstants.REFLEXIVE_TYPE_DNODE);
		dNode.setDGraph(null);
		dNode.setLocation(null);
		dNode.setSize(DNode.DEFAULT_DIMENSION);
		dNode.setConfigureString(null);
		return dNode;
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
	public DArrow createDArrow() {
		DArrowImpl dArrow = new DArrowImpl();
		dArrow.setArrow(CoreFactory.eINSTANCE.createArrow());
		dArrow.setDType(DPFConstants.REFLEXIVE_TYPE_DARROW);
		dArrow.setDSource(DPFConstants.REFLEXIVE_TYPE_DNODE);
		dArrow.setDGraph(null);
		dArrow.setNameOffset(DiagramFactory.eINSTANCE.createDOffset());
		dArrow.setConfigureString(null);
		return dArrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DConstraint createDConstraint() {
		DConstraintImpl dConstraint = new DConstraintImpl();
		dConstraint.setConstraint(CoreFactory.eINSTANCE.createConstraint());
		return dConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DPredicate createDPredicate() {
		DPredicateImpl dPredicate = new DPredicateImpl();
		dPredicate.setPredicate(CoreFactory.eINSTANCE.createPredicate());
		dPredicate.setDGraph(createDGraph());
		dPredicate.getPredicate().setShape(dPredicate.getDGraph().getGraph());
		dPredicate.setVisualization(createVisualization());
		return dPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBound createDBound() {
		DBoundImpl dBound = new DBoundImpl();
		return dBound;
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
	 * @generated NOT
	 */
	public DSignature createDSignature() {
		DSignatureImpl dSignature = new DSignatureImpl();
		dSignature.setSignature(CoreFactory.eINSTANCE.createSignature());
		return dSignature;
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
	public String convertVisualizationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public String convertEDimensionToString(EDataType eDataType, Object instanceValue) {
		Dimension point = (Dimension) instanceValue;
		return point.width + " " + point.height;
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
	public DiagramPackage getDiagramPackage() {
		return (DiagramPackage)getEPackage();
	}

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

	/**
	 * @generated NOT
	 */
	@Override
	public DNode createDefaultDNode() {
		DNode dnode = new DNodeImpl();
		dnode.setNode(DPFConstants.REFLEXIVE_TYPE_NODE);
		return dnode;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DArrow createDefaultDArrow() {
		DArrow darrow = new DArrowImpl();
		darrow.setArrow(DPFConstants.REFLEXIVE_TYPE_ARROW);
		darrow.setDSource(DPFConstants.REFLEXIVE_TYPE_DNODE);
		darrow.setDTarget(DPFConstants.REFLEXIVE_TYPE_DNODE);
		return darrow;
	}
	/**
	 * @generated NOT
	 */
	@Override
	public DGraph createDefaultDGraph() {
		DGraph dGraph = new DGraphImpl();
		dGraph.setGraph(DPFConstants.REFLEXIVE_TYPE_GRAPH);
		DPFConstants.REFLEXIVE_TYPE_DNODE.setDGraph(dGraph);
		DPFConstants.REFLEXIVE_TYPE_DARROW.setDGraph(dGraph);
		return dGraph;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public DSpecification createDefaultDSpecification() {
		DSpecificationImpl result = new DSpecificationImpl();
		result.setSpecification(DPFConstants.REFLEXIVE_SPECIFICATION);
		result.setDGraph(DPFConstants.REFLEXIVE_TYPE_DGRAPH);
		return result;
	}
} //DiagramFactoryImpl
