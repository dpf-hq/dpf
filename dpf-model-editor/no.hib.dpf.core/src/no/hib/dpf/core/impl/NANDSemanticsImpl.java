/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package no.hib.dpf.core.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Graph;
import no.hib.dpf.core.NANDSemantics;
import no.hib.dpf.core.Node;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NAND Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NANDSemanticsImpl extends SemanticsValidatorImpl implements NANDSemantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NANDSemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.NAND_SEMANTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Boolean validateSemantics(Graph oStar, String constraintParameters, EList<Node> typeNodes, EList<Arrow> typeArrows) {
		//Check invairant constraint:
		if ((typeArrows.size() != 2) || (typeNodes.size() < 1)) {
			System.out.println("breaks NAND");
			return true;
		}

		//Check NAND:
		final Node typeSourceNode = typeArrows.get(0).getSource();
		//HashMap for saving arrowType for each source node:
		Map<Node, List<Arrow>> violateArrows = new HashMap<Node, List<Arrow>>();
		for(Node node : oStar.getNodes())
			if(node.getTypeNode() == typeSourceNode){
				boolean nand = true;
				EList<Arrow> outgoing = node.getOutgoingArrows();
				if(outgoing.size() > 0){
					Arrow type = outgoing.get(0).getTypeArrow();
					for(Arrow arrow : node.getOutgoingArrows())
						if(arrow.getTypeArrow() != type){
							nand = false;
							break;
						}
				}else
					continue;
				if(!nand)
					violateArrows.put(node, outgoing);

			}

		if(!violateArrows.isEmpty()){
			System.out.println("Followings violate NAND Constraint: ");
			Arrow typeArrow0 = typeArrows.get(0);
			Arrow typeArrow1 = typeArrows.get(1);
			String xor0 = typeArrow0.getName() + ": " + typeArrow0.getSource().getName() + "->" + typeArrow0.getTarget().getName();
			String xor1 = typeArrow1.getName() + ": " + typeArrow1.getSource().getName() + "->" + typeArrow1.getTarget().getName();
			for(Entry<Node, List<Arrow>> entry : violateArrows.entrySet()){
					System.out.println("\tArrows following from " + entry.getKey().getName() + " break NAND constraint on " + xor0 + " and " + xor1);
					for(Arrow arrow : entry.getValue())
						System.out.println("\t\t" + arrow.getName() + ":" + arrow.getSource().getName() + "->" + arrow.getTarget().getName());
			}
			System.out.println();  	
		}
		return violateArrows.isEmpty();	
	} //NANDSemanticsImpl
}

