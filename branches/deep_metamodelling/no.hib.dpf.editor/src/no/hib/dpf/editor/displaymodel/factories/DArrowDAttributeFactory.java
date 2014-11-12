package no.hib.dpf.editor.displaymodel.factories;
 
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.requests.CreationFactory;

public class DArrowDAttributeFactory implements CreationFactory {

	DArrowDAttribute typeDAttribute;

	public DArrowDAttributeFactory(DArrowDAttribute dattribute) {
		typeDAttribute = dattribute;
	}

	@Override
	public Object getNewObject() {
		DArrowDAttribute newDAttribute = DiagramFactory.eINSTANCE.createDefaultDArrowDAttribute();
		newDAttribute.setDType(typeDAttribute);
		if(typeDAttribute.getConfigureString() != null){
			newDAttribute.setConfigureString(typeDAttribute.getConfigureString());
		}
		
		updateMutability(newDAttribute);
		return newDAttribute;
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param newDArrow
	 */
	private void updateMutability(DArrowDAttribute newDArrowDAttribute) {
		ArrowAttribute typeArrowAttribute = typeDAttribute.getArrowAttribute();
		ArrowAttribute newArrowAttribute = newDArrowDAttribute.getArrowAttribute();
		newArrowAttribute.setMutability(typeArrowAttribute.getMutability());
		
		DGraph dgraph = (DGraph) typeDAttribute.eContainer();
		if (!DPFTemplateUtils.getTemplateArrowAttributes(dgraph).contains(typeArrowAttribute.getName())) {
			if(typeArrowAttribute.getMutability() > 0){
				
				ArrowAttribute typeOfTypeNode = typeArrowAttribute.getTypeAttribute();
				if(typeOfTypeNode != null && typeOfTypeNode.getMutability() > 0){
					String typeOfTypeNodeValue = typeOfTypeNode.getName();
					String typeNodeValue = typeArrowAttribute.getName();
					if(!typeNodeValue.equals(typeOfTypeNodeValue)){
						typeArrowAttribute.setMutability(typeArrowAttribute.getMutability() - 1);
						newArrowAttribute.setMutability(typeArrowAttribute.getMutability());
					}
				}
			}
		}
	}


	@Override
	public Object getObjectType() {
		return DArrowDAttribute.class;
	}

}
