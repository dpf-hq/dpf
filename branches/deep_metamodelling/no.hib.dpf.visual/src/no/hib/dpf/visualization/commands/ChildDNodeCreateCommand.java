/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * 
 * Portions of the code Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Elias Volanakis - initial API and implementation
 * 
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.visualization.commands;

import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import no.hib.dpf.core.DataNode;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.commands.node.DNodeCreateCommand;
import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
import no.hib.dpf.editor.diagrams.classdiagram.dialogs.ClassDiagramMethodDialog;
import no.hib.dpf.editor.utilities.DPFMetaLanguageUtils;
import no.hib.dpf.editor.utilities.DPFModelUtils;
import no.hib.dpf.editor.utilities.DPFTemplateUtils; 
import no.hib.dpf.utils.DPFCoreConstants;
import no.hib.dpf.visualization.VCompartment;
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.VisualizationFactory;
import no.hib.dpf.visualization.util.VisualizationModelUtils;

/**
 * A command to add a Shape to a ShapeDiagram.
 * The command can be undone or redone.
 * @author Elias Volanakis
 */
public class ChildDNodeCreateCommand extends DNodeCreateCommand {

	/** Diagram to add to. */
	private final VCompartment compartment;
	private final DNode parentNode;

	/**
	 * Create a command that will add a new Shape to a ShapesDiagram.
	 * @param newDNode the new VNode that is to be added
	 * @param parentNode the ShapesDiagram that will hold the new element
	 * @param parent 
	 * @param bounds the bounds of the new shape; the size can be (-1, -1) if not known
	 * @throws IllegalArgumentException if any parameter is null, or the request
	 * 						  does not provide a new Shape instance
	 */
	public ChildDNodeCreateCommand(DNode newDNode, DNode parentNode, VCompartment compartment, DGraph parent) {
		super(newDNode, parent);
		this.parentNode = parentNode; 
		this.compartment = compartment;
		setLabel("shape creation");
	}

	/**
	 * Can execute if all the necessary information has been provided. 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if(compartment == null || parentNode == null || parent == null){
			return false;
		}
		
		return VisualizationModelUtils.canConnect(newObject, parentNode);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {	
		super.execute();
		
		if(newObject == null || newObject.getDType() == null){
			return;
		}
		
		// create connection between container and method
		connect(newObject, parentNode);
		
		
		// TODO: The code below should be made more generic. 
		//******************************************************************************************************************************
		if(newObject.getDType().getName().equals(ClassDiagramConstants.NODE_METHOD)){
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			Assert.isNotNull(shell);
			ClassDiagramMethodDialog dialog = new ClassDiagramMethodDialog(shell, parent,  newObject);
			newObject = dialog.open();  //
		}
		//******************************************************************************************************************************
	}

	private void connect(DNode newObject, DNode parentNode2) {
		DArrow connectionDArrow = null;
		DNode newObjectDType = newObject.getDType();
		if(newObjectDType == null){
			return;
		}
		
		
		for (DArrow typeDArrow : newObject.getDType().getDIncomings()) {
			
			DNode sourceDNodeDType = typeDArrow.getDSource();
			DNode targetDNodeDType = parentNode.getDType();
			if(sourceDNodeDType == null || targetDNodeDType == null){
				continue;
			}
			
			DNode templateSourceDNode = sourceDNodeDType.getTemplateDNode();
			DNode templateTargetDNode = targetDNodeDType.getTemplateDNode();
			if(templateSourceDNode == null || templateTargetDNode == null){
				continue;
			}
			
			if(templateSourceDNode == templateTargetDNode){
				connectionDArrow = DPFModelUtils.createDArrow(typeDArrow);
				DPFModelUtils.connectDArrow(parentNode, connectionDArrow, newObject);
				connectionDArrow.getArrow().setPotency(newObject.getNode().getPotency());
				DPFTemplateUtils.replicateTemplateArrowAttributesForArrow(connectionDArrow, parent);
				parent.addDArrow(connectionDArrow); 
				
				// Wrap the node in a compartmentElement and add it to the compartment
				VCompartmentElement compElement = VisualizationFactory.eINSTANCE.createVCompartmentElement();
				compElement.setDNode(newObject);
				compartment.addChild(compElement);
				break;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		// Remove figure...
		Iterator<VCompartmentElement> it = compartment.getChildren().iterator();
		while(it.hasNext()) {
			if(it.next().getDNode()==newObject)
				it.remove();
		}
		parent.removeDNode(newObject);
	}
}