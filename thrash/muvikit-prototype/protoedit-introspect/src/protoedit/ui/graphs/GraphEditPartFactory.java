package protoedit.ui.graphs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import protoedit.editparts.graphs.DiagramEditPart;
import protomodel.Diagram;

public class GraphEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof Diagram) {
			return new DiagramEditPart((Diagram) model);
		}
		Assert.isTrue(model == null,
				getClass().getName() + " could not create an EditPart for the model element " + model);
		return null;
	}
	

}
