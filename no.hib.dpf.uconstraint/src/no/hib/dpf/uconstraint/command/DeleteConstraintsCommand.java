package no.hib.dpf.uconstraint.command;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.uconstraint.UConstraint;

import org.eclipse.gef.commands.CompoundCommand;

public class DeleteConstraintsCommand extends CompoundCommand {
	
	private Object deleteObject;
	private UConstraint uconstraint;
	private boolean isAdded;
	public DeleteConstraintsCommand(Object editNode, UConstraint prod){
		this.deleteObject = editNode;
		this.uconstraint = prod;
		setLabel("Deletion element");
		if(deleteObject instanceof DNode){
			DNode dNode = (DNode) deleteObject;
			for(DArrow dArrow : dNode.getDIncomings())
				add(new DeleteConstraintsCommand(dArrow, prod));
			for(DArrow dArrow : dNode.getDOutgoings())
				add(new DeleteConstraintsCommand(dArrow, prod));
			isAdded = uconstraint.isAdded(dNode);
		}else
			isAdded = uconstraint.isAdded((DArrow) deleteObject);
		setLabel("Insertion element");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return (deleteObject instanceof DNode || deleteObject instanceof DArrow) && uconstraint != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if(deleteObject instanceof DNode)
			uconstraint.setDeled((DNode) deleteObject);
		else
			uconstraint.setDeled((DArrow) deleteObject);
		super.execute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		super.undo();
		if(deleteObject instanceof DNode)
			if(isAdded) 
				uconstraint.setAdded((DNode) deleteObject);
			else
				uconstraint.setKept((DNode) deleteObject, true);
		else
			if(isAdded) 
				uconstraint.setAdded((DArrow) deleteObject);
			else
				uconstraint.setKept((DArrow) deleteObject, true);
	}
}
