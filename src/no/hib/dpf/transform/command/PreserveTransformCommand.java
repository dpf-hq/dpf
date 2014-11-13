package no.hib.dpf.transform.command;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;

import org.eclipse.gef.commands.CompoundCommand;

public class PreserveTransformCommand extends CompoundCommand {
	
	private Object commonObject;
	private Production production;
	boolean isAdded;
	public PreserveTransformCommand(Object editNode, Production prod){
		this.commonObject = editNode;
		this.production = prod;
		if(commonObject instanceof DArrow){
			DArrow dArrow = (DArrow) commonObject;
			add(new PreserveTransformCommand(dArrow.getDSource(), prod));
			add(new PreserveTransformCommand(dArrow.getDTarget(), prod));
			isAdded = production.isAdded(dArrow);
		}else
			isAdded = production.isAdded((DNode) commonObject);
		setLabel("Preserve elements");
	}
	public boolean canExecute() {
		return (commonObject instanceof DNode || commonObject instanceof DArrow) && production != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if(commonObject instanceof DNode)
			production.setKept((DNode) commonObject, true);
		else
			production.setKept((DArrow) commonObject, true);
		super.execute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		super.undo();
		if(commonObject instanceof DNode)
			if(isAdded) 
				production.setAdded((DNode) commonObject);
			else
				production.setDeled((DNode) commonObject);
		else
			if(isAdded) 
				production.setAdded((DArrow) commonObject);
			else
				production.setDeled((DArrow) commonObject);
	}
	
}
