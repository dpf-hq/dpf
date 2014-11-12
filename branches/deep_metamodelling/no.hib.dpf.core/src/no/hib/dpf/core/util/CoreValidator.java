/**
 */
package no.hib.dpf.core.util;

import java.util.Map;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.IDObject;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.Predicate;
import no.hib.dpf.core.SemanticValidator;
import no.hib.dpf.core.Signature;
import no.hib.dpf.core.Specification;
import no.hib.dpf.core.ValidatorType;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.core.CorePackage
 * @generated
 */
public class CoreValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CoreValidator INSTANCE = new CoreValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "no.hib.dpf.core";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return CorePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case CorePackage.SPECIFICATION:
				return validateSpecification((Specification)value, diagnostics, context);
			case CorePackage.GRAPH:
				return validateGraph((Graph)value, diagnostics, context);
			case CorePackage.NODE:
				return validateNode((Node)value, diagnostics, context);
			case CorePackage.ARROW:
				return validateArrow((Arrow)value, diagnostics, context);
			case CorePackage.SIGNATURE:
				return validateSignature((Signature)value, diagnostics, context);
			case CorePackage.PREDICATE:
				return validatePredicate((Predicate)value, diagnostics, context);
			case CorePackage.SEMANTIC_VALIDATOR:
				return validateSemanticValidator((SemanticValidator)value, diagnostics, context);
			case CorePackage.CONSTRAINT:
				return validateConstraint((Constraint)value, diagnostics, context);
			case CorePackage.GRAPH_HOMOMORPHISM:
				return validateGraphHomomorphism((GraphHomomorphism)value, diagnostics, context);
			case CorePackage.NODE_TO_NODE_MAP:
				return validateNodeToNodeMap((Map.Entry<?, ?>)value, diagnostics, context);
			case CorePackage.ARROW_TO_ARROW_MAP:
				return validateArrowToArrowMap((Map.Entry<?, ?>)value, diagnostics, context);
			case CorePackage.ID_OBJECT:
				return validateIDObject((IDObject)value, diagnostics, context);
			case CorePackage.VALIDATOR_TYPE:
				return validateValidatorType((ValidatorType)value, diagnostics, context);
			case CorePackage.ERESOURCE_SET:
				return validateEResourceSet((ResourceSet)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecification(Specification specification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(specification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGraph(Graph graph, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(graph, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(graph, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(graph, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNode(Node node, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(node, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(node, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(node, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrow(Arrow arrow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(arrow, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(arrow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(arrow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(arrow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(arrow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(arrow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(arrow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(arrow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(arrow, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignature(Signature signature, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(signature, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredicate(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(predicate, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSemanticValidator(SemanticValidator semanticValidator, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(semanticValidator, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(constraint, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(constraint, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constraint, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGraphHomomorphism(GraphHomomorphism graphHomomorphism, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(graphHomomorphism, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNodeToNodeMap(Map.Entry<?, ?> nodeToNodeMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)nodeToNodeMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArrowToArrowMap(Map.Entry<?, ?> arrowToArrowMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)arrowToArrowMap, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIDObject(IDObject idObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(idObject, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(idObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(idObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(idObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(idObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(idObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(idObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(idObject, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(idObject, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValidatorType(ValidatorType validatorType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEResourceSet(ResourceSet eResourceSet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //CoreValidator
