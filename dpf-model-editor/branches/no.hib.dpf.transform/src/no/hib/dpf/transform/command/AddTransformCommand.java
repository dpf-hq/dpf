package no.hib.dpf.transform.command;

import java.util.List;

import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.provider.ProductionItemProvider;
import no.hib.dpf.transform.util.TransformAdapterFactory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class AddTransformCommand extends Command {
	
	private final DGraph parent;
	private DNode newObject;
	private List<Production> rules;
	private Production production;
	
	public AddTransformCommand(DNode editNode, DGraph parent){
		this.newObject = editNode;
		this.parent = parent;
		production = (Production) parent.eContainer().eContainer();
		setLabel("add transform rule");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return newObject instanceof DNode && parent != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		System.out.println("Rule: " + production.getName());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		
	}
}
