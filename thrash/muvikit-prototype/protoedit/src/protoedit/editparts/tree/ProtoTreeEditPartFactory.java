package protoedit.editparts.tree;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import protomodel.Clazz;
import protomodel.Diagram;
import protomodel.Reference;

public class ProtoTreeEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof Diagram) {
			return new DiagramTreeEditPart((Diagram) model);
		}
		if(model instanceof Reference) {
			return new ReferenceTreeEditPart((Reference) model);
		}
		if(model instanceof Clazz) {
			return new ClazzTreeEditPart((Clazz) model);
		}
		Assert.isTrue(model == null,
				"TreeEditPartFactory could not create an EditPart for model element " + model);
		return null;
	}

}
