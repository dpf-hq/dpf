package no.hib.dpf.editor.figures;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.AnchorListener;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * The ChopboxAnchor's location is found by calculating the intersection of a
 * line drawn from the center point of its owner's box to a reference point on
 * that box. Thus {@link Connection Connections} using the ChopBoxAnchor will be
 * oriented such that they point to their owner's center.
 */
public class LineConstraintAnchor implements AncestorListener, ConnectionAnchor  {

	private IFigure owner;
	private List listeners = new ArrayList(1);
	

	/**
	 * Constructs a new ChopboxAnchor.
	 */
	public LineConstraintAnchor() {
	}
	
	/**
	 * Constructs a ChopboxAnchor with the given <i>owner</i> figure.
	 * 
	 * @param owner
	 *            The owner figure
	 * @since 2.0
	 */
	public LineConstraintAnchor(IFigure owner) {
		setOwner(owner);
	}

	/**
	 * Gets a Rectangle from {@link #getBox()} and returns the Point where a
	 * line from the center of the Rectangle to the Point <i>reference</i>
	 * intersects the Rectangle.
	 * 
	 * @param reference
	 *            The reference point
	 * @return The anchor location
	 */
	public Point getLocation(Point reference) {
		
		Random random = new Random();
		return new Point(random.nextInt(400), random.nextInt(400));	
		
//		Rectangle r = Rectangle.SINGLETON;
//		r.setBounds(getBox());
//		r.translate(-1, -1);
//		r.resize(1, 1);
//
//		getOwner().translateToAbsolute(r);
//		float centerX = r.x + 0.5f * r.width;
//		float centerY = r.y + 0.5f * r.height;
//
//		if (r.isEmpty()
//				|| (reference.x == (int) centerX && reference.y == (int) centerY))
//			return new Point((int) centerX, (int) centerY); // This avoids
//															// divide-by-zero
//
//		float dx = reference.x - centerX;
//		float dy = reference.y - centerY;
//
//		// r.width, r.height, dx, and dy are guaranteed to be non-zero.
//		float scale = 0.5f / Math.max(Math.abs(dx) / r.width, Math.abs(dy)
//				/ r.height);
//
//		dx *= scale;
//		dy *= scale;
//		centerX += dx;
//		centerY += dy;
//
//		return new Point(Math.round(centerX), Math.round(centerY));
	}

	/**
	 * Returns the bounds of this ChopboxAnchor's owner. Subclasses can override
	 * this method to adjust the box the anchor can be placed on. For instance,
	 * the owner figure may have a drop shadow that should not be included in
	 * the box.
	 * 
	 * @return The bounds of this ChopboxAnchor's owner
	 * @since 2.0
	 */
	protected Rectangle getBox() {
		return getOwner().getBounds();
	}

	/**
	 * Returns the anchor's reference point. In the case of the ChopboxAnchor,
	 * this is the center of the anchor's owner.
	 * 
	 * @return The reference point
	 */
	public Point getReferencePoint() {
		Point ref = getBox().getCenter();
		getOwner().translateToAbsolute(ref);
		return ref;
		
		
//		if (getOwner() == null)
//			return null;
//		else {
//			Point ref = getOwner().getBounds().getCenter();
//			getOwner().translateToAbsolute(ref);
//			return ref;
//		}
		
	}

	/**
	 * Returns <code>true</code> if the other anchor has the same owner and box.
	 * 
	 * @param obj
	 *            the other anchor
	 * @return <code>true</code> if equal
	 */
	public boolean equals(Object obj) {
		if (obj instanceof LineConstraintAnchor) {
			LineConstraintAnchor other = (LineConstraintAnchor) obj;
			return other.getOwner() == getOwner()
					&& other.getBox().equals(getBox());
		}
		return false;
	}

	/**
	 * The owning figure's hashcode is used since equality is approximately
	 * based on the owner.
	 * 
	 * @return the hash code.
	 */
	public int hashCode() {
		if (getOwner() != null)
			return getOwner().hashCode();
		else
			return super.hashCode();
	}
	
	
	
	
	
	
	
	
	/**
	 * Adds the given listener to the listeners to be notified of anchor
	 * location changes.
	 * 
	 * @since 2.0
	 * @param listener
	 *            Listener to be added
	 * @see #removeAnchorListener(AnchorListener)
	 */
	public void addAnchorListener(AnchorListener listener) {
		if (listener == null)
			return;
		if (listeners.size() == 0)
			getOwner().addAncestorListener(this);
		
		listeners.add(listener);
		
	}

	/**
	 * Notifies all the listeners of this anchor's location change.
	 * 
	 * @since 2.0
	 * @param figure
	 *            Anchor-owning Figure which has moved
	 * @see org.eclipse.draw2d.AncestorListener#ancestorMoved(IFigure)
	 */
	public void ancestorMoved(IFigure figure) {
		fireAnchorMoved();
	}

	/**
	 * @see org.eclipse.draw2d.AncestorListener#ancestorAdded(IFigure)
	 */
	public void ancestorAdded(IFigure ancestor) {
	}

	/**
	 * @see org.eclipse.draw2d.AncestorListener#ancestorRemoved(IFigure)
	 */
	public void ancestorRemoved(IFigure ancestor) {
	}

	/**
	 * Returns the owner Figure on which this anchor's location is dependent.
	 * 
	 * @since 2.0
	 * @return Owner of this anchor
	 * @see #setOwner(IFigure)
	 */
	public IFigure getOwner() {
		return owner;
	}

	/**
	 * Removes the given listener from this anchor. If all the listeners are
	 * removed, then this anchor removes itself from its owner.
	 * 
	 * @since 2.0
	 * @param listener
	 *            Listener to be removed from this anchors listeners list
	 * @see #addAnchorListener(AnchorListener)
	 */
	public void removeAnchorListener(AnchorListener listener) {
		listeners.remove(listener);
		if (listeners.size() == 0)
			getOwner().removeAncestorListener(this);
	}

	/**
	 * Sets the owner of this anchor, on whom this anchors location is
	 * dependent.
	 * 
	 * @since 2.0
	 * @param owner
	 *            Owner of this anchor
	 */
	public void setOwner(IFigure owner) {
		this.owner = owner;
	}
	

	/**
	 * Notifies all the listeners in the list of a change in position of this
	 * anchor. This is called from one of the implementing anchors when its
	 * location is changed.
	 * 
	 * @since 2.0
	 */
	private void fireAnchorMoved() {
		Iterator iter = listeners.iterator();
		while (iter.hasNext())
			((AnchorListener) iter.next()).anchorMoved(this);
	}	

}
