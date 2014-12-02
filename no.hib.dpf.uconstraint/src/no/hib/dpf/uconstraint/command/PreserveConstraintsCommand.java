package no.hib.dpf.uconstraint.command;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.uconstraint.UConstraint;

import org.eclipse.gef.commands.CompoundCommand;

public class PreserveConstraintsCommand extends CompoundCommand {
	
	private Object commonObject;
	private UConstraint uconstraint;
	boolean isAdded;
	public PreserveConstraintsCommand(Object editNode, UConstraint prod){
		this.commonObject = editNode;
		this.uconstraint = prod;
		if(commonObject instanceof DArrow){
			DArrow dArrow = (DArrow) commonObject;
			add(new PreserveConstraintsCommand(dArrow.getDSource(), prod));
			add(new PreserveConstraintsCommand(dArrow.getDTarget(), prod));
			isAdded = uconstraint.isAdded(dArrow);
		}else
			isAdded = uconstraint.isAdded((DNode) commonObject);
		setLabel("Preserve elements");
	}
	public boolean canExecute() {
		return (commonObject instanceof DNode || commonObject instanceof DArrow) && uconstraint != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		if(commonObject instanceof DNode)
			uconstraint.setKept((DNode) commonObject, true);
		else
			uconstraint.setKept((DArrow) commonObject, true);
		super.execute();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		super.undo();
		if(commonObject instanceof DNode)
			if(isAdded) 
				uconstraint.setAdded((DNode) commonObject);
			else
				uconstraint.setDeled((DNode) commonObject);
		else
			if(isAdded) 
				uconstraint.setAdded((DArrow) commonObject);
			else
				uconstraint.setDeled((DArrow) commonObject);
	}
	
}
