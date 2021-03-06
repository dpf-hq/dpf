/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.util;

import no.hib.dpf.core.IDObject;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DComposedConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGenericArrowConstraint;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramPackage;
import no.hib.dpf.diagram.Visualization;

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
 * @see no.hib.dpf.diagram.DiagramPackage
 * @generated
 */
public class DiagramSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DiagramPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramSwitch() {
		if (modelPackage == null) {
			modelPackage = DiagramPackage.eINSTANCE;
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DArrow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DArrow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDArrow(DArrow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DArrow Label Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DArrow Label Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDArrowLabelConstraint(DArrowLabelConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DComposed Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DComposed Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDComposedConstraint(DComposedConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DConstraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DConstraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDConstraint(DConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDElement(DElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>DGeneric Arrow Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DGeneric Arrow Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDGenericArrowConstraint(DGenericArrowConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DGraph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DGraph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDGraph(DGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DNode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDNode(DNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DConstraint Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DConstraint Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDConstraintNode(DConstraintNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DOffset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DOffset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDOffset(DOffset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DPredicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DPredicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDPredicate(DPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DSignature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DSignature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDSignature(DSignature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DSpecification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DSpecification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDSpecification(DSpecification object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated NOT
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DiagramPackage.DSPECIFICATION: {
				DSpecification dSpecification = (DSpecification)theEObject;
				T result = caseDSpecification(dSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DGRAPH: {
				DGraph dGraph = (DGraph)theEObject;
				T result = caseDGraph(dGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DNODE: {
				DNode dNode = (DNode)theEObject;
				T result = caseDNode(dNode);
				if (result == null) result = caseDElement(dNode);
				if (result == null) result = caseIDObject(dNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DCONSTRAINT_NODE: {
				DConstraintNode dConstraintNode = (DConstraintNode)theEObject;
				T result = caseDConstraintNode(dConstraintNode);
				if (result == null) result = caseDNode(dConstraintNode);
				if (result == null) result = caseDElement(dConstraintNode);
				if (result == null) result = caseIDObject(dConstraintNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DARROW: {
				DArrow dArrow = (DArrow)theEObject;
				T result = caseDArrow(dArrow);
				if (result == null) result = caseDElement(dArrow);
				if (result == null) result = caseIDObject(dArrow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DCONSTRAINT: {
				DConstraint dConstraint = (DConstraint)theEObject;
				T result = caseDConstraint(dConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DARROW_LABEL_CONSTRAINT: {
				DArrowLabelConstraint dArrowLabelConstraint = (DArrowLabelConstraint)theEObject;
				T result = caseDArrowLabelConstraint(dArrowLabelConstraint);
				if (result == null) result = caseDConstraint(dArrowLabelConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DGENERIC_ARROW_CONSTRAINT: {
				DGenericArrowConstraint dGenericArrowConstraint = (DGenericArrowConstraint)theEObject;
				T result = caseDGenericArrowConstraint(dGenericArrowConstraint);
				if (result == null) result = caseDConstraint(dGenericArrowConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DCOMPOSED_CONSTRAINT: {
				DComposedConstraint dComposedConstraint = (DComposedConstraint)theEObject;
				T result = caseDComposedConstraint(dComposedConstraint);
				if (result == null) result = caseDConstraint(dComposedConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DPREDICATE: {
				DPredicate dPredicate = (DPredicate)theEObject;
				T result = caseDPredicate(dPredicate);
				if (result == null) result = caseIDObject(dPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DOFFSET: {
				DOffset dOffset = (DOffset)theEObject;
				T result = caseDOffset(dOffset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DSIGNATURE: {
				DSignature dSignature = (DSignature)theEObject;
				T result = caseDSignature(dSignature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.VISUALIZATION: {
				Visualization visualization = (Visualization)theEObject;
				T result = caseVisualization(visualization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagramPackage.DELEMENT: {
				DElement dElement = (DElement)theEObject;
				T result = caseDElement(dElement);
				if (result == null) result = caseIDObject(dElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
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
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

} //DiagramSwitch
