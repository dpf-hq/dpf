/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.impl;

import no.hib.dpf.core.CorePackage;
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

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDiagramPackage.createPackageContents();

		// Initialize created meta-data
		theDiagramPackage.initializePackageContents();

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
	private EClass dArrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dArrowLabelConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dComposedConstraintEClass = null;

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
	private EClass dElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dNodeDAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dArrowDAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dGenericArrowConstraintEClass = null;

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
	private EClass dDataNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dConstraintNodeEClass = null;

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
	private EClass dPredicateEClass = null;

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
	private EClass dSpecificationEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

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
		createEReference(dGraphEClass, DGRAPH__DDATA_NODES);
		createEReference(dGraphEClass, DGRAPH__DARROW_DATTRIBUTES);
		createEReference(dGraphEClass, DGRAPH__DNODE_DATTRIBUTES);

		dNodeEClass = createEClass(DNODE);
		createEReference(dNodeEClass, DNODE__DTYPE);
		createEReference(dNodeEClass, DNODE__NODE);
		createEAttribute(dNodeEClass, DNODE__CONFIGURE_STRING);
		createEReference(dNodeEClass, DNODE__DOUTGOINGS);
		createEReference(dNodeEClass, DNODE__DINCOMINGS);
		createEReference(dNodeEClass, DNODE__DCONSTRAINTS);
		createEAttribute(dNodeEClass, DNODE__LOCATION);
		createEAttribute(dNodeEClass, DNODE__SIZE);
		createEReference(dNodeEClass, DNODE__DOUTGOING_ATTRIBUTES);

		dDataNodeEClass = createEClass(DDATA_NODE);
		createEReference(dDataNodeEClass, DDATA_NODE__DATANODE);
		createEAttribute(dDataNodeEClass, DDATA_NODE__CONFIGURE_STRING);
		createEAttribute(dDataNodeEClass, DDATA_NODE__LOCATION);
		createEAttribute(dDataNodeEClass, DDATA_NODE__SIZE);
		createEReference(dDataNodeEClass, DDATA_NODE__DINCOMING_DNODE_DATTRIBUTES);
		createEReference(dDataNodeEClass, DDATA_NODE__DINCOMING_DARROW_DATTRIBUTES);
		createEReference(dDataNodeEClass, DDATA_NODE__DTYPE);

		dConstraintNodeEClass = createEClass(DCONSTRAINT_NODE);
		createEReference(dConstraintNodeEClass, DCONSTRAINT_NODE__DCONSTRAINT);

		dArrowEClass = createEClass(DARROW);
		createEReference(dArrowEClass, DARROW__DTYPE);
		createEReference(dArrowEClass, DARROW__ARROW);
		createEAttribute(dArrowEClass, DARROW__CONFIGURE_STRING);
		createEAttribute(dArrowEClass, DARROW__LINE_STYLE);
		createEReference(dArrowEClass, DARROW__DSOURCE);
		createEReference(dArrowEClass, DARROW__DTARGET);
		createEReference(dArrowEClass, DARROW__DCONSTRAINTS);
		createEReference(dArrowEClass, DARROW__NAME_OFFSET);
		createEReference(dArrowEClass, DARROW__BENDPOINTS);
		createEReference(dArrowEClass, DARROW__DOUTGOING_ATTRIBUTES);

		dNodeDAttributeEClass = createEClass(DNODE_DATTRIBUTE);
		createEReference(dNodeDAttributeEClass, DNODE_DATTRIBUTE__DSOURCE);
		createEReference(dNodeDAttributeEClass, DNODE_DATTRIBUTE__NODE_ATTRIBUTE);
		createEReference(dNodeDAttributeEClass, DNODE_DATTRIBUTE__DTYPE);
		createEAttribute(dNodeDAttributeEClass, DNODE_DATTRIBUTE__CONFIGURE_STRING);
		createEAttribute(dNodeDAttributeEClass, DNODE_DATTRIBUTE__LINE_STYLE);
		createEReference(dNodeDAttributeEClass, DNODE_DATTRIBUTE__DTARGET);
		createEReference(dNodeDAttributeEClass, DNODE_DATTRIBUTE__DCONSTRAINTS);
		createEReference(dNodeDAttributeEClass, DNODE_DATTRIBUTE__NAME_OFFSET);
		createEReference(dNodeDAttributeEClass, DNODE_DATTRIBUTE__BENDPOINTS);

		dArrowDAttributeEClass = createEClass(DARROW_DATTRIBUTE);
		createEReference(dArrowDAttributeEClass, DARROW_DATTRIBUTE__DSOURCE);
		createEReference(dArrowDAttributeEClass, DARROW_DATTRIBUTE__ARROW_ATTRIBUTE);
		createEReference(dArrowDAttributeEClass, DARROW_DATTRIBUTE__DTYPE);
		createEReference(dArrowDAttributeEClass, DARROW_DATTRIBUTE__DTARGET);
		createEAttribute(dArrowDAttributeEClass, DARROW_DATTRIBUTE__CONFIGURE_STRING);
		createEAttribute(dArrowDAttributeEClass, DARROW_DATTRIBUTE__LINESTYLE);
		createEReference(dArrowDAttributeEClass, DARROW_DATTRIBUTE__DCONSTRAINTS);
		createEReference(dArrowDAttributeEClass, DARROW_DATTRIBUTE__NAME_OFFSET);
		createEReference(dArrowDAttributeEClass, DARROW_DATTRIBUTE__BENDPOINTS);

		dConstraintEClass = createEClass(DCONSTRAINT);
		createEReference(dConstraintEClass, DCONSTRAINT__CONSTRAINT);
		createEReference(dConstraintEClass, DCONSTRAINT__DNODES);
		createEReference(dConstraintEClass, DCONSTRAINT__DARROWS);
		createEReference(dConstraintEClass, DCONSTRAINT__DPREDICATE);
		createEReference(dConstraintEClass, DCONSTRAINT__DNODE_DATTRIBUTES);
		createEReference(dConstraintEClass, DCONSTRAINT__DARROW_DATTRIBUTES);

		dArrowLabelConstraintEClass = createEClass(DARROW_LABEL_CONSTRAINT);
		createEReference(dArrowLabelConstraintEClass, DARROW_LABEL_CONSTRAINT__OFFSET);
		createEReference(dArrowLabelConstraintEClass, DARROW_LABEL_CONSTRAINT__SOURCE);

		dGenericArrowConstraintEClass = createEClass(DGENERIC_ARROW_CONSTRAINT);
		createEReference(dGenericArrowConstraintEClass, DGENERIC_ARROW_CONSTRAINT__SOURCE);
		createEReference(dGenericArrowConstraintEClass, DGENERIC_ARROW_CONSTRAINT__TARGET);

		dComposedConstraintEClass = createEClass(DCOMPOSED_CONSTRAINT);
		createEReference(dComposedConstraintEClass, DCOMPOSED_CONSTRAINT__CHILDREN);
		createEReference(dComposedConstraintEClass, DCOMPOSED_CONSTRAINT__FAKE_NODE);

		dPredicateEClass = createEClass(DPREDICATE);
		createEReference(dPredicateEClass, DPREDICATE__PREDICATE);
		createEReference(dPredicateEClass, DPREDICATE__DGRAPH);
		createEReference(dPredicateEClass, DPREDICATE__VISUALIZATION);
		createEAttribute(dPredicateEClass, DPREDICATE__ICON);
		createEAttribute(dPredicateEClass, DPREDICATE__SIMPLE_NAME);

		dOffsetEClass = createEClass(DOFFSET);
		createEAttribute(dOffsetEClass, DOFFSET__OFFSET);
		createEAttribute(dOffsetEClass, DOFFSET__LEN);
		createEAttribute(dOffsetEClass, DOFFSET__INDEX);

		dSignatureEClass = createEClass(DSIGNATURE);
		createEReference(dSignatureEClass, DSIGNATURE__SIGNATURE);
		createEReference(dSignatureEClass, DSIGNATURE__DPREDICATES);

		visualizationEClass = createEClass(VISUALIZATION);
		createEAttribute(visualizationEClass, VISUALIZATION__TYPE);
		createEReference(visualizationEClass, VISUALIZATION__SOURCE);
		createEReference(visualizationEClass, VISUALIZATION__TARGET);

		dElementEClass = createEClass(DELEMENT);
		createEReference(dElementEClass, DELEMENT__CONSTRAINTS_FROM);
		createEReference(dElementEClass, DELEMENT__CONSTRAINTS_TO);

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
	@Override
	public EClass getDArrow() {
		return dArrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrow_Arrow() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrow_Bendpoints() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrow_DOutgoingAttributes() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDArrow_ConfigureString() {
		return (EAttribute)dArrowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrow_DConstraints() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrow_DSource() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrow_DTarget() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrow_DType() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDArrow_LineStyle() {
		return (EAttribute)dArrowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrow_NameOffset() {
		return (EReference)dArrowEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDArrowLabelConstraint() {
		return dArrowLabelConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrowLabelConstraint_Offset() {
		return (EReference)dArrowLabelConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrowLabelConstraint_Source() {
		return (EReference)dArrowLabelConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDComposedConstraint() {
		return dComposedConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDComposedConstraint_Children() {
		return (EReference)dComposedConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDComposedConstraint_FakeNode() {
		return (EReference)dComposedConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDConstraint() {
		return dConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDConstraint_Constraint() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDConstraint_DArrows() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDConstraint_DNodes() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDConstraint_DPredicate() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_DNodeDAttributes() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDConstraint_DArrowDAttributes() {
		return (EReference)dConstraintEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDElement() {
		return dElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDElement_ConstraintsFrom() {
		return (EReference)dElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDElement_ConstraintsTo() {
		return (EReference)dElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDNodeDAttribute() {
		return dNodeDAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNodeDAttribute_DSource() {
		return (EReference)dNodeDAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNodeDAttribute_NodeAttribute() {
		return (EReference)dNodeDAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNodeDAttribute_DType() {
		return (EReference)dNodeDAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDNodeDAttribute_ConfigureString() {
		return (EAttribute)dNodeDAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDNodeDAttribute_LineStyle() {
		return (EAttribute)dNodeDAttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNodeDAttribute_DTarget() {
		return (EReference)dNodeDAttributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNodeDAttribute_DConstraints() {
		return (EReference)dNodeDAttributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNodeDAttribute_NameOffset() {
		return (EReference)dNodeDAttributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDNodeDAttribute_Bendpoints() {
		return (EReference)dNodeDAttributeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDArrowDAttribute() {
		return dArrowDAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrowDAttribute_DSource() {
		return (EReference)dArrowDAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrowDAttribute_ArrowAttribute() {
		return (EReference)dArrowDAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDArrowDAttribute_DType() {
		return (EReference)dArrowDAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrowDAttribute_DTarget() {
		return (EReference)dArrowDAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDArrowDAttribute_ConfigureString() {
		return (EAttribute)dArrowDAttributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDArrowDAttribute_Linestyle() {
		return (EAttribute)dArrowDAttributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrowDAttribute_DConstraints() {
		return (EReference)dArrowDAttributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrowDAttribute_NameOffset() {
		return (EReference)dArrowDAttributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDArrowDAttribute_Bendpoints() {
		return (EReference)dArrowDAttributeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDGenericArrowConstraint() {
		return dGenericArrowConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDGenericArrowConstraint_Source() {
		return (EReference)dGenericArrowConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDGenericArrowConstraint_Target() {
		return (EReference)dGenericArrowConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDGraph() {
		return dGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDGraph_DArrows() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDGraph_DNodes() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDGraph_DType() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDGraph_Graph() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDGraph_DDataNodes() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDGraph_DArrowDAttributes() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDGraph_DNodeDAttributes() {
		return (EReference)dGraphEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagramFactory getDiagramFactory() {
		return (DiagramFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDNode() {
		return dNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDNode_ConfigureString() {
		return (EAttribute)dNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNode_DConstraints() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNode_DIncomings() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNode_DOutgoings() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNode_DType() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDNode_Location() {
		return (EAttribute)dNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNode_Node() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDNode_Size() {
		return (EAttribute)dNodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDNode_DOutgoingAttributes() {
		return (EReference)dNodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDDataNode() {
		return dDataNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDDataNode_Datanode() {
		return (EReference)dDataNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDDataNode_ConfigureString() {
		return (EAttribute)dDataNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDDataNode_Location() {
		return (EAttribute)dDataNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDDataNode_Size() {
		return (EAttribute)dDataNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDDataNode_DIncomingDNodeDAttributes() {
		return (EReference)dDataNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDDataNode_DIncomingDArrowDAttributes() {
		return (EReference)dDataNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDDataNode_DType() {
		return (EReference)dDataNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDConstraintNode() {
		return dConstraintNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDConstraintNode_DConstraint() {
		return (EReference)dConstraintNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDOffset() {
		return dOffsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDOffset_Index() {
		return (EAttribute)dOffsetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDOffset_Len() {
		return (EAttribute)dOffsetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDOffset_Offset() {
		return (EAttribute)dOffsetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDPredicate() {
		return dPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDPredicate_DGraph() {
		return (EReference)dPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDPredicate_Icon() {
		return (EAttribute)dPredicateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDPredicate_Predicate() {
		return (EReference)dPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDPredicate_SimpleName() {
		return (EAttribute)dPredicateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDPredicate_Visualization() {
		return (EReference)dPredicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDSignature() {
		return dSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDSignature_DPredicates() {
		return (EReference)dSignatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDSignature_Signature() {
		return (EReference)dSignatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDSpecification() {
		return dSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDSpecification_DConstraints() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDSpecification_DGraph() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDSpecification_DSignature() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDSpecification_DType() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDSpecification_Grid() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDSpecification_GridVisible() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDSpecification_MetaFile() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDSpecification_SignatureFile() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDSpecification_Snap() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDSpecification_Specification() {
		return (EReference)dSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDSpecification_Zoom() {
		return (EAttribute)dSpecificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getEDimension() {
		return eDimensionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getELocation() {
		return eLocationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVisualization() {
		return visualizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVisualization_Source() {
		return (EReference)visualizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVisualization_Target() {
		return (EReference)visualizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVisualization_Type() {
		return (EAttribute)visualizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVisualizationType() {
		return visualizationTypeEEnum;
	}

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
		dNodeEClass.getESuperTypes().add(this.getDElement());
		dDataNodeEClass.getESuperTypes().add(this.getDElement());
		dConstraintNodeEClass.getESuperTypes().add(this.getDNode());
		dArrowEClass.getESuperTypes().add(this.getDElement());
		dNodeDAttributeEClass.getESuperTypes().add(this.getDElement());
		dArrowDAttributeEClass.getESuperTypes().add(this.getDElement());
		dArrowLabelConstraintEClass.getESuperTypes().add(this.getDConstraint());
		dGenericArrowConstraintEClass.getESuperTypes().add(this.getDConstraint());
		dComposedConstraintEClass.getESuperTypes().add(this.getDConstraint());

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

		addEOperation(dSpecificationEClass, this.getDSpecification(), "getTemplateDSpecification", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dGraphEClass, DGraph.class, "DGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDGraph_DType(), this.getDGraph(), null, "dType", null, 1, 1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_DNodes(), this.getDNode(), null, "dNodes", null, 0, -1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_DArrows(), this.getDArrow(), null, "dArrows", null, 0, -1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_Graph(), theCorePackage.getGraph(), null, "graph", null, 1, 1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_DDataNodes(), this.getDDataNode(), null, "dDataNodes", null, 0, -1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_DArrowDAttributes(), this.getDArrowDAttribute(), null, "dArrowDAttributes", null, 0, -1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGraph_DNodeDAttributes(), this.getDNodeDAttribute(), null, "dNodeDAttributes", null, 0, -1, DGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		addEOperation(dGraphEClass, this.getDGraph(), "getTemplateDGraph", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dNodeEClass, DNode.class, "DNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDNode_DType(), this.getDNode(), null, "dType", null, 1, 1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_Node(), theCorePackage.getNode(), null, "node", null, 1, 1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDNode_ConfigureString(), ecorePackage.getEString(), "configureString", null, 0, 1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_DOutgoings(), this.getDArrow(), this.getDArrow_DSource(), "dOutgoings", null, 0, -1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_DIncomings(), this.getDArrow(), this.getDArrow_DTarget(), "dIncomings", null, 0, -1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_DConstraints(), this.getDConstraint(), this.getDConstraint_DNodes(), "dConstraints", null, 0, -1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDNode_Location(), this.getELocation(), "location", null, 0, 1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDNode_Size(), this.getEDimension(), "size", null, 0, 1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNode_DOutgoingAttributes(), this.getDNodeDAttribute(), this.getDNodeDAttribute_DSource(), "dOutgoingAttributes", null, 0, -1, DNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(dNodeEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dNodeEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dNodeEClass, this.getDNode(), "getTemplateDNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dDataNodeEClass, DDataNode.class, "DDataNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDDataNode_Datanode(), theCorePackage.getDataNode(), null, "datanode", null, 1, 1, DDataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDDataNode_ConfigureString(), ecorePackage.getEString(), "configureString", null, 0, 1, DDataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDDataNode_Location(), this.getELocation(), "location", null, 0, 1, DDataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDDataNode_Size(), this.getEDimension(), "size", null, 0, 1, DDataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDDataNode_DIncomingDNodeDAttributes(), this.getDNodeDAttribute(), this.getDNodeDAttribute_DTarget(), "dIncomingDNodeDAttributes", null, 0, -1, DDataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDDataNode_DIncomingDArrowDAttributes(), this.getDArrowDAttribute(), this.getDArrowDAttribute_DTarget(), "dIncomingDArrowDAttributes", null, 0, -1, DDataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDDataNode_DType(), this.getDDataNode(), null, "dType", null, 1, 1, DDataNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(dDataNodeEClass, this.getDDataNode(), "getTemplateDDataNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dConstraintNodeEClass, DConstraintNode.class, "DConstraintNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDConstraintNode_DConstraint(), this.getDConstraint(), null, "dConstraint", null, 0, 1, DConstraintNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dArrowEClass, DArrow.class, "DArrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDArrow_DType(), this.getDArrow(), null, "dType", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_Arrow(), theCorePackage.getArrow(), null, "arrow", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDArrow_ConfigureString(), ecorePackage.getEString(), "configureString", null, 0, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDArrow_LineStyle(), ecorePackage.getEInt(), "lineStyle", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_DSource(), this.getDNode(), this.getDNode_DOutgoings(), "dSource", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_DTarget(), this.getDNode(), this.getDNode_DIncomings(), "dTarget", null, 1, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_DConstraints(), this.getDConstraint(), this.getDConstraint_DArrows(), "dConstraints", null, 0, -1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_NameOffset(), this.getDOffset(), null, "nameOffset", null, 0, 1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_Bendpoints(), this.getDOffset(), null, "bendpoints", null, 0, -1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrow_DOutgoingAttributes(), this.getDArrowDAttribute(), this.getDArrowDAttribute_DSource(), "dOutgoingAttributes", null, 0, -1, DArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dArrowEClass, null, "reconnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowEClass, null, "disconnect", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowEClass, this.getDArrow(), "getTemplateDArrow", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dNodeDAttributeEClass, DNodeDAttribute.class, "DNodeDAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDNodeDAttribute_DSource(), this.getDNode(), this.getDNode_DOutgoingAttributes(), "dSource", null, 1, 1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNodeDAttribute_NodeAttribute(), theCorePackage.getNodeAttribute(), null, "nodeAttribute", null, 1, 1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNodeDAttribute_DType(), this.getDNodeDAttribute(), null, "dType", null, 1, 1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDNodeDAttribute_ConfigureString(), ecorePackage.getEString(), "configureString", null, 0, 1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDNodeDAttribute_LineStyle(), ecorePackage.getEInt(), "lineStyle", null, 1, 1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNodeDAttribute_DTarget(), this.getDDataNode(), this.getDDataNode_DIncomingDNodeDAttributes(), "dTarget", null, 1, 1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNodeDAttribute_DConstraints(), this.getDConstraint(), null, "dConstraints", null, 0, -1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNodeDAttribute_NameOffset(), this.getDOffset(), null, "nameOffset", null, 0, 1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDNodeDAttribute_Bendpoints(), this.getDOffset(), null, "bendpoints", null, 0, -1, DNodeDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dNodeDAttributeEClass, null, "reconnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDDataNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dNodeDAttributeEClass, null, "disconnect", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dNodeDAttributeEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dNodeDAttributeEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dNodeDAttributeEClass, this.getDNodeDAttribute(), "getTemplateDAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dArrowDAttributeEClass, DArrowDAttribute.class, "DArrowDAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDArrowDAttribute_DSource(), this.getDArrow(), this.getDArrow_DOutgoingAttributes(), "dSource", null, 1, 1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrowDAttribute_ArrowAttribute(), theCorePackage.getArrowAttribute(), null, "arrowAttribute", null, 1, 1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrowDAttribute_DType(), this.getDArrowDAttribute(), null, "dType", null, 1, 1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrowDAttribute_DTarget(), this.getDDataNode(), this.getDDataNode_DIncomingDArrowDAttributes(), "dTarget", null, 1, 1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDArrowDAttribute_ConfigureString(), ecorePackage.getEString(), "configureString", null, 0, 1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDArrowDAttribute_Linestyle(), ecorePackage.getEInt(), "linestyle", null, 0, 1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrowDAttribute_DConstraints(), this.getDConstraint(), null, "dConstraints", null, 0, -1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrowDAttribute_NameOffset(), this.getDOffset(), null, "nameOffset", null, 0, 1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrowDAttribute_Bendpoints(), this.getDOffset(), null, "bendpoints", null, 0, -1, DArrowDAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dArrowDAttributeEClass, null, "reconnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDArrow(), "source", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDDataNode(), "target", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowDAttributeEClass, null, "disconnect", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowDAttributeEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowDAttributeEClass, ecorePackage.getEString(), "getTypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dArrowDAttributeEClass, this.getDArrowDAttribute(), "getTemplateDAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dConstraintEClass, DConstraint.class, "DConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDConstraint_Constraint(), theCorePackage.getConstraint(), null, "constraint", null, 0, 1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_DNodes(), this.getDNode(), this.getDNode_DConstraints(), "dNodes", null, 0, -1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_DArrows(), this.getDArrow(), this.getDArrow_DConstraints(), "dArrows", null, 0, -1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_DPredicate(), this.getDPredicate(), null, "dPredicate", null, 0, 1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_DNodeDAttributes(), this.getDNodeDAttribute(), null, "dNodeDAttributes", null, 0, -1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDConstraint_DArrowDAttributes(), this.getDArrowDAttribute(), null, "DArrowDAttributes", null, 0, -1, DConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dConstraintEClass, null, "reconnect", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "nodes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDArrow(), "arrows", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDSpecification(), "specification", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dConstraintEClass, null, "disconnect", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dConstraintEClass, null, "addDArrow", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDArrow(), "dArrow", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dConstraintEClass, null, "addDNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDNode(), "dNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dArrowLabelConstraintEClass, DArrowLabelConstraint.class, "DArrowLabelConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDArrowLabelConstraint_Offset(), this.getDOffset(), null, "offset", null, 0, 1, DArrowLabelConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDArrowLabelConstraint_Source(), this.getDElement(), null, "source", null, 0, 1, DArrowLabelConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dGenericArrowConstraintEClass, DGenericArrowConstraint.class, "DGenericArrowConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDGenericArrowConstraint_Source(), this.getDElement(), null, "source", null, 0, 1, DGenericArrowConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDGenericArrowConstraint_Target(), this.getDElement(), null, "target", null, 0, 1, DGenericArrowConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dComposedConstraintEClass, DComposedConstraint.class, "DComposedConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDComposedConstraint_Children(), this.getDConstraint(), null, "children", null, 0, -1, DComposedConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDComposedConstraint_FakeNode(), this.getDConstraintNode(), null, "fakeNode", null, 0, 1, DComposedConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dPredicateEClass, DPredicate.class, "DPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDPredicate_Predicate(), theCorePackage.getPredicate(), null, "predicate", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDPredicate_DGraph(), this.getDGraph(), null, "dGraph", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDPredicate_Visualization(), this.getVisualization(), null, "visualization", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDPredicate_Icon(), ecorePackage.getEString(), "icon", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDPredicate_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, DPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dOffsetEClass, DOffset.class, "DOffset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDOffset_Offset(), this.getELocation(), "offset", null, 0, 1, DOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDOffset_Len(), ecorePackage.getEInt(), "len", null, 0, 1, DOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDOffset_Index(), ecorePackage.getEInt(), "index", null, 0, 1, DOffset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(dElementEClass, DElement.class, "DElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDElement_ConstraintsFrom(), this.getDConstraint(), null, "constraintsFrom", null, 0, -1, DElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDElement_ConstraintsTo(), this.getDConstraint(), null, "constraintsTo", null, 0, -1, DElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(visualizationTypeEEnum, VisualizationType.class, "VisualizationType");
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_LABEL);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.NODE_TO_NODE);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.NODE_TO_ARROW);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_TO_NODE);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ARROW_TO_ARROW);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.COMPOSED);
		addEEnumLiteral(visualizationTypeEEnum, VisualizationType.ON_NODE);

		// Initialize data types
		initEDataType(eDimensionEDataType, Dimension.class, "EDimension", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(eLocationEDataType, Point.class, "ELocation", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DiagramPackageImpl
