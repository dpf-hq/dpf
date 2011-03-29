/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.util;

import java.util.List;

import java.util.Map;
import no.hib.dpf.metamodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see no.hib.dpf.metamodel.MetamodelPackage
 * @generated
 */
public class MetamodelSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = MetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MetamodelPackage.GRAPH: {
				Graph graph = (Graph)theEObject;
				T result = caseGraph(graph);
				if (result == null) result = caseIDObject(graph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = caseIDObject(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ARROW: {
				Arrow arrow = (Arrow)theEObject;
				T result = caseArrow(arrow);
				if (result == null) result = caseIDObject(arrow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SIGNATURE: {
				Signature signature = (Signature)theEObject;
				T result = caseSignature(signature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.PREDICATE: {
				Predicate predicate = (Predicate)theEObject;
				T result = casePredicate(predicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SEMANTICS: {
				Semantics semantics = (Semantics)theEObject;
				T result = caseSemantics(semantics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.VISUALIZATION: {
				Visualization visualization = (Visualization)theEObject;
				T result = caseVisualization(visualization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.NODE_TO_NODE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Node, Node> nodeToNodeMap = (Map.Entry<Node, Node>)theEObject;
				T result = caseNodeToNodeMap(nodeToNodeMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseIDObject(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ARROW_TO_ARROW_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<Arrow, Arrow> arrowToArrowMap = (Map.Entry<Arrow, Arrow>)theEObject;
				T result = caseArrowToArrowMap(arrowToArrowMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.TYPING_MORPHISM: {
				TypingMorphism typingMorphism = (TypingMorphism)theEObject;
				T result = caseTypingMorphism(typingMorphism);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.GRAPH_HOMOMORPHISM: {
				GraphHomomorphism graphHomomorphism = (GraphHomomorphism)theEObject;
				T result = caseGraphHomomorphism(graphHomomorphism);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.ID_OBJECT: {
				IDObject idObject = (IDObject)theEObject;
				T result = caseIDObject(idObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.SPECIFICATION: {
				Specification specification = (Specification)theEObject;
				T result = caseSpecification(specification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.MODEL_HIERARCHY: {
				ModelHierarchy modelHierarchy = (ModelHierarchy)theEObject;
				T result = caseModelHierarchy(modelHierarchy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.JOINTLY_SURJECTIVE_SEMANTICS: {
				JointlySurjectiveSemantics jointlySurjectiveSemantics = (JointlySurjectiveSemantics)theEObject;
				T result = caseJointlySurjectiveSemantics(jointlySurjectiveSemantics);
				if (result == null) result = caseSemantics(jointlySurjectiveSemantics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.INVERSE_SEMANTICS: {
				InverseSemantics inverseSemantics = (InverseSemantics)theEObject;
				T result = caseInverseSemantics(inverseSemantics);
				if (result == null) result = caseSemantics(inverseSemantics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.IRREFLEXIVE_SEMANTICS: {
				IrreflexiveSemantics irreflexiveSemantics = (IrreflexiveSemantics)theEObject;
				T result = caseIrreflexiveSemantics(irreflexiveSemantics);
				if (result == null) result = caseSemantics(irreflexiveSemantics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.MULTIPLICITY_SEMANTICS: {
				MultiplicitySemantics multiplicitySemantics = (MultiplicitySemantics)theEObject;
				T result = caseMultiplicitySemantics(multiplicitySemantics);
				if (result == null) result = caseSemantics(multiplicitySemantics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MetamodelPackage.XOR_SEMANTICS: {
				XORSemantics xorSemantics = (XORSemantics)theEObject;
				T result = caseXORSemantics(xorSemantics);
				if (result == null) result = caseSemantics(xorSemantics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	public T caseGraph(Graph object) {
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
	public T caseNode(Node object) {
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
	public T caseArrow(Arrow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignature(Signature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicate(Predicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemantics(Semantics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visualization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visualization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisualization(Visualization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node To Node Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node To Node Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeToNodeMap(Map.Entry<Node, Node> object) {
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
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arrow To Arrow Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arrow To Arrow Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrowToArrowMap(Map.Entry<Arrow, Arrow> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typing Morphism</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typing Morphism</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypingMorphism(TypingMorphism object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Homomorphism</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Homomorphism</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphHomomorphism(GraphHomomorphism object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ID Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ID Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDObject(IDObject object) {
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
	public T caseSpecification(Specification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Hierarchy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Hierarchy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelHierarchy(ModelHierarchy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jointly Surjective Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jointly Surjective Semantics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJointlySurjectiveSemantics(JointlySurjectiveSemantics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inverse Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inverse Semantics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInverseSemantics(InverseSemantics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Irreflexive Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Irreflexive Semantics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIrreflexiveSemantics(IrreflexiveSemantics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity Semantics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicitySemantics(MultiplicitySemantics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XOR Semantics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XOR Semantics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXORSemantics(XORSemantics object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //MetamodelSwitch
