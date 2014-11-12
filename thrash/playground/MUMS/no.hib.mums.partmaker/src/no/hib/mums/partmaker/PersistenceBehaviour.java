package no.hib.mums.partmaker;

import no.hib.mums.shared.DPFResourceHandler;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class PersistenceBehaviour extends DefaultPersistencyBehavior {

	private DiagramEditor de = null;
	
	public PersistenceBehaviour(DiagramEditor diagramEditor) {
		super(diagramEditor);
		this.de = diagramEditor;
	}

	@Override
	public void saveDiagram(IProgressMonitor monitor) {
		System.out.println("PartMaker: Save diagram");
		CommandStack cs = de.getEditingDomain().getCommandStack();
		
		DiagramTypeProvider dtp = (DiagramTypeProvider)de.getDiagramTypeProvider();
		final DPFResourceHandler drh = dtp.getResourceHandler();
		
		cs.execute(new RecordingCommand(de.getEditingDomain()) {
			
			@Override
			protected void doExecute() {
				drh.saveSpecification();
			}
		});
		super.saveDiagram(monitor);
	}
	
	
}
