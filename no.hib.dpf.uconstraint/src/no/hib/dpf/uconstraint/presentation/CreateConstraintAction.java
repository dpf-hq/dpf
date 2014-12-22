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
package no.hib.dpf.uconstraint.presentation;

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.Constraint;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.commands.DConstraintCreateCommand;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.resource.ImageDescriptor;

public class CreateConstraintAction extends SelectionActionForEditParts {

	private DPredicate dPredicate;
	private EList<DArrow> selectionDArrows;
	private EList<DNode> selectionDNodes;
	private EList<Arrow> selectionArrows;
	private EList<Node> selectionNodes;
	private GraphHomomorphism graphHomomorphism = null;
	
	private String getToolTipText(String name){
		return "Creates a new " + name + " Constraint";
	}
	
	public static String getActionID(DPredicate dPredicate) {
		return "no.hib.dpf.uconstraints.actions.Create" + dPredicate.getPredicate().getSymbol() + "Action";
	}
	public static ImageDescriptor getImageDescriptor(DPredicate predicate, URI base){
		if(predicate.getIcon() != null && !predicate.getIcon().isEmpty()){
			if(predicate.eContainer() == DEFAULT_DSIGNATURE)
				return ImageDescriptor.createFromURL(DPFPlugin.getDefault().getBundle().getResource(predicate.getIcon()));
			File file = new File(URI.createFileURI(predicate.getIcon()).resolve(base).toFileString());
			try {
				return ImageDescriptor.createFromURL(file.toURI().toURL());
			} catch (MalformedURLException e) {
				DPFUtils.logError(e);
				return null;
			}
		}
		return null;
	}
	public CreateConstraintAction(ConstraintsEditor part, DPredicate predicate) {
		super(part, getActionID(predicate));
		setText(predicate.getSimpleName());
		setToolTipText(getToolTipText(predicate.getPredicate().getSymbol()));
		setImageDescriptor(getImageDescriptor(predicate, predicate.eResource().getURI()));
		dPredicate = predicate;
	}

	private EList<Node> getNodes(List<DNode> nodes){
		EList<Node> result = new BasicEList<Node>();
		for(DNode node : nodes)
			if(node.getNode() != null)
				result.add(node.getNode());
		return result;
	}
	
	private EList<Arrow> getArrows(List<DArrow> arrows){
		EList<Arrow> result = new BasicEList<Arrow>();
		for(DArrow arrow : arrows)
			if(arrow.getArrow() != null)
				result.add(arrow.getArrow());
		return result;
	}
	
	@Override
	protected boolean calculateEnabled() {
		if(selectionArrows == null) return false;
		for(Arrow arrow : selectionArrows)
			for(Constraint constraint : arrow.getConstraints())
				if(constraint.getPredicate() == dPredicate.getPredicate())
					return false;
		graphHomomorphism = dPredicate.getPredicate().createGraphHomomorphism(selectionNodes, selectionArrows);
		return graphHomomorphism != null;
	}	

	protected void handleSelectionChanged() {
		selectionDArrows = new BasicEList<DArrow>();
		selectionDNodes = new BasicEList<DNode>();
		getSelectElements(selectionDNodes, selectionDArrows);
		selectionArrows = getArrows(selectionDArrows);
		selectionNodes = getNodes(selectionDNodes);
		super.handleSelectionChanged();
	}
	@Override
	public void run() {
		// this method is only called if calculate enabled() returns true
		Command command = getConstraintCreateCommand(selectionDArrows, selectionDNodes);
		if(command != null)
			execute(command);
		setSelection(null);
	}

	protected DSpecification getSpecification(){
		DNode node = selectionDNodes.get(0);
		return (DSpecification) node.eContainer().eContainer();
	}
	protected Command getConstraintCreateCommand(EList<DArrow> arrows, EList<DNode> nodes){
		return new DConstraintCreateCommand(getSpecification(), dPredicate, graphHomomorphism, nodes, arrows);
	}

}
