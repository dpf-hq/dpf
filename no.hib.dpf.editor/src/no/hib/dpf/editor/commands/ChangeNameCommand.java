/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.commands;



import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;


/**
 * Command to change the name field
 * 
 * @author Phil Zoio
 */
public class ChangeNameCommand extends Command
{

	private Object object;
	private String newName, oldName;

	public ChangeNameCommand(Object node, String name){
		super();
		Assert.isTrue(node != null);
		object = node;
		newName = name;
		if(object instanceof DNode){
			oldName = ((DNode)object).getNode().getName();
		}
		
		if(object instanceof DDataNode){
			oldName = ((DDataNode)object).getDatanode().getValue();
		}
		
		if(object instanceof DArrowDAttribute){
			oldName = ((DArrowDAttribute)object).getArrowAttribute().getName();
		}
		
		if(object instanceof DNodeDAttribute){
			oldName = ((DNodeDAttribute)object).getNodeAttribute().getName();
		}
		
		if(object instanceof DArrow){
			oldName = ((DArrow)object).getArrow().getName();
		}
		
		setLabel("Change" + oldName + "'s name");
	}
	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute()
	{
		if(object instanceof DNode){
			((DNode)object).getNode().setName(newName);
		}	
		
		if(object instanceof DDataNode){
			((DDataNode)object).getDatanode().setValue(newName);
		}
		
		if(object instanceof DArrowDAttribute){
			((DArrowDAttribute)object).getArrowAttribute().setName(newName);
		}
		
		if(object instanceof DNodeDAttribute){
			((DNodeDAttribute)object).getNodeAttribute().setName(newName);
		}
		
		if(object instanceof DArrow){
			((DArrow)object).getArrow().setName(newName);
		}
		
		
	}


	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo(){
		if(object instanceof DNode){
			((DNode)object).getNode().setName(oldName);
		}
		
		if(object instanceof DDataNode){
			((DDataNode)object).getDatanode().setValue(oldName);
		}
		
		if(object instanceof DArrowDAttribute){
			((DArrowDAttribute)object).getArrowAttribute().setName(oldName);
		}
		
		if(object instanceof DNodeDAttribute){
			((DNodeDAttribute)object).getNodeAttribute().setName(oldName);
		}
		
		if(object instanceof DArrow){
			((DArrow)object).getArrow().setName(oldName);
		}
	}

}