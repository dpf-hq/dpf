package no.hib.dpf.editor.parts;

import java.beans.PropertyChangeListener;

import no.hib.dpf.editor.viewmodel.ModelElement;

import org.eclipse.gef.editparts.AbstractConnectionEditPart;

public abstract class ModelElementConnectionEditPart extends AbstractConnectionEditPart implements PropertyChangeListener {

	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	public void activate() {
		if (!isActive()) {
			super.activate();
			((ModelElement) getModel()).addPropertyChangeListener(this);
		}
	}

	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((ModelElement) getModel()).removePropertyChangeListener(this);
		}
	}


}
