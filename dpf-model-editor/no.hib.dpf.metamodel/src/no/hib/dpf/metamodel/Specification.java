/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel;

import java.io.IOException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link no.hib.dpf.metamodel.Specification#getGraph <em>Graph</em>}</li>
 *   <li>{@link no.hib.dpf.metamodel.Specification#getTypeGraph <em>Type Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see no.hib.dpf.metamodel.MetamodelPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends EObject {
	/**
	 * Returns the value of the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' containment reference.
	 * @see #setGraph(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getSpecification_Graph()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Specification#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Type Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Graph</em>' containment reference.
	 * @see #setTypeGraph(Graph)
	 * @see no.hib.dpf.metamodel.MetamodelPackage#getSpecification_TypeGraph()
	 * @model containment="true"
	 * @generated
	 */
	Graph getTypeGraph();

	/**
	 * Sets the value of the '{@link no.hib.dpf.metamodel.Specification#getTypeGraph <em>Type Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Graph</em>' containment reference.
	 * @see #getTypeGraph()
	 * @generated
	 */
	void setTypeGraph(Graph value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="no.hib.dpf.metamodel.EIOException" uriDataType="no.hib.dpf.metamodel.EURI"
	 * @generated
	 */
	void save(URI uri) throws IOException;

} // Specification
