package no.hib.dpf.visualization.commands;

import no.hib.dpf.editor.commands.DNodeDeleteCommand;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;

import org.eclipse.emf.common.util.EList;

public class ChildDNodeDeleteCommand extends DNodeDeleteCommand {
	VCompartment parent;
	VCompartmentElement compartmentElement;
	
	public ChildDNodeDeleteCommand(VCompartmentElement compartmentElement) {
		super(compartmentElement.getDNode());
		this.compartmentElement = compartmentElement;
		this.parent =  (VCompartment) compartmentElement.eContainer();
	}

	@Override
	public boolean canExecute() {
		if(parent != null && compartmentElement != null){
			return super.canExecute();
		}
		return false;
	}

	@Override
	public boolean canUndo() {
		if(parent != null && compartmentElement != null){
			return super.canUndo();
		}
		return false;
	}
	
	@Override
	public void execute() {
		for (VCompartmentElement vcompartmentElement : parent.getChildren()) {
			if(compartmentElement == vcompartmentElement){
				super.execute();
				
				EList<VCompartmentElement> list = parent.getChildren();
				synchronized (list) {
					list.remove(compartmentElement);
				}
			}
		}
	}
	
	@Override
	public void redo() {
		execute();
	}

	@Override
	public void undo() {
		super.undo();
		
		EList<VCompartmentElement> list = parent.getChildren();
		synchronized (list) {
			list.add(compartmentElement);
		}
	}
}