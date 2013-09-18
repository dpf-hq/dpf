package no.hib.dpf.editor.commands;

import no.hib.dpf.diagram.DNode;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

public abstract class AbstractCreateCommand extends Command {

	protected Dimension bounds;
	protected Point start;
	protected DNode newObject;
}
