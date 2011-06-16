/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.InverseSemantics;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inverse Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InverseSemanticsImpl extends EObjectImpl implements InverseSemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InverseSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.INVERSE_SEMANTICS;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		for (Node aNode : oStar.getNodes()) {
			if (!canReturn(aNode)) {
				return false;
			}
		}
		return true;
	}

	/**
	 *  @generated NOT
	 */
	private boolean canReturn(Node aNode) {
		for (Arrow outgoing : aNode.getOutgoingArrows()) {
			boolean gotBack = false;
			for (Arrow incoming : outgoing.getTarget().getOutgoingArrows()) {
				if (incoming.getTarget().equals(aNode)) {
					gotBack = true;
				}
			}
			if (!gotBack) {
				return false;
			}
		}
		return true;
	}

} //InverseSemanticsImpl
