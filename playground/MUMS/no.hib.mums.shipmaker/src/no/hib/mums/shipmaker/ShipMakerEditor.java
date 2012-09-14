package no.hib.mums.shipmaker;

import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class ShipMakerEditor extends DiagramEditor {
	public ShipMakerEditor() {
		super();
		
	}
	
	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new PersistenceBehaviour(this);
	}
	
	
}
