/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DGraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.diagram.DGraph#getDType <em>DType</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DGraph#getDNodes <em>DNodes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DGraph#getDArrows <em>DArrows</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DGraph#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph()
 * @model
 * @generated
 */
public interface DGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>DType</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DType</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DType</em>' reference.
	 * @see #setDType(DGraph)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph_DType()
	 * @model required="true"
	 * @generated
	 */
	DGraph getDType();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DGraph#getDType <em>DType</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DType</em>' reference.
	 * @see #getDType()
	 * @generated
	 */
	void setDType(DGraph value);

	/**
	 * Returns the value of the '<em><b>DNodes</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DNodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DNodes</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph_DNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DNode> getDNodes();

	/**
	 * Returns the value of the '<em><b>DArrows</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DArrows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DArrows</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph_DArrows()
	 * @model containment="true"
	 * @generated
	 */
	EList<DArrow> getDArrows();

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' reference.
	 * @see #setGraph(Graph)
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph_Graph()
	 * @model required="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.diagram.DGraph#getGraph <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DNode getDNode(Node node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DArrow getDArrow(Arrow arrow);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DNode createDNode(String name, DNode dType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DArrow createDArrow(String name, DNode dSource, DNode dTarget, DArrow dType);

	void addDNode(DNode node);
	void addDArrow(DArrow arrow);
	void removeDNode(DNode node);
	void removeDArrow(DArrow arrow);
} // DGraph
