package no.hib.dpf.editor.parts;

import org.eclipse.gef.EditPart;

public class DConstraintFromNodeEditPart extends DConstraintEditPart {

	public void setTarget(EditPart target){
		super.setTarget(target);
//		if(getSource() instanceof DComposedNodePart && target instanceof DNodeEditPart){
//			DComposedNodePart source = (DComposedNodePart)getSource();
//			DConstraintNode node = source.getDConstraintNode(); 
//			if(node.getLocation() == null){
//				DNodeEditPart nodePart = (DNodeEditPart)target;
//				Rectangle bounds = nodePart.getFigure().getBounds();
//				Label label = source.getLabel();
//				Point initial = bounds.getTop();
//				initial.y -= label.getSize().height;
//				initial.x -= (label.getSize().width/2); 
//				node.setLocation(initial);
//			}
//		}
	}
}
