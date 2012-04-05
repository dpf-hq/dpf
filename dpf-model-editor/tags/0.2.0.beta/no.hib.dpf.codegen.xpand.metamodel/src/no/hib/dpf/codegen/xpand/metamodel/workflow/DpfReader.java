package no.hib.dpf.codegen.xpand.metamodel.workflow;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.core.Specification;
import no.hib.dpf.utils.DPFCoreUtil;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * This class represents the DpfReader component used in MWE workflow files.
 * It provides xml attributes for setting a DPF metamodel as well as model.
 * 
 * In it's current state it only supports one DPF metamodel.
 * 
 * See example project for usage.
 * 
 * @author Anders Sandven <anders.sandven@gmail.com>
 */

public class DpfReader extends WorkflowComponentWithModelSlot {

	private static final String COMPONENT_NAME = "DPF Reader";
	private Specification dpfMetaModel, dpfModel;
	private DpfMetamodel metaModel;
	
	@Override
	public void checkConfiguration(Issues issues) {
		if(dpfMetaModel == null) {
			issues.addError(this, "DPF meta model is null");
		} else if(dpfModel == null) {
			issues.addError(this, "DPF model is null");
		}
		super.checkConfiguration(issues);
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		metaModel.addDpfMetaModel(dpfMetaModel);
		metaModel.setDpfModel(dpfModel);
		ctx.set(getModelSlot(), dpfModel); //For use in the expand statement
	}

	public Specification getDpfMetaModel() {
		return dpfMetaModel;
	}

	public void setDpfMetaModel(String path) {
		this.dpfMetaModel = DPFCoreUtil.loadSpecification(URI.createURI(path));
	}

	public Specification getDpfModel() {
		return dpfModel;
	}

	public void setDpfModel(String path) {
		this.dpfModel = DPFCoreUtil.loadSpecification(URI.createURI(path));
	}
	
	public DpfMetamodel getMetaModel() {
		return metaModel;
	}

	public void setMetaModel(DpfMetamodel metamodel) {
		this.metaModel = metamodel;
	}
	
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
	
}