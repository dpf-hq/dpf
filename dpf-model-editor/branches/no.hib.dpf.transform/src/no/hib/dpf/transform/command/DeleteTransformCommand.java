package no.hib.dpf.transform.command;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;

import org.eclipse.gef.commands.Command;

public class DeleteTransformCommand extends Command {
	
	private Object deleteObject;
	private Production production;
	
	public DeleteTransformCommand(Object editNode, Production prod){
		this.deleteObject = editNode;
		this.production = prod;
		setLabel("Deletion element");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return deleteObject instanceof DNode || deleteObject instanceof DArrow && production != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if(deleteObject instanceof DNode){
			if(production.getCommonNodes().contains(deleteObject)){
				production.getCommonNodes().remove(deleteObject);
			}
			if(production.getRightNodes().contains(deleteObject)){
				production.getRightNodes().remove(deleteObject);
			}
			production.getLeftNodes().add((DNode) deleteObject);
		}
		if(deleteObject instanceof DArrow){
			if(production.getCommonArrows().contains(deleteObject)){
				production.getCommonArrows().remove(deleteObject);
			}
			if(production.getRightArrows().contains(deleteObject)){
				production.getRightArrows().remove(deleteObject);
			}
			production.getLeftArrows().add((DArrow) deleteObject);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		if(deleteObject instanceof DNode){
			production.getLeftNodes().remove((DNode) deleteObject);
		}
		if(deleteObject instanceof DArrow){
			production.getLeftArrows().remove((DArrow) deleteObject);
		}
	}
}
