package no.hib.dpf.transform.command;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;

import org.eclipse.gef.commands.Command;

public class PreserveTransformCommand extends Command {
	
	private Object commonObject;
	private Production production;
	
	public PreserveTransformCommand(Object editNode, Production prod){
		this.commonObject = editNode;
		this.production = prod;
		setLabel("Preserve elements");
	}
	public boolean canExecute() {
		return commonObject instanceof DNode || commonObject instanceof DArrow && production != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if(commonObject instanceof DNode){
			if(production.getLeftNodes().contains(commonObject)){
				production.getLeftNodes().remove(commonObject);
			}
			if(production.getRightNodes().contains(commonObject)){
				production.getRightNodes().remove(commonObject);
			}
			production.getCommonNodes().add((DNode) commonObject);
		}
		if(commonObject instanceof DArrow){
			if(production.getLeftArrows().contains(commonObject)){
				production.getLeftArrows().remove(commonObject);
			}
			if(production.getRightArrows().contains(commonObject)){
				production.getRightArrows().remove(commonObject);
			}
			production.getCommonArrows().add((DArrow) commonObject);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		if(commonObject instanceof DNode){
			production.getCommonNodes().remove((DNode) commonObject);
		}
		if(commonObject instanceof DArrow){
			production.getCommonArrows().remove((DArrow) commonObject);
		}
	}
	
}
