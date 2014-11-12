package no.hib.dpf.editor.commands.datanode;

import no.hib.dpf.diagram.DDataNode;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;

public class DDataNodeResizeCommand extends Command {
	/** Stores the new size and location. */
	private final Dimension newDimension;
	/** Node to manipulate. */
	private final DDataNode ddatanode;

	/** Stores the old size and location. */
	private Dimension oldDimension;

	public DDataNodeResizeCommand(DDataNode ddatanode, Dimension newDimension) {
		if (ddatanode == null || newDimension == null) {
			throw new IllegalArgumentException();
		}
		this.ddatanode = ddatanode;
		this.newDimension = newDimension.getCopy();
		setLabel("Resize " + ddatanode.getDatanode().getValue());
		oldDimension = ddatanode.getSize();
	}

	@Override
	public void execute() {
		ddatanode.setSize(newDimension);
	}

	@Override
	public void undo() {
		ddatanode.setSize(oldDimension);
	}
}
