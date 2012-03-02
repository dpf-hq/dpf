/*******************************************************************************
 * Copyright (c) 2011 H¿yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * ¯yvind Bech and Dag Viggo Lok¿en - DPF Editor
*******************************************************************************/
package no.hib.dpf.editor.figures;



public interface RoutableFigure {

	/**
	 * Returns the priority under which an instance should be routed.
	 * Some elements are dependant upon other types of elements, and
	 * this gives the elements an opportunity to signal their preference
	 * for routing.
	 */
	int getRoutingPriority();
	
	
}
