/**
 * <copyright>
 * </copyright>
 *
 */
package no.hib.dpf.text.tdpf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.text.tdpf.TdpfPackage
 * @generated
 */
public interface TdpfFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TdpfFactory eINSTANCE = no.hib.dpf.text.tdpf.impl.TdpfFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Command</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Command</em>'.
   * @generated
   */
  Command createCommand();

  /**
   * Returns a new object of class '<em>Make Emf</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Make Emf</em>'.
   * @generated
   */
  MakeEmf createMakeEmf();

  /**
   * Returns a new object of class '<em>Make Ecore</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Make Ecore</em>'.
   * @generated
   */
  MakeEcore createMakeEcore();

  /**
   * Returns a new object of class '<em>Make Image</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Make Image</em>'.
   * @generated
   */
  MakeImage createMakeImage();

  /**
   * Returns a new object of class '<em>Simple Evo Span</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Evo Span</em>'.
   * @generated
   */
  SimpleEvoSpan createSimpleEvoSpan();

  /**
   * Returns a new object of class '<em>Simple Evo Cospan</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Evo Cospan</em>'.
   * @generated
   */
  SimpleEvoCospan createSimpleEvoCospan();

  /**
   * Returns a new object of class '<em>Evo Span</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Evo Span</em>'.
   * @generated
   */
  EvoSpan createEvoSpan();

  /**
   * Returns a new object of class '<em>Evo Cospan</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Evo Cospan</em>'.
   * @generated
   */
  EvoCospan createEvoCospan();

  /**
   * Returns a new object of class '<em>Instance Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Specification</em>'.
   * @generated
   */
  InstanceSpecification createInstanceSpecification();

  /**
   * Returns a new object of class '<em>Choosen Specfication</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choosen Specfication</em>'.
   * @generated
   */
  ChoosenSpecfication createChoosenSpecfication();

  /**
   * Returns a new object of class '<em>Constraint Semantic</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Semantic</em>'.
   * @generated
   */
  ConstraintSemantic createConstraintSemantic();

  /**
   * Returns a new object of class '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specification</em>'.
   * @generated
   */
  Specification createSpecification();

  /**
   * Returns a new object of class '<em>Choosen Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choosen Specification</em>'.
   * @generated
   */
  ChoosenSpecification createChoosenSpecification();

  /**
   * Returns a new object of class '<em>Choosen Constraint Semantic</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choosen Constraint Semantic</em>'.
   * @generated
   */
  ChoosenConstraintSemantic createChoosenConstraintSemantic();

  /**
   * Returns a new object of class '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint</em>'.
   * @generated
   */
  Constraint createConstraint();

  /**
   * Returns a new object of class '<em>Constraint Signature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Signature</em>'.
   * @generated
   */
  ConstraintSignature createConstraintSignature();

  /**
   * Returns a new object of class '<em>Morphism</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Morphism</em>'.
   * @generated
   */
  Morphism createMorphism();

  /**
   * Returns a new object of class '<em>Domain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Domain</em>'.
   * @generated
   */
  Domain createDomain();

  /**
   * Returns a new object of class '<em>Codomain</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Codomain</em>'.
   * @generated
   */
  Codomain createCodomain();

  /**
   * Returns a new object of class '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping</em>'.
   * @generated
   */
  Mapping createMapping();

  /**
   * Returns a new object of class '<em>Mapping Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Node</em>'.
   * @generated
   */
  MappingNode createMappingNode();

  /**
   * Returns a new object of class '<em>Mapping Arrow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mapping Arrow</em>'.
   * @generated
   */
  MappingArrow createMappingArrow();

  /**
   * Returns a new object of class '<em>Ext Sub TGraph</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ext Sub TGraph</em>'.
   * @generated
   */
  ExtSubTGraph createExtSubTGraph();

  /**
   * Returns a new object of class '<em>Choosen Ext Sub TGraph</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choosen Ext Sub TGraph</em>'.
   * @generated
   */
  ChoosenExtSubTGraph createChoosenExtSubTGraph();

  /**
   * Returns a new object of class '<em>Graph</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Graph</em>'.
   * @generated
   */
  Graph createGraph();

  /**
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  Element createElement();

  /**
   * Returns a new object of class '<em>Arrows</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arrows</em>'.
   * @generated
   */
  Arrows createArrows();

  /**
   * Returns a new object of class '<em>Arrow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arrow</em>'.
   * @generated
   */
  Arrow createArrow();

  /**
   * Returns a new object of class '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node</em>'.
   * @generated
   */
  Node createNode();

  /**
   * Returns a new object of class '<em>Attribute Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Value</em>'.
   * @generated
   */
  AttributeValue createAttributeValue();

  /**
   * Returns a new object of class '<em>Dpf Id</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dpf Id</em>'.
   * @generated
   */
  DpfId createDpfId();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TdpfPackage getTdpfPackage();

} //TdpfFactory
