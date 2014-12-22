package no.hib.dpf.visualization.commands;

//import no.hib.dpf.core.DataNode;
import no.hib.dpf.diagram.DElement;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.DNodeCreateCommand;
import no.hib.dpf.editor.utilities.DPFMetaLanguageUtils; 
import no.hib.dpf.utils.DPFCoreConstants;
import no.hib.dpf.visual.VElement;
import no.hib.dpf.visualization.VCompartment;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class VNodeCreateCommand extends DNodeCreateCommand {

	EMap<DElement, VElement> maps;
	EList<VCompartment> compartments;
	
	public VNodeCreateCommand(DNode newVNode, DGraph parent, EMap<DElement, VElement> maps, EList<VCompartment> compartments) { 
		super(newVNode, parent);
		this.maps = maps;
		this.compartments = compartments;
	}

	@Override
	public boolean canExecute() {		
		return super.canExecute();
	}

	@Override
	public void execute() {
		super.execute();
	}

	@Override
	public void undo() {
		super.undo();
	}
}