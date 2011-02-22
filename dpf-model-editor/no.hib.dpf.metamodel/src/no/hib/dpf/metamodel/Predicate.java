/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Predicate#getShape <em>Shape</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Predicate#getSemantics <em>Semantics</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Predicate#getVisualization <em>Visualization</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Predicate#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate()
 * @model
 * @generated
 */
public interface Predicate extends EObject {
	/**
	 * Returns the value of the '<em><b>Shape</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape</em>' containment reference.
	 * @see #setShape(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate_Shape()
	 * @model containment="true"
	 * @generated
	 */
	Graph getShape();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Predicate#getShape <em>Shape</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape</em>' containment reference.
	 * @see #getShape()
	 * @generated
	 */
	void setShape(Graph value);

	/**
	 * Returns the value of the '<em><b>Semantics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Semantics</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantics</em>' containment reference.
	 * @see #setSemantics(Semantics)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate_Semantics()
	 * @model containment="true"
	 * @generated
	 */
	Semantics getSemantics();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Predicate#getSemantics <em>Semantics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Semantics</em>' containment reference.
	 * @see #getSemantics()
	 * @generated
	 */
	void setSemantics(Semantics value);

	/**
	 * Returns the value of the '<em><b>Visualization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visualization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visualization</em>' reference.
	 * @see #setVisualization(Visualization)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate_Visualization()
	 * @model
	 * @generated
	 */
	Visualization getVisualization();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Predicate#getVisualization <em>Visualization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visualization</em>' reference.
	 * @see #getVisualization()
	 * @generated
	 */
	void setVisualization(Visualization value);

	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' attribute.
	 * @see #setSymbol(String)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getPredicate_Symbol()
	 * @model unique="false" required="true"
	 * @generated
	 */
	String getSymbol();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Predicate#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" arrowsMany="true"
	 * @generated
	 */
	Constraint createConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nodesMany="true" arrowsMany="true"
	 * @generated
	 */
	boolean canCreateConstraint(EList<Node> nodes, EList<Arrow> arrows, Graph modelToBeConstrained);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Boolean checkSemantics(Graph oStar);

} // Predicate
