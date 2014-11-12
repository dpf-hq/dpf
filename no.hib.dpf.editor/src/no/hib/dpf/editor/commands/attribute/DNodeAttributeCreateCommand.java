package no.hib.dpf.editor.commands.attribute;

import no.hib.dpf.core.NodeAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.diagram.DNode;
import no.hib.dpf.diagram.DNodeDAttribute;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;

public class DNodeAttributeCreateCommand extends Command {
	/** Start endpoint for the connection. */
	private DNode source;
	/** Target endpoint for the connection. */
	private DDataNode target;
	
	/** Diagram to add to. */
	private final DNodeDAttribute newDAttribute;

	
	public DNodeAttributeCreateCommand(DNode source, DNodeDAttribute newDAttribute) {
		if (source == null)
			throw new IllegalArgumentException();
		
		setLabel("connection creation");
		Assert.isTrue(newDAttribute != null);
		this.newDAttribute = newDAttribute;
		this.source = source;
	}

	/**
	 * Can execute if all the necessary information has been provided.
	 * 
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if (target == null || source == null){
			return false;		
		}
		
		return canConnect(source, newDAttribute, target);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		newDAttribute.reconnect(source, target);
	}

	public void setTarget(DDataNode target) {
		if (target == null)
			throw new IllegalArgumentException();
		this.target = target;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		newDAttribute.disconnect();
	}
	
	/**
	 * @author Ole Klokkhammer
	 * @param sourceDNode
	 * @param newDAttribute
	 * @param target
	 * @return
	 */
	protected boolean canConnect(DNode sourceDNode, DNodeDAttribute newDAttribute, DDataNode target){ 
		DNode sourceDType = null;
		DNode arrowSrcDType = null;
		DDataNode targetDType = null;
		DDataNode arrowTargetDType = null;
		
		// the dArrow determines what meta-level we're at.
		DNodeDAttribute typeDNodeDAttribute = newDAttribute.getDType();
		Assert.isNotNull(typeDNodeDAttribute);
		NodeAttribute typeNodeAttribute = typeDNodeDAttribute.getNodeAttribute();
		Assert.isNotNull(typeNodeAttribute);
		boolean isExtensionFromTemplateMetalevel = false;
		if(typeNodeAttribute.isTemplateElement() || DPFTemplateUtils.getTemplateNodeAttributes(sourceDNode).contains(typeNodeAttribute.getName())){
			isExtensionFromTemplateMetalevel = true;
		}
		
		if(isExtensionFromTemplateMetalevel){ 
			sourceDType = sourceDNode.getDType().getTemplateDNode();
			arrowSrcDType = newDAttribute.getDType().getDSource().getTemplateDNode();
			targetDType = target.getDType().getTemplateDDataNode();
			arrowTargetDType = newDAttribute.getDType().getDTarget().getTemplateDDataNode();
		}else{
			sourceDType = sourceDNode.getDType();
			arrowSrcDType = newDAttribute.getDType().getDSource();
			targetDType = target.getDType();
			arrowTargetDType = newDAttribute.getDType().getDTarget();
		}
		
		if(sourceDType == null || arrowSrcDType == null || arrowTargetDType == null || targetDType == null){
			return false;
		}
		
		return (arrowSrcDType == sourceDType && arrowTargetDType == targetDType);
	}
}