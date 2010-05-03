package protoedit.commands;

import muvitorkit.commands.SimpleDeleteEObjectCommand;

import org.eclipse.gef.commands.CompoundCommand;

import protomodel.Reference;

public class DeleteReferenceCommand extends CompoundCommand {
	public DeleteReferenceCommand(Reference reference) {
		add(new SimpleDeleteEObjectCommand(reference));
	}
}
