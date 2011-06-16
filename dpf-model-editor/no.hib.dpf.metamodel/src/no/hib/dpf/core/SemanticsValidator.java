/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semantics Validator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see no.hib.dpf.core.CorePackage#getSemanticsValidator()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SemanticsValidator extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model typeNodesMany="true" typeArrowsMany="true"
	 * @generated
	 */
	Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows);

} // SemanticsValidator
