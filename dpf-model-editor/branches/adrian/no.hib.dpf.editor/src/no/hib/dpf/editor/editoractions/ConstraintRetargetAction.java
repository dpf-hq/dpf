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
package no.hib.dpf.editor.editoractions;

import no.hib.dpf.editor.displaymodel.DConstraint;
import no.hib.dpf.editor.icons.ImageSettings;

import org.eclipse.ui.actions.LabelRetargetAction;

public class ConstraintRetargetAction extends LabelRetargetAction {
	
	public ConstraintRetargetAction(DConstraint.ConstraintType constraintType) {
		super(null, null);
		switch (constraintType) {
			case INVERSE: 
				setId(CreateInverseConstraintAction.ID);
				setImageDescriptor(ImageSettings.INVERSE.getImageDescriptor());
//			setImageDescriptor(InternalImages.DESC_VERT_ALIGN_BOTTOM);
//			setDisabledImageDescriptor(InternalImages.DESC_VERT_ALIGN_BOTTOM_DIS);
				break;
			case JOINTLY_INJECTIVE:
				setId(CreateJointlyInjectiveConstraintAction.ID);
				setImageDescriptor(ImageSettings.JOINTLY_INJECTIVE.getImageDescriptor());
				break;
			case JOINTLY_SURJECTIVE:
				setId(CreateJointlySurjectiveConstraintAction.ID);
				setImageDescriptor(ImageSettings.JOINTLY_SURJECTIVE.getImageDescriptor());
				break;
			case MULTIPLICITY:
				setId(CreateMultiplicityConstraintAction.ID);
				setImageDescriptor(ImageSettings.MULTIPLICITY.getImageDescriptor());
				break;
			case IMAGE_INCLUSION:
				setId(CreateImageInclusionConstraintAction.ID);
				setImageDescriptor(ImageSettings.IMAGE_INCLUSION.getImageDescriptor());
				break;
			case COMPOSITION:
				setId(CreateCompositionConstraintAction.ID);
				setImageDescriptor(ImageSettings.COMPOSITION.getImageDescriptor());
				break;
			case INJECTIVE:
				setId(CreateInjectiveConstraintAction.ID);
				setImageDescriptor(ImageSettings.INJECTIVE.getImageDescriptor());
				break;
			case SURJECTIVE:
				setId(CreateSurjectiveConstraintAction.ID);
				setImageDescriptor(ImageSettings.SURJECTIVE.getImageDescriptor());
				break;
			case IRREFLEXIVE:
				setId(CreateIrreflexiveConstraintAction.ID);
				setImageDescriptor(ImageSettings.IRREFLEXIVE.getImageDescriptor());
				break;
			case TRANSITIVE_IRREFLEXIVE:
				setId(CreateTransitiveIrreflexiveConstraintAction.ID);
				setImageDescriptor(ImageSettings.TRANSITIVE_IRREFLEXIVE.getImageDescriptor());
				break;
			case XOR:
				setId(CreateXORConstraintAction.ID);
				setImageDescriptor(ImageSettings.XOR.getImageDescriptor());
				break;
			case NAND:
				setId(CreateNANDConstraintAction.ID);
				setImageDescriptor(ImageSettings.NAND.getImageDescriptor());
				break;
		}
		// TODO Auto-generated constructor stub
	}

}
