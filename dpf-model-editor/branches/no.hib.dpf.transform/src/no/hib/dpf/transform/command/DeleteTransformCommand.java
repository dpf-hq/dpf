package no.hib.dpf.transform.command;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.eclipse.gef.commands.Command;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.impl.TransformFactoryImpl;
import no.hib.dpf.transform.presentation.ProductionDetailBlock;
import no.hib.dpf.transform.presentation.TransformEditor;
import no.hib.dpf.transform.presentation.TransformFormPage;
import no.hib.dpf.transform.presentation.TransformMasterBlock;
import no.hib.dpf.transform.provider.TransformEditPlugin;
import no.hib.dpf.transform.util.TransformActivePage;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class DeleteTransformCommand extends Command {
	
	private final DGraph parent;
	private Object newObject;
	private Production production;
	
	public DeleteTransformCommand(Object editNode, DGraph parent){
		this.newObject = editNode;
		this.parent = parent;
		production = (Production) parent.eContainer().eContainer();
		setLabel("delete transform rule");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return newObject instanceof DNode || newObject instanceof DArrow  && parent != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		System.out.println("Hva er her " + production.getName());
		production.getLeftNodes().add((DNode) newObject);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		if(newObject instanceof DNode){
			System.out.println("Node: " + ((DNode) newObject).getName());
			production.getLeftNodes().remove((DNode) newObject);
		}
		else{
			System.out.println("Arrow: " + ((DArrow) newObject).getName());
			production.getLeftArrows().remove((DArrow) newObject);
		}
	}
}
