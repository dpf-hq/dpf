package protoedit.editparts.tree;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class ProtoTreeEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof EObject) {
			EObject eModel = (EObject) model;
			return new GenericTreeEditPart(eModel);
		} else {
			Assert.isTrue(model == null, "TreeEditPartFActory could not create an EditPart for model element " + model);
			return null;
		}
	}

//	@Override
//	public EditPart createEditPart(EditPart context, Object model) {
//		if(model instanceof Diagram) {
//			return new DiagramTreeEditPart((Diagram) model);
//		}
//		if(model instanceof Reference) {
//			return new ReferenceTreeEditPart((Reference) model);
//		}
//		if(model instanceof Clazz) {
//			return new ClazzTreeEditPart((Clazz) model);
//		}
//		Assert.isTrue(model == null,
//				"TreeEditPartFactory could not create an EditPart for model element " + model);
//		return null;
//	}
	
	

}
