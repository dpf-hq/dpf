/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see no.hib.dpf.diagram.DiagramFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://no.hib.dpf.diagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "diagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramPackage eINSTANCE = no.hib.dpf.diagram.impl.DiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DSpecificationImpl <em>DSpecification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DSpecificationImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDSpecification()
	 * @generated
	 */
	int DSPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__DTYPE = 0;

	/**
	 * The feature id for the '<em><b>DGraph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__DGRAPH = 1;

	/**
	 * The feature id for the '<em><b>DConstraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__DCONSTRAINTS = 2;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Grid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__GRID = 4;

	/**
	 * The feature id for the '<em><b>Snap</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__SNAP = 5;

	/**
	 * The feature id for the '<em><b>Zoom</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__ZOOM = 6;

	/**
	 * The feature id for the '<em><b>Grid Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__GRID_VISIBLE = 7;

	/**
	 * The feature id for the '<em><b>DSignature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__DSIGNATURE = 8;

	/**
	 * The feature id for the '<em><b>Meta File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__META_FILE = 9;

	/**
	 * The feature id for the '<em><b>Signature File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION__SIGNATURE_FILE = 10;

	/**
	 * The number of structural features of the '<em>DSpecification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSPECIFICATION_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DGraphImpl <em>DGraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DGraphImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDGraph()
	 * @generated
	 */
	int DGRAPH = 1;

	/**
	 * The feature id for the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGRAPH__DTYPE = 0;

	/**
	 * The feature id for the '<em><b>DNodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGRAPH__DNODES = 1;

	/**
	 * The feature id for the '<em><b>DArrows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGRAPH__DARROWS = 2;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGRAPH__GRAPH = 3;

	/**
	 * The number of structural features of the '<em>DGraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGRAPH_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DElementImpl <em>DElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DElementImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDElement()
	 * @generated
	 */
	int DELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Constraints From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEMENT__CONSTRAINTS_FROM = 0;

	/**
	 * The feature id for the '<em><b>Constraints To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEMENT__CONSTRAINTS_TO = 1;

	/**
	 * The number of structural features of the '<em>DElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DNodeImpl <em>DNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DNodeImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDNode()
	 * @generated
	 */
	int DNODE = 2;

	/**
	 * The feature id for the '<em><b>Constraints From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__CONSTRAINTS_FROM = DELEMENT__CONSTRAINTS_FROM;

	/**
	 * The feature id for the '<em><b>Constraints To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__CONSTRAINTS_TO = DELEMENT__CONSTRAINTS_TO;

	/**
	 * The feature id for the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__DTYPE = DELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__NODE = DELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Configure String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__CONFIGURE_STRING = DELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>DOutgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__DOUTGOINGS = DELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>DIncomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__DINCOMINGS = DELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>DConstraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__DCONSTRAINTS = DELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__LOCATION = DELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE__SIZE = DELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>DNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DNODE_FEATURE_COUNT = DELEMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DFakeNodeImpl <em>DFake Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DFakeNodeImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDFakeNode()
	 * @generated
	 */
	int DFAKE_NODE = 3;

	/**
	 * The feature id for the '<em><b>Constraints From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__CONSTRAINTS_FROM = DNODE__CONSTRAINTS_FROM;

	/**
	 * The feature id for the '<em><b>Constraints To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__CONSTRAINTS_TO = DNODE__CONSTRAINTS_TO;

	/**
	 * The feature id for the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__DTYPE = DNODE__DTYPE;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__NODE = DNODE__NODE;

	/**
	 * The feature id for the '<em><b>Configure String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__CONFIGURE_STRING = DNODE__CONFIGURE_STRING;

	/**
	 * The feature id for the '<em><b>DOutgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__DOUTGOINGS = DNODE__DOUTGOINGS;

	/**
	 * The feature id for the '<em><b>DIncomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__DINCOMINGS = DNODE__DINCOMINGS;

	/**
	 * The feature id for the '<em><b>DConstraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__DCONSTRAINTS = DNODE__DCONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__LOCATION = DNODE__LOCATION;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__SIZE = DNODE__SIZE;

	/**
	 * The feature id for the '<em><b>DConstraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE__DCONSTRAINT = DNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DFake Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFAKE_NODE_FEATURE_COUNT = DNODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DArrowImpl <em>DArrow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DArrowImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDArrow()
	 * @generated
	 */
	int DARROW = 4;

	/**
	 * The feature id for the '<em><b>Constraints From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__CONSTRAINTS_FROM = DELEMENT__CONSTRAINTS_FROM;

	/**
	 * The feature id for the '<em><b>Constraints To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__CONSTRAINTS_TO = DELEMENT__CONSTRAINTS_TO;

	/**
	 * The feature id for the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__DTYPE = DELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arrow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__ARROW = DELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Configure String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__CONFIGURE_STRING = DELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Line Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__LINE_STYLE = DELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>DSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__DSOURCE = DELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>DTarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__DTARGET = DELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>DConstraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__DCONSTRAINTS = DELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name Offset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__NAME_OFFSET = DELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Bendpoints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW__BENDPOINTS = DELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>DArrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW_FEATURE_COUNT = DELEMENT_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DConstraintImpl <em>DConstraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DConstraintImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDConstraint()
	 * @generated
	 */
	int DCONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCONSTRAINT__CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>DNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCONSTRAINT__DNODES = 1;

	/**
	 * The feature id for the '<em><b>DArrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCONSTRAINT__DARROWS = 2;

	/**
	 * The feature id for the '<em><b>DPredicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCONSTRAINT__DPREDICATE = 3;

	/**
	 * The number of structural features of the '<em>DConstraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCONSTRAINT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DArrowLabelConstraintImpl <em>DArrow Label Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DArrowLabelConstraintImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDArrowLabelConstraint()
	 * @generated
	 */
	int DARROW_LABEL_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW_LABEL_CONSTRAINT__CONSTRAINT = DCONSTRAINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>DNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW_LABEL_CONSTRAINT__DNODES = DCONSTRAINT__DNODES;

	/**
	 * The feature id for the '<em><b>DArrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW_LABEL_CONSTRAINT__DARROWS = DCONSTRAINT__DARROWS;

	/**
	 * The feature id for the '<em><b>DPredicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW_LABEL_CONSTRAINT__DPREDICATE = DCONSTRAINT__DPREDICATE;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW_LABEL_CONSTRAINT__OFFSET = DCONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW_LABEL_CONSTRAINT__SOURCE = DCONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DArrow Label Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DARROW_LABEL_CONSTRAINT_FEATURE_COUNT = DCONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DGenericArrowConstraintImpl <em>DGeneric Arrow Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DGenericArrowConstraintImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDGenericArrowConstraint()
	 * @generated
	 */
	int DGENERIC_ARROW_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGENERIC_ARROW_CONSTRAINT__CONSTRAINT = DCONSTRAINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>DNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGENERIC_ARROW_CONSTRAINT__DNODES = DCONSTRAINT__DNODES;

	/**
	 * The feature id for the '<em><b>DArrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGENERIC_ARROW_CONSTRAINT__DARROWS = DCONSTRAINT__DARROWS;

	/**
	 * The feature id for the '<em><b>DPredicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGENERIC_ARROW_CONSTRAINT__DPREDICATE = DCONSTRAINT__DPREDICATE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGENERIC_ARROW_CONSTRAINT__SOURCE = DCONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGENERIC_ARROW_CONSTRAINT__TARGET = DCONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DGeneric Arrow Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DGENERIC_ARROW_CONSTRAINT_FEATURE_COUNT = DCONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DComposedConstraintImpl <em>DComposed Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DComposedConstraintImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDComposedConstraint()
	 * @generated
	 */
	int DCOMPOSED_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCOMPOSED_CONSTRAINT__CONSTRAINT = DCONSTRAINT__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>DNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCOMPOSED_CONSTRAINT__DNODES = DCONSTRAINT__DNODES;

	/**
	 * The feature id for the '<em><b>DArrows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCOMPOSED_CONSTRAINT__DARROWS = DCONSTRAINT__DARROWS;

	/**
	 * The feature id for the '<em><b>DPredicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCOMPOSED_CONSTRAINT__DPREDICATE = DCONSTRAINT__DPREDICATE;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCOMPOSED_CONSTRAINT__CHILDREN = DCONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fake Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCOMPOSED_CONSTRAINT__FAKE_NODE = DCONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DComposed Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DCOMPOSED_CONSTRAINT_FEATURE_COUNT = DCONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DPredicateImpl <em>DPredicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DPredicateImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDPredicate()
	 * @generated
	 */
	int DPREDICATE = 9;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPREDICATE__PREDICATE = 0;

	/**
	 * The feature id for the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPREDICATE__SIMPLE_NAME = 1;

	/**
	 * The feature id for the '<em><b>DGraph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPREDICATE__DGRAPH = 2;

	/**
	 * The feature id for the '<em><b>Visualization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPREDICATE__VISUALIZATION = 3;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPREDICATE__ICON = 4;

	/**
	 * The number of structural features of the '<em>DPredicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DPREDICATE_FEATURE_COUNT = 5;


	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DOffsetImpl <em>DOffset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DOffsetImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDOffset()
	 * @generated
	 */
	int DOFFSET = 10;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOFFSET__OFFSET = 0;

	/**
	 * The feature id for the '<em><b>Len</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOFFSET__LEN = 1;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOFFSET__INDEX = 2;

	/**
	 * The number of structural features of the '<em>DOffset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOFFSET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.DSignatureImpl <em>DSignature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.DSignatureImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDSignature()
	 * @generated
	 */
	int DSIGNATURE = 11;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSIGNATURE__SIGNATURE = 0;

	/**
	 * The feature id for the '<em><b>DPredicates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSIGNATURE__DPREDICATES = 1;

	/**
	 * The number of structural features of the '<em>DSignature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSIGNATURE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.impl.VisualizationImpl <em>Visualization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.impl.VisualizationImpl
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getVisualization()
	 * @generated
	 */
	int VISUALIZATION = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATION__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATION__TARGET = 2;

	/**
	 * The number of structural features of the '<em>Visualization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISUALIZATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link no.hib.dpf.diagram.VisualizationType <em>Visualization Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see no.hib.dpf.diagram.VisualizationType
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getVisualizationType()
	 * @generated
	 */
	int VISUALIZATION_TYPE = 14;

	/**
	 * The meta object id for the '<em>EDimension</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.draw2d.geometry.Dimension
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getEDimension()
	 * @generated
	 */
	int EDIMENSION = 15;

	/**
	 * The meta object id for the '<em>ELocation</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.draw2d.geometry.Point
	 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getELocation()
	 * @generated
	 */
	int ELOCATION = 16;

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DSpecification <em>DSpecification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSpecification</em>'.
	 * @see no.hib.dpf.diagram.DSpecification
	 * @generated
	 */
	EClass getDSpecification();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DSpecification#getDType <em>DType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DType</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#getDType()
	 * @see #getDSpecification()
	 * @generated
	 */
	EReference getDSpecification_DType();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.diagram.DSpecification#getDGraph <em>DGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>DGraph</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#getDGraph()
	 * @see #getDSpecification()
	 * @generated
	 */
	EReference getDSpecification_DGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.diagram.DSpecification#getDConstraints <em>DConstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>DConstraints</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#getDConstraints()
	 * @see #getDSpecification()
	 * @generated
	 */
	EReference getDSpecification_DConstraints();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DSpecification#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specification</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#getSpecification()
	 * @see #getDSpecification()
	 * @generated
	 */
	EReference getDSpecification_Specification();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DSpecification#isGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grid</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#isGrid()
	 * @see #getDSpecification()
	 * @generated
	 */
	EAttribute getDSpecification_Grid();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DSpecification#isSnap <em>Snap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snap</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#isSnap()
	 * @see #getDSpecification()
	 * @generated
	 */
	EAttribute getDSpecification_Snap();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DSpecification#getZoom <em>Zoom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zoom</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#getZoom()
	 * @see #getDSpecification()
	 * @generated
	 */
	EAttribute getDSpecification_Zoom();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DSpecification#isGridVisible <em>Grid Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grid Visible</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#isGridVisible()
	 * @see #getDSpecification()
	 * @generated
	 */
	EAttribute getDSpecification_GridVisible();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DSpecification#getDSignature <em>DSignature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DSignature</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#getDSignature()
	 * @see #getDSpecification()
	 * @generated
	 */
	EReference getDSpecification_DSignature();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DSpecification#getMetaFile <em>Meta File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta File</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#getMetaFile()
	 * @see #getDSpecification()
	 * @generated
	 */
	EAttribute getDSpecification_MetaFile();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DSpecification#getSignatureFile <em>Signature File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signature File</em>'.
	 * @see no.hib.dpf.diagram.DSpecification#getSignatureFile()
	 * @see #getDSpecification()
	 * @generated
	 */
	EAttribute getDSpecification_SignatureFile();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DGraph <em>DGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DGraph</em>'.
	 * @see no.hib.dpf.diagram.DGraph
	 * @generated
	 */
	EClass getDGraph();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DGraph#getDType <em>DType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DType</em>'.
	 * @see no.hib.dpf.diagram.DGraph#getDType()
	 * @see #getDGraph()
	 * @generated
	 */
	EReference getDGraph_DType();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.diagram.DGraph#getDNodes <em>DNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>DNodes</em>'.
	 * @see no.hib.dpf.diagram.DGraph#getDNodes()
	 * @see #getDGraph()
	 * @generated
	 */
	EReference getDGraph_DNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.diagram.DGraph#getDArrows <em>DArrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>DArrows</em>'.
	 * @see no.hib.dpf.diagram.DGraph#getDArrows()
	 * @see #getDGraph()
	 * @generated
	 */
	EReference getDGraph_DArrows();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DGraph#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Graph</em>'.
	 * @see no.hib.dpf.diagram.DGraph#getGraph()
	 * @see #getDGraph()
	 * @generated
	 */
	EReference getDGraph_Graph();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DNode <em>DNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DNode</em>'.
	 * @see no.hib.dpf.diagram.DNode
	 * @generated
	 */
	EClass getDNode();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DNode#getDType <em>DType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DType</em>'.
	 * @see no.hib.dpf.diagram.DNode#getDType()
	 * @see #getDNode()
	 * @generated
	 */
	EReference getDNode_DType();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see no.hib.dpf.diagram.DNode#getNode()
	 * @see #getDNode()
	 * @generated
	 */
	EReference getDNode_Node();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DNode#getConfigureString <em>Configure String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configure String</em>'.
	 * @see no.hib.dpf.diagram.DNode#getConfigureString()
	 * @see #getDNode()
	 * @generated
	 */
	EAttribute getDNode_ConfigureString();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DNode#getDOutgoings <em>DOutgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>DOutgoings</em>'.
	 * @see no.hib.dpf.diagram.DNode#getDOutgoings()
	 * @see #getDNode()
	 * @generated
	 */
	EReference getDNode_DOutgoings();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DNode#getDIncomings <em>DIncomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>DIncomings</em>'.
	 * @see no.hib.dpf.diagram.DNode#getDIncomings()
	 * @see #getDNode()
	 * @generated
	 */
	EReference getDNode_DIncomings();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DNode#getDConstraints <em>DConstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>DConstraints</em>'.
	 * @see no.hib.dpf.diagram.DNode#getDConstraints()
	 * @see #getDNode()
	 * @generated
	 */
	EReference getDNode_DConstraints();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DNode#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see no.hib.dpf.diagram.DNode#getLocation()
	 * @see #getDNode()
	 * @generated
	 */
	EAttribute getDNode_Location();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DNode#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see no.hib.dpf.diagram.DNode#getSize()
	 * @see #getDNode()
	 * @generated
	 */
	EAttribute getDNode_Size();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DFakeNode <em>DFake Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFake Node</em>'.
	 * @see no.hib.dpf.diagram.DFakeNode
	 * @generated
	 */
	EClass getDFakeNode();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DFakeNode#getDConstraint <em>DConstraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DConstraint</em>'.
	 * @see no.hib.dpf.diagram.DFakeNode#getDConstraint()
	 * @see #getDFakeNode()
	 * @generated
	 */
	EReference getDFakeNode_DConstraint();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DArrow <em>DArrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DArrow</em>'.
	 * @see no.hib.dpf.diagram.DArrow
	 * @generated
	 */
	EClass getDArrow();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DArrow#getDType <em>DType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DType</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getDType()
	 * @see #getDArrow()
	 * @generated
	 */
	EReference getDArrow_DType();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DArrow#getArrow <em>Arrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Arrow</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getArrow()
	 * @see #getDArrow()
	 * @generated
	 */
	EReference getDArrow_Arrow();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DArrow#getConfigureString <em>Configure String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Configure String</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getConfigureString()
	 * @see #getDArrow()
	 * @generated
	 */
	EAttribute getDArrow_ConfigureString();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DArrow#getLineStyle <em>Line Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Style</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getLineStyle()
	 * @see #getDArrow()
	 * @generated
	 */
	EAttribute getDArrow_LineStyle();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DArrow#getDSource <em>DSource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DSource</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getDSource()
	 * @see #getDArrow()
	 * @generated
	 */
	EReference getDArrow_DSource();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DArrow#getDTarget <em>DTarget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DTarget</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getDTarget()
	 * @see #getDArrow()
	 * @generated
	 */
	EReference getDArrow_DTarget();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DArrow#getDConstraints <em>DConstraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>DConstraints</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getDConstraints()
	 * @see #getDArrow()
	 * @generated
	 */
	EReference getDArrow_DConstraints();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.diagram.DArrow#getBendpoints <em>Bendpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bendpoints</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getBendpoints()
	 * @see #getDArrow()
	 * @generated
	 */
	EReference getDArrow_Bendpoints();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.diagram.DArrow#getNameOffset <em>Name Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name Offset</em>'.
	 * @see no.hib.dpf.diagram.DArrow#getNameOffset()
	 * @see #getDArrow()
	 * @generated
	 */
	EReference getDArrow_NameOffset();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DConstraint <em>DConstraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DConstraint</em>'.
	 * @see no.hib.dpf.diagram.DConstraint
	 * @generated
	 */
	EClass getDConstraint();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DConstraint#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constraint</em>'.
	 * @see no.hib.dpf.diagram.DConstraint#getConstraint()
	 * @see #getDConstraint()
	 * @generated
	 */
	EReference getDConstraint_Constraint();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DConstraint#getDNodes <em>DNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>DNodes</em>'.
	 * @see no.hib.dpf.diagram.DConstraint#getDNodes()
	 * @see #getDConstraint()
	 * @generated
	 */
	EReference getDConstraint_DNodes();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DConstraint#getDArrows <em>DArrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>DArrows</em>'.
	 * @see no.hib.dpf.diagram.DConstraint#getDArrows()
	 * @see #getDConstraint()
	 * @generated
	 */
	EReference getDConstraint_DArrows();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DConstraint#getDPredicate <em>DPredicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>DPredicate</em>'.
	 * @see no.hib.dpf.diagram.DConstraint#getDPredicate()
	 * @see #getDConstraint()
	 * @generated
	 */
	EReference getDConstraint_DPredicate();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DArrowLabelConstraint <em>DArrow Label Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DArrow Label Constraint</em>'.
	 * @see no.hib.dpf.diagram.DArrowLabelConstraint
	 * @generated
	 */
	EClass getDArrowLabelConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.diagram.DArrowLabelConstraint#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Offset</em>'.
	 * @see no.hib.dpf.diagram.DArrowLabelConstraint#getOffset()
	 * @see #getDArrowLabelConstraint()
	 * @generated
	 */
	EReference getDArrowLabelConstraint_Offset();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DArrowLabelConstraint#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see no.hib.dpf.diagram.DArrowLabelConstraint#getSource()
	 * @see #getDArrowLabelConstraint()
	 * @generated
	 */
	EReference getDArrowLabelConstraint_Source();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DGenericArrowConstraint <em>DGeneric Arrow Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DGeneric Arrow Constraint</em>'.
	 * @see no.hib.dpf.diagram.DGenericArrowConstraint
	 * @generated
	 */
	EClass getDGenericArrowConstraint();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DGenericArrowConstraint#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see no.hib.dpf.diagram.DGenericArrowConstraint#getSource()
	 * @see #getDGenericArrowConstraint()
	 * @generated
	 */
	EReference getDGenericArrowConstraint_Source();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DGenericArrowConstraint#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see no.hib.dpf.diagram.DGenericArrowConstraint#getTarget()
	 * @see #getDGenericArrowConstraint()
	 * @generated
	 */
	EReference getDGenericArrowConstraint_Target();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DComposedConstraint <em>DComposed Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DComposed Constraint</em>'.
	 * @see no.hib.dpf.diagram.DComposedConstraint
	 * @generated
	 */
	EClass getDComposedConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.diagram.DComposedConstraint#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see no.hib.dpf.diagram.DComposedConstraint#getChildren()
	 * @see #getDComposedConstraint()
	 * @generated
	 */
	EReference getDComposedConstraint_Children();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DComposedConstraint#getFakeNode <em>Fake Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fake Node</em>'.
	 * @see no.hib.dpf.diagram.DComposedConstraint#getFakeNode()
	 * @see #getDComposedConstraint()
	 * @generated
	 */
	EReference getDComposedConstraint_FakeNode();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DPredicate <em>DPredicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DPredicate</em>'.
	 * @see no.hib.dpf.diagram.DPredicate
	 * @generated
	 */
	EClass getDPredicate();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DPredicate#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see no.hib.dpf.diagram.DPredicate#getPredicate()
	 * @see #getDPredicate()
	 * @generated
	 */
	EReference getDPredicate_Predicate();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DPredicate#getSimpleName <em>Simple Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Simple Name</em>'.
	 * @see no.hib.dpf.diagram.DPredicate#getSimpleName()
	 * @see #getDPredicate()
	 * @generated
	 */
	EAttribute getDPredicate_SimpleName();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.diagram.DPredicate#getDGraph <em>DGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>DGraph</em>'.
	 * @see no.hib.dpf.diagram.DPredicate#getDGraph()
	 * @see #getDPredicate()
	 * @generated
	 */
	EReference getDPredicate_DGraph();

	/**
	 * Returns the meta object for the containment reference '{@link no.hib.dpf.diagram.DPredicate#getVisualization <em>Visualization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Visualization</em>'.
	 * @see no.hib.dpf.diagram.DPredicate#getVisualization()
	 * @see #getDPredicate()
	 * @generated
	 */
	EReference getDPredicate_Visualization();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DPredicate#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see no.hib.dpf.diagram.DPredicate#getIcon()
	 * @see #getDPredicate()
	 * @generated
	 */
	EAttribute getDPredicate_Icon();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DOffset <em>DOffset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DOffset</em>'.
	 * @see no.hib.dpf.diagram.DOffset
	 * @generated
	 */
	EClass getDOffset();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DOffset#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see no.hib.dpf.diagram.DOffset#getOffset()
	 * @see #getDOffset()
	 * @generated
	 */
	EAttribute getDOffset_Offset();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DOffset#getLen <em>Len</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Len</em>'.
	 * @see no.hib.dpf.diagram.DOffset#getLen()
	 * @see #getDOffset()
	 * @generated
	 */
	EAttribute getDOffset_Len();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.DOffset#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see no.hib.dpf.diagram.DOffset#getIndex()
	 * @see #getDOffset()
	 * @generated
	 */
	EAttribute getDOffset_Index();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DSignature <em>DSignature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSignature</em>'.
	 * @see no.hib.dpf.diagram.DSignature
	 * @generated
	 */
	EClass getDSignature();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.DSignature#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see no.hib.dpf.diagram.DSignature#getSignature()
	 * @see #getDSignature()
	 * @generated
	 */
	EReference getDSignature_Signature();

	/**
	 * Returns the meta object for the containment reference list '{@link no.hib.dpf.diagram.DSignature#getDPredicates <em>DPredicates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>DPredicates</em>'.
	 * @see no.hib.dpf.diagram.DSignature#getDPredicates()
	 * @see #getDSignature()
	 * @generated
	 */
	EReference getDSignature_DPredicates();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.Visualization <em>Visualization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visualization</em>'.
	 * @see no.hib.dpf.diagram.Visualization
	 * @generated
	 */
	EClass getVisualization();

	/**
	 * Returns the meta object for the attribute '{@link no.hib.dpf.diagram.Visualization#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see no.hib.dpf.diagram.Visualization#getType()
	 * @see #getVisualization()
	 * @generated
	 */
	EAttribute getVisualization_Type();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.Visualization#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see no.hib.dpf.diagram.Visualization#getSource()
	 * @see #getVisualization()
	 * @generated
	 */
	EReference getVisualization_Source();

	/**
	 * Returns the meta object for the reference '{@link no.hib.dpf.diagram.Visualization#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see no.hib.dpf.diagram.Visualization#getTarget()
	 * @see #getVisualization()
	 * @generated
	 */
	EReference getVisualization_Target();

	/**
	 * Returns the meta object for class '{@link no.hib.dpf.diagram.DElement <em>DElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DElement</em>'.
	 * @see no.hib.dpf.diagram.DElement
	 * @generated
	 */
	EClass getDElement();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DElement#getConstraintsFrom <em>Constraints From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints From</em>'.
	 * @see no.hib.dpf.diagram.DElement#getConstraintsFrom()
	 * @see #getDElement()
	 * @generated
	 */
	EReference getDElement_ConstraintsFrom();

	/**
	 * Returns the meta object for the reference list '{@link no.hib.dpf.diagram.DElement#getConstraintsTo <em>Constraints To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints To</em>'.
	 * @see no.hib.dpf.diagram.DElement#getConstraintsTo()
	 * @see #getDElement()
	 * @generated
	 */
	EReference getDElement_ConstraintsTo();

	/**
	 * Returns the meta object for enum '{@link no.hib.dpf.diagram.VisualizationType <em>Visualization Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visualization Type</em>'.
	 * @see no.hib.dpf.diagram.VisualizationType
	 * @generated
	 */
	EEnum getVisualizationType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Dimension <em>EDimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>EDimension</em>'.
	 * @see org.eclipse.draw2d.geometry.Dimension
	 * @model instanceClass="org.eclipse.draw2d.geometry.Dimension"
	 * @generated
	 */
	EDataType getEDimension();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.draw2d.geometry.Point <em>ELocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ELocation</em>'.
	 * @see org.eclipse.draw2d.geometry.Point
	 * @model instanceClass="org.eclipse.draw2d.geometry.Point"
	 * @generated
	 */
	EDataType getELocation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramFactory getDiagramFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DSpecificationImpl <em>DSpecification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DSpecificationImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDSpecification()
		 * @generated
		 */
		EClass DSPECIFICATION = eINSTANCE.getDSpecification();

		/**
		 * The meta object literal for the '<em><b>DType</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSPECIFICATION__DTYPE = eINSTANCE.getDSpecification_DType();

		/**
		 * The meta object literal for the '<em><b>DGraph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSPECIFICATION__DGRAPH = eINSTANCE.getDSpecification_DGraph();

		/**
		 * The meta object literal for the '<em><b>DConstraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSPECIFICATION__DCONSTRAINTS = eINSTANCE.getDSpecification_DConstraints();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSPECIFICATION__SPECIFICATION = eINSTANCE.getDSpecification_Specification();

		/**
		 * The meta object literal for the '<em><b>Grid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSPECIFICATION__GRID = eINSTANCE.getDSpecification_Grid();

		/**
		 * The meta object literal for the '<em><b>Snap</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSPECIFICATION__SNAP = eINSTANCE.getDSpecification_Snap();

		/**
		 * The meta object literal for the '<em><b>Zoom</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSPECIFICATION__ZOOM = eINSTANCE.getDSpecification_Zoom();

		/**
		 * The meta object literal for the '<em><b>Grid Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSPECIFICATION__GRID_VISIBLE = eINSTANCE.getDSpecification_GridVisible();

		/**
		 * The meta object literal for the '<em><b>DSignature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSPECIFICATION__DSIGNATURE = eINSTANCE.getDSpecification_DSignature();

		/**
		 * The meta object literal for the '<em><b>Meta File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSPECIFICATION__META_FILE = eINSTANCE.getDSpecification_MetaFile();

		/**
		 * The meta object literal for the '<em><b>Signature File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSPECIFICATION__SIGNATURE_FILE = eINSTANCE.getDSpecification_SignatureFile();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DGraphImpl <em>DGraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DGraphImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDGraph()
		 * @generated
		 */
		EClass DGRAPH = eINSTANCE.getDGraph();

		/**
		 * The meta object literal for the '<em><b>DType</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DGRAPH__DTYPE = eINSTANCE.getDGraph_DType();

		/**
		 * The meta object literal for the '<em><b>DNodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DGRAPH__DNODES = eINSTANCE.getDGraph_DNodes();

		/**
		 * The meta object literal for the '<em><b>DArrows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DGRAPH__DARROWS = eINSTANCE.getDGraph_DArrows();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DGRAPH__GRAPH = eINSTANCE.getDGraph_Graph();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DNodeImpl <em>DNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DNodeImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDNode()
		 * @generated
		 */
		EClass DNODE = eINSTANCE.getDNode();

		/**
		 * The meta object literal for the '<em><b>DType</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DNODE__DTYPE = eINSTANCE.getDNode_DType();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DNODE__NODE = eINSTANCE.getDNode_Node();

		/**
		 * The meta object literal for the '<em><b>Configure String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DNODE__CONFIGURE_STRING = eINSTANCE.getDNode_ConfigureString();

		/**
		 * The meta object literal for the '<em><b>DOutgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DNODE__DOUTGOINGS = eINSTANCE.getDNode_DOutgoings();

		/**
		 * The meta object literal for the '<em><b>DIncomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DNODE__DINCOMINGS = eINSTANCE.getDNode_DIncomings();

		/**
		 * The meta object literal for the '<em><b>DConstraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DNODE__DCONSTRAINTS = eINSTANCE.getDNode_DConstraints();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DNODE__LOCATION = eINSTANCE.getDNode_Location();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DNODE__SIZE = eINSTANCE.getDNode_Size();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DFakeNodeImpl <em>DFake Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DFakeNodeImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDFakeNode()
		 * @generated
		 */
		EClass DFAKE_NODE = eINSTANCE.getDFakeNode();

		/**
		 * The meta object literal for the '<em><b>DConstraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFAKE_NODE__DCONSTRAINT = eINSTANCE.getDFakeNode_DConstraint();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DArrowImpl <em>DArrow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DArrowImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDArrow()
		 * @generated
		 */
		EClass DARROW = eINSTANCE.getDArrow();

		/**
		 * The meta object literal for the '<em><b>DType</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW__DTYPE = eINSTANCE.getDArrow_DType();

		/**
		 * The meta object literal for the '<em><b>Arrow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW__ARROW = eINSTANCE.getDArrow_Arrow();

		/**
		 * The meta object literal for the '<em><b>Configure String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DARROW__CONFIGURE_STRING = eINSTANCE.getDArrow_ConfigureString();

		/**
		 * The meta object literal for the '<em><b>Line Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DARROW__LINE_STYLE = eINSTANCE.getDArrow_LineStyle();

		/**
		 * The meta object literal for the '<em><b>DSource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW__DSOURCE = eINSTANCE.getDArrow_DSource();

		/**
		 * The meta object literal for the '<em><b>DTarget</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW__DTARGET = eINSTANCE.getDArrow_DTarget();

		/**
		 * The meta object literal for the '<em><b>DConstraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW__DCONSTRAINTS = eINSTANCE.getDArrow_DConstraints();

		/**
		 * The meta object literal for the '<em><b>Bendpoints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW__BENDPOINTS = eINSTANCE.getDArrow_Bendpoints();

		/**
		 * The meta object literal for the '<em><b>Name Offset</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW__NAME_OFFSET = eINSTANCE.getDArrow_NameOffset();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DConstraintImpl <em>DConstraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DConstraintImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDConstraint()
		 * @generated
		 */
		EClass DCONSTRAINT = eINSTANCE.getDConstraint();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DCONSTRAINT__CONSTRAINT = eINSTANCE.getDConstraint_Constraint();

		/**
		 * The meta object literal for the '<em><b>DNodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DCONSTRAINT__DNODES = eINSTANCE.getDConstraint_DNodes();

		/**
		 * The meta object literal for the '<em><b>DArrows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DCONSTRAINT__DARROWS = eINSTANCE.getDConstraint_DArrows();

		/**
		 * The meta object literal for the '<em><b>DPredicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DCONSTRAINT__DPREDICATE = eINSTANCE.getDConstraint_DPredicate();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DArrowLabelConstraintImpl <em>DArrow Label Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DArrowLabelConstraintImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDArrowLabelConstraint()
		 * @generated
		 */
		EClass DARROW_LABEL_CONSTRAINT = eINSTANCE.getDArrowLabelConstraint();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW_LABEL_CONSTRAINT__OFFSET = eINSTANCE.getDArrowLabelConstraint_Offset();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DARROW_LABEL_CONSTRAINT__SOURCE = eINSTANCE.getDArrowLabelConstraint_Source();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DGenericArrowConstraintImpl <em>DGeneric Arrow Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DGenericArrowConstraintImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDGenericArrowConstraint()
		 * @generated
		 */
		EClass DGENERIC_ARROW_CONSTRAINT = eINSTANCE.getDGenericArrowConstraint();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DGENERIC_ARROW_CONSTRAINT__SOURCE = eINSTANCE.getDGenericArrowConstraint_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DGENERIC_ARROW_CONSTRAINT__TARGET = eINSTANCE.getDGenericArrowConstraint_Target();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DComposedConstraintImpl <em>DComposed Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DComposedConstraintImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDComposedConstraint()
		 * @generated
		 */
		EClass DCOMPOSED_CONSTRAINT = eINSTANCE.getDComposedConstraint();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DCOMPOSED_CONSTRAINT__CHILDREN = eINSTANCE.getDComposedConstraint_Children();

		/**
		 * The meta object literal for the '<em><b>Fake Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DCOMPOSED_CONSTRAINT__FAKE_NODE = eINSTANCE.getDComposedConstraint_FakeNode();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DPredicateImpl <em>DPredicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DPredicateImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDPredicate()
		 * @generated
		 */
		EClass DPREDICATE = eINSTANCE.getDPredicate();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DPREDICATE__PREDICATE = eINSTANCE.getDPredicate_Predicate();

		/**
		 * The meta object literal for the '<em><b>Simple Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DPREDICATE__SIMPLE_NAME = eINSTANCE.getDPredicate_SimpleName();

		/**
		 * The meta object literal for the '<em><b>DGraph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DPREDICATE__DGRAPH = eINSTANCE.getDPredicate_DGraph();

		/**
		 * The meta object literal for the '<em><b>Visualization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DPREDICATE__VISUALIZATION = eINSTANCE.getDPredicate_Visualization();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DPREDICATE__ICON = eINSTANCE.getDPredicate_Icon();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DOffsetImpl <em>DOffset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DOffsetImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDOffset()
		 * @generated
		 */
		EClass DOFFSET = eINSTANCE.getDOffset();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOFFSET__OFFSET = eINSTANCE.getDOffset_Offset();

		/**
		 * The meta object literal for the '<em><b>Len</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOFFSET__LEN = eINSTANCE.getDOffset_Len();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOFFSET__INDEX = eINSTANCE.getDOffset_Index();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DSignatureImpl <em>DSignature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DSignatureImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDSignature()
		 * @generated
		 */
		EClass DSIGNATURE = eINSTANCE.getDSignature();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSIGNATURE__SIGNATURE = eINSTANCE.getDSignature_Signature();

		/**
		 * The meta object literal for the '<em><b>DPredicates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSIGNATURE__DPREDICATES = eINSTANCE.getDSignature_DPredicates();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.VisualizationImpl <em>Visualization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.VisualizationImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getVisualization()
		 * @generated
		 */
		EClass VISUALIZATION = eINSTANCE.getVisualization();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISUALIZATION__TYPE = eINSTANCE.getVisualization_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUALIZATION__SOURCE = eINSTANCE.getVisualization_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VISUALIZATION__TARGET = eINSTANCE.getVisualization_Target();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.impl.DElementImpl <em>DElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.impl.DElementImpl
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getDElement()
		 * @generated
		 */
		EClass DELEMENT = eINSTANCE.getDElement();

		/**
		 * The meta object literal for the '<em><b>Constraints From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEMENT__CONSTRAINTS_FROM = eINSTANCE.getDElement_ConstraintsFrom();

		/**
		 * The meta object literal for the '<em><b>Constraints To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELEMENT__CONSTRAINTS_TO = eINSTANCE.getDElement_ConstraintsTo();

		/**
		 * The meta object literal for the '{@link no.hib.dpf.diagram.VisualizationType <em>Visualization Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see no.hib.dpf.diagram.VisualizationType
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getVisualizationType()
		 * @generated
		 */
		EEnum VISUALIZATION_TYPE = eINSTANCE.getVisualizationType();

		/**
		 * The meta object literal for the '<em>EDimension</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.draw2d.geometry.Dimension
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getEDimension()
		 * @generated
		 */
		EDataType EDIMENSION = eINSTANCE.getEDimension();

		/**
		 * The meta object literal for the '<em>ELocation</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.draw2d.geometry.Point
		 * @see no.hib.dpf.diagram.impl.DiagramPackageImpl#getELocation()
		 * @generated
		 */
		EDataType ELOCATION = eINSTANCE.getELocation();

	}

} //DiagramPackage
