package no.hib.dpf.editor.commands;


import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowLabelConstraint;
import no.hib.dpf.diagram.DComposedConstraint;
import no.hib.dpf.diagram.DConstraint;
import no.hib.dpf.diagram.DFakeNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.diagram.DiagramFactory;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class DConstraintCreateCommand extends AbstractCreateCommand {

	protected DConstraint dConstraint;
	protected DSpecification dSpecification;
	protected EList<DNode> dnodes = new BasicEList<DNode>();
	protected EList<DArrow> darrows = new BasicEList<DArrow>();

	private DConstraint createDConstraint(DPredicate dPredicate, GraphHomomorphism graHomomorphism){
		DConstraint result = null;//DiagramFactory.eINSTANCE.createDConstraint();
		switch(dPredicate.getVisualization().getType()){
		case ARROW_LABEL:
			result = DiagramFactory.eINSTANCE.createDArrowLabelConstraint();
			((DArrowLabelConstraint)result).setOffset(DiagramFactory.eINSTANCE.createDOffset());
			break;
		case NODE_TO_ARROW:
		case NODE_TO_NODE:
		case ARROW_TO_NODE:
		case ARROW_TO_ARROW:
			result = DiagramFactory.eINSTANCE.createDGenericArrowConstraint();
			break;
		case COMPOSED:
			DComposedConstraint newComposedConstraint = DiagramFactory.eINSTANCE.createDComposedConstraint();
			DFakeNode dNode = DiagramFactory.eINSTANCE.createDFakeNode();
			//TODO get fakenode's position automatically in the future
			dNode.setSize(new Dimension(100,30));
			dNode.setLocation(new Point(10,10));
			dNode.setDConstraint(newComposedConstraint);
			newComposedConstraint.setFakeNode(dNode);
			for (int i = 0; i < darrows.size(); i++) 
				newComposedConstraint.getChildren().add(DiagramFactory.eINSTANCE.createDGenericArrowConstraint());
			result = newComposedConstraint;
			break;
		}
		result.setConstraint(CoreFactory.eINSTANCE.createConstraint());
		result.getConstraint().setMappings(graHomomorphism);
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
	}

	public void undo() {
		dConstraint.disconnect();
	}
}
