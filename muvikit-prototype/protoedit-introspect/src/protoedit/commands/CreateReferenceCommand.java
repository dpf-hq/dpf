package protoedit.commands;

import org.eclipse.gef.commands.Command;

import protomodel.Clazz;
import protomodel.ProtomodelFactory;
import protomodel.Reference;

public class CreateReferenceCommand extends Command {
	private Clazz clazz;
	private Reference reference;
	
	public CreateReferenceCommand(Clazz clazz, String name) {
		this.clazz = clazz;
		this.reference = ProtomodelFactory.eINSTANCE.createReference();
		this.reference.setName(name);
		this.reference.setSource(clazz);
		this.reference.setDest(clazz);
	}
	
	@Override
	public void execute() {
		clazz.getReferences().add(reference);
	}
	
	@Override
	public void undo() {
		clazz.getReferences().remove(reference);
	}
	
}
