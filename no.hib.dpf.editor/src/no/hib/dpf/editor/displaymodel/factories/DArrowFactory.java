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
package no.hib.dpf.editor.displaymodel.factories;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.utilities.DPFMetaLanguageUtils;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.requests.CreationFactory;

public class DArrowFactory implements CreationFactory {

	DArrow typeDArrow;

	public DArrowFactory(DArrow darrow) {
		typeDArrow = darrow;
	}

	@Override
	public Object getNewObject() {
		DArrow newDArrow = DiagramFactory.eINSTANCE.createDefaultDArrow();
		newDArrow.setDType(typeDArrow);
		if(typeDArrow.getConfigureString() != null){
			newDArrow.setConfigureString(typeDArrow.getConfigureString());
		}
		updatePotency(newDArrow);
		updateMutability(newDArrow);
		return newDArrow;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param newDArrow
	 */
	private void updateMutability(DArrow newDArrow) {
		Arrow typeArrow = typeDArrow.getArrow();
		Arrow newArrow = newDArrow.getArrow();
		newArrow.setMutability(typeArrow.getMutability());
		
		DGraph dgraph = (DGraph) typeDArrow.eContainer();
		if (!DPFTemplateUtils.getTemplateArrows(dgraph).contains(typeArrow.getName())) {
			if(typeArrow.getMutability() > 0){
				
				Arrow typeOfTypeNode = typeArrow.getTypeArrow();
				if(typeOfTypeNode != null && typeOfTypeNode.getMutability() > 0){
					String typeOfTypeNodeValue = typeOfTypeNode.getName();
					String typeNodeValue = typeArrow.getName();
					if(!typeNodeValue.equals(typeOfTypeNodeValue)){
						typeArrow.setMutability(typeArrow.getMutability() - 1);
						newArrow.setMutability(typeArrow.getMutability());
					}
				}
			}
		}
	}

	/**
	 * @author Ole Klokkhammer
	 * @param newDArrow
	 */
	private void updatePotency(DArrow newDArrow) {
		Arrow newArrow = newDArrow.getArrow();
		Assert.isNotNull(newArrow);
		Arrow typeArrow = typeDArrow.getArrow();
		Assert.isNotNull(typeArrow);
		
		// if the potency is set on the type-arrow, we will decrease its current potency by 1
		if(typeArrow.eIsSet(CorePackage.Literals.DEEP_ELEMENT__POTENCY)){			
			int typePotency = typeArrow.getPotency();
			newArrow.setPotency(typePotency - 1);
			newDArrow.setArrow(newArrow);
		}else {
			
			// check on the arrow's type, since the arrow is probably not added to its container (graph) yet:
			Arrow templateArrow = (Arrow) typeArrow.getTemplateElement();
			Arrow metaLanguageArrow = null;
			if(templateArrow != null && templateArrow.getTypeArrow() != null){
				metaLanguageArrow = templateArrow.getTypeArrow();
				if(metaLanguageArrow.getName().equals(DPFMetaLanguageUtils.INHERITANCE)){
					// set the potency to zero to prevent reinstantiation
					// possible better to define in the ecore model?? TODO
					newArrow.setPotency(0);
					newDArrow.setArrow(newArrow);
				}
			}
		}
	}

	@Override
	public Object getObjectType() {
		return DArrow.class;
	}

}
