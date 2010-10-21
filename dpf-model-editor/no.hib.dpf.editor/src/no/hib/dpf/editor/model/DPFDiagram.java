/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Elias Volanakis - initial API and implementation
 *******************************************************************************/
package no.hib.dpf.editor.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;

/**
 * A container for multiple shapes. This is the "root" of the model data
 * structure.
 * 
 * @author Elias Volanakis
 */
public class DPFDiagram extends ModelElement {

	/** Property ID to use when a child is added to this diagram. */
	public static final String CHILD_ADDED_PROP = "ShapesDiagram.ChildAdded";
	/** Property ID to use when a child is removed from this diagram. */
	public static final String CHILD_REMOVED_PROP = "ShapesDiagram.ChildRemoved";
	private static final long serialVersionUID = 1;
	private List<Shape> shapes = new ArrayList<Shape>();

	/** Used for adding and removing a model element to and from the DPF graph */
	protected transient Graph dpfGraph;
	
	public DPFDiagram() {
		super();
		this.dpfGraph = MetamodelFactory.eINSTANCE.createGraph();
	}
	
	public Graph getDpfGraph() {
		return dpfGraph;
	}

	public void setDpfGraph(Graph dpfGraph) {
		this.dpfGraph = dpfGraph;
	}

	/**
	 * Returns a map of this diagram's children, ordered by their IDObject-provided ID.
	 */
	public Map<String, ModelElement> getChildrenWithID() {
		Map<String,ModelElement> retVal = new HashMap<String,ModelElement>();
		for (Shape aShape : getChildren()) {
			addIDObjectToMap(retVal, aShape);
			addConnectionsToMap(retVal, aShape);				
		}
		return retVal;
	}

	private void addConnectionsToMap(Map<String, ModelElement> retVal, Shape aShape) {
		for (Connection aConnection : aShape.getSourceConnections()) {
			addIDObjectToMap(retVal, aConnection);
			addConstraintsToMap(retVal, aConnection);
		}
	}
	
	private void addConstraintsToMap(Map<String, ModelElement> retVal, Connection aConnection) {
		for (ConstraintElement aConstraint : aConnection.getSourceConstraints()) {
			addIDObjectToMap(retVal, aConstraint);
		}
	}

	private void addIDObjectToMap(Map<String, ModelElement> retVal, ModelElement aModelElement) {
		if (aModelElement instanceof IDObjectContainer) {
			retVal.put(((IDObjectContainer)aModelElement).getIDObjectID(), aModelElement);
		}
	}
	
	/**
	 * Add a shape to this diagram.
	 * 
	 * @param s
	 *            a non-null shape instance
	 * @return true, if the shape was added, false otherwise
	 */
	public boolean addChild(Shape s) {
		if (s != null && shapes.add(s)) {
			s.setGraphExec(dpfGraph);

			firePropertyChange(CHILD_ADDED_PROP, null, s);
			return true;
		}
		return false;
	}

	/**
	 * Return a List of Shapes in this diagram. The returned List should not be
	 * modified.
	 */
	public List<Shape> getChildren() {
		return shapes;
	}

	/**
	 * Remove a shape from this diagram.
	 * 
	 * @param s
	 *            a non-null shape instance;
	 * @return true, if the shape was removed, false otherwise
	 */
	public boolean removeChild(Shape s) {
		if (s != null && shapes.remove(s)) {
			s.removeGraphExec();

			firePropertyChange(CHILD_REMOVED_PROP, null, s);
			return true;
		}
		return false;
	}
}