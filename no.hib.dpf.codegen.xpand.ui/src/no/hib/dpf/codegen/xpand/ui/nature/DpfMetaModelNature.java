/**
 * <copyright>
 * Copyright (c) 2012 Høyskolen i Bergen
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * @author Anders Sandven <anders.sandven@gmail.com>
 * </copyright>
 *
 * $Id$
 */

package no.hib.dpf.codegen.xpand.ui.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class DpfMetaModelNature implements IProjectNature {
	public static String NATURE_ID = "no.hib.dpf.codegen.xpand.ui.nature.dpfmetamodelnature";
	
	private IProject project;
	
	@Override
	public void configure() throws CoreException {
		System.setProperty(NATURE_ID, "true");
	}

	@Override
	public void deconfigure() throws CoreException {
		System.setProperty(NATURE_ID, "false");
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

}
