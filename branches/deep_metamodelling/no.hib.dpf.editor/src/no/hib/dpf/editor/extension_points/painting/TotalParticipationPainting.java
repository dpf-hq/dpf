package no.hib.dpf.editor.extension_points.painting;

import no.hib.dpf.editor.extension_points.IArrowPainting;
import no.hib.dpf.editor.extension_points.painting.RelationshipPainting.RelationshipAnchor;
import no.hib.dpf.editor.figures.ArrowConnection;

import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class TotalParticipationPainting implements IArrowPainting {


	@Override
	public RotatableDecoration createTargetDecoration() {
		return null;
	}

	@Override
	public PolylineConnection createConnectionFigure() {
		return  new TotalParticipationFigure();
	}

	private abstract class AnchorWithParent implements ConnectionAnchor{
		ConnectionAnchor parent;
		public AnchorWithParent(ConnectionAnchor parent){
			this.parent = parent;
		}
		@Override
		public void addAnchorListener(AnchorListener listener) {
			parent.addAnchorListener(listener);
		}
		@Override
		public Point getLocation(Point reference) {
			Point result =  parent.getLocation(reference);
			final Rectangle rectangle = parent.getOwner() != null ? parent.getOwner().getBounds() : null;
			Rectangle r = Rectangle.SINGLETON;
			if(rectangle != null){
				r.setBounds(rectangle);
				r.translate(-1, -1);
				r.resize(1, 1);
				parent.getOwner().translateToAbsolute(r);
			}

			final Point center = rectangle != null ? r.getCenter() : null;
			return getLocation(result, reference, rectangle, center);
		}
		public abstract Point getLocation(Point result, Point reference,
				Rectangle rectangle, Point center) ;
		@Override
		public IFigure getOwner() {
			return parent.getOwner();
		}
		@Override
		public Point getReferencePoint() {
			return parent.getReferencePoint();
		}
		@Override
		public void removeAnchorListener(AnchorListener listener) {
			parent.removeAnchorListener(listener);
		}
	}
	private class TotalParticipationFigure extends ArrowConnection {
		PolylineConnection up ;
		PolylineConnection down ;
		@Override
		public void revalidate() {
			super.revalidate();
		}
		public TotalParticipationFigure(){
			super();
			if(up == null){
				up = new PolylineConnection();
				this.add(up);
			}
			if(down == null){
				down = new PolylineConnection();
				this.add(down);
			}
		}
		@Override
		public void setRoutingConstraint(Object cons) {
			super.setRoutingConstraint(cons);
			up.setRoutingConstraint(cons);
			down.setRoutingConstraint(cons);
		}
		@Override
		public void setSourceAnchor(final ConnectionAnchor anchor) {
			
			if(anchor == null){
				super.setSourceAnchor(null);
				return;
			}
			up.setSourceAnchor(new AnchorWithParent(anchor){

				@Override
				public Point getLocation(Point result, Point reference,
						Rectangle rectangle, Point center) {
					if(center != null){
						if(parent instanceof RelationshipAnchor){
							Point rr = getTranslate(center, result);
							return getTranslateBack(turn(rr, -Math.PI/4, 5*Math.sqrt(2)), result);
						}
						if(parent instanceof ChopboxAnchor){
							int area = getAreaNumber(rectangle, result);
							switch(area){
							case 1: result.y += 5; break;
							case 2: result.x -= 5; break;
							case 3: result.y -= 5; break;
							case 4: result.x += 5; break;
							}
							return result;
						}
					}
					return result.getTranslated(5, 5);
				}
			});
			down.setSourceAnchor(new AnchorWithParent(anchor){

				@Override
				public Point getLocation(Point result, Point reference,
						Rectangle rectangle, Point center) {
					if(center != null){
						if(parent instanceof RelationshipAnchor){
							Point rr = getTranslate(center, result);
							return getTranslateBack(turn(rr, Math.PI/4, 5*Math.sqrt(2)), result);
						}
					}
					if(parent instanceof ChopboxAnchor){
						int area = getAreaNumber(rectangle, result);
						switch(area){
						case 1: result.y -= 5; break;
						case 2: result.x += 5; break;
						case 3: result.y += 5; break;
						case 4: result.x -= 5; break;
						}
						return result;
					}
					return result.getTranslated(-5, -5);
				}
			});
			super.setSourceAnchor(anchor);
		}
		@SuppressWarnings("unused")
		public double getAngle(Point a, Point b, Point c){
			a = getTranslate(a, b);
			c = getTranslate(c, b);
			double result = (a.x * c.x + a.y * c.y)/(getLength(a) * getLength(c));
			return Math.acos(result);
		}
		public int getAreaNumber(Rectangle d, Point a){

			Point center = d.getCenter();
			Point r_a = getTranslate(a, center);
			double ration = r_a.x == 0 ? Double.MAX_VALUE : (double)r_a.y / (double)r_a.x;
			double c_r = (double)d.height / (double)d.width;
			if(ration > c_r || ration < -c_r){
				if(r_a.y > 0) return 2;
				return 4;
			}
			if(r_a.x > 0) return 1;
			return 3;
		}
		@Override
		public void setTargetAnchor(ConnectionAnchor anchor) {
			if(anchor == null){
				super.setTargetAnchor(null);
				return;
			}
			up.setTargetAnchor(new AnchorWithParent(anchor){
				@Override
				public Point getLocation(Point result, Point reference,
						Rectangle rectangle, Point center) {
					if(center != null){
						if(parent instanceof RelationshipAnchor){
							Point rr = getTranslate(center, result);
							return getTranslateBack(turn(rr, Math.PI/4, 5*Math.sqrt(2)), result);
						}
						if(parent instanceof ChopboxAnchor){
							int area = getAreaNumber(rectangle, result);
							switch(area){
							case 1: result.y -= 5; break;
							case 2: result.x += 5; break;
							case 3: result.y += 5; break;
							case 4: result.x -= 5; break;
							}
							return result;
						}
					}
					return result.getTranslated(5, 5);
				}
			});
			down.setTargetAnchor(new AnchorWithParent(anchor){

				@Override
				public Point getLocation(Point result, Point reference,
						Rectangle rectangle, Point center) {
					if(center != null){
						if(parent instanceof RelationshipAnchor){
							Point rr = getTranslate(center, result);
							return getTranslateBack(turn(rr, -Math.PI/4, 5*Math.sqrt(2)), result);
						}
						if(parent instanceof ChopboxAnchor){
							int area = getAreaNumber(rectangle, result);
							switch(area){
							case 1: result.y += 5; break;
							case 2: result.x -= 5; break;
							case 3: result.y -= 5; break;
							case 4: result.x += 5; break;
							}
							return result;
						}
					}
					return result.getTranslated(-5, -5);
				}
			});
			super.setTargetAnchor(anchor);
		}
		@Override
		public void setEnabled(boolean value) {
			super.setEnabled(value);
			if(value == true){
				up.setEnabled(true);
				down.setEnabled(true);
			}

		}
		@Override
		public void addNotify() {
			super.addNotify();
			if (getSourceAnchor() != null)
				getSourceAnchor().addAnchorListener(this);
			if (getTargetAnchor() != null)
				getTargetAnchor().addAnchorListener(this);
		}
		@Override
		public void addPoint(Point current) {
			super.addPoint(current);
			System.out.println(current);
//			PointList points = getPoints();
//			int size = getPoints().size();
//			if(size > 2)
			/*{
				if(up == null){
					up = new PolylineConnection();
					this.add(up);
					up.getPoints().removeAllPoints();
					up.addPoint(current);
				}
				if(down == null){
					down = new PolylineConnection();
					this.add(down);
					down.getPoints().removeAllPoints();
					down.addPoint(current);
				}
			}else{*/
//				{
//				Point up_pre = up.getPoints().get;
//				Point down_pre = down.getPoints().getLastPoint();
//				Point pre = points.getLastPoint();
//				double length = getBounds().width/2;
//				if(length > 10)
//					length = 10;//getLength(pre,current);
//					double degree = Math.PI/2;
//					Point current_up = getTurnScalePointAccordingToSecond(pre, current, -degree, length);
//					Point current_down = getTurnScalePointAccordingToSecond(pre, current, degree, length);
//					Point pre_up = getTurnScalePointAccordingToSecond(current, pre, degree, length);				
//					Point pre_down = getTurnScalePointAccordingToSecond(current, pre, -degree, length);
//					if(size == 1){
//						up_pre = pre_up;
//						down_pre = pre_down;
//					}
//					if(size > 2){
//						Point up_pre_pre = up.getPoints().getPoint(size - 2);
//						Point down_pre_pre = down.getPoints().getPoint(size - 2);
//						up_pre = getCrossPoint(up_pre, up_pre_pre, pre_up, current_up);
//						down_pre = getCrossPoint(down_pre, down_pre_pre, pre_down, current_down);
//					}
//					up.addPoint(current_up);
//					down.addPoint(current_down);
//				}
//			}
		}
		@Override
		protected void outlineShape(Graphics g) {
		}

//		public Point getTurnScalePointAccordingToSecond(Point a, Point b, double angle, double scale){
//			return getTranslateBack(turn(getTranslate(a, b), angle, scale), b);
//		}
		Point getTranslate(Point a, Point b){
			return new Point(a.x - b.x, a.y - b.y);
		}
		Point getTranslateBack(Point a, Point b){
			return new Point(a.x + b.x, a.y + b.y);
		}
		Point turn(Point a, double angle, double scale){
			double sin = Math.sin(angle);
			double cos = Math.cos(angle);
			return new Point((int)(a.x * cos - a.y * sin), (int)(a.x * sin + a.y * cos)).scale(scale/getLength(a)); 
		}
		double getLength(Point a){
			return Math.sqrt(a.x * a.x + a.y * a.y);
		}

//		double getSlope(Point a, Point b){
//			return (b.y - a.y)/(b.x - a.x);
//		}
//		Point getCrossPoint(Point a, Point b, Point c, Point d){
//			double ka = getSlope(a, b);
//			double kc = getSlope(c, d);
//			double x = (c.y - a.y + (ka * a.x - kc * c.x))/(ka - kc);
//			double y = a.y + ka * (x - a.x);
//			return new Point((int)x, (int)y);
//		}
	}


}
