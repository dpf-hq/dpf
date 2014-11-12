/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.impl;

import no.hib.dpf.text.tdpf.Arrow;
import no.hib.dpf.text.tdpf.Arrows;
import no.hib.dpf.text.tdpf.AttributeValue;
import no.hib.dpf.text.tdpf.ChoosenConstraintSemantic;
import no.hib.dpf.text.tdpf.ChoosenExtSubTGraph;
import no.hib.dpf.text.tdpf.ChoosenSpecification;
import no.hib.dpf.text.tdpf.Codomain;
import no.hib.dpf.text.tdpf.Command;
import no.hib.dpf.text.tdpf.Constraint;
import no.hib.dpf.text.tdpf.ConstraintSemantic;
import no.hib.dpf.text.tdpf.ConstraintSignature;
import no.hib.dpf.text.tdpf.DataType;
import no.hib.dpf.text.tdpf.Domain;
import no.hib.dpf.text.tdpf.DpfId;
import no.hib.dpf.text.tdpf.Element;
import no.hib.dpf.text.tdpf.EvoCospan;
import no.hib.dpf.text.tdpf.EvoSpan;
import no.hib.dpf.text.tdpf.ExtSubTGraph;
import no.hib.dpf.text.tdpf.Graph;
import no.hib.dpf.text.tdpf.MakeEcore;
import no.hib.dpf.text.tdpf.MakeEmf;
import no.hib.dpf.text.tdpf.MakeImage;
import no.hib.dpf.text.tdpf.Mapping;
import no.hib.dpf.text.tdpf.MappingArrow;
import no.hib.dpf.text.tdpf.MappingNode;
import no.hib.dpf.text.tdpf.Model;
import no.hib.dpf.text.tdpf.Morphism;
import no.hib.dpf.text.tdpf.Node;
import no.hib.dpf.text.tdpf.SequenceNumber;
import no.hib.dpf.text.tdpf.Signature;
import no.hib.dpf.text.tdpf.SimpleEvoCospan;
import no.hib.dpf.text.tdpf.SimpleEvoSpan;
import no.hib.dpf.text.tdpf.Specification;
import no.hib.dpf.text.tdpf.TdpfFactory;
import no.hib.dpf.text.tdpf.TdpfPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TdpfPackageImpl extends EPackageImpl implements TdpfPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass makeEmfEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass makeEcoreEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass makeImageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleEvoSpanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleEvoCospanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass evoSpanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass evoCospanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choosenSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceNumberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choosenConstraintSemanticEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintSignatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signatureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintSemanticEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass morphismEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass domainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codomainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mappingArrowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extSubTGraphEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choosenExtSubTGraphEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass graphEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrowsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dpfIdEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum dataTypeEEnum = null;

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
   * @see no.hib.dpf.text.tdpf.TdpfPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TdpfPackageImpl()
  {
    super(eNS_URI, TdpfFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TdpfPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TdpfPackage init()
  {
    if (isInited) return (TdpfPackage)EPackage.Registry.INSTANCE.getEPackage(TdpfPackage.eNS_URI);

    // Obtain or create and register package
    TdpfPackageImpl theTdpfPackage = (TdpfPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TdpfPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TdpfPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTdpfPackage.createPackageContents();

    // Initialize created meta-data
    theTdpfPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTdpfPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TdpfPackage.eNS_URI, theTdpfPackage);
    return theTdpfPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Commands()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommand()
  {
    return commandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMakeEmf()
  {
    return makeEmfEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMakeEmf_Id()
  {
    return (EAttribute)makeEmfEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMakeEcore()
  {
    return makeEcoreEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMakeEcore_Id()
  {
    return (EAttribute)makeEcoreEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMakeImage()
  {
    return makeImageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMakeImage_Id()
  {
    return (EAttribute)makeImageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleEvoSpan()
  {
    return simpleEvoSpanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleEvoSpan_Lhs()
  {
    return (EAttribute)simpleEvoSpanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleEvoSpan_Diff()
  {
    return (EAttribute)simpleEvoSpanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleEvoSpan_RhS()
  {
    return (EAttribute)simpleEvoSpanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleEvoSpan_TypeGraph()
  {
    return (EAttribute)simpleEvoSpanEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleEvoCospan()
  {
    return simpleEvoCospanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleEvoCospan_Lhs()
  {
    return (EAttribute)simpleEvoCospanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleEvoCospan_Joint()
  {
    return (EAttribute)simpleEvoCospanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleEvoCospan_Rhs()
  {
    return (EAttribute)simpleEvoCospanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleEvoCospan_TypeGraph()
  {
    return (EAttribute)simpleEvoCospanEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvoSpan()
  {
    return evoSpanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvoSpan_Lhs()
  {
    return (EAttribute)evoSpanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvoSpan_Rhs()
  {
    return (EAttribute)evoSpanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvoSpan_TypeGraph()
  {
    return (EAttribute)evoSpanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvoCospan()
  {
    return evoCospanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvoCospan_Lhs()
  {
    return (EAttribute)evoCospanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvoCospan_Rhs()
  {
    return (EAttribute)evoCospanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvoCospan_TypeGraph()
  {
    return (EAttribute)evoCospanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecification()
  {
    return specificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_Type()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_ConstraintSemantic()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_SequenceNumber()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_Graph()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_Constraints()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoosenSpecification()
  {
    return choosenSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChoosenSpecification_Id()
  {
    return (EAttribute)choosenSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequenceNumber()
  {
    return sequenceNumberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSequenceNumber_NextNumber()
  {
    return (EAttribute)sequenceNumberEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoosenConstraintSemantic()
  {
    return choosenConstraintSemanticEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChoosenConstraintSemantic_Id()
  {
    return (EAttribute)choosenConstraintSemanticEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraint()
  {
    return constraintEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraint_Signature()
  {
    return (EReference)constraintEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraint_Arrows()
  {
    return (EReference)constraintEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintSignature()
  {
    return constraintSignatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintSignature_Id()
  {
    return (EReference)constraintSignatureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstraintSignature_Parameter()
  {
    return (EAttribute)constraintSignatureEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignature()
  {
    return signatureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignature_ConstraintSemantics()
  {
    return (EReference)signatureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintSemantic()
  {
    return constraintSemanticEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintSemantic_Id()
  {
    return (EReference)constraintSemanticEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintSemantic_Arrows()
  {
    return (EReference)constraintSemanticEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstraintSemantic_Ocl()
  {
    return (EAttribute)constraintSemanticEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMorphism()
  {
    return morphismEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMorphism_Domain()
  {
    return (EReference)morphismEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMorphism_Codmain()
  {
    return (EReference)morphismEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMorphism_Mappings()
  {
    return (EReference)morphismEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDomain()
  {
    return domainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDomain_Id()
  {
    return (EAttribute)domainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCodomain()
  {
    return codomainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCodomain_Id()
  {
    return (EAttribute)codomainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMapping()
  {
    return mappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingNode()
  {
    return mappingNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingNode_Domain()
  {
    return (EReference)mappingNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingNode_Codomain()
  {
    return (EReference)mappingNodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMappingArrow()
  {
    return mappingArrowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingArrow_Domain()
  {
    return (EReference)mappingArrowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMappingArrow_Codmain()
  {
    return (EReference)mappingArrowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtSubTGraph()
  {
    return extSubTGraphEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtSubTGraph_Id()
  {
    return (EAttribute)extSubTGraphEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtSubTGraph_ExtendsGraph()
  {
    return (EReference)extSubTGraphEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtSubTGraph_Elements()
  {
    return (EReference)extSubTGraphEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoosenExtSubTGraph()
  {
    return choosenExtSubTGraphEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getChoosenExtSubTGraph_Id()
  {
    return (EAttribute)choosenExtSubTGraphEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGraph()
  {
    return graphEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGraph_Elements()
  {
    return (EReference)graphEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElement()
  {
    return elementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElement_Id()
  {
    return (EReference)elementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElement_Type()
  {
    return (EReference)elementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrows()
  {
    return arrowsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrows_Sr()
  {
    return (EReference)arrowsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrows_Next()
  {
    return (EReference)arrowsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrow()
  {
    return arrowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getArrow_TgDataType()
  {
    return (EAttribute)arrowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrow_TgValue()
  {
    return (EReference)arrowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrow_TgNode()
  {
    return (EReference)arrowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNode()
  {
    return nodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeValue()
  {
    return attributeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttributeValue_Value()
  {
    return (EAttribute)attributeValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDpfId()
  {
    return dpfIdEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDpfId_Name()
  {
    return (EAttribute)dpfIdEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDpfId_Id()
  {
    return (EAttribute)dpfIdEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getDataType()
  {
    return dataTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TdpfFactory getTdpfFactory()
  {
    return (TdpfFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__COMMANDS);

    commandEClass = createEClass(COMMAND);

    makeEmfEClass = createEClass(MAKE_EMF);
    createEAttribute(makeEmfEClass, MAKE_EMF__ID);

    makeEcoreEClass = createEClass(MAKE_ECORE);
    createEAttribute(makeEcoreEClass, MAKE_ECORE__ID);

    makeImageEClass = createEClass(MAKE_IMAGE);
    createEAttribute(makeImageEClass, MAKE_IMAGE__ID);

    simpleEvoSpanEClass = createEClass(SIMPLE_EVO_SPAN);
    createEAttribute(simpleEvoSpanEClass, SIMPLE_EVO_SPAN__LHS);
    createEAttribute(simpleEvoSpanEClass, SIMPLE_EVO_SPAN__DIFF);
    createEAttribute(simpleEvoSpanEClass, SIMPLE_EVO_SPAN__RH_S);
    createEAttribute(simpleEvoSpanEClass, SIMPLE_EVO_SPAN__TYPE_GRAPH);

    simpleEvoCospanEClass = createEClass(SIMPLE_EVO_COSPAN);
    createEAttribute(simpleEvoCospanEClass, SIMPLE_EVO_COSPAN__LHS);
    createEAttribute(simpleEvoCospanEClass, SIMPLE_EVO_COSPAN__JOINT);
    createEAttribute(simpleEvoCospanEClass, SIMPLE_EVO_COSPAN__RHS);
    createEAttribute(simpleEvoCospanEClass, SIMPLE_EVO_COSPAN__TYPE_GRAPH);

    evoSpanEClass = createEClass(EVO_SPAN);
    createEAttribute(evoSpanEClass, EVO_SPAN__LHS);
    createEAttribute(evoSpanEClass, EVO_SPAN__RHS);
    createEAttribute(evoSpanEClass, EVO_SPAN__TYPE_GRAPH);

    evoCospanEClass = createEClass(EVO_COSPAN);
    createEAttribute(evoCospanEClass, EVO_COSPAN__LHS);
    createEAttribute(evoCospanEClass, EVO_COSPAN__RHS);
    createEAttribute(evoCospanEClass, EVO_COSPAN__TYPE_GRAPH);

    specificationEClass = createEClass(SPECIFICATION);
    createEReference(specificationEClass, SPECIFICATION__TYPE);
    createEReference(specificationEClass, SPECIFICATION__CONSTRAINT_SEMANTIC);
    createEReference(specificationEClass, SPECIFICATION__SEQUENCE_NUMBER);
    createEReference(specificationEClass, SPECIFICATION__GRAPH);
    createEReference(specificationEClass, SPECIFICATION__CONSTRAINTS);

    choosenSpecificationEClass = createEClass(CHOOSEN_SPECIFICATION);
    createEAttribute(choosenSpecificationEClass, CHOOSEN_SPECIFICATION__ID);

    sequenceNumberEClass = createEClass(SEQUENCE_NUMBER);
    createEAttribute(sequenceNumberEClass, SEQUENCE_NUMBER__NEXT_NUMBER);

    choosenConstraintSemanticEClass = createEClass(CHOOSEN_CONSTRAINT_SEMANTIC);
    createEAttribute(choosenConstraintSemanticEClass, CHOOSEN_CONSTRAINT_SEMANTIC__ID);

    constraintEClass = createEClass(CONSTRAINT);
    createEReference(constraintEClass, CONSTRAINT__SIGNATURE);
    createEReference(constraintEClass, CONSTRAINT__ARROWS);

    constraintSignatureEClass = createEClass(CONSTRAINT_SIGNATURE);
    createEReference(constraintSignatureEClass, CONSTRAINT_SIGNATURE__ID);
    createEAttribute(constraintSignatureEClass, CONSTRAINT_SIGNATURE__PARAMETER);

    signatureEClass = createEClass(SIGNATURE);
    createEReference(signatureEClass, SIGNATURE__CONSTRAINT_SEMANTICS);

    constraintSemanticEClass = createEClass(CONSTRAINT_SEMANTIC);
    createEReference(constraintSemanticEClass, CONSTRAINT_SEMANTIC__ID);
    createEReference(constraintSemanticEClass, CONSTRAINT_SEMANTIC__ARROWS);
    createEAttribute(constraintSemanticEClass, CONSTRAINT_SEMANTIC__OCL);

    morphismEClass = createEClass(MORPHISM);
    createEReference(morphismEClass, MORPHISM__DOMAIN);
    createEReference(morphismEClass, MORPHISM__CODMAIN);
    createEReference(morphismEClass, MORPHISM__MAPPINGS);

    domainEClass = createEClass(DOMAIN);
    createEAttribute(domainEClass, DOMAIN__ID);

    codomainEClass = createEClass(CODOMAIN);
    createEAttribute(codomainEClass, CODOMAIN__ID);

    mappingEClass = createEClass(MAPPING);

    mappingNodeEClass = createEClass(MAPPING_NODE);
    createEReference(mappingNodeEClass, MAPPING_NODE__DOMAIN);
    createEReference(mappingNodeEClass, MAPPING_NODE__CODOMAIN);

    mappingArrowEClass = createEClass(MAPPING_ARROW);
    createEReference(mappingArrowEClass, MAPPING_ARROW__DOMAIN);
    createEReference(mappingArrowEClass, MAPPING_ARROW__CODMAIN);

    extSubTGraphEClass = createEClass(EXT_SUB_TGRAPH);
    createEAttribute(extSubTGraphEClass, EXT_SUB_TGRAPH__ID);
    createEReference(extSubTGraphEClass, EXT_SUB_TGRAPH__EXTENDS_GRAPH);
    createEReference(extSubTGraphEClass, EXT_SUB_TGRAPH__ELEMENTS);

    choosenExtSubTGraphEClass = createEClass(CHOOSEN_EXT_SUB_TGRAPH);
    createEAttribute(choosenExtSubTGraphEClass, CHOOSEN_EXT_SUB_TGRAPH__ID);

    graphEClass = createEClass(GRAPH);
    createEReference(graphEClass, GRAPH__ELEMENTS);

    elementEClass = createEClass(ELEMENT);
    createEReference(elementEClass, ELEMENT__ID);
    createEReference(elementEClass, ELEMENT__TYPE);

    arrowsEClass = createEClass(ARROWS);
    createEReference(arrowsEClass, ARROWS__SR);
    createEReference(arrowsEClass, ARROWS__NEXT);

    arrowEClass = createEClass(ARROW);
    createEAttribute(arrowEClass, ARROW__TG_DATA_TYPE);
    createEReference(arrowEClass, ARROW__TG_VALUE);
    createEReference(arrowEClass, ARROW__TG_NODE);

    nodeEClass = createEClass(NODE);

    attributeValueEClass = createEClass(ATTRIBUTE_VALUE);
    createEAttribute(attributeValueEClass, ATTRIBUTE_VALUE__VALUE);

    dpfIdEClass = createEClass(DPF_ID);
    createEAttribute(dpfIdEClass, DPF_ID__NAME);
    createEAttribute(dpfIdEClass, DPF_ID__ID);

    // Create enums
    dataTypeEEnum = createEEnum(DATA_TYPE);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    makeEmfEClass.getESuperTypes().add(this.getCommand());
    makeEcoreEClass.getESuperTypes().add(this.getCommand());
    makeImageEClass.getESuperTypes().add(this.getCommand());
    simpleEvoSpanEClass.getESuperTypes().add(this.getCommand());
    simpleEvoCospanEClass.getESuperTypes().add(this.getCommand());
    evoSpanEClass.getESuperTypes().add(this.getCommand());
    evoCospanEClass.getESuperTypes().add(this.getCommand());
    specificationEClass.getESuperTypes().add(this.getModel());
    signatureEClass.getESuperTypes().add(this.getModel());
    morphismEClass.getESuperTypes().add(this.getCommand());
    mappingNodeEClass.getESuperTypes().add(this.getMapping());
    mappingArrowEClass.getESuperTypes().add(this.getMapping());
    extSubTGraphEClass.getESuperTypes().add(this.getCommand());
    arrowsEClass.getESuperTypes().add(this.getElement());
    arrowEClass.getESuperTypes().add(this.getArrows());
    nodeEClass.getESuperTypes().add(this.getElement());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Commands(), this.getCommand(), null, "commands", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commandEClass, Command.class, "Command", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(makeEmfEClass, MakeEmf.class, "MakeEmf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMakeEmf_Id(), ecorePackage.getEString(), "id", null, 0, 1, MakeEmf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(makeEcoreEClass, MakeEcore.class, "MakeEcore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMakeEcore_Id(), ecorePackage.getEString(), "id", null, 0, 1, MakeEcore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(makeImageEClass, MakeImage.class, "MakeImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMakeImage_Id(), ecorePackage.getEString(), "id", null, 0, 1, MakeImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleEvoSpanEClass, SimpleEvoSpan.class, "SimpleEvoSpan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleEvoSpan_Lhs(), ecorePackage.getEString(), "lhs", null, 0, 1, SimpleEvoSpan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleEvoSpan_Diff(), ecorePackage.getEString(), "diff", null, 0, 1, SimpleEvoSpan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleEvoSpan_RhS(), ecorePackage.getEString(), "rhS", null, 0, 1, SimpleEvoSpan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleEvoSpan_TypeGraph(), ecorePackage.getEString(), "typeGraph", null, 0, 1, SimpleEvoSpan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleEvoCospanEClass, SimpleEvoCospan.class, "SimpleEvoCospan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleEvoCospan_Lhs(), ecorePackage.getEString(), "lhs", null, 0, 1, SimpleEvoCospan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleEvoCospan_Joint(), ecorePackage.getEString(), "joint", null, 0, 1, SimpleEvoCospan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleEvoCospan_Rhs(), ecorePackage.getEString(), "rhs", null, 0, 1, SimpleEvoCospan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleEvoCospan_TypeGraph(), ecorePackage.getEString(), "typeGraph", null, 0, 1, SimpleEvoCospan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(evoSpanEClass, EvoSpan.class, "EvoSpan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEvoSpan_Lhs(), ecorePackage.getEString(), "lhs", null, 0, 1, EvoSpan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEvoSpan_Rhs(), ecorePackage.getEString(), "rhs", null, 0, 1, EvoSpan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEvoSpan_TypeGraph(), ecorePackage.getEString(), "typeGraph", null, 0, 1, EvoSpan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(evoCospanEClass, EvoCospan.class, "EvoCospan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEvoCospan_Lhs(), ecorePackage.getEString(), "lhs", null, 0, 1, EvoCospan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEvoCospan_Rhs(), ecorePackage.getEString(), "rhs", null, 0, 1, EvoCospan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEvoCospan_TypeGraph(), ecorePackage.getEString(), "typeGraph", null, 0, 1, EvoCospan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specificationEClass, Specification.class, "Specification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSpecification_Type(), this.getChoosenSpecification(), null, "type", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecification_ConstraintSemantic(), this.getChoosenConstraintSemantic(), null, "constraintSemantic", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecification_SequenceNumber(), this.getSequenceNumber(), null, "sequenceNumber", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecification_Graph(), this.getGraph(), null, "graph", null, 0, 1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSpecification_Constraints(), this.getConstraint(), null, "constraints", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choosenSpecificationEClass, ChoosenSpecification.class, "ChoosenSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChoosenSpecification_Id(), ecorePackage.getEString(), "id", null, 0, 1, ChoosenSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceNumberEClass, SequenceNumber.class, "SequenceNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSequenceNumber_NextNumber(), ecorePackage.getEInt(), "nextNumber", null, 0, 1, SequenceNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choosenConstraintSemanticEClass, ChoosenConstraintSemantic.class, "ChoosenConstraintSemantic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChoosenConstraintSemantic_Id(), ecorePackage.getEString(), "id", null, 0, 1, ChoosenConstraintSemantic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstraint_Signature(), this.getConstraintSignature(), null, "signature", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstraint_Arrows(), this.getArrows(), null, "arrows", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constraintSignatureEClass, ConstraintSignature.class, "ConstraintSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstraintSignature_Id(), this.getDpfId(), null, "id", null, 0, 1, ConstraintSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstraintSignature_Parameter(), ecorePackage.getEString(), "parameter", null, 0, -1, ConstraintSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(signatureEClass, Signature.class, "Signature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSignature_ConstraintSemantics(), this.getConstraintSemantic(), null, "constraintSemantics", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constraintSemanticEClass, ConstraintSemantic.class, "ConstraintSemantic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstraintSemantic_Id(), this.getDpfId(), null, "id", null, 0, 1, ConstraintSemantic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstraintSemantic_Arrows(), this.getArrows(), null, "arrows", null, 0, -1, ConstraintSemantic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstraintSemantic_Ocl(), ecorePackage.getEString(), "ocl", null, 0, 1, ConstraintSemantic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(morphismEClass, Morphism.class, "Morphism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMorphism_Domain(), this.getDomain(), null, "domain", null, 0, 1, Morphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMorphism_Codmain(), this.getCodomain(), null, "codmain", null, 0, 1, Morphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMorphism_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, Morphism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDomain_Id(), ecorePackage.getEString(), "id", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(codomainEClass, Codomain.class, "Codomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCodomain_Id(), ecorePackage.getEString(), "id", null, 0, 1, Codomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mappingNodeEClass, MappingNode.class, "MappingNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMappingNode_Domain(), this.getNode(), null, "domain", null, 0, 1, MappingNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMappingNode_Codomain(), this.getNode(), null, "codomain", null, 0, 1, MappingNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(mappingArrowEClass, MappingArrow.class, "MappingArrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMappingArrow_Domain(), this.getArrow(), null, "domain", null, 0, 1, MappingArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMappingArrow_Codmain(), this.getArrow(), null, "codmain", null, 0, 1, MappingArrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(extSubTGraphEClass, ExtSubTGraph.class, "ExtSubTGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExtSubTGraph_Id(), ecorePackage.getEString(), "id", null, 0, 1, ExtSubTGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExtSubTGraph_ExtendsGraph(), this.getChoosenExtSubTGraph(), null, "extendsGraph", null, 0, 1, ExtSubTGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExtSubTGraph_Elements(), this.getElement(), null, "elements", null, 0, -1, ExtSubTGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choosenExtSubTGraphEClass, ChoosenExtSubTGraph.class, "ChoosenExtSubTGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getChoosenExtSubTGraph_Id(), ecorePackage.getEString(), "id", null, 0, 1, ChoosenExtSubTGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(graphEClass, Graph.class, "Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGraph_Elements(), this.getElement(), null, "elements", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElement_Id(), this.getDpfId(), null, "id", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElement_Type(), this.getDpfId(), null, "type", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrowsEClass, Arrows.class, "Arrows", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrows_Sr(), this.getNode(), null, "sr", null, 0, 1, Arrows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrows_Next(), this.getArrows(), null, "next", null, 0, 1, Arrows.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrowEClass, Arrow.class, "Arrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getArrow_TgDataType(), this.getDataType(), "tgDataType", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrow_TgValue(), this.getAttributeValue(), null, "tgValue", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrow_TgNode(), this.getNode(), null, "tgNode", null, 0, 1, Arrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeValueEClass, AttributeValue.class, "AttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttributeValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dpfIdEClass, DpfId.class, "DpfId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDpfId_Name(), ecorePackage.getEString(), "name", null, 0, 1, DpfId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDpfId_Id(), ecorePackage.getEInt(), "id", null, 0, 1, DpfId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(dataTypeEEnum, DataType.class, "DataType");
    addEEnumLiteral(dataTypeEEnum, DataType.TBOOLEAN);
    addEEnumLiteral(dataTypeEEnum, DataType.TCHAR);
    addEEnumLiteral(dataTypeEEnum, DataType.TBYTE);
    addEEnumLiteral(dataTypeEEnum, DataType.TSHORT);
    addEEnumLiteral(dataTypeEEnum, DataType.TINT);
    addEEnumLiteral(dataTypeEEnum, DataType.TLONG);
    addEEnumLiteral(dataTypeEEnum, DataType.TFLOAT);
    addEEnumLiteral(dataTypeEEnum, DataType.TDOUBLE);
    addEEnumLiteral(dataTypeEEnum, DataType.TSTRING);

    // Create resource
    createResource(eNS_URI);
  }

} //TdpfPackageImpl
