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

import static no.hib.dpf.diagram.util.DPFConstants.DEFAULT_DSIGNATURE;

import java.io.File;
import java.net.MalformedURLException;

import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.commands.DConstraintCreateCommand;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;

public class CreateConstraintToolEntry extends ToolEntry {

	DPredicate predicate = null;
	DSpecification specification = null;
	private GraphHomomorphism morphism = null;
	EList<DArrow> selectionArrows = null;
	EList<DNode> selectionNodes = null;
	public CreateConstraintToolEntry(final DSpecification dSpecification, final DPredicate thepre) {
		super(thepre.getSimpleName(), thepre.getPredicate().getSymbol(), 
				getImageDescriptor(thepre, dSpecification.eResource().getURI()), null);
		this.predicate = thepre;
		specification = dSpecification;
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

	public DPredicate getDPredicate() {
		return predicate;
	}


	public void setGraphHomorphism(GraphHomomorphism graphHomomorphism) {
		morphism = graphHomomorphism;
	}


	public void setNodes(EList<DNode> selectionDNodes) {
		this.selectionNodes = selectionDNodes;
	}


	public void setArrows(EList<DArrow> selectionDArrows) {
		this.selectionArrows = selectionDArrows;
	}


	public Command getCommand() {
		if(morphism != null)
			return new DConstraintCreateCommand(specification, predicate, morphism, selectionNodes, selectionArrows);
		return null;
	}
}
