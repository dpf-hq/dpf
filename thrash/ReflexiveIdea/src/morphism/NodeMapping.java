/**
 * <copyright>
 * </copyright>
 *
 * $Id: NodeMapping.java,v 1.1 2010-05-19 13:09:35 fma Exp $
 */
package morphism;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link morphism.NodeMapping#getSrc <em>Src</em>}</li>
 *   <li>{@link morphism.NodeMapping#getTar <em>Tar</em>}</li>
 * </ul>
 * </p>
 *
 * @see morphism.MorphismPackage#getNodeMapping()
 * @model
 * @generated
 */
public interface NodeMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Src</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' reference.
	 * @see #setSrc(EClass)
	 * @see morphism.MorphismPackage#getNodeMapping_Src()
	 * @model required="true"
	 * @generated
	 */
	EClass getSrc();

	/**
	 * Sets the value of the '{@link morphism.NodeMapping#getSrc <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' reference.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(EClass value);

	/**
	 * Returns the value of the '<em><b>Tar</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tar</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tar</em>' reference list.
	 * @see morphism.MorphismPackage#getNodeMapping_Tar()
	 * @model required="true"
	 * @generated
	 */
	EList<EClass> getTar();

} // NodeMapping
