package no.hib.dpf.transform.command;


import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;

import org.eclipse.gef.commands.CompoundCommand;

public class AddTransformCommand extends CompoundCommand {

	//	private final DGraph parent;
	private Object insertObject;
	private Production production;
	private boolean isDel;

	public AddTransformCommand(Object editNode, Production prod){
		this.insertObject = editNode;
		this.production = prod;
		if(insertObject instanceof DNode){
			DNode dNode = (DNode) insertObject;
			for(DArrow dArrow : dNode.getDIncomings())
				add(new AddTransformCommand(dArrow, prod));
			for(DArrow dArrow : dNode.getDOutgoings())
				add(new AddTransformCommand(dArrow, prod));
			isDel = production.isDeled(dNode);
		}else
			isDel = production.isDeled((DArrow) insertObject);
		setLabel("Insertion element");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return (insertObject instanceof DNode || insertObject instanceof DArrow) && production != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if(insertObject instanceof DNode)
			production.setAdded((DNode) insertObject);
		else
			production.setAdded((DArrow) insertObject);
		super.execute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		super.undo();
		if(insertObject instanceof DNode)
			if(isDel) 
				production.setDeled((DNode) insertObject);
			else
				production.setKept((DNode) insertObject, true);
		else
			if(isDel) 
				production.setDeled((DArrow) insertObject);
			else
				production.setKept((DArrow) insertObject, true);
	}
}
