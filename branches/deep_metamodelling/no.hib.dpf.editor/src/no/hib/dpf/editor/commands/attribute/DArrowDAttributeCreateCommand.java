package no.hib.dpf.editor.commands.attribute;

import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;

public class DArrowDAttributeCreateCommand extends Command {
	/** Start endpoint for the connection. */
	private DArrow source;
	/** Target endpoint for the connection. */
	private DDataNode target;
	
	/** Diagram to add to. */
	private final DArrowDAttribute newDAttribute;

	
	public DArrowDAttributeCreateCommand(DArrow source, DArrowDAttribute newDAttribute) {
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
	 * @param source
	 * @param newDAttribute
	 * @param target
	 * @return
	 */
	protected boolean canConnect(DArrow source, DArrowDAttribute newDAttribute, DDataNode target){ 
		DArrow sourceDType = null;
		DArrow arrowSrcDType = null;
		DDataNode targetDType = null;
		DDataNode arrowTargetDType = null;
		
		// the dArrow determines what meta-level we're at.
		DArrowDAttribute typeDArrowDAttribute = newDAttribute.getDType();
		Assert.isNotNull(typeDArrowDAttribute);
		ArrowAttribute typeArrowAttribute = typeDArrowDAttribute.getArrowAttribute();
		Assert.isNotNull(typeArrowAttribute);
		boolean isExtensionFromTemplateMetalevel = false;
		if(typeArrowAttribute.isTemplateElement() || DPFTemplateUtils.getTemplateArrowAttributes(source).contains(typeArrowAttribute.getName())){
			isExtensionFromTemplateMetalevel = true;
		}
		
		if(isExtensionFromTemplateMetalevel){ 
			sourceDType = source.getDType().getTemplateDArrow();
			arrowSrcDType = newDAttribute.getDType().getDSource().getTemplateDArrow();
			targetDType = target.getDType().getTemplateDDataNode();
			arrowTargetDType = newDAttribute.getDType().getDTarget().getTemplateDDataNode();
		}else{
			sourceDType = source.getDType();
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