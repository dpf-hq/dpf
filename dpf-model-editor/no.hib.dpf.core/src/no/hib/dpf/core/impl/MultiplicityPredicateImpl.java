/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.MultiplicityPredicate;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MultiplicityPredicateImpl extends PredicateImpl implements MultiplicityPredicate {
	static String[] paraNames = {"Min", "Max"};
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplicityPredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	
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
	private int [] getValuesFromParameters(EList<String> parameters) {
		try {
			//TODO check parameters.size() == 2, if not throw MultipliciyParameterException
			int[] retval = new int[2];
			retval[0] = Integer.parseInt(parameters.get(0));
			retval[1] = Integer.parseInt(parameters.get(1));
			return retval;
		} catch (Exception e) {
			return new int[]{1, -1};
		}
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public Boolean validateSemantics(EList<String> constraintParameters,
			EList<Node> typeNodes, EList<Arrow> typeArrows,
			EList<Node> stuckedNodes, EList<Arrow> stuckedArrows) {
		if ((typeArrows.size() != 1) || (typeNodes.size() < 1)) {
			return true;
		}
		
		Node typeSourceNode = typeArrows.get(0).getSource();
				
		int [] maxMinValues = getValuesFromParameters(constraintParameters);
		
		
		
		List<Node> sourceNodes = new ArrayList<Node>();		
		for (Node node : stuckedNodes) {
			if (node.getTypeNode().equals(typeSourceNode)) {
				sourceNodes.add(node);
			}
		}
		
				
		for (Node sourceNode : sourceNodes) {
			int outgoingArrowCount = sourceNode.getOutgoings().size();
			if (outgoingArrowCount > convertValue(maxMinValues[1])) {
				// Too many connections
				return false;
			} else if (outgoingArrowCount < convertValue(maxMinValues[0])) {
				// Too few connections
				return false;
			}
		}
		
		return true;
	}
	
} //MultiplicityPredicateImpl
