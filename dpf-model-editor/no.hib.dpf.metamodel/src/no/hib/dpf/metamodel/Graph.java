/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#getName <em>Name</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#getEdges <em>Edges</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Graph#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends IDObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.metamodel.Node}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.metamodel.Node#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraph_Nodes()
	 * @see no.hib.dpf.metamodel.Node#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraph_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Graph#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.metamodel.Edge}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.metamodel.Edge#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraph_Edges()
	 * @see no.hib.dpf.metamodel.Edge#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link no.hib.dpf.metamodel.Constraint}.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.metamodel.Constraint#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getGraph_Constraints()
	 * @see no.hib.dpf.metamodel.Constraint#getGraph
	 * @model opposite="graph" containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Node createNode(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Edge createEdge(String name, Node source, Node target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" edgesMany="true"
	 * @generated
	 */
	Constraint applyPredicate(Predicate predicate, EList<Node> nodes, EList<Edge> edges);

	/**
	 * <!-- begin-user-doc -->
	 * Returns any IDPointer member of the graph having the provided id value.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	IDObject getGraphMember(String id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteNode(Node node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deleteEdge(Edge edge);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Node getNodeByName(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Edge getEdgeByName(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Node createNode(String name, Node typeNode);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Edge createEdge(String name, Node source, Node target, Edge typeEdge);
	

} // Graph
