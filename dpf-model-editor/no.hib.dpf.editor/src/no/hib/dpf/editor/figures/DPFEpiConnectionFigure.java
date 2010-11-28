package no.hib.dpf.editor.figures;

import org.eclipse.draw2d.geometry.Rectangle;


public class DPFEpiConnectionFigure extends DPFConnectionFigure {
	
	@Override
	public int getRoutingPriority() {
		return super.getRoutingPriority() + 1;
	}
		
	public Rectangle getOwnerBounds() {
		if ((getSourceAnchor() != null) && (this.getSourceAnchor().getOwner() instanceof BasicRectangleFigure)) {
			return ((BasicRectangleFigure)getSourceAnchor().getOwner()).getBounds().getCopy();
		}
		return null;
	}
	
//		
//	private Rectangle outline = new Rectangle(-1, -1, 60, 40);
//
//	@Override
//	protected void outlineShape(Graphics g) {
//		Rectangle figureRect = getFigureRectangle();
//		Rectangle ownerRect = getOwnerRectangle().getCopy();
//		
//		if ((figureRect != null) && (ownerRect != null)) {
//						
//			Rectangle topClip = figureRect.getCopy();
//			if (topClip.y < ownerRect.y) {
//				topClip.height = ownerRect.y - topClip.y;
//				drawArcPart(g, figureRect, topClip.expand(3, 0));
//			} else {
//				collapseRectangle(topClip);				
//			}
//			
//			Rectangle bottomClip = figureRect.getCopy();
//			if (bottomClip.bottom() > ownerRect.bottom()) {
//				bottomClip.y = ownerRect.bottom();
//				drawArcPart(g, figureRect, bottomClip.expand(3, 0));
//			} else {
//				collapseRectangle(bottomClip);				
//			}
//
//			Rectangle leftClip = figureRect.getCopy();
//			if (leftClip.x < ownerRect.x) {
//				leftClip.width = ownerRect.x - leftClip.x;
//				drawArcPart(g, figureRect, leftClip.expand(0, 3));
//			} else {
//				collapseRectangle(leftClip);				
//			}
//			
//			Rectangle rightClip = figureRect.getCopy();
//			if (rightClip.right() > ownerRect.right()) {
//				rightClip.x = ownerRect.right();
//				drawArcPart(g, figureRect, rightClip.expand(0, 3));
//			} else {
//				collapseRectangle(rightClip);				
//			}
//			
//			// Find the point(s) where rectangles hit the figure:
//			
////			g.clipRect(sourceFiguresRect);
////			g.drawArc(sourceFiguresRect, 0, 360);
//		}
//	//	super.outlineShape(g);
////		g.drawText("epi", getPoints().getFirstPoint().translate(-17, 0));
//		
//		counter++;
////		System.out.println(Integer.toString(counter) + ": Outlines EPI Line figure");
//	}
//	
////	private int verticalHit(Rectangle clipRect, Rectangle figureRect) {
////		if ((clipRect.height == 0) && (clipRect.width == 0)) return -1;
////		if ((clipRect.y >= figureRect.y) && (clipRect.y <= figureRect.bottom())) {
////			return clipRect.y;
////		}
////		if ((clipRect.bottom() >= figureRect.y) && (clipRect.bottom() <= figureRect.bottom())) {
////			return clipRect.bottom();
////		}
////		return -1;
////	}
////	
////	private int horizontalHit(Rectangle clipRect, Rectangle figureRect) {
////		if ((clipRect.height == 0) && (clipRect.width == 0)) return -1;
////		if ((clipRect.x >= figureRect.x) && (clipRect.x <= figureRect.right())) {
////			return clipRect.x;
////		}
////		if ((clipRect.right() >= figureRect.x) && (clipRect.right() <= figureRect.right())) {
////			return clipRect.right();
////		}
////		return -1;
////	}
//	
//	public void setNewSize(Dimension dimension) {
//		outline.setSize(dimension);
//	}
//	
//	public void setNewLocation(Point position) {
//		outline.setLocation(position);
//	}
//
//	private void collapseRectangle(Rectangle rect) {
//		rect.height = 0;
//		rect.width = 0;
//	}
//
//	private void drawArcPart(Graphics g, Rectangle figureRect, Rectangle clip) {
//		g.pushState();
//		g.clipRect(clip);
////		g.drawRectangle(figureRect);
//		g.drawArc(figureRect, 0, 360);				
//		g.popState();
//	}
//		
//	/**
//	 * @see IFigure#containsPoint(int, int)
//	 */
//	public boolean containsPoint(int x, int y) {
//		if (pointInOwnerRectangle(x, y)) {
//			return false;
//		}
//		return pointInBounds(x, y);
//	}
//
//	private boolean pointInBounds(int x, int y) {
//		Rectangle figureRectangle = getFigureRectangle();
//		if (figureRectangle != null) {
//			return getBounds().contains(x, y);
//		}
//		return false;
//	}
//	
//	private boolean pointInOwnerRectangle(int x, int y) {
//		Rectangle ownerRectangle = getOwnerRectangle();
//		return ((ownerRectangle != null) && (ownerRectangle.contains(x, y)));
//	}
//	
//	private Rectangle getOwnerRectangle() {
//		if ((getSourceAnchor() != null) && (this.getSourceAnchor().getOwner() instanceof BasicRectangleFigure)) {
//			return ((BasicRectangleFigure)getSourceAnchor().getOwner()).getBounds();
//		}
//		return null;
//	}
//		
//	private Rectangle getFigureRectangle() {
//		
//		Rectangle ownerRect = getOwnerRectangle();
//		if (ownerRect != null) {
//			Rectangle figureRect = outline.getCopy();
////			if (figureRect.width > figureRect.height) {
////				figureRect.width = figureRect.height;
////			} else {				
////				figureRect.height = figureRect.width;
////			}
//			if (figureRect.x == -1) {
//				figureRect.x = ownerRect.x - (figureRect.width/2);
//			}
//			if (figureRect.y == -1) {
//				figureRect.y = ownerRect.y - (figureRect.height/2);
//			}
////			figureRect.height += 35;
//			return figureRect;
//		}
//		return null;
//		
//	}
//	
//	private static int counter = 0;
//	
//	@Override
//	public Rectangle getBounds() {
//		if (bounds == null) {
//			super.getBounds();
//			Rectangle figureRect = getFigureRectangle();
//			if (figureRect != null) {
//				bounds = figureRect;
//			}
//			
//			bounds.expand(10, 10);
//		}
//		return bounds;
//		
//	}
//	
	

}
