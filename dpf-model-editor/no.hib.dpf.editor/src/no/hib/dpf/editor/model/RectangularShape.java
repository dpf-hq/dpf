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

import java.lang.reflect.InvocationTargetException;

import no.hib.dpf.metamodel.Edge;
import no.hib.dpf.metamodel.Graph;
import no.hib.dpf.metamodel.MetamodelFactory;
import no.hib.dpf.metamodel.Node;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.graphics.Image;


/**
 * A rectangular shape.
 * @author Elias Volanakis
 */
public class RectangularShape extends Shape implements Node {
	
private transient Node nodeComponent;
private String nodeID;

public RectangularShape() {
	super();
	nodeComponent = MetamodelFactory.eINSTANCE.createNode();
	nodeID = nodeComponent.getId();
}

/** A 16x16 pictogram of a rectangular shape. */
private static final Image RECTANGLE_ICON = createImage("icons/rectangle16.gif");

private static final long serialVersionUID = 1;

public Image getIcon() {
	return RECTANGLE_ICON;
}

public String toString() {
	return "Rectangle " + hashCode();
}

public String getNodeID() {
	return nodeID;
}

//-----------------------------------------------------------------------------------
//Node methods:
//-----------------------------------------------------------------------------------

@Override
public EClass eClass() {
	return nodeComponent.eClass();
}

@Override
public Resource eResource() {
	return nodeComponent.eResource();
}

@Override
public EObject eContainer() {
	return nodeComponent.eContainer();
}

@Override
public EStructuralFeature eContainingFeature() {
	return nodeComponent.eContainingFeature();
}

@Override
public EReference eContainmentFeature() {
	return nodeComponent.eContainmentFeature();
}

@Override
public EList<EObject> eContents() {
	return nodeComponent.eContents();
}

@Override
public TreeIterator<EObject> eAllContents() {
	return nodeComponent.eAllContents();
}

@Override
public boolean eIsProxy() {
	return nodeComponent.eIsProxy();
}

@Override
public EList<EObject> eCrossReferences() {
	return nodeComponent.eCrossReferences();
}

@Override
public Object eGet(EStructuralFeature feature) {
	return nodeComponent.eGet(feature);
}

@Override
public Object eGet(EStructuralFeature feature, boolean resolve) {
	return nodeComponent.eGet(feature, resolve);
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	nodeComponent.eSet(feature, newValue);
}

@Override
public boolean eIsSet(EStructuralFeature feature) {
	return nodeComponent.eIsSet(feature);
}

@Override
public void eUnset(EStructuralFeature feature) {
	nodeComponent.eUnset(feature);
}

@Override
public Object eInvoke(EOperation operation, EList<?> arguments)
		throws InvocationTargetException {
	return nodeComponent.eInvoke(operation, arguments);
}

@Override
public EList<Adapter> eAdapters() {
	return nodeComponent.eAdapters();
}

@Override
public boolean eDeliver() {
	return nodeComponent.eDeliver();
}

@Override
public void eSetDeliver(boolean deliver) {
	nodeComponent.eSetDeliver(deliver);
}

@Override
public void eNotify(Notification notification) {
	nodeComponent.eNotify(notification);
}

@Override
public String getName() {
	return nodeComponent.getName();
}

@Override
public void setName(String value) {
	nodeComponent.setName(value);
}

@Override
public Graph getGraph() {
	return nodeComponent.getGraph();
}

@Override
public void setGraph(Graph value) {
	nodeComponent.setGraph(value);
}

@Override
public EList<Edge> getOutgoingEdges() {
	return nodeComponent.getOutgoingEdges();
}

@Override
public String getId() {
	return nodeComponent.getId();
}

@Override
public void setId(String value) {
	// TODO Auto-generated method stub
	
}

}
