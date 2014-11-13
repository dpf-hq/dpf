package no.hib.dpf.transform.command;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;

import org.eclipse.gef.commands.CompoundCommand;

public class DeleteTransformCommand extends CompoundCommand {
	
	private Object deleteObject;
	private Production production;
	private boolean isAdded;
	public DeleteTransformCommand(Object editNode, Production prod){
		this.deleteObject = editNode;
		this.production = prod;
		setLabel("Deletion element");
		if(deleteObject instanceof DNode){
			DNode dNode = (DNode) deleteObject;
			for(DArrow dArrow : dNode.getDIncomings())
				add(new DeleteTransformCommand(dArrow, prod));
			for(DArrow dArrow : dNode.getDOutgoings())
				add(new DeleteTransformCommand(dArrow, prod));
			isAdded = production.isAdded(dNode);
		}else
			isAdded = production.isAdded((DArrow) deleteObject);
		setLabel("Insertion element");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return (deleteObject instanceof DNode || deleteObject instanceof DArrow) && production != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if(deleteObject instanceof DNode)
			production.setDeled((DNode) deleteObject);
		else
			production.setDeled((DArrow) deleteObject);
		super.execute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		super.undo();
		if(deleteObject instanceof DNode)
			if(isAdded) 
				production.setAdded((DNode) deleteObject);
			else
				production.setKept((DNode) deleteObject, true);
		else
			if(isAdded) 
				production.setAdded((DArrow) deleteObject);
			else
				production.setKept((DArrow) deleteObject, true);
	}
}
