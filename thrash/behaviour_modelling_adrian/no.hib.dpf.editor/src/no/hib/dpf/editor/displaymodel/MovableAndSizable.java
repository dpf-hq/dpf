/*******************************************************************************
 * Copyright (c) 2011 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Øyvind Bech and Dag Viggo Lokøen - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.displaymodel;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

public interface MovableAndSizable {

	/**
	 * Return the Location of this screen object.
	 * 
	 * @return a non-null location instance
	 */
	Point getLocation();

	/**
	 * Return the Size of this screen object.
	 * 
	 * @return a non-null Dimension instance
	 */
	Dimension getSize();

	/**
	 * Set the Location of this screen object.
	 * 
	 * @param newLocation
	 *            a non-null Point instance
	 */
	void setLocation(Point newLocation);

	/**
	 * Set the Size of this screen object. Should not modify the size if newSize is null.
	 * 
	 * @param newSize
	 *            a non-null Dimension instance or null
	 */
	void setSize(Dimension newSize);

}