package no.hib.dpf.editor.commands.datanode;

import no.hib.dpf.diagram.DConstraintNode;
import no.hib.dpf.diagram.DDataNode;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

public class DDataNodeMoveCommand extends Command {
	/** Stores the new size and location. */
	private final Point newLocation;
	/** Node to manipulate. */
	private final DDataNode ddatanode;

	/** Stores the old size and location. */
	private Point oldLocation;

	/**
	 * Create a command that can resize and/or move a shape. 
	 * @param ddatanode	the shape to manipulate
	 * @param newLocation the new location
	 * @throws IllegalArgumentException if any of the parameters is null
	 */
	public DDataNodeMoveCommand(DDataNode ddatanode, Point newLocation) {
		if (ddatanode == null || newLocation == null) {
			throw new IllegalArgumentException();
		}
		String name = null;
		if(ddatanode instanceof DConstraintNode){
			name = ((DConstraintNode)ddatanode).getDConstraint().getDPredicate().getPredicate().getSymbol(); 
		}else
			name = ddatanode.getDatanode().getValue();
		setLabel("Move " + name);
		this.ddatanode = ddatanode;
		this.newLocation = newLocation.getCopy();
		oldLocation = ddatanode.getLocation();
	}

	@Override
	public void execute() {
		ddatanode.setLocation(newLocation);
	}

	@Override
	public void undo() {
		ddatanode.setLocation(oldLocation);
	}
}
