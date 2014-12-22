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
package no.hib.dpf.visualization.policies;
/*
 * Created on Jul 18, 2004
 */

//import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DNode;
//import no.hib.dpf.editor.diagrams.classdiagram.ClassDiagramConstants;
import no.hib.dpf.editor.policies.NameDirectEditPolicy;
import no.hib.dpf.editor.utilities.DPFMetaLanguageUtils;
import no.hib.dpf.editor.utilities.DynamicNodeAttributeDialog;  
import no.hib.dpf.visualization.VCompartmentElement;
import no.hib.dpf.visualization.commands.VCompartmentElementChangeNameCommand;
import no.hib.dpf.visualization.part.VCompartmentElementEditPart;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * EditPolicy for the direct editing of node names
 * 
 */
public class VCompartmentElementNameDirectEditPolicy extends NameDirectEditPolicy {
	/**
	 * @see DirectEditPolicy#getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		Command command = super.getDirectEditCommand(request);
		if(command == null){
			String name = (String) request.getCellEditor().getValue();
			if(getHost() instanceof VCompartmentElementEditPart){
				VCompartmentElement compElement = (VCompartmentElement) getHost().getModel();
				DNode compelementDNode = compElement.getDNode();
				
				// Should be made more generic
				//************************************************************************************************************
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				Assert.isNotNull(shell);
				//ValueDialog dia = new ValueDialog(shell, compelementDNode);
				DynamicNodeAttributeDialog dia = new DynamicNodeAttributeDialog(shell, compelementDNode);
				dia.open();
				//************************************************************************************************************
				
				
				String compElementName = "";
				if(compelementDNode != null && compelementDNode.getNode() != null){
				 	compElementName = compelementDNode.getNode().getName();
				}
				
				if(compElementName != null && !compElementName.equals(name)){
					return new VCompartmentElementChangeNameCommand(compelementDNode.getNode(), name);
				}
			}
		}
		return null;
	}
	
	
	
}