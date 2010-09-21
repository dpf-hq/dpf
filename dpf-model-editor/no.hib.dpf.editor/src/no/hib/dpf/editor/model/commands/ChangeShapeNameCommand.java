package no.hib.dpf.editor.model.commands;


import no.hib.dpf.editor.model.Shape;

import org.eclipse.gef.commands.Command;


/**
 * Command to change the name field
 * 
 * @author Phil Zoio
 */
public class ChangeShapeNameCommand extends Command
{

	private Shape shape;
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

	public void setShape(Shape shape)
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