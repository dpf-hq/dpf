/*******************************************************************************
 * Copyright (c) 2000, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor.parts;


import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Geometry;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Straight;
import org.eclipse.draw2d.geometry.Vector;
import org.eclipse.gef.ConnectionEditPart;

/**
 * This anchor is used when an arrow between two different nodes is to be anchored down.
 * When more than one connection exists between two nodes, the anchors at either end
 * should have knowledge of each other. Then, they should agree on a common anchorage
 * where the arrows are spaced out in the orthogonal dimension to the arrows themselves.
 */
public class AnchorOHoy extends ChopboxAnchor {

	private ConnectionEditPart connectionEditPart;
	private ConnectionAnchor previousAnchor;
	private ConnectionAnchor nextAnchor;


	/**
	 * Constructs a AnchorOHoy with the given <i>owner</i> figure.
	 * 
	 * @param owner The owner figure
	 * @param connectionEditPart The connection edit part owning the figure. Used for determining if a connection is active
	 * @param previousAnchor The previous anchor added to the node at one end of the connection
	 */
	public AnchorOHoy(IFigure owner, ConnectionEditPart connectionEditPart, ConnectionAnchor previousAnchor) {
		super(owner);
		if (previousAnchor != null) {
			((AnchorOHoy)previousAnchor).coupleAnchors(this);
		}
		this.connectionEditPart = connectionEditPart;
	}
	
	protected void coupleAnchors(AnchorOHoy next) {
		next.previousAnchor = this;
		nextAnchor = next;
	}
	
	protected int totalActiveAnchors() {
		int count = 1; // this connection is actie if we are here
		if (nextAnchor != null) {
			count += ((AnchorOHoy)nextAnchor).numNextActiveConnections();			
		}
		if (previousAnchor != null) {
			count += ((AnchorOHoy)previousAnchor).numPreviousActiveConnections();
		}
		
		return count;
	}
	
	protected int activeConnection() {
		if ((connectionEditPart != null) && (this.connectionEditPart.isActive())) {
			return 1;
		}
		return 0;
	}
	
	protected int numNextActiveConnections() {
		if (nextAnchor == null) {
			return activeConnection();
		}
		
		return activeConnection() + ((AnchorOHoy)nextAnchor).numNextActiveConnections();
	}

	protected int numPreviousActiveConnections() {
		if (previousAnchor == null) {
			return activeConnection();
		}
		
		return activeConnection() + ((AnchorOHoy)previousAnchor).numPreviousActiveConnections();
	}

	private int getOrthogonalOffset(int availableOrthogonalSpace) {
		int totalArrows = totalActiveAnchors();
		int previousArrowsIncThis = numPreviousActiveConnections();
			
		if (totalArrows == 1) {
			return 0;
		}
		// Odd number of arrows
		boolean oddNumber = (totalArrows % 2) != 0;
		
		
		double singleSpaceWidth = availableOrthogonalSpace/totalArrows;
		
		double initialOffset = 0;
		if (!oddNumber) {
			initialOffset = singleSpaceWidth/2;
		}
		
		boolean thisArrowIsOddNumber = (previousArrowsIncThis % 2) != 0; 
		
		
		if (thisArrowIsOddNumber) {
			return (int) (- initialOffset - (singleSpaceWidth * ((previousArrowsIncThis - 1)/2)));
		} else {
			return (int) (-initialOffset + (singleSpaceWidth * (previousArrowsIncThis/2)));			
		}
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
		//System.out.println("getLocation called with reference " + reference + ", my ID is " + this);
		
		// The "space" available for arrows on the rectangle in an orthogonal direction to the arrows (todo: calculate from actual)
		int availableOrthogonalSpace = 40;
				
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getBox());
		r.translate(-1, -1);
		r.resize(1, 1);

		getOwner().translateToAbsolute(r);
		float centerX = r.x + 0.5f * r.width;
		float centerY = r.y + 0.5f * r.height;

		
		// Translate reference?
		float dx = reference.x - centerX;
		float dy = reference.y - centerY;
		
		
			boolean leftmostOrHighest = false;
			if (reference.x < (int)centerX) {
				leftmostOrHighest = true;
			} else if (reference.x == (int)centerX) {
				leftmostOrHighest = reference.y < (int)centerY;
			}
			
