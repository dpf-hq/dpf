/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import no.hib.dpf.core.CorePackage;

import no.hib.dpf.core.impl.CorePackageImpl;

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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramPackageImpl extends EPackageImpl implements DiagramPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dArrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dOffsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visualizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visualizationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eDimensionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eLocationEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see no.hib.dpf.diagram.DiagramPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiagramPackageImpl() {
		super(eNS_URI, DiagramFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DiagramPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DiagramPackage init() {
		if (isInited) return (DiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI);

		// Obtain or create and register package
		DiagramPackageImpl theDiagramPackage = (DiagramPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DiagramPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DiagramPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);

		// Create package meta-data objects
		theDiagramPackage.createPackageContents();
		theCorePackage.createPackageContents();

		// Initialize created meta-data
		theDiagramPackage.initializePackageContents();
		theCorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiagramPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiagramPackage.eNS_URI, theDiagramPackage);
		return theDiagramPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDSpecification() {
		return dSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSpecification_DType() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSpecification_DGraph() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSpecification_DConstraints() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSpecification_Specification() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDSpecification_Grid() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDSpecification_Snap() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDSpecification_Zoom() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDSpecification_GridVisible() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSpecification_DSignature() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDSpecification_MetaFile() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDSpecification_SignatureFile() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDGraph() {
		return dGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDGraph_DType() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDGraph_DNodes() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDGraph_DArrows() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDGraph_Graph() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDNode() {
		return dNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNode_DType() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNode_Node() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDNode_ConfigureString() {
		return (EAttribute)dNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNode_DOutgoings() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNode_DIncomings() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNode_DConstraints() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDArrow() {
		return dArrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_DType() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_Arrow() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDArrow_ConfigureString() {
		return (EAttribute)dArrowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDArrow_LineStyle() {
		return (EAttribute)dArrowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_DSource() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_DTarget() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_DConstraints() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDArrow_Bendpoints() {
		return (EAttribute)dArrowEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_NameOffset() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_ConstraintOffset() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_ConstraintsFrom() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrow_ConstraintsTo() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDConstraint() {
		return dConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_Constraint() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_DNodes() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_DArrows() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_Offset() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_Source() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_Target() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_DPredicate() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDPredicate() {
		return dPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDPredicate_Predicate() {
		return (EReference)dPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDPredicate_SimpleName() {
		return (EAttribute)dPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDPredicate_DGraph() {
		return (EReference)dPredicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDPredicate_Visualization() {
		return (EReference)dPredicateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDPredicate_Icon() {
		return (EAttribute)dPredicateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDBound() {
		return dBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDBound_Location() {
		return (EAttribute)dBoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDBound_Size() {
		return (EAttribute)dBoundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDOffset() {
		return dOffsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDOffset_Offset() {
		return (EAttribute)dOffsetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDSignature() {
		return dSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSignature_Signature() {
		return (EReference)dSignatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSignature_DPredicates() {
		return (EReference)dSignatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisualization() {
		return visualizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVisualization_Type() {
		return (EAttribute)visualizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualization_Source() {
		return (EReference)visualizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVisualization_Target() {
		return (EReference)visualizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisualizationType() {
		return visualizationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEDimension() {
		return eDimensionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getELocation() {
		return eLocationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramFactory getDiagramFactory() {
		return (DiagramFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		dSpecificationEClass = createEClass(DSPECIFICATION);
		createEReference(dSpecificationEClass, DSPECIFICATION__DTYPE);
		createEReference(dSpecificationEClass, DSPECIFICATION__DGRAPH);
		createEReference(dSpecificationEClass, DSPECIFICATION__DCONSTRAINTS);
		createEReference(dSpecificationEClass, DSPECIFICATION__SPECIFICATION);
		createEAttribute(dSpecificationEClass, DSPECIFICATION__GRID);
		createEAttribute(dSpecificationEClass, DSPECIFICATION__SNAP);
		createEAttribute(dSpecificationEClass, DSPECIFICATION__ZOOM);
		createEAttribute(dSpecificationEClass, DSPECIFICATION__GRID_VISIBLE);
		createEReference(dSpecificationEClass, DSPECIFICATION__DSIGNATURE);
		createEAttribute(dSpecificationEClass, DSPECIFICATION__META_FILE);
		createEAttribute(dSpecificationEClass, DSPECIFICATION__SIGNATURE_FILE);

		dGraphEClass = createEClass(DGRAPH);
		createEReference(dGraphEClass, DGRAPH__DTYPE);
		createEReference(dGraphEClass, DGRAPH__DNODES);
		createEReference(dGraphEClass, DGRAPH__DARROWS);
		createEReference(dGraphEClass, DGRAPH__GRAPH);

		dNodeEClass = createEClass(DNODE);
		createEReference(dNodeEClass, DNODE__DTYPE);
		createEReference(dNodeEClass, DNODE__NODE);
		createEAttribute(dNodeEClass, DNODE__CONFIGURE_STRING);
		createEReference(dNodeEClass, DNODE__DOUTGOINGS);
		createEReference(dNodeEClass, DNODE__DINCOMINGS);
		createEReference(dNodeEClass, DNODE__DCONSTRAINTS);

		dArrowEClass = createEClass(DARROW);
		createEReference(dArrowEClass, DARROW__DTYPE);
		createEReference(dArrowEClass, DARROW__ARROW);
		createEAttribute(dArrowEClass, DARROW__CONFIGURE_STRING);
		createEAttribute(dArrowEClass, DARROW__LINE_STYLE);
		createEReference(dArrowEClass, DARROW__DSOURCE);
		createEReference(dArrowEClass, DARROW__DTARGET);
		createEReference(dArrowEClass, DARROW__DCONSTRAINTS);
		createEAttribute(dArrowEClass, DARROW__BENDPOINTS);
		createEReference(dArrowEClass, DARROW__NAME_OFFSET);
		createEReference(dArrowEClass, DARROW__CONSTRAINT_OFFSET);
		createEReference(dArrowEClass, DARROW__CONSTRAINTS_FROM);
		createEReference(dArrowEClass, DARROW__CONSTRAINTS_TO);

		dConstraintEClass = createEClass(DCONSTRAINT);
		createEReference(dConstraintEClass, DCONSTRAINT__CONSTRAINT);
		createEReference(dConstraintEClass, DCONSTRAINT__DNODES);
		createEReference(dConstraintEClass, DCONSTRAINT__DARROWS);
		createEReference(dConstraintEClass, DCONSTRAINT__OFFSET);
		createEReference(dConstraintEClass, DCONSTRAINT__SOURCE);
		createEReference(dConstraintEClass, DCONSTRAINT__TARGET);
		createEReference(dConstraintEClass, DCONSTRAINT__DPREDICATE);

		dPredicateEClass = createEClass(DPREDICATE);
		createEReference(dPredicateEClass, DPREDICATE__PREDICATE);
		createEAttribute(dPredicateEClass, DPREDICATE__SIMPLE_NAME);
		createEReference(dPredicateEClass, DPREDICATE__DGRAPH);
		createEReference(dPredicateEClass, DPREDICATE__VISUALIZATION);
		createEAttribute(dPredicateEClass, DPREDICATE__ICON);

		dBoundEClass = createEClass(DBOUND);
		createEAttribute(dBoundEClass, DBOUND__LOCATION);
		createEAttribute(dBoundEClass, DBOUND__SIZE);

		dOffsetEClass = createEClass(DOFFSET);
		createEAttribute(dOffsetEClass, DOFFSET__OFFSET);

		dSignatureEClass = createEClass(DSIGNATURE);
		createEReference(dSignatureEClass, DSIGNATURE__SIGNATURE);
		createEReference(dSignatureEClass, DSIGNATURE__DPREDICATES);

		visualizationEClass = createEClass(VISUALIZATION);
		createEAttribute(visualizationEClass, VISUALIZATION__TYPE);
		createEReference(visualizationEClass, VISUALIZATION__SOURCE);
		createEReference(visualizationEClass, VISUALIZATION__TARGET);

		// Create enums
		visualizationTypeEEnum = createEEnum(VISUALIZATION_TYPE);

		// Create data types
		eDimensionEDataType = createEDataType(EDIMENSION);
		eLocationEDataType = createEDataType(ELOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dNodeEClass.getESuperTypes().add(this.getDBound());

		// Initialize classes and features; add operations and parameters
		initEClass(dSpecificationEClass, DSpecification.class, "DSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDSpecification_DType(), this.getDSpecification(), null, "dType", null, 0, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDSpecification_DGraph(), this.getDGraph(), null, "dGraph", null, 0, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDSpecification_DConstraints(), this.getDConstraint(), null, "dConstraints", null, 0, -1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDSpecification_Specification(), theCorePackage.getSpecification(), null, "specification", null, 1, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDSpecification_Grid(), ecorePackage.getEBoolean(), "grid", "true", 1, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDSpecification_Snap(), ecorePackage.getEBoolean(), "snap", "true", 1, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDSpecification_Zoom(), ecorePackage.getEDouble(), "zoom", "1.0", 1, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDSpecification_GridVisible(), ecorePackage.getEBoolean(), "gridVisible", "true", 1, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDSpecification_DSignature(), this.getDSignature(), null, "dSignature", null, 0, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDSpecification_MetaFile(), ecorePackage.getEString(), "metaFile", null, 0, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDSpecification_SignatureFile(), ecorePackage.getEString(), "signatureFile", null, 0, 1, DSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(dSpecificationEClass, this.getDGraph(), "createDGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCorePackage.getGraph(), "graph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDGraph(), "dType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dSpecificationEClass, this.getDConstraint(), "createDConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCorePackage.getConstraint(), "constraint", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dGraphEClass, DGraph.class, "DGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDGraph_DType(), this.getDGraph(), null, "dType", null, 1, 1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_DNodes(), this.getDNode(), null, "dNodes", null, 0, -1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_DArrows(), this.getDArrow(), null, "dArrows", null, 0, -1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_Graph(), theCorePackage.getGraph(), null, "graph", null, 1, 1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dGraphEClass, this.getDNode(), "getDNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCorePackage.getNode(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dGraphEClass, this.getDArrow(), "getDArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCorePackage.getArrow(), "arrow", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dGraphEClass, this.getDNode(), "createDNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "dType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dGraphEClass, this.getDArrow(), "createDArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "dSource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "dTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDArrow(), "dType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dNodeEClass, DNode.class, "DNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDNode_DType(), this.getDNode(), null, "dType", null, 1, 1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_Node(), theCorePackage.getNode(), null, "node", null, 1, 1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDNode_ConfigureString(), ecorePackage.getEString(), "configureString", null, 0, 1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_DOutgoings(), this.getDArrow(), this.getDArrow_DSource(), "dOutgoings", null, 0, -1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_DIncomings(), this.getDArrow(), this.getDArrow_DTarget(), "dIncomings", null, 0, -1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_DConstraints(), this.getDConstraint(), this.getDConstraint_DNodes(), "dConstraints", null, 0, -1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(dNodeEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dNodeEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dArrowEClass, DArrow.class, "DArrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDArrow_DType(), this.getDArrow(), null, "dType", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_Arrow(), theCorePackage.getArrow(), null, "arrow", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDArrow_ConfigureString(), ecorePackage.getEString(), "configureString", null, 0, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDArrow_LineStyle(), ecorePackage.getEInt(), "lineStyle", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_DSource(), this.getDNode(), this.getDNode_DOutgoings(), "dSource", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_DTarget(), this.getDNode(), this.getDNode_DIncomings(), "dTarget", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_DConstraints(), this.getDConstraint(), this.getDConstraint_DArrows(), "dConstraints", null, 0, -1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDArrow_Bendpoints(), this.getELocation(), "bendpoints", null, 0, -1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_NameOffset(), this.getDOffset(), null, "nameOffset", null, 0, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_ConstraintOffset(), this.getDOffset(), null, "constraintOffset", null, 0, -1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_ConstraintsFrom(), this.getDConstraint(), this.getDConstraint_Source(), "constraintsFrom", null, 0, -1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_ConstraintsTo(), this.getDConstraint(), this.getDConstraint_Target(), "constraintsTo", null, 0, -1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dArrowEClass, null, "reconnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowEClass, null, "disconnect", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dConstraintEClass, DConstraint.class, "DConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDConstraint_Constraint(), theCorePackage.getConstraint(), null, "constraint", null, 0, 1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_DNodes(), this.getDNode(), this.getDNode_DConstraints(), "dNodes", null, 0, -1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_DArrows(), this.getDArrow(), this.getDArrow_DConstraints(), "dArrows", null, 0, -1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_Offset(), this.getDOffset(), null, "offset", null, 0, 1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_Source(), this.getDArrow(), this.getDArrow_ConstraintsFrom(), "source", null, 0, 1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_Target(), this.getDArrow(), this.getDArrow_ConstraintsTo(), "target", null, 0, 1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_DPredicate(), this.getDPredicate(), null, "dPredicate", null, 0, 1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dConstraintEClass, null, "reconnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDArrow(), "arrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDSpecification(), "specification", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dConstraintEClass, null, "disconnect", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dConstraintEClass, null, "addDArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDArrow(), "dArrow", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dConstraintEClass, null, "addDNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "dNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dPredicateEClass, DPredicate.class, "DPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDPredicate_Predicate(), theCorePackage.getPredicate(), null, "predicate", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDPredicate_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDPredicate_DGraph(), this.getDGraph(), null, "dGraph", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDPredicate_Visualization(), this.getVisualization(), null, "visualization", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDPredicate_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dBoundEClass, DBound.class, "DBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDBound_Location(), this.getELocation(), "location", null, 0, 1, DBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDBound_Size(), this.getEDimension(), "size", null, 0, 1, DBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dOffsetEClass, DOffset.class, "DOffset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDOffset_Offset(), this.getELocation(), "offset", null, 0, 1, DOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dSignatureEClass, DSignature.class, "DSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDSignature_Signature(), theCorePackage.getSignature(), null, "signature", null, 0, 1, DSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDSignature_DPredicates(), this.getDPredicate(), null, "dPredicates", null, 0, -1, DSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dSignatureEClass, null, "addDPredicate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDPredicate(), "dPredicate", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dSignatureEClass, null, "removeDPredicate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDPredicate(), "dPredicate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(visualizationEClass, Visualization.class, "Visualization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVisualization_Type(), this.getVisualizationType(), "type", null, 0, 1, Visualization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualization_Source(), theCorePackage.getIDObject(), null, "source", null, 0, 1, Visualization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVisualization_Target(), theCorePackage.getIDObject(), null, "target", null, 0, 1, Visualization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(visualizationTypeEEnum, VisualizationType.class, "VisualizationType");
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_LABEL);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.NODE_TO_NODE);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.NODE_TO_ARROW);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_TO_NODE);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_TO_ARROW);

		// Initialize data types
		initEDataType(eDimensionEDataType, Dimension.class, "EDimension", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eLocationEDataType, Point.class, "ELocation", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DiagramPackageImpl
