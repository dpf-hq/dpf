package no.hib.dpf.codegen.xpand.metamodel.workflow;

import java.io.IOException;

import no.hib.dpf.codegen.xpand.metamodel.DpfMetamodel;
import no.hib.dpf.core.CoreFactory;
import no.hib.dpf.core.CorePackage;
import no.hib.dpf.core.Specification;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

public class DpfReader extends WorkflowComponentWithModelSlot {

	private static final String COMPONENT_NAME = "DPF Reader";
	private Specification dsm, instanceModel;
	private DpfMetamodel metaModel;

	static {
		EPackage.Registry.INSTANCE.put(CorePackage.eNS_URI, CorePackage.eINSTANCE);
	}
	
	@Override
	public void checkConfiguration(Issues issues) {
		System.out.println("checkconfig called");
		if(dsm == null) {
			issues.addError(this, "DSM is null");
		} else if(instanceModel == null) {
			issues.addError(this, "Instance model is null");
		}
		super.checkConfiguration(issues);
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		metaModel.setDsm(dsm);
		ctx.set(getModelSlot(), instanceModel); //For use in the expand statement
	}

	public Specification getDsm() {
		return dsm;
	}

	public void setDsm(String path) {
		try {
			this.dsm = CoreFactory.eINSTANCE.loadSpecification(URI.createURI(path));
		} catch (IOException e) {
			//do nothing, checkConfiguration should pick this up
			e.printStackTrace();
		}
	}

	public Specification getInstanceModel() {
		return instanceModel;
	}

	public void setInstanceModel(String path) {
		try {
			this.instanceModel = CoreFactory.eINSTANCE.loadSpecification(URI.createURI(path));
		} catch (IOException e) {
			//do nothing, checkConfiguration should pick this up
			e.printStackTrace();
		}
	}
	
	public DpfMetamodel getMetaModel() {
		System.out.println("###############getMetamodel");
		return metaModel;
	}

	public void setMetaModel(DpfMetamodel metamodel) {
		System.out.println("#################setMetamodel");
		this.metaModel = metamodel;
	}
	
	@Override
	public String getComponentName() {
		return COMPONENT_NAME;
	}
	
}