			Point finalVector = getOrthogonalVector(dx, dy, getOrthogonalOffset(availableOrthogonalSpace), leftmostOrHighest);

			//System.out.println("ref: " + reference);
			Point movedReference =  new Point(reference.x + finalVector.x, reference.y + finalVector.y);
			//System.out.println("mref: " + movedReference);
			centerX = centerX + finalVector.x;
			centerY = centerY + finalVector.y;			
									
			Straight lineStraight = new Straight(new PrecisionPoint(centerX, centerY), new PrecisionPoint(movedReference.x, movedReference.y));
			
			Vector[] candidates = getIntersectionCandidates(centerX, centerY, movedReference, r, lineStraight);
			PrecisionPoint newCenter = new PrecisionPoint(centerX, centerY);
			PrecisionPoint bestCandidate = getBestIntersectionCandidate(candidates, newCenter);
			if (bestCandidate != null) {
				return new Point(bestCandidate.x, bestCandidate.y);
			}
			

		
		return super.getLocation(reference);
	}

	private Vector[] getIntersectionCandidates(float centerX, float centerY,
			Point movedReference, Rectangle r, Straight lineStraight) {
		
		PrecisionPoint p1 = new PrecisionPoint(r.x, r.y);
		PrecisionPoint p2 = new PrecisionPoint(r.x + r.width, r.y);
		PrecisionPoint p3 = new PrecisionPoint(r.x, r.y + r.height);
		PrecisionPoint p4 = new PrecisionPoint(r.x + r.width, r.y + r.height);
		
		Vector [] candidates = new Vector[4];
		
		candidates[0] = getIntersection(lineStraight, new PrecisionPoint(centerX, centerY), movedReference, p1, p2);
		candidates[1] = getIntersection(lineStraight, new PrecisionPoint(centerX, centerY), movedReference, p1, p3);
		candidates[2] = getIntersection(lineStraight, new PrecisionPoint(centerX, centerY), movedReference, p2, p4);
		candidates[3] = getIntersection(lineStraight, new PrecisionPoint(centerX, centerY), movedReference, p3, p4);
		return candidates;
	}

	/**
	 * Returns the best intersection candidate (if any)
	 */
	private PrecisionPoint getBestIntersectionCandidate(Vector[] candidates, PrecisionPoint newCenter) {
		PrecisionPoint bestCandidate = null;
		for (int i = 0; i < 4; i++) {
			if (candidates[i] != null) {
				if (bestCandidate == null) {
					bestCandidate = candidates[i].toPoint();
				} else {
					if ((bestCandidate.getDistance(newCenter)) > candidates[i].toPoint().getDistance(newCenter)) {
						bestCandidate = candidates[i].toPoint();							
					}
				}
			}
		}
		return bestCandidate;
	}
	
	private Vector getIntersection(Straight lineStraight, Point center, Point reference, PrecisionPoint p1, PrecisionPoint p2) {
		if (Geometry.linesIntersect(center.x, center.y, reference.x, reference.y, p1.x, p1.y, p2.x, p2.y)) {
			return lineStraight.getIntersection(new Straight(p1, p2));
		}
		return null;
	}

	private Point getOrthogonalVector(float dx, float dy, int offset, boolean leftmostOrHighest) {
		// Move points orthogonally to line:
		Point orthoVector = new Point(-dy, dx);
		double length = new Point(0, 0).getDistance(orthoVector);

		double normOrthoVectorX = orthoVector.x / length;
		double normOrthoVectorY = orthoVector.y / length;
		Point finalVector = new Point(normOrthoVectorX * offset, normOrthoVectorY  * offset);
		if (leftmostOrHighest) {
			finalVector = new Point(normOrthoVectorX * -offset, normOrthoVectorY  * -offset);
		}
		return finalVector;
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
	}

	/**
	 * Returns <code>true</code> if the other anchor has the same owner and box.
	 * 
	 * @param obj
	 *            the other anchor
	 * @return <code>true</code> if equal
	 */
	public boolean equals(Object obj) {
		if (obj instanceof AnchorOHoy) {
			AnchorOHoy other = (AnchorOHoy) obj;
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

	@Override
	public String toString() {
		return super.toString() + ", leftAnchor: " + previousAnchor;
	}

	
	
}
