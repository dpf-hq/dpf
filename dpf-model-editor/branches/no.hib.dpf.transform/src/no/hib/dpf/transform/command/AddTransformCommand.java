package no.hib.dpf.transform.command;


import java.util.List;

import no.hib.dpf.core.Specification;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DSignature;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.Transform;
import no.hib.dpf.transform.henshin.TranslateToHenshinRules;
import no.hib.dpf.transform.provider.ProductionItemProvider;
import no.hib.dpf.transform.util.TransformActivePage;
import no.hib.dpf.transform.util.TransformAdapterFactory;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import org.eclipse.core.internal.registry.OffsetTable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

public class AddTransformCommand extends Command {
	
//	private final DGraph parent;
	private Object insertObject;
	private List<Production> rules;
	private Production production;
	
	public AddTransformCommand(Object editNode, Production prod){
		this.insertObject = editNode;
		this.production = prod;
		//production = (Production) parent.eContainer().eContainer();
		setLabel("Insertion element");
//		Specification spec = production.getSum().getSpecification();
//		System.out.println("Get Metafile " + spec.getMetaFile());
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	public boolean canExecute() {
		return insertObject instanceof DNode || insertObject instanceof DArrow && production != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {
		System.out.println("Rule: " + production.getName());
		if(insertObject instanceof DNode){
			if(production.getLeftNodes().contains(insertObject)){
				production.getLeftNodes().remove(insertObject);
			}
			if(production.getCommonNodes().contains(insertObject)){
				production.getCommonNodes().remove(insertObject);
			}
			System.out.println(" her " + ((DNode) insertObject).getConfigureString());
			production.getRightNodes().add((DNode) insertObject);
		}
		if(insertObject instanceof DArrow){
			if(production.getLeftArrows().contains(insertObject)){
				production.getLeftArrows().remove(insertObject);
			}
			if(production.getCommonArrows().contains(insertObject)){
				production.getCommonArrows().remove(insertObject);
			}
			((DArrow) insertObject).getArrow().setName("create--");
			production.getRightArrows().add((DArrow) insertObject);
			
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		if(insertObject instanceof DNode){
			production.getRightNodes().remove((DNode) insertObject);
		}
		if(insertObject instanceof DArrow){
			production.getRightArrows().remove((DArrow) insertObject);
		}
	}
}
