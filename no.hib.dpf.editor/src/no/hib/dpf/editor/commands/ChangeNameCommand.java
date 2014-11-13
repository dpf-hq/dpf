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
import no.hib.dpf.diagram.DNode;

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
		if(object instanceof DNode)
			oldName = ((DNode)object).getNode().getName();
		if(object instanceof DArrow)
			oldName = ((DArrow)object).getArrow().getName();
		setLabel("Change" + oldName + "'s name");
		
	}
	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute()
	{
		if(object instanceof DNode)
			((DNode)object).getNode().setName(newName);
		if(object instanceof DArrow)
			((DArrow)object).getArrow().setName(newName);
	}


	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo()
	{
		if(object instanceof DNode)
			((DNode)object).getNode().setName(oldName);
		if(object instanceof DArrow)
			((DArrow)object).getArrow().setName(oldName);
	}

}