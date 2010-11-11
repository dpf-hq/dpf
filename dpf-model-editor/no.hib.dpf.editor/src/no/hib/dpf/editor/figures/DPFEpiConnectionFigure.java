package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

public class DPFEpiConnectionFigure extends DPFConnectionFigure {
		
	
	@Override
	protected void outlineShape(Graphics g) {
		
	//	super.outlineShape(g);
		g.drawText("epi", getPoints().getFirstPoint().translate(-17, 0));
		
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
			bounds.expand(30, 30);
		}
		return bounds;
		
	}
	

}
