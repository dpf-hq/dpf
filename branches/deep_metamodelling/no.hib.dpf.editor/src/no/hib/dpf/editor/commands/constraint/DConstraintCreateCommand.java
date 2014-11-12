package no.hib.dpf.editor.commands.constraint;


import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.commands.node.AbstractDNodeCreateCommand;
import no.hib.dpf.editor.utilities.DPFModelUtils;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class DConstraintCreateCommand extends AbstractDNodeCreateCommand {

	protected EList<DArrow> darrows = new BasicEList<DArrow>();
	protected DConstraint dConstraint;
	protected EList<DNode> dnodes = new BasicEList<DNode>();
	protected DSpecification dSpecification;

	public DConstraintCreateCommand(DSpecification dSpecification,
			DPredicate dPredicate, GraphHomomorphism graphHomomorphism,
			EList<DNode> nodes, EList<DArrow> arrows) {
		this.dSpecification = dSpecification;
		dnodes.addAll(nodes);
		darrows.addAll(arrows);
		setLabel("Create " + dPredicate.getPredicate().getSymbol() + " Constraint");
		dConstraint = DPFModelUtils.createDConstraint(dPredicate, graphHomomorphism, nodes, arrows);
	}
	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return dConstraint != null && dSpecification != null;
	}

	@Override
	public boolean canUndo() {
		return dConstraint != null && dSpecification != null;
	}

	@Override
	public void execute() {
		dConstraint.reconnect(dnodes, darrows, dSpecification);
	}

	@Override
	public void undo() {
		dConstraint.disconnect();
	}
}
