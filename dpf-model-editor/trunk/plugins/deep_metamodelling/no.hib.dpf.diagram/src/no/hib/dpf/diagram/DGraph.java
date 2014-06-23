/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.diagram;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;

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
 *   <li>{@link no.hib.dpf.diagram.DGraph#getDDataNodes <em>DData Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DGraph#getDArrowDAttributes <em>DArrow DAttributes</em>}</li>
 *   <li>{@link no.hib.dpf.diagram.DGraph#getDNodeDAttributes <em>DNode DAttributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph()
 * @model
 * @generated
 */
public interface DGraph extends EObject {
	void addDArrow(DArrow arrow);

	void addDNode(DNode node);
	
	void addDNodeDAttribute(DNodeDAttribute dnodeDAttribute);
	void addDArrowDAttribute(DArrowDAttribute darrowDAttribute);
	
	void addDDataNode(DDataNode ddatanode);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DArrow createDArrow(String name, DNode dSource, DNode dTarget, DArrow dType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DGraph getTemplateDGraph();

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
	DArrow getDArrow(Arrow arrow);

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	DNode getDNode(Node node);

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

	void removeDArrow(DArrow arrow);
	void removeDNode(DNode node);
	void removeDNodeDAttribute(DNodeDAttribute dattribute);
	void removeDArrowDAttribute(DArrowDAttribute dattribute);
	void removeDDataNode(DDataNode ddatanode);
	
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
	 * Sets the value of the '{@link no.hib.dpf.diagram.DGraph#getGraph <em>Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>DData Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DDataNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DData Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DData Nodes</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph_DDataNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DDataNode> getDDataNodes();

	/**
	 * Returns the value of the '<em><b>DArrow DAttributes</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DArrowDAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DArrow DAttributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DArrow DAttributes</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph_DArrowDAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DArrowDAttribute> getDArrowDAttributes();

	/**
	 * Returns the value of the '<em><b>DNode DAttributes</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.diagram.DNodeDAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DNode DAttributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DNode DAttributes</em>' containment reference list.
	 * @see no.hib.dpf.diagram.DiagramPackage#getDGraph_DNodeDAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DNodeDAttribute> getDNodeDAttributes();

	DDataNode getDDataNode(DataNode node);

	DNodeDAttribute getDNodeDAttribute(NodeAttribute nodeattribute);
} // DGraph
