/**
 * <copyright>
 * </copyright>
 *
 * $Id: Morphism.java,v 1.1 2010-05-19 13:09:35 fma Exp $
 */
package morphism;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Morphism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link morphism.Morphism#getNodeMappings <em>Node Mappings</em>}</li>
 *   <li>{@link morphism.Morphism#getReferenceMappings <em>Reference Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see morphism.MorphismPackage#getMorphism()
 * @model
 * @generated
 */
public interface Morphism extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link morphism.NodeMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Mappings</em>' containment reference list.
	 * @see morphism.MorphismPackage#getMorphism_NodeMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<NodeMapping> getNodeMappings();

	/**
	 * Returns the value of the '<em><b>Reference Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link morphism.ReferenceMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Mappings</em>' containment reference list.
	 * @see morphism.MorphismPackage#getMorphism_ReferenceMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceMapping> getReferenceMappings();

} // Morphism
