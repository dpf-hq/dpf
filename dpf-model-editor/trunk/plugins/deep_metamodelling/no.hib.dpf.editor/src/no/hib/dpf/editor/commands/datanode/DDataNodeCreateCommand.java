package no.hib.dpf.editor.commands.datanode;

import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;


public class DDataNodeCreateCommand extends Command {

	/** Diagram to add to. */
	protected Dimension bounds;
	protected Point start;
	protected DDataNode newObject;
	private final DGraph parent;

	
	public DDataNodeCreateCommand(DDataNode newDDataNode, DGraph parent) {
		this.newObject = newDDataNode;
		this.parent = parent;
		setLabel("shape creation");
	}

	/**
	 * Can execute if all the necessary information has been provided.
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return newObject instanceof DDataNode && parent != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		parent.addDDataNode(newObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		parent.removeDDataNode(newObject);
	}

}