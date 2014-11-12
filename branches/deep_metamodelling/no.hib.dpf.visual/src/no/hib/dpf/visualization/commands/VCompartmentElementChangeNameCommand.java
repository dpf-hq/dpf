package no.hib.dpf.visualization.commands;
 
import no.hib.dpf.core.Node;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;

public class VCompartmentElementChangeNameCommand extends Command {

	private Node node;
	private String newName, oldName;

	public VCompartmentElementChangeNameCommand(Node node, String name){
		super();
		Assert.isTrue(node != null);
		this.node = node;
		newName = name;
		oldName = node.getName();
		
		setLabel("Change" + oldName + "'s name");
	}
	
	
	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute(){
		node.setName(newName);
	}

	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo(){
		node.setName(oldName);
	}
}
