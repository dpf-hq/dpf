package no.hib.dpf.editor.displaymodel.factories;
 
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DGraph;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.diagram.DiagramFactory;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.requests.CreationFactory;

public class DNodeDAttributeFactory implements CreationFactory {

	DNodeDAttribute typeDAttribute;

	public DNodeDAttributeFactory(DNodeDAttribute dattribute) {
		typeDAttribute = dattribute;
	}

	@Override
	public Object getNewObject() {
		DNodeDAttribute newDAttribute = DiagramFactory.eINSTANCE.createDefaultDNodeDAttribute();
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
	private void updateMutability(DNodeDAttribute newDNodeDAttribute) {
		NodeAttribute typeNodeAttribute = typeDAttribute.getNodeAttribute();
		NodeAttribute newNodeAttribute = newDNodeDAttribute.getNodeAttribute();
		newNodeAttribute.setMutability(typeNodeAttribute.getMutability());
		
		DGraph dgraph = (DGraph) typeDAttribute.eContainer();
		if (!DPFTemplateUtils.getTemplateNodeAttributes(dgraph).contains(typeNodeAttribute.getName())) {
			if(typeNodeAttribute.getMutability() > 0){
				
				NodeAttribute typeOfTypeNode = typeNodeAttribute.getTypeAttribute();
				if(typeOfTypeNode != null && typeOfTypeNode.getMutability() > 0){
					String typeOfTypeNodeValue = typeOfTypeNode.getName();
					String typeNodeValue = typeNodeAttribute.getName();
					if(!typeNodeValue.equals(typeOfTypeNodeValue)){
						typeNodeAttribute.setMutability(typeNodeAttribute.getMutability() - 1);
						newNodeAttribute.setMutability(typeNodeAttribute.getMutability());
					}
				}
			}
		}
	}

	@Override
	public Object getObjectType() {
		return DNodeDAttribute.class;
	}

}
