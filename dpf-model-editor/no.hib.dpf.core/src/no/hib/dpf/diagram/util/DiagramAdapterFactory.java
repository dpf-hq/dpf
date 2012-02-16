/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram.util;

import no.hib.dpf.diagram.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see no.hib.dpf.diagram.DiagramPackage
 * @generated
 */
public class DiagramAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DiagramPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DiagramPackage.eINSTANCE;
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
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
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
	protected DiagramSwitch<Adapter> modelSwitch =
		new DiagramSwitch<Adapter>() {
			@Override
			public Adapter caseDSpecification(DSpecification object) {
				return createDSpecificationAdapter();
			}
			@Override
			public Adapter caseDGraph(DGraph object) {
				return createDGraphAdapter();
			}
			@Override
			public Adapter caseDNode(DNode object) {
				return createDNodeAdapter();
			}
			@Override
			public Adapter caseDArrow(DArrow object) {
				return createDArrowAdapter();
			}
			@Override
			public Adapter caseDConstraint(DConstraint object) {
				return createDConstraintAdapter();
			}
			@Override
			public Adapter caseDPredicate(DPredicate object) {
				return createDPredicateAdapter();
			}
			@Override
			public Adapter caseDBound(DBound object) {
				return createDBoundAdapter();
			}
			@Override
			public Adapter caseDOffset(DOffset object) {
				return createDOffsetAdapter();
			}
			@Override
			public Adapter caseDSignature(DSignature object) {
				return createDSignatureAdapter();
			}
			@Override
			public Adapter caseVisualization(Visualization object) {
				return createVisualizationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DSpecification <em>DSpecification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DSpecification
	 * @generated
	 */
	public Adapter createDSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DGraph <em>DGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DGraph
	 * @generated
	 */
	public Adapter createDGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DNode <em>DNode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DNode
	 * @generated
	 */
	public Adapter createDNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DArrow <em>DArrow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DArrow
	 * @generated
	 */
	public Adapter createDArrowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DConstraint <em>DConstraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DConstraint
	 * @generated
	 */
	public Adapter createDConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DPredicate <em>DPredicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DPredicate
	 * @generated
	 */
	public Adapter createDPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DBound <em>DBound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DBound
	 * @generated
	 */
	public Adapter createDBoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DOffset <em>DOffset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DOffset
	 * @generated
	 */
	public Adapter createDOffsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.DSignature <em>DSignature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.DSignature
	 * @generated
	 */
	public Adapter createDSignatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link no.hib.dpf.diagram.Visualization <em>Visualization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see no.hib.dpf.diagram.Visualization
	 * @generated
	 */
	public Adapter createVisualizationAdapter() {
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
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DiagramAdapterFactory
