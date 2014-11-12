package no.hib.dpf.editor.commands.datanode;

import java.util.ArrayList;
import java.util.List;

import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.editor.commands.EmptyExecutableCommand;
import no.hib.dpf.editor.commands.attribute.DArrowDAttributeDeleteCommand;
import no.hib.dpf.editor.commands.attribute.DNodeAttributeDeleteCommand;

import org.eclipse.gef.commands.CompoundCommand;

public class DDataNodeDeleteCommand extends CompoundCommand {
	/** Node to remove. */
	private final DDataNode child;
	private final DGraph parent;


	/**
	 * Create a command that will remove the VNode from its parent.
	 * 
	 * @param parent the DPFDiagram containing the child
	 * @param child the VNode to remove
	 * @throws IllegalArgumentException if any parameter is null
	 */
	public DDataNodeDeleteCommand(DDataNode child) {

		if (child == null || child.getDGraph() == null) {
			throw new IllegalArgumentException();
		}
		setLabel("datanode deletion");
		this.parent = child.getDGraph();
		this.child = child;
		
		
		List<DNodeDAttribute> arrows = new ArrayList<DNodeDAttribute>();
		for(DNodeDAttribute attribute : child.getDIncomingDNodeDAttributes()){
			if(!arrows.contains(attribute)){
				add(new DNodeAttributeDeleteCommand((DNodeDAttribute)attribute));
				arrows.add(attribute);
			}
		}
		
		List<DArrowDAttribute> attr = new ArrayList<DArrowDAttribute>();
		for(DArrowDAttribute arrowattribute : child.getDIncomingDArrowDAttributes()){
			if(!attr.contains(arrowattribute)){
				add(new DArrowDAttributeDeleteCommand((DArrowDAttribute)arrowattribute)); 
				attr.add(arrowattribute);
			}
		}
		
		if(getCommands().size() == 0)
			add(EmptyExecutableCommand.INSTANCE);
	}

	@Override
	public boolean canExecute() {
		return ((parent != null) && super.canExecute());
	}

	@Override
	public boolean canUndo() {
		return ((parent != null) && super.canUndo());
	}
	
	@Override
	public void execute() {
		super.execute();
		if(parent != null)
			parent.removeDDataNode(child);
	}
	
	@Override
	public void redo() {
		execute();
	}

	@Override
	public void undo() {
		if(parent != null)
			parent.addDDataNode(child);
		super.undo();
	}
}