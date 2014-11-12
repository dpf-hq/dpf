package no.hib.dpf.editor.commands.attribute;

import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DArrowDAttribute;
import no.hib.dpf.diagram.DDataNode;
import no.hib.dpf.editor.utilities.DPFTemplateUtils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;


public class DArrowDAttributeReconnectCommand extends Command {

	/** The connection instance to reconnect. */
	private DArrowDAttribute connection;
	/** The new source endpoint. */
	private DArrow newSource;
	/** The new target endpoint. */
	private DDataNode newTarget;
	/** The original source endpoint. */
	private final DArrow oldSource;
	/** The original target endpoint. */
	private final DDataNode oldTarget;

	/**
	 * Instantiate a command that can reconnect a Connection instance to a different source
	 * or target endpoint.
	 * @param conn the connection instance to reconnect (non-null)
	 * @throws IllegalArgumentException if conn is null
	 */
	public DArrowDAttributeReconnectCommand(DArrowDAttribute conn) {
		if (conn == null) {
			throw new IllegalArgumentException();
		}
		this.connection = conn;
		this.oldSource = conn.getDSource();
		this.oldTarget = conn.getDTarget();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {
		if (newSource != null) {
			return canConnect(newSource, connection, oldTarget);
		} else if (newTarget != null) {
			return canConnect(oldSource, connection, newTarget);
		}
		return false;
	}

	/**
	 * Reconnect the connection to newSource (if setNewSource(...) was invoked before)
	 * or newTarget (if setNewTarget(...) was invoked before).
	 */
	@Override
	public void execute() {
		if (newSource != null) {
			connection.reconnect(newSource, oldTarget);
		} else if (newTarget != null) {
			connection.reconnect(oldSource, newTarget);
		} else {
			throw new IllegalStateException("Should not happen");
		}
	}

	/**
	 * Set a new source endpoint for this connection.
	 * When execute() is invoked, the source endpoint of the connection will be attached
	 * to the supplied Shape instance.
	 * <p>
	 * Note: Calling this method, deactivates reconnection of the <i>target</i> endpoint.
	 * A single instance of this command can only reconnect either the source or the target 
	 * endpoint.
	 * </p>
	 * @param connectionSource a non-null Shape instance, to be used as a new source endpoint
	 * @throws IllegalArgumentException if connectionSource is null
	 */
	public void setNewSource(DArrow connectionSource) {
		if (connectionSource == null) {
			throw new IllegalArgumentException();
		}
		setLabel("move connection startpoint");
		newSource = connectionSource;
		newTarget = null;
	}

	/**
	 * Set a new target endpoint for this connection
	 * When execute() is invoked, the target endpoint of the connection will be attached
	 * to the supplied Shape instance.
	 * <p>
	 * Note: Calling this method, deactivates reconnection of the <i>source</i> endpoint.
	 * A single instance of this command can only reconnect either the source or the target 
	 * endpoint.
	 * </p>
	 * @param connectionTarget a non-null Shape instance, to be used as a new target endpoint
	 * @throws IllegalArgumentException if connectionTarget is null
	 */
	public void setNewTarget(DDataNode connectionTarget) {
		if (connectionTarget == null) {
			throw new IllegalArgumentException();
		}
		setLabel("move connection endpoint");
		newSource = null;
		newTarget = connectionTarget;
	}

	/**
	 * Reconnect the connection to its original source and target endpoints.
	 */
	@Override
	public void undo() {
		connection.reconnect(oldSource, oldTarget);
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
