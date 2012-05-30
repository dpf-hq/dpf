/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.util;

import no.hib.dpf.text.tdpf.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.text.tdpf.TdpfPackage
 * @generated
 */
public class TdpfAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TdpfPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TdpfAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TdpfPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TdpfSwitch<Adapter> modelSwitch =
    new TdpfSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseDefinition(Definition object)
      {
        return createDefinitionAdapter();
      }
      @Override
      public Adapter caseMakeEmf(MakeEmf object)
      {
        return createMakeEmfAdapter();
      }
      @Override
      public Adapter caseMakeEcore(MakeEcore object)
      {
        return createMakeEcoreAdapter();
      }
      @Override
      public Adapter caseMakeImage(MakeImage object)
      {
        return createMakeImageAdapter();
      }
      @Override
      public Adapter caseSimpleEvoSpan(SimpleEvoSpan object)
      {
        return createSimpleEvoSpanAdapter();
      }
      @Override
      public Adapter caseSimpleEvoCospan(SimpleEvoCospan object)
      {
        return createSimpleEvoCospanAdapter();
      }
      @Override
      public Adapter caseEvoSpan(EvoSpan object)
      {
        return createEvoSpanAdapter();
      }
      @Override
      public Adapter caseEvoCospan(EvoCospan object)
      {
        return createEvoCospanAdapter();
      }
      @Override
      public Adapter caseInstanceSpecification(InstanceSpecification object)
      {
        return createInstanceSpecificationAdapter();
      }
      @Override
      public Adapter caseChoosenSpecfication(ChoosenSpecfication object)
      {
        return createChoosenSpecficationAdapter();
      }
      @Override
      public Adapter caseConstraintSemantic(ConstraintSemantic object)
      {
        return createConstraintSemanticAdapter();
      }
      @Override
      public Adapter caseSpecification(Specification object)
      {
        return createSpecificationAdapter();
      }
      @Override
      public Adapter caseChoosenGraph(ChoosenGraph object)
      {
        return createChoosenGraphAdapter();
      }
      @Override
      public Adapter caseConstraint(Constraint object)
      {
        return createConstraintAdapter();
      }
      @Override
      public Adapter caseConstraintSignature(ConstraintSignature object)
      {
        return createConstraintSignatureAdapter();
      }
      @Override
      public Adapter caseMorphism(Morphism object)
      {
        return createMorphismAdapter();
      }
      @Override
      public Adapter caseDomain(Domain object)
      {
        return createDomainAdapter();
      }
      @Override
      public Adapter caseCodomain(Codomain object)
      {
        return createCodomainAdapter();
      }
      @Override
      public Adapter caseMapping(Mapping object)
      {
        return createMappingAdapter();
      }
      @Override
      public Adapter caseMappingNode(MappingNode object)
      {
        return createMappingNodeAdapter();
      }
      @Override
      public Adapter caseMappingArrow(MappingArrow object)
      {
        return createMappingArrowAdapter();
      }
      @Override
      public Adapter caseExtSubTGraph(ExtSubTGraph object)
      {
        return createExtSubTGraphAdapter();
      }
      @Override
      public Adapter caseTGraphExtSubName(TGraphExtSubName object)
      {
        return createTGraphExtSubNameAdapter();
      }
      @Override
      public Adapter caseTGraph(TGraph object)
      {
        return createTGraphAdapter();
      }
      @Override
      public Adapter caseTGraphName(TGraphName object)
      {
        return createTGraphNameAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseArrows(Arrows object)
      {
        return createArrowsAdapter();
      }
      @Override
      public Adapter caseArrow(Arrow object)
      {
        return createArrowAdapter();
      }
      @Override
      public Adapter caseNode(Node object)
      {
        return createNodeAdapter();
      }
      @Override
      public Adapter caseAttributeValue(AttributeValue object)
      {
        return createAttributeValueAdapter();
      }
      @Override
      public Adapter caseDpfId(DpfId object)
      {
        return createDpfIdAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Definition
   * @generated
   */
  public Adapter createDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.MakeEmf <em>Make Emf</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.MakeEmf
   * @generated
   */
  public Adapter createMakeEmfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.MakeEcore <em>Make Ecore</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.MakeEcore
   * @generated
   */
  public Adapter createMakeEcoreAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.MakeImage <em>Make Image</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.MakeImage
   * @generated
   */
  public Adapter createMakeImageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.SimpleEvoSpan <em>Simple Evo Span</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.SimpleEvoSpan
   * @generated
   */
  public Adapter createSimpleEvoSpanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.SimpleEvoCospan <em>Simple Evo Cospan</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.SimpleEvoCospan
   * @generated
   */
  public Adapter createSimpleEvoCospanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.EvoSpan <em>Evo Span</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.EvoSpan
   * @generated
   */
  public Adapter createEvoSpanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.EvoCospan <em>Evo Cospan</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.EvoCospan
   * @generated
   */
  public Adapter createEvoCospanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.InstanceSpecification <em>Instance Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.InstanceSpecification
   * @generated
   */
  public Adapter createInstanceSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.ChoosenSpecfication <em>Choosen Specfication</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.ChoosenSpecfication
   * @generated
   */
  public Adapter createChoosenSpecficationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.ConstraintSemantic <em>Constraint Semantic</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.ConstraintSemantic
   * @generated
   */
  public Adapter createConstraintSemanticAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Specification
   * @generated
   */
  public Adapter createSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.ChoosenGraph <em>Choosen Graph</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.ChoosenGraph
   * @generated
   */
  public Adapter createChoosenGraphAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Constraint
   * @generated
   */
  public Adapter createConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.ConstraintSignature <em>Constraint Signature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.ConstraintSignature
   * @generated
   */
  public Adapter createConstraintSignatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Morphism <em>Morphism</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Morphism
   * @generated
   */
  public Adapter createMorphismAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Domain
   * @generated
   */
  public Adapter createDomainAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Codomain <em>Codomain</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Codomain
   * @generated
   */
  public Adapter createCodomainAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Mapping <em>Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Mapping
   * @generated
   */
  public Adapter createMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.MappingNode <em>Mapping Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.MappingNode
   * @generated
   */
  public Adapter createMappingNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.MappingArrow <em>Mapping Arrow</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.MappingArrow
   * @generated
   */
  public Adapter createMappingArrowAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.ExtSubTGraph <em>Ext Sub TGraph</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.ExtSubTGraph
   * @generated
   */
  public Adapter createExtSubTGraphAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.TGraphExtSubName <em>TGraph Ext Sub Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.TGraphExtSubName
   * @generated
   */
  public Adapter createTGraphExtSubNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.TGraph <em>TGraph</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.TGraph
   * @generated
   */
  public Adapter createTGraphAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.TGraphName <em>TGraph Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.TGraphName
   * @generated
   */
  public Adapter createTGraphNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Arrows <em>Arrows</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Arrows
   * @generated
   */
  public Adapter createArrowsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Arrow <em>Arrow</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Arrow
   * @generated
   */
  public Adapter createArrowAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.Node
   * @generated
   */
  public Adapter createNodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.AttributeValue <em>Attribute Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.AttributeValue
   * @generated
   */
  public Adapter createAttributeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link no.hib.dpf.text.tdpf.DpfId <em>Dpf Id</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see no.hib.dpf.text.tdpf.DpfId
   * @generated
   */
  public Adapter createDpfIdAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //TdpfAdapterFactory