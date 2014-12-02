package no.hib.dpf.uconstraint.command;


import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.uconstraint.UConstraint;

import org.eclipse.gef.commands.CompoundCommand;

public class AddConstraintsCommand extends CompoundCommand {

	//	private final DGraph parent;
	private Object insertObject;
	private UConstraint uconstraint;
	private boolean isDel;

	public AddConstraintsCommand(Object editNode, UConstraint prod){
		this.insertObject = editNode;
		this.uconstraint = prod;
		if(insertObject instanceof DNode){
			DNode dNode = (DNode) insertObject;
			for(DArrow dArrow : dNode.getDIncomings())
				add(new AddConstraintsCommand(dArrow, prod));
			for(DArrow dArrow : dNode.getDOutgoings())
				add(new AddConstraintsCommand(dArrow, prod));
			isDel = uconstraint.isDeled(dNode);
		}else
			isDel = uconstraint.isDeled((DArrow) insertObject);
		setLabel("Insertion element");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return (insertObject instanceof DNode || insertObject instanceof DArrow) && uconstraint != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if(insertObject instanceof DNode)
			uconstraint.setAdded((DNode) insertObject);
		else
			uconstraint.setAdded((DArrow) insertObject);
		super.execute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		super.undo();
		if(insertObject instanceof DNode)
			if(isDel) 
				uconstraint.setDeled((DNode) insertObject);
			else
				uconstraint.setKept((DNode) insertObject, true);
		else
			if(isDel) 
				uconstraint.setDeled((DArrow) insertObject);
			else
				uconstraint.setKept((DArrow) insertObject, true);
	}
}
