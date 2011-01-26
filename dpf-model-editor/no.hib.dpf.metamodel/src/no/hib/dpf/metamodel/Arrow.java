/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Arrow#getTarget <em>Target</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Arrow#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Arrow#getTypeArrow <em>Type Arrow</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Arrow#getSource <em>Source</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Arrow#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getArrow()
 * @model
 * @generated
 */
public interface Arrow extends IDObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getArrow_Target()
	 * @model
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Arrow#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link no.hib.dpf.metamodel.Graph#getArrows <em>Arrows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getArrow_Graph()
	 * @see no.hib.dpf.metamodel.Graph#getArrows
	 * @model opposite="arrows" transient="false"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Arrow#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Type Arrow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Arrow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arrow</em>' reference.
	 * @see #setTypeArrow(Arrow)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getArrow_TypeArrow()
	 * @model
	 * @generated
	 */
	Arrow getTypeArrow();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Arrow#getTypeArrow <em>Type Arrow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Arrow</em>' reference.
	 * @see #getTypeArrow()
	 * @generated
	 */
	void setTypeArrow(Arrow value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getArrow_Source()
	 * @model
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Arrow#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

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
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getArrow_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Arrow#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getTypeName();

} // Arrow
