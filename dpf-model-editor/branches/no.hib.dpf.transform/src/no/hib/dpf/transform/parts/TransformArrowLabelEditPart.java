package no.hib.dpf.transform.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DOffset;
import no.hib.dpf.editor.parts.ArrowLabelEditPart;
import no.hib.dpf.transform.Production;
import no.hib.dpf.transform.preferences.TransformEditorPreferences;

public class TransformArrowLabelEditPart extends ArrowLabelEditPart {
	private DArrow element = null;
	private Production production = null;
	private Label label = null;
	
	public TransformArrowLabelEditPart(DOffset modelElement) {
		element = (DArrow) modelElement.eContainer();
		production = (Production) element.eContainer().eContainer().eContainer();
	}

	@Override
	public IFigure createFigure() {
		label = new Label();
		
		if(production.getLeftArrows().contains(element)){
			label.setForegroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
		}
		if(production.getCommonArrows().contains(element)){
			label.setForegroundColor(TransformEditorPreferences.getDefault().getPreserveForegroundColor());
		}
		if(production.getRightArrows().contains(element)){
			label.setForegroundColor(TransformEditorPreferences.getDefault().getInsertForegroundColor());
		}
		label.setOpaque(true);
		return label;
	}
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		if(production.getLeftArrows().contains(element)){
			label.setForegroundColor(TransformEditorPreferences.getDefault().getDeleteForegroundColor());
		}
		if(production.getCommonArrows().contains(element)){
			label.setForegroundColor(TransformEditorPreferences.getDefault().getPreserveForegroundColor());
		}
		if(production.getRightArrows().contains(element)){
			label.setForegroundColor(TransformEditorPreferences.getDefault().getInsertForegroundColor());
		}
	}
}
