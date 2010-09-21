package no.hib.dpf.editor.policies;
/*
 * Created on Jul 18, 2004
 */

import no.hib.dpf.editor.model.Shape;
import no.hib.dpf.editor.model.commands.ChangeShapeNameCommand;
import no.hib.dpf.editor.parts.ShapeEditPart;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.jface.viewers.CellEditor;

/**
 * EditPolicy for the direct editing of shape names
 * 
 * @author Phil Zoio
 */
public class ShapeDirectEditPolicy extends DirectEditPolicy
{

	private String oldValue;

	/**
	 * @see DirectEditPolicy#getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
	 */
	protected Command getDirectEditCommand(DirectEditRequest request)
	{
		ChangeShapeNameCommand cmd = new ChangeShapeNameCommand();
		Shape shape = (Shape) getHost().getModel();
		cmd.setShape(shape);
		cmd.setOldName(shape.getNameExec());
		CellEditor cellEditor = request.getCellEditor();
		cmd.setName((String) cellEditor.getValue());
		return cmd;
	}

	/**
	 * @see DirectEditPolicy#showCurrentEditValue(org.eclipse.gef.requests.DirectEditRequest)
	 */
	protected void showCurrentEditValue(DirectEditRequest request)
	{
		String value = (String) request.getCellEditor().getValue();
		ShapeEditPart shapeEditPart = (ShapeEditPart) getHost();
		shapeEditPart.handleNameChange(value);
	}

	/**
	 * @param to
	 *            Saves the initial text value so that if the user's changes are not committed then 
	 */
	protected void storeOldEditValue(DirectEditRequest request)
	{
		
		CellEditor cellEditor = request.getCellEditor();
		oldValue = (String) cellEditor.getValue();
	}

	/**
	 * @param request
	 */
	protected void revertOldEditValue(DirectEditRequest request)
	{
		CellEditor cellEditor = request.getCellEditor();
		cellEditor.setValue(oldValue);
		ShapeEditPart shapeEditPart = (ShapeEditPart)getHost();
		shapeEditPart.revertNameChange();
	}
}