package protoedit.editparts.tree;

import protomodel.Diagram;
import muvitorkit.gef.editparts.AdapterTreeEditPart;

public class DiagramTreeEditPart extends AdapterTreeEditPart<Diagram> {

	public DiagramTreeEditPart(Diagram model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String getText() {
		return getCastedModel().getName();
	}

}
