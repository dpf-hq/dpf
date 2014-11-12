package protoedit.commands;

import org.eclipse.gef.commands.Command;

import protomodel.Clazz;
import protomodel.Diagram;
import protomodel.ProtomodelFactory;

public class CreateClassCommand extends Command {

	private Diagram diagram;
	private Clazz clazz;

	public CreateClassCommand(Diagram diagram, String name) {
		this.diagram = diagram;
		clazz = ProtomodelFactory.eINSTANCE.createClazz();
		clazz.setName(name);
		
	}
	
	@Override
	public void execute() {
		diagram.getClasses().add(clazz);
	}
	
	@Override
	public void undo() {
		diagram.getClasses().remove(clazz);
	}

}
