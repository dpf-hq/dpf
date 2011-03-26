/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.metamodel.Arrow;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelPackage;
import no.hib.dpf.metamodel.MultiplicitySemantics;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MultiplicitySemanticsImpl extends EObjectImpl implements MultiplicitySemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicitySemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.MULTIPLICITY_SEMANTICS;
	}

	/**
	 * @generated NOT
	 */
	private int convertValue(int value) {
		if (value == -1) {
			return Integer.MAX_VALUE;
		}
		return value;
	}
	
	/**
	 * @generated NOT
	 */
	private int [] getValuesFromParameters(String parameters) {
		try {
			int [] retval =  new int[2];
			retval[0] = Integer.parseInt(parameters.split(",")[0]);
			retval[1] = Integer.parseInt(parameters.split(",")[1]);
			return retval;
		} catch (Exception e) {
			return new int[]{1, -1};
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters) {
		
		int [] maxMinValues = getValuesFromParameters(constraintParameters);
		
		List<Node> targetNodes = new ArrayList<Node>();
		for (Arrow arrow : oStar.getArrows()) {
			if (!targetNodes.contains(arrow.getTarget())) {
				targetNodes.add(arrow.getTarget());
			}
		}
		for (Node sourceNode : oStar.getNodes()) {
			int outgoingArrowCount = sourceNode.getOutgoingArrows().size();
			if (outgoingArrowCount > convertValue(maxMinValues[1])) {
				// Too many connections
				return false;
			} else if (outgoingArrowCount < convertValue(maxMinValues[0])) {
				// Target node?
				if (!targetNodes.contains(sourceNode)) {
					return false;
				}
			}
		}
		
		return true;
	}

} //MultiplicitySemanticsImpl
