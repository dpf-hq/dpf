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
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.GraphHomomorphism;
import no.hib.dpf.core.Node;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DPredicate;
import no.hib.dpf.diagram.DSpecification;
import no.hib.dpf.editor.DPFPlugin;
import no.hib.dpf.editor.DPFUtils;
import no.hib.dpf.editor.commands.DConstraintCreateCommand;

public class CreateConstraintToolEntry extends ToolEntry {

	DPredicate predicate = null;
	DSpecification specification = null;
	EList<DArrow> selectionDArrows = null;
	EList<DNode> selectionDNodes = null;
	EList<Arrow> selectionArrows = null;
	EList<Node> selectionNodes = null;

	public CreateConstraintToolEntry(final DSpecification dSpecification, final DPredicate thepre) {
		super(thepre.getSimpleName(), thepre.getPredicate().getSymbol(),
				getImageDescriptor(thepre, dSpecification.eResource().getURI()), null);
		this.predicate = thepre;
		specification = dSpecification;
	}

	public static ImageDescriptor getImageDescriptor(DPredicate predicate, URI base) {
		if (predicate.getIcon() != null && !predicate.getIcon().isEmpty()) {
			if (predicate.eContainer() == DEFAULT_DSIGNATURE)
				return ImageDescriptor
						.createFromURL(DPFPlugin.getDefault().getBundle().getResource(predicate.getIcon()));
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

	public void setNodes(EList<DNode> selectionDNodes, EList<Node> seleNodes) {
		this.selectionDNodes = selectionDNodes;
		this.selectionNodes = seleNodes;
	}

	public void setArrows(EList<DArrow> selectionDArrows, EList<Arrow> selArrows) {
		this.selectionDArrows = selectionDArrows;
		selectionArrows = selArrows;
	}

	public Command getCommand() {
		List<GraphHomomorphism> maps = predicate.getPredicate().createGraphHomomorphism(selectionNodes, selectionArrows,
				false);
		int result = 0;
		if (maps.size() > 1) {
			result = new ConstraintSelectDiaglog(null, maps, selectionDNodes, selectionDArrows).open();
			if (result < 0)
				return null;
		}

		return new DConstraintCreateCommand(specification, predicate, maps.get(result), selectionDNodes,
				selectionDArrows);
	}
}
