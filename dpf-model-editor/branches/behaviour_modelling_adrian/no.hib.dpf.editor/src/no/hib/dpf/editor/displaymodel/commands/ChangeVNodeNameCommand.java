/*******************************************************************************
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel.commands;


import no.hib.dpf.editor.displaymodel.DNode;

import org.eclipse.gef.commands.Command;


/**
 * Command to change the name field
 * 
 * @author Phil Zoio
 */
public class ChangeVNodeNameCommand extends Command
{

	private DNode shape;
	private String name, oldName;

	/**
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute()
	{
		shape.setNameExec(name);
	}

	/**
	 * @return whether we can apply changes
	 */
	public boolean canExecute()
	{
		if (name != null)
		{
			return true;
		}
		else
		{
			name = oldName;
			return false;
		}
	}

	/**
	 * Sets the new Column name
	 * 
	 * @param string
	 *            the new name
	 */
	public void setName(String string)
	{
		this.name = string;
	}

	/**
	 * Sets the old Column name
	 * 
	 * @param string
	 *            the old name
	 */
	public void setOldName(String string)
	{
		oldName = string;
	}

	public void setShape(DNode shape)
	{
		this.shape = shape;
	}

	/**
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo()
	{
		shape.setNameExec(oldName);
	}

}