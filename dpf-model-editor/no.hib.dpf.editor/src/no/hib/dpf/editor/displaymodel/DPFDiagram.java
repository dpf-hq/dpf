/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
�* All rights reserved. This program and the accompanying materials
�* are made available under the terms of the Eclipse Public License v1.0
�* which accompanies this distribution, and is available at
�* http://www.eclipse.org/legal/epl-v10.html
�*
�* Contributors:
�*����Elias Volanakis - initial API and implementation
�*******************************************************************************/
package no.hib.dpf.editor.displaymodel;

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
	private List<DNode> shapes = new ArrayList<DNode>();

	private boolean snapToGeometry = true;
	private boolean gridEnabled = false;
	private double zoom = 1.0;
	
	/** Used for adding and removing a model element to and from the DPF graph */
	protected transient Graph dpfGraph;
	
	public DPFDiagram() {
		super();
		this.dpfGraph = MetamodelFactory.eINSTANCE.createGraph();
	}
	
	public boolean isGridEnabled() {
		return gridEnabled;
	}

	public boolean isSnapToGeometryEnabled() {
		return snapToGeometry;
	}

	public double getZoom() {
		return zoom;
	}

	public void setGridEnabled(boolean isEnabled) {
		gridEnabled = isEnabled;
	}

	public void setSnapToGeometry(boolean isEnabled) {
		snapToGeometry = isEnabled;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}

	public void validateSemantics() {
		firePropertyChange("VALIDATE_SEMANTICS", null, null);
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
		for (DNode aShape : getChildren()) {
			addIDObjectToMap(retVal, aShape);
			addConnectionsToMap(retVal, aShape);				
		}
		return retVal;
	}

	private void addConnectionsToMap(Map<String, ModelElement> retVal, DNode aShape) {
		for (DArrow aConnection : aShape.getSourceConnections()) {
			addIDObjectToMap(retVal, aConnection);
			addConstraintsToMap(retVal, aConnection);
		}
	}
	
	private void addConstraintsToMap(Map<String, ModelElement> retVal, DArrow aConnection) {
		for (DConstraint aConstraint : aConnection.getSourceConstraints()) {
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
	 * @param vNode
	 *            a non-null shape instance
	 * @return true, if the shape was added, false otherwise
	 */
	public boolean addChild(DNode vNode) {
		if (vNode != null && shapes.add(vNode)) {
			vNode.setGraph(dpfGraph);
			vNode.setNameExec(vNode.generateUniqueName());

			firePropertyChange(CHILD_ADDED_PROP, null, vNode);
			return true;
		}
		return false;
	}

	/**
	 * Return a List of Shapes in this diagram. The returned List should not be
	 * modified.
	 */
	public List<DNode> getChildren() {
		return shapes;
	}

	/**
	 * Remove a shape from this diagram.
	 * 
	 * @param s
	 *            a non-null shape instance;
	 * @return true, if the shape was removed, false otherwise
	 */
	public boolean removeChild(DNode s) {
		if (s != null && shapes.remove(s)) {
			s.removeGraph();

			firePropertyChange(CHILD_REMOVED_PROP, null, s);
			return true;
		}
		return false;
	}
}