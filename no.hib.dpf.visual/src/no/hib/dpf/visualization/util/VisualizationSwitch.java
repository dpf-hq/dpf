/**
 */
package no.hib.dpf.visualization.util;

import java.util.Map;

import no.hib.dpf.diagram.DElement;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visualization.*;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationPackage;
import no.hib.dpf.visualization.Visualizations;

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
 * @see no.hib.dpf.visualization.VisualizationPackage
 * @generated
 */
public class VisualizationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VisualizationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationSwitch() {
		if (modelPackage == null) {
			modelPackage = VisualizationPackage.eINSTANCE;
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
			case VisualizationPackage.VISUALIZATIONS: {
				Visualizations visualizations = (Visualizations)theEObject;
				T result = caseVisualizations(visualizations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VisualizationPackage.MODEL_TO_VISUAL_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<DElement, VElement> modelToVisualEntry = (Map.Entry<DElement, VElement>)theEObject;
				T result = caseModelToVisualEntry(modelToVisualEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VisualizationPackage.VCOMPARTMENT: {
				VCompartment vCompartment = (VCompartment)theEObject;
				T result = caseVCompartment(vCompartment);
				if (result == null) result = caseVElement(vCompartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case VisualizationPackage.VCOMPARTMENT_ELEMENT: {
				VCompartmentElement vCompartmentElement = (VCompartmentElement)theEObject;
				T result = caseVCompartmentElement(vCompartmentElement);
				if (result == null) result = caseVElement(vCompartmentElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visualizations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visualizations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisualizations(Visualizations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model To Visual Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model To Visual Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelToVisualEntry(Map.Entry<DElement, VElement> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VCompartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VCompartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVCompartment(VCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VCompartment Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VCompartment Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVCompartmentElement(VCompartmentElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVElement(VElement object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //VisualizationSwitch
