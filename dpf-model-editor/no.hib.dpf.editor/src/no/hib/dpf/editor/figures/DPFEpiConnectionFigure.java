package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

public class DPFEpiConnectionFigure extends DPFConnectionFigure {
		
	
	@Override
	protected void outlineShape(Graphics g) {
		if ((getSourceAnchor() != null) && (this.getSourceAnchor().getOwner() instanceof BasicRectangleFigure)) {
			Rectangle sourceFiguresRect = ((BasicRectangleFigure)getSourceAnchor().getOwner()).getBounds();
			//g.drawArc(sourceFiguresRect.x, sourceFiguresRect.y, 80, 80, 0, 150);
			Rectangle sourceFiguresRectCopy = sourceFiguresRect.getCopy();
			if (sourceFiguresRectCopy.width > sourceFiguresRectCopy.height) {
				sourceFiguresRectCopy.width = sourceFiguresRectCopy.height;
			} else {				
				sourceFiguresRectCopy.height = sourceFiguresRectCopy.width;
			}
			sourceFiguresRectCopy.x = sourceFiguresRect.x - (sourceFiguresRectCopy.width/2);
			sourceFiguresRectCopy.y = sourceFiguresRect.y - (sourceFiguresRectCopy.height/2);
			g.drawArc(sourceFiguresRectCopy, 0, 270);
		}
	//	super.outlineShape(g);
//		g.drawText("epi", getPoints().getFirstPoint().translate(-17, 0));
		
		counter++;
//		System.out.println(Integer.toString(counter) + ": Outlines EPI Line figure");
	}
	
	private static int counter = 0;
	
	@Override
	public Rectangle getBounds() {
		if (bounds == null) {
			super.getBounds();
			for (int i = 0; i < getChildren().size(); i++) {
				IFigure child = (IFigure) getChildren().get(i);
				bounds.union(child.getBounds());
			}
			bounds.expand(300, 300);
		}
		return bounds;
		
	}
	

}
