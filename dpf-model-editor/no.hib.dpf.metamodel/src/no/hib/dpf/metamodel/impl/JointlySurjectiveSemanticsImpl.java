/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.JointlySurjectiveSemantics;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jointly Surjective Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JointlySurjectiveSemanticsImpl extends EObjectImpl implements JointlySurjectiveSemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JointlySurjectiveSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.JOINTLY_SURJECTIVE_SEMANTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters) {
		if (oStar.getArrows().size() != (oStar.getNodes().size() - 1)) {
			return false;
		}
		if (oStar.getNodes().size() == 1) {
			return false;
		}
		int nodesWithIncomingArrowsCount = 0;
		Node nodeWithOnlyIncoming = null;
		for (Node node : oStar.getNodes()) {
			if (node.getOutgoingArrows().size() == 0) {
				nodesWithIncomingArrowsCount++;
				nodeWithOnlyIncoming = node;
			} else if (node.getOutgoingArrows().size() != 1) {
				return false;
			}
		}
		if (nodesWithIncomingArrowsCount != 1) {
			return false;
		}
		for (Node node : oStar.getNodes()) {
			if (!node.equals(nodeWithOnlyIncoming)) {
				if (node.getArrowto(nodeWithOnlyIncoming) == null) {
					return false;
				}
			}
		}
		return true;
	}


} //JointlySurjectiveSemanticsImpl
