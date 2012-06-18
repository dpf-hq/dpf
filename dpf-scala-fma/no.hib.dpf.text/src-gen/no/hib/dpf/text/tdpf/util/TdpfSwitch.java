/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf.util;

import no.hib.dpf.text.tdpf.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.text.tdpf.TdpfPackage
 * @generated
 */
public class TdpfSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TdpfPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TdpfSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TdpfPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case TdpfPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.COMMAND:
      {
        Command command = (Command)theEObject;
        T result = caseCommand(command);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.MAKE_EMF:
      {
        MakeEmf makeEmf = (MakeEmf)theEObject;
        T result = caseMakeEmf(makeEmf);
        if (result == null) result = caseCommand(makeEmf);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.MAKE_ECORE:
      {
        MakeEcore makeEcore = (MakeEcore)theEObject;
        T result = caseMakeEcore(makeEcore);
        if (result == null) result = caseCommand(makeEcore);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.MAKE_IMAGE:
      {
        MakeImage makeImage = (MakeImage)theEObject;
        T result = caseMakeImage(makeImage);
        if (result == null) result = caseCommand(makeImage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.SIMPLE_EVO_SPAN:
      {
        SimpleEvoSpan simpleEvoSpan = (SimpleEvoSpan)theEObject;
        T result = caseSimpleEvoSpan(simpleEvoSpan);
        if (result == null) result = caseCommand(simpleEvoSpan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.SIMPLE_EVO_COSPAN:
      {
        SimpleEvoCospan simpleEvoCospan = (SimpleEvoCospan)theEObject;
        T result = caseSimpleEvoCospan(simpleEvoCospan);
        if (result == null) result = caseCommand(simpleEvoCospan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.EVO_SPAN:
      {
        EvoSpan evoSpan = (EvoSpan)theEObject;
        T result = caseEvoSpan(evoSpan);
        if (result == null) result = caseCommand(evoSpan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.EVO_COSPAN:
      {
        EvoCospan evoCospan = (EvoCospan)theEObject;
        T result = caseEvoCospan(evoCospan);
        if (result == null) result = caseCommand(evoCospan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.INSTANCE_SPECIFICATION:
      {
        InstanceSpecification instanceSpecification = (InstanceSpecification)theEObject;
        T result = caseInstanceSpecification(instanceSpecification);
        if (result == null) result = caseCommand(instanceSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.CHOOSEN_SPECFICATION:
      {
        ChoosenSpecfication choosenSpecfication = (ChoosenSpecfication)theEObject;
        T result = caseChoosenSpecfication(choosenSpecfication);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.CONSTRAINT_SEMANTIC:
      {
        ConstraintSemantic constraintSemantic = (ConstraintSemantic)theEObject;
        T result = caseConstraintSemantic(constraintSemantic);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.SPECIFICATION:
      {
        Specification specification = (Specification)theEObject;
        T result = caseSpecification(specification);
        if (result == null) result = caseModel(specification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.CHOOSEN_SPECIFICATION:
      {
        ChoosenSpecification choosenSpecification = (ChoosenSpecification)theEObject;
        T result = caseChoosenSpecification(choosenSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.CHOOSEN_CONSTRAINT_SEMANTIC:
      {
        ChoosenConstraintSemantic choosenConstraintSemantic = (ChoosenConstraintSemantic)theEObject;
        T result = caseChoosenConstraintSemantic(choosenConstraintSemantic);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.CONSTRAINT:
      {
        Constraint constraint = (Constraint)theEObject;
        T result = caseConstraint(constraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.CONSTRAINT_SIGNATURE:
      {
        ConstraintSignature constraintSignature = (ConstraintSignature)theEObject;
        T result = caseConstraintSignature(constraintSignature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.MORPHISM:
      {
        Morphism morphism = (Morphism)theEObject;
        T result = caseMorphism(morphism);
        if (result == null) result = caseCommand(morphism);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.DOMAIN:
      {
        Domain domain = (Domain)theEObject;
        T result = caseDomain(domain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.CODOMAIN:
      {
        Codomain codomain = (Codomain)theEObject;
        T result = caseCodomain(codomain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.MAPPING:
      {
        Mapping mapping = (Mapping)theEObject;
        T result = caseMapping(mapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.MAPPING_NODE:
      {
        MappingNode mappingNode = (MappingNode)theEObject;
        T result = caseMappingNode(mappingNode);
        if (result == null) result = caseMapping(mappingNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.MAPPING_ARROW:
      {
        MappingArrow mappingArrow = (MappingArrow)theEObject;
        T result = caseMappingArrow(mappingArrow);
        if (result == null) result = caseMapping(mappingArrow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.EXT_SUB_TGRAPH:
      {
        ExtSubTGraph extSubTGraph = (ExtSubTGraph)theEObject;
        T result = caseExtSubTGraph(extSubTGraph);
        if (result == null) result = caseCommand(extSubTGraph);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.CHOOSEN_EXT_SUB_TGRAPH:
      {
        ChoosenExtSubTGraph choosenExtSubTGraph = (ChoosenExtSubTGraph)theEObject;
        T result = caseChoosenExtSubTGraph(choosenExtSubTGraph);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.GRAPH:
      {
        Graph graph = (Graph)theEObject;
        T result = caseGraph(graph);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.ELEMENT:
      {
        Element element = (Element)theEObject;
        T result = caseElement(element);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.ARROWS:
      {
        Arrows arrows = (Arrows)theEObject;
        T result = caseArrows(arrows);
        if (result == null) result = caseElement(arrows);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.ARROW:
      {
        Arrow arrow = (Arrow)theEObject;
        T result = caseArrow(arrow);
        if (result == null) result = caseArrows(arrow);
        if (result == null) result = caseElement(arrow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.NODE:
      {
        Node node = (Node)theEObject;
        T result = caseNode(node);
        if (result == null) result = caseElement(node);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.ATTRIBUTE_VALUE:
      {
        AttributeValue attributeValue = (AttributeValue)theEObject;
        T result = caseAttributeValue(attributeValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TdpfPackage.DPF_ID:
      {
        DpfId dpfId = (DpfId)theEObject;
        T result = caseDpfId(dpfId);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Command</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommand(Command object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Make Emf</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Make Emf</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMakeEmf(MakeEmf object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Make Ecore</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Make Ecore</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMakeEcore(MakeEcore object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Make Image</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Make Image</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMakeImage(MakeImage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Evo Span</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Evo Span</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleEvoSpan(SimpleEvoSpan object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Evo Cospan</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Evo Cospan</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleEvoCospan(SimpleEvoCospan object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Evo Span</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Evo Span</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvoSpan(EvoSpan object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Evo Cospan</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Evo Cospan</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvoCospan(EvoCospan object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceSpecification(InstanceSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Choosen Specfication</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choosen Specfication</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoosenSpecfication(ChoosenSpecfication object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Semantic</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Semantic</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintSemantic(ConstraintSemantic object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecification(Specification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Choosen Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choosen Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoosenSpecification(ChoosenSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Choosen Constraint Semantic</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choosen Constraint Semantic</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoosenConstraintSemantic(ChoosenConstraintSemantic object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraint(Constraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Signature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Signature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintSignature(ConstraintSignature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Morphism</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Morphism</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMorphism(Morphism object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomain(Domain object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Codomain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Codomain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCodomain(Codomain object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapping(Mapping object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingNode(MappingNode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Arrow</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Arrow</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingArrow(MappingArrow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ext Sub TGraph</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ext Sub TGraph</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtSubTGraph(ExtSubTGraph object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Choosen Ext Sub TGraph</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choosen Ext Sub TGraph</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoosenExtSubTGraph(ChoosenExtSubTGraph object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Graph</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Graph</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGraph(Graph object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arrows</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arrows</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrows(Arrows object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arrow</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arrow</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrow(Arrow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNode(Node object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeValue(AttributeValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Dpf Id</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Dpf Id</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDpfId(DpfId object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //TdpfSwitch
