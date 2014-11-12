package no.hib.dpf.editor.commands.arrow;

import no.hib.dpf.core.Arrow;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.editor.utilities.DPFMetaLanguageUtils;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;

/**
 * @author Ole Klokkhammer
 */
public abstract class AbstractDArrowCommand extends Command {
	
	/**
	 * @author Ole Klokkhammer
	 * @param sourceDNode
	 * @param connectionDArrow
	 * @param targetDNode
	 * @return
	 */
	protected boolean canConnect(DNode sourceDNode, DArrow connectionDArrow, DNode targetDNode){ 
		DNode sourceDType = null;
		DNode arrowSrcDType = null;
		DNode targetDType = null;
		DNode arrowTargetDType = null;
		
		// the dArrow determines what meta-level we're at.
		DArrow typeDArrow = connectionDArrow.getDType();
		Assert.isNotNull(typeDArrow);
		Arrow typeArrow = typeDArrow.getArrow();
		Assert.isNotNull(typeArrow);
		boolean isExtensionFromTemplateMetalevel = false;
		if(typeArrow.isTemplateElement() || DPFTemplateUtils.getTemplateArrows(sourceDNode).contains(typeArrow.getName())){
			isExtensionFromTemplateMetalevel = true;
		}
		
		if(isExtensionFromTemplateMetalevel){ 
			sourceDType = sourceDNode.getDType().getTemplateDNode();
			arrowSrcDType = connectionDArrow.getDType().getDSource().getTemplateDNode();
			targetDType = targetDNode.getDType().getTemplateDNode();
			arrowTargetDType = connectionDArrow.getDType().getDTarget().getTemplateDNode();
		}else{
			sourceDType = sourceDNode.getDType();
			arrowSrcDType = connectionDArrow.getDType().getDSource();
			targetDType = targetDNode.getDType();
			arrowTargetDType = connectionDArrow.getDType().getDTarget();
		}
		
		if(sourceDType == null || arrowSrcDType == null || arrowTargetDType == null || targetDType == null){
			return false;
		}
		
		boolean canConnect = (arrowSrcDType == sourceDType && arrowTargetDType == targetDType);
		if(canConnect){
			return true;
		}else if(DPFMetaLanguageUtils.hasSuperTypes(sourceDType)){ // check for generalizations:
			return checkSuperTypes(sourceDType, connectionDArrow.getDType(), targetDType);
		}
		return false;
	}

	/**
	 * @author Ole Klokkhammer
	 * @param sourceDType
	 * @param typeDArrow
	 * @param targetDType
	 * @return
	 */
	private boolean checkSuperTypes(DNode sourceDType, DArrow typeDArrow, DNode targetDType){
		if(sourceDType == null || typeDArrow == null || targetDType == null){
			return false;
		}
		
		for(DNode superDNode : DPFMetaLanguageUtils.getSuperTypes(sourceDType)){		
			DNode source = typeDArrow.getDSource();
			DNode target = typeDArrow.getDTarget();
			
			if(source == null || target == null){
				continue; // jump to next iteration
			}
			
			boolean canConnect = (source == superDNode && target == targetDType);
			if(canConnect){
				return true;
			}else if(DPFMetaLanguageUtils.hasSuperTypes(superDNode)){
				return checkSuperTypes(superDNode, typeDArrow, targetDType);
			}
		}
		return false;
	}
}
