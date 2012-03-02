package no.hib.dpf.editor.commands;


import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;
//import no.hib.dpf.editor.parts.ImageInclusionConstraintEditPart;
//import no.hib.dpf.editor.parts.InverseConstraintEditPart;
//import no.hib.dpf.editor.parts.JointlySurjectiveConstraintEditPart;
//import no.hib.dpf.editor.parts.TwoArrowsOneNodeConstraintEditPart;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class DConstraintCreateCommand extends AbstractCreateCommand {

	protected DConstraint dConstraint;
	protected DSpecification dSpecification;
	protected EList<DNode> dnodes = new BasicEList<DNode>();
	protected EList<DArrow> darrows = new BasicEList<DArrow>();

	private DConstraint createDConstraint(DPredicate dPredicate, GraphHomomorphism graHomomorphism){
		DConstraint result = DiagramFactory.eINSTANCE.createDConstraint();
		Constraint constraint = result.getConstraint();
		constraint.setPredicate(dPredicate.getPredicate());
		constraint.setMappings(graHomomorphism);
		result.setDPredicate(dPredicate);
		return result;
	}
	public DConstraintCreateCommand(DSpecification dSpecification,
			DPredicate dPredicate, GraphHomomorphism graphHomomorphism,
			EList<DNode> nodes, EList<DArrow> arrows) {
		this.dSpecification = dSpecification;
		dnodes.addAll(nodes);
		darrows.addAll(arrows);
		setLabel("Create " + dPredicate.getPredicate().getSymbol() + " Constraint");
		dConstraint = createDConstraint(dPredicate, graphHomomorphism);
		if(darrows.size() == 1)
			dConstraint.setOffset(DiagramFactory.eINSTANCE.createDOffset());
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return dConstraint != null && dSpecification != null;
	}

	public boolean canUndo() {
		return dConstraint != null && dSpecification != null;
	}

	public void execute() {
		dConstraint.reconnect(dnodes, darrows, dSpecification);
		if(darrows.size() > 1){
				dConstraint.setSource(darrows.get(0));
				dConstraint.setTarget(darrows.get(1));
		}
	}

	public void undo() {
		if(darrows.size() > 1){
			dConstraint.setSource(null);
			dConstraint.setTarget(null);
		}
		dConstraint.disconnect();
	}
}
