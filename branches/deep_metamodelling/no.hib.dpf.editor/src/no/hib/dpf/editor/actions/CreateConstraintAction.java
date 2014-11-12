/*******************************************************************************
 * Copyright (c) 2011 H�yskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * �yvind Bech and Dag Viggo Lok�en - DPF Editor
 *******************************************************************************/
package no.hib.dpf.editor.actions;

import static no.hib.dpf.diagram.util.DPFDiagramConstants.DEFAULT_DSIGNATURE;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFEditor;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.commands.constraint.DConstraintCreateCommand;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

public class CreateConstraintAction extends SelectionActionForEditParts {

	private DPredicate dPredicate;
	private EList<DArrow> selectionDArrows;
	private EList<DArrowDAttribute> selectionDArrowDAttributes;
	private EList<DNodeDAttribute> selectionDNodeDAttributes;
	
	private EList<DNode> selectionDNodes;
	private EList<DDataNode> selectionDDataNodes;
	
	private EList<Arrow> selectionArrows;
	private EList<ArrowAttribute> selectionArrowAttributes;
	private EList<NodeAttribute> selectionNodeAttributes;
	
	private EList<Node> selectionNodes;
	private EList<DataNode> selectionDataNodes;
	
	private DPFEditor editor = null;
	private GraphHomomorphism graphHomomorphism = null;
	private DSpecification dSpecification;
	
	private String getToolTipText(String name){
		return "Creates a new " + name + " Constraint";
	}
	
	public static String getActionID(DPredicate dPredicate) {
		return "no.hib.dpf.editor.editor.actions.Create" + dPredicate.getPredicate().getSymbol() + "Action";
	}
	public static ImageDescriptor getImageDescriptor(DPredicate predicate, URI base){
		if(predicate.getIcon() != null && !predicate.getIcon().isEmpty()){
			if(predicate.eContainer() == DEFAULT_DSIGNATURE)
				return ImageDescriptor.createFromURL(DPFPlugin.getDefault().getBundle().getResource(predicate.getIcon()));
			File file = new File(URI.createFileURI(predicate.getIcon()).resolve(base).toFileString());
			try {
				return ImageDescriptor.createFromURL(file.toURI().toURL());
			} catch (MalformedURLException e) {
				DPFCoreUtil.logError(e);
				return null;
			}
		}
		return null;
	}
	public CreateConstraintAction(DPFEditor part, DSpecification dSpecification, DPredicate predicate) {
		super(part, getActionID(predicate), dSpecification.getDGraph());
		this.dSpecification = dSpecification;
		setText(predicate.getSimpleName());
		setToolTipText(getToolTipText(predicate.getPredicate().getSymbol()));
		setImageDescriptor(getImageDescriptor(predicate, dSpecification.eResource().getURI()));
		dPredicate = predicate;
		editor = (DPFEditor) getWorkbenchPart();
	}

	private EList<Node> getNodes(List<DNode> nodes){
		EList<Node> result = new BasicEList<Node>();
		for(DNode node : nodes)
			if(node.getNode() != null)
				result.add(node.getNode());
		return result;
	}
	
	private EList<DataNode> getDataNodes(List<DDataNode> datanodes){
		EList<DataNode> result = new BasicEList<DataNode>();
		if(datanodes != null){
			for(DDataNode datanode : datanodes)
				if(datanode.getDatanode() != null)
					result.add(datanode.getDatanode());
		}
		return result;
	}
	
	private EList<Arrow> getArrows(List<DArrow> arrows){
		EList<Arrow> result = new BasicEList<Arrow>();
		for(DArrow arrow : arrows)
			if(arrow.getArrow() != null)
				result.add(arrow.getArrow());
		return result;
	}
	
	private EList<ArrowAttribute> getArrowAttributes(List<DArrowDAttribute> attributes){
		EList<ArrowAttribute> result = new BasicEList<ArrowAttribute>();
		if(attributes != null){
			for(DArrowDAttribute attribute : attributes)
				if(attribute.getArrowAttribute() != null)
					result.add(attribute.getArrowAttribute());
		}
		return result;
	}
	
	private EList<NodeAttribute> getNodeAttributes(List<DNodeDAttribute> attributes){
		EList<NodeAttribute> result = new BasicEList<NodeAttribute>();
		if(attributes != null){
			for(DNodeDAttribute attribute : attributes)
				if(attribute.getNodeAttribute() != null)
					result.add(attribute.getNodeAttribute());
		}
		return result;
	}
	
	private IWorkbenchPart getActivePart(){
		if(editor == null) return null;
		if(editor.getSite() == null) return null;
		if(editor.getSite().getWorkbenchWindow() == null) return null;
		if(editor.getSite().getWorkbenchWindow().getActivePage() == null) return null;
		return editor.getSite().getWorkbenchWindow().getActivePage().getActivePart();
	}
	
	@Override
	protected boolean calculateEnabled() {
		if(getWorkbenchPart() == null || getActivePart() != editor || selectionArrows == null) return false;
		for(Arrow arrow : selectionArrows)
			for(Constraint constraint : arrow.getConstraints())
				if(constraint.getPredicate() == dPredicate.getPredicate())
					return false;
		graphHomomorphism = dPredicate.getPredicate().createGraphHomomorphism(selectionNodes, selectionArrows);
		return graphHomomorphism != null;
	}	

	@Override
	protected void handleSelectionChanged() {
		selectionDArrows = new BasicEList<DArrow>();
		selectionDNodes = new BasicEList<DNode>();
		getSelectElements(selectionDNodes, selectionDArrows,selectionDDataNodes, selectionDNodeDAttributes, selectionDArrowDAttributes);
		selectionArrows = getArrows(selectionDArrows); 
		selectionArrowAttributes = getArrowAttributes(selectionDArrowDAttributes);
		selectionNodeAttributes = getNodeAttributes(selectionDNodeDAttributes);
		
		selectionNodes = getNodes(selectionDNodes);
		selectionDataNodes = getDataNodes(selectionDDataNodes);
		
		super.handleSelectionChanged();
	}
	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true
		Command command = getConstraintCreateCommand(selectionDArrows, selectionDNodes);
		if(command != null)
			execute(command);
		editor.getGraphicalViewer().deselectAll();
	}

	protected Command getConstraintCreateCommand(EList<DArrow> arrows, EList<DNode> nodes){
		return new DConstraintCreateCommand(dSpecification, dPredicate, graphHomomorphism, nodes, arrows);
	}

}
