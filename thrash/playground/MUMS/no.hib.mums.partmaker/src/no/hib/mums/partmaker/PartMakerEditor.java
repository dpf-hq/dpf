package no.hib.mums.partmaker;

import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class PartMakerEditor extends DiagramEditor {
	public PartMakerEditor() {
		super();
		
	}
	
	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new PersistenceBehaviour(this);
	}
	
	
}
