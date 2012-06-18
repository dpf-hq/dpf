/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see no.hib.dpf.text.tdpf.TdpfFactory
 * @model kind="package"
 * @generated
 */
public interface TdpfPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tdpf";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://no.hib.dpf/dpf-text";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "tdpf";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TdpfPackage eINSTANCE = no.hib.dpf.text.tdpf.impl.TdpfPackageImpl.init();

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ModelImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__COMMANDS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.CommandImpl <em>Command</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.CommandImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getCommand()
   * @generated
   */
  int COMMAND = 1;

  /**
   * The number of structural features of the '<em>Command</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMAND_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.MakeEmfImpl <em>Make Emf</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.MakeEmfImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMakeEmf()
   * @generated
   */
  int MAKE_EMF = 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAKE_EMF__ID = COMMAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Make Emf</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAKE_EMF_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.MakeEcoreImpl <em>Make Ecore</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.MakeEcoreImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMakeEcore()
   * @generated
   */
  int MAKE_ECORE = 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAKE_ECORE__ID = COMMAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Make Ecore</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAKE_ECORE_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.MakeImageImpl <em>Make Image</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.MakeImageImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMakeImage()
   * @generated
   */
  int MAKE_IMAGE = 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAKE_IMAGE__ID = COMMAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Make Image</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAKE_IMAGE_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.SimpleEvoSpanImpl <em>Simple Evo Span</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.SimpleEvoSpanImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getSimpleEvoSpan()
   * @generated
   */
  int SIMPLE_EVO_SPAN = 5;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_SPAN__LHS = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Diff</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_SPAN__DIFF = COMMAND_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rh S</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_SPAN__RH_S = COMMAND_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type Graph</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_SPAN__TYPE_GRAPH = COMMAND_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Simple Evo Span</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_SPAN_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.SimpleEvoCospanImpl <em>Simple Evo Cospan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.SimpleEvoCospanImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getSimpleEvoCospan()
   * @generated
   */
  int SIMPLE_EVO_COSPAN = 6;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_COSPAN__LHS = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Joint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_COSPAN__JOINT = COMMAND_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_COSPAN__RHS = COMMAND_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type Graph</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_COSPAN__TYPE_GRAPH = COMMAND_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Simple Evo Cospan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_EVO_COSPAN_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.EvoSpanImpl <em>Evo Span</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.EvoSpanImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getEvoSpan()
   * @generated
   */
  int EVO_SPAN = 7;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVO_SPAN__LHS = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVO_SPAN__RHS = COMMAND_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type Graph</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVO_SPAN__TYPE_GRAPH = COMMAND_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Evo Span</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVO_SPAN_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.EvoCospanImpl <em>Evo Cospan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.EvoCospanImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getEvoCospan()
   * @generated
   */
  int EVO_COSPAN = 8;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVO_COSPAN__LHS = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVO_COSPAN__RHS = COMMAND_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type Graph</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVO_COSPAN__TYPE_GRAPH = COMMAND_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Evo Cospan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVO_COSPAN_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.InstanceSpecificationImpl <em>Instance Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.InstanceSpecificationImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getInstanceSpecification()
   * @generated
   */
  int INSTANCE_SPECIFICATION = 9;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_SPECIFICATION__ID = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_SPECIFICATION__MODEL = COMMAND_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Metamodel</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_SPECIFICATION__METAMODEL = COMMAND_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Constraint Semantics</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_SPECIFICATION__CONSTRAINT_SEMANTICS = COMMAND_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Instance Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_SPECIFICATION_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ChoosenSpecficationImpl <em>Choosen Specfication</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ChoosenSpecficationImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getChoosenSpecfication()
   * @generated
   */
  int CHOOSEN_SPECFICATION = 10;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOOSEN_SPECFICATION__ID = 0;

  /**
   * The number of structural features of the '<em>Choosen Specfication</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOOSEN_SPECFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ConstraintSemanticImpl <em>Constraint Semantic</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ConstraintSemanticImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getConstraintSemantic()
   * @generated
   */
  int CONSTRAINT_SEMANTIC = 11;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SEMANTIC__ID = 0;

  /**
   * The feature id for the '<em><b>Arrows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SEMANTIC__ARROWS = 1;

  /**
   * The feature id for the '<em><b>Ocl</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SEMANTIC__OCL = 2;

  /**
   * The number of structural features of the '<em>Constraint Semantic</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SEMANTIC_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.SpecificationImpl <em>Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.SpecificationImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getSpecification()
   * @generated
   */
  int SPECIFICATION = 12;

  /**
   * The feature id for the '<em><b>Commands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__COMMANDS = MODEL__COMMANDS;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__TYPE = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sequence Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__SEQUENCE_NUMBER = MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Graph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__GRAPH = MODEL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Constaint Semantic</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__CONSTAINT_SEMANTIC = MODEL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION__CONSTRAINTS = MODEL_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_FEATURE_COUNT = MODEL_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ChoosenSpecificationImpl <em>Choosen Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ChoosenSpecificationImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getChoosenSpecification()
   * @generated
   */
  int CHOOSEN_SPECIFICATION = 13;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOOSEN_SPECIFICATION__ID = 0;

  /**
   * The number of structural features of the '<em>Choosen Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOOSEN_SPECIFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ChoosenConstraintSemanticImpl <em>Choosen Constraint Semantic</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ChoosenConstraintSemanticImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getChoosenConstraintSemantic()
   * @generated
   */
  int CHOOSEN_CONSTRAINT_SEMANTIC = 14;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOOSEN_CONSTRAINT_SEMANTIC__ID = 0;

  /**
   * The number of structural features of the '<em>Choosen Constraint Semantic</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOOSEN_CONSTRAINT_SEMANTIC_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ConstraintImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getConstraint()
   * @generated
   */
  int CONSTRAINT = 15;

  /**
   * The feature id for the '<em><b>Signature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__SIGNATURE = 0;

  /**
   * The feature id for the '<em><b>Arrows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__ARROWS = 1;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ConstraintSignatureImpl <em>Constraint Signature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ConstraintSignatureImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getConstraintSignature()
   * @generated
   */
  int CONSTRAINT_SIGNATURE = 16;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SIGNATURE__ID = 0;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SIGNATURE__PARAMETER = 1;

  /**
   * The number of structural features of the '<em>Constraint Signature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_SIGNATURE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.MorphismImpl <em>Morphism</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.MorphismImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMorphism()
   * @generated
   */
  int MORPHISM = 17;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORPHISM__DOMAIN = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Codmain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORPHISM__CODMAIN = COMMAND_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORPHISM__MAPPINGS = COMMAND_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Morphism</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORPHISM_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.DomainImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 18;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN__ID = 0;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.CodomainImpl <em>Codomain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.CodomainImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getCodomain()
   * @generated
   */
  int CODOMAIN = 19;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODOMAIN__ID = 0;

  /**
   * The number of structural features of the '<em>Codomain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODOMAIN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.MappingImpl <em>Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.MappingImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMapping()
   * @generated
   */
  int MAPPING = 20;

  /**
   * The number of structural features of the '<em>Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.MappingNodeImpl <em>Mapping Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.MappingNodeImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMappingNode()
   * @generated
   */
  int MAPPING_NODE = 21;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_NODE__DOMAIN = MAPPING_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Codomain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_NODE__CODOMAIN = MAPPING_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Mapping Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_NODE_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.MappingArrowImpl <em>Mapping Arrow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.MappingArrowImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMappingArrow()
   * @generated
   */
  int MAPPING_ARROW = 22;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_ARROW__DOMAIN = MAPPING_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Codmain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_ARROW__CODMAIN = MAPPING_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Mapping Arrow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAPPING_ARROW_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ExtSubTGraphImpl <em>Ext Sub TGraph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ExtSubTGraphImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getExtSubTGraph()
   * @generated
   */
  int EXT_SUB_TGRAPH = 23;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXT_SUB_TGRAPH__ID = COMMAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Extends Graph</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXT_SUB_TGRAPH__EXTENDS_GRAPH = COMMAND_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXT_SUB_TGRAPH__ELEMENTS = COMMAND_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Ext Sub TGraph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXT_SUB_TGRAPH_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ChoosenExtSubTGraphImpl <em>Choosen Ext Sub TGraph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ChoosenExtSubTGraphImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getChoosenExtSubTGraph()
   * @generated
   */
  int CHOOSEN_EXT_SUB_TGRAPH = 24;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOOSEN_EXT_SUB_TGRAPH__ID = 0;

  /**
   * The number of structural features of the '<em>Choosen Ext Sub TGraph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOOSEN_EXT_SUB_TGRAPH_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.GraphImpl <em>Graph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.GraphImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getGraph()
   * @generated
   */
  int GRAPH = 25;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Graph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GRAPH_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ElementImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 26;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__ID = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__TYPE = 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ArrowsImpl <em>Arrows</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ArrowsImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getArrows()
   * @generated
   */
  int ARROWS = 27;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROWS__ID = ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROWS__TYPE = ELEMENT__TYPE;

  /**
   * The feature id for the '<em><b>Sr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROWS__SR = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Next</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROWS__NEXT = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Arrows</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROWS_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.ArrowImpl <em>Arrow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.ArrowImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getArrow()
   * @generated
   */
  int ARROW = 28;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW__ID = ARROWS__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW__TYPE = ARROWS__TYPE;

  /**
   * The feature id for the '<em><b>Sr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW__SR = ARROWS__SR;

  /**
   * The feature id for the '<em><b>Next</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW__NEXT = ARROWS__NEXT;

  /**
   * The feature id for the '<em><b>Tg Data Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW__TG_DATA_TYPE = ARROWS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Tg Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW__TG_VALUE = ARROWS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Tg Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW__TG_NODE = ARROWS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Arrow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARROW_FEATURE_COUNT = ARROWS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.NodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.NodeImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getNode()
   * @generated
   */
  int NODE = 29;

  /**
   * The feature id for the '<em><b>Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__ID = ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__TYPE = ELEMENT__TYPE;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.AttributeValueImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getAttributeValue()
   * @generated
   */
  int ATTRIBUTE_VALUE = 30;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE__VALUE = 0;

  /**
   * The number of structural features of the '<em>Attribute Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.impl.DpfIdImpl <em>Dpf Id</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.impl.DpfIdImpl
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getDpfId()
   * @generated
   */
  int DPF_ID = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DPF_ID__NAME = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DPF_ID__ID = 1;

  /**
   * The number of structural features of the '<em>Dpf Id</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DPF_ID_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link no.hib.dpf.text.tdpf.DataType <em>Data Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see no.hib.dpf.text.tdpf.DataType
   * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getDataType()
   * @generated
   */
  int DATA_TYPE = 32;


  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see no.hib.dpf.text.tdpf.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link no.hib.dpf.text.tdpf.Model#getCommands <em>Commands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Commands</em>'.
   * @see no.hib.dpf.text.tdpf.Model#getCommands()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Commands();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Command <em>Command</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Command</em>'.
   * @see no.hib.dpf.text.tdpf.Command
   * @generated
   */
  EClass getCommand();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.MakeEmf <em>Make Emf</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Make Emf</em>'.
   * @see no.hib.dpf.text.tdpf.MakeEmf
   * @generated
   */
  EClass getMakeEmf();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.MakeEmf#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.MakeEmf#getId()
   * @see #getMakeEmf()
   * @generated
   */
  EAttribute getMakeEmf_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.MakeEcore <em>Make Ecore</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Make Ecore</em>'.
   * @see no.hib.dpf.text.tdpf.MakeEcore
   * @generated
   */
  EClass getMakeEcore();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.MakeEcore#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.MakeEcore#getId()
   * @see #getMakeEcore()
   * @generated
   */
  EAttribute getMakeEcore_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.MakeImage <em>Make Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Make Image</em>'.
   * @see no.hib.dpf.text.tdpf.MakeImage
   * @generated
   */
  EClass getMakeImage();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.MakeImage#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.MakeImage#getId()
   * @see #getMakeImage()
   * @generated
   */
  EAttribute getMakeImage_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.SimpleEvoSpan <em>Simple Evo Span</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Evo Span</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoSpan
   * @generated
   */
  EClass getSimpleEvoSpan();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.SimpleEvoSpan#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lhs</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoSpan#getLhs()
   * @see #getSimpleEvoSpan()
   * @generated
   */
  EAttribute getSimpleEvoSpan_Lhs();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.SimpleEvoSpan#getDiff <em>Diff</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Diff</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoSpan#getDiff()
   * @see #getSimpleEvoSpan()
   * @generated
   */
  EAttribute getSimpleEvoSpan_Diff();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.SimpleEvoSpan#getRhS <em>Rh S</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rh S</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoSpan#getRhS()
   * @see #getSimpleEvoSpan()
   * @generated
   */
  EAttribute getSimpleEvoSpan_RhS();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.SimpleEvoSpan#getTypeGraph <em>Type Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Graph</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoSpan#getTypeGraph()
   * @see #getSimpleEvoSpan()
   * @generated
   */
  EAttribute getSimpleEvoSpan_TypeGraph();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.SimpleEvoCospan <em>Simple Evo Cospan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Evo Cospan</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoCospan
   * @generated
   */
  EClass getSimpleEvoCospan();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.SimpleEvoCospan#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lhs</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoCospan#getLhs()
   * @see #getSimpleEvoCospan()
   * @generated
   */
  EAttribute getSimpleEvoCospan_Lhs();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.SimpleEvoCospan#getJoint <em>Joint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Joint</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoCospan#getJoint()
   * @see #getSimpleEvoCospan()
   * @generated
   */
  EAttribute getSimpleEvoCospan_Joint();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.SimpleEvoCospan#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rhs</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoCospan#getRhs()
   * @see #getSimpleEvoCospan()
   * @generated
   */
  EAttribute getSimpleEvoCospan_Rhs();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.SimpleEvoCospan#getTypeGraph <em>Type Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Graph</em>'.
   * @see no.hib.dpf.text.tdpf.SimpleEvoCospan#getTypeGraph()
   * @see #getSimpleEvoCospan()
   * @generated
   */
  EAttribute getSimpleEvoCospan_TypeGraph();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.EvoSpan <em>Evo Span</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Evo Span</em>'.
   * @see no.hib.dpf.text.tdpf.EvoSpan
   * @generated
   */
  EClass getEvoSpan();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.EvoSpan#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lhs</em>'.
   * @see no.hib.dpf.text.tdpf.EvoSpan#getLhs()
   * @see #getEvoSpan()
   * @generated
   */
  EAttribute getEvoSpan_Lhs();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.EvoSpan#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rhs</em>'.
   * @see no.hib.dpf.text.tdpf.EvoSpan#getRhs()
   * @see #getEvoSpan()
   * @generated
   */
  EAttribute getEvoSpan_Rhs();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.EvoSpan#getTypeGraph <em>Type Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Graph</em>'.
   * @see no.hib.dpf.text.tdpf.EvoSpan#getTypeGraph()
   * @see #getEvoSpan()
   * @generated
   */
  EAttribute getEvoSpan_TypeGraph();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.EvoCospan <em>Evo Cospan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Evo Cospan</em>'.
   * @see no.hib.dpf.text.tdpf.EvoCospan
   * @generated
   */
  EClass getEvoCospan();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.EvoCospan#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lhs</em>'.
   * @see no.hib.dpf.text.tdpf.EvoCospan#getLhs()
   * @see #getEvoCospan()
   * @generated
   */
  EAttribute getEvoCospan_Lhs();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.EvoCospan#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rhs</em>'.
   * @see no.hib.dpf.text.tdpf.EvoCospan#getRhs()
   * @see #getEvoCospan()
   * @generated
   */
  EAttribute getEvoCospan_Rhs();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.EvoCospan#getTypeGraph <em>Type Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Graph</em>'.
   * @see no.hib.dpf.text.tdpf.EvoCospan#getTypeGraph()
   * @see #getEvoCospan()
   * @generated
   */
  EAttribute getEvoCospan_TypeGraph();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.InstanceSpecification <em>Instance Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Specification</em>'.
   * @see no.hib.dpf.text.tdpf.InstanceSpecification
   * @generated
   */
  EClass getInstanceSpecification();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.InstanceSpecification#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.InstanceSpecification#getId()
   * @see #getInstanceSpecification()
   * @generated
   */
  EAttribute getInstanceSpecification_Id();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.InstanceSpecification#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model</em>'.
   * @see no.hib.dpf.text.tdpf.InstanceSpecification#getModel()
   * @see #getInstanceSpecification()
   * @generated
   */
  EReference getInstanceSpecification_Model();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.InstanceSpecification#getMetamodel <em>Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Metamodel</em>'.
   * @see no.hib.dpf.text.tdpf.InstanceSpecification#getMetamodel()
   * @see #getInstanceSpecification()
   * @generated
   */
  EReference getInstanceSpecification_Metamodel();

  /**
   * Returns the meta object for the containment reference list '{@link no.hib.dpf.text.tdpf.InstanceSpecification#getConstraintSemantics <em>Constraint Semantics</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Semantics</em>'.
   * @see no.hib.dpf.text.tdpf.InstanceSpecification#getConstraintSemantics()
   * @see #getInstanceSpecification()
   * @generated
   */
  EReference getInstanceSpecification_ConstraintSemantics();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.ChoosenSpecfication <em>Choosen Specfication</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choosen Specfication</em>'.
   * @see no.hib.dpf.text.tdpf.ChoosenSpecfication
   * @generated
   */
  EClass getChoosenSpecfication();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.ChoosenSpecfication#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.ChoosenSpecfication#getId()
   * @see #getChoosenSpecfication()
   * @generated
   */
  EAttribute getChoosenSpecfication_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.ConstraintSemantic <em>Constraint Semantic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint Semantic</em>'.
   * @see no.hib.dpf.text.tdpf.ConstraintSemantic
   * @generated
   */
  EClass getConstraintSemantic();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.ConstraintSemantic#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.ConstraintSemantic#getId()
   * @see #getConstraintSemantic()
   * @generated
   */
  EReference getConstraintSemantic_Id();

  /**
   * Returns the meta object for the containment reference list '{@link no.hib.dpf.text.tdpf.ConstraintSemantic#getArrows <em>Arrows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arrows</em>'.
   * @see no.hib.dpf.text.tdpf.ConstraintSemantic#getArrows()
   * @see #getConstraintSemantic()
   * @generated
   */
  EReference getConstraintSemantic_Arrows();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.ConstraintSemantic#getOcl <em>Ocl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ocl</em>'.
   * @see no.hib.dpf.text.tdpf.ConstraintSemantic#getOcl()
   * @see #getConstraintSemantic()
   * @generated
   */
  EAttribute getConstraintSemantic_Ocl();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification</em>'.
   * @see no.hib.dpf.text.tdpf.Specification
   * @generated
   */
  EClass getSpecification();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Specification#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see no.hib.dpf.text.tdpf.Specification#getType()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Type();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.Specification#getSequenceNumber <em>Sequence Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Sequence Number</em>'.
   * @see no.hib.dpf.text.tdpf.Specification#getSequenceNumber()
   * @see #getSpecification()
   * @generated
   */
  EAttribute getSpecification_SequenceNumber();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Specification#getGraph <em>Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Graph</em>'.
   * @see no.hib.dpf.text.tdpf.Specification#getGraph()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Graph();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Specification#getConstaintSemantic <em>Constaint Semantic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constaint Semantic</em>'.
   * @see no.hib.dpf.text.tdpf.Specification#getConstaintSemantic()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_ConstaintSemantic();

  /**
   * Returns the meta object for the containment reference list '{@link no.hib.dpf.text.tdpf.Specification#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraints</em>'.
   * @see no.hib.dpf.text.tdpf.Specification#getConstraints()
   * @see #getSpecification()
   * @generated
   */
  EReference getSpecification_Constraints();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.ChoosenSpecification <em>Choosen Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choosen Specification</em>'.
   * @see no.hib.dpf.text.tdpf.ChoosenSpecification
   * @generated
   */
  EClass getChoosenSpecification();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.ChoosenSpecification#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.ChoosenSpecification#getId()
   * @see #getChoosenSpecification()
   * @generated
   */
  EAttribute getChoosenSpecification_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.ChoosenConstraintSemantic <em>Choosen Constraint Semantic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choosen Constraint Semantic</em>'.
   * @see no.hib.dpf.text.tdpf.ChoosenConstraintSemantic
   * @generated
   */
  EClass getChoosenConstraintSemantic();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.ChoosenConstraintSemantic#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.ChoosenConstraintSemantic#getId()
   * @see #getChoosenConstraintSemantic()
   * @generated
   */
  EAttribute getChoosenConstraintSemantic_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see no.hib.dpf.text.tdpf.Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Constraint#getSignature <em>Signature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Signature</em>'.
   * @see no.hib.dpf.text.tdpf.Constraint#getSignature()
   * @see #getConstraint()
   * @generated
   */
  EReference getConstraint_Signature();

  /**
   * Returns the meta object for the containment reference list '{@link no.hib.dpf.text.tdpf.Constraint#getArrows <em>Arrows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arrows</em>'.
   * @see no.hib.dpf.text.tdpf.Constraint#getArrows()
   * @see #getConstraint()
   * @generated
   */
  EReference getConstraint_Arrows();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.ConstraintSignature <em>Constraint Signature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint Signature</em>'.
   * @see no.hib.dpf.text.tdpf.ConstraintSignature
   * @generated
   */
  EClass getConstraintSignature();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.ConstraintSignature#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.ConstraintSignature#getId()
   * @see #getConstraintSignature()
   * @generated
   */
  EReference getConstraintSignature_Id();

  /**
   * Returns the meta object for the attribute list '{@link no.hib.dpf.text.tdpf.ConstraintSignature#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Parameter</em>'.
   * @see no.hib.dpf.text.tdpf.ConstraintSignature#getParameter()
   * @see #getConstraintSignature()
   * @generated
   */
  EAttribute getConstraintSignature_Parameter();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Morphism <em>Morphism</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Morphism</em>'.
   * @see no.hib.dpf.text.tdpf.Morphism
   * @generated
   */
  EClass getMorphism();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Morphism#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see no.hib.dpf.text.tdpf.Morphism#getDomain()
   * @see #getMorphism()
   * @generated
   */
  EReference getMorphism_Domain();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Morphism#getCodmain <em>Codmain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Codmain</em>'.
   * @see no.hib.dpf.text.tdpf.Morphism#getCodmain()
   * @see #getMorphism()
   * @generated
   */
  EReference getMorphism_Codmain();

  /**
   * Returns the meta object for the containment reference list '{@link no.hib.dpf.text.tdpf.Morphism#getMappings <em>Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mappings</em>'.
   * @see no.hib.dpf.text.tdpf.Morphism#getMappings()
   * @see #getMorphism()
   * @generated
   */
  EReference getMorphism_Mappings();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see no.hib.dpf.text.tdpf.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.Domain#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.Domain#getId()
   * @see #getDomain()
   * @generated
   */
  EAttribute getDomain_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Codomain <em>Codomain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Codomain</em>'.
   * @see no.hib.dpf.text.tdpf.Codomain
   * @generated
   */
  EClass getCodomain();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.Codomain#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.Codomain#getId()
   * @see #getCodomain()
   * @generated
   */
  EAttribute getCodomain_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mapping</em>'.
   * @see no.hib.dpf.text.tdpf.Mapping
   * @generated
   */
  EClass getMapping();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.MappingNode <em>Mapping Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mapping Node</em>'.
   * @see no.hib.dpf.text.tdpf.MappingNode
   * @generated
   */
  EClass getMappingNode();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.MappingNode#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see no.hib.dpf.text.tdpf.MappingNode#getDomain()
   * @see #getMappingNode()
   * @generated
   */
  EReference getMappingNode_Domain();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.MappingNode#getCodomain <em>Codomain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Codomain</em>'.
   * @see no.hib.dpf.text.tdpf.MappingNode#getCodomain()
   * @see #getMappingNode()
   * @generated
   */
  EReference getMappingNode_Codomain();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.MappingArrow <em>Mapping Arrow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mapping Arrow</em>'.
   * @see no.hib.dpf.text.tdpf.MappingArrow
   * @generated
   */
  EClass getMappingArrow();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.MappingArrow#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see no.hib.dpf.text.tdpf.MappingArrow#getDomain()
   * @see #getMappingArrow()
   * @generated
   */
  EReference getMappingArrow_Domain();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.MappingArrow#getCodmain <em>Codmain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Codmain</em>'.
   * @see no.hib.dpf.text.tdpf.MappingArrow#getCodmain()
   * @see #getMappingArrow()
   * @generated
   */
  EReference getMappingArrow_Codmain();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.ExtSubTGraph <em>Ext Sub TGraph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ext Sub TGraph</em>'.
   * @see no.hib.dpf.text.tdpf.ExtSubTGraph
   * @generated
   */
  EClass getExtSubTGraph();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.ExtSubTGraph#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.ExtSubTGraph#getId()
   * @see #getExtSubTGraph()
   * @generated
   */
  EAttribute getExtSubTGraph_Id();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.ExtSubTGraph#getExtendsGraph <em>Extends Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Extends Graph</em>'.
   * @see no.hib.dpf.text.tdpf.ExtSubTGraph#getExtendsGraph()
   * @see #getExtSubTGraph()
   * @generated
   */
  EReference getExtSubTGraph_ExtendsGraph();

  /**
   * Returns the meta object for the containment reference list '{@link no.hib.dpf.text.tdpf.ExtSubTGraph#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see no.hib.dpf.text.tdpf.ExtSubTGraph#getElements()
   * @see #getExtSubTGraph()
   * @generated
   */
  EReference getExtSubTGraph_Elements();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.ChoosenExtSubTGraph <em>Choosen Ext Sub TGraph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choosen Ext Sub TGraph</em>'.
   * @see no.hib.dpf.text.tdpf.ChoosenExtSubTGraph
   * @generated
   */
  EClass getChoosenExtSubTGraph();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.ChoosenExtSubTGraph#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.ChoosenExtSubTGraph#getId()
   * @see #getChoosenExtSubTGraph()
   * @generated
   */
  EAttribute getChoosenExtSubTGraph_Id();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Graph <em>Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Graph</em>'.
   * @see no.hib.dpf.text.tdpf.Graph
   * @generated
   */
  EClass getGraph();

  /**
   * Returns the meta object for the containment reference list '{@link no.hib.dpf.text.tdpf.Graph#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see no.hib.dpf.text.tdpf.Graph#getElements()
   * @see #getGraph()
   * @generated
   */
  EReference getGraph_Elements();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see no.hib.dpf.text.tdpf.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Element#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.Element#getId()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Id();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Element#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see no.hib.dpf.text.tdpf.Element#getType()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Type();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Arrows <em>Arrows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arrows</em>'.
   * @see no.hib.dpf.text.tdpf.Arrows
   * @generated
   */
  EClass getArrows();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Arrows#getSr <em>Sr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sr</em>'.
   * @see no.hib.dpf.text.tdpf.Arrows#getSr()
   * @see #getArrows()
   * @generated
   */
  EReference getArrows_Sr();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Arrows#getNext <em>Next</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Next</em>'.
   * @see no.hib.dpf.text.tdpf.Arrows#getNext()
   * @see #getArrows()
   * @generated
   */
  EReference getArrows_Next();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Arrow <em>Arrow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arrow</em>'.
   * @see no.hib.dpf.text.tdpf.Arrow
   * @generated
   */
  EClass getArrow();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.Arrow#getTgDataType <em>Tg Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tg Data Type</em>'.
   * @see no.hib.dpf.text.tdpf.Arrow#getTgDataType()
   * @see #getArrow()
   * @generated
   */
  EAttribute getArrow_TgDataType();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Arrow#getTgValue <em>Tg Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tg Value</em>'.
   * @see no.hib.dpf.text.tdpf.Arrow#getTgValue()
   * @see #getArrow()
   * @generated
   */
  EReference getArrow_TgValue();

  /**
   * Returns the meta object for the containment reference '{@link no.hib.dpf.text.tdpf.Arrow#getTgNode <em>Tg Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tg Node</em>'.
   * @see no.hib.dpf.text.tdpf.Arrow#getTgNode()
   * @see #getArrow()
   * @generated
   */
  EReference getArrow_TgNode();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see no.hib.dpf.text.tdpf.Node
   * @generated
   */
  EClass getNode();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.AttributeValue <em>Attribute Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Value</em>'.
   * @see no.hib.dpf.text.tdpf.AttributeValue
   * @generated
   */
  EClass getAttributeValue();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.AttributeValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see no.hib.dpf.text.tdpf.AttributeValue#getValue()
   * @see #getAttributeValue()
   * @generated
   */
  EAttribute getAttributeValue_Value();

  /**
   * Returns the meta object for class '{@link no.hib.dpf.text.tdpf.DpfId <em>Dpf Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dpf Id</em>'.
   * @see no.hib.dpf.text.tdpf.DpfId
   * @generated
   */
  EClass getDpfId();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.DpfId#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see no.hib.dpf.text.tdpf.DpfId#getName()
   * @see #getDpfId()
   * @generated
   */
  EAttribute getDpfId_Name();

  /**
   * Returns the meta object for the attribute '{@link no.hib.dpf.text.tdpf.DpfId#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see no.hib.dpf.text.tdpf.DpfId#getId()
   * @see #getDpfId()
   * @generated
   */
  EAttribute getDpfId_Id();

  /**
   * Returns the meta object for enum '{@link no.hib.dpf.text.tdpf.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Data Type</em>'.
   * @see no.hib.dpf.text.tdpf.DataType
   * @generated
   */
  EEnum getDataType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TdpfFactory getTdpfFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ModelImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__COMMANDS = eINSTANCE.getModel_Commands();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.CommandImpl <em>Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.CommandImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getCommand()
     * @generated
     */
    EClass COMMAND = eINSTANCE.getCommand();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.MakeEmfImpl <em>Make Emf</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.MakeEmfImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMakeEmf()
     * @generated
     */
    EClass MAKE_EMF = eINSTANCE.getMakeEmf();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAKE_EMF__ID = eINSTANCE.getMakeEmf_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.MakeEcoreImpl <em>Make Ecore</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.MakeEcoreImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMakeEcore()
     * @generated
     */
    EClass MAKE_ECORE = eINSTANCE.getMakeEcore();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAKE_ECORE__ID = eINSTANCE.getMakeEcore_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.MakeImageImpl <em>Make Image</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.MakeImageImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMakeImage()
     * @generated
     */
    EClass MAKE_IMAGE = eINSTANCE.getMakeImage();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAKE_IMAGE__ID = eINSTANCE.getMakeImage_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.SimpleEvoSpanImpl <em>Simple Evo Span</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.SimpleEvoSpanImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getSimpleEvoSpan()
     * @generated
     */
    EClass SIMPLE_EVO_SPAN = eINSTANCE.getSimpleEvoSpan();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EVO_SPAN__LHS = eINSTANCE.getSimpleEvoSpan_Lhs();

    /**
     * The meta object literal for the '<em><b>Diff</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EVO_SPAN__DIFF = eINSTANCE.getSimpleEvoSpan_Diff();

    /**
     * The meta object literal for the '<em><b>Rh S</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EVO_SPAN__RH_S = eINSTANCE.getSimpleEvoSpan_RhS();

    /**
     * The meta object literal for the '<em><b>Type Graph</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EVO_SPAN__TYPE_GRAPH = eINSTANCE.getSimpleEvoSpan_TypeGraph();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.SimpleEvoCospanImpl <em>Simple Evo Cospan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.SimpleEvoCospanImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getSimpleEvoCospan()
     * @generated
     */
    EClass SIMPLE_EVO_COSPAN = eINSTANCE.getSimpleEvoCospan();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EVO_COSPAN__LHS = eINSTANCE.getSimpleEvoCospan_Lhs();

    /**
     * The meta object literal for the '<em><b>Joint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EVO_COSPAN__JOINT = eINSTANCE.getSimpleEvoCospan_Joint();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EVO_COSPAN__RHS = eINSTANCE.getSimpleEvoCospan_Rhs();

    /**
     * The meta object literal for the '<em><b>Type Graph</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_EVO_COSPAN__TYPE_GRAPH = eINSTANCE.getSimpleEvoCospan_TypeGraph();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.EvoSpanImpl <em>Evo Span</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.EvoSpanImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getEvoSpan()
     * @generated
     */
    EClass EVO_SPAN = eINSTANCE.getEvoSpan();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVO_SPAN__LHS = eINSTANCE.getEvoSpan_Lhs();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVO_SPAN__RHS = eINSTANCE.getEvoSpan_Rhs();

    /**
     * The meta object literal for the '<em><b>Type Graph</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVO_SPAN__TYPE_GRAPH = eINSTANCE.getEvoSpan_TypeGraph();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.EvoCospanImpl <em>Evo Cospan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.EvoCospanImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getEvoCospan()
     * @generated
     */
    EClass EVO_COSPAN = eINSTANCE.getEvoCospan();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVO_COSPAN__LHS = eINSTANCE.getEvoCospan_Lhs();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVO_COSPAN__RHS = eINSTANCE.getEvoCospan_Rhs();

    /**
     * The meta object literal for the '<em><b>Type Graph</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVO_COSPAN__TYPE_GRAPH = eINSTANCE.getEvoCospan_TypeGraph();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.InstanceSpecificationImpl <em>Instance Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.InstanceSpecificationImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getInstanceSpecification()
     * @generated
     */
    EClass INSTANCE_SPECIFICATION = eINSTANCE.getInstanceSpecification();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE_SPECIFICATION__ID = eINSTANCE.getInstanceSpecification_Id();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_SPECIFICATION__MODEL = eINSTANCE.getInstanceSpecification_Model();

    /**
     * The meta object literal for the '<em><b>Metamodel</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_SPECIFICATION__METAMODEL = eINSTANCE.getInstanceSpecification_Metamodel();

    /**
     * The meta object literal for the '<em><b>Constraint Semantics</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_SPECIFICATION__CONSTRAINT_SEMANTICS = eINSTANCE.getInstanceSpecification_ConstraintSemantics();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ChoosenSpecficationImpl <em>Choosen Specfication</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ChoosenSpecficationImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getChoosenSpecfication()
     * @generated
     */
    EClass CHOOSEN_SPECFICATION = eINSTANCE.getChoosenSpecfication();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOOSEN_SPECFICATION__ID = eINSTANCE.getChoosenSpecfication_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ConstraintSemanticImpl <em>Constraint Semantic</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ConstraintSemanticImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getConstraintSemantic()
     * @generated
     */
    EClass CONSTRAINT_SEMANTIC = eINSTANCE.getConstraintSemantic();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_SEMANTIC__ID = eINSTANCE.getConstraintSemantic_Id();

    /**
     * The meta object literal for the '<em><b>Arrows</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_SEMANTIC__ARROWS = eINSTANCE.getConstraintSemantic_Arrows();

    /**
     * The meta object literal for the '<em><b>Ocl</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT_SEMANTIC__OCL = eINSTANCE.getConstraintSemantic_Ocl();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.SpecificationImpl <em>Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.SpecificationImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getSpecification()
     * @generated
     */
    EClass SPECIFICATION = eINSTANCE.getSpecification();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__TYPE = eINSTANCE.getSpecification_Type();

    /**
     * The meta object literal for the '<em><b>Sequence Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPECIFICATION__SEQUENCE_NUMBER = eINSTANCE.getSpecification_SequenceNumber();

    /**
     * The meta object literal for the '<em><b>Graph</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__GRAPH = eINSTANCE.getSpecification_Graph();

    /**
     * The meta object literal for the '<em><b>Constaint Semantic</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__CONSTAINT_SEMANTIC = eINSTANCE.getSpecification_ConstaintSemantic();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION__CONSTRAINTS = eINSTANCE.getSpecification_Constraints();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ChoosenSpecificationImpl <em>Choosen Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ChoosenSpecificationImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getChoosenSpecification()
     * @generated
     */
    EClass CHOOSEN_SPECIFICATION = eINSTANCE.getChoosenSpecification();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOOSEN_SPECIFICATION__ID = eINSTANCE.getChoosenSpecification_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ChoosenConstraintSemanticImpl <em>Choosen Constraint Semantic</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ChoosenConstraintSemanticImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getChoosenConstraintSemantic()
     * @generated
     */
    EClass CHOOSEN_CONSTRAINT_SEMANTIC = eINSTANCE.getChoosenConstraintSemantic();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOOSEN_CONSTRAINT_SEMANTIC__ID = eINSTANCE.getChoosenConstraintSemantic_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ConstraintImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getConstraint()
     * @generated
     */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
     * The meta object literal for the '<em><b>Signature</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT__SIGNATURE = eINSTANCE.getConstraint_Signature();

    /**
     * The meta object literal for the '<em><b>Arrows</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT__ARROWS = eINSTANCE.getConstraint_Arrows();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ConstraintSignatureImpl <em>Constraint Signature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ConstraintSignatureImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getConstraintSignature()
     * @generated
     */
    EClass CONSTRAINT_SIGNATURE = eINSTANCE.getConstraintSignature();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_SIGNATURE__ID = eINSTANCE.getConstraintSignature_Id();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT_SIGNATURE__PARAMETER = eINSTANCE.getConstraintSignature_Parameter();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.MorphismImpl <em>Morphism</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.MorphismImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMorphism()
     * @generated
     */
    EClass MORPHISM = eINSTANCE.getMorphism();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MORPHISM__DOMAIN = eINSTANCE.getMorphism_Domain();

    /**
     * The meta object literal for the '<em><b>Codmain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MORPHISM__CODMAIN = eINSTANCE.getMorphism_Codmain();

    /**
     * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MORPHISM__MAPPINGS = eINSTANCE.getMorphism_Mappings();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.DomainImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = eINSTANCE.getDomain();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN__ID = eINSTANCE.getDomain_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.CodomainImpl <em>Codomain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.CodomainImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getCodomain()
     * @generated
     */
    EClass CODOMAIN = eINSTANCE.getCodomain();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODOMAIN__ID = eINSTANCE.getCodomain_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.MappingImpl <em>Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.MappingImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMapping()
     * @generated
     */
    EClass MAPPING = eINSTANCE.getMapping();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.MappingNodeImpl <em>Mapping Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.MappingNodeImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMappingNode()
     * @generated
     */
    EClass MAPPING_NODE = eINSTANCE.getMappingNode();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING_NODE__DOMAIN = eINSTANCE.getMappingNode_Domain();

    /**
     * The meta object literal for the '<em><b>Codomain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING_NODE__CODOMAIN = eINSTANCE.getMappingNode_Codomain();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.MappingArrowImpl <em>Mapping Arrow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.MappingArrowImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getMappingArrow()
     * @generated
     */
    EClass MAPPING_ARROW = eINSTANCE.getMappingArrow();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING_ARROW__DOMAIN = eINSTANCE.getMappingArrow_Domain();

    /**
     * The meta object literal for the '<em><b>Codmain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAPPING_ARROW__CODMAIN = eINSTANCE.getMappingArrow_Codmain();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ExtSubTGraphImpl <em>Ext Sub TGraph</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ExtSubTGraphImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getExtSubTGraph()
     * @generated
     */
    EClass EXT_SUB_TGRAPH = eINSTANCE.getExtSubTGraph();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXT_SUB_TGRAPH__ID = eINSTANCE.getExtSubTGraph_Id();

    /**
     * The meta object literal for the '<em><b>Extends Graph</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXT_SUB_TGRAPH__EXTENDS_GRAPH = eINSTANCE.getExtSubTGraph_ExtendsGraph();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXT_SUB_TGRAPH__ELEMENTS = eINSTANCE.getExtSubTGraph_Elements();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ChoosenExtSubTGraphImpl <em>Choosen Ext Sub TGraph</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ChoosenExtSubTGraphImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getChoosenExtSubTGraph()
     * @generated
     */
    EClass CHOOSEN_EXT_SUB_TGRAPH = eINSTANCE.getChoosenExtSubTGraph();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOOSEN_EXT_SUB_TGRAPH__ID = eINSTANCE.getChoosenExtSubTGraph_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.GraphImpl <em>Graph</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.GraphImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getGraph()
     * @generated
     */
    EClass GRAPH = eINSTANCE.getGraph();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GRAPH__ELEMENTS = eINSTANCE.getGraph_Elements();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ElementImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__ID = eINSTANCE.getElement_Id();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__TYPE = eINSTANCE.getElement_Type();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ArrowsImpl <em>Arrows</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ArrowsImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getArrows()
     * @generated
     */
    EClass ARROWS = eINSTANCE.getArrows();

    /**
     * The meta object literal for the '<em><b>Sr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARROWS__SR = eINSTANCE.getArrows_Sr();

    /**
     * The meta object literal for the '<em><b>Next</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARROWS__NEXT = eINSTANCE.getArrows_Next();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.ArrowImpl <em>Arrow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.ArrowImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getArrow()
     * @generated
     */
    EClass ARROW = eINSTANCE.getArrow();

    /**
     * The meta object literal for the '<em><b>Tg Data Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARROW__TG_DATA_TYPE = eINSTANCE.getArrow_TgDataType();

    /**
     * The meta object literal for the '<em><b>Tg Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARROW__TG_VALUE = eINSTANCE.getArrow_TgValue();

    /**
     * The meta object literal for the '<em><b>Tg Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARROW__TG_NODE = eINSTANCE.getArrow_TgNode();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.NodeImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getNode()
     * @generated
     */
    EClass NODE = eINSTANCE.getNode();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.AttributeValueImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getAttributeValue()
     * @generated
     */
    EClass ATTRIBUTE_VALUE = eINSTANCE.getAttributeValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE_VALUE__VALUE = eINSTANCE.getAttributeValue_Value();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.impl.DpfIdImpl <em>Dpf Id</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.impl.DpfIdImpl
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getDpfId()
     * @generated
     */
    EClass DPF_ID = eINSTANCE.getDpfId();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DPF_ID__NAME = eINSTANCE.getDpfId_Name();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DPF_ID__ID = eINSTANCE.getDpfId_Id();

    /**
     * The meta object literal for the '{@link no.hib.dpf.text.tdpf.DataType <em>Data Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see no.hib.dpf.text.tdpf.DataType
     * @see no.hib.dpf.text.tdpf.impl.TdpfPackageImpl#getDataType()
     * @generated
     */
    EEnum DATA_TYPE = eINSTANCE.getDataType();

  }

} //TdpfPackage
