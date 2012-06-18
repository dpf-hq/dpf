/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import no.hib.dpf.text.tdpf.*;

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
public class TdpfFactoryImpl extends EFactoryImpl implements TdpfFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TdpfFactory init()
  {
    try
    {
      TdpfFactory theTdpfFactory = (TdpfFactory)EPackage.Registry.INSTANCE.getEFactory("http://no.hib.dpf/dpf-text"); 
      if (theTdpfFactory != null)
      {
        return theTdpfFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TdpfFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TdpfFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TdpfPackage.MODEL: return createModel();
      case TdpfPackage.COMMAND: return createCommand();
      case TdpfPackage.MAKE_EMF: return createMakeEmf();
      case TdpfPackage.MAKE_ECORE: return createMakeEcore();
      case TdpfPackage.MAKE_IMAGE: return createMakeImage();
      case TdpfPackage.SIMPLE_EVO_SPAN: return createSimpleEvoSpan();
      case TdpfPackage.SIMPLE_EVO_COSPAN: return createSimpleEvoCospan();
      case TdpfPackage.EVO_SPAN: return createEvoSpan();
      case TdpfPackage.EVO_COSPAN: return createEvoCospan();
      case TdpfPackage.INSTANCE_SPECIFICATION: return createInstanceSpecification();
      case TdpfPackage.CHOOSEN_SPECFICATION: return createChoosenSpecfication();
      case TdpfPackage.CONSTRAINT_SEMANTIC: return createConstraintSemantic();
      case TdpfPackage.SPECIFICATION: return createSpecification();
      case TdpfPackage.CHOOSEN_SPECIFICATION: return createChoosenSpecification();
      case TdpfPackage.CHOOSEN_CONSTRAINT_SEMANTIC: return createChoosenConstraintSemantic();
      case TdpfPackage.CONSTRAINT: return createConstraint();
      case TdpfPackage.CONSTRAINT_SIGNATURE: return createConstraintSignature();
      case TdpfPackage.MORPHISM: return createMorphism();
      case TdpfPackage.DOMAIN: return createDomain();
      case TdpfPackage.CODOMAIN: return createCodomain();
      case TdpfPackage.MAPPING: return createMapping();
      case TdpfPackage.MAPPING_NODE: return createMappingNode();
      case TdpfPackage.MAPPING_ARROW: return createMappingArrow();
      case TdpfPackage.EXT_SUB_TGRAPH: return createExtSubTGraph();
      case TdpfPackage.CHOOSEN_EXT_SUB_TGRAPH: return createChoosenExtSubTGraph();
      case TdpfPackage.GRAPH: return createGraph();
      case TdpfPackage.ELEMENT: return createElement();
      case TdpfPackage.ARROWS: return createArrows();
      case TdpfPackage.ARROW: return createArrow();
      case TdpfPackage.NODE: return createNode();
      case TdpfPackage.ATTRIBUTE_VALUE: return createAttributeValue();
      case TdpfPackage.DPF_ID: return createDpfId();
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
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TdpfPackage.DATA_TYPE:
        return createDataTypeFromString(eDataType, initialValue);
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
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TdpfPackage.DATA_TYPE:
        return convertDataTypeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Command createCommand()
  {
    CommandImpl command = new CommandImpl();
    return command;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MakeEmf createMakeEmf()
  {
    MakeEmfImpl makeEmf = new MakeEmfImpl();
    return makeEmf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MakeEcore createMakeEcore()
  {
    MakeEcoreImpl makeEcore = new MakeEcoreImpl();
    return makeEcore;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MakeImage createMakeImage()
  {
    MakeImageImpl makeImage = new MakeImageImpl();
    return makeImage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleEvoSpan createSimpleEvoSpan()
  {
    SimpleEvoSpanImpl simpleEvoSpan = new SimpleEvoSpanImpl();
    return simpleEvoSpan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleEvoCospan createSimpleEvoCospan()
  {
    SimpleEvoCospanImpl simpleEvoCospan = new SimpleEvoCospanImpl();
    return simpleEvoCospan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EvoSpan createEvoSpan()
  {
    EvoSpanImpl evoSpan = new EvoSpanImpl();
    return evoSpan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EvoCospan createEvoCospan()
  {
    EvoCospanImpl evoCospan = new EvoCospanImpl();
    return evoCospan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InstanceSpecification createInstanceSpecification()
  {
    InstanceSpecificationImpl instanceSpecification = new InstanceSpecificationImpl();
    return instanceSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoosenSpecfication createChoosenSpecfication()
  {
    ChoosenSpecficationImpl choosenSpecfication = new ChoosenSpecficationImpl();
    return choosenSpecfication;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintSemantic createConstraintSemantic()
  {
    ConstraintSemanticImpl constraintSemantic = new ConstraintSemanticImpl();
    return constraintSemantic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Specification createSpecification()
  {
    SpecificationImpl specification = new SpecificationImpl();
    return specification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoosenSpecification createChoosenSpecification()
  {
    ChoosenSpecificationImpl choosenSpecification = new ChoosenSpecificationImpl();
    return choosenSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoosenConstraintSemantic createChoosenConstraintSemantic()
  {
    ChoosenConstraintSemanticImpl choosenConstraintSemantic = new ChoosenConstraintSemanticImpl();
    return choosenConstraintSemantic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constraint createConstraint()
  {
    ConstraintImpl constraint = new ConstraintImpl();
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintSignature createConstraintSignature()
  {
    ConstraintSignatureImpl constraintSignature = new ConstraintSignatureImpl();
    return constraintSignature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Morphism createMorphism()
  {
    MorphismImpl morphism = new MorphismImpl();
    return morphism;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Domain createDomain()
  {
    DomainImpl domain = new DomainImpl();
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Codomain createCodomain()
  {
    CodomainImpl codomain = new CodomainImpl();
    return codomain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mapping createMapping()
  {
    MappingImpl mapping = new MappingImpl();
    return mapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingNode createMappingNode()
  {
    MappingNodeImpl mappingNode = new MappingNodeImpl();
    return mappingNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingArrow createMappingArrow()
  {
    MappingArrowImpl mappingArrow = new MappingArrowImpl();
    return mappingArrow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtSubTGraph createExtSubTGraph()
  {
    ExtSubTGraphImpl extSubTGraph = new ExtSubTGraphImpl();
    return extSubTGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoosenExtSubTGraph createChoosenExtSubTGraph()
  {
    ChoosenExtSubTGraphImpl choosenExtSubTGraph = new ChoosenExtSubTGraphImpl();
    return choosenExtSubTGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Graph createGraph()
  {
    GraphImpl graph = new GraphImpl();
    return graph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element createElement()
  {
    ElementImpl element = new ElementImpl();
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arrows createArrows()
  {
    ArrowsImpl arrows = new ArrowsImpl();
    return arrows;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Arrow createArrow()
  {
    ArrowImpl arrow = new ArrowImpl();
    return arrow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node createNode()
  {
    NodeImpl node = new NodeImpl();
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeValue createAttributeValue()
  {
    AttributeValueImpl attributeValue = new AttributeValueImpl();
    return attributeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DpfId createDpfId()
  {
    DpfIdImpl dpfId = new DpfIdImpl();
    return dpfId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataTypeFromString(EDataType eDataType, String initialValue)
  {
    DataType result = DataType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDataTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TdpfPackage getTdpfPackage()
  {
    return (TdpfPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TdpfPackage getPackage()
  {
    return TdpfPackage.eINSTANCE;
  }

} //TdpfFactoryImpl
